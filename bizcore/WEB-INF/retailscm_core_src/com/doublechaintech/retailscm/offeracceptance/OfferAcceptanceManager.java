
package com.doublechaintech.retailscm.offeracceptance;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface OfferAcceptanceManager extends BaseManager{

		

	public OfferAcceptance createOfferAcceptance(RetailscmUserContext userContext, String who,Date acceptTime,String comments) throws Exception;
	public OfferAcceptance updateOfferAcceptance(RetailscmUserContext userContext,String offerAcceptanceId, int offerAcceptanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OfferAcceptance loadOfferAcceptance(RetailscmUserContext userContext, String offerAcceptanceId, String [] tokensExpr) throws Exception;
	public OfferAcceptance internalSaveOfferAcceptance(RetailscmUserContext userContext, OfferAcceptance offerAcceptance) throws Exception;
	public OfferAcceptance internalSaveOfferAcceptance(RetailscmUserContext userContext, OfferAcceptance offerAcceptance,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String offerAcceptanceId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, OfferAcceptance newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String offerAcceptanceId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  OfferAcceptance addEmployee(RetailscmUserContext userContext, String offerAcceptanceId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  OfferAcceptance removeEmployee(RetailscmUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  OfferAcceptance updateEmployee(RetailscmUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


