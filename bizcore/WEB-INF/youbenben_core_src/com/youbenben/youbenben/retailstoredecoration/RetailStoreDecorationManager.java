
package com.youbenben.youbenben.retailstoredecoration;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreDecorationManager extends BaseManager{

		

	public RetailStoreDecoration createRetailStoreDecoration(YoubenbenUserContext userContext, String comment) throws Exception;
	public RetailStoreDecoration updateRetailStoreDecoration(YoubenbenUserContext userContext,String retailStoreDecorationId, int retailStoreDecorationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreDecoration loadRetailStoreDecoration(YoubenbenUserContext userContext, String retailStoreDecorationId, String [] tokensExpr) throws Exception;
	public RetailStoreDecoration internalSaveRetailStoreDecoration(YoubenbenUserContext userContext, RetailStoreDecoration retailStoreDecoration) throws Exception;
	public RetailStoreDecoration internalSaveRetailStoreDecoration(YoubenbenUserContext userContext, RetailStoreDecoration retailStoreDecoration,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreDecorationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreDecoration newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreManager getRetailStoreManager(YoubenbenUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreDecoration addRetailStore(YoubenbenUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreDecoration removeRetailStore(YoubenbenUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreDecoration updateRetailStore(YoubenbenUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


