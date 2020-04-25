
package com.xingyou.xingyou.sku;

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


import com.xingyou.xingyou.product.Product;

import com.xingyou.xingyou.product.CandidateProduct;







public class SkuManagerImpl extends CustomXingyouCheckerManager implements SkuManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "Sku";
	@Override
	public SkuDAO daoOf(XingyouUserContext userContext) {
		return skuDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws SkuManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SkuManagerException(message);

	}



 	protected Sku saveSku(XingyouUserContext userContext, Sku sku, String [] tokensExpr) throws Exception{	
 		//return getSkuDAO().save(sku, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSku(userContext, sku, tokens);
 	}
 	
 	protected Sku saveSkuDetail(XingyouUserContext userContext, Sku sku) throws Exception{	

 		
 		return saveSku(userContext, sku, allTokens());
 	}
 	
 	public Sku loadSku(XingyouUserContext userContext, String skuId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).throwExceptionIfHasErrors( SkuManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Sku sku = loadSku( userContext, skuId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,sku, tokens);
 	}
 	
 	
 	 public Sku searchSku(XingyouUserContext userContext, String skuId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).throwExceptionIfHasErrors( SkuManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Sku sku = loadSku( userContext, skuId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,sku, tokens);
 	}
 	
 	

 	protected Sku present(XingyouUserContext userContext, Sku sku, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,sku,tokens);
		
		
		Sku  skuToPresent = skuDaoOf(userContext).present(sku, tokens);
		
		List<BaseEntity> entityListToNaming = skuToPresent.collectRefercencesFromLists();
		skuDaoOf(userContext).alias(entityListToNaming);
		
		return  skuToPresent;
		
		
	}
 
 	
 	
 	public Sku loadSkuDetail(XingyouUserContext userContext, String skuId) throws Exception{	
 		Sku sku = loadSku( userContext, skuId, allTokens());
 		return present(userContext,sku, allTokens());
		
 	}
 	
 	public Object view(XingyouUserContext userContext, String skuId) throws Exception{	
 		Sku sku = loadSku( userContext, skuId, viewTokens());
 		return present(userContext,sku, allTokens());
		
 	}
 	protected Sku saveSku(XingyouUserContext userContext, Sku sku, Map<String,Object>tokens) throws Exception{	
 		return skuDaoOf(userContext).save(sku, tokens);
 	}
 	protected Sku loadSku(XingyouUserContext userContext, String skuId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).throwExceptionIfHasErrors( SkuManagerException.class);

 
 		return skuDaoOf(userContext).load(skuId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(XingyouUserContext userContext, Sku sku, Map<String, Object> tokens){
		super.addActions(userContext, sku, tokens);
		
		addAction(userContext, sku, tokens,"@create","createSku","createSku/","main","primary");
		addAction(userContext, sku, tokens,"@update","updateSku","updateSku/"+sku.getId()+"/","main","primary");
		addAction(userContext, sku, tokens,"@copy","cloneSku","cloneSku/"+sku.getId()+"/","main","primary");
		
		addAction(userContext, sku, tokens,"sku.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+sku.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(XingyouUserContext userContext, Sku sku, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Sku createSku(XingyouUserContext userContext, String name,String size,String productId,String barcode,String packageType,String netContent,BigDecimal price,String picture) throws Exception
	//public Sku createSku(XingyouUserContext userContext,String name, String size, String productId, String barcode, String packageType, String netContent, BigDecimal price, String picture) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfSku(name);
		checkerOf(userContext).checkSizeOfSku(size);
		checkerOf(userContext).checkBarcodeOfSku(barcode);
		checkerOf(userContext).checkPackageTypeOfSku(packageType);
		checkerOf(userContext).checkNetContentOfSku(netContent);
		checkerOf(userContext).checkPriceOfSku(price);
		checkerOf(userContext).checkPictureOfSku(picture);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);


		Sku sku=createNewSku();	

		sku.setName(name);
		sku.setSize(size);
			
		Product product = loadProduct(userContext, productId,emptyOptions());
		sku.setProduct(product);
		
		
		sku.setBarcode(barcode);
		sku.setPackageType(packageType);
		sku.setNetContent(netContent);
		sku.setPrice(price);
		sku.setPicture(picture);

		sku = saveSku(userContext, sku, emptyOptions());
		
		onNewInstanceCreated(userContext, sku);
		return sku;


	}
	protected Sku createNewSku()
	{

		return new Sku();
	}

	protected void checkParamsForUpdatingSku(XingyouUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSku(skuId);
		checkerOf(userContext).checkVersionOfSku( skuVersion);
		

		if(Sku.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfSku(parseString(newValueExpr));
		
			
		}
		if(Sku.SIZE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSizeOfSku(parseString(newValueExpr));
		
			
		}		

		
		if(Sku.BARCODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBarcodeOfSku(parseString(newValueExpr));
		
			
		}
		if(Sku.PACKAGE_TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPackageTypeOfSku(parseString(newValueExpr));
		
			
		}
		if(Sku.NET_CONTENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNetContentOfSku(parseString(newValueExpr));
		
			
		}
		if(Sku.PRICE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPriceOfSku(parseBigDecimal(newValueExpr));
		
			
		}
		if(Sku.PICTURE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPictureOfSku(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);


	}



	public Sku clone(XingyouUserContext userContext, String fromSkuId) throws Exception{

		return skuDaoOf(userContext).clone(fromSkuId, this.allTokens());
	}

	public Sku internalSaveSku(XingyouUserContext userContext, Sku sku) throws Exception
	{
		return internalSaveSku(userContext, sku, allTokens());

	}
	public Sku internalSaveSku(XingyouUserContext userContext, Sku sku, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);


		synchronized(sku){
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			if (sku.isChanged()){
			
			}
			sku = saveSku(userContext, sku, options);
			return sku;

		}

	}

	public Sku updateSku(XingyouUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);



		Sku sku = loadSku(userContext, skuId, allTokens());
		if(sku.getVersion() != skuVersion){
			String message = "The target version("+sku.getVersion()+") is not equals to version("+skuVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(sku){
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			
			sku.changeProperty(property, newValueExpr);
			sku = saveSku(userContext, sku, tokens().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
			//return saveSku(userContext, sku, tokens().done());
		}

	}

	public Sku updateSkuProperty(XingyouUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);

		Sku sku = loadSku(userContext, skuId, allTokens());
		if(sku.getVersion() != skuVersion){
			String message = "The target version("+sku.getVersion()+") is not equals to version("+skuVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(sku){
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.

			sku.changeProperty(property, newValueExpr);
			
			sku = saveSku(userContext, sku, tokens().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
			//return saveSku(userContext, sku, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SkuTokens tokens(){
		return SkuTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SkuTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SkuTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProduct(XingyouUserContext userContext, String skuId, String anotherProductId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSku(skuId);
 		checkerOf(userContext).checkIdOfProduct(anotherProductId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SkuManagerException.class);

 	}
 	public Sku transferToAnotherProduct(XingyouUserContext userContext, String skuId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, skuId,anotherProductId);
 
		Sku sku = loadSku(userContext, skuId, allTokens());	
		synchronized(sku){
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Product product = loadProduct(userContext, anotherProductId, emptyOptions());		
			sku.updateProduct(product);		
			sku = saveSku(userContext, sku, emptyOptions());
			
			return present(userContext,sku, allTokens());
			
		}

 	}

	


	public CandidateProduct requestCandidateProduct(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProduct result = new CandidateProduct();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Product> candidateList = productDaoOf(userContext).requestCandidateProductForSku(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Product loadProduct(XingyouUserContext userContext, String newProductId, Map<String,Object> options) throws Exception
 	{

 		return productDaoOf(userContext).load(newProductId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(XingyouUserContext userContext, String skuId, int skuVersion) throws Exception {
		//deleteInternal(userContext, skuId, skuVersion);
	}
	protected void deleteInternal(XingyouUserContext userContext,
			String skuId, int skuVersion) throws Exception{

		skuDaoOf(userContext).delete(skuId, skuVersion);
	}

	public Sku forgetByAll(XingyouUserContext userContext, String skuId, int skuVersion) throws Exception {
		return forgetByAllInternal(userContext, skuId, skuVersion);
	}
	protected Sku forgetByAllInternal(XingyouUserContext userContext,
			String skuId, int skuVersion) throws Exception{

		return skuDaoOf(userContext).disconnectFromAll(skuId, skuVersion);
	}




	public int deleteAll(XingyouUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SkuManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(XingyouUserContext userContext) throws Exception{
		return skuDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(XingyouUserContext userContext, Sku newCreated) throws Exception{
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
		//   Sku newSku = this.createSku(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSku
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Sku.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(XingyouUserContext userContext,SmartList<Sku> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Product> productList = XingyouBaseUtils.collectReferencedObjectWithType(userContext, list, Product.class);
		userContext.getDAOGroup().enhanceList(productList, Product.class);


    }
	
	public Object listByProduct(XingyouUserContext userContext,String productId) throws Exception {
		return listPageByProduct(userContext, productId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByProduct(XingyouUserContext userContext,String productId, int start, int count) throws Exception {
		SmartList<Sku> list = skuDaoOf(userContext).findSkuByProduct(productId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		XingyouCommonListOfViewPage page = new XingyouCommonListOfViewPage();
		page.setClassOfList(Sku.class);
		page.setContainerObject(Product.withId(productId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("SKU列表");
		page.setRequestName("listByProduct");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("product");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByProduct/%s/",  getBeanName(), productId)));

		page.assemblerContent(userContext, "listByProduct");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(XingyouUserContext userContext, String skuId) throws Exception{
	  SerializeScope vscope = XingyouViewScope.getInstance().getSkuDetailScope().clone();
		Sku merchantObj = (Sku) this.view(userContext, skuId);
    String merchantObjId = skuId;
    String linkToUrl =	"skuManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "SKU"+"详情";
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
				MapUtil.put("id", "3-size")
				    .put("fieldName", "size")
				    .put("label", "大小")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("size", merchantObj.getSize());

		propList.add(
				MapUtil.put("id", "4-product")
				    .put("fieldName", "product")
				    .put("label", "产品")
				    .put("type", "auto")
				    .put("linkToUrl", "productManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"origin\",\"imageUrl\":\"picture\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("product", merchantObj.getProduct());

		propList.add(
				MapUtil.put("id", "5-barcode")
				    .put("fieldName", "barcode")
				    .put("label", "条码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("barcode", merchantObj.getBarcode());

		propList.add(
				MapUtil.put("id", "6-packageType")
				    .put("fieldName", "packageType")
				    .put("label", "包装类型")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("packageType", merchantObj.getPackageType());

		propList.add(
				MapUtil.put("id", "7-netContent")
				    .put("fieldName", "netContent")
				    .put("label", "净含量")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("netContent", merchantObj.getNetContent());

		propList.add(
				MapUtil.put("id", "8-price")
				    .put("fieldName", "price")
				    .put("label", "价格")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("price", merchantObj.getPrice());

		propList.add(
				MapUtil.put("id", "9-picture")
				    .put("fieldName", "picture")
				    .put("label", "图片")
				    .put("type", "image")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("picture", merchantObj.getPicture());

		//处理 sectionList

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


