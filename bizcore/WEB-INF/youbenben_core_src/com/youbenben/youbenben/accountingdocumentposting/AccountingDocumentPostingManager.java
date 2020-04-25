
package com.youbenben.youbenben.accountingdocumentposting;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface AccountingDocumentPostingManager extends BaseManager{

		

	public AccountingDocumentPosting createAccountingDocumentPosting(YoubenbenUserContext userContext, String who,String comments,Date makeDate) throws Exception;
	public AccountingDocumentPosting updateAccountingDocumentPosting(YoubenbenUserContext userContext,String accountingDocumentPostingId, int accountingDocumentPostingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentPosting loadAccountingDocumentPosting(YoubenbenUserContext userContext, String accountingDocumentPostingId, String [] tokensExpr) throws Exception;
	public AccountingDocumentPosting internalSaveAccountingDocumentPosting(YoubenbenUserContext userContext, AccountingDocumentPosting accountingDocumentPosting) throws Exception;
	public AccountingDocumentPosting internalSaveAccountingDocumentPosting(YoubenbenUserContext userContext, AccountingDocumentPosting accountingDocumentPosting,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String accountingDocumentPostingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, AccountingDocumentPosting newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingDocumentManager getAccountingDocumentManager(YoubenbenUserContext userContext, String accountingDocumentPostingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String auditingId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocumentPosting addAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentPostingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String auditingId , String [] tokensExpr)  throws Exception;
	public  AccountingDocumentPosting removeAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentPosting updateAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


