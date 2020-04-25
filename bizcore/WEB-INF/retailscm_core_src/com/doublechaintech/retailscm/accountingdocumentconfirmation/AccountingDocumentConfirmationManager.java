
package com.doublechaintech.retailscm.accountingdocumentconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface AccountingDocumentConfirmationManager extends BaseManager{

		

	public AccountingDocumentConfirmation createAccountingDocumentConfirmation(RetailscmUserContext userContext, String who,String comments,Date makeDate) throws Exception;
	public AccountingDocumentConfirmation updateAccountingDocumentConfirmation(RetailscmUserContext userContext,String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentConfirmation loadAccountingDocumentConfirmation(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String [] tokensExpr) throws Exception;
	public AccountingDocumentConfirmation internalSaveAccountingDocumentConfirmation(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation) throws Exception;
	public AccountingDocumentConfirmation internalSaveAccountingDocumentConfirmation(RetailscmUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String accountingDocumentConfirmationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingDocumentManager getAccountingDocumentManager(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String auditingId, String postingId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocumentConfirmation addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String auditingId, String postingId , String [] tokensExpr)  throws Exception;
	public  AccountingDocumentConfirmation removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentConfirmation updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


