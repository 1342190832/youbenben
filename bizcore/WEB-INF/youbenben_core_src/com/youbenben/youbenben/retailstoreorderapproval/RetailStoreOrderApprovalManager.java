
package com.youbenben.youbenben.retailstoreorderapproval;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreOrderApprovalManager extends BaseManager{

		

	public RetailStoreOrderApproval createRetailStoreOrderApproval(YoubenbenUserContext userContext, String who,Date approveTime) throws Exception;
	public RetailStoreOrderApproval updateRetailStoreOrderApproval(YoubenbenUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderApproval loadRetailStoreOrderApproval(YoubenbenUserContext userContext, String retailStoreOrderApprovalId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderApproval internalSaveRetailStoreOrderApproval(YoubenbenUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval) throws Exception;
	public RetailStoreOrderApproval internalSaveRetailStoreOrderApproval(YoubenbenUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreOrderApprovalId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOrderApproval newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreOrderManager getRetailStoreOrderManager(YoubenbenUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrderApproval addRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderApproval removeRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderApproval updateRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


