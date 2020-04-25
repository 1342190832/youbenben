
package com.doublechaintech.retailscm.supplyorderdelivery;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderDeliveryManager extends BaseManager{

		

	public SupplyOrderDelivery createSupplyOrderDelivery(RetailscmUserContext userContext, String who,Date deliveryTime) throws Exception;
	public SupplyOrderDelivery updateSupplyOrderDelivery(RetailscmUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderDelivery loadSupplyOrderDelivery(RetailscmUserContext userContext, String supplyOrderDeliveryId, String [] tokensExpr) throws Exception;
	public SupplyOrderDelivery internalSaveSupplyOrderDelivery(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery) throws Exception;
	public SupplyOrderDelivery internalSaveSupplyOrderDelivery(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String supplyOrderDeliveryId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderDelivery newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String storeId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderDelivery addConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderDelivery addSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


