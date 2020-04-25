
package com.youbenben.youbenben.interviewtype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface InterviewTypeManager extends BaseManager{

		

	public InterviewType createInterviewType(YoubenbenUserContext userContext, String code,String companyId,String description,String detailDescription) throws Exception;
	public InterviewType updateInterviewType(YoubenbenUserContext userContext,String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public InterviewType loadInterviewType(YoubenbenUserContext userContext, String interviewTypeId, String [] tokensExpr) throws Exception;
	public InterviewType internalSaveInterviewType(YoubenbenUserContext userContext, InterviewType interviewType) throws Exception;
	public InterviewType internalSaveInterviewType(YoubenbenUserContext userContext, InterviewType interviewType,Map<String,Object>option) throws Exception;

	public InterviewType transferToAnotherCompany(YoubenbenUserContext userContext, String interviewTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String interviewTypeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, InterviewType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeInterviewManager getEmployeeInterviewManager(YoubenbenUserContext userContext, String interviewTypeId, String employeeId, String remark ,String [] tokensExpr)  throws Exception;

	public  InterviewType addEmployeeInterview(YoubenbenUserContext userContext, String interviewTypeId, String employeeId, String remark , String [] tokensExpr)  throws Exception;
	public  InterviewType removeEmployeeInterview(YoubenbenUserContext userContext, String interviewTypeId, String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr)  throws Exception;
	public  InterviewType updateEmployeeInterview(YoubenbenUserContext userContext, String interviewTypeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


