
package com.youbenben.youbenben.accountingdocumentconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface AccountingDocumentConfirmationManager extends BaseManager{

		

	public AccountingDocumentConfirmation createAccountingDocumentConfirmation(YoubenbenUserContext userContext, String who,String comments,Date makeDate) throws Exception;
	public AccountingDocumentConfirmation updateAccountingDocumentConfirmation(YoubenbenUserContext userContext,String accountingDocumentConfirmationId, int accountingDocumentConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentConfirmation loadAccountingDocumentConfirmation(YoubenbenUserContext userContext, String accountingDocumentConfirmationId, String [] tokensExpr) throws Exception;
	public AccountingDocumentConfirmation internalSaveAccountingDocumentConfirmation(YoubenbenUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation) throws Exception;
	public AccountingDocumentConfirmation internalSaveAccountingDocumentConfirmation(YoubenbenUserContext userContext, AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String accountingDocumentConfirmationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, AccountingDocumentConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingDocumentManager getAccountingDocumentManager(YoubenbenUserContext userContext, String accountingDocumentConfirmationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String auditingId, String postingId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocumentConfirmation addAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentConfirmationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String auditingId, String postingId , String [] tokensExpr)  throws Exception;
	public  AccountingDocumentConfirmation removeAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentConfirmation updateAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentConfirmationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


