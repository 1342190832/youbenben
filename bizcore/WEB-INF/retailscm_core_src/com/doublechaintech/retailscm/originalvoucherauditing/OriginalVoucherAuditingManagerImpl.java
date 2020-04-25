
package com.doublechaintech.retailscm.originalvoucherauditing;

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

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;


import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.doublechaintech.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.doublechaintech.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;






public class OriginalVoucherAuditingManagerImpl extends CustomRetailscmCheckerManager implements OriginalVoucherAuditingManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = OriginalVoucherAuditingTokens.start().withTokenFromListName(listName).done();
		OriginalVoucherAuditing  originalVoucherAuditing = (OriginalVoucherAuditing) this.loadOriginalVoucherAuditing(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = originalVoucherAuditing.collectRefercencesFromLists();
		originalVoucherAuditingDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, originalVoucherAuditing, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new OriginalVoucherAuditingGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "OriginalVoucherAuditing";
	@Override
	public OriginalVoucherAuditingDAO daoOf(RetailscmUserContext userContext) {
		return originalVoucherAuditingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws OriginalVoucherAuditingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new OriginalVoucherAuditingManagerException(message);

	}



 	protected OriginalVoucherAuditing saveOriginalVoucherAuditing(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, String [] tokensExpr) throws Exception{	
 		//return getOriginalVoucherAuditingDAO().save(originalVoucherAuditing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens);
 	}
 	
 	protected OriginalVoucherAuditing saveOriginalVoucherAuditingDetail(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing) throws Exception{	

 		
 		return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, allTokens());
 	}
 	
 	public OriginalVoucherAuditing loadOriginalVoucherAuditing(RetailscmUserContext userContext, String originalVoucherAuditingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherAuditingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing( userContext, originalVoucherAuditingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherAuditing, tokens);
 	}
 	
 	
 	 public OriginalVoucherAuditing searchOriginalVoucherAuditing(RetailscmUserContext userContext, String originalVoucherAuditingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherAuditingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing( userContext, originalVoucherAuditingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherAuditing, tokens);
 	}
 	
 	

 	protected OriginalVoucherAuditing present(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,originalVoucherAuditing,tokens);
		
		
		OriginalVoucherAuditing  originalVoucherAuditingToPresent = originalVoucherAuditingDaoOf(userContext).present(originalVoucherAuditing, tokens);
		
		List<BaseEntity> entityListToNaming = originalVoucherAuditingToPresent.collectRefercencesFromLists();
		originalVoucherAuditingDaoOf(userContext).alias(entityListToNaming);
		
		return  originalVoucherAuditingToPresent;
		
		
	}
 
 	
 	
 	public OriginalVoucherAuditing loadOriginalVoucherAuditingDetail(RetailscmUserContext userContext, String originalVoucherAuditingId) throws Exception{	
 		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing( userContext, originalVoucherAuditingId, allTokens());
 		return present(userContext,originalVoucherAuditing, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String originalVoucherAuditingId) throws Exception{	
 		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing( userContext, originalVoucherAuditingId, viewTokens());
 		return present(userContext,originalVoucherAuditing, allTokens());
		
 	}
 	protected OriginalVoucherAuditing saveOriginalVoucherAuditing(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object>tokens) throws Exception{	
 		return originalVoucherAuditingDaoOf(userContext).save(originalVoucherAuditing, tokens);
 	}
 	protected OriginalVoucherAuditing loadOriginalVoucherAuditing(RetailscmUserContext userContext, String originalVoucherAuditingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherAuditingManagerException.class);

 
 		return originalVoucherAuditingDaoOf(userContext).load(originalVoucherAuditingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucherAuditing, tokens);
		
		addAction(userContext, originalVoucherAuditing, tokens,"@create","createOriginalVoucherAuditing","createOriginalVoucherAuditing/","main","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"@update","updateOriginalVoucherAuditing","updateOriginalVoucherAuditing/"+originalVoucherAuditing.getId()+"/","main","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"@copy","cloneOriginalVoucherAuditing","cloneOriginalVoucherAuditing/"+originalVoucherAuditing.getId()+"/","main","primary");
		
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public OriginalVoucherAuditing createOriginalVoucherAuditing(RetailscmUserContext userContext, String who,String comments,Date makeDate) throws Exception
	//public OriginalVoucherAuditing createOriginalVoucherAuditing(RetailscmUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfOriginalVoucherAuditing(who);
		checkerOf(userContext).checkCommentsOfOriginalVoucherAuditing(comments);
		checkerOf(userContext).checkMakeDateOfOriginalVoucherAuditing(makeDate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);


		OriginalVoucherAuditing originalVoucherAuditing=createNewOriginalVoucherAuditing();	

		originalVoucherAuditing.setWho(who);
		originalVoucherAuditing.setComments(comments);
		originalVoucherAuditing.setMakeDate(makeDate);

		originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, emptyOptions());
		
		onNewInstanceCreated(userContext, originalVoucherAuditing);
		return originalVoucherAuditing;


	}
	protected OriginalVoucherAuditing createNewOriginalVoucherAuditing()
	{

		return new OriginalVoucherAuditing();
	}

	protected void checkParamsForUpdatingOriginalVoucherAuditing(RetailscmUserContext userContext,String originalVoucherAuditingId, int originalVoucherAuditingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		checkerOf(userContext).checkVersionOfOriginalVoucherAuditing( originalVoucherAuditingVersion);
		

		if(OriginalVoucherAuditing.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfOriginalVoucherAuditing(parseString(newValueExpr));
		
			
		}
		if(OriginalVoucherAuditing.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfOriginalVoucherAuditing(parseString(newValueExpr));
		
			
		}
		if(OriginalVoucherAuditing.MAKE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMakeDateOfOriginalVoucherAuditing(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);


	}



	public OriginalVoucherAuditing clone(RetailscmUserContext userContext, String fromOriginalVoucherAuditingId) throws Exception{

		return originalVoucherAuditingDaoOf(userContext).clone(fromOriginalVoucherAuditingId, this.allTokens());
	}

	public OriginalVoucherAuditing internalSaveOriginalVoucherAuditing(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing) throws Exception
	{
		return internalSaveOriginalVoucherAuditing(userContext, originalVoucherAuditing, allTokens());

	}
	public OriginalVoucherAuditing internalSaveOriginalVoucherAuditing(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingOriginalVoucherAuditing(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion, property, newValueExpr, tokensExpr);


		synchronized(originalVoucherAuditing){
			//will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherAuditing.
			if (originalVoucherAuditing.isChanged()){
			
			}
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, options);
			return originalVoucherAuditing;

		}

	}

	public OriginalVoucherAuditing updateOriginalVoucherAuditing(RetailscmUserContext userContext,String originalVoucherAuditingId, int originalVoucherAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucherAuditing(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion, property, newValueExpr, tokensExpr);



		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		if(originalVoucherAuditing.getVersion() != originalVoucherAuditingVersion){
			String message = "The target version("+originalVoucherAuditing.getVersion()+") is not equals to version("+originalVoucherAuditingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucherAuditing){
			//will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherAuditing.
			
			originalVoucherAuditing.changeProperty(property, newValueExpr);
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().done());
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().done());
		}

	}

	public OriginalVoucherAuditing updateOriginalVoucherAuditingProperty(RetailscmUserContext userContext,String originalVoucherAuditingId, int originalVoucherAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucherAuditing(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion, property, newValueExpr, tokensExpr);

		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		if(originalVoucherAuditing.getVersion() != originalVoucherAuditingVersion){
			String message = "The target version("+originalVoucherAuditing.getVersion()+") is not equals to version("+originalVoucherAuditingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucherAuditing){
			//will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherAuditing.

			originalVoucherAuditing.changeProperty(property, newValueExpr);
			
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().done());
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected OriginalVoucherAuditingTokens tokens(){
		return OriginalVoucherAuditingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherAuditingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortOriginalVoucherListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OriginalVoucherAuditingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String originalVoucherAuditingId, int originalVoucherAuditingVersion) throws Exception {
		//deleteInternal(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String originalVoucherAuditingId, int originalVoucherAuditingVersion) throws Exception{

		originalVoucherAuditingDaoOf(userContext).delete(originalVoucherAuditingId, originalVoucherAuditingVersion);
	}

	public OriginalVoucherAuditing forgetByAll(RetailscmUserContext userContext, String originalVoucherAuditingId, int originalVoucherAuditingVersion) throws Exception {
		return forgetByAllInternal(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion);
	}
	protected OriginalVoucherAuditing forgetByAllInternal(RetailscmUserContext userContext,
			String originalVoucherAuditingId, int originalVoucherAuditingVersion) throws Exception{

		return originalVoucherAuditingDaoOf(userContext).disconnectFromAll(originalVoucherAuditingId, originalVoucherAuditingVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherAuditingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return originalVoucherAuditingDaoOf(userContext).deleteAll();
	}


	//disconnect OriginalVoucherAuditing with belongs_to in OriginalVoucher
	protected OriginalVoucherAuditing breakWithOriginalVoucherByBelongsTo(RetailscmUserContext userContext, String originalVoucherAuditingId, String belongsToId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());

			synchronized(originalVoucherAuditing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				originalVoucherAuditingDaoOf(userContext).planToRemoveOriginalVoucherListWithBelongsTo(originalVoucherAuditing, belongsToId, this.emptyOptions());

				originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
				return originalVoucherAuditing;
			}
	}
	//disconnect OriginalVoucherAuditing with creation in OriginalVoucher
	protected OriginalVoucherAuditing breakWithOriginalVoucherByCreation(RetailscmUserContext userContext, String originalVoucherAuditingId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());

			synchronized(originalVoucherAuditing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				originalVoucherAuditingDaoOf(userContext).planToRemoveOriginalVoucherListWithCreation(originalVoucherAuditing, creationId, this.emptyOptions());

				originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
				return originalVoucherAuditing;
			}
	}
	//disconnect OriginalVoucherAuditing with confirmation in OriginalVoucher
	protected OriginalVoucherAuditing breakWithOriginalVoucherByConfirmation(RetailscmUserContext userContext, String originalVoucherAuditingId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());

			synchronized(originalVoucherAuditing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				originalVoucherAuditingDaoOf(userContext).planToRemoveOriginalVoucherListWithConfirmation(originalVoucherAuditing, confirmationId, this.emptyOptions());

				originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
				return originalVoucherAuditing;
			}
	}






	protected void checkParamsForAddingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String confirmationId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);

		
		checkerOf(userContext).checkTitleOfOriginalVoucher(title);
		
		checkerOf(userContext).checkMadeByOfOriginalVoucher(madeBy);
		
		checkerOf(userContext).checkReceivedByOfOriginalVoucher(receivedBy);
		
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher(voucherType);
		
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher(voucherImage);
		
		checkerOf(userContext).checkBelongsToIdOfOriginalVoucher(belongsToId);
		
		checkerOf(userContext).checkCreationIdOfOriginalVoucher(creationId);
		
		checkerOf(userContext).checkConfirmationIdOfOriginalVoucher(confirmationId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);


	}
	public  OriginalVoucherAuditing addOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String confirmationId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingOriginalVoucher(userContext,originalVoucherAuditingId,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId, creationId, confirmationId,tokensExpr);

		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId, creationId, confirmationId);

		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, emptyOptions());
		synchronized(originalVoucherAuditing){
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherAuditing.addOriginalVoucher( originalVoucher );
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, originalVoucher);
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingOriginalVoucherProperties(RetailscmUserContext userContext, String originalVoucherAuditingId,String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		checkerOf(userContext).checkIdOfOriginalVoucher(id);

		checkerOf(userContext).checkTitleOfOriginalVoucher( title);
		checkerOf(userContext).checkMadeByOfOriginalVoucher( madeBy);
		checkerOf(userContext).checkReceivedByOfOriginalVoucher( receivedBy);
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher( voucherType);
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher( voucherImage);

		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);

	}
	public  OriginalVoucherAuditing updateOriginalVoucherProperties(RetailscmUserContext userContext, String originalVoucherAuditingId, String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucherProperties(userContext,originalVoucherAuditingId,id,title,madeBy,receivedBy,voucherType,voucherImage,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withOriginalVoucherListList()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "is", id).done();

		OriginalVoucherAuditing originalVoucherAuditingToUpdate = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, options);

		if(originalVoucherAuditingToUpdate.getOriginalVoucherList().isEmpty()){
			throw new OriginalVoucherAuditingManagerException("OriginalVoucher is NOT FOUND with id: '"+id+"'");
		}

		OriginalVoucher item = originalVoucherAuditingToUpdate.getOriginalVoucherList().first();

		item.updateTitle( title );
		item.updateMadeBy( madeBy );
		item.updateReceivedBy( receivedBy );
		item.updateVoucherType( voucherType );
		item.updateVoucherImage( voucherImage );


		//checkParamsForAddingOriginalVoucher(userContext,originalVoucherAuditingId,name, code, used,tokensExpr);
		OriginalVoucherAuditing originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditingToUpdate, tokens().withOriginalVoucherList().done());
		synchronized(originalVoucherAuditing){
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}
	}


	protected OriginalVoucher createOriginalVoucher(RetailscmUserContext userContext, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String confirmationId) throws Exception{

		OriginalVoucher originalVoucher = new OriginalVoucher();
		
		
		originalVoucher.setTitle(title);		
		originalVoucher.setMadeBy(madeBy);		
		originalVoucher.setReceivedBy(receivedBy);		
		originalVoucher.setVoucherType(voucherType);		
		originalVoucher.setVoucherImage(voucherImage);		
		AccountingDocument  belongsTo = new AccountingDocument();
		belongsTo.setId(belongsToId);		
		originalVoucher.setBelongsTo(belongsTo);		
		OriginalVoucherCreation  creation = new OriginalVoucherCreation();
		creation.setId(creationId);		
		originalVoucher.setCreation(creation);		
		OriginalVoucherConfirmation  confirmation = new OriginalVoucherConfirmation();
		confirmation.setId(confirmationId);		
		originalVoucher.setConfirmation(confirmation);
	
		
		return originalVoucher;


	}

	protected OriginalVoucher createIndexedOriginalVoucher(String id, int version){

		OriginalVoucher originalVoucher = new OriginalVoucher();
		originalVoucher.setId(id);
		originalVoucher.setVersion(version);
		return originalVoucher;

	}

	protected void checkParamsForRemovingOriginalVoucherList(RetailscmUserContext userContext, String originalVoucherAuditingId,
			String originalVoucherIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		for(String originalVoucherIdItem: originalVoucherIds){
			checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);

	}
	public  OriginalVoucherAuditing removeOriginalVoucherList(RetailscmUserContext userContext, String originalVoucherAuditingId,
			String originalVoucherIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingOriginalVoucherList(userContext, originalVoucherAuditingId,  originalVoucherIds, tokensExpr);


			OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
			synchronized(originalVoucherAuditing){
				//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				originalVoucherAuditingDaoOf(userContext).planToRemoveOriginalVoucherList(originalVoucherAuditing, originalVoucherIds, allTokens());
				originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
				deleteRelationListInGraph(userContext, originalVoucherAuditing.getOriginalVoucherList());
				return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOriginalVoucherAuditing( originalVoucherAuditingId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);

	}
	public  OriginalVoucherAuditing removeOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingOriginalVoucher(userContext,originalVoucherAuditingId, originalVoucherId, originalVoucherVersion,tokensExpr);

		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		synchronized(originalVoucherAuditing){
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherAuditing.removeOriginalVoucher( originalVoucher );
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			deleteRelationInGraph(userContext, originalVoucher);
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOriginalVoucherAuditing( originalVoucherAuditingId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);

	}
	public  OriginalVoucherAuditing copyOriginalVoucherFrom(RetailscmUserContext userContext, String originalVoucherAuditingId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingOriginalVoucher(userContext,originalVoucherAuditingId, originalVoucherId, originalVoucherVersion,tokensExpr);

		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		synchronized(originalVoucherAuditing){
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			originalVoucherAuditing.copyOriginalVoucherFrom( originalVoucher );
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, (OriginalVoucher)originalVoucherAuditing.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		

		if(OriginalVoucher.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfOriginalVoucher(parseString(newValueExpr));
		
		}
		
		if(OriginalVoucher.MADE_BY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMadeByOfOriginalVoucher(parseString(newValueExpr));
		
		}
		
		if(OriginalVoucher.RECEIVED_BY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkReceivedByOfOriginalVoucher(parseString(newValueExpr));
		
		}
		
		if(OriginalVoucher.VOUCHER_TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkVoucherTypeOfOriginalVoucher(parseString(newValueExpr));
		
		}
		
		if(OriginalVoucher.VOUCHER_IMAGE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkVoucherImageOfOriginalVoucher(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);

	}

	public  OriginalVoucherAuditing updateOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherAuditingId, originalVoucherId, originalVoucherVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withOriginalVoucherList().searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "eq", originalVoucherId).done();



		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, loadTokens);

		synchronized(originalVoucherAuditing){
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//originalVoucherAuditing.removeOriginalVoucher( originalVoucher );
			//make changes to AcceleraterAccount.
			OriginalVoucher originalVoucherIndex = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);

			OriginalVoucher originalVoucher = originalVoucherAuditing.findTheOriginalVoucher(originalVoucherIndex);
			if(originalVoucher == null){
				throw new OriginalVoucherAuditingManagerException(originalVoucher+" is NOT FOUND" );
			}

			originalVoucher.changeProperty(property, newValueExpr);
			
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, OriginalVoucherAuditing newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
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
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
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
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   OriginalVoucherAuditing newOriginalVoucherAuditing = this.createOriginalVoucherAuditing(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newOriginalVoucherAuditing
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, OriginalVoucherAuditing.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<OriginalVoucherAuditing> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String originalVoucherAuditingId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getOriginalVoucherAuditingDetailScope().clone();
		OriginalVoucherAuditing merchantObj = (OriginalVoucherAuditing) this.view(userContext, originalVoucherAuditingId);
    String merchantObjId = originalVoucherAuditingId;
    String linkToUrl =	"originalVoucherAuditingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "原始凭证的审核"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
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
				MapUtil.put("id", "3-comments")
				    .put("fieldName", "comments")
				    .put("label", "评论")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("comments", merchantObj.getComments());

		propList.add(
				MapUtil.put("id", "4-makeDate")
				    .put("fieldName", "makeDate")
				    .put("label", "制造日期")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("makeDate", merchantObj.getMakeDate());

		//处理 sectionList

		//处理Section：originalVoucherListSection
		Map originalVoucherListSection = ListofUtils.buildSection(
		    "originalVoucherListSection",
		    "原始凭证列表",
		    null,
		    "",
		    "__no_group",
		    "originalVoucherManager/listByAuditing/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(originalVoucherListSection);

		result.put("originalVoucherListSection", ListofUtils.toShortList(merchantObj.getOriginalVoucherList(), "originalVoucher"));
		vscope.field("originalVoucherListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( OriginalVoucher.class.getName(), null));

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


