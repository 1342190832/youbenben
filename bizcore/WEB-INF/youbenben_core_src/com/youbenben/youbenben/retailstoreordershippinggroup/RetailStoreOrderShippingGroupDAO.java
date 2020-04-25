
package com.youbenben.youbenben.retailstoreordershippinggroup;
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


public interface RetailStoreOrderShippingGroupDAO extends BaseDAO{

	public SmartList<RetailStoreOrderShippingGroup> loadAll();
	public RetailStoreOrderShippingGroup load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderShippingGroup present(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String,Object> options) throws Exception;
	public RetailStoreOrderShippingGroup clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderShippingGroup save(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String,Object> options);
	public SmartList<RetailStoreOrderShippingGroup> saveRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,Map<String,Object> options);
	public SmartList<RetailStoreOrderShippingGroup> removeRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,Map<String,Object> options);
	public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderShippingGroupWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderShippingGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderShippingGroupId, int version) throws Exception;
	public RetailStoreOrderShippingGroup disconnectFromAll(String retailStoreOrderShippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<RetailStoreOrderShippingGroup> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreOrderShippingGroup executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public int countRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderShippingGroupByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderShippingGroupByBizOrder(SmartList<RetailStoreOrderShippingGroup> resultList, String retailStoreOrderId, Map<String,Object> options);

 
 
}


