
package com.youbenben.youbenben.employeeeducation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeEducationManager extends BaseManager{

		

	public EmployeeEducation createEmployeeEducation(YoubenbenUserContext userContext, String employeeId,Date completeTime,String type,String remark) throws Exception;
	public EmployeeEducation updateEmployeeEducation(YoubenbenUserContext userContext,String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeEducation loadEmployeeEducation(YoubenbenUserContext userContext, String employeeEducationId, String [] tokensExpr) throws Exception;
	public EmployeeEducation internalSaveEmployeeEducation(YoubenbenUserContext userContext, EmployeeEducation employeeEducation) throws Exception;
	public EmployeeEducation internalSaveEmployeeEducation(YoubenbenUserContext userContext, EmployeeEducation employeeEducation,Map<String,Object>option) throws Exception;

	public EmployeeEducation transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeEducationId, String anotherEmployeeId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeeEducationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeEducation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception;
  

}


