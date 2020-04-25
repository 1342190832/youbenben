
package com.youbenben.youbenben.franchisedoutletcityservicecenter;

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


import com.youbenben.youbenben.potentialcustomer.PotentialCustomer;
import com.youbenben.youbenben.citypartner.CityPartner;
import com.youbenben.youbenben.cityevent.CityEvent;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;

import com.youbenben.youbenben.franchisedoutletcitycenter.CandidateFranchisedOutletCityCenter;

import com.youbenben.youbenben.citypartner.CityPartner;
import com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenter;






public class FranchisedOutletCityServiceCenterManagerImpl extends CustomYoubenbenCheckerManager implements FranchisedOutletCityServiceCenterManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = FranchisedOutletCityServiceCenterTokens.start().withTokenFromListName(listName).done();
		FranchisedOutletCityServiceCenter  franchisedOutletCityServiceCenter = (FranchisedOutletCityServiceCenter) this.loadFranchisedOutletCityServiceCenter(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = franchisedOutletCityServiceCenter.collectRefercencesFromLists();
		franchisedOutletCityServiceCenterDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, franchisedOutletCityServiceCenter, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new FranchisedOutletCityServiceCenterGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "FranchisedOutletCityServiceCenter";
	@Override
	public FranchisedOutletCityServiceCenterDAO daoOf(YoubenbenUserContext userContext) {
		return franchisedOutletCityServiceCenterDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws FranchisedOutletCityServiceCenterManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new FranchisedOutletCityServiceCenterManagerException(message);

	}



 	protected FranchisedOutletCityServiceCenter saveFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, String [] tokensExpr) throws Exception{	
 		//return getFranchisedOutletCityServiceCenterDAO().save(franchisedOutletCityServiceCenter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens);
 	}
 	
 	protected FranchisedOutletCityServiceCenter saveFranchisedOutletCityServiceCenterDetail(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter) throws Exception{	

 		
 		return saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, allTokens());
 	}
 	
 	public FranchisedOutletCityServiceCenter loadFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( FranchisedOutletCityServiceCenterManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter( userContext, franchisedOutletCityServiceCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,franchisedOutletCityServiceCenter, tokens);
 	}
 	
 	
 	 public FranchisedOutletCityServiceCenter searchFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( FranchisedOutletCityServiceCenterManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter( userContext, franchisedOutletCityServiceCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,franchisedOutletCityServiceCenter, tokens);
 	}
 	
 	

 	protected FranchisedOutletCityServiceCenter present(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,franchisedOutletCityServiceCenter,tokens);
		
		
		FranchisedOutletCityServiceCenter  franchisedOutletCityServiceCenterToPresent = franchisedOutletCityServiceCenterDaoOf(userContext).present(franchisedOutletCityServiceCenter, tokens);
		
		List<BaseEntity> entityListToNaming = franchisedOutletCityServiceCenterToPresent.collectRefercencesFromLists();
		franchisedOutletCityServiceCenterDaoOf(userContext).alias(entityListToNaming);
		
		return  franchisedOutletCityServiceCenterToPresent;
		
		
	}
 
 	
 	
 	public FranchisedOutletCityServiceCenter loadFranchisedOutletCityServiceCenterDetail(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId) throws Exception{	
 		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter( userContext, franchisedOutletCityServiceCenterId, allTokens());
 		return present(userContext,franchisedOutletCityServiceCenter, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId) throws Exception{	
 		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter( userContext, franchisedOutletCityServiceCenterId, viewTokens());
 		return present(userContext,franchisedOutletCityServiceCenter, allTokens());
		
 	}
 	protected FranchisedOutletCityServiceCenter saveFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object>tokens) throws Exception{	
 		return franchisedOutletCityServiceCenterDaoOf(userContext).save(franchisedOutletCityServiceCenter, tokens);
 	}
 	protected FranchisedOutletCityServiceCenter loadFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( FranchisedOutletCityServiceCenterManagerException.class);

 
 		return franchisedOutletCityServiceCenterDaoOf(userContext).load(franchisedOutletCityServiceCenterId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String, Object> tokens){
		super.addActions(userContext, franchisedOutletCityServiceCenter, tokens);
		
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"@create","createFranchisedOutletCityServiceCenter","createFranchisedOutletCityServiceCenter/","main","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"@update","updateFranchisedOutletCityServiceCenter","updateFranchisedOutletCityServiceCenter/"+franchisedOutletCityServiceCenter.getId()+"/","main","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"@copy","cloneFranchisedOutletCityServiceCenter","cloneFranchisedOutletCityServiceCenter/"+franchisedOutletCityServiceCenter.getId()+"/","main","primary");
		
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+franchisedOutletCityServiceCenter.getId()+"/","main","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.addCityPartner","addCityPartner","addCityPartner/"+franchisedOutletCityServiceCenter.getId()+"/","cityPartnerList","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.removeCityPartner","removeCityPartner","removeCityPartner/"+franchisedOutletCityServiceCenter.getId()+"/","cityPartnerList","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.updateCityPartner","updateCityPartner","updateCityPartner/"+franchisedOutletCityServiceCenter.getId()+"/","cityPartnerList","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.copyCityPartnerFrom","copyCityPartnerFrom","copyCityPartnerFrom/"+franchisedOutletCityServiceCenter.getId()+"/","cityPartnerList","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.addPotentialCustomer","addPotentialCustomer","addPotentialCustomer/"+franchisedOutletCityServiceCenter.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.removePotentialCustomer","removePotentialCustomer","removePotentialCustomer/"+franchisedOutletCityServiceCenter.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.updatePotentialCustomer","updatePotentialCustomer","updatePotentialCustomer/"+franchisedOutletCityServiceCenter.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.copyPotentialCustomerFrom","copyPotentialCustomerFrom","copyPotentialCustomerFrom/"+franchisedOutletCityServiceCenter.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.addCityEvent","addCityEvent","addCityEvent/"+franchisedOutletCityServiceCenter.getId()+"/","cityEventList","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.removeCityEvent","removeCityEvent","removeCityEvent/"+franchisedOutletCityServiceCenter.getId()+"/","cityEventList","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.updateCityEvent","updateCityEvent","updateCityEvent/"+franchisedOutletCityServiceCenter.getId()+"/","cityEventList","primary");
		addAction(userContext, franchisedOutletCityServiceCenter, tokens,"franchised_outlet_city_service_center.copyCityEventFrom","copyCityEventFrom","copyCityEventFrom/"+franchisedOutletCityServiceCenter.getId()+"/","cityEventList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public FranchisedOutletCityServiceCenter createFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String name,Date founded,String belongsToId) throws Exception
	//public FranchisedOutletCityServiceCenter createFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext,String name, Date founded, String belongsToId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfFranchisedOutletCityServiceCenter(name);
		checkerOf(userContext).checkFoundedOfFranchisedOutletCityServiceCenter(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);


		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter=createNewFranchisedOutletCityServiceCenter();	

		franchisedOutletCityServiceCenter.setName(name);
		franchisedOutletCityServiceCenter.setFounded(founded);
			
		FranchisedOutletCityCenter belongsTo = loadFranchisedOutletCityCenter(userContext, belongsToId,emptyOptions());
		franchisedOutletCityServiceCenter.setBelongsTo(belongsTo);
		
		
		franchisedOutletCityServiceCenter.setLastUpdateTime(userContext.now());

		franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, emptyOptions());
		
		onNewInstanceCreated(userContext, franchisedOutletCityServiceCenter);
		return franchisedOutletCityServiceCenter;


	}
	protected FranchisedOutletCityServiceCenter createNewFranchisedOutletCityServiceCenter()
	{

		return new FranchisedOutletCityServiceCenter();
	}

	protected void checkParamsForUpdatingFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext,String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkVersionOfFranchisedOutletCityServiceCenter( franchisedOutletCityServiceCenterVersion);
		

		if(FranchisedOutletCityServiceCenter.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfFranchisedOutletCityServiceCenter(parseString(newValueExpr));
		
			
		}
		if(FranchisedOutletCityServiceCenter.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfFranchisedOutletCityServiceCenter(parseDate(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);


	}



	public FranchisedOutletCityServiceCenter clone(YoubenbenUserContext userContext, String fromFranchisedOutletCityServiceCenterId) throws Exception{

		return franchisedOutletCityServiceCenterDaoOf(userContext).clone(fromFranchisedOutletCityServiceCenterId, this.allTokens());
	}

	public FranchisedOutletCityServiceCenter internalSaveFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter) throws Exception
	{
		return internalSaveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, allTokens());

	}
	public FranchisedOutletCityServiceCenter internalSaveFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion, property, newValueExpr, tokensExpr);


		synchronized(franchisedOutletCityServiceCenter){
			//will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FranchisedOutletCityServiceCenter.
			if (franchisedOutletCityServiceCenter.isChanged()){
			franchisedOutletCityServiceCenter.updateLastUpdateTime(userContext.now());
			}
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, options);
			return franchisedOutletCityServiceCenter;

		}

	}

	public FranchisedOutletCityServiceCenter updateFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext,String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion, property, newValueExpr, tokensExpr);



		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());
		if(franchisedOutletCityServiceCenter.getVersion() != franchisedOutletCityServiceCenterVersion){
			String message = "The target version("+franchisedOutletCityServiceCenter.getVersion()+") is not equals to version("+franchisedOutletCityServiceCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(franchisedOutletCityServiceCenter){
			//will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FranchisedOutletCityServiceCenter.
			franchisedOutletCityServiceCenter.updateLastUpdateTime(userContext.now());
			franchisedOutletCityServiceCenter.changeProperty(property, newValueExpr);
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().done());
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
			//return saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().done());
		}

	}

	public FranchisedOutletCityServiceCenter updateFranchisedOutletCityServiceCenterProperty(YoubenbenUserContext userContext,String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion, property, newValueExpr, tokensExpr);

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());
		if(franchisedOutletCityServiceCenter.getVersion() != franchisedOutletCityServiceCenterVersion){
			String message = "The target version("+franchisedOutletCityServiceCenter.getVersion()+") is not equals to version("+franchisedOutletCityServiceCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(franchisedOutletCityServiceCenter){
			//will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FranchisedOutletCityServiceCenter.

			franchisedOutletCityServiceCenter.changeProperty(property, newValueExpr);
			franchisedOutletCityServiceCenter.updateLastUpdateTime(userContext.now());
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().done());
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
			//return saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected FranchisedOutletCityServiceCenterTokens tokens(){
		return FranchisedOutletCityServiceCenterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FranchisedOutletCityServiceCenterTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCityPartnerListWith("id","desc")
		.sortPotentialCustomerListWith("id","desc")
		.sortCityEventListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FranchisedOutletCityServiceCenterTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String anotherBelongsToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
 		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(anotherBelongsToId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

 	}
 	public FranchisedOutletCityServiceCenter transferToAnotherBelongsTo(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, franchisedOutletCityServiceCenterId,anotherBelongsToId);
 
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());	
		synchronized(franchisedOutletCityServiceCenter){
			//will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			FranchisedOutletCityCenter belongsTo = loadFranchisedOutletCityCenter(userContext, anotherBelongsToId, emptyOptions());		
			franchisedOutletCityServiceCenter.updateBelongsTo(belongsTo);		
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, emptyOptions());
			
			return present(userContext,franchisedOutletCityServiceCenter, allTokens());
			
		}

 	}

	


	public CandidateFranchisedOutletCityCenter requestCandidateBelongsTo(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<FranchisedOutletCityCenter> candidateList = franchisedOutletCityCenterDaoOf(userContext).requestCandidateFranchisedOutletCityCenterForFranchisedOutletCityServiceCenter(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected FranchisedOutletCityCenter loadFranchisedOutletCityCenter(YoubenbenUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{

 		return franchisedOutletCityCenterDaoOf(userContext).load(newBelongsToId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion) throws Exception {
		//deleteInternal(userContext, franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion) throws Exception{

		franchisedOutletCityServiceCenterDaoOf(userContext).delete(franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion);
	}

	public FranchisedOutletCityServiceCenter forgetByAll(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion) throws Exception {
		return forgetByAllInternal(userContext, franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion);
	}
	protected FranchisedOutletCityServiceCenter forgetByAllInternal(YoubenbenUserContext userContext,
			String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion) throws Exception{

		return franchisedOutletCityServiceCenterDaoOf(userContext).disconnectFromAll(franchisedOutletCityServiceCenterId, franchisedOutletCityServiceCenterVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FranchisedOutletCityServiceCenterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return franchisedOutletCityServiceCenterDaoOf(userContext).deleteAll();
	}


	//disconnect FranchisedOutletCityServiceCenter with city_partner in PotentialCustomer
	protected FranchisedOutletCityServiceCenter breakWithPotentialCustomerByCityPartner(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String cityPartnerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());

			synchronized(franchisedOutletCityServiceCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				franchisedOutletCityServiceCenterDaoOf(userContext).planToRemovePotentialCustomerListWithCityPartner(franchisedOutletCityServiceCenter, cityPartnerId, this.emptyOptions());

				franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withPotentialCustomerList().done());
				return franchisedOutletCityServiceCenter;
			}
	}






	protected void checkParamsForAddingCityPartner(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);

		
		checkerOf(userContext).checkNameOfCityPartner(name);
		
		checkerOf(userContext).checkMobileOfCityPartner(mobile);
		
		checkerOf(userContext).checkDescriptionOfCityPartner(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);


	}
	public  FranchisedOutletCityServiceCenter addCityPartner(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCityPartner(userContext,franchisedOutletCityServiceCenterId,name, mobile, description,tokensExpr);

		CityPartner cityPartner = createCityPartner(userContext,name, mobile, description);

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, emptyOptions());
		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityServiceCenter.addCityPartner( cityPartner );
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withCityPartnerList().done());
			
			userContext.getManagerGroup().getCityPartnerManager().onNewInstanceCreated(userContext, cityPartner);
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCityPartnerProperties(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,String id,String name,String mobile,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfCityPartner(id);

		checkerOf(userContext).checkNameOfCityPartner( name);
		checkerOf(userContext).checkMobileOfCityPartner( mobile);
		checkerOf(userContext).checkDescriptionOfCityPartner( description);

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter updateCityPartnerProperties(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String id,String name,String mobile,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityPartnerProperties(userContext,franchisedOutletCityServiceCenterId,id,name,mobile,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCityPartnerListList()
				.searchCityPartnerListWith(CityPartner.ID_PROPERTY, "is", id).done();

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenterToUpdate = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, options);

		if(franchisedOutletCityServiceCenterToUpdate.getCityPartnerList().isEmpty()){
			throw new FranchisedOutletCityServiceCenterManagerException("CityPartner is NOT FOUND with id: '"+id+"'");
		}

		CityPartner item = franchisedOutletCityServiceCenterToUpdate.getCityPartnerList().first();

		item.updateName( name );
		item.updateMobile( mobile );
		item.updateDescription( description );


		//checkParamsForAddingCityPartner(userContext,franchisedOutletCityServiceCenterId,name, code, used,tokensExpr);
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterToUpdate, tokens().withCityPartnerList().done());
		synchronized(franchisedOutletCityServiceCenter){
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected CityPartner createCityPartner(YoubenbenUserContext userContext, String name, String mobile, String description) throws Exception{

		CityPartner cityPartner = new CityPartner();
		
		
		cityPartner.setName(name);		
		cityPartner.setMobile(mobile);		
		cityPartner.setDescription(description);		
		cityPartner.setLastUpdateTime(userContext.now());
	
		
		return cityPartner;


	}

	protected CityPartner createIndexedCityPartner(String id, int version){

		CityPartner cityPartner = new CityPartner();
		cityPartner.setId(id);
		cityPartner.setVersion(version);
		return cityPartner;

	}

	protected void checkParamsForRemovingCityPartnerList(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
			String cityPartnerIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		for(String cityPartnerIdItem: cityPartnerIds){
			checkerOf(userContext).checkIdOfCityPartner(cityPartnerIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter removeCityPartnerList(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
			String cityPartnerIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCityPartnerList(userContext, franchisedOutletCityServiceCenterId,  cityPartnerIds, tokensExpr);


			FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());
			synchronized(franchisedOutletCityServiceCenter){
				//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				franchisedOutletCityServiceCenterDaoOf(userContext).planToRemoveCityPartnerList(franchisedOutletCityServiceCenter, cityPartnerIds, allTokens());
				franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withCityPartnerList().done());
				deleteRelationListInGraph(userContext, franchisedOutletCityServiceCenter.getCityPartnerList());
				return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCityPartner(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String cityPartnerId, int cityPartnerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter( franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		checkerOf(userContext).checkVersionOfCityPartner(cityPartnerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter removeCityPartner(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String cityPartnerId, int cityPartnerVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingCityPartner(userContext,franchisedOutletCityServiceCenterId, cityPartnerId, cityPartnerVersion,tokensExpr);

		CityPartner cityPartner = createIndexedCityPartner(cityPartnerId, cityPartnerVersion);
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());
		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityServiceCenter.removeCityPartner( cityPartner );
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withCityPartnerList().done());
			deleteRelationInGraph(userContext, cityPartner);
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingCityPartner(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String cityPartnerId, int cityPartnerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter( franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		checkerOf(userContext).checkVersionOfCityPartner(cityPartnerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter copyCityPartnerFrom(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String cityPartnerId, int cityPartnerVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingCityPartner(userContext,franchisedOutletCityServiceCenterId, cityPartnerId, cityPartnerVersion,tokensExpr);

		CityPartner cityPartner = createIndexedCityPartner(cityPartnerId, cityPartnerVersion);
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());
		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			cityPartner.updateLastUpdateTime(userContext.now());

			franchisedOutletCityServiceCenter.copyCityPartnerFrom( cityPartner );
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withCityPartnerList().done());
			
			userContext.getManagerGroup().getCityPartnerManager().onNewInstanceCreated(userContext, (CityPartner)franchisedOutletCityServiceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCityPartner(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		checkerOf(userContext).checkVersionOfCityPartner(cityPartnerVersion);
		

		if(CityPartner.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCityPartner(parseString(newValueExpr));
		
		}
		
		if(CityPartner.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfCityPartner(parseString(newValueExpr));
		
		}
		
		if(CityPartner.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfCityPartner(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}

	public  FranchisedOutletCityServiceCenter updateCityPartner(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCityPartner(userContext, franchisedOutletCityServiceCenterId, cityPartnerId, cityPartnerVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCityPartnerList().searchCityPartnerListWith(CityPartner.ID_PROPERTY, "eq", cityPartnerId).done();



		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, loadTokens);

		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//franchisedOutletCityServiceCenter.removeCityPartner( cityPartner );
			//make changes to AcceleraterAccount.
			CityPartner cityPartnerIndex = createIndexedCityPartner(cityPartnerId, cityPartnerVersion);

			CityPartner cityPartner = franchisedOutletCityServiceCenter.findTheCityPartner(cityPartnerIndex);
			if(cityPartner == null){
				throw new FranchisedOutletCityServiceCenterManagerException(cityPartner+" is NOT FOUND" );
			}

			cityPartner.changeProperty(property, newValueExpr);
			cityPartner.updateLastUpdateTime(userContext.now());
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withCityPartnerList().done());
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingPotentialCustomer(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String cityPartnerId, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);

		
		checkerOf(userContext).checkNameOfPotentialCustomer(name);
		
		checkerOf(userContext).checkMobileOfPotentialCustomer(mobile);
		
		checkerOf(userContext).checkCityPartnerIdOfPotentialCustomer(cityPartnerId);
		
		checkerOf(userContext).checkDescriptionOfPotentialCustomer(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);


	}
	public  FranchisedOutletCityServiceCenter addPotentialCustomer(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String cityPartnerId, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingPotentialCustomer(userContext,franchisedOutletCityServiceCenterId,name, mobile, cityPartnerId, description,tokensExpr);

		PotentialCustomer potentialCustomer = createPotentialCustomer(userContext,name, mobile, cityPartnerId, description);

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, emptyOptions());
		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityServiceCenter.addPotentialCustomer( potentialCustomer );
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withPotentialCustomerList().done());
			
			userContext.getManagerGroup().getPotentialCustomerManager().onNewInstanceCreated(userContext, potentialCustomer);
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPotentialCustomerProperties(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,String id,String name,String mobile,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfPotentialCustomer(id);

		checkerOf(userContext).checkNameOfPotentialCustomer( name);
		checkerOf(userContext).checkMobileOfPotentialCustomer( mobile);
		checkerOf(userContext).checkDescriptionOfPotentialCustomer( description);

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter updatePotentialCustomerProperties(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String id,String name,String mobile,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPotentialCustomerProperties(userContext,franchisedOutletCityServiceCenterId,id,name,mobile,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPotentialCustomerListList()
				.searchPotentialCustomerListWith(PotentialCustomer.ID_PROPERTY, "is", id).done();

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenterToUpdate = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, options);

		if(franchisedOutletCityServiceCenterToUpdate.getPotentialCustomerList().isEmpty()){
			throw new FranchisedOutletCityServiceCenterManagerException("PotentialCustomer is NOT FOUND with id: '"+id+"'");
		}

		PotentialCustomer item = franchisedOutletCityServiceCenterToUpdate.getPotentialCustomerList().first();

		item.updateName( name );
		item.updateMobile( mobile );
		item.updateDescription( description );


		//checkParamsForAddingPotentialCustomer(userContext,franchisedOutletCityServiceCenterId,name, code, used,tokensExpr);
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterToUpdate, tokens().withPotentialCustomerList().done());
		synchronized(franchisedOutletCityServiceCenter){
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected PotentialCustomer createPotentialCustomer(YoubenbenUserContext userContext, String name, String mobile, String cityPartnerId, String description) throws Exception{

		PotentialCustomer potentialCustomer = new PotentialCustomer();
		
		
		potentialCustomer.setName(name);		
		potentialCustomer.setMobile(mobile);		
		CityPartner  cityPartner = new CityPartner();
		cityPartner.setId(cityPartnerId);		
		potentialCustomer.setCityPartner(cityPartner);		
		potentialCustomer.setDescription(description);		
		potentialCustomer.setLastUpdateTime(userContext.now());
	
		
		return potentialCustomer;


	}

	protected PotentialCustomer createIndexedPotentialCustomer(String id, int version){

		PotentialCustomer potentialCustomer = new PotentialCustomer();
		potentialCustomer.setId(id);
		potentialCustomer.setVersion(version);
		return potentialCustomer;

	}

	protected void checkParamsForRemovingPotentialCustomerList(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
			String potentialCustomerIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		for(String potentialCustomerIdItem: potentialCustomerIds){
			checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter removePotentialCustomerList(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
			String potentialCustomerIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingPotentialCustomerList(userContext, franchisedOutletCityServiceCenterId,  potentialCustomerIds, tokensExpr);


			FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());
			synchronized(franchisedOutletCityServiceCenter){
				//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				franchisedOutletCityServiceCenterDaoOf(userContext).planToRemovePotentialCustomerList(franchisedOutletCityServiceCenter, potentialCustomerIds, allTokens());
				franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withPotentialCustomerList().done());
				deleteRelationListInGraph(userContext, franchisedOutletCityServiceCenter.getPotentialCustomerList());
				return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingPotentialCustomer(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter( franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerId);
		checkerOf(userContext).checkVersionOfPotentialCustomer(potentialCustomerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter removePotentialCustomer(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingPotentialCustomer(userContext,franchisedOutletCityServiceCenterId, potentialCustomerId, potentialCustomerVersion,tokensExpr);

		PotentialCustomer potentialCustomer = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());
		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityServiceCenter.removePotentialCustomer( potentialCustomer );
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withPotentialCustomerList().done());
			deleteRelationInGraph(userContext, potentialCustomer);
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingPotentialCustomer(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter( franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerId);
		checkerOf(userContext).checkVersionOfPotentialCustomer(potentialCustomerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter copyPotentialCustomerFrom(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingPotentialCustomer(userContext,franchisedOutletCityServiceCenterId, potentialCustomerId, potentialCustomerVersion,tokensExpr);

		PotentialCustomer potentialCustomer = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());
		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			potentialCustomer.updateLastUpdateTime(userContext.now());

			franchisedOutletCityServiceCenter.copyPotentialCustomerFrom( potentialCustomer );
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withPotentialCustomerList().done());
			
			userContext.getManagerGroup().getPotentialCustomerManager().onNewInstanceCreated(userContext, (PotentialCustomer)franchisedOutletCityServiceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingPotentialCustomer(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerId);
		checkerOf(userContext).checkVersionOfPotentialCustomer(potentialCustomerVersion);
		

		if(PotentialCustomer.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfPotentialCustomer(parseString(newValueExpr));
		
		}
		
		if(PotentialCustomer.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfPotentialCustomer(parseString(newValueExpr));
		
		}
		
		if(PotentialCustomer.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfPotentialCustomer(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}

	public  FranchisedOutletCityServiceCenter updatePotentialCustomer(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingPotentialCustomer(userContext, franchisedOutletCityServiceCenterId, potentialCustomerId, potentialCustomerVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withPotentialCustomerList().searchPotentialCustomerListWith(PotentialCustomer.ID_PROPERTY, "eq", potentialCustomerId).done();



		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, loadTokens);

		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//franchisedOutletCityServiceCenter.removePotentialCustomer( potentialCustomer );
			//make changes to AcceleraterAccount.
			PotentialCustomer potentialCustomerIndex = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);

			PotentialCustomer potentialCustomer = franchisedOutletCityServiceCenter.findThePotentialCustomer(potentialCustomerIndex);
			if(potentialCustomer == null){
				throw new FranchisedOutletCityServiceCenterManagerException(potentialCustomer+" is NOT FOUND" );
			}

			potentialCustomer.changeProperty(property, newValueExpr);
			potentialCustomer.updateLastUpdateTime(userContext.now());
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withPotentialCustomerList().done());
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingCityEvent(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);

		
		checkerOf(userContext).checkNameOfCityEvent(name);
		
		checkerOf(userContext).checkMobileOfCityEvent(mobile);
		
		checkerOf(userContext).checkDescriptionOfCityEvent(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);


	}
	public  FranchisedOutletCityServiceCenter addCityEvent(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCityEvent(userContext,franchisedOutletCityServiceCenterId,name, mobile, description,tokensExpr);

		CityEvent cityEvent = createCityEvent(userContext,name, mobile, description);

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, emptyOptions());
		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityServiceCenter.addCityEvent( cityEvent );
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withCityEventList().done());
			
			userContext.getManagerGroup().getCityEventManager().onNewInstanceCreated(userContext, cityEvent);
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCityEventProperties(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,String id,String name,String mobile,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfCityEvent(id);

		checkerOf(userContext).checkNameOfCityEvent( name);
		checkerOf(userContext).checkMobileOfCityEvent( mobile);
		checkerOf(userContext).checkDescriptionOfCityEvent( description);

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter updateCityEventProperties(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String id,String name,String mobile,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityEventProperties(userContext,franchisedOutletCityServiceCenterId,id,name,mobile,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCityEventListList()
				.searchCityEventListWith(CityEvent.ID_PROPERTY, "is", id).done();

		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenterToUpdate = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, options);

		if(franchisedOutletCityServiceCenterToUpdate.getCityEventList().isEmpty()){
			throw new FranchisedOutletCityServiceCenterManagerException("CityEvent is NOT FOUND with id: '"+id+"'");
		}

		CityEvent item = franchisedOutletCityServiceCenterToUpdate.getCityEventList().first();

		item.updateName( name );
		item.updateMobile( mobile );
		item.updateDescription( description );


		//checkParamsForAddingCityEvent(userContext,franchisedOutletCityServiceCenterId,name, code, used,tokensExpr);
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterToUpdate, tokens().withCityEventList().done());
		synchronized(franchisedOutletCityServiceCenter){
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected CityEvent createCityEvent(YoubenbenUserContext userContext, String name, String mobile, String description) throws Exception{

		CityEvent cityEvent = new CityEvent();
		
		
		cityEvent.setName(name);		
		cityEvent.setMobile(mobile);		
		cityEvent.setDescription(description);		
		cityEvent.setLastUpdateTime(userContext.now());
	
		
		return cityEvent;


	}

	protected CityEvent createIndexedCityEvent(String id, int version){

		CityEvent cityEvent = new CityEvent();
		cityEvent.setId(id);
		cityEvent.setVersion(version);
		return cityEvent;

	}

	protected void checkParamsForRemovingCityEventList(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
			String cityEventIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		for(String cityEventIdItem: cityEventIds){
			checkerOf(userContext).checkIdOfCityEvent(cityEventIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter removeCityEventList(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
			String cityEventIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCityEventList(userContext, franchisedOutletCityServiceCenterId,  cityEventIds, tokensExpr);


			FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());
			synchronized(franchisedOutletCityServiceCenter){
				//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				franchisedOutletCityServiceCenterDaoOf(userContext).planToRemoveCityEventList(franchisedOutletCityServiceCenter, cityEventIds, allTokens());
				franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withCityEventList().done());
				deleteRelationListInGraph(userContext, franchisedOutletCityServiceCenter.getCityEventList());
				return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCityEvent(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String cityEventId, int cityEventVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter( franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfCityEvent(cityEventId);
		checkerOf(userContext).checkVersionOfCityEvent(cityEventVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter removeCityEvent(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String cityEventId, int cityEventVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingCityEvent(userContext,franchisedOutletCityServiceCenterId, cityEventId, cityEventVersion,tokensExpr);

		CityEvent cityEvent = createIndexedCityEvent(cityEventId, cityEventVersion);
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());
		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletCityServiceCenter.removeCityEvent( cityEvent );
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withCityEventList().done());
			deleteRelationInGraph(userContext, cityEvent);
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingCityEvent(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String cityEventId, int cityEventVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter( franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfCityEvent(cityEventId);
		checkerOf(userContext).checkVersionOfCityEvent(cityEventVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}
	public  FranchisedOutletCityServiceCenter copyCityEventFrom(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId,
		String cityEventId, int cityEventVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingCityEvent(userContext,franchisedOutletCityServiceCenterId, cityEventId, cityEventVersion,tokensExpr);

		CityEvent cityEvent = createIndexedCityEvent(cityEventId, cityEventVersion);
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, allTokens());
		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			cityEvent.updateLastUpdateTime(userContext.now());

			franchisedOutletCityServiceCenter.copyCityEventFrom( cityEvent );
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withCityEventList().done());
			
			userContext.getManagerGroup().getCityEventManager().onNewInstanceCreated(userContext, (CityEvent)franchisedOutletCityServiceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCityEvent(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenterId);
		checkerOf(userContext).checkIdOfCityEvent(cityEventId);
		checkerOf(userContext).checkVersionOfCityEvent(cityEventVersion);
		

		if(CityEvent.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCityEvent(parseString(newValueExpr));
		
		}
		
		if(CityEvent.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfCityEvent(parseString(newValueExpr));
		
		}
		
		if(CityEvent.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfCityEvent(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletCityServiceCenterManagerException.class);

	}

	public  FranchisedOutletCityServiceCenter updateCityEvent(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCityEvent(userContext, franchisedOutletCityServiceCenterId, cityEventId, cityEventVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCityEventList().searchCityEventListWith(CityEvent.ID_PROPERTY, "eq", cityEventId).done();



		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenterId, loadTokens);

		synchronized(franchisedOutletCityServiceCenter){
			//Will be good when the franchisedOutletCityServiceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//franchisedOutletCityServiceCenter.removeCityEvent( cityEvent );
			//make changes to AcceleraterAccount.
			CityEvent cityEventIndex = createIndexedCityEvent(cityEventId, cityEventVersion);

			CityEvent cityEvent = franchisedOutletCityServiceCenter.findTheCityEvent(cityEventIndex);
			if(cityEvent == null){
				throw new FranchisedOutletCityServiceCenterManagerException(cityEvent+" is NOT FOUND" );
			}

			cityEvent.changeProperty(property, newValueExpr);
			cityEvent.updateLastUpdateTime(userContext.now());
			franchisedOutletCityServiceCenter = saveFranchisedOutletCityServiceCenter(userContext, franchisedOutletCityServiceCenter, tokens().withCityEventList().done());
			return present(userContext,franchisedOutletCityServiceCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter newCreated) throws Exception{
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
		//   FranchisedOutletCityServiceCenter newFranchisedOutletCityServiceCenter = this.createFranchisedOutletCityServiceCenter(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newFranchisedOutletCityServiceCenter
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, FranchisedOutletCityServiceCenter.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<FranchisedOutletCityServiceCenter> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<FranchisedOutletCityCenter> belongsToList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, FranchisedOutletCityCenter.class);
		userContext.getDAOGroup().enhanceList(belongsToList, FranchisedOutletCityCenter.class);


    }
	
	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception {
		return listPageByBelongsTo(userContext, belongsToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception {
		SmartList<FranchisedOutletCityServiceCenter> list = franchisedOutletCityServiceCenterDaoOf(userContext).findFranchisedOutletCityServiceCenterByBelongsTo(belongsToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(FranchisedOutletCityServiceCenter.class);
		page.setContainerObject(FranchisedOutletCityCenter.withId(belongsToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("特许经销城市服务中心列表");
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
 	public Object wxappview(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getFranchisedOutletCityServiceCenterDetailScope().clone();
		FranchisedOutletCityServiceCenter merchantObj = (FranchisedOutletCityServiceCenter) this.view(userContext, franchisedOutletCityServiceCenterId);
    String merchantObjId = franchisedOutletCityServiceCenterId;
    String linkToUrl =	"franchisedOutletCityServiceCenterManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "特许经销城市服务中心"+"详情";
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
				MapUtil.put("id", "4-belongsTo")
				    .put("fieldName", "belongsTo")
				    .put("label", "属于")
				    .put("type", "auto")
				    .put("linkToUrl", "franchisedOutletCityCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("belongsTo", merchantObj.getBelongsTo());

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

		//处理Section：cityPartnerListSection
		Map cityPartnerListSection = ListofUtils.buildSection(
		    "cityPartnerListSection",
		    "城市的合作伙伴名单",
		    null,
		    "",
		    "__no_group",
		    "cityPartnerManager/listByTownServiceCenter/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(cityPartnerListSection);

		result.put("cityPartnerListSection", ListofUtils.toShortList(merchantObj.getCityPartnerList(), "cityPartner"));
		vscope.field("cityPartnerListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( CityPartner.class.getName(), null));

		//处理Section：potentialCustomerListSection
		Map potentialCustomerListSection = ListofUtils.buildSection(
		    "potentialCustomerListSection",
		    "潜在客户列表",
		    null,
		    "",
		    "__no_group",
		    "potentialCustomerManager/listByCityServiceCenter/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(potentialCustomerListSection);

		result.put("potentialCustomerListSection", ListofUtils.toShortList(merchantObj.getPotentialCustomerList(), "potentialCustomer"));
		vscope.field("potentialCustomerListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( PotentialCustomer.class.getName(), null));

		//处理Section：cityEventListSection
		Map cityEventListSection = ListofUtils.buildSection(
		    "cityEventListSection",
		    "城市事件列表",
		    null,
		    "",
		    "__no_group",
		    "cityEventManager/listByCityServiceCenter/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(cityEventListSection);

		result.put("cityEventListSection", ListofUtils.toShortList(merchantObj.getCityEventList(), "cityEvent"));
		vscope.field("cityEventListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( CityEvent.class.getName(), null));

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


