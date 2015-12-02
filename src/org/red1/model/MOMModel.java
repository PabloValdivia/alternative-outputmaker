package org.red1.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MOMModel extends X_OM_Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MOMModel(Properties ctx, int OM_Model_ID, String trxName) {
		super(ctx, OM_Model_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MOMModel(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

}
