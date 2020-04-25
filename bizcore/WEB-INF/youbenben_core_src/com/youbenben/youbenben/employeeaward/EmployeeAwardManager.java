
package com.youbenben.youbenben.employeeaward;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeAwardManager extends BaseManager{

		

	public EmployeeAward createEmployeeAward(YoubenbenUserContext userContext, String employeeId,Date completeTime,String type,String remark) throws Exception;
	public EmployeeAward updateEmployeeAward(YoubenbenUserContext userContext,String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeAward loadEmployeeAward(YoubenbenUserContext userContext, String employeeAwardId, String [] tokensExpr) throws Exception;
	public EmployeeAward internalSaveEmployeeAward(YoubenbenUserContext userContext, EmployeeAward employeeAward) throws Exception;
	public EmployeeAward internalSaveEmployeeAward(YoubenbenUserContext userContext, EmployeeAward employeeAward,Map<String,Object>option) throws Exception;

	public EmployeeAward transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeAwardId, String anotherEmployeeId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeeAwardId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeAward newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception;
  

}


