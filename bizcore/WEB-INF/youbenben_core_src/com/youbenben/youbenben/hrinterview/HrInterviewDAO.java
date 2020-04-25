
package com.youbenben.youbenben.hrinterview;
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


public interface HrInterviewDAO extends BaseDAO{

	public SmartList<HrInterview> loadAll();
	public HrInterview load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<HrInterview> hrInterviewList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public HrInterview present(HrInterview hrInterview,Map<String,Object> options) throws Exception;
	public HrInterview clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public HrInterview save(HrInterview hrInterview,Map<String,Object> options);
	public SmartList<HrInterview> saveHrInterviewList(SmartList<HrInterview> hrInterviewList,Map<String,Object> options);
	public SmartList<HrInterview> removeHrInterviewList(SmartList<HrInterview> hrInterviewList,Map<String,Object> options);
	public SmartList<HrInterview> findHrInterviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countHrInterviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countHrInterviewWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String hrInterviewId, int version) throws Exception;
	public HrInterview disconnectFromAll(String hrInterviewId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<HrInterview> requestCandidateHrInterviewForEmployee(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public HrInterview planToRemoveEmployeeList(HrInterview hrInterview, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect HrInterview with company in Employee
	public HrInterview planToRemoveEmployeeListWithCompany(HrInterview hrInterview, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String hrInterviewId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with department in Employee
	public HrInterview planToRemoveEmployeeListWithDepartment(HrInterview hrInterview, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String hrInterviewId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with occupation in Employee
	public HrInterview planToRemoveEmployeeListWithOccupation(HrInterview hrInterview, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String hrInterviewId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with responsible_for in Employee
	public HrInterview planToRemoveEmployeeListWithResponsibleFor(HrInterview hrInterview, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String hrInterviewId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with current_salary_grade in Employee
	public HrInterview planToRemoveEmployeeListWithCurrentSalaryGrade(HrInterview hrInterview, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String hrInterviewId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with job_application in Employee
	public HrInterview planToRemoveEmployeeListWithJobApplication(HrInterview hrInterview, String jobApplicationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithJobApplication(String hrInterviewId, String jobApplicationId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with profession_interview in Employee
	public HrInterview planToRemoveEmployeeListWithProfessionInterview(HrInterview hrInterview, String professionInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithProfessionInterview(String hrInterviewId, String professionInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with offer_approval in Employee
	public HrInterview planToRemoveEmployeeListWithOfferApproval(HrInterview hrInterview, String offerApprovalId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferApproval(String hrInterviewId, String offerApprovalId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with offer_acceptance in Employee
	public HrInterview planToRemoveEmployeeListWithOfferAcceptance(HrInterview hrInterview, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferAcceptance(String hrInterviewId, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with employee_boarding in Employee
	public HrInterview planToRemoveEmployeeListWithEmployeeBoarding(HrInterview hrInterview, String employeeBoardingId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithEmployeeBoarding(String hrInterviewId, String employeeBoardingId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with termination in Employee
	public HrInterview planToRemoveEmployeeListWithTermination(HrInterview hrInterview, String terminationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithTermination(String hrInterviewId, String terminationId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<HrInterview> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateHrInterview executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:Employee的hrInterview的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(YoubenbenUserContext userContext, List<HrInterview> us, Map<String,Object> options) throws Exception;
	
}


