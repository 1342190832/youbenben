
package com.youbenben.youbenben.retailstoreprovincecenter;

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


import com.youbenben.youbenben.provincecenteremployee.ProvinceCenterEmployee;
import com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.youbenben.youbenben.provincecenterdepartment.ProvinceCenterDepartment;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.youbenben.youbenben.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.youbenben.youbenben.provincecenterdepartment.ProvinceCenterDepartment;






public class RetailStoreProvinceCenterManagerImpl extends CustomYoubenbenCheckerManager implements RetailStoreProvinceCenterManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreProvinceCenterTokens.start().withTokenFromListName(listName).done();
		RetailStoreProvinceCenter  retailStoreProvinceCenter = (RetailStoreProvinceCenter) this.loadRetailStoreProvinceCenter(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreProvinceCenter.collectRefercencesFromLists();
		retailStoreProvinceCenterDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreProvinceCenter, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreProvinceCenterGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreProvinceCenter";
	@Override
	public RetailStoreProvinceCenterDAO daoOf(YoubenbenUserContext userContext) {
		return retailStoreProvinceCenterDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreProvinceCenterManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreProvinceCenterManagerException(message);

	}



 	protected RetailStoreProvinceCenter saveRetailStoreProvinceCenter(YoubenbenUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreProvinceCenterDAO().save(retailStoreProvinceCenter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens);
 	}
 	
 	protected RetailStoreProvinceCenter saveRetailStoreProvinceCenterDetail(YoubenbenUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter) throws Exception{	

 		
 		return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, allTokens());
 	}
 	
 	public RetailStoreProvinceCenter loadRetailStoreProvinceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreProvinceCenterManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter( userContext, retailStoreProvinceCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreProvinceCenter, tokens);
 	}
 	
 	
 	 public RetailStoreProvinceCenter searchRetailStoreProvinceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreProvinceCenterManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter( userContext, retailStoreProvinceCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreProvinceCenter, tokens);
 	}
 	
 	

 	protected RetailStoreProvinceCenter present(YoubenbenUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreProvinceCenter,tokens);
		
		
		RetailStoreProvinceCenter  retailStoreProvinceCenterToPresent = retailStoreProvinceCenterDaoOf(userContext).present(retailStoreProvinceCenter, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreProvinceCenterToPresent.collectRefercencesFromLists();
		retailStoreProvinceCenterDaoOf(userContext).alias(entityListToNaming);
		
		return  retailStoreProvinceCenterToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreProvinceCenter loadRetailStoreProvinceCenterDetail(YoubenbenUserContext userContext, String retailStoreProvinceCenterId) throws Exception{	
 		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter( userContext, retailStoreProvinceCenterId, allTokens());
 		return present(userContext,retailStoreProvinceCenter, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String retailStoreProvinceCenterId) throws Exception{	
 		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter( userContext, retailStoreProvinceCenterId, viewTokens());
 		return present(userContext,retailStoreProvinceCenter, allTokens());
		
 	}
 	protected RetailStoreProvinceCenter saveRetailStoreProvinceCenter(YoubenbenUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object>tokens) throws Exception{	
 		return retailStoreProvinceCenterDaoOf(userContext).save(retailStoreProvinceCenter, tokens);
 	}
 	protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreProvinceCenterManagerException.class);

 
 		return retailStoreProvinceCenterDaoOf(userContext).load(retailStoreProvinceCenterId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreProvinceCenter, tokens);
		
		addAction(userContext, retailStoreProvinceCenter, tokens,"@create","createRetailStoreProvinceCenter","createRetailStoreProvinceCenter/","main","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"@update","updateRetailStoreProvinceCenter","updateRetailStoreProvinceCenter/"+retailStoreProvinceCenter.getId()+"/","main","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"@copy","cloneRetailStoreProvinceCenter","cloneRetailStoreProvinceCenter/"+retailStoreProvinceCenter.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.transfer_to_country","transferToAnotherCountry","transferToAnotherCountry/"+retailStoreProvinceCenter.getId()+"/","main","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.addProvinceCenterDepartment","addProvinceCenterDepartment","addProvinceCenterDepartment/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.removeProvinceCenterDepartment","removeProvinceCenterDepartment","removeProvinceCenterDepartment/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.updateProvinceCenterDepartment","updateProvinceCenterDepartment","updateProvinceCenterDepartment/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.copyProvinceCenterDepartmentFrom","copyProvinceCenterDepartmentFrom","copyProvinceCenterDepartmentFrom/"+retailStoreProvinceCenter.getId()+"/","provinceCenterDepartmentList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.addProvinceCenterEmployee","addProvinceCenterEmployee","addProvinceCenterEmployee/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.removeProvinceCenterEmployee","removeProvinceCenterEmployee","removeProvinceCenterEmployee/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.updateProvinceCenterEmployee","updateProvinceCenterEmployee","updateProvinceCenterEmployee/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom/"+retailStoreProvinceCenter.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.addRetailStoreCityServiceCenter","addRetailStoreCityServiceCenter","addRetailStoreCityServiceCenter/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.removeRetailStoreCityServiceCenter","removeRetailStoreCityServiceCenter","removeRetailStoreCityServiceCenter/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.updateRetailStoreCityServiceCenter","updateRetailStoreCityServiceCenter","updateRetailStoreCityServiceCenter/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
		addAction(userContext, retailStoreProvinceCenter, tokens,"retail_store_province_center.copyRetailStoreCityServiceCenterFrom","copyRetailStoreCityServiceCenterFrom","copyRetailStoreCityServiceCenterFrom/"+retailStoreProvinceCenter.getId()+"/","retailStoreCityServiceCenterList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreProvinceCenter createRetailStoreProvinceCenter(YoubenbenUserContext userContext, String name,Date founded,String countryId) throws Exception
	//public RetailStoreProvinceCenter createRetailStoreProvinceCenter(YoubenbenUserContext userContext,String name, Date founded, String countryId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfRetailStoreProvinceCenter(name);
		checkerOf(userContext).checkFoundedOfRetailStoreProvinceCenter(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);


		RetailStoreProvinceCenter retailStoreProvinceCenter=createNewRetailStoreProvinceCenter();	

		retailStoreProvinceCenter.setName(name);
		retailStoreProvinceCenter.setFounded(founded);
			
		RetailStoreCountryCenter country = loadRetailStoreCountryCenter(userContext, countryId,emptyOptions());
		retailStoreProvinceCenter.setCountry(country);
		
		
		retailStoreProvinceCenter.setLastUpdateTime(userContext.now());

		retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreProvinceCenter);
		return retailStoreProvinceCenter;


	}
	protected RetailStoreProvinceCenter createNewRetailStoreProvinceCenter()
	{

		return new RetailStoreProvinceCenter();
	}

	protected void checkParamsForUpdatingRetailStoreProvinceCenter(YoubenbenUserContext userContext,String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).checkVersionOfRetailStoreProvinceCenter( retailStoreProvinceCenterVersion);
		

		if(RetailStoreProvinceCenter.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreProvinceCenter(parseString(newValueExpr));
		
			
		}
		if(RetailStoreProvinceCenter.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfRetailStoreProvinceCenter(parseDate(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);


	}



	public RetailStoreProvinceCenter clone(YoubenbenUserContext userContext, String fromRetailStoreProvinceCenterId) throws Exception{

		return retailStoreProvinceCenterDaoOf(userContext).clone(fromRetailStoreProvinceCenterId, this.allTokens());
	}

	public RetailStoreProvinceCenter internalSaveRetailStoreProvinceCenter(YoubenbenUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter) throws Exception
	{
		return internalSaveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, allTokens());

	}
	public RetailStoreProvinceCenter internalSaveRetailStoreProvinceCenter(YoubenbenUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreProvinceCenter){
			//will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreProvinceCenter.
			if (retailStoreProvinceCenter.isChanged()){
			retailStoreProvinceCenter.updateLastUpdateTime(userContext.now());
			}
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, options);
			return retailStoreProvinceCenter;

		}

	}

	public RetailStoreProvinceCenter updateRetailStoreProvinceCenter(YoubenbenUserContext userContext,String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion, property, newValueExpr, tokensExpr);



		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		if(retailStoreProvinceCenter.getVersion() != retailStoreProvinceCenterVersion){
			String message = "The target version("+retailStoreProvinceCenter.getVersion()+") is not equals to version("+retailStoreProvinceCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreProvinceCenter){
			//will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreProvinceCenter.
			retailStoreProvinceCenter.updateLastUpdateTime(userContext.now());
			retailStoreProvinceCenter.changeProperty(property, newValueExpr);
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
			//return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
		}

	}

	public RetailStoreProvinceCenter updateRetailStoreProvinceCenterProperty(YoubenbenUserContext userContext,String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion, property, newValueExpr, tokensExpr);

		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		if(retailStoreProvinceCenter.getVersion() != retailStoreProvinceCenterVersion){
			String message = "The target version("+retailStoreProvinceCenter.getVersion()+") is not equals to version("+retailStoreProvinceCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreProvinceCenter){
			//will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreProvinceCenter.

			retailStoreProvinceCenter.changeProperty(property, newValueExpr);
			retailStoreProvinceCenter.updateLastUpdateTime(userContext.now());
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
			//return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreProvinceCenterTokens tokens(){
		return RetailStoreProvinceCenterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreProvinceCenterTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProvinceCenterDepartmentListWith("id","desc")
		.sortProvinceCenterEmployeeListWith("id","desc")
		.sortRetailStoreCityServiceCenterListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreProvinceCenterTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCountry(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String anotherCountryId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCountryId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

 	}
 	public RetailStoreProvinceCenter transferToAnotherCountry(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String anotherCountryId) throws Exception
 	{
 		checkParamsForTransferingAnotherCountry(userContext, retailStoreProvinceCenterId,anotherCountryId);
 
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());	
		synchronized(retailStoreProvinceCenter){
			//will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter country = loadRetailStoreCountryCenter(userContext, anotherCountryId, emptyOptions());		
			retailStoreProvinceCenter.updateCountry(country);		
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, emptyOptions());
			
			return present(userContext,retailStoreProvinceCenter, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreCountryCenter requestCandidateCountry(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForRetailStoreProvinceCenter(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(YoubenbenUserContext userContext, String newCountryId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newCountryId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion) throws Exception {
		//deleteInternal(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion) throws Exception{

		retailStoreProvinceCenterDaoOf(userContext).delete(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
	}

	public RetailStoreProvinceCenter forgetByAll(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
	}
	protected RetailStoreProvinceCenter forgetByAllInternal(YoubenbenUserContext userContext,
			String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion) throws Exception{

		return retailStoreProvinceCenterDaoOf(userContext).disconnectFromAll(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreProvinceCenterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return retailStoreProvinceCenterDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreProvinceCenter with department in ProvinceCenterEmployee
	protected RetailStoreProvinceCenter breakWithProvinceCenterEmployeeByDepartment(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());

			synchronized(retailStoreProvinceCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreProvinceCenterDaoOf(userContext).planToRemoveProvinceCenterEmployeeListWithDepartment(retailStoreProvinceCenter, departmentId, this.emptyOptions());

				retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
				return retailStoreProvinceCenter;
			}
	}






	protected void checkParamsForAddingProvinceCenterDepartment(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String manager,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

		
		checkerOf(userContext).checkNameOfProvinceCenterDepartment(name);
		
		checkerOf(userContext).checkFoundedOfProvinceCenterDepartment(founded);
		
		checkerOf(userContext).checkManagerOfProvinceCenterDepartment(manager);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);


	}
	public  RetailStoreProvinceCenter addProvinceCenterDepartment(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String manager, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId,name, founded, manager,tokensExpr);

		ProvinceCenterDepartment provinceCenterDepartment = createProvinceCenterDepartment(userContext,name, founded, manager);

		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, emptyOptions());
		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.addProvinceCenterDepartment( provinceCenterDepartment );
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			
			userContext.getManagerGroup().getProvinceCenterDepartmentManager().onNewInstanceCreated(userContext, provinceCenterDepartment);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProvinceCenterDepartmentProperties(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,String id,String name,Date founded,String manager,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfProvinceCenterDepartment(id);

		checkerOf(userContext).checkNameOfProvinceCenterDepartment( name);
		checkerOf(userContext).checkFoundedOfProvinceCenterDepartment( founded);
		checkerOf(userContext).checkManagerOfProvinceCenterDepartment( manager);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter updateProvinceCenterDepartmentProperties(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String id,String name,Date founded,String manager, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProvinceCenterDepartmentProperties(userContext,retailStoreProvinceCenterId,id,name,founded,manager,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProvinceCenterDepartmentListList()
				.searchProvinceCenterDepartmentListWith(ProvinceCenterDepartment.ID_PROPERTY, "is", id).done();

		RetailStoreProvinceCenter retailStoreProvinceCenterToUpdate = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, options);

		if(retailStoreProvinceCenterToUpdate.getProvinceCenterDepartmentList().isEmpty()){
			throw new RetailStoreProvinceCenterManagerException("ProvinceCenterDepartment is NOT FOUND with id: '"+id+"'");
		}

		ProvinceCenterDepartment item = retailStoreProvinceCenterToUpdate.getProvinceCenterDepartmentList().first();

		item.updateName( name );
		item.updateFounded( founded );
		item.updateManager( manager );


		//checkParamsForAddingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId,name, code, used,tokensExpr);
		RetailStoreProvinceCenter retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterToUpdate, tokens().withProvinceCenterDepartmentList().done());
		synchronized(retailStoreProvinceCenter){
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected ProvinceCenterDepartment createProvinceCenterDepartment(YoubenbenUserContext userContext, String name, Date founded, String manager) throws Exception{

		ProvinceCenterDepartment provinceCenterDepartment = new ProvinceCenterDepartment();
		
		
		provinceCenterDepartment.setName(name);		
		provinceCenterDepartment.setFounded(founded);		
		provinceCenterDepartment.setManager(manager);
	
		
		return provinceCenterDepartment;


	}

	protected ProvinceCenterDepartment createIndexedProvinceCenterDepartment(String id, int version){

		ProvinceCenterDepartment provinceCenterDepartment = new ProvinceCenterDepartment();
		provinceCenterDepartment.setId(id);
		provinceCenterDepartment.setVersion(version);
		return provinceCenterDepartment;

	}

	protected void checkParamsForRemovingProvinceCenterDepartmentList(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
			String provinceCenterDepartmentIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		for(String provinceCenterDepartmentIdItem: provinceCenterDepartmentIds){
			checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter removeProvinceCenterDepartmentList(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
			String provinceCenterDepartmentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingProvinceCenterDepartmentList(userContext, retailStoreProvinceCenterId,  provinceCenterDepartmentIds, tokensExpr);


			RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
			synchronized(retailStoreProvinceCenter){
				//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreProvinceCenterDaoOf(userContext).planToRemoveProvinceCenterDepartmentList(retailStoreProvinceCenter, provinceCenterDepartmentIds, allTokens());
				retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
				deleteRelationListInGraph(userContext, retailStoreProvinceCenter.getProvinceCenterDepartmentList());
				return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingProvinceCenterDepartment(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		checkerOf(userContext).checkVersionOfProvinceCenterDepartment(provinceCenterDepartmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter removeProvinceCenterDepartment(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId, provinceCenterDepartmentId, provinceCenterDepartmentVersion,tokensExpr);

		ProvinceCenterDepartment provinceCenterDepartment = createIndexedProvinceCenterDepartment(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.removeProvinceCenterDepartment( provinceCenterDepartment );
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			deleteRelationInGraph(userContext, provinceCenterDepartment);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingProvinceCenterDepartment(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		checkerOf(userContext).checkVersionOfProvinceCenterDepartment(provinceCenterDepartmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter copyProvinceCenterDepartmentFrom(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId, provinceCenterDepartmentId, provinceCenterDepartmentVersion,tokensExpr);

		ProvinceCenterDepartment provinceCenterDepartment = createIndexedProvinceCenterDepartment(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreProvinceCenter.copyProvinceCenterDepartmentFrom( provinceCenterDepartment );
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			
			userContext.getManagerGroup().getProvinceCenterDepartmentManager().onNewInstanceCreated(userContext, (ProvinceCenterDepartment)retailStoreProvinceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingProvinceCenterDepartment(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		checkerOf(userContext).checkVersionOfProvinceCenterDepartment(provinceCenterDepartmentVersion);
		

		if(ProvinceCenterDepartment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfProvinceCenterDepartment(parseString(newValueExpr));
		
		}
		
		if(ProvinceCenterDepartment.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfProvinceCenterDepartment(parseDate(newValueExpr));
		
		}
		
		if(ProvinceCenterDepartment.MANAGER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkManagerOfProvinceCenterDepartment(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}

	public  RetailStoreProvinceCenter updateProvinceCenterDepartment(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingProvinceCenterDepartment(userContext, retailStoreProvinceCenterId, provinceCenterDepartmentId, provinceCenterDepartmentVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withProvinceCenterDepartmentList().searchProvinceCenterDepartmentListWith(ProvinceCenterDepartment.ID_PROPERTY, "eq", provinceCenterDepartmentId).done();



		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, loadTokens);

		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreProvinceCenter.removeProvinceCenterDepartment( provinceCenterDepartment );
			//make changes to AcceleraterAccount.
			ProvinceCenterDepartment provinceCenterDepartmentIndex = createIndexedProvinceCenterDepartment(provinceCenterDepartmentId, provinceCenterDepartmentVersion);

			ProvinceCenterDepartment provinceCenterDepartment = retailStoreProvinceCenter.findTheProvinceCenterDepartment(provinceCenterDepartmentIndex);
			if(provinceCenterDepartment == null){
				throw new RetailStoreProvinceCenterManagerException(provinceCenterDepartment+" is NOT FOUND" );
			}

			provinceCenterDepartment.changeProperty(property, newValueExpr);
			
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterDepartmentList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingProvinceCenterEmployee(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, String mobile, String email, Date founded, String departmentId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

		
		checkerOf(userContext).checkNameOfProvinceCenterEmployee(name);
		
		checkerOf(userContext).checkMobileOfProvinceCenterEmployee(mobile);
		
		checkerOf(userContext).checkEmailOfProvinceCenterEmployee(email);
		
		checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(founded);
		
		checkerOf(userContext).checkDepartmentIdOfProvinceCenterEmployee(departmentId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);


	}
	public  RetailStoreProvinceCenter addProvinceCenterEmployee(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, String mobile, String email, Date founded, String departmentId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId,name, mobile, email, founded, departmentId,tokensExpr);

		ProvinceCenterEmployee provinceCenterEmployee = createProvinceCenterEmployee(userContext,name, mobile, email, founded, departmentId);

		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, emptyOptions());
		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.addProvinceCenterEmployee( provinceCenterEmployee );
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			
			userContext.getManagerGroup().getProvinceCenterEmployeeManager().onNewInstanceCreated(userContext, provinceCenterEmployee);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProvinceCenterEmployeeProperties(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,String id,String name,String mobile,String email,Date founded,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfProvinceCenterEmployee(id);

		checkerOf(userContext).checkNameOfProvinceCenterEmployee( name);
		checkerOf(userContext).checkMobileOfProvinceCenterEmployee( mobile);
		checkerOf(userContext).checkEmailOfProvinceCenterEmployee( email);
		checkerOf(userContext).checkFoundedOfProvinceCenterEmployee( founded);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter updateProvinceCenterEmployeeProperties(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String id,String name,String mobile,String email,Date founded, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProvinceCenterEmployeeProperties(userContext,retailStoreProvinceCenterId,id,name,mobile,email,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProvinceCenterEmployeeListList()
				.searchProvinceCenterEmployeeListWith(ProvinceCenterEmployee.ID_PROPERTY, "is", id).done();

		RetailStoreProvinceCenter retailStoreProvinceCenterToUpdate = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, options);

		if(retailStoreProvinceCenterToUpdate.getProvinceCenterEmployeeList().isEmpty()){
			throw new RetailStoreProvinceCenterManagerException("ProvinceCenterEmployee is NOT FOUND with id: '"+id+"'");
		}

		ProvinceCenterEmployee item = retailStoreProvinceCenterToUpdate.getProvinceCenterEmployeeList().first();

		item.updateName( name );
		item.updateMobile( mobile );
		item.updateEmail( email );
		item.updateFounded( founded );


		//checkParamsForAddingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId,name, code, used,tokensExpr);
		RetailStoreProvinceCenter retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterToUpdate, tokens().withProvinceCenterEmployeeList().done());
		synchronized(retailStoreProvinceCenter){
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected ProvinceCenterEmployee createProvinceCenterEmployee(YoubenbenUserContext userContext, String name, String mobile, String email, Date founded, String departmentId) throws Exception{

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		
		
		provinceCenterEmployee.setName(name);		
		provinceCenterEmployee.setMobile(mobile);		
		provinceCenterEmployee.setEmail(email);		
		provinceCenterEmployee.setFounded(founded);		
		ProvinceCenterDepartment  department = new ProvinceCenterDepartment();
		department.setId(departmentId);		
		provinceCenterEmployee.setDepartment(department);
	
		
		return provinceCenterEmployee;


	}

	protected ProvinceCenterEmployee createIndexedProvinceCenterEmployee(String id, int version){

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		provinceCenterEmployee.setId(id);
		provinceCenterEmployee.setVersion(version);
		return provinceCenterEmployee;

	}

	protected void checkParamsForRemovingProvinceCenterEmployeeList(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
			String provinceCenterEmployeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		for(String provinceCenterEmployeeIdItem: provinceCenterEmployeeIds){
			checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter removeProvinceCenterEmployeeList(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
			String provinceCenterEmployeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingProvinceCenterEmployeeList(userContext, retailStoreProvinceCenterId,  provinceCenterEmployeeIds, tokensExpr);


			RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
			synchronized(retailStoreProvinceCenter){
				//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreProvinceCenterDaoOf(userContext).planToRemoveProvinceCenterEmployeeList(retailStoreProvinceCenter, provinceCenterEmployeeIds, allTokens());
				retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
				deleteRelationListInGraph(userContext, retailStoreProvinceCenter.getProvinceCenterEmployeeList());
				return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingProvinceCenterEmployee(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		checkerOf(userContext).checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter removeProvinceCenterEmployee(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);

		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.removeProvinceCenterEmployee( provinceCenterEmployee );
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			deleteRelationInGraph(userContext, provinceCenterEmployee);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingProvinceCenterEmployee(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		checkerOf(userContext).checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter copyProvinceCenterEmployeeFrom(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);

		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreProvinceCenter.copyProvinceCenterEmployeeFrom( provinceCenterEmployee );
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			
			userContext.getManagerGroup().getProvinceCenterEmployeeManager().onNewInstanceCreated(userContext, (ProvinceCenterEmployee)retailStoreProvinceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingProvinceCenterEmployee(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		checkerOf(userContext).checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);
		

		if(ProvinceCenterEmployee.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfProvinceCenterEmployee(parseString(newValueExpr));
		
		}
		
		if(ProvinceCenterEmployee.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfProvinceCenterEmployee(parseString(newValueExpr));
		
		}
		
		if(ProvinceCenterEmployee.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfProvinceCenterEmployee(parseString(newValueExpr));
		
		}
		
		if(ProvinceCenterEmployee.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}

	public  RetailStoreProvinceCenter updateProvinceCenterEmployee(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingProvinceCenterEmployee(userContext, retailStoreProvinceCenterId, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withProvinceCenterEmployeeList().searchProvinceCenterEmployeeListWith(ProvinceCenterEmployee.ID_PROPERTY, "eq", provinceCenterEmployeeId).done();



		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, loadTokens);

		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreProvinceCenter.removeProvinceCenterEmployee( provinceCenterEmployee );
			//make changes to AcceleraterAccount.
			ProvinceCenterEmployee provinceCenterEmployeeIndex = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);

			ProvinceCenterEmployee provinceCenterEmployee = retailStoreProvinceCenter.findTheProvinceCenterEmployee(provinceCenterEmployeeIndex);
			if(provinceCenterEmployee == null){
				throw new RetailStoreProvinceCenterManagerException(provinceCenterEmployee+" is NOT FOUND" );
			}

			provinceCenterEmployee.changeProperty(property, newValueExpr);
			
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

		
		checkerOf(userContext).checkNameOfRetailStoreCityServiceCenter(name);
		
		checkerOf(userContext).checkFoundedOfRetailStoreCityServiceCenter(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);


	}
	public  RetailStoreProvinceCenter addRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId,name, founded,tokensExpr);

		RetailStoreCityServiceCenter retailStoreCityServiceCenter = createRetailStoreCityServiceCenter(userContext,name, founded);

		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, emptyOptions());
		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.addRetailStoreCityServiceCenter( retailStoreCityServiceCenter );
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			
			userContext.getManagerGroup().getRetailStoreCityServiceCenterManager().onNewInstanceCreated(userContext, retailStoreCityServiceCenter);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreCityServiceCenterProperties(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,String id,String name,Date founded,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(id);

		checkerOf(userContext).checkNameOfRetailStoreCityServiceCenter( name);
		checkerOf(userContext).checkFoundedOfRetailStoreCityServiceCenter( founded);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter updateRetailStoreCityServiceCenterProperties(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String id,String name,Date founded, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreCityServiceCenterProperties(userContext,retailStoreProvinceCenterId,id,name,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreCityServiceCenterListList()
				.searchRetailStoreCityServiceCenterListWith(RetailStoreCityServiceCenter.ID_PROPERTY, "is", id).done();

		RetailStoreProvinceCenter retailStoreProvinceCenterToUpdate = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, options);

		if(retailStoreProvinceCenterToUpdate.getRetailStoreCityServiceCenterList().isEmpty()){
			throw new RetailStoreProvinceCenterManagerException("RetailStoreCityServiceCenter is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreCityServiceCenter item = retailStoreProvinceCenterToUpdate.getRetailStoreCityServiceCenterList().first();

		item.updateName( name );
		item.updateFounded( founded );


		//checkParamsForAddingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId,name, code, used,tokensExpr);
		RetailStoreProvinceCenter retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterToUpdate, tokens().withRetailStoreCityServiceCenterList().done());
		synchronized(retailStoreProvinceCenter){
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreCityServiceCenter createRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String name, Date founded) throws Exception{

		RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
		
		
		retailStoreCityServiceCenter.setName(name);		
		retailStoreCityServiceCenter.setFounded(founded);		
		retailStoreCityServiceCenter.setLastUpdateTime(userContext.now());
	
		
		return retailStoreCityServiceCenter;


	}

	protected RetailStoreCityServiceCenter createIndexedRetailStoreCityServiceCenter(String id, int version){

		RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
		retailStoreCityServiceCenter.setId(id);
		retailStoreCityServiceCenter.setVersion(version);
		return retailStoreCityServiceCenter;

	}

	protected void checkParamsForRemovingRetailStoreCityServiceCenterList(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
			String retailStoreCityServiceCenterIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		for(String retailStoreCityServiceCenterIdItem: retailStoreCityServiceCenterIds){
			checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter removeRetailStoreCityServiceCenterList(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
			String retailStoreCityServiceCenterIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreCityServiceCenterList(userContext, retailStoreProvinceCenterId,  retailStoreCityServiceCenterIds, tokensExpr);


			RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
			synchronized(retailStoreProvinceCenter){
				//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreProvinceCenterDaoOf(userContext).planToRemoveRetailStoreCityServiceCenterList(retailStoreProvinceCenter, retailStoreCityServiceCenterIds, allTokens());
				retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
				deleteRelationListInGraph(userContext, retailStoreProvinceCenter.getRetailStoreCityServiceCenterList());
				return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
		checkerOf(userContext).checkVersionOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter removeRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion,tokensExpr);

		RetailStoreCityServiceCenter retailStoreCityServiceCenter = createIndexedRetailStoreCityServiceCenter(retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreProvinceCenter.removeRetailStoreCityServiceCenter( retailStoreCityServiceCenter );
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			deleteRelationInGraph(userContext, retailStoreCityServiceCenter);
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter( retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
		checkerOf(userContext).checkVersionOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}
	public  RetailStoreProvinceCenter copyRetailStoreCityServiceCenterFrom(YoubenbenUserContext userContext, String retailStoreProvinceCenterId,
		String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion,tokensExpr);

		RetailStoreCityServiceCenter retailStoreCityServiceCenter = createIndexedRetailStoreCityServiceCenter(retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStoreCityServiceCenter.updateLastUpdateTime(userContext.now());

			retailStoreProvinceCenter.copyRetailStoreCityServiceCenterFrom( retailStoreCityServiceCenter );
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			
			userContext.getManagerGroup().getRetailStoreCityServiceCenterManager().onNewInstanceCreated(userContext, (RetailStoreCityServiceCenter)retailStoreProvinceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
		checkerOf(userContext).checkVersionOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterVersion);
		

		if(RetailStoreCityServiceCenter.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreCityServiceCenter(parseString(newValueExpr));
		
		}
		
		if(RetailStoreCityServiceCenter.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfRetailStoreCityServiceCenter(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

	}

	public  RetailStoreProvinceCenter updateRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreCityServiceCenter(userContext, retailStoreProvinceCenterId, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreCityServiceCenterList().searchRetailStoreCityServiceCenterListWith(RetailStoreCityServiceCenter.ID_PROPERTY, "eq", retailStoreCityServiceCenterId).done();



		RetailStoreProvinceCenter retailStoreProvinceCenter = loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, loadTokens);

		synchronized(retailStoreProvinceCenter){
			//Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreProvinceCenter.removeRetailStoreCityServiceCenter( retailStoreCityServiceCenter );
			//make changes to AcceleraterAccount.
			RetailStoreCityServiceCenter retailStoreCityServiceCenterIndex = createIndexedRetailStoreCityServiceCenter(retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);

			RetailStoreCityServiceCenter retailStoreCityServiceCenter = retailStoreProvinceCenter.findTheRetailStoreCityServiceCenter(retailStoreCityServiceCenterIndex);
			if(retailStoreCityServiceCenter == null){
				throw new RetailStoreProvinceCenterManagerException(retailStoreCityServiceCenter+" is NOT FOUND" );
			}

			retailStoreCityServiceCenter.changeProperty(property, newValueExpr);
			retailStoreCityServiceCenter.updateLastUpdateTime(userContext.now());
			retailStoreProvinceCenter = saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().withRetailStoreCityServiceCenterList().done());
			return present(userContext,retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreProvinceCenter newCreated) throws Exception{
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
		//   RetailStoreProvinceCenter newRetailStoreProvinceCenter = this.createRetailStoreProvinceCenter(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreProvinceCenter
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreProvinceCenter.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<RetailStoreProvinceCenter> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> countryList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(countryList, RetailStoreCountryCenter.class);


    }
	
	public Object listByCountry(YoubenbenUserContext userContext,String countryId) throws Exception {
		return listPageByCountry(userContext, countryId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCountry(YoubenbenUserContext userContext,String countryId, int start, int count) throws Exception {
		SmartList<RetailStoreProvinceCenter> list = retailStoreProvinceCenterDaoOf(userContext).findRetailStoreProvinceCenterByCountry(countryId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(RetailStoreProvinceCenter.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(countryId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超省中心列表");
		page.setRequestName("listByCountry");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCountry/%s/",  getBeanName(), countryId)));

		page.assemblerContent(userContext, "listByCountry");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String retailStoreProvinceCenterId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getRetailStoreProvinceCenterDetailScope().clone();
		RetailStoreProvinceCenter merchantObj = (RetailStoreProvinceCenter) this.view(userContext, retailStoreProvinceCenterId);
    String merchantObjId = retailStoreProvinceCenterId;
    String linkToUrl =	"retailStoreProvinceCenterManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "双链小超省中心"+"详情";
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
				MapUtil.put("id", "4-country")
				    .put("fieldName", "country")
				    .put("label", "国")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("country", merchantObj.getCountry());

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

		//处理Section：provinceCenterEmployeeListSection
		Map provinceCenterEmployeeListSection = ListofUtils.buildSection(
		    "provinceCenterEmployeeListSection",
		    "省中心员工名单",
		    null,
		    "",
		    "__no_group",
		    "provinceCenterEmployeeManager/listByProvinceCenter/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(provinceCenterEmployeeListSection);

		result.put("provinceCenterEmployeeListSection", ListofUtils.toShortList(merchantObj.getProvinceCenterEmployeeList(), "provinceCenterEmployee"));
		vscope.field("provinceCenterEmployeeListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( ProvinceCenterEmployee.class.getName(), null));

		//处理Section：retailStoreCityServiceCenterListSection
		Map retailStoreCityServiceCenterListSection = ListofUtils.buildSection(
		    "retailStoreCityServiceCenterListSection",
		    "零售门店城市服务中心名单",
		    null,
		    "",
		    "__no_group",
		    "retailStoreCityServiceCenterManager/listByBelongsTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreCityServiceCenterListSection);

		result.put("retailStoreCityServiceCenterListSection", ListofUtils.toShortList(merchantObj.getRetailStoreCityServiceCenterList(), "retailStoreCityServiceCenter"));
		vscope.field("retailStoreCityServiceCenterListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( RetailStoreCityServiceCenter.class.getName(), null));

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


