
package com.youbenben.youbenben.originalvoucher;

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


import com.youbenben.youbenben.originalvouchercreation.OriginalVoucherCreation;
import com.youbenben.youbenben.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.youbenben.youbenben.originalvoucherauditing.OriginalVoucherAuditing;
import com.youbenben.youbenben.accountingdocument.AccountingDocument;

import com.youbenben.youbenben.originalvouchercreation.CandidateOriginalVoucherCreation;
import com.youbenben.youbenben.originalvoucherconfirmation.CandidateOriginalVoucherConfirmation;
import com.youbenben.youbenben.originalvoucherauditing.CandidateOriginalVoucherAuditing;
import com.youbenben.youbenben.accountingdocument.CandidateAccountingDocument;







public class OriginalVoucherManagerImpl extends CustomYoubenbenCheckerManager implements OriginalVoucherManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "OriginalVoucher";
	@Override
	public OriginalVoucherDAO daoOf(YoubenbenUserContext userContext) {
		return originalVoucherDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws OriginalVoucherManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new OriginalVoucherManagerException(message);

	}



 	protected OriginalVoucher saveOriginalVoucher(YoubenbenUserContext userContext, OriginalVoucher originalVoucher, String [] tokensExpr) throws Exception{	
 		//return getOriginalVoucherDAO().save(originalVoucher, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOriginalVoucher(userContext, originalVoucher, tokens);
 	}
 	
 	protected OriginalVoucher saveOriginalVoucherDetail(YoubenbenUserContext userContext, OriginalVoucher originalVoucher) throws Exception{	

 		
 		return saveOriginalVoucher(userContext, originalVoucher, allTokens());
 	}
 	
 	public OriginalVoucher loadOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucher, tokens);
 	}
 	
 	
 	 public OriginalVoucher searchOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucher, tokens);
 	}
 	
 	

 	protected OriginalVoucher present(YoubenbenUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,originalVoucher,tokens);
		
		
		OriginalVoucher  originalVoucherToPresent = originalVoucherDaoOf(userContext).present(originalVoucher, tokens);
		
		List<BaseEntity> entityListToNaming = originalVoucherToPresent.collectRefercencesFromLists();
		originalVoucherDaoOf(userContext).alias(entityListToNaming);
		
		return  originalVoucherToPresent;
		
		
	}
 
 	
 	
 	public OriginalVoucher loadOriginalVoucherDetail(YoubenbenUserContext userContext, String originalVoucherId) throws Exception{	
 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, allTokens());
 		return present(userContext,originalVoucher, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String originalVoucherId) throws Exception{	
 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, viewTokens());
 		return present(userContext,originalVoucher, allTokens());
		
 	}
 	protected OriginalVoucher saveOriginalVoucher(YoubenbenUserContext userContext, OriginalVoucher originalVoucher, Map<String,Object>tokens) throws Exception{	
 		return originalVoucherDaoOf(userContext).save(originalVoucher, tokens);
 	}
 	protected OriginalVoucher loadOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherManagerException.class);

 
 		return originalVoucherDaoOf(userContext).load(originalVoucherId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucher, tokens);
		
		addAction(userContext, originalVoucher, tokens,"@create","createOriginalVoucher","createOriginalVoucher/","main","primary");
		addAction(userContext, originalVoucher, tokens,"@update","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucher.getId()+"/","main","primary");
		addAction(userContext, originalVoucher, tokens,"@copy","cloneOriginalVoucher","cloneOriginalVoucher/"+originalVoucher.getId()+"/","main","primary");
		
		addAction(userContext, originalVoucher, tokens,"original_voucher.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+originalVoucher.getId()+"/","main","primary");
		addAction(userContext, originalVoucher, tokens,"original_voucher.transfer_to_creation","transferToAnotherCreation","transferToAnotherCreation/"+originalVoucher.getId()+"/","main","primary");
		addAction(userContext, originalVoucher, tokens,"original_voucher.transfer_to_confirmation","transferToAnotherConfirmation","transferToAnotherConfirmation/"+originalVoucher.getId()+"/","main","primary");
		addAction(userContext, originalVoucher, tokens,"original_voucher.transfer_to_auditing","transferToAnotherAuditing","transferToAnotherAuditing/"+originalVoucher.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public OriginalVoucher createOriginalVoucher(YoubenbenUserContext userContext, String title,String madeBy,String receivedBy,String voucherType,String voucherImage,String belongsToId,String creationId,String confirmationId,String auditingId) throws Exception
	//public OriginalVoucher createOriginalVoucher(YoubenbenUserContext userContext,String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String confirmationId, String auditingId) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfOriginalVoucher(title);
		checkerOf(userContext).checkMadeByOfOriginalVoucher(madeBy);
		checkerOf(userContext).checkReceivedByOfOriginalVoucher(receivedBy);
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher(voucherType);
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher(voucherImage);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherManagerException.class);


		OriginalVoucher originalVoucher=createNewOriginalVoucher();	

		originalVoucher.setTitle(title);
		originalVoucher.setMadeBy(madeBy);
		originalVoucher.setReceivedBy(receivedBy);
		originalVoucher.setVoucherType(voucherType);
		originalVoucher.setVoucherImage(voucherImage);
			
		AccountingDocument belongsTo = loadAccountingDocument(userContext, belongsToId,emptyOptions());
		originalVoucher.setBelongsTo(belongsTo);
		
		
			
		OriginalVoucherCreation creation = loadOriginalVoucherCreation(userContext, creationId,emptyOptions());
		originalVoucher.setCreation(creation);
		
		
			
		OriginalVoucherConfirmation confirmation = loadOriginalVoucherConfirmation(userContext, confirmationId,emptyOptions());
		originalVoucher.setConfirmation(confirmation);
		
		
			
		OriginalVoucherAuditing auditing = loadOriginalVoucherAuditing(userContext, auditingId,emptyOptions());
		originalVoucher.setAuditing(auditing);
		
		

		originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
		
		onNewInstanceCreated(userContext, originalVoucher);
		return originalVoucher;


	}
	protected OriginalVoucher createNewOriginalVoucher()
	{

		return new OriginalVoucher();
	}

	protected void checkParamsForUpdatingOriginalVoucher(YoubenbenUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher( originalVoucherVersion);
		

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

				

				

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherManagerException.class);


	}



	public OriginalVoucher clone(YoubenbenUserContext userContext, String fromOriginalVoucherId) throws Exception{

		return originalVoucherDaoOf(userContext).clone(fromOriginalVoucherId, this.allTokens());
	}

	public OriginalVoucher internalSaveOriginalVoucher(YoubenbenUserContext userContext, OriginalVoucher originalVoucher) throws Exception
	{
		return internalSaveOriginalVoucher(userContext, originalVoucher, allTokens());

	}
	public OriginalVoucher internalSaveOriginalVoucher(YoubenbenUserContext userContext, OriginalVoucher originalVoucher, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherId, originalVoucherVersion, property, newValueExpr, tokensExpr);


		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucher.
			if (originalVoucher.isChanged()){
			
			}
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, options);
			return originalVoucher;

		}

	}

	public OriginalVoucher updateOriginalVoucher(YoubenbenUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherId, originalVoucherVersion, property, newValueExpr, tokensExpr);



		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());
		if(originalVoucher.getVersion() != originalVoucherVersion){
			String message = "The target version("+originalVoucher.getVersion()+") is not equals to version("+originalVoucherVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucher.
			
			originalVoucher.changeProperty(property, newValueExpr);
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().done());
			return present(userContext,originalVoucher, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucher(userContext, originalVoucher, tokens().done());
		}

	}

	public OriginalVoucher updateOriginalVoucherProperty(YoubenbenUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherId, originalVoucherVersion, property, newValueExpr, tokensExpr);

		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());
		if(originalVoucher.getVersion() != originalVoucherVersion){
			String message = "The target version("+originalVoucher.getVersion()+") is not equals to version("+originalVoucherVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucher.

			originalVoucher.changeProperty(property, newValueExpr);
			
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().done());
			return present(userContext,originalVoucher, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucher(userContext, originalVoucher, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected OriginalVoucherTokens tokens(){
		return OriginalVoucherTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OriginalVoucherTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(YoubenbenUserContext userContext, String originalVoucherId, String anotherBelongsToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
 		checkerOf(userContext).checkIdOfAccountingDocument(anotherBelongsToId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherManagerException.class);

 	}
 	public OriginalVoucher transferToAnotherBelongsTo(YoubenbenUserContext userContext, String originalVoucherId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, originalVoucherId,anotherBelongsToId);
 
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocument belongsTo = loadAccountingDocument(userContext, anotherBelongsToId, emptyOptions());		
			originalVoucher.updateBelongsTo(belongsTo);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}

	


	public CandidateAccountingDocument requestCandidateBelongsTo(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocument result = new CandidateAccountingDocument();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocument> candidateList = accountingDocumentDaoOf(userContext).requestCandidateAccountingDocumentForOriginalVoucher(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherCreation(YoubenbenUserContext userContext, String originalVoucherId, String anotherCreationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
 		checkerOf(userContext).checkIdOfOriginalVoucherCreation(anotherCreationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherManagerException.class);

 	}
 	public OriginalVoucher transferToAnotherCreation(YoubenbenUserContext userContext, String originalVoucherId, String anotherCreationId) throws Exception
 	{
 		checkParamsForTransferingAnotherCreation(userContext, originalVoucherId,anotherCreationId);
 
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			OriginalVoucherCreation creation = loadOriginalVoucherCreation(userContext, anotherCreationId, emptyOptions());		
			originalVoucher.updateCreation(creation);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}

	


	public CandidateOriginalVoucherCreation requestCandidateCreation(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateOriginalVoucherCreation result = new CandidateOriginalVoucherCreation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<OriginalVoucherCreation> candidateList = originalVoucherCreationDaoOf(userContext).requestCandidateOriginalVoucherCreationForOriginalVoucher(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherConfirmation(YoubenbenUserContext userContext, String originalVoucherId, String anotherConfirmationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
 		checkerOf(userContext).checkIdOfOriginalVoucherConfirmation(anotherConfirmationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherManagerException.class);

 	}
 	public OriginalVoucher transferToAnotherConfirmation(YoubenbenUserContext userContext, String originalVoucherId, String anotherConfirmationId) throws Exception
 	{
 		checkParamsForTransferingAnotherConfirmation(userContext, originalVoucherId,anotherConfirmationId);
 
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			OriginalVoucherConfirmation confirmation = loadOriginalVoucherConfirmation(userContext, anotherConfirmationId, emptyOptions());		
			originalVoucher.updateConfirmation(confirmation);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}

	


	public CandidateOriginalVoucherConfirmation requestCandidateConfirmation(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateOriginalVoucherConfirmation result = new CandidateOriginalVoucherConfirmation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<OriginalVoucherConfirmation> candidateList = originalVoucherConfirmationDaoOf(userContext).requestCandidateOriginalVoucherConfirmationForOriginalVoucher(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherAuditing(YoubenbenUserContext userContext, String originalVoucherId, String anotherAuditingId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
 		checkerOf(userContext).checkIdOfOriginalVoucherAuditing(anotherAuditingId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherManagerException.class);

 	}
 	public OriginalVoucher transferToAnotherAuditing(YoubenbenUserContext userContext, String originalVoucherId, String anotherAuditingId) throws Exception
 	{
 		checkParamsForTransferingAnotherAuditing(userContext, originalVoucherId,anotherAuditingId);
 
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			OriginalVoucherAuditing auditing = loadOriginalVoucherAuditing(userContext, anotherAuditingId, emptyOptions());		
			originalVoucher.updateAuditing(auditing);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}

	


	public CandidateOriginalVoucherAuditing requestCandidateAuditing(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateOriginalVoucherAuditing result = new CandidateOriginalVoucherAuditing();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<OriginalVoucherAuditing> candidateList = originalVoucherAuditingDaoOf(userContext).requestCandidateOriginalVoucherAuditingForOriginalVoucher(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected OriginalVoucherCreation loadOriginalVoucherCreation(YoubenbenUserContext userContext, String newCreationId, Map<String,Object> options) throws Exception
 	{

 		return originalVoucherCreationDaoOf(userContext).load(newCreationId, options);
 	}
 	


	

 	protected AccountingDocument loadAccountingDocument(YoubenbenUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{

 		return accountingDocumentDaoOf(userContext).load(newBelongsToId, options);
 	}
 	


	

 	protected OriginalVoucherConfirmation loadOriginalVoucherConfirmation(YoubenbenUserContext userContext, String newConfirmationId, Map<String,Object> options) throws Exception
 	{

 		return originalVoucherConfirmationDaoOf(userContext).load(newConfirmationId, options);
 	}
 	


	

 	protected OriginalVoucherAuditing loadOriginalVoucherAuditing(YoubenbenUserContext userContext, String newAuditingId, Map<String,Object> options) throws Exception
 	{

 		return originalVoucherAuditingDaoOf(userContext).load(newAuditingId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String originalVoucherId, int originalVoucherVersion) throws Exception {
		//deleteInternal(userContext, originalVoucherId, originalVoucherVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String originalVoucherId, int originalVoucherVersion) throws Exception{

		originalVoucherDaoOf(userContext).delete(originalVoucherId, originalVoucherVersion);
	}

	public OriginalVoucher forgetByAll(YoubenbenUserContext userContext, String originalVoucherId, int originalVoucherVersion) throws Exception {
		return forgetByAllInternal(userContext, originalVoucherId, originalVoucherVersion);
	}
	protected OriginalVoucher forgetByAllInternal(YoubenbenUserContext userContext,
			String originalVoucherId, int originalVoucherVersion) throws Exception{

		return originalVoucherDaoOf(userContext).disconnectFromAll(originalVoucherId, originalVoucherVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return originalVoucherDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(YoubenbenUserContext userContext, OriginalVoucher newCreated) throws Exception{
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
		//   OriginalVoucher newOriginalVoucher = this.createOriginalVoucher(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newOriginalVoucher
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, OriginalVoucher.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<OriginalVoucher> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<AccountingDocument> belongsToList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingDocument.class);
		userContext.getDAOGroup().enhanceList(belongsToList, AccountingDocument.class);
		List<OriginalVoucherCreation> creationList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, OriginalVoucherCreation.class);
		userContext.getDAOGroup().enhanceList(creationList, OriginalVoucherCreation.class);
		List<OriginalVoucherConfirmation> confirmationList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, OriginalVoucherConfirmation.class);
		userContext.getDAOGroup().enhanceList(confirmationList, OriginalVoucherConfirmation.class);
		List<OriginalVoucherAuditing> auditingList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, OriginalVoucherAuditing.class);
		userContext.getDAOGroup().enhanceList(auditingList, OriginalVoucherAuditing.class);


    }
	
	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception {
		return listPageByBelongsTo(userContext, belongsToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception {
		SmartList<OriginalVoucher> list = originalVoucherDaoOf(userContext).findOriginalVoucherByBelongsTo(belongsToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(OriginalVoucher.class);
		page.setContainerObject(AccountingDocument.withId(belongsToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("原始凭证列表");
		page.setRequestName("listByBelongsTo");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBelongsTo/%s/",  getBeanName(), belongsToId)));

		page.assemblerContent(userContext, "listByBelongsTo");
		return page.doRender(userContext);
	}
  
	public Object listByCreation(YoubenbenUserContext userContext,String creationId) throws Exception {
		return listPageByCreation(userContext, creationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCreation(YoubenbenUserContext userContext,String creationId, int start, int count) throws Exception {
		SmartList<OriginalVoucher> list = originalVoucherDaoOf(userContext).findOriginalVoucherByCreation(creationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(OriginalVoucher.class);
		page.setContainerObject(OriginalVoucherCreation.withId(creationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("原始凭证列表");
		page.setRequestName("listByCreation");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCreation/%s/",  getBeanName(), creationId)));

		page.assemblerContent(userContext, "listByCreation");
		return page.doRender(userContext);
	}
  
	public Object listByConfirmation(YoubenbenUserContext userContext,String confirmationId) throws Exception {
		return listPageByConfirmation(userContext, confirmationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByConfirmation(YoubenbenUserContext userContext,String confirmationId, int start, int count) throws Exception {
		SmartList<OriginalVoucher> list = originalVoucherDaoOf(userContext).findOriginalVoucherByConfirmation(confirmationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(OriginalVoucher.class);
		page.setContainerObject(OriginalVoucherConfirmation.withId(confirmationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("原始凭证列表");
		page.setRequestName("listByConfirmation");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByConfirmation/%s/",  getBeanName(), confirmationId)));

		page.assemblerContent(userContext, "listByConfirmation");
		return page.doRender(userContext);
	}
  
	public Object listByAuditing(YoubenbenUserContext userContext,String auditingId) throws Exception {
		return listPageByAuditing(userContext, auditingId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByAuditing(YoubenbenUserContext userContext,String auditingId, int start, int count) throws Exception {
		SmartList<OriginalVoucher> list = originalVoucherDaoOf(userContext).findOriginalVoucherByAuditing(auditingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(OriginalVoucher.class);
		page.setContainerObject(OriginalVoucherAuditing.withId(auditingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("原始凭证列表");
		page.setRequestName("listByAuditing");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByAuditing/%s/",  getBeanName(), auditingId)));

		page.assemblerContent(userContext, "listByAuditing");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String originalVoucherId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getOriginalVoucherDetailScope().clone();
		OriginalVoucher merchantObj = (OriginalVoucher) this.view(userContext, originalVoucherId);
    String merchantObjId = originalVoucherId;
    String linkToUrl =	"originalVoucherManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "原始凭证"+"详情";
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
				MapUtil.put("id", "2-title")
				    .put("fieldName", "title")
				    .put("label", "标题")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("title", merchantObj.getTitle());

		propList.add(
				MapUtil.put("id", "3-madeBy")
				    .put("fieldName", "madeBy")
				    .put("label", "由")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("madeBy", merchantObj.getMadeBy());

		propList.add(
				MapUtil.put("id", "4-receivedBy")
				    .put("fieldName", "receivedBy")
				    .put("label", "受")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("receivedBy", merchantObj.getReceivedBy());

		propList.add(
				MapUtil.put("id", "5-voucherType")
				    .put("fieldName", "voucherType")
				    .put("label", "凭证类型")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("voucherType", merchantObj.getVoucherType());

		propList.add(
				MapUtil.put("id", "6-voucherImage")
				    .put("fieldName", "voucherImage")
				    .put("label", "凭证图像")
				    .put("type", "image")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("voucherImage", merchantObj.getVoucherImage());

		propList.add(
				MapUtil.put("id", "7-belongsTo")
				    .put("fieldName", "belongsTo")
				    .put("label", "属于")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingDocumentManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"accounting_document_date\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("belongsTo", merchantObj.getBelongsTo());

		propList.add(
				MapUtil.put("id", "8-creation")
				    .put("fieldName", "creation")
				    .put("label", "创建")
				    .put("type", "auto")
				    .put("linkToUrl", "originalVoucherCreationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"comments\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("creation", merchantObj.getCreation());

		propList.add(
				MapUtil.put("id", "9-confirmation")
				    .put("fieldName", "confirmation")
				    .put("label", "确认")
				    .put("type", "auto")
				    .put("linkToUrl", "originalVoucherConfirmationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"comments\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("confirmation", merchantObj.getConfirmation());

		propList.add(
				MapUtil.put("id", "10-auditing")
				    .put("fieldName", "auditing")
				    .put("label", "审计")
				    .put("type", "auto")
				    .put("linkToUrl", "originalVoucherAuditingManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"comments\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("auditing", merchantObj.getAuditing());

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


