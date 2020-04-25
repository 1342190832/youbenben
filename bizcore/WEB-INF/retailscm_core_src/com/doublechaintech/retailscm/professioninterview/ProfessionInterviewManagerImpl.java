
package com.doublechaintech.retailscm.professioninterview;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.employee.Employee;


import com.doublechaintech.retailscm.hrinterview.HrInterview;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.jobapplication.JobApplication;
import com.doublechaintech.retailscm.professioninterview.ProfessionInterview;
import com.doublechaintech.retailscm.offeracceptance.OfferAcceptance;
import com.doublechaintech.retailscm.employeeboarding.EmployeeBoarding;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.offerapproval.OfferApproval;






public class ProfessionInterviewManagerImpl extends CustomRetailscmCheckerManager implements ProfessionInterviewManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = ProfessionInterviewTokens.start().withTokenFromListName(listName).done();
		ProfessionInterview  professionInterview = (ProfessionInterview) this.loadProfessionInterview(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = professionInterview.collectRefercencesFromLists();
		professionInterviewDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, professionInterview, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new ProfessionInterviewGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "ProfessionInterview";
	@Override
	public ProfessionInterviewDAO daoOf(RetailscmUserContext userContext) {
		return professionInterviewDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ProfessionInterviewManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ProfessionInterviewManagerException(message);

	}



 	protected ProfessionInterview saveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview, String [] tokensExpr) throws Exception{	
 		//return getProfessionInterviewDAO().save(professionInterview, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProfessionInterview(userContext, professionInterview, tokens);
 	}
 	
 	protected ProfessionInterview saveProfessionInterviewDetail(RetailscmUserContext userContext, ProfessionInterview professionInterview) throws Exception{	

 		
 		return saveProfessionInterview(userContext, professionInterview, allTokens());
 	}
 	
 	public ProfessionInterview loadProfessionInterview(RetailscmUserContext userContext, String professionInterviewId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfProfessionInterview(professionInterviewId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProfessionInterviewManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProfessionInterview professionInterview = loadProfessionInterview( userContext, professionInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,professionInterview, tokens);
 	}
 	
 	
 	 public ProfessionInterview searchProfessionInterview(RetailscmUserContext userContext, String professionInterviewId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfProfessionInterview(professionInterviewId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProfessionInterviewManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ProfessionInterview professionInterview = loadProfessionInterview( userContext, professionInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,professionInterview, tokens);
 	}
 	
 	

 	protected ProfessionInterview present(RetailscmUserContext userContext, ProfessionInterview professionInterview, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,professionInterview,tokens);
		
		
		ProfessionInterview  professionInterviewToPresent = professionInterviewDaoOf(userContext).present(professionInterview, tokens);
		
		List<BaseEntity> entityListToNaming = professionInterviewToPresent.collectRefercencesFromLists();
		professionInterviewDaoOf(userContext).alias(entityListToNaming);
		
		return  professionInterviewToPresent;
		
		
	}
 
 	
 	
 	public ProfessionInterview loadProfessionInterviewDetail(RetailscmUserContext userContext, String professionInterviewId) throws Exception{	
 		ProfessionInterview professionInterview = loadProfessionInterview( userContext, professionInterviewId, allTokens());
 		return present(userContext,professionInterview, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String professionInterviewId) throws Exception{	
 		ProfessionInterview professionInterview = loadProfessionInterview( userContext, professionInterviewId, viewTokens());
 		return present(userContext,professionInterview, allTokens());
		
 	}
 	protected ProfessionInterview saveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview, Map<String,Object>tokens) throws Exception{	
 		return professionInterviewDaoOf(userContext).save(professionInterview, tokens);
 	}
 	protected ProfessionInterview loadProfessionInterview(RetailscmUserContext userContext, String professionInterviewId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfProfessionInterview(professionInterviewId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProfessionInterviewManagerException.class);

 
 		return professionInterviewDaoOf(userContext).load(professionInterviewId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProfessionInterview professionInterview, Map<String, Object> tokens){
		super.addActions(userContext, professionInterview, tokens);
		
		addAction(userContext, professionInterview, tokens,"@create","createProfessionInterview","createProfessionInterview/","main","primary");
		addAction(userContext, professionInterview, tokens,"@update","updateProfessionInterview","updateProfessionInterview/"+professionInterview.getId()+"/","main","primary");
		addAction(userContext, professionInterview, tokens,"@copy","cloneProfessionInterview","cloneProfessionInterview/"+professionInterview.getId()+"/","main","primary");
		
		addAction(userContext, professionInterview, tokens,"profession_interview.addEmployee","addEmployee","addEmployee/"+professionInterview.getId()+"/","employeeList","primary");
		addAction(userContext, professionInterview, tokens,"profession_interview.removeEmployee","removeEmployee","removeEmployee/"+professionInterview.getId()+"/","employeeList","primary");
		addAction(userContext, professionInterview, tokens,"profession_interview.updateEmployee","updateEmployee","updateEmployee/"+professionInterview.getId()+"/","employeeList","primary");
		addAction(userContext, professionInterview, tokens,"profession_interview.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+professionInterview.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProfessionInterview professionInterview, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ProfessionInterview createProfessionInterview(RetailscmUserContext userContext, String who,Date interviewTime,String comments) throws Exception
	//public ProfessionInterview createProfessionInterview(RetailscmUserContext userContext,String who, Date interviewTime, String comments) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfProfessionInterview(who);
		checkerOf(userContext).checkInterviewTimeOfProfessionInterview(interviewTime);
		checkerOf(userContext).checkCommentsOfProfessionInterview(comments);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);


		ProfessionInterview professionInterview=createNewProfessionInterview();	

		professionInterview.setWho(who);
		professionInterview.setInterviewTime(interviewTime);
		professionInterview.setComments(comments);

		professionInterview = saveProfessionInterview(userContext, professionInterview, emptyOptions());
		
		onNewInstanceCreated(userContext, professionInterview);
		return professionInterview;


	}
	protected ProfessionInterview createNewProfessionInterview()
	{

		return new ProfessionInterview();
	}

	protected void checkParamsForUpdatingProfessionInterview(RetailscmUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfProfessionInterview(professionInterviewId);
		checkerOf(userContext).checkVersionOfProfessionInterview( professionInterviewVersion);
		

		if(ProfessionInterview.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfProfessionInterview(parseString(newValueExpr));
		
			
		}
		if(ProfessionInterview.INTERVIEW_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkInterviewTimeOfProfessionInterview(parseDate(newValueExpr));
		
			
		}
		if(ProfessionInterview.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfProfessionInterview(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);


	}



	public ProfessionInterview clone(RetailscmUserContext userContext, String fromProfessionInterviewId) throws Exception{

		return professionInterviewDaoOf(userContext).clone(fromProfessionInterviewId, this.allTokens());
	}

	public ProfessionInterview internalSaveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview) throws Exception
	{
		return internalSaveProfessionInterview(userContext, professionInterview, allTokens());

	}
	public ProfessionInterview internalSaveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingProfessionInterview(userContext, professionInterviewId, professionInterviewVersion, property, newValueExpr, tokensExpr);


		synchronized(professionInterview){
			//will be good when the professionInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProfessionInterview.
			if (professionInterview.isChanged()){
			
			}
			professionInterview = saveProfessionInterview(userContext, professionInterview, options);
			return professionInterview;

		}

	}

	public ProfessionInterview updateProfessionInterview(RetailscmUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProfessionInterview(userContext, professionInterviewId, professionInterviewVersion, property, newValueExpr, tokensExpr);



		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		if(professionInterview.getVersion() != professionInterviewVersion){
			String message = "The target version("+professionInterview.getVersion()+") is not equals to version("+professionInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(professionInterview){
			//will be good when the professionInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProfessionInterview.
			
			professionInterview.changeProperty(property, newValueExpr);
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().done());
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
			//return saveProfessionInterview(userContext, professionInterview, tokens().done());
		}

	}

	public ProfessionInterview updateProfessionInterviewProperty(RetailscmUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProfessionInterview(userContext, professionInterviewId, professionInterviewVersion, property, newValueExpr, tokensExpr);

		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		if(professionInterview.getVersion() != professionInterviewVersion){
			String message = "The target version("+professionInterview.getVersion()+") is not equals to version("+professionInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(professionInterview){
			//will be good when the professionInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProfessionInterview.

			professionInterview.changeProperty(property, newValueExpr);
			
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().done());
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
			//return saveProfessionInterview(userContext, professionInterview, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ProfessionInterviewTokens tokens(){
		return ProfessionInterviewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProfessionInterviewTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProfessionInterviewTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String professionInterviewId, int professionInterviewVersion) throws Exception {
		//deleteInternal(userContext, professionInterviewId, professionInterviewVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String professionInterviewId, int professionInterviewVersion) throws Exception{

		professionInterviewDaoOf(userContext).delete(professionInterviewId, professionInterviewVersion);
	}

	public ProfessionInterview forgetByAll(RetailscmUserContext userContext, String professionInterviewId, int professionInterviewVersion) throws Exception {
		return forgetByAllInternal(userContext, professionInterviewId, professionInterviewVersion);
	}
	protected ProfessionInterview forgetByAllInternal(RetailscmUserContext userContext,
			String professionInterviewId, int professionInterviewVersion) throws Exception{

		return professionInterviewDaoOf(userContext).disconnectFromAll(professionInterviewId, professionInterviewVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProfessionInterviewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return professionInterviewDaoOf(userContext).deleteAll();
	}


	//disconnect ProfessionInterview with company in Employee
	protected ProfessionInterview breakWithEmployeeByCompany(RetailscmUserContext userContext, String professionInterviewId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				professionInterviewDaoOf(userContext).planToRemoveEmployeeListWithCompany(professionInterview, companyId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with department in Employee
	protected ProfessionInterview breakWithEmployeeByDepartment(RetailscmUserContext userContext, String professionInterviewId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				professionInterviewDaoOf(userContext).planToRemoveEmployeeListWithDepartment(professionInterview, departmentId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with occupation in Employee
	protected ProfessionInterview breakWithEmployeeByOccupation(RetailscmUserContext userContext, String professionInterviewId, String occupationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				professionInterviewDaoOf(userContext).planToRemoveEmployeeListWithOccupation(professionInterview, occupationId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with responsible_for in Employee
	protected ProfessionInterview breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String professionInterviewId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				professionInterviewDaoOf(userContext).planToRemoveEmployeeListWithResponsibleFor(professionInterview, responsibleForId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with current_salary_grade in Employee
	protected ProfessionInterview breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String professionInterviewId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				professionInterviewDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(professionInterview, currentSalaryGradeId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with job_application in Employee
	protected ProfessionInterview breakWithEmployeeByJobApplication(RetailscmUserContext userContext, String professionInterviewId, String jobApplicationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				professionInterviewDaoOf(userContext).planToRemoveEmployeeListWithJobApplication(professionInterview, jobApplicationId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with hr_interview in Employee
	protected ProfessionInterview breakWithEmployeeByHrInterview(RetailscmUserContext userContext, String professionInterviewId, String hrInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				professionInterviewDaoOf(userContext).planToRemoveEmployeeListWithHrInterview(professionInterview, hrInterviewId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with offer_approval in Employee
	protected ProfessionInterview breakWithEmployeeByOfferApproval(RetailscmUserContext userContext, String professionInterviewId, String offerApprovalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				professionInterviewDaoOf(userContext).planToRemoveEmployeeListWithOfferApproval(professionInterview, offerApprovalId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with offer_acceptance in Employee
	protected ProfessionInterview breakWithEmployeeByOfferAcceptance(RetailscmUserContext userContext, String professionInterviewId, String offerAcceptanceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				professionInterviewDaoOf(userContext).planToRemoveEmployeeListWithOfferAcceptance(professionInterview, offerAcceptanceId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with employee_boarding in Employee
	protected ProfessionInterview breakWithEmployeeByEmployeeBoarding(RetailscmUserContext userContext, String professionInterviewId, String employeeBoardingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				professionInterviewDaoOf(userContext).planToRemoveEmployeeListWithEmployeeBoarding(professionInterview, employeeBoardingId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}
	//disconnect ProfessionInterview with termination in Employee
	protected ProfessionInterview breakWithEmployeeByTermination(RetailscmUserContext userContext, String professionInterviewId, String terminationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());

			synchronized(professionInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				professionInterviewDaoOf(userContext).planToRemoveEmployeeListWithTermination(professionInterview, terminationId, this.emptyOptions());

				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				return professionInterview;
			}
	}






	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfProfessionInterview(professionInterviewId);

		
		checkerOf(userContext).checkCompanyIdOfEmployee(companyId);
		
		checkerOf(userContext).checkTitleOfEmployee(title);
		
		checkerOf(userContext).checkDepartmentIdOfEmployee(departmentId);
		
		checkerOf(userContext).checkFamilyNameOfEmployee(familyName);
		
		checkerOf(userContext).checkGivenNameOfEmployee(givenName);
		
		checkerOf(userContext).checkEmailOfEmployee(email);
		
		checkerOf(userContext).checkCityOfEmployee(city);
		
		checkerOf(userContext).checkAddressOfEmployee(address);
		
		checkerOf(userContext).checkCellPhoneOfEmployee(cellPhone);
		
		checkerOf(userContext).checkOccupationIdOfEmployee(occupationId);
		
		checkerOf(userContext).checkResponsibleForIdOfEmployee(responsibleForId);
		
		checkerOf(userContext).checkCurrentSalaryGradeIdOfEmployee(currentSalaryGradeId);
		
		checkerOf(userContext).checkSalaryAccountOfEmployee(salaryAccount);
		
		checkerOf(userContext).checkJobApplicationIdOfEmployee(jobApplicationId);
		
		checkerOf(userContext).checkHrInterviewIdOfEmployee(hrInterviewId);
		
		checkerOf(userContext).checkOfferApprovalIdOfEmployee(offerApprovalId);
		
		checkerOf(userContext).checkOfferAcceptanceIdOfEmployee(offerAcceptanceId);
		
		checkerOf(userContext).checkEmployeeBoardingIdOfEmployee(employeeBoardingId);
		
		checkerOf(userContext).checkTerminationIdOfEmployee(terminationId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);


	}
	public  ProfessionInterview addEmployee(RetailscmUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,professionInterviewId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId);

		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, emptyOptions());
		synchronized(professionInterview){
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			professionInterview.addEmployee( employee );
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String professionInterviewId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfProfessionInterview(professionInterviewId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);

	}
	public  ProfessionInterview updateEmployeeProperties(RetailscmUserContext userContext, String professionInterviewId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,professionInterviewId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		ProfessionInterview professionInterviewToUpdate = loadProfessionInterview(userContext, professionInterviewId, options);

		if(professionInterviewToUpdate.getEmployeeList().isEmpty()){
			throw new ProfessionInterviewManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = professionInterviewToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,professionInterviewId,name, code, used,tokensExpr);
		ProfessionInterview professionInterview = saveProfessionInterview(userContext, professionInterviewToUpdate, tokens().withEmployeeList().done());
		synchronized(professionInterview){
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId) throws Exception{

		Employee employee = new Employee();
		
		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		employee.setCompany(company);		
		employee.setTitle(title);		
		LevelThreeDepartment  department = new LevelThreeDepartment();
		department.setId(departmentId);		
		employee.setDepartment(department);		
		employee.setFamilyName(familyName);		
		employee.setGivenName(givenName);		
		employee.setEmail(email);		
		employee.setCity(city);		
		employee.setAddress(address);		
		employee.setCellPhone(cellPhone);		
		OccupationType  occupation = new OccupationType();
		occupation.setId(occupationId);		
		employee.setOccupation(occupation);		
		ResponsibilityType  responsibleFor = new ResponsibilityType();
		responsibleFor.setId(responsibleForId);		
		employee.setResponsibleFor(responsibleFor);		
		SalaryGrade  currentSalaryGrade = new SalaryGrade();
		currentSalaryGrade.setId(currentSalaryGradeId);		
		employee.setCurrentSalaryGrade(currentSalaryGrade);		
		employee.setSalaryAccount(salaryAccount);		
		JobApplication  jobApplication = new JobApplication();
		jobApplication.setId(jobApplicationId);		
		employee.setJobApplication(jobApplication);		
		HrInterview  hrInterview = new HrInterview();
		hrInterview.setId(hrInterviewId);		
		employee.setHrInterview(hrInterview);		
		OfferApproval  offerApproval = new OfferApproval();
		offerApproval.setId(offerApprovalId);		
		employee.setOfferApproval(offerApproval);		
		OfferAcceptance  offerAcceptance = new OfferAcceptance();
		offerAcceptance.setId(offerAcceptanceId);		
		employee.setOfferAcceptance(offerAcceptance);		
		EmployeeBoarding  employeeBoarding = new EmployeeBoarding();
		employeeBoarding.setId(employeeBoardingId);		
		employee.setEmployeeBoarding(employeeBoarding);		
		Termination  termination = new Termination();
		termination.setId(terminationId);		
		employee.setTermination(termination);		
		employee.setLastUpdateTime(userContext.now());
	
		
		return employee;


	}

	protected Employee createIndexedEmployee(String id, int version){

		Employee employee = new Employee();
		employee.setId(id);
		employee.setVersion(version);
		return employee;

	}

	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String professionInterviewId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfProfessionInterview(professionInterviewId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);

	}
	public  ProfessionInterview removeEmployeeList(RetailscmUserContext userContext, String professionInterviewId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, professionInterviewId,  employeeIds, tokensExpr);


			ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
			synchronized(professionInterview){
				//Will be good when the professionInterview loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				professionInterviewDaoOf(userContext).planToRemoveEmployeeList(professionInterview, employeeIds, allTokens());
				professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, professionInterview.getEmployeeList());
				return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String professionInterviewId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfProfessionInterview( professionInterviewId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);

	}
	public  ProfessionInterview removeEmployee(RetailscmUserContext userContext, String professionInterviewId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,professionInterviewId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		synchronized(professionInterview){
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			professionInterview.removeEmployee( employee );
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String professionInterviewId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfProfessionInterview( professionInterviewId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);

	}
	public  ProfessionInterview copyEmployeeFrom(RetailscmUserContext userContext, String professionInterviewId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,professionInterviewId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, allTokens());
		synchronized(professionInterview){
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			professionInterview.copyEmployeeFrom( employee );
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)professionInterview.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfProfessionInterview(professionInterviewId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		

		if(Employee.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.FAMILY_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFamilyNameOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.GIVEN_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkGivenNameOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.CITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCityOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.ADDRESS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAddressOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.CELL_PHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCellPhoneOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.SALARY_ACCOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSalaryAccountOfEmployee(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProfessionInterviewManagerException.class);

	}

	public  ProfessionInterview updateEmployee(RetailscmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, professionInterviewId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		ProfessionInterview professionInterview = loadProfessionInterview(userContext, professionInterviewId, loadTokens);

		synchronized(professionInterview){
			//Will be good when the professionInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//professionInterview.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = professionInterview.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new ProfessionInterviewManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			professionInterview = saveProfessionInterview(userContext, professionInterview, tokens().withEmployeeList().done());
			return present(userContext,professionInterview, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, ProfessionInterview newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   ProfessionInterview newProfessionInterview = this.createProfessionInterview(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newProfessionInterview
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ProfessionInterview.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ProfessionInterview> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String professionInterviewId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getProfessionInterviewDetailScope().clone();
		ProfessionInterview merchantObj = (ProfessionInterview) this.view(userContext, professionInterviewId);
    String merchantObjId = professionInterviewId;
    String linkToUrl =	"professionInterviewManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "专业面试"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-who")
				    .put("fieldName", "who")
				    .put("label", "谁")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("who", merchantObj.getWho());

		propList.add(
				MapUtil.put("id", "3-interviewTime")
				    .put("fieldName", "interviewTime")
				    .put("label", "面试时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("interviewTime", merchantObj.getInterviewTime());

		propList.add(
				MapUtil.put("id", "4-comments")
				    .put("fieldName", "comments")
				    .put("label", "评论")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("comments", merchantObj.getComments());

		//处理 sectionList

		//处理Section：employeeListSection
		Map employeeListSection = ListofUtils.buildSection(
		    "employeeListSection",
		    "员工列表",
		    null,
		    "",
		    "__no_group",
		    "employeeManager/listByProfessionInterview/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeListSection);

		result.put("employeeListSection", ListofUtils.toShortList(merchantObj.getEmployeeList(), "employee"));
		vscope.field("employeeListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Employee.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


