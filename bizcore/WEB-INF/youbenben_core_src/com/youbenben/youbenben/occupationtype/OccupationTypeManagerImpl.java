
package com.youbenben.youbenben.occupationtype;

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
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

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






public class OccupationTypeManagerImpl extends CustomYoubenbenCheckerManager implements OccupationTypeManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = OccupationTypeTokens.start().withTokenFromListName(listName).done();
		OccupationType  occupationType = (OccupationType) this.loadOccupationType(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = occupationType.collectRefercencesFromLists();
		occupationTypeDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, occupationType, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new OccupationTypeGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "OccupationType";
	@Override
	public OccupationTypeDAO daoOf(YoubenbenUserContext userContext) {
		return occupationTypeDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws OccupationTypeManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new OccupationTypeManagerException(message);

	}



 	protected OccupationType saveOccupationType(YoubenbenUserContext userContext, OccupationType occupationType, String [] tokensExpr) throws Exception{	
 		//return getOccupationTypeDAO().save(occupationType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOccupationType(userContext, occupationType, tokens);
 	}
 	
 	protected OccupationType saveOccupationTypeDetail(YoubenbenUserContext userContext, OccupationType occupationType) throws Exception{	

 		
 		return saveOccupationType(userContext, occupationType, allTokens());
 	}
 	
 	public OccupationType loadOccupationType(YoubenbenUserContext userContext, String occupationTypeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( OccupationTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OccupationType occupationType = loadOccupationType( userContext, occupationTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,occupationType, tokens);
 	}
 	
 	
 	 public OccupationType searchOccupationType(YoubenbenUserContext userContext, String occupationTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( OccupationTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OccupationType occupationType = loadOccupationType( userContext, occupationTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,occupationType, tokens);
 	}
 	
 	

 	protected OccupationType present(YoubenbenUserContext userContext, OccupationType occupationType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,occupationType,tokens);
		
		
		OccupationType  occupationTypeToPresent = occupationTypeDaoOf(userContext).present(occupationType, tokens);
		
		List<BaseEntity> entityListToNaming = occupationTypeToPresent.collectRefercencesFromLists();
		occupationTypeDaoOf(userContext).alias(entityListToNaming);
		
		return  occupationTypeToPresent;
		
		
	}
 
 	
 	
 	public OccupationType loadOccupationTypeDetail(YoubenbenUserContext userContext, String occupationTypeId) throws Exception{	
 		OccupationType occupationType = loadOccupationType( userContext, occupationTypeId, allTokens());
 		return present(userContext,occupationType, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String occupationTypeId) throws Exception{	
 		OccupationType occupationType = loadOccupationType( userContext, occupationTypeId, viewTokens());
 		return present(userContext,occupationType, allTokens());
		
 	}
 	protected OccupationType saveOccupationType(YoubenbenUserContext userContext, OccupationType occupationType, Map<String,Object>tokens) throws Exception{	
 		return occupationTypeDaoOf(userContext).save(occupationType, tokens);
 	}
 	protected OccupationType loadOccupationType(YoubenbenUserContext userContext, String occupationTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( OccupationTypeManagerException.class);

 
 		return occupationTypeDaoOf(userContext).load(occupationTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, OccupationType occupationType, Map<String, Object> tokens){
		super.addActions(userContext, occupationType, tokens);
		
		addAction(userContext, occupationType, tokens,"@create","createOccupationType","createOccupationType/","main","primary");
		addAction(userContext, occupationType, tokens,"@update","updateOccupationType","updateOccupationType/"+occupationType.getId()+"/","main","primary");
		addAction(userContext, occupationType, tokens,"@copy","cloneOccupationType","cloneOccupationType/"+occupationType.getId()+"/","main","primary");
		
		addAction(userContext, occupationType, tokens,"occupation_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+occupationType.getId()+"/","main","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.addEmployee","addEmployee","addEmployee/"+occupationType.getId()+"/","employeeList","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.removeEmployee","removeEmployee","removeEmployee/"+occupationType.getId()+"/","employeeList","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.updateEmployee","updateEmployee","updateEmployee/"+occupationType.getId()+"/","employeeList","primary");
		addAction(userContext, occupationType, tokens,"occupation_type.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+occupationType.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, OccupationType occupationType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public OccupationType createOccupationType(YoubenbenUserContext userContext, String code,String companyId,String description,String detailDescription) throws Exception
	//public OccupationType createOccupationType(YoubenbenUserContext userContext,String code, String companyId, String description, String detailDescription) throws Exception
	{

		

		

		checkerOf(userContext).checkCodeOfOccupationType(code);
		checkerOf(userContext).checkDescriptionOfOccupationType(description);
		checkerOf(userContext).checkDetailDescriptionOfOccupationType(detailDescription);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OccupationTypeManagerException.class);


		OccupationType occupationType=createNewOccupationType();	

		occupationType.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		occupationType.setCompany(company);
		
		
		occupationType.setDescription(description);
		occupationType.setDetailDescription(detailDescription);

		occupationType = saveOccupationType(userContext, occupationType, emptyOptions());
		
		onNewInstanceCreated(userContext, occupationType);
		return occupationType;


	}
	protected OccupationType createNewOccupationType()
	{

		return new OccupationType();
	}

	protected void checkParamsForUpdatingOccupationType(YoubenbenUserContext userContext,String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);
		checkerOf(userContext).checkVersionOfOccupationType( occupationTypeVersion);
		

		if(OccupationType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfOccupationType(parseString(newValueExpr));
		
			
		}		

		
		if(OccupationType.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfOccupationType(parseString(newValueExpr));
		
			
		}
		if(OccupationType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDetailDescriptionOfOccupationType(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(OccupationTypeManagerException.class);


	}



	public OccupationType clone(YoubenbenUserContext userContext, String fromOccupationTypeId) throws Exception{

		return occupationTypeDaoOf(userContext).clone(fromOccupationTypeId, this.allTokens());
	}

	public OccupationType internalSaveOccupationType(YoubenbenUserContext userContext, OccupationType occupationType) throws Exception
	{
		return internalSaveOccupationType(userContext, occupationType, allTokens());

	}
	public OccupationType internalSaveOccupationType(YoubenbenUserContext userContext, OccupationType occupationType, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingOccupationType(userContext, occupationTypeId, occupationTypeVersion, property, newValueExpr, tokensExpr);


		synchronized(occupationType){
			//will be good when the occupationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OccupationType.
			if (occupationType.isChanged()){
			
			}
			occupationType = saveOccupationType(userContext, occupationType, options);
			return occupationType;

		}

	}

	public OccupationType updateOccupationType(YoubenbenUserContext userContext,String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOccupationType(userContext, occupationTypeId, occupationTypeVersion, property, newValueExpr, tokensExpr);



		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		if(occupationType.getVersion() != occupationTypeVersion){
			String message = "The target version("+occupationType.getVersion()+") is not equals to version("+occupationTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(occupationType){
			//will be good when the occupationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OccupationType.
			
			occupationType.changeProperty(property, newValueExpr);
			occupationType = saveOccupationType(userContext, occupationType, tokens().done());
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
			//return saveOccupationType(userContext, occupationType, tokens().done());
		}

	}

	public OccupationType updateOccupationTypeProperty(YoubenbenUserContext userContext,String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOccupationType(userContext, occupationTypeId, occupationTypeVersion, property, newValueExpr, tokensExpr);

		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		if(occupationType.getVersion() != occupationTypeVersion){
			String message = "The target version("+occupationType.getVersion()+") is not equals to version("+occupationTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(occupationType){
			//will be good when the occupationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OccupationType.

			occupationType.changeProperty(property, newValueExpr);
			
			occupationType = saveOccupationType(userContext, occupationType, tokens().done());
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
			//return saveOccupationType(userContext, occupationType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected OccupationTypeTokens tokens(){
		return OccupationTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OccupationTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OccupationTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(YoubenbenUserContext userContext, String occupationTypeId, String anotherCompanyId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(OccupationTypeManagerException.class);

 	}
 	public OccupationType transferToAnotherCompany(YoubenbenUserContext userContext, String occupationTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, occupationTypeId,anotherCompanyId);
 
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());	
		synchronized(occupationType){
			//will be good when the occupationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			occupationType.updateCompany(company);		
			occupationType = saveOccupationType(userContext, occupationType, emptyOptions());
			
			return present(userContext,occupationType, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreCountryCenter requestCandidateCompany(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForOccupationType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(YoubenbenUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newCompanyId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String occupationTypeId, int occupationTypeVersion) throws Exception {
		//deleteInternal(userContext, occupationTypeId, occupationTypeVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String occupationTypeId, int occupationTypeVersion) throws Exception{

		occupationTypeDaoOf(userContext).delete(occupationTypeId, occupationTypeVersion);
	}

	public OccupationType forgetByAll(YoubenbenUserContext userContext, String occupationTypeId, int occupationTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, occupationTypeId, occupationTypeVersion);
	}
	protected OccupationType forgetByAllInternal(YoubenbenUserContext userContext,
			String occupationTypeId, int occupationTypeVersion) throws Exception{

		return occupationTypeDaoOf(userContext).disconnectFromAll(occupationTypeId, occupationTypeVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OccupationTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return occupationTypeDaoOf(userContext).deleteAll();
	}


	//disconnect OccupationType with company in Employee
	protected OccupationType breakWithEmployeeByCompany(YoubenbenUserContext userContext, String occupationTypeId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				occupationTypeDaoOf(userContext).planToRemoveEmployeeListWithCompany(occupationType, companyId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with department in Employee
	protected OccupationType breakWithEmployeeByDepartment(YoubenbenUserContext userContext, String occupationTypeId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				occupationTypeDaoOf(userContext).planToRemoveEmployeeListWithDepartment(occupationType, departmentId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with responsible_for in Employee
	protected OccupationType breakWithEmployeeByResponsibleFor(YoubenbenUserContext userContext, String occupationTypeId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				occupationTypeDaoOf(userContext).planToRemoveEmployeeListWithResponsibleFor(occupationType, responsibleForId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with current_salary_grade in Employee
	protected OccupationType breakWithEmployeeByCurrentSalaryGrade(YoubenbenUserContext userContext, String occupationTypeId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				occupationTypeDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(occupationType, currentSalaryGradeId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with job_application in Employee
	protected OccupationType breakWithEmployeeByJobApplication(YoubenbenUserContext userContext, String occupationTypeId, String jobApplicationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				occupationTypeDaoOf(userContext).planToRemoveEmployeeListWithJobApplication(occupationType, jobApplicationId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with profession_interview in Employee
	protected OccupationType breakWithEmployeeByProfessionInterview(YoubenbenUserContext userContext, String occupationTypeId, String professionInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				occupationTypeDaoOf(userContext).planToRemoveEmployeeListWithProfessionInterview(occupationType, professionInterviewId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with hr_interview in Employee
	protected OccupationType breakWithEmployeeByHrInterview(YoubenbenUserContext userContext, String occupationTypeId, String hrInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				occupationTypeDaoOf(userContext).planToRemoveEmployeeListWithHrInterview(occupationType, hrInterviewId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with offer_approval in Employee
	protected OccupationType breakWithEmployeeByOfferApproval(YoubenbenUserContext userContext, String occupationTypeId, String offerApprovalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				occupationTypeDaoOf(userContext).planToRemoveEmployeeListWithOfferApproval(occupationType, offerApprovalId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with offer_acceptance in Employee
	protected OccupationType breakWithEmployeeByOfferAcceptance(YoubenbenUserContext userContext, String occupationTypeId, String offerAcceptanceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				occupationTypeDaoOf(userContext).planToRemoveEmployeeListWithOfferAcceptance(occupationType, offerAcceptanceId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with employee_boarding in Employee
	protected OccupationType breakWithEmployeeByEmployeeBoarding(YoubenbenUserContext userContext, String occupationTypeId, String employeeBoardingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				occupationTypeDaoOf(userContext).planToRemoveEmployeeListWithEmployeeBoarding(occupationType, employeeBoardingId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}
	//disconnect OccupationType with termination in Employee
	protected OccupationType breakWithEmployeeByTermination(YoubenbenUserContext userContext, String occupationTypeId, String terminationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());

			synchronized(occupationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				occupationTypeDaoOf(userContext).planToRemoveEmployeeListWithTermination(occupationType, terminationId, this.emptyOptions());

				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				return occupationType;
			}
	}






	protected void checkParamsForAddingEmployee(YoubenbenUserContext userContext, String occupationTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);

		
		checkerOf(userContext).checkCompanyIdOfEmployee(companyId);
		
		checkerOf(userContext).checkTitleOfEmployee(title);
		
		checkerOf(userContext).checkDepartmentIdOfEmployee(departmentId);
		
		checkerOf(userContext).checkFamilyNameOfEmployee(familyName);
		
		checkerOf(userContext).checkGivenNameOfEmployee(givenName);
		
		checkerOf(userContext).checkEmailOfEmployee(email);
		
		checkerOf(userContext).checkCityOfEmployee(city);
		
		checkerOf(userContext).checkAddressOfEmployee(address);
		
		checkerOf(userContext).checkCellPhoneOfEmployee(cellPhone);
		
		checkerOf(userContext).checkResponsibleForIdOfEmployee(responsibleForId);
		
		checkerOf(userContext).checkCurrentSalaryGradeIdOfEmployee(currentSalaryGradeId);
		
		checkerOf(userContext).checkSalaryAccountOfEmployee(salaryAccount);
		
		checkerOf(userContext).checkJobApplicationIdOfEmployee(jobApplicationId);
		
		checkerOf(userContext).checkProfessionInterviewIdOfEmployee(professionInterviewId);
		
		checkerOf(userContext).checkHrInterviewIdOfEmployee(hrInterviewId);
		
		checkerOf(userContext).checkOfferApprovalIdOfEmployee(offerApprovalId);
		
		checkerOf(userContext).checkOfferAcceptanceIdOfEmployee(offerAcceptanceId);
		
		checkerOf(userContext).checkEmployeeBoardingIdOfEmployee(employeeBoardingId);
		
		checkerOf(userContext).checkTerminationIdOfEmployee(terminationId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OccupationTypeManagerException.class);


	}
	public  OccupationType addEmployee(YoubenbenUserContext userContext, String occupationTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,occupationTypeId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId);

		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, emptyOptions());
		synchronized(occupationType){
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			occupationType.addEmployee( employee );
			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(YoubenbenUserContext userContext, String occupationTypeId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(OccupationTypeManagerException.class);

	}
	public  OccupationType updateEmployeeProperties(YoubenbenUserContext userContext, String occupationTypeId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,occupationTypeId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		OccupationType occupationTypeToUpdate = loadOccupationType(userContext, occupationTypeId, options);

		if(occupationTypeToUpdate.getEmployeeList().isEmpty()){
			throw new OccupationTypeManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = occupationTypeToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,occupationTypeId,name, code, used,tokensExpr);
		OccupationType occupationType = saveOccupationType(userContext, occupationTypeToUpdate, tokens().withEmployeeList().done());
		synchronized(occupationType){
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(YoubenbenUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId) throws Exception{

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

	protected void checkParamsForRemovingEmployeeList(YoubenbenUserContext userContext, String occupationTypeId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(OccupationTypeManagerException.class);

	}
	public  OccupationType removeEmployeeList(YoubenbenUserContext userContext, String occupationTypeId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, occupationTypeId,  employeeIds, tokensExpr);


			OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
			synchronized(occupationType){
				//Will be good when the occupationType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				occupationTypeDaoOf(userContext).planToRemoveEmployeeList(occupationType, employeeIds, allTokens());
				occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, occupationType.getEmployeeList());
				return present(userContext,occupationType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(YoubenbenUserContext userContext, String occupationTypeId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOccupationType( occupationTypeId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OccupationTypeManagerException.class);

	}
	public  OccupationType removeEmployee(YoubenbenUserContext userContext, String occupationTypeId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,occupationTypeId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		synchronized(occupationType){
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			occupationType.removeEmployee( employee );
			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(YoubenbenUserContext userContext, String occupationTypeId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOccupationType( occupationTypeId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OccupationTypeManagerException.class);

	}
	public  OccupationType copyEmployeeFrom(YoubenbenUserContext userContext, String occupationTypeId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,occupationTypeId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, allTokens());
		synchronized(occupationType){
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			occupationType.copyEmployeeFrom( employee );
			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)occupationType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(YoubenbenUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(OccupationTypeManagerException.class);

	}

	public  OccupationType updateEmployee(YoubenbenUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, occupationTypeId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		OccupationType occupationType = loadOccupationType(userContext, occupationTypeId, loadTokens);

		synchronized(occupationType){
			//Will be good when the occupationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//occupationType.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = occupationType.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new OccupationTypeManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			occupationType = saveOccupationType(userContext, occupationType, tokens().withEmployeeList().done());
			return present(userContext,occupationType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, OccupationType newCreated) throws Exception{
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
		//   OccupationType newOccupationType = this.createOccupationType(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newOccupationType
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, OccupationType.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<OccupationType> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> companyList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(companyList, RetailStoreCountryCenter.class);


    }
	
	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception {
		return listPageByCompany(userContext, companyId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception {
		SmartList<OccupationType> list = occupationTypeDaoOf(userContext).findOccupationTypeByCompany(companyId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(OccupationType.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("职位类型列表");
		page.setRequestName("listByCompany");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCompany/%s/",  getBeanName(), companyId)));

		page.assemblerContent(userContext, "listByCompany");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String occupationTypeId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getOccupationTypeDetailScope().clone();
		OccupationType merchantObj = (OccupationType) this.view(userContext, occupationTypeId);
    String merchantObjId = occupationTypeId;
    String linkToUrl =	"occupationTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "职位类型"+"详情";
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
				MapUtil.put("id", "2-code")
				    .put("fieldName", "code")
				    .put("label", "编码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("code", merchantObj.getCode());

		propList.add(
				MapUtil.put("id", "3-company")
				    .put("fieldName", "company")
				    .put("label", "公司")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("company", merchantObj.getCompany());

		propList.add(
				MapUtil.put("id", "4-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "5-detailDescription")
				    .put("fieldName", "detailDescription")
				    .put("label", "详细描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("detailDescription", merchantObj.getDetailDescription());

		//处理 sectionList

		//处理Section：employeeListSection
		Map employeeListSection = ListofUtils.buildSection(
		    "employeeListSection",
		    "员工列表",
		    null,
		    "",
		    "__no_group",
		    "employeeManager/listByOccupation/"+merchantObjId+"/",
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


