
package com.youbenben.youbenben.jobapplication;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface JobApplicationManager extends BaseManager{

		

	public JobApplication createJobApplication(YoubenbenUserContext userContext, Date applicationTime,String who,String comments) throws Exception;
	public JobApplication updateJobApplication(YoubenbenUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public JobApplication loadJobApplication(YoubenbenUserContext userContext, String jobApplicationId, String [] tokensExpr) throws Exception;
	public JobApplication internalSaveJobApplication(YoubenbenUserContext userContext, JobApplication jobApplication) throws Exception;
	public JobApplication internalSaveJobApplication(YoubenbenUserContext userContext, JobApplication jobApplication,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String jobApplicationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, JobApplication newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  JobApplication addEmployee(YoubenbenUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  JobApplication removeEmployee(YoubenbenUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  JobApplication updateEmployee(YoubenbenUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


