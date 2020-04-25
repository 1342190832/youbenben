
package com.youbenben.youbenben.supplyordershipment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplyOrderShipmentManager extends BaseManager{

		

	public SupplyOrderShipment createSupplyOrderShipment(YoubenbenUserContext userContext, String who,Date shipTime) throws Exception;
	public SupplyOrderShipment updateSupplyOrderShipment(YoubenbenUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderShipment loadSupplyOrderShipment(YoubenbenUserContext userContext, String supplyOrderShipmentId, String [] tokensExpr) throws Exception;
	public SupplyOrderShipment internalSaveSupplyOrderShipment(YoubenbenUserContext userContext, SupplyOrderShipment supplyOrderShipment) throws Exception;
	public SupplyOrderShipment internalSaveSupplyOrderShipment(YoubenbenUserContext userContext, SupplyOrderShipment supplyOrderShipment,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String supplyOrderShipmentId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderShipment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(YoubenbenUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String deliveryId, String storeId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderShipment addConsumerOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String deliveryId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment removeConsumerOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment updateConsumerOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(YoubenbenUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderShipment addSupplyOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment removeSupplyOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment updateSupplyOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


