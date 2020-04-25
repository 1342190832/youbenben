
package com.doublechaintech.retailscm.supplyordershipment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;


public interface SupplyOrderShipmentDAO extends BaseDAO{

	public SmartList<SupplyOrderShipment> loadAll();
	public SupplyOrderShipment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderShipment> supplyOrderShipmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderShipment present(SupplyOrderShipment supplyOrderShipment,Map<String,Object> options) throws Exception;
	public SupplyOrderShipment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderShipment save(SupplyOrderShipment supplyOrderShipment,Map<String,Object> options);
	public SmartList<SupplyOrderShipment> saveSupplyOrderShipmentList(SmartList<SupplyOrderShipment> supplyOrderShipmentList,Map<String,Object> options);
	public SmartList<SupplyOrderShipment> removeSupplyOrderShipmentList(SmartList<SupplyOrderShipment> supplyOrderShipmentList,Map<String,Object> options);
	public SmartList<SupplyOrderShipment> findSupplyOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderShipmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderShipmentId, int version) throws Exception;
	public SupplyOrderShipment disconnectFromAll(String supplyOrderShipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderDAO getConsumerOrderDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	
 	public SmartList<SupplyOrderShipment> requestCandidateSupplyOrderShipmentForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrderShipment> requestCandidateSupplyOrderShipmentForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrderShipment planToRemoveConsumerOrderList(SupplyOrderShipment supplyOrderShipment, String consumerOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderShipment with consumer in ConsumerOrder
	public SupplyOrderShipment planToRemoveConsumerOrderListWithConsumer(SupplyOrderShipment supplyOrderShipment, String consumerId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConsumer(String supplyOrderShipmentId, String consumerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with confirmation in ConsumerOrder
	public SupplyOrderShipment planToRemoveConsumerOrderListWithConfirmation(SupplyOrderShipment supplyOrderShipment, String confirmationId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConfirmation(String supplyOrderShipmentId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with approval in ConsumerOrder
	public SupplyOrderShipment planToRemoveConsumerOrderListWithApproval(SupplyOrderShipment supplyOrderShipment, String approvalId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithApproval(String supplyOrderShipmentId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with processing in ConsumerOrder
	public SupplyOrderShipment planToRemoveConsumerOrderListWithProcessing(SupplyOrderShipment supplyOrderShipment, String processingId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithProcessing(String supplyOrderShipmentId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with delivery in ConsumerOrder
	public SupplyOrderShipment planToRemoveConsumerOrderListWithDelivery(SupplyOrderShipment supplyOrderShipment, String deliveryId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithDelivery(String supplyOrderShipmentId, String deliveryId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with store in ConsumerOrder
	public SupplyOrderShipment planToRemoveConsumerOrderListWithStore(SupplyOrderShipment supplyOrderShipment, String storeId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithStore(String supplyOrderShipmentId, String storeId, Map<String,Object> options)throws Exception;
	
	public SupplyOrderShipment planToRemoveSupplyOrderList(SupplyOrderShipment supplyOrderShipment, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderShipment with buyer in SupplyOrder
	public SupplyOrderShipment planToRemoveSupplyOrderListWithBuyer(SupplyOrderShipment supplyOrderShipment, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String supplyOrderShipmentId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with seller in SupplyOrder
	public SupplyOrderShipment planToRemoveSupplyOrderListWithSeller(SupplyOrderShipment supplyOrderShipment, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String supplyOrderShipmentId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with confirmation in SupplyOrder
	public SupplyOrderShipment planToRemoveSupplyOrderListWithConfirmation(SupplyOrderShipment supplyOrderShipment, String confirmationId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithConfirmation(String supplyOrderShipmentId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with approval in SupplyOrder
	public SupplyOrderShipment planToRemoveSupplyOrderListWithApproval(SupplyOrderShipment supplyOrderShipment, String approvalId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithApproval(String supplyOrderShipmentId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with processing in SupplyOrder
	public SupplyOrderShipment planToRemoveSupplyOrderListWithProcessing(SupplyOrderShipment supplyOrderShipment, String processingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithProcessing(String supplyOrderShipmentId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with picking in SupplyOrder
	public SupplyOrderShipment planToRemoveSupplyOrderListWithPicking(SupplyOrderShipment supplyOrderShipment, String pickingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithPicking(String supplyOrderShipmentId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderShipment with delivery in SupplyOrder
	public SupplyOrderShipment planToRemoveSupplyOrderListWithDelivery(SupplyOrderShipment supplyOrderShipment, String deliveryId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithDelivery(String supplyOrderShipmentId, String deliveryId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrderShipment> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSupplyOrderShipment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:ConsumerOrder的shipment的ConsumerOrderList
	public SmartList<ConsumerOrder> loadOurConsumerOrderList(RetailscmUserContext userContext, List<SupplyOrderShipment> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrder的shipment的SupplyOrderList
	public SmartList<SupplyOrder> loadOurSupplyOrderList(RetailscmUserContext userContext, List<SupplyOrderShipment> us, Map<String,Object> options) throws Exception;
	
}


