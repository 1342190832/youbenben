
package com.youbenben.youbenben.employee;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.employeeboarding.EmployeeBoarding;
import com.youbenben.youbenben.termination.Termination;
import com.youbenben.youbenben.employeesalarysheet.EmployeeSalarySheet;
import com.youbenben.youbenben.payingoff.PayingOff;
import com.youbenben.youbenben.employeequalifier.EmployeeQualifier;
import com.youbenben.youbenben.offerapproval.OfferApproval;
import com.youbenben.youbenben.responsibilitytype.ResponsibilityType;
import com.youbenben.youbenben.employeecompanytraining.EmployeeCompanyTraining;
import com.youbenben.youbenben.professioninterview.ProfessionInterview;
import com.youbenben.youbenben.employeeeducation.EmployeeEducation;
import com.youbenben.youbenben.hrinterview.HrInterview;
import com.youbenben.youbenben.salarygrade.SalaryGrade;
import com.youbenben.youbenben.jobapplication.JobApplication;
import com.youbenben.youbenben.employeeskill.EmployeeSkill;
import com.youbenben.youbenben.employeeworkexperience.EmployeeWorkExperience;
import com.youbenben.youbenben.employeeaward.EmployeeAward;
import com.youbenben.youbenben.offeracceptance.OfferAcceptance;
import com.youbenben.youbenben.levelthreedepartment.LevelThreeDepartment;
import com.youbenben.youbenben.occupationtype.OccupationType;
import com.youbenben.youbenben.employeeinterview.EmployeeInterview;
import com.youbenben.youbenben.employeeleave.EmployeeLeave;
import com.youbenben.youbenben.employeeattendance.EmployeeAttendance;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;
import com.youbenben.youbenben.employeeperformance.EmployeePerformance;

import com.youbenben.youbenben.employeequalifier.EmployeeQualifierDAO;
import com.youbenben.youbenben.payingoff.PayingOffDAO;
import com.youbenben.youbenben.professioninterview.ProfessionInterviewDAO;
import com.youbenben.youbenben.occupationtype.OccupationTypeDAO;
import com.youbenben.youbenben.salarygrade.SalaryGradeDAO;
import com.youbenben.youbenben.jobapplication.JobApplicationDAO;
import com.youbenben.youbenben.employeeskill.EmployeeSkillDAO;
import com.youbenben.youbenben.employeeeducation.EmployeeEducationDAO;
import com.youbenben.youbenben.levelthreedepartment.LevelThreeDepartmentDAO;
import com.youbenben.youbenben.responsibilitytype.ResponsibilityTypeDAO;
import com.youbenben.youbenben.employeecompanytraining.EmployeeCompanyTrainingDAO;
import com.youbenben.youbenben.employeeboarding.EmployeeBoardingDAO;
import com.youbenben.youbenben.employeeperformance.EmployeePerformanceDAO;
import com.youbenben.youbenben.employeeworkexperience.EmployeeWorkExperienceDAO;
import com.youbenben.youbenben.offerapproval.OfferApprovalDAO;
import com.youbenben.youbenben.termination.TerminationDAO;
import com.youbenben.youbenben.employeeattendance.EmployeeAttendanceDAO;
import com.youbenben.youbenben.employeeleave.EmployeeLeaveDAO;
import com.youbenben.youbenben.employeeinterview.EmployeeInterviewDAO;
import com.youbenben.youbenben.offeracceptance.OfferAcceptanceDAO;
import com.youbenben.youbenben.hrinterview.HrInterviewDAO;
import com.youbenben.youbenben.employeesalarysheet.EmployeeSalarySheetDAO;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.youbenben.youbenben.employeeaward.EmployeeAwardDAO;


public interface EmployeeDAO extends BaseDAO{

