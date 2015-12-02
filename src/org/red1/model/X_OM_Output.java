/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.red1.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for OM_Output
 *  @author iDempiere (generated) 
 *  @version Release 2.1 - $Id$ */
public class X_OM_Output extends PO implements I_OM_Output, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150202L;

    /** Standard Constructor */
    public X_OM_Output (Properties ctx, int OM_Output_ID, String trxName)
    {
      super (ctx, OM_Output_ID, trxName);
      /** if (OM_Output_ID == 0)
        {
			setOM_Output_ID (0);
        } */
    }

    /** Load Constructor */
    public X_OM_Output (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 7 - System - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_OM_Output[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Column getAD_Column() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Column)MTable.get(getCtx(), org.compiere.model.I_AD_Column.Table_Name)
			.getPO(getAD_Column_ID(), get_TrxName());	}

	/** Set Column.
		@param AD_Column_ID 
		Column in the table
	  */
	public void setAD_Column_ID (int AD_Column_ID)
	{
		if (AD_Column_ID < 1) 
			set_Value (COLUMNNAME_AD_Column_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Column_ID, Integer.valueOf(AD_Column_ID));
	}

	/** Get Column.
		@return Column in the table
	  */
	public int getAD_Column_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Column_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_OM_Model getOM_Model() throws RuntimeException
    {
		return (I_OM_Model)MTable.get(getCtx(), I_OM_Model.Table_Name)
			.getPO(getOM_Model_ID(), get_TrxName());	}

	/** Set OutputMakerModel.
		@param OM_Model_ID OutputMakerModel	  */
	public void setOM_Model_ID (int OM_Model_ID)
	{
		if (OM_Model_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_OM_Model_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_OM_Model_ID, Integer.valueOf(OM_Model_ID));
	}

	/** Get OutputMakerModel.
		@return OutputMakerModel	  */
	public int getOM_Model_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_OM_Model_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set OutputMakerOutput.
		@param OM_Output_ID OutputMakerOutput	  */
	public void setOM_Output_ID (int OM_Output_ID)
	{
		if (OM_Output_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_OM_Output_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_OM_Output_ID, Integer.valueOf(OM_Output_ID));
	}

	/** Get OutputMakerOutput.
		@return OutputMakerOutput	  */
	public int getOM_Output_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_OM_Output_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set OM_Output_UU.
		@param OM_Output_UU OM_Output_UU	  */
	public void setOM_Output_UU (String OM_Output_UU)
	{
		set_Value (COLUMNNAME_OM_Output_UU, OM_Output_UU);
	}

	/** Get OM_Output_UU.
		@return OM_Output_UU	  */
	public String getOM_Output_UU () 
	{
		return (String)get_Value(COLUMNNAME_OM_Output_UU);
	}

	/** Set Sequence.
		@param Sequence Sequence	  */
	public void setSequence (BigDecimal Sequence)
	{
		set_Value (COLUMNNAME_Sequence, Sequence);
	}

	/** Get Sequence.
		@return Sequence	  */
	public BigDecimal getSequence () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Sequence);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Alias.
		@param TableAlias Alias	  */
	public void setTableAlias (String TableAlias)
	{
		set_Value (COLUMNNAME_TableAlias, TableAlias);
	}

	/** Get Alias.
		@return Alias	  */
	public String getTableAlias () 
	{
		return (String)get_Value(COLUMNNAME_TableAlias);
	}
}