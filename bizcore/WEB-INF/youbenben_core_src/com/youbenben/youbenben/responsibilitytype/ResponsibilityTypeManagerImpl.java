
package com.youbenben.youbenben.responsibilitytype;

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






public class ResponsibilityTypeManagerImpl extends CustomYoubenbenCheckerManager implements ResponsibilityTypeManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = ResponsibilityTypeTokens.start().withTokenFromListName(listName).done();
		ResponsibilityType  responsibilityType = (ResponsibilityType) this.loadResponsibilityType(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = responsibilityType.collectRefercencesFromLists();
		responsibilityTypeDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, responsibilityType, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new ResponsibilityTypeGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "ResponsibilityType";
	@Override
	public ResponsibilityTypeDAO daoOf(YoubenbenUserContext userContext) {
		return responsibilityTypeDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ResponsibilityTypeManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ResponsibilityTypeManagerException(message);

	}



 	protected ResponsibilityType saveResponsibilityType(YoubenbenUserContext userContext, ResponsibilityType responsibilityType, String [] tokensExpr) throws Exception{	
 		//return getResponsibilityTypeDAO().save(responsibilityType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveResponsibilityType(userContext, responsibilityType, tokens);
 	}
 	
 	protected ResponsibilityType saveResponsibilityTypeDetail(YoubenbenUserContext userContext, ResponsibilityType responsibilityType) throws Exception{	

 		
 		return saveResponsibilityType(userContext, responsibilityType, allTokens());
 	}
 	
 	public ResponsibilityType loadResponsibilityType(YoubenbenUserContext userContext, String responsibilityTypeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ResponsibilityTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,responsibilityType, tokens);
 	}
 	
 	
 	 public ResponsibilityType searchResponsibilityType(YoubenbenUserContext userContext, String responsibilityTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ResponsibilityTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,responsibilityType, tokens);
 	}
 	
 	

 	protected ResponsibilityType present(YoubenbenUserContext userContext, ResponsibilityType responsibilityType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,responsibilityType,tokens);
		
		
		ResponsibilityType  responsibilityTypeToPresent = responsibilityTypeDaoOf(userContext).present(responsibilityType, tokens);
		
		List<BaseEntity> entityListToNaming = responsibilityTypeToPresent.collectRefercencesFromLists();
		responsibilityTypeDaoOf(userContext).alias(entityListToNaming);
		
		return  responsibilityTypeToPresent;
		
		
	}
 
 	
 	
 	public ResponsibilityType loadResponsibilityTypeDetail(YoubenbenUserContext userContext, String responsibilityTypeId) throws Exception{	
 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, allTokens());
 		return present(userContext,responsibilityType, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String responsibilityTypeId) throws Exception{	
 		ResponsibilityType responsibilityType = loadResponsibilityType( userContext, responsibilityTypeId, viewTokens());
 		return present(userContext,responsibilityType, allTokens());
		
 	}
 	protected ResponsibilityType saveResponsibilityType(YoubenbenUserContext userContext, ResponsibilityType responsibilityType, Map<String,Object>tokens) throws Exception{	
 		return responsibilityTypeDaoOf(userContext).save(responsibilityType, tokens);
 	}
 	protected ResponsibilityType loadResponsibilityType(YoubenbenUserContext userContext, String responsibilityTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ResponsibilityTypeManagerException.class);

 
 		return responsibilityTypeDaoOf(userContext).load(responsibilityTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, ResponsibilityType responsibilityType, Map<String, Object> tokens){
		super.addActions(userContext, responsibilityType, tokens);
		
		addAction(userContext, responsibilityType, tokens,"@create","createResponsibilityType","createResponsibilityType/","main","primary");
		addAction(userContext, responsibilityType, tokens,"@update","updateResponsibilityType","updateResponsibilityType/"+responsibilityType.getId()+"/","main","primary");
		addAction(userContext, responsibilityType, tokens,"@copy","cloneResponsibilityType","cloneResponsibilityType/"+responsibilityType.getId()+"/","main","primary");
		
		addAction(userContext, responsibilityType, tokens,"responsibility_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+responsibilityType.getId()+"/","main","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.addEmployee","addEmployee","addEmployee/"+responsibilityType.getId()+"/","employeeList","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.removeEmployee","removeEmployee","removeEmployee/"+responsibilityType.getId()+"/","employeeList","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.updateEmployee","updateEmployee","updateEmployee/"+responsibilityType.getId()+"/","employeeList","primary");
		addAction(userContext, responsibilityType, tokens,"responsibility_type.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+responsibilityType.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, ResponsibilityType responsibilityType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ResponsibilityType createResponsibilityType(YoubenbenUserContext userContext, String code,String companyId,String baseDescription,String detailDescription) throws Exception
	//public ResponsibilityType createResponsibilityType(YoubenbenUserContext userContext,String code, String companyId, String baseDescription, String detailDescription) throws Exception
	{

		

		

		checkerOf(userContext).checkCodeOfResponsibilityType(code);
		checkerOf(userContext).checkBaseDescriptionOfResponsibilityType(baseDescription);
		checkerOf(userContext).checkDetailDescriptionOfResponsibilityType(detailDescription);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);


		ResponsibilityType responsibilityType=createNewResponsibilityType();	

		responsibilityType.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		responsibilityType.setCompany(company);
		
		
		responsibilityType.setBaseDescription(baseDescription);
		responsibilityType.setDetailDescription(detailDescription);

		responsibilityType = saveResponsibilityType(userContext, responsibilityType, emptyOptions());
		
		onNewInstanceCreated(userContext, responsibilityType);
		return responsibilityType;


	}
	protected ResponsibilityType createNewResponsibilityType()
	{

		return new ResponsibilityType();
	}

	protected void checkParamsForUpdatingResponsibilityType(YoubenbenUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		checkerOf(userContext).checkVersionOfResponsibilityType( responsibilityTypeVersion);
		

		if(ResponsibilityType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfResponsibilityType(parseString(newValueExpr));
		
			
		}		

		
		if(ResponsibilityType.BASE_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBaseDescriptionOfResponsibilityType(parseString(newValueExpr));
		
			
		}
		if(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDetailDescriptionOfResponsibilityType(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);


	}



	public ResponsibilityType clone(YoubenbenUserContext userContext, String fromResponsibilityTypeId) throws Exception{

		return responsibilityTypeDaoOf(userContext).clone(fromResponsibilityTypeId, this.allTokens());
	}

	public ResponsibilityType internalSaveResponsibilityType(YoubenbenUserContext userContext, ResponsibilityType responsibilityType) throws Exception
	{
		return internalSaveResponsibilityType(userContext, responsibilityType, allTokens());

	}
	public ResponsibilityType internalSaveResponsibilityType(YoubenbenUserContext userContext, ResponsibilityType responsibilityType, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingResponsibilityType(userContext, responsibilityTypeId, responsibilityTypeVersion, property, newValueExpr, tokensExpr);


		synchronized(responsibilityType){
			//will be good when the responsibilityType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ResponsibilityType.
			if (responsibilityType.isChanged()){
			
			}
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, options);
			return responsibilityType;

		}

	}

	public ResponsibilityType updateResponsibilityType(YoubenbenUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingResponsibilityType(userContext, responsibilityTypeId, responsibilityTypeVersion, property, newValueExpr, tokensExpr);



		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		if(responsibilityType.getVersion() != responsibilityTypeVersion){
			String message = "The target version("+responsibilityType.getVersion()+") is not equals to version("+responsibilityTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(responsibilityType){
			//will be good when the responsibilityType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ResponsibilityType.
			
			responsibilityType.changeProperty(property, newValueExpr);
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().done());
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
			//return saveResponsibilityType(userContext, responsibilityType, tokens().done());
		}

	}

	public ResponsibilityType updateResponsibilityTypeProperty(YoubenbenUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingResponsibilityType(userContext, responsibilityTypeId, responsibilityTypeVersion, property, newValueExpr, tokensExpr);

		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		if(responsibilityType.getVersion() != responsibilityTypeVersion){
			String message = "The target version("+responsibilityType.getVersion()+") is not equals to version("+responsibilityTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(responsibilityType){
			//will be good when the responsibilityType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ResponsibilityType.

			responsibilityType.changeProperty(property, newValueExpr);
			
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().done());
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
			//return saveResponsibilityType(userContext, responsibilityType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ResponsibilityTypeTokens tokens(){
		return ResponsibilityTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ResponsibilityTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ResponsibilityTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(YoubenbenUserContext userContext, String responsibilityTypeId, String anotherCompanyId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);

 	}
 	public ResponsibilityType transferToAnotherCompany(YoubenbenUserContext userContext, String responsibilityTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, responsibilityTypeId,anotherCompanyId);
 
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());	
		synchronized(responsibilityType){
			//will be good when the responsibilityType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			responsibilityType.updateCompany(company);		
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, emptyOptions());
			
			return present(userContext,responsibilityType, allTokens());
			
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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForResponsibilityType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(YoubenbenUserContext userContext, String responsibilityTypeId, int responsibilityTypeVersion) throws Exception {
		//deleteInternal(userContext, responsibilityTypeId, responsibilityTypeVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String responsibilityTypeId, int responsibilityTypeVersion) throws Exception{

		responsibilityTypeDaoOf(userContext).delete(responsibilityTypeId, responsibilityTypeVersion);
	}

	public ResponsibilityType forgetByAll(YoubenbenUserContext userContext, String responsibilityTypeId, int responsibilityTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, responsibilityTypeId, responsibilityTypeVersion);
	}
	protected ResponsibilityType forgetByAllInternal(YoubenbenUserContext userContext,
			String responsibilityTypeId, int responsibilityTypeVersion) throws Exception{

		return responsibilityTypeDaoOf(userContext).disconnectFromAll(responsibilityTypeId, responsibilityTypeVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ResponsibilityTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return responsibilityTypeDaoOf(userContext).deleteAll();
	}


	//disconnect ResponsibilityType with company in Employee
	protected ResponsibilityType breakWithEmployeeByCompany(YoubenbenUserContext userContext, String responsibilityTypeId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeListWithCompany(responsibilityType, companyId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with department in Employee
	protected ResponsibilityType breakWithEmployeeByDepartment(YoubenbenUserContext userContext, String responsibilityTypeId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeListWithDepartment(responsibilityType, departmentId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with occupation in Employee
	protected ResponsibilityType breakWithEmployeeByOccupation(YoubenbenUserContext userContext, String responsibilityTypeId, String occupationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeListWithOccupation(responsibilityType, occupationId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with current_salary_grade in Employee
	protected ResponsibilityType breakWithEmployeeByCurrentSalaryGrade(YoubenbenUserContext userContext, String responsibilityTypeId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(responsibilityType, currentSalaryGradeId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with job_application in Employee
	protected ResponsibilityType breakWithEmployeeByJobApplication(YoubenbenUserContext userContext, String responsibilityTypeId, String jobApplicationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeListWithJobApplication(responsibilityType, jobApplicationId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with profession_interview in Employee
	protected ResponsibilityType breakWithEmployeeByProfessionInterview(YoubenbenUserContext userContext, String responsibilityTypeId, String professionInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeListWithProfessionInterview(responsibilityType, professionInterviewId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with hr_interview in Employee
	protected ResponsibilityType breakWithEmployeeByHrInterview(YoubenbenUserContext userContext, String responsibilityTypeId, String hrInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeListWithHrInterview(responsibilityType, hrInterviewId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with offer_approval in Employee
	protected ResponsibilityType breakWithEmployeeByOfferApproval(YoubenbenUserContext userContext, String responsibilityTypeId, String offerApprovalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeListWithOfferApproval(responsibilityType, offerApprovalId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with offer_acceptance in Employee
	protected ResponsibilityType breakWithEmployeeByOfferAcceptance(YoubenbenUserContext userContext, String responsibilityTypeId, String offerAcceptanceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeListWithOfferAcceptance(responsibilityType, offerAcceptanceId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with employee_boarding in Employee
	protected ResponsibilityType breakWithEmployeeByEmployeeBoarding(YoubenbenUserContext userContext, String responsibilityTypeId, String employeeBoardingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeListWithEmployeeBoarding(responsibilityType, employeeBoardingId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}
	//disconnect ResponsibilityType with termination in Employee
	protected ResponsibilityType breakWithEmployeeByTermination(YoubenbenUserContext userContext, String responsibilityTypeId, String terminationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());

			synchronized(responsibilityType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeListWithTermination(responsibilityType, terminationId, this.emptyOptions());

				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				return responsibilityType;
			}
	}






	protected void checkParamsForAddingEmployee(YoubenbenUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);

		
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
		
		checkerOf(userContext).checkCurrentSalaryGradeIdOfEmployee(currentSalaryGradeId);
		
		checkerOf(userContext).checkSalaryAccountOfEmployee(salaryAccount);
		
		checkerOf(userContext).checkJobApplicationIdOfEmployee(jobApplicationId);
		
		checkerOf(userContext).checkProfessionInterviewIdOfEmployee(professionInterviewId);
		
		checkerOf(userContext).checkHrInterviewIdOfEmployee(hrInterviewId);
		
		checkerOf(userContext).checkOfferApprovalIdOfEmployee(offerApprovalId);
		
		checkerOf(userContext).checkOfferAcceptanceIdOfEmployee(offerAcceptanceId);
		
		checkerOf(userContext).checkEmployeeBoardingIdOfEmployee(employeeBoardingId);
		
		checkerOf(userContext).checkTerminationIdOfEmployee(terminationId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);


	}
	public  ResponsibilityType addEmployee(YoubenbenUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,responsibilityTypeId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId);

		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, emptyOptions());
		synchronized(responsibilityType){
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			responsibilityType.addEmployee( employee );
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(YoubenbenUserContext userContext, String responsibilityTypeId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);

	}
	public  ResponsibilityType updateEmployeeProperties(YoubenbenUserContext userContext, String responsibilityTypeId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,responsibilityTypeId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		ResponsibilityType responsibilityTypeToUpdate = loadResponsibilityType(userContext, responsibilityTypeId, options);

		if(responsibilityTypeToUpdate.getEmployeeList().isEmpty()){
			throw new ResponsibilityTypeManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = responsibilityTypeToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,responsibilityTypeId,name, code, used,tokensExpr);
		ResponsibilityType responsibilityType = saveResponsibilityType(userContext, responsibilityTypeToUpdate, tokens().withEmployeeList().done());
		synchronized(responsibilityType){
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(YoubenbenUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId) throws Exception{

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

	protected void checkParamsForRemovingEmployeeList(YoubenbenUserContext userContext, String responsibilityTypeId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);

	}
	public  ResponsibilityType removeEmployeeList(YoubenbenUserContext userContext, String responsibilityTypeId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, responsibilityTypeId,  employeeIds, tokensExpr);


			ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
			synchronized(responsibilityType){
				//Will be good when the responsibilityType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				responsibilityTypeDaoOf(userContext).planToRemoveEmployeeList(responsibilityType, employeeIds, allTokens());
				responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, responsibilityType.getEmployeeList());
				return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(YoubenbenUserContext userContext, String responsibilityTypeId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfResponsibilityType( responsibilityTypeId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);

	}
	public  ResponsibilityType removeEmployee(YoubenbenUserContext userContext, String responsibilityTypeId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,responsibilityTypeId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		synchronized(responsibilityType){
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			responsibilityType.removeEmployee( employee );
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(YoubenbenUserContext userContext, String responsibilityTypeId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfResponsibilityType( responsibilityTypeId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);

	}
	public  ResponsibilityType copyEmployeeFrom(YoubenbenUserContext userContext, String responsibilityTypeId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,responsibilityTypeId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, allTokens());
		synchronized(responsibilityType){
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			responsibilityType.copyEmployeeFrom( employee );
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)responsibilityType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(YoubenbenUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ResponsibilityTypeManagerException.class);

	}

	public  ResponsibilityType updateEmployee(YoubenbenUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, responsibilityTypeId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		ResponsibilityType responsibilityType = loadResponsibilityType(userContext, responsibilityTypeId, loadTokens);

		synchronized(responsibilityType){
			//Will be good when the responsibilityType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//responsibilityType.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = responsibilityType.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new ResponsibilityTypeManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			responsibilityType = saveResponsibilityType(userContext, responsibilityType, tokens().withEmployeeList().done());
			return present(userContext,responsibilityType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, ResponsibilityType newCreated) throws Exception{
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
		//   ResponsibilityType newResponsibilityType = this.createResponsibilityType(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newResponsibilityType
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ResponsibilityType.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<ResponsibilityType> list) throws Exception {
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
		SmartList<ResponsibilityType> list = responsibilityTypeDaoOf(userContext).findResponsibilityTypeByCompany(companyId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(ResponsibilityType.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("责任类型列表");
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
 	public Object wxappview(YoubenbenUserContext userContext, String responsibilityTypeId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getResponsibilityTypeDetailScope().clone();
		ResponsibilityType merchantObj = (ResponsibilityType) this.view(userContext, responsibilityTypeId);
    String merchantObjId = responsibilityTypeId;
    String linkToUrl =	"responsibilityTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "责任类型"+"详情";
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
				MapUtil.put("id", "4-baseDescription")
				    .put("fieldName", "baseDescription")
				    .put("label", "基本描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("baseDescription", merchantObj.getBaseDescription());

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
		    "employeeManager/listByResponsibleFor/"+merchantObjId+"/",
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


