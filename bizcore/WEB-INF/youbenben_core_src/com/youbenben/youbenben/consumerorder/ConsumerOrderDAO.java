
package com.youbenben.youbenben.consumerorder;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDelivery;
import com.youbenben.youbenben.supplyorderapproval.SupplyOrderApproval;
import com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmation;
import com.youbenben.youbenben.consumerorderlineitem.ConsumerOrderLineItem;
import com.youbenben.youbenben.supplyordershipment.SupplyOrderShipment;
import com.youbenben.youbenben.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.youbenben.youbenben.retailstore.RetailStore;
import com.youbenben.youbenben.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.youbenben.youbenben.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.youbenben.youbenben.retailstoremember.RetailStoreMember;
import com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessing;
import com.youbenben.youbenben.consumerordershippinggroup.ConsumerOrderShippingGroup;

import com.youbenben.youbenben.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO;
import com.youbenben.youbenben.retailstoremember.RetailStoreMemberDAO;
import com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmationDAO;
import com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessingDAO;
import com.youbenben.youbenben.retailstore.RetailStoreDAO;
import com.youbenben.youbenben.consumerorderlineitem.ConsumerOrderLineItemDAO;
import com.youbenben.youbenben.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentDAO;
import com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDeliveryDAO;
import com.youbenben.youbenben.supplyorderapproval.SupplyOrderApprovalDAO;
import com.youbenben.youbenben.supplyordershipment.SupplyOrderShipmentDAO;
import com.youbenben.youbenben.consumerorderpaymentgroup.ConsumerOrderPaymentGroupDAO;
import com.youbenben.youbenben.consumerordershippinggroup.ConsumerOrderShippingGroupDAO;


public interface ConsumerOrderDAO extends BaseDAO{

