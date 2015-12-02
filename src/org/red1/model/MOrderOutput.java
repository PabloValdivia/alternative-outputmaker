package org.red1.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MOrder;
import org.compiere.util.Env;
import org.output.model.X_C_OrderOutput;

public class MOrderOutput extends X_C_OrderOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MOrderOutput(Properties ctx, int C_OrderOutput_ID, String trxName) {
		super(ctx, C_OrderOutput_ID, trxName); 
	}
	public MOrderOutput(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	public MOrderOutput(MOrder order) { 
		this(Env.getCtx(), 0, order.get_TrxName());
		setC_Order_ID(order.getC_Order_ID()); 
	}

}
