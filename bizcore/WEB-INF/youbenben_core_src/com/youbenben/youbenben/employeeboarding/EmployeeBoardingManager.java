
package com.youbenben.youbenben.employeeboarding;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeBoardingManager extends BaseManager{

		

	public EmployeeBoarding createEmployeeBoarding(YoubenbenUserContext userContext, String who,Date employTime,String comments) throws Exception;
	public EmployeeBoarding updateEmployeeBoarding(YoubenbenUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeBoarding loadEmployeeBoarding(YoubenbenUserContext userContext, String employeeBoardingId, String [] tokensExpr) throws Exception;
	public EmployeeBoarding internalSaveEmployeeBoarding(YoubenbenUserContext userContext, EmployeeBoarding employeeBoarding) throws Exception;
	public EmployeeBoarding internalSaveEmployeeBoarding(YoubenbenUserContext userContext, EmployeeBoarding employeeBoarding,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String employeeBoardingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeBoarding newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  EmployeeBoarding addEmployee(YoubenbenUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String terminationId , String [] tokensExpr)  throws Exception;
	public  EmployeeBoarding removeEmployee(YoubenbenUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  EmployeeBoarding updateEmployee(YoubenbenUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


