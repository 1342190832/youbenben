
package com.youbenben.youbenben.responsibilitytype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ResponsibilityTypeManager extends BaseManager{

		

	public ResponsibilityType createResponsibilityType(YoubenbenUserContext userContext, String code,String companyId,String baseDescription,String detailDescription) throws Exception;
	public ResponsibilityType updateResponsibilityType(YoubenbenUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ResponsibilityType loadResponsibilityType(YoubenbenUserContext userContext, String responsibilityTypeId, String [] tokensExpr) throws Exception;
	public ResponsibilityType internalSaveResponsibilityType(YoubenbenUserContext userContext, ResponsibilityType responsibilityType) throws Exception;
	public ResponsibilityType internalSaveResponsibilityType(YoubenbenUserContext userContext, ResponsibilityType responsibilityType,Map<String,Object>option) throws Exception;

	public ResponsibilityType transferToAnotherCompany(YoubenbenUserContext userContext, String responsibilityTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String responsibilityTypeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ResponsibilityType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  ResponsibilityType addEmployee(YoubenbenUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  ResponsibilityType removeEmployee(YoubenbenUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  ResponsibilityType updateEmployee(YoubenbenUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


