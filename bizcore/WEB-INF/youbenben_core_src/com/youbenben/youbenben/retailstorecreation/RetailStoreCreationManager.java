
package com.youbenben.youbenben.retailstorecreation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreCreationManager extends BaseManager{

		

	public RetailStoreCreation createRetailStoreCreation(YoubenbenUserContext userContext, String comment) throws Exception;
	public RetailStoreCreation updateRetailStoreCreation(YoubenbenUserContext userContext,String retailStoreCreationId, int retailStoreCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreCreation loadRetailStoreCreation(YoubenbenUserContext userContext, String retailStoreCreationId, String [] tokensExpr) throws Exception;
	public RetailStoreCreation internalSaveRetailStoreCreation(YoubenbenUserContext userContext, RetailStoreCreation retailStoreCreation) throws Exception;
	public RetailStoreCreation internalSaveRetailStoreCreation(YoubenbenUserContext userContext, RetailStoreCreation retailStoreCreation,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreCreationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreCreation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreManager getRetailStoreManager(YoubenbenUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCreation addRetailStore(YoubenbenUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCreation removeRetailStore(YoubenbenUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCreation updateRetailStore(YoubenbenUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


