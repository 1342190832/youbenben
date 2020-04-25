
package com.doublechaintech.retailscm.supplyorderprocessing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderProcessingManager extends BaseManager{

		

	public SupplyOrderProcessing createSupplyOrderProcessing(RetailscmUserContext userContext, String who,Date processTime) throws Exception;
	public SupplyOrderProcessing updateSupplyOrderProcessing(RetailscmUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderProcessing loadSupplyOrderProcessing(RetailscmUserContext userContext, String supplyOrderProcessingId, String [] tokensExpr) throws Exception;
	public SupplyOrderProcessing internalSaveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing) throws Exception;
	public SupplyOrderProcessing internalSaveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String supplyOrderProcessingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderProcessing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String confirmationId, String approvalId, String shipmentId, String deliveryId, String storeId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderProcessing addConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String confirmationId, String approvalId, String shipmentId, String deliveryId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderProcessing addSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


