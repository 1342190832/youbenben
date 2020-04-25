
package com.youbenben.youbenben.retailstoreorder;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreOrderManager extends BaseManager{

		

	public RetailStoreOrder createRetailStoreOrder(YoubenbenUserContext userContext, String buyerId,String sellerId,String title,BigDecimal totalAmount,String confirmationId,String approvalId,String processingId,String pickingId,String shipmentId,String deliveryId) throws Exception;
	public RetailStoreOrder updateRetailStoreOrder(YoubenbenUserContext userContext,String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrder loadRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderId, String [] tokensExpr) throws Exception;
	public RetailStoreOrder internalSaveRetailStoreOrder(YoubenbenUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception;
	public RetailStoreOrder internalSaveRetailStoreOrder(YoubenbenUserContext userContext, RetailStoreOrder retailStoreOrder,Map<String,Object>option) throws Exception;

	public RetailStoreOrder transferToAnotherBuyer(YoubenbenUserContext userContext, String retailStoreOrderId, String anotherBuyerId)  throws Exception;
 	public RetailStoreOrder transferToAnotherSeller(YoubenbenUserContext userContext, String retailStoreOrderId, String anotherSellerId)  throws Exception;
 	public RetailStoreOrder transferToAnotherConfirmation(YoubenbenUserContext userContext, String retailStoreOrderId, String anotherConfirmationId)  throws Exception;
 	public RetailStoreOrder transferToAnotherApproval(YoubenbenUserContext userContext, String retailStoreOrderId, String anotherApprovalId)  throws Exception;
 	public RetailStoreOrder transferToAnotherProcessing(YoubenbenUserContext userContext, String retailStoreOrderId, String anotherProcessingId)  throws Exception;
 	public RetailStoreOrder transferToAnotherPicking(YoubenbenUserContext userContext, String retailStoreOrderId, String anotherPickingId)  throws Exception;
 	public RetailStoreOrder transferToAnotherShipment(YoubenbenUserContext userContext, String retailStoreOrderId, String anotherShipmentId)  throws Exception;
 	public RetailStoreOrder transferToAnotherDelivery(YoubenbenUserContext userContext, String retailStoreOrderId, String anotherDeliveryId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreOrderId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOrder newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreOrderLineItemManager getRetailStoreOrderLineItemManager(YoubenbenUserContext userContext, String retailStoreOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrder addRetailStoreOrderLineItem(YoubenbenUserContext userContext, String retailStoreOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeRetailStoreOrderLineItem(YoubenbenUserContext userContext, String retailStoreOrderId, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateRetailStoreOrderLineItem(YoubenbenUserContext userContext, String retailStoreOrderId, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreOrderShippingGroupManager getRetailStoreOrderShippingGroupManager(YoubenbenUserContext userContext, String retailStoreOrderId, String name, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrder addRetailStoreOrderShippingGroup(YoubenbenUserContext userContext, String retailStoreOrderId, String name, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeRetailStoreOrderShippingGroup(YoubenbenUserContext userContext, String retailStoreOrderId, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateRetailStoreOrderShippingGroup(YoubenbenUserContext userContext, String retailStoreOrderId, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreOrderPaymentGroupManager getRetailStoreOrderPaymentGroupManager(YoubenbenUserContext userContext, String retailStoreOrderId, String name, String cardNumber ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrder addRetailStoreOrderPaymentGroup(YoubenbenUserContext userContext, String retailStoreOrderId, String name, String cardNumber , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeRetailStoreOrderPaymentGroup(YoubenbenUserContext userContext, String retailStoreOrderId, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateRetailStoreOrderPaymentGroup(YoubenbenUserContext userContext, String retailStoreOrderId, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  GoodsManager getGoodsManager(YoubenbenUserContext userContext, String retailStoreOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String packagingId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrder addGoods(YoubenbenUserContext userContext, String retailStoreOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String packagingId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeGoods(YoubenbenUserContext userContext, String retailStoreOrderId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateGoods(YoubenbenUserContext userContext, String retailStoreOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBuyer(YoubenbenUserContext userContext,String buyerId) throws Exception;
	public Object listPageByBuyer(YoubenbenUserContext userContext,String buyerId, int start, int count) throws Exception;
  
	public Object listBySeller(YoubenbenUserContext userContext,String sellerId) throws Exception;
	public Object listPageBySeller(YoubenbenUserContext userContext,String sellerId, int start, int count) throws Exception;
  
	public Object listByConfirmation(YoubenbenUserContext userContext,String confirmationId) throws Exception;
	public Object listPageByConfirmation(YoubenbenUserContext userContext,String confirmationId, int start, int count) throws Exception;
  
	public Object listByApproval(YoubenbenUserContext userContext,String approvalId) throws Exception;
	public Object listPageByApproval(YoubenbenUserContext userContext,String approvalId, int start, int count) throws Exception;
  
	public Object listByProcessing(YoubenbenUserContext userContext,String processingId) throws Exception;
	public Object listPageByProcessing(YoubenbenUserContext userContext,String processingId, int start, int count) throws Exception;
  
	public Object listByPicking(YoubenbenUserContext userContext,String pickingId) throws Exception;
	public Object listPageByPicking(YoubenbenUserContext userContext,String pickingId, int start, int count) throws Exception;
  
	public Object listByShipment(YoubenbenUserContext userContext,String shipmentId) throws Exception;
	public Object listPageByShipment(YoubenbenUserContext userContext,String shipmentId, int start, int count) throws Exception;
  
	public Object listByDelivery(YoubenbenUserContext userContext,String deliveryId) throws Exception;
	public Object listPageByDelivery(YoubenbenUserContext userContext,String deliveryId, int start, int count) throws Exception;
  

}


