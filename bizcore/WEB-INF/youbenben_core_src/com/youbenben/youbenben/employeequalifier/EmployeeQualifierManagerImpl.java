
package com.youbenben.youbenben.employeequalifier;

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


import com.youbenben.youbenben.employee.Employee;

import com.youbenben.youbenben.employee.CandidateEmployee;







public class EmployeeQualifierManagerImpl extends CustomYoubenbenCheckerManager implements EmployeeQualifierManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "EmployeeQualifier";
	@Override
	public EmployeeQualifierDAO daoOf(YoubenbenUserContext userContext) {
		return employeeQualifierDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws EmployeeQualifierManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeeQualifierManagerException(message);

	}



 	protected EmployeeQualifier saveEmployeeQualifier(YoubenbenUserContext userContext, EmployeeQualifier employeeQualifier, String [] tokensExpr) throws Exception{	
 		//return getEmployeeQualifierDAO().save(employeeQualifier, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeQualifier(userContext, employeeQualifier, tokens);
 	}
 	
 	protected EmployeeQualifier saveEmployeeQualifierDetail(YoubenbenUserContext userContext, EmployeeQualifier employeeQualifier) throws Exception{	

 		
 		return saveEmployeeQualifier(userContext, employeeQualifier, allTokens());
 	}
 	
 	public EmployeeQualifier loadEmployeeQualifier(YoubenbenUserContext userContext, String employeeQualifierId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeQualifierManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeQualifier employeeQualifier = loadEmployeeQualifier( userContext, employeeQualifierId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeQualifier, tokens);
 	}
 	
 	
 	 public EmployeeQualifier searchEmployeeQualifier(YoubenbenUserContext userContext, String employeeQualifierId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeQualifierManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeQualifier employeeQualifier = loadEmployeeQualifier( userContext, employeeQualifierId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeQualifier, tokens);
 	}
 	
 	

 	protected EmployeeQualifier present(YoubenbenUserContext userContext, EmployeeQualifier employeeQualifier, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeQualifier,tokens);
		
		
		EmployeeQualifier  employeeQualifierToPresent = employeeQualifierDaoOf(userContext).present(employeeQualifier, tokens);
		
		List<BaseEntity> entityListToNaming = employeeQualifierToPresent.collectRefercencesFromLists();
		employeeQualifierDaoOf(userContext).alias(entityListToNaming);
		
		return  employeeQualifierToPresent;
		
		
	}
 
 	
 	
 	public EmployeeQualifier loadEmployeeQualifierDetail(YoubenbenUserContext userContext, String employeeQualifierId) throws Exception{	
 		EmployeeQualifier employeeQualifier = loadEmployeeQualifier( userContext, employeeQualifierId, allTokens());
 		return present(userContext,employeeQualifier, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String employeeQualifierId) throws Exception{	
 		EmployeeQualifier employeeQualifier = loadEmployeeQualifier( userContext, employeeQualifierId, viewTokens());
 		return present(userContext,employeeQualifier, allTokens());
		
 	}
 	protected EmployeeQualifier saveEmployeeQualifier(YoubenbenUserContext userContext, EmployeeQualifier employeeQualifier, Map<String,Object>tokens) throws Exception{	
 		return employeeQualifierDaoOf(userContext).save(employeeQualifier, tokens);
 	}
 	protected EmployeeQualifier loadEmployeeQualifier(YoubenbenUserContext userContext, String employeeQualifierId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeQualifierManagerException.class);

 
 		return employeeQualifierDaoOf(userContext).load(employeeQualifierId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, EmployeeQualifier employeeQualifier, Map<String, Object> tokens){
		super.addActions(userContext, employeeQualifier, tokens);
		
		addAction(userContext, employeeQualifier, tokens,"@create","createEmployeeQualifier","createEmployeeQualifier/","main","primary");
		addAction(userContext, employeeQualifier, tokens,"@update","updateEmployeeQualifier","updateEmployeeQualifier/"+employeeQualifier.getId()+"/","main","primary");
		addAction(userContext, employeeQualifier, tokens,"@copy","cloneEmployeeQualifier","cloneEmployeeQualifier/"+employeeQualifier.getId()+"/","main","primary");
		
		addAction(userContext, employeeQualifier, tokens,"employee_qualifier.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeQualifier.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, EmployeeQualifier employeeQualifier, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public EmployeeQualifier createEmployeeQualifier(YoubenbenUserContext userContext, String employeeId,Date qualifiedTime,String type,String level,String remark) throws Exception
	//public EmployeeQualifier createEmployeeQualifier(YoubenbenUserContext userContext,String employeeId, Date qualifiedTime, String type, String level, String remark) throws Exception
	{

		

		

		checkerOf(userContext).checkQualifiedTimeOfEmployeeQualifier(qualifiedTime);
		checkerOf(userContext).checkTypeOfEmployeeQualifier(type);
		checkerOf(userContext).checkLevelOfEmployeeQualifier(level);
		checkerOf(userContext).checkRemarkOfEmployeeQualifier(remark);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeQualifierManagerException.class);


		EmployeeQualifier employeeQualifier=createNewEmployeeQualifier();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeQualifier.setEmployee(employee);
		
		
		employeeQualifier.setQualifiedTime(qualifiedTime);
		employeeQualifier.setType(type);
		employeeQualifier.setLevel(level);
		employeeQualifier.setRemark(remark);

		employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeQualifier);
		return employeeQualifier;


	}
	protected EmployeeQualifier createNewEmployeeQualifier()
	{

		return new EmployeeQualifier();
	}

	protected void checkParamsForUpdatingEmployeeQualifier(YoubenbenUserContext userContext,String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);
		checkerOf(userContext).checkVersionOfEmployeeQualifier( employeeQualifierVersion);
		
		

		
		if(EmployeeQualifier.QUALIFIED_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkQualifiedTimeOfEmployeeQualifier(parseDate(newValueExpr));
		
			
		}
		if(EmployeeQualifier.TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTypeOfEmployeeQualifier(parseString(newValueExpr));
		
			
		}
		if(EmployeeQualifier.LEVEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLevelOfEmployeeQualifier(parseString(newValueExpr));
		
			
		}
		if(EmployeeQualifier.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeQualifier(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeQualifierManagerException.class);


	}



	public EmployeeQualifier clone(YoubenbenUserContext userContext, String fromEmployeeQualifierId) throws Exception{

		return employeeQualifierDaoOf(userContext).clone(fromEmployeeQualifierId, this.allTokens());
	}

	public EmployeeQualifier internalSaveEmployeeQualifier(YoubenbenUserContext userContext, EmployeeQualifier employeeQualifier) throws Exception
	{
		return internalSaveEmployeeQualifier(userContext, employeeQualifier, allTokens());

	}
	public EmployeeQualifier internalSaveEmployeeQualifier(YoubenbenUserContext userContext, EmployeeQualifier employeeQualifier, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeeQualifier(userContext, employeeQualifierId, employeeQualifierVersion, property, newValueExpr, tokensExpr);


		synchronized(employeeQualifier){
			//will be good when the employeeQualifier loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeQualifier.
			if (employeeQualifier.isChanged()){
			
			}
			employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, options);
			return employeeQualifier;

		}

	}

	public EmployeeQualifier updateEmployeeQualifier(YoubenbenUserContext userContext,String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeQualifier(userContext, employeeQualifierId, employeeQualifierVersion, property, newValueExpr, tokensExpr);



		EmployeeQualifier employeeQualifier = loadEmployeeQualifier(userContext, employeeQualifierId, allTokens());
		if(employeeQualifier.getVersion() != employeeQualifierVersion){
			String message = "The target version("+employeeQualifier.getVersion()+") is not equals to version("+employeeQualifierVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeQualifier){
			//will be good when the employeeQualifier loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeQualifier.
			
			employeeQualifier.changeProperty(property, newValueExpr);
			employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, tokens().done());
			return present(userContext,employeeQualifier, mergedAllTokens(tokensExpr));
			//return saveEmployeeQualifier(userContext, employeeQualifier, tokens().done());
		}

	}

	public EmployeeQualifier updateEmployeeQualifierProperty(YoubenbenUserContext userContext,String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeQualifier(userContext, employeeQualifierId, employeeQualifierVersion, property, newValueExpr, tokensExpr);

		EmployeeQualifier employeeQualifier = loadEmployeeQualifier(userContext, employeeQualifierId, allTokens());
		if(employeeQualifier.getVersion() != employeeQualifierVersion){
			String message = "The target version("+employeeQualifier.getVersion()+") is not equals to version("+employeeQualifierVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeQualifier){
			//will be good when the employeeQualifier loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeQualifier.

			employeeQualifier.changeProperty(property, newValueExpr);
			
			employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, tokens().done());
			return present(userContext,employeeQualifier, mergedAllTokens(tokensExpr));
			//return saveEmployeeQualifier(userContext, employeeQualifier, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeeQualifierTokens tokens(){
		return EmployeeQualifierTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeQualifierTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeQualifierTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(YoubenbenUserContext userContext, String employeeQualifierId, String anotherEmployeeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);
 		checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeQualifierManagerException.class);

 	}
 	public EmployeeQualifier transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeQualifierId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeQualifierId,anotherEmployeeId);
 
		EmployeeQualifier employeeQualifier = loadEmployeeQualifier(userContext, employeeQualifierId, allTokens());	
		synchronized(employeeQualifier){
			//will be good when the employeeQualifier loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeQualifier.updateEmployee(employee);		
			employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, emptyOptions());
			
			return present(userContext,employeeQualifier, allTokens());
			
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
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeeQualifier(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String employeeQualifierId, int employeeQualifierVersion) throws Exception {
		//deleteInternal(userContext, employeeQualifierId, employeeQualifierVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String employeeQualifierId, int employeeQualifierVersion) throws Exception{

		employeeQualifierDaoOf(userContext).delete(employeeQualifierId, employeeQualifierVersion);
	}

	public EmployeeQualifier forgetByAll(YoubenbenUserContext userContext, String employeeQualifierId, int employeeQualifierVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeQualifierId, employeeQualifierVersion);
	}
	protected EmployeeQualifier forgetByAllInternal(YoubenbenUserContext userContext,
			String employeeQualifierId, int employeeQualifierVersion) throws Exception{

		return employeeQualifierDaoOf(userContext).disconnectFromAll(employeeQualifierId, employeeQualifierVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeQualifierManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return employeeQualifierDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeQualifier newCreated) throws Exception{
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
		//   EmployeeQualifier newEmployeeQualifier = this.createEmployeeQualifier(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeQualifier
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, EmployeeQualifier.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<EmployeeQualifier> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Employee> employeeList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
		userContext.getDAOGroup().enhanceList(employeeList, Employee.class);


    }
	
	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception {
		return listPageByEmployee(userContext, employeeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception {
		SmartList<EmployeeQualifier> list = employeeQualifierDaoOf(userContext).findEmployeeQualifierByEmployee(employeeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(EmployeeQualifier.class);
		page.setContainerObject(Employee.withId(employeeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工资质列表");
		page.setRequestName("listByEmployee");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByEmployee/%s/",  getBeanName(), employeeId)));

		page.assemblerContent(userContext, "listByEmployee");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String employeeQualifierId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getEmployeeQualifierDetailScope().clone();
		EmployeeQualifier merchantObj = (EmployeeQualifier) this.view(userContext, employeeQualifierId);
    String merchantObjId = employeeQualifierId;
    String linkToUrl =	"employeeQualifierManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工资质"+"详情";
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
				MapUtil.put("id", "3-qualifiedTime")
				    .put("fieldName", "qualifiedTime")
				    .put("label", "合格的时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("qualifiedTime", merchantObj.getQualifiedTime());

		propList.add(
				MapUtil.put("id", "4-type")
				    .put("fieldName", "type")
				    .put("label", "类型")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("type", merchantObj.getType());

		propList.add(
				MapUtil.put("id", "5-level")
				    .put("fieldName", "level")
				    .put("label", "水平")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("level", merchantObj.getLevel());

		propList.add(
				MapUtil.put("id", "6-remark")
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


