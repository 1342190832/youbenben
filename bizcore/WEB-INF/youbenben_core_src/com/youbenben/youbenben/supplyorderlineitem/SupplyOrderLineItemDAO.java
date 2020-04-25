
package com.youbenben.youbenben.supplyorderlineitem;
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


public interface SupplyOrderLineItemDAO extends BaseDAO{

	public SmartList<SupplyOrderLineItem> loadAll();
	public SupplyOrderLineItem load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderLineItem> supplyOrderLineItemList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderLineItem present(SupplyOrderLineItem supplyOrderLineItem,Map<String,Object> options) throws Exception;
	public SupplyOrderLineItem clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderLineItem save(SupplyOrderLineItem supplyOrderLineItem,Map<String,Object> options);
	public SmartList<SupplyOrderLineItem> saveSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList,Map<String,Object> options);
	public SmartList<SupplyOrderLineItem> removeSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList,Map<String,Object> options);
	public SmartList<SupplyOrderLineItem> findSupplyOrderLineItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderLineItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderLineItemWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderLineItemId, int version) throws Exception;
	public SupplyOrderLineItem disconnectFromAll(String supplyOrderLineItemId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<SupplyOrderLineItem> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSupplyOrderLineItem executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<SupplyOrderLineItem> findSupplyOrderLineItemByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public int countSupplyOrderLineItemByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public Map<String, Integer> countSupplyOrderLineItemByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<SupplyOrderLineItem> findSupplyOrderLineItemByBizOrder(String supplyOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeSupplyOrderLineItemByBizOrder(SmartList<SupplyOrderLineItem> resultList, String supplyOrderId, Map<String,Object> options);

 
 
}


