package org.red1.model;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env; 

public class OutputModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		if (MOrderOutput.Table_Name.equals(tableName))
			return MOrderOutput.class;
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if (MOrderOutput.Table_Name.equals(tableName))
			return new MOrderOutput(Env.getCtx(), Record_ID, trxName); 
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (MOrderOutput.Table_Name.equals(tableName))
			return new MOrderOutput(Env.getCtx(), rs, trxName); 
		return null;
	}
}
