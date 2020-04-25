
package com.xingyou.xingyou.citycenterdepartment;

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

import com.xingyou.xingyou.*;
import com.xingyou.xingyou.tree.*;
import com.xingyou.xingyou.treenode.*;
import com.xingyou.xingyou.XingyouUserContextImpl;
import com.xingyou.xingyou.iamservice.*;
import com.xingyou.xingyou.services.IamService;
import com.xingyou.xingyou.secuser.SecUser;
import com.xingyou.xingyou.userapp.UserApp;
import com.xingyou.xingyou.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.xingyou.xingyou.citycenteremployee.CityCenterEmployee;

import com.xingyou.xingyou.franchisedoutletcitycenter.CandidateFranchisedOutletCityCenter;

import com.xingyou.xingyou.citycenterdepartment.CityCenterDepartment;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenter;






public class CityCenterDepartmentManagerImpl extends CustomXingyouCheckerManager implements CityCenterDepartmentManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(XingyouUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = CityCenterDepartmentTokens.start().withTokenFromListName(listName).done();
		CityCenterDepartment  cityCenterDepartment = (CityCenterDepartment) this.loadCityCenterDepartment(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = cityCenterDepartment.collectRefercencesFromLists();
		cityCenterDepartmentDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, cityCenterDepartment, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new CityCenterDepartmentGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "CityCenterDepartment";
	@Override
	public CityCenterDepartmentDAO daoOf(XingyouUserContext userContext) {
		return cityCenterDepartmentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws CityCenterDepartmentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new CityCenterDepartmentManagerException(message);

	}



 	protected CityCenterDepartment saveCityCenterDepartment(XingyouUserContext userContext, CityCenterDepartment cityCenterDepartment, String [] tokensExpr) throws Exception{	
 		//return getCityCenterDepartmentDAO().save(cityCenterDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCityCenterDepartment(userContext, cityCenterDepartment, tokens);
 	}
 	
 	protected CityCenterDepartment saveCityCenterDepartmentDetail(XingyouUserContext userContext, CityCenterDepartment cityCenterDepartment) throws Exception{	

 		
 		return saveCityCenterDepartment(userContext, cityCenterDepartment, allTokens());
 	}
 	
 	public CityCenterDepartment loadCityCenterDepartment(XingyouUserContext userContext, String cityCenterDepartmentId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityCenterDepartmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment( userContext, cityCenterDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityCenterDepartment, tokens);
 	}
 	
 	
 	 public CityCenterDepartment searchCityCenterDepartment(XingyouUserContext userContext, String cityCenterDepartmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityCenterDepartmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment( userContext, cityCenterDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityCenterDepartment, tokens);
 	}
 	
 	

 	protected CityCenterDepartment present(XingyouUserContext userContext, CityCenterDepartment cityCenterDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,cityCenterDepartment,tokens);
		
		
		CityCenterDepartment  cityCenterDepartmentToPresent = cityCenterDepartmentDaoOf(userContext).present(cityCenterDepartment, tokens);
		
		List<BaseEntity> entityListToNaming = cityCenterDepartmentToPresent.collectRefercencesFromLists();
		cityCenterDepartmentDaoOf(userContext).alias(entityListToNaming);
		
		return  cityCenterDepartmentToPresent;
		
		
	}
 
 	
 	
 	public CityCenterDepartment loadCityCenterDepartmentDetail(XingyouUserContext userContext, String cityCenterDepartmentId) throws Exception{	
 		CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment( userContext, cityCenterDepartmentId, allTokens());
 		return present(userContext,cityCenterDepartment, allTokens());
		
 	}
 	
 	public Object view(XingyouUserContext userContext, String cityCenterDepartmentId) throws Exception{	
 		CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment( userContext, cityCenterDepartmentId, viewTokens());
 		return present(userContext,cityCenterDepartment, allTokens());
		
 	}
 	protected CityCenterDepartment saveCityCenterDepartment(XingyouUserContext userContext, CityCenterDepartment cityCenterDepartment, Map<String,Object>tokens) throws Exception{	
 		return cityCenterDepartmentDaoOf(userContext).save(cityCenterDepartment, tokens);
 	}
 	protected CityCenterDepartment loadCityCenterDepartment(XingyouUserContext userContext, String cityCenterDepartmentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityCenterDepartmentManagerException.class);

 
 		return cityCenterDepartmentDaoOf(userContext).load(cityCenterDepartmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(XingyouUserContext userContext, CityCenterDepartment cityCenterDepartment, Map<String, Object> tokens){
		super.addActions(userContext, cityCenterDepartment, tokens);
		
		addAction(userContext, cityCenterDepartment, tokens,"@create","createCityCenterDepartment","createCityCenterDepartment/","main","primary");
		addAction(userContext, cityCenterDepartment, tokens,"@update","updateCityCenterDepartment","updateCityCenterDepartment/"+cityCenterDepartment.getId()+"/","main","primary");
		addAction(userContext, cityCenterDepartment, tokens,"@copy","cloneCityCenterDepartment","cloneCityCenterDepartment/"+cityCenterDepartment.getId()+"/","main","primary");
		
		addAction(userContext, cityCenterDepartment, tokens,"city_center_department.transfer_to_city_center","transferToAnotherCityCenter","transferToAnotherCityCenter/"+cityCenterDepartment.getId()+"/","main","primary");
		addAction(userContext, cityCenterDepartment, tokens,"city_center_department.addCityCenterEmployee","addCityCenterEmployee","addCityCenterEmployee/"+cityCenterDepartment.getId()+"/","cityCenterEmployeeList","primary");
		addAction(userContext, cityCenterDepartment, tokens,"city_center_department.removeCityCenterEmployee","removeCityCenterEmployee","removeCityCenterEmployee/"+cityCenterDepartment.getId()+"/","cityCenterEmployeeList","primary");
		addAction(userContext, cityCenterDepartment, tokens,"city_center_department.updateCityCenterEmployee","updateCityCenterEmployee","updateCityCenterEmployee/"+cityCenterDepartment.getId()+"/","cityCenterEmployeeList","primary");
		addAction(userContext, cityCenterDepartment, tokens,"city_center_department.copyCityCenterEmployeeFrom","copyCityCenterEmployeeFrom","copyCityCenterEmployeeFrom/"+cityCenterDepartment.getId()+"/","cityCenterEmployeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(XingyouUserContext userContext, CityCenterDepartment cityCenterDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public CityCenterDepartment createCityCenterDepartment(XingyouUserContext userContext, String name,Date founded,String cityCenterId,String manager) throws Exception
	//public CityCenterDepartment createCityCenterDepartment(XingyouUserContext userContext,String name, Date founded, String cityCenterId, String manager) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfCityCenterDepartment(name);
		checkerOf(userContext).checkFoundedOfCityCenterDepartment(founded);
		checkerOf(userContext).checkManagerOfCityCenterDepartment(manager);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterDepartmentManagerException.class);


		CityCenterDepartment cityCenterDepartment=createNewCityCenterDepartment();	

		cityCenterDepartment.setName(name);
		cityCenterDepartment.setFounded(founded);
			
		FranchisedOutletCityCenter cityCenter = loadFranchisedOutletCityCenter(userContext, cityCenterId,emptyOptions());
		cityCenterDepartment.setCityCenter(cityCenter);
		
		
		cityCenterDepartment.setManager(manager);

		cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartment, emptyOptions());
		
		onNewInstanceCreated(userContext, cityCenterDepartment);
		return cityCenterDepartment;


	}
	protected CityCenterDepartment createNewCityCenterDepartment()
	{

		return new CityCenterDepartment();
	}

	protected void checkParamsForUpdatingCityCenterDepartment(XingyouUserContext userContext,String cityCenterDepartmentId, int cityCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);
		checkerOf(userContext).checkVersionOfCityCenterDepartment( cityCenterDepartmentVersion);
		

		if(CityCenterDepartment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCityCenterDepartment(parseString(newValueExpr));
		
			
		}
		if(CityCenterDepartment.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfCityCenterDepartment(parseDate(newValueExpr));
		
			
		}		

		
		if(CityCenterDepartment.MANAGER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkManagerOfCityCenterDepartment(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterDepartmentManagerException.class);


	}



	public CityCenterDepartment clone(XingyouUserContext userContext, String fromCityCenterDepartmentId) throws Exception{

		return cityCenterDepartmentDaoOf(userContext).clone(fromCityCenterDepartmentId, this.allTokens());
	}

	public CityCenterDepartment internalSaveCityCenterDepartment(XingyouUserContext userContext, CityCenterDepartment cityCenterDepartment) throws Exception
	{
		return internalSaveCityCenterDepartment(userContext, cityCenterDepartment, allTokens());

	}
	public CityCenterDepartment internalSaveCityCenterDepartment(XingyouUserContext userContext, CityCenterDepartment cityCenterDepartment, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingCityCenterDepartment(userContext, cityCenterDepartmentId, cityCenterDepartmentVersion, property, newValueExpr, tokensExpr);


		synchronized(cityCenterDepartment){
			//will be good when the cityCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityCenterDepartment.
			if (cityCenterDepartment.isChanged()){
			
			}
			cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartment, options);
			return cityCenterDepartment;

		}

	}

	public CityCenterDepartment updateCityCenterDepartment(XingyouUserContext userContext,String cityCenterDepartmentId, int cityCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityCenterDepartment(userContext, cityCenterDepartmentId, cityCenterDepartmentVersion, property, newValueExpr, tokensExpr);



		CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment(userContext, cityCenterDepartmentId, allTokens());
		if(cityCenterDepartment.getVersion() != cityCenterDepartmentVersion){
			String message = "The target version("+cityCenterDepartment.getVersion()+") is not equals to version("+cityCenterDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(cityCenterDepartment){
			//will be good when the cityCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityCenterDepartment.
			
			cityCenterDepartment.changeProperty(property, newValueExpr);
			cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartment, tokens().done());
			return present(userContext,cityCenterDepartment, mergedAllTokens(tokensExpr));
			//return saveCityCenterDepartment(userContext, cityCenterDepartment, tokens().done());
		}

	}

	public CityCenterDepartment updateCityCenterDepartmentProperty(XingyouUserContext userContext,String cityCenterDepartmentId, int cityCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityCenterDepartment(userContext, cityCenterDepartmentId, cityCenterDepartmentVersion, property, newValueExpr, tokensExpr);

		CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment(userContext, cityCenterDepartmentId, allTokens());
		if(cityCenterDepartment.getVersion() != cityCenterDepartmentVersion){
			String message = "The target version("+cityCenterDepartment.getVersion()+") is not equals to version("+cityCenterDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(cityCenterDepartment){
			//will be good when the cityCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityCenterDepartment.

			cityCenterDepartment.changeProperty(property, newValueExpr);
			
			cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartment, tokens().done());
			return present(userContext,cityCenterDepartment, mergedAllTokens(tokensExpr));
			//return saveCityCenterDepartment(userContext, cityCenterDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected CityCenterDepartmentTokens tokens(){
		return CityCenterDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CityCenterDepartmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCityCenterEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CityCenterDepartmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCityCenter(XingyouUserContext userContext, String cityCenterDepartmentId, String anotherCityCenterId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);
 		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(anotherCityCenterId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterDepartmentManagerException.class);

 	}
 	public CityCenterDepartment transferToAnotherCityCenter(XingyouUserContext userContext, String cityCenterDepartmentId, String anotherCityCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityCenter(userContext, cityCenterDepartmentId,anotherCityCenterId);
 
		CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment(userContext, cityCenterDepartmentId, allTokens());	
		synchronized(cityCenterDepartment){
			//will be good when the cityCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			FranchisedOutletCityCenter cityCenter = loadFranchisedOutletCityCenter(userContext, anotherCityCenterId, emptyOptions());		
			cityCenterDepartment.updateCityCenter(cityCenter);		
			cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartment, emptyOptions());
			
			return present(userContext,cityCenterDepartment, allTokens());
			
		}

 	}

	


	public CandidateFranchisedOutletCityCenter requestCandidateCityCenter(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateFranchisedOutletCityCenter result = new CandidateFranchisedOutletCityCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<FranchisedOutletCityCenter> candidateList = franchisedOutletCityCenterDaoOf(userContext).requestCandidateFranchisedOutletCityCenterForCityCenterDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected FranchisedOutletCityCenter loadFranchisedOutletCityCenter(XingyouUserContext userContext, String newCityCenterId, Map<String,Object> options) throws Exception
 	{

 		return franchisedOutletCityCenterDaoOf(userContext).load(newCityCenterId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(XingyouUserContext userContext, String cityCenterDepartmentId, int cityCenterDepartmentVersion) throws Exception {
		//deleteInternal(userContext, cityCenterDepartmentId, cityCenterDepartmentVersion);
	}
	protected void deleteInternal(XingyouUserContext userContext,
			String cityCenterDepartmentId, int cityCenterDepartmentVersion) throws Exception{

		cityCenterDepartmentDaoOf(userContext).delete(cityCenterDepartmentId, cityCenterDepartmentVersion);
	}

	public CityCenterDepartment forgetByAll(XingyouUserContext userContext, String cityCenterDepartmentId, int cityCenterDepartmentVersion) throws Exception {
		return forgetByAllInternal(userContext, cityCenterDepartmentId, cityCenterDepartmentVersion);
	}
	protected CityCenterDepartment forgetByAllInternal(XingyouUserContext userContext,
			String cityCenterDepartmentId, int cityCenterDepartmentVersion) throws Exception{

		return cityCenterDepartmentDaoOf(userContext).disconnectFromAll(cityCenterDepartmentId, cityCenterDepartmentVersion);
	}




	public int deleteAll(XingyouUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CityCenterDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(XingyouUserContext userContext) throws Exception{
		return cityCenterDepartmentDaoOf(userContext).deleteAll();
	}


	//disconnect CityCenterDepartment with city_center in CityCenterEmployee
	protected CityCenterDepartment breakWithCityCenterEmployeeByCityCenter(XingyouUserContext userContext, String cityCenterDepartmentId, String cityCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment(userContext, cityCenterDepartmentId, allTokens());

			synchronized(cityCenterDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				cityCenterDepartmentDaoOf(userContext).planToRemoveCityCenterEmployeeListWithCityCenter(cityCenterDepartment, cityCenterId, this.emptyOptions());

				cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartment, tokens().withCityCenterEmployeeList().done());
				return cityCenterDepartment;
			}
	}






	protected void checkParamsForAddingCityCenterEmployee(XingyouUserContext userContext, String cityCenterDepartmentId, String name, String mobile, String email, Date founded, String cityCenterId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);

		
		checkerOf(userContext).checkNameOfCityCenterEmployee(name);
		
		checkerOf(userContext).checkMobileOfCityCenterEmployee(mobile);
		
		checkerOf(userContext).checkEmailOfCityCenterEmployee(email);
		
		checkerOf(userContext).checkFoundedOfCityCenterEmployee(founded);
		
		checkerOf(userContext).checkCityCenterIdOfCityCenterEmployee(cityCenterId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterDepartmentManagerException.class);


	}
	public  CityCenterDepartment addCityCenterEmployee(XingyouUserContext userContext, String cityCenterDepartmentId, String name, String mobile, String email, Date founded, String cityCenterId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCityCenterEmployee(userContext,cityCenterDepartmentId,name, mobile, email, founded, cityCenterId,tokensExpr);

		CityCenterEmployee cityCenterEmployee = createCityCenterEmployee(userContext,name, mobile, email, founded, cityCenterId);

		CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment(userContext, cityCenterDepartmentId, emptyOptions());
		synchronized(cityCenterDepartment){
			//Will be good when the cityCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityCenterDepartment.addCityCenterEmployee( cityCenterEmployee );
			cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartment, tokens().withCityCenterEmployeeList().done());
			
			userContext.getManagerGroup().getCityCenterEmployeeManager().onNewInstanceCreated(userContext, cityCenterEmployee);
			return present(userContext,cityCenterDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCityCenterEmployeeProperties(XingyouUserContext userContext, String cityCenterDepartmentId,String id,String name,String mobile,String email,Date founded,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);
		checkerOf(userContext).checkIdOfCityCenterEmployee(id);

		checkerOf(userContext).checkNameOfCityCenterEmployee( name);
		checkerOf(userContext).checkMobileOfCityCenterEmployee( mobile);
		checkerOf(userContext).checkEmailOfCityCenterEmployee( email);
		checkerOf(userContext).checkFoundedOfCityCenterEmployee( founded);

		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterDepartmentManagerException.class);

	}
	public  CityCenterDepartment updateCityCenterEmployeeProperties(XingyouUserContext userContext, String cityCenterDepartmentId, String id,String name,String mobile,String email,Date founded, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityCenterEmployeeProperties(userContext,cityCenterDepartmentId,id,name,mobile,email,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCityCenterEmployeeListList()
				.searchCityCenterEmployeeListWith(CityCenterEmployee.ID_PROPERTY, "is", id).done();

		CityCenterDepartment cityCenterDepartmentToUpdate = loadCityCenterDepartment(userContext, cityCenterDepartmentId, options);

		if(cityCenterDepartmentToUpdate.getCityCenterEmployeeList().isEmpty()){
			throw new CityCenterDepartmentManagerException("CityCenterEmployee is NOT FOUND with id: '"+id+"'");
		}

		CityCenterEmployee item = cityCenterDepartmentToUpdate.getCityCenterEmployeeList().first();

		item.updateName( name );
		item.updateMobile( mobile );
		item.updateEmail( email );
		item.updateFounded( founded );


		//checkParamsForAddingCityCenterEmployee(userContext,cityCenterDepartmentId,name, code, used,tokensExpr);
		CityCenterDepartment cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartmentToUpdate, tokens().withCityCenterEmployeeList().done());
		synchronized(cityCenterDepartment){
			return present(userContext,cityCenterDepartment, mergedAllTokens(tokensExpr));
		}
	}


	protected CityCenterEmployee createCityCenterEmployee(XingyouUserContext userContext, String name, String mobile, String email, Date founded, String cityCenterId) throws Exception{

		CityCenterEmployee cityCenterEmployee = new CityCenterEmployee();
		
		
		cityCenterEmployee.setName(name);		
		cityCenterEmployee.setMobile(mobile);		
		cityCenterEmployee.setEmail(email);		
		cityCenterEmployee.setFounded(founded);		
		FranchisedOutletCityCenter  cityCenter = new FranchisedOutletCityCenter();
		cityCenter.setId(cityCenterId);		
		cityCenterEmployee.setCityCenter(cityCenter);
	
		
		return cityCenterEmployee;


	}

	protected CityCenterEmployee createIndexedCityCenterEmployee(String id, int version){

		CityCenterEmployee cityCenterEmployee = new CityCenterEmployee();
		cityCenterEmployee.setId(id);
		cityCenterEmployee.setVersion(version);
		return cityCenterEmployee;

	}

	protected void checkParamsForRemovingCityCenterEmployeeList(XingyouUserContext userContext, String cityCenterDepartmentId,
			String cityCenterEmployeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);
		for(String cityCenterEmployeeIdItem: cityCenterEmployeeIds){
			checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterDepartmentManagerException.class);

	}
	public  CityCenterDepartment removeCityCenterEmployeeList(XingyouUserContext userContext, String cityCenterDepartmentId,
			String cityCenterEmployeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCityCenterEmployeeList(userContext, cityCenterDepartmentId,  cityCenterEmployeeIds, tokensExpr);


			CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment(userContext, cityCenterDepartmentId, allTokens());
			synchronized(cityCenterDepartment){
				//Will be good when the cityCenterDepartment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				cityCenterDepartmentDaoOf(userContext).planToRemoveCityCenterEmployeeList(cityCenterDepartment, cityCenterEmployeeIds, allTokens());
				cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartment, tokens().withCityCenterEmployeeList().done());
				deleteRelationListInGraph(userContext, cityCenterDepartment.getCityCenterEmployeeList());
				return present(userContext,cityCenterDepartment, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCityCenterEmployee(XingyouUserContext userContext, String cityCenterDepartmentId,
		String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCityCenterDepartment( cityCenterDepartmentId);
		checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeId);
		checkerOf(userContext).checkVersionOfCityCenterEmployee(cityCenterEmployeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterDepartmentManagerException.class);

	}
	public  CityCenterDepartment removeCityCenterEmployee(XingyouUserContext userContext, String cityCenterDepartmentId,
		String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingCityCenterEmployee(userContext,cityCenterDepartmentId, cityCenterEmployeeId, cityCenterEmployeeVersion,tokensExpr);

		CityCenterEmployee cityCenterEmployee = createIndexedCityCenterEmployee(cityCenterEmployeeId, cityCenterEmployeeVersion);
		CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment(userContext, cityCenterDepartmentId, allTokens());
		synchronized(cityCenterDepartment){
			//Will be good when the cityCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityCenterDepartment.removeCityCenterEmployee( cityCenterEmployee );
			cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartment, tokens().withCityCenterEmployeeList().done());
			deleteRelationInGraph(userContext, cityCenterEmployee);
			return present(userContext,cityCenterDepartment, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingCityCenterEmployee(XingyouUserContext userContext, String cityCenterDepartmentId,
		String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCityCenterDepartment( cityCenterDepartmentId);
		checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeId);
		checkerOf(userContext).checkVersionOfCityCenterEmployee(cityCenterEmployeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterDepartmentManagerException.class);

	}
	public  CityCenterDepartment copyCityCenterEmployeeFrom(XingyouUserContext userContext, String cityCenterDepartmentId,
		String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingCityCenterEmployee(userContext,cityCenterDepartmentId, cityCenterEmployeeId, cityCenterEmployeeVersion,tokensExpr);

		CityCenterEmployee cityCenterEmployee = createIndexedCityCenterEmployee(cityCenterEmployeeId, cityCenterEmployeeVersion);
		CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment(userContext, cityCenterDepartmentId, allTokens());
		synchronized(cityCenterDepartment){
			//Will be good when the cityCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			cityCenterDepartment.copyCityCenterEmployeeFrom( cityCenterEmployee );
			cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartment, tokens().withCityCenterEmployeeList().done());
			
			userContext.getManagerGroup().getCityCenterEmployeeManager().onNewInstanceCreated(userContext, (CityCenterEmployee)cityCenterDepartment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,cityCenterDepartment, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCityCenterEmployee(XingyouUserContext userContext, String cityCenterDepartmentId, String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);
		checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeId);
		checkerOf(userContext).checkVersionOfCityCenterEmployee(cityCenterEmployeeVersion);
		

		if(CityCenterEmployee.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCityCenterEmployee(parseString(newValueExpr));
		
		}
		
		if(CityCenterEmployee.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfCityCenterEmployee(parseString(newValueExpr));
		
		}
		
		if(CityCenterEmployee.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfCityCenterEmployee(parseString(newValueExpr));
		
		}
		
		if(CityCenterEmployee.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfCityCenterEmployee(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterDepartmentManagerException.class);

	}

	public  CityCenterDepartment updateCityCenterEmployee(XingyouUserContext userContext, String cityCenterDepartmentId, String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCityCenterEmployee(userContext, cityCenterDepartmentId, cityCenterEmployeeId, cityCenterEmployeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCityCenterEmployeeList().searchCityCenterEmployeeListWith(CityCenterEmployee.ID_PROPERTY, "eq", cityCenterEmployeeId).done();



		CityCenterDepartment cityCenterDepartment = loadCityCenterDepartment(userContext, cityCenterDepartmentId, loadTokens);

		synchronized(cityCenterDepartment){
			//Will be good when the cityCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//cityCenterDepartment.removeCityCenterEmployee( cityCenterEmployee );
			//make changes to AcceleraterAccount.
			CityCenterEmployee cityCenterEmployeeIndex = createIndexedCityCenterEmployee(cityCenterEmployeeId, cityCenterEmployeeVersion);

			CityCenterEmployee cityCenterEmployee = cityCenterDepartment.findTheCityCenterEmployee(cityCenterEmployeeIndex);
			if(cityCenterEmployee == null){
				throw new CityCenterDepartmentManagerException(cityCenterEmployee+" is NOT FOUND" );
			}

			cityCenterEmployee.changeProperty(property, newValueExpr);
			
			cityCenterDepartment = saveCityCenterDepartment(userContext, cityCenterDepartment, tokens().withCityCenterEmployeeList().done());
			return present(userContext,cityCenterDepartment, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(XingyouUserContext userContext, CityCenterDepartment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(XingyouUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(XingyouBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(XingyouUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(XingyouBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(XingyouUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(XingyouBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(XingyouUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(XingyouBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(XingyouUserContextImpl userContext, LoginContext loginContext) throws Exception {
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
		XingyouUserContextImpl userContext = (XingyouUserContextImpl)baseUserContext;
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
	protected boolean isMethodNeedLogin(XingyouUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(XingyouUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(XingyouUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(XingyouUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(XingyouUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   CityCenterDepartment newCityCenterDepartment = this.createCityCenterDepartment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newCityCenterDepartment
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(XingyouUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, CityCenterDepartment.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((XingyouBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(XingyouUserContext userContext,SmartList<CityCenterDepartment> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<FranchisedOutletCityCenter> cityCenterList = XingyouBaseUtils.collectReferencedObjectWithType(userContext, list, FranchisedOutletCityCenter.class);
		userContext.getDAOGroup().enhanceList(cityCenterList, FranchisedOutletCityCenter.class);


    }
	
	public Object listByCityCenter(XingyouUserContext userContext,String cityCenterId) throws Exception {
		return listPageByCityCenter(userContext, cityCenterId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCityCenter(XingyouUserContext userContext,String cityCenterId, int start, int count) throws Exception {
		SmartList<CityCenterDepartment> list = cityCenterDepartmentDaoOf(userContext).findCityCenterDepartmentByCityCenter(cityCenterId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		XingyouCommonListOfViewPage page = new XingyouCommonListOfViewPage();
		page.setClassOfList(CityCenterDepartment.class);
		page.setContainerObject(FranchisedOutletCityCenter.withId(cityCenterId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("城市中心部门列表");
		page.setRequestName("listByCityCenter");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCityCenter/%s/",  getBeanName(), cityCenterId)));

		page.assemblerContent(userContext, "listByCityCenter");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(XingyouUserContext userContext, String cityCenterDepartmentId) throws Exception{
	  SerializeScope vscope = XingyouViewScope.getInstance().getCityCenterDepartmentDetailScope().clone();
		CityCenterDepartment merchantObj = (CityCenterDepartment) this.view(userContext, cityCenterDepartmentId);
    String merchantObjId = cityCenterDepartmentId;
    String linkToUrl =	"cityCenterDepartmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "城市中心部门"+"详情";
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
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		propList.add(
				MapUtil.put("id", "4-cityCenter")
				    .put("fieldName", "cityCenter")
				    .put("label", "城市中心")
				    .put("type", "auto")
				    .put("linkToUrl", "franchisedOutletCityCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("cityCenter", merchantObj.getCityCenter());

		propList.add(
				MapUtil.put("id", "5-manager")
				    .put("fieldName", "manager")
				    .put("label", "经理")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("manager", merchantObj.getManager());

		//处理 sectionList

		//处理Section：cityCenterEmployeeListSection
		Map cityCenterEmployeeListSection = ListofUtils.buildSection(
		    "cityCenterEmployeeListSection",
		    "市中心员工名单",
		    null,
		    "",
		    "__no_group",
		    "cityCenterEmployeeManager/listByDepartment/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(cityCenterEmployeeListSection);

		result.put("cityCenterEmployeeListSection", ListofUtils.toShortList(merchantObj.getCityCenterEmployeeList(), "cityCenterEmployee"));
		vscope.field("cityCenterEmployeeListSection", XingyouListOfViewScope.getInstance()
					.getListOfViewScope( CityCenterEmployee.class.getName(), null));

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


