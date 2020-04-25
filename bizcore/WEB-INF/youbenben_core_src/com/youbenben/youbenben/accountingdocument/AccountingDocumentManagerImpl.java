
package com.youbenben.youbenben.accountingdocument;

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


import com.youbenben.youbenben.accountingdocumentposting.AccountingDocumentPosting;
import com.youbenben.youbenben.accountingdocumenttype.AccountingDocumentType;
import com.youbenben.youbenben.originalvoucher.OriginalVoucher;
import com.youbenben.youbenben.accountingdocumentauditing.AccountingDocumentAuditing;
import com.youbenben.youbenben.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.youbenben.youbenben.accountingdocumentcreation.AccountingDocumentCreation;
import com.youbenben.youbenben.accountingperiod.AccountingPeriod;
import com.youbenben.youbenben.accountingdocumentline.AccountingDocumentLine;

import com.youbenben.youbenben.accountingdocumentposting.CandidateAccountingDocumentPosting;
import com.youbenben.youbenben.accountingdocumenttype.CandidateAccountingDocumentType;
import com.youbenben.youbenben.accountingdocumentauditing.CandidateAccountingDocumentAuditing;
import com.youbenben.youbenben.accountingdocumentconfirmation.CandidateAccountingDocumentConfirmation;
import com.youbenben.youbenben.accountingdocumentcreation.CandidateAccountingDocumentCreation;
import com.youbenben.youbenben.accountingperiod.CandidateAccountingPeriod;

import com.youbenben.youbenben.originalvouchercreation.OriginalVoucherCreation;
import com.youbenben.youbenben.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.youbenben.youbenben.originalvoucherauditing.OriginalVoucherAuditing;
import com.youbenben.youbenben.accountingdocument.AccountingDocument;
import com.youbenben.youbenben.accountingsubject.AccountingSubject;






