
package com.youbenben.youbenben.retailstorefranchising;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreFranchisingManager extends BaseManager{

		

	public RetailStoreFranchising createRetailStoreFranchising(YoubenbenUserContext userContext, String comment) throws Exception;
	public RetailStoreFranchising updateRetailStoreFranchising(YoubenbenUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreFranchising loadRetailStoreFranchising(YoubenbenUserContext userContext, String retailStoreFranchisingId, String [] tokensExpr) throws Exception;
	public RetailStoreFranchising internalSaveRetailStoreFranchising(YoubenbenUserContext userContext, RetailStoreFranchising retailStoreFranchising) throws Exception;
	public RetailStoreFranchising internalSaveRetailStoreFranchising(YoubenbenUserContext userContext, RetailStoreFranchising retailStoreFranchising,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreFranchisingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreFranchising newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreManager getRetailStoreManager(YoubenbenUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreFranchising addRetailStore(YoubenbenUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreFranchising removeRetailStore(YoubenbenUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreFranchising updateRetailStore(YoubenbenUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


