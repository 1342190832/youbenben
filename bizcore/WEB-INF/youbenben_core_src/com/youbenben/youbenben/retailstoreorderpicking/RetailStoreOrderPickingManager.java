
package com.youbenben.youbenben.retailstoreorderpicking;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreOrderPickingManager extends BaseManager{

		

	public RetailStoreOrderPicking createRetailStoreOrderPicking(YoubenbenUserContext userContext, String who,Date processTime) throws Exception;
	public RetailStoreOrderPicking updateRetailStoreOrderPicking(YoubenbenUserContext userContext,String retailStoreOrderPickingId, int retailStoreOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderPicking loadRetailStoreOrderPicking(YoubenbenUserContext userContext, String retailStoreOrderPickingId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderPicking internalSaveRetailStoreOrderPicking(YoubenbenUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking) throws Exception;
	public RetailStoreOrderPicking internalSaveRetailStoreOrderPicking(YoubenbenUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreOrderPickingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOrderPicking newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreOrderManager getRetailStoreOrderManager(YoubenbenUserContext userContext, String retailStoreOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrderPicking addRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderPicking removeRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderPicking updateRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


