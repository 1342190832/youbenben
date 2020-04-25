
package com.doublechaintech.retailscm.accountingdocumentconfirmation;

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






public class AccountingDocumentConfirmationManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentConfirmationManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = AccountingDocumentConfirmationTokens.start().withTokenFromListName(listName).done();
		AccountingDocumentConfirmation  accountingDocumentConfirmation = (AccountingDocumentConfirmation) this.loadAccountingDocumentConfirmation(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = accountingDocumentConfirmation.collectRefercencesFromLists();
		accountingDocumentConfirmationDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, accountingDocumentConfirmation, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new AccountingDocumentConfirmationGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "AccountingDocumentConfirmation";
	@Override
	public AccountingDocumentConfirmationDAO daoOf(RetailscmUserContext userContext) {
		return accountingDocumentConfirmationDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws AccountingDocumentConfirmationManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentConfirmationManagerException(message);

	}



 	protected AccountingDocumentConfirmation saveAccountingDocumentConfirmation(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentConfirmationDAO().save(accountingDocumentConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens);
 	}
 	
 	protected AccountingDocumentConfirmation saveAccountingDocumentConfirmationDetail(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation) throws Exception{	

 		
 		return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, allTokens());
 	}
 	
 	public AccountingDocumentConfirmation loadAccountingDocumentConfirmation(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentConfirmationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation( userContext, accountingDocumentConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentConfirmation, tokens);
 	}
 	
 	
 	 public AccountingDocumentConfirmation searchAccountingDocumentConfirmation(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentConfirmationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation( userContext, accountingDocumentConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentConfirmation, tokens);
 	}
 	
 	

 	protected AccountingDocumentConfirmation present(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentConfirmation,tokens);
		
		
		AccountingDocumentConfirmation  accountingDocumentConfirmationToPresent = accountingDocumentConfirmationDaoOf(userContext).present(accountingDocumentConfirmation, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentConfirmationToPresent.collectRefercencesFromLists();
		accountingDocumentConfirmationDaoOf(userContext).alias(entityListToNaming);
		
		return  accountingDocumentConfirmationToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocumentConfirmation loadAccountingDocumentConfirmationDetail(RetailscmUserContext userContext, String accountingDocumentConfirmationId) throws Exception{	
 		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation( userContext, accountingDocumentConfirmationId, allTokens());
 		return present(userContext,accountingDocumentConfirmation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingDocumentConfirmationId) throws Exception{	
 		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation( userContext, accountingDocumentConfirmationId, viewTokens());
 		return present(userContext,accountingDocumentConfirmation, allTokens());
		
 	}
 	protected AccountingDocumentConfirmation saveAccountingDocumentConfirmation(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object>tokens) throws Exception{	
 		return accountingDocumentConfirmationDaoOf(userContext).save(accountingDocumentConfirmation, tokens);
 	}
 	protected AccountingDocumentConfirmation loadAccountingDocumentConfirmation(RetailscmUserContext userContext, String accountingDocumentConfirmationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentConfirmationManagerException.class);

 
 		return accountingDocumentConfirmationDaoOf(userContext).load(accountingDocumentConfirmationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentConfirmation, tokens);
		
		addAction(userContext, accountingDocumentConfirmation, tokens,"@create","createAccountingDocumentConfirmation","createAccountingDocumentConfirmation/","main","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"@update","updateAccountingDocumentConfirmation","updateAccountingDocumentConfirmation/"+accountingDocumentConfirmation.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"@copy","cloneAccountingDocumentConfirmation","cloneAccountingDocumentConfirmation/"+accountingDocumentConfirmation.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentConfirmation, tokens,"accounting_document_confirmation.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentConfirmation.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public AccountingDocumentConfirmation createAccountingDocumentConfirmation(RetailscmUserContext userContext, String who,String comments,Date makeDate) throws Exception
	//public AccountingDocumentConfirmation createAccountingDocumentConfirmation(RetailscmUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfAccountingDocumentConfirmation(who);
		checkerOf(userContext).checkCommentsOfAccountingDocumentConfirmation(comments);
		checkerOf(userContext).checkMakeDateOfAccountingDocumentConfirmation(makeDate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);


		AccountingDocumentConfirmation accountingDocumentConfirmation=createNewAccountingDocumentConfirmation();	

		accountingDocumentConfirmation.setWho(who);
		accountingDocumentConfirmation.setComments(comments);
		accountingDocumentConfirmation.setMakeDate(makeDate);

		accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocumentConfirmation);
		return accountingDocumentConfirmation;


	}
	protected AccountingDocumentConfirmation createNewAccountingDocumentConfirmation()
	{

		return new AccountingDocumentConfirmation();
	}

	protected void checkParamsForUpdatingAccountingDocumentConfirmation(RetailscmUserContext userContext,String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		checkerOf(userContext).checkVersionOfAccountingDocumentConfirmation( accountingDocumentConfirmationVersion);
		

		if(AccountingDocumentConfirmation.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfAccountingDocumentConfirmation(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentConfirmation.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfAccountingDocumentConfirmation(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentConfirmation.MAKE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMakeDateOfAccountingDocumentConfirmation(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);


	}



	public AccountingDocumentConfirmation clone(RetailscmUserContext userContext, String fromAccountingDocumentConfirmationId) throws Exception{

		return accountingDocumentConfirmationDaoOf(userContext).clone(fromAccountingDocumentConfirmationId, this.allTokens());
	}

	public AccountingDocumentConfirmation internalSaveAccountingDocumentConfirmation(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation) throws Exception
	{
		return internalSaveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, allTokens());

	}
	public AccountingDocumentConfirmation internalSaveAccountingDocumentConfirmation(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion, property, newValueExpr, tokensExpr);


		synchronized(accountingDocumentConfirmation){
			//will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentConfirmation.
			if (accountingDocumentConfirmation.isChanged()){
			
			}
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, options);
			return accountingDocumentConfirmation;

		}

	}

	public AccountingDocumentConfirmation updateAccountingDocumentConfirmation(RetailscmUserContext userContext,String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion, property, newValueExpr, tokensExpr);



		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		if(accountingDocumentConfirmation.getVersion() != accountingDocumentConfirmationVersion){
			String message = "The target version("+accountingDocumentConfirmation.getVersion()+") is not equals to version("+accountingDocumentConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentConfirmation){
			//will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentConfirmation.
			
			accountingDocumentConfirmation.changeProperty(property, newValueExpr);
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().done());
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().done());
		}

	}

	public AccountingDocumentConfirmation updateAccountingDocumentConfirmationProperty(RetailscmUserContext userContext,String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion, property, newValueExpr, tokensExpr);

		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		if(accountingDocumentConfirmation.getVersion() != accountingDocumentConfirmationVersion){
			String message = "The target version("+accountingDocumentConfirmation.getVersion()+") is not equals to version("+accountingDocumentConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentConfirmation){
			//will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentConfirmation.

			accountingDocumentConfirmation.changeProperty(property, newValueExpr);
			
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().done());
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected AccountingDocumentConfirmationTokens tokens(){
		return AccountingDocumentConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentConfirmationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentConfirmationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion) throws Exception{

		accountingDocumentConfirmationDaoOf(userContext).delete(accountingDocumentConfirmationId, accountingDocumentConfirmationVersion);
	}

	public AccountingDocumentConfirmation forgetByAll(RetailscmUserContext userContext, String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentConfirmationId, accountingDocumentConfirmationVersion);
	}
	protected AccountingDocumentConfirmation forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion) throws Exception{

		return accountingDocumentConfirmationDaoOf(userContext).disconnectFromAll(accountingDocumentConfirmationId, accountingDocumentConfirmationVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return accountingDocumentConfirmationDaoOf(userContext).deleteAll();
	}


	//disconnect AccountingDocumentConfirmation with accounting_period in AccountingDocument
	protected AccountingDocumentConfirmation breakWithAccountingDocumentByAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String accountingPeriodId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());

			synchronized(accountingDocumentConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentConfirmationDaoOf(userContext).planToRemoveAccountingDocumentListWithAccountingPeriod(accountingDocumentConfirmation, accountingPeriodId, this.emptyOptions());

				accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
				return accountingDocumentConfirmation;
			}
	}
	//disconnect AccountingDocumentConfirmation with document_type in AccountingDocument
	protected AccountingDocumentConfirmation breakWithAccountingDocumentByDocumentType(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String documentTypeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());

			synchronized(accountingDocumentConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentConfirmationDaoOf(userContext).planToRemoveAccountingDocumentListWithDocumentType(accountingDocumentConfirmation, documentTypeId, this.emptyOptions());

				accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
				return accountingDocumentConfirmation;
			}
	}
	//disconnect AccountingDocumentConfirmation with creation in AccountingDocument
	protected AccountingDocumentConfirmation breakWithAccountingDocumentByCreation(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());

			synchronized(accountingDocumentConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentConfirmationDaoOf(userContext).planToRemoveAccountingDocumentListWithCreation(accountingDocumentConfirmation, creationId, this.emptyOptions());

				accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
				return accountingDocumentConfirmation;
			}
	}
	//disconnect AccountingDocumentConfirmation with auditing in AccountingDocument
	protected AccountingDocumentConfirmation breakWithAccountingDocumentByAuditing(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String auditingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());

			synchronized(accountingDocumentConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentConfirmationDaoOf(userContext).planToRemoveAccountingDocumentListWithAuditing(accountingDocumentConfirmation, auditingId, this.emptyOptions());

				accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
				return accountingDocumentConfirmation;
			}
	}
	//disconnect AccountingDocumentConfirmation with posting in AccountingDocument
	protected AccountingDocumentConfirmation breakWithAccountingDocumentByPosting(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String postingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());

			synchronized(accountingDocumentConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentConfirmationDaoOf(userContext).planToRemoveAccountingDocumentListWithPosting(accountingDocumentConfirmation, postingId, this.emptyOptions());

				accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
				return accountingDocumentConfirmation;
			}
	}






	protected void checkParamsForAddingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String auditingId, String postingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);

		
		checkerOf(userContext).checkNameOfAccountingDocument(name);
		
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
		
		checkerOf(userContext).checkAccountingPeriodIdOfAccountingDocument(accountingPeriodId);
		
		checkerOf(userContext).checkDocumentTypeIdOfAccountingDocument(documentTypeId);
		
		checkerOf(userContext).checkCreationIdOfAccountingDocument(creationId);
		
		checkerOf(userContext).checkAuditingIdOfAccountingDocument(auditingId);
		
		checkerOf(userContext).checkPostingIdOfAccountingDocument(postingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);


	}
	public  AccountingDocumentConfirmation addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String auditingId, String postingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingDocument(userContext,accountingDocumentConfirmationId,name, accountingDocumentDate, accountingPeriodId, documentTypeId, creationId, auditingId, postingId,tokensExpr);

		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId, creationId, auditingId, postingId);

		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, emptyOptions());
		synchronized(accountingDocumentConfirmation){
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentConfirmation.addAccountingDocument( accountingDocument );
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, accountingDocument);
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentConfirmationId,String id,String name,Date accountingDocumentDate,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		checkerOf(userContext).checkIdOfAccountingDocument(id);

		checkerOf(userContext).checkNameOfAccountingDocument( name);
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument( accountingDocumentDate);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);

	}
	public  AccountingDocumentConfirmation updateAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String id,String name,Date accountingDocumentDate, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentProperties(userContext,accountingDocumentConfirmationId,id,name,accountingDocumentDate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentListList()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "is", id).done();

		AccountingDocumentConfirmation accountingDocumentConfirmationToUpdate = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, options);

		if(accountingDocumentConfirmationToUpdate.getAccountingDocumentList().isEmpty()){
			throw new AccountingDocumentConfirmationManagerException("AccountingDocument is NOT FOUND with id: '"+id+"'");
		}

		AccountingDocument item = accountingDocumentConfirmationToUpdate.getAccountingDocumentList().first();

		item.updateName( name );
		item.updateAccountingDocumentDate( accountingDocumentDate );


		//checkParamsForAddingAccountingDocument(userContext,accountingDocumentConfirmationId,name, code, used,tokensExpr);
		AccountingDocumentConfirmation accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationToUpdate, tokens().withAccountingDocumentList().done());
		synchronized(accountingDocumentConfirmation){
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountingDocument createAccountingDocument(RetailscmUserContext userContext, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String auditingId, String postingId) throws Exception{

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
		AccountingDocumentAuditing  auditing = new AccountingDocumentAuditing();
		auditing.setId(auditingId);		
		accountingDocument.setAuditing(auditing);		
		AccountingDocumentPosting  posting = new AccountingDocumentPosting();
		posting.setId(postingId);		
		accountingDocument.setPosting(posting);
	
		
		return accountingDocument;


	}

	protected AccountingDocument createIndexedAccountingDocument(String id, int version){

		AccountingDocument accountingDocument = new AccountingDocument();
		accountingDocument.setId(id);
		accountingDocument.setVersion(version);
		return accountingDocument;

	}

	protected void checkParamsForRemovingAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentConfirmationId,
			String accountingDocumentIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		for(String accountingDocumentIdItem: accountingDocumentIds){
			checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);

	}
	public  AccountingDocumentConfirmation removeAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentConfirmationId,
			String accountingDocumentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingDocumentList(userContext, accountingDocumentConfirmationId,  accountingDocumentIds, tokensExpr);


			AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
			synchronized(accountingDocumentConfirmation){
				//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountingDocumentConfirmationDaoOf(userContext).planToRemoveAccountingDocumentList(accountingDocumentConfirmation, accountingDocumentIds, allTokens());
				accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
				deleteRelationListInGraph(userContext, accountingDocumentConfirmation.getAccountingDocumentList());
				return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocumentConfirmation( accountingDocumentConfirmationId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);

	}
	public  AccountingDocumentConfirmation removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentConfirmationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);

		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		synchronized(accountingDocumentConfirmation){
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentConfirmation.removeAccountingDocument( accountingDocument );
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			deleteRelationInGraph(userContext, accountingDocument);
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocumentConfirmation( accountingDocumentConfirmationId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);

	}
	public  AccountingDocumentConfirmation copyAccountingDocumentFrom(RetailscmUserContext userContext, String accountingDocumentConfirmationId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentConfirmationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);

		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, allTokens());
		synchronized(accountingDocumentConfirmation){
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			accountingDocumentConfirmation.copyAccountingDocumentFrom( accountingDocument );
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, (AccountingDocument)accountingDocumentConfirmation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfAccountingDocumentConfirmation(accountingDocumentConfirmationId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocument(parseString(newValueExpr));
		
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentConfirmationManagerException.class);

	}

	public  AccountingDocumentConfirmation updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentConfirmationId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentList().searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "eq", accountingDocumentId).done();



		AccountingDocumentConfirmation accountingDocumentConfirmation = loadAccountingDocumentConfirmation(userContext, accountingDocumentConfirmationId, loadTokens);

		synchronized(accountingDocumentConfirmation){
			//Will be good when the accountingDocumentConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentConfirmation.removeAccountingDocument( accountingDocument );
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);

			AccountingDocument accountingDocument = accountingDocumentConfirmation.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentConfirmationManagerException(accountingDocument+" is NOT FOUND" );
			}

			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingDocumentConfirmation = saveAccountingDocumentConfirmation(userContext, accountingDocumentConfirmation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentConfirmation newCreated) throws Exception{
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
		//   AccountingDocumentConfirmation newAccountingDocumentConfirmation = this.createAccountingDocumentConfirmation(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newAccountingDocumentConfirmation
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, AccountingDocumentConfirmation.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<AccountingDocumentConfirmation> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String accountingDocumentConfirmationId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getAccountingDocumentConfirmationDetailScope().clone();
		AccountingDocumentConfirmation merchantObj = (AccountingDocumentConfirmation) this.view(userContext, accountingDocumentConfirmationId);
    String merchantObjId = accountingDocumentConfirmationId;
    String linkToUrl =	"accountingDocumentConfirmationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会计的确认文件"+"详情";
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
		    "accountingDocumentManager/listByConfirmation/"+merchantObjId+"/",
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


