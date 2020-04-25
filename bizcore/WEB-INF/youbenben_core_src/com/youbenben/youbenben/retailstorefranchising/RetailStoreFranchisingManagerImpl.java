
package com.youbenben.youbenben.retailstorefranchising;

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


import com.youbenben.youbenben.retailstore.RetailStore;


import com.youbenben.youbenben.retailstorefranchising.RetailStoreFranchising;
import com.youbenben.youbenben.retailstoreopening.RetailStoreOpening;
import com.youbenben.youbenben.retailstoredecoration.RetailStoreDecoration;
import com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.youbenben.youbenben.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.youbenben.youbenben.retailstorecreation.RetailStoreCreation;
import com.youbenben.youbenben.retailstoreclosing.RetailStoreClosing;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;






public class RetailStoreFranchisingManagerImpl extends CustomYoubenbenCheckerManager implements RetailStoreFranchisingManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreFranchisingTokens.start().withTokenFromListName(listName).done();
		RetailStoreFranchising  retailStoreFranchising = (RetailStoreFranchising) this.loadRetailStoreFranchising(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreFranchising.collectRefercencesFromLists();
		retailStoreFranchisingDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreFranchising, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreFranchisingGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreFranchising";
	@Override
	public RetailStoreFranchisingDAO daoOf(YoubenbenUserContext userContext) {
		return retailStoreFranchisingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreFranchisingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreFranchisingManagerException(message);

	}



 	protected RetailStoreFranchising saveRetailStoreFranchising(YoubenbenUserContext userContext, RetailStoreFranchising retailStoreFranchising, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreFranchisingDAO().save(retailStoreFranchising, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens);
 	}
 	
 	protected RetailStoreFranchising saveRetailStoreFranchisingDetail(YoubenbenUserContext userContext, RetailStoreFranchising retailStoreFranchising) throws Exception{	

 		
 		return saveRetailStoreFranchising(userContext, retailStoreFranchising, allTokens());
 	}
 	
 	public RetailStoreFranchising loadRetailStoreFranchising(YoubenbenUserContext userContext, String retailStoreFranchisingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreFranchisingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising( userContext, retailStoreFranchisingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreFranchising, tokens);
 	}
 	
 	
 	 public RetailStoreFranchising searchRetailStoreFranchising(YoubenbenUserContext userContext, String retailStoreFranchisingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreFranchisingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising( userContext, retailStoreFranchisingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreFranchising, tokens);
 	}
 	
 	

 	protected RetailStoreFranchising present(YoubenbenUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreFranchising,tokens);
		
		
		RetailStoreFranchising  retailStoreFranchisingToPresent = retailStoreFranchisingDaoOf(userContext).present(retailStoreFranchising, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreFranchisingToPresent.collectRefercencesFromLists();
		retailStoreFranchisingDaoOf(userContext).alias(entityListToNaming);
		
		return  retailStoreFranchisingToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreFranchising loadRetailStoreFranchisingDetail(YoubenbenUserContext userContext, String retailStoreFranchisingId) throws Exception{	
 		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising( userContext, retailStoreFranchisingId, allTokens());
 		return present(userContext,retailStoreFranchising, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String retailStoreFranchisingId) throws Exception{	
 		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising( userContext, retailStoreFranchisingId, viewTokens());
 		return present(userContext,retailStoreFranchising, allTokens());
		
 	}
 	protected RetailStoreFranchising saveRetailStoreFranchising(YoubenbenUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String,Object>tokens) throws Exception{	
 		return retailStoreFranchisingDaoOf(userContext).save(retailStoreFranchising, tokens);
 	}
 	protected RetailStoreFranchising loadRetailStoreFranchising(YoubenbenUserContext userContext, String retailStoreFranchisingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreFranchisingManagerException.class);

 
 		return retailStoreFranchisingDaoOf(userContext).load(retailStoreFranchisingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreFranchising, tokens);
		
		addAction(userContext, retailStoreFranchising, tokens,"@create","createRetailStoreFranchising","createRetailStoreFranchising/","main","primary");
		addAction(userContext, retailStoreFranchising, tokens,"@update","updateRetailStoreFranchising","updateRetailStoreFranchising/"+retailStoreFranchising.getId()+"/","main","primary");
		addAction(userContext, retailStoreFranchising, tokens,"@copy","cloneRetailStoreFranchising","cloneRetailStoreFranchising/"+retailStoreFranchising.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.addRetailStore","addRetailStore","addRetailStore/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreFranchising createRetailStoreFranchising(YoubenbenUserContext userContext, String comment) throws Exception
	//public RetailStoreFranchising createRetailStoreFranchising(YoubenbenUserContext userContext,String comment) throws Exception
	{

		

		

		checkerOf(userContext).checkCommentOfRetailStoreFranchising(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);


		RetailStoreFranchising retailStoreFranchising=createNewRetailStoreFranchising();	

		retailStoreFranchising.setComment(comment);

		retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreFranchising);
		return retailStoreFranchising;


	}
	protected RetailStoreFranchising createNewRetailStoreFranchising()
	{

		return new RetailStoreFranchising();
	}

	protected void checkParamsForUpdatingRetailStoreFranchising(YoubenbenUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		checkerOf(userContext).checkVersionOfRetailStoreFranchising( retailStoreFranchisingVersion);
		

		if(RetailStoreFranchising.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfRetailStoreFranchising(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);


	}



	public RetailStoreFranchising clone(YoubenbenUserContext userContext, String fromRetailStoreFranchisingId) throws Exception{

		return retailStoreFranchisingDaoOf(userContext).clone(fromRetailStoreFranchisingId, this.allTokens());
	}

	public RetailStoreFranchising internalSaveRetailStoreFranchising(YoubenbenUserContext userContext, RetailStoreFranchising retailStoreFranchising) throws Exception
	{
		return internalSaveRetailStoreFranchising(userContext, retailStoreFranchising, allTokens());

	}
	public RetailStoreFranchising internalSaveRetailStoreFranchising(YoubenbenUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreFranchising(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreFranchising){
			//will be good when the retailStoreFranchising loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreFranchising.
			if (retailStoreFranchising.isChanged()){
			
			}
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, options);
			return retailStoreFranchising;

		}

	}

	public RetailStoreFranchising updateRetailStoreFranchising(YoubenbenUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreFranchising(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion, property, newValueExpr, tokensExpr);



		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		if(retailStoreFranchising.getVersion() != retailStoreFranchisingVersion){
			String message = "The target version("+retailStoreFranchising.getVersion()+") is not equals to version("+retailStoreFranchisingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreFranchising){
			//will be good when the retailStoreFranchising loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreFranchising.
			
			retailStoreFranchising.changeProperty(property, newValueExpr);
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
			//return saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
		}

	}

	public RetailStoreFranchising updateRetailStoreFranchisingProperty(YoubenbenUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreFranchising(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion, property, newValueExpr, tokensExpr);

		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		if(retailStoreFranchising.getVersion() != retailStoreFranchisingVersion){
			String message = "The target version("+retailStoreFranchising.getVersion()+") is not equals to version("+retailStoreFranchisingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreFranchising){
			//will be good when the retailStoreFranchising loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreFranchising.

			retailStoreFranchising.changeProperty(property, newValueExpr);
			
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
			//return saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreFranchisingTokens tokens(){
		return RetailStoreFranchisingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreFranchisingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreFranchisingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String retailStoreFranchisingId, int retailStoreFranchisingVersion) throws Exception {
		//deleteInternal(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String retailStoreFranchisingId, int retailStoreFranchisingVersion) throws Exception{

		retailStoreFranchisingDaoOf(userContext).delete(retailStoreFranchisingId, retailStoreFranchisingVersion);
	}

	public RetailStoreFranchising forgetByAll(YoubenbenUserContext userContext, String retailStoreFranchisingId, int retailStoreFranchisingVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion);
	}
	protected RetailStoreFranchising forgetByAllInternal(YoubenbenUserContext userContext,
			String retailStoreFranchisingId, int retailStoreFranchisingVersion) throws Exception{

		return retailStoreFranchisingDaoOf(userContext).disconnectFromAll(retailStoreFranchisingId, retailStoreFranchisingVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreFranchisingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return retailStoreFranchisingDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreFranchising with retail_store_country_center in RetailStore
	protected RetailStoreFranchising breakWithRetailStoreByRetailStoreCountryCenter(YoubenbenUserContext userContext, String retailStoreFranchisingId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());

			synchronized(retailStoreFranchising){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreFranchisingDaoOf(userContext).planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreFranchising, retailStoreCountryCenterId, this.emptyOptions());

				retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
				return retailStoreFranchising;
			}
	}
	//disconnect RetailStoreFranchising with city_service_center in RetailStore
	protected RetailStoreFranchising breakWithRetailStoreByCityServiceCenter(YoubenbenUserContext userContext, String retailStoreFranchisingId, String cityServiceCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());

			synchronized(retailStoreFranchising){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreFranchisingDaoOf(userContext).planToRemoveRetailStoreListWithCityServiceCenter(retailStoreFranchising, cityServiceCenterId, this.emptyOptions());

				retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
				return retailStoreFranchising;
			}
	}
	//disconnect RetailStoreFranchising with creation in RetailStore
	protected RetailStoreFranchising breakWithRetailStoreByCreation(YoubenbenUserContext userContext, String retailStoreFranchisingId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());

			synchronized(retailStoreFranchising){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreFranchisingDaoOf(userContext).planToRemoveRetailStoreListWithCreation(retailStoreFranchising, creationId, this.emptyOptions());

				retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
				return retailStoreFranchising;
			}
	}
	//disconnect RetailStoreFranchising with investment_invitation in RetailStore
	protected RetailStoreFranchising breakWithRetailStoreByInvestmentInvitation(YoubenbenUserContext userContext, String retailStoreFranchisingId, String investmentInvitationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());

			synchronized(retailStoreFranchising){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreFranchisingDaoOf(userContext).planToRemoveRetailStoreListWithInvestmentInvitation(retailStoreFranchising, investmentInvitationId, this.emptyOptions());

				retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
				return retailStoreFranchising;
			}
	}
	//disconnect RetailStoreFranchising with decoration in RetailStore
	protected RetailStoreFranchising breakWithRetailStoreByDecoration(YoubenbenUserContext userContext, String retailStoreFranchisingId, String decorationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());

			synchronized(retailStoreFranchising){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreFranchisingDaoOf(userContext).planToRemoveRetailStoreListWithDecoration(retailStoreFranchising, decorationId, this.emptyOptions());

				retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
				return retailStoreFranchising;
			}
	}
	//disconnect RetailStoreFranchising with opening in RetailStore
	protected RetailStoreFranchising breakWithRetailStoreByOpening(YoubenbenUserContext userContext, String retailStoreFranchisingId, String openingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());

			synchronized(retailStoreFranchising){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreFranchisingDaoOf(userContext).planToRemoveRetailStoreListWithOpening(retailStoreFranchising, openingId, this.emptyOptions());

				retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
				return retailStoreFranchising;
			}
	}
	//disconnect RetailStoreFranchising with closing in RetailStore
	protected RetailStoreFranchising breakWithRetailStoreByClosing(YoubenbenUserContext userContext, String retailStoreFranchisingId, String closingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());

			synchronized(retailStoreFranchising){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreFranchisingDaoOf(userContext).planToRemoveRetailStoreListWithClosing(retailStoreFranchising, closingId, this.emptyOptions());

				retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
				return retailStoreFranchising;
			}
	}






	protected void checkParamsForAddingRetailStore(YoubenbenUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);

		
		checkerOf(userContext).checkNameOfRetailStore(name);
		
		checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
		
		checkerOf(userContext).checkOwnerOfRetailStore(owner);
		
		checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		checkerOf(userContext).checkCreationIdOfRetailStore(creationId);
		
		checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);
		
		checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);
		
		checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);
		
		checkerOf(userContext).checkClosingIdOfRetailStore(closingId);
		
		checkerOf(userContext).checkFoundedOfRetailStore(founded);
		
		checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
		
		checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
		
		checkerOf(userContext).checkDescriptionOfRetailStore(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);


	}
	public  RetailStoreFranchising addRetailStore(YoubenbenUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStore(userContext,retailStoreFranchisingId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, decorationId, openingId, closingId, founded, latitude, longitude, description,tokensExpr);

		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, decorationId, openingId, closingId, founded, latitude, longitude, description);

		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, emptyOptions());
		synchronized(retailStoreFranchising){
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreFranchising.addRetailStore( retailStore );
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(YoubenbenUserContext userContext, String retailStoreFranchisingId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		checkerOf(userContext).checkIdOfRetailStore(id);

		checkerOf(userContext).checkNameOfRetailStore( name);
		checkerOf(userContext).checkTelephoneOfRetailStore( telephone);
		checkerOf(userContext).checkOwnerOfRetailStore( owner);
		checkerOf(userContext).checkFoundedOfRetailStore( founded);
		checkerOf(userContext).checkLatitudeOfRetailStore( latitude);
		checkerOf(userContext).checkLongitudeOfRetailStore( longitude);
		checkerOf(userContext).checkDescriptionOfRetailStore( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);

	}
	public  RetailStoreFranchising updateRetailStoreProperties(YoubenbenUserContext userContext, String retailStoreFranchisingId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreFranchisingId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "is", id).done();

		RetailStoreFranchising retailStoreFranchisingToUpdate = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);

		if(retailStoreFranchisingToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreFranchisingManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}

		RetailStore item = retailStoreFranchisingToUpdate.getRetailStoreList().first();

		item.updateName( name );
		item.updateTelephone( telephone );
		item.updateOwner( owner );
		item.updateFounded( founded );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );


		//checkParamsForAddingRetailStore(userContext,retailStoreFranchisingId,name, code, used,tokensExpr);
		RetailStoreFranchising retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchisingToUpdate, tokens().withRetailStoreList().done());
		synchronized(retailStoreFranchising){
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStore createRetailStore(YoubenbenUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception{

		RetailStore retailStore = new RetailStore();
		
		
		retailStore.setName(name);		
		retailStore.setTelephone(telephone);		
		retailStore.setOwner(owner);		
		RetailStoreCountryCenter  retailStoreCountryCenter = new RetailStoreCountryCenter();
		retailStoreCountryCenter.setId(retailStoreCountryCenterId);		
		retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);		
		RetailStoreCityServiceCenter  cityServiceCenter = new RetailStoreCityServiceCenter();
		cityServiceCenter.setId(cityServiceCenterId);		
		retailStore.setCityServiceCenter(cityServiceCenter);		
		RetailStoreCreation  creation = new RetailStoreCreation();
		creation.setId(creationId);		
		retailStore.setCreation(creation);		
		RetailStoreInvestmentInvitation  investmentInvitation = new RetailStoreInvestmentInvitation();
		investmentInvitation.setId(investmentInvitationId);		
		retailStore.setInvestmentInvitation(investmentInvitation);		
		RetailStoreDecoration  decoration = new RetailStoreDecoration();
		decoration.setId(decorationId);		
		retailStore.setDecoration(decoration);		
		RetailStoreOpening  opening = new RetailStoreOpening();
		opening.setId(openingId);		
		retailStore.setOpening(opening);		
		RetailStoreClosing  closing = new RetailStoreClosing();
		closing.setId(closingId);		
		retailStore.setClosing(closing);		
		retailStore.setFounded(founded);		
		retailStore.setLatitude(latitude);		
		retailStore.setLongitude(longitude);		
		retailStore.setDescription(description);		
		retailStore.setLastUpdateTime(userContext.now());
	
		
		return retailStore;


	}

	protected RetailStore createIndexedRetailStore(String id, int version){

		RetailStore retailStore = new RetailStore();
		retailStore.setId(id);
		retailStore.setVersion(version);
		return retailStore;

	}

	protected void checkParamsForRemovingRetailStoreList(YoubenbenUserContext userContext, String retailStoreFranchisingId,
			String retailStoreIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		for(String retailStoreIdItem: retailStoreIds){
			checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);

	}
	public  RetailStoreFranchising removeRetailStoreList(YoubenbenUserContext userContext, String retailStoreFranchisingId,
			String retailStoreIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreList(userContext, retailStoreFranchisingId,  retailStoreIds, tokensExpr);


			RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
			synchronized(retailStoreFranchising){
				//Will be good when the retailStoreFranchising loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreFranchisingDaoOf(userContext).planToRemoveRetailStoreList(retailStoreFranchising, retailStoreIds, allTokens());
				retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreFranchising.getRetailStoreList());
				return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStore(YoubenbenUserContext userContext, String retailStoreFranchisingId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreFranchising( retailStoreFranchisingId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);

	}
	public  RetailStoreFranchising removeRetailStore(YoubenbenUserContext userContext, String retailStoreFranchisingId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStore(userContext,retailStoreFranchisingId, retailStoreId, retailStoreVersion,tokensExpr);

		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		synchronized(retailStoreFranchising){
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreFranchising.removeRetailStore( retailStore );
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			deleteRelationInGraph(userContext, retailStore);
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStore(YoubenbenUserContext userContext, String retailStoreFranchisingId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreFranchising( retailStoreFranchisingId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);

	}
	public  RetailStoreFranchising copyRetailStoreFrom(YoubenbenUserContext userContext, String retailStoreFranchisingId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStore(userContext,retailStoreFranchisingId, retailStoreId, retailStoreVersion,tokensExpr);

		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		synchronized(retailStoreFranchising){
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStore.updateLastUpdateTime(userContext.now());

			retailStoreFranchising.copyRetailStoreFrom( retailStore );
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, (RetailStore)retailStoreFranchising.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStore(YoubenbenUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		

		if(RetailStore.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStore(parseString(newValueExpr));
		
		}
		
		if(RetailStore.TELEPHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTelephoneOfRetailStore(parseString(newValueExpr));
		
		}
		
		if(RetailStore.OWNER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOwnerOfRetailStore(parseString(newValueExpr));
		
		}
		
		if(RetailStore.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfRetailStore(parseDate(newValueExpr));
		
		}
		
		if(RetailStore.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfRetailStore(parseBigDecimal(newValueExpr));
		
		}
		
		if(RetailStore.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfRetailStore(parseBigDecimal(newValueExpr));
		
		}
		
		if(RetailStore.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfRetailStore(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);

	}

	public  RetailStoreFranchising updateRetailStore(YoubenbenUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStore(userContext, retailStoreFranchisingId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, "eq", retailStoreId).done();



		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, loadTokens);

		synchronized(retailStoreFranchising){
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreFranchising.removeRetailStore( retailStore );
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);

			RetailStore retailStore = retailStoreFranchising.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreFranchisingManagerException(retailStore+" is NOT FOUND" );
			}

			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreFranchising newCreated) throws Exception{
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
		//   RetailStoreFranchising newRetailStoreFranchising = this.createRetailStoreFranchising(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreFranchising
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreFranchising.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<RetailStoreFranchising> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String retailStoreFranchisingId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getRetailStoreFranchisingDetailScope().clone();
		RetailStoreFranchising merchantObj = (RetailStoreFranchising) this.view(userContext, retailStoreFranchisingId);
    String merchantObjId = retailStoreFranchisingId;
    String linkToUrl =	"retailStoreFranchisingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超的特许经营"+"详情";
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
				MapUtil.put("id", "2-comment")
				    .put("fieldName", "comment")
				    .put("label", "备注")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("comment", merchantObj.getComment());

		//处理 sectionList

		//处理Section：retailStoreListSection
		Map retailStoreListSection = ListofUtils.buildSection(
		    "retailStoreListSection",
		    "零售门店列表",
		    null,
		    "",
		    "__no_group",
		    "retailStoreManager/listByFranchising/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreListSection);

		result.put("retailStoreListSection", ListofUtils.toShortList(merchantObj.getRetailStoreList(), "retailStore"));
		vscope.field("retailStoreListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( RetailStore.class.getName(), null));

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


