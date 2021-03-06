
package com.youbenben.youbenben.consumerorderconfirmation;

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










public class ConsumerOrderConfirmationManagerImpl extends CustomYoubenbenCheckerManager implements ConsumerOrderConfirmationManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "ConsumerOrderConfirmation";
	@Override
	public ConsumerOrderConfirmationDAO daoOf(YoubenbenUserContext userContext) {
		return consumerOrderConfirmationDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ConsumerOrderConfirmationManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderConfirmationManagerException(message);

	}



 	protected ConsumerOrderConfirmation saveConsumerOrderConfirmation(YoubenbenUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderConfirmationDAO().save(consumerOrderConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens);
 	}
 	
 	protected ConsumerOrderConfirmation saveConsumerOrderConfirmationDetail(YoubenbenUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation) throws Exception{	

 		
 		return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, allTokens());
 	}
 	
 	public ConsumerOrderConfirmation loadConsumerOrderConfirmation(YoubenbenUserContext userContext, String consumerOrderConfirmationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderConfirmation(consumerOrderConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderConfirmationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation( userContext, consumerOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderConfirmation, tokens);
 	}
 	
 	
 	 public ConsumerOrderConfirmation searchConsumerOrderConfirmation(YoubenbenUserContext userContext, String consumerOrderConfirmationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderConfirmation(consumerOrderConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderConfirmationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation( userContext, consumerOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderConfirmation, tokens);
 	}
 	
 	

 	protected ConsumerOrderConfirmation present(YoubenbenUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderConfirmation,tokens);
		
		
		ConsumerOrderConfirmation  consumerOrderConfirmationToPresent = consumerOrderConfirmationDaoOf(userContext).present(consumerOrderConfirmation, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderConfirmationToPresent.collectRefercencesFromLists();
		consumerOrderConfirmationDaoOf(userContext).alias(entityListToNaming);
		
		return  consumerOrderConfirmationToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderConfirmation loadConsumerOrderConfirmationDetail(YoubenbenUserContext userContext, String consumerOrderConfirmationId) throws Exception{	
 		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation( userContext, consumerOrderConfirmationId, allTokens());
 		return present(userContext,consumerOrderConfirmation, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String consumerOrderConfirmationId) throws Exception{	
 		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation( userContext, consumerOrderConfirmationId, viewTokens());
 		return present(userContext,consumerOrderConfirmation, allTokens());
		
 	}
 	protected ConsumerOrderConfirmation saveConsumerOrderConfirmation(YoubenbenUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String,Object>tokens) throws Exception{	
 		return consumerOrderConfirmationDaoOf(userContext).save(consumerOrderConfirmation, tokens);
 	}
 	protected ConsumerOrderConfirmation loadConsumerOrderConfirmation(YoubenbenUserContext userContext, String consumerOrderConfirmationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfConsumerOrderConfirmation(consumerOrderConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderConfirmationManagerException.class);

 
 		return consumerOrderConfirmationDaoOf(userContext).load(consumerOrderConfirmationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderConfirmation, tokens);
		
		addAction(userContext, consumerOrderConfirmation, tokens,"@create","createConsumerOrderConfirmation","createConsumerOrderConfirmation/","main","primary");
		addAction(userContext, consumerOrderConfirmation, tokens,"@update","updateConsumerOrderConfirmation","updateConsumerOrderConfirmation/"+consumerOrderConfirmation.getId()+"/","main","primary");
		addAction(userContext, consumerOrderConfirmation, tokens,"@copy","cloneConsumerOrderConfirmation","cloneConsumerOrderConfirmation/"+consumerOrderConfirmation.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ConsumerOrderConfirmation createConsumerOrderConfirmation(YoubenbenUserContext userContext, String who,Date confirmTime) throws Exception
	//public ConsumerOrderConfirmation createConsumerOrderConfirmation(YoubenbenUserContext userContext,String who, Date confirmTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfConsumerOrderConfirmation(who);
		checkerOf(userContext).checkConfirmTimeOfConsumerOrderConfirmation(confirmTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderConfirmationManagerException.class);


		ConsumerOrderConfirmation consumerOrderConfirmation=createNewConsumerOrderConfirmation();	

		consumerOrderConfirmation.setWho(who);
		consumerOrderConfirmation.setConfirmTime(confirmTime);

		consumerOrderConfirmation = saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderConfirmation);
		return consumerOrderConfirmation;


	}
	protected ConsumerOrderConfirmation createNewConsumerOrderConfirmation()
	{

		return new ConsumerOrderConfirmation();
	}

	protected void checkParamsForUpdatingConsumerOrderConfirmation(YoubenbenUserContext userContext,String consumerOrderConfirmationId, int consumerOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfConsumerOrderConfirmation(consumerOrderConfirmationId);
		checkerOf(userContext).checkVersionOfConsumerOrderConfirmation( consumerOrderConfirmationVersion);
		

		if(ConsumerOrderConfirmation.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfConsumerOrderConfirmation(parseString(newValueExpr));
		
			
		}
		if(ConsumerOrderConfirmation.CONFIRM_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkConfirmTimeOfConsumerOrderConfirmation(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderConfirmationManagerException.class);


	}



	public ConsumerOrderConfirmation clone(YoubenbenUserContext userContext, String fromConsumerOrderConfirmationId) throws Exception{

		return consumerOrderConfirmationDaoOf(userContext).clone(fromConsumerOrderConfirmationId, this.allTokens());
	}

	public ConsumerOrderConfirmation internalSaveConsumerOrderConfirmation(YoubenbenUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation) throws Exception
	{
		return internalSaveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, allTokens());

	}
	public ConsumerOrderConfirmation internalSaveConsumerOrderConfirmation(YoubenbenUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion, property, newValueExpr, tokensExpr);


		synchronized(consumerOrderConfirmation){
			//will be good when the consumerOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderConfirmation.
			if (consumerOrderConfirmation.isChanged()){
			
			}
			consumerOrderConfirmation = saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, options);
			return consumerOrderConfirmation;

		}

	}

	public ConsumerOrderConfirmation updateConsumerOrderConfirmation(YoubenbenUserContext userContext,String consumerOrderConfirmationId, int consumerOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion, property, newValueExpr, tokensExpr);



		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, allTokens());
		if(consumerOrderConfirmation.getVersion() != consumerOrderConfirmationVersion){
			String message = "The target version("+consumerOrderConfirmation.getVersion()+") is not equals to version("+consumerOrderConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderConfirmation){
			//will be good when the consumerOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderConfirmation.
			
			consumerOrderConfirmation.changeProperty(property, newValueExpr);
			consumerOrderConfirmation = saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens().done());
			return present(userContext,consumerOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens().done());
		}

	}

	public ConsumerOrderConfirmation updateConsumerOrderConfirmationProperty(YoubenbenUserContext userContext,String consumerOrderConfirmationId, int consumerOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion, property, newValueExpr, tokensExpr);

		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, allTokens());
		if(consumerOrderConfirmation.getVersion() != consumerOrderConfirmationVersion){
			String message = "The target version("+consumerOrderConfirmation.getVersion()+") is not equals to version("+consumerOrderConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderConfirmation){
			//will be good when the consumerOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderConfirmation.

			consumerOrderConfirmation.changeProperty(property, newValueExpr);
			
			consumerOrderConfirmation = saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens().done());
			return present(userContext,consumerOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ConsumerOrderConfirmationTokens tokens(){
		return ConsumerOrderConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderConfirmationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderConfirmationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String consumerOrderConfirmationId, int consumerOrderConfirmationVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String consumerOrderConfirmationId, int consumerOrderConfirmationVersion) throws Exception{

		consumerOrderConfirmationDaoOf(userContext).delete(consumerOrderConfirmationId, consumerOrderConfirmationVersion);
	}

	public ConsumerOrderConfirmation forgetByAll(YoubenbenUserContext userContext, String consumerOrderConfirmationId, int consumerOrderConfirmationVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion);
	}
	protected ConsumerOrderConfirmation forgetByAllInternal(YoubenbenUserContext userContext,
			String consumerOrderConfirmationId, int consumerOrderConfirmationVersion) throws Exception{

		return consumerOrderConfirmationDaoOf(userContext).disconnectFromAll(consumerOrderConfirmationId, consumerOrderConfirmationVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return consumerOrderConfirmationDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderConfirmation newCreated) throws Exception{
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
		//   ConsumerOrderConfirmation newConsumerOrderConfirmation = this.createConsumerOrderConfirmation(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newConsumerOrderConfirmation
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ConsumerOrderConfirmation.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<ConsumerOrderConfirmation> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String consumerOrderConfirmationId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getConsumerOrderConfirmationDetailScope().clone();
		ConsumerOrderConfirmation merchantObj = (ConsumerOrderConfirmation) this.view(userContext, consumerOrderConfirmationId);
    String merchantObjId = consumerOrderConfirmationId;
    String linkToUrl =	"consumerOrderConfirmationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "客户订单确认"+"详情";
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
				MapUtil.put("id", "2-who")
				    .put("fieldName", "who")
				    .put("label", "谁")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("who", merchantObj.getWho());

		propList.add(
				MapUtil.put("id", "3-confirmTime")
				    .put("fieldName", "confirmTime")
				    .put("label", "确认时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("confirmTime", merchantObj.getConfirmTime());

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


