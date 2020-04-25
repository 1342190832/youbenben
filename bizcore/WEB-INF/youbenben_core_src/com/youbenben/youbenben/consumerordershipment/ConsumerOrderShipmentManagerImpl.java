
package com.youbenben.youbenben.consumerordershipment;

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










public class ConsumerOrderShipmentManagerImpl extends CustomYoubenbenCheckerManager implements ConsumerOrderShipmentManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "ConsumerOrderShipment";
	@Override
	public ConsumerOrderShipmentDAO daoOf(YoubenbenUserContext userContext) {
		return consumerOrderShipmentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ConsumerOrderShipmentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderShipmentManagerException(message);

	}



 	protected ConsumerOrderShipment saveConsumerOrderShipment(YoubenbenUserContext userContext, ConsumerOrderShipment consumerOrderShipment, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderShipmentDAO().save(consumerOrderShipment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens);
 	}
 	
 	protected ConsumerOrderShipment saveConsumerOrderShipmentDetail(YoubenbenUserContext userContext, ConsumerOrderShipment consumerOrderShipment) throws Exception{	

 		
 		return saveConsumerOrderShipment(userContext, consumerOrderShipment, allTokens());
 	}
 	
 	public ConsumerOrderShipment loadConsumerOrderShipment(YoubenbenUserContext userContext, String consumerOrderShipmentId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderShipment(consumerOrderShipmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderShipmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment( userContext, consumerOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShipment, tokens);
 	}
 	
 	
 	 public ConsumerOrderShipment searchConsumerOrderShipment(YoubenbenUserContext userContext, String consumerOrderShipmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrderShipment(consumerOrderShipmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderShipmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment( userContext, consumerOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShipment, tokens);
 	}
 	
 	

 	protected ConsumerOrderShipment present(YoubenbenUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderShipment,tokens);
		
		
		ConsumerOrderShipment  consumerOrderShipmentToPresent = consumerOrderShipmentDaoOf(userContext).present(consumerOrderShipment, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderShipmentToPresent.collectRefercencesFromLists();
		consumerOrderShipmentDaoOf(userContext).alias(entityListToNaming);
		
		return  consumerOrderShipmentToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderShipment loadConsumerOrderShipmentDetail(YoubenbenUserContext userContext, String consumerOrderShipmentId) throws Exception{	
 		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment( userContext, consumerOrderShipmentId, allTokens());
 		return present(userContext,consumerOrderShipment, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String consumerOrderShipmentId) throws Exception{	
 		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment( userContext, consumerOrderShipmentId, viewTokens());
 		return present(userContext,consumerOrderShipment, allTokens());
		
 	}
 	protected ConsumerOrderShipment saveConsumerOrderShipment(YoubenbenUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String,Object>tokens) throws Exception{	
 		return consumerOrderShipmentDaoOf(userContext).save(consumerOrderShipment, tokens);
 	}
 	protected ConsumerOrderShipment loadConsumerOrderShipment(YoubenbenUserContext userContext, String consumerOrderShipmentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfConsumerOrderShipment(consumerOrderShipmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderShipmentManagerException.class);

 
 		return consumerOrderShipmentDaoOf(userContext).load(consumerOrderShipmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderShipment, tokens);
		
		addAction(userContext, consumerOrderShipment, tokens,"@create","createConsumerOrderShipment","createConsumerOrderShipment/","main","primary");
		addAction(userContext, consumerOrderShipment, tokens,"@update","updateConsumerOrderShipment","updateConsumerOrderShipment/"+consumerOrderShipment.getId()+"/","main","primary");
		addAction(userContext, consumerOrderShipment, tokens,"@copy","cloneConsumerOrderShipment","cloneConsumerOrderShipment/"+consumerOrderShipment.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ConsumerOrderShipment createConsumerOrderShipment(YoubenbenUserContext userContext, String who,Date shipTime) throws Exception
	//public ConsumerOrderShipment createConsumerOrderShipment(YoubenbenUserContext userContext,String who, Date shipTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfConsumerOrderShipment(who);
		checkerOf(userContext).checkShipTimeOfConsumerOrderShipment(shipTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderShipmentManagerException.class);


		ConsumerOrderShipment consumerOrderShipment=createNewConsumerOrderShipment();	

		consumerOrderShipment.setWho(who);
		consumerOrderShipment.setShipTime(shipTime);

		consumerOrderShipment = saveConsumerOrderShipment(userContext, consumerOrderShipment, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderShipment);
		return consumerOrderShipment;


	}
	protected ConsumerOrderShipment createNewConsumerOrderShipment()
	{

		return new ConsumerOrderShipment();
	}

	protected void checkParamsForUpdatingConsumerOrderShipment(YoubenbenUserContext userContext,String consumerOrderShipmentId, int consumerOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfConsumerOrderShipment(consumerOrderShipmentId);
		checkerOf(userContext).checkVersionOfConsumerOrderShipment( consumerOrderShipmentVersion);
		

		if(ConsumerOrderShipment.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfConsumerOrderShipment(parseString(newValueExpr));
		
			
		}
		if(ConsumerOrderShipment.SHIP_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkShipTimeOfConsumerOrderShipment(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderShipmentManagerException.class);


	}



	public ConsumerOrderShipment clone(YoubenbenUserContext userContext, String fromConsumerOrderShipmentId) throws Exception{

		return consumerOrderShipmentDaoOf(userContext).clone(fromConsumerOrderShipmentId, this.allTokens());
	}

	public ConsumerOrderShipment internalSaveConsumerOrderShipment(YoubenbenUserContext userContext, ConsumerOrderShipment consumerOrderShipment) throws Exception
	{
		return internalSaveConsumerOrderShipment(userContext, consumerOrderShipment, allTokens());

	}
	public ConsumerOrderShipment internalSaveConsumerOrderShipment(YoubenbenUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingConsumerOrderShipment(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion, property, newValueExpr, tokensExpr);


		synchronized(consumerOrderShipment){
			//will be good when the consumerOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShipment.
			if (consumerOrderShipment.isChanged()){
			
			}
			consumerOrderShipment = saveConsumerOrderShipment(userContext, consumerOrderShipment, options);
			return consumerOrderShipment;

		}

	}

	public ConsumerOrderShipment updateConsumerOrderShipment(YoubenbenUserContext userContext,String consumerOrderShipmentId, int consumerOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderShipment(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion, property, newValueExpr, tokensExpr);



		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment(userContext, consumerOrderShipmentId, allTokens());
		if(consumerOrderShipment.getVersion() != consumerOrderShipmentVersion){
			String message = "The target version("+consumerOrderShipment.getVersion()+") is not equals to version("+consumerOrderShipmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderShipment){
			//will be good when the consumerOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShipment.
			
			consumerOrderShipment.changeProperty(property, newValueExpr);
			consumerOrderShipment = saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens().done());
			return present(userContext,consumerOrderShipment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens().done());
		}

	}

	public ConsumerOrderShipment updateConsumerOrderShipmentProperty(YoubenbenUserContext userContext,String consumerOrderShipmentId, int consumerOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderShipment(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion, property, newValueExpr, tokensExpr);

		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment(userContext, consumerOrderShipmentId, allTokens());
		if(consumerOrderShipment.getVersion() != consumerOrderShipmentVersion){
			String message = "The target version("+consumerOrderShipment.getVersion()+") is not equals to version("+consumerOrderShipmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderShipment){
			//will be good when the consumerOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShipment.

			consumerOrderShipment.changeProperty(property, newValueExpr);
			
			consumerOrderShipment = saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens().done());
			return present(userContext,consumerOrderShipment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ConsumerOrderShipmentTokens tokens(){
		return ConsumerOrderShipmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderShipmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderShipmentTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String consumerOrderShipmentId, int consumerOrderShipmentVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String consumerOrderShipmentId, int consumerOrderShipmentVersion) throws Exception{

		consumerOrderShipmentDaoOf(userContext).delete(consumerOrderShipmentId, consumerOrderShipmentVersion);
	}

	public ConsumerOrderShipment forgetByAll(YoubenbenUserContext userContext, String consumerOrderShipmentId, int consumerOrderShipmentVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion);
	}
	protected ConsumerOrderShipment forgetByAllInternal(YoubenbenUserContext userContext,
			String consumerOrderShipmentId, int consumerOrderShipmentVersion) throws Exception{

		return consumerOrderShipmentDaoOf(userContext).disconnectFromAll(consumerOrderShipmentId, consumerOrderShipmentVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderShipmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return consumerOrderShipmentDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderShipment newCreated) throws Exception{
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
		//   ConsumerOrderShipment newConsumerOrderShipment = this.createConsumerOrderShipment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newConsumerOrderShipment
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ConsumerOrderShipment.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<ConsumerOrderShipment> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String consumerOrderShipmentId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getConsumerOrderShipmentDetailScope().clone();
		ConsumerOrderShipment merchantObj = (ConsumerOrderShipment) this.view(userContext, consumerOrderShipmentId);
    String merchantObjId = consumerOrderShipmentId;
    String linkToUrl =	"consumerOrderShipmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "消费者的订单发货"+"详情";
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
				MapUtil.put("id", "3-shipTime")
				    .put("fieldName", "shipTime")
				    .put("label", "船的时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("shipTime", merchantObj.getShipTime());

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


