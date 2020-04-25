
package com.youbenben.youbenben.consumerorderdelivery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;




public interface ConsumerOrderDeliveryDAO extends BaseDAO{

	public SmartList<ConsumerOrderDelivery> loadAll();
	public ConsumerOrderDelivery load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderDelivery> consumerOrderDeliveryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderDelivery present(ConsumerOrderDelivery consumerOrderDelivery,Map<String,Object> options) throws Exception;
	public ConsumerOrderDelivery clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderDelivery save(ConsumerOrderDelivery consumerOrderDelivery,Map<String,Object> options);
	public SmartList<ConsumerOrderDelivery> saveConsumerOrderDeliveryList(SmartList<ConsumerOrderDelivery> consumerOrderDeliveryList,Map<String,Object> options);
	public SmartList<ConsumerOrderDelivery> removeConsumerOrderDeliveryList(SmartList<ConsumerOrderDelivery> consumerOrderDeliveryList,Map<String,Object> options);
	public SmartList<ConsumerOrderDelivery> findConsumerOrderDeliveryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderDeliveryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderDeliveryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderDeliveryId, int version) throws Exception;
	public ConsumerOrderDelivery disconnectFromAll(String consumerOrderDeliveryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderDelivery> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateConsumerOrderDelivery executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

}


