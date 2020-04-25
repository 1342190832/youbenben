
package com.doublechaintech.retailscm.retailstoreorderprocessing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderProcessingManager extends BaseManager{

		

	public RetailStoreOrderProcessing createRetailStoreOrderProcessing(RetailscmUserContext userContext, String who,Date processTime) throws Exception;
	public RetailStoreOrderProcessing updateRetailStoreOrderProcessing(RetailscmUserContext userContext,String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderProcessing loadRetailStoreOrderProcessing(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderProcessing internalSaveRetailStoreOrderProcessing(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing) throws Exception;
	public RetailStoreOrderProcessing internalSaveRetailStoreOrderProcessing(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String retailStoreOrderProcessingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderProcessing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrderProcessing addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderProcessing removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderProcessing updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


