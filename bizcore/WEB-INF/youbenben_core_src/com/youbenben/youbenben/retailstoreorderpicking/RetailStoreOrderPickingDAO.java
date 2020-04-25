
package com.youbenben.youbenben.retailstoreorderpicking;
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


public interface RetailStoreOrderPickingDAO extends BaseDAO{

	public SmartList<RetailStoreOrderPicking> loadAll();
	public RetailStoreOrderPicking load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderPicking> retailStoreOrderPickingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderPicking present(RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object> options) throws Exception;
	public RetailStoreOrderPicking clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderPicking save(RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object> options);
	public SmartList<RetailStoreOrderPicking> saveRetailStoreOrderPickingList(SmartList<RetailStoreOrderPicking> retailStoreOrderPickingList,Map<String,Object> options);
	public SmartList<RetailStoreOrderPicking> removeRetailStoreOrderPickingList(SmartList<RetailStoreOrderPicking> retailStoreOrderPickingList,Map<String,Object> options);
	public SmartList<RetailStoreOrderPicking> findRetailStoreOrderPickingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderPickingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderPickingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderPickingId, int version) throws Exception;
	public RetailStoreOrderPicking disconnectFromAll(String retailStoreOrderPickingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	
 	public SmartList<RetailStoreOrderPicking> requestCandidateRetailStoreOrderPickingForRetailStoreOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderList(RetailStoreOrderPicking retailStoreOrderPicking, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrderPicking with buyer in RetailStoreOrder
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderPicking retailStoreOrderPicking, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderPickingId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderPicking with seller in RetailStoreOrder
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderPicking retailStoreOrderPicking, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderPickingId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderPicking with confirmation in RetailStoreOrder
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderListWithConfirmation(RetailStoreOrderPicking retailStoreOrderPicking, String confirmationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithConfirmation(String retailStoreOrderPickingId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderPicking with approval in RetailStoreOrder
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderListWithApproval(RetailStoreOrderPicking retailStoreOrderPicking, String approvalId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithApproval(String retailStoreOrderPickingId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderPicking with processing in RetailStoreOrder
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderListWithProcessing(RetailStoreOrderPicking retailStoreOrderPicking, String processingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithProcessing(String retailStoreOrderPickingId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderPicking with shipment in RetailStoreOrder
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderListWithShipment(RetailStoreOrderPicking retailStoreOrderPicking, String shipmentId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithShipment(String retailStoreOrderPickingId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderPicking with delivery in RetailStoreOrder
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderListWithDelivery(RetailStoreOrderPicking retailStoreOrderPicking, String deliveryId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithDelivery(String retailStoreOrderPickingId, String deliveryId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrderPicking> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreOrderPicking executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的picking的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(YoubenbenUserContext userContext, List<RetailStoreOrderPicking> us, Map<String,Object> options) throws Exception;
	
}


