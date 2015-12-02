package org.red1.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MOMInput extends X_OM_Input{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MOMInput(Properties ctx, int OM_Input_ID, String trxName) {
		super(ctx, OM_Input_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MOMInput(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}


}
