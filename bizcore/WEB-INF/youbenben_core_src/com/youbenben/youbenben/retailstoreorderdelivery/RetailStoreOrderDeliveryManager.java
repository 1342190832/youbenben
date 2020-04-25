
package com.youbenben.youbenben.retailstoreorderdelivery;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreOrderDeliveryManager extends BaseManager{

		

	public RetailStoreOrderDelivery createRetailStoreOrderDelivery(YoubenbenUserContext userContext, String who,Date deliveryTime) throws Exception;
	public RetailStoreOrderDelivery updateRetailStoreOrderDelivery(YoubenbenUserContext userContext,String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderDelivery loadRetailStoreOrderDelivery(YoubenbenUserContext userContext, String retailStoreOrderDeliveryId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderDelivery internalSaveRetailStoreOrderDelivery(YoubenbenUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery) throws Exception;
	public RetailStoreOrderDelivery internalSaveRetailStoreOrderDelivery(YoubenbenUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreOrderDeliveryId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOrderDelivery newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreOrderManager getRetailStoreOrderManager(YoubenbenUserContext userContext, String retailStoreOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrderDelivery addRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderDelivery removeRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderDelivery updateRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


