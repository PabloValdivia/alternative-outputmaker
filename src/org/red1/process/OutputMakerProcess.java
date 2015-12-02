package org.red1.process;

import java.math.BigDecimal;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

public class OutputMakerProcess extends SvrProcess{

	private int m_OMModel_ID;

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (name.equals("OM_Model_ID"))
				m_OMModel_ID = ((BigDecimal)para[i].getParameter()).intValue();
		}	
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
