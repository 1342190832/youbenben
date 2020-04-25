
package com.doublechaintech.retailscm.consumerorder;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface ConsumerOrderManager extends BaseManager{

		

	public ConsumerOrder createConsumerOrder(RetailscmUserContext userContext, String title,String consumerId,String confirmationId,String approvalId,String processingId,String shipmentId,String deliveryId,String storeId) throws Exception;
	public ConsumerOrder updateConsumerOrder(RetailscmUserContext userContext,String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrder loadConsumerOrder(RetailscmUserContext userContext, String consumerOrderId, String [] tokensExpr) throws Exception;
	public ConsumerOrder internalSaveConsumerOrder(RetailscmUserContext userContext, ConsumerOrder consumerOrder) throws Exception;
	public ConsumerOrder internalSaveConsumerOrder(RetailscmUserContext userContext, ConsumerOrder consumerOrder,Map<String,Object>option) throws Exception;

	public ConsumerOrder transferToAnotherConsumer(RetailscmUserContext userContext, String consumerOrderId, String anotherConsumerId)  throws Exception;
 	public ConsumerOrder transferToAnotherConfirmation(RetailscmUserContext userContext, String consumerOrderId, String anotherConfirmationId)  throws Exception;
 	public ConsumerOrder transferToAnotherApproval(RetailscmUserContext userContext, String consumerOrderId, String anotherApprovalId)  throws Exception;
 	public ConsumerOrder transferToAnotherProcessing(RetailscmUserContext userContext, String consumerOrderId, String anotherProcessingId)  throws Exception;
 	public ConsumerOrder transferToAnotherShipment(RetailscmUserContext userContext, String consumerOrderId, String anotherShipmentId)  throws Exception;
 	public ConsumerOrder transferToAnotherDelivery(RetailscmUserContext userContext, String consumerOrderId, String anotherDeliveryId)  throws Exception;
 	public ConsumerOrder transferToAnotherStore(RetailscmUserContext userContext, String consumerOrderId, String anotherStoreId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String consumerOrderId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrder newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderLineItemManager getConsumerOrderLineItemManager(RetailscmUserContext userContext, String consumerOrderId, String skuId, String skuName, BigDecimal price, BigDecimal quantity, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addConsumerOrderLineItem(RetailscmUserContext userContext, String consumerOrderId, String skuId, String skuName, BigDecimal price, BigDecimal quantity, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderLineItem(RetailscmUserContext userContext, String consumerOrderId, String consumerOrderLineItemId, int consumerOrderLineItemVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderLineItem(RetailscmUserContext userContext, String consumerOrderId, String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ConsumerOrderShippingGroupManager getConsumerOrderShippingGroupManager(RetailscmUserContext userContext, String consumerOrderId, String name, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderId, String name, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderId, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderId, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ConsumerOrderPaymentGroupManager getConsumerOrderPaymentGroupManager(RetailscmUserContext userContext, String consumerOrderId, String name, String cardNumber ,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addConsumerOrderPaymentGroup(RetailscmUserContext userContext, String consumerOrderId, String name, String cardNumber , String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderPaymentGroup(RetailscmUserContext userContext, String consumerOrderId, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderPaymentGroup(RetailscmUserContext userContext, String consumerOrderId, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ConsumerOrderPriceAdjustmentManager getConsumerOrderPriceAdjustmentManager(RetailscmUserContext userContext, String consumerOrderId, String name, BigDecimal amount, String provider ,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderId, String name, BigDecimal amount, String provider , String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderId, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderId, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreMemberGiftCardConsumeRecordManager getRetailStoreMemberGiftCardConsumeRecordManager(RetailscmUserContext userContext, String consumerOrderId, Date occureTime, String ownerId, String number, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String consumerOrderId, Date occureTime, String ownerId, String number, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String consumerOrderId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String consumerOrderId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByConsumer(RetailscmUserContext userContext,String consumerId) throws Exception;
	public Object listPageByConsumer(RetailscmUserContext userContext,String consumerId, int start, int count) throws Exception;
  
	public Object listByConfirmation(RetailscmUserContext userContext,String confirmationId) throws Exception;
	public Object listPageByConfirmation(RetailscmUserContext userContext,String confirmationId, int start, int count) throws Exception;
  
	public Object listByApproval(RetailscmUserContext userContext,String approvalId) throws Exception;
	public Object listPageByApproval(RetailscmUserContext userContext,String approvalId, int start, int count) throws Exception;
  
	public Object listByProcessing(RetailscmUserContext userContext,String processingId) throws Exception;
	public Object listPageByProcessing(RetailscmUserContext userContext,String processingId, int start, int count) throws Exception;
  
	public Object listByShipment(RetailscmUserContext userContext,String shipmentId) throws Exception;
	public Object listPageByShipment(RetailscmUserContext userContext,String shipmentId, int start, int count) throws Exception;
  
	public Object listByDelivery(RetailscmUserContext userContext,String deliveryId) throws Exception;
	public Object listPageByDelivery(RetailscmUserContext userContext,String deliveryId, int start, int count) throws Exception;
  
	public Object listByStore(RetailscmUserContext userContext,String storeId) throws Exception;
	public Object listPageByStore(RetailscmUserContext userContext,String storeId, int start, int count) throws Exception;
  

}


