
package com.youbenben.youbenben.skilltype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SkillTypeManager extends BaseManager{

		

	public SkillType createSkillType(YoubenbenUserContext userContext, String code,String companyId,String description) throws Exception;
	public SkillType updateSkillType(YoubenbenUserContext userContext,String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SkillType loadSkillType(YoubenbenUserContext userContext, String skillTypeId, String [] tokensExpr) throws Exception;
	public SkillType internalSaveSkillType(YoubenbenUserContext userContext, SkillType skillType) throws Exception;
	public SkillType internalSaveSkillType(YoubenbenUserContext userContext, SkillType skillType,Map<String,Object>option) throws Exception;

	public SkillType transferToAnotherCompany(YoubenbenUserContext userContext, String skillTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String skillTypeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SkillType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeSkillManager getEmployeeSkillManager(YoubenbenUserContext userContext, String skillTypeId, String employeeId, String description ,String [] tokensExpr)  throws Exception;

	public  SkillType addEmployeeSkill(YoubenbenUserContext userContext, String skillTypeId, String employeeId, String description , String [] tokensExpr)  throws Exception;
	public  SkillType removeEmployeeSkill(YoubenbenUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion,String [] tokensExpr)  throws Exception;
	public  SkillType updateEmployeeSkill(YoubenbenUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


