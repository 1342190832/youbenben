
package com.youbenben.youbenben.offeracceptance;
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


public interface OfferAcceptanceDAO extends BaseDAO{

	public SmartList<OfferAcceptance> loadAll();
	public OfferAcceptance load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<OfferAcceptance> offerAcceptanceList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public OfferAcceptance present(OfferAcceptance offerAcceptance,Map<String,Object> options) throws Exception;
	public OfferAcceptance clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OfferAcceptance save(OfferAcceptance offerAcceptance,Map<String,Object> options);
	public SmartList<OfferAcceptance> saveOfferAcceptanceList(SmartList<OfferAcceptance> offerAcceptanceList,Map<String,Object> options);
	public SmartList<OfferAcceptance> removeOfferAcceptanceList(SmartList<OfferAcceptance> offerAcceptanceList,Map<String,Object> options);
	public SmartList<OfferAcceptance> findOfferAcceptanceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countOfferAcceptanceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countOfferAcceptanceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String offerAcceptanceId, int version) throws Exception;
	public OfferAcceptance disconnectFromAll(String offerAcceptanceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<OfferAcceptance> requestCandidateOfferAcceptanceForEmployee(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public OfferAcceptance planToRemoveEmployeeList(OfferAcceptance offerAcceptance, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect OfferAcceptance with company in Employee
	public OfferAcceptance planToRemoveEmployeeListWithCompany(OfferAcceptance offerAcceptance, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String offerAcceptanceId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with department in Employee
	public OfferAcceptance planToRemoveEmployeeListWithDepartment(OfferAcceptance offerAcceptance, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String offerAcceptanceId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with occupation in Employee
	public OfferAcceptance planToRemoveEmployeeListWithOccupation(OfferAcceptance offerAcceptance, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String offerAcceptanceId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with responsible_for in Employee
	public OfferAcceptance planToRemoveEmployeeListWithResponsibleFor(OfferAcceptance offerAcceptance, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String offerAcceptanceId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with current_salary_grade in Employee
	public OfferAcceptance planToRemoveEmployeeListWithCurrentSalaryGrade(OfferAcceptance offerAcceptance, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String offerAcceptanceId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with job_application in Employee
	public OfferAcceptance planToRemoveEmployeeListWithJobApplication(OfferAcceptance offerAcceptance, String jobApplicationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithJobApplication(String offerAcceptanceId, String jobApplicationId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with profession_interview in Employee
	public OfferAcceptance planToRemoveEmployeeListWithProfessionInterview(OfferAcceptance offerAcceptance, String professionInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithProfessionInterview(String offerAcceptanceId, String professionInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with hr_interview in Employee
	public OfferAcceptance planToRemoveEmployeeListWithHrInterview(OfferAcceptance offerAcceptance, String hrInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithHrInterview(String offerAcceptanceId, String hrInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with offer_approval in Employee
	public OfferAcceptance planToRemoveEmployeeListWithOfferApproval(OfferAcceptance offerAcceptance, String offerApprovalId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferApproval(String offerAcceptanceId, String offerApprovalId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with employee_boarding in Employee
	public OfferAcceptance planToRemoveEmployeeListWithEmployeeBoarding(OfferAcceptance offerAcceptance, String employeeBoardingId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithEmployeeBoarding(String offerAcceptanceId, String employeeBoardingId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with termination in Employee
	public OfferAcceptance planToRemoveEmployeeListWithTermination(OfferAcceptance offerAcceptance, String terminationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithTermination(String offerAcceptanceId, String terminationId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<OfferAcceptance> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateOfferAcceptance executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:Employee的offerAcceptance的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(YoubenbenUserContext userContext, List<OfferAcceptance> us, Map<String,Object> options) throws Exception;
	
}


