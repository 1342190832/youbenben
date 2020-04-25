
package com.youbenben.youbenben.employeecompanytraining;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EmployeeCompanyTrainingManager extends BaseManager{

		

	public EmployeeCompanyTraining createEmployeeCompanyTraining(YoubenbenUserContext userContext, String employeeId,String trainingId,String scoringId) throws Exception;
	public EmployeeCompanyTraining updateEmployeeCompanyTraining(YoubenbenUserContext userContext,String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeCompanyTraining loadEmployeeCompanyTraining(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String [] tokensExpr) throws Exception;
	public EmployeeCompanyTraining internalSaveEmployeeCompanyTraining(YoubenbenUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining) throws Exception;
	public EmployeeCompanyTraining internalSaveEmployeeCompanyTraining(YoubenbenUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining,Map<String,Object>option) throws Exception;

	public EmployeeCompanyTraining transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String anotherEmployeeId)  throws Exception;
 	public EmployeeCompanyTraining transferToAnotherTraining(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String anotherTrainingId)  throws Exception;
 	public EmployeeCompanyTraining transferToAnotherScoring(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String anotherScoringId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String employeeCompanyTrainingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeCompanyTraining newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception;
  
	public Object listByTraining(YoubenbenUserContext userContext,String trainingId) throws Exception;
	public Object listPageByTraining(YoubenbenUserContext userContext,String trainingId, int start, int count) throws Exception;
  
	public Object listByScoring(YoubenbenUserContext userContext,String scoringId) throws Exception;
	public Object listPageByScoring(YoubenbenUserContext userContext,String scoringId, int start, int count) throws Exception;
  

}


