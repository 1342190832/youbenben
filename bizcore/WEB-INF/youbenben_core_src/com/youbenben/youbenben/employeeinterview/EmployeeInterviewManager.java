
package com.youbenben.youbenben.employeeinterview;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeInterviewManager extends BaseManager{

		

	public EmployeeInterview createEmployeeInterview(YoubenbenUserContext userContext, String employeeId,String interviewTypeId,String remark) throws Exception;
	public EmployeeInterview updateEmployeeInterview(YoubenbenUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeInterview loadEmployeeInterview(YoubenbenUserContext userContext, String employeeInterviewId, String [] tokensExpr) throws Exception;
	public EmployeeInterview internalSaveEmployeeInterview(YoubenbenUserContext userContext, EmployeeInterview employeeInterview) throws Exception;
	public EmployeeInterview internalSaveEmployeeInterview(YoubenbenUserContext userContext, EmployeeInterview employeeInterview,Map<String,Object>option) throws Exception;

	public EmployeeInterview transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeInterviewId, String anotherEmployeeId)  throws Exception;
 	public EmployeeInterview transferToAnotherInterviewType(YoubenbenUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeeInterviewId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeInterview newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception;
  
	public Object listByInterviewType(YoubenbenUserContext userContext,String interviewTypeId) throws Exception;
	public Object listPageByInterviewType(YoubenbenUserContext userContext,String interviewTypeId, int start, int count) throws Exception;
  

}


