
package com.youbenben.youbenben.catalog;

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


import com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenter;
import com.youbenben.youbenben.levelonecategory.LevelOneCategory;

import com.youbenben.youbenben.franchisedoutletprovincecenter.CandidateFranchisedOutletProvinceCenter;

import com.youbenben.youbenben.catalog.Catalog;






public class CatalogManagerImpl extends CustomYoubenbenCheckerManager implements CatalogManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = CatalogTokens.start().withTokenFromListName(listName).done();
		Catalog  catalog = (Catalog) this.loadCatalog(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = catalog.collectRefercencesFromLists();
		catalogDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, catalog, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new CatalogGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "Catalog";
	@Override
	public CatalogDAO daoOf(YoubenbenUserContext userContext) {
		return catalogDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws CatalogManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new CatalogManagerException(message);

	}



 	protected Catalog saveCatalog(YoubenbenUserContext userContext, Catalog catalog, String [] tokensExpr) throws Exception{	
 		//return getCatalogDAO().save(catalog, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCatalog(userContext, catalog, tokens);
 	}
 	
 	protected Catalog saveCatalogDetail(YoubenbenUserContext userContext, Catalog catalog) throws Exception{	

 		
 		return saveCatalog(userContext, catalog, allTokens());
 	}
 	
 	public Catalog loadCatalog(YoubenbenUserContext userContext, String catalogId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).throwExceptionIfHasErrors( CatalogManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Catalog catalog = loadCatalog( userContext, catalogId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,catalog, tokens);
 	}
 	
 	
 	 public Catalog searchCatalog(YoubenbenUserContext userContext, String catalogId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).throwExceptionIfHasErrors( CatalogManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Catalog catalog = loadCatalog( userContext, catalogId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,catalog, tokens);
 	}
 	
 	

 	protected Catalog present(YoubenbenUserContext userContext, Catalog catalog, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,catalog,tokens);
		
		
		Catalog  catalogToPresent = catalogDaoOf(userContext).present(catalog, tokens);
		
		List<BaseEntity> entityListToNaming = catalogToPresent.collectRefercencesFromLists();
		catalogDaoOf(userContext).alias(entityListToNaming);
		
		return  catalogToPresent;
		
		
	}
 
 	
 	
 	public Catalog loadCatalogDetail(YoubenbenUserContext userContext, String catalogId) throws Exception{	
 		Catalog catalog = loadCatalog( userContext, catalogId, allTokens());
 		return present(userContext,catalog, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String catalogId) throws Exception{	
 		Catalog catalog = loadCatalog( userContext, catalogId, viewTokens());
 		return present(userContext,catalog, allTokens());
		
 	}
 	protected Catalog saveCatalog(YoubenbenUserContext userContext, Catalog catalog, Map<String,Object>tokens) throws Exception{	
 		return catalogDaoOf(userContext).save(catalog, tokens);
 	}
 	protected Catalog loadCatalog(YoubenbenUserContext userContext, String catalogId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).throwExceptionIfHasErrors( CatalogManagerException.class);

 
 		return catalogDaoOf(userContext).load(catalogId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, Catalog catalog, Map<String, Object> tokens){
		super.addActions(userContext, catalog, tokens);
		
		addAction(userContext, catalog, tokens,"@create","createCatalog","createCatalog/","main","primary");
		addAction(userContext, catalog, tokens,"@update","updateCatalog","updateCatalog/"+catalog.getId()+"/","main","primary");
		addAction(userContext, catalog, tokens,"@copy","cloneCatalog","cloneCatalog/"+catalog.getId()+"/","main","primary");
		
		addAction(userContext, catalog, tokens,"catalog.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+catalog.getId()+"/","main","primary");
		addAction(userContext, catalog, tokens,"catalog.addLevelOneCategory","addLevelOneCategory","addLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.removeLevelOneCategory","removeLevelOneCategory","removeLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.updateLevelOneCategory","updateLevelOneCategory","updateLevelOneCategory/"+catalog.getId()+"/","levelOneCategoryList","primary");
		addAction(userContext, catalog, tokens,"catalog.copyLevelOneCategoryFrom","copyLevelOneCategoryFrom","copyLevelOneCategoryFrom/"+catalog.getId()+"/","levelOneCategoryList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, Catalog catalog, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Catalog createCatalog(YoubenbenUserContext userContext, String name,String ownerId,int subCount,BigDecimal amount) throws Exception
	//public Catalog createCatalog(YoubenbenUserContext userContext,String name, String ownerId, int subCount, BigDecimal amount) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfCatalog(name);
		checkerOf(userContext).checkSubCountOfCatalog(subCount);
		checkerOf(userContext).checkAmountOfCatalog(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);


		Catalog catalog=createNewCatalog();	

		catalog.setName(name);
			
		FranchisedOutletProvinceCenter owner = loadFranchisedOutletProvinceCenter(userContext, ownerId,emptyOptions());
		catalog.setOwner(owner);
		
		
		catalog.setSubCount(subCount);
		catalog.setAmount(amount);

		catalog = saveCatalog(userContext, catalog, emptyOptions());
		
		onNewInstanceCreated(userContext, catalog);
		return catalog;


	}
	protected Catalog createNewCatalog()
	{

		return new Catalog();
	}

	protected void checkParamsForUpdatingCatalog(YoubenbenUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).checkVersionOfCatalog( catalogVersion);
		

		if(Catalog.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCatalog(parseString(newValueExpr));
		
			
		}		

		
		if(Catalog.SUB_COUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSubCountOfCatalog(parseInt(newValueExpr));
		
			
		}
		if(Catalog.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfCatalog(parseBigDecimal(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);


	}



	public Catalog clone(YoubenbenUserContext userContext, String fromCatalogId) throws Exception{

		return catalogDaoOf(userContext).clone(fromCatalogId, this.allTokens());
	}

	public Catalog internalSaveCatalog(YoubenbenUserContext userContext, Catalog catalog) throws Exception
	{
		return internalSaveCatalog(userContext, catalog, allTokens());

	}
	public Catalog internalSaveCatalog(YoubenbenUserContext userContext, Catalog catalog, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingCatalog(userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);


		synchronized(catalog){
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Catalog.
			if (catalog.isChanged()){
			
			}
			catalog = saveCatalog(userContext, catalog, options);
			return catalog;

		}

	}

	public Catalog updateCatalog(YoubenbenUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCatalog(userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);



		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		if(catalog.getVersion() != catalogVersion){
			String message = "The target version("+catalog.getVersion()+") is not equals to version("+catalogVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(catalog){
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Catalog.
			
			catalog.changeProperty(property, newValueExpr);
			catalog = saveCatalog(userContext, catalog, tokens().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
			//return saveCatalog(userContext, catalog, tokens().done());
		}

	}

	public Catalog updateCatalogProperty(YoubenbenUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCatalog(userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);

		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		if(catalog.getVersion() != catalogVersion){
			String message = "The target version("+catalog.getVersion()+") is not equals to version("+catalogVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(catalog){
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Catalog.

			catalog.changeProperty(property, newValueExpr);
			
			catalog = saveCatalog(userContext, catalog, tokens().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
			//return saveCatalog(userContext, catalog, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected CatalogTokens tokens(){
		return CatalogTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CatalogTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelOneCategoryListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CatalogTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(YoubenbenUserContext userContext, String catalogId, String anotherOwnerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCatalog(catalogId);
 		checkerOf(userContext).checkIdOfFranchisedOutletProvinceCenter(anotherOwnerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);

 	}
 	public Catalog transferToAnotherOwner(YoubenbenUserContext userContext, String catalogId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, catalogId,anotherOwnerId);
 
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());	
		synchronized(catalog){
			//will be good when the catalog loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			FranchisedOutletProvinceCenter owner = loadFranchisedOutletProvinceCenter(userContext, anotherOwnerId, emptyOptions());		
			catalog.updateOwner(owner);		
			catalog = saveCatalog(userContext, catalog, emptyOptions());
			
			return present(userContext,catalog, allTokens());
			
		}

 	}

	


	public CandidateFranchisedOutletProvinceCenter requestCandidateOwner(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateFranchisedOutletProvinceCenter result = new CandidateFranchisedOutletProvinceCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<FranchisedOutletProvinceCenter> candidateList = franchisedOutletProvinceCenterDaoOf(userContext).requestCandidateFranchisedOutletProvinceCenterForCatalog(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected FranchisedOutletProvinceCenter loadFranchisedOutletProvinceCenter(YoubenbenUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{

 		return franchisedOutletProvinceCenterDaoOf(userContext).load(newOwnerId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String catalogId, int catalogVersion) throws Exception {
		//deleteInternal(userContext, catalogId, catalogVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String catalogId, int catalogVersion) throws Exception{

		catalogDaoOf(userContext).delete(catalogId, catalogVersion);
	}

	public Catalog forgetByAll(YoubenbenUserContext userContext, String catalogId, int catalogVersion) throws Exception {
		return forgetByAllInternal(userContext, catalogId, catalogVersion);
	}
	protected Catalog forgetByAllInternal(YoubenbenUserContext userContext,
			String catalogId, int catalogVersion) throws Exception{

		return catalogDaoOf(userContext).disconnectFromAll(catalogId, catalogVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CatalogManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return catalogDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingLevelOneCategory(YoubenbenUserContext userContext, String catalogId, String name,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfCatalog(catalogId);

		
		checkerOf(userContext).checkNameOfLevelOneCategory(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);


	}
	public  Catalog addLevelOneCategory(YoubenbenUserContext userContext, String catalogId, String name, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingLevelOneCategory(userContext,catalogId,name,tokensExpr);

		LevelOneCategory levelOneCategory = createLevelOneCategory(userContext,name);

		Catalog catalog = loadCatalog(userContext, catalogId, emptyOptions());
		synchronized(catalog){
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.addLevelOneCategory( levelOneCategory );
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			
			userContext.getManagerGroup().getLevelOneCategoryManager().onNewInstanceCreated(userContext, levelOneCategory);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelOneCategoryProperties(YoubenbenUserContext userContext, String catalogId,String id,String name,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).checkIdOfLevelOneCategory(id);

		checkerOf(userContext).checkNameOfLevelOneCategory( name);

		checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);

	}
	public  Catalog updateLevelOneCategoryProperties(YoubenbenUserContext userContext, String catalogId, String id,String name, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelOneCategoryProperties(userContext,catalogId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelOneCategoryListList()
				.searchLevelOneCategoryListWith(LevelOneCategory.ID_PROPERTY, "is", id).done();

		Catalog catalogToUpdate = loadCatalog(userContext, catalogId, options);

		if(catalogToUpdate.getLevelOneCategoryList().isEmpty()){
			throw new CatalogManagerException("LevelOneCategory is NOT FOUND with id: '"+id+"'");
		}

		LevelOneCategory item = catalogToUpdate.getLevelOneCategoryList().first();

		item.updateName( name );


		//checkParamsForAddingLevelOneCategory(userContext,catalogId,name, code, used,tokensExpr);
		Catalog catalog = saveCatalog(userContext, catalogToUpdate, tokens().withLevelOneCategoryList().done());
		synchronized(catalog){
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}
	}


	protected LevelOneCategory createLevelOneCategory(YoubenbenUserContext userContext, String name) throws Exception{

		LevelOneCategory levelOneCategory = new LevelOneCategory();
		
		
		levelOneCategory.setName(name);
	
		
		return levelOneCategory;


	}

	protected LevelOneCategory createIndexedLevelOneCategory(String id, int version){

		LevelOneCategory levelOneCategory = new LevelOneCategory();
		levelOneCategory.setId(id);
		levelOneCategory.setVersion(version);
		return levelOneCategory;

	}

	protected void checkParamsForRemovingLevelOneCategoryList(YoubenbenUserContext userContext, String catalogId,
			String levelOneCategoryIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCatalog(catalogId);
		for(String levelOneCategoryIdItem: levelOneCategoryIds){
			checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);

	}
	public  Catalog removeLevelOneCategoryList(YoubenbenUserContext userContext, String catalogId,
			String levelOneCategoryIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingLevelOneCategoryList(userContext, catalogId,  levelOneCategoryIds, tokensExpr);


			Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
			synchronized(catalog){
				//Will be good when the catalog loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				catalogDaoOf(userContext).planToRemoveLevelOneCategoryList(catalog, levelOneCategoryIds, allTokens());
				catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
				deleteRelationListInGraph(userContext, catalog.getLevelOneCategoryList());
				return present(userContext,catalog, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingLevelOneCategory(YoubenbenUserContext userContext, String catalogId,
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCatalog( catalogId);
		checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
		checkerOf(userContext).checkVersionOfLevelOneCategory(levelOneCategoryVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);

	}
	public  Catalog removeLevelOneCategory(YoubenbenUserContext userContext, String catalogId,
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingLevelOneCategory(userContext,catalogId, levelOneCategoryId, levelOneCategoryVersion,tokensExpr);

		LevelOneCategory levelOneCategory = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			catalog.removeLevelOneCategory( levelOneCategory );
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			deleteRelationInGraph(userContext, levelOneCategory);
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingLevelOneCategory(YoubenbenUserContext userContext, String catalogId,
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCatalog( catalogId);
		checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
		checkerOf(userContext).checkVersionOfLevelOneCategory(levelOneCategoryVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);

	}
	public  Catalog copyLevelOneCategoryFrom(YoubenbenUserContext userContext, String catalogId,
		String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingLevelOneCategory(userContext,catalogId, levelOneCategoryId, levelOneCategoryVersion,tokensExpr);

		LevelOneCategory levelOneCategory = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
		Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
		synchronized(catalog){
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			catalog.copyLevelOneCategoryFrom( levelOneCategory );
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			
			userContext.getManagerGroup().getLevelOneCategoryManager().onNewInstanceCreated(userContext, (LevelOneCategory)catalog.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingLevelOneCategory(YoubenbenUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
		checkerOf(userContext).checkVersionOfLevelOneCategory(levelOneCategoryVersion);
		

		if(LevelOneCategory.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfLevelOneCategory(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);

	}

	public  Catalog updateLevelOneCategory(YoubenbenUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingLevelOneCategory(userContext, catalogId, levelOneCategoryId, levelOneCategoryVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withLevelOneCategoryList().searchLevelOneCategoryListWith(LevelOneCategory.ID_PROPERTY, "eq", levelOneCategoryId).done();



		Catalog catalog = loadCatalog(userContext, catalogId, loadTokens);

		synchronized(catalog){
			//Will be good when the catalog loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//catalog.removeLevelOneCategory( levelOneCategory );
			//make changes to AcceleraterAccount.
			LevelOneCategory levelOneCategoryIndex = createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);

			LevelOneCategory levelOneCategory = catalog.findTheLevelOneCategory(levelOneCategoryIndex);
			if(levelOneCategory == null){
				throw new CatalogManagerException(levelOneCategory+" is NOT FOUND" );
			}

			levelOneCategory.changeProperty(property, newValueExpr);
			
			catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
			return present(userContext,catalog, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, Catalog newCreated) throws Exception{
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
		//   Catalog newCatalog = this.createCatalog(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newCatalog
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Catalog.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<Catalog> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<FranchisedOutletProvinceCenter> ownerList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, FranchisedOutletProvinceCenter.class);
		userContext.getDAOGroup().enhanceList(ownerList, FranchisedOutletProvinceCenter.class);


    }
	
	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception {
		return listPageByOwner(userContext, ownerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception {
		SmartList<Catalog> list = catalogDaoOf(userContext).findCatalogByOwner(ownerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(Catalog.class);
		page.setContainerObject(FranchisedOutletProvinceCenter.withId(ownerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("目录列表");
		page.setRequestName("listByOwner");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByOwner/%s/",  getBeanName(), ownerId)));

		page.assemblerContent(userContext, "listByOwner");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String catalogId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getCatalogDetailScope().clone();
		Catalog merchantObj = (Catalog) this.view(userContext, catalogId);
    String merchantObjId = catalogId;
    String linkToUrl =	"catalogManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "目录"+"详情";
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
				MapUtil.put("id", "3-owner")
				    .put("fieldName", "owner")
				    .put("label", "所有人")
				    .put("type", "auto")
				    .put("linkToUrl", "franchisedOutletProvinceCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("owner", merchantObj.getOwner());

		propList.add(
				MapUtil.put("id", "4-subCount")
				    .put("fieldName", "subCount")
				    .put("label", "子数")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("subCount", merchantObj.getSubCount());

		propList.add(
				MapUtil.put("id", "5-amount")
				    .put("fieldName", "amount")
				    .put("label", "金额")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("amount", merchantObj.getAmount());

		//处理 sectionList

		//处理Section：levelOneCategoryListSection
		Map levelOneCategoryListSection = ListofUtils.buildSection(
		    "levelOneCategoryListSection",
		    "一级类别列表",
		    null,
		    "",
		    "__no_group",
		    "levelOneCategoryManager/listByCatalog/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(levelOneCategoryListSection);

		result.put("levelOneCategoryListSection", ListofUtils.toShortList(merchantObj.getLevelOneCategoryList(), "levelOneCategory"));
		vscope.field("levelOneCategoryListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( LevelOneCategory.class.getName(), null));

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


