
package com.youbenben.youbenben.employeeattendance;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.employee.Employee;

import com.youbenben.youbenben.employee.EmployeeDAO;


public interface EmployeeAttendanceDAO extends BaseDAO{

	public SmartList<EmployeeAttendance> loadAll();
	public EmployeeAttendance load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeAttendance> employeeAttendanceList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeAttendance present(EmployeeAttendance employeeAttendance,Map<String,Object> options) throws Exception;
	public EmployeeAttendance clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeAttendance save(EmployeeAttendance employeeAttendance,Map<String,Object> options);
	public SmartList<EmployeeAttendance> saveEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList,Map<String,Object> options);
	public SmartList<EmployeeAttendance> removeEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList,Map<String,Object> options);
	public SmartList<EmployeeAttendance> findEmployeeAttendanceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeAttendanceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeAttendanceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeAttendanceId, int version) throws Exception;
	public EmployeeAttendance disconnectFromAll(String employeeAttendanceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EmployeeAttendance> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateEmployeeAttendance executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<EmployeeAttendance> findEmployeeAttendanceByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeAttendanceByEmployee(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeAttendanceByEmployeeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeAttendance> findEmployeeAttendanceByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeAttendanceByEmployee(SmartList<EmployeeAttendance> resultList, String employeeId, Map<String,Object> options);

 
 
}


