
package com.youbenben.youbenben.retailstoreorderconfirmation;
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


public interface RetailStoreOrderConfirmationDAO extends BaseDAO{

	public SmartList<RetailStoreOrderConfirmation> loadAll();
	public RetailStoreOrderConfirmation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderConfirmation present(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object> options) throws Exception;
	public RetailStoreOrderConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderConfirmation save(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object> options);
	public SmartList<RetailStoreOrderConfirmation> saveRetailStoreOrderConfirmationList(SmartList<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList,Map<String,Object> options);
	public SmartList<RetailStoreOrderConfirmation> removeRetailStoreOrderConfirmationList(SmartList<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList,Map<String,Object> options);
	public SmartList<RetailStoreOrderConfirmation> findRetailStoreOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderConfirmationId, int version) throws Exception;
	public RetailStoreOrderConfirmation disconnectFromAll(String retailStoreOrderConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	
 	public SmartList<RetailStoreOrderConfirmation> requestCandidateRetailStoreOrderConfirmationForRetailStoreOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderList(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOrderConfirmation with buyer in RetailStoreOrder
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderConfirmationId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderConfirmation with seller in RetailStoreOrder
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderConfirmationId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderConfirmation with approval in RetailStoreOrder
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderListWithApproval(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String approvalId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithApproval(String retailStoreOrderConfirmationId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderConfirmation with processing in RetailStoreOrder
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderListWithProcessing(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String processingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithProcessing(String retailStoreOrderConfirmationId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderConfirmation with picking in RetailStoreOrder
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderListWithPicking(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String pickingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithPicking(String retailStoreOrderConfirmationId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderConfirmation with shipment in RetailStoreOrder
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderListWithShipment(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String shipmentId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithShipment(String retailStoreOrderConfirmationId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOrderConfirmation with delivery in RetailStoreOrder
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderListWithDelivery(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String deliveryId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithDelivery(String retailStoreOrderConfirmationId, String deliveryId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOrderConfirmation> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreOrderConfirmation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的confirmation的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(YoubenbenUserContext userContext, List<RetailStoreOrderConfirmation> us, Map<String,Object> options) throws Exception;
	
}


