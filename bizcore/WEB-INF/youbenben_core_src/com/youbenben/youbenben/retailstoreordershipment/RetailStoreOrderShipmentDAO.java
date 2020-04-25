
package com.youbenben.youbenben.retailstoreordershipment;
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


public interface RetailStoreOrderShipmentDAO extends BaseDAO{

	public SmartList<RetailStoreOrderShipment> loadAll();
	public RetailStoreOrderShipment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderShipment> retailStoreOrderShipmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderShipment present(RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object> options) throws Exception;
	public RetailStoreOrderShipment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderShipment save(RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object> options);
	public SmartList<RetailStoreOrderShipment> saveRetailStoreOrderShipmentList(SmartList<RetailStoreOrderShipment> retailStoreOrderShipmentList,Map<String,Object> options);
	public SmartList<RetailStoreOrderShipment> removeRetailStoreOrderShipmentList(SmartList<RetailStoreOrderShipment> retailStoreOrderShipmentList,Map<String,Object> options);
	public SmartList<RetailStoreOrderShipment> findRetailStoreOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderShipmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderShipmentId, int version) throws Exception;
	public RetailStoreOrderShipment disconnectFromAll(String retailStoreOrderShipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	
 	public SmartList<RetailStoreOrderShipment> requestCandidateRetailStoreOrderShipmentForRetailStoreOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderList(RetailStoreOrderShipment retailStoreOrderShipment, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrderShipment with buyer in RetailStoreOrder
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderShipment retailStoreOrderShipment, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderShipmentId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderShipment with seller in RetailStoreOrder
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderShipment retailStoreOrderShipment, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderShipmentId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderShipment with confirmation in RetailStoreOrder
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderListWithConfirmation(RetailStoreOrderShipment retailStoreOrderShipment, String confirmationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithConfirmation(String retailStoreOrderShipmentId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderShipment with approval in RetailStoreOrder
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderListWithApproval(RetailStoreOrderShipment retailStoreOrderShipment, String approvalId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithApproval(String retailStoreOrderShipmentId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderShipment with processing in RetailStoreOrder
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderListWithProcessing(RetailStoreOrderShipment retailStoreOrderShipment, String processingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithProcessing(String retailStoreOrderShipmentId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderShipment with picking in RetailStoreOrder
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderListWithPicking(RetailStoreOrderShipment retailStoreOrderShipment, String pickingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithPicking(String retailStoreOrderShipmentId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderShipment with delivery in RetailStoreOrder
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderListWithDelivery(RetailStoreOrderShipment retailStoreOrderShipment, String deliveryId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithDelivery(String retailStoreOrderShipmentId, String deliveryId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrderShipment> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreOrderShipment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的shipment的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(YoubenbenUserContext userContext, List<RetailStoreOrderShipment> us, Map<String,Object> options) throws Exception;
	
}


