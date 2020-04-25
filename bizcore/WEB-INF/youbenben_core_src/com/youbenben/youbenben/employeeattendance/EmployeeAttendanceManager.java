
package com.youbenben.youbenben.employeeattendance;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeAttendanceManager extends BaseManager{

		

	public EmployeeAttendance createEmployeeAttendance(YoubenbenUserContext userContext, String employeeId,Date enterTime,Date leaveTime,int durationHours,String remark) throws Exception;
	public EmployeeAttendance updateEmployeeAttendance(YoubenbenUserContext userContext,String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeAttendance loadEmployeeAttendance(YoubenbenUserContext userContext, String employeeAttendanceId, String [] tokensExpr) throws Exception;
	public EmployeeAttendance internalSaveEmployeeAttendance(YoubenbenUserContext userContext, EmployeeAttendance employeeAttendance) throws Exception;
	public EmployeeAttendance internalSaveEmployeeAttendance(YoubenbenUserContext userContext, EmployeeAttendance employeeAttendance,Map<String,Object>option) throws Exception;

	public EmployeeAttendance transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeAttendanceId, String anotherEmployeeId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeeAttendanceId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeAttendance newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception;
  

}


