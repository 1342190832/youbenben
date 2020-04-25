
package com.doublechaintech.retailscm.retailstoreorderconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderConfirmationManager extends BaseManager{

		

	public RetailStoreOrderConfirmation createRetailStoreOrderConfirmation(RetailscmUserContext userContext, String who,Date confirmTime) throws Exception;
	public RetailStoreOrderConfirmation updateRetailStoreOrderConfirmation(RetailscmUserContext userContext,String retailStoreOrderConfirmationId, int retailStoreOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderConfirmation loadRetailStoreOrderConfirmation(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderConfirmation internalSaveRetailStoreOrderConfirmation(RetailscmUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation) throws Exception;
	public RetailStoreOrderConfirmation internalSaveRetailStoreOrderConfirmation(RetailscmUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrderConfirmation addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderConfirmation removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderConfirmation updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


