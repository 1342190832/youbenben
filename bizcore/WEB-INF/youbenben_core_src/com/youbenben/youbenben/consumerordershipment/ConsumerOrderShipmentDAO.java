
package com.youbenben.youbenben.consumerordershipment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;




public interface ConsumerOrderShipmentDAO extends BaseDAO{

	public SmartList<ConsumerOrderShipment> loadAll();
	public ConsumerOrderShipment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderShipment> consumerOrderShipmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderShipment present(ConsumerOrderShipment consumerOrderShipment,Map<String,Object> options) throws Exception;
	public ConsumerOrderShipment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderShipment save(ConsumerOrderShipment consumerOrderShipment,Map<String,Object> options);
	public SmartList<ConsumerOrderShipment> saveConsumerOrderShipmentList(SmartList<ConsumerOrderShipment> consumerOrderShipmentList,Map<String,Object> options);
	public SmartList<ConsumerOrderShipment> removeConsumerOrderShipmentList(SmartList<ConsumerOrderShipment> consumerOrderShipmentList,Map<String,Object> options);
	public SmartList<ConsumerOrderShipment> findConsumerOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderShipmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderShipmentId, int version) throws Exception;
	public ConsumerOrderShipment disconnectFromAll(String consumerOrderShipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderShipment> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateConsumerOrderShipment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

}


