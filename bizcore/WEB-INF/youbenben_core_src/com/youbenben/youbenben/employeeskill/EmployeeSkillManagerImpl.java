
package com.youbenben.youbenben.employeeskill;

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


import com.youbenben.youbenben.skilltype.SkillType;
import com.youbenben.youbenben.employee.Employee;

import com.youbenben.youbenben.skilltype.CandidateSkillType;
import com.youbenben.youbenben.employee.CandidateEmployee;







public class EmployeeSkillManagerImpl extends CustomYoubenbenCheckerManager implements EmployeeSkillManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "EmployeeSkill";
	@Override
	public EmployeeSkillDAO daoOf(YoubenbenUserContext userContext) {
		return employeeSkillDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws EmployeeSkillManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeeSkillManagerException(message);

	}



 	protected EmployeeSkill saveEmployeeSkill(YoubenbenUserContext userContext, EmployeeSkill employeeSkill, String [] tokensExpr) throws Exception{	
 		//return getEmployeeSkillDAO().save(employeeSkill, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeSkill(userContext, employeeSkill, tokens);
 	}
 	
 	protected EmployeeSkill saveEmployeeSkillDetail(YoubenbenUserContext userContext, EmployeeSkill employeeSkill) throws Exception{	

 		
 		return saveEmployeeSkill(userContext, employeeSkill, allTokens());
 	}
 	
 	public EmployeeSkill loadEmployeeSkill(YoubenbenUserContext userContext, String employeeSkillId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeSkillManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeSkill employeeSkill = loadEmployeeSkill( userContext, employeeSkillId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeSkill, tokens);
 	}
 	
 	
 	 public EmployeeSkill searchEmployeeSkill(YoubenbenUserContext userContext, String employeeSkillId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeSkillManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeSkill employeeSkill = loadEmployeeSkill( userContext, employeeSkillId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeSkill, tokens);
 	}
 	
 	

 	protected EmployeeSkill present(YoubenbenUserContext userContext, EmployeeSkill employeeSkill, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeSkill,tokens);
		
		
		EmployeeSkill  employeeSkillToPresent = employeeSkillDaoOf(userContext).present(employeeSkill, tokens);
		
		List<BaseEntity> entityListToNaming = employeeSkillToPresent.collectRefercencesFromLists();
		employeeSkillDaoOf(userContext).alias(entityListToNaming);
		
		return  employeeSkillToPresent;
		
		
	}
 
 	
 	
 	public EmployeeSkill loadEmployeeSkillDetail(YoubenbenUserContext userContext, String employeeSkillId) throws Exception{	
 		EmployeeSkill employeeSkill = loadEmployeeSkill( userContext, employeeSkillId, allTokens());
 		return present(userContext,employeeSkill, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String employeeSkillId) throws Exception{	
 		EmployeeSkill employeeSkill = loadEmployeeSkill( userContext, employeeSkillId, viewTokens());
 		return present(userContext,employeeSkill, allTokens());
		
 	}
 	protected EmployeeSkill saveEmployeeSkill(YoubenbenUserContext userContext, EmployeeSkill employeeSkill, Map<String,Object>tokens) throws Exception{	
 		return employeeSkillDaoOf(userContext).save(employeeSkill, tokens);
 	}
 	protected EmployeeSkill loadEmployeeSkill(YoubenbenUserContext userContext, String employeeSkillId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeSkillManagerException.class);

 
 		return employeeSkillDaoOf(userContext).load(employeeSkillId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, EmployeeSkill employeeSkill, Map<String, Object> tokens){
		super.addActions(userContext, employeeSkill, tokens);
		
		addAction(userContext, employeeSkill, tokens,"@create","createEmployeeSkill","createEmployeeSkill/","main","primary");
		addAction(userContext, employeeSkill, tokens,"@update","updateEmployeeSkill","updateEmployeeSkill/"+employeeSkill.getId()+"/","main","primary");
		addAction(userContext, employeeSkill, tokens,"@copy","cloneEmployeeSkill","cloneEmployeeSkill/"+employeeSkill.getId()+"/","main","primary");
		
		addAction(userContext, employeeSkill, tokens,"employee_skill.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeSkill.getId()+"/","main","primary");
		addAction(userContext, employeeSkill, tokens,"employee_skill.transfer_to_skill_type","transferToAnotherSkillType","transferToAnotherSkillType/"+employeeSkill.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, EmployeeSkill employeeSkill, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public EmployeeSkill createEmployeeSkill(YoubenbenUserContext userContext, String employeeId,String skillTypeId,String description) throws Exception
	//public EmployeeSkill createEmployeeSkill(YoubenbenUserContext userContext,String employeeId, String skillTypeId, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkDescriptionOfEmployeeSkill(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeSkillManagerException.class);


		EmployeeSkill employeeSkill=createNewEmployeeSkill();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeSkill.setEmployee(employee);
		
		
			
		SkillType skillType = loadSkillType(userContext, skillTypeId,emptyOptions());
		employeeSkill.setSkillType(skillType);
		
		
		employeeSkill.setDescription(description);

		employeeSkill = saveEmployeeSkill(userContext, employeeSkill, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeSkill);
		return employeeSkill;


	}
	protected EmployeeSkill createNewEmployeeSkill()
	{

		return new EmployeeSkill();
	}

	protected void checkParamsForUpdatingEmployeeSkill(YoubenbenUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
		checkerOf(userContext).checkVersionOfEmployeeSkill( employeeSkillVersion);
		
		

				

		
		if(EmployeeSkill.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfEmployeeSkill(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeSkillManagerException.class);


	}



	public EmployeeSkill clone(YoubenbenUserContext userContext, String fromEmployeeSkillId) throws Exception{

		return employeeSkillDaoOf(userContext).clone(fromEmployeeSkillId, this.allTokens());
	}

	public EmployeeSkill internalSaveEmployeeSkill(YoubenbenUserContext userContext, EmployeeSkill employeeSkill) throws Exception
	{
		return internalSaveEmployeeSkill(userContext, employeeSkill, allTokens());

	}
	public EmployeeSkill internalSaveEmployeeSkill(YoubenbenUserContext userContext, EmployeeSkill employeeSkill, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeeSkill(userContext, employeeSkillId, employeeSkillVersion, property, newValueExpr, tokensExpr);


		synchronized(employeeSkill){
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeSkill.
			if (employeeSkill.isChanged()){
			
			}
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, options);
			return employeeSkill;

		}

	}

	public EmployeeSkill updateEmployeeSkill(YoubenbenUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeSkill(userContext, employeeSkillId, employeeSkillVersion, property, newValueExpr, tokensExpr);



		EmployeeSkill employeeSkill = loadEmployeeSkill(userContext, employeeSkillId, allTokens());
		if(employeeSkill.getVersion() != employeeSkillVersion){
			String message = "The target version("+employeeSkill.getVersion()+") is not equals to version("+employeeSkillVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeSkill){
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeSkill.
			
			employeeSkill.changeProperty(property, newValueExpr);
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, tokens().done());
			return present(userContext,employeeSkill, mergedAllTokens(tokensExpr));
			//return saveEmployeeSkill(userContext, employeeSkill, tokens().done());
		}

	}

	public EmployeeSkill updateEmployeeSkillProperty(YoubenbenUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeSkill(userContext, employeeSkillId, employeeSkillVersion, property, newValueExpr, tokensExpr);

		EmployeeSkill employeeSkill = loadEmployeeSkill(userContext, employeeSkillId, allTokens());
		if(employeeSkill.getVersion() != employeeSkillVersion){
			String message = "The target version("+employeeSkill.getVersion()+") is not equals to version("+employeeSkillVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeSkill){
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeSkill.

			employeeSkill.changeProperty(property, newValueExpr);
			
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, tokens().done());
			return present(userContext,employeeSkill, mergedAllTokens(tokensExpr));
			//return saveEmployeeSkill(userContext, employeeSkill, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeeSkillTokens tokens(){
		return EmployeeSkillTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeSkillTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeSkillTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(YoubenbenUserContext userContext, String employeeSkillId, String anotherEmployeeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
 		checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeSkillManagerException.class);

 	}
 	public EmployeeSkill transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeSkillId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeSkillId,anotherEmployeeId);
 
		EmployeeSkill employeeSkill = loadEmployeeSkill(userContext, employeeSkillId, allTokens());	
		synchronized(employeeSkill){
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeSkill.updateEmployee(employee);		
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, emptyOptions());
			
			return present(userContext,employeeSkill, allTokens());
			
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
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeeSkill(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherSkillType(YoubenbenUserContext userContext, String employeeSkillId, String anotherSkillTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
 		checkerOf(userContext).checkIdOfSkillType(anotherSkillTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeSkillManagerException.class);

 	}
 	public EmployeeSkill transferToAnotherSkillType(YoubenbenUserContext userContext, String employeeSkillId, String anotherSkillTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherSkillType(userContext, employeeSkillId,anotherSkillTypeId);
 
		EmployeeSkill employeeSkill = loadEmployeeSkill(userContext, employeeSkillId, allTokens());	
		synchronized(employeeSkill){
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SkillType skillType = loadSkillType(userContext, anotherSkillTypeId, emptyOptions());		
			employeeSkill.updateSkillType(skillType);		
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, emptyOptions());
			
			return present(userContext,employeeSkill, allTokens());
			
		}

 	}

	


	public CandidateSkillType requestCandidateSkillType(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSkillType result = new CandidateSkillType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SkillType> candidateList = skillTypeDaoOf(userContext).requestCandidateSkillTypeForEmployeeSkill(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	


	

 	protected SkillType loadSkillType(YoubenbenUserContext userContext, String newSkillTypeId, Map<String,Object> options) throws Exception
 	{

 		return skillTypeDaoOf(userContext).load(newSkillTypeId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String employeeSkillId, int employeeSkillVersion) throws Exception {
		//deleteInternal(userContext, employeeSkillId, employeeSkillVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String employeeSkillId, int employeeSkillVersion) throws Exception{

		employeeSkillDaoOf(userContext).delete(employeeSkillId, employeeSkillVersion);
	}

	public EmployeeSkill forgetByAll(YoubenbenUserContext userContext, String employeeSkillId, int employeeSkillVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeSkillId, employeeSkillVersion);
	}
	protected EmployeeSkill forgetByAllInternal(YoubenbenUserContext userContext,
			String employeeSkillId, int employeeSkillVersion) throws Exception{

		return employeeSkillDaoOf(userContext).disconnectFromAll(employeeSkillId, employeeSkillVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeSkillManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return employeeSkillDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeSkill newCreated) throws Exception{
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
		//   EmployeeSkill newEmployeeSkill = this.createEmployeeSkill(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeSkill
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, EmployeeSkill.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<EmployeeSkill> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Employee> employeeList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
		userContext.getDAOGroup().enhanceList(employeeList, Employee.class);
		List<SkillType> skillTypeList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SkillType.class);
		userContext.getDAOGroup().enhanceList(skillTypeList, SkillType.class);


    }
	
	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception {
		return listPageByEmployee(userContext, employeeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception {
		SmartList<EmployeeSkill> list = employeeSkillDaoOf(userContext).findEmployeeSkillByEmployee(employeeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(EmployeeSkill.class);
		page.setContainerObject(Employee.withId(employeeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工技能列表");
		page.setRequestName("listByEmployee");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByEmployee/%s/",  getBeanName(), employeeId)));

		page.assemblerContent(userContext, "listByEmployee");
		return page.doRender(userContext);
	}
  
	public Object listBySkillType(YoubenbenUserContext userContext,String skillTypeId) throws Exception {
		return listPageBySkillType(userContext, skillTypeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySkillType(YoubenbenUserContext userContext,String skillTypeId, int start, int count) throws Exception {
		SmartList<EmployeeSkill> list = employeeSkillDaoOf(userContext).findEmployeeSkillBySkillType(skillTypeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(EmployeeSkill.class);
		page.setContainerObject(SkillType.withId(skillTypeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工技能列表");
		page.setRequestName("listBySkillType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listBySkillType/%s/",  getBeanName(), skillTypeId)));

		page.assemblerContent(userContext, "listBySkillType");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String employeeSkillId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getEmployeeSkillDetailScope().clone();
		EmployeeSkill merchantObj = (EmployeeSkill) this.view(userContext, employeeSkillId);
    String merchantObjId = employeeSkillId;
    String linkToUrl =	"employeeSkillManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工技能"+"详情";
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
				MapUtil.put("id", "3-skillType")
				    .put("fieldName", "skillType")
				    .put("label", "技能类型")
				    .put("type", "auto")
				    .put("linkToUrl", "skillTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"code\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("skillType", merchantObj.getSkillType());

		propList.add(
				MapUtil.put("id", "4-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

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


