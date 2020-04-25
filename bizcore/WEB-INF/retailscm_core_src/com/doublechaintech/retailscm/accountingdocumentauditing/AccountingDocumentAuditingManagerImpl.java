
package com.doublechaintech.retailscm.accountingdocumentauditing;

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






public class AccountingDocumentAuditingManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentAuditingManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = AccountingDocumentAuditingTokens.start().withTokenFromListName(listName).done();
		AccountingDocumentAuditing  accountingDocumentAuditing = (AccountingDocumentAuditing) this.loadAccountingDocumentAuditing(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = accountingDocumentAuditing.collectRefercencesFromLists();
		accountingDocumentAuditingDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, accountingDocumentAuditing, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new AccountingDocumentAuditingGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "AccountingDocumentAuditing";
	@Override
	public AccountingDocumentAuditingDAO daoOf(RetailscmUserContext userContext) {
		return accountingDocumentAuditingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws AccountingDocumentAuditingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentAuditingManagerException(message);

	}



 	protected AccountingDocumentAuditing saveAccountingDocumentAuditing(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentAuditingDAO().save(accountingDocumentAuditing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens);
 	}
 	
 	protected AccountingDocumentAuditing saveAccountingDocumentAuditingDetail(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing) throws Exception{	

 		
 		return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, allTokens());
 	}
 	
 	public AccountingDocumentAuditing loadAccountingDocumentAuditing(RetailscmUserContext userContext, String accountingDocumentAuditingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentAuditingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing( userContext, accountingDocumentAuditingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentAuditing, tokens);
 	}
 	
 	
 	 public AccountingDocumentAuditing searchAccountingDocumentAuditing(RetailscmUserContext userContext, String accountingDocumentAuditingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentAuditingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing( userContext, accountingDocumentAuditingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentAuditing, tokens);
 	}
 	
 	

 	protected AccountingDocumentAuditing present(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentAuditing,tokens);
		
		
		AccountingDocumentAuditing  accountingDocumentAuditingToPresent = accountingDocumentAuditingDaoOf(userContext).present(accountingDocumentAuditing, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentAuditingToPresent.collectRefercencesFromLists();
		accountingDocumentAuditingDaoOf(userContext).alias(entityListToNaming);
		
		return  accountingDocumentAuditingToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocumentAuditing loadAccountingDocumentAuditingDetail(RetailscmUserContext userContext, String accountingDocumentAuditingId) throws Exception{	
 		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing( userContext, accountingDocumentAuditingId, allTokens());
 		return present(userContext,accountingDocumentAuditing, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingDocumentAuditingId) throws Exception{	
 		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing( userContext, accountingDocumentAuditingId, viewTokens());
 		return present(userContext,accountingDocumentAuditing, allTokens());
		
 	}
 	protected AccountingDocumentAuditing saveAccountingDocumentAuditing(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object>tokens) throws Exception{	
 		return accountingDocumentAuditingDaoOf(userContext).save(accountingDocumentAuditing, tokens);
 	}
 	protected AccountingDocumentAuditing loadAccountingDocumentAuditing(RetailscmUserContext userContext, String accountingDocumentAuditingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentAuditingManagerException.class);

 
 		return accountingDocumentAuditingDaoOf(userContext).load(accountingDocumentAuditingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentAuditing, tokens);
		
		addAction(userContext, accountingDocumentAuditing, tokens,"@create","createAccountingDocumentAuditing","createAccountingDocumentAuditing/","main","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"@update","updateAccountingDocumentAuditing","updateAccountingDocumentAuditing/"+accountingDocumentAuditing.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"@copy","cloneAccountingDocumentAuditing","cloneAccountingDocumentAuditing/"+accountingDocumentAuditing.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.addAccountingDocument","addAccountingDocument","addAccountingDocument/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.removeAccountingDocument","removeAccountingDocument","removeAccountingDocument/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.updateAccountingDocument","updateAccountingDocument","updateAccountingDocument/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
		addAction(userContext, accountingDocumentAuditing, tokens,"accounting_document_auditing.copyAccountingDocumentFrom","copyAccountingDocumentFrom","copyAccountingDocumentFrom/"+accountingDocumentAuditing.getId()+"/","accountingDocumentList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public AccountingDocumentAuditing createAccountingDocumentAuditing(RetailscmUserContext userContext, String who,String comments,Date makeDate) throws Exception
	//public AccountingDocumentAuditing createAccountingDocumentAuditing(RetailscmUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfAccountingDocumentAuditing(who);
		checkerOf(userContext).checkCommentsOfAccountingDocumentAuditing(comments);
		checkerOf(userContext).checkMakeDateOfAccountingDocumentAuditing(makeDate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);


		AccountingDocumentAuditing accountingDocumentAuditing=createNewAccountingDocumentAuditing();	

		accountingDocumentAuditing.setWho(who);
		accountingDocumentAuditing.setComments(comments);
		accountingDocumentAuditing.setMakeDate(makeDate);

		accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocumentAuditing);
		return accountingDocumentAuditing;


	}
	protected AccountingDocumentAuditing createNewAccountingDocumentAuditing()
	{

		return new AccountingDocumentAuditing();
	}

	protected void checkParamsForUpdatingAccountingDocumentAuditing(RetailscmUserContext userContext,String accountingDocumentAuditingId, int accountingDocumentAuditingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		checkerOf(userContext).checkVersionOfAccountingDocumentAuditing( accountingDocumentAuditingVersion);
		

		if(AccountingDocumentAuditing.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfAccountingDocumentAuditing(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentAuditing.COMMENTS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentsOfAccountingDocumentAuditing(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentAuditing.MAKE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMakeDateOfAccountingDocumentAuditing(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);


	}



	public AccountingDocumentAuditing clone(RetailscmUserContext userContext, String fromAccountingDocumentAuditingId) throws Exception{

		return accountingDocumentAuditingDaoOf(userContext).clone(fromAccountingDocumentAuditingId, this.allTokens());
	}

	public AccountingDocumentAuditing internalSaveAccountingDocumentAuditing(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing) throws Exception
	{
		return internalSaveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, allTokens());

	}
	public AccountingDocumentAuditing internalSaveAccountingDocumentAuditing(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion, property, newValueExpr, tokensExpr);


		synchronized(accountingDocumentAuditing){
			//will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentAuditing.
			if (accountingDocumentAuditing.isChanged()){
			
			}
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, options);
			return accountingDocumentAuditing;

		}

	}

	public AccountingDocumentAuditing updateAccountingDocumentAuditing(RetailscmUserContext userContext,String accountingDocumentAuditingId, int accountingDocumentAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion, property, newValueExpr, tokensExpr);



		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		if(accountingDocumentAuditing.getVersion() != accountingDocumentAuditingVersion){
			String message = "The target version("+accountingDocumentAuditing.getVersion()+") is not equals to version("+accountingDocumentAuditingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentAuditing){
			//will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentAuditing.
			
			accountingDocumentAuditing.changeProperty(property, newValueExpr);
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().done());
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().done());
		}

	}

	public AccountingDocumentAuditing updateAccountingDocumentAuditingProperty(RetailscmUserContext userContext,String accountingDocumentAuditingId, int accountingDocumentAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion, property, newValueExpr, tokensExpr);

		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		if(accountingDocumentAuditing.getVersion() != accountingDocumentAuditingVersion){
			String message = "The target version("+accountingDocumentAuditing.getVersion()+") is not equals to version("+accountingDocumentAuditingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentAuditing){
			//will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentAuditing.

			accountingDocumentAuditing.changeProperty(property, newValueExpr);
			
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().done());
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected AccountingDocumentAuditingTokens tokens(){
		return AccountingDocumentAuditingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentAuditingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAccountingDocumentListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentAuditingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentAuditingId, int accountingDocumentAuditingVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentAuditingId, int accountingDocumentAuditingVersion) throws Exception{

		accountingDocumentAuditingDaoOf(userContext).delete(accountingDocumentAuditingId, accountingDocumentAuditingVersion);
	}

	public AccountingDocumentAuditing forgetByAll(RetailscmUserContext userContext, String accountingDocumentAuditingId, int accountingDocumentAuditingVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentAuditingId, accountingDocumentAuditingVersion);
	}
	protected AccountingDocumentAuditing forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentAuditingId, int accountingDocumentAuditingVersion) throws Exception{

		return accountingDocumentAuditingDaoOf(userContext).disconnectFromAll(accountingDocumentAuditingId, accountingDocumentAuditingVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentAuditingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return accountingDocumentAuditingDaoOf(userContext).deleteAll();
	}


	//disconnect AccountingDocumentAuditing with accounting_period in AccountingDocument
	protected AccountingDocumentAuditing breakWithAccountingDocumentByAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentAuditingId, String accountingPeriodId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());

			synchronized(accountingDocumentAuditing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentAuditingDaoOf(userContext).planToRemoveAccountingDocumentListWithAccountingPeriod(accountingDocumentAuditing, accountingPeriodId, this.emptyOptions());

				accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
				return accountingDocumentAuditing;
			}
	}
	//disconnect AccountingDocumentAuditing with document_type in AccountingDocument
	protected AccountingDocumentAuditing breakWithAccountingDocumentByDocumentType(RetailscmUserContext userContext, String accountingDocumentAuditingId, String documentTypeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());

			synchronized(accountingDocumentAuditing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentAuditingDaoOf(userContext).planToRemoveAccountingDocumentListWithDocumentType(accountingDocumentAuditing, documentTypeId, this.emptyOptions());

				accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
				return accountingDocumentAuditing;
			}
	}
	//disconnect AccountingDocumentAuditing with creation in AccountingDocument
	protected AccountingDocumentAuditing breakWithAccountingDocumentByCreation(RetailscmUserContext userContext, String accountingDocumentAuditingId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());

			synchronized(accountingDocumentAuditing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentAuditingDaoOf(userContext).planToRemoveAccountingDocumentListWithCreation(accountingDocumentAuditing, creationId, this.emptyOptions());

				accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
				return accountingDocumentAuditing;
			}
	}
	//disconnect AccountingDocumentAuditing with confirmation in AccountingDocument
	protected AccountingDocumentAuditing breakWithAccountingDocumentByConfirmation(RetailscmUserContext userContext, String accountingDocumentAuditingId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());

			synchronized(accountingDocumentAuditing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentAuditingDaoOf(userContext).planToRemoveAccountingDocumentListWithConfirmation(accountingDocumentAuditing, confirmationId, this.emptyOptions());

				accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
				return accountingDocumentAuditing;
			}
	}
	//disconnect AccountingDocumentAuditing with posting in AccountingDocument
	protected AccountingDocumentAuditing breakWithAccountingDocumentByPosting(RetailscmUserContext userContext, String accountingDocumentAuditingId, String postingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());

			synchronized(accountingDocumentAuditing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				accountingDocumentAuditingDaoOf(userContext).planToRemoveAccountingDocumentListWithPosting(accountingDocumentAuditing, postingId, this.emptyOptions());

				accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
				return accountingDocumentAuditing;
			}
	}






	protected void checkParamsForAddingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String postingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);

		
		checkerOf(userContext).checkNameOfAccountingDocument(name);
		
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);
		
		checkerOf(userContext).checkAccountingPeriodIdOfAccountingDocument(accountingPeriodId);
		
		checkerOf(userContext).checkDocumentTypeIdOfAccountingDocument(documentTypeId);
		
		checkerOf(userContext).checkCreationIdOfAccountingDocument(creationId);
		
		checkerOf(userContext).checkConfirmationIdOfAccountingDocument(confirmationId);
		
		checkerOf(userContext).checkPostingIdOfAccountingDocument(postingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);


	}
	public  AccountingDocumentAuditing addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String postingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountingDocument(userContext,accountingDocumentAuditingId,name, accountingDocumentDate, accountingPeriodId, documentTypeId, creationId, confirmationId, postingId,tokensExpr);

		AccountingDocument accountingDocument = createAccountingDocument(userContext,name, accountingDocumentDate, accountingPeriodId, documentTypeId, creationId, confirmationId, postingId);

		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, emptyOptions());
		synchronized(accountingDocumentAuditing){
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentAuditing.addAccountingDocument( accountingDocument );
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, accountingDocument);
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentAuditingId,String id,String name,Date accountingDocumentDate,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		checkerOf(userContext).checkIdOfAccountingDocument(id);

		checkerOf(userContext).checkNameOfAccountingDocument( name);
		checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument( accountingDocumentDate);

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);

	}
	public  AccountingDocumentAuditing updateAccountingDocumentProperties(RetailscmUserContext userContext, String accountingDocumentAuditingId, String id,String name,Date accountingDocumentDate, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentProperties(userContext,accountingDocumentAuditingId,id,name,accountingDocumentDate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountingDocumentListList()
				.searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "is", id).done();

		AccountingDocumentAuditing accountingDocumentAuditingToUpdate = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, options);

		if(accountingDocumentAuditingToUpdate.getAccountingDocumentList().isEmpty()){
			throw new AccountingDocumentAuditingManagerException("AccountingDocument is NOT FOUND with id: '"+id+"'");
		}

		AccountingDocument item = accountingDocumentAuditingToUpdate.getAccountingDocumentList().first();

		item.updateName( name );
		item.updateAccountingDocumentDate( accountingDocumentDate );


		//checkParamsForAddingAccountingDocument(userContext,accountingDocumentAuditingId,name, code, used,tokensExpr);
		AccountingDocumentAuditing accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditingToUpdate, tokens().withAccountingDocumentList().done());
		synchronized(accountingDocumentAuditing){
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountingDocument createAccountingDocument(RetailscmUserContext userContext, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String postingId) throws Exception{

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

	protected void checkParamsForRemovingAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentAuditingId,
			String accountingDocumentIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		for(String accountingDocumentIdItem: accountingDocumentIds){
			checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);

	}
	public  AccountingDocumentAuditing removeAccountingDocumentList(RetailscmUserContext userContext, String accountingDocumentAuditingId,
			String accountingDocumentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountingDocumentList(userContext, accountingDocumentAuditingId,  accountingDocumentIds, tokensExpr);


			AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
			synchronized(accountingDocumentAuditing){
				//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				accountingDocumentAuditingDaoOf(userContext).planToRemoveAccountingDocumentList(accountingDocumentAuditing, accountingDocumentIds, allTokens());
				accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
				deleteRelationListInGraph(userContext, accountingDocumentAuditing.getAccountingDocumentList());
				return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocumentAuditing( accountingDocumentAuditingId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);

	}
	public  AccountingDocumentAuditing removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountingDocument(userContext,accountingDocumentAuditingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);

		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		synchronized(accountingDocumentAuditing){
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			accountingDocumentAuditing.removeAccountingDocument( accountingDocument );
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			deleteRelationInGraph(userContext, accountingDocument);
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfAccountingDocumentAuditing( accountingDocumentAuditingId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);

	}
	public  AccountingDocumentAuditing copyAccountingDocumentFrom(RetailscmUserContext userContext, String accountingDocumentAuditingId,
		String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountingDocument(userContext,accountingDocumentAuditingId, accountingDocumentId, accountingDocumentVersion,tokensExpr);

		AccountingDocument accountingDocument = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, allTokens());
		synchronized(accountingDocumentAuditing){
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			accountingDocumentAuditing.copyAccountingDocumentFrom( accountingDocument );
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			
			userContext.getManagerGroup().getAccountingDocumentManager().onNewInstanceCreated(userContext, (AccountingDocument)accountingDocumentAuditing.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfAccountingDocumentAuditing(accountingDocumentAuditingId);
		checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
		checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);
		

		if(AccountingDocument.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocument(parseString(newValueExpr));
		
		}
		
		if(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentAuditingManagerException.class);

	}

	public  AccountingDocumentAuditing updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountingDocument(userContext, accountingDocumentAuditingId, accountingDocumentId, accountingDocumentVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountingDocumentList().searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, "eq", accountingDocumentId).done();



		AccountingDocumentAuditing accountingDocumentAuditing = loadAccountingDocumentAuditing(userContext, accountingDocumentAuditingId, loadTokens);

		synchronized(accountingDocumentAuditing){
			//Will be good when the accountingDocumentAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//accountingDocumentAuditing.removeAccountingDocument( accountingDocument );
			//make changes to AcceleraterAccount.
			AccountingDocument accountingDocumentIndex = createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);

			AccountingDocument accountingDocument = accountingDocumentAuditing.findTheAccountingDocument(accountingDocumentIndex);
			if(accountingDocument == null){
				throw new AccountingDocumentAuditingManagerException(accountingDocument+" is NOT FOUND" );
			}

			accountingDocument.changeProperty(property, newValueExpr);
			
			accountingDocumentAuditing = saveAccountingDocumentAuditing(userContext, accountingDocumentAuditing, tokens().withAccountingDocumentList().done());
			return present(userContext,accountingDocumentAuditing, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentAuditing newCreated) throws Exception{
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
		//   AccountingDocumentAuditing newAccountingDocumentAuditing = this.createAccountingDocumentAuditing(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newAccountingDocumentAuditing
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, AccountingDocumentAuditing.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<AccountingDocumentAuditing> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String accountingDocumentAuditingId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getAccountingDocumentAuditingDetailScope().clone();
		AccountingDocumentAuditing merchantObj = (AccountingDocumentAuditing) this.view(userContext, accountingDocumentAuditingId);
    String merchantObjId = accountingDocumentAuditingId;
    String linkToUrl =	"accountingDocumentAuditingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会计凭证的审核"+"详情";
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
		    "accountingDocumentManager/listByAuditing/"+merchantObjId+"/",
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


