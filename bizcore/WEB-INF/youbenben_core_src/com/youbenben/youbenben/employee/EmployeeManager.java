
package com.youbenben.youbenben.employee;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeManager extends BaseManager{

		

	public Employee createEmployee(YoubenbenUserContext userContext, String companyId,String title,String departmentId,String familyName,String givenName,String email,String city,String address,String cellPhone,String occupationId,String responsibleForId,String currentSalaryGradeId,String salaryAccount,String jobApplicationId,String professionInterviewId,String hrInterviewId,String offerApprovalId,String offerAcceptanceId,String employeeBoardingId,String terminationId) throws Exception;
	public Employee updateEmployee(YoubenbenUserContext userContext,String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Employee loadEmployee(YoubenbenUserContext userContext, String employeeId, String [] tokensExpr) throws Exception;
	public Employee internalSaveEmployee(YoubenbenUserContext userContext, Employee employee) throws Exception;
	public Employee internalSaveEmployee(YoubenbenUserContext userContext, Employee employee,Map<String,Object>option) throws Exception;

	public Employee transferToAnotherCompany(YoubenbenUserContext userContext, String employeeId, String anotherCompanyId)  throws Exception;
 	public Employee transferToAnotherDepartment(YoubenbenUserContext userContext, String employeeId, String anotherDepartmentId)  throws Exception;
 	public Employee transferToAnotherOccupation(YoubenbenUserContext userContext, String employeeId, String anotherOccupationId)  throws Exception;
 	public Employee transferToAnotherResponsibleFor(YoubenbenUserContext userContext, String employeeId, String anotherResponsibleForId)  throws Exception;
 	public Employee transferToAnotherCurrentSalaryGrade(YoubenbenUserContext userContext, String employeeId, String anotherCurrentSalaryGradeId)  throws Exception;
 	public Employee transferToAnotherJobApplication(YoubenbenUserContext userContext, String employeeId, String anotherJobApplicationId)  throws Exception;
 	public Employee transferToAnotherProfessionInterview(YoubenbenUserContext userContext, String employeeId, String anotherProfessionInterviewId)  throws Exception;
 	public Employee transferToAnotherHrInterview(YoubenbenUserContext userContext, String employeeId, String anotherHrInterviewId)  throws Exception;
 	public Employee transferToAnotherOfferApproval(YoubenbenUserContext userContext, String employeeId, String anotherOfferApprovalId)  throws Exception;
 	public Employee transferToAnotherOfferAcceptance(YoubenbenUserContext userContext, String employeeId, String anotherOfferAcceptanceId)  throws Exception;
 	public Employee transferToAnotherEmployeeBoarding(YoubenbenUserContext userContext, String employeeId, String anotherEmployeeBoardingId)  throws Exception;
 	public Employee transferToAnotherTermination(YoubenbenUserContext userContext, String employeeId, String anotherTerminationId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, Employee newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeCompanyTrainingManager getEmployeeCompanyTrainingManager(YoubenbenUserContext userContext, String employeeId, String trainingId, String scoringId ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeCompanyTraining(YoubenbenUserContext userContext, String employeeId, String trainingId, String scoringId , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeCompanyTraining(YoubenbenUserContext userContext, String employeeId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeCompanyTraining(YoubenbenUserContext userContext, String employeeId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeSkillManager getEmployeeSkillManager(YoubenbenUserContext userContext, String employeeId, String skillTypeId, String description ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeSkill(YoubenbenUserContext userContext, String employeeId, String skillTypeId, String description , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeSkill(YoubenbenUserContext userContext, String employeeId, String employeeSkillId, int employeeSkillVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeSkill(YoubenbenUserContext userContext, String employeeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeePerformanceManager getEmployeePerformanceManager(YoubenbenUserContext userContext, String employeeId, String performanceComment ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeePerformance(YoubenbenUserContext userContext, String employeeId, String performanceComment , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeePerformance(YoubenbenUserContext userContext, String employeeId, String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeePerformance(YoubenbenUserContext userContext, String employeeId, String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeWorkExperienceManager getEmployeeWorkExperienceManager(YoubenbenUserContext userContext, String employeeId, Date start, Date end, String company, String description ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeWorkExperience(YoubenbenUserContext userContext, String employeeId, Date start, Date end, String company, String description , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeWorkExperience(YoubenbenUserContext userContext, String employeeId, String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeWorkExperience(YoubenbenUserContext userContext, String employeeId, String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeLeaveManager getEmployeeLeaveManager(YoubenbenUserContext userContext, String employeeId, String typeId, int leaveDurationHour, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeLeave(YoubenbenUserContext userContext, String employeeId, String typeId, int leaveDurationHour, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeLeave(YoubenbenUserContext userContext, String employeeId, String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeLeave(YoubenbenUserContext userContext, String employeeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeInterviewManager getEmployeeInterviewManager(YoubenbenUserContext userContext, String employeeId, String interviewTypeId, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeInterview(YoubenbenUserContext userContext, String employeeId, String interviewTypeId, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeInterview(YoubenbenUserContext userContext, String employeeId, String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeInterview(YoubenbenUserContext userContext, String employeeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeAttendanceManager getEmployeeAttendanceManager(YoubenbenUserContext userContext, String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeAttendance(YoubenbenUserContext userContext, String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeAttendance(YoubenbenUserContext userContext, String employeeId, String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeAttendance(YoubenbenUserContext userContext, String employeeId, String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeQualifierManager getEmployeeQualifierManager(YoubenbenUserContext userContext, String employeeId, Date qualifiedTime, String type, String level, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeQualifier(YoubenbenUserContext userContext, String employeeId, Date qualifiedTime, String type, String level, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeQualifier(YoubenbenUserContext userContext, String employeeId, String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeQualifier(YoubenbenUserContext userContext, String employeeId, String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeEducationManager getEmployeeEducationManager(YoubenbenUserContext userContext, String employeeId, Date completeTime, String type, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeEducation(YoubenbenUserContext userContext, String employeeId, Date completeTime, String type, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeEducation(YoubenbenUserContext userContext, String employeeId, String employeeEducationId, int employeeEducationVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeEducation(YoubenbenUserContext userContext, String employeeId, String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeAwardManager getEmployeeAwardManager(YoubenbenUserContext userContext, String employeeId, Date completeTime, String type, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeAward(YoubenbenUserContext userContext, String employeeId, Date completeTime, String type, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeAward(YoubenbenUserContext userContext, String employeeId, String employeeAwardId, int employeeAwardVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeAward(YoubenbenUserContext userContext, String employeeId, String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeSalarySheetManager getEmployeeSalarySheetManager(YoubenbenUserContext userContext, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String payingOffId ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeSalarySheet(YoubenbenUserContext userContext, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String payingOffId , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeSalarySheet(YoubenbenUserContext userContext, String employeeId, String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeSalarySheet(YoubenbenUserContext userContext, String employeeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PayingOffManager getPayingOffManager(YoubenbenUserContext userContext, String employeeId, String who, Date paidTime, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  Employee addPayingOff(YoubenbenUserContext userContext, String employeeId, String who, Date paidTime, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  Employee removePayingOff(YoubenbenUserContext userContext, String employeeId, String payingOffId, int payingOffVersion,String [] tokensExpr)  throws Exception;
	public  Employee updatePayingOff(YoubenbenUserContext userContext, String employeeId, String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  
	public Object listByDepartment(YoubenbenUserContext userContext,String departmentId) throws Exception;
	public Object listPageByDepartment(YoubenbenUserContext userContext,String departmentId, int start, int count) throws Exception;
  
	public Object listByOccupation(YoubenbenUserContext userContext,String occupationId) throws Exception;
	public Object listPageByOccupation(YoubenbenUserContext userContext,String occupationId, int start, int count) throws Exception;
  
	public Object listByResponsibleFor(YoubenbenUserContext userContext,String responsibleForId) throws Exception;
	public Object listPageByResponsibleFor(YoubenbenUserContext userContext,String responsibleForId, int start, int count) throws Exception;
  
	public Object listByCurrentSalaryGrade(YoubenbenUserContext userContext,String currentSalaryGradeId) throws Exception;
	public Object listPageByCurrentSalaryGrade(YoubenbenUserContext userContext,String currentSalaryGradeId, int start, int count) throws Exception;
  
	public Object listByJobApplication(YoubenbenUserContext userContext,String jobApplicationId) throws Exception;
	public Object listPageByJobApplication(YoubenbenUserContext userContext,String jobApplicationId, int start, int count) throws Exception;
  
	public Object listByProfessionInterview(YoubenbenUserContext userContext,String professionInterviewId) throws Exception;
	public Object listPageByProfessionInterview(YoubenbenUserContext userContext,String professionInterviewId, int start, int count) throws Exception;
  
	public Object listByHrInterview(YoubenbenUserContext userContext,String hrInterviewId) throws Exception;
	public Object listPageByHrInterview(YoubenbenUserContext userContext,String hrInterviewId, int start, int count) throws Exception;
  
	public Object listByOfferApproval(YoubenbenUserContext userContext,String offerApprovalId) throws Exception;
	public Object listPageByOfferApproval(YoubenbenUserContext userContext,String offerApprovalId, int start, int count) throws Exception;
  
	public Object listByOfferAcceptance(YoubenbenUserContext userContext,String offerAcceptanceId) throws Exception;
	public Object listPageByOfferAcceptance(YoubenbenUserContext userContext,String offerAcceptanceId, int start, int count) throws Exception;
  
	public Object listByEmployeeBoarding(YoubenbenUserContext userContext,String employeeBoardingId) throws Exception;
	public Object listPageByEmployeeBoarding(YoubenbenUserContext userContext,String employeeBoardingId, int start, int count) throws Exception;
  
	public Object listByTermination(YoubenbenUserContext userContext,String terminationId) throws Exception;
	public Object listPageByTermination(YoubenbenUserContext userContext,String terminationId, int start, int count) throws Exception;
  

}


