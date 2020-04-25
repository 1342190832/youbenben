
package com.youbenben.youbenben.consumerorder;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ConsumerOrderManager extends BaseManager{

		

	public ConsumerOrder createConsumerOrder(YoubenbenUserContext userContext, String title,String consumerId,String confirmationId,String approvalId,String processingId,String shipmentId,String deliveryId,String storeId) throws Exception;
	public ConsumerOrder updateConsumerOrder(YoubenbenUserContext userContext,String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrder loadConsumerOrder(YoubenbenUserContext userContext, String consumerOrderId, String [] tokensExpr) throws Exception;
	public ConsumerOrder internalSaveConsumerOrder(YoubenbenUserContext userContext, ConsumerOrder consumerOrder) throws Exception;
	public ConsumerOrder internalSaveConsumerOrder(YoubenbenUserContext userContext, ConsumerOrder consumerOrder,Map<String,Object>option) throws Exception;

	public ConsumerOrder transferToAnotherConsumer(YoubenbenUserContext userContext, String consumerOrderId, String anotherConsumerId)  throws Exception;
 	public ConsumerOrder transferToAnotherConfirmation(YoubenbenUserContext userContext, String consumerOrderId, String anotherConfirmationId)  throws Exception;
 	public ConsumerOrder transferToAnotherApproval(YoubenbenUserContext userContext, String consumerOrderId, String anotherApprovalId)  throws Exception;
 	public ConsumerOrder transferToAnotherProcessing(YoubenbenUserContext userContext, String consumerOrderId, String anotherProcessingId)  throws Exception;
 	public ConsumerOrder transferToAnotherShipment(YoubenbenUserContext userContext, String consumerOrderId, String anotherShipmentId)  throws Exception;
 	public ConsumerOrder transferToAnotherDelivery(YoubenbenUserContext userContext, String consumerOrderId, String anotherDeliveryId)  throws Exception;
 	public ConsumerOrder transferToAnotherStore(YoubenbenUserContext userContext, String consumerOrderId, String anotherStoreId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String consumerOrderId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrder newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderLineItemManager getConsumerOrderLineItemManager(YoubenbenUserContext userContext, String consumerOrderId, String skuId, String skuName, BigDecimal price, BigDecimal quantity, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addConsumerOrderLineItem(YoubenbenUserContext userContext, String consumerOrderId, String skuId, String skuName, BigDecimal price, BigDecimal quantity, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderLineItem(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderLineItemId, int consumerOrderLineItemVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderLineItem(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ConsumerOrderShippingGroupManager getConsumerOrderShippingGroupManager(YoubenbenUserContext userContext, String consumerOrderId, String name, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addConsumerOrderShippingGroup(YoubenbenUserContext userContext, String consumerOrderId, String name, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderShippingGroup(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderShippingGroup(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ConsumerOrderPaymentGroupManager getConsumerOrderPaymentGroupManager(YoubenbenUserContext userContext, String consumerOrderId, String name, String cardNumber ,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String consumerOrderId, String name, String cardNumber , String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ConsumerOrderPriceAdjustmentManager getConsumerOrderPriceAdjustmentManager(YoubenbenUserContext userContext, String consumerOrderId, String name, BigDecimal amount, String provider ,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String consumerOrderId, String name, BigDecimal amount, String provider , String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreMemberGiftCardConsumeRecordManager getRetailStoreMemberGiftCardConsumeRecordManager(YoubenbenUserContext userContext, String consumerOrderId, Date occureTime, String ownerId, String number, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String consumerOrderId, Date occureTime, String ownerId, String number, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String consumerOrderId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String consumerOrderId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByConsumer(YoubenbenUserContext userContext,String consumerId) throws Exception;
	public Object listPageByConsumer(YoubenbenUserContext userContext,String consumerId, int start, int count) throws Exception;
  
	public Object listByConfirmation(YoubenbenUserContext userContext,String confirmationId) throws Exception;
	public Object listPageByConfirmation(YoubenbenUserContext userContext,String confirmationId, int start, int count) throws Exception;
  
	public Object listByApproval(YoubenbenUserContext userContext,String approvalId) throws Exception;
	public Object listPageByApproval(YoubenbenUserContext userContext,String approvalId, int start, int count) throws Exception;
  
	public Object listByProcessing(YoubenbenUserContext userContext,String processingId) throws Exception;
	public Object listPageByProcessing(YoubenbenUserContext userContext,String processingId, int start, int count) throws Exception;
  
	public Object listByShipment(YoubenbenUserContext userContext,String shipmentId) throws Exception;
	public Object listPageByShipment(YoubenbenUserContext userContext,String shipmentId, int start, int count) throws Exception;
  
	public Object listByDelivery(YoubenbenUserContext userContext,String deliveryId) throws Exception;
	public Object listPageByDelivery(YoubenbenUserContext userContext,String deliveryId, int start, int count) throws Exception;
  
	public Object listByStore(YoubenbenUserContext userContext,String storeId) throws Exception;
	public Object listPageByStore(YoubenbenUserContext userContext,String storeId, int start, int count) throws Exception;
  

}


