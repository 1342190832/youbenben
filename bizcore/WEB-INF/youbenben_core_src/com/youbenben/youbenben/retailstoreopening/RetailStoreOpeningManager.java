
package com.youbenben.youbenben.retailstoreopening;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreOpeningManager extends BaseManager{

		

	public RetailStoreOpening createRetailStoreOpening(YoubenbenUserContext userContext, String comment) throws Exception;
	public RetailStoreOpening updateRetailStoreOpening(YoubenbenUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOpening loadRetailStoreOpening(YoubenbenUserContext userContext, String retailStoreOpeningId, String [] tokensExpr) throws Exception;
	public RetailStoreOpening internalSaveRetailStoreOpening(YoubenbenUserContext userContext, RetailStoreOpening retailStoreOpening) throws Exception;
	public RetailStoreOpening internalSaveRetailStoreOpening(YoubenbenUserContext userContext, RetailStoreOpening retailStoreOpening,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreOpeningId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOpening newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreManager getRetailStoreManager(YoubenbenUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOpening addRetailStore(YoubenbenUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreOpening removeRetailStore(YoubenbenUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOpening updateRetailStore(YoubenbenUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


