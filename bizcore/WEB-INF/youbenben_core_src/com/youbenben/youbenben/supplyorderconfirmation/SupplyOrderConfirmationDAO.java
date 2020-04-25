
package com.youbenben.youbenben.supplyorderconfirmation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.supplyorder.SupplyOrder;
import com.youbenben.youbenben.consumerorder.ConsumerOrder;

import com.youbenben.youbenben.consumerorder.ConsumerOrderDAO;
import com.youbenben.youbenben.supplyorder.SupplyOrderDAO;


public interface SupplyOrderConfirmationDAO extends BaseDAO{

	public SmartList<SupplyOrderConfirmation> loadAll();
	public SupplyOrderConfirmation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderConfirmation> supplyOrderConfirmationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderConfirmation present(SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object> options) throws Exception;
	public SupplyOrderConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderConfirmation save(SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object> options);
	public SmartList<SupplyOrderConfirmation> saveSupplyOrderConfirmationList(SmartList<SupplyOrderConfirmation> supplyOrderConfirmationList,Map<String,Object> options);
	public SmartList<SupplyOrderConfirmation> removeSupplyOrderConfirmationList(SmartList<SupplyOrderConfirmation> supplyOrderConfirmationList,Map<String,Object> options);
	public SmartList<SupplyOrderConfirmation> findSupplyOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderConfirmationId, int version) throws Exception;
	public SupplyOrderConfirmation disconnectFromAll(String supplyOrderConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderDAO getConsumerOrderDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	
 	public SmartList<SupplyOrderConfirmation> requestCandidateSupplyOrderConfirmationForConsumerOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrderConfirmation> requestCandidateSupplyOrderConfirmationForSupplyOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrderConfirmation planToRemoveConsumerOrderList(SupplyOrderConfirmation supplyOrderConfirmation, String consumerOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderConfirmation with consumer in ConsumerOrder
	public SupplyOrderConfirmation planToRemoveConsumerOrderListWithConsumer(SupplyOrderConfirmation supplyOrderConfirmation, String consumerId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConsumer(String supplyOrderConfirmationId, String consumerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with approval in ConsumerOrder
	public SupplyOrderConfirmation planToRemoveConsumerOrderListWithApproval(SupplyOrderConfirmation supplyOrderConfirmation, String approvalId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithApproval(String supplyOrderConfirmationId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with processing in ConsumerOrder
	public SupplyOrderConfirmation planToRemoveConsumerOrderListWithProcessing(SupplyOrderConfirmation supplyOrderConfirmation, String processingId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithProcessing(String supplyOrderConfirmationId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with shipment in ConsumerOrder
	public SupplyOrderConfirmation planToRemoveConsumerOrderListWithShipment(SupplyOrderConfirmation supplyOrderConfirmation, String shipmentId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithShipment(String supplyOrderConfirmationId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with delivery in ConsumerOrder
	public SupplyOrderConfirmation planToRemoveConsumerOrderListWithDelivery(SupplyOrderConfirmation supplyOrderConfirmation, String deliveryId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithDelivery(String supplyOrderConfirmationId, String deliveryId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with store in ConsumerOrder
	public SupplyOrderConfirmation planToRemoveConsumerOrderListWithStore(SupplyOrderConfirmation supplyOrderConfirmation, String storeId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithStore(String supplyOrderConfirmationId, String storeId, Map<String,Object> options)throws Exception;
	
	public SupplyOrderConfirmation planToRemoveSupplyOrderList(SupplyOrderConfirmation supplyOrderConfirmation, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderConfirmation with buyer in SupplyOrder
	public SupplyOrderConfirmation planToRemoveSupplyOrderListWithBuyer(SupplyOrderConfirmation supplyOrderConfirmation, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String supplyOrderConfirmationId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with seller in SupplyOrder
	public SupplyOrderConfirmation planToRemoveSupplyOrderListWithSeller(SupplyOrderConfirmation supplyOrderConfirmation, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String supplyOrderConfirmationId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with approval in SupplyOrder
	public SupplyOrderConfirmation planToRemoveSupplyOrderListWithApproval(SupplyOrderConfirmation supplyOrderConfirmation, String approvalId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithApproval(String supplyOrderConfirmationId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with processing in SupplyOrder
	public SupplyOrderConfirmation planToRemoveSupplyOrderListWithProcessing(SupplyOrderConfirmation supplyOrderConfirmation, String processingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithProcessing(String supplyOrderConfirmationId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with picking in SupplyOrder
	public SupplyOrderConfirmation planToRemoveSupplyOrderListWithPicking(SupplyOrderConfirmation supplyOrderConfirmation, String pickingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithPicking(String supplyOrderConfirmationId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with shipment in SupplyOrder
	public SupplyOrderConfirmation planToRemoveSupplyOrderListWithShipment(SupplyOrderConfirmation supplyOrderConfirmation, String shipmentId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithShipment(String supplyOrderConfirmationId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderConfirmation with delivery in SupplyOrder
	public SupplyOrderConfirmation planToRemoveSupplyOrderListWithDelivery(SupplyOrderConfirmation supplyOrderConfirmation, String deliveryId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithDelivery(String supplyOrderConfirmationId, String deliveryId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrderConfirmation> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSupplyOrderConfirmation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:ConsumerOrder的confirmation的ConsumerOrderList
	public SmartList<ConsumerOrder> loadOurConsumerOrderList(YoubenbenUserContext userContext, List<SupplyOrderConfirmation> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrder的confirmation的SupplyOrderList
	public SmartList<SupplyOrder> loadOurSupplyOrderList(YoubenbenUserContext userContext, List<SupplyOrderConfirmation> us, Map<String,Object> options) throws Exception;
	
}


