
package com.youbenben.youbenben.retailstoreopening;

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






public class RetailStoreOpeningManagerImpl extends CustomYoubenbenCheckerManager implements RetailStoreOpeningManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreOpeningTokens.start().withTokenFromListName(listName).done();
		RetailStoreOpening  retailStoreOpening = (RetailStoreOpening) this.loadRetailStoreOpening(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreOpening.collectRefercencesFromLists();
		retailStoreOpeningDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreOpening, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreOpeningGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreOpening";
	@Override
	public RetailStoreOpeningDAO daoOf(YoubenbenUserContext userContext) {
		return retailStoreOpeningDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreOpeningManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOpeningManagerException(message);

	}



 	protected RetailStoreOpening saveRetailStoreOpening(YoubenbenUserContext userContext, RetailStoreOpening retailStoreOpening, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOpeningDAO().save(retailStoreOpening, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOpening(userContext, retailStoreOpening, tokens);
 	}
 	
 	protected RetailStoreOpening saveRetailStoreOpeningDetail(YoubenbenUserContext userContext, RetailStoreOpening retailStoreOpening) throws Exception{	

 		
 		return saveRetailStoreOpening(userContext, retailStoreOpening, allTokens());
 	}
 	
 	public RetailStoreOpening loadRetailStoreOpening(YoubenbenUserContext userContext, String retailStoreOpeningId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOpeningManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOpening, tokens);
 	}
 	
 	
 	 public RetailStoreOpening searchRetailStoreOpening(YoubenbenUserContext userContext, String retailStoreOpeningId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOpeningManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOpening, tokens);
 	}
 	
 	

 	protected RetailStoreOpening present(YoubenbenUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOpening,tokens);
		
		
		RetailStoreOpening  retailStoreOpeningToPresent = retailStoreOpeningDaoOf(userContext).present(retailStoreOpening, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOpeningToPresent.collectRefercencesFromLists();
		retailStoreOpeningDaoOf(userContext).alias(entityListToNaming);
		
		return  retailStoreOpeningToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOpening loadRetailStoreOpeningDetail(YoubenbenUserContext userContext, String retailStoreOpeningId) throws Exception{	
 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, allTokens());
 		return present(userContext,retailStoreOpening, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String retailStoreOpeningId) throws Exception{	
 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, viewTokens());
 		return present(userContext,retailStoreOpening, allTokens());
		
 	}
 	protected RetailStoreOpening saveRetailStoreOpening(YoubenbenUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String,Object>tokens) throws Exception{	
 		return retailStoreOpeningDaoOf(userContext).save(retailStoreOpening, tokens);
 	}
 	protected RetailStoreOpening loadRetailStoreOpening(YoubenbenUserContext userContext, String retailStoreOpeningId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOpeningManagerException.class);

 
 		return retailStoreOpeningDaoOf(userContext).load(retailStoreOpeningId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOpening, tokens);
		
		addAction(userContext, retailStoreOpening, tokens,"@create","createRetailStoreOpening","createRetailStoreOpening/","main","primary");
		addAction(userContext, retailStoreOpening, tokens,"@update","updateRetailStoreOpening","updateRetailStoreOpening/"+retailStoreOpening.getId()+"/","main","primary");
		addAction(userContext, retailStoreOpening, tokens,"@copy","cloneRetailStoreOpening","cloneRetailStoreOpening/"+retailStoreOpening.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.addRetailStore","addRetailStore","addRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreOpening createRetailStoreOpening(YoubenbenUserContext userContext, String comment) throws Exception
	//public RetailStoreOpening createRetailStoreOpening(YoubenbenUserContext userContext,String comment) throws Exception
	{

		

		

		checkerOf(userContext).checkCommentOfRetailStoreOpening(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);


		RetailStoreOpening retailStoreOpening=createNewRetailStoreOpening();	

		retailStoreOpening.setComment(comment);

		retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOpening);
		return retailStoreOpening;


	}
	protected RetailStoreOpening createNewRetailStoreOpening()
	{

		return new RetailStoreOpening();
	}

	protected void checkParamsForUpdatingRetailStoreOpening(YoubenbenUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);
		checkerOf(userContext).checkVersionOfRetailStoreOpening( retailStoreOpeningVersion);
		

		if(RetailStoreOpening.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfRetailStoreOpening(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);


	}



	public RetailStoreOpening clone(YoubenbenUserContext userContext, String fromRetailStoreOpeningId) throws Exception{

		return retailStoreOpeningDaoOf(userContext).clone(fromRetailStoreOpeningId, this.allTokens());
	}

	public RetailStoreOpening internalSaveRetailStoreOpening(YoubenbenUserContext userContext, RetailStoreOpening retailStoreOpening) throws Exception
	{
		return internalSaveRetailStoreOpening(userContext, retailStoreOpening, allTokens());

	}
	public RetailStoreOpening internalSaveRetailStoreOpening(YoubenbenUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreOpening(userContext, retailStoreOpeningId, retailStoreOpeningVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreOpening){
			//will be good when the retailStoreOpening loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOpening.
			if (retailStoreOpening.isChanged()){
			
			}
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, options);
			return retailStoreOpening;

		}

	}

	public RetailStoreOpening updateRetailStoreOpening(YoubenbenUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOpening(userContext, retailStoreOpeningId, retailStoreOpeningVersion, property, newValueExpr, tokensExpr);



		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		if(retailStoreOpening.getVersion() != retailStoreOpeningVersion){
			String message = "The target version("+retailStoreOpening.getVersion()+") is not equals to version("+retailStoreOpeningVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOpening){
			//will be good when the retailStoreOpening loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOpening.
			
			retailStoreOpening.changeProperty(property, newValueExpr);
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
		}

	}

	public RetailStoreOpening updateRetailStoreOpeningProperty(YoubenbenUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOpening(userContext, retailStoreOpeningId, retailStoreOpeningVersion, property, newValueExpr, tokensExpr);

		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		if(retailStoreOpening.getVersion() != retailStoreOpeningVersion){
			String message = "The target version("+retailStoreOpening.getVersion()+") is not equals to version("+retailStoreOpeningVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOpening){
			//will be good when the retailStoreOpening loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOpening.

			retailStoreOpening.changeProperty(property, newValueExpr);
			
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreOpeningTokens tokens(){
		return RetailStoreOpeningTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOpeningTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOpeningTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOpeningId, retailStoreOpeningVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception{

		retailStoreOpeningDaoOf(userContext).delete(retailStoreOpeningId, retailStoreOpeningVersion);
	}

	public RetailStoreOpening forgetByAll(YoubenbenUserContext userContext, String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOpeningId, retailStoreOpeningVersion);
	}
	protected RetailStoreOpening forgetByAllInternal(YoubenbenUserContext userContext,
			String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception{

		return retailStoreOpeningDaoOf(userContext).disconnectFromAll(retailStoreOpeningId, retailStoreOpeningVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOpeningManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return retailStoreOpeningDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreOpening with retail_store_country_center in RetailStore
	protected RetailStoreOpening breakWithRetailStoreByRetailStoreCountryCenter(YoubenbenUserContext userContext, String retailStoreOpeningId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());

			synchronized(retailStoreOpening){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOpeningDaoOf(userContext).planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreOpening, retailStoreCountryCenterId, this.emptyOptions());

				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				return retailStoreOpening;
			}
	}
	//disconnect RetailStoreOpening with city_service_center in RetailStore
	protected RetailStoreOpening breakWithRetailStoreByCityServiceCenter(YoubenbenUserContext userContext, String retailStoreOpeningId, String cityServiceCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());

			synchronized(retailStoreOpening){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOpeningDaoOf(userContext).planToRemoveRetailStoreListWithCityServiceCenter(retailStoreOpening, cityServiceCenterId, this.emptyOptions());

				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				return retailStoreOpening;
			}
	}
	//disconnect RetailStoreOpening with creation in RetailStore
	protected RetailStoreOpening breakWithRetailStoreByCreation(YoubenbenUserContext userContext, String retailStoreOpeningId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());

			synchronized(retailStoreOpening){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOpeningDaoOf(userContext).planToRemoveRetailStoreListWithCreation(retailStoreOpening, creationId, this.emptyOptions());

				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				return retailStoreOpening;
			}
	}
	//disconnect RetailStoreOpening with investment_invitation in RetailStore
	protected RetailStoreOpening breakWithRetailStoreByInvestmentInvitation(YoubenbenUserContext userContext, String retailStoreOpeningId, String investmentInvitationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());

			synchronized(retailStoreOpening){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOpeningDaoOf(userContext).planToRemoveRetailStoreListWithInvestmentInvitation(retailStoreOpening, investmentInvitationId, this.emptyOptions());

				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				return retailStoreOpening;
			}
	}
	//disconnect RetailStoreOpening with franchising in RetailStore
	protected RetailStoreOpening breakWithRetailStoreByFranchising(YoubenbenUserContext userContext, String retailStoreOpeningId, String franchisingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());

			synchronized(retailStoreOpening){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOpeningDaoOf(userContext).planToRemoveRetailStoreListWithFranchising(retailStoreOpening, franchisingId, this.emptyOptions());

				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				return retailStoreOpening;
			}
	}
	//disconnect RetailStoreOpening with decoration in RetailStore
	protected RetailStoreOpening breakWithRetailStoreByDecoration(YoubenbenUserContext userContext, String retailStoreOpeningId, String decorationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());

			synchronized(retailStoreOpening){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOpeningDaoOf(userContext).planToRemoveRetailStoreListWithDecoration(retailStoreOpening, decorationId, this.emptyOptions());

				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				return retailStoreOpening;
			}
	}
	//disconnect RetailStoreOpening with closing in RetailStore
	protected RetailStoreOpening breakWithRetailStoreByClosing(YoubenbenUserContext userContext, String retailStoreOpeningId, String closingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());

			synchronized(retailStoreOpening){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOpeningDaoOf(userContext).planToRemoveRetailStoreListWithClosing(retailStoreOpening, closingId, this.emptyOptions());

				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				return retailStoreOpening;
			}
	}






	protected void checkParamsForAddingRetailStore(YoubenbenUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);

		
		checkerOf(userContext).checkNameOfRetailStore(name);
		
		checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
		
		checkerOf(userContext).checkOwnerOfRetailStore(owner);
		
		checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		checkerOf(userContext).checkCreationIdOfRetailStore(creationId);
		
		checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);
		
		checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);
		
		checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);
		
		checkerOf(userContext).checkClosingIdOfRetailStore(closingId);
		
		checkerOf(userContext).checkFoundedOfRetailStore(founded);
		
		checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
		
		checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
		
		checkerOf(userContext).checkDescriptionOfRetailStore(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);


	}
	public  RetailStoreOpening addRetailStore(YoubenbenUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStore(userContext,retailStoreOpeningId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, closingId, founded, latitude, longitude, description,tokensExpr);

		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, closingId, founded, latitude, longitude, description);

		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, emptyOptions());
		synchronized(retailStoreOpening){
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOpening.addRetailStore( retailStore );
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(YoubenbenUserContext userContext, String retailStoreOpeningId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);
		checkerOf(userContext).checkIdOfRetailStore(id);

		checkerOf(userContext).checkNameOfRetailStore( name);
		checkerOf(userContext).checkTelephoneOfRetailStore( telephone);
		checkerOf(userContext).checkOwnerOfRetailStore( owner);
		checkerOf(userContext).checkFoundedOfRetailStore( founded);
		checkerOf(userContext).checkLatitudeOfRetailStore( latitude);
		checkerOf(userContext).checkLongitudeOfRetailStore( longitude);
		checkerOf(userContext).checkDescriptionOfRetailStore( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);

	}
	public  RetailStoreOpening updateRetailStoreProperties(YoubenbenUserContext userContext, String retailStoreOpeningId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreOpeningId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "is", id).done();

		RetailStoreOpening retailStoreOpeningToUpdate = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);

		if(retailStoreOpeningToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreOpeningManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}

		RetailStore item = retailStoreOpeningToUpdate.getRetailStoreList().first();

		item.updateName( name );
		item.updateTelephone( telephone );
		item.updateOwner( owner );
		item.updateFounded( founded );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );


		//checkParamsForAddingRetailStore(userContext,retailStoreOpeningId,name, code, used,tokensExpr);
		RetailStoreOpening retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpeningToUpdate, tokens().withRetailStoreList().done());
		synchronized(retailStoreOpening){
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStore createRetailStore(YoubenbenUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception{

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
		RetailStoreFranchising  franchising = new RetailStoreFranchising();
		franchising.setId(franchisingId);		
		retailStore.setFranchising(franchising);		
		RetailStoreDecoration  decoration = new RetailStoreDecoration();
		decoration.setId(decorationId);		
		retailStore.setDecoration(decoration);		
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

	protected void checkParamsForRemovingRetailStoreList(YoubenbenUserContext userContext, String retailStoreOpeningId,
			String retailStoreIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);
		for(String retailStoreIdItem: retailStoreIds){
			checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);

	}
	public  RetailStoreOpening removeRetailStoreList(YoubenbenUserContext userContext, String retailStoreOpeningId,
			String retailStoreIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreList(userContext, retailStoreOpeningId,  retailStoreIds, tokensExpr);


			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
			synchronized(retailStoreOpening){
				//Will be good when the retailStoreOpening loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreOpeningDaoOf(userContext).planToRemoveRetailStoreList(retailStoreOpening, retailStoreIds, allTokens());
				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreOpening.getRetailStoreList());
				return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStore(YoubenbenUserContext userContext, String retailStoreOpeningId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOpening( retailStoreOpeningId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);

	}
	public  RetailStoreOpening removeRetailStore(YoubenbenUserContext userContext, String retailStoreOpeningId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStore(userContext,retailStoreOpeningId, retailStoreId, retailStoreVersion,tokensExpr);

		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		synchronized(retailStoreOpening){
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOpening.removeRetailStore( retailStore );
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			deleteRelationInGraph(userContext, retailStore);
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStore(YoubenbenUserContext userContext, String retailStoreOpeningId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOpening( retailStoreOpeningId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);

	}
	public  RetailStoreOpening copyRetailStoreFrom(YoubenbenUserContext userContext, String retailStoreOpeningId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStore(userContext,retailStoreOpeningId, retailStoreId, retailStoreVersion,tokensExpr);

		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		synchronized(retailStoreOpening){
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStore.updateLastUpdateTime(userContext.now());

			retailStoreOpening.copyRetailStoreFrom( retailStore );
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, (RetailStore)retailStoreOpening.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStore(YoubenbenUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);

	}

	public  RetailStoreOpening updateRetailStore(YoubenbenUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStore(userContext, retailStoreOpeningId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, "eq", retailStoreId).done();



		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, loadTokens);

		synchronized(retailStoreOpening){
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOpening.removeRetailStore( retailStore );
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);

			RetailStore retailStore = retailStoreOpening.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreOpeningManagerException(retailStore+" is NOT FOUND" );
			}

			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOpening newCreated) throws Exception{
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
		//   RetailStoreOpening newRetailStoreOpening = this.createRetailStoreOpening(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreOpening
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreOpening.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<RetailStoreOpening> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String retailStoreOpeningId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getRetailStoreOpeningDetailScope().clone();
		RetailStoreOpening merchantObj = (RetailStoreOpening) this.view(userContext, retailStoreOpeningId);
    String merchantObjId = retailStoreOpeningId;
    String linkToUrl =	"retailStoreOpeningManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超开业"+"详情";
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
		    "retailStoreManager/listByOpening/"+merchantObjId+"/",
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


