
package com.youbenben.youbenben.employeeleave;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeLeaveManager extends BaseManager{

		

	public EmployeeLeave createEmployeeLeave(YoubenbenUserContext userContext, String whoId,String typeId,int leaveDurationHour,String remark) throws Exception;
	public EmployeeLeave updateEmployeeLeave(YoubenbenUserContext userContext,String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeLeave loadEmployeeLeave(YoubenbenUserContext userContext, String employeeLeaveId, String [] tokensExpr) throws Exception;
	public EmployeeLeave internalSaveEmployeeLeave(YoubenbenUserContext userContext, EmployeeLeave employeeLeave) throws Exception;
	public EmployeeLeave internalSaveEmployeeLeave(YoubenbenUserContext userContext, EmployeeLeave employeeLeave,Map<String,Object>option) throws Exception;

	public EmployeeLeave transferToAnotherWho(YoubenbenUserContext userContext, String employeeLeaveId, String anotherWhoId)  throws Exception;
 	public EmployeeLeave transferToAnotherType(YoubenbenUserContext userContext, String employeeLeaveId, String anotherTypeId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeeLeaveId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeLeave newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByWho(YoubenbenUserContext userContext,String whoId) throws Exception;
	public Object listPageByWho(YoubenbenUserContext userContext,String whoId, int start, int count) throws Exception;
  
	public Object listByType(YoubenbenUserContext userContext,String typeId) throws Exception;
	public Object listPageByType(YoubenbenUserContext userContext,String typeId, int start, int count) throws Exception;
  

}


