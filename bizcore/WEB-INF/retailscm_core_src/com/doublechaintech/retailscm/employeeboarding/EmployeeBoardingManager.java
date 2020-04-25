
package com.doublechaintech.retailscm.employeeboarding;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface EmployeeBoardingManager extends BaseManager{

		

	public EmployeeBoarding createEmployeeBoarding(RetailscmUserContext userContext, String who,Date employTime,String comments) throws Exception;
	public EmployeeBoarding updateEmployeeBoarding(RetailscmUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeBoarding loadEmployeeBoarding(RetailscmUserContext userContext, String employeeBoardingId, String [] tokensExpr) throws Exception;
	public EmployeeBoarding internalSaveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding) throws Exception;
	public EmployeeBoarding internalSaveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String employeeBoardingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeBoarding newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  EmployeeBoarding addEmployee(RetailscmUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String terminationId , String [] tokensExpr)  throws Exception;
	public  EmployeeBoarding removeEmployee(RetailscmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  EmployeeBoarding updateEmployee(RetailscmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


