
package com.youbenben.youbenben.retailstoreordershipment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreOrderShipmentManager extends BaseManager{

		

	public RetailStoreOrderShipment createRetailStoreOrderShipment(YoubenbenUserContext userContext, String who,Date shipTime) throws Exception;
	public RetailStoreOrderShipment updateRetailStoreOrderShipment(YoubenbenUserContext userContext,String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderShipment loadRetailStoreOrderShipment(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderShipment internalSaveRetailStoreOrderShipment(YoubenbenUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment) throws Exception;
	public RetailStoreOrderShipment internalSaveRetailStoreOrderShipment(YoubenbenUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOrderShipment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreOrderManager getRetailStoreOrderManager(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrderShipment addRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderShipment removeRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderShipment updateRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


