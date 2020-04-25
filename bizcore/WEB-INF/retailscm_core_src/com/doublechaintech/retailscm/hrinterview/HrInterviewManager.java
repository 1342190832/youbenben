
package com.doublechaintech.retailscm.hrinterview;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface HrInterviewManager extends BaseManager{

		

	public HrInterview createHrInterview(RetailscmUserContext userContext, String who,Date interviewTime,String comments) throws Exception;
	public HrInterview updateHrInterview(RetailscmUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public HrInterview loadHrInterview(RetailscmUserContext userContext, String hrInterviewId, String [] tokensExpr) throws Exception;
	public HrInterview internalSaveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview) throws Exception;
	public HrInterview internalSaveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String hrInterviewId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, HrInterview newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  HrInterview addEmployee(RetailscmUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  HrInterview removeEmployee(RetailscmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  HrInterview updateEmployee(RetailscmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


