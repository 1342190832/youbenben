
package com.youbenben.youbenben.employeecompanytraining;

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


import com.youbenben.youbenben.companytraining.CompanyTraining;
import com.youbenben.youbenben.scoring.Scoring;
import com.youbenben.youbenben.employee.Employee;

import com.youbenben.youbenben.companytraining.CandidateCompanyTraining;
import com.youbenben.youbenben.scoring.CandidateScoring;
import com.youbenben.youbenben.employee.CandidateEmployee;







public class EmployeeCompanyTrainingManagerImpl extends CustomYoubenbenCheckerManager implements EmployeeCompanyTrainingManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "EmployeeCompanyTraining";
	@Override
	public EmployeeCompanyTrainingDAO daoOf(YoubenbenUserContext userContext) {
		return employeeCompanyTrainingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws EmployeeCompanyTrainingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeeCompanyTrainingManagerException(message);

	}



 	protected EmployeeCompanyTraining saveEmployeeCompanyTraining(YoubenbenUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, String [] tokensExpr) throws Exception{	
 		//return getEmployeeCompanyTrainingDAO().save(employeeCompanyTraining, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens);
 	}
 	
 	protected EmployeeCompanyTraining saveEmployeeCompanyTrainingDetail(YoubenbenUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining) throws Exception{	

 		
 		return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, allTokens());
 	}
 	
 	public EmployeeCompanyTraining loadEmployeeCompanyTraining(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeCompanyTrainingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining( userContext, employeeCompanyTrainingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeCompanyTraining, tokens);
 	}
 	
 	
 	 public EmployeeCompanyTraining searchEmployeeCompanyTraining(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeCompanyTrainingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining( userContext, employeeCompanyTrainingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeCompanyTraining, tokens);
 	}
 	
 	

 	protected EmployeeCompanyTraining present(YoubenbenUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeCompanyTraining,tokens);
		
		
		EmployeeCompanyTraining  employeeCompanyTrainingToPresent = employeeCompanyTrainingDaoOf(userContext).present(employeeCompanyTraining, tokens);
		
		List<BaseEntity> entityListToNaming = employeeCompanyTrainingToPresent.collectRefercencesFromLists();
		employeeCompanyTrainingDaoOf(userContext).alias(entityListToNaming);
		
		return  employeeCompanyTrainingToPresent;
		
		
	}
 
 	
 	
 	public EmployeeCompanyTraining loadEmployeeCompanyTrainingDetail(YoubenbenUserContext userContext, String employeeCompanyTrainingId) throws Exception{	
 		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining( userContext, employeeCompanyTrainingId, allTokens());
 		return present(userContext,employeeCompanyTraining, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String employeeCompanyTrainingId) throws Exception{	
 		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining( userContext, employeeCompanyTrainingId, viewTokens());
 		return present(userContext,employeeCompanyTraining, allTokens());
		
 	}
 	protected EmployeeCompanyTraining saveEmployeeCompanyTraining(YoubenbenUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object>tokens) throws Exception{	
 		return employeeCompanyTrainingDaoOf(userContext).save(employeeCompanyTraining, tokens);
 	}
 	protected EmployeeCompanyTraining loadEmployeeCompanyTraining(YoubenbenUserContext userContext, String employeeCompanyTrainingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeCompanyTrainingManagerException.class);

 
 		return employeeCompanyTrainingDaoOf(userContext).load(employeeCompanyTrainingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String, Object> tokens){
		super.addActions(userContext, employeeCompanyTraining, tokens);
		
		addAction(userContext, employeeCompanyTraining, tokens,"@create","createEmployeeCompanyTraining","createEmployeeCompanyTraining/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"@update","updateEmployeeCompanyTraining","updateEmployeeCompanyTraining/"+employeeCompanyTraining.getId()+"/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"@copy","cloneEmployeeCompanyTraining","cloneEmployeeCompanyTraining/"+employeeCompanyTraining.getId()+"/","main","primary");
		
		addAction(userContext, employeeCompanyTraining, tokens,"employee_company_training.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeCompanyTraining.getId()+"/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"employee_company_training.transfer_to_training","transferToAnotherTraining","transferToAnotherTraining/"+employeeCompanyTraining.getId()+"/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"employee_company_training.transfer_to_scoring","transferToAnotherScoring","transferToAnotherScoring/"+employeeCompanyTraining.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public EmployeeCompanyTraining createEmployeeCompanyTraining(YoubenbenUserContext userContext, String employeeId,String trainingId,String scoringId) throws Exception
	//public EmployeeCompanyTraining createEmployeeCompanyTraining(YoubenbenUserContext userContext,String employeeId, String trainingId, String scoringId) throws Exception
	{

		

		

	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);


		EmployeeCompanyTraining employeeCompanyTraining=createNewEmployeeCompanyTraining();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeCompanyTraining.setEmployee(employee);
		
		
			
		CompanyTraining training = loadCompanyTraining(userContext, trainingId,emptyOptions());
		employeeCompanyTraining.setTraining(training);
		
		
			
		Scoring scoring = loadScoring(userContext, scoringId,emptyOptions());
		employeeCompanyTraining.setScoring(scoring);
		
		

		employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeCompanyTraining);
		return employeeCompanyTraining;


	}
	protected EmployeeCompanyTraining createNewEmployeeCompanyTraining()
	{

		return new EmployeeCompanyTraining();
	}

	protected void checkParamsForUpdatingEmployeeCompanyTraining(YoubenbenUserContext userContext,String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining( employeeCompanyTrainingVersion);
		
		

				

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);


	}



	public EmployeeCompanyTraining clone(YoubenbenUserContext userContext, String fromEmployeeCompanyTrainingId) throws Exception{

		return employeeCompanyTrainingDaoOf(userContext).clone(fromEmployeeCompanyTrainingId, this.allTokens());
	}

	public EmployeeCompanyTraining internalSaveEmployeeCompanyTraining(YoubenbenUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining) throws Exception
	{
		return internalSaveEmployeeCompanyTraining(userContext, employeeCompanyTraining, allTokens());

	}
	public EmployeeCompanyTraining internalSaveEmployeeCompanyTraining(YoubenbenUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr, tokensExpr);


		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeCompanyTraining.
			if (employeeCompanyTraining.isChanged()){
			
			}
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, options);
			return employeeCompanyTraining;

		}

	}

	public EmployeeCompanyTraining updateEmployeeCompanyTraining(YoubenbenUserContext userContext,String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr, tokensExpr);



		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());
		if(employeeCompanyTraining.getVersion() != employeeCompanyTrainingVersion){
			String message = "The target version("+employeeCompanyTraining.getVersion()+") is not equals to version("+employeeCompanyTrainingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeCompanyTraining.
			
			employeeCompanyTraining.changeProperty(property, newValueExpr);
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
			return present(userContext,employeeCompanyTraining, mergedAllTokens(tokensExpr));
			//return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
		}

	}

	public EmployeeCompanyTraining updateEmployeeCompanyTrainingProperty(YoubenbenUserContext userContext,String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr, tokensExpr);

		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());
		if(employeeCompanyTraining.getVersion() != employeeCompanyTrainingVersion){
			String message = "The target version("+employeeCompanyTraining.getVersion()+") is not equals to version("+employeeCompanyTrainingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeCompanyTraining.

			employeeCompanyTraining.changeProperty(property, newValueExpr);
			
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
			return present(userContext,employeeCompanyTraining, mergedAllTokens(tokensExpr));
			//return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeeCompanyTrainingTokens tokens(){
		return EmployeeCompanyTrainingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeCompanyTrainingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeCompanyTrainingTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String anotherEmployeeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
 		checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);

 	}
 	public EmployeeCompanyTraining transferToAnotherEmployee(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeCompanyTrainingId,anotherEmployeeId);
 
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());	
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeCompanyTraining.updateEmployee(employee);		
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());
			
			return present(userContext,employeeCompanyTraining, allTokens());
			
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
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeeCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherTraining(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String anotherTrainingId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
 		checkerOf(userContext).checkIdOfCompanyTraining(anotherTrainingId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);

 	}
 	public EmployeeCompanyTraining transferToAnotherTraining(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String anotherTrainingId) throws Exception
 	{
 		checkParamsForTransferingAnotherTraining(userContext, employeeCompanyTrainingId,anotherTrainingId);
 
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());	
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CompanyTraining training = loadCompanyTraining(userContext, anotherTrainingId, emptyOptions());		
			employeeCompanyTraining.updateTraining(training);		
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());
			
			return present(userContext,employeeCompanyTraining, allTokens());
			
		}

 	}

	


	public CandidateCompanyTraining requestCandidateTraining(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCompanyTraining result = new CandidateCompanyTraining();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<CompanyTraining> candidateList = companyTrainingDaoOf(userContext).requestCandidateCompanyTrainingForEmployeeCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherScoring(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String anotherScoringId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
 		checkerOf(userContext).checkIdOfScoring(anotherScoringId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);

 	}
 	public EmployeeCompanyTraining transferToAnotherScoring(YoubenbenUserContext userContext, String employeeCompanyTrainingId, String anotherScoringId) throws Exception
 	{
 		checkParamsForTransferingAnotherScoring(userContext, employeeCompanyTrainingId,anotherScoringId);
 
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());	
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Scoring scoring = loadScoring(userContext, anotherScoringId, emptyOptions());		
			employeeCompanyTraining.updateScoring(scoring);		
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());
			
			return present(userContext,employeeCompanyTraining, allTokens());
			
		}

 	}

	


	public CandidateScoring requestCandidateScoring(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateScoring result = new CandidateScoring();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("scoredBy");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Scoring> candidateList = scoringDaoOf(userContext).requestCandidateScoringForEmployeeCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	


	

 	protected Scoring loadScoring(YoubenbenUserContext userContext, String newScoringId, Map<String,Object> options) throws Exception
 	{

 		return scoringDaoOf(userContext).load(newScoringId, options);
 	}
 	


	

 	protected CompanyTraining loadCompanyTraining(YoubenbenUserContext userContext, String newTrainingId, Map<String,Object> options) throws Exception
 	{

 		return companyTrainingDaoOf(userContext).load(newTrainingId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion) throws Exception {
		//deleteInternal(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String employeeCompanyTrainingId, int employeeCompanyTrainingVersion) throws Exception{

		employeeCompanyTrainingDaoOf(userContext).delete(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
	}

	public EmployeeCompanyTraining forgetByAll(YoubenbenUserContext userContext, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion);
	}
	protected EmployeeCompanyTraining forgetByAllInternal(YoubenbenUserContext userContext,
			String employeeCompanyTrainingId, int employeeCompanyTrainingVersion) throws Exception{

		return employeeCompanyTrainingDaoOf(userContext).disconnectFromAll(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeCompanyTrainingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return employeeCompanyTrainingDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, EmployeeCompanyTraining newCreated) throws Exception{
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
		//   EmployeeCompanyTraining newEmployeeCompanyTraining = this.createEmployeeCompanyTraining(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeCompanyTraining
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, EmployeeCompanyTraining.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<EmployeeCompanyTraining> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Employee> employeeList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
		userContext.getDAOGroup().enhanceList(employeeList, Employee.class);
		List<CompanyTraining> trainingList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, CompanyTraining.class);
		userContext.getDAOGroup().enhanceList(trainingList, CompanyTraining.class);
		List<Scoring> scoringList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, Scoring.class);
		userContext.getDAOGroup().enhanceList(scoringList, Scoring.class);


    }
	
	public Object listByEmployee(YoubenbenUserContext userContext,String employeeId) throws Exception {
		return listPageByEmployee(userContext, employeeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByEmployee(YoubenbenUserContext userContext,String employeeId, int start, int count) throws Exception {
		SmartList<EmployeeCompanyTraining> list = employeeCompanyTrainingDaoOf(userContext).findEmployeeCompanyTrainingByEmployee(employeeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(EmployeeCompanyTraining.class);
		page.setContainerObject(Employee.withId(employeeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工参与的公司培训列表");
		page.setRequestName("listByEmployee");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByEmployee/%s/",  getBeanName(), employeeId)));

		page.assemblerContent(userContext, "listByEmployee");
		return page.doRender(userContext);
	}
  
	public Object listByTraining(YoubenbenUserContext userContext,String trainingId) throws Exception {
		return listPageByTraining(userContext, trainingId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByTraining(YoubenbenUserContext userContext,String trainingId, int start, int count) throws Exception {
		SmartList<EmployeeCompanyTraining> list = employeeCompanyTrainingDaoOf(userContext).findEmployeeCompanyTrainingByTraining(trainingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(EmployeeCompanyTraining.class);
		page.setContainerObject(CompanyTraining.withId(trainingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工参与的公司培训列表");
		page.setRequestName("listByTraining");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByTraining/%s/",  getBeanName(), trainingId)));

		page.assemblerContent(userContext, "listByTraining");
		return page.doRender(userContext);
	}
  
	public Object listByScoring(YoubenbenUserContext userContext,String scoringId) throws Exception {
		return listPageByScoring(userContext, scoringId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByScoring(YoubenbenUserContext userContext,String scoringId, int start, int count) throws Exception {
		SmartList<EmployeeCompanyTraining> list = employeeCompanyTrainingDaoOf(userContext).findEmployeeCompanyTrainingByScoring(scoringId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(EmployeeCompanyTraining.class);
		page.setContainerObject(Scoring.withId(scoringId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工参与的公司培训列表");
		page.setRequestName("listByScoring");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByScoring/%s/",  getBeanName(), scoringId)));

		page.assemblerContent(userContext, "listByScoring");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String employeeCompanyTrainingId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getEmployeeCompanyTrainingDetailScope().clone();
		EmployeeCompanyTraining merchantObj = (EmployeeCompanyTraining) this.view(userContext, employeeCompanyTrainingId);
    String merchantObjId = employeeCompanyTrainingId;
    String linkToUrl =	"employeeCompanyTrainingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工参与的公司培训"+"详情";
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
				MapUtil.put("id", "3-training")
				    .put("fieldName", "training")
				    .put("label", "培训活动")
				    .put("type", "auto")
				    .put("linkToUrl", "companyTrainingManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"duration_hours\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("training", merchantObj.getTraining());

		propList.add(
				MapUtil.put("id", "4-scoring")
				    .put("fieldName", "scoring")
				    .put("label", "评分")
				    .put("type", "auto")
				    .put("linkToUrl", "scoringManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"score\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"scored_by\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("scoring", merchantObj.getScoring());

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


