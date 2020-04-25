
package com.youbenben.youbenben.hrinterview;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface HrInterviewManager extends BaseManager{

		

	public HrInterview createHrInterview(YoubenbenUserContext userContext, String who,Date interviewTime,String comments) throws Exception;
	public HrInterview updateHrInterview(YoubenbenUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public HrInterview loadHrInterview(YoubenbenUserContext userContext, String hrInterviewId, String [] tokensExpr) throws Exception;
	public HrInterview internalSaveHrInterview(YoubenbenUserContext userContext, HrInterview hrInterview) throws Exception;
	public HrInterview internalSaveHrInterview(YoubenbenUserContext userContext, HrInterview hrInterview,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String hrInterviewId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, HrInterview newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  HrInterview addEmployee(YoubenbenUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  HrInterview removeEmployee(YoubenbenUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  HrInterview updateEmployee(YoubenbenUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


