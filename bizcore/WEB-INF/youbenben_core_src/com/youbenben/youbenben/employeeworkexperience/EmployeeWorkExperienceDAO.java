
package com.youbenben.youbenben.employeeworkexperience;
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


public interface EmployeeWorkExperienceDAO extends BaseDAO{

	public SmartList<EmployeeWorkExperience> loadAll();
	public EmployeeWorkExperience load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeWorkExperience> employeeWorkExperienceList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeWorkExperience present(EmployeeWorkExperience employeeWorkExperience,Map<String,Object> options) throws Exception;
	public EmployeeWorkExperience clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeWorkExperience save(EmployeeWorkExperience employeeWorkExperience,Map<String,Object> options);
	public SmartList<EmployeeWorkExperience> saveEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList,Map<String,Object> options);
	public SmartList<EmployeeWorkExperience> removeEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList,Map<String,Object> options);
	public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeWorkExperienceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeWorkExperienceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeWorkExperienceId, int version) throws Exception;
	public EmployeeWorkExperience disconnectFromAll(String employeeWorkExperienceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EmployeeWorkExperience> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateEmployeeWorkExperience executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeWorkExperienceByEmployee(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeWorkExperienceByEmployeeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeWorkExperienceByEmployee(SmartList<EmployeeWorkExperience> resultList, String employeeId, Map<String,Object> options);

 
 
}


