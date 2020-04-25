
package com.doublechaintech.retailscm.retailstoreorderapproval;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderApprovalManager extends BaseManager{

		

	public RetailStoreOrderApproval createRetailStoreOrderApproval(RetailscmUserContext userContext, String who,Date approveTime) throws Exception;
	public RetailStoreOrderApproval updateRetailStoreOrderApproval(RetailscmUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderApproval loadRetailStoreOrderApproval(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderApproval internalSaveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval) throws Exception;
	public RetailStoreOrderApproval internalSaveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String retailStoreOrderApprovalId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderApproval newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrderApproval addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderApproval removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderApproval updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


