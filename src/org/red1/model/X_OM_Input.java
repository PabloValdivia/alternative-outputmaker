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

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for OM_Input
 *  @author iDempiere (generated) 
 *  @version Release 2.1 - $Id$ */
public class X_OM_Input extends PO implements I_OM_Input, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150202L;

    /** Standard Constructor */
    public X_OM_Input (Properties ctx, int OM_Input_ID, String trxName)
    {
      super (ctx, OM_Input_ID, trxName);
      /** if (OM_Input_ID == 0)
        {
			setOM_Input_ID (0);
        } */
    }

    /** Load Constructor */
    public X_OM_Input (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_OM_Input[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Table)MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_Name)
			.getPO(getAD_Table_ID(), get_TrxName());	}

	/** Set Table.
		@param AD_Table_ID 
		Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID)
	{
		if (AD_Table_ID < 1) 
			set_Value (COLUMNNAME_AD_Table_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
	}

	/** Get Table.
		@return Database Table information
	  */
	public int getAD_Table_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CommonValue.
		@param CommonValue CommonValue	  */
	public void setCommonValue (String CommonValue)
	{
		set_Value (COLUMNNAME_CommonValue, CommonValue);
	}

	/** Get CommonValue.
		@return CommonValue	  */
	public String getCommonValue () 
	{
		return (String)get_Value(COLUMNNAME_CommonValue);
	}

	/** Set OutputMakerInput.
		@param OM_Input_ID OutputMakerInput	  */
	public void setOM_Input_ID (int OM_Input_ID)
	{
		if (OM_Input_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_OM_Input_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_OM_Input_ID, Integer.valueOf(OM_Input_ID));
	}

	/** Get OutputMakerInput.
		@return OutputMakerInput	  */
	public int getOM_Input_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_OM_Input_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set OM_Input_UU.
		@param OM_Input_UU OM_Input_UU	  */
	public void setOM_Input_UU (String OM_Input_UU)
	{
		set_Value (COLUMNNAME_OM_Input_UU, OM_Input_UU);
	}

	/** Get OM_Input_UU.
		@return OM_Input_UU	  */
	public String getOM_Input_UU () 
	{
		return (String)get_Value(COLUMNNAME_OM_Input_UU);
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

	/** INNER JOIN = IJ */
	public static final String SQLJOIN_INNERJOIN = "IJ";
	/** OUTER JOIN = OJ */
	public static final String SQLJOIN_OUTERJOIN = "OJ";
	/** Set SQL Join.
		@param SQLjoin SQL Join	  */
	public void setSQLjoin (String SQLjoin)
	{

		set_Value (COLUMNNAME_SQLjoin, SQLjoin);
	}

	/** Get SQL Join.
		@return SQL Join	  */
	public String getSQLjoin () 
	{
		return (String)get_Value(COLUMNNAME_SQLjoin);
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