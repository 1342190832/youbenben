
package com.youbenben.youbenben.scoring;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ScoringManager extends BaseManager{

		

	public Scoring createScoring(YoubenbenUserContext userContext, String scoredBy,int score,String comment) throws Exception;
	public Scoring updateScoring(YoubenbenUserContext userContext,String scoringId, int scoringVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Scoring loadScoring(YoubenbenUserContext userContext, String scoringId, String [] tokensExpr) throws Exception;
	public Scoring internalSaveScoring(YoubenbenUserContext userContext, Scoring scoring) throws Exception;
	public Scoring internalSaveScoring(YoubenbenUserContext userContext, Scoring scoring,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String scoringId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, Scoring newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeCompanyTrainingManager getEmployeeCompanyTrainingManager(YoubenbenUserContext userContext, String scoringId, String employeeId, String trainingId ,String [] tokensExpr)  throws Exception;

	public  Scoring addEmployeeCompanyTraining(YoubenbenUserContext userContext, String scoringId, String employeeId, String trainingId , String [] tokensExpr)  throws Exception;
	public  Scoring removeEmployeeCompanyTraining(YoubenbenUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  Scoring updateEmployeeCompanyTraining(YoubenbenUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


