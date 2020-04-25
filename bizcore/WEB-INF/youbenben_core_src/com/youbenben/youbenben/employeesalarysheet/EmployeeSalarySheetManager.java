
package com.youbenben.youbenben.employeesalarysheet;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeSalarySheetManager extends BaseManager{

		

	public EmployeeSalarySheet createEmployeeSalarySheet(YoubenbenUserContext userContext, String employeeId,String currentSalaryGradeId,BigDecimal baseSalary,BigDecimal bonus,BigDecimal reward,BigDecimal personalTax,BigDecimal socialSecurity,BigDecimal housingFound,BigDecimal jobInsurance,String payingOffId) throws Exception;
	public EmployeeSalarySheet updateEmployeeSalarySheet(YoubenbenUserContext userContext,String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeSalarySheet loadEmployeeSalarySheet(YoubenbenUserContext userContext, String employeeSalarySheetId, String [] tokensExpr) throws Exception;
	public EmployeeSalarySheet internalSaveEmployeeSalarySheet(YoubenbenUserContext userContext, EmployeeSalarySheet employeeSalarySheet) throws Exception;
	public EmployeeSalarySheet internalSaveEmployeeSalarySheet(YoubenbenUserContext userContext, EmployeeSalarySheet employeeSalarySheet,Map<String,Object>option) throws Exception;

	public EmployeeSalarySheet transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeSalarySheetId, String anotherEmployeeId)  throws Exception;
 	public EmployeeSalarySheet transferToAnotherCurrentSalaryGrade(YoubenbenUserContext userContext, String employeeSalarySheetId, String anotherCurrentSalaryGradeId)  throws Exception;
 	public EmployeeSalarySheet transferToAnotherPayingOff(YoubenbenUserContext userContext, String employeeSalarySheetId, String anotherPayingOffId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeeSalarySheetId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeSalarySheet newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception;
  
	public Object listByCurrentSalaryGrade(YoubenbenUserContext userContext,String currentSalaryGradeId) throws Exception;
	public Object listPageByCurrentSalaryGrade(YoubenbenUserContext userContext,String currentSalaryGradeId, int start, int count) throws Exception;
  
	public Object listByPayingOff(YoubenbenUserContext userContext,String payingOffId) throws Exception;
	public Object listPageByPayingOff(YoubenbenUserContext userContext,String payingOffId, int start, int count) throws Exception;
  

}


