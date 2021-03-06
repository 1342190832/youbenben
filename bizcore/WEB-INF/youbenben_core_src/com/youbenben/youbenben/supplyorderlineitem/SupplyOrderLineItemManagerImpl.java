
package com.youbenben.youbenben.supplyorderlineitem;

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


import com.youbenben.youbenben.supplyorder.SupplyOrder;

import com.youbenben.youbenben.supplyorder.CandidateSupplyOrder;







public class SupplyOrderLineItemManagerImpl extends CustomYoubenbenCheckerManager implements SupplyOrderLineItemManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "SupplyOrderLineItem";
	@Override
	public SupplyOrderLineItemDAO daoOf(YoubenbenUserContext userContext) {
		return supplyOrderLineItemDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws SupplyOrderLineItemManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderLineItemManagerException(message);

	}



 	protected SupplyOrderLineItem saveSupplyOrderLineItem(YoubenbenUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderLineItemDAO().save(supplyOrderLineItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens);
 	}
 	
 	protected SupplyOrderLineItem saveSupplyOrderLineItemDetail(YoubenbenUserContext userContext, SupplyOrderLineItem supplyOrderLineItem) throws Exception{	

 		
 		return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, allTokens());
 	}
 	
 	public SupplyOrderLineItem loadSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderLineItemId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderLineItemManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem( userContext, supplyOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderLineItem, tokens);
 	}
 	
 	
 	 public SupplyOrderLineItem searchSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderLineItemId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderLineItemManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem( userContext, supplyOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderLineItem, tokens);
 	}
 	
 	

 	protected SupplyOrderLineItem present(YoubenbenUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderLineItem,tokens);
		
		
		SupplyOrderLineItem  supplyOrderLineItemToPresent = supplyOrderLineItemDaoOf(userContext).present(supplyOrderLineItem, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderLineItemToPresent.collectRefercencesFromLists();
		supplyOrderLineItemDaoOf(userContext).alias(entityListToNaming);
		
		return  supplyOrderLineItemToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderLineItem loadSupplyOrderLineItemDetail(YoubenbenUserContext userContext, String supplyOrderLineItemId) throws Exception{	
 		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem( userContext, supplyOrderLineItemId, allTokens());
 		return present(userContext,supplyOrderLineItem, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String supplyOrderLineItemId) throws Exception{	
 		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem( userContext, supplyOrderLineItemId, viewTokens());
 		return present(userContext,supplyOrderLineItem, allTokens());
		
 	}
 	protected SupplyOrderLineItem saveSupplyOrderLineItem(YoubenbenUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String,Object>tokens) throws Exception{	
 		return supplyOrderLineItemDaoOf(userContext).save(supplyOrderLineItem, tokens);
 	}
 	protected SupplyOrderLineItem loadSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderLineItemId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderLineItemManagerException.class);

 
 		return supplyOrderLineItemDaoOf(userContext).load(supplyOrderLineItemId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderLineItem, tokens);
		
		addAction(userContext, supplyOrderLineItem, tokens,"@create","createSupplyOrderLineItem","createSupplyOrderLineItem/","main","primary");
		addAction(userContext, supplyOrderLineItem, tokens,"@update","updateSupplyOrderLineItem","updateSupplyOrderLineItem/"+supplyOrderLineItem.getId()+"/","main","primary");
		addAction(userContext, supplyOrderLineItem, tokens,"@copy","cloneSupplyOrderLineItem","cloneSupplyOrderLineItem/"+supplyOrderLineItem.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderLineItem, tokens,"supply_order_line_item.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+supplyOrderLineItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SupplyOrderLineItem createSupplyOrderLineItem(YoubenbenUserContext userContext, String bizOrderId,String skuId,String skuName,BigDecimal amount,int quantity,String unitOfMeasurement) throws Exception
	//public SupplyOrderLineItem createSupplyOrderLineItem(YoubenbenUserContext userContext,String bizOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement) throws Exception
	{

		

		

		checkerOf(userContext).checkSkuIdOfSupplyOrderLineItem(skuId);
		checkerOf(userContext).checkSkuNameOfSupplyOrderLineItem(skuName);
		checkerOf(userContext).checkAmountOfSupplyOrderLineItem(amount);
		checkerOf(userContext).checkQuantityOfSupplyOrderLineItem(quantity);
		checkerOf(userContext).checkUnitOfMeasurementOfSupplyOrderLineItem(unitOfMeasurement);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);


		SupplyOrderLineItem supplyOrderLineItem=createNewSupplyOrderLineItem();	

			
		SupplyOrder bizOrder = loadSupplyOrder(userContext, bizOrderId,emptyOptions());
		supplyOrderLineItem.setBizOrder(bizOrder);
		
		
		supplyOrderLineItem.setSkuId(skuId);
		supplyOrderLineItem.setSkuName(skuName);
		supplyOrderLineItem.setAmount(amount);
		supplyOrderLineItem.setQuantity(quantity);
		supplyOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);

		supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderLineItem);
		return supplyOrderLineItem;


	}
	protected SupplyOrderLineItem createNewSupplyOrderLineItem()
	{

		return new SupplyOrderLineItem();
	}

	protected void checkParamsForUpdatingSupplyOrderLineItem(YoubenbenUserContext userContext,String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		checkerOf(userContext).checkVersionOfSupplyOrderLineItem( supplyOrderLineItemVersion);
		
		

		
		if(SupplyOrderLineItem.SKU_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSkuIdOfSupplyOrderLineItem(parseString(newValueExpr));
		
			
		}
		if(SupplyOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSkuNameOfSupplyOrderLineItem(parseString(newValueExpr));
		
			
		}
		if(SupplyOrderLineItem.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfSupplyOrderLineItem(parseBigDecimal(newValueExpr));
		
			
		}
		if(SupplyOrderLineItem.QUANTITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkQuantityOfSupplyOrderLineItem(parseInt(newValueExpr));
		
			
		}
		if(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUnitOfMeasurementOfSupplyOrderLineItem(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);


	}



	public SupplyOrderLineItem clone(YoubenbenUserContext userContext, String fromSupplyOrderLineItemId) throws Exception{

		return supplyOrderLineItemDaoOf(userContext).clone(fromSupplyOrderLineItemId, this.allTokens());
	}

	public SupplyOrderLineItem internalSaveSupplyOrderLineItem(YoubenbenUserContext userContext, SupplyOrderLineItem supplyOrderLineItem) throws Exception
	{
		return internalSaveSupplyOrderLineItem(userContext, supplyOrderLineItem, allTokens());

	}
	public SupplyOrderLineItem internalSaveSupplyOrderLineItem(YoubenbenUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSupplyOrderLineItem(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion, property, newValueExpr, tokensExpr);


		synchronized(supplyOrderLineItem){
			//will be good when the supplyOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderLineItem.
			if (supplyOrderLineItem.isChanged()){
			
			}
			supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, options);
			return supplyOrderLineItem;

		}

	}

	public SupplyOrderLineItem updateSupplyOrderLineItem(YoubenbenUserContext userContext,String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderLineItem(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion, property, newValueExpr, tokensExpr);



		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());
		if(supplyOrderLineItem.getVersion() != supplyOrderLineItemVersion){
			String message = "The target version("+supplyOrderLineItem.getVersion()+") is not equals to version("+supplyOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderLineItem){
			//will be good when the supplyOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderLineItem.
			
			supplyOrderLineItem.changeProperty(property, newValueExpr);
			supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
			return present(userContext,supplyOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
		}

	}

	public SupplyOrderLineItem updateSupplyOrderLineItemProperty(YoubenbenUserContext userContext,String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderLineItem(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion, property, newValueExpr, tokensExpr);

		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());
		if(supplyOrderLineItem.getVersion() != supplyOrderLineItemVersion){
			String message = "The target version("+supplyOrderLineItem.getVersion()+") is not equals to version("+supplyOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderLineItem){
			//will be good when the supplyOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderLineItem.

			supplyOrderLineItem.changeProperty(property, newValueExpr);
			
			supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
			return present(userContext,supplyOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SupplyOrderLineItemTokens tokens(){
		return SupplyOrderLineItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderLineItemTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderLineItemTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(YoubenbenUserContext userContext, String supplyOrderLineItemId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
 		checkerOf(userContext).checkIdOfSupplyOrder(anotherBizOrderId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);

 	}
 	public SupplyOrderLineItem transferToAnotherBizOrder(YoubenbenUserContext userContext, String supplyOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, supplyOrderLineItemId,anotherBizOrderId);
 
		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());	
		synchronized(supplyOrderLineItem){
			//will be good when the supplyOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrder bizOrder = loadSupplyOrder(userContext, anotherBizOrderId, emptyOptions());		
			supplyOrderLineItem.updateBizOrder(bizOrder);		
			supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, emptyOptions());
			
			return present(userContext,supplyOrderLineItem, allTokens());
			
		}

 	}

	


	public CandidateSupplyOrder requestCandidateBizOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrder result = new CandidateSupplyOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("buyer");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrder> candidateList = supplyOrderDaoOf(userContext).requestCandidateSupplyOrderForSupplyOrderLineItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected SupplyOrder loadSupplyOrder(YoubenbenUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderDaoOf(userContext).load(newBizOrderId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String supplyOrderLineItemId, int supplyOrderLineItemVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String supplyOrderLineItemId, int supplyOrderLineItemVersion) throws Exception{

		supplyOrderLineItemDaoOf(userContext).delete(supplyOrderLineItemId, supplyOrderLineItemVersion);
	}

	public SupplyOrderLineItem forgetByAll(YoubenbenUserContext userContext, String supplyOrderLineItemId, int supplyOrderLineItemVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion);
	}
	protected SupplyOrderLineItem forgetByAllInternal(YoubenbenUserContext userContext,
			String supplyOrderLineItemId, int supplyOrderLineItemVersion) throws Exception{

		return supplyOrderLineItemDaoOf(userContext).disconnectFromAll(supplyOrderLineItemId, supplyOrderLineItemVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderLineItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return supplyOrderLineItemDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderLineItem newCreated) throws Exception{
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
		//   SupplyOrderLineItem newSupplyOrderLineItem = this.createSupplyOrderLineItem(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSupplyOrderLineItem
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, SupplyOrderLineItem.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<SupplyOrderLineItem> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<SupplyOrder> bizOrderList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrder.class);
		userContext.getDAOGroup().enhanceList(bizOrderList, SupplyOrder.class);


    }
	
	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception {
		return listPageByBizOrder(userContext, bizOrderId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception {
		SmartList<SupplyOrderLineItem> list = supplyOrderLineItemDaoOf(userContext).findSupplyOrderLineItemByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(SupplyOrderLineItem.class);
		page.setContainerObject(SupplyOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应订单行项目列表");
		page.setRequestName("listByBizOrder");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBizOrder/%s/",  getBeanName(), bizOrderId)));

		page.assemblerContent(userContext, "listByBizOrder");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String supplyOrderLineItemId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getSupplyOrderLineItemDetailScope().clone();
		SupplyOrderLineItem merchantObj = (SupplyOrderLineItem) this.view(userContext, supplyOrderLineItemId);
    String merchantObjId = supplyOrderLineItemId;
    String linkToUrl =	"supplyOrderLineItemManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "供应订单行项目"+"详情";
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
				MapUtil.put("id", "2-bizOrder")
				    .put("fieldName", "bizOrder")
				    .put("label", "订单")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"total_amount\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("bizOrder", merchantObj.getBizOrder());

		propList.add(
				MapUtil.put("id", "3-skuId")
				    .put("fieldName", "skuId")
				    .put("label", "产品ID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("skuId", merchantObj.getSkuId());

		propList.add(
				MapUtil.put("id", "4-skuName")
				    .put("fieldName", "skuName")
				    .put("label", "产品名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("skuName", merchantObj.getSkuName());

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

		propList.add(
				MapUtil.put("id", "6-quantity")
				    .put("fieldName", "quantity")
				    .put("label", "证书份数")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("quantity", merchantObj.getQuantity());

		propList.add(
				MapUtil.put("id", "7-unitOfMeasurement")
				    .put("fieldName", "unitOfMeasurement")
				    .put("label", "测量单位")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("unitOfMeasurement", merchantObj.getUnitOfMeasurement());

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


