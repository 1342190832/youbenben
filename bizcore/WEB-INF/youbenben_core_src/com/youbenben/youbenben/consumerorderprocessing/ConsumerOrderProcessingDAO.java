
package com.youbenben.youbenben.consumerorderprocessing;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;




public interface ConsumerOrderProcessingDAO extends BaseDAO{

	public SmartList<ConsumerOrderProcessing> loadAll();
	public ConsumerOrderProcessing load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderProcessing> consumerOrderProcessingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderProcessing present(ConsumerOrderProcessing consumerOrderProcessing,Map<String,Object> options) throws Exception;
	public ConsumerOrderProcessing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderProcessing save(ConsumerOrderProcessing consumerOrderProcessing,Map<String,Object> options);
	public SmartList<ConsumerOrderProcessing> saveConsumerOrderProcessingList(SmartList<ConsumerOrderProcessing> consumerOrderProcessingList,Map<String,Object> options);
	public SmartList<ConsumerOrderProcessing> removeConsumerOrderProcessingList(SmartList<ConsumerOrderProcessing> consumerOrderProcessingList,Map<String,Object> options);
	public SmartList<ConsumerOrderProcessing> findConsumerOrderProcessingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderProcessingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderProcessingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderProcessingId, int version) throws Exception;
	public ConsumerOrderProcessing disconnectFromAll(String consumerOrderProcessingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderProcessing> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateConsumerOrderProcessing executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

}


