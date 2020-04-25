
package com.youbenben.youbenben.truckdriver;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.transportfleet.TransportFleet;
import com.youbenben.youbenben.transporttask.TransportTask;

import com.youbenben.youbenben.transporttask.TransportTaskDAO;
import com.youbenben.youbenben.transportfleet.TransportFleetDAO;


public interface TruckDriverDAO extends BaseDAO{

	public SmartList<TruckDriver> loadAll();
	public TruckDriver load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TruckDriver> truckDriverList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TruckDriver present(TruckDriver truckDriver,Map<String,Object> options) throws Exception;
	public TruckDriver clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TruckDriver save(TruckDriver truckDriver,Map<String,Object> options);
	public SmartList<TruckDriver> saveTruckDriverList(SmartList<TruckDriver> truckDriverList,Map<String,Object> options);
	public SmartList<TruckDriver> removeTruckDriverList(SmartList<TruckDriver> truckDriverList,Map<String,Object> options);
	public SmartList<TruckDriver> findTruckDriverWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTruckDriverWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTruckDriverWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String truckDriverId, int version) throws Exception;
	public TruckDriver disconnectFromAll(String truckDriverId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TransportTaskDAO getTransportTaskDAO();
		
	
 	public SmartList<TruckDriver> requestCandidateTruckDriverForTransportTask(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TruckDriver planToRemoveTransportTaskList(TruckDriver truckDriver, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect TruckDriver with end in TransportTask
	public TruckDriver planToRemoveTransportTaskListWithEnd(TruckDriver truckDriver, String endId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithEnd(String truckDriverId, String endId, Map<String,Object> options)throws Exception;
	
	//disconnect TruckDriver with truck in TransportTask
	public TruckDriver planToRemoveTransportTaskListWithTruck(TruckDriver truckDriver, String truckId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithTruck(String truckDriverId, String truckId, Map<String,Object> options)throws Exception;
	
	//disconnect TruckDriver with belongs_to in TransportTask
	public TruckDriver planToRemoveTransportTaskListWithBelongsTo(TruckDriver truckDriver, String belongsToId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithBelongsTo(String truckDriverId, String belongsToId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<TruckDriver> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateTruckDriver executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<TruckDriver> findTruckDriverByBelongsTo(String transportFleetId, Map<String,Object> options);
 	public int countTruckDriverByBelongsTo(String transportFleetId, Map<String,Object> options);
 	public Map<String, Integer> countTruckDriverByBelongsToIds(String[] ids, Map<String,Object> options);
 	public SmartList<TruckDriver> findTruckDriverByBelongsTo(String transportFleetId, int start, int count, Map<String,Object> options);
 	public void analyzeTruckDriverByBelongsTo(SmartList<TruckDriver> resultList, String transportFleetId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:TransportTask的driver的TransportTaskList
	public SmartList<TransportTask> loadOurTransportTaskList(YoubenbenUserContext userContext, List<TruckDriver> us, Map<String,Object> options) throws Exception;
	
}


