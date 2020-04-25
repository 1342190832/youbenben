
package com.youbenben.youbenben.termination;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface TerminationManager extends BaseManager{

		

	public Termination createTermination(YoubenbenUserContext userContext, String reasonId,String typeId,String comment) throws Exception;
	public Termination updateTermination(YoubenbenUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Termination loadTermination(YoubenbenUserContext userContext, String terminationId, String [] tokensExpr) throws Exception;
	public Termination internalSaveTermination(YoubenbenUserContext userContext, Termination termination) throws Exception;
	public Termination internalSaveTermination(YoubenbenUserContext userContext, Termination termination,Map<String,Object>option) throws Exception;

	public Termination transferToAnotherReason(YoubenbenUserContext userContext, String terminationId, String anotherReasonId)  throws Exception;
 	public Termination transferToAnotherType(YoubenbenUserContext userContext, String terminationId, String anotherTypeId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String terminationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, Termination newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String terminationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId ,String [] tokensExpr)  throws Exception;

	public  Termination addEmployee(YoubenbenUserContext userContext, String terminationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId , String [] tokensExpr)  throws Exception;
	public  Termination removeEmployee(YoubenbenUserContext userContext, String terminationId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  Termination updateEmployee(YoubenbenUserContext userContext, String terminationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByReason(YoubenbenUserContext userContext,String reasonId) throws Exception;
	public Object listPageByReason(YoubenbenUserContext userContext,String reasonId, int start, int count) throws Exception;
  
	public Object listByType(YoubenbenUserContext userContext,String typeId) throws Exception;
	public Object listPageByType(YoubenbenUserContext userContext,String typeId, int start, int count) throws Exception;
  

}


