
package com.youbenben.youbenben.offeracceptance;

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

import com.youbenben.youbenben.*;
import com.youbenben.youbenben.tree.*;
import com.youbenben.youbenben.treenode.*;
import com.youbenben.youbenben.YoubenbenUserContextImpl;
import com.youbenben.youbenben.iamservice.*;
import com.youbenben.youbenben.services.IamService;
import com.youbenben.youbenben.secuser.SecUser;
import com.youbenben.youbenben.userapp.UserApp;
import com.youbenben.youbenben.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.youbenben.youbenben.employee.Employee;


import com.youbenben.youbenben.employeeboarding.EmployeeBoarding;
import com.youbenben.youbenben.hrinterview.HrInterview;
import com.youbenben.youbenben.termination.Termination;
import com.youbenben.youbenben.salarygrade.SalaryGrade;
import com.youbenben.youbenben.jobapplication.JobApplication;
import com.youbenben.youbenben.offerapproval.OfferApproval;
import com.youbenben.youbenben.offeracceptance.OfferAcceptance;
import com.youbenben.youbenben.responsibilitytype.ResponsibilityType;
import com.youbenben.youbenben.levelthreedepartment.LevelThreeDepartment;
import com.youbenben.youbenben.occupationtype.OccupationType;
import com.youbenben.youbenben.professioninterview.ProfessionInterview;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;






