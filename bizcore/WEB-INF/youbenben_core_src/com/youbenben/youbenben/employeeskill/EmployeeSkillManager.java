
package com.youbenben.youbenben.employeeskill;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeSkillManager extends BaseManager{

		

	public EmployeeSkill createEmployeeSkill(YoubenbenUserContext userContext, String employeeId,String skillTypeId,String description) throws Exception;
	public EmployeeSkill updateEmployeeSkill(YoubenbenUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeSkill loadEmployeeSkill(YoubenbenUserContext userContext, String employeeSkillId, String [] tokensExpr) throws Exception;
	public EmployeeSkill internalSaveEmployeeSkill(YoubenbenUserContext userContext, EmployeeSkill employeeSkill) throws Exception;
	public EmployeeSkill internalSaveEmployeeSkill(YoubenbenUserContext userContext, EmployeeSkill employeeSkill,Map<String,Object>option) throws Exception;

	public EmployeeSkill transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeSkillId, String anotherEmployeeId)  throws Exception;
 	public EmployeeSkill transferToAnotherSkillType(YoubenbenUserContext userContext, String employeeSkillId, String anotherSkillTypeId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeeSkillId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeSkill newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception;
  
	public Object listBySkillType(YoubenbenUserContext userContext,String skillTypeId) throws Exception;
	public Object listPageBySkillType(YoubenbenUserContext userContext,String skillTypeId, int start, int count) throws Exception;
  

}


