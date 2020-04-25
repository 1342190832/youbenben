
package com.youbenben.youbenben.consumerorderapproval;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;




public interface ConsumerOrderApprovalDAO extends BaseDAO{

	public SmartList<ConsumerOrderApproval> loadAll();
	public ConsumerOrderApproval load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderApproval> consumerOrderApprovalList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderApproval present(ConsumerOrderApproval consumerOrderApproval,Map<String,Object> options) throws Exception;
	public ConsumerOrderApproval clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderApproval save(ConsumerOrderApproval consumerOrderApproval,Map<String,Object> options);
	public SmartList<ConsumerOrderApproval> saveConsumerOrderApprovalList(SmartList<ConsumerOrderApproval> consumerOrderApprovalList,Map<String,Object> options);
	public SmartList<ConsumerOrderApproval> removeConsumerOrderApprovalList(SmartList<ConsumerOrderApproval> consumerOrderApprovalList,Map<String,Object> options);
	public SmartList<ConsumerOrderApproval> findConsumerOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderApprovalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderApprovalId, int version) throws Exception;
	public ConsumerOrderApproval disconnectFromAll(String consumerOrderApprovalId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderApproval> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateConsumerOrderApproval executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

}