	public SmartList<ConsumerOrder> loadAll();
	public ConsumerOrder load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrder> consumerOrderList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrder present(ConsumerOrder consumerOrder,Map<String,Object> options) throws Exception;
	public ConsumerOrder clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrder save(ConsumerOrder consumerOrder,Map<String,Object> options);
	public SmartList<ConsumerOrder> saveConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options);
	public SmartList<ConsumerOrder> removeConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options);
	public SmartList<ConsumerOrder> findConsumerOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderId, int version) throws Exception;
	public ConsumerOrder disconnectFromAll(String consumerOrderId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderLineItemDAO getConsumerOrderLineItemDAO();
		
	public ConsumerOrderShippingGroupDAO getConsumerOrderShippingGroupDAO();
		
	public ConsumerOrderPaymentGroupDAO getConsumerOrderPaymentGroupDAO();
		
	public ConsumerOrderPriceAdjustmentDAO getConsumerOrderPriceAdjustmentDAO();
		
	public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO();
		
	
 	public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderLineItem(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderShippingGroup(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ConsumerOrder> requestCandidateConsumerOrderForRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ConsumerOrder planToRemoveConsumerOrderLineItemList(ConsumerOrder consumerOrder, String consumerOrderLineItemIds[], Map<String,Object> options)throws Exception;


	//disconnect ConsumerOrder with sku_id in ConsumerOrderLineItem
	public ConsumerOrder planToRemoveConsumerOrderLineItemListWithSkuId(ConsumerOrder consumerOrder, String skuIdId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderLineItemListWithSkuId(String consumerOrderId, String skuIdId, Map<String,Object> options)throws Exception;
	
	public ConsumerOrder planToRemoveConsumerOrderShippingGroupList(ConsumerOrder consumerOrder, String consumerOrderShippingGroupIds[], Map<String,Object> options)throws Exception;


	public ConsumerOrder planToRemoveConsumerOrderPaymentGroupList(ConsumerOrder consumerOrder, String consumerOrderPaymentGroupIds[], Map<String,Object> options)throws Exception;


	public ConsumerOrder planToRemoveConsumerOrderPriceAdjustmentList(ConsumerOrder consumerOrder, String consumerOrderPriceAdjustmentIds[], Map<String,Object> options)throws Exception;


	public ConsumerOrder planToRemoveRetailStoreMemberGiftCardConsumeRecordList(ConsumerOrder consumerOrder, String retailStoreMemberGiftCardConsumeRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect ConsumerOrder with owner in RetailStoreMemberGiftCardConsumeRecord
	public ConsumerOrder planToRemoveRetailStoreMemberGiftCardConsumeRecordListWithOwner(ConsumerOrder consumerOrder, String ownerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreMemberGiftCardConsumeRecordListWithOwner(String consumerOrderId, String ownerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ConsumerOrder> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateConsumerOrder executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<ConsumerOrder> findConsumerOrderByConsumer(String retailStoreMemberId, Map<String,Object> options);
 	public int countConsumerOrderByConsumer(String retailStoreMemberId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByConsumerIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByConsumer(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByConsumer(SmartList<ConsumerOrder> resultList, String retailStoreMemberId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByConfirmation(String supplyOrderConfirmationId, Map<String,Object> options);
 	public int countConsumerOrderByConfirmation(String supplyOrderConfirmationId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByConfirmationIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByConfirmation(String supplyOrderConfirmationId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByConfirmation(SmartList<ConsumerOrder> resultList, String supplyOrderConfirmationId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByApproval(String supplyOrderApprovalId, Map<String,Object> options);
 	public int countConsumerOrderByApproval(String supplyOrderApprovalId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByApprovalIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByApproval(String supplyOrderApprovalId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByApproval(SmartList<ConsumerOrder> resultList, String supplyOrderApprovalId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByProcessing(String supplyOrderProcessingId, Map<String,Object> options);
 	public int countConsumerOrderByProcessing(String supplyOrderProcessingId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByProcessingIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByProcessing(String supplyOrderProcessingId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByProcessing(SmartList<ConsumerOrder> resultList, String supplyOrderProcessingId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByShipment(String supplyOrderShipmentId, Map<String,Object> options);
 	public int countConsumerOrderByShipment(String supplyOrderShipmentId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByShipmentIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByShipment(String supplyOrderShipmentId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByShipment(SmartList<ConsumerOrder> resultList, String supplyOrderShipmentId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByDelivery(String supplyOrderDeliveryId, Map<String,Object> options);
 	public int countConsumerOrderByDelivery(String supplyOrderDeliveryId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByDeliveryIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByDelivery(String supplyOrderDeliveryId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByDelivery(SmartList<ConsumerOrder> resultList, String supplyOrderDeliveryId, Map<String,Object> options);

 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByStore(String retailStoreId, Map<String,Object> options);
 	public int countConsumerOrderByStore(String retailStoreId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderByStoreIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByStore(String retailStoreId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderByStore(SmartList<ConsumerOrder> resultList, String retailStoreId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:ConsumerOrderLineItem的bizOrder的ConsumerOrderLineItemList
	public SmartList<ConsumerOrderLineItem> loadOurConsumerOrderLineItemList(YoubenbenUserContext userContext, List<ConsumerOrder> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ConsumerOrderShippingGroup的bizOrder的ConsumerOrderShippingGroupList
	public SmartList<ConsumerOrderShippingGroup> loadOurConsumerOrderShippingGroupList(YoubenbenUserContext userContext, List<ConsumerOrder> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ConsumerOrderPaymentGroup的bizOrder的ConsumerOrderPaymentGroupList
	public SmartList<ConsumerOrderPaymentGroup> loadOurConsumerOrderPaymentGroupList(YoubenbenUserContext userContext, List<ConsumerOrder> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ConsumerOrderPriceAdjustment的bizOrder的ConsumerOrderPriceAdjustmentList
	public SmartList<ConsumerOrderPriceAdjustment> loadOurConsumerOrderPriceAdjustmentList(YoubenbenUserContext userContext, List<ConsumerOrder> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreMemberGiftCardConsumeRecord的bizOrder的RetailStoreMemberGiftCardConsumeRecordList
	public SmartList<RetailStoreMemberGiftCardConsumeRecord> loadOurRetailStoreMemberGiftCardConsumeRecordList(YoubenbenUserContext userContext, List<ConsumerOrder> us, Map<String,Object> options) throws Exception;
	
}


