
package com.youbenben.youbenben.employeecompanytraining;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.companytraining.CompanyTraining;
import com.youbenben.youbenben.scoring.Scoring;
import com.youbenben.youbenben.employee.Employee;

import com.youbenben.youbenben.scoring.ScoringDAO;
import com.youbenben.youbenben.companytraining.CompanyTrainingDAO;
import com.youbenben.youbenben.employee.EmployeeDAO;


public interface EmployeeCompanyTrainingDAO extends BaseDAO{

	public SmartList<EmployeeCompanyTraining> loadAll();
	public EmployeeCompanyTraining load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeCompanyTraining> employeeCompanyTrainingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeCompanyTraining present(EmployeeCompanyTraining employeeCompanyTraining,Map<String,Object> options) throws Exception;
	public EmployeeCompanyTraining clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeCompanyTraining save(EmployeeCompanyTraining employeeCompanyTraining,Map<String,Object> options);
	public SmartList<EmployeeCompanyTraining> saveEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList,Map<String,Object> options);
	public SmartList<EmployeeCompanyTraining> removeEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList,Map<String,Object> options);
	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeCompanyTrainingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeCompanyTrainingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeCompanyTrainingId, int version) throws Exception;
	public EmployeeCompanyTraining disconnectFromAll(String employeeCompanyTrainingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EmployeeCompanyTraining> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateEmployeeCompanyTraining executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeCompanyTrainingByEmployee(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeCompanyTrainingByEmployeeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeCompanyTrainingByEmployee(SmartList<EmployeeCompanyTraining> resultList, String employeeId, Map<String,Object> options);

 
  
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByTraining(String companyTrainingId, Map<String,Object> options);
 	public int countEmployeeCompanyTrainingByTraining(String companyTrainingId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeCompanyTrainingByTrainingIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByTraining(String companyTrainingId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeCompanyTrainingByTraining(SmartList<EmployeeCompanyTraining> resultList, String companyTrainingId, Map<String,Object> options);

 
  
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByScoring(String scoringId, Map<String,Object> options);
 	public int countEmployeeCompanyTrainingByScoring(String scoringId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeCompanyTrainingByScoringIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByScoring(String scoringId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeCompanyTrainingByScoring(SmartList<EmployeeCompanyTraining> resultList, String scoringId, Map<String,Object> options);

 
 
}


