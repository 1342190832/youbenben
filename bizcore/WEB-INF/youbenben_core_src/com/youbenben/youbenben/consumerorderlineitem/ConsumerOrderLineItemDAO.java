
package com.youbenben.youbenben.consumerorderlineitem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.consumerorder.ConsumerOrder;

import com.youbenben.youbenben.consumerorder.ConsumerOrderDAO;


public interface ConsumerOrderLineItemDAO extends BaseDAO{

	public SmartList<ConsumerOrderLineItem> loadAll();
	public ConsumerOrderLineItem load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderLineItem> consumerOrderLineItemList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderLineItem present(ConsumerOrderLineItem consumerOrderLineItem,Map<String,Object> options) throws Exception;
	public ConsumerOrderLineItem clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderLineItem save(ConsumerOrderLineItem consumerOrderLineItem,Map<String,Object> options);
	public SmartList<ConsumerOrderLineItem> saveConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList,Map<String,Object> options);
	public SmartList<ConsumerOrderLineItem> removeConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList,Map<String,Object> options);
	public SmartList<ConsumerOrderLineItem> findConsumerOrderLineItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderLineItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderLineItemWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderLineItemId, int version) throws Exception;
	public ConsumerOrderLineItem disconnectFromAll(String consumerOrderLineItemId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderLineItem> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateConsumerOrderLineItem executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<ConsumerOrderLineItem> findConsumerOrderLineItemByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public int countConsumerOrderLineItemByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public Map<String, Integer> countConsumerOrderLineItemByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<ConsumerOrderLineItem> findConsumerOrderLineItemByBizOrder(String consumerOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeConsumerOrderLineItemByBizOrder(SmartList<ConsumerOrderLineItem> resultList, String consumerOrderId, Map<String,Object> options);

 
 
}


