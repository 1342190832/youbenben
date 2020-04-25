
package com.doublechaintech.retailscm.professioninterview;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface ProfessionInterviewDAO extends BaseDAO{

	public SmartList<ProfessionInterview> loadAll();
	public ProfessionInterview load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ProfessionInterview> professionInterviewList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ProfessionInterview present(ProfessionInterview professionInterview,Map<String,Object> options) throws Exception;
	public ProfessionInterview clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ProfessionInterview save(ProfessionInterview professionInterview,Map<String,Object> options);
	public SmartList<ProfessionInterview> saveProfessionInterviewList(SmartList<ProfessionInterview> professionInterviewList,Map<String,Object> options);
	public SmartList<ProfessionInterview> removeProfessionInterviewList(SmartList<ProfessionInterview> professionInterviewList,Map<String,Object> options);
	public SmartList<ProfessionInterview> findProfessionInterviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProfessionInterviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProfessionInterviewWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String professionInterviewId, int version) throws Exception;
	public ProfessionInterview disconnectFromAll(String professionInterviewId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<ProfessionInterview> requestCandidateProfessionInterviewForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ProfessionInterview planToRemoveEmployeeList(ProfessionInterview professionInterview, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect ProfessionInterview with company in Employee
	public ProfessionInterview planToRemoveEmployeeListWithCompany(ProfessionInterview professionInterview, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String professionInterviewId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with department in Employee
	public ProfessionInterview planToRemoveEmployeeListWithDepartment(ProfessionInterview professionInterview, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String professionInterviewId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with occupation in Employee
	public ProfessionInterview planToRemoveEmployeeListWithOccupation(ProfessionInterview professionInterview, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String professionInterviewId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with responsible_for in Employee
	public ProfessionInterview planToRemoveEmployeeListWithResponsibleFor(ProfessionInterview professionInterview, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String professionInterviewId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with current_salary_grade in Employee
	public ProfessionInterview planToRemoveEmployeeListWithCurrentSalaryGrade(ProfessionInterview professionInterview, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String professionInterviewId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with job_application in Employee
	public ProfessionInterview planToRemoveEmployeeListWithJobApplication(ProfessionInterview professionInterview, String jobApplicationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithJobApplication(String professionInterviewId, String jobApplicationId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with hr_interview in Employee
	public ProfessionInterview planToRemoveEmployeeListWithHrInterview(ProfessionInterview professionInterview, String hrInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithHrInterview(String professionInterviewId, String hrInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with offer_approval in Employee
	public ProfessionInterview planToRemoveEmployeeListWithOfferApproval(ProfessionInterview professionInterview, String offerApprovalId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferApproval(String professionInterviewId, String offerApprovalId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with offer_acceptance in Employee
	public ProfessionInterview planToRemoveEmployeeListWithOfferAcceptance(ProfessionInterview professionInterview, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferAcceptance(String professionInterviewId, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with employee_boarding in Employee
	public ProfessionInterview planToRemoveEmployeeListWithEmployeeBoarding(ProfessionInterview professionInterview, String employeeBoardingId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithEmployeeBoarding(String professionInterviewId, String employeeBoardingId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with termination in Employee
	public ProfessionInterview planToRemoveEmployeeListWithTermination(ProfessionInterview professionInterview, String terminationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithTermination(String professionInterviewId, String terminationId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ProfessionInterview> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateProfessionInterview executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:Employee的professionInterview的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<ProfessionInterview> us, Map<String,Object> options) throws Exception;
	
}


