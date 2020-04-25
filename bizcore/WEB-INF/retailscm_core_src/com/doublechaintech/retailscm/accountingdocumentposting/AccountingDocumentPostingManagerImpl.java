
package com.doublechaintech.retailscm.accountingdocumentposting;

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


import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;


import com.doublechaintech.retailscm.accountingdocumentposting.AccountingDocumentPosting;
import com.doublechaintech.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.doublechaintech.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.doublechaintech.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;






public class AccountingDocumentPostingManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentPostingManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = AccountingDocumentPostingTokens.start().withTokenFromListName(listName).done();
		AccountingDocumentPosting  accountingDocumentPosting = (AccountingDocumentPosting) this.loadAccountingDocumentPosting(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = accountingDocumentPosting.collectRefercencesFromLists();
		accountingDocumentPostingDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, accountingDocumentPosting, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new AccountingDocumentPostingGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "AccountingDocumentPosting";
	@Override
	public AccountingDocumentPostingDAO daoOf(RetailscmUserContext userContext) {
		return accountingDocumentPostingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws AccountingDocumentPostingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentPostingManagerException(message);

	}



 	protected AccountingDocumentPosting saveAccountingDocumentPosting(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentPostingDAO().save(accountingDocumentPosting, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens);
 	}
 	
 	protected AccountingDocumentPosting saveAccountingDocumentPostingDetail(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting) throws Exception{	

 		
 		return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, allTokens());
 	}
 	
 	public AccountingDocumentPosting loadAccountingDocumentPosting(RetailscmUserContext userContext, String accountingDocumentPostingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentPostingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting( userContext, accountingDocumentPostingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentPosting, tokens);
 	}
 	
 	
 	 public AccountingDocumentPosting searchAccountingDocumentPosting(RetailscmUserContext userContext, String accountingDocumentPostingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentPostingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting( userContext, accountingDocumentPostingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentPosting, tokens);
 	}
 	
 	

 	protected AccountingDocumentPosting present(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentPosting,tokens);
		
		
		AccountingDocumentPosting  accountingDocumentPostingToPresent = accountingDocumentPostingDaoOf(userContext).present(accountingDocumentPosting, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentPostingToPresent.collectRefercencesFromLists();
		accountingDocumentPostingDaoOf(userContext).alias(entityListToNaming);
		
		return  accountingDocumentPostingToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocumentPosting loadAccountingDocumentPostingDetail(RetailscmUserContext userContext, String accountingDocumentPostingId) throws Exception{	
 		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting( userContext, accountingDocumentPostingId, allTokens());
 		return present(userContext,accountingDocumentPosting, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingDocumentPostingId) throws Exception{	
 		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting( userContext, accountingDocumentPostingId, viewTokens());
 		return present(userContext,accountingDocumentPosting, allTokens());
		
 	}
 	protected AccountingDocumentPosting saveAccountingDocumentPosting(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String,Object>tokens) throws Exception{	
 		return accountingDocumentPostingDaoOf(userContext).save(accountingDocumentPosting, tokens);
 	}
 	protected AccountingDocumentPosting loadAccountingDocumentPosting(RetailscmUserContext userContext, String accountingDocumentPostingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentPostingManagerException.class);

 
 		return accountingDocumentPostingDaoOf(userContext).load(accountingDocumentPostingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentPosting, tokens);
		
		addAction(userContext, accountingDocumentPosting, tokens,"@create","createAccountingDocumentPosting","createAccountingDocumentPosting/","main","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"@update","updateAccountingDocumentPosting","updateAccountingDocumentPosting/"+accountingDocumentPosting.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"@copy","cloneAccountingDocumentPosting","cloneAccountingDocumentPosting/"+accountingDocumentPosting.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentPosting, tokens,"accounting_document_posting.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentPosting.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public AccountingDocumentPosting createAccountingDocumentPosting(RetailscmUserContext userContext, String who,String comments,Date makeDate) throws Exception
	//public AccountingDocumentPosting createAccountingDocumentPosting(RetailscmUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfAccountingDocumentPosting(who);
		checkerOf(userContext).checkCommentsOfAccountingDocumentPosting(comments);
		checkerOf(userContext).checkMakeDateOfAccountingDocumentPosting(makeDate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);


		AccountingDocumentPosting accountingDocumentPosting=createNewAccountingDocumentPosting();	

		accountingDocumentPosting.setWho(who);
		accountingDocumentPosting.setComments(comments);
		accountingDocumentPosting.setMakeDate(makeDate);

		accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocumentPosting);
		return accountingDocumentPosting;


	}
	protected AccountingDocumentPosting createNewAccountingDocumentPosting()
	{

		return new AccountingDocumentPosting();
	}

	protected void checkParamsForUpdatingAccountingDocumentPosting(RetailscmUserContext userContext,String accountingDocumentPostingId, int accountingDocumentPostingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		checkerOf(userContext).checkVersionOfAccountingDocumentPosting( accountingDocumentPostingVersion);
		

		if(AccountingDocumentPosting.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfAccountingDocumentPosting(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentPosting.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfAccountingDocumentPosting(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentPosting.MAKE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMakeDateOfAccountingDocumentPosting(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);


	}



	public AccountingDocumentPosting clone(RetailscmUserContext userContext, String fromAccountingDocumentPostingId) throws Exception{

		return accountingDocumentPostingDaoOf(userContext).clone(fromAccountingDocumentPostingId, this.allTokens());
	}

	public AccountingDocumentPosting internalSaveAccountingDocumentPosting(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting) throws Exception
	{
		return internalSaveAccountingDocumentPosting(userContext, accountingDocumentPosting, allTokens());

	}
	public AccountingDocumentPosting internalSaveAccountingDocumentPosting(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingAccountingDocumentPosting(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion, property, newValueExpr, tokensExpr);


		synchronized(accountingDocumentPosting){
			//will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentPosting.
			if (accountingDocumentPosting.isChanged()){
			
			}
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, options);
			return accountingDocumentPosting;

		}

	}

	public AccountingDocumentPosting updateAccountingDocumentPosting(RetailscmUserContext userContext,String accountingDocumentPostingId, int accountingDocumentPostingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentPosting(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion, property, newValueExpr, tokensExpr);



		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		if(accountingDocumentPosting.getVersion() != accountingDocumentPostingVersion){
			String message = "The target version("+accountingDocumentPosting.getVersion()+") is not equals to version("+accountingDocumentPostingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentPosting){
			//will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentPosting.
			
			accountingDocumentPosting.changeProperty(property, newValueExpr);
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().done());
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().done());
		}

	}

	public AccountingDocumentPosting updateAccountingDocumentPostingProperty(RetailscmUserContext userContext,String accountingDocumentPostingId, int accountingDocumentPostingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentPosting(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion, property, newValueExpr, tokensExpr);

		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		if(accountingDocumentPosting.getVersion() != accountingDocumentPostingVersion){
			String message = "The target version("+accountingDocumentPosting.getVersion()+") is not equals to version("+accountingDocumentPostingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentPosting){
			//will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentPosting.

			accountingDocumentPosting.changeProperty(property, newValueExpr);
			
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().done());
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected AccountingDocumentPostingTokens tokens(){
		return AccountingDocumentPostingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentPostingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentPostingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentPostingId, int accountingDocumentPostingVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentPostingId, int accountingDocumentPostingVersion) throws Exception{

		accountingDocumentPostingDaoOf(userContext).delete(accountingDocumentPostingId, accountingDocumentPostingVersion);
	}

	public AccountingDocumentPosting forgetByAll(RetailscmUserContext userContext, String accountingDocumentPostingId, int accountingDocumentPostingVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentPostingId, accountingDocumentPostingVersion);
	}
	protected AccountingDocumentPosting forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentPostingId, int accountingDocumentPostingVersion) throws Exception{

		return accountingDocumentPostingDaoOf(userContext).disconnectFromAll(accountingDocumentPostingId, accountingDocumentPostingVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentPostingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return accountingDocumentPostingDaoOf(userContext).deleteAll();
	}


	//disconnect AccountingDocumentPosting with accounting_period in AccountingDocument
	protected AccountingDocumentPosting breakWithAccountingDocumentByAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentPostingId, String accountingPeriodId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());

			synchronized(accountingDocumentPosting){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentPostingDaoOf(userContext).planToRemoveAccountingDocumentListWithAccountingPeriod(accountingDocumentPosting, accountingPeriodId, this.emptyOptions());

				accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
				return accountingDocumentPosting;
			}
	}
	//disconnect AccountingDocumentPosting with document_type in AccountingDocument
	protected AccountingDocumentPosting breakWithAccountingDocumentByDocumentType(RetailscmUserContext userContext, String accountingDocumentPostingId, String documentTypeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());

			synchronized(accountingDocumentPosting){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentPostingDaoOf(userContext).planToRemoveAccountingDocumentListWithDocumentType(accountingDocumentPosting, documentTypeId, this.emptyOptions());

				accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
				return accountingDocumentPosting;
			}
	}
	//disconnect AccountingDocumentPosting with creation in AccountingDocument
	protected AccountingDocumentPosting breakWithAccountingDocumentByCreation(RetailscmUserContext userContext, String accountingDocumentPostingId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());

			synchronized(accountingDocumentPosting){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentPostingDaoOf(userContext).planToRemoveAccountingDocumentListWithCreation(accountingDocumentPosting, creationId, this.emptyOptions());

				accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
				return accountingDocumentPosting;
			}
	}
	//disconnect AccountingDocumentPosting with confirmation in AccountingDocument
	protected AccountingDocumentPosting breakWithAccountingDocumentByConfirmation(RetailscmUserContext userContext, String accountingDocumentPostingId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());

			synchronized(accountingDocumentPosting){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentPostingDaoOf(userContext).planToRemoveAccountingDocumentListWithConfirmation(accountingDocumentPosting, confirmationId, this.emptyOptions());

				accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
				return accountingDocumentPosting;
			}
	}
	//disconnect AccountingDocumentPosting with auditing in AccountingDocument
	protected AccountingDocumentPosting breakWithAccountingDocumentByAuditing(RetailscmUserContext userContext, String accountingDocumentPostingId, String auditingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());

			synchronized(accountingDocumentPosting){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentPostingDaoOf(userContext).planToRemoveAccountingDocumentListWithAuditing(accountingDocumentPosting, auditingId, this.emptyOptions());

				accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
				return accountingDocumentPosting;
			}
	}






	protected void checkParamsForAddingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String auditingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);

		
		checkerOf(userContext).checkNameOfAccountingDocument(name);
		
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
		
		checkerOf(userContext).checkAccountingPeriodIdOfAccountingDocument(accountingPeriodId);
		
		checkerOf(userContext).checkDocumentTypeIdOfAccountingDocument(documentTypeId);
		
		checkerOf(userContext).checkCreationIdOfAccountingDocument(creationId);
		
		checkerOf(userContext).checkConfirmationIdOfAccountingDocument(confirmationId);
		
		checkerOf(userContext).checkAuditingIdOfAccountingDocument(auditingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);


	}
	public  AccountingDocumentPosting addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String auditingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingDocument(userContext,accountingDocumentPostingId,name, accountingDocumentDate, accountingPeriodId, documentTypeId, creationId, confirmationId, auditingId,tokensExpr);

		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId, creationId, confirmationId, auditingId);

		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, emptyOptions());
		synchronized(accountingDocumentPosting){
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentPosting.addAccountingDocument( accountingDocument );
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, accountingDocument);
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentPostingId,String id,String name,Date accountingDocumentDate,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		checkerOf(userContext).checkIdOfAccountingDocument(id);

		checkerOf(userContext).checkNameOfAccountingDocument( name);
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument( accountingDocumentDate);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);

	}
	public  AccountingDocumentPosting updateAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentPostingId, String id,String name,Date accountingDocumentDate, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentProperties(userContext,accountingDocumentPostingId,id,name,accountingDocumentDate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentListList()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "is", id).done();

		AccountingDocumentPosting accountingDocumentPostingToUpdate = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, options);

		if(accountingDocumentPostingToUpdate.getAccountingDocumentList().isEmpty()){
			throw new AccountingDocumentPostingManagerException("AccountingDocument is NOT FOUND with id: '"+id+"'");
		}

		AccountingDocument item = accountingDocumentPostingToUpdate.getAccountingDocumentList().first();

		item.updateName( name );
		item.updateAccountingDocumentDate( accountingDocumentDate );


		//checkParamsForAddingAccountingDocument(userContext,accountingDocumentPostingId,name, code, used,tokensExpr);
		AccountingDocumentPosting accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPostingToUpdate, tokens().withAccountingDocumentList().done());
		synchronized(accountingDocumentPosting){
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountingDocument createAccountingDocument(RetailscmUserContext userContext, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String auditingId) throws Exception{

		AccountingDocument accountingDocument = new AccountingDocument();
		
		
		accountingDocument.setName(name);		
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);		
		AccountingPeriod  accountingPeriod = new AccountingPeriod();
		accountingPeriod.setId(accountingPeriodId);		
		accountingDocument.setAccountingPeriod(accountingPeriod);		
		AccountingDocumentType  documentType = new AccountingDocumentType();
		documentType.setId(documentTypeId);		
		accountingDocument.setDocumentType(documentType);		
		AccountingDocumentCreation  creation = new AccountingDocumentCreation();
		creation.setId(creationId);		
		accountingDocument.setCreation(creation);		
		AccountingDocumentConfirmation  confirmation = new AccountingDocumentConfirmation();
		confirmation.setId(confirmationId);		
		accountingDocument.setConfirmation(confirmation);		
		AccountingDocumentAuditing  auditing = new AccountingDocumentAuditing();
		auditing.setId(auditingId);		
		accountingDocument.setAuditing(auditing);
	
		
		return accountingDocument;


	}

	protected AccountingDocument createIndexedAccountingDocument(String id, int version){

		AccountingDocument accountingDocument = new AccountingDocument();
		accountingDocument.setId(id);
		accountingDocument.setVersion(version);
		return accountingDocument;

	}

	protected void checkParamsForRemovingAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentPostingId,
			String accountingDocumentIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		for(String accountingDocumentIdItem: accountingDocumentIds){
			checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);

	}
	public  AccountingDocumentPosting removeAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentPostingId,
			String accountingDocumentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingDocumentList(userContext, accountingDocumentPostingId,  accountingDocumentIds, tokensExpr);


			AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
			synchronized(accountingDocumentPosting){
				//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountingDocumentPostingDaoOf(userContext).planToRemoveAccountingDocumentList(accountingDocumentPosting, accountingDocumentIds, allTokens());
				accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
				deleteRelationListInGraph(userContext, accountingDocumentPosting.getAccountingDocumentList());
				return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocumentPosting( accountingDocumentPostingId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);

	}
	public  AccountingDocumentPosting removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentPostingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);

		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		synchronized(accountingDocumentPosting){
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentPosting.removeAccountingDocument( accountingDocument );
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			deleteRelationInGraph(userContext, accountingDocument);
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocumentPosting( accountingDocumentPostingId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);

	}
	public  AccountingDocumentPosting copyAccountingDocumentFrom(RetailscmUserContext userContext, String accountingDocumentPostingId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentPostingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);

		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, allTokens());
		synchronized(accountingDocumentPosting){
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			accountingDocumentPosting.copyAccountingDocumentFrom( accountingDocument );
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, (AccountingDocument)accountingDocumentPosting.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfAccountingDocumentPosting(accountingDocumentPostingId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocument(parseString(newValueExpr));
		
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentPostingManagerException.class);

	}

	public  AccountingDocumentPosting updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentPostingId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentList().searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "eq", accountingDocumentId).done();



		AccountingDocumentPosting accountingDocumentPosting = loadAccountingDocumentPosting(userContext, accountingDocumentPostingId, loadTokens);

		synchronized(accountingDocumentPosting){
			//Will be good when the accountingDocumentPosting loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentPosting.removeAccountingDocument( accountingDocument );
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);

			AccountingDocument accountingDocument = accountingDocumentPosting.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentPostingManagerException(accountingDocument+" is NOT FOUND" );
			}

			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingDocumentPosting = saveAccountingDocumentPosting(userContext, accountingDocumentPosting, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentPosting, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentPosting newCreated) throws Exception{
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
		//   AccountingDocumentPosting newAccountingDocumentPosting = this.createAccountingDocumentPosting(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newAccountingDocumentPosting
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, AccountingDocumentPosting.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<AccountingDocumentPosting> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String accountingDocumentPostingId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getAccountingDocumentPostingDetailScope().clone();
		AccountingDocumentPosting merchantObj = (AccountingDocumentPosting) this.view(userContext, accountingDocumentPostingId);
    String merchantObjId = accountingDocumentPostingId;
    String linkToUrl =	"accountingDocumentPostingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会计凭证过帐"+"详情";
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

		//处理Section：accountingDocumentListSection
		Map accountingDocumentListSection = ListofUtils.buildSection(
		    "accountingDocumentListSection",
		    "会计文档列表",
		    null,
		    "",
		    "__no_group",
		    "accountingDocumentManager/listByPosting/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(accountingDocumentListSection);

		result.put("accountingDocumentListSection", ListofUtils.toShortList(merchantObj.getAccountingDocumentList(), "accountingDocument"));
		vscope.field("accountingDocumentListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( AccountingDocument.class.getName(), null));

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


