
package com.doublechaintech.retailscm.offerapproval;

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






public class OfferApprovalManagerImpl extends CustomRetailscmCheckerManager implements OfferApprovalManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = OfferApprovalTokens.start().withTokenFromListName(listName).done();
		OfferApproval  offerApproval = (OfferApproval) this.loadOfferApproval(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = offerApproval.collectRefercencesFromLists();
		offerApprovalDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, offerApproval, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new OfferApprovalGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "OfferApproval";
	@Override
	public OfferApprovalDAO daoOf(RetailscmUserContext userContext) {
		return offerApprovalDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws OfferApprovalManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new OfferApprovalManagerException(message);

	}



 	protected OfferApproval saveOfferApproval(RetailscmUserContext userContext, OfferApproval offerApproval, String [] tokensExpr) throws Exception{	
 		//return getOfferApprovalDAO().save(offerApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOfferApproval(userContext, offerApproval, tokens);
 	}
 	
 	protected OfferApproval saveOfferApprovalDetail(RetailscmUserContext userContext, OfferApproval offerApproval) throws Exception{	

 		
 		return saveOfferApproval(userContext, offerApproval, allTokens());
 	}
 	
 	public OfferApproval loadOfferApproval(RetailscmUserContext userContext, String offerApprovalId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOfferApproval(offerApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( OfferApprovalManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OfferApproval offerApproval = loadOfferApproval( userContext, offerApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,offerApproval, tokens);
 	}
 	
 	
 	 public OfferApproval searchOfferApproval(RetailscmUserContext userContext, String offerApprovalId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOfferApproval(offerApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( OfferApprovalManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OfferApproval offerApproval = loadOfferApproval( userContext, offerApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,offerApproval, tokens);
 	}
 	
 	

 	protected OfferApproval present(RetailscmUserContext userContext, OfferApproval offerApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,offerApproval,tokens);
		
		
		OfferApproval  offerApprovalToPresent = offerApprovalDaoOf(userContext).present(offerApproval, tokens);
		
		List<BaseEntity> entityListToNaming = offerApprovalToPresent.collectRefercencesFromLists();
		offerApprovalDaoOf(userContext).alias(entityListToNaming);
		
		return  offerApprovalToPresent;
		
		
	}
 
 	
 	
 	public OfferApproval loadOfferApprovalDetail(RetailscmUserContext userContext, String offerApprovalId) throws Exception{	
 		OfferApproval offerApproval = loadOfferApproval( userContext, offerApprovalId, allTokens());
 		return present(userContext,offerApproval, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String offerApprovalId) throws Exception{	
 		OfferApproval offerApproval = loadOfferApproval( userContext, offerApprovalId, viewTokens());
 		return present(userContext,offerApproval, allTokens());
		
 	}
 	protected OfferApproval saveOfferApproval(RetailscmUserContext userContext, OfferApproval offerApproval, Map<String,Object>tokens) throws Exception{	
 		return offerApprovalDaoOf(userContext).save(offerApproval, tokens);
 	}
 	protected OfferApproval loadOfferApproval(RetailscmUserContext userContext, String offerApprovalId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfOfferApproval(offerApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( OfferApprovalManagerException.class);

 
 		return offerApprovalDaoOf(userContext).load(offerApprovalId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OfferApproval offerApproval, Map<String, Object> tokens){
		super.addActions(userContext, offerApproval, tokens);
		
		addAction(userContext, offerApproval, tokens,"@create","createOfferApproval","createOfferApproval/","main","primary");
		addAction(userContext, offerApproval, tokens,"@update","updateOfferApproval","updateOfferApproval/"+offerApproval.getId()+"/","main","primary");
		addAction(userContext, offerApproval, tokens,"@copy","cloneOfferApproval","cloneOfferApproval/"+offerApproval.getId()+"/","main","primary");
		
		addAction(userContext, offerApproval, tokens,"offer_approval.addEmployee","addEmployee","addEmployee/"+offerApproval.getId()+"/","employeeList","primary");
		addAction(userContext, offerApproval, tokens,"offer_approval.removeEmployee","removeEmployee","removeEmployee/"+offerApproval.getId()+"/","employeeList","primary");
		addAction(userContext, offerApproval, tokens,"offer_approval.updateEmployee","updateEmployee","updateEmployee/"+offerApproval.getId()+"/","employeeList","primary");
		addAction(userContext, offerApproval, tokens,"offer_approval.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+offerApproval.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OfferApproval offerApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public OfferApproval createOfferApproval(RetailscmUserContext userContext, String who,Date approveTime,String comments) throws Exception
	//public OfferApproval createOfferApproval(RetailscmUserContext userContext,String who, Date approveTime, String comments) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfOfferApproval(who);
		checkerOf(userContext).checkApproveTimeOfOfferApproval(approveTime);
		checkerOf(userContext).checkCommentsOfOfferApproval(comments);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OfferApprovalManagerException.class);


		OfferApproval offerApproval=createNewOfferApproval();	

		offerApproval.setWho(who);
		offerApproval.setApproveTime(approveTime);
		offerApproval.setComments(comments);

		offerApproval = saveOfferApproval(userContext, offerApproval, emptyOptions());
		
		onNewInstanceCreated(userContext, offerApproval);
		return offerApproval;


	}
	protected OfferApproval createNewOfferApproval()
	{

		return new OfferApproval();
	}

	protected void checkParamsForUpdatingOfferApproval(RetailscmUserContext userContext,String offerApprovalId, int offerApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfOfferApproval(offerApprovalId);
		checkerOf(userContext).checkVersionOfOfferApproval( offerApprovalVersion);
		

		if(OfferApproval.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfOfferApproval(parseString(newValueExpr));
		
			
		}
		if(OfferApproval.APPROVE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkApproveTimeOfOfferApproval(parseDate(newValueExpr));
		
			
		}
		if(OfferApproval.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfOfferApproval(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(OfferApprovalManagerException.class);


	}



	public OfferApproval clone(RetailscmUserContext userContext, String fromOfferApprovalId) throws Exception{

		return offerApprovalDaoOf(userContext).clone(fromOfferApprovalId, this.allTokens());
	}

	public OfferApproval internalSaveOfferApproval(RetailscmUserContext userContext, OfferApproval offerApproval) throws Exception
	{
		return internalSaveOfferApproval(userContext, offerApproval, allTokens());

	}
	public OfferApproval internalSaveOfferApproval(RetailscmUserContext userContext, OfferApproval offerApproval, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingOfferApproval(userContext, offerApprovalId, offerApprovalVersion, property, newValueExpr, tokensExpr);


		synchronized(offerApproval){
			//will be good when the offerApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferApproval.
			if (offerApproval.isChanged()){
			
			}
			offerApproval = saveOfferApproval(userContext, offerApproval, options);
			return offerApproval;

		}

	}

	public OfferApproval updateOfferApproval(RetailscmUserContext userContext,String offerApprovalId, int offerApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOfferApproval(userContext, offerApprovalId, offerApprovalVersion, property, newValueExpr, tokensExpr);



		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		if(offerApproval.getVersion() != offerApprovalVersion){
			String message = "The target version("+offerApproval.getVersion()+") is not equals to version("+offerApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(offerApproval){
			//will be good when the offerApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferApproval.
			
			offerApproval.changeProperty(property, newValueExpr);
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().done());
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
			//return saveOfferApproval(userContext, offerApproval, tokens().done());
		}

	}

	public OfferApproval updateOfferApprovalProperty(RetailscmUserContext userContext,String offerApprovalId, int offerApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOfferApproval(userContext, offerApprovalId, offerApprovalVersion, property, newValueExpr, tokensExpr);

		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		if(offerApproval.getVersion() != offerApprovalVersion){
			String message = "The target version("+offerApproval.getVersion()+") is not equals to version("+offerApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(offerApproval){
			//will be good when the offerApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OfferApproval.

			offerApproval.changeProperty(property, newValueExpr);
			
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().done());
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
			//return saveOfferApproval(userContext, offerApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected OfferApprovalTokens tokens(){
		return OfferApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OfferApprovalTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OfferApprovalTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String offerApprovalId, int offerApprovalVersion) throws Exception {
		//deleteInternal(userContext, offerApprovalId, offerApprovalVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String offerApprovalId, int offerApprovalVersion) throws Exception{

		offerApprovalDaoOf(userContext).delete(offerApprovalId, offerApprovalVersion);
	}

	public OfferApproval forgetByAll(RetailscmUserContext userContext, String offerApprovalId, int offerApprovalVersion) throws Exception {
		return forgetByAllInternal(userContext, offerApprovalId, offerApprovalVersion);
	}
	protected OfferApproval forgetByAllInternal(RetailscmUserContext userContext,
			String offerApprovalId, int offerApprovalVersion) throws Exception{

		return offerApprovalDaoOf(userContext).disconnectFromAll(offerApprovalId, offerApprovalVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OfferApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return offerApprovalDaoOf(userContext).deleteAll();
	}


	//disconnect OfferApproval with company in Employee
	protected OfferApproval breakWithEmployeeByCompany(RetailscmUserContext userContext, String offerApprovalId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerApprovalDaoOf(userContext).planToRemoveEmployeeListWithCompany(offerApproval, companyId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with department in Employee
	protected OfferApproval breakWithEmployeeByDepartment(RetailscmUserContext userContext, String offerApprovalId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerApprovalDaoOf(userContext).planToRemoveEmployeeListWithDepartment(offerApproval, departmentId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with occupation in Employee
	protected OfferApproval breakWithEmployeeByOccupation(RetailscmUserContext userContext, String offerApprovalId, String occupationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerApprovalDaoOf(userContext).planToRemoveEmployeeListWithOccupation(offerApproval, occupationId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with responsible_for in Employee
	protected OfferApproval breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String offerApprovalId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerApprovalDaoOf(userContext).planToRemoveEmployeeListWithResponsibleFor(offerApproval, responsibleForId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with current_salary_grade in Employee
	protected OfferApproval breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String offerApprovalId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerApprovalDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(offerApproval, currentSalaryGradeId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with job_application in Employee
	protected OfferApproval breakWithEmployeeByJobApplication(RetailscmUserContext userContext, String offerApprovalId, String jobApplicationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerApprovalDaoOf(userContext).planToRemoveEmployeeListWithJobApplication(offerApproval, jobApplicationId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with profession_interview in Employee
	protected OfferApproval breakWithEmployeeByProfessionInterview(RetailscmUserContext userContext, String offerApprovalId, String professionInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerApprovalDaoOf(userContext).planToRemoveEmployeeListWithProfessionInterview(offerApproval, professionInterviewId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with hr_interview in Employee
	protected OfferApproval breakWithEmployeeByHrInterview(RetailscmUserContext userContext, String offerApprovalId, String hrInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerApprovalDaoOf(userContext).planToRemoveEmployeeListWithHrInterview(offerApproval, hrInterviewId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with offer_acceptance in Employee
	protected OfferApproval breakWithEmployeeByOfferAcceptance(RetailscmUserContext userContext, String offerApprovalId, String offerAcceptanceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerApprovalDaoOf(userContext).planToRemoveEmployeeListWithOfferAcceptance(offerApproval, offerAcceptanceId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with employee_boarding in Employee
	protected OfferApproval breakWithEmployeeByEmployeeBoarding(RetailscmUserContext userContext, String offerApprovalId, String employeeBoardingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerApprovalDaoOf(userContext).planToRemoveEmployeeListWithEmployeeBoarding(offerApproval, employeeBoardingId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}
	//disconnect OfferApproval with termination in Employee
	protected OfferApproval breakWithEmployeeByTermination(RetailscmUserContext userContext, String offerApprovalId, String terminationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());

			synchronized(offerApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				offerApprovalDaoOf(userContext).planToRemoveEmployeeListWithTermination(offerApproval, terminationId, this.emptyOptions());

				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				return offerApproval;
			}
	}






	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String offerApprovalId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerAcceptanceId, String employeeBoardingId, String terminationId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfOfferApproval(offerApprovalId);

		
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
		
		checkerOf(userContext).checkOfferAcceptanceIdOfEmployee(offerAcceptanceId);
		
		checkerOf(userContext).checkEmployeeBoardingIdOfEmployee(employeeBoardingId);
		
		checkerOf(userContext).checkTerminationIdOfEmployee(terminationId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OfferApprovalManagerException.class);


	}
	public  OfferApproval addEmployee(RetailscmUserContext userContext, String offerApprovalId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerAcceptanceId, String employeeBoardingId, String terminationId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,offerApprovalId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerAcceptanceId, employeeBoardingId, terminationId,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerAcceptanceId, employeeBoardingId, terminationId);

		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, emptyOptions());
		synchronized(offerApproval){
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerApproval.addEmployee( employee );
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String offerApprovalId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOfferApproval(offerApprovalId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(OfferApprovalManagerException.class);

	}
	public  OfferApproval updateEmployeeProperties(RetailscmUserContext userContext, String offerApprovalId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,offerApprovalId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		OfferApproval offerApprovalToUpdate = loadOfferApproval(userContext, offerApprovalId, options);

		if(offerApprovalToUpdate.getEmployeeList().isEmpty()){
			throw new OfferApprovalManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = offerApprovalToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,offerApprovalId,name, code, used,tokensExpr);
		OfferApproval offerApproval = saveOfferApproval(userContext, offerApprovalToUpdate, tokens().withEmployeeList().done());
		synchronized(offerApproval){
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerAcceptanceId, String employeeBoardingId, String terminationId) throws Exception{

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

	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String offerApprovalId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOfferApproval(offerApprovalId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(OfferApprovalManagerException.class);

	}
	public  OfferApproval removeEmployeeList(RetailscmUserContext userContext, String offerApprovalId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, offerApprovalId,  employeeIds, tokensExpr);


			OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
			synchronized(offerApproval){
				//Will be good when the offerApproval loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				offerApprovalDaoOf(userContext).planToRemoveEmployeeList(offerApproval, employeeIds, allTokens());
				offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, offerApproval.getEmployeeList());
				return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String offerApprovalId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOfferApproval( offerApprovalId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OfferApprovalManagerException.class);

	}
	public  OfferApproval removeEmployee(RetailscmUserContext userContext, String offerApprovalId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,offerApprovalId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		synchronized(offerApproval){
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			offerApproval.removeEmployee( employee );
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String offerApprovalId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOfferApproval( offerApprovalId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OfferApprovalManagerException.class);

	}
	public  OfferApproval copyEmployeeFrom(RetailscmUserContext userContext, String offerApprovalId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,offerApprovalId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, allTokens());
		synchronized(offerApproval){
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			offerApproval.copyEmployeeFrom( employee );
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)offerApproval.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfOfferApproval(offerApprovalId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(OfferApprovalManagerException.class);

	}

	public  OfferApproval updateEmployee(RetailscmUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, offerApprovalId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		OfferApproval offerApproval = loadOfferApproval(userContext, offerApprovalId, loadTokens);

		synchronized(offerApproval){
			//Will be good when the offerApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//offerApproval.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = offerApproval.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new OfferApprovalManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			offerApproval = saveOfferApproval(userContext, offerApproval, tokens().withEmployeeList().done());
			return present(userContext,offerApproval, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, OfferApproval newCreated) throws Exception{
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
		//   OfferApproval newOfferApproval = this.createOfferApproval(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newOfferApproval
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, OfferApproval.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<OfferApproval> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String offerApprovalId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getOfferApprovalDetailScope().clone();
		OfferApproval merchantObj = (OfferApproval) this.view(userContext, offerApprovalId);
    String merchantObjId = offerApprovalId;
    String linkToUrl =	"offerApprovalManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "审批工作要约"+"详情";
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
				MapUtil.put("id", "3-approveTime")
				    .put("fieldName", "approveTime")
				    .put("label", "批准时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("approveTime", merchantObj.getApproveTime());

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
		    "employeeManager/listByOfferApproval/"+merchantObjId+"/",
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


