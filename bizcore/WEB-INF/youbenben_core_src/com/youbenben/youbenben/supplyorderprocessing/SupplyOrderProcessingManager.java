
package com.youbenben.youbenben.supplyorderprocessing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplyOrderProcessingManager extends BaseManager{

		

	public SupplyOrderProcessing createSupplyOrderProcessing(YoubenbenUserContext userContext, String who,Date processTime) throws Exception;
	public SupplyOrderProcessing updateSupplyOrderProcessing(YoubenbenUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderProcessing loadSupplyOrderProcessing(YoubenbenUserContext userContext, String supplyOrderProcessingId, String [] tokensExpr) throws Exception;
	public SupplyOrderProcessing internalSaveSupplyOrderProcessing(YoubenbenUserContext userContext, SupplyOrderProcessing supplyOrderProcessing) throws Exception;
	public SupplyOrderProcessing internalSaveSupplyOrderProcessing(YoubenbenUserContext userContext, SupplyOrderProcessing supplyOrderProcessing,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String supplyOrderProcessingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderProcessing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(YoubenbenUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String confirmationId, String approvalId, String shipmentId, String deliveryId, String storeId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderProcessing addConsumerOrder(YoubenbenUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String confirmationId, String approvalId, String shipmentId, String deliveryId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing removeConsumerOrder(YoubenbenUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing updateConsumerOrder(YoubenbenUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(YoubenbenUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderProcessing addSupplyOrder(YoubenbenUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing removeSupplyOrder(YoubenbenUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing updateSupplyOrder(YoubenbenUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


