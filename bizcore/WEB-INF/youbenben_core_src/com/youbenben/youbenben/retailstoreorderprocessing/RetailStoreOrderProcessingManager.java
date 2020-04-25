
package com.youbenben.youbenben.retailstoreorderprocessing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreOrderProcessingManager extends BaseManager{

		

	public RetailStoreOrderProcessing createRetailStoreOrderProcessing(YoubenbenUserContext userContext, String who,Date processTime) throws Exception;
	public RetailStoreOrderProcessing updateRetailStoreOrderProcessing(YoubenbenUserContext userContext,String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderProcessing loadRetailStoreOrderProcessing(YoubenbenUserContext userContext, String retailStoreOrderProcessingId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderProcessing internalSaveRetailStoreOrderProcessing(YoubenbenUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing) throws Exception;
	public RetailStoreOrderProcessing internalSaveRetailStoreOrderProcessing(YoubenbenUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreOrderProcessingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOrderProcessing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreOrderManager getRetailStoreOrderManager(YoubenbenUserContext userContext, String retailStoreOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrderProcessing addRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderProcessing removeRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderProcessing updateRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


