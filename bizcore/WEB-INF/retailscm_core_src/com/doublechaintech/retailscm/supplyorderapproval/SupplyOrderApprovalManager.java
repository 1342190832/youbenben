
package com.doublechaintech.retailscm.supplyorderapproval;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderApprovalManager extends BaseManager{

		

	public SupplyOrderApproval createSupplyOrderApproval(RetailscmUserContext userContext, String who,Date approveTime) throws Exception;
	public SupplyOrderApproval updateSupplyOrderApproval(RetailscmUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderApproval loadSupplyOrderApproval(RetailscmUserContext userContext, String supplyOrderApprovalId, String [] tokensExpr) throws Exception;
	public SupplyOrderApproval internalSaveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval) throws Exception;
	public SupplyOrderApproval internalSaveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String supplyOrderApprovalId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderApproval newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String confirmationId, String processingId, String shipmentId, String deliveryId, String storeId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderApproval addConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String confirmationId, String processingId, String shipmentId, String deliveryId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderApproval addSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


