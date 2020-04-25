
package com.youbenben.youbenben.retailstoreorderprocessing;
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


public interface RetailStoreOrderProcessingDAO extends BaseDAO{

	public SmartList<RetailStoreOrderProcessing> loadAll();
	public RetailStoreOrderProcessing load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderProcessing present(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object> options) throws Exception;
	public RetailStoreOrderProcessing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderProcessing save(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object> options);
	public SmartList<RetailStoreOrderProcessing> saveRetailStoreOrderProcessingList(SmartList<RetailStoreOrderProcessing> retailStoreOrderProcessingList,Map<String,Object> options);
	public SmartList<RetailStoreOrderProcessing> removeRetailStoreOrderProcessingList(SmartList<RetailStoreOrderProcessing> retailStoreOrderProcessingList,Map<String,Object> options);
	public SmartList<RetailStoreOrderProcessing> findRetailStoreOrderProcessingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderProcessingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderProcessingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderProcessingId, int version) throws Exception;
	public RetailStoreOrderProcessing disconnectFromAll(String retailStoreOrderProcessingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	
 	public SmartList<RetailStoreOrderProcessing> requestCandidateRetailStoreOrderProcessingForRetailStoreOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderList(RetailStoreOrderProcessing retailStoreOrderProcessing, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrderProcessing with buyer in RetailStoreOrder
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderProcessing retailStoreOrderProcessing, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderProcessingId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderProcessing with seller in RetailStoreOrder
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderProcessing retailStoreOrderProcessing, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderProcessingId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderProcessing with confirmation in RetailStoreOrder
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderListWithConfirmation(RetailStoreOrderProcessing retailStoreOrderProcessing, String confirmationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithConfirmation(String retailStoreOrderProcessingId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderProcessing with approval in RetailStoreOrder
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderListWithApproval(RetailStoreOrderProcessing retailStoreOrderProcessing, String approvalId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithApproval(String retailStoreOrderProcessingId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderProcessing with picking in RetailStoreOrder
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderListWithPicking(RetailStoreOrderProcessing retailStoreOrderProcessing, String pickingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithPicking(String retailStoreOrderProcessingId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderProcessing with shipment in RetailStoreOrder
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderListWithShipment(RetailStoreOrderProcessing retailStoreOrderProcessing, String shipmentId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithShipment(String retailStoreOrderProcessingId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderProcessing with delivery in RetailStoreOrder
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderListWithDelivery(RetailStoreOrderProcessing retailStoreOrderProcessing, String deliveryId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithDelivery(String retailStoreOrderProcessingId, String deliveryId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrderProcessing> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreOrderProcessing executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的processing的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(YoubenbenUserContext userContext, List<RetailStoreOrderProcessing> us, Map<String,Object> options) throws Exception;
	
}


