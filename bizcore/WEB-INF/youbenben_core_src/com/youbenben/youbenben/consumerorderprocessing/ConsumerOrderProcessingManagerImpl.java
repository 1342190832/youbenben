
package com.youbenben.youbenben.consumerorderprocessing;

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










public class ConsumerOrderProcessingManagerImpl extends CustomYoubenbenCheckerManager implements ConsumerOrderProcessingManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "ConsumerOrderProcessing";
	@Override
	public ConsumerOrderProcessingDAO daoOf(YoubenbenUserContext userContext) {
		return consumerOrderProcessingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ConsumerOrderProcessingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderProcessingManagerException(message);

	}



 	protected ConsumerOrderProcessing saveConsumerOrderProcessing(YoubenbenUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderProcessingDAO().save(consumerOrderProcessing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens);
 	}
 	
 	protected ConsumerOrderProcessing saveConsumerOrderProcessingDetail(YoubenbenUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing) throws Exception{	

 		
 		return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, allTokens());
 	}
 	
 	public ConsumerOrderProcessing loadConsumerOrderProcessing(YoubenbenUserContext userContext, String consumerOrderProcessingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderProcessing(consumerOrderProcessingId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderProcessingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing( userContext, consumerOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderProcessing, tokens);
 	}
 	
 	
 	 public ConsumerOrderProcessing searchConsumerOrderProcessing(YoubenbenUserContext userContext, String consumerOrderProcessingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderProcessing(consumerOrderProcessingId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderProcessingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing( userContext, consumerOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderProcessing, tokens);
 	}
 	
 	

 	protected ConsumerOrderProcessing present(YoubenbenUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderProcessing,tokens);
		
		
		ConsumerOrderProcessing  consumerOrderProcessingToPresent = consumerOrderProcessingDaoOf(userContext).present(consumerOrderProcessing, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderProcessingToPresent.collectRefercencesFromLists();
		consumerOrderProcessingDaoOf(userContext).alias(entityListToNaming);
		
		return  consumerOrderProcessingToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderProcessing loadConsumerOrderProcessingDetail(YoubenbenUserContext userContext, String consumerOrderProcessingId) throws Exception{	
 		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing( userContext, consumerOrderProcessingId, allTokens());
 		return present(userContext,consumerOrderProcessing, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String consumerOrderProcessingId) throws Exception{	
 		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing( userContext, consumerOrderProcessingId, viewTokens());
 		return present(userContext,consumerOrderProcessing, allTokens());
		
 	}
 	protected ConsumerOrderProcessing saveConsumerOrderProcessing(YoubenbenUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String,Object>tokens) throws Exception{	
 		return consumerOrderProcessingDaoOf(userContext).save(consumerOrderProcessing, tokens);
 	}
 	protected ConsumerOrderProcessing loadConsumerOrderProcessing(YoubenbenUserContext userContext, String consumerOrderProcessingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfConsumerOrderProcessing(consumerOrderProcessingId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderProcessingManagerException.class);

 
 		return consumerOrderProcessingDaoOf(userContext).load(consumerOrderProcessingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderProcessing, tokens);
		
		addAction(userContext, consumerOrderProcessing, tokens,"@create","createConsumerOrderProcessing","createConsumerOrderProcessing/","main","primary");
		addAction(userContext, consumerOrderProcessing, tokens,"@update","updateConsumerOrderProcessing","updateConsumerOrderProcessing/"+consumerOrderProcessing.getId()+"/","main","primary");
		addAction(userContext, consumerOrderProcessing, tokens,"@copy","cloneConsumerOrderProcessing","cloneConsumerOrderProcessing/"+consumerOrderProcessing.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ConsumerOrderProcessing createConsumerOrderProcessing(YoubenbenUserContext userContext, String who,Date processTime) throws Exception
	//public ConsumerOrderProcessing createConsumerOrderProcessing(YoubenbenUserContext userContext,String who, Date processTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfConsumerOrderProcessing(who);
		checkerOf(userContext).checkProcessTimeOfConsumerOrderProcessing(processTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderProcessingManagerException.class);


		ConsumerOrderProcessing consumerOrderProcessing=createNewConsumerOrderProcessing();	

		consumerOrderProcessing.setWho(who);
		consumerOrderProcessing.setProcessTime(processTime);

		consumerOrderProcessing = saveConsumerOrderProcessing(userContext, consumerOrderProcessing, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderProcessing);
		return consumerOrderProcessing;


	}
	protected ConsumerOrderProcessing createNewConsumerOrderProcessing()
	{

		return new ConsumerOrderProcessing();
	}

	protected void checkParamsForUpdatingConsumerOrderProcessing(YoubenbenUserContext userContext,String consumerOrderProcessingId, int consumerOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfConsumerOrderProcessing(consumerOrderProcessingId);
		checkerOf(userContext).checkVersionOfConsumerOrderProcessing( consumerOrderProcessingVersion);
		

		if(ConsumerOrderProcessing.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfConsumerOrderProcessing(parseString(newValueExpr));
		
			
		}
		if(ConsumerOrderProcessing.PROCESS_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkProcessTimeOfConsumerOrderProcessing(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderProcessingManagerException.class);


	}



	public ConsumerOrderProcessing clone(YoubenbenUserContext userContext, String fromConsumerOrderProcessingId) throws Exception{

		return consumerOrderProcessingDaoOf(userContext).clone(fromConsumerOrderProcessingId, this.allTokens());
	}

	public ConsumerOrderProcessing internalSaveConsumerOrderProcessing(YoubenbenUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing) throws Exception
	{
		return internalSaveConsumerOrderProcessing(userContext, consumerOrderProcessing, allTokens());

	}
	public ConsumerOrderProcessing internalSaveConsumerOrderProcessing(YoubenbenUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingConsumerOrderProcessing(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion, property, newValueExpr, tokensExpr);


		synchronized(consumerOrderProcessing){
			//will be good when the consumerOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderProcessing.
			if (consumerOrderProcessing.isChanged()){
			
			}
			consumerOrderProcessing = saveConsumerOrderProcessing(userContext, consumerOrderProcessing, options);
			return consumerOrderProcessing;

		}

	}

	public ConsumerOrderProcessing updateConsumerOrderProcessing(YoubenbenUserContext userContext,String consumerOrderProcessingId, int consumerOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderProcessing(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion, property, newValueExpr, tokensExpr);



		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing(userContext, consumerOrderProcessingId, allTokens());
		if(consumerOrderProcessing.getVersion() != consumerOrderProcessingVersion){
			String message = "The target version("+consumerOrderProcessing.getVersion()+") is not equals to version("+consumerOrderProcessingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderProcessing){
			//will be good when the consumerOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderProcessing.
			
			consumerOrderProcessing.changeProperty(property, newValueExpr);
			consumerOrderProcessing = saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens().done());
			return present(userContext,consumerOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens().done());
		}

	}

	public ConsumerOrderProcessing updateConsumerOrderProcessingProperty(YoubenbenUserContext userContext,String consumerOrderProcessingId, int consumerOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderProcessing(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion, property, newValueExpr, tokensExpr);

		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing(userContext, consumerOrderProcessingId, allTokens());
		if(consumerOrderProcessing.getVersion() != consumerOrderProcessingVersion){
			String message = "The target version("+consumerOrderProcessing.getVersion()+") is not equals to version("+consumerOrderProcessingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderProcessing){
			//will be good when the consumerOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderProcessing.

			consumerOrderProcessing.changeProperty(property, newValueExpr);
			
			consumerOrderProcessing = saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens().done());
			return present(userContext,consumerOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ConsumerOrderProcessingTokens tokens(){
		return ConsumerOrderProcessingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderProcessingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderProcessingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String consumerOrderProcessingId, int consumerOrderProcessingVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String consumerOrderProcessingId, int consumerOrderProcessingVersion) throws Exception{

		consumerOrderProcessingDaoOf(userContext).delete(consumerOrderProcessingId, consumerOrderProcessingVersion);
	}

	public ConsumerOrderProcessing forgetByAll(YoubenbenUserContext userContext, String consumerOrderProcessingId, int consumerOrderProcessingVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion);
	}
	protected ConsumerOrderProcessing forgetByAllInternal(YoubenbenUserContext userContext,
			String consumerOrderProcessingId, int consumerOrderProcessingVersion) throws Exception{

		return consumerOrderProcessingDaoOf(userContext).disconnectFromAll(consumerOrderProcessingId, consumerOrderProcessingVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderProcessingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return consumerOrderProcessingDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderProcessing newCreated) throws Exception{
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
		//   ConsumerOrderProcessing newConsumerOrderProcessing = this.createConsumerOrderProcessing(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newConsumerOrderProcessing
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ConsumerOrderProcessing.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<ConsumerOrderProcessing> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String consumerOrderProcessingId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getConsumerOrderProcessingDetailScope().clone();
		ConsumerOrderProcessing merchantObj = (ConsumerOrderProcessing) this.view(userContext, consumerOrderProcessingId);
    String merchantObjId = consumerOrderProcessingId;
    String linkToUrl =	"consumerOrderProcessingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "消费者的订单处理"+"详情";
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
				MapUtil.put("id", "3-processTime")
				    .put("fieldName", "processTime")
				    .put("label", "处理时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("processTime", merchantObj.getProcessTime());

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


