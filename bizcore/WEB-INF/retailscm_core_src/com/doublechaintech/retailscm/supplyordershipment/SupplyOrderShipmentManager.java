
package com.doublechaintech.retailscm.supplyordershipment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderShipmentManager extends BaseManager{

		

	public SupplyOrderShipment createSupplyOrderShipment(RetailscmUserContext userContext, String who,Date shipTime) throws Exception;
	public SupplyOrderShipment updateSupplyOrderShipment(RetailscmUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderShipment loadSupplyOrderShipment(RetailscmUserContext userContext, String supplyOrderShipmentId, String [] tokensExpr) throws Exception;
	public SupplyOrderShipment internalSaveSupplyOrderShipment(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment) throws Exception;
	public SupplyOrderShipment internalSaveSupplyOrderShipment(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String supplyOrderShipmentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderShipment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String deliveryId, String storeId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderShipment addConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String deliveryId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderShipment addSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


