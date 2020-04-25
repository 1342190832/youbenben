
package com.youbenben.youbenben.salarygrade;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SalaryGradeManager extends BaseManager{

		

	public SalaryGrade createSalaryGrade(YoubenbenUserContext userContext, String code,String companyId,String name,String detailDescription) throws Exception;
	public SalaryGrade updateSalaryGrade(YoubenbenUserContext userContext,String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SalaryGrade loadSalaryGrade(YoubenbenUserContext userContext, String salaryGradeId, String [] tokensExpr) throws Exception;
	public SalaryGrade internalSaveSalaryGrade(YoubenbenUserContext userContext, SalaryGrade salaryGrade) throws Exception;
	public SalaryGrade internalSaveSalaryGrade(YoubenbenUserContext userContext, SalaryGrade salaryGrade,Map<String,Object>option) throws Exception;

	public SalaryGrade transferToAnotherCompany(YoubenbenUserContext userContext, String salaryGradeId, String anotherCompanyId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String salaryGradeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SalaryGrade newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String salaryGradeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  SalaryGrade addEmployee(YoubenbenUserContext userContext, String salaryGradeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  SalaryGrade removeEmployee(YoubenbenUserContext userContext, String salaryGradeId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  SalaryGrade updateEmployee(YoubenbenUserContext userContext, String salaryGradeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeSalarySheetManager getEmployeeSalarySheetManager(YoubenbenUserContext userContext, String salaryGradeId, String employeeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String payingOffId ,String [] tokensExpr)  throws Exception;

	public  SalaryGrade addEmployeeSalarySheet(YoubenbenUserContext userContext, String salaryGradeId, String employeeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String payingOffId , String [] tokensExpr)  throws Exception;
	public  SalaryGrade removeEmployeeSalarySheet(YoubenbenUserContext userContext, String salaryGradeId, String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr)  throws Exception;
	public  SalaryGrade updateEmployeeSalarySheet(YoubenbenUserContext userContext, String salaryGradeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


