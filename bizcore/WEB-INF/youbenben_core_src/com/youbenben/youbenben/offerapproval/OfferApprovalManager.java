
package com.youbenben.youbenben.offerapproval;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface OfferApprovalManager extends BaseManager{

		

	public OfferApproval createOfferApproval(YoubenbenUserContext userContext, String who,Date approveTime,String comments) throws Exception;
	public OfferApproval updateOfferApproval(YoubenbenUserContext userContext,String offerApprovalId, int offerApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OfferApproval loadOfferApproval(YoubenbenUserContext userContext, String offerApprovalId, String [] tokensExpr) throws Exception;
	public OfferApproval internalSaveOfferApproval(YoubenbenUserContext userContext, OfferApproval offerApproval) throws Exception;
	public OfferApproval internalSaveOfferApproval(YoubenbenUserContext userContext, OfferApproval offerApproval,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String offerApprovalId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, OfferApproval newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(YoubenbenUserContext userContext, String offerApprovalId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerAcceptanceId, String employeeBoardingId, String terminationId ,String [] tokensExpr)  throws Exception;

	public  OfferApproval addEmployee(YoubenbenUserContext userContext, String offerApprovalId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerAcceptanceId, String employeeBoardingId, String terminationId , String [] tokensExpr)  throws Exception;
	public  OfferApproval removeEmployee(YoubenbenUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  OfferApproval updateEmployee(YoubenbenUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


