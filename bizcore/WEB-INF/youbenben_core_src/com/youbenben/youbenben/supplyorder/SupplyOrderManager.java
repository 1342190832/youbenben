
package com.youbenben.youbenben.supplyorder;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplyOrderManager extends BaseManager{

		

	public SupplyOrder createSupplyOrder(YoubenbenUserContext userContext, String buyerId,String sellerId,String title,BigDecimal totalAmount,String confirmationId,String approvalId,String processingId,String pickingId,String shipmentId,String deliveryId) throws Exception;
	public SupplyOrder updateSupplyOrder(YoubenbenUserContext userContext,String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrder loadSupplyOrder(YoubenbenUserContext userContext, String supplyOrderId, String [] tokensExpr) throws Exception;
	public SupplyOrder internalSaveSupplyOrder(YoubenbenUserContext userContext, SupplyOrder supplyOrder) throws Exception;
	public SupplyOrder internalSaveSupplyOrder(YoubenbenUserContext userContext, SupplyOrder supplyOrder,Map<String,Object>option) throws Exception;

	public SupplyOrder transferToAnotherBuyer(YoubenbenUserContext userContext, String supplyOrderId, String anotherBuyerId)  throws Exception;
 	public SupplyOrder transferToAnotherSeller(YoubenbenUserContext userContext, String supplyOrderId, String anotherSellerId)  throws Exception;
 	public SupplyOrder transferToAnotherConfirmation(YoubenbenUserContext userContext, String supplyOrderId, String anotherConfirmationId)  throws Exception;
 	public SupplyOrder transferToAnotherApproval(YoubenbenUserContext userContext, String supplyOrderId, String anotherApprovalId)  throws Exception;
 	public SupplyOrder transferToAnotherProcessing(YoubenbenUserContext userContext, String supplyOrderId, String anotherProcessingId)  throws Exception;
 	public SupplyOrder transferToAnotherPicking(YoubenbenUserContext userContext, String supplyOrderId, String anotherPickingId)  throws Exception;
 	public SupplyOrder transferToAnotherShipment(YoubenbenUserContext userContext, String supplyOrderId, String anotherShipmentId)  throws Exception;
 	public SupplyOrder transferToAnotherDelivery(YoubenbenUserContext userContext, String supplyOrderId, String anotherDeliveryId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String supplyOrderId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrder newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SupplyOrderLineItemManager getSupplyOrderLineItemManager(YoubenbenUserContext userContext, String supplyOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement ,String [] tokensExpr)  throws Exception;

	public  SupplyOrder addSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement , String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderShippingGroupManager getSupplyOrderShippingGroupManager(YoubenbenUserContext userContext, String supplyOrderId, String name, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  SupplyOrder addSupplyOrderShippingGroup(YoubenbenUserContext userContext, String supplyOrderId, String name, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeSupplyOrderShippingGroup(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateSupplyOrderShippingGroup(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderPaymentGroupManager getSupplyOrderPaymentGroupManager(YoubenbenUserContext userContext, String supplyOrderId, String name, String cardNumber ,String [] tokensExpr)  throws Exception;

	public  SupplyOrder addSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String supplyOrderId, String name, String cardNumber , String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  GoodsManager getGoodsManager(YoubenbenUserContext userContext, String supplyOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId, String packagingId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrder addGoods(YoubenbenUserContext userContext, String supplyOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId, String packagingId , String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeGoods(YoubenbenUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateGoods(YoubenbenUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

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


