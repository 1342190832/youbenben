
package com.youbenben.youbenben.companytraining;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface CompanyTrainingManager extends BaseManager{

		

	public CompanyTraining createCompanyTraining(YoubenbenUserContext userContext, String title,String companyId,String instructorId,String trainingCourseTypeId,Date timeStart,int durationHours) throws Exception;
	public CompanyTraining updateCompanyTraining(YoubenbenUserContext userContext,String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CompanyTraining loadCompanyTraining(YoubenbenUserContext userContext, String companyTrainingId, String [] tokensExpr) throws Exception;
	public CompanyTraining internalSaveCompanyTraining(YoubenbenUserContext userContext, CompanyTraining companyTraining) throws Exception;
	public CompanyTraining internalSaveCompanyTraining(YoubenbenUserContext userContext, CompanyTraining companyTraining,Map<String,Object>option) throws Exception;

	public CompanyTraining transferToAnotherCompany(YoubenbenUserContext userContext, String companyTrainingId, String anotherCompanyId)  throws Exception;
 	public CompanyTraining transferToAnotherInstructor(YoubenbenUserContext userContext, String companyTrainingId, String anotherInstructorId)  throws Exception;
 	public CompanyTraining transferToAnotherTrainingCourseType(YoubenbenUserContext userContext, String companyTrainingId, String anotherTrainingCourseTypeId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String companyTrainingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, CompanyTraining newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeCompanyTrainingManager getEmployeeCompanyTrainingManager(YoubenbenUserContext userContext, String companyTrainingId, String employeeId, String scoringId ,String [] tokensExpr)  throws Exception;

	public  CompanyTraining addEmployeeCompanyTraining(YoubenbenUserContext userContext, String companyTrainingId, String employeeId, String scoringId , String [] tokensExpr)  throws Exception;
	public  CompanyTraining removeEmployeeCompanyTraining(YoubenbenUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  CompanyTraining updateEmployeeCompanyTraining(YoubenbenUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  
	public Object listByInstructor(YoubenbenUserContext userContext,String instructorId) throws Exception;
	public Object listPageByInstructor(YoubenbenUserContext userContext,String instructorId, int start, int count) throws Exception;
  
	public Object listByTrainingCourseType(YoubenbenUserContext userContext,String trainingCourseTypeId) throws Exception;
	public Object listPageByTrainingCourseType(YoubenbenUserContext userContext,String trainingCourseTypeId, int start, int count) throws Exception;
  

}


