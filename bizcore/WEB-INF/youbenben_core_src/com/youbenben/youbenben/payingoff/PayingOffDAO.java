
package com.youbenben.youbenben.payingoff;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.employeesalarysheet.EmployeeSalarySheet;
import com.youbenben.youbenben.employee.Employee;

import com.youbenben.youbenben.employeesalarysheet.EmployeeSalarySheetDAO;
import com.youbenben.youbenben.employee.EmployeeDAO;


public interface PayingOffDAO extends BaseDAO{

	public SmartList<PayingOff> loadAll();
	public PayingOff load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PayingOff> payingOffList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public PayingOff present(PayingOff payingOff,Map<String,Object> options) throws Exception;
	public PayingOff clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PayingOff save(PayingOff payingOff,Map<String,Object> options);
	public SmartList<PayingOff> savePayingOffList(SmartList<PayingOff> payingOffList,Map<String,Object> options);
	public SmartList<PayingOff> removePayingOffList(SmartList<PayingOff> payingOffList,Map<String,Object> options);
	public SmartList<PayingOff> findPayingOffWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPayingOffWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPayingOffWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String payingOffId, int version) throws Exception;
	public PayingOff disconnectFromAll(String payingOffId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO();
		
	
 	public SmartList<PayingOff> requestCandidatePayingOffForEmployeeSalarySheet(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public PayingOff planToRemoveEmployeeSalarySheetList(PayingOff payingOff, String employeeSalarySheetIds[], Map<String,Object> options)throws Exception;


	//disconnect PayingOff with employee in EmployeeSalarySheet
	public PayingOff planToRemoveEmployeeSalarySheetListWithEmployee(PayingOff payingOff, String employeeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithEmployee(String payingOffId, String employeeId, Map<String,Object> options)throws Exception;
	
	//disconnect PayingOff with current_salary_grade in EmployeeSalarySheet
	public PayingOff planToRemoveEmployeeSalarySheetListWithCurrentSalaryGrade(PayingOff payingOff, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithCurrentSalaryGrade(String payingOffId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<PayingOff> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidatePayingOff executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<PayingOff> findPayingOffByPaidFor(String employeeId, Map<String,Object> options);
 	public int countPayingOffByPaidFor(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countPayingOffByPaidForIds(String[] ids, Map<String,Object> options);
 	public SmartList<PayingOff> findPayingOffByPaidFor(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzePayingOffByPaidFor(SmartList<PayingOff> resultList, String employeeId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:EmployeeSalarySheet的payingOff的EmployeeSalarySheetList
	public SmartList<EmployeeSalarySheet> loadOurEmployeeSalarySheetList(YoubenbenUserContext userContext, List<PayingOff> us, Map<String,Object> options) throws Exception;
	
}


