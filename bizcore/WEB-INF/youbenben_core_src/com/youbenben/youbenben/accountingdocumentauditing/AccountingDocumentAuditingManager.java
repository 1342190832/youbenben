
package com.youbenben.youbenben.accountingdocumentauditing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface AccountingDocumentAuditingManager extends BaseManager{

		

	public AccountingDocumentAuditing createAccountingDocumentAuditing(YoubenbenUserContext userContext, String who,String comments,Date makeDate) throws Exception;
	public AccountingDocumentAuditing updateAccountingDocumentAuditing(YoubenbenUserContext userContext,String accountingDocumentAuditingId, int accountingDocumentAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentAuditing loadAccountingDocumentAuditing(YoubenbenUserContext userContext, String accountingDocumentAuditingId, String [] tokensExpr) throws Exception;
	public AccountingDocumentAuditing internalSaveAccountingDocumentAuditing(YoubenbenUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing) throws Exception;
	public AccountingDocumentAuditing internalSaveAccountingDocumentAuditing(YoubenbenUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String accountingDocumentAuditingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, AccountingDocumentAuditing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingDocumentManager getAccountingDocumentManager(YoubenbenUserContext userContext, String accountingDocumentAuditingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String postingId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocumentAuditing addAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentAuditingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String postingId , String [] tokensExpr)  throws Exception;
	public  AccountingDocumentAuditing removeAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentAuditing updateAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


