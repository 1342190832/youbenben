
package com.youbenben.youbenben.franchisedoutletprovincecenter;

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


import com.youbenben.youbenben.catalog.Catalog;


import com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenter;






public class FranchisedOutletProvinceCenterManagerImpl extends CustomYoubenbenCheckerManager implements FranchisedOutletProvinceCenterManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = FranchisedOutletProvinceCenterTokens.start().withTokenFromListName(listName).done();
		FranchisedOutletProvinceCenter  franchisedOutletProvinceCenter = (FranchisedOutletProvinceCenter) this.loadFranchisedOutletProvinceCenter(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = franchisedOutletProvinceCenter.collectRefercencesFromLists();
		franchisedOutletProvinceCenterDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, franchisedOutletProvinceCenter, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new FranchisedOutletProvinceCenterGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "FranchisedOutletProvinceCenter";
	@Override
	public FranchisedOutletProvinceCenterDAO daoOf(YoubenbenUserContext userContext) {
		return franchisedOutletProvinceCenterDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws FranchisedOutletProvinceCenterManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new FranchisedOutletProvinceCenterManagerException(message);

	}



 	protected FranchisedOutletProvinceCenter saveFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, String [] tokensExpr) throws Exception{	
 		//return getFranchisedOutletProvinceCenterDAO().save(franchisedOutletProvinceCenter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, tokens);
 	}
 	
 	protected FranchisedOutletProvinceCenter saveFranchisedOutletProvinceCenterDetail(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter) throws Exception{	

 		
 		return saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, allTokens());
 	}
 	
 	public FranchisedOutletProvinceCenter loadFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFranchisedOutletProvinceCenter(franchisedOutletProvinceCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( FranchisedOutletProvinceCenterManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadFranchisedOutletProvinceCenter( userContext, franchisedOutletProvinceCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,franchisedOutletProvinceCenter, tokens);
 	}
 	
 	
 	 public FranchisedOutletProvinceCenter searchFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFranchisedOutletProvinceCenter(franchisedOutletProvinceCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( FranchisedOutletProvinceCenterManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadFranchisedOutletProvinceCenter( userContext, franchisedOutletProvinceCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,franchisedOutletProvinceCenter, tokens);
 	}
 	
 	

 	protected FranchisedOutletProvinceCenter present(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,franchisedOutletProvinceCenter,tokens);
		
		
		FranchisedOutletProvinceCenter  franchisedOutletProvinceCenterToPresent = franchisedOutletProvinceCenterDaoOf(userContext).present(franchisedOutletProvinceCenter, tokens);
		
		List<BaseEntity> entityListToNaming = franchisedOutletProvinceCenterToPresent.collectRefercencesFromLists();
		franchisedOutletProvinceCenterDaoOf(userContext).alias(entityListToNaming);
		
		return  franchisedOutletProvinceCenterToPresent;
		
		
	}
 
 	
 	
 	public FranchisedOutletProvinceCenter loadFranchisedOutletProvinceCenterDetail(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId) throws Exception{	
 		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadFranchisedOutletProvinceCenter( userContext, franchisedOutletProvinceCenterId, allTokens());
 		return present(userContext,franchisedOutletProvinceCenter, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId) throws Exception{	
 		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadFranchisedOutletProvinceCenter( userContext, franchisedOutletProvinceCenterId, viewTokens());
 		return present(userContext,franchisedOutletProvinceCenter, allTokens());
		
 	}
 	protected FranchisedOutletProvinceCenter saveFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, Map<String,Object>tokens) throws Exception{	
 		return franchisedOutletProvinceCenterDaoOf(userContext).save(franchisedOutletProvinceCenter, tokens);
 	}
 	protected FranchisedOutletProvinceCenter loadFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFranchisedOutletProvinceCenter(franchisedOutletProvinceCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( FranchisedOutletProvinceCenterManagerException.class);

 
 		return franchisedOutletProvinceCenterDaoOf(userContext).load(franchisedOutletProvinceCenterId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, Map<String, Object> tokens){
		super.addActions(userContext, franchisedOutletProvinceCenter, tokens);
		
		addAction(userContext, franchisedOutletProvinceCenter, tokens,"@create","createFranchisedOutletProvinceCenter","createFranchisedOutletProvinceCenter/","main","primary");
		addAction(userContext, franchisedOutletProvinceCenter, tokens,"@update","updateFranchisedOutletProvinceCenter","updateFranchisedOutletProvinceCenter/"+franchisedOutletProvinceCenter.getId()+"/","main","primary");
		addAction(userContext, franchisedOutletProvinceCenter, tokens,"@copy","cloneFranchisedOutletProvinceCenter","cloneFranchisedOutletProvinceCenter/"+franchisedOutletProvinceCenter.getId()+"/","main","primary");
		
		addAction(userContext, franchisedOutletProvinceCenter, tokens,"franchised_outlet_province_center.addCatalog","addCatalog","addCatalog/"+franchisedOutletProvinceCenter.getId()+"/","catalogList","primary");
		addAction(userContext, franchisedOutletProvinceCenter, tokens,"franchised_outlet_province_center.removeCatalog","removeCatalog","removeCatalog/"+franchisedOutletProvinceCenter.getId()+"/","catalogList","primary");
		addAction(userContext, franchisedOutletProvinceCenter, tokens,"franchised_outlet_province_center.updateCatalog","updateCatalog","updateCatalog/"+franchisedOutletProvinceCenter.getId()+"/","catalogList","primary");
		addAction(userContext, franchisedOutletProvinceCenter, tokens,"franchised_outlet_province_center.copyCatalogFrom","copyCatalogFrom","copyCatalogFrom/"+franchisedOutletProvinceCenter.getId()+"/","catalogList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public FranchisedOutletProvinceCenter createFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, String name,String serviceNumber,Date founded,String webSite,String address,String operatedBy,String legalRepresentative,String description) throws Exception
	//public FranchisedOutletProvinceCenter createFranchisedOutletProvinceCenter(YoubenbenUserContext userContext,String name, String serviceNumber, Date founded, String webSite, String address, String operatedBy, String legalRepresentative, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfFranchisedOutletProvinceCenter(name);
		checkerOf(userContext).checkServiceNumberOfFranchisedOutletProvinceCenter(serviceNumber);
		checkerOf(userContext).checkFoundedOfFranchisedOutletProvinceCenter(founded);
		checkerOf(userContext).checkWebSiteOfFranchisedOutletProvinceCenter(webSite);
		checkerOf(userContext).checkAddressOfFranchisedOutletProvinceCenter(address);
		checkerOf(userContext).checkOperatedByOfFranchisedOutletProvinceCenter(operatedBy);
		checkerOf(userContext).checkLegalRepresentativeOfFranchisedOutletProvinceCenter(legalRepresentative);
		checkerOf(userContext).checkDescriptionOfFranchisedOutletProvinceCenter(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletProvinceCenterManagerException.class);


		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter=createNewFranchisedOutletProvinceCenter();	

		franchisedOutletProvinceCenter.setName(name);
		franchisedOutletProvinceCenter.setServiceNumber(serviceNumber);
		franchisedOutletProvinceCenter.setFounded(founded);
		franchisedOutletProvinceCenter.setWebSite(webSite);
		franchisedOutletProvinceCenter.setAddress(address);
		franchisedOutletProvinceCenter.setOperatedBy(operatedBy);
		franchisedOutletProvinceCenter.setLegalRepresentative(legalRepresentative);
		franchisedOutletProvinceCenter.setDescription(description);

		franchisedOutletProvinceCenter = saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, emptyOptions());
		
		onNewInstanceCreated(userContext, franchisedOutletProvinceCenter);
		return franchisedOutletProvinceCenter;


	}
	protected FranchisedOutletProvinceCenter createNewFranchisedOutletProvinceCenter()
	{

		return new FranchisedOutletProvinceCenter();
	}

	protected void checkParamsForUpdatingFranchisedOutletProvinceCenter(YoubenbenUserContext userContext,String franchisedOutletProvinceCenterId, int franchisedOutletProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFranchisedOutletProvinceCenter(franchisedOutletProvinceCenterId);
		checkerOf(userContext).checkVersionOfFranchisedOutletProvinceCenter( franchisedOutletProvinceCenterVersion);
		

		if(FranchisedOutletProvinceCenter.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfFranchisedOutletProvinceCenter(parseString(newValueExpr));
		
			
		}
		if(FranchisedOutletProvinceCenter.SERVICE_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkServiceNumberOfFranchisedOutletProvinceCenter(parseString(newValueExpr));
		
			
		}
		if(FranchisedOutletProvinceCenter.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfFranchisedOutletProvinceCenter(parseDate(newValueExpr));
		
			
		}
		if(FranchisedOutletProvinceCenter.WEB_SITE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWebSiteOfFranchisedOutletProvinceCenter(parseString(newValueExpr));
		
			
		}
		if(FranchisedOutletProvinceCenter.ADDRESS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAddressOfFranchisedOutletProvinceCenter(parseString(newValueExpr));
		
			
		}
		if(FranchisedOutletProvinceCenter.OPERATED_BY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOperatedByOfFranchisedOutletProvinceCenter(parseString(newValueExpr));
		
			
		}
		if(FranchisedOutletProvinceCenter.LEGAL_REPRESENTATIVE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLegalRepresentativeOfFranchisedOutletProvinceCenter(parseString(newValueExpr));
		
			
		}
		if(FranchisedOutletProvinceCenter.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfFranchisedOutletProvinceCenter(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletProvinceCenterManagerException.class);


	}



	public FranchisedOutletProvinceCenter clone(YoubenbenUserContext userContext, String fromFranchisedOutletProvinceCenterId) throws Exception{

		return franchisedOutletProvinceCenterDaoOf(userContext).clone(fromFranchisedOutletProvinceCenterId, this.allTokens());
	}

	public FranchisedOutletProvinceCenter internalSaveFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter) throws Exception
	{
		return internalSaveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, allTokens());

	}
	public FranchisedOutletProvinceCenter internalSaveFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterId, franchisedOutletProvinceCenterVersion, property, newValueExpr, tokensExpr);


		synchronized(franchisedOutletProvinceCenter){
			//will be good when the franchisedOutletProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FranchisedOutletProvinceCenter.
			if (franchisedOutletProvinceCenter.isChanged()){
			
			}
			franchisedOutletProvinceCenter = saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, options);
			return franchisedOutletProvinceCenter;

		}

	}

	public FranchisedOutletProvinceCenter updateFranchisedOutletProvinceCenter(YoubenbenUserContext userContext,String franchisedOutletProvinceCenterId, int franchisedOutletProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterId, franchisedOutletProvinceCenterVersion, property, newValueExpr, tokensExpr);



		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterId, allTokens());
		if(franchisedOutletProvinceCenter.getVersion() != franchisedOutletProvinceCenterVersion){
			String message = "The target version("+franchisedOutletProvinceCenter.getVersion()+") is not equals to version("+franchisedOutletProvinceCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(franchisedOutletProvinceCenter){
			//will be good when the franchisedOutletProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FranchisedOutletProvinceCenter.
			
			franchisedOutletProvinceCenter.changeProperty(property, newValueExpr);
			franchisedOutletProvinceCenter = saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, tokens().done());
			return present(userContext,franchisedOutletProvinceCenter, mergedAllTokens(tokensExpr));
			//return saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, tokens().done());
		}

	}

	public FranchisedOutletProvinceCenter updateFranchisedOutletProvinceCenterProperty(YoubenbenUserContext userContext,String franchisedOutletProvinceCenterId, int franchisedOutletProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterId, franchisedOutletProvinceCenterVersion, property, newValueExpr, tokensExpr);

		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterId, allTokens());
		if(franchisedOutletProvinceCenter.getVersion() != franchisedOutletProvinceCenterVersion){
			String message = "The target version("+franchisedOutletProvinceCenter.getVersion()+") is not equals to version("+franchisedOutletProvinceCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(franchisedOutletProvinceCenter){
			//will be good when the franchisedOutletProvinceCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FranchisedOutletProvinceCenter.

			franchisedOutletProvinceCenter.changeProperty(property, newValueExpr);
			
			franchisedOutletProvinceCenter = saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, tokens().done());
			return present(userContext,franchisedOutletProvinceCenter, mergedAllTokens(tokensExpr));
			//return saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected FranchisedOutletProvinceCenterTokens tokens(){
		return FranchisedOutletProvinceCenterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FranchisedOutletProvinceCenterTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCatalogListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FranchisedOutletProvinceCenterTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, int franchisedOutletProvinceCenterVersion) throws Exception {
		//deleteInternal(userContext, franchisedOutletProvinceCenterId, franchisedOutletProvinceCenterVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String franchisedOutletProvinceCenterId, int franchisedOutletProvinceCenterVersion) throws Exception{

		franchisedOutletProvinceCenterDaoOf(userContext).delete(franchisedOutletProvinceCenterId, franchisedOutletProvinceCenterVersion);
	}

	public FranchisedOutletProvinceCenter forgetByAll(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, int franchisedOutletProvinceCenterVersion) throws Exception {
		return forgetByAllInternal(userContext, franchisedOutletProvinceCenterId, franchisedOutletProvinceCenterVersion);
	}
	protected FranchisedOutletProvinceCenter forgetByAllInternal(YoubenbenUserContext userContext,
			String franchisedOutletProvinceCenterId, int franchisedOutletProvinceCenterVersion) throws Exception{

		return franchisedOutletProvinceCenterDaoOf(userContext).disconnectFromAll(franchisedOutletProvinceCenterId, franchisedOutletProvinceCenterVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FranchisedOutletProvinceCenterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return franchisedOutletProvinceCenterDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingCatalog(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String name, int subCount, BigDecimal amount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfFranchisedOutletProvinceCenter(franchisedOutletProvinceCenterId);

		
		checkerOf(userContext).checkNameOfCatalog(name);
		
		checkerOf(userContext).checkSubCountOfCatalog(subCount);
		
		checkerOf(userContext).checkAmountOfCatalog(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletProvinceCenterManagerException.class);


	}
	public  FranchisedOutletProvinceCenter addCatalog(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String name, int subCount, BigDecimal amount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCatalog(userContext,franchisedOutletProvinceCenterId,name, subCount, amount,tokensExpr);

		Catalog catalog = createCatalog(userContext,name, subCount, amount);

		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterId, emptyOptions());
		synchronized(franchisedOutletProvinceCenter){
			//Will be good when the franchisedOutletProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletProvinceCenter.addCatalog( catalog );
			franchisedOutletProvinceCenter = saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, tokens().withCatalogList().done());
			
			userContext.getManagerGroup().getCatalogManager().onNewInstanceCreated(userContext, catalog);
			return present(userContext,franchisedOutletProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCatalogProperties(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId,String id,String name,int subCount,BigDecimal amount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletProvinceCenter(franchisedOutletProvinceCenterId);
		checkerOf(userContext).checkIdOfCatalog(id);

		checkerOf(userContext).checkNameOfCatalog( name);
		checkerOf(userContext).checkSubCountOfCatalog( subCount);
		checkerOf(userContext).checkAmountOfCatalog( amount);

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletProvinceCenterManagerException.class);

	}
	public  FranchisedOutletProvinceCenter updateCatalogProperties(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String id,String name,int subCount,BigDecimal amount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCatalogProperties(userContext,franchisedOutletProvinceCenterId,id,name,subCount,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCatalogListList()
				.searchCatalogListWith(Catalog.ID_PROPERTY, "is", id).done();

		FranchisedOutletProvinceCenter franchisedOutletProvinceCenterToUpdate = loadFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterId, options);

		if(franchisedOutletProvinceCenterToUpdate.getCatalogList().isEmpty()){
			throw new FranchisedOutletProvinceCenterManagerException("Catalog is NOT FOUND with id: '"+id+"'");
		}

		Catalog item = franchisedOutletProvinceCenterToUpdate.getCatalogList().first();

		item.updateName( name );
		item.updateSubCount( subCount );
		item.updateAmount( amount );


		//checkParamsForAddingCatalog(userContext,franchisedOutletProvinceCenterId,name, code, used,tokensExpr);
		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterToUpdate, tokens().withCatalogList().done());
		synchronized(franchisedOutletProvinceCenter){
			return present(userContext,franchisedOutletProvinceCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected Catalog createCatalog(YoubenbenUserContext userContext, String name, int subCount, BigDecimal amount) throws Exception{

		Catalog catalog = new Catalog();
		
		
		catalog.setName(name);		
		catalog.setSubCount(subCount);		
		catalog.setAmount(amount);
	
		
		return catalog;


	}

	protected Catalog createIndexedCatalog(String id, int version){

		Catalog catalog = new Catalog();
		catalog.setId(id);
		catalog.setVersion(version);
		return catalog;

	}

	protected void checkParamsForRemovingCatalogList(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId,
			String catalogIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFranchisedOutletProvinceCenter(franchisedOutletProvinceCenterId);
		for(String catalogIdItem: catalogIds){
			checkerOf(userContext).checkIdOfCatalog(catalogIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletProvinceCenterManagerException.class);

	}
	public  FranchisedOutletProvinceCenter removeCatalogList(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId,
			String catalogIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCatalogList(userContext, franchisedOutletProvinceCenterId,  catalogIds, tokensExpr);


			FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterId, allTokens());
			synchronized(franchisedOutletProvinceCenter){
				//Will be good when the franchisedOutletProvinceCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				franchisedOutletProvinceCenterDaoOf(userContext).planToRemoveCatalogList(franchisedOutletProvinceCenter, catalogIds, allTokens());
				franchisedOutletProvinceCenter = saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, tokens().withCatalogList().done());
				deleteRelationListInGraph(userContext, franchisedOutletProvinceCenter.getCatalogList());
				return present(userContext,franchisedOutletProvinceCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCatalog(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId,
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletProvinceCenter( franchisedOutletProvinceCenterId);
		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).checkVersionOfCatalog(catalogVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletProvinceCenterManagerException.class);

	}
	public  FranchisedOutletProvinceCenter removeCatalog(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId,
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingCatalog(userContext,franchisedOutletProvinceCenterId, catalogId, catalogVersion,tokensExpr);

		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterId, allTokens());
		synchronized(franchisedOutletProvinceCenter){
			//Will be good when the franchisedOutletProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			franchisedOutletProvinceCenter.removeCatalog( catalog );
			franchisedOutletProvinceCenter = saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, tokens().withCatalogList().done());
			deleteRelationInGraph(userContext, catalog);
			return present(userContext,franchisedOutletProvinceCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingCatalog(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId,
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFranchisedOutletProvinceCenter( franchisedOutletProvinceCenterId);
		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).checkVersionOfCatalog(catalogVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletProvinceCenterManagerException.class);

	}
	public  FranchisedOutletProvinceCenter copyCatalogFrom(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId,
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingCatalog(userContext,franchisedOutletProvinceCenterId, catalogId, catalogVersion,tokensExpr);

		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterId, allTokens());
		synchronized(franchisedOutletProvinceCenter){
			//Will be good when the franchisedOutletProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			franchisedOutletProvinceCenter.copyCatalogFrom( catalog );
			franchisedOutletProvinceCenter = saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, tokens().withCatalogList().done());
			
			userContext.getManagerGroup().getCatalogManager().onNewInstanceCreated(userContext, (Catalog)franchisedOutletProvinceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,franchisedOutletProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCatalog(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfFranchisedOutletProvinceCenter(franchisedOutletProvinceCenterId);
		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).checkVersionOfCatalog(catalogVersion);
		

		if(Catalog.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCatalog(parseString(newValueExpr));
		
		}
		
		if(Catalog.SUB_COUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSubCountOfCatalog(parseInt(newValueExpr));
		
		}
		
		if(Catalog.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfCatalog(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FranchisedOutletProvinceCenterManagerException.class);

	}

	public  FranchisedOutletProvinceCenter updateCatalog(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCatalog(userContext, franchisedOutletProvinceCenterId, catalogId, catalogVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCatalogList().searchCatalogListWith(Catalog.ID_PROPERTY, "eq", catalogId).done();



		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenterId, loadTokens);

		synchronized(franchisedOutletProvinceCenter){
			//Will be good when the franchisedOutletProvinceCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//franchisedOutletProvinceCenter.removeCatalog( catalog );
			//make changes to AcceleraterAccount.
			Catalog catalogIndex = createIndexedCatalog(catalogId, catalogVersion);

			Catalog catalog = franchisedOutletProvinceCenter.findTheCatalog(catalogIndex);
			if(catalog == null){
				throw new FranchisedOutletProvinceCenterManagerException(catalog+" is NOT FOUND" );
			}

			catalog.changeProperty(property, newValueExpr);
			
			franchisedOutletProvinceCenter = saveFranchisedOutletProvinceCenter(userContext, franchisedOutletProvinceCenter, tokens().withCatalogList().done());
			return present(userContext,franchisedOutletProvinceCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, FranchisedOutletProvinceCenter newCreated) throws Exception{
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
		//   FranchisedOutletProvinceCenter newFranchisedOutletProvinceCenter = this.createFranchisedOutletProvinceCenter(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newFranchisedOutletProvinceCenter
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, FranchisedOutletProvinceCenter.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<FranchisedOutletProvinceCenter> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String franchisedOutletProvinceCenterId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getFranchisedOutletProvinceCenterDetailScope().clone();
		FranchisedOutletProvinceCenter merchantObj = (FranchisedOutletProvinceCenter) this.view(userContext, franchisedOutletProvinceCenterId);
    String merchantObjId = franchisedOutletProvinceCenterId;
    String linkToUrl =	"franchisedOutletProvinceCenterManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "加盟店省中心"+"详情";
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
				MapUtil.put("id", "3-serviceNumber")
				    .put("fieldName", "serviceNumber")
				    .put("label", "服务号码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("serviceNumber", merchantObj.getServiceNumber());

		propList.add(
				MapUtil.put("id", "4-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		propList.add(
				MapUtil.put("id", "5-webSite")
				    .put("fieldName", "webSite")
				    .put("label", "网站")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("webSite", merchantObj.getWebSite());

		propList.add(
				MapUtil.put("id", "6-address")
				    .put("fieldName", "address")
				    .put("label", "地址")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("address", merchantObj.getAddress());

		propList.add(
				MapUtil.put("id", "7-operatedBy")
				    .put("fieldName", "operatedBy")
				    .put("label", "由")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("operatedBy", merchantObj.getOperatedBy());

		propList.add(
				MapUtil.put("id", "8-legalRepresentative")
				    .put("fieldName", "legalRepresentative")
				    .put("label", "法定代表人")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("legalRepresentative", merchantObj.getLegalRepresentative());

		propList.add(
				MapUtil.put("id", "9-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		//处理 sectionList

		//处理Section：catalogListSection
		Map catalogListSection = ListofUtils.buildSection(
		    "catalogListSection",
		    "目录列表",
		    null,
		    "",
		    "产品管理",
		    "catalogManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(catalogListSection);

		result.put("catalogListSection", ListofUtils.toShortList(merchantObj.getCatalogList(), "catalog"));
		vscope.field("catalogListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( Catalog.class.getName(), null));

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


