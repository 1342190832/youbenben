
package com.youbenben.youbenben.originalvoucherconfirmation;

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


import com.youbenben.youbenben.originalvoucher.OriginalVoucher;


import com.youbenben.youbenben.originalvouchercreation.OriginalVoucherCreation;
import com.youbenben.youbenben.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.youbenben.youbenben.originalvoucherauditing.OriginalVoucherAuditing;
import com.youbenben.youbenben.accountingdocument.AccountingDocument;






public class OriginalVoucherConfirmationManagerImpl extends CustomYoubenbenCheckerManager implements OriginalVoucherConfirmationManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = OriginalVoucherConfirmationTokens.start().withTokenFromListName(listName).done();
		OriginalVoucherConfirmation  originalVoucherConfirmation = (OriginalVoucherConfirmation) this.loadOriginalVoucherConfirmation(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = originalVoucherConfirmation.collectRefercencesFromLists();
		originalVoucherConfirmationDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, originalVoucherConfirmation, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new OriginalVoucherConfirmationGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "OriginalVoucherConfirmation";
	@Override
	public OriginalVoucherConfirmationDAO daoOf(YoubenbenUserContext userContext) {
		return originalVoucherConfirmationDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws OriginalVoucherConfirmationManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new OriginalVoucherConfirmationManagerException(message);

	}



 	protected OriginalVoucherConfirmation saveOriginalVoucherConfirmation(YoubenbenUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, String [] tokensExpr) throws Exception{	
 		//return getOriginalVoucherConfirmationDAO().save(originalVoucherConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens);
 	}
 	
 	protected OriginalVoucherConfirmation saveOriginalVoucherConfirmationDetail(YoubenbenUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation) throws Exception{	

 		
 		return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, allTokens());
 	}
 	
 	public OriginalVoucherConfirmation loadOriginalVoucherConfirmation(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherConfirmationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation( userContext, originalVoucherConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherConfirmation, tokens);
 	}
 	
 	
 	 public OriginalVoucherConfirmation searchOriginalVoucherConfirmation(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherConfirmationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation( userContext, originalVoucherConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherConfirmation, tokens);
 	}
 	
 	

 	protected OriginalVoucherConfirmation present(YoubenbenUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,originalVoucherConfirmation,tokens);
		
		
		OriginalVoucherConfirmation  originalVoucherConfirmationToPresent = originalVoucherConfirmationDaoOf(userContext).present(originalVoucherConfirmation, tokens);
		
		List<BaseEntity> entityListToNaming = originalVoucherConfirmationToPresent.collectRefercencesFromLists();
		originalVoucherConfirmationDaoOf(userContext).alias(entityListToNaming);
		
		return  originalVoucherConfirmationToPresent;
		
		
	}
 
 	
 	
 	public OriginalVoucherConfirmation loadOriginalVoucherConfirmationDetail(YoubenbenUserContext userContext, String originalVoucherConfirmationId) throws Exception{	
 		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation( userContext, originalVoucherConfirmationId, allTokens());
 		return present(userContext,originalVoucherConfirmation, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String originalVoucherConfirmationId) throws Exception{	
 		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation( userContext, originalVoucherConfirmationId, viewTokens());
 		return present(userContext,originalVoucherConfirmation, allTokens());
		
 	}
 	protected OriginalVoucherConfirmation saveOriginalVoucherConfirmation(YoubenbenUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object>tokens) throws Exception{	
 		return originalVoucherConfirmationDaoOf(userContext).save(originalVoucherConfirmation, tokens);
 	}
 	protected OriginalVoucherConfirmation loadOriginalVoucherConfirmation(YoubenbenUserContext userContext, String originalVoucherConfirmationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherConfirmationManagerException.class);

 
 		return originalVoucherConfirmationDaoOf(userContext).load(originalVoucherConfirmationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucherConfirmation, tokens);
		
		addAction(userContext, originalVoucherConfirmation, tokens,"@create","createOriginalVoucherConfirmation","createOriginalVoucherConfirmation/","main","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"@update","updateOriginalVoucherConfirmation","updateOriginalVoucherConfirmation/"+originalVoucherConfirmation.getId()+"/","main","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"@copy","cloneOriginalVoucherConfirmation","cloneOriginalVoucherConfirmation/"+originalVoucherConfirmation.getId()+"/","main","primary");
		
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public OriginalVoucherConfirmation createOriginalVoucherConfirmation(YoubenbenUserContext userContext, String who,String comments,Date makeDate) throws Exception
	//public OriginalVoucherConfirmation createOriginalVoucherConfirmation(YoubenbenUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfOriginalVoucherConfirmation(who);
		checkerOf(userContext).checkCommentsOfOriginalVoucherConfirmation(comments);
		checkerOf(userContext).checkMakeDateOfOriginalVoucherConfirmation(makeDate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);


		OriginalVoucherConfirmation originalVoucherConfirmation=createNewOriginalVoucherConfirmation();	

		originalVoucherConfirmation.setWho(who);
		originalVoucherConfirmation.setComments(comments);
		originalVoucherConfirmation.setMakeDate(makeDate);

		originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, emptyOptions());
		
		onNewInstanceCreated(userContext, originalVoucherConfirmation);
		return originalVoucherConfirmation;


	}
	protected OriginalVoucherConfirmation createNewOriginalVoucherConfirmation()
	{

		return new OriginalVoucherConfirmation();
	}

	protected void checkParamsForUpdatingOriginalVoucherConfirmation(YoubenbenUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		checkerOf(userContext).checkVersionOfOriginalVoucherConfirmation( originalVoucherConfirmationVersion);
		

		if(OriginalVoucherConfirmation.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfOriginalVoucherConfirmation(parseString(newValueExpr));
		
			
		}
		if(OriginalVoucherConfirmation.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfOriginalVoucherConfirmation(parseString(newValueExpr));
		
			
		}
		if(OriginalVoucherConfirmation.MAKE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMakeDateOfOriginalVoucherConfirmation(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);


	}



	public OriginalVoucherConfirmation clone(YoubenbenUserContext userContext, String fromOriginalVoucherConfirmationId) throws Exception{

		return originalVoucherConfirmationDaoOf(userContext).clone(fromOriginalVoucherConfirmationId, this.allTokens());
	}

	public OriginalVoucherConfirmation internalSaveOriginalVoucherConfirmation(YoubenbenUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation) throws Exception
	{
		return internalSaveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, allTokens());

	}
	public OriginalVoucherConfirmation internalSaveOriginalVoucherConfirmation(YoubenbenUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion, property, newValueExpr, tokensExpr);


		synchronized(originalVoucherConfirmation){
			//will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherConfirmation.
			if (originalVoucherConfirmation.isChanged()){
			
			}
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, options);
			return originalVoucherConfirmation;

		}

	}

	public OriginalVoucherConfirmation updateOriginalVoucherConfirmation(YoubenbenUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion, property, newValueExpr, tokensExpr);



		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		if(originalVoucherConfirmation.getVersion() != originalVoucherConfirmationVersion){
			String message = "The target version("+originalVoucherConfirmation.getVersion()+") is not equals to version("+originalVoucherConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucherConfirmation){
			//will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherConfirmation.
			
			originalVoucherConfirmation.changeProperty(property, newValueExpr);
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().done());
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().done());
		}

	}

	public OriginalVoucherConfirmation updateOriginalVoucherConfirmationProperty(YoubenbenUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion, property, newValueExpr, tokensExpr);

		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		if(originalVoucherConfirmation.getVersion() != originalVoucherConfirmationVersion){
			String message = "The target version("+originalVoucherConfirmation.getVersion()+") is not equals to version("+originalVoucherConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucherConfirmation){
			//will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherConfirmation.

			originalVoucherConfirmation.changeProperty(property, newValueExpr);
			
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().done());
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected OriginalVoucherConfirmationTokens tokens(){
		return OriginalVoucherConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherConfirmationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortOriginalVoucherListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OriginalVoucherConfirmationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String originalVoucherConfirmationId, int originalVoucherConfirmationVersion) throws Exception {
		//deleteInternal(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String originalVoucherConfirmationId, int originalVoucherConfirmationVersion) throws Exception{

		originalVoucherConfirmationDaoOf(userContext).delete(originalVoucherConfirmationId, originalVoucherConfirmationVersion);
	}

	public OriginalVoucherConfirmation forgetByAll(YoubenbenUserContext userContext, String originalVoucherConfirmationId, int originalVoucherConfirmationVersion) throws Exception {
		return forgetByAllInternal(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion);
	}
	protected OriginalVoucherConfirmation forgetByAllInternal(YoubenbenUserContext userContext,
			String originalVoucherConfirmationId, int originalVoucherConfirmationVersion) throws Exception{

		return originalVoucherConfirmationDaoOf(userContext).disconnectFromAll(originalVoucherConfirmationId, originalVoucherConfirmationVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return originalVoucherConfirmationDaoOf(userContext).deleteAll();
	}


	//disconnect OriginalVoucherConfirmation with belongs_to in OriginalVoucher
	protected OriginalVoucherConfirmation breakWithOriginalVoucherByBelongsTo(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String belongsToId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());

			synchronized(originalVoucherConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				originalVoucherConfirmationDaoOf(userContext).planToRemoveOriginalVoucherListWithBelongsTo(originalVoucherConfirmation, belongsToId, this.emptyOptions());

				originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
				return originalVoucherConfirmation;
			}
	}
	//disconnect OriginalVoucherConfirmation with creation in OriginalVoucher
	protected OriginalVoucherConfirmation breakWithOriginalVoucherByCreation(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());

			synchronized(originalVoucherConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				originalVoucherConfirmationDaoOf(userContext).planToRemoveOriginalVoucherListWithCreation(originalVoucherConfirmation, creationId, this.emptyOptions());

				originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
				return originalVoucherConfirmation;
			}
	}
	//disconnect OriginalVoucherConfirmation with auditing in OriginalVoucher
	protected OriginalVoucherConfirmation breakWithOriginalVoucherByAuditing(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String auditingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());

			synchronized(originalVoucherConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				originalVoucherConfirmationDaoOf(userContext).planToRemoveOriginalVoucherListWithAuditing(originalVoucherConfirmation, auditingId, this.emptyOptions());

				originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
				return originalVoucherConfirmation;
			}
	}






	protected void checkParamsForAddingOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String auditingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);

		
		checkerOf(userContext).checkTitleOfOriginalVoucher(title);
		
		checkerOf(userContext).checkMadeByOfOriginalVoucher(madeBy);
		
		checkerOf(userContext).checkReceivedByOfOriginalVoucher(receivedBy);
		
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher(voucherType);
		
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher(voucherImage);
		
		checkerOf(userContext).checkBelongsToIdOfOriginalVoucher(belongsToId);
		
		checkerOf(userContext).checkCreationIdOfOriginalVoucher(creationId);
		
		checkerOf(userContext).checkAuditingIdOfOriginalVoucher(auditingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);


	}
	public  OriginalVoucherConfirmation addOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String auditingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingOriginalVoucher(userContext,originalVoucherConfirmationId,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId, creationId, auditingId,tokensExpr);

		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId, creationId, auditingId);

		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, emptyOptions());
		synchronized(originalVoucherConfirmation){
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherConfirmation.addOriginalVoucher( originalVoucher );
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, originalVoucher);
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingOriginalVoucherProperties(YoubenbenUserContext userContext, String originalVoucherConfirmationId,String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		checkerOf(userContext).checkIdOfOriginalVoucher(id);

		checkerOf(userContext).checkTitleOfOriginalVoucher( title);
		checkerOf(userContext).checkMadeByOfOriginalVoucher( madeBy);
		checkerOf(userContext).checkReceivedByOfOriginalVoucher( receivedBy);
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher( voucherType);
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher( voucherImage);

		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);

	}
	public  OriginalVoucherConfirmation updateOriginalVoucherProperties(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucherProperties(userContext,originalVoucherConfirmationId,id,title,madeBy,receivedBy,voucherType,voucherImage,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withOriginalVoucherListList()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "is", id).done();

		OriginalVoucherConfirmation originalVoucherConfirmationToUpdate = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, options);

		if(originalVoucherConfirmationToUpdate.getOriginalVoucherList().isEmpty()){
			throw new OriginalVoucherConfirmationManagerException("OriginalVoucher is NOT FOUND with id: '"+id+"'");
		}

		OriginalVoucher item = originalVoucherConfirmationToUpdate.getOriginalVoucherList().first();

		item.updateTitle( title );
		item.updateMadeBy( madeBy );
		item.updateReceivedBy( receivedBy );
		item.updateVoucherType( voucherType );
		item.updateVoucherImage( voucherImage );


		//checkParamsForAddingOriginalVoucher(userContext,originalVoucherConfirmationId,name, code, used,tokensExpr);
		OriginalVoucherConfirmation originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmationToUpdate, tokens().withOriginalVoucherList().done());
		synchronized(originalVoucherConfirmation){
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}
	}


	protected OriginalVoucher createOriginalVoucher(YoubenbenUserContext userContext, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String auditingId) throws Exception{

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
		OriginalVoucherAuditing  auditing = new OriginalVoucherAuditing();
		auditing.setId(auditingId);		
		originalVoucher.setAuditing(auditing);
	
		
		return originalVoucher;


	}

	protected OriginalVoucher createIndexedOriginalVoucher(String id, int version){

		OriginalVoucher originalVoucher = new OriginalVoucher();
		originalVoucher.setId(id);
		originalVoucher.setVersion(version);
		return originalVoucher;

	}

	protected void checkParamsForRemovingOriginalVoucherList(YoubenbenUserContext userContext, String originalVoucherConfirmationId,
			String originalVoucherIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		for(String originalVoucherIdItem: originalVoucherIds){
			checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);

	}
	public  OriginalVoucherConfirmation removeOriginalVoucherList(YoubenbenUserContext userContext, String originalVoucherConfirmationId,
			String originalVoucherIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingOriginalVoucherList(userContext, originalVoucherConfirmationId,  originalVoucherIds, tokensExpr);


			OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
			synchronized(originalVoucherConfirmation){
				//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				originalVoucherConfirmationDaoOf(userContext).planToRemoveOriginalVoucherList(originalVoucherConfirmation, originalVoucherIds, allTokens());
				originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
				deleteRelationListInGraph(userContext, originalVoucherConfirmation.getOriginalVoucherList());
				return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherConfirmationId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOriginalVoucherConfirmation( originalVoucherConfirmationId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);

	}
	public  OriginalVoucherConfirmation removeOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherConfirmationId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingOriginalVoucher(userContext,originalVoucherConfirmationId, originalVoucherId, originalVoucherVersion,tokensExpr);

		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		synchronized(originalVoucherConfirmation){
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherConfirmation.removeOriginalVoucher( originalVoucher );
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			deleteRelationInGraph(userContext, originalVoucher);
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherConfirmationId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOriginalVoucherConfirmation( originalVoucherConfirmationId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);

	}
	public  OriginalVoucherConfirmation copyOriginalVoucherFrom(YoubenbenUserContext userContext, String originalVoucherConfirmationId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingOriginalVoucher(userContext,originalVoucherConfirmationId, originalVoucherId, originalVoucherVersion,tokensExpr);

		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		synchronized(originalVoucherConfirmation){
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			originalVoucherConfirmation.copyOriginalVoucherFrom( originalVoucher );
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, (OriginalVoucher)originalVoucherConfirmation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);

	}

	public  OriginalVoucherConfirmation updateOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherConfirmationId, originalVoucherId, originalVoucherVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withOriginalVoucherList().searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "eq", originalVoucherId).done();



		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, loadTokens);

		synchronized(originalVoucherConfirmation){
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//originalVoucherConfirmation.removeOriginalVoucher( originalVoucher );
			//make changes to AcceleraterAccount.
			OriginalVoucher originalVoucherIndex = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);

			OriginalVoucher originalVoucher = originalVoucherConfirmation.findTheOriginalVoucher(originalVoucherIndex);
			if(originalVoucher == null){
				throw new OriginalVoucherConfirmationManagerException(originalVoucher+" is NOT FOUND" );
			}

			originalVoucher.changeProperty(property, newValueExpr);
			
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, OriginalVoucherConfirmation newCreated) throws Exception{
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
		//   OriginalVoucherConfirmation newOriginalVoucherConfirmation = this.createOriginalVoucherConfirmation(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newOriginalVoucherConfirmation
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, OriginalVoucherConfirmation.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<OriginalVoucherConfirmation> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String originalVoucherConfirmationId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getOriginalVoucherConfirmationDetailScope().clone();
		OriginalVoucherConfirmation merchantObj = (OriginalVoucherConfirmation) this.view(userContext, originalVoucherConfirmationId);
    String merchantObjId = originalVoucherConfirmationId;
    String linkToUrl =	"originalVoucherConfirmationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "原始凭证的确认"+"详情";
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
		    "originalVoucherManager/listByConfirmation/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(originalVoucherListSection);

		result.put("originalVoucherListSection", ListofUtils.toShortList(merchantObj.getOriginalVoucherList(), "originalVoucher"));
		vscope.field("originalVoucherListSection", YoubenbenListOfViewScope.getInstance()
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