public class OfferAcceptanceManagerImpl extends CustomYoubenbenCheckerManager implements OfferAcceptanceManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = OfferAcceptanceTokens.start().withTokenFromListName(listName).done();
		OfferAcceptance  offerAcceptance = (OfferAcceptance) this.loadOfferAcceptance(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = offerAcceptance.collectRefercencesFromLists();
		offerAcceptanceDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, offerAcceptance, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new OfferAcceptanceGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "OfferAcceptance";
	@Override
	public OfferAcceptanceDAO daoOf(YoubenbenUserContext userContext) {
		return offerAcceptanceDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws OfferAcceptanceManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new OfferAcceptanceManagerException(message);

	}



 	protected OfferAcceptance saveOfferAcceptance(YoubenbenUserContext userContext, OfferAcceptance offerAcceptance, String [] tokensExpr) throws Exception{	
 		//return getOfferAcceptanceDAO().save(offerAcceptance, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOfferAcceptance(userContext, offerAcceptance, tokens);
 	}
 	
 	protected OfferAcceptance saveOfferAcceptanceDetail(YoubenbenUserContext userContext, OfferAcceptance offerAcceptance) throws Exception{	

 		
 		return saveOfferAcceptance(userContext, offerAcceptance, allTokens());
 	}
 	
 	public OfferAcceptance loadOfferAcceptance(YoubenbenUserContext userContext, String offerAcceptanceId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOfferAcceptance(offerAcceptanceId);
		checkerOf(userContext).throwExceptionIfHasErrors( OfferAcceptanceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OfferAcceptance offerAcceptance = loadOfferAcceptance( userContext, offerAcceptanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,offerAcceptance, tokens);
 	}
 	
 	
 	 public OfferAcceptance searchOfferAcceptance(YoubenbenUserContext userContext, String offerAcceptanceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOfferAcceptance(offerAcceptanceId);
		checkerOf(userContext).throwExceptionIfHasErrors( OfferAcceptanceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OfferAcceptance offerAcceptance = loadOfferAcceptance( userContext, offerAcceptanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,offerAcceptance, tokens);
 	}
 	
 	

 	protected OfferAcceptance present(YoubenbenUserContext userContext, OfferAcceptance offerAcceptance, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,offerAcceptance,tokens);
		
		
		OfferAcceptance  offerAcceptanceToPresent = offerAcceptanceDaoOf(userContext).present(offerAcceptance, tokens);
		
		List<BaseEntity> entityListToNaming = offerAcceptanceToPresent.collectRefercencesFromLists();
		offerAcceptanceDaoOf(userContext).alias(entityListToNaming);
		
		return  offerAcceptanceToPresent;
		
		
	}
 
 	
 	
 	public OfferAcceptance loadOfferAcceptanceDetail(YoubenbenUserContext userContext, String offerAcceptanceId) throws Exception{	
 		OfferAcceptance offerAcceptance = loadOfferAcceptance( userContext, offerAcceptanceId, allTokens());
 		return present(userContext,offerAcceptance, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String offerAcceptanceId) throws Exception{	
 		OfferAcceptance offerAcceptance = loadOfferAcceptance( userContext, offerAcceptanceId, viewTokens());
 		return present(userContext,offerAcceptance, allTokens());
		
 	}
 	protected OfferAcceptance saveOfferAcceptance(YoubenbenUserContext userContext, OfferAcceptance offerAcceptance, Map<String,Object>tokens) throws Exception{	
 		return offerAcceptanceDaoOf(userContext).save(offerAcceptance, tokens);
 	}
 	protected OfferAcceptance loadOfferAcceptance(YoubenbenUserContext userContext, String offerAcceptanceId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfOfferAcceptance(offerAcceptanceId);
		checkerOf(userContext).throwExceptionIfHasErrors( OfferAcceptanceManagerException.class);

 
 		return offerAcceptanceDaoOf(userContext).load(offerAcceptanceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, OfferAcceptance offerAcceptance, Map<String, Object> tokens){
		super.addActions(userContext, offerAcceptance, tokens);
		
		addAction(userContext, offerAcceptance, tokens,"@create","createOfferAcceptance","createOfferAcceptance/","main","primary");
		addAction(userContext, offerAcceptance, tokens,"@update","updateOfferAcceptance","updateOfferAcceptance/"+offerAcceptance.getId()+"/","main","primary");
		addAction(userContext, offerAcceptance, tokens,"@copy","cloneOfferAcceptance","cloneOfferAcceptance/"+offerAcceptance.getId()+"/","main","primary");
		
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.addEmployee","addEmployee","addEmployee/"+offerAcceptance.getId()+"/","employeeList","primary");
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.removeEmployee","removeEmployee","removeEmployee/"+offerAcceptance.getId()+"/","employeeList","primary");
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.updateEmployee","updateEmployee","updateEmployee/"+offerAcceptance.getId()+"/","employeeList","primary");
		addAction(userContext, offerAcceptance, tokens,"offer_acceptance.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+offerAcceptance.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, OfferAcceptance offerAcceptance, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public OfferAcceptance createOfferAcceptance(YoubenbenUserContext userContext, String who,Date acceptTime,String comments) throws Exception
	//public OfferAcceptance createOfferAcceptance(YoubenbenUserContext userContext,String who, Date acceptTime, String comments) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfOfferAcceptance(who);
		checkerOf(userContext).checkAcceptTimeOfOfferAcceptance(acceptTime);
		checkerOf(userContext).checkCommentsOfOfferAcceptance(comments);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);


		OfferAcceptance offerAcceptance=createNewOfferAcceptance();	

		offerAcceptance.setWho(who);
		offerAcceptance.setAcceptTime(acceptTime);
		offerAcceptance.setComments(comments);

		offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, emptyOptions());
		
		onNewInstanceCreated(userContext, offerAcceptance);
		return offerAcceptance;


	}
	protected OfferAcceptance createNewOfferAcceptance()
	{

		return new OfferAcceptance();
	}

	protected void checkParamsForUpdatingOfferAcceptance(YoubenbenUserContext userContext,String offerAcceptanceId, int offerAcceptanceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfOfferAcceptance(offerAcceptanceId);
		checkerOf(userContext).checkVersionOfOfferAcceptance( offerAcceptanceVersion);
		

		if(OfferAcceptance.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfOfferAcceptance(parseString(newValueExpr));
		
			
		}
		if(OfferAcceptance.ACCEPT_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAcceptTimeOfOfferAcceptance(parseDate(newValueExpr));
		
			
		}
		if(OfferAcceptance.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfOfferAcceptance(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);


	}



	public OfferAcceptance clone(YoubenbenUserContext userContext, String fromOfferAcceptanceId) throws Exception{

		return offerAcceptanceDaoOf(userContext).clone(fromOfferAcceptanceId, this.allTokens());
	}

	public OfferAcceptance internalSaveOfferAcceptance(YoubenbenUserContext userContext, OfferAcceptance offerAcceptance) throws Exception
	{
		return internalSaveOfferAcceptance(userContext, offerAcceptance, allTokens());

	}
	public OfferAcceptance internalSaveOfferAcceptance(YoubenbenUserContext userContext, OfferAcceptance offerAcceptance, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingOfferAcceptance(userContext, offerAcceptanceId, offerAcceptanceVersion, property, newValueExpr, tokensExpr);


		synchronized(offerAcceptance){
			//will be good when the offerAcceptance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferAcceptance.
			if (offerAcceptance.isChanged()){
			
			}
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, options);
			return offerAcceptance;

		}

	}

	public OfferAcceptance updateOfferAcceptance(YoubenbenUserContext userContext,String offerAcceptanceId, int offerAcceptanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOfferAcceptance(userContext, offerAcceptanceId, offerAcceptanceVersion, property, newValueExpr, tokensExpr);



		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		if(offerAcceptance.getVersion() != offerAcceptanceVersion){
			String message = "The target version("+offerAcceptance.getVersion()+") is not equals to version("+offerAcceptanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(offerAcceptance){
			//will be good when the offerAcceptance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferAcceptance.
			
			offerAcceptance.changeProperty(property, newValueExpr);
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().done());
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
			//return saveOfferAcceptance(userContext, offerAcceptance, tokens().done());
		}

	}

	public OfferAcceptance updateOfferAcceptanceProperty(YoubenbenUserContext userContext,String offerAcceptanceId, int offerAcceptanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOfferAcceptance(userContext, offerAcceptanceId, offerAcceptanceVersion, property, newValueExpr, tokensExpr);

		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		if(offerAcceptance.getVersion() != offerAcceptanceVersion){
			String message = "The target version("+offerAcceptance.getVersion()+") is not equals to version("+offerAcceptanceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(offerAcceptance){
			//will be good when the offerAcceptance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferAcceptance.

			offerAcceptance.changeProperty(property, newValueExpr);
			
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().done());
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
			//return saveOfferAcceptance(userContext, offerAcceptance, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected OfferAcceptanceTokens tokens(){
		return OfferAcceptanceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OfferAcceptanceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OfferAcceptanceTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String offerAcceptanceId, int offerAcceptanceVersion) throws Exception {
		//deleteInternal(userContext, offerAcceptanceId, offerAcceptanceVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String offerAcceptanceId, int offerAcceptanceVersion) throws Exception{

		offerAcceptanceDaoOf(userContext).delete(offerAcceptanceId, offerAcceptanceVersion);
	}

	public OfferAcceptance forgetByAll(YoubenbenUserContext userContext, String offerAcceptanceId, int offerAcceptanceVersion) throws Exception {
		return forgetByAllInternal(userContext, offerAcceptanceId, offerAcceptanceVersion);
	}
	protected OfferAcceptance forgetByAllInternal(YoubenbenUserContext userContext,
			String offerAcceptanceId, int offerAcceptanceVersion) throws Exception{

		return offerAcceptanceDaoOf(userContext).disconnectFromAll(offerAcceptanceId, offerAcceptanceVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OfferAcceptanceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return offerAcceptanceDaoOf(userContext).deleteAll();
	}


	//disconnect OfferAcceptance with company in Employee
	protected OfferAcceptance breakWithEmployeeByCompany(YoubenbenUserContext userContext, String offerAcceptanceId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeListWithCompany(offerAcceptance, companyId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with department in Employee
	protected OfferAcceptance breakWithEmployeeByDepartment(YoubenbenUserContext userContext, String offerAcceptanceId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeListWithDepartment(offerAcceptance, departmentId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with occupation in Employee
	protected OfferAcceptance breakWithEmployeeByOccupation(YoubenbenUserContext userContext, String offerAcceptanceId, String occupationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeListWithOccupation(offerAcceptance, occupationId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with responsible_for in Employee
	protected OfferAcceptance breakWithEmployeeByResponsibleFor(YoubenbenUserContext userContext, String offerAcceptanceId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeListWithResponsibleFor(offerAcceptance, responsibleForId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with current_salary_grade in Employee
	protected OfferAcceptance breakWithEmployeeByCurrentSalaryGrade(YoubenbenUserContext userContext, String offerAcceptanceId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(offerAcceptance, currentSalaryGradeId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with job_application in Employee
	protected OfferAcceptance breakWithEmployeeByJobApplication(YoubenbenUserContext userContext, String offerAcceptanceId, String jobApplicationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeListWithJobApplication(offerAcceptance, jobApplicationId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with profession_interview in Employee
	protected OfferAcceptance breakWithEmployeeByProfessionInterview(YoubenbenUserContext userContext, String offerAcceptanceId, String professionInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeListWithProfessionInterview(offerAcceptance, professionInterviewId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with hr_interview in Employee
	protected OfferAcceptance breakWithEmployeeByHrInterview(YoubenbenUserContext userContext, String offerAcceptanceId, String hrInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeListWithHrInterview(offerAcceptance, hrInterviewId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with offer_approval in Employee
	protected OfferAcceptance breakWithEmployeeByOfferApproval(YoubenbenUserContext userContext, String offerAcceptanceId, String offerApprovalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeListWithOfferApproval(offerAcceptance, offerApprovalId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with employee_boarding in Employee
	protected OfferAcceptance breakWithEmployeeByEmployeeBoarding(YoubenbenUserContext userContext, String offerAcceptanceId, String employeeBoardingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeListWithEmployeeBoarding(offerAcceptance, employeeBoardingId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}
	//disconnect OfferAcceptance with termination in Employee
	protected OfferAcceptance breakWithEmployeeByTermination(YoubenbenUserContext userContext, String offerAcceptanceId, String terminationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());

			synchronized(offerAcceptance){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeListWithTermination(offerAcceptance, terminationId, this.emptyOptions());

				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				return offerAcceptance;
			}
	}






	protected void checkParamsForAddingEmployee(YoubenbenUserContext userContext, String offerAcceptanceId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String employeeBoardingId, String terminationId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfOfferAcceptance(offerAcceptanceId);

		
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
		
		checkerOf(userContext).checkEmployeeBoardingIdOfEmployee(employeeBoardingId);
		
		checkerOf(userContext).checkTerminationIdOfEmployee(terminationId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);


	}
	public  OfferAcceptance addEmployee(YoubenbenUserContext userContext, String offerAcceptanceId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String employeeBoardingId, String terminationId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,offerAcceptanceId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, employeeBoardingId, terminationId,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, employeeBoardingId, terminationId);

		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, emptyOptions());
		synchronized(offerAcceptance){
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerAcceptance.addEmployee( employee );
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(YoubenbenUserContext userContext, String offerAcceptanceId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOfferAcceptance(offerAcceptanceId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);

	}
	public  OfferAcceptance updateEmployeeProperties(YoubenbenUserContext userContext, String offerAcceptanceId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,offerAcceptanceId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		OfferAcceptance offerAcceptanceToUpdate = loadOfferAcceptance(userContext, offerAcceptanceId, options);

		if(offerAcceptanceToUpdate.getEmployeeList().isEmpty()){
			throw new OfferAcceptanceManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = offerAcceptanceToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,offerAcceptanceId,name, code, used,tokensExpr);
		OfferAcceptance offerAcceptance = saveOfferAcceptance(userContext, offerAcceptanceToUpdate, tokens().withEmployeeList().done());
		synchronized(offerAcceptance){
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(YoubenbenUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String employeeBoardingId, String terminationId) throws Exception{

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

	protected void checkParamsForRemovingEmployeeList(YoubenbenUserContext userContext, String offerAcceptanceId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOfferAcceptance(offerAcceptanceId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);

	}
	public  OfferAcceptance removeEmployeeList(YoubenbenUserContext userContext, String offerAcceptanceId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, offerAcceptanceId,  employeeIds, tokensExpr);


			OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
			synchronized(offerAcceptance){
				//Will be good when the offerAcceptance loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				offerAcceptanceDaoOf(userContext).planToRemoveEmployeeList(offerAcceptance, employeeIds, allTokens());
				offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, offerAcceptance.getEmployeeList());
				return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(YoubenbenUserContext userContext, String offerAcceptanceId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOfferAcceptance( offerAcceptanceId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);

	}
	public  OfferAcceptance removeEmployee(YoubenbenUserContext userContext, String offerAcceptanceId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,offerAcceptanceId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		synchronized(offerAcceptance){
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerAcceptance.removeEmployee( employee );
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(YoubenbenUserContext userContext, String offerAcceptanceId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOfferAcceptance( offerAcceptanceId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);

	}
	public  OfferAcceptance copyEmployeeFrom(YoubenbenUserContext userContext, String offerAcceptanceId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,offerAcceptanceId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, allTokens());
		synchronized(offerAcceptance){
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			offerAcceptance.copyEmployeeFrom( employee );
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)offerAcceptance.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(YoubenbenUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfOfferAcceptance(offerAcceptanceId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(OfferAcceptanceManagerException.class);

	}

	public  OfferAcceptance updateEmployee(YoubenbenUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, offerAcceptanceId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		OfferAcceptance offerAcceptance = loadOfferAcceptance(userContext, offerAcceptanceId, loadTokens);

		synchronized(offerAcceptance){
			//Will be good when the offerAcceptance loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//offerAcceptance.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = offerAcceptance.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new OfferAcceptanceManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			offerAcceptance = saveOfferAcceptance(userContext, offerAcceptance, tokens().withEmployeeList().done());
			return present(userContext,offerAcceptance, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, OfferAcceptance newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(YoubenbenUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(YoubenbenUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(YoubenbenUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(YoubenbenUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(YoubenbenUserContextImpl userContext, LoginContext loginContext) throws Exception {
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
		YoubenbenUserContextImpl userContext = (YoubenbenUserContextImpl)baseUserContext;
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
	protected boolean isMethodNeedLogin(YoubenbenUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(YoubenbenUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(YoubenbenUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   OfferAcceptance newOfferAcceptance = this.createOfferAcceptance(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newOfferAcceptance
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, OfferAcceptance.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((YoubenbenBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<OfferAcceptance> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String offerAcceptanceId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getOfferAcceptanceDetailScope().clone();
		OfferAcceptance merchantObj = (OfferAcceptance) this.view(userContext, offerAcceptanceId);
    String merchantObjId = offerAcceptanceId;
    String linkToUrl =	"offerAcceptanceManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "接受工作要约"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
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
				MapUtil.put("id", "3-acceptTime")
				    .put("fieldName", "acceptTime")
				    .put("label", "受理时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("acceptTime", merchantObj.getAcceptTime());

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
		    "employeeManager/listByOfferAcceptance/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeListSection);

		result.put("employeeListSection", ListofUtils.toShortList(merchantObj.getEmployeeList(), "employee"));
		vscope.field("employeeListSection", YoubenbenListOfViewScope.getInstance()
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


