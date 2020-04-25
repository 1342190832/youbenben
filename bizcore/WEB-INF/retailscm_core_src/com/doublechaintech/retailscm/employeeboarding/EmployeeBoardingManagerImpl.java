
package com.doublechaintech.retailscm.employeeboarding;

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






public class EmployeeBoardingManagerImpl extends CustomRetailscmCheckerManager implements EmployeeBoardingManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = EmployeeBoardingTokens.start().withTokenFromListName(listName).done();
		EmployeeBoarding  employeeBoarding = (EmployeeBoarding) this.loadEmployeeBoarding(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = employeeBoarding.collectRefercencesFromLists();
		employeeBoardingDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, employeeBoarding, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new EmployeeBoardingGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "EmployeeBoarding";
	@Override
	public EmployeeBoardingDAO daoOf(RetailscmUserContext userContext) {
		return employeeBoardingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws EmployeeBoardingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeeBoardingManagerException(message);

	}



 	protected EmployeeBoarding saveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, String [] tokensExpr) throws Exception{	
 		//return getEmployeeBoardingDAO().save(employeeBoarding, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeBoarding(userContext, employeeBoarding, tokens);
 	}
 	
 	protected EmployeeBoarding saveEmployeeBoardingDetail(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding) throws Exception{	

 		
 		return saveEmployeeBoarding(userContext, employeeBoarding, allTokens());
 	}
 	
 	public EmployeeBoarding loadEmployeeBoarding(RetailscmUserContext userContext, String employeeBoardingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeBoarding(employeeBoardingId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeBoardingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeBoarding employeeBoarding = loadEmployeeBoarding( userContext, employeeBoardingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeBoarding, tokens);
 	}
 	
 	
 	 public EmployeeBoarding searchEmployeeBoarding(RetailscmUserContext userContext, String employeeBoardingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeBoarding(employeeBoardingId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeBoardingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeBoarding employeeBoarding = loadEmployeeBoarding( userContext, employeeBoardingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeBoarding, tokens);
 	}
 	
 	

 	protected EmployeeBoarding present(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeBoarding,tokens);
		
		
		EmployeeBoarding  employeeBoardingToPresent = employeeBoardingDaoOf(userContext).present(employeeBoarding, tokens);
		
		List<BaseEntity> entityListToNaming = employeeBoardingToPresent.collectRefercencesFromLists();
		employeeBoardingDaoOf(userContext).alias(entityListToNaming);
		
		return  employeeBoardingToPresent;
		
		
	}
 
 	
 	
 	public EmployeeBoarding loadEmployeeBoardingDetail(RetailscmUserContext userContext, String employeeBoardingId) throws Exception{	
 		EmployeeBoarding employeeBoarding = loadEmployeeBoarding( userContext, employeeBoardingId, allTokens());
 		return present(userContext,employeeBoarding, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeBoardingId) throws Exception{	
 		EmployeeBoarding employeeBoarding = loadEmployeeBoarding( userContext, employeeBoardingId, viewTokens());
 		return present(userContext,employeeBoarding, allTokens());
		
 	}
 	protected EmployeeBoarding saveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String,Object>tokens) throws Exception{	
 		return employeeBoardingDaoOf(userContext).save(employeeBoarding, tokens);
 	}
 	protected EmployeeBoarding loadEmployeeBoarding(RetailscmUserContext userContext, String employeeBoardingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfEmployeeBoarding(employeeBoardingId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeBoardingManagerException.class);

 
 		return employeeBoardingDaoOf(userContext).load(employeeBoardingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String, Object> tokens){
		super.addActions(userContext, employeeBoarding, tokens);
		
		addAction(userContext, employeeBoarding, tokens,"@create","createEmployeeBoarding","createEmployeeBoarding/","main","primary");
		addAction(userContext, employeeBoarding, tokens,"@update","updateEmployeeBoarding","updateEmployeeBoarding/"+employeeBoarding.getId()+"/","main","primary");
		addAction(userContext, employeeBoarding, tokens,"@copy","cloneEmployeeBoarding","cloneEmployeeBoarding/"+employeeBoarding.getId()+"/","main","primary");
		
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.addEmployee","addEmployee","addEmployee/"+employeeBoarding.getId()+"/","employeeList","primary");
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.removeEmployee","removeEmployee","removeEmployee/"+employeeBoarding.getId()+"/","employeeList","primary");
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.updateEmployee","updateEmployee","updateEmployee/"+employeeBoarding.getId()+"/","employeeList","primary");
		addAction(userContext, employeeBoarding, tokens,"employee_boarding.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+employeeBoarding.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public EmployeeBoarding createEmployeeBoarding(RetailscmUserContext userContext, String who,Date employTime,String comments) throws Exception
	//public EmployeeBoarding createEmployeeBoarding(RetailscmUserContext userContext,String who, Date employTime, String comments) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfEmployeeBoarding(who);
		checkerOf(userContext).checkEmployTimeOfEmployeeBoarding(employTime);
		checkerOf(userContext).checkCommentsOfEmployeeBoarding(comments);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);


		EmployeeBoarding employeeBoarding=createNewEmployeeBoarding();	

		employeeBoarding.setWho(who);
		employeeBoarding.setEmployTime(employTime);
		employeeBoarding.setComments(comments);

		employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeBoarding);
		return employeeBoarding;


	}
	protected EmployeeBoarding createNewEmployeeBoarding()
	{

		return new EmployeeBoarding();
	}

	protected void checkParamsForUpdatingEmployeeBoarding(RetailscmUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfEmployeeBoarding(employeeBoardingId);
		checkerOf(userContext).checkVersionOfEmployeeBoarding( employeeBoardingVersion);
		

		if(EmployeeBoarding.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfEmployeeBoarding(parseString(newValueExpr));
		
			
		}
		if(EmployeeBoarding.EMPLOY_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmployTimeOfEmployeeBoarding(parseDate(newValueExpr));
		
			
		}
		if(EmployeeBoarding.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfEmployeeBoarding(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);


	}



	public EmployeeBoarding clone(RetailscmUserContext userContext, String fromEmployeeBoardingId) throws Exception{

		return employeeBoardingDaoOf(userContext).clone(fromEmployeeBoardingId, this.allTokens());
	}

	public EmployeeBoarding internalSaveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding) throws Exception
	{
		return internalSaveEmployeeBoarding(userContext, employeeBoarding, allTokens());

	}
	public EmployeeBoarding internalSaveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeeBoarding(userContext, employeeBoardingId, employeeBoardingVersion, property, newValueExpr, tokensExpr);


		synchronized(employeeBoarding){
			//will be good when the employeeBoarding loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeBoarding.
			if (employeeBoarding.isChanged()){
			
			}
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, options);
			return employeeBoarding;

		}

	}

	public EmployeeBoarding updateEmployeeBoarding(RetailscmUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeBoarding(userContext, employeeBoardingId, employeeBoardingVersion, property, newValueExpr, tokensExpr);



		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		if(employeeBoarding.getVersion() != employeeBoardingVersion){
			String message = "The target version("+employeeBoarding.getVersion()+") is not equals to version("+employeeBoardingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeBoarding){
			//will be good when the employeeBoarding loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeBoarding.
			
			employeeBoarding.changeProperty(property, newValueExpr);
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().done());
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
			//return saveEmployeeBoarding(userContext, employeeBoarding, tokens().done());
		}

	}

	public EmployeeBoarding updateEmployeeBoardingProperty(RetailscmUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeBoarding(userContext, employeeBoardingId, employeeBoardingVersion, property, newValueExpr, tokensExpr);

		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		if(employeeBoarding.getVersion() != employeeBoardingVersion){
			String message = "The target version("+employeeBoarding.getVersion()+") is not equals to version("+employeeBoardingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeBoarding){
			//will be good when the employeeBoarding loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeBoarding.

			employeeBoarding.changeProperty(property, newValueExpr);
			
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().done());
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
			//return saveEmployeeBoarding(userContext, employeeBoarding, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeeBoardingTokens tokens(){
		return EmployeeBoardingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeBoardingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeBoardingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeBoardingId, int employeeBoardingVersion) throws Exception {
		//deleteInternal(userContext, employeeBoardingId, employeeBoardingVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeBoardingId, int employeeBoardingVersion) throws Exception{

		employeeBoardingDaoOf(userContext).delete(employeeBoardingId, employeeBoardingVersion);
	}

	public EmployeeBoarding forgetByAll(RetailscmUserContext userContext, String employeeBoardingId, int employeeBoardingVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeBoardingId, employeeBoardingVersion);
	}
	protected EmployeeBoarding forgetByAllInternal(RetailscmUserContext userContext,
			String employeeBoardingId, int employeeBoardingVersion) throws Exception{

		return employeeBoardingDaoOf(userContext).disconnectFromAll(employeeBoardingId, employeeBoardingVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeBoardingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return employeeBoardingDaoOf(userContext).deleteAll();
	}


	//disconnect EmployeeBoarding with company in Employee
	protected EmployeeBoarding breakWithEmployeeByCompany(RetailscmUserContext userContext, String employeeBoardingId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeBoardingDaoOf(userContext).planToRemoveEmployeeListWithCompany(employeeBoarding, companyId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with department in Employee
	protected EmployeeBoarding breakWithEmployeeByDepartment(RetailscmUserContext userContext, String employeeBoardingId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeBoardingDaoOf(userContext).planToRemoveEmployeeListWithDepartment(employeeBoarding, departmentId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with occupation in Employee
	protected EmployeeBoarding breakWithEmployeeByOccupation(RetailscmUserContext userContext, String employeeBoardingId, String occupationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeBoardingDaoOf(userContext).planToRemoveEmployeeListWithOccupation(employeeBoarding, occupationId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with responsible_for in Employee
	protected EmployeeBoarding breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String employeeBoardingId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeBoardingDaoOf(userContext).planToRemoveEmployeeListWithResponsibleFor(employeeBoarding, responsibleForId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with current_salary_grade in Employee
	protected EmployeeBoarding breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String employeeBoardingId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeBoardingDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(employeeBoarding, currentSalaryGradeId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with job_application in Employee
	protected EmployeeBoarding breakWithEmployeeByJobApplication(RetailscmUserContext userContext, String employeeBoardingId, String jobApplicationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeBoardingDaoOf(userContext).planToRemoveEmployeeListWithJobApplication(employeeBoarding, jobApplicationId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with profession_interview in Employee
	protected EmployeeBoarding breakWithEmployeeByProfessionInterview(RetailscmUserContext userContext, String employeeBoardingId, String professionInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeBoardingDaoOf(userContext).planToRemoveEmployeeListWithProfessionInterview(employeeBoarding, professionInterviewId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with hr_interview in Employee
	protected EmployeeBoarding breakWithEmployeeByHrInterview(RetailscmUserContext userContext, String employeeBoardingId, String hrInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeBoardingDaoOf(userContext).planToRemoveEmployeeListWithHrInterview(employeeBoarding, hrInterviewId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with offer_approval in Employee
	protected EmployeeBoarding breakWithEmployeeByOfferApproval(RetailscmUserContext userContext, String employeeBoardingId, String offerApprovalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeBoardingDaoOf(userContext).planToRemoveEmployeeListWithOfferApproval(employeeBoarding, offerApprovalId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with offer_acceptance in Employee
	protected EmployeeBoarding breakWithEmployeeByOfferAcceptance(RetailscmUserContext userContext, String employeeBoardingId, String offerAcceptanceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeBoardingDaoOf(userContext).planToRemoveEmployeeListWithOfferAcceptance(employeeBoarding, offerAcceptanceId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}
	//disconnect EmployeeBoarding with termination in Employee
	protected EmployeeBoarding breakWithEmployeeByTermination(RetailscmUserContext userContext, String employeeBoardingId, String terminationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());

			synchronized(employeeBoarding){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				employeeBoardingDaoOf(userContext).planToRemoveEmployeeListWithTermination(employeeBoarding, terminationId, this.emptyOptions());

				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				return employeeBoarding;
			}
	}






	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String terminationId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfEmployeeBoarding(employeeBoardingId);

		
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
		
		checkerOf(userContext).checkHrInterviewIdOfEmployee(hrInterviewId);
		
		checkerOf(userContext).checkOfferApprovalIdOfEmployee(offerApprovalId);
		
		checkerOf(userContext).checkOfferAcceptanceIdOfEmployee(offerAcceptanceId);
		
		checkerOf(userContext).checkTerminationIdOfEmployee(terminationId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);


	}
	public  EmployeeBoarding addEmployee(RetailscmUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String terminationId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,employeeBoardingId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, terminationId,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, terminationId);

		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, emptyOptions());
		synchronized(employeeBoarding){
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employeeBoarding.addEmployee( employee );
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String employeeBoardingId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfEmployeeBoarding(employeeBoardingId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);

	}
	public  EmployeeBoarding updateEmployeeProperties(RetailscmUserContext userContext, String employeeBoardingId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,employeeBoardingId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		EmployeeBoarding employeeBoardingToUpdate = loadEmployeeBoarding(userContext, employeeBoardingId, options);

		if(employeeBoardingToUpdate.getEmployeeList().isEmpty()){
			throw new EmployeeBoardingManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = employeeBoardingToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,employeeBoardingId,name, code, used,tokensExpr);
		EmployeeBoarding employeeBoarding = saveEmployeeBoarding(userContext, employeeBoardingToUpdate, tokens().withEmployeeList().done());
		synchronized(employeeBoarding){
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String terminationId) throws Exception{

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
		HrInterview  hrInterview = new HrInterview();
		hrInterview.setId(hrInterviewId);		
		employee.setHrInterview(hrInterview);		
		OfferApproval  offerApproval = new OfferApproval();
		offerApproval.setId(offerApprovalId);		
		employee.setOfferApproval(offerApproval);		
		OfferAcceptance  offerAcceptance = new OfferAcceptance();
		offerAcceptance.setId(offerAcceptanceId);		
		employee.setOfferAcceptance(offerAcceptance);		
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

	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String employeeBoardingId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfEmployeeBoarding(employeeBoardingId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);

	}
	public  EmployeeBoarding removeEmployeeList(RetailscmUserContext userContext, String employeeBoardingId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, employeeBoardingId,  employeeIds, tokensExpr);


			EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
			synchronized(employeeBoarding){
				//Will be good when the employeeBoarding loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				employeeBoardingDaoOf(userContext).planToRemoveEmployeeList(employeeBoarding, employeeIds, allTokens());
				employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, employeeBoarding.getEmployeeList());
				return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String employeeBoardingId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployeeBoarding( employeeBoardingId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);

	}
	public  EmployeeBoarding removeEmployee(RetailscmUserContext userContext, String employeeBoardingId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,employeeBoardingId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		synchronized(employeeBoarding){
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			employeeBoarding.removeEmployee( employee );
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String employeeBoardingId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfEmployeeBoarding( employeeBoardingId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);

	}
	public  EmployeeBoarding copyEmployeeFrom(RetailscmUserContext userContext, String employeeBoardingId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,employeeBoardingId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, allTokens());
		synchronized(employeeBoarding){
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			employeeBoarding.copyEmployeeFrom( employee );
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)employeeBoarding.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfEmployeeBoarding(employeeBoardingId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeBoardingManagerException.class);

	}

	public  EmployeeBoarding updateEmployee(RetailscmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, employeeBoardingId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		EmployeeBoarding employeeBoarding = loadEmployeeBoarding(userContext, employeeBoardingId, loadTokens);

		synchronized(employeeBoarding){
			//Will be good when the employeeBoarding loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//employeeBoarding.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = employeeBoarding.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new EmployeeBoardingManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			employeeBoarding = saveEmployeeBoarding(userContext, employeeBoarding, tokens().withEmployeeList().done());
			return present(userContext,employeeBoarding, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeBoarding newCreated) throws Exception{
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
		//   EmployeeBoarding newEmployeeBoarding = this.createEmployeeBoarding(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeBoarding
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, EmployeeBoarding.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<EmployeeBoarding> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String employeeBoardingId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getEmployeeBoardingDetailScope().clone();
		EmployeeBoarding merchantObj = (EmployeeBoarding) this.view(userContext, employeeBoardingId);
    String merchantObjId = employeeBoardingId;
    String linkToUrl =	"employeeBoardingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工入职"+"详情";
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
				MapUtil.put("id", "3-employTime")
				    .put("fieldName", "employTime")
				    .put("label", "使用时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("employTime", merchantObj.getEmployTime());

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
		    "employeeManager/listByEmployeeBoarding/"+merchantObjId+"/",
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


