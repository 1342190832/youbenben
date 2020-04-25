
package com.youbenben.youbenben.employeeperformance;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeePerformanceManager extends BaseManager{

		

	public EmployeePerformance createEmployeePerformance(YoubenbenUserContext userContext, String employeeId,String performanceComment) throws Exception;
	public EmployeePerformance updateEmployeePerformance(YoubenbenUserContext userContext,String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeePerformance loadEmployeePerformance(YoubenbenUserContext userContext, String employeePerformanceId, String [] tokensExpr) throws Exception;
	public EmployeePerformance internalSaveEmployeePerformance(YoubenbenUserContext userContext, EmployeePerformance employeePerformance) throws Exception;
	public EmployeePerformance internalSaveEmployeePerformance(YoubenbenUserContext userContext, EmployeePerformance employeePerformance,Map<String,Object>option) throws Exception;

	public EmployeePerformance transferToAnotherEmployee(YoubenbenUserContext userContext, String employeePerformanceId, String anotherEmployeeId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeePerformanceId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeePerformance newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception;
  

}


