
package com.youbenben.youbenben.retailstoreorderapproval;
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


public interface RetailStoreOrderApprovalDAO extends BaseDAO{

	public SmartList<RetailStoreOrderApproval> loadAll();
	public RetailStoreOrderApproval load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderApproval> retailStoreOrderApprovalList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderApproval present(RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object> options) throws Exception;
	public RetailStoreOrderApproval clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderApproval save(RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object> options);
	public SmartList<RetailStoreOrderApproval> saveRetailStoreOrderApprovalList(SmartList<RetailStoreOrderApproval> retailStoreOrderApprovalList,Map<String,Object> options);
	public SmartList<RetailStoreOrderApproval> removeRetailStoreOrderApprovalList(SmartList<RetailStoreOrderApproval> retailStoreOrderApprovalList,Map<String,Object> options);
	public SmartList<RetailStoreOrderApproval> findRetailStoreOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderApprovalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderApprovalId, int version) throws Exception;
	public RetailStoreOrderApproval disconnectFromAll(String retailStoreOrderApprovalId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	
 	public SmartList<RetailStoreOrderApproval> requestCandidateRetailStoreOrderApprovalForRetailStoreOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderList(RetailStoreOrderApproval retailStoreOrderApproval, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrderApproval with buyer in RetailStoreOrder
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderApproval retailStoreOrderApproval, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderApprovalId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderApproval with seller in RetailStoreOrder
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderApproval retailStoreOrderApproval, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderApprovalId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderApproval with confirmation in RetailStoreOrder
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderListWithConfirmation(RetailStoreOrderApproval retailStoreOrderApproval, String confirmationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithConfirmation(String retailStoreOrderApprovalId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderApproval with processing in RetailStoreOrder
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderListWithProcessing(RetailStoreOrderApproval retailStoreOrderApproval, String processingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithProcessing(String retailStoreOrderApprovalId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderApproval with picking in RetailStoreOrder
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderListWithPicking(RetailStoreOrderApproval retailStoreOrderApproval, String pickingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithPicking(String retailStoreOrderApprovalId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderApproval with shipment in RetailStoreOrder
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderListWithShipment(RetailStoreOrderApproval retailStoreOrderApproval, String shipmentId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithShipment(String retailStoreOrderApprovalId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderApproval with delivery in RetailStoreOrder
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderListWithDelivery(RetailStoreOrderApproval retailStoreOrderApproval, String deliveryId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithDelivery(String retailStoreOrderApprovalId, String deliveryId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrderApproval> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreOrderApproval executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的approval的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(YoubenbenUserContext userContext, List<RetailStoreOrderApproval> us, Map<String,Object> options) throws Exception;
	
}


