
package com.youbenben.youbenben.supplyorderconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplyOrderConfirmationManager extends BaseManager{

		

	public SupplyOrderConfirmation createSupplyOrderConfirmation(YoubenbenUserContext userContext, String who,Date confirmTime) throws Exception;
	public SupplyOrderConfirmation updateSupplyOrderConfirmation(YoubenbenUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderConfirmation loadSupplyOrderConfirmation(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String [] tokensExpr) throws Exception;
	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(YoubenbenUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation) throws Exception;
	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(YoubenbenUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String supplyOrderConfirmationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderConfirmation addConsumerOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation removeConsumerOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation updateConsumerOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderConfirmation addSupplyOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation removeSupplyOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation updateSupplyOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


