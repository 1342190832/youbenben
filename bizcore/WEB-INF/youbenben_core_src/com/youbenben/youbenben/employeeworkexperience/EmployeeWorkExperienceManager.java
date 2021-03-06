
package com.youbenben.youbenben.employeeworkexperience;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeWorkExperienceManager extends BaseManager{

		

	public EmployeeWorkExperience createEmployeeWorkExperience(YoubenbenUserContext userContext, String employeeId,Date start,Date end,String company,String description) throws Exception;
	public EmployeeWorkExperience updateEmployeeWorkExperience(YoubenbenUserContext userContext,String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeWorkExperience loadEmployeeWorkExperience(YoubenbenUserContext userContext, String employeeWorkExperienceId, String [] tokensExpr) throws Exception;
	public EmployeeWorkExperience internalSaveEmployeeWorkExperience(YoubenbenUserContext userContext, EmployeeWorkExperience employeeWorkExperience) throws Exception;
	public EmployeeWorkExperience internalSaveEmployeeWorkExperience(YoubenbenUserContext userContext, EmployeeWorkExperience employeeWorkExperience,Map<String,Object>option) throws Exception;

	public EmployeeWorkExperience transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeWorkExperienceId, String anotherEmployeeId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeeWorkExperienceId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeWorkExperience newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception;
  

}


