
package com.youbenben.youbenben.scoring;

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


import com.youbenben.youbenben.employeecompanytraining.EmployeeCompanyTraining;


import com.youbenben.youbenben.companytraining.CompanyTraining;
import com.youbenben.youbenben.scoring.Scoring;
import com.youbenben.youbenben.employee.Employee;






public class ScoringManagerImpl extends CustomYoubenbenCheckerManager implements ScoringManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = ScoringTokens.start().withTokenFromListName(listName).done();
		Scoring  scoring = (Scoring) this.loadScoring(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = scoring.collectRefercencesFromLists();
		scoringDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, scoring, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new ScoringGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "Scoring";
	@Override
	public ScoringDAO daoOf(YoubenbenUserContext userContext) {
		return scoringDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ScoringManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ScoringManagerException(message);

	}



 	protected Scoring saveScoring(YoubenbenUserContext userContext, Scoring scoring, String [] tokensExpr) throws Exception{	
 		//return getScoringDAO().save(scoring, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveScoring(userContext, scoring, tokens);
 	}
 	
 	protected Scoring saveScoringDetail(YoubenbenUserContext userContext, Scoring scoring) throws Exception{	

 		
 		return saveScoring(userContext, scoring, allTokens());
 	}
 	
 	public Scoring loadScoring(YoubenbenUserContext userContext, String scoringId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).throwExceptionIfHasErrors( ScoringManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Scoring scoring = loadScoring( userContext, scoringId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,scoring, tokens);
 	}
 	
 	
 	 public Scoring searchScoring(YoubenbenUserContext userContext, String scoringId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).throwExceptionIfHasErrors( ScoringManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Scoring scoring = loadScoring( userContext, scoringId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,scoring, tokens);
 	}
 	
 	

 	protected Scoring present(YoubenbenUserContext userContext, Scoring scoring, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,scoring,tokens);
		
		
		Scoring  scoringToPresent = scoringDaoOf(userContext).present(scoring, tokens);
		
		List<BaseEntity> entityListToNaming = scoringToPresent.collectRefercencesFromLists();
		scoringDaoOf(userContext).alias(entityListToNaming);
		
		return  scoringToPresent;
		
		
	}
 
 	
 	
 	public Scoring loadScoringDetail(YoubenbenUserContext userContext, String scoringId) throws Exception{	
 		Scoring scoring = loadScoring( userContext, scoringId, allTokens());
 		return present(userContext,scoring, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String scoringId) throws Exception{	
 		Scoring scoring = loadScoring( userContext, scoringId, viewTokens());
 		return present(userContext,scoring, allTokens());
		
 	}
 	protected Scoring saveScoring(YoubenbenUserContext userContext, Scoring scoring, Map<String,Object>tokens) throws Exception{	
 		return scoringDaoOf(userContext).save(scoring, tokens);
 	}
 	protected Scoring loadScoring(YoubenbenUserContext userContext, String scoringId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).throwExceptionIfHasErrors( ScoringManagerException.class);

 
 		return scoringDaoOf(userContext).load(scoringId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, Scoring scoring, Map<String, Object> tokens){
		super.addActions(userContext, scoring, tokens);
		
		addAction(userContext, scoring, tokens,"@create","createScoring","createScoring/","main","primary");
		addAction(userContext, scoring, tokens,"@update","updateScoring","updateScoring/"+scoring.getId()+"/","main","primary");
		addAction(userContext, scoring, tokens,"@copy","cloneScoring","cloneScoring/"+scoring.getId()+"/","main","primary");
		
		addAction(userContext, scoring, tokens,"scoring.addEmployeeCompanyTraining","addEmployeeCompanyTraining","addEmployeeCompanyTraining/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, scoring, tokens,"scoring.removeEmployeeCompanyTraining","removeEmployeeCompanyTraining","removeEmployeeCompanyTraining/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, scoring, tokens,"scoring.updateEmployeeCompanyTraining","updateEmployeeCompanyTraining","updateEmployeeCompanyTraining/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, scoring, tokens,"scoring.copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, Scoring scoring, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Scoring createScoring(YoubenbenUserContext userContext, String scoredBy,int score,String comment) throws Exception
	//public Scoring createScoring(YoubenbenUserContext userContext,String scoredBy, int score, String comment) throws Exception
	{

		

		

		checkerOf(userContext).checkScoredByOfScoring(scoredBy);
		checkerOf(userContext).checkScoreOfScoring(score);
		checkerOf(userContext).checkCommentOfScoring(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);


		Scoring scoring=createNewScoring();	

		scoring.setScoredBy(scoredBy);
		scoring.setScore(score);
		scoring.setComment(comment);

		scoring = saveScoring(userContext, scoring, emptyOptions());
		
		onNewInstanceCreated(userContext, scoring);
		return scoring;


	}
	protected Scoring createNewScoring()
	{

		return new Scoring();
	}

	protected void checkParamsForUpdatingScoring(YoubenbenUserContext userContext,String scoringId, int scoringVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).checkVersionOfScoring( scoringVersion);
		

		if(Scoring.SCORED_BY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkScoredByOfScoring(parseString(newValueExpr));
		
			
		}
		if(Scoring.SCORE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkScoreOfScoring(parseInt(newValueExpr));
		
			
		}
		if(Scoring.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfScoring(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);


	}



	public Scoring clone(YoubenbenUserContext userContext, String fromScoringId) throws Exception{

		return scoringDaoOf(userContext).clone(fromScoringId, this.allTokens());
	}

	public Scoring internalSaveScoring(YoubenbenUserContext userContext, Scoring scoring) throws Exception
	{
		return internalSaveScoring(userContext, scoring, allTokens());

	}
	public Scoring internalSaveScoring(YoubenbenUserContext userContext, Scoring scoring, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingScoring(userContext, scoringId, scoringVersion, property, newValueExpr, tokensExpr);


		synchronized(scoring){
			//will be good when the scoring loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Scoring.
			if (scoring.isChanged()){
			
			}
			scoring = saveScoring(userContext, scoring, options);
			return scoring;

		}

	}

	public Scoring updateScoring(YoubenbenUserContext userContext,String scoringId, int scoringVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingScoring(userContext, scoringId, scoringVersion, property, newValueExpr, tokensExpr);



		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		if(scoring.getVersion() != scoringVersion){
			String message = "The target version("+scoring.getVersion()+") is not equals to version("+scoringVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(scoring){
			//will be good when the scoring loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Scoring.
			
			scoring.changeProperty(property, newValueExpr);
			scoring = saveScoring(userContext, scoring, tokens().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
			//return saveScoring(userContext, scoring, tokens().done());
		}

	}

	public Scoring updateScoringProperty(YoubenbenUserContext userContext,String scoringId, int scoringVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingScoring(userContext, scoringId, scoringVersion, property, newValueExpr, tokensExpr);

		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		if(scoring.getVersion() != scoringVersion){
			String message = "The target version("+scoring.getVersion()+") is not equals to version("+scoringVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(scoring){
			//will be good when the scoring loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Scoring.

			scoring.changeProperty(property, newValueExpr);
			
			scoring = saveScoring(userContext, scoring, tokens().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
			//return saveScoring(userContext, scoring, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ScoringTokens tokens(){
		return ScoringTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ScoringTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeCompanyTrainingListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ScoringTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String scoringId, int scoringVersion) throws Exception {
		//deleteInternal(userContext, scoringId, scoringVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String scoringId, int scoringVersion) throws Exception{

		scoringDaoOf(userContext).delete(scoringId, scoringVersion);
	}

	public Scoring forgetByAll(YoubenbenUserContext userContext, String scoringId, int scoringVersion) throws Exception {
		return forgetByAllInternal(userContext, scoringId, scoringVersion);
	}
	protected Scoring forgetByAllInternal(YoubenbenUserContext userContext,
			String scoringId, int scoringVersion) throws Exception{

		return scoringDaoOf(userContext).disconnectFromAll(scoringId, scoringVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ScoringManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return scoringDaoOf(userContext).deleteAll();
	}


	//disconnect Scoring with employee in EmployeeCompanyTraining
	protected Scoring breakWithEmployeeCompanyTrainingByEmployee(YoubenbenUserContext userContext, String scoringId, String employeeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Scoring scoring = loadScoring(userContext, scoringId, allTokens());

			synchronized(scoring){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				scoringDaoOf(userContext).planToRemoveEmployeeCompanyTrainingListWithEmployee(scoring, employeeId, this.emptyOptions());

				scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
				return scoring;
			}
	}
	//disconnect Scoring with training in EmployeeCompanyTraining
	protected Scoring breakWithEmployeeCompanyTrainingByTraining(YoubenbenUserContext userContext, String scoringId, String trainingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Scoring scoring = loadScoring(userContext, scoringId, allTokens());

			synchronized(scoring){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				scoringDaoOf(userContext).planToRemoveEmployeeCompanyTrainingListWithTraining(scoring, trainingId, this.emptyOptions());

				scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
				return scoring;
			}
	}






	protected void checkParamsForAddingEmployeeCompanyTraining(YoubenbenUserContext userContext, String scoringId, String employeeId, String trainingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfScoring(scoringId);

		
		checkerOf(userContext).checkEmployeeIdOfEmployeeCompanyTraining(employeeId);
		
		checkerOf(userContext).checkTrainingIdOfEmployeeCompanyTraining(trainingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);


	}
	public  Scoring addEmployeeCompanyTraining(YoubenbenUserContext userContext, String scoringId, String employeeId, String trainingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeCompanyTraining(userContext,scoringId,employeeId, trainingId,tokensExpr);

		EmployeeCompanyTraining employeeCompanyTraining = createEmployeeCompanyTraining(userContext,employeeId, trainingId);

		Scoring scoring = loadScoring(userContext, scoringId, emptyOptions());
		synchronized(scoring){
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			scoring.addEmployeeCompanyTraining( employeeCompanyTraining );
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			
			userContext.getManagerGroup().getEmployeeCompanyTrainingManager().onNewInstanceCreated(userContext, employeeCompanyTraining);
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeCompanyTrainingProperties(YoubenbenUserContext userContext, String scoringId,String id,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(id);


		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

	}
	public  Scoring updateEmployeeCompanyTrainingProperties(YoubenbenUserContext userContext, String scoringId, String id, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeCompanyTrainingProperties(userContext,scoringId,id,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeCompanyTrainingListList()
				.searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "is", id).done();

		Scoring scoringToUpdate = loadScoring(userContext, scoringId, options);

		if(scoringToUpdate.getEmployeeCompanyTrainingList().isEmpty()){
			throw new ScoringManagerException("EmployeeCompanyTraining is NOT FOUND with id: '"+id+"'");
		}

		EmployeeCompanyTraining item = scoringToUpdate.getEmployeeCompanyTrainingList().first();



		//checkParamsForAddingEmployeeCompanyTraining(userContext,scoringId,name, code, used,tokensExpr);
		Scoring scoring = saveScoring(userContext, scoringToUpdate, tokens().withEmployeeCompanyTrainingList().done());
		synchronized(scoring){
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}
	}


	protected EmployeeCompanyTraining createEmployeeCompanyTraining(YoubenbenUserContext userContext, String employeeId, String trainingId) throws Exception{

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeCompanyTraining.setEmployee(employee);		
		CompanyTraining  training = new CompanyTraining();
		training.setId(trainingId);		
		employeeCompanyTraining.setTraining(training);
	
		
		return employeeCompanyTraining;


	}

	protected EmployeeCompanyTraining createIndexedEmployeeCompanyTraining(String id, int version){

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		employeeCompanyTraining.setId(id);
		employeeCompanyTraining.setVersion(version);
		return employeeCompanyTraining;

	}

	protected void checkParamsForRemovingEmployeeCompanyTrainingList(YoubenbenUserContext userContext, String scoringId,
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfScoring(scoringId);
		for(String employeeCompanyTrainingIdItem: employeeCompanyTrainingIds){
			checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

	}
	public  Scoring removeEmployeeCompanyTrainingList(YoubenbenUserContext userContext, String scoringId,
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeCompanyTrainingList(userContext, scoringId,  employeeCompanyTrainingIds, tokensExpr);


			Scoring scoring = loadScoring(userContext, scoringId, allTokens());
			synchronized(scoring){
				//Will be good when the scoring loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				scoringDaoOf(userContext).planToRemoveEmployeeCompanyTrainingList(scoring, employeeCompanyTrainingIds, allTokens());
				scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, scoring.getEmployeeCompanyTrainingList());
				return present(userContext,scoring, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeCompanyTraining(YoubenbenUserContext userContext, String scoringId,
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfScoring( scoringId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

	}
	public  Scoring removeEmployeeCompanyTraining(YoubenbenUserContext userContext, String scoringId,
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployeeCompanyTraining(userContext,scoringId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);

		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		synchronized(scoring){
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			scoring.removeEmployeeCompanyTraining( employeeCompanyTraining );
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			deleteRelationInGraph(userContext, employeeCompanyTraining);
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployeeCompanyTraining(YoubenbenUserContext userContext, String scoringId,
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfScoring( scoringId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

	}
	public  Scoring copyEmployeeCompanyTrainingFrom(YoubenbenUserContext userContext, String scoringId,
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployeeCompanyTraining(userContext,scoringId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);

		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		synchronized(scoring){
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			scoring.copyEmployeeCompanyTrainingFrom( employeeCompanyTraining );
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			
			userContext.getManagerGroup().getEmployeeCompanyTrainingManager().onNewInstanceCreated(userContext, (EmployeeCompanyTraining)scoring.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployeeCompanyTraining(YoubenbenUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		

	
		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

	}

	public  Scoring updateEmployeeCompanyTraining(YoubenbenUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployeeCompanyTraining(userContext, scoringId, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeCompanyTrainingList().searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "eq", employeeCompanyTrainingId).done();



		Scoring scoring = loadScoring(userContext, scoringId, loadTokens);

		synchronized(scoring){
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//scoring.removeEmployeeCompanyTraining( employeeCompanyTraining );
			//make changes to AcceleraterAccount.
			EmployeeCompanyTraining employeeCompanyTrainingIndex = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);

			EmployeeCompanyTraining employeeCompanyTraining = scoring.findTheEmployeeCompanyTraining(employeeCompanyTrainingIndex);
			if(employeeCompanyTraining == null){
				throw new ScoringManagerException(employeeCompanyTraining+" is NOT FOUND" );
			}

			employeeCompanyTraining.changeProperty(property, newValueExpr);
			
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, Scoring newCreated) throws Exception{
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
		//   Scoring newScoring = this.createScoring(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newScoring
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Scoring.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<Scoring> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String scoringId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getScoringDetailScope().clone();
		Scoring merchantObj = (Scoring) this.view(userContext, scoringId);
    String merchantObjId = scoringId;
    String linkToUrl =	"scoringManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "评分"+"详情";
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
				MapUtil.put("id", "2-scoredBy")
				    .put("fieldName", "scoredBy")
				    .put("label", "由谁打分")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("scoredBy", merchantObj.getScoredBy());

		propList.add(
				MapUtil.put("id", "3-score")
				    .put("fieldName", "score")
				    .put("label", "分数")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("score", merchantObj.getScore());

		propList.add(
				MapUtil.put("id", "4-comment")
				    .put("fieldName", "comment")
				    .put("label", "备注")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("comment", merchantObj.getComment());

		//处理 sectionList

		//处理Section：employeeCompanyTrainingListSection
		Map employeeCompanyTrainingListSection = ListofUtils.buildSection(
		    "employeeCompanyTrainingListSection",
		    "员工公司培训名单",
		    null,
		    "",
		    "__no_group",
		    "employeeCompanyTrainingManager/listByScoring/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeCompanyTrainingListSection);

		result.put("employeeCompanyTrainingListSection", ListofUtils.toShortList(merchantObj.getEmployeeCompanyTrainingList(), "employeeCompanyTraining"));
		vscope.field("employeeCompanyTrainingListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeCompanyTraining.class.getName(), null));

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


