
package com.youbenben.youbenben.retailstoreorderdelivery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.retailstoreorder.RetailStoreOrder;

import com.youbenben.youbenben.retailstoreorder.RetailStoreOrderDAO;


public interface RetailStoreOrderDeliveryDAO extends BaseDAO{

	public SmartList<RetailStoreOrderDelivery> loadAll();
	public RetailStoreOrderDelivery load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderDelivery present(RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String,Object> options) throws Exception;
	public RetailStoreOrderDelivery clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderDelivery save(RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String,Object> options);
	public SmartList<RetailStoreOrderDelivery> saveRetailStoreOrderDeliveryList(SmartList<RetailStoreOrderDelivery> retailStoreOrderDeliveryList,Map<String,Object> options);
	public SmartList<RetailStoreOrderDelivery> removeRetailStoreOrderDeliveryList(SmartList<RetailStoreOrderDelivery> retailStoreOrderDeliveryList,Map<String,Object> options);
	public SmartList<RetailStoreOrderDelivery> findRetailStoreOrderDeliveryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderDeliveryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderDeliveryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderDeliveryId, int version) throws Exception;
	public RetailStoreOrderDelivery disconnectFromAll(String retailStoreOrderDeliveryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	
 	public SmartList<RetailStoreOrderDelivery> requestCandidateRetailStoreOrderDeliveryForRetailStoreOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrderDelivery planToRemoveRetailStoreOrderList(RetailStoreOrderDelivery retailStoreOrderDelivery, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrderDelivery with buyer in RetailStoreOrder
	public RetailStoreOrderDelivery planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderDelivery retailStoreOrderDelivery, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderDeliveryId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderDelivery with seller in RetailStoreOrder
	public RetailStoreOrderDelivery planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderDelivery retailStoreOrderDelivery, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderDeliveryId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderDelivery with confirmation in RetailStoreOrder
	public RetailStoreOrderDelivery planToRemoveRetailStoreOrderListWithConfirmation(RetailStoreOrderDelivery retailStoreOrderDelivery, String confirmationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithConfirmation(String retailStoreOrderDeliveryId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderDelivery with approval in RetailStoreOrder
	public RetailStoreOrderDelivery planToRemoveRetailStoreOrderListWithApproval(RetailStoreOrderDelivery retailStoreOrderDelivery, String approvalId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithApproval(String retailStoreOrderDeliveryId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderDelivery with processing in RetailStoreOrder
	public RetailStoreOrderDelivery planToRemoveRetailStoreOrderListWithProcessing(RetailStoreOrderDelivery retailStoreOrderDelivery, String processingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithProcessing(String retailStoreOrderDeliveryId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderDelivery with picking in RetailStoreOrder
	public RetailStoreOrderDelivery planToRemoveRetailStoreOrderListWithPicking(RetailStoreOrderDelivery retailStoreOrderDelivery, String pickingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithPicking(String retailStoreOrderDeliveryId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderDelivery with shipment in RetailStoreOrder
	public RetailStoreOrderDelivery planToRemoveRetailStoreOrderListWithShipment(RetailStoreOrderDelivery retailStoreOrderDelivery, String shipmentId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithShipment(String retailStoreOrderDeliveryId, String shipmentId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrderDelivery> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreOrderDelivery executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的delivery的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(YoubenbenUserContext userContext, List<RetailStoreOrderDelivery> us, Map<String,Object> options) throws Exception;
	
}


