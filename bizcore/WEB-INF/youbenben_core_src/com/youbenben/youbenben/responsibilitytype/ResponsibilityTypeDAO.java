
package com.youbenben.youbenben.responsibilitytype;
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
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.youbenben.youbenben.employee.EmployeeDAO;


public interface ResponsibilityTypeDAO extends BaseDAO{

	public SmartList<ResponsibilityType> loadAll();
	public ResponsibilityType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ResponsibilityType> responsibilityTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ResponsibilityType present(ResponsibilityType responsibilityType,Map<String,Object> options) throws Exception;
	public ResponsibilityType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ResponsibilityType save(ResponsibilityType responsibilityType,Map<String,Object> options);
	public SmartList<ResponsibilityType> saveResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList,Map<String,Object> options);
	public SmartList<ResponsibilityType> removeResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList,Map<String,Object> options);
	public SmartList<ResponsibilityType> findResponsibilityTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countResponsibilityTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countResponsibilityTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String responsibilityTypeId, int version) throws Exception;
	public ResponsibilityType disconnectFromAll(String responsibilityTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<ResponsibilityType> requestCandidateResponsibilityTypeForEmployee(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ResponsibilityType planToRemoveEmployeeList(ResponsibilityType responsibilityType, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect ResponsibilityType with company in Employee
	public ResponsibilityType planToRemoveEmployeeListWithCompany(ResponsibilityType responsibilityType, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String responsibilityTypeId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with department in Employee
	public ResponsibilityType planToRemoveEmployeeListWithDepartment(ResponsibilityType responsibilityType, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String responsibilityTypeId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with occupation in Employee
	public ResponsibilityType planToRemoveEmployeeListWithOccupation(ResponsibilityType responsibilityType, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String responsibilityTypeId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with current_salary_grade in Employee
	public ResponsibilityType planToRemoveEmployeeListWithCurrentSalaryGrade(ResponsibilityType responsibilityType, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String responsibilityTypeId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with job_application in Employee
	public ResponsibilityType planToRemoveEmployeeListWithJobApplication(ResponsibilityType responsibilityType, String jobApplicationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithJobApplication(String responsibilityTypeId, String jobApplicationId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with profession_interview in Employee
	public ResponsibilityType planToRemoveEmployeeListWithProfessionInterview(ResponsibilityType responsibilityType, String professionInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithProfessionInterview(String responsibilityTypeId, String professionInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with hr_interview in Employee
	public ResponsibilityType planToRemoveEmployeeListWithHrInterview(ResponsibilityType responsibilityType, String hrInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithHrInterview(String responsibilityTypeId, String hrInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with offer_approval in Employee
	public ResponsibilityType planToRemoveEmployeeListWithOfferApproval(ResponsibilityType responsibilityType, String offerApprovalId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferApproval(String responsibilityTypeId, String offerApprovalId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with offer_acceptance in Employee
	public ResponsibilityType planToRemoveEmployeeListWithOfferAcceptance(ResponsibilityType responsibilityType, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferAcceptance(String responsibilityTypeId, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with employee_boarding in Employee
	public ResponsibilityType planToRemoveEmployeeListWithEmployeeBoarding(ResponsibilityType responsibilityType, String employeeBoardingId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithEmployeeBoarding(String responsibilityTypeId, String employeeBoardingId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with termination in Employee
	public ResponsibilityType planToRemoveEmployeeListWithTermination(ResponsibilityType responsibilityType, String terminationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithTermination(String responsibilityTypeId, String terminationId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ResponsibilityType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateResponsibilityType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<ResponsibilityType> findResponsibilityTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countResponsibilityTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countResponsibilityTypeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<ResponsibilityType> findResponsibilityTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeResponsibilityTypeByCompany(SmartList<ResponsibilityType> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Employee的responsibleFor的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(YoubenbenUserContext userContext, List<ResponsibilityType> us, Map<String,Object> options) throws Exception;
	
}


