
package com.youbenben.youbenben.employeesalarysheet;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.salarygrade.SalaryGrade;
import com.youbenben.youbenben.payingoff.PayingOff;
import com.youbenben.youbenben.employee.Employee;

import com.youbenben.youbenben.payingoff.PayingOffDAO;
import com.youbenben.youbenben.salarygrade.SalaryGradeDAO;
import com.youbenben.youbenben.employee.EmployeeDAO;


public interface EmployeeSalarySheetDAO extends BaseDAO{

	public SmartList<EmployeeSalarySheet> loadAll();
	public EmployeeSalarySheet load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeSalarySheet> employeeSalarySheetList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeSalarySheet present(EmployeeSalarySheet employeeSalarySheet,Map<String,Object> options) throws Exception;
	public EmployeeSalarySheet clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeSalarySheet save(EmployeeSalarySheet employeeSalarySheet,Map<String,Object> options);
	public SmartList<EmployeeSalarySheet> saveEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList,Map<String,Object> options);
	public SmartList<EmployeeSalarySheet> removeEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList,Map<String,Object> options);
	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeSalarySheetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeSalarySheetWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeSalarySheetId, int version) throws Exception;
	public EmployeeSalarySheet disconnectFromAll(String employeeSalarySheetId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EmployeeSalarySheet> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateEmployeeSalarySheet executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeSalarySheetByEmployee(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeSalarySheetByEmployeeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeSalarySheetByEmployee(SmartList<EmployeeSalarySheet> resultList, String employeeId, Map<String,Object> options);

 
  
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public int countEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeSalarySheetByCurrentSalaryGradeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeSalarySheetByCurrentSalaryGrade(SmartList<EmployeeSalarySheet> resultList, String salaryGradeId, Map<String,Object> options);

 
  
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByPayingOff(String payingOffId, Map<String,Object> options);
 	public int countEmployeeSalarySheetByPayingOff(String payingOffId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeSalarySheetByPayingOffIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByPayingOff(String payingOffId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeSalarySheetByPayingOff(SmartList<EmployeeSalarySheet> resultList, String payingOffId, Map<String,Object> options);

 
 
}


