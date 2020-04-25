
package com.youbenben.youbenben.citycenteremployee;

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


import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartment;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;

import com.youbenben.youbenben.citycenterdepartment.CandidateCityCenterDepartment;
import com.youbenben.youbenben.franchisedoutletcitycenter.CandidateFranchisedOutletCityCenter;







public class CityCenterEmployeeManagerImpl extends CustomYoubenbenCheckerManager implements CityCenterEmployeeManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "CityCenterEmployee";
	@Override
	public CityCenterEmployeeDAO daoOf(YoubenbenUserContext userContext) {
		return cityCenterEmployeeDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws CityCenterEmployeeManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new CityCenterEmployeeManagerException(message);

	}



 	protected CityCenterEmployee saveCityCenterEmployee(YoubenbenUserContext userContext, CityCenterEmployee cityCenterEmployee, String [] tokensExpr) throws Exception{	
 		//return getCityCenterEmployeeDAO().save(cityCenterEmployee, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCityCenterEmployee(userContext, cityCenterEmployee, tokens);
 	}
 	
 	protected CityCenterEmployee saveCityCenterEmployeeDetail(YoubenbenUserContext userContext, CityCenterEmployee cityCenterEmployee) throws Exception{	

 		
 		return saveCityCenterEmployee(userContext, cityCenterEmployee, allTokens());
 	}
 	
 	public CityCenterEmployee loadCityCenterEmployee(YoubenbenUserContext userContext, String cityCenterEmployeeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityCenterEmployeeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CityCenterEmployee cityCenterEmployee = loadCityCenterEmployee( userContext, cityCenterEmployeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityCenterEmployee, tokens);
 	}
 	
 	
 	 public CityCenterEmployee searchCityCenterEmployee(YoubenbenUserContext userContext, String cityCenterEmployeeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityCenterEmployeeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CityCenterEmployee cityCenterEmployee = loadCityCenterEmployee( userContext, cityCenterEmployeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityCenterEmployee, tokens);
 	}
 	
 	

 	protected CityCenterEmployee present(YoubenbenUserContext userContext, CityCenterEmployee cityCenterEmployee, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,cityCenterEmployee,tokens);
		
		
		CityCenterEmployee  cityCenterEmployeeToPresent = cityCenterEmployeeDaoOf(userContext).present(cityCenterEmployee, tokens);
		
		List<BaseEntity> entityListToNaming = cityCenterEmployeeToPresent.collectRefercencesFromLists();
		cityCenterEmployeeDaoOf(userContext).alias(entityListToNaming);
		
		return  cityCenterEmployeeToPresent;
		
		
	}
 
 	
 	
 	public CityCenterEmployee loadCityCenterEmployeeDetail(YoubenbenUserContext userContext, String cityCenterEmployeeId) throws Exception{	
 		CityCenterEmployee cityCenterEmployee = loadCityCenterEmployee( userContext, cityCenterEmployeeId, allTokens());
 		return present(userContext,cityCenterEmployee, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String cityCenterEmployeeId) throws Exception{	
 		CityCenterEmployee cityCenterEmployee = loadCityCenterEmployee( userContext, cityCenterEmployeeId, viewTokens());
 		return present(userContext,cityCenterEmployee, allTokens());
		
 	}
 	protected CityCenterEmployee saveCityCenterEmployee(YoubenbenUserContext userContext, CityCenterEmployee cityCenterEmployee, Map<String,Object>tokens) throws Exception{	
 		return cityCenterEmployeeDaoOf(userContext).save(cityCenterEmployee, tokens);
 	}
 	protected CityCenterEmployee loadCityCenterEmployee(YoubenbenUserContext userContext, String cityCenterEmployeeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityCenterEmployeeManagerException.class);

 
 		return cityCenterEmployeeDaoOf(userContext).load(cityCenterEmployeeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, CityCenterEmployee cityCenterEmployee, Map<String, Object> tokens){
		super.addActions(userContext, cityCenterEmployee, tokens);
		
		addAction(userContext, cityCenterEmployee, tokens,"@create","createCityCenterEmployee","createCityCenterEmployee/","main","primary");
		addAction(userContext, cityCenterEmployee, tokens,"@update","updateCityCenterEmployee","updateCityCenterEmployee/"+cityCenterEmployee.getId()+"/","main","primary");
		addAction(userContext, cityCenterEmployee, tokens,"@copy","cloneCityCenterEmployee","cloneCityCenterEmployee/"+cityCenterEmployee.getId()+"/","main","primary");
		
		addAction(userContext, cityCenterEmployee, tokens,"city_center_employee.transfer_to_department","transferToAnotherDepartment","transferToAnotherDepartment/"+cityCenterEmployee.getId()+"/","main","primary");
		addAction(userContext, cityCenterEmployee, tokens,"city_center_employee.transfer_to_city_center","transferToAnotherCityCenter","transferToAnotherCityCenter/"+cityCenterEmployee.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, CityCenterEmployee cityCenterEmployee, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public CityCenterEmployee createCityCenterEmployee(YoubenbenUserContext userContext, String name,String mobile,String email,Date founded,String departmentId,String cityCenterId) throws Exception
	//public CityCenterEmployee createCityCenterEmployee(YoubenbenUserContext userContext,String name, String mobile, String email, Date founded, String departmentId, String cityCenterId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfCityCenterEmployee(name);
		checkerOf(userContext).checkMobileOfCityCenterEmployee(mobile);
		checkerOf(userContext).checkEmailOfCityCenterEmployee(email);
		checkerOf(userContext).checkFoundedOfCityCenterEmployee(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterEmployeeManagerException.class);


		CityCenterEmployee cityCenterEmployee=createNewCityCenterEmployee();	

		cityCenterEmployee.setName(name);
		cityCenterEmployee.setMobile(mobile);
		cityCenterEmployee.setEmail(email);
		cityCenterEmployee.setFounded(founded);
			
		CityCenterDepartment department = loadCityCenterDepartment(userContext, departmentId,emptyOptions());
		cityCenterEmployee.setDepartment(department);
		
		
			
		FranchisedOutletCityCenter cityCenter = loadFranchisedOutletCityCenter(userContext, cityCenterId,emptyOptions());
		cityCenterEmployee.setCityCenter(cityCenter);
		
		

		cityCenterEmployee = saveCityCenterEmployee(userContext, cityCenterEmployee, emptyOptions());
		
		onNewInstanceCreated(userContext, cityCenterEmployee);
		return cityCenterEmployee;


	}
	protected CityCenterEmployee createNewCityCenterEmployee()
	{

		return new CityCenterEmployee();
	}

	protected void checkParamsForUpdatingCityCenterEmployee(YoubenbenUserContext userContext,String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeId);
		checkerOf(userContext).checkVersionOfCityCenterEmployee( cityCenterEmployeeVersion);
		

		if(CityCenterEmployee.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCityCenterEmployee(parseString(newValueExpr));
		
			
		}
		if(CityCenterEmployee.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfCityCenterEmployee(parseString(newValueExpr));
		
			
		}
		if(CityCenterEmployee.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfCityCenterEmployee(parseString(newValueExpr));
		
			
		}
		if(CityCenterEmployee.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfCityCenterEmployee(parseDate(newValueExpr));
		
			
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterEmployeeManagerException.class);


	}



	public CityCenterEmployee clone(YoubenbenUserContext userContext, String fromCityCenterEmployeeId) throws Exception{

		return cityCenterEmployeeDaoOf(userContext).clone(fromCityCenterEmployeeId, this.allTokens());
	}

	public CityCenterEmployee internalSaveCityCenterEmployee(YoubenbenUserContext userContext, CityCenterEmployee cityCenterEmployee) throws Exception
	{
		return internalSaveCityCenterEmployee(userContext, cityCenterEmployee, allTokens());

	}
	public CityCenterEmployee internalSaveCityCenterEmployee(YoubenbenUserContext userContext, CityCenterEmployee cityCenterEmployee, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingCityCenterEmployee(userContext, cityCenterEmployeeId, cityCenterEmployeeVersion, property, newValueExpr, tokensExpr);


		synchronized(cityCenterEmployee){
			//will be good when the cityCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityCenterEmployee.
			if (cityCenterEmployee.isChanged()){
			
			}
			cityCenterEmployee = saveCityCenterEmployee(userContext, cityCenterEmployee, options);
			return cityCenterEmployee;

		}

	}

	public CityCenterEmployee updateCityCenterEmployee(YoubenbenUserContext userContext,String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityCenterEmployee(userContext, cityCenterEmployeeId, cityCenterEmployeeVersion, property, newValueExpr, tokensExpr);



		CityCenterEmployee cityCenterEmployee = loadCityCenterEmployee(userContext, cityCenterEmployeeId, allTokens());
		if(cityCenterEmployee.getVersion() != cityCenterEmployeeVersion){
			String message = "The target version("+cityCenterEmployee.getVersion()+") is not equals to version("+cityCenterEmployeeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(cityCenterEmployee){
			//will be good when the cityCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityCenterEmployee.
			
			cityCenterEmployee.changeProperty(property, newValueExpr);
			cityCenterEmployee = saveCityCenterEmployee(userContext, cityCenterEmployee, tokens().done());
			return present(userContext,cityCenterEmployee, mergedAllTokens(tokensExpr));
			//return saveCityCenterEmployee(userContext, cityCenterEmployee, tokens().done());
		}

	}

	public CityCenterEmployee updateCityCenterEmployeeProperty(YoubenbenUserContext userContext,String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityCenterEmployee(userContext, cityCenterEmployeeId, cityCenterEmployeeVersion, property, newValueExpr, tokensExpr);

		CityCenterEmployee cityCenterEmployee = loadCityCenterEmployee(userContext, cityCenterEmployeeId, allTokens());
		if(cityCenterEmployee.getVersion() != cityCenterEmployeeVersion){
			String message = "The target version("+cityCenterEmployee.getVersion()+") is not equals to version("+cityCenterEmployeeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(cityCenterEmployee){
			//will be good when the cityCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityCenterEmployee.

			cityCenterEmployee.changeProperty(property, newValueExpr);
			
			cityCenterEmployee = saveCityCenterEmployee(userContext, cityCenterEmployee, tokens().done());
			return present(userContext,cityCenterEmployee, mergedAllTokens(tokensExpr));
			//return saveCityCenterEmployee(userContext, cityCenterEmployee, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected CityCenterEmployeeTokens tokens(){
		return CityCenterEmployeeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CityCenterEmployeeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CityCenterEmployeeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDepartment(YoubenbenUserContext userContext, String cityCenterEmployeeId, String anotherDepartmentId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeId);
 		checkerOf(userContext).checkIdOfCityCenterDepartment(anotherDepartmentId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterEmployeeManagerException.class);

 	}
 	public CityCenterEmployee transferToAnotherDepartment(YoubenbenUserContext userContext, String cityCenterEmployeeId, String anotherDepartmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherDepartment(userContext, cityCenterEmployeeId,anotherDepartmentId);
 
		CityCenterEmployee cityCenterEmployee = loadCityCenterEmployee(userContext, cityCenterEmployeeId, allTokens());	
		synchronized(cityCenterEmployee){
			//will be good when the cityCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CityCenterDepartment department = loadCityCenterDepartment(userContext, anotherDepartmentId, emptyOptions());		
			cityCenterEmployee.updateDepartment(department);		
			cityCenterEmployee = saveCityCenterEmployee(userContext, cityCenterEmployee, emptyOptions());
			
			return present(userContext,cityCenterEmployee, allTokens());
			
		}

 	}

	


	public CandidateCityCenterDepartment requestCandidateDepartment(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCityCenterDepartment result = new CandidateCityCenterDepartment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<CityCenterDepartment> candidateList = cityCenterDepartmentDaoOf(userContext).requestCandidateCityCenterDepartmentForCityCenterEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherCityCenter(YoubenbenUserContext userContext, String cityCenterEmployeeId, String anotherCityCenterId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCityCenterEmployee(cityCenterEmployeeId);
 		checkerOf(userContext).checkIdOfFranchisedOutletCityCenter(anotherCityCenterId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CityCenterEmployeeManagerException.class);

 	}
 	public CityCenterEmployee transferToAnotherCityCenter(YoubenbenUserContext userContext, String cityCenterEmployeeId, String anotherCityCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityCenter(userContext, cityCenterEmployeeId,anotherCityCenterId);
 
		CityCenterEmployee cityCenterEmployee = loadCityCenterEmployee(userContext, cityCenterEmployeeId, allTokens());	
		synchronized(cityCenterEmployee){
			//will be good when the cityCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			FranchisedOutletCityCenter cityCenter = loadFranchisedOutletCityCenter(userContext, anotherCityCenterId, emptyOptions());		
			cityCenterEmployee.updateCityCenter(cityCenter);		
			cityCenterEmployee = saveCityCenterEmployee(userContext, cityCenterEmployee, emptyOptions());
			
			return present(userContext,cityCenterEmployee, allTokens());
			
		}

 	}

	


	public CandidateFranchisedOutletCityCenter requestCandidateCityCenter(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateFranchisedOutletCityCenter result = new CandidateFranchisedOutletCityCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<FranchisedOutletCityCenter> candidateList = franchisedOutletCityCenterDaoOf(userContext).requestCandidateFranchisedOutletCityCenterForCityCenterEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected CityCenterDepartment loadCityCenterDepartment(YoubenbenUserContext userContext, String newDepartmentId, Map<String,Object> options) throws Exception
 	{

 		return cityCenterDepartmentDaoOf(userContext).load(newDepartmentId, options);
 	}
 	


	

 	protected FranchisedOutletCityCenter loadFranchisedOutletCityCenter(YoubenbenUserContext userContext, String newCityCenterId, Map<String,Object> options) throws Exception
 	{

 		return franchisedOutletCityCenterDaoOf(userContext).load(newCityCenterId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String cityCenterEmployeeId, int cityCenterEmployeeVersion) throws Exception {
		//deleteInternal(userContext, cityCenterEmployeeId, cityCenterEmployeeVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String cityCenterEmployeeId, int cityCenterEmployeeVersion) throws Exception{

		cityCenterEmployeeDaoOf(userContext).delete(cityCenterEmployeeId, cityCenterEmployeeVersion);
	}

	public CityCenterEmployee forgetByAll(YoubenbenUserContext userContext, String cityCenterEmployeeId, int cityCenterEmployeeVersion) throws Exception {
		return forgetByAllInternal(userContext, cityCenterEmployeeId, cityCenterEmployeeVersion);
	}
	protected CityCenterEmployee forgetByAllInternal(YoubenbenUserContext userContext,
			String cityCenterEmployeeId, int cityCenterEmployeeVersion) throws Exception{

		return cityCenterEmployeeDaoOf(userContext).disconnectFromAll(cityCenterEmployeeId, cityCenterEmployeeVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CityCenterEmployeeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return cityCenterEmployeeDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, CityCenterEmployee newCreated) throws Exception{
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
		//   CityCenterEmployee newCityCenterEmployee = this.createCityCenterEmployee(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newCityCenterEmployee
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, CityCenterEmployee.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<CityCenterEmployee> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<CityCenterDepartment> departmentList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, CityCenterDepartment.class);
		userContext.getDAOGroup().enhanceList(departmentList, CityCenterDepartment.class);
		List<FranchisedOutletCityCenter> cityCenterList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, FranchisedOutletCityCenter.class);
		userContext.getDAOGroup().enhanceList(cityCenterList, FranchisedOutletCityCenter.class);


    }
	
	public Object listByDepartment(YoubenbenUserContext userContext,String departmentId) throws Exception {
		return listPageByDepartment(userContext, departmentId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDepartment(YoubenbenUserContext userContext,String departmentId, int start, int count) throws Exception {
		SmartList<CityCenterEmployee> list = cityCenterEmployeeDaoOf(userContext).findCityCenterEmployeeByDepartment(departmentId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(CityCenterEmployee.class);
		page.setContainerObject(CityCenterDepartment.withId(departmentId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("城市中心的员工列表");
		page.setRequestName("listByDepartment");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDepartment/%s/",  getBeanName(), departmentId)));

		page.assemblerContent(userContext, "listByDepartment");
		return page.doRender(userContext);
	}
  
	public Object listByCityCenter(YoubenbenUserContext userContext,String cityCenterId) throws Exception {
		return listPageByCityCenter(userContext, cityCenterId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCityCenter(YoubenbenUserContext userContext,String cityCenterId, int start, int count) throws Exception {
		SmartList<CityCenterEmployee> list = cityCenterEmployeeDaoOf(userContext).findCityCenterEmployeeByCityCenter(cityCenterId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(CityCenterEmployee.class);
		page.setContainerObject(FranchisedOutletCityCenter.withId(cityCenterId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("城市中心的员工列表");
		page.setRequestName("listByCityCenter");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCityCenter/%s/",  getBeanName(), cityCenterId)));

		page.assemblerContent(userContext, "listByCityCenter");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String cityCenterEmployeeId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getCityCenterEmployeeDetailScope().clone();
		CityCenterEmployee merchantObj = (CityCenterEmployee) this.view(userContext, cityCenterEmployeeId);
    String merchantObjId = cityCenterEmployeeId;
    String linkToUrl =	"cityCenterEmployeeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "城市中心的员工"+"详情";
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
				MapUtil.put("id", "3-mobile")
				    .put("fieldName", "mobile")
				    .put("label", "手机号码")
				    .put("type", "mobile")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("mobile", merchantObj.getMobile());

		propList.add(
				MapUtil.put("id", "4-email")
				    .put("fieldName", "email")
				    .put("label", "电子邮件")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("email", merchantObj.getEmail());

		propList.add(
				MapUtil.put("id", "5-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		propList.add(
				MapUtil.put("id", "6-department")
				    .put("fieldName", "department")
				    .put("label", "部门")
				    .put("type", "auto")
				    .put("linkToUrl", "cityCenterDepartmentManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"manager\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("department", merchantObj.getDepartment());

		propList.add(
				MapUtil.put("id", "7-cityCenter")
				    .put("fieldName", "cityCenter")
				    .put("label", "城市中心")
				    .put("type", "auto")
				    .put("linkToUrl", "franchisedOutletCityCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("cityCenter", merchantObj.getCityCenter());

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


