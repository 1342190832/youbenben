
package com.youbenben.youbenben.consumerorderconfirmation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;




public interface ConsumerOrderConfirmationDAO extends BaseDAO{

	public SmartList<ConsumerOrderConfirmation> loadAll();
	public ConsumerOrderConfirmation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderConfirmation> consumerOrderConfirmationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderConfirmation present(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object> options) throws Exception;
	public ConsumerOrderConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderConfirmation save(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object> options);
	public SmartList<ConsumerOrderConfirmation> saveConsumerOrderConfirmationList(SmartList<ConsumerOrderConfirmation> consumerOrderConfirmationList,Map<String,Object> options);
	public SmartList<ConsumerOrderConfirmation> removeConsumerOrderConfirmationList(SmartList<ConsumerOrderConfirmation> consumerOrderConfirmationList,Map<String,Object> options);
	public SmartList<ConsumerOrderConfirmation> findConsumerOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderConfirmationId, int version) throws Exception;
	public ConsumerOrderConfirmation disconnectFromAll(String consumerOrderConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderConfirmation> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateConsumerOrderConfirmation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

}


