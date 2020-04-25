
package com.youbenben.youbenben.eventattendance;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.potentialcustomer.PotentialCustomer;
import com.youbenben.youbenben.cityevent.CityEvent;

import com.youbenben.youbenben.cityevent.CityEventDAO;
import com.youbenben.youbenben.potentialcustomer.PotentialCustomerDAO;


public interface EventAttendanceDAO extends BaseDAO{

	public SmartList<EventAttendance> loadAll();
	public EventAttendance load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EventAttendance> eventAttendanceList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EventAttendance present(EventAttendance eventAttendance,Map<String,Object> options) throws Exception;
	public EventAttendance clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EventAttendance save(EventAttendance eventAttendance,Map<String,Object> options);
	public SmartList<EventAttendance> saveEventAttendanceList(SmartList<EventAttendance> eventAttendanceList,Map<String,Object> options);
	public SmartList<EventAttendance> removeEventAttendanceList(SmartList<EventAttendance> eventAttendanceList,Map<String,Object> options);
	public SmartList<EventAttendance> findEventAttendanceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEventAttendanceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEventAttendanceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String eventAttendanceId, int version) throws Exception;
	public EventAttendance disconnectFromAll(String eventAttendanceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EventAttendance> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateEventAttendance executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<EventAttendance> findEventAttendanceByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public int countEventAttendanceByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public Map<String, Integer> countEventAttendanceByPotentialCustomerIds(String[] ids, Map<String,Object> options);
 	public SmartList<EventAttendance> findEventAttendanceByPotentialCustomer(String potentialCustomerId, int start, int count, Map<String,Object> options);
 	public void analyzeEventAttendanceByPotentialCustomer(SmartList<EventAttendance> resultList, String potentialCustomerId, Map<String,Object> options);

 
  
 	public SmartList<EventAttendance> findEventAttendanceByCityEvent(String cityEventId, Map<String,Object> options);
 	public int countEventAttendanceByCityEvent(String cityEventId, Map<String,Object> options);
 	public Map<String, Integer> countEventAttendanceByCityEventIds(String[] ids, Map<String,Object> options);
 	public SmartList<EventAttendance> findEventAttendanceByCityEvent(String cityEventId, int start, int count, Map<String,Object> options);
 	public void analyzeEventAttendanceByCityEvent(SmartList<EventAttendance> resultList, String cityEventId, Map<String,Object> options);

 
 
}


