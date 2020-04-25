
package com.youbenben.youbenben.levelthreedepartment;

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


import com.youbenben.youbenben.leveltwodepartment.LevelTwoDepartment;
import com.youbenben.youbenben.employee.Employee;

import com.youbenben.youbenben.leveltwodepartment.CandidateLevelTwoDepartment;

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






public class LevelThreeDepartmentManagerImpl extends CustomYoubenbenCheckerManager implements LevelThreeDepartmentManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = LevelThreeDepartmentTokens.start().withTokenFromListName(listName).done();
		LevelThreeDepartment  levelThreeDepartment = (LevelThreeDepartment) this.loadLevelThreeDepartment(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = levelThreeDepartment.collectRefercencesFromLists();
		levelThreeDepartmentDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, levelThreeDepartment, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new LevelThreeDepartmentGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "LevelThreeDepartment";
	@Override
	public LevelThreeDepartmentDAO daoOf(YoubenbenUserContext userContext) {
		return levelThreeDepartmentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws LevelThreeDepartmentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new LevelThreeDepartmentManagerException(message);

	}



 	protected LevelThreeDepartment saveLevelThreeDepartment(YoubenbenUserContext userContext, LevelThreeDepartment levelThreeDepartment, String [] tokensExpr) throws Exception{	
 		//return getLevelThreeDepartmentDAO().save(levelThreeDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens);
 	}
 	
 	protected LevelThreeDepartment saveLevelThreeDepartmentDetail(YoubenbenUserContext userContext, LevelThreeDepartment levelThreeDepartment) throws Exception{	

 		
 		return saveLevelThreeDepartment(userContext, levelThreeDepartment, allTokens());
 	}
 	
 	public LevelThreeDepartment loadLevelThreeDepartment(YoubenbenUserContext userContext, String levelThreeDepartmentId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelThreeDepartmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeDepartment, tokens);
 	}
 	
 	
 	 public LevelThreeDepartment searchLevelThreeDepartment(YoubenbenUserContext userContext, String levelThreeDepartmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelThreeDepartmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeDepartment, tokens);
 	}
 	
 	

 	protected LevelThreeDepartment present(YoubenbenUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelThreeDepartment,tokens);
		
		
		LevelThreeDepartment  levelThreeDepartmentToPresent = levelThreeDepartmentDaoOf(userContext).present(levelThreeDepartment, tokens);
		
		List<BaseEntity> entityListToNaming = levelThreeDepartmentToPresent.collectRefercencesFromLists();
		levelThreeDepartmentDaoOf(userContext).alias(entityListToNaming);
		
		return  levelThreeDepartmentToPresent;
		
		
	}
 
 	
 	
 	public LevelThreeDepartment loadLevelThreeDepartmentDetail(YoubenbenUserContext userContext, String levelThreeDepartmentId) throws Exception{	
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, allTokens());
 		return present(userContext,levelThreeDepartment, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String levelThreeDepartmentId) throws Exception{	
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, viewTokens());
 		return present(userContext,levelThreeDepartment, allTokens());
		
 	}
 	protected LevelThreeDepartment saveLevelThreeDepartment(YoubenbenUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String,Object>tokens) throws Exception{	
 		return levelThreeDepartmentDaoOf(userContext).save(levelThreeDepartment, tokens);
 	}
 	protected LevelThreeDepartment loadLevelThreeDepartment(YoubenbenUserContext userContext, String levelThreeDepartmentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelThreeDepartmentManagerException.class);

 
 		return levelThreeDepartmentDaoOf(userContext).load(levelThreeDepartmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens){
		super.addActions(userContext, levelThreeDepartment, tokens);
		
		addAction(userContext, levelThreeDepartment, tokens,"@create","createLevelThreeDepartment","createLevelThreeDepartment/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"@update","updateLevelThreeDepartment","updateLevelThreeDepartment/"+levelThreeDepartment.getId()+"/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"@copy","cloneLevelThreeDepartment","cloneLevelThreeDepartment/"+levelThreeDepartment.getId()+"/","main","primary");
		
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+levelThreeDepartment.getId()+"/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.addEmployee","addEmployee","addEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.removeEmployee","removeEmployee","removeEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.updateEmployee","updateEmployee","updateEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+levelThreeDepartment.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public LevelThreeDepartment createLevelThreeDepartment(YoubenbenUserContext userContext, String belongsToId,String name,String description,Date founded) throws Exception
	//public LevelThreeDepartment createLevelThreeDepartment(YoubenbenUserContext userContext,String belongsToId, String name, String description, Date founded) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfLevelThreeDepartment(name);
		checkerOf(userContext).checkDescriptionOfLevelThreeDepartment(description);
		checkerOf(userContext).checkFoundedOfLevelThreeDepartment(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);


		LevelThreeDepartment levelThreeDepartment=createNewLevelThreeDepartment();	

			
		LevelTwoDepartment belongsTo = loadLevelTwoDepartment(userContext, belongsToId,emptyOptions());
		levelThreeDepartment.setBelongsTo(belongsTo);
		
		
		levelThreeDepartment.setName(name);
		levelThreeDepartment.setDescription(description);
		levelThreeDepartment.setFounded(founded);

		levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, emptyOptions());
		
		onNewInstanceCreated(userContext, levelThreeDepartment);
		return levelThreeDepartment;


	}
	protected LevelThreeDepartment createNewLevelThreeDepartment()
	{

		return new LevelThreeDepartment();
	}

	protected void checkParamsForUpdatingLevelThreeDepartment(YoubenbenUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).checkVersionOfLevelThreeDepartment( levelThreeDepartmentVersion);
		
		

		
		if(LevelThreeDepartment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfLevelThreeDepartment(parseString(newValueExpr));
		
			
		}
		if(LevelThreeDepartment.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfLevelThreeDepartment(parseString(newValueExpr));
		
			
		}
		if(LevelThreeDepartment.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfLevelThreeDepartment(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);


	}



	public LevelThreeDepartment clone(YoubenbenUserContext userContext, String fromLevelThreeDepartmentId) throws Exception{

		return levelThreeDepartmentDaoOf(userContext).clone(fromLevelThreeDepartmentId, this.allTokens());
	}

	public LevelThreeDepartment internalSaveLevelThreeDepartment(YoubenbenUserContext userContext, LevelThreeDepartment levelThreeDepartment) throws Exception
	{
		return internalSaveLevelThreeDepartment(userContext, levelThreeDepartment, allTokens());

	}
	public LevelThreeDepartment internalSaveLevelThreeDepartment(YoubenbenUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingLevelThreeDepartment(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr, tokensExpr);


		synchronized(levelThreeDepartment){
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeDepartment.
			if (levelThreeDepartment.isChanged()){
			
			}
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, options);
			return levelThreeDepartment;

		}

	}

	public LevelThreeDepartment updateLevelThreeDepartment(YoubenbenUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelThreeDepartment(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr, tokensExpr);



		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		if(levelThreeDepartment.getVersion() != levelThreeDepartmentVersion){
			String message = "The target version("+levelThreeDepartment.getVersion()+") is not equals to version("+levelThreeDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelThreeDepartment){
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeDepartment.
			
			levelThreeDepartment.changeProperty(property, newValueExpr);
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
		}

	}

	public LevelThreeDepartment updateLevelThreeDepartmentProperty(YoubenbenUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelThreeDepartment(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr, tokensExpr);

		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		if(levelThreeDepartment.getVersion() != levelThreeDepartmentVersion){
			String message = "The target version("+levelThreeDepartment.getVersion()+") is not equals to version("+levelThreeDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelThreeDepartment){
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeDepartment.

			levelThreeDepartment.changeProperty(property, newValueExpr);
			
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected LevelThreeDepartmentTokens tokens(){
		return LevelThreeDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelThreeDepartmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelThreeDepartmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(YoubenbenUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
 		checkerOf(userContext).checkIdOfLevelTwoDepartment(anotherBelongsToId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

 	}
 	public LevelThreeDepartment transferToAnotherBelongsTo(YoubenbenUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, levelThreeDepartmentId,anotherBelongsToId);
 
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());	
		synchronized(levelThreeDepartment){
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelTwoDepartment belongsTo = loadLevelTwoDepartment(userContext, anotherBelongsToId, emptyOptions());		
			levelThreeDepartment.updateBelongsTo(belongsTo);		
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, emptyOptions());
			
			return present(userContext,levelThreeDepartment, allTokens());
			
		}

 	}

	


	public CandidateLevelTwoDepartment requestCandidateBelongsTo(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelTwoDepartment result = new CandidateLevelTwoDepartment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("belongsTo");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelTwoDepartment> candidateList = levelTwoDepartmentDaoOf(userContext).requestCandidateLevelTwoDepartmentForLevelThreeDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected LevelTwoDepartment loadLevelTwoDepartment(YoubenbenUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{

 		return levelTwoDepartmentDaoOf(userContext).load(newBelongsToId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception {
		//deleteInternal(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception{

		levelThreeDepartmentDaoOf(userContext).delete(levelThreeDepartmentId, levelThreeDepartmentVersion);
	}

	public LevelThreeDepartment forgetByAll(YoubenbenUserContext userContext, String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception {
		return forgetByAllInternal(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion);
	}
	protected LevelThreeDepartment forgetByAllInternal(YoubenbenUserContext userContext,
			String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception{

		return levelThreeDepartmentDaoOf(userContext).disconnectFromAll(levelThreeDepartmentId, levelThreeDepartmentVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelThreeDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return levelThreeDepartmentDaoOf(userContext).deleteAll();
	}


	//disconnect LevelThreeDepartment with company in Employee
	protected LevelThreeDepartment breakWithEmployeeByCompany(YoubenbenUserContext userContext, String levelThreeDepartmentId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithCompany(levelThreeDepartment, companyId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with occupation in Employee
	protected LevelThreeDepartment breakWithEmployeeByOccupation(YoubenbenUserContext userContext, String levelThreeDepartmentId, String occupationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithOccupation(levelThreeDepartment, occupationId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with responsible_for in Employee
	protected LevelThreeDepartment breakWithEmployeeByResponsibleFor(YoubenbenUserContext userContext, String levelThreeDepartmentId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithResponsibleFor(levelThreeDepartment, responsibleForId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with current_salary_grade in Employee
	protected LevelThreeDepartment breakWithEmployeeByCurrentSalaryGrade(YoubenbenUserContext userContext, String levelThreeDepartmentId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(levelThreeDepartment, currentSalaryGradeId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with job_application in Employee
	protected LevelThreeDepartment breakWithEmployeeByJobApplication(YoubenbenUserContext userContext, String levelThreeDepartmentId, String jobApplicationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithJobApplication(levelThreeDepartment, jobApplicationId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with profession_interview in Employee
	protected LevelThreeDepartment breakWithEmployeeByProfessionInterview(YoubenbenUserContext userContext, String levelThreeDepartmentId, String professionInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithProfessionInterview(levelThreeDepartment, professionInterviewId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with hr_interview in Employee
	protected LevelThreeDepartment breakWithEmployeeByHrInterview(YoubenbenUserContext userContext, String levelThreeDepartmentId, String hrInterviewId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithHrInterview(levelThreeDepartment, hrInterviewId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with offer_approval in Employee
	protected LevelThreeDepartment breakWithEmployeeByOfferApproval(YoubenbenUserContext userContext, String levelThreeDepartmentId, String offerApprovalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithOfferApproval(levelThreeDepartment, offerApprovalId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with offer_acceptance in Employee
	protected LevelThreeDepartment breakWithEmployeeByOfferAcceptance(YoubenbenUserContext userContext, String levelThreeDepartmentId, String offerAcceptanceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithOfferAcceptance(levelThreeDepartment, offerAcceptanceId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with employee_boarding in Employee
	protected LevelThreeDepartment breakWithEmployeeByEmployeeBoarding(YoubenbenUserContext userContext, String levelThreeDepartmentId, String employeeBoardingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithEmployeeBoarding(levelThreeDepartment, employeeBoardingId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with termination in Employee
	protected LevelThreeDepartment breakWithEmployeeByTermination(YoubenbenUserContext userContext, String levelThreeDepartmentId, String terminationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithTermination(levelThreeDepartment, terminationId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}






	protected void checkParamsForAddingEmployee(YoubenbenUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);

		
		checkerOf(userContext).checkCompanyIdOfEmployee(companyId);
		
		checkerOf(userContext).checkTitleOfEmployee(title);
		
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
		
		checkerOf(userContext).checkTerminationIdOfEmployee(terminationId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);


	}
	public  LevelThreeDepartment addEmployee(YoubenbenUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,levelThreeDepartmentId,companyId, title, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId);

		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, emptyOptions());
		synchronized(levelThreeDepartment){
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeDepartment.addEmployee( employee );
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(YoubenbenUserContext userContext, String levelThreeDepartmentId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

	}
	public  LevelThreeDepartment updateEmployeeProperties(YoubenbenUserContext userContext, String levelThreeDepartmentId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,levelThreeDepartmentId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		LevelThreeDepartment levelThreeDepartmentToUpdate = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);

		if(levelThreeDepartmentToUpdate.getEmployeeList().isEmpty()){
			throw new LevelThreeDepartmentManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = levelThreeDepartmentToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,levelThreeDepartmentId,name, code, used,tokensExpr);
		LevelThreeDepartment levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartmentToUpdate, tokens().withEmployeeList().done());
		synchronized(levelThreeDepartment){
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(YoubenbenUserContext userContext, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId, String terminationId) throws Exception{

		Employee employee = new Employee();
		
		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		employee.setCompany(company);		
		employee.setTitle(title);		
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

	protected void checkParamsForRemovingEmployeeList(YoubenbenUserContext userContext, String levelThreeDepartmentId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

	}
	public  LevelThreeDepartment removeEmployeeList(YoubenbenUserContext userContext, String levelThreeDepartmentId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, levelThreeDepartmentId,  employeeIds, tokensExpr);


			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
			synchronized(levelThreeDepartment){
				//Will be good when the levelThreeDepartment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeList(levelThreeDepartment, employeeIds, allTokens());
				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, levelThreeDepartment.getEmployeeList());
				return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(YoubenbenUserContext userContext, String levelThreeDepartmentId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelThreeDepartment( levelThreeDepartmentId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

	}
	public  LevelThreeDepartment removeEmployee(YoubenbenUserContext userContext, String levelThreeDepartmentId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,levelThreeDepartmentId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		synchronized(levelThreeDepartment){
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeDepartment.removeEmployee( employee );
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(YoubenbenUserContext userContext, String levelThreeDepartmentId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelThreeDepartment( levelThreeDepartmentId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

	}
	public  LevelThreeDepartment copyEmployeeFrom(YoubenbenUserContext userContext, String levelThreeDepartmentId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,levelThreeDepartmentId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		synchronized(levelThreeDepartment){
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			levelThreeDepartment.copyEmployeeFrom( employee );
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)levelThreeDepartment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(YoubenbenUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

	}

	public  LevelThreeDepartment updateEmployee(YoubenbenUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, levelThreeDepartmentId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, loadTokens);

		synchronized(levelThreeDepartment){
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelThreeDepartment.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = levelThreeDepartment.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new LevelThreeDepartmentManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, LevelThreeDepartment newCreated) throws Exception{
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
		//   LevelThreeDepartment newLevelThreeDepartment = this.createLevelThreeDepartment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newLevelThreeDepartment
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, LevelThreeDepartment.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<LevelThreeDepartment> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<LevelTwoDepartment> belongsToList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, LevelTwoDepartment.class);
		userContext.getDAOGroup().enhanceList(belongsToList, LevelTwoDepartment.class);


    }
	
	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception {
		return listPageByBelongsTo(userContext, belongsToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception {
		SmartList<LevelThreeDepartment> list = levelThreeDepartmentDaoOf(userContext).findLevelThreeDepartmentByBelongsTo(belongsToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(LevelThreeDepartment.class);
		page.setContainerObject(LevelTwoDepartment.withId(belongsToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("三级部门列表");
		page.setRequestName("listByBelongsTo");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBelongsTo/%s/",  getBeanName(), belongsToId)));

		page.assemblerContent(userContext, "listByBelongsTo");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String levelThreeDepartmentId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getLevelThreeDepartmentDetailScope().clone();
		LevelThreeDepartment merchantObj = (LevelThreeDepartment) this.view(userContext, levelThreeDepartmentId);
    String merchantObjId = levelThreeDepartmentId;
    String linkToUrl =	"levelThreeDepartmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "三级部门"+"详情";
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
				MapUtil.put("id", "2-belongsTo")
				    .put("fieldName", "belongsTo")
				    .put("label", "属于")
				    .put("type", "auto")
				    .put("linkToUrl", "levelTwoDepartmentManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("belongsTo", merchantObj.getBelongsTo());

		propList.add(
				MapUtil.put("id", "3-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

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
				MapUtil.put("id", "5-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		//处理 sectionList

		//处理Section：employeeListSection
		Map employeeListSection = ListofUtils.buildSection(
		    "employeeListSection",
		    "员工列表",
		    null,
		    "",
		    "__no_group",
		    "employeeManager/listByDepartment/"+merchantObjId+"/",
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


