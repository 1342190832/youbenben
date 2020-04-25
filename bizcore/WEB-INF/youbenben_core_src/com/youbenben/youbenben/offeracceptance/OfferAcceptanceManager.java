
package com.youbenben.youbenben.offeracceptance;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface OfferAcceptanceManager extends BaseManager{

		

	public OfferAcceptance createOfferAcceptance(YoubenbenUserContext userContext, String who,Date acceptTime,String comments) throws Exception;
	public OfferAcceptance updateOfferAcceptance(YoubenbenUserContext userContext,String offerAcceptanceId, int offerAcceptanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OfferAcceptance loadOfferAcceptance(YoubenbenUserContext userContext, String offerAcceptanceId, String [] tokensExpr) throws Exception;
	public OfferAcceptance internalSaveOfferAcceptance(YoubenbenUserContext userContext, OfferAcceptance offerAcceptance) throws Exception;
	public OfferAcceptance internalSaveOfferAcceptance(YoubenbenUserContext userContext, OfferAcceptance offerAcceptance,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String offerAcceptanceId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, OfferAcceptance newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String offerAcceptanceId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  OfferAcceptance addEmployee(YoubenbenUserContext userContext, String offerAcceptanceId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  OfferAcceptance removeEmployee(YoubenbenUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  OfferAcceptance updateEmployee(YoubenbenUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


