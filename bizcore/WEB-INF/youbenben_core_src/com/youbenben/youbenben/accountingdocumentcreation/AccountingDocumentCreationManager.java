
package com.youbenben.youbenben.accountingdocumentcreation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface AccountingDocumentCreationManager extends BaseManager{

		

	public AccountingDocumentCreation createAccountingDocumentCreation(YoubenbenUserContext userContext, String who,String comments,Date makeDate) throws Exception;
	public AccountingDocumentCreation updateAccountingDocumentCreation(YoubenbenUserContext userContext,String accountingDocumentCreationId, int accountingDocumentCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentCreation loadAccountingDocumentCreation(YoubenbenUserContext userContext, String accountingDocumentCreationId, String [] tokensExpr) throws Exception;
	public AccountingDocumentCreation internalSaveAccountingDocumentCreation(YoubenbenUserContext userContext, AccountingDocumentCreation accountingDocumentCreation) throws Exception;
	public AccountingDocumentCreation internalSaveAccountingDocumentCreation(YoubenbenUserContext userContext, AccountingDocumentCreation accountingDocumentCreation,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String accountingDocumentCreationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, AccountingDocumentCreation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingDocumentManager getAccountingDocumentManager(YoubenbenUserContext userContext, String accountingDocumentCreationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String confirmationId, String auditingId, String postingId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocumentCreation addAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentCreationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String confirmationId, String auditingId, String postingId , String [] tokensExpr)  throws Exception;
	public  AccountingDocumentCreation removeAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentCreation updateAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


