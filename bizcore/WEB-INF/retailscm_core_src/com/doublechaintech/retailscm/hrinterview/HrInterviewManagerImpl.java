
package com.doublechaintech.retailscm.hrinterview;

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






public class HrInterviewManagerImpl extends CustomRetailscmCheckerManager implements HrInterviewManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = HrInterviewTokens.start().withTokenFromListName(listName).done();
		HrInterview  hrInterview = (HrInterview) this.loadHrInterview(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = hrInterview.collectRefercencesFromLists();
		hrInterviewDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, hrInterview, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new HrInterviewGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "HrInterview";
	@Override
	public HrInterviewDAO daoOf(RetailscmUserContext userContext) {
		return hrInterviewDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws HrInterviewManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new HrInterviewManagerException(message);

	}



 	protected HrInterview saveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview, String [] tokensExpr) throws Exception{	
 		//return getHrInterviewDAO().save(hrInterview, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveHrInterview(userContext, hrInterview, tokens);
 	}
 	
 	protected HrInterview saveHrInterviewDetail(RetailscmUserContext userContext, HrInterview hrInterview) throws Exception{	

 		
 		return saveHrInterview(userContext, hrInterview, allTokens());
 	}
 	
 	public HrInterview loadHrInterview(RetailscmUserContext userContext, String hrInterviewId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfHrInterview(hrInterviewId);
		checkerOf(userContext).throwExceptionIfHasErrors( HrInterviewManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		HrInterview hrInterview = loadHrInterview( userContext, hrInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,hrInterview, tokens);
 	}
 	
 	
 	 public HrInterview searchHrInterview(RetailscmUserContext userContext, String hrInterviewId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfHrInterview(hrInterviewId);
		checkerOf(userContext).throwExceptionIfHasErrors( HrInterviewManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		HrInterview hrInterview = loadHrInterview( userContext, hrInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,hrInterview, tokens);
 	}
 	
 	

 	protected HrInterview present(RetailscmUserContext userContext, HrInterview hrInterview, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,hrInterview,tokens);
		
		
		HrInterview  hrInterviewToPresent = hrInterviewDaoOf(userContext).present(hrInterview, tokens);
		
		List<BaseEntity> entityListToNaming = hrInterviewToPresent.collectRefercencesFromLists();
		hrInterviewDaoOf(userContext).alias(entityListToNaming);
		
		return  hrInterviewToPresent;
		
		
	}
 
 	
 	
 	public HrInterview loadHrInterviewDetail(RetailscmUserContext userContext, String hrInterviewId) throws Exception{	
 		HrInterview hrInterview = loadHrInterview( userContext, hrInterviewId, allTokens());
 		return present(userContext,hrInterview, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String hrInterviewId) throws Exception{	
 		HrInterview hrInterview = loadHrInterview( userContext, hrInterviewId, viewTokens());
 		return present(userContext,hrInterview, allTokens());
		
 	}
 	protected HrInterview saveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview, Map<String,Object>tokens) throws Exception{	
 		return hrInterviewDaoOf(userContext).save(hrInterview, tokens);
 	}
 	protected HrInterview loadHrInterview(RetailscmUserContext userContext, String hrInterviewId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfHrInterview(hrInterviewId);
		checkerOf(userContext).throwExceptionIfHasErrors( HrInterviewManagerException.class);

 
 		return hrInterviewDaoOf(userContext).load(hrInterviewId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, HrInterview hrInterview, Map<String, Object> tokens){
		super.addActions(userContext, hrInterview, tokens);
		
		addAction(userContext, hrInterview, tokens,"@create","createHrInterview","createHrInterview/","main","primary");
		addAction(userContext, hrInterview, tokens,"@update","updateHrInterview","updateHrInterview/"+hrInterview.getId()+"/","main","primary");
		addAction(userContext, hrInterview, tokens,"@copy","cloneHrInterview","cloneHrInterview/"+hrInterview.getId()+"/","main","primary");
		
		addAction(userContext, hrInterview, tokens,"hr_interview.addEmployee","addEmployee","addEmployee/"+hrInterview.getId()+"/","employeeList","primary");
		addAction(userContext, hrInterview, tokens,"hr_interview.removeEmployee","removeEmployee","removeEmployee/"+hrInterview.getId()+"/","employeeList","primary");
		addAction(userContext, hrInterview, tokens,"hr_interview.updateEmployee","updateEmployee","updateEmployee/"+hrInterview.getId()+"/","employeeList","primary");
		addAction(userContext, hrInterview, tokens,"hr_interview.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+hrInterview.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, HrInterview hrInterview, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public HrInterview createHrInterview(RetailscmUserContext userContext, String who,Date interviewTime,String comments) throws Exception
	//public HrInterview createHrInterview(RetailscmUserContext userContext,String who, Date interviewTime, String comments) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfHrInterview(who);
		checkerOf(userContext).checkInterviewTimeOfHrInterview(interviewTime);
		checkerOf(userContext).checkCommentsOfHrInterview(comments);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HrInterviewManagerException.class);


		HrInterview hrInterview=createNewHrInterview();	

		hrInterview.setWho(who);
		hrInterview.setInterviewTime(interviewTime);
		hrInterview.setComments(comments);

		hrInterview = saveHrInterview(userContext, hrInterview, emptyOptions());
		
		onNewInstanceCreated(userContext, hrInterview);
		return hrInterview;


	}
	protected HrInterview createNewHrInterview()
	{

		return new HrInterview();
	}

	protected void checkParamsForUpdatingHrInterview(RetailscmUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfHrInterview(hrInterviewId);
		checkerOf(userContext).checkVersionOfHrInterview( hrInterviewVersion);
		

		if(HrInterview.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfHrInterview(parseString(newValueExpr));
		
			
		}
		if(HrInterview.INTERVIEW_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkInterviewTimeOfHrInterview(parseDate(newValueExpr));
		
			
		}
		if(HrInterview.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfHrInterview(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(HrInterviewManagerException.class);


	}



	public HrInterview clone(RetailscmUserContext userContext, String fromHrInterviewId) throws Exception{

		return hrInterviewDaoOf(userContext).clone(fromHrInterviewId, this.allTokens());
	}

	public HrInterview internalSaveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview) throws Exception
	{
		return internalSaveHrInterview(userContext, hrInterview, allTokens());

	}
	public HrInterview internalSaveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingHrInterview(userContext, hrInterviewId, hrInterviewVersion, property, newValueExpr, tokensExpr);


		synchronized(hrInterview){
			//will be good when the hrInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HrInterview.
			if (hrInterview.isChanged()){
			
			}
			hrInterview = saveHrInterview(userContext, hrInterview, options);
			return hrInterview;

		}

	}

	public HrInterview updateHrInterview(RetailscmUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingHrInterview(userContext, hrInterviewId, hrInterviewVersion, property, newValueExpr, tokensExpr);



		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		if(hrInterview.getVersion() != hrInterviewVersion){
			String message = "The target version("+hrInterview.getVersion()+") is not equals to version("+hrInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(hrInterview){
			//will be good when the hrInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HrInterview.
			
			hrInterview.changeProperty(property, newValueExpr);
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().done());
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
			//return saveHrInterview(userContext, hrInterview, tokens().done());
		}

	}

	public HrInterview updateHrInterviewProperty(RetailscmUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingHrInterview(userContext, hrInterviewId, hrInterviewVersion, property, newValueExpr, tokensExpr);

		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		if(hrInterview.getVersion() != hrInterviewVersion){
			String message = "The target version("+hrInterview.getVersion()+") is not equals to version("+hrInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(hrInterview){
			//will be good when the hrInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HrInterview.

			hrInterview.changeProperty(property, newValueExpr);
			
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().done());
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
			//return saveHrInterview(userContext, hrInterview, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected HrInterviewTokens tokens(){
		return HrInterviewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return HrInterviewTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return HrInterviewTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String hrInterviewId, int hrInterviewVersion) throws Exception {
		//deleteInternal(userContext, hrInterviewId, hrInterviewVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String hrInterviewId, int hrInterviewVersion) throws Exception{

		hrInterviewDaoOf(userContext).delete(hrInterviewId, hrInterviewVersion);
	}

	public HrInterview forgetByAll(RetailscmUserContext userContext, String hrInterviewId, int hrInterviewVersion) throws Exception {
		return forgetByAllInternal(userContext, hrInterviewId, hrInterviewVersion);
	}
	protected HrInterview forgetByAllInternal(RetailscmUserContext userContext,
			String hrInterviewId, int hrInterviewVersion) throws Exception{

		return hrInterviewDaoOf(userContext).disconnectFromAll(hrInterviewId, hrInterviewVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new HrInterviewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return hrInterviewDaoOf(userContext).deleteAll();
	}


	//disconnect HrInterview with company in Employee
	protected HrInterview breakWithEmployeeByCompany(RetailscmUserContext userContext, String hrInterviewId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hrInterviewDaoOf(userContext).planToRemoveEmployeeListWithCompany(hrInterview, companyId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with department in Employee
	protected HrInterview breakWithEmployeeByDepartment(RetailscmUserContext userContext, String hrInterviewId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hrInterviewDaoOf(userContext).planToRemoveEmployeeListWithDepartment(hrInterview, departmentId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with occupation in Employee
	protected HrInterview breakWithEmployeeByOccupation(RetailscmUserContext userContext, String hrInterviewId, String occupationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hrInterviewDaoOf(userContext).planToRemoveEmployeeListWithOccupation(hrInterview, occupationId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with responsible_for in Employee
	protected HrInterview breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String hrInterviewId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hrInterviewDaoOf(userContext).planToRemoveEmployeeListWithResponsibleFor(hrInterview, responsibleForId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with current_salary_grade in Employee
	protected HrInterview breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String hrInterviewId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hrInterviewDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(hrInterview, currentSalaryGradeId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with job_application in Employee
	protected HrInterview breakWithEmployeeByJobApplication(RetailscmUserContext userContext, String hrInterviewId, String jobApplicationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hrInterviewDaoOf(userContext).planToRemoveEmployeeListWithJobApplication(hrInterview, jobApplicationId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with profession_interview in Employee
	protected HrInterview breakWithEmployeeByProfessionInterview(RetailscmUserContext userContext, String hrInterviewId, String professionInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hrInterviewDaoOf(userContext).planToRemoveEmployeeListWithProfessionInterview(hrInterview, professionInterviewId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with offer_approval in Employee
	protected HrInterview breakWithEmployeeByOfferApproval(RetailscmUserContext userContext, String hrInterviewId, String offerApprovalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hrInterviewDaoOf(userContext).planToRemoveEmployeeListWithOfferApproval(hrInterview, offerApprovalId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with offer_acceptance in Employee
	protected HrInterview breakWithEmployeeByOfferAcceptance(RetailscmUserContext userContext, String hrInterviewId, String offerAcceptanceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hrInterviewDaoOf(userContext).planToRemoveEmployeeListWithOfferAcceptance(hrInterview, offerAcceptanceId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with employee_boarding in Employee
	protected HrInterview breakWithEmployeeByEmployeeBoarding(RetailscmUserContext userContext, String hrInterviewId, String employeeBoardingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hrInterviewDaoOf(userContext).planToRemoveEmployeeListWithEmployeeBoarding(hrInterview, employeeBoardingId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}
	//disconnect HrInterview with termination in Employee
	protected HrInterview breakWithEmployeeByTermination(RetailscmUserContext userContext, String hrInterviewId, String terminationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());

			synchronized(hrInterview){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				hrInterviewDaoOf(userContext).planToRemoveEmployeeListWithTermination(hrInterview, terminationId, this.emptyOptions());

				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				return hrInterview;
			}
	}






	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfHrInterview(hrInterviewId);

		
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
		
		checkerOf(userContext).checkProfessionInterviewIdOfEmployee(professionInterviewId);
		
		checkerOf(userContext).checkOfferApprovalIdOfEmployee(offerApprovalId);
		
		checkerOf(userContext).checkOfferAcceptanceIdOfEmployee(offerAcceptanceId);
		
		checkerOf(userContext).checkEmployeeBoardingIdOfEmployee(employeeBoardingId);
		
		checkerOf(userContext).checkTerminationIdOfEmployee(terminationId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HrInterviewManagerException.class);


	}
	public  HrInterview addEmployee(RetailscmUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,hrInterviewId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId);

		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, emptyOptions());
		synchronized(hrInterview){
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hrInterview.addEmployee( employee );
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String hrInterviewId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfHrInterview(hrInterviewId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(HrInterviewManagerException.class);

	}
	public  HrInterview updateEmployeeProperties(RetailscmUserContext userContext, String hrInterviewId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,hrInterviewId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		HrInterview hrInterviewToUpdate = loadHrInterview(userContext, hrInterviewId, options);

		if(hrInterviewToUpdate.getEmployeeList().isEmpty()){
			throw new HrInterviewManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = hrInterviewToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,hrInterviewId,name, code, used,tokensExpr);
		HrInterview hrInterview = saveHrInterview(userContext, hrInterviewToUpdate, tokens().withEmployeeList().done());
		synchronized(hrInterview){
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId) throws Exception{

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
		ProfessionInterview  professionInterview = new ProfessionInterview();
		professionInterview.setId(professionInterviewId);		
		employee.setProfessionInterview(professionInterview);		
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

	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String hrInterviewId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfHrInterview(hrInterviewId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(HrInterviewManagerException.class);

	}
	public  HrInterview removeEmployeeList(RetailscmUserContext userContext, String hrInterviewId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, hrInterviewId,  employeeIds, tokensExpr);


			HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
			synchronized(hrInterview){
				//Will be good when the hrInterview loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hrInterviewDaoOf(userContext).planToRemoveEmployeeList(hrInterview, employeeIds, allTokens());
				hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, hrInterview.getEmployeeList());
				return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String hrInterviewId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHrInterview( hrInterviewId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HrInterviewManagerException.class);

	}
	public  HrInterview removeEmployee(RetailscmUserContext userContext, String hrInterviewId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,hrInterviewId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		synchronized(hrInterview){
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hrInterview.removeEmployee( employee );
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String hrInterviewId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHrInterview( hrInterviewId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HrInterviewManagerException.class);

	}
	public  HrInterview copyEmployeeFrom(RetailscmUserContext userContext, String hrInterviewId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,hrInterviewId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, allTokens());
		synchronized(hrInterview){
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			hrInterview.copyEmployeeFrom( employee );
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)hrInterview.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHrInterview(hrInterviewId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HrInterviewManagerException.class);

	}

	public  HrInterview updateEmployee(RetailscmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, hrInterviewId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		HrInterview hrInterview = loadHrInterview(userContext, hrInterviewId, loadTokens);

		synchronized(hrInterview){
			//Will be good when the hrInterview loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hrInterview.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = hrInterview.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new HrInterviewManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			hrInterview = saveHrInterview(userContext, hrInterview, tokens().withEmployeeList().done());
			return present(userContext,hrInterview, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, HrInterview newCreated) throws Exception{
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
		//   HrInterview newHrInterview = this.createHrInterview(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newHrInterview
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, HrInterview.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<HrInterview> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String hrInterviewId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getHrInterviewDetailScope().clone();
		HrInterview merchantObj = (HrInterview) this.view(userContext, hrInterviewId);
    String merchantObjId = hrInterviewId;
    String linkToUrl =	"hrInterviewManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "人力资源部面试"+"详情";
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
		    "employeeManager/listByHrInterview/"+merchantObjId+"/",
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


