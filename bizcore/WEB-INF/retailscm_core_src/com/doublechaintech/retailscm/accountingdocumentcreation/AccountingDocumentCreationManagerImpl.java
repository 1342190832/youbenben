
package com.doublechaintech.retailscm.accountingdocumentcreation;

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






public class AccountingDocumentCreationManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentCreationManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = AccountingDocumentCreationTokens.start().withTokenFromListName(listName).done();
		AccountingDocumentCreation  accountingDocumentCreation = (AccountingDocumentCreation) this.loadAccountingDocumentCreation(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = accountingDocumentCreation.collectRefercencesFromLists();
		accountingDocumentCreationDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, accountingDocumentCreation, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new AccountingDocumentCreationGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "AccountingDocumentCreation";
	@Override
	public AccountingDocumentCreationDAO daoOf(RetailscmUserContext userContext) {
		return accountingDocumentCreationDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws AccountingDocumentCreationManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentCreationManagerException(message);

	}



 	protected AccountingDocumentCreation saveAccountingDocumentCreation(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentCreationDAO().save(accountingDocumentCreation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens);
 	}
 	
 	protected AccountingDocumentCreation saveAccountingDocumentCreationDetail(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation) throws Exception{	

 		
 		return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, allTokens());
 	}
 	
 	public AccountingDocumentCreation loadAccountingDocumentCreation(RetailscmUserContext userContext, String accountingDocumentCreationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentCreationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation( userContext, accountingDocumentCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentCreation, tokens);
 	}
 	
 	
 	 public AccountingDocumentCreation searchAccountingDocumentCreation(RetailscmUserContext userContext, String accountingDocumentCreationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentCreationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation( userContext, accountingDocumentCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentCreation, tokens);
 	}
 	
 	

 	protected AccountingDocumentCreation present(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentCreation,tokens);
		
		
		AccountingDocumentCreation  accountingDocumentCreationToPresent = accountingDocumentCreationDaoOf(userContext).present(accountingDocumentCreation, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentCreationToPresent.collectRefercencesFromLists();
		accountingDocumentCreationDaoOf(userContext).alias(entityListToNaming);
		
		return  accountingDocumentCreationToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocumentCreation loadAccountingDocumentCreationDetail(RetailscmUserContext userContext, String accountingDocumentCreationId) throws Exception{	
 		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation( userContext, accountingDocumentCreationId, allTokens());
 		return present(userContext,accountingDocumentCreation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingDocumentCreationId) throws Exception{	
 		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation( userContext, accountingDocumentCreationId, viewTokens());
 		return present(userContext,accountingDocumentCreation, allTokens());
		
 	}
 	protected AccountingDocumentCreation saveAccountingDocumentCreation(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String,Object>tokens) throws Exception{	
 		return accountingDocumentCreationDaoOf(userContext).save(accountingDocumentCreation, tokens);
 	}
 	protected AccountingDocumentCreation loadAccountingDocumentCreation(RetailscmUserContext userContext, String accountingDocumentCreationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentCreationManagerException.class);

 
 		return accountingDocumentCreationDaoOf(userContext).load(accountingDocumentCreationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentCreation, tokens);
		
		addAction(userContext, accountingDocumentCreation, tokens,"@create","createAccountingDocumentCreation","createAccountingDocumentCreation/","main","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"@update","updateAccountingDocumentCreation","updateAccountingDocumentCreation/"+accountingDocumentCreation.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"@copy","cloneAccountingDocumentCreation","cloneAccountingDocumentCreation/"+accountingDocumentCreation.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentCreation, tokens,"accounting_document_creation.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentCreation.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public AccountingDocumentCreation createAccountingDocumentCreation(RetailscmUserContext userContext, String who,String comments,Date makeDate) throws Exception
	//public AccountingDocumentCreation createAccountingDocumentCreation(RetailscmUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfAccountingDocumentCreation(who);
		checkerOf(userContext).checkCommentsOfAccountingDocumentCreation(comments);
		checkerOf(userContext).checkMakeDateOfAccountingDocumentCreation(makeDate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);


		AccountingDocumentCreation accountingDocumentCreation=createNewAccountingDocumentCreation();	

		accountingDocumentCreation.setWho(who);
		accountingDocumentCreation.setComments(comments);
		accountingDocumentCreation.setMakeDate(makeDate);

		accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocumentCreation);
		return accountingDocumentCreation;


	}
	protected AccountingDocumentCreation createNewAccountingDocumentCreation()
	{

		return new AccountingDocumentCreation();
	}

	protected void checkParamsForUpdatingAccountingDocumentCreation(RetailscmUserContext userContext,String accountingDocumentCreationId, int accountingDocumentCreationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		checkerOf(userContext).checkVersionOfAccountingDocumentCreation( accountingDocumentCreationVersion);
		

		if(AccountingDocumentCreation.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfAccountingDocumentCreation(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentCreation.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfAccountingDocumentCreation(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentCreation.MAKE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMakeDateOfAccountingDocumentCreation(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);


	}



	public AccountingDocumentCreation clone(RetailscmUserContext userContext, String fromAccountingDocumentCreationId) throws Exception{

		return accountingDocumentCreationDaoOf(userContext).clone(fromAccountingDocumentCreationId, this.allTokens());
	}

	public AccountingDocumentCreation internalSaveAccountingDocumentCreation(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation) throws Exception
	{
		return internalSaveAccountingDocumentCreation(userContext, accountingDocumentCreation, allTokens());

	}
	public AccountingDocumentCreation internalSaveAccountingDocumentCreation(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingAccountingDocumentCreation(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion, property, newValueExpr, tokensExpr);


		synchronized(accountingDocumentCreation){
			//will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentCreation.
			if (accountingDocumentCreation.isChanged()){
			
			}
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, options);
			return accountingDocumentCreation;

		}

	}

	public AccountingDocumentCreation updateAccountingDocumentCreation(RetailscmUserContext userContext,String accountingDocumentCreationId, int accountingDocumentCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentCreation(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion, property, newValueExpr, tokensExpr);



		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		if(accountingDocumentCreation.getVersion() != accountingDocumentCreationVersion){
			String message = "The target version("+accountingDocumentCreation.getVersion()+") is not equals to version("+accountingDocumentCreationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentCreation){
			//will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentCreation.
			
			accountingDocumentCreation.changeProperty(property, newValueExpr);
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().done());
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().done());
		}

	}

	public AccountingDocumentCreation updateAccountingDocumentCreationProperty(RetailscmUserContext userContext,String accountingDocumentCreationId, int accountingDocumentCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentCreation(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion, property, newValueExpr, tokensExpr);

		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		if(accountingDocumentCreation.getVersion() != accountingDocumentCreationVersion){
			String message = "The target version("+accountingDocumentCreation.getVersion()+") is not equals to version("+accountingDocumentCreationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentCreation){
			//will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentCreation.

			accountingDocumentCreation.changeProperty(property, newValueExpr);
			
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().done());
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected AccountingDocumentCreationTokens tokens(){
		return AccountingDocumentCreationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentCreationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentCreationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentCreationId, int accountingDocumentCreationVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentCreationId, int accountingDocumentCreationVersion) throws Exception{

		accountingDocumentCreationDaoOf(userContext).delete(accountingDocumentCreationId, accountingDocumentCreationVersion);
	}

	public AccountingDocumentCreation forgetByAll(RetailscmUserContext userContext, String accountingDocumentCreationId, int accountingDocumentCreationVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentCreationId, accountingDocumentCreationVersion);
	}
	protected AccountingDocumentCreation forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentCreationId, int accountingDocumentCreationVersion) throws Exception{

		return accountingDocumentCreationDaoOf(userContext).disconnectFromAll(accountingDocumentCreationId, accountingDocumentCreationVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentCreationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return accountingDocumentCreationDaoOf(userContext).deleteAll();
	}


	//disconnect AccountingDocumentCreation with accounting_period in AccountingDocument
	protected AccountingDocumentCreation breakWithAccountingDocumentByAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentCreationId, String accountingPeriodId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());

			synchronized(accountingDocumentCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentCreationDaoOf(userContext).planToRemoveAccountingDocumentListWithAccountingPeriod(accountingDocumentCreation, accountingPeriodId, this.emptyOptions());

				accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
				return accountingDocumentCreation;
			}
	}
	//disconnect AccountingDocumentCreation with document_type in AccountingDocument
	protected AccountingDocumentCreation breakWithAccountingDocumentByDocumentType(RetailscmUserContext userContext, String accountingDocumentCreationId, String documentTypeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());

			synchronized(accountingDocumentCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentCreationDaoOf(userContext).planToRemoveAccountingDocumentListWithDocumentType(accountingDocumentCreation, documentTypeId, this.emptyOptions());

				accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
				return accountingDocumentCreation;
			}
	}
	//disconnect AccountingDocumentCreation with confirmation in AccountingDocument
	protected AccountingDocumentCreation breakWithAccountingDocumentByConfirmation(RetailscmUserContext userContext, String accountingDocumentCreationId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());

			synchronized(accountingDocumentCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentCreationDaoOf(userContext).planToRemoveAccountingDocumentListWithConfirmation(accountingDocumentCreation, confirmationId, this.emptyOptions());

				accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
				return accountingDocumentCreation;
			}
	}
	//disconnect AccountingDocumentCreation with auditing in AccountingDocument
	protected AccountingDocumentCreation breakWithAccountingDocumentByAuditing(RetailscmUserContext userContext, String accountingDocumentCreationId, String auditingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());

			synchronized(accountingDocumentCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentCreationDaoOf(userContext).planToRemoveAccountingDocumentListWithAuditing(accountingDocumentCreation, auditingId, this.emptyOptions());

				accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
				return accountingDocumentCreation;
			}
	}
	//disconnect AccountingDocumentCreation with posting in AccountingDocument
	protected AccountingDocumentCreation breakWithAccountingDocumentByPosting(RetailscmUserContext userContext, String accountingDocumentCreationId, String postingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());

			synchronized(accountingDocumentCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentCreationDaoOf(userContext).planToRemoveAccountingDocumentListWithPosting(accountingDocumentCreation, postingId, this.emptyOptions());

				accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
				return accountingDocumentCreation;
			}
	}






	protected void checkParamsForAddingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String confirmationId, String auditingId, String postingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);

		
		checkerOf(userContext).checkNameOfAccountingDocument(name);
		
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
		
		checkerOf(userContext).checkAccountingPeriodIdOfAccountingDocument(accountingPeriodId);
		
		checkerOf(userContext).checkDocumentTypeIdOfAccountingDocument(documentTypeId);
		
		checkerOf(userContext).checkConfirmationIdOfAccountingDocument(confirmationId);
		
		checkerOf(userContext).checkAuditingIdOfAccountingDocument(auditingId);
		
		checkerOf(userContext).checkPostingIdOfAccountingDocument(postingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);


	}
	public  AccountingDocumentCreation addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String confirmationId, String auditingId, String postingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingDocument(userContext,accountingDocumentCreationId,name, accountingDocumentDate, accountingPeriodId, documentTypeId, confirmationId, auditingId, postingId,tokensExpr);

		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId, confirmationId, auditingId, postingId);

		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, emptyOptions());
		synchronized(accountingDocumentCreation){
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentCreation.addAccountingDocument( accountingDocument );
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, accountingDocument);
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentCreationId,String id,String name,Date accountingDocumentDate,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		checkerOf(userContext).checkIdOfAccountingDocument(id);

		checkerOf(userContext).checkNameOfAccountingDocument( name);
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument( accountingDocumentDate);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);

	}
	public  AccountingDocumentCreation updateAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentCreationId, String id,String name,Date accountingDocumentDate, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentProperties(userContext,accountingDocumentCreationId,id,name,accountingDocumentDate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentListList()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "is", id).done();

		AccountingDocumentCreation accountingDocumentCreationToUpdate = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, options);

		if(accountingDocumentCreationToUpdate.getAccountingDocumentList().isEmpty()){
			throw new AccountingDocumentCreationManagerException("AccountingDocument is NOT FOUND with id: '"+id+"'");
		}

		AccountingDocument item = accountingDocumentCreationToUpdate.getAccountingDocumentList().first();

		item.updateName( name );
		item.updateAccountingDocumentDate( accountingDocumentDate );


		//checkParamsForAddingAccountingDocument(userContext,accountingDocumentCreationId,name, code, used,tokensExpr);
		AccountingDocumentCreation accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreationToUpdate, tokens().withAccountingDocumentList().done());
		synchronized(accountingDocumentCreation){
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountingDocument createAccountingDocument(RetailscmUserContext userContext, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String confirmationId, String auditingId, String postingId) throws Exception{

		AccountingDocument accountingDocument = new AccountingDocument();
		
		
		accountingDocument.setName(name);		
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);		
		AccountingPeriod  accountingPeriod = new AccountingPeriod();
		accountingPeriod.setId(accountingPeriodId);		
		accountingDocument.setAccountingPeriod(accountingPeriod);		
		AccountingDocumentType  documentType = new AccountingDocumentType();
		documentType.setId(documentTypeId);		
		accountingDocument.setDocumentType(documentType);		
		AccountingDocumentConfirmation  confirmation = new AccountingDocumentConfirmation();
		confirmation.setId(confirmationId);		
		accountingDocument.setConfirmation(confirmation);		
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

	protected void checkParamsForRemovingAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentCreationId,
			String accountingDocumentIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		for(String accountingDocumentIdItem: accountingDocumentIds){
			checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);

	}
	public  AccountingDocumentCreation removeAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentCreationId,
			String accountingDocumentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingDocumentList(userContext, accountingDocumentCreationId,  accountingDocumentIds, tokensExpr);


			AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
			synchronized(accountingDocumentCreation){
				//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountingDocumentCreationDaoOf(userContext).planToRemoveAccountingDocumentList(accountingDocumentCreation, accountingDocumentIds, allTokens());
				accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
				deleteRelationListInGraph(userContext, accountingDocumentCreation.getAccountingDocumentList());
				return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocumentCreation( accountingDocumentCreationId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);

	}
	public  AccountingDocumentCreation removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentCreationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);

		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		synchronized(accountingDocumentCreation){
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentCreation.removeAccountingDocument( accountingDocument );
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			deleteRelationInGraph(userContext, accountingDocument);
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocumentCreation( accountingDocumentCreationId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);

	}
	public  AccountingDocumentCreation copyAccountingDocumentFrom(RetailscmUserContext userContext, String accountingDocumentCreationId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentCreationId, accountingDocumentId, accountingDocumentVersion,tokensExpr);

		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, allTokens());
		synchronized(accountingDocumentCreation){
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			accountingDocumentCreation.copyAccountingDocumentFrom( accountingDocument );
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, (AccountingDocument)accountingDocumentCreation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfAccountingDocumentCreation(accountingDocumentCreationId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocument(parseString(newValueExpr));
		
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentCreationManagerException.class);

	}

	public  AccountingDocumentCreation updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentCreationId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentList().searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "eq", accountingDocumentId).done();



		AccountingDocumentCreation accountingDocumentCreation = loadAccountingDocumentCreation(userContext, accountingDocumentCreationId, loadTokens);

		synchronized(accountingDocumentCreation){
			//Will be good when the accountingDocumentCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentCreation.removeAccountingDocument( accountingDocument );
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);

			AccountingDocument accountingDocument = accountingDocumentCreation.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentCreationManagerException(accountingDocument+" is NOT FOUND" );
			}

			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingDocumentCreation = saveAccountingDocumentCreation(userContext, accountingDocumentCreation, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentCreation, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentCreation newCreated) throws Exception{
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
		//   AccountingDocumentCreation newAccountingDocumentCreation = this.createAccountingDocumentCreation(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newAccountingDocumentCreation
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, AccountingDocumentCreation.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<AccountingDocumentCreation> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String accountingDocumentCreationId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getAccountingDocumentCreationDetailScope().clone();
		AccountingDocumentCreation merchantObj = (AccountingDocumentCreation) this.view(userContext, accountingDocumentCreationId);
    String merchantObjId = accountingDocumentCreationId;
    String linkToUrl =	"accountingDocumentCreationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会计文件的创建"+"详情";
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
		    "accountingDocumentManager/listByCreation/"+merchantObjId+"/",
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


