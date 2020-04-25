
package com.youbenben.youbenben.supplyorderapproval;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplyOrderApprovalManager extends BaseManager{

		

	public SupplyOrderApproval createSupplyOrderApproval(YoubenbenUserContext userContext, String who,Date approveTime) throws Exception;
	public SupplyOrderApproval updateSupplyOrderApproval(YoubenbenUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderApproval loadSupplyOrderApproval(YoubenbenUserContext userContext, String supplyOrderApprovalId, String [] tokensExpr) throws Exception;
	public SupplyOrderApproval internalSaveSupplyOrderApproval(YoubenbenUserContext userContext, SupplyOrderApproval supplyOrderApproval) throws Exception;
	public SupplyOrderApproval internalSaveSupplyOrderApproval(YoubenbenUserContext userContext, SupplyOrderApproval supplyOrderApproval,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String supplyOrderApprovalId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderApproval newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(YoubenbenUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String confirmationId, String processingId, String shipmentId, String deliveryId, String storeId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderApproval addConsumerOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String confirmationId, String processingId, String shipmentId, String deliveryId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval removeConsumerOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval updateConsumerOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(YoubenbenUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderApproval addSupplyOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval removeSupplyOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval updateSupplyOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


