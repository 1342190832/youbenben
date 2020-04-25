
package com.youbenben.youbenben.retailstoreorderconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreOrderConfirmationManager extends BaseManager{

		

	public RetailStoreOrderConfirmation createRetailStoreOrderConfirmation(YoubenbenUserContext userContext, String who,Date confirmTime) throws Exception;
	public RetailStoreOrderConfirmation updateRetailStoreOrderConfirmation(YoubenbenUserContext userContext,String retailStoreOrderConfirmationId, int retailStoreOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderConfirmation loadRetailStoreOrderConfirmation(YoubenbenUserContext userContext, String retailStoreOrderConfirmationId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderConfirmation internalSaveRetailStoreOrderConfirmation(YoubenbenUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation) throws Exception;
	public RetailStoreOrderConfirmation internalSaveRetailStoreOrderConfirmation(YoubenbenUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreOrderConfirmationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOrderConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreOrderManager getRetailStoreOrderManager(YoubenbenUserContext userContext, String retailStoreOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrderConfirmation addRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderConfirmation removeRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderConfirmationId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderConfirmation updateRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderConfirmationId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


