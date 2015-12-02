/**
 * Licensed under the karma of sharing. As i have shared freely to you, so shall you share freely back.
 * If you shall try to cheat and find a loophole in this license, then karma will exact your share.
 * and your worldly gain shall come to naught and those who share shall inherit above you.
 */

package org.output.maker;

import java.util.List;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.base.event.LoginEventData;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MProduct;
import org.compiere.model.MProductBOM;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.osgi.service.event.Event;
import org.red1.model.MOrderOutput;

/**
 * Alternative Output V1.0 for IDempiere 3.1 backward compatible to v2.0
 * OrderLines must belong to a single BOM defined in MProductBOM 
 *  - there can be less products in orderlines than the BOM  group of children
 *  - if there is another extra non BOM orderline, then it won't take effect
 *  - if there is no at least *HEADER* remark in Document Note of the parent BOM, then it won't take effect
 *  @author red1
 */
public class OutputDocEvent extends AbstractEventHandler{
	private static CLogger log = CLogger.getCLogger(OutputDocEvent.class);
	private String trxName = "";
	private PO po = null; 
	//these settings appear in Document Note of Parent.
	private boolean HEADER = false; //consolidated to parent name, no details unless ..
	private boolean DESCRIPTION = false; //add description
	private boolean COMMENT = false;//add comment
	private boolean DETAIL_NO_PRICE = false;//add details no prices ELSE detail original price
	private boolean DETAIL_OWN_PRICE = false;//details with prices replaced by BOM children's description or orderline description marked with *PRICE*
	private boolean OUTPUT_SETTING;
	private boolean CONSOLIDATED_STATEMENT;
	
	private StringBuilder HeaderString = new StringBuilder();
	private MProduct parent = null;
	
	@Override
	protected void initialize() { 
	//register EventTopics and TableNames
		registerTableEvent(IEventTopics.DOC_AFTER_PREPARE, MOrder.Table_Name);
		log.info("<ORDER OUTPUT> .. IS NOW INITIALIZED");
		}

	@Override
	protected void doHandleEvent(Event event) {
		String type = event.getTopic();
		//testing that it works at login
		if (type.equals(IEventTopics.AFTER_LOGIN)) {
			LoginEventData eventData = getEventData(event);
			log.fine(" topic="+event.getTopic()+" AD_Client_ID="+eventData.getAD_Client_ID()
					+" AD_Org_ID="+eventData.getAD_Org_ID()+" AD_Role_ID="+eventData.getAD_Role_ID()
					+" AD_User_ID="+eventData.getAD_User_ID());
			}
		else if (type.equals(IEventTopics.DOC_AFTER_PREPARE))
		{
			setPo(getPO(event));
			setTrxName(po.get_TrxName());
			log.info(" topic="+event.getTopic()+" po="+po);
			if (po instanceof MOrder) {
				//buffer to store text from orderlines
				StringBuilder outputtext = new StringBuilder();
				MOrder order = (MOrder) po;
				MOrderOutput output = new MOrderOutput(Env.getCtx(),0,trxName);
				output.setC_Order_ID(order.get_ID());
				
				List<MOrderLine> orderlines = new Query(Env.getCtx(),MOrderLine.Table_Name,MOrder.COLUMNNAME_C_Order_ID+"=?", trxName)
				.setParameters(order.getC_Order_ID())
				.list();
				for (MOrderLine orderline:orderlines){
					//check product as BOM child, indicating part of BOM Parent existence
					MProductBOM bom = new Query(Env.getCtx(),MProductBOM.Table_Name,MProductBOM.COLUMNNAME_M_ProductBOM_ID+"=?",trxName)
					.setParameters(orderline.getM_Product_ID())
					.first();
					if (bom==null) 
						break;//leave
					
					//this orderline's product is part of a BOM, so proceed to set one time output setting
					//preferences comes from the BOM parent (DOCUMENTNOTE) - HEADER, DESCRIPTION, COMMENT, DETAIL, DETAIL_OWN_PRICE
					if (!findSetting(bom))
						break;
					
					outputtext.append("\n"+orderline.getM_Product().getName());
					if (!DETAIL_NO_PRICE){
						if (DETAIL_OWN_PRICE)
							outputtext.append(" "+Msg.translate(Env.getCtx(), "Qty")+": " + orderline.getQtyOrdered()+" Price:"+orderline.getPriceList().toString());
						else
							outputtext.append(" "+Msg.translate(Env.getCtx(), "Qty")+": " + orderline.getQtyOrdered()+" Price:"+bom.getDescription());
					} else {
						outputtext.append(" "+Msg.translate(Env.getCtx(), "Qty")+": " + orderline.getQtyOrdered().toPlainString());
					}
		
					
					//consolidate TODO
					//refer rules
				}
				if (OUTPUT_SETTING){
					if (DESCRIPTION && parent!=null)
						HeaderString.append(parent.getDescription());
					if (COMMENT && parent!=null)
						HeaderString.append(parent.getHelp());
					if (HEADER){
						HeaderString.append(Msg.translate(Env.getCtx(), "GrandTotal")+": "+order.getGrandTotal().toPlainString());
					}
					output.setName(HeaderString.toString());	
					output.setDescription(outputtext.toString());
					output.saveEx(trxName);
				}
			}
		}
	}
	/**
	 * Done one time with OUTPUT_SETTING
	 * @param bom
	 * @return
	 */
	private boolean findSetting(MProductBOM bom) { 
		if (OUTPUT_SETTING) //already set
			return true;
		parent = new Query(Env.getCtx(),MProduct.Table_Name,MProduct.COLUMNNAME_M_Product_ID+"=?",trxName)
		.setParameters(bom.getM_Product_ID())
		.firstOnly();
		
		if (parent==null) 
			return false;
		String docNote = parent.getDocumentNote();
		if (docNote==null)
			return false;
		String[] array = docNote.split("#");
		if (array.length>0){
			for (String s:array){
				if (s.equals("HEADER")){
					HEADER = true;
					HeaderString.append(parent.getName());
				}
					
				else if (s.equals("DESCRIPTION"))
					DESCRIPTION = true;
				else if (s.equals("COMMENT"))
					COMMENT = true; 
				else if (s.equals("DETAIL_NO_PRICE"))
					DETAIL_NO_PRICE = true;
				else if (s.equals("DETAIL_OWN_PRICE"))
					DETAIL_OWN_PRICE = true;
				}
			OUTPUT_SETTING = true;
			if (!HEADER){ //settings left out HEADER, so all is void.
				log.warning("*HEADER* in OUTPUT DOC EVENT MISSING - ABORTED");
				return false;
			}
			return true;
		} else {
			log.fine("OUTPUT EVENT has no Doucment Note setting in BOM Header (parent)");
			return false;
		}
	}

	private void setPo(PO eventPO) {
		 po = eventPO;
	}

	private void setTrxName(String get_TrxName) {
		trxName = get_TrxName;		
	}
}
