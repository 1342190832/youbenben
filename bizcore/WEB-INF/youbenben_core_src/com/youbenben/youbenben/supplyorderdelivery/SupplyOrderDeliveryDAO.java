
package com.youbenben.youbenben.supplyorderdelivery;
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


public interface SupplyOrderDeliveryDAO extends BaseDAO{

	public SmartList<SupplyOrderDelivery> loadAll();
	public SupplyOrderDelivery load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderDelivery> supplyOrderDeliveryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderDelivery present(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options) throws Exception;
	public SupplyOrderDelivery clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderDelivery save(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options);
	public SmartList<SupplyOrderDelivery> saveSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options);
	public SmartList<SupplyOrderDelivery> removeSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options);
	public SmartList<SupplyOrderDelivery> findSupplyOrderDeliveryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderDeliveryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderDeliveryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderDeliveryId, int version) throws Exception;
	public SupplyOrderDelivery disconnectFromAll(String supplyOrderDeliveryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderDAO getConsumerOrderDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	
 	public SmartList<SupplyOrderDelivery> requestCandidateSupplyOrderDeliveryForConsumerOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrderDelivery> requestCandidateSupplyOrderDeliveryForSupplyOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrderDelivery planToRemoveConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, String consumerOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderDelivery with consumer in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithConsumer(SupplyOrderDelivery supplyOrderDelivery, String consumerId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConsumer(String supplyOrderDeliveryId, String consumerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with confirmation in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithConfirmation(SupplyOrderDelivery supplyOrderDelivery, String confirmationId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConfirmation(String supplyOrderDeliveryId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with approval in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithApproval(SupplyOrderDelivery supplyOrderDelivery, String approvalId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithApproval(String supplyOrderDeliveryId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with processing in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithProcessing(SupplyOrderDelivery supplyOrderDelivery, String processingId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithProcessing(String supplyOrderDeliveryId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with shipment in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithShipment(SupplyOrderDelivery supplyOrderDelivery, String shipmentId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithShipment(String supplyOrderDeliveryId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with store in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithStore(SupplyOrderDelivery supplyOrderDelivery, String storeId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithStore(String supplyOrderDeliveryId, String storeId, Map<String,Object> options)throws Exception;
	
	public SupplyOrderDelivery planToRemoveSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderDelivery with buyer in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithBuyer(SupplyOrderDelivery supplyOrderDelivery, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String supplyOrderDeliveryId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with seller in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithSeller(SupplyOrderDelivery supplyOrderDelivery, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String supplyOrderDeliveryId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with confirmation in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithConfirmation(SupplyOrderDelivery supplyOrderDelivery, String confirmationId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithConfirmation(String supplyOrderDeliveryId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with approval in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithApproval(SupplyOrderDelivery supplyOrderDelivery, String approvalId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithApproval(String supplyOrderDeliveryId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with processing in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithProcessing(SupplyOrderDelivery supplyOrderDelivery, String processingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithProcessing(String supplyOrderDeliveryId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with picking in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithPicking(SupplyOrderDelivery supplyOrderDelivery, String pickingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithPicking(String supplyOrderDeliveryId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderDelivery with shipment in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithShipment(SupplyOrderDelivery supplyOrderDelivery, String shipmentId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithShipment(String supplyOrderDeliveryId, String shipmentId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrderDelivery> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSupplyOrderDelivery executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:ConsumerOrder的delivery的ConsumerOrderList
	public SmartList<ConsumerOrder> loadOurConsumerOrderList(YoubenbenUserContext userContext, List<SupplyOrderDelivery> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrder的delivery的SupplyOrderList
	public SmartList<SupplyOrder> loadOurSupplyOrderList(YoubenbenUserContext userContext, List<SupplyOrderDelivery> us, Map<String,Object> options) throws Exception;
	
}


