
package com.doublechaintech.retailscm.professioninterview;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface ProfessionInterviewManager extends BaseManager{

		

	public ProfessionInterview createProfessionInterview(RetailscmUserContext userContext, String who,Date interviewTime,String comments) throws Exception;
	public ProfessionInterview updateProfessionInterview(RetailscmUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ProfessionInterview loadProfessionInterview(RetailscmUserContext userContext, String professionInterviewId, String [] tokensExpr) throws Exception;
	public ProfessionInterview internalSaveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview) throws Exception;
	public ProfessionInterview internalSaveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String professionInterviewId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ProfessionInterview newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  ProfessionInterview addEmployee(RetailscmUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  ProfessionInterview removeEmployee(RetailscmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  ProfessionInterview updateEmployee(RetailscmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


