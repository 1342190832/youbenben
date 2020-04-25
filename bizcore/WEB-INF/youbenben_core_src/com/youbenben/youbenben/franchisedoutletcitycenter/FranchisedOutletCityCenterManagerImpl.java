
package com.youbenben.youbenben.franchisedoutletcitycenter;

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


import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartment;
import com.youbenben.youbenben.citycenteremployee.CityCenterEmployee;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenter;

import com.youbenben.youbenben.franchisedoutletcitycenter.CandidateFranchisedOutletCityCenter;

import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartment;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;






public class FranchisedOutletCityCenterManagerImpl extends CustomYoubenbenCheckerManager implements FranchisedOutletCityCenterManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = FranchisedOutletCityCenterTokens.start().withTokenFromListName(listName).done();
		FranchisedOutletCityCenter  franchisedOutletCityCenter = (FranchisedOutletCityCenter) this.loadFranchisedOutletCityCenter(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = franchisedOutletCityCenter.collectRefercencesFromLists();
		franchisedOutletCityCenterDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, franchisedOutletCityCenter, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new FranchisedOutletCityCenterGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "FranchisedOutletCityCenter";
	@Override
	public FranchisedOutletCityCenterDAO daoOf(YoubenbenUserContext userContext) {
		return franchisedOutletCityCenterDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws FranchisedOutletCityCenterManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new FranchisedOutletCityCenterManagerException(message);

	}



 	protected FranchisedOutletCityCenter saveFranchisedOutletCityCenter(YoubenbenUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter, String [] tokensExpr) throws Exception{	
 		//return getFranchisedOutletCityCenterDAO().save(franchisedOutletCityCenter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens);
 	}
 	
 	protected FranchisedOutletCityCenter saveFranchisedOutletCityCenterDetail(YoubenbenUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter) throws Exception{	

 		
 		return saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, allTokens());
 	}
 	
 	public FranchisedOutletCityCenter loadFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( FranchisedOutletCityCenterManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter( userContext, franchisedOutletCityCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,franchisedOutletCityCenter, tokens);
 	}
 	
 	
 	 public FranchisedOutletCityCenter searchFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( FranchisedOutletCityCenterManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter( userContext, franchisedOutletCityCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,franchisedOutletCityCenter, tokens);
 	}
 	
 	

 	protected FranchisedOutletCityCenter present(YoubenbenUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,franchisedOutletCityCenter,tokens);
		
		
		FranchisedOutletCityCenter  franchisedOutletCityCenterToPresent = franchisedOutletCityCenterDaoOf(userContext).present(franchisedOutletCityCenter, tokens);
		
		List<BaseEntity> entityListToNaming = franchisedOutletCityCenterToPresent.collectRefercencesFromLists();
		franchisedOutletCityCenterDaoOf(userContext).alias(entityListToNaming);
		
		return  franchisedOutletCityCenterToPresent;
		
		
	}
 
 	
 	
 	public FranchisedOutletCityCenter loadFranchisedOutletCityCenterDetail(YoubenbenUserContext userContext, String franchisedOutletCityCenterId) throws Exception{	
 		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter( userContext, franchisedOutletCityCenterId, allTokens());
 		return present(userContext,franchisedOutletCityCenter, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String franchisedOutletCityCenterId) throws Exception{	
 		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter( userContext, franchisedOutletCityCenterId, viewTokens());
 		return present(userContext,franchisedOutletCityCenter, allTokens());
		
 	}
 	protected FranchisedOutletCityCenter saveFranchisedOutletCityCenter(YoubenbenUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object>tokens) throws Exception{	
 		return franchisedOutletCityCenterDaoOf(userContext).save(franchisedOutletCityCenter, tokens);
 	}
 	protected FranchisedOutletCityCenter loadFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( FranchisedOutletCityCenterManagerException.class);

 
 		return franchisedOutletCityCenterDaoOf(userContext).load(franchisedOutletCityCenterId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String, Object> tokens){
		super.addActions(userContext, franchisedOutletCityCenter, tokens);
		
		addAction(userContext, franchisedOutletCityCenter, tokens,"@create","createFranchisedOutletCityCenter","createFranchisedOutletCityCenter/","main","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"@update","updateFranchisedOutletCityCenter","updateFranchisedOutletCityCenter/"+franchisedOutletCityCenter.getId()+"/","main","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"@copy","cloneFranchisedOutletCityCenter","cloneFranchisedOutletCityCenter/"+franchisedOutletCityCenter.getId()+"/","main","primary");
		
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.transfer_to_city","transferToAnotherCity","transferToAnotherCity/"+franchisedOutletCityCenter.getId()+"/","main","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.addFranchisedOutletCityCenter","addFranchisedOutletCityCenter","addFranchisedOutletCityCenter/"+franchisedOutletCityCenter.getId()+"/","franchisedOutletCityCenterList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.removeFranchisedOutletCityCenter","removeFranchisedOutletCityCenter","removeFranchisedOutletCityCenter/"+franchisedOutletCityCenter.getId()+"/","franchisedOutletCityCenterList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.updateFranchisedOutletCityCenter","updateFranchisedOutletCityCenter","updateFranchisedOutletCityCenter/"+franchisedOutletCityCenter.getId()+"/","franchisedOutletCityCenterList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.copyFranchisedOutletCityCenterFrom","copyFranchisedOutletCityCenterFrom","copyFranchisedOutletCityCenterFrom/"+franchisedOutletCityCenter.getId()+"/","franchisedOutletCityCenterList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.addCityCenterDepartment","addCityCenterDepartment","addCityCenterDepartment/"+franchisedOutletCityCenter.getId()+"/","cityCenterDepartmentList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.removeCityCenterDepartment","removeCityCenterDepartment","removeCityCenterDepartment/"+franchisedOutletCityCenter.getId()+"/","cityCenterDepartmentList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.updateCityCenterDepartment","updateCityCenterDepartment","updateCityCenterDepartment/"+franchisedOutletCityCenter.getId()+"/","cityCenterDepartmentList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.copyCityCenterDepartmentFrom","copyCityCenterDepartmentFrom","copyCityCenterDepartmentFrom/"+franchisedOutletCityCenter.getId()+"/","cityCenterDepartmentList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.addCityCenterEmployee","addCityCenterEmployee","addCityCenterEmployee/"+franchisedOutletCityCenter.getId()+"/","cityCenterEmployeeList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.removeCityCenterEmployee","removeCityCenterEmployee","removeCityCenterEmployee/"+franchisedOutletCityCenter.getId()+"/","cityCenterEmployeeList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.updateCityCenterEmployee","updateCityCenterEmployee","updateCityCenterEmployee/"+franchisedOutletCityCenter.getId()+"/","cityCenterEmployeeList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.copyCityCenterEmployeeFrom","copyCityCenterEmployeeFrom","copyCityCenterEmployeeFrom/"+franchisedOutletCityCenter.getId()+"/","cityCenterEmployeeList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.addFranchisedOutletCityServiceCenter","addFranchisedOutletCityServiceCenter","addFranchisedOutletCityServiceCenter/"+franchisedOutletCityCenter.getId()+"/","franchisedOutletCityServiceCenterList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.removeFranchisedOutletCityServiceCenter","removeFranchisedOutletCityServiceCenter","removeFranchisedOutletCityServiceCenter/"+franchisedOutletCityCenter.getId()+"/","franchisedOutletCityServiceCenterList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.updateFranchisedOutletCityServiceCenter","updateFranchisedOutletCityServiceCenter","updateFranchisedOutletCityServiceCenter/"+franchisedOutletCityCenter.getId()+"/","franchisedOutletCityServiceCenterList","primary");
		addAction(userContext, franchisedOutletCityCenter, tokens,"franchised_outlet_city_center.copyFranchisedOutletCityServiceCenterFrom","copyFranchisedOutletCityServiceCenterFrom","copyFranchisedOutletCityServiceCenterFrom/"+franchisedOutletCityCenter.getId()+"/","franchisedOutletCityServiceCenterList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public FranchisedOutletCityCenter createFranchisedOutletCityCenter(YoubenbenUserContext userContext, String name,Date founded,String cityId) throws Exception
	//public FranchisedOutletCityCenter createFranchisedOutletCityCenter(YoubenbenUserContext userContext,String name, Date founded, String cityId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfFranchisedOutletCityCenter(name);
		checkerOf(userContext).checkFoundedOfFranchisedOutletCityCenter(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);


		FranchisedOutletCityCenter franchisedOutletCityCenter=createNewFranchisedOutletCityCenter();	

		franchisedOutletCityCenter.setName(name);
		franchisedOutletCityCenter.setFounded(founded);
			
		FranchisedOutletCityCenter city = loadFranchisedOutletCityCenter(userContext, cityId,emptyOptions());
		franchisedOutletCityCenter.setCity(city);
		
		
		franchisedOutletCityCenter.setLastUpdateTime(userContext.now());

		franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, emptyOptions());
		
		onNewInstanceCreated(userContext, franchisedOutletCityCenter);
		return franchisedOutletCityCenter;


	}
	protected FranchisedOutletCityCenter createNewFranchisedOutletCityCenter()
	{

		return new FranchisedOutletCityCenter();
	}

	protected void checkParamsForUpdatingFranchisedOutletCityCenter(YoubenbenUserContext userContext,String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).checkVersionOfFranchisedOutletCityCenter( franchisedOutletCityCenterVersion);
		

		if(FranchisedOutletCityCenter.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfFranchisedOutletCityCenter(parseString(newValueExpr));
		
			
		}
		if(FranchisedOutletCityCenter.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfFranchisedOutletCityCenter(parseDate(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);


	}



	public FranchisedOutletCityCenter clone(YoubenbenUserContext userContext, String fromFranchisedOutletCityCenterId) throws Exception{

		return franchisedOutletCityCenterDaoOf(userContext).clone(fromFranchisedOutletCityCenterId, this.allTokens());
	}

	public FranchisedOutletCityCenter internalSaveFranchisedOutletCityCenter(YoubenbenUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter) throws Exception
	{
		return internalSaveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, allTokens());

	}
	public FranchisedOutletCityCenter internalSaveFranchisedOutletCityCenter(YoubenbenUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, franchisedOutletCityCenterVersion, property, newValueExpr, tokensExpr);


		synchronized(franchisedOutletCityCenter){
			//will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FranchisedOutletCityCenter.
			if (franchisedOutletCityCenter.isChanged()){
			franchisedOutletCityCenter.updateLastUpdateTime(userContext.now());
			}
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, options);
			return franchisedOutletCityCenter;

		}

	}

	public FranchisedOutletCityCenter updateFranchisedOutletCityCenter(YoubenbenUserContext userContext,String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, franchisedOutletCityCenterVersion, property, newValueExpr, tokensExpr);



		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
		if(franchisedOutletCityCenter.getVersion() != franchisedOutletCityCenterVersion){
			String message = "The target version("+franchisedOutletCityCenter.getVersion()+") is not equals to version("+franchisedOutletCityCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(franchisedOutletCityCenter){
			//will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FranchisedOutletCityCenter.
			franchisedOutletCityCenter.updateLastUpdateTime(userContext.now());
			franchisedOutletCityCenter.changeProperty(property, newValueExpr);
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().done());
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
			//return saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().done());
		}

	}

	public FranchisedOutletCityCenter updateFranchisedOutletCityCenterProperty(YoubenbenUserContext userContext,String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, franchisedOutletCityCenterVersion, property, newValueExpr, tokensExpr);

		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
		if(franchisedOutletCityCenter.getVersion() != franchisedOutletCityCenterVersion){
			String message = "The target version("+franchisedOutletCityCenter.getVersion()+") is not equals to version("+franchisedOutletCityCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(franchisedOutletCityCenter){
			//will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FranchisedOutletCityCenter.

			franchisedOutletCityCenter.changeProperty(property, newValueExpr);
			franchisedOutletCityCenter.updateLastUpdateTime(userContext.now());
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().done());
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
			//return saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected FranchisedOutletCityCenterTokens tokens(){
		return FranchisedOutletCityCenterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FranchisedOutletCityCenterTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortFranchisedOutletCityCenterListWith("id","desc")
		.sortCityCenterDepartmentListWith("id","desc")
		.sortCityCenterEmployeeListWith("id","desc")
		.sortFranchisedOutletCityServiceCenterListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FranchisedOutletCityCenterTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCity(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String anotherCityId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
 		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(anotherCityId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

 	}
 	public FranchisedOutletCityCenter transferToAnotherCity(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String anotherCityId) throws Exception
 	{
 		checkParamsForTransferingAnotherCity(userContext, franchisedOutletCityCenterId,anotherCityId);
 
		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());	
		synchronized(franchisedOutletCityCenter){
			//will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			FranchisedOutletCityCenter city = loadFranchisedOutletCityCenter(userContext, anotherCityId, emptyOptions());		
			franchisedOutletCityCenter.updateCity(city);		
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, emptyOptions());
			
			return present(userContext,franchisedOutletCityCenter, allTokens());
			
		}

 	}

	


	public CandidateFranchisedOutletCityCenter requestCandidateCity(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<FranchisedOutletCityCenter> candidateList = franchisedOutletCityCenterDaoOf(userContext).requestCandidateFranchisedOutletCityCenterForFranchisedOutletCityCenter(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion) throws Exception {
		//deleteInternal(userContext, franchisedOutletCityCenterId, franchisedOutletCityCenterVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion) throws Exception{

		franchisedOutletCityCenterDaoOf(userContext).delete(franchisedOutletCityCenterId, franchisedOutletCityCenterVersion);
	}

	public FranchisedOutletCityCenter forgetByAll(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion) throws Exception {
		return forgetByAllInternal(userContext, franchisedOutletCityCenterId, franchisedOutletCityCenterVersion);
	}
	protected FranchisedOutletCityCenter forgetByAllInternal(YoubenbenUserContext userContext,
			String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion) throws Exception{

		return franchisedOutletCityCenterDaoOf(userContext).disconnectFromAll(franchisedOutletCityCenterId, franchisedOutletCityCenterVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FranchisedOutletCityCenterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return franchisedOutletCityCenterDaoOf(userContext).deleteAll();
	}


	//disconnect FranchisedOutletCityCenter with department in CityCenterEmployee
	protected FranchisedOutletCityCenter breakWithCityCenterEmployeeByDepartment(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());

			synchronized(franchisedOutletCityCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				franchisedOutletCityCenterDaoOf(userContext).planToRemoveCityCenterEmployeeListWithDepartment(franchisedOutletCityCenter, departmentId, this.emptyOptions());

				franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withCityCenterEmployeeList().done());
				return franchisedOutletCityCenter;
			}
	}






	protected void checkParamsForAddingFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);

		
		checkerOf(userContext).checkNameOfFranchisedOutletCityCenter(name);
		
		checkerOf(userContext).checkFoundedOfFranchisedOutletCityCenter(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);


	}
	public  FranchisedOutletCityCenter addFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingFranchisedOutletCityCenter(userContext,franchisedOutletCityCenterId,name, founded,tokensExpr);

		FranchisedOutletCityCenter franchisedOutletCityCenter = createFranchisedOutletCityCenter(userContext,name, founded);

		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, emptyOptions());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityCenter.addFranchisedOutletCityCenter( franchisedOutletCityCenter );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withFranchisedOutletCityCenterList().done());
			
			userContext.getManagerGroup().getFranchisedOutletCityCenterManager().onNewInstanceCreated(userContext, franchisedOutletCityCenter);
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFranchisedOutletCityCenterProperties(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,String id,String name,Date founded,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(id);

		checkerOf(userContext).checkNameOfFranchisedOutletCityCenter( name);
		checkerOf(userContext).checkFoundedOfFranchisedOutletCityCenter( founded);

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter updateFranchisedOutletCityCenterProperties(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String id,String name,Date founded, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFranchisedOutletCityCenterProperties(userContext,franchisedOutletCityCenterId,id,name,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFranchisedOutletCityCenterListList()
				.searchFranchisedOutletCityCenterListWith(FranchisedOutletCityCenter.ID_PROPERTY, "is", id).done();

		FranchisedOutletCityCenter franchisedOutletCityCenterToUpdate = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, options);

		if(franchisedOutletCityCenterToUpdate.getFranchisedOutletCityCenterList().isEmpty()){
			throw new FranchisedOutletCityCenterManagerException("FranchisedOutletCityCenter is NOT FOUND with id: '"+id+"'");
		}

		FranchisedOutletCityCenter item = franchisedOutletCityCenterToUpdate.getFranchisedOutletCityCenterList().first();

		item.updateName( name );
		item.updateFounded( founded );


		//checkParamsForAddingFranchisedOutletCityCenter(userContext,franchisedOutletCityCenterId,name, code, used,tokensExpr);
		FranchisedOutletCityCenter franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterToUpdate, tokens().withFranchisedOutletCityCenterList().done());
		synchronized(franchisedOutletCityCenter){
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected FranchisedOutletCityCenter createFranchisedOutletCityCenter(YoubenbenUserContext userContext, String name, Date founded) throws Exception{

		FranchisedOutletCityCenter franchisedOutletCityCenter = new FranchisedOutletCityCenter();
		
		
		franchisedOutletCityCenter.setName(name);		
		franchisedOutletCityCenter.setFounded(founded);		
		franchisedOutletCityCenter.setLastUpdateTime(userContext.now());
	
		
		return franchisedOutletCityCenter;


	}

	protected FranchisedOutletCityCenter createIndexedFranchisedOutletCityCenter(String id, int version){

		FranchisedOutletCityCenter franchisedOutletCityCenter = new FranchisedOutletCityCenter();
		franchisedOutletCityCenter.setId(id);
		franchisedOutletCityCenter.setVersion(version);
		return franchisedOutletCityCenter;

	}

	protected void checkParamsForRemovingFranchisedOutletCityCenterList(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
			String franchisedOutletCityCenterIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		for(String franchisedOutletCityCenterIdItem: franchisedOutletCityCenterIds){
			checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter removeFranchisedOutletCityCenterList(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
			String franchisedOutletCityCenterIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingFranchisedOutletCityCenterList(userContext, franchisedOutletCityCenterId,  franchisedOutletCityCenterIds, tokensExpr);


			FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
			synchronized(franchisedOutletCityCenter){
				//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				franchisedOutletCityCenterDaoOf(userContext).planToRemoveFranchisedOutletCityCenterList(franchisedOutletCityCenter, franchisedOutletCityCenterIds, allTokens());
				franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withFranchisedOutletCityCenterList().done());
				deleteRelationListInGraph(userContext, franchisedOutletCityCenter.getFranchisedOutletCityCenterList());
				return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter( franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).checkVersionOfFranchisedOutletCityCenter(franchisedOutletCityCenterVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter removeFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingFranchisedOutletCityCenter(userContext,franchisedOutletCityCenterId, franchisedOutletCityCenterId, franchisedOutletCityCenterVersion,tokensExpr);

		FranchisedOutletCityCenter franchisedOutletCityCenter = createIndexedFranchisedOutletCityCenter(franchisedOutletCityCenterId, franchisedOutletCityCenterVersion);
		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityCenter.removeFranchisedOutletCityCenter( franchisedOutletCityCenter );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withFranchisedOutletCityCenterList().done());
			deleteRelationInGraph(userContext, franchisedOutletCityCenter);
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter( franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).checkVersionOfFranchisedOutletCityCenter(franchisedOutletCityCenterVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter copyFranchisedOutletCityCenterFrom(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingFranchisedOutletCityCenter(userContext,franchisedOutletCityCenterId, franchisedOutletCityCenterId, franchisedOutletCityCenterVersion,tokensExpr);

		FranchisedOutletCityCenter franchisedOutletCityCenter = createIndexedFranchisedOutletCityCenter(franchisedOutletCityCenterId, franchisedOutletCityCenterVersion);
		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			franchisedOutletCityCenter.updateLastUpdateTime(userContext.now());

			franchisedOutletCityCenter.copyFranchisedOutletCityCenterFrom( franchisedOutletCityCenter );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withFranchisedOutletCityCenterList().done());
			
			userContext.getManagerGroup().getFranchisedOutletCityCenterManager().onNewInstanceCreated(userContext, (FranchisedOutletCityCenter)franchisedOutletCityCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).checkVersionOfFranchisedOutletCityCenter(franchisedOutletCityCenterVersion);
		

		if(FranchisedOutletCityCenter.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfFranchisedOutletCityCenter(parseString(newValueExpr));
		
		}
		
		if(FranchisedOutletCityCenter.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfFranchisedOutletCityCenter(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}

	public  FranchisedOutletCityCenter updateFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, franchisedOutletCityCenterId, franchisedOutletCityCenterVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withFranchisedOutletCityCenterList().searchFranchisedOutletCityCenterListWith(FranchisedOutletCityCenter.ID_PROPERTY, "eq", franchisedOutletCityCenterId).done();



		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, loadTokens);

		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//franchisedOutletCityCenter.removeFranchisedOutletCityCenter( franchisedOutletCityCenter );
			//make changes to AcceleraterAccount.
			FranchisedOutletCityCenter franchisedOutletCityCenterIndex = createIndexedFranchisedOutletCityCenter(franchisedOutletCityCenterId, franchisedOutletCityCenterVersion);

			FranchisedOutletCityCenter franchisedOutletCityCenter = franchisedOutletCityCenter.findTheFranchisedOutletCityCenter(franchisedOutletCityCenterIndex);
			if(franchisedOutletCityCenter == null){
				throw new FranchisedOutletCityCenterManagerException(franchisedOutletCityCenter+" is NOT FOUND" );
			}

			franchisedOutletCityCenter.changeProperty(property, newValueExpr);
			franchisedOutletCityCenter.updateLastUpdateTime(userContext.now());
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withFranchisedOutletCityCenterList().done());
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingCityCenterDepartment(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded, String manager,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);

		
		checkerOf(userContext).checkNameOfCityCenterDepartment(name);
		
		checkerOf(userContext).checkFoundedOfCityCenterDepartment(founded);
		
		checkerOf(userContext).checkManagerOfCityCenterDepartment(manager);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);


	}
	public  FranchisedOutletCityCenter addCityCenterDepartment(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded, String manager, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCityCenterDepartment(userContext,franchisedOutletCityCenterId,name, founded, manager,tokensExpr);

		CityCenterDepartment cityCenterDepartment = createCityCenterDepartment(userContext,name, founded, manager);

		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, emptyOptions());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityCenter.addCityCenterDepartment( cityCenterDepartment );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withCityCenterDepartmentList().done());
			
			userContext.getManagerGroup().getCityCenterDepartmentManager().onNewInstanceCreated(userContext, cityCenterDepartment);
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCityCenterDepartmentProperties(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,String id,String name,Date founded,String manager,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfCityCenterDepartment(id);

		checkerOf(userContext).checkNameOfCityCenterDepartment( name);
		checkerOf(userContext).checkFoundedOfCityCenterDepartment( founded);
		checkerOf(userContext).checkManagerOfCityCenterDepartment( manager);

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter updateCityCenterDepartmentProperties(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String id,String name,Date founded,String manager, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityCenterDepartmentProperties(userContext,franchisedOutletCityCenterId,id,name,founded,manager,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCityCenterDepartmentListList()
				.searchCityCenterDepartmentListWith(CityCenterDepartment.ID_PROPERTY, "is", id).done();

		FranchisedOutletCityCenter franchisedOutletCityCenterToUpdate = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, options);

		if(franchisedOutletCityCenterToUpdate.getCityCenterDepartmentList().isEmpty()){
			throw new FranchisedOutletCityCenterManagerException("CityCenterDepartment is NOT FOUND with id: '"+id+"'");
		}

		CityCenterDepartment item = franchisedOutletCityCenterToUpdate.getCityCenterDepartmentList().first();

		item.updateName( name );
		item.updateFounded( founded );
		item.updateManager( manager );


		//checkParamsForAddingCityCenterDepartment(userContext,franchisedOutletCityCenterId,name, code, used,tokensExpr);
		FranchisedOutletCityCenter franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterToUpdate, tokens().withCityCenterDepartmentList().done());
		synchronized(franchisedOutletCityCenter){
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected CityCenterDepartment createCityCenterDepartment(YoubenbenUserContext userContext, String name, Date founded, String manager) throws Exception{

		CityCenterDepartment cityCenterDepartment = new CityCenterDepartment();
		
		
		cityCenterDepartment.setName(name);		
		cityCenterDepartment.setFounded(founded);		
		cityCenterDepartment.setManager(manager);
	
		
		return cityCenterDepartment;


	}

	protected CityCenterDepartment createIndexedCityCenterDepartment(String id, int version){

		CityCenterDepartment cityCenterDepartment = new CityCenterDepartment();
		cityCenterDepartment.setId(id);
		cityCenterDepartment.setVersion(version);
		return cityCenterDepartment;

	}

	protected void checkParamsForRemovingCityCenterDepartmentList(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
			String cityCenterDepartmentIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		for(String cityCenterDepartmentIdItem: cityCenterDepartmentIds){
			checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter removeCityCenterDepartmentList(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
			String cityCenterDepartmentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCityCenterDepartmentList(userContext, franchisedOutletCityCenterId,  cityCenterDepartmentIds, tokensExpr);


			FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
			synchronized(franchisedOutletCityCenter){
				//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				franchisedOutletCityCenterDaoOf(userContext).planToRemoveCityCenterDepartmentList(franchisedOutletCityCenter, cityCenterDepartmentIds, allTokens());
				franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withCityCenterDepartmentList().done());
				deleteRelationListInGraph(userContext, franchisedOutletCityCenter.getCityCenterDepartmentList());
				return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCityCenterDepartment(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String cityCenterDepartmentId, int cityCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter( franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);
		checkerOf(userContext).checkVersionOfCityCenterDepartment(cityCenterDepartmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter removeCityCenterDepartment(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String cityCenterDepartmentId, int cityCenterDepartmentVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingCityCenterDepartment(userContext,franchisedOutletCityCenterId, cityCenterDepartmentId, cityCenterDepartmentVersion,tokensExpr);

		CityCenterDepartment cityCenterDepartment = createIndexedCityCenterDepartment(cityCenterDepartmentId, cityCenterDepartmentVersion);
		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityCenter.removeCityCenterDepartment( cityCenterDepartment );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withCityCenterDepartmentList().done());
			deleteRelationInGraph(userContext, cityCenterDepartment);
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingCityCenterDepartment(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String cityCenterDepartmentId, int cityCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter( franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);
		checkerOf(userContext).checkVersionOfCityCenterDepartment(cityCenterDepartmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter copyCityCenterDepartmentFrom(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String cityCenterDepartmentId, int cityCenterDepartmentVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingCityCenterDepartment(userContext,franchisedOutletCityCenterId, cityCenterDepartmentId, cityCenterDepartmentVersion,tokensExpr);

		CityCenterDepartment cityCenterDepartment = createIndexedCityCenterDepartment(cityCenterDepartmentId, cityCenterDepartmentVersion);
		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			franchisedOutletCityCenter.copyCityCenterDepartmentFrom( cityCenterDepartment );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withCityCenterDepartmentList().done());
			
			userContext.getManagerGroup().getCityCenterDepartmentManager().onNewInstanceCreated(userContext, (CityCenterDepartment)franchisedOutletCityCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCityCenterDepartment(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String cityCenterDepartmentId, int cityCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfCityCenterDepartment(cityCenterDepartmentId);
		checkerOf(userContext).checkVersionOfCityCenterDepartment(cityCenterDepartmentVersion);
		

		if(CityCenterDepartment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCityCenterDepartment(parseString(newValueExpr));
		
		}
		
		if(CityCenterDepartment.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfCityCenterDepartment(parseDate(newValueExpr));
		
		}
		
		if(CityCenterDepartment.MANAGER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkManagerOfCityCenterDepartment(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}

	public  FranchisedOutletCityCenter updateCityCenterDepartment(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String cityCenterDepartmentId, int cityCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCityCenterDepartment(userContext, franchisedOutletCityCenterId, cityCenterDepartmentId, cityCenterDepartmentVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCityCenterDepartmentList().searchCityCenterDepartmentListWith(CityCenterDepartment.ID_PROPERTY, "eq", cityCenterDepartmentId).done();



		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, loadTokens);

		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//franchisedOutletCityCenter.removeCityCenterDepartment( cityCenterDepartment );
			//make changes to AcceleraterAccount.
			CityCenterDepartment cityCenterDepartmentIndex = createIndexedCityCenterDepartment(cityCenterDepartmentId, cityCenterDepartmentVersion);

			CityCenterDepartment cityCenterDepartment = franchisedOutletCityCenter.findTheCityCenterDepartment(cityCenterDepartmentIndex);
			if(cityCenterDepartment == null){
				throw new FranchisedOutletCityCenterManagerException(cityCenterDepartment+" is NOT FOUND" );
			}

			cityCenterDepartment.changeProperty(property, newValueExpr);
			
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withCityCenterDepartmentList().done());
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingCityCenterEmployee(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, String mobile, String email, Date founded, String departmentId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);

		
		checkerOf(userContext).checkNameOfCityCenterEmployee(name);
		
		checkerOf(userContext).checkMobileOfCityCenterEmployee(mobile);
		
		checkerOf(userContext).checkEmailOfCityCenterEmployee(email);
		
		checkerOf(userContext).checkFoundedOfCityCenterEmployee(founded);
		
		checkerOf(userContext).checkDepartmentIdOfCityCenterEmployee(departmentId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);


	}
	public  FranchisedOutletCityCenter addCityCenterEmployee(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, String mobile, String email, Date founded, String departmentId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCityCenterEmployee(userContext,franchisedOutletCityCenterId,name, mobile, email, founded, departmentId,tokensExpr);

		CityCenterEmployee cityCenterEmployee = createCityCenterEmployee(userContext,name, mobile, email, founded, departmentId);

		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, emptyOptions());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityCenter.addCityCenterEmployee( cityCenterEmployee );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withCityCenterEmployeeList().done());
			
			userContext.getManagerGroup().getCityCenterEmployeeManager().onNewInstanceCreated(userContext, cityCenterEmployee);
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCityCenterEmployeeProperties(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,String id,String name,String mobile,String email,Date founded,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfCityCenterEmployee(id);

		checkerOf(userContext).checkNameOfCityCenterEmployee( name);
		checkerOf(userContext).checkMobileOfCityCenterEmployee( mobile);
		checkerOf(userContext).checkEmailOfCityCenterEmployee( email);
		checkerOf(userContext).checkFoundedOfCityCenterEmployee( founded);

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter updateCityCenterEmployeeProperties(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String id,String name,String mobile,String email,Date founded, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityCenterEmployeeProperties(userContext,franchisedOutletCityCenterId,id,name,mobile,email,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCityCenterEmployeeListList()
				.searchCityCenterEmployeeListWith(CityCenterEmployee.ID_PROPERTY, "is", id).done();

		FranchisedOutletCityCenter franchisedOutletCityCenterToUpdate = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, options);

		if(franchisedOutletCityCenterToUpdate.getCityCenterEmployeeList().isEmpty()){
			throw new FranchisedOutletCityCenterManagerException("CityCenterEmployee is NOT FOUND with id: '"+id+"'");
		}

		CityCenterEmployee item = franchisedOutletCityCenterToUpdate.getCityCenterEmployeeList().first();

		item.updateName( name );
		item.updateMobile( mobile );
		item.updateEmail( email );
		item.updateFounded( founded );


		//checkParamsForAddingCityCenterEmployee(userContext,franchisedOutletCityCenterId,name, code, used,tokensExpr);
		FranchisedOutletCityCenter franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterToUpdate, tokens().withCityCenterEmployeeList().done());
		synchronized(franchisedOutletCityCenter){
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected CityCenterEmployee createCityCenterEmployee(YoubenbenUserContext userContext, String name, String mobile, String email, Date founded, String departmentId) throws Exception{

		CityCenterEmployee cityCenterEmployee = new CityCenterEmployee();
		
		
		cityCenterEmployee.setName(name);		
		cityCenterEmployee.setMobile(mobile);		
		cityCenterEmployee.setEmail(email);		
		cityCenterEmployee.setFounded(founded);		
		CityCenterDepartment  department = new CityCenterDepartment();
		department.setId(departmentId);		
		cityCenterEmployee.setDepartment(department);
	
		
		return cityCenterEmployee;


	}

	protected CityCenterEmployee createIndexedCityCenterEmployee(String id, int version){

		CityCenterEmployee cityCenterEmployee = new CityCenterEmployee();
		cityCenterEmployee.setId(id);
		cityCenterEmployee.setVersion(version);
		return cityCenterEmployee;

	}

	protected void checkParamsForRemovingCityCenterEmployeeList(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
			String cityCenterEmployeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		for(String cityCenterEmployeeIdItem: cityCenterEmployeeIds){
			checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter removeCityCenterEmployeeList(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
			String cityCenterEmployeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCityCenterEmployeeList(userContext, franchisedOutletCityCenterId,  cityCenterEmployeeIds, tokensExpr);


			FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
			synchronized(franchisedOutletCityCenter){
				//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				franchisedOutletCityCenterDaoOf(userContext).planToRemoveCityCenterEmployeeList(franchisedOutletCityCenter, cityCenterEmployeeIds, allTokens());
				franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withCityCenterEmployeeList().done());
				deleteRelationListInGraph(userContext, franchisedOutletCityCenter.getCityCenterEmployeeList());
				return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCityCenterEmployee(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter( franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeId);
		checkerOf(userContext).checkVersionOfCityCenterEmployee(cityCenterEmployeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter removeCityCenterEmployee(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingCityCenterEmployee(userContext,franchisedOutletCityCenterId, cityCenterEmployeeId, cityCenterEmployeeVersion,tokensExpr);

		CityCenterEmployee cityCenterEmployee = createIndexedCityCenterEmployee(cityCenterEmployeeId, cityCenterEmployeeVersion);
		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityCenter.removeCityCenterEmployee( cityCenterEmployee );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withCityCenterEmployeeList().done());
			deleteRelationInGraph(userContext, cityCenterEmployee);
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingCityCenterEmployee(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter( franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeId);
		checkerOf(userContext).checkVersionOfCityCenterEmployee(cityCenterEmployeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter copyCityCenterEmployeeFrom(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingCityCenterEmployee(userContext,franchisedOutletCityCenterId, cityCenterEmployeeId, cityCenterEmployeeVersion,tokensExpr);

		CityCenterEmployee cityCenterEmployee = createIndexedCityCenterEmployee(cityCenterEmployeeId, cityCenterEmployeeVersion);
		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			franchisedOutletCityCenter.copyCityCenterEmployeeFrom( cityCenterEmployee );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withCityCenterEmployeeList().done());
			
			userContext.getManagerGroup().getCityCenterEmployeeManager().onNewInstanceCreated(userContext, (CityCenterEmployee)franchisedOutletCityCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCityCenterEmployee(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}

	public  FranchisedOutletCityCenter updateCityCenterEmployee(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCityCenterEmployee(userContext, franchisedOutletCityCenterId, cityCenterEmployeeId, cityCenterEmployeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCityCenterEmployeeList().searchCityCenterEmployeeListWith(CityCenterEmployee.ID_PROPERTY, "eq", cityCenterEmployeeId).done();



		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, loadTokens);

		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//franchisedOutletCityCenter.removeCityCenterEmployee( cityCenterEmployee );
			//make changes to AcceleraterAccount.
			CityCenterEmployee cityCenterEmployeeIndex = createIndexedCityCenterEmployee(cityCenterEmployeeId, cityCenterEmployeeVersion);

			CityCenterEmployee cityCenterEmployee = franchisedOutletCityCenter.findTheCityCenterEmployee(cityCenterEmployeeIndex);
			if(cityCenterEmployee == null){
				throw new FranchisedOutletCityCenterManagerException(cityCenterEmployee+" is NOT FOUND" );
			}

			cityCenterEmployee.changeProperty(property, newValueExpr);
			
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withCityCenterEmployeeList().done());
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);

		
		checkerOf(userContext).checkNameOfFranchisedOutletCityServiceCenter(name);
		
		checkerOf(userContext).checkFoundedOfFranchisedOutletCityServiceCenter(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);


	}
	public  FranchisedOutletCityCenter addFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingFranchisedOutletCityServiceCenter(userContext,franchisedOutletCityCenterId,name, founded,tokensExpr);

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = createFranchisedOutletCityServiceCenter(userContext,name, founded);

		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, emptyOptions());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityCenter.addFranchisedOutletCityServiceCenter( franchisedOutletCityServiceCenter );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withFranchisedOutletCityServiceCenterList().done());
			
			userContext.getManagerGroup().getFranchisedOutletCityServiceCenterManager().onNewInstanceCreated(userContext, franchisedOutletCityServiceCenter);
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFranchisedOutletCityServiceCenterProperties(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,String id,String name,Date founded,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(id);

		checkerOf(userContext).checkNameOfFranchisedOutletCityServiceCenter( name);
		checkerOf(userContext).checkFoundedOfFranchisedOutletCityServiceCenter( founded);

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter updateFranchisedOutletCityServiceCenterProperties(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String id,String name,Date founded, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFranchisedOutletCityServiceCenterProperties(userContext,franchisedOutletCityCenterId,id,name,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFranchisedOutletCityServiceCenterListList()
				.searchFranchisedOutletCityServiceCenterListWith(FranchisedOutletCityServiceCenter.ID_PROPERTY, "is", id).done();

		FranchisedOutletCityCenter franchisedOutletCityCenterToUpdate = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, options);

		if(franchisedOutletCityCenterToUpdate.getFranchisedOutletCityServiceCenterList().isEmpty()){
			throw new FranchisedOutletCityCenterManagerException("FranchisedOutletCityServiceCenter is NOT FOUND with id: '"+id+"'");
		}

		FranchisedOutletCityServiceCenter item = franchisedOutletCityCenterToUpdate.getFranchisedOutletCityServiceCenterList().first();

		item.updateName( name );
		item.updateFounded( founded );


		//checkParamsForAddingFranchisedOutletCityServiceCenter(userContext,franchisedOutletCityCenterId,name, code, used,tokensExpr);
		FranchisedOutletCityCenter franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterToUpdate, tokens().withFranchisedOutletCityServiceCenterList().done());
		synchronized(franchisedOutletCityCenter){
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected FranchisedOutletCityServiceCenter createFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String name, Date founded) throws Exception{

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = new FranchisedOutletCityServiceCenter();
		
		
		franchisedOutletCityServiceCenter.setName(name);		
		franchisedOutletCityServiceCenter.setFounded(founded);		
		franchisedOutletCityServiceCenter.setLastUpdateTime(userContext.now());
	
		
		return franchisedOutletCityServiceCenter;


	}

	protected FranchisedOutletCityServiceCenter createIndexedFranchisedOutletCityServiceCenter(String id, int version){

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = new FranchisedOutletCityServiceCenter();
		franchisedOutletCityServiceCenter.setId(id);
		franchisedOutletCityServiceCenter.setVersion(version);
		return franchisedOutletCityServiceCenter;

	}

	protected void checkParamsForRemovingFranchisedOutletCityServiceCenterList(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
			String franchisedOutletCityServiceCenterIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		for(String franchisedOutletCityServiceCenterIdItem: franchisedOutletCityServiceCenterIds){
			checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter removeFranchisedOutletCityServiceCenterList(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
			String franchisedOutletCityServiceCenterIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingFranchisedOutletCityServiceCenterList(userContext, franchisedOutletCityCenterId,  franchisedOutletCityServiceCenterIds, tokensExpr);


			FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
			synchronized(franchisedOutletCityCenter){
				//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				franchisedOutletCityCenterDaoOf(userContext).planToRemoveFranchisedOutletCityServiceCenterList(franchisedOutletCityCenter, franchisedOutletCityServiceCenterIds, allTokens());
				franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withFranchisedOutletCityServiceCenterList().done());
				deleteRelationListInGraph(userContext, franchisedOutletCityCenter.getFranchisedOutletCityServiceCenterList());
				return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter( franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkVersionOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter removeFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingFranchisedOutletCityServiceCenter(userContext,franchisedOutletCityCenterId, franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion,tokensExpr);

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = createIndexedFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion);
		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityCenter.removeFranchisedOutletCityServiceCenter( franchisedOutletCityServiceCenter );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withFranchisedOutletCityServiceCenterList().done());
			deleteRelationInGraph(userContext, franchisedOutletCityServiceCenter);
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter( franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkVersionOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}
	public  FranchisedOutletCityCenter copyFranchisedOutletCityServiceCenterFrom(YoubenbenUserContext userContext, String franchisedOutletCityCenterId,
		String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingFranchisedOutletCityServiceCenter(userContext,franchisedOutletCityCenterId, franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion,tokensExpr);

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = createIndexedFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion);
		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, allTokens());
		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			franchisedOutletCityServiceCenter.updateLastUpdateTime(userContext.now());

			franchisedOutletCityCenter.copyFranchisedOutletCityServiceCenterFrom( franchisedOutletCityServiceCenter );
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withFranchisedOutletCityServiceCenterList().done());
			
			userContext.getManagerGroup().getFranchisedOutletCityServiceCenterManager().onNewInstanceCreated(userContext, (FranchisedOutletCityServiceCenter)franchisedOutletCityCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(franchisedOutletCityCenterId);
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkVersionOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterVersion);
		

		if(FranchisedOutletCityServiceCenter.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfFranchisedOutletCityServiceCenter(parseString(newValueExpr));
		
		}
		
		if(FranchisedOutletCityServiceCenter.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfFranchisedOutletCityServiceCenter(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityCenterManagerException.class);

	}

	public  FranchisedOutletCityCenter updateFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityCenterId, franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withFranchisedOutletCityServiceCenterList().searchFranchisedOutletCityServiceCenterListWith(FranchisedOutletCityServiceCenter.ID_PROPERTY, "eq", franchisedOutletCityServiceCenterId).done();



		FranchisedOutletCityCenter franchisedOutletCityCenter = loadFranchisedOutletCityCenter(userContext, franchisedOutletCityCenterId, loadTokens);

		synchronized(franchisedOutletCityCenter){
			//Will be good when the franchisedOutletCityCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//franchisedOutletCityCenter.removeFranchisedOutletCityServiceCenter( franchisedOutletCityServiceCenter );
			//make changes to AcceleraterAccount.
			FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenterIndex = createIndexedFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion);

			FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = franchisedOutletCityCenter.findTheFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterIndex);
			if(franchisedOutletCityServiceCenter == null){
				throw new FranchisedOutletCityCenterManagerException(franchisedOutletCityServiceCenter+" is NOT FOUND" );
			}

			franchisedOutletCityServiceCenter.changeProperty(property, newValueExpr);
			franchisedOutletCityServiceCenter.updateLastUpdateTime(userContext.now());
			franchisedOutletCityCenter = saveFranchisedOutletCityCenter(userContext, franchisedOutletCityCenter, tokens().withFranchisedOutletCityServiceCenterList().done());
			return present(userContext,franchisedOutletCityCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, FranchisedOutletCityCenter newCreated) throws Exception{
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
		//   FranchisedOutletCityCenter newFranchisedOutletCityCenter = this.createFranchisedOutletCityCenter(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newFranchisedOutletCityCenter
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, FranchisedOutletCityCenter.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<FranchisedOutletCityCenter> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<FranchisedOutletCityCenter> cityList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, FranchisedOutletCityCenter.class);
		userContext.getDAOGroup().enhanceList(cityList, FranchisedOutletCityCenter.class);


    }
	
	public Object listByCity(YoubenbenUserContext userContext,String cityId) throws Exception {
		return listPageByCity(userContext, cityId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCity(YoubenbenUserContext userContext,String cityId, int start, int count) throws Exception {
		SmartList<FranchisedOutletCityCenter> list = franchisedOutletCityCenterDaoOf(userContext).findFranchisedOutletCityCenterByCity(cityId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(FranchisedOutletCityCenter.class);
		page.setContainerObject(FranchisedOutletCityCenter.withId(cityId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("城市中心专卖店列表");
		page.setRequestName("listByCity");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCity/%s/",  getBeanName(), cityId)));

		page.assemblerContent(userContext, "listByCity");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String franchisedOutletCityCenterId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getFranchisedOutletCityCenterDetailScope().clone();
		FranchisedOutletCityCenter merchantObj = (FranchisedOutletCityCenter) this.view(userContext, franchisedOutletCityCenterId);
    String merchantObjId = franchisedOutletCityCenterId;
    String linkToUrl =	"franchisedOutletCityCenterManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "城市中心专卖店"+"详情";
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
				MapUtil.put("id", "4-city")
				    .put("fieldName", "city")
				    .put("label", "城市")
				    .put("type", "auto")
				    .put("linkToUrl", "franchisedOutletCityCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("city", merchantObj.getCity());

		propList.add(
				MapUtil.put("id", "5-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "最后更新时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：franchisedOutletCityCenterListSection
		Map franchisedOutletCityCenterListSection = ListofUtils.buildSection(
		    "franchisedOutletCityCenterListSection",
		    "城市中心特许经销店名单",
		    null,
		    "",
		    "__no_group",
		    "franchisedOutletCityCenterManager/listByCity/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(franchisedOutletCityCenterListSection);

		result.put("franchisedOutletCityCenterListSection", ListofUtils.toShortList(merchantObj.getFranchisedOutletCityCenterList(), "franchisedOutletCityCenter"));
		vscope.field("franchisedOutletCityCenterListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( FranchisedOutletCityCenter.class.getName(), null));

		//处理Section：cityCenterEmployeeListSection
		Map cityCenterEmployeeListSection = ListofUtils.buildSection(
		    "cityCenterEmployeeListSection",
		    "市中心员工名单",
		    null,
		    "",
		    "__no_group",
		    "cityCenterEmployeeManager/listByCityCenter/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(cityCenterEmployeeListSection);

		result.put("cityCenterEmployeeListSection", ListofUtils.toShortList(merchantObj.getCityCenterEmployeeList(), "cityCenterEmployee"));
		vscope.field("cityCenterEmployeeListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( CityCenterEmployee.class.getName(), null));

		//处理Section：franchisedOutletCityServiceCenterListSection
		Map franchisedOutletCityServiceCenterListSection = ListofUtils.buildSection(
		    "franchisedOutletCityServiceCenterListSection",
		    "特许经销城市服务中心名单",
		    null,
		    "",
		    "__no_group",
		    "franchisedOutletCityServiceCenterManager/listByBelongsTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(franchisedOutletCityServiceCenterListSection);

		result.put("franchisedOutletCityServiceCenterListSection", ListofUtils.toShortList(merchantObj.getFranchisedOutletCityServiceCenterList(), "franchisedOutletCityServiceCenter"));
		vscope.field("franchisedOutletCityServiceCenterListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( FranchisedOutletCityServiceCenter.class.getName(), null));

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


