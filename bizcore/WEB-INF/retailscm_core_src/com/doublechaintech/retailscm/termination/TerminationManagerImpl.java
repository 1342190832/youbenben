
package com.doublechaintech.retailscm.termination;

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
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;

import com.doublechaintech.retailscm.terminationtype.CandidateTerminationType;
import com.doublechaintech.retailscm.terminationreason.CandidateTerminationReason;

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






public class TerminationManagerImpl extends CustomRetailscmCheckerManager implements TerminationManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = TerminationTokens.start().withTokenFromListName(listName).done();
		Termination  termination = (Termination) this.loadTermination(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = termination.collectRefercencesFromLists();
		terminationDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, termination, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new TerminationGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "Termination";
	@Override
	public TerminationDAO daoOf(RetailscmUserContext userContext) {
		return terminationDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws TerminationManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new TerminationManagerException(message);

	}



 	protected Termination saveTermination(RetailscmUserContext userContext, Termination termination, String [] tokensExpr) throws Exception{	
 		//return getTerminationDAO().save(termination, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTermination(userContext, termination, tokens);
 	}
 	
 	protected Termination saveTerminationDetail(RetailscmUserContext userContext, Termination termination) throws Exception{	

 		
 		return saveTermination(userContext, termination, allTokens());
 	}
 	
 	public Termination loadTermination(RetailscmUserContext userContext, String terminationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).throwExceptionIfHasErrors( TerminationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Termination termination = loadTermination( userContext, terminationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,termination, tokens);
 	}
 	
 	
 	 public Termination searchTermination(RetailscmUserContext userContext, String terminationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).throwExceptionIfHasErrors( TerminationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Termination termination = loadTermination( userContext, terminationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,termination, tokens);
 	}
 	
 	

 	protected Termination present(RetailscmUserContext userContext, Termination termination, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,termination,tokens);
		
		
		Termination  terminationToPresent = terminationDaoOf(userContext).present(termination, tokens);
		
		List<BaseEntity> entityListToNaming = terminationToPresent.collectRefercencesFromLists();
		terminationDaoOf(userContext).alias(entityListToNaming);
		
		return  terminationToPresent;
		
		
	}
 
 	
 	
 	public Termination loadTerminationDetail(RetailscmUserContext userContext, String terminationId) throws Exception{	
 		Termination termination = loadTermination( userContext, terminationId, allTokens());
 		return present(userContext,termination, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String terminationId) throws Exception{	
 		Termination termination = loadTermination( userContext, terminationId, viewTokens());
 		return present(userContext,termination, allTokens());
		
 	}
 	protected Termination saveTermination(RetailscmUserContext userContext, Termination termination, Map<String,Object>tokens) throws Exception{	
 		return terminationDaoOf(userContext).save(termination, tokens);
 	}
 	protected Termination loadTermination(RetailscmUserContext userContext, String terminationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).throwExceptionIfHasErrors( TerminationManagerException.class);

 
 		return terminationDaoOf(userContext).load(terminationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Termination termination, Map<String, Object> tokens){
		super.addActions(userContext, termination, tokens);
		
		addAction(userContext, termination, tokens,"@create","createTermination","createTermination/","main","primary");
		addAction(userContext, termination, tokens,"@update","updateTermination","updateTermination/"+termination.getId()+"/","main","primary");
		addAction(userContext, termination, tokens,"@copy","cloneTermination","cloneTermination/"+termination.getId()+"/","main","primary");
		
		addAction(userContext, termination, tokens,"termination.transfer_to_reason","transferToAnotherReason","transferToAnotherReason/"+termination.getId()+"/","main","primary");
		addAction(userContext, termination, tokens,"termination.transfer_to_type","transferToAnotherType","transferToAnotherType/"+termination.getId()+"/","main","primary");
		addAction(userContext, termination, tokens,"termination.addEmployee","addEmployee","addEmployee/"+termination.getId()+"/","employeeList","primary");
		addAction(userContext, termination, tokens,"termination.removeEmployee","removeEmployee","removeEmployee/"+termination.getId()+"/","employeeList","primary");
		addAction(userContext, termination, tokens,"termination.updateEmployee","updateEmployee","updateEmployee/"+termination.getId()+"/","employeeList","primary");
		addAction(userContext, termination, tokens,"termination.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+termination.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Termination termination, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Termination createTermination(RetailscmUserContext userContext, String reasonId,String typeId,String comment) throws Exception
	//public Termination createTermination(RetailscmUserContext userContext,String reasonId, String typeId, String comment) throws Exception
	{

		

		

		checkerOf(userContext).checkCommentOfTermination(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);


		Termination termination=createNewTermination();	

			
		TerminationReason reason = loadTerminationReason(userContext, reasonId,emptyOptions());
		termination.setReason(reason);
		
		
			
		TerminationType type = loadTerminationType(userContext, typeId,emptyOptions());
		termination.setType(type);
		
		
		termination.setComment(comment);

		termination = saveTermination(userContext, termination, emptyOptions());
		
		onNewInstanceCreated(userContext, termination);
		return termination;


	}
	protected Termination createNewTermination()
	{

		return new Termination();
	}

	protected void checkParamsForUpdatingTermination(RetailscmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).checkVersionOfTermination( terminationVersion);
		
		

				

		
		if(Termination.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfTermination(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);


	}



	public Termination clone(RetailscmUserContext userContext, String fromTerminationId) throws Exception{

		return terminationDaoOf(userContext).clone(fromTerminationId, this.allTokens());
	}

	public Termination internalSaveTermination(RetailscmUserContext userContext, Termination termination) throws Exception
	{
		return internalSaveTermination(userContext, termination, allTokens());

	}
	public Termination internalSaveTermination(RetailscmUserContext userContext, Termination termination, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingTermination(userContext, terminationId, terminationVersion, property, newValueExpr, tokensExpr);


		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Termination.
			if (termination.isChanged()){
			
			}
			termination = saveTermination(userContext, termination, options);
			return termination;

		}

	}

	public Termination updateTermination(RetailscmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTermination(userContext, terminationId, terminationVersion, property, newValueExpr, tokensExpr);



		Termination termination = loadTermination(userContext, terminationId, allTokens());
		if(termination.getVersion() != terminationVersion){
			String message = "The target version("+termination.getVersion()+") is not equals to version("+terminationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Termination.
			
			termination.changeProperty(property, newValueExpr);
			termination = saveTermination(userContext, termination, tokens().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
			//return saveTermination(userContext, termination, tokens().done());
		}

	}

	public Termination updateTerminationProperty(RetailscmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTermination(userContext, terminationId, terminationVersion, property, newValueExpr, tokensExpr);

		Termination termination = loadTermination(userContext, terminationId, allTokens());
		if(termination.getVersion() != terminationVersion){
			String message = "The target version("+termination.getVersion()+") is not equals to version("+terminationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Termination.

			termination.changeProperty(property, newValueExpr);
			
			termination = saveTermination(userContext, termination, tokens().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
			//return saveTermination(userContext, termination, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected TerminationTokens tokens(){
		return TerminationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TerminationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TerminationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherReason(RetailscmUserContext userContext, String terminationId, String anotherReasonId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTermination(terminationId);
 		checkerOf(userContext).checkIdOfTerminationReason(anotherReasonId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);

 	}
 	public Termination transferToAnotherReason(RetailscmUserContext userContext, String terminationId, String anotherReasonId) throws Exception
 	{
 		checkParamsForTransferingAnotherReason(userContext, terminationId,anotherReasonId);
 
		Termination termination = loadTermination(userContext, terminationId, allTokens());	
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TerminationReason reason = loadTerminationReason(userContext, anotherReasonId, emptyOptions());		
			termination.updateReason(reason);		
			termination = saveTermination(userContext, termination, emptyOptions());
			
			return present(userContext,termination, allTokens());
			
		}

 	}

	


	public CandidateTerminationReason requestCandidateReason(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTerminationReason result = new CandidateTerminationReason();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TerminationReason> candidateList = terminationReasonDaoOf(userContext).requestCandidateTerminationReasonForTermination(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherType(RetailscmUserContext userContext, String terminationId, String anotherTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTermination(terminationId);
 		checkerOf(userContext).checkIdOfTerminationType(anotherTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);

 	}
 	public Termination transferToAnotherType(RetailscmUserContext userContext, String terminationId, String anotherTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherType(userContext, terminationId,anotherTypeId);
 
		Termination termination = loadTermination(userContext, terminationId, allTokens());	
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TerminationType type = loadTerminationType(userContext, anotherTypeId, emptyOptions());		
			termination.updateType(type);		
			termination = saveTermination(userContext, termination, emptyOptions());
			
			return present(userContext,termination, allTokens());
			
		}

 	}

	


	public CandidateTerminationType requestCandidateType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTerminationType result = new CandidateTerminationType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TerminationType> candidateList = terminationTypeDaoOf(userContext).requestCandidateTerminationTypeForTermination(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected TerminationReason loadTerminationReason(RetailscmUserContext userContext, String newReasonId, Map<String,Object> options) throws Exception
 	{

 		return terminationReasonDaoOf(userContext).load(newReasonId, options);
 	}
 	


	

 	protected TerminationType loadTerminationType(RetailscmUserContext userContext, String newTypeId, Map<String,Object> options) throws Exception
 	{

 		return terminationTypeDaoOf(userContext).load(newTypeId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String terminationId, int terminationVersion) throws Exception {
		//deleteInternal(userContext, terminationId, terminationVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String terminationId, int terminationVersion) throws Exception{

		terminationDaoOf(userContext).delete(terminationId, terminationVersion);
	}

	public Termination forgetByAll(RetailscmUserContext userContext, String terminationId, int terminationVersion) throws Exception {
		return forgetByAllInternal(userContext, terminationId, terminationVersion);
	}
	protected Termination forgetByAllInternal(RetailscmUserContext userContext,
			String terminationId, int terminationVersion) throws Exception{

		return terminationDaoOf(userContext).disconnectFromAll(terminationId, terminationVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TerminationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return terminationDaoOf(userContext).deleteAll();
	}


	//disconnect Termination with company in Employee
	protected Termination breakWithEmployeeByCompany(RetailscmUserContext userContext, String terminationId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationDaoOf(userContext).planToRemoveEmployeeListWithCompany(termination, companyId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with department in Employee
	protected Termination breakWithEmployeeByDepartment(RetailscmUserContext userContext, String terminationId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationDaoOf(userContext).planToRemoveEmployeeListWithDepartment(termination, departmentId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with occupation in Employee
	protected Termination breakWithEmployeeByOccupation(RetailscmUserContext userContext, String terminationId, String occupationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationDaoOf(userContext).planToRemoveEmployeeListWithOccupation(termination, occupationId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with responsible_for in Employee
	protected Termination breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String terminationId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationDaoOf(userContext).planToRemoveEmployeeListWithResponsibleFor(termination, responsibleForId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with current_salary_grade in Employee
	protected Termination breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String terminationId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(termination, currentSalaryGradeId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with job_application in Employee
	protected Termination breakWithEmployeeByJobApplication(RetailscmUserContext userContext, String terminationId, String jobApplicationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationDaoOf(userContext).planToRemoveEmployeeListWithJobApplication(termination, jobApplicationId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with profession_interview in Employee
	protected Termination breakWithEmployeeByProfessionInterview(RetailscmUserContext userContext, String terminationId, String professionInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationDaoOf(userContext).planToRemoveEmployeeListWithProfessionInterview(termination, professionInterviewId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with hr_interview in Employee
	protected Termination breakWithEmployeeByHrInterview(RetailscmUserContext userContext, String terminationId, String hrInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationDaoOf(userContext).planToRemoveEmployeeListWithHrInterview(termination, hrInterviewId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with offer_approval in Employee
	protected Termination breakWithEmployeeByOfferApproval(RetailscmUserContext userContext, String terminationId, String offerApprovalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationDaoOf(userContext).planToRemoveEmployeeListWithOfferApproval(termination, offerApprovalId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with offer_acceptance in Employee
	protected Termination breakWithEmployeeByOfferAcceptance(RetailscmUserContext userContext, String terminationId, String offerAcceptanceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationDaoOf(userContext).planToRemoveEmployeeListWithOfferAcceptance(termination, offerAcceptanceId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with employee_boarding in Employee
	protected Termination breakWithEmployeeByEmployeeBoarding(RetailscmUserContext userContext, String terminationId, String employeeBoardingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationDaoOf(userContext).planToRemoveEmployeeListWithEmployeeBoarding(termination, employeeBoardingId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}






	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String terminationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfTermination(terminationId);

		
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
		
		checkerOf(userContext).checkEmployeeBoardingIdOfEmployee(employeeBoardingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);


	}
	public  Termination addEmployee(RetailscmUserContext userContext, String terminationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,terminationId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId);

		Termination termination = loadTermination(userContext, terminationId, emptyOptions());
		synchronized(termination){
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			termination.addEmployee( employee );
			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String terminationId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);

	}
	public  Termination updateEmployeeProperties(RetailscmUserContext userContext, String terminationId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,terminationId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		Termination terminationToUpdate = loadTermination(userContext, terminationId, options);

		if(terminationToUpdate.getEmployeeList().isEmpty()){
			throw new TerminationManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = terminationToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,terminationId,name, code, used,tokensExpr);
		Termination termination = saveTermination(userContext, terminationToUpdate, tokens().withEmployeeList().done());
		synchronized(termination){
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId) throws Exception{

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
		EmployeeBoarding  employeeBoarding = new EmployeeBoarding();
		employeeBoarding.setId(employeeBoardingId);		
		employee.setEmployeeBoarding(employeeBoarding);		
		employee.setLastUpdateTime(userContext.now());
	
		
		return employee;


	}

	protected Employee createIndexedEmployee(String id, int version){

		Employee employee = new Employee();
		employee.setId(id);
		employee.setVersion(version);
		return employee;

	}

	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String terminationId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTermination(terminationId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);

	}
	public  Termination removeEmployeeList(RetailscmUserContext userContext, String terminationId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, terminationId,  employeeIds, tokensExpr);


			Termination termination = loadTermination(userContext, terminationId, allTokens());
			synchronized(termination){
				//Will be good when the termination loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				terminationDaoOf(userContext).planToRemoveEmployeeList(termination, employeeIds, allTokens());
				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, termination.getEmployeeList());
				return present(userContext,termination, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String terminationId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTermination( terminationId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);

	}
	public  Termination removeEmployee(RetailscmUserContext userContext, String terminationId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,terminationId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		synchronized(termination){
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			termination.removeEmployee( employee );
			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String terminationId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTermination( terminationId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);

	}
	public  Termination copyEmployeeFrom(RetailscmUserContext userContext, String terminationId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,terminationId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		synchronized(termination){
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			termination.copyEmployeeFrom( employee );
			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)termination.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String terminationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfTermination(terminationId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);

	}

	public  Termination updateEmployee(RetailscmUserContext userContext, String terminationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, terminationId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		Termination termination = loadTermination(userContext, terminationId, loadTokens);

		synchronized(termination){
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//termination.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = termination.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new TerminationManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, Termination newCreated) throws Exception{
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
		//   Termination newTermination = this.createTermination(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newTermination
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Termination.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<Termination> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<TerminationReason> reasonList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TerminationReason.class);
		userContext.getDAOGroup().enhanceList(reasonList, TerminationReason.class);
		List<TerminationType> typeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TerminationType.class);
		userContext.getDAOGroup().enhanceList(typeList, TerminationType.class);


    }
	
	public Object listByReason(RetailscmUserContext userContext,String reasonId) throws Exception {
		return listPageByReason(userContext, reasonId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByReason(RetailscmUserContext userContext,String reasonId, int start, int count) throws Exception {
		SmartList<Termination> list = terminationDaoOf(userContext).findTerminationByReason(reasonId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Termination.class);
		page.setContainerObject(TerminationReason.withId(reasonId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("雇佣终止列表");
		page.setRequestName("listByReason");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByReason/%s/",  getBeanName(), reasonId)));

		page.assemblerContent(userContext, "listByReason");
		return page.doRender(userContext);
	}
  
	public Object listByType(RetailscmUserContext userContext,String typeId) throws Exception {
		return listPageByType(userContext, typeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByType(RetailscmUserContext userContext,String typeId, int start, int count) throws Exception {
		SmartList<Termination> list = terminationDaoOf(userContext).findTerminationByType(typeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Termination.class);
		page.setContainerObject(TerminationType.withId(typeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("雇佣终止列表");
		page.setRequestName("listByType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByType/%s/",  getBeanName(), typeId)));

		page.assemblerContent(userContext, "listByType");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String terminationId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getTerminationDetailScope().clone();
		Termination merchantObj = (Termination) this.view(userContext, terminationId);
    String merchantObjId = terminationId;
    String linkToUrl =	"terminationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "雇佣终止"+"详情";
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
				MapUtil.put("id", "2-reason")
				    .put("fieldName", "reason")
				    .put("label", "原因")
				    .put("type", "auto")
				    .put("linkToUrl", "terminationReasonManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"code\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("reason", merchantObj.getReason());

		propList.add(
				MapUtil.put("id", "3-type")
				    .put("fieldName", "type")
				    .put("label", "类型")
				    .put("type", "auto")
				    .put("linkToUrl", "terminationTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"base_description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"code\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("type", merchantObj.getType());

		propList.add(
				MapUtil.put("id", "4-comment")
				    .put("fieldName", "comment")
				    .put("label", "评论")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("comment", merchantObj.getComment());

		//处理 sectionList

		//处理Section：employeeListSection
		Map employeeListSection = ListofUtils.buildSection(
		    "employeeListSection",
		    "员工列表",
		    null,
		    "",
		    "__no_group",
		    "employeeManager/listByTermination/"+merchantObjId+"/",
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


