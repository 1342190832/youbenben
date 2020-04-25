
package com.youbenben.youbenben.employeeinterview;

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


import com.youbenben.youbenben.interviewtype.InterviewType;
import com.youbenben.youbenben.employee.Employee;

import com.youbenben.youbenben.interviewtype.CandidateInterviewType;
import com.youbenben.youbenben.employee.CandidateEmployee;







public class EmployeeInterviewManagerImpl extends CustomYoubenbenCheckerManager implements EmployeeInterviewManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "EmployeeInterview";
	@Override
	public EmployeeInterviewDAO daoOf(YoubenbenUserContext userContext) {
		return employeeInterviewDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws EmployeeInterviewManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeeInterviewManagerException(message);

	}



 	protected EmployeeInterview saveEmployeeInterview(YoubenbenUserContext userContext, EmployeeInterview employeeInterview, String [] tokensExpr) throws Exception{	
 		//return getEmployeeInterviewDAO().save(employeeInterview, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeInterview(userContext, employeeInterview, tokens);
 	}
 	
 	protected EmployeeInterview saveEmployeeInterviewDetail(YoubenbenUserContext userContext, EmployeeInterview employeeInterview) throws Exception{	

 		
 		return saveEmployeeInterview(userContext, employeeInterview, allTokens());
 	}
 	
 	public EmployeeInterview loadEmployeeInterview(YoubenbenUserContext userContext, String employeeInterviewId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeInterviewManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeInterview, tokens);
 	}
 	
 	
 	 public EmployeeInterview searchEmployeeInterview(YoubenbenUserContext userContext, String employeeInterviewId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeInterviewManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeInterview, tokens);
 	}
 	
 	

 	protected EmployeeInterview present(YoubenbenUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeInterview,tokens);
		
		
		EmployeeInterview  employeeInterviewToPresent = employeeInterviewDaoOf(userContext).present(employeeInterview, tokens);
		
		List<BaseEntity> entityListToNaming = employeeInterviewToPresent.collectRefercencesFromLists();
		employeeInterviewDaoOf(userContext).alias(entityListToNaming);
		
		return  employeeInterviewToPresent;
		
		
	}
 
 	
 	
 	public EmployeeInterview loadEmployeeInterviewDetail(YoubenbenUserContext userContext, String employeeInterviewId) throws Exception{	
 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, allTokens());
 		return present(userContext,employeeInterview, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String employeeInterviewId) throws Exception{	
 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, viewTokens());
 		return present(userContext,employeeInterview, allTokens());
		
 	}
 	protected EmployeeInterview saveEmployeeInterview(YoubenbenUserContext userContext, EmployeeInterview employeeInterview, Map<String,Object>tokens) throws Exception{	
 		return employeeInterviewDaoOf(userContext).save(employeeInterview, tokens);
 	}
 	protected EmployeeInterview loadEmployeeInterview(YoubenbenUserContext userContext, String employeeInterviewId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeInterviewManagerException.class);

 
 		return employeeInterviewDaoOf(userContext).load(employeeInterviewId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens){
		super.addActions(userContext, employeeInterview, tokens);
		
		addAction(userContext, employeeInterview, tokens,"@create","createEmployeeInterview","createEmployeeInterview/","main","primary");
		addAction(userContext, employeeInterview, tokens,"@update","updateEmployeeInterview","updateEmployeeInterview/"+employeeInterview.getId()+"/","main","primary");
		addAction(userContext, employeeInterview, tokens,"@copy","cloneEmployeeInterview","cloneEmployeeInterview/"+employeeInterview.getId()+"/","main","primary");
		
		addAction(userContext, employeeInterview, tokens,"employee_interview.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeInterview.getId()+"/","main","primary");
		addAction(userContext, employeeInterview, tokens,"employee_interview.transfer_to_interview_type","transferToAnotherInterviewType","transferToAnotherInterviewType/"+employeeInterview.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public EmployeeInterview createEmployeeInterview(YoubenbenUserContext userContext, String employeeId,String interviewTypeId,String remark) throws Exception
	//public EmployeeInterview createEmployeeInterview(YoubenbenUserContext userContext,String employeeId, String interviewTypeId, String remark) throws Exception
	{

		

		

		checkerOf(userContext).checkRemarkOfEmployeeInterview(remark);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);


		EmployeeInterview employeeInterview=createNewEmployeeInterview();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeInterview.setEmployee(employee);
		
		
			
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId,emptyOptions());
		employeeInterview.setInterviewType(interviewType);
		
		
		employeeInterview.setRemark(remark);

		employeeInterview = saveEmployeeInterview(userContext, employeeInterview, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeInterview);
		return employeeInterview;


	}
	protected EmployeeInterview createNewEmployeeInterview()
	{

		return new EmployeeInterview();
	}

	protected void checkParamsForUpdatingEmployeeInterview(YoubenbenUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
		checkerOf(userContext).checkVersionOfEmployeeInterview( employeeInterviewVersion);
		
		

				

		
		if(EmployeeInterview.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeInterview(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);


	}



	public EmployeeInterview clone(YoubenbenUserContext userContext, String fromEmployeeInterviewId) throws Exception{

		return employeeInterviewDaoOf(userContext).clone(fromEmployeeInterviewId, this.allTokens());
	}

	public EmployeeInterview internalSaveEmployeeInterview(YoubenbenUserContext userContext, EmployeeInterview employeeInterview) throws Exception
	{
		return internalSaveEmployeeInterview(userContext, employeeInterview, allTokens());

	}
	public EmployeeInterview internalSaveEmployeeInterview(YoubenbenUserContext userContext, EmployeeInterview employeeInterview, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeeInterview(userContext, employeeInterviewId, employeeInterviewVersion, property, newValueExpr, tokensExpr);


		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeInterview.
			if (employeeInterview.isChanged()){
			
			}
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, options);
			return employeeInterview;

		}

	}

	public EmployeeInterview updateEmployeeInterview(YoubenbenUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeInterview(userContext, employeeInterviewId, employeeInterviewVersion, property, newValueExpr, tokensExpr);



		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());
		if(employeeInterview.getVersion() != employeeInterviewVersion){
			String message = "The target version("+employeeInterview.getVersion()+") is not equals to version("+employeeInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeInterview.
			
			employeeInterview.changeProperty(property, newValueExpr);
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, tokens().done());
			return present(userContext,employeeInterview, mergedAllTokens(tokensExpr));
			//return saveEmployeeInterview(userContext, employeeInterview, tokens().done());
		}

	}

	public EmployeeInterview updateEmployeeInterviewProperty(YoubenbenUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeInterview(userContext, employeeInterviewId, employeeInterviewVersion, property, newValueExpr, tokensExpr);

		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());
		if(employeeInterview.getVersion() != employeeInterviewVersion){
			String message = "The target version("+employeeInterview.getVersion()+") is not equals to version("+employeeInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeInterview.

			employeeInterview.changeProperty(property, newValueExpr);
			
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, tokens().done());
			return present(userContext,employeeInterview, mergedAllTokens(tokensExpr));
			//return saveEmployeeInterview(userContext, employeeInterview, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeeInterviewTokens tokens(){
		return EmployeeInterviewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeInterviewTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeInterviewTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(YoubenbenUserContext userContext, String employeeInterviewId, String anotherEmployeeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
 		checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);

 	}
 	public EmployeeInterview transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeInterviewId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeInterviewId,anotherEmployeeId);
 
		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());	
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeInterview.updateEmployee(employee);		
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, emptyOptions());
			
			return present(userContext,employeeInterview, allTokens());
			
		}

 	}

	


	public CandidateEmployee requestCandidateEmployee(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateEmployee result = new CandidateEmployee();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("company");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeeInterview(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherInterviewType(YoubenbenUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
 		checkerOf(userContext).checkIdOfInterviewType(anotherInterviewTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);

 	}
 	public EmployeeInterview transferToAnotherInterviewType(YoubenbenUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherInterviewType(userContext, employeeInterviewId,anotherInterviewTypeId);
 
		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());	
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			InterviewType interviewType = loadInterviewType(userContext, anotherInterviewTypeId, emptyOptions());		
			employeeInterview.updateInterviewType(interviewType);		
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, emptyOptions());
			
			return present(userContext,employeeInterview, allTokens());
			
		}

 	}

	


	public CandidateInterviewType requestCandidateInterviewType(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateInterviewType result = new CandidateInterviewType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<InterviewType> candidateList = interviewTypeDaoOf(userContext).requestCandidateInterviewTypeForEmployeeInterview(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Employee loadEmployee(YoubenbenUserContext userContext, String newEmployeeId, Map<String,Object> options) throws Exception
 	{

 		return employeeDaoOf(userContext).load(newEmployeeId, options);
 	}
 	


	

 	protected InterviewType loadInterviewType(YoubenbenUserContext userContext, String newInterviewTypeId, Map<String,Object> options) throws Exception
 	{

 		return interviewTypeDaoOf(userContext).load(newInterviewTypeId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String employeeInterviewId, int employeeInterviewVersion) throws Exception {
		//deleteInternal(userContext, employeeInterviewId, employeeInterviewVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String employeeInterviewId, int employeeInterviewVersion) throws Exception{

		employeeInterviewDaoOf(userContext).delete(employeeInterviewId, employeeInterviewVersion);
	}

	public EmployeeInterview forgetByAll(YoubenbenUserContext userContext, String employeeInterviewId, int employeeInterviewVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeInterviewId, employeeInterviewVersion);
	}
	protected EmployeeInterview forgetByAllInternal(YoubenbenUserContext userContext,
			String employeeInterviewId, int employeeInterviewVersion) throws Exception{

		return employeeInterviewDaoOf(userContext).disconnectFromAll(employeeInterviewId, employeeInterviewVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeInterviewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return employeeInterviewDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeInterview newCreated) throws Exception{
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
		//   EmployeeInterview newEmployeeInterview = this.createEmployeeInterview(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeInterview
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, EmployeeInterview.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<EmployeeInterview> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Employee> employeeList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
		userContext.getDAOGroup().enhanceList(employeeList, Employee.class);
		List<InterviewType> interviewTypeList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, InterviewType.class);
		userContext.getDAOGroup().enhanceList(interviewTypeList, InterviewType.class);


    }
	
	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception {
		return listPageByEmployee(userContext, employeeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception {
		SmartList<EmployeeInterview> list = employeeInterviewDaoOf(userContext).findEmployeeInterviewByEmployee(employeeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(EmployeeInterview.class);
		page.setContainerObject(Employee.withId(employeeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工面试列表");
		page.setRequestName("listByEmployee");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByEmployee/%s/",  getBeanName(), employeeId)));

		page.assemblerContent(userContext, "listByEmployee");
		return page.doRender(userContext);
	}
  
	public Object listByInterviewType(YoubenbenUserContext userContext,String interviewTypeId) throws Exception {
		return listPageByInterviewType(userContext, interviewTypeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByInterviewType(YoubenbenUserContext userContext,String interviewTypeId, int start, int count) throws Exception {
		SmartList<EmployeeInterview> list = employeeInterviewDaoOf(userContext).findEmployeeInterviewByInterviewType(interviewTypeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(EmployeeInterview.class);
		page.setContainerObject(InterviewType.withId(interviewTypeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工面试列表");
		page.setRequestName("listByInterviewType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByInterviewType/%s/",  getBeanName(), interviewTypeId)));

		page.assemblerContent(userContext, "listByInterviewType");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String employeeInterviewId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getEmployeeInterviewDetailScope().clone();
		EmployeeInterview merchantObj = (EmployeeInterview) this.view(userContext, employeeInterviewId);
    String merchantObjId = employeeInterviewId;
    String linkToUrl =	"employeeInterviewManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工面试"+"详情";
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
				MapUtil.put("id", "2-employee")
				    .put("fieldName", "employee")
				    .put("label", "员工")
				    .put("type", "auto")
				    .put("linkToUrl", "employeeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"family_name\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("employee", merchantObj.getEmployee());

		propList.add(
				MapUtil.put("id", "3-interviewType")
				    .put("fieldName", "interviewType")
				    .put("label", "面试类型")
				    .put("type", "auto")
				    .put("linkToUrl", "interviewTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"code\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("interviewType", merchantObj.getInterviewType());

		propList.add(
				MapUtil.put("id", "4-remark")
				    .put("fieldName", "remark")
				    .put("label", "备注")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("remark", merchantObj.getRemark());

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


