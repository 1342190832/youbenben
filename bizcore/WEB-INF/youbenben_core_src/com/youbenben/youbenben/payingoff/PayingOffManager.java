
package com.youbenben.youbenben.payingoff;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface PayingOffManager extends BaseManager{

		

	public PayingOff createPayingOff(YoubenbenUserContext userContext, String who,String paidForId,Date paidTime,BigDecimal amount) throws Exception;
	public PayingOff updatePayingOff(YoubenbenUserContext userContext,String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PayingOff loadPayingOff(YoubenbenUserContext userContext, String payingOffId, String [] tokensExpr) throws Exception;
	public PayingOff internalSavePayingOff(YoubenbenUserContext userContext, PayingOff payingOff) throws Exception;
	public PayingOff internalSavePayingOff(YoubenbenUserContext userContext, PayingOff payingOff,Map<String,Object>option) throws Exception;

	public PayingOff transferToAnotherPaidFor(YoubenbenUserContext userContext, String payingOffId, String anotherPaidForId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String payingOffId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, PayingOff newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeSalarySheetManager getEmployeeSalarySheetManager(YoubenbenUserContext userContext, String payingOffId, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance ,String [] tokensExpr)  throws Exception;

	public  PayingOff addEmployeeSalarySheet(YoubenbenUserContext userContext, String payingOffId, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance , String [] tokensExpr)  throws Exception;
	public  PayingOff removeEmployeeSalarySheet(YoubenbenUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr)  throws Exception;
	public  PayingOff updateEmployeeSalarySheet(YoubenbenUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByPaidFor(YoubenbenUserContext userContext,String paidForId) throws Exception;
	public Object listPageByPaidFor(YoubenbenUserContext userContext,String paidForId, int start, int count) throws Exception;
  

}


