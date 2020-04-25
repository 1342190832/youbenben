
package com.doublechaintech.retailscm.retailstoreordershipment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderShipmentManager extends BaseManager{

		

	public RetailStoreOrderShipment createRetailStoreOrderShipment(RetailscmUserContext userContext, String who,Date shipTime) throws Exception;
	public RetailStoreOrderShipment updateRetailStoreOrderShipment(RetailscmUserContext userContext,String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderShipment loadRetailStoreOrderShipment(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderShipment internalSaveRetailStoreOrderShipment(RetailscmUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment) throws Exception;
	public RetailStoreOrderShipment internalSaveRetailStoreOrderShipment(RetailscmUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String retailStoreOrderShipmentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderShipment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrderShipment addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderShipment removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderShipment updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


