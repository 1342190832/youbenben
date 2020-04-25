
package com.youbenben.youbenben.employeeaward;
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


public interface EmployeeAwardDAO extends BaseDAO{

	public SmartList<EmployeeAward> loadAll();
	public EmployeeAward load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeAward> employeeAwardList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeAward present(EmployeeAward employeeAward,Map<String,Object> options) throws Exception;
	public EmployeeAward clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeAward save(EmployeeAward employeeAward,Map<String,Object> options);
	public SmartList<EmployeeAward> saveEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList,Map<String,Object> options);
	public SmartList<EmployeeAward> removeEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList,Map<String,Object> options);
	public SmartList<EmployeeAward> findEmployeeAwardWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeAwardWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeAwardWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeAwardId, int version) throws Exception;
	public EmployeeAward disconnectFromAll(String employeeAwardId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EmployeeAward> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateEmployeeAward executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<EmployeeAward> findEmployeeAwardByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeAwardByEmployee(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeAwardByEmployeeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeAward> findEmployeeAwardByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeAwardByEmployee(SmartList<EmployeeAward> resultList, String employeeId, Map<String,Object> options);

 
 
}


