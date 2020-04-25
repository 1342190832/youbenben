
package com.youbenben.youbenben.levelthreedepartment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface LevelThreeDepartmentManager extends BaseManager{

		

	public LevelThreeDepartment createLevelThreeDepartment(YoubenbenUserContext userContext, String belongsToId,String name,String description,Date founded) throws Exception;
	public LevelThreeDepartment updateLevelThreeDepartment(YoubenbenUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelThreeDepartment loadLevelThreeDepartment(YoubenbenUserContext userContext, String levelThreeDepartmentId, String [] tokensExpr) throws Exception;
	public LevelThreeDepartment internalSaveLevelThreeDepartment(YoubenbenUserContext userContext, LevelThreeDepartment levelThreeDepartment) throws Exception;
	public LevelThreeDepartment internalSaveLevelThreeDepartment(YoubenbenUserContext userContext, LevelThreeDepartment levelThreeDepartment,Map<String,Object>option) throws Exception;

	public LevelThreeDepartment transferToAnotherBelongsTo(YoubenbenUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String levelThreeDepartmentId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, LevelThreeDepartment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  LevelThreeDepartment addEmployee(YoubenbenUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  LevelThreeDepartment removeEmployee(YoubenbenUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  LevelThreeDepartment updateEmployee(YoubenbenUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


