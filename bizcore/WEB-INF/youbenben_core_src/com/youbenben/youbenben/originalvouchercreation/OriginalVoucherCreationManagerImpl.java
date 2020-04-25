
package com.youbenben.youbenben.originalvouchercreation;

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






public class OriginalVoucherCreationManagerImpl extends CustomYoubenbenCheckerManager implements OriginalVoucherCreationManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = OriginalVoucherCreationTokens.start().withTokenFromListName(listName).done();
		OriginalVoucherCreation  originalVoucherCreation = (OriginalVoucherCreation) this.loadOriginalVoucherCreation(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = originalVoucherCreation.collectRefercencesFromLists();
		originalVoucherCreationDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, originalVoucherCreation, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new OriginalVoucherCreationGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "OriginalVoucherCreation";
	@Override
	public OriginalVoucherCreationDAO daoOf(YoubenbenUserContext userContext) {
		return originalVoucherCreationDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws OriginalVoucherCreationManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new OriginalVoucherCreationManagerException(message);

	}



 	protected OriginalVoucherCreation saveOriginalVoucherCreation(YoubenbenUserContext userContext, OriginalVoucherCreation originalVoucherCreation, String [] tokensExpr) throws Exception{	
 		//return getOriginalVoucherCreationDAO().save(originalVoucherCreation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens);
 	}
 	
 	protected OriginalVoucherCreation saveOriginalVoucherCreationDetail(YoubenbenUserContext userContext, OriginalVoucherCreation originalVoucherCreation) throws Exception{	

 		
 		return saveOriginalVoucherCreation(userContext, originalVoucherCreation, allTokens());
 	}
 	
 	public OriginalVoucherCreation loadOriginalVoucherCreation(YoubenbenUserContext userContext, String originalVoucherCreationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOriginalVoucherCreation(originalVoucherCreationId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherCreationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation( userContext, originalVoucherCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherCreation, tokens);
 	}
 	
 	
 	 public OriginalVoucherCreation searchOriginalVoucherCreation(YoubenbenUserContext userContext, String originalVoucherCreationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOriginalVoucherCreation(originalVoucherCreationId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherCreationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation( userContext, originalVoucherCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherCreation, tokens);
 	}
 	
 	

 	protected OriginalVoucherCreation present(YoubenbenUserContext userContext, OriginalVoucherCreation originalVoucherCreation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,originalVoucherCreation,tokens);
		
		
		OriginalVoucherCreation  originalVoucherCreationToPresent = originalVoucherCreationDaoOf(userContext).present(originalVoucherCreation, tokens);
		
		List<BaseEntity> entityListToNaming = originalVoucherCreationToPresent.collectRefercencesFromLists();
		originalVoucherCreationDaoOf(userContext).alias(entityListToNaming);
		
		return  originalVoucherCreationToPresent;
		
		
	}
 
 	
 	
 	public OriginalVoucherCreation loadOriginalVoucherCreationDetail(YoubenbenUserContext userContext, String originalVoucherCreationId) throws Exception{	
 		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation( userContext, originalVoucherCreationId, allTokens());
 		return present(userContext,originalVoucherCreation, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String originalVoucherCreationId) throws Exception{	
 		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation( userContext, originalVoucherCreationId, viewTokens());
 		return present(userContext,originalVoucherCreation, allTokens());
		
 	}
 	protected OriginalVoucherCreation saveOriginalVoucherCreation(YoubenbenUserContext userContext, OriginalVoucherCreation originalVoucherCreation, Map<String,Object>tokens) throws Exception{	
 		return originalVoucherCreationDaoOf(userContext).save(originalVoucherCreation, tokens);
 	}
 	protected OriginalVoucherCreation loadOriginalVoucherCreation(YoubenbenUserContext userContext, String originalVoucherCreationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfOriginalVoucherCreation(originalVoucherCreationId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherCreationManagerException.class);

 
 		return originalVoucherCreationDaoOf(userContext).load(originalVoucherCreationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, OriginalVoucherCreation originalVoucherCreation, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucherCreation, tokens);
		
		addAction(userContext, originalVoucherCreation, tokens,"@create","createOriginalVoucherCreation","createOriginalVoucherCreation/","main","primary");
		addAction(userContext, originalVoucherCreation, tokens,"@update","updateOriginalVoucherCreation","updateOriginalVoucherCreation/"+originalVoucherCreation.getId()+"/","main","primary");
		addAction(userContext, originalVoucherCreation, tokens,"@copy","cloneOriginalVoucherCreation","cloneOriginalVoucherCreation/"+originalVoucherCreation.getId()+"/","main","primary");
		
		addAction(userContext, originalVoucherCreation, tokens,"original_voucher_creation.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+originalVoucherCreation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherCreation, tokens,"original_voucher_creation.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+originalVoucherCreation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherCreation, tokens,"original_voucher_creation.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucherCreation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherCreation, tokens,"original_voucher_creation.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+originalVoucherCreation.getId()+"/","originalVoucherList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, OriginalVoucherCreation originalVoucherCreation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public OriginalVoucherCreation createOriginalVoucherCreation(YoubenbenUserContext userContext, String who,String comments,Date makeDate) throws Exception
	//public OriginalVoucherCreation createOriginalVoucherCreation(YoubenbenUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfOriginalVoucherCreation(who);
		checkerOf(userContext).checkCommentsOfOriginalVoucherCreation(comments);
		checkerOf(userContext).checkMakeDateOfOriginalVoucherCreation(makeDate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherCreationManagerException.class);


		OriginalVoucherCreation originalVoucherCreation=createNewOriginalVoucherCreation();	

		originalVoucherCreation.setWho(who);
		originalVoucherCreation.setComments(comments);
		originalVoucherCreation.setMakeDate(makeDate);

		originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, emptyOptions());
		
		onNewInstanceCreated(userContext, originalVoucherCreation);
		return originalVoucherCreation;


	}
	protected OriginalVoucherCreation createNewOriginalVoucherCreation()
	{

		return new OriginalVoucherCreation();
	}

	protected void checkParamsForUpdatingOriginalVoucherCreation(YoubenbenUserContext userContext,String originalVoucherCreationId, int originalVoucherCreationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfOriginalVoucherCreation(originalVoucherCreationId);
		checkerOf(userContext).checkVersionOfOriginalVoucherCreation( originalVoucherCreationVersion);
		

		if(OriginalVoucherCreation.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfOriginalVoucherCreation(parseString(newValueExpr));
		
			
		}
		if(OriginalVoucherCreation.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfOriginalVoucherCreation(parseString(newValueExpr));
		
			
		}
		if(OriginalVoucherCreation.MAKE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMakeDateOfOriginalVoucherCreation(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherCreationManagerException.class);


	}



	public OriginalVoucherCreation clone(YoubenbenUserContext userContext, String fromOriginalVoucherCreationId) throws Exception{

		return originalVoucherCreationDaoOf(userContext).clone(fromOriginalVoucherCreationId, this.allTokens());
	}

	public OriginalVoucherCreation internalSaveOriginalVoucherCreation(YoubenbenUserContext userContext, OriginalVoucherCreation originalVoucherCreation) throws Exception
	{
		return internalSaveOriginalVoucherCreation(userContext, originalVoucherCreation, allTokens());

	}
	public OriginalVoucherCreation internalSaveOriginalVoucherCreation(YoubenbenUserContext userContext, OriginalVoucherCreation originalVoucherCreation, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingOriginalVoucherCreation(userContext, originalVoucherCreationId, originalVoucherCreationVersion, property, newValueExpr, tokensExpr);


		synchronized(originalVoucherCreation){
			//will be good when the originalVoucherCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherCreation.
			if (originalVoucherCreation.isChanged()){
			
			}
			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, options);
			return originalVoucherCreation;

		}

	}

	public OriginalVoucherCreation updateOriginalVoucherCreation(YoubenbenUserContext userContext,String originalVoucherCreationId, int originalVoucherCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucherCreation(userContext, originalVoucherCreationId, originalVoucherCreationVersion, property, newValueExpr, tokensExpr);



		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());
		if(originalVoucherCreation.getVersion() != originalVoucherCreationVersion){
			String message = "The target version("+originalVoucherCreation.getVersion()+") is not equals to version("+originalVoucherCreationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucherCreation){
			//will be good when the originalVoucherCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherCreation.
			
			originalVoucherCreation.changeProperty(property, newValueExpr);
			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().done());
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().done());
		}

	}

	public OriginalVoucherCreation updateOriginalVoucherCreationProperty(YoubenbenUserContext userContext,String originalVoucherCreationId, int originalVoucherCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucherCreation(userContext, originalVoucherCreationId, originalVoucherCreationVersion, property, newValueExpr, tokensExpr);

		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());
		if(originalVoucherCreation.getVersion() != originalVoucherCreationVersion){
			String message = "The target version("+originalVoucherCreation.getVersion()+") is not equals to version("+originalVoucherCreationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucherCreation){
			//will be good when the originalVoucherCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherCreation.

			originalVoucherCreation.changeProperty(property, newValueExpr);
			
			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().done());
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected OriginalVoucherCreationTokens tokens(){
		return OriginalVoucherCreationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherCreationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortOriginalVoucherListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OriginalVoucherCreationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String originalVoucherCreationId, int originalVoucherCreationVersion) throws Exception {
		//deleteInternal(userContext, originalVoucherCreationId, originalVoucherCreationVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String originalVoucherCreationId, int originalVoucherCreationVersion) throws Exception{

		originalVoucherCreationDaoOf(userContext).delete(originalVoucherCreationId, originalVoucherCreationVersion);
	}

	public OriginalVoucherCreation forgetByAll(YoubenbenUserContext userContext, String originalVoucherCreationId, int originalVoucherCreationVersion) throws Exception {
		return forgetByAllInternal(userContext, originalVoucherCreationId, originalVoucherCreationVersion);
	}
	protected OriginalVoucherCreation forgetByAllInternal(YoubenbenUserContext userContext,
			String originalVoucherCreationId, int originalVoucherCreationVersion) throws Exception{

		return originalVoucherCreationDaoOf(userContext).disconnectFromAll(originalVoucherCreationId, originalVoucherCreationVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherCreationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return originalVoucherCreationDaoOf(userContext).deleteAll();
	}


	//disconnect OriginalVoucherCreation with belongs_to in OriginalVoucher
	protected OriginalVoucherCreation breakWithOriginalVoucherByBelongsTo(YoubenbenUserContext userContext, String originalVoucherCreationId, String belongsToId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());

			synchronized(originalVoucherCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				originalVoucherCreationDaoOf(userContext).planToRemoveOriginalVoucherListWithBelongsTo(originalVoucherCreation, belongsToId, this.emptyOptions());

				originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
				return originalVoucherCreation;
			}
	}
	//disconnect OriginalVoucherCreation with confirmation in OriginalVoucher
	protected OriginalVoucherCreation breakWithOriginalVoucherByConfirmation(YoubenbenUserContext userContext, String originalVoucherCreationId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());

			synchronized(originalVoucherCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				originalVoucherCreationDaoOf(userContext).planToRemoveOriginalVoucherListWithConfirmation(originalVoucherCreation, confirmationId, this.emptyOptions());

				originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
				return originalVoucherCreation;
			}
	}
	//disconnect OriginalVoucherCreation with auditing in OriginalVoucher
	protected OriginalVoucherCreation breakWithOriginalVoucherByAuditing(YoubenbenUserContext userContext, String originalVoucherCreationId, String auditingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());

			synchronized(originalVoucherCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				originalVoucherCreationDaoOf(userContext).planToRemoveOriginalVoucherListWithAuditing(originalVoucherCreation, auditingId, this.emptyOptions());

				originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
				return originalVoucherCreation;
			}
	}






	protected void checkParamsForAddingOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherCreationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String confirmationId, String auditingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfOriginalVoucherCreation(originalVoucherCreationId);

		
		checkerOf(userContext).checkTitleOfOriginalVoucher(title);
		
		checkerOf(userContext).checkMadeByOfOriginalVoucher(madeBy);
		
		checkerOf(userContext).checkReceivedByOfOriginalVoucher(receivedBy);
		
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher(voucherType);
		
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher(voucherImage);
		
		checkerOf(userContext).checkBelongsToIdOfOriginalVoucher(belongsToId);
		
		checkerOf(userContext).checkConfirmationIdOfOriginalVoucher(confirmationId);
		
		checkerOf(userContext).checkAuditingIdOfOriginalVoucher(auditingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherCreationManagerException.class);


	}
	public  OriginalVoucherCreation addOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherCreationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String confirmationId, String auditingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingOriginalVoucher(userContext,originalVoucherCreationId,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId, confirmationId, auditingId,tokensExpr);

		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId, confirmationId, auditingId);

		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, emptyOptions());
		synchronized(originalVoucherCreation){
			//Will be good when the originalVoucherCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherCreation.addOriginalVoucher( originalVoucher );
			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, originalVoucher);
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingOriginalVoucherProperties(YoubenbenUserContext userContext, String originalVoucherCreationId,String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOriginalVoucherCreation(originalVoucherCreationId);
		checkerOf(userContext).checkIdOfOriginalVoucher(id);

		checkerOf(userContext).checkTitleOfOriginalVoucher( title);
		checkerOf(userContext).checkMadeByOfOriginalVoucher( madeBy);
		checkerOf(userContext).checkReceivedByOfOriginalVoucher( receivedBy);
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher( voucherType);
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher( voucherImage);

		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherCreationManagerException.class);

	}
	public  OriginalVoucherCreation updateOriginalVoucherProperties(YoubenbenUserContext userContext, String originalVoucherCreationId, String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucherProperties(userContext,originalVoucherCreationId,id,title,madeBy,receivedBy,voucherType,voucherImage,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withOriginalVoucherListList()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "is", id).done();

		OriginalVoucherCreation originalVoucherCreationToUpdate = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, options);

		if(originalVoucherCreationToUpdate.getOriginalVoucherList().isEmpty()){
			throw new OriginalVoucherCreationManagerException("OriginalVoucher is NOT FOUND with id: '"+id+"'");
		}

		OriginalVoucher item = originalVoucherCreationToUpdate.getOriginalVoucherList().first();

		item.updateTitle( title );
		item.updateMadeBy( madeBy );
		item.updateReceivedBy( receivedBy );
		item.updateVoucherType( voucherType );
		item.updateVoucherImage( voucherImage );


		//checkParamsForAddingOriginalVoucher(userContext,originalVoucherCreationId,name, code, used,tokensExpr);
		OriginalVoucherCreation originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreationToUpdate, tokens().withOriginalVoucherList().done());
		synchronized(originalVoucherCreation){
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
		}
	}


	protected OriginalVoucher createOriginalVoucher(YoubenbenUserContext userContext, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String confirmationId, String auditingId) throws Exception{

		OriginalVoucher originalVoucher = new OriginalVoucher();
		
		
		originalVoucher.setTitle(title);		
		originalVoucher.setMadeBy(madeBy);		
		originalVoucher.setReceivedBy(receivedBy);		
		originalVoucher.setVoucherType(voucherType);		
		originalVoucher.setVoucherImage(voucherImage);		
		AccountingDocument  belongsTo = new AccountingDocument();
		belongsTo.setId(belongsToId);		
		originalVoucher.setBelongsTo(belongsTo);		
		OriginalVoucherConfirmation  confirmation = new OriginalVoucherConfirmation();
		confirmation.setId(confirmationId);		
		originalVoucher.setConfirmation(confirmation);		
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

	protected void checkParamsForRemovingOriginalVoucherList(YoubenbenUserContext userContext, String originalVoucherCreationId,
			String originalVoucherIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfOriginalVoucherCreation(originalVoucherCreationId);
		for(String originalVoucherIdItem: originalVoucherIds){
			checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherCreationManagerException.class);

	}
	public  OriginalVoucherCreation removeOriginalVoucherList(YoubenbenUserContext userContext, String originalVoucherCreationId,
			String originalVoucherIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingOriginalVoucherList(userContext, originalVoucherCreationId,  originalVoucherIds, tokensExpr);


			OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());
			synchronized(originalVoucherCreation){
				//Will be good when the originalVoucherCreation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				originalVoucherCreationDaoOf(userContext).planToRemoveOriginalVoucherList(originalVoucherCreation, originalVoucherIds, allTokens());
				originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
				deleteRelationListInGraph(userContext, originalVoucherCreation.getOriginalVoucherList());
				return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherCreationId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOriginalVoucherCreation( originalVoucherCreationId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherCreationManagerException.class);

	}
	public  OriginalVoucherCreation removeOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherCreationId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingOriginalVoucher(userContext,originalVoucherCreationId, originalVoucherId, originalVoucherVersion,tokensExpr);

		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());
		synchronized(originalVoucherCreation){
			//Will be good when the originalVoucherCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherCreation.removeOriginalVoucher( originalVoucher );
			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
			deleteRelationInGraph(userContext, originalVoucher);
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherCreationId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOriginalVoucherCreation( originalVoucherCreationId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherCreationManagerException.class);

	}
	public  OriginalVoucherCreation copyOriginalVoucherFrom(YoubenbenUserContext userContext, String originalVoucherCreationId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingOriginalVoucher(userContext,originalVoucherCreationId, originalVoucherId, originalVoucherVersion,tokensExpr);

		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());
		synchronized(originalVoucherCreation){
			//Will be good when the originalVoucherCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			originalVoucherCreation.copyOriginalVoucherFrom( originalVoucher );
			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, (OriginalVoucher)originalVoucherCreation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherCreationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfOriginalVoucherCreation(originalVoucherCreationId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherCreationManagerException.class);

	}

	public  OriginalVoucherCreation updateOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherCreationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherCreationId, originalVoucherId, originalVoucherVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withOriginalVoucherList().searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "eq", originalVoucherId).done();



		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, loadTokens);

		synchronized(originalVoucherCreation){
			//Will be good when the originalVoucherCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//originalVoucherCreation.removeOriginalVoucher( originalVoucher );
			//make changes to AcceleraterAccount.
			OriginalVoucher originalVoucherIndex = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);

			OriginalVoucher originalVoucher = originalVoucherCreation.findTheOriginalVoucher(originalVoucherIndex);
			if(originalVoucher == null){
				throw new OriginalVoucherCreationManagerException(originalVoucher+" is NOT FOUND" );
			}

			originalVoucher.changeProperty(property, newValueExpr);
			
			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, OriginalVoucherCreation newCreated) throws Exception{
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
		//   OriginalVoucherCreation newOriginalVoucherCreation = this.createOriginalVoucherCreation(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newOriginalVoucherCreation
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, OriginalVoucherCreation.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<OriginalVoucherCreation> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String originalVoucherCreationId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getOriginalVoucherCreationDetailScope().clone();
		OriginalVoucherCreation merchantObj = (OriginalVoucherCreation) this.view(userContext, originalVoucherCreationId);
    String merchantObjId = originalVoucherCreationId;
    String linkToUrl =	"originalVoucherCreationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "原始凭证制作"+"详情";
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
		    "originalVoucherManager/listByCreation/"+merchantObjId+"/",
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


