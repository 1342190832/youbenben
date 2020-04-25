
package com.youbenben.youbenben.retailstoreclosing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreClosingManager extends BaseManager{

		

	public RetailStoreClosing createRetailStoreClosing(YoubenbenUserContext userContext, String comment) throws Exception;
	public RetailStoreClosing updateRetailStoreClosing(YoubenbenUserContext userContext,String retailStoreClosingId, int retailStoreClosingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreClosing loadRetailStoreClosing(YoubenbenUserContext userContext, String retailStoreClosingId, String [] tokensExpr) throws Exception;
	public RetailStoreClosing internalSaveRetailStoreClosing(YoubenbenUserContext userContext, RetailStoreClosing retailStoreClosing) throws Exception;
	public RetailStoreClosing internalSaveRetailStoreClosing(YoubenbenUserContext userContext, RetailStoreClosing retailStoreClosing,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreClosingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreClosing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreManager getRetailStoreManager(YoubenbenUserContext userContext, String retailStoreClosingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreClosing addRetailStore(YoubenbenUserContext userContext, String retailStoreClosingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreClosing removeRetailStore(YoubenbenUserContext userContext, String retailStoreClosingId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreClosing updateRetailStore(YoubenbenUserContext userContext, String retailStoreClosingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


