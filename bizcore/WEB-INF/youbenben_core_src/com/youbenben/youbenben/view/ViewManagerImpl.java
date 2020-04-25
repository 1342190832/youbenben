
package com.youbenben.youbenben.view;

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










public class ViewManagerImpl extends CustomYoubenbenCheckerManager implements ViewManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "View";
	@Override
	public ViewDAO daoOf(YoubenbenUserContext userContext) {
		return viewDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ViewManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ViewManagerException(message);

	}



 	protected View saveView(YoubenbenUserContext userContext, View view, String [] tokensExpr) throws Exception{	
 		//return getViewDAO().save(view, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveView(userContext, view, tokens);
 	}
 	
 	protected View saveViewDetail(YoubenbenUserContext userContext, View view) throws Exception{	

 		
 		return saveView(userContext, view, allTokens());
 	}
 	
 	public View loadView(YoubenbenUserContext userContext, String viewId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfView(viewId);
		checkerOf(userContext).throwExceptionIfHasErrors( ViewManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		View view = loadView( userContext, viewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,view, tokens);
 	}
 	
 	
 	 public View searchView(YoubenbenUserContext userContext, String viewId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfView(viewId);
		checkerOf(userContext).throwExceptionIfHasErrors( ViewManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		View view = loadView( userContext, viewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,view, tokens);
 	}
 	
 	

 	protected View present(YoubenbenUserContext userContext, View view, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,view,tokens);
		
		
		View  viewToPresent = viewDaoOf(userContext).present(view, tokens);
		
		List<BaseEntity> entityListToNaming = viewToPresent.collectRefercencesFromLists();
		viewDaoOf(userContext).alias(entityListToNaming);
		
		return  viewToPresent;
		
		
	}
 
 	
 	
 	public View loadViewDetail(YoubenbenUserContext userContext, String viewId) throws Exception{	
 		View view = loadView( userContext, viewId, allTokens());
 		return present(userContext,view, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String viewId) throws Exception{	
 		View view = loadView( userContext, viewId, viewTokens());
 		return present(userContext,view, allTokens());
		
 	}
 	protected View saveView(YoubenbenUserContext userContext, View view, Map<String,Object>tokens) throws Exception{	
 		return viewDaoOf(userContext).save(view, tokens);
 	}
 	protected View loadView(YoubenbenUserContext userContext, String viewId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfView(viewId);
		checkerOf(userContext).throwExceptionIfHasErrors( ViewManagerException.class);

 
 		return viewDaoOf(userContext).load(viewId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, View view, Map<String, Object> tokens){
		super.addActions(userContext, view, tokens);
		
		addAction(userContext, view, tokens,"@create","createView","createView/","main","primary");
		addAction(userContext, view, tokens,"@update","updateView","updateView/"+view.getId()+"/","main","primary");
		addAction(userContext, view, tokens,"@copy","cloneView","cloneView/"+view.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, View view, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public View createView(YoubenbenUserContext userContext, String who,String assessment,Date interviewTime) throws Exception
	//public View createView(YoubenbenUserContext userContext,String who, String assessment, Date interviewTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfView(who);
		checkerOf(userContext).checkAssessmentOfView(assessment);
		checkerOf(userContext).checkInterviewTimeOfView(interviewTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ViewManagerException.class);


		View view=createNewView();	

		view.setWho(who);
		view.setAssessment(assessment);
		view.setInterviewTime(interviewTime);

		view = saveView(userContext, view, emptyOptions());
		
		onNewInstanceCreated(userContext, view);
		return view;


	}
	protected View createNewView()
	{

		return new View();
	}

	protected void checkParamsForUpdatingView(YoubenbenUserContext userContext,String viewId, int viewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfView(viewId);
		checkerOf(userContext).checkVersionOfView( viewVersion);
		

		if(View.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfView(parseString(newValueExpr));
		
			
		}
		if(View.ASSESSMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAssessmentOfView(parseString(newValueExpr));
		
			
		}
		if(View.INTERVIEW_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkInterviewTimeOfView(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ViewManagerException.class);


	}



	public View clone(YoubenbenUserContext userContext, String fromViewId) throws Exception{

		return viewDaoOf(userContext).clone(fromViewId, this.allTokens());
	}

	public View internalSaveView(YoubenbenUserContext userContext, View view) throws Exception
	{
		return internalSaveView(userContext, view, allTokens());

	}
	public View internalSaveView(YoubenbenUserContext userContext, View view, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingView(userContext, viewId, viewVersion, property, newValueExpr, tokensExpr);


		synchronized(view){
			//will be good when the view loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to View.
			if (view.isChanged()){
			
			}
			view = saveView(userContext, view, options);
			return view;

		}

	}

	public View updateView(YoubenbenUserContext userContext,String viewId, int viewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingView(userContext, viewId, viewVersion, property, newValueExpr, tokensExpr);



		View view = loadView(userContext, viewId, allTokens());
		if(view.getVersion() != viewVersion){
			String message = "The target version("+view.getVersion()+") is not equals to version("+viewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(view){
			//will be good when the view loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to View.
			
			view.changeProperty(property, newValueExpr);
			view = saveView(userContext, view, tokens().done());
			return present(userContext,view, mergedAllTokens(tokensExpr));
			//return saveView(userContext, view, tokens().done());
		}

	}

	public View updateViewProperty(YoubenbenUserContext userContext,String viewId, int viewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingView(userContext, viewId, viewVersion, property, newValueExpr, tokensExpr);

		View view = loadView(userContext, viewId, allTokens());
		if(view.getVersion() != viewVersion){
			String message = "The target version("+view.getVersion()+") is not equals to version("+viewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(view){
			//will be good when the view loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to View.

			view.changeProperty(property, newValueExpr);
			
			view = saveView(userContext, view, tokens().done());
			return present(userContext,view, mergedAllTokens(tokensExpr));
			//return saveView(userContext, view, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ViewTokens tokens(){
		return ViewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ViewTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ViewTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String viewId, int viewVersion) throws Exception {
		//deleteInternal(userContext, viewId, viewVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String viewId, int viewVersion) throws Exception{

		viewDaoOf(userContext).delete(viewId, viewVersion);
	}

	public View forgetByAll(YoubenbenUserContext userContext, String viewId, int viewVersion) throws Exception {
		return forgetByAllInternal(userContext, viewId, viewVersion);
	}
	protected View forgetByAllInternal(YoubenbenUserContext userContext,
			String viewId, int viewVersion) throws Exception{

		return viewDaoOf(userContext).disconnectFromAll(viewId, viewVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ViewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return viewDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, View newCreated) throws Exception{
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
		//   View newView = this.createView(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newView
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, View.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<View> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String viewId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getViewDetailScope().clone();
		View merchantObj = (View) this.view(userContext, viewId);
    String merchantObjId = viewId;
    String linkToUrl =	"viewManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "观"+"详情";
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
				MapUtil.put("id", "3-assessment")
				    .put("fieldName", "assessment")
				    .put("label", "评估")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("assessment", merchantObj.getAssessment());

		propList.add(
				MapUtil.put("id", "4-interviewTime")
				    .put("fieldName", "interviewTime")
				    .put("label", "面试时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("interviewTime", merchantObj.getInterviewTime());

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


