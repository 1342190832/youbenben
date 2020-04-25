
package com.youbenben.youbenben.professioninterview;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ProfessionInterviewManager extends BaseManager{

		

	public ProfessionInterview createProfessionInterview(YoubenbenUserContext userContext, String who,Date interviewTime,String comments) throws Exception;
	public ProfessionInterview updateProfessionInterview(YoubenbenUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ProfessionInterview loadProfessionInterview(YoubenbenUserContext userContext, String professionInterviewId, String [] tokensExpr) throws Exception;
	public ProfessionInterview internalSaveProfessionInterview(YoubenbenUserContext userContext, ProfessionInterview professionInterview) throws Exception;
	public ProfessionInterview internalSaveProfessionInterview(YoubenbenUserContext userContext, ProfessionInterview professionInterview,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String professionInterviewId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ProfessionInterview newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  ProfessionInterview addEmployee(YoubenbenUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  ProfessionInterview removeEmployee(YoubenbenUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  ProfessionInterview updateEmployee(YoubenbenUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


