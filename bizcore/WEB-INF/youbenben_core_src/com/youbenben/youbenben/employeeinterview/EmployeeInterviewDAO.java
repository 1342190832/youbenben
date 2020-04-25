
package com.youbenben.youbenben.employeeinterview;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.interviewtype.InterviewType;
import com.youbenben.youbenben.employee.Employee;

import com.youbenben.youbenben.interviewtype.InterviewTypeDAO;
import com.youbenben.youbenben.employee.EmployeeDAO;


public interface EmployeeInterviewDAO extends BaseDAO{

	public SmartList<EmployeeInterview> loadAll();
	public EmployeeInterview load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeInterview> employeeInterviewList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeInterview present(EmployeeInterview employeeInterview,Map<String,Object> options) throws Exception;
	public EmployeeInterview clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeInterview save(EmployeeInterview employeeInterview,Map<String,Object> options);
	public SmartList<EmployeeInterview> saveEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList,Map<String,Object> options);
	public SmartList<EmployeeInterview> removeEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList,Map<String,Object> options);
	public SmartList<EmployeeInterview> findEmployeeInterviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeInterviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeInterviewWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeInterviewId, int version) throws Exception;
	public EmployeeInterview disconnectFromAll(String employeeInterviewId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EmployeeInterview> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateEmployeeInterview executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<EmployeeInterview> findEmployeeInterviewByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeInterviewByEmployee(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeInterviewByEmployeeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeInterview> findEmployeeInterviewByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeInterviewByEmployee(SmartList<EmployeeInterview> resultList, String employeeId, Map<String,Object> options);

 
  
 	public SmartList<EmployeeInterview> findEmployeeInterviewByInterviewType(String interviewTypeId, Map<String,Object> options);
 	public int countEmployeeInterviewByInterviewType(String interviewTypeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeInterviewByInterviewTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeInterview> findEmployeeInterviewByInterviewType(String interviewTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeInterviewByInterviewType(SmartList<EmployeeInterview> resultList, String interviewTypeId, Map<String,Object> options);

 
 
}


