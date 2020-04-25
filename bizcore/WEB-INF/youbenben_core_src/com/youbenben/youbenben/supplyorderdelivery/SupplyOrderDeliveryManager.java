
package com.youbenben.youbenben.supplyorderdelivery;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplyOrderDeliveryManager extends BaseManager{

		

	public SupplyOrderDelivery createSupplyOrderDelivery(YoubenbenUserContext userContext, String who,Date deliveryTime) throws Exception;
	public SupplyOrderDelivery updateSupplyOrderDelivery(YoubenbenUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderDelivery loadSupplyOrderDelivery(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String [] tokensExpr) throws Exception;
	public SupplyOrderDelivery internalSaveSupplyOrderDelivery(YoubenbenUserContext userContext, SupplyOrderDelivery supplyOrderDelivery) throws Exception;
	public SupplyOrderDelivery internalSaveSupplyOrderDelivery(YoubenbenUserContext userContext, SupplyOrderDelivery supplyOrderDelivery,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String supplyOrderDeliveryId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderDelivery newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String storeId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderDelivery addConsumerOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery removeConsumerOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery updateConsumerOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderDelivery addSupplyOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery removeSupplyOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery updateSupplyOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


