
package com.youbenben.youbenben.trainingcoursetype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface TrainingCourseTypeManager extends BaseManager{

		

	public TrainingCourseType createTrainingCourseType(YoubenbenUserContext userContext, String code,String companyId,String name,String description) throws Exception;
	public TrainingCourseType updateTrainingCourseType(YoubenbenUserContext userContext,String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TrainingCourseType loadTrainingCourseType(YoubenbenUserContext userContext, String trainingCourseTypeId, String [] tokensExpr) throws Exception;
	public TrainingCourseType internalSaveTrainingCourseType(YoubenbenUserContext userContext, TrainingCourseType trainingCourseType) throws Exception;
	public TrainingCourseType internalSaveTrainingCourseType(YoubenbenUserContext userContext, TrainingCourseType trainingCourseType,Map<String,Object>option) throws Exception;

	public TrainingCourseType transferToAnotherCompany(YoubenbenUserContext userContext, String trainingCourseTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String trainingCourseTypeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, TrainingCourseType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CompanyTrainingManager getCompanyTrainingManager(YoubenbenUserContext userContext, String trainingCourseTypeId, String title, String companyId, String instructorId, Date timeStart, int durationHours ,String [] tokensExpr)  throws Exception;

	public  TrainingCourseType addCompanyTraining(YoubenbenUserContext userContext, String trainingCourseTypeId, String title, String companyId, String instructorId, Date timeStart, int durationHours , String [] tokensExpr)  throws Exception;
	public  TrainingCourseType removeCompanyTraining(YoubenbenUserContext userContext, String trainingCourseTypeId, String companyTrainingId, int companyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  TrainingCourseType updateCompanyTraining(YoubenbenUserContext userContext, String trainingCourseTypeId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