public class AccountingDocumentManagerImpl extends CustomYoubenbenCheckerManager implements AccountingDocumentManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = AccountingDocumentTokens.start().withTokenFromListName(listName).done();
		AccountingDocument  accountingDocument = (AccountingDocument) this.loadAccountingDocument(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = accountingDocument.collectRefercencesFromLists();
		accountingDocumentDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, accountingDocument, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new AccountingDocumentGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "AccountingDocument";
	@Override
	public AccountingDocumentDAO daoOf(YoubenbenUserContext userContext) {
		return accountingDocumentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws AccountingDocumentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentManagerException(message);

	}



 	protected AccountingDocument saveAccountingDocument(YoubenbenUserContext userContext, AccountingDocument accountingDocument, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentDAO().save(accountingDocument, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocument(userContext, accountingDocument, tokens);
 	}
 	
 	protected AccountingDocument saveAccountingDocumentDetail(YoubenbenUserContext userContext, AccountingDocument accountingDocument) throws Exception{	

 		
 		return saveAccountingDocument(userContext, accountingDocument, allTokens());
 	}
 	
 	public AccountingDocument loadAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocument, tokens);
 	}
 	
 	
 	 public AccountingDocument searchAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocument, tokens);
 	}
 	
 	

 	protected AccountingDocument present(YoubenbenUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocument,tokens);
		
		
		AccountingDocument  accountingDocumentToPresent = accountingDocumentDaoOf(userContext).present(accountingDocument, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentToPresent.collectRefercencesFromLists();
		accountingDocumentDaoOf(userContext).alias(entityListToNaming);
		
		return  accountingDocumentToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocument loadAccountingDocumentDetail(YoubenbenUserContext userContext, String accountingDocumentId) throws Exception{	
 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, allTokens());
 		return present(userContext,accountingDocument, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String accountingDocumentId) throws Exception{	
 		AccountingDocument accountingDocument = loadAccountingDocument( userContext, accountingDocumentId, viewTokens());
 		return present(userContext,accountingDocument, allTokens());
		
 	}
 	protected AccountingDocument saveAccountingDocument(YoubenbenUserContext userContext, AccountingDocument accountingDocument, Map<String,Object>tokens) throws Exception{	
 		return accountingDocumentDaoOf(userContext).save(accountingDocument, tokens);
 	}
 	protected AccountingDocument loadAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentManagerException.class);

 
 		return accountingDocumentDaoOf(userContext).load(accountingDocumentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocument, tokens);
		
		addAction(userContext, accountingDocument, tokens,"@create","createAccountingDocument","createAccountingDocument/","main","primary");
		addAction(userContext, accountingDocument, tokens,"@update","updateAccountingDocument","updateAccountingDocument/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"@copy","cloneAccountingDocument","cloneAccountingDocument/"+accountingDocument.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_accounting_period","transferToAnotherAccountingPeriod","transferToAnotherAccountingPeriod/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_document_type","transferToAnotherDocumentType","transferToAnotherDocumentType/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_creation","transferToAnotherCreation","transferToAnotherCreation/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_confirmation","transferToAnotherConfirmation","transferToAnotherConfirmation/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_auditing","transferToAnotherAuditing","transferToAnotherAuditing/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.transfer_to_posting","transferToAnotherPosting","transferToAnotherPosting/"+accountingDocument.getId()+"/","main","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+accountingDocument.getId()+"/","originalVoucherList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.addAccountingDocumentLine","addAccountingDocumentLine","addAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.removeAccountingDocumentLine","removeAccountingDocumentLine","removeAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.updateAccountingDocumentLine","updateAccountingDocumentLine","updateAccountingDocumentLine/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
		addAction(userContext, accountingDocument, tokens,"accounting_document.copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom","copyAccountingDocumentLineFrom/"+accountingDocument.getId()+"/","accountingDocumentLineList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, AccountingDocument accountingDocument, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public AccountingDocument createAccountingDocument(YoubenbenUserContext userContext, String name,Date accountingDocumentDate,String accountingPeriodId,String documentTypeId,String creationId,String confirmationId,String auditingId,String postingId) throws Exception
	//public AccountingDocument createAccountingDocument(YoubenbenUserContext userContext,String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String auditingId, String postingId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfAccountingDocument(name);
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);


		AccountingDocument accountingDocument=createNewAccountingDocument();	

		accountingDocument.setName(name);
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);
			
		AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, accountingPeriodId,emptyOptions());
		accountingDocument.setAccountingPeriod(accountingPeriod);
		
		
			
		AccountingDocumentType documentType = loadAccountingDocumentType(userContext, documentTypeId,emptyOptions());
		accountingDocument.setDocumentType(documentType);
		
		
			
		AccountingDocumentCreation creation = loadAccountingDocumentCreation(userContext, creationId,emptyOptions());
		accountingDocument.setCreation(creation);
		
		
			
		AccountingDocumentConfirmation confirmation = loadAccountingDocumentConfirmation(userContext, confirmationId,emptyOptions());
		accountingDocument.setConfirmation(confirmation);
		
		
			
		AccountingDocumentAuditing auditing = loadAccountingDocumentAuditing(userContext, auditingId,emptyOptions());
		accountingDocument.setAuditing(auditing);
		
		
			
		AccountingDocumentPosting posting = loadAccountingDocumentPosting(userContext, postingId,emptyOptions());
		accountingDocument.setPosting(posting);
		
		

		accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocument);
		return accountingDocument;


	}
	protected AccountingDocument createNewAccountingDocument()
	{

		return new AccountingDocument();
	}

	protected void checkParamsForUpdatingAccountingDocument(YoubenbenUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument( accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocument(parseString(newValueExpr));
		
			
		}
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		
			
		}		

				

				

				

				

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);


	}



	public AccountingDocument clone(YoubenbenUserContext userContext, String fromAccountingDocumentId) throws Exception{

		return accountingDocumentDaoOf(userContext).clone(fromAccountingDocumentId, this.allTokens());
	}

	public AccountingDocument internalSaveAccountingDocument(YoubenbenUserContext userContext, AccountingDocument accountingDocument) throws Exception
	{
		return internalSaveAccountingDocument(userContext, accountingDocument, allTokens());

	}
	public AccountingDocument internalSaveAccountingDocument(YoubenbenUserContext userContext, AccountingDocument accountingDocument, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentId, accountingDocumentVersion, property, newValueExpr, tokensExpr);


		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocument.
			if (accountingDocument.isChanged()){
			
			}
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, options);
			return accountingDocument;

		}

	}

	public AccountingDocument updateAccountingDocument(YoubenbenUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentId, accountingDocumentVersion, property, newValueExpr, tokensExpr);



		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		if(accountingDocument.getVersion() != accountingDocumentVersion){
			String message = "The target version("+accountingDocument.getVersion()+") is not equals to version("+accountingDocumentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocument.
			
			accountingDocument.changeProperty(property, newValueExpr);
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
			//return saveAccountingDocument(userContext, accountingDocument, tokens().done());
		}

	}

	public AccountingDocument updateAccountingDocumentProperty(YoubenbenUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentId, accountingDocumentVersion, property, newValueExpr, tokensExpr);

		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		if(accountingDocument.getVersion() != accountingDocumentVersion){
			String message = "The target version("+accountingDocument.getVersion()+") is not equals to version("+accountingDocumentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocument.

			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
			//return saveAccountingDocument(userContext, accountingDocument, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected AccountingDocumentTokens tokens(){
		return AccountingDocumentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortOriginalVoucherListWith("id","desc")
		.sortAccountingDocumentLineListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherAccountingPeriod(YoubenbenUserContext userContext, String accountingDocumentId, String anotherAccountingPeriodId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
 		checkerOf(userContext).checkIdOfAccountingPeriod(anotherAccountingPeriodId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

 	}
 	public AccountingDocument transferToAnotherAccountingPeriod(YoubenbenUserContext userContext, String accountingDocumentId, String anotherAccountingPeriodId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountingPeriod(userContext, accountingDocumentId,anotherAccountingPeriodId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingPeriod accountingPeriod = loadAccountingPeriod(userContext, anotherAccountingPeriodId, emptyOptions());		
			accountingDocument.updateAccountingPeriod(accountingPeriod);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}

	


	public CandidateAccountingPeriod requestCandidateAccountingPeriod(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingPeriod result = new CandidateAccountingPeriod();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingPeriod> candidateList = accountingPeriodDaoOf(userContext).requestCandidateAccountingPeriodForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherDocumentType(YoubenbenUserContext userContext, String accountingDocumentId, String anotherDocumentTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
 		checkerOf(userContext).checkIdOfAccountingDocumentType(anotherDocumentTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

 	}
 	public AccountingDocument transferToAnotherDocumentType(YoubenbenUserContext userContext, String accountingDocumentId, String anotherDocumentTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherDocumentType(userContext, accountingDocumentId,anotherDocumentTypeId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocumentType documentType = loadAccountingDocumentType(userContext, anotherDocumentTypeId, emptyOptions());		
			accountingDocument.updateDocumentType(documentType);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}

	


	public CandidateAccountingDocumentType requestCandidateDocumentType(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocumentType result = new CandidateAccountingDocumentType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocumentType> candidateList = accountingDocumentTypeDaoOf(userContext).requestCandidateAccountingDocumentTypeForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherCreation(YoubenbenUserContext userContext, String accountingDocumentId, String anotherCreationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
 		checkerOf(userContext).checkIdOfAccountingDocumentCreation(anotherCreationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

 	}
 	public AccountingDocument transferToAnotherCreation(YoubenbenUserContext userContext, String accountingDocumentId, String anotherCreationId) throws Exception
 	{
 		checkParamsForTransferingAnotherCreation(userContext, accountingDocumentId,anotherCreationId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocumentCreation creation = loadAccountingDocumentCreation(userContext, anotherCreationId, emptyOptions());		
			accountingDocument.updateCreation(creation);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}

	


	public CandidateAccountingDocumentCreation requestCandidateCreation(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocumentCreation result = new CandidateAccountingDocumentCreation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocumentCreation> candidateList = accountingDocumentCreationDaoOf(userContext).requestCandidateAccountingDocumentCreationForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherConfirmation(YoubenbenUserContext userContext, String accountingDocumentId, String anotherConfirmationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
 		checkerOf(userContext).checkIdOfAccountingDocumentConfirmation(anotherConfirmationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

 	}
 	public AccountingDocument transferToAnotherConfirmation(YoubenbenUserContext userContext, String accountingDocumentId, String anotherConfirmationId) throws Exception
 	{
 		checkParamsForTransferingAnotherConfirmation(userContext, accountingDocumentId,anotherConfirmationId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocumentConfirmation confirmation = loadAccountingDocumentConfirmation(userContext, anotherConfirmationId, emptyOptions());		
			accountingDocument.updateConfirmation(confirmation);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}

	


	public CandidateAccountingDocumentConfirmation requestCandidateConfirmation(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocumentConfirmation result = new CandidateAccountingDocumentConfirmation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocumentConfirmation> candidateList = accountingDocumentConfirmationDaoOf(userContext).requestCandidateAccountingDocumentConfirmationForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherAuditing(YoubenbenUserContext userContext, String accountingDocumentId, String anotherAuditingId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
 		checkerOf(userContext).checkIdOfAccountingDocumentAuditing(anotherAuditingId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

 	}
 	public AccountingDocument transferToAnotherAuditing(YoubenbenUserContext userContext, String accountingDocumentId, String anotherAuditingId) throws Exception
 	{
 		checkParamsForTransferingAnotherAuditing(userContext, accountingDocumentId,anotherAuditingId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocumentAuditing auditing = loadAccountingDocumentAuditing(userContext, anotherAuditingId, emptyOptions());		
			accountingDocument.updateAuditing(auditing);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}

	


	public CandidateAccountingDocumentAuditing requestCandidateAuditing(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocumentAuditing result = new CandidateAccountingDocumentAuditing();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocumentAuditing> candidateList = accountingDocumentAuditingDaoOf(userContext).requestCandidateAccountingDocumentAuditingForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherPosting(YoubenbenUserContext userContext, String accountingDocumentId, String anotherPostingId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
 		checkerOf(userContext).checkIdOfAccountingDocumentPosting(anotherPostingId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

 	}
 	public AccountingDocument transferToAnotherPosting(YoubenbenUserContext userContext, String accountingDocumentId, String anotherPostingId) throws Exception
 	{
 		checkParamsForTransferingAnotherPosting(userContext, accountingDocumentId,anotherPostingId);
 
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());	
		synchronized(accountingDocument){
			//will be good when the accountingDocument loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocumentPosting posting = loadAccountingDocumentPosting(userContext, anotherPostingId, emptyOptions());		
			accountingDocument.updatePosting(posting);		
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, emptyOptions());
			
			return present(userContext,accountingDocument, allTokens());
			
		}

 	}

	


	public CandidateAccountingDocumentPosting requestCandidatePosting(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocumentPosting result = new CandidateAccountingDocumentPosting();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocumentPosting> candidateList = accountingDocumentPostingDaoOf(userContext).requestCandidateAccountingDocumentPostingForAccountingDocument(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected AccountingDocumentPosting loadAccountingDocumentPosting(YoubenbenUserContext userContext, String newPostingId, Map<String,Object> options) throws Exception
 	{

 		return accountingDocumentPostingDaoOf(userContext).load(newPostingId, options);
 	}
 	


	

 	protected AccountingDocumentConfirmation loadAccountingDocumentConfirmation(YoubenbenUserContext userContext, String newConfirmationId, Map<String,Object> options) throws Exception
 	{

 		return accountingDocumentConfirmationDaoOf(userContext).load(newConfirmationId, options);
 	}
 	


	

 	protected AccountingDocumentAuditing loadAccountingDocumentAuditing(YoubenbenUserContext userContext, String newAuditingId, Map<String,Object> options) throws Exception
 	{

 		return accountingDocumentAuditingDaoOf(userContext).load(newAuditingId, options);
 	}
 	


	

 	protected AccountingPeriod loadAccountingPeriod(YoubenbenUserContext userContext, String newAccountingPeriodId, Map<String,Object> options) throws Exception
 	{

 		return accountingPeriodDaoOf(userContext).load(newAccountingPeriodId, options);
 	}
 	


	

 	protected AccountingDocumentType loadAccountingDocumentType(YoubenbenUserContext userContext, String newDocumentTypeId, Map<String,Object> options) throws Exception
 	{

 		return accountingDocumentTypeDaoOf(userContext).load(newDocumentTypeId, options);
 	}
 	


	

 	protected AccountingDocumentCreation loadAccountingDocumentCreation(YoubenbenUserContext userContext, String newCreationId, Map<String,Object> options) throws Exception
 	{

 		return accountingDocumentCreationDaoOf(userContext).load(newCreationId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String accountingDocumentId, int accountingDocumentVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentId, accountingDocumentVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String accountingDocumentId, int accountingDocumentVersion) throws Exception{

		accountingDocumentDaoOf(userContext).delete(accountingDocumentId, accountingDocumentVersion);
	}

	public AccountingDocument forgetByAll(YoubenbenUserContext userContext, String accountingDocumentId, int accountingDocumentVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentId, accountingDocumentVersion);
	}
	protected AccountingDocument forgetByAllInternal(YoubenbenUserContext userContext,
			String accountingDocumentId, int accountingDocumentVersion) throws Exception{

		return accountingDocumentDaoOf(userContext).disconnectFromAll(accountingDocumentId, accountingDocumentVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return accountingDocumentDaoOf(userContext).deleteAll();
	}


	//disconnect AccountingDocument with creation in OriginalVoucher
	protected AccountingDocument breakWithOriginalVoucherByCreation(YoubenbenUserContext userContext, String accountingDocumentId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());

			synchronized(accountingDocument){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentDaoOf(userContext).planToRemoveOriginalVoucherListWithCreation(accountingDocument, creationId, this.emptyOptions());

				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
				return accountingDocument;
			}
	}
	//disconnect AccountingDocument with confirmation in OriginalVoucher
	protected AccountingDocument breakWithOriginalVoucherByConfirmation(YoubenbenUserContext userContext, String accountingDocumentId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());

			synchronized(accountingDocument){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentDaoOf(userContext).planToRemoveOriginalVoucherListWithConfirmation(accountingDocument, confirmationId, this.emptyOptions());

				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
				return accountingDocument;
			}
	}
	//disconnect AccountingDocument with auditing in OriginalVoucher
	protected AccountingDocument breakWithOriginalVoucherByAuditing(YoubenbenUserContext userContext, String accountingDocumentId, String auditingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());

			synchronized(accountingDocument){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentDaoOf(userContext).planToRemoveOriginalVoucherListWithAuditing(accountingDocument, auditingId, this.emptyOptions());

				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
				return accountingDocument;
			}
	}
	//disconnect AccountingDocument with accounting_subject in AccountingDocumentLine
	protected AccountingDocument breakWithAccountingDocumentLineByAccountingSubject(YoubenbenUserContext userContext, String accountingDocumentId, String accountingSubjectId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());

			synchronized(accountingDocument){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentDaoOf(userContext).planToRemoveAccountingDocumentLineListWithAccountingSubject(accountingDocument, accountingSubjectId, this.emptyOptions());

				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
				return accountingDocument;
			}
	}






	protected void checkParamsForAddingOriginalVoucher(YoubenbenUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String creationId, String confirmationId, String auditingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);

		
		checkerOf(userContext).checkTitleOfOriginalVoucher(title);
		
		checkerOf(userContext).checkMadeByOfOriginalVoucher(madeBy);
		
		checkerOf(userContext).checkReceivedByOfOriginalVoucher(receivedBy);
		
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher(voucherType);
		
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher(voucherImage);
		
		checkerOf(userContext).checkCreationIdOfOriginalVoucher(creationId);
		
		checkerOf(userContext).checkConfirmationIdOfOriginalVoucher(confirmationId);
		
		checkerOf(userContext).checkAuditingIdOfOriginalVoucher(auditingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);


	}
	public  AccountingDocument addOriginalVoucher(YoubenbenUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String creationId, String confirmationId, String auditingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingOriginalVoucher(userContext,accountingDocumentId,title, madeBy, receivedBy, voucherType, voucherImage, creationId, confirmationId, auditingId,tokensExpr);

		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage, creationId, confirmationId, auditingId);

		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, emptyOptions());
		synchronized(accountingDocument){
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.addOriginalVoucher( originalVoucher );
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, originalVoucher);
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingOriginalVoucherProperties(YoubenbenUserContext userContext, String accountingDocumentId,String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkIdOfOriginalVoucher(id);

		checkerOf(userContext).checkTitleOfOriginalVoucher( title);
		checkerOf(userContext).checkMadeByOfOriginalVoucher( madeBy);
		checkerOf(userContext).checkReceivedByOfOriginalVoucher( receivedBy);
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher( voucherType);
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher( voucherImage);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}
	public  AccountingDocument updateOriginalVoucherProperties(YoubenbenUserContext userContext, String accountingDocumentId, String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucherProperties(userContext,accountingDocumentId,id,title,madeBy,receivedBy,voucherType,voucherImage,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withOriginalVoucherListList()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "is", id).done();

		AccountingDocument accountingDocumentToUpdate = loadAccountingDocument(userContext, accountingDocumentId, options);

		if(accountingDocumentToUpdate.getOriginalVoucherList().isEmpty()){
			throw new AccountingDocumentManagerException("OriginalVoucher is NOT FOUND with id: '"+id+"'");
		}

		OriginalVoucher item = accountingDocumentToUpdate.getOriginalVoucherList().first();

		item.updateTitle( title );
		item.updateMadeBy( madeBy );
		item.updateReceivedBy( receivedBy );
		item.updateVoucherType( voucherType );
		item.updateVoucherImage( voucherImage );


		//checkParamsForAddingOriginalVoucher(userContext,accountingDocumentId,name, code, used,tokensExpr);
		AccountingDocument accountingDocument = saveAccountingDocument(userContext, accountingDocumentToUpdate, tokens().withOriginalVoucherList().done());
		synchronized(accountingDocument){
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
	}


	protected OriginalVoucher createOriginalVoucher(YoubenbenUserContext userContext, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String creationId, String confirmationId, String auditingId) throws Exception{

		OriginalVoucher originalVoucher = new OriginalVoucher();
		
		
		originalVoucher.setTitle(title);		
		originalVoucher.setMadeBy(madeBy);		
		originalVoucher.setReceivedBy(receivedBy);		
		originalVoucher.setVoucherType(voucherType);		
		originalVoucher.setVoucherImage(voucherImage);		
		OriginalVoucherCreation  creation = new OriginalVoucherCreation();
		creation.setId(creationId);		
		originalVoucher.setCreation(creation);		
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

	protected void checkParamsForRemovingOriginalVoucherList(YoubenbenUserContext userContext, String accountingDocumentId,
			String originalVoucherIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		for(String originalVoucherIdItem: originalVoucherIds){
			checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}
	public  AccountingDocument removeOriginalVoucherList(YoubenbenUserContext userContext, String accountingDocumentId,
			String originalVoucherIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingOriginalVoucherList(userContext, accountingDocumentId,  originalVoucherIds, tokensExpr);


			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
			synchronized(accountingDocument){
				//Will be good when the accountingDocument loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountingDocumentDaoOf(userContext).planToRemoveOriginalVoucherList(accountingDocument, originalVoucherIds, allTokens());
				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
				deleteRelationListInGraph(userContext, accountingDocument.getOriginalVoucherList());
				return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingOriginalVoucher(YoubenbenUserContext userContext, String accountingDocumentId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocument( accountingDocumentId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}
	public  AccountingDocument removeOriginalVoucher(YoubenbenUserContext userContext, String accountingDocumentId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingOriginalVoucher(userContext,accountingDocumentId, originalVoucherId, originalVoucherVersion,tokensExpr);

		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.removeOriginalVoucher( originalVoucher );
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			deleteRelationInGraph(userContext, originalVoucher);
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingOriginalVoucher(YoubenbenUserContext userContext, String accountingDocumentId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocument( accountingDocumentId);
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher(originalVoucherVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}
	public  AccountingDocument copyOriginalVoucherFrom(YoubenbenUserContext userContext, String accountingDocumentId,
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingOriginalVoucher(userContext,accountingDocumentId, originalVoucherId, originalVoucherVersion,tokensExpr);

		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			accountingDocument.copyOriginalVoucherFrom( originalVoucher );
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, (OriginalVoucher)accountingDocument.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingOriginalVoucher(YoubenbenUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}

	public  AccountingDocument updateOriginalVoucher(YoubenbenUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingOriginalVoucher(userContext, accountingDocumentId, originalVoucherId, originalVoucherVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withOriginalVoucherList().searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "eq", originalVoucherId).done();



		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, loadTokens);

		synchronized(accountingDocument){
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocument.removeOriginalVoucher( originalVoucher );
			//make changes to AcceleraterAccount.
			OriginalVoucher originalVoucherIndex = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);

			OriginalVoucher originalVoucher = accountingDocument.findTheOriginalVoucher(originalVoucherIndex);
			if(originalVoucher == null){
				throw new AccountingDocumentManagerException(originalVoucher+" is NOT FOUND" );
			}

			originalVoucher.changeProperty(property, newValueExpr);
			
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withOriginalVoucherList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingAccountingDocumentLine(YoubenbenUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);

		
		checkerOf(userContext).checkNameOfAccountingDocumentLine(name);
		
		checkerOf(userContext).checkCodeOfAccountingDocumentLine(code);
		
		checkerOf(userContext).checkDirectOfAccountingDocumentLine(direct);
		
		checkerOf(userContext).checkAmountOfAccountingDocumentLine(amount);
		
		checkerOf(userContext).checkAccountingSubjectIdOfAccountingDocumentLine(accountingSubjectId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);


	}
	public  AccountingDocument addAccountingDocumentLine(YoubenbenUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingDocumentLine(userContext,accountingDocumentId,name, code, direct, amount, accountingSubjectId,tokensExpr);

		AccountingDocumentLine accountingDocumentLine = createAccountingDocumentLine(userContext,name, code, direct, amount, accountingSubjectId);

		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, emptyOptions());
		synchronized(accountingDocument){
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.addAccountingDocumentLine( accountingDocumentLine );
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			
			userContext.getManagerGroup().getAccountingDocumentLineManager().onNewInstanceCreated(userContext, accountingDocumentLine);
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentLineProperties(YoubenbenUserContext userContext, String accountingDocumentId,String id,String name,String code,String direct,BigDecimal amount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkIdOfAccountingDocumentLine(id);

		checkerOf(userContext).checkNameOfAccountingDocumentLine( name);
		checkerOf(userContext).checkCodeOfAccountingDocumentLine( code);
		checkerOf(userContext).checkDirectOfAccountingDocumentLine( direct);
		checkerOf(userContext).checkAmountOfAccountingDocumentLine( amount);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}
	public  AccountingDocument updateAccountingDocumentLineProperties(YoubenbenUserContext userContext, String accountingDocumentId, String id,String name,String code,String direct,BigDecimal amount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentLineProperties(userContext,accountingDocumentId,id,name,code,direct,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentLineListList()
				.searchAccountingDocumentLineListWith(AccountingDocumentLine.ID_PROPERTY, "is", id).done();

		AccountingDocument accountingDocumentToUpdate = loadAccountingDocument(userContext, accountingDocumentId, options);

		if(accountingDocumentToUpdate.getAccountingDocumentLineList().isEmpty()){
			throw new AccountingDocumentManagerException("AccountingDocumentLine is NOT FOUND with id: '"+id+"'");
		}

		AccountingDocumentLine item = accountingDocumentToUpdate.getAccountingDocumentLineList().first();

		item.updateName( name );
		item.updateCode( code );
		item.updateDirect( direct );
		item.updateAmount( amount );


		//checkParamsForAddingAccountingDocumentLine(userContext,accountingDocumentId,name, code, used,tokensExpr);
		AccountingDocument accountingDocument = saveAccountingDocument(userContext, accountingDocumentToUpdate, tokens().withAccountingDocumentLineList().done());
		synchronized(accountingDocument){
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountingDocumentLine createAccountingDocumentLine(YoubenbenUserContext userContext, String name, String code, String direct, BigDecimal amount, String accountingSubjectId) throws Exception{

		AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
		
		
		accountingDocumentLine.setName(name);		
		accountingDocumentLine.setCode(code);		
		accountingDocumentLine.setDirect(direct);		
		accountingDocumentLine.setAmount(amount);		
		AccountingSubject  accountingSubject = new AccountingSubject();
		accountingSubject.setId(accountingSubjectId);		
		accountingDocumentLine.setAccountingSubject(accountingSubject);
	
		
		return accountingDocumentLine;


	}

	protected AccountingDocumentLine createIndexedAccountingDocumentLine(String id, int version){

		AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
		accountingDocumentLine.setId(id);
		accountingDocumentLine.setVersion(version);
		return accountingDocumentLine;

	}

	protected void checkParamsForRemovingAccountingDocumentLineList(YoubenbenUserContext userContext, String accountingDocumentId,
			String accountingDocumentLineIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		for(String accountingDocumentLineIdItem: accountingDocumentLineIds){
			checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}
	public  AccountingDocument removeAccountingDocumentLineList(YoubenbenUserContext userContext, String accountingDocumentId,
			String accountingDocumentLineIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingDocumentLineList(userContext, accountingDocumentId,  accountingDocumentLineIds, tokensExpr);


			AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
			synchronized(accountingDocument){
				//Will be good when the accountingDocument loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountingDocumentDaoOf(userContext).planToRemoveAccountingDocumentLineList(accountingDocument, accountingDocumentLineIds, allTokens());
				accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
				deleteRelationListInGraph(userContext, accountingDocument.getAccountingDocumentLineList());
				return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingDocumentLine(YoubenbenUserContext userContext, String accountingDocumentId,
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocument( accountingDocumentId);
		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}
	public  AccountingDocument removeAccountingDocumentLine(YoubenbenUserContext userContext, String accountingDocumentId,
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountingDocumentLine(userContext,accountingDocumentId, accountingDocumentLineId, accountingDocumentLineVersion,tokensExpr);

		AccountingDocumentLine accountingDocumentLine = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocument.removeAccountingDocumentLine( accountingDocumentLine );
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			deleteRelationInGraph(userContext, accountingDocumentLine);
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountingDocumentLine(YoubenbenUserContext userContext, String accountingDocumentId,
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocument( accountingDocumentId);
		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}
	public  AccountingDocument copyAccountingDocumentLineFrom(YoubenbenUserContext userContext, String accountingDocumentId,
		String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountingDocumentLine(userContext,accountingDocumentId, accountingDocumentLineId, accountingDocumentLineVersion,tokensExpr);

		AccountingDocumentLine accountingDocumentLine = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);
		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, allTokens());
		synchronized(accountingDocument){
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			accountingDocument.copyAccountingDocumentLineFrom( accountingDocumentLine );
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			
			userContext.getManagerGroup().getAccountingDocumentLineManager().onNewInstanceCreated(userContext, (AccountingDocumentLine)accountingDocument.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountingDocumentLine(YoubenbenUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).checkVersionOfAccountingDocumentLine(accountingDocumentLineVersion);
		

		if(AccountingDocumentLine.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocumentLine(parseString(newValueExpr));
		
		}
		
		if(AccountingDocumentLine.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfAccountingDocumentLine(parseString(newValueExpr));
		
		}
		
		if(AccountingDocumentLine.DIRECT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDirectOfAccountingDocumentLine(parseString(newValueExpr));
		
		}
		
		if(AccountingDocumentLine.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfAccountingDocumentLine(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentManagerException.class);

	}

	public  AccountingDocument updateAccountingDocumentLine(YoubenbenUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountingDocumentLine(userContext, accountingDocumentId, accountingDocumentLineId, accountingDocumentLineVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentLineList().searchAccountingDocumentLineListWith(AccountingDocumentLine.ID_PROPERTY, "eq", accountingDocumentLineId).done();



		AccountingDocument accountingDocument = loadAccountingDocument(userContext, accountingDocumentId, loadTokens);

		synchronized(accountingDocument){
			//Will be good when the accountingDocument loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocument.removeAccountingDocumentLine( accountingDocumentLine );
			//make changes to AcceleraterAccount.
			AccountingDocumentLine accountingDocumentLineIndex = createIndexedAccountingDocumentLine(accountingDocumentLineId, accountingDocumentLineVersion);

			AccountingDocumentLine accountingDocumentLine = accountingDocument.findTheAccountingDocumentLine(accountingDocumentLineIndex);
			if(accountingDocumentLine == null){
				throw new AccountingDocumentManagerException(accountingDocumentLine+" is NOT FOUND" );
			}

			accountingDocumentLine.changeProperty(property, newValueExpr);
			
			accountingDocument = saveAccountingDocument(userContext, accountingDocument, tokens().withAccountingDocumentLineList().done());
			return present(userContext,accountingDocument, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, AccountingDocument newCreated) throws Exception{
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
		//   AccountingDocument newAccountingDocument = this.createAccountingDocument(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newAccountingDocument
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, AccountingDocument.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<AccountingDocument> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<AccountingPeriod> accountingPeriodList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingPeriod.class);
		userContext.getDAOGroup().enhanceList(accountingPeriodList, AccountingPeriod.class);
		List<AccountingDocumentType> documentTypeList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingDocumentType.class);
		userContext.getDAOGroup().enhanceList(documentTypeList, AccountingDocumentType.class);
		List<AccountingDocumentCreation> creationList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingDocumentCreation.class);
		userContext.getDAOGroup().enhanceList(creationList, AccountingDocumentCreation.class);
		List<AccountingDocumentConfirmation> confirmationList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingDocumentConfirmation.class);
		userContext.getDAOGroup().enhanceList(confirmationList, AccountingDocumentConfirmation.class);
		List<AccountingDocumentAuditing> auditingList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingDocumentAuditing.class);
		userContext.getDAOGroup().enhanceList(auditingList, AccountingDocumentAuditing.class);
		List<AccountingDocumentPosting> postingList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingDocumentPosting.class);
		userContext.getDAOGroup().enhanceList(postingList, AccountingDocumentPosting.class);


    }
	
	public Object listByAccountingPeriod(YoubenbenUserContext userContext,String accountingPeriodId) throws Exception {
		return listPageByAccountingPeriod(userContext, accountingPeriodId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByAccountingPeriod(YoubenbenUserContext userContext,String accountingPeriodId, int start, int count) throws Exception {
		SmartList<AccountingDocument> list = accountingDocumentDaoOf(userContext).findAccountingDocumentByAccountingPeriod(accountingPeriodId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(AccountingDocument.class);
		page.setContainerObject(AccountingPeriod.withId(accountingPeriodId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计凭证列表");
		page.setRequestName("listByAccountingPeriod");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByAccountingPeriod/%s/",  getBeanName(), accountingPeriodId)));

		page.assemblerContent(userContext, "listByAccountingPeriod");
		return page.doRender(userContext);
	}
  
	public Object listByDocumentType(YoubenbenUserContext userContext,String documentTypeId) throws Exception {
		return listPageByDocumentType(userContext, documentTypeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDocumentType(YoubenbenUserContext userContext,String documentTypeId, int start, int count) throws Exception {
		SmartList<AccountingDocument> list = accountingDocumentDaoOf(userContext).findAccountingDocumentByDocumentType(documentTypeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(AccountingDocument.class);
		page.setContainerObject(AccountingDocumentType.withId(documentTypeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计凭证列表");
		page.setRequestName("listByDocumentType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDocumentType/%s/",  getBeanName(), documentTypeId)));

		page.assemblerContent(userContext, "listByDocumentType");
		return page.doRender(userContext);
	}
  
	public Object listByCreation(YoubenbenUserContext userContext,String creationId) throws Exception {
		return listPageByCreation(userContext, creationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCreation(YoubenbenUserContext userContext,String creationId, int start, int count) throws Exception {
		SmartList<AccountingDocument> list = accountingDocumentDaoOf(userContext).findAccountingDocumentByCreation(creationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(AccountingDocument.class);
		page.setContainerObject(AccountingDocumentCreation.withId(creationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计凭证列表");
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
		SmartList<AccountingDocument> list = accountingDocumentDaoOf(userContext).findAccountingDocumentByConfirmation(confirmationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(AccountingDocument.class);
		page.setContainerObject(AccountingDocumentConfirmation.withId(confirmationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计凭证列表");
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
		SmartList<AccountingDocument> list = accountingDocumentDaoOf(userContext).findAccountingDocumentByAuditing(auditingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(AccountingDocument.class);
		page.setContainerObject(AccountingDocumentAuditing.withId(auditingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计凭证列表");
		page.setRequestName("listByAuditing");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByAuditing/%s/",  getBeanName(), auditingId)));

		page.assemblerContent(userContext, "listByAuditing");
		return page.doRender(userContext);
	}
  
	public Object listByPosting(YoubenbenUserContext userContext,String postingId) throws Exception {
		return listPageByPosting(userContext, postingId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPosting(YoubenbenUserContext userContext,String postingId, int start, int count) throws Exception {
		SmartList<AccountingDocument> list = accountingDocumentDaoOf(userContext).findAccountingDocumentByPosting(postingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(AccountingDocument.class);
		page.setContainerObject(AccountingDocumentPosting.withId(postingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计凭证列表");
		page.setRequestName("listByPosting");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByPosting/%s/",  getBeanName(), postingId)));

		page.assemblerContent(userContext, "listByPosting");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String accountingDocumentId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getAccountingDocumentDetailScope().clone();
		AccountingDocument merchantObj = (AccountingDocument) this.view(userContext, accountingDocumentId);
    String merchantObjId = accountingDocumentId;
    String linkToUrl =	"accountingDocumentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会计凭证"+"详情";
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
				MapUtil.put("id", "3-accountingDocumentDate")
				    .put("fieldName", "accountingDocumentDate")
				    .put("label", "会计凭证日期")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("accountingDocumentDate", merchantObj.getAccountingDocumentDate());

		propList.add(
				MapUtil.put("id", "4-accountingPeriod")
				    .put("fieldName", "accountingPeriod")
				    .put("label", "会计期间")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingPeriodManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"start_date\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("accountingPeriod", merchantObj.getAccountingPeriod());

		propList.add(
				MapUtil.put("id", "5-documentType")
				    .put("fieldName", "documentType")
				    .put("label", "文档类型")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingDocumentTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("documentType", merchantObj.getDocumentType());

		propList.add(
				MapUtil.put("id", "6-creation")
				    .put("fieldName", "creation")
				    .put("label", "创建")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingDocumentCreationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"comments\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("creation", merchantObj.getCreation());

		propList.add(
				MapUtil.put("id", "7-confirmation")
				    .put("fieldName", "confirmation")
				    .put("label", "确认")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingDocumentConfirmationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"comments\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("confirmation", merchantObj.getConfirmation());

		propList.add(
				MapUtil.put("id", "8-auditing")
				    .put("fieldName", "auditing")
				    .put("label", "审计")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingDocumentAuditingManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"comments\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("auditing", merchantObj.getAuditing());

		propList.add(
				MapUtil.put("id", "9-posting")
				    .put("fieldName", "posting")
				    .put("label", "过账")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingDocumentPostingManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"comments\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("posting", merchantObj.getPosting());

		//处理 sectionList

		//处理Section：originalVoucherListSection
		Map originalVoucherListSection = ListofUtils.buildSection(
		    "originalVoucherListSection",
		    "原始凭证列表",
		    null,
		    "",
		    "__no_group",
		    "originalVoucherManager/listByBelongsTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(originalVoucherListSection);

		result.put("originalVoucherListSection", ListofUtils.toShortList(merchantObj.getOriginalVoucherList(), "originalVoucher"));
		vscope.field("originalVoucherListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( OriginalVoucher.class.getName(), null));

		//处理Section：accountingDocumentLineListSection
		Map accountingDocumentLineListSection = ListofUtils.buildSection(
		    "accountingDocumentLineListSection",
		    "会计文件行表",
		    null,
		    "",
		    "__no_group",
		    "accountingDocumentLineManager/listByBelongsTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(accountingDocumentLineListSection);

		result.put("accountingDocumentLineListSection", ListofUtils.toShortList(merchantObj.getAccountingDocumentLineList(), "accountingDocumentLine"));
		vscope.field("accountingDocumentLineListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( AccountingDocumentLine.class.getName(), null));

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


