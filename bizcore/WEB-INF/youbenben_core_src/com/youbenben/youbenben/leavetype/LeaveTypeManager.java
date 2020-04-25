
package com.youbenben.youbenben.leavetype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface LeaveTypeManager extends BaseManager{

		

	public LeaveType createLeaveType(YoubenbenUserContext userContext, String code,String companyId,String description,String detailDescription) throws Exception;
	public LeaveType updateLeaveType(YoubenbenUserContext userContext,String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LeaveType loadLeaveType(YoubenbenUserContext userContext, String leaveTypeId, String [] tokensExpr) throws Exception;
	public LeaveType internalSaveLeaveType(YoubenbenUserContext userContext, LeaveType leaveType) throws Exception;
	public LeaveType internalSaveLeaveType(YoubenbenUserContext userContext, LeaveType leaveType,Map<String,Object>option) throws Exception;

	public LeaveType transferToAnotherCompany(YoubenbenUserContext userContext, String leaveTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String leaveTypeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, LeaveType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeLeaveManager getEmployeeLeaveManager(YoubenbenUserContext userContext, String leaveTypeId, String whoId, int leaveDurationHour, String remark ,String [] tokensExpr)  throws Exception;

	public  LeaveType addEmployeeLeave(YoubenbenUserContext userContext, String leaveTypeId, String whoId, int leaveDurationHour, String remark , String [] tokensExpr)  throws Exception;
	public  LeaveType removeEmployeeLeave(YoubenbenUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr)  throws Exception;
	public  LeaveType updateEmployeeLeave(YoubenbenUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


