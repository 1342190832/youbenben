
package com.youbenben.youbenben.employeequalifier;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeQualifierManager extends BaseManager{

		

	public EmployeeQualifier createEmployeeQualifier(YoubenbenUserContext userContext, String employeeId,Date qualifiedTime,String type,String level,String remark) throws Exception;
	public EmployeeQualifier updateEmployeeQualifier(YoubenbenUserContext userContext,String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeQualifier loadEmployeeQualifier(YoubenbenUserContext userContext, String employeeQualifierId, String [] tokensExpr) throws Exception;
	public EmployeeQualifier internalSaveEmployeeQualifier(YoubenbenUserContext userContext, EmployeeQualifier employeeQualifier) throws Exception;
	public EmployeeQualifier internalSaveEmployeeQualifier(YoubenbenUserContext userContext, EmployeeQualifier employeeQualifier,Map<String,Object>option) throws Exception;

	public EmployeeQualifier transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeQualifierId, String anotherEmployeeId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeeQualifierId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeQualifier newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception;
  

}


