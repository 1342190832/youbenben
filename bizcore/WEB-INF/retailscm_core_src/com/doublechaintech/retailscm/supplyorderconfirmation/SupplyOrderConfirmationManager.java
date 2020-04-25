
package com.doublechaintech.retailscm.supplyorderconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderConfirmationManager extends BaseManager{

		

	public SupplyOrderConfirmation createSupplyOrderConfirmation(RetailscmUserContext userContext, String who,Date confirmTime) throws Exception;
	public SupplyOrderConfirmation updateSupplyOrderConfirmation(RetailscmUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderConfirmation loadSupplyOrderConfirmation(RetailscmUserContext userContext, String supplyOrderConfirmationId, String [] tokensExpr) throws Exception;
	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation) throws Exception;
	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String supplyOrderConfirmationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderConfirmation addConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderConfirmation addSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


