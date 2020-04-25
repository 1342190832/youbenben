
package com.doublechaintech.retailscm.jobapplication;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface JobApplicationManager extends BaseManager{

		

	public JobApplication createJobApplication(RetailscmUserContext userContext, Date applicationTime,String who,String comments) throws Exception;
	public JobApplication updateJobApplication(RetailscmUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public JobApplication loadJobApplication(RetailscmUserContext userContext, String jobApplicationId, String [] tokensExpr) throws Exception;
	public JobApplication internalSaveJobApplication(RetailscmUserContext userContext, JobApplication jobApplication) throws Exception;
	public JobApplication internalSaveJobApplication(RetailscmUserContext userContext, JobApplication jobApplication,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String jobApplicationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, JobApplication newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  JobApplication addEmployee(RetailscmUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  JobApplication removeEmployee(RetailscmUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  JobApplication updateEmployee(RetailscmUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


