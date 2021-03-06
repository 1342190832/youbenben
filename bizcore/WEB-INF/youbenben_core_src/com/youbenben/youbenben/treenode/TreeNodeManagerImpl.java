
package com.youbenben.youbenben.treenode;

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










public class TreeNodeManagerImpl extends CustomYoubenbenCheckerManager implements TreeNodeManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "TreeNode";
	@Override
	public TreeNodeDAO daoOf(YoubenbenUserContext userContext) {
		return treeNodeDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws TreeNodeManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new TreeNodeManagerException(message);

	}



 	protected TreeNode saveTreeNode(YoubenbenUserContext userContext, TreeNode treeNode, String [] tokensExpr) throws Exception{	
 		//return getTreeNodeDAO().save(treeNode, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTreeNode(userContext, treeNode, tokens);
 	}
 	
 	protected TreeNode saveTreeNodeDetail(YoubenbenUserContext userContext, TreeNode treeNode) throws Exception{	

 		
 		return saveTreeNode(userContext, treeNode, allTokens());
 	}
 	
 	public TreeNode loadTreeNode(YoubenbenUserContext userContext, String treeNodeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTreeNode(treeNodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TreeNodeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TreeNode treeNode = loadTreeNode( userContext, treeNodeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,treeNode, tokens);
 	}
 	
 	
 	 public TreeNode searchTreeNode(YoubenbenUserContext userContext, String treeNodeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTreeNode(treeNodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TreeNodeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TreeNode treeNode = loadTreeNode( userContext, treeNodeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,treeNode, tokens);
 	}
 	
 	

 	protected TreeNode present(YoubenbenUserContext userContext, TreeNode treeNode, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,treeNode,tokens);
		
		
		TreeNode  treeNodeToPresent = treeNodeDaoOf(userContext).present(treeNode, tokens);
		
		List<BaseEntity> entityListToNaming = treeNodeToPresent.collectRefercencesFromLists();
		treeNodeDaoOf(userContext).alias(entityListToNaming);
		
		return  treeNodeToPresent;
		
		
	}
 
 	
 	
 	public TreeNode loadTreeNodeDetail(YoubenbenUserContext userContext, String treeNodeId) throws Exception{	
 		TreeNode treeNode = loadTreeNode( userContext, treeNodeId, allTokens());
 		return present(userContext,treeNode, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String treeNodeId) throws Exception{	
 		TreeNode treeNode = loadTreeNode( userContext, treeNodeId, viewTokens());
 		return present(userContext,treeNode, allTokens());
		
 	}
 	protected TreeNode saveTreeNode(YoubenbenUserContext userContext, TreeNode treeNode, Map<String,Object>tokens) throws Exception{	
 		return treeNodeDaoOf(userContext).save(treeNode, tokens);
 	}
 	protected TreeNode loadTreeNode(YoubenbenUserContext userContext, String treeNodeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfTreeNode(treeNodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TreeNodeManagerException.class);

 
 		return treeNodeDaoOf(userContext).load(treeNodeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, TreeNode treeNode, Map<String, Object> tokens){
		super.addActions(userContext, treeNode, tokens);
		
		addAction(userContext, treeNode, tokens,"@create","createTreeNode","createTreeNode/","main","primary");
		addAction(userContext, treeNode, tokens,"@update","updateTreeNode","updateTreeNode/"+treeNode.getId()+"/","main","primary");
		addAction(userContext, treeNode, tokens,"@copy","cloneTreeNode","cloneTreeNode/"+treeNode.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, TreeNode treeNode, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public TreeNode createTreeNode(YoubenbenUserContext userContext, String nodeId,String nodeType,int leftValue,int rightValue) throws Exception
	//public TreeNode createTreeNode(YoubenbenUserContext userContext,String nodeId, String nodeType, int leftValue, int rightValue) throws Exception
	{

		

		

		checkerOf(userContext).checkNodeIdOfTreeNode(nodeId);
		checkerOf(userContext).checkNodeTypeOfTreeNode(nodeType);
		checkerOf(userContext).checkLeftValueOfTreeNode(leftValue);
		checkerOf(userContext).checkRightValueOfTreeNode(rightValue);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TreeNodeManagerException.class);


		TreeNode treeNode=createNewTreeNode();	

		treeNode.setNodeId(nodeId);
		treeNode.setNodeType(nodeType);
		treeNode.setLeftValue(leftValue);
		treeNode.setRightValue(rightValue);

		treeNode = saveTreeNode(userContext, treeNode, emptyOptions());
		
		onNewInstanceCreated(userContext, treeNode);
		return treeNode;


	}
	protected TreeNode createNewTreeNode()
	{

		return new TreeNode();
	}

	protected void checkParamsForUpdatingTreeNode(YoubenbenUserContext userContext,String treeNodeId, int treeNodeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfTreeNode(treeNodeId);
		checkerOf(userContext).checkVersionOfTreeNode( treeNodeVersion);
		

		if(TreeNode.NODE_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNodeIdOfTreeNode(parseString(newValueExpr));
		
			
		}
		if(TreeNode.NODE_TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNodeTypeOfTreeNode(parseString(newValueExpr));
		
			
		}
		if(TreeNode.LEFT_VALUE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLeftValueOfTreeNode(parseInt(newValueExpr));
		
			
		}
		if(TreeNode.RIGHT_VALUE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRightValueOfTreeNode(parseInt(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(TreeNodeManagerException.class);


	}



	public TreeNode clone(YoubenbenUserContext userContext, String fromTreeNodeId) throws Exception{

		return treeNodeDaoOf(userContext).clone(fromTreeNodeId, this.allTokens());
	}

	public TreeNode internalSaveTreeNode(YoubenbenUserContext userContext, TreeNode treeNode) throws Exception
	{
		return internalSaveTreeNode(userContext, treeNode, allTokens());

	}
	public TreeNode internalSaveTreeNode(YoubenbenUserContext userContext, TreeNode treeNode, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingTreeNode(userContext, treeNodeId, treeNodeVersion, property, newValueExpr, tokensExpr);


		synchronized(treeNode){
			//will be good when the treeNode loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TreeNode.
			if (treeNode.isChanged()){
			
			}
			treeNode = saveTreeNode(userContext, treeNode, options);
			return treeNode;

		}

	}

	public TreeNode updateTreeNode(YoubenbenUserContext userContext,String treeNodeId, int treeNodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTreeNode(userContext, treeNodeId, treeNodeVersion, property, newValueExpr, tokensExpr);



		TreeNode treeNode = loadTreeNode(userContext, treeNodeId, allTokens());
		if(treeNode.getVersion() != treeNodeVersion){
			String message = "The target version("+treeNode.getVersion()+") is not equals to version("+treeNodeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(treeNode){
			//will be good when the treeNode loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TreeNode.
			
			treeNode.changeProperty(property, newValueExpr);
			treeNode = saveTreeNode(userContext, treeNode, tokens().done());
			return present(userContext,treeNode, mergedAllTokens(tokensExpr));
			//return saveTreeNode(userContext, treeNode, tokens().done());
		}

	}

	public TreeNode updateTreeNodeProperty(YoubenbenUserContext userContext,String treeNodeId, int treeNodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTreeNode(userContext, treeNodeId, treeNodeVersion, property, newValueExpr, tokensExpr);

		TreeNode treeNode = loadTreeNode(userContext, treeNodeId, allTokens());
		if(treeNode.getVersion() != treeNodeVersion){
			String message = "The target version("+treeNode.getVersion()+") is not equals to version("+treeNodeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(treeNode){
			//will be good when the treeNode loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TreeNode.

			treeNode.changeProperty(property, newValueExpr);
			
			treeNode = saveTreeNode(userContext, treeNode, tokens().done());
			return present(userContext,treeNode, mergedAllTokens(tokensExpr));
			//return saveTreeNode(userContext, treeNode, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected TreeNodeTokens tokens(){
		return TreeNodeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TreeNodeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TreeNodeTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String treeNodeId, int treeNodeVersion) throws Exception {
		//deleteInternal(userContext, treeNodeId, treeNodeVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String treeNodeId, int treeNodeVersion) throws Exception{

		treeNodeDaoOf(userContext).delete(treeNodeId, treeNodeVersion);
	}

	public TreeNode forgetByAll(YoubenbenUserContext userContext, String treeNodeId, int treeNodeVersion) throws Exception {
		return forgetByAllInternal(userContext, treeNodeId, treeNodeVersion);
	}
	protected TreeNode forgetByAllInternal(YoubenbenUserContext userContext,
			String treeNodeId, int treeNodeVersion) throws Exception{

		return treeNodeDaoOf(userContext).disconnectFromAll(treeNodeId, treeNodeVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TreeNodeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return treeNodeDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, TreeNode newCreated) throws Exception{
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
		//   TreeNode newTreeNode = this.createTreeNode(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newTreeNode
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, TreeNode.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<TreeNode> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String treeNodeId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getTreeNodeDetailScope().clone();
		TreeNode merchantObj = (TreeNode) this.view(userContext, treeNodeId);
    String merchantObjId = treeNodeId;
    String linkToUrl =	"treeNodeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "树节点"+"详情";
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
				MapUtil.put("id", "2-nodeId")
				    .put("fieldName", "nodeId")
				    .put("label", "节点Id")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("nodeId", merchantObj.getNodeId());

		propList.add(
				MapUtil.put("id", "3-nodeType")
				    .put("fieldName", "nodeType")
				    .put("label", "节点类型")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("nodeType", merchantObj.getNodeType());

		propList.add(
				MapUtil.put("id", "4-leftValue")
				    .put("fieldName", "leftValue")
				    .put("label", "左值")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("leftValue", merchantObj.getLeftValue());

		propList.add(
				MapUtil.put("id", "5-rightValue")
				    .put("fieldName", "rightValue")
				    .put("label", "正确的价值")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("rightValue", merchantObj.getRightValue());

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

















