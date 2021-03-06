
package com.youbenben.youbenben.supplyorderpicking;
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

import com.youbenben.youbenben.supplyorder.SupplyOrderDAO;


public interface SupplyOrderPickingDAO extends BaseDAO{

	public SmartList<SupplyOrderPicking> loadAll();
	public SupplyOrderPicking load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderPicking> supplyOrderPickingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderPicking present(SupplyOrderPicking supplyOrderPicking,Map<String,Object> options) throws Exception;
	public SupplyOrderPicking clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderPicking save(SupplyOrderPicking supplyOrderPicking,Map<String,Object> options);
	public SmartList<SupplyOrderPicking> saveSupplyOrderPickingList(SmartList<SupplyOrderPicking> supplyOrderPickingList,Map<String,Object> options);
	public SmartList<SupplyOrderPicking> removeSupplyOrderPickingList(SmartList<SupplyOrderPicking> supplyOrderPickingList,Map<String,Object> options);
	public SmartList<SupplyOrderPicking> findSupplyOrderPickingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderPickingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderPickingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderPickingId, int version) throws Exception;
	public SupplyOrderPicking disconnectFromAll(String supplyOrderPickingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public SupplyOrderDAO getSupplyOrderDAO();
		
	
 	public SmartList<SupplyOrderPicking> requestCandidateSupplyOrderPickingForSupplyOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrderPicking planToRemoveSupplyOrderList(SupplyOrderPicking supplyOrderPicking, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderPicking with buyer in SupplyOrder
	public SupplyOrderPicking planToRemoveSupplyOrderListWithBuyer(SupplyOrderPicking supplyOrderPicking, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String supplyOrderPickingId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderPicking with seller in SupplyOrder
	public SupplyOrderPicking planToRemoveSupplyOrderListWithSeller(SupplyOrderPicking supplyOrderPicking, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String supplyOrderPickingId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderPicking with confirmation in SupplyOrder
	public SupplyOrderPicking planToRemoveSupplyOrderListWithConfirmation(SupplyOrderPicking supplyOrderPicking, String confirmationId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithConfirmation(String supplyOrderPickingId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderPicking with approval in SupplyOrder
	public SupplyOrderPicking planToRemoveSupplyOrderListWithApproval(SupplyOrderPicking supplyOrderPicking, String approvalId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithApproval(String supplyOrderPickingId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderPicking with processing in SupplyOrder
	public SupplyOrderPicking planToRemoveSupplyOrderListWithProcessing(SupplyOrderPicking supplyOrderPicking, String processingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithProcessing(String supplyOrderPickingId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderPicking with shipment in SupplyOrder
	public SupplyOrderPicking planToRemoveSupplyOrderListWithShipment(SupplyOrderPicking supplyOrderPicking, String shipmentId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithShipment(String supplyOrderPickingId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderPicking with delivery in SupplyOrder
	public SupplyOrderPicking planToRemoveSupplyOrderListWithDelivery(SupplyOrderPicking supplyOrderPicking, String deliveryId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithDelivery(String supplyOrderPickingId, String deliveryId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrderPicking> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSupplyOrderPicking executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:SupplyOrder的picking的SupplyOrderList
	public SmartList<SupplyOrder> loadOurSupplyOrderList(YoubenbenUserContext userContext, List<SupplyOrderPicking> us, Map<String,Object> options) throws Exception;
	
}


