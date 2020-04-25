
package com.youbenben.youbenben.occupationtype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface OccupationTypeManager extends BaseManager{

		

	public OccupationType createOccupationType(YoubenbenUserContext userContext, String code,String companyId,String description,String detailDescription) throws Exception;
	public OccupationType updateOccupationType(YoubenbenUserContext userContext,String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OccupationType loadOccupationType(YoubenbenUserContext userContext, String occupationTypeId, String [] tokensExpr) throws Exception;
	public OccupationType internalSaveOccupationType(YoubenbenUserContext userContext, OccupationType occupationType) throws Exception;
	public OccupationType internalSaveOccupationType(YoubenbenUserContext userContext, OccupationType occupationType,Map<String,Object>option) throws Exception;

	public OccupationType transferToAnotherCompany(YoubenbenUserContext userContext, String occupationTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String occupationTypeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, OccupationType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String occupationTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  OccupationType addEmployee(YoubenbenUserContext userContext, String occupationTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  OccupationType removeEmployee(YoubenbenUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  OccupationType updateEmployee(YoubenbenUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