	public SmartList<Employee> loadAll();
	public Employee load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Employee> employeeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Employee present(Employee employee,Map<String,Object> options) throws Exception;
	public Employee clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Employee save(Employee employee,Map<String,Object> options);
	public SmartList<Employee> saveEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options);
	public SmartList<Employee> removeEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options);
	public SmartList<Employee> findEmployeeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeId, int version) throws Exception;
	public Employee disconnectFromAll(String employeeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO();
		
	public EmployeeSkillDAO getEmployeeSkillDAO();
		
	public EmployeePerformanceDAO getEmployeePerformanceDAO();
		
	public EmployeeWorkExperienceDAO getEmployeeWorkExperienceDAO();
		
	public EmployeeLeaveDAO getEmployeeLeaveDAO();
		
	public EmployeeInterviewDAO getEmployeeInterviewDAO();
		
	public EmployeeAttendanceDAO getEmployeeAttendanceDAO();
		
	public EmployeeQualifierDAO getEmployeeQualifierDAO();
		
	public EmployeeEducationDAO getEmployeeEducationDAO();
		
	public EmployeeAwardDAO getEmployeeAwardDAO();
		
	public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO();
		
	public PayingOffDAO getPayingOffDAO();
		
	
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeCompanyTraining(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeSkill(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeePerformance(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeWorkExperience(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeLeave(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeInterview(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeAttendance(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeQualifier(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeEducation(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeAward(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeSalarySheet(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForPayingOff(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Employee planToRemoveEmployeeCompanyTrainingList(Employee employee, String employeeCompanyTrainingIds[], Map<String,Object> options)throws Exception;


	//disconnect Employee with training in EmployeeCompanyTraining
	public Employee planToRemoveEmployeeCompanyTrainingListWithTraining(Employee employee, String trainingId, Map<String,Object> options)throws Exception;
	public int countEmployeeCompanyTrainingListWithTraining(String employeeId, String trainingId, Map<String,Object> options)throws Exception;
	
	//disconnect Employee with scoring in EmployeeCompanyTraining
	public Employee planToRemoveEmployeeCompanyTrainingListWithScoring(Employee employee, String scoringId, Map<String,Object> options)throws Exception;
	public int countEmployeeCompanyTrainingListWithScoring(String employeeId, String scoringId, Map<String,Object> options)throws Exception;
	
	public Employee planToRemoveEmployeeSkillList(Employee employee, String employeeSkillIds[], Map<String,Object> options)throws Exception;


	//disconnect Employee with skill_type in EmployeeSkill
	public Employee planToRemoveEmployeeSkillListWithSkillType(Employee employee, String skillTypeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSkillListWithSkillType(String employeeId, String skillTypeId, Map<String,Object> options)throws Exception;
	
	public Employee planToRemoveEmployeePerformanceList(Employee employee, String employeePerformanceIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeWorkExperienceList(Employee employee, String employeeWorkExperienceIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeLeaveList(Employee employee, String employeeLeaveIds[], Map<String,Object> options)throws Exception;


	//disconnect Employee with type in EmployeeLeave
	public Employee planToRemoveEmployeeLeaveListWithType(Employee employee, String typeId, Map<String,Object> options)throws Exception;
	public int countEmployeeLeaveListWithType(String employeeId, String typeId, Map<String,Object> options)throws Exception;
	
	public Employee planToRemoveEmployeeInterviewList(Employee employee, String employeeInterviewIds[], Map<String,Object> options)throws Exception;


	//disconnect Employee with interview_type in EmployeeInterview
	public Employee planToRemoveEmployeeInterviewListWithInterviewType(Employee employee, String interviewTypeId, Map<String,Object> options)throws Exception;
	public int countEmployeeInterviewListWithInterviewType(String employeeId, String interviewTypeId, Map<String,Object> options)throws Exception;
	
	public Employee planToRemoveEmployeeAttendanceList(Employee employee, String employeeAttendanceIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeQualifierList(Employee employee, String employeeQualifierIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeEducationList(Employee employee, String employeeEducationIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeAwardList(Employee employee, String employeeAwardIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeSalarySheetList(Employee employee, String employeeSalarySheetIds[], Map<String,Object> options)throws Exception;


	//disconnect Employee with current_salary_grade in EmployeeSalarySheet
	public Employee planToRemoveEmployeeSalarySheetListWithCurrentSalaryGrade(Employee employee, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithCurrentSalaryGrade(String employeeId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	//disconnect Employee with paying_off in EmployeeSalarySheet
	public Employee planToRemoveEmployeeSalarySheetListWithPayingOff(Employee employee, String payingOffId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithPayingOff(String employeeId, String payingOffId, Map<String,Object> options)throws Exception;
	
	public Employee planToRemovePayingOffList(Employee employee, String payingOffIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Employee> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateEmployee executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<Employee> findEmployeeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countEmployeeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByCompany(SmartList<Employee> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
  
 	public SmartList<Employee> findEmployeeByDepartment(String levelThreeDepartmentId, Map<String,Object> options);
 	public int countEmployeeByDepartment(String levelThreeDepartmentId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByDepartmentIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByDepartment(String levelThreeDepartmentId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByDepartment(SmartList<Employee> resultList, String levelThreeDepartmentId, Map<String,Object> options);

 
  
 	public SmartList<Employee> findEmployeeByOccupation(String occupationTypeId, Map<String,Object> options);
 	public int countEmployeeByOccupation(String occupationTypeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByOccupationIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByOccupation(String occupationTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByOccupation(SmartList<Employee> resultList, String occupationTypeId, Map<String,Object> options);

 
  
 	public SmartList<Employee> findEmployeeByResponsibleFor(String responsibilityTypeId, Map<String,Object> options);
 	public int countEmployeeByResponsibleFor(String responsibilityTypeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByResponsibleForIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByResponsibleFor(String responsibilityTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByResponsibleFor(SmartList<Employee> resultList, String responsibilityTypeId, Map<String,Object> options);

 
  
 	public SmartList<Employee> findEmployeeByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public int countEmployeeByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByCurrentSalaryGradeIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByCurrentSalaryGrade(String salaryGradeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByCurrentSalaryGrade(SmartList<Employee> resultList, String salaryGradeId, Map<String,Object> options);

 
  
 	public SmartList<Employee> findEmployeeByJobApplication(String jobApplicationId, Map<String,Object> options);
 	public int countEmployeeByJobApplication(String jobApplicationId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByJobApplicationIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByJobApplication(String jobApplicationId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByJobApplication(SmartList<Employee> resultList, String jobApplicationId, Map<String,Object> options);

 
  
 	public SmartList<Employee> findEmployeeByProfessionInterview(String professionInterviewId, Map<String,Object> options);
 	public int countEmployeeByProfessionInterview(String professionInterviewId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByProfessionInterviewIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByProfessionInterview(String professionInterviewId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByProfessionInterview(SmartList<Employee> resultList, String professionInterviewId, Map<String,Object> options);

 
  
 	public SmartList<Employee> findEmployeeByHrInterview(String hrInterviewId, Map<String,Object> options);
 	public int countEmployeeByHrInterview(String hrInterviewId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByHrInterviewIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByHrInterview(String hrInterviewId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByHrInterview(SmartList<Employee> resultList, String hrInterviewId, Map<String,Object> options);

 
  
 	public SmartList<Employee> findEmployeeByOfferApproval(String offerApprovalId, Map<String,Object> options);
 	public int countEmployeeByOfferApproval(String offerApprovalId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByOfferApprovalIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByOfferApproval(String offerApprovalId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByOfferApproval(SmartList<Employee> resultList, String offerApprovalId, Map<String,Object> options);

 
  
 	public SmartList<Employee> findEmployeeByOfferAcceptance(String offerAcceptanceId, Map<String,Object> options);
 	public int countEmployeeByOfferAcceptance(String offerAcceptanceId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByOfferAcceptanceIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByOfferAcceptance(String offerAcceptanceId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByOfferAcceptance(SmartList<Employee> resultList, String offerAcceptanceId, Map<String,Object> options);

 
  
 	public SmartList<Employee> findEmployeeByEmployeeBoarding(String employeeBoardingId, Map<String,Object> options);
 	public int countEmployeeByEmployeeBoarding(String employeeBoardingId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByEmployeeBoardingIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByEmployeeBoarding(String employeeBoardingId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByEmployeeBoarding(SmartList<Employee> resultList, String employeeBoardingId, Map<String,Object> options);

 
  
 	public SmartList<Employee> findEmployeeByTermination(String terminationId, Map<String,Object> options);
 	public int countEmployeeByTermination(String terminationId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByTerminationIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByTermination(String terminationId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByTermination(SmartList<Employee> resultList, String terminationId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:EmployeeCompanyTraining的employee的EmployeeCompanyTrainingList
	public SmartList<EmployeeCompanyTraining> loadOurEmployeeCompanyTrainingList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeSkill的employee的EmployeeSkillList
	public SmartList<EmployeeSkill> loadOurEmployeeSkillList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeePerformance的employee的EmployeePerformanceList
	public SmartList<EmployeePerformance> loadOurEmployeePerformanceList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeWorkExperience的employee的EmployeeWorkExperienceList
	public SmartList<EmployeeWorkExperience> loadOurEmployeeWorkExperienceList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeLeave的who的EmployeeLeaveList
	public SmartList<EmployeeLeave> loadOurEmployeeLeaveList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeInterview的employee的EmployeeInterviewList
	public SmartList<EmployeeInterview> loadOurEmployeeInterviewList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeAttendance的employee的EmployeeAttendanceList
	public SmartList<EmployeeAttendance> loadOurEmployeeAttendanceList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeQualifier的employee的EmployeeQualifierList
	public SmartList<EmployeeQualifier> loadOurEmployeeQualifierList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeEducation的employee的EmployeeEducationList
	public SmartList<EmployeeEducation> loadOurEmployeeEducationList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeAward的employee的EmployeeAwardList
	public SmartList<EmployeeAward> loadOurEmployeeAwardList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeSalarySheet的employee的EmployeeSalarySheetList
	public SmartList<EmployeeSalarySheet> loadOurEmployeeSalarySheetList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PayingOff的paidFor的PayingOffList
	public SmartList<PayingOff> loadOurPayingOffList(YoubenbenUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
}


