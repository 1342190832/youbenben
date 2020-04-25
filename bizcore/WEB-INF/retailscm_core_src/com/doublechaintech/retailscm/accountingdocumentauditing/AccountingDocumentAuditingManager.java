
package com.doublechaintech.retailscm.accountingdocumentauditing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface AccountingDocumentAuditingManager extends BaseManager{

		

	public AccountingDocumentAuditing createAccountingDocumentAuditing(RetailscmUserContext userContext, String who,String comments,Date makeDate) throws Exception;
	public AccountingDocumentAuditing updateAccountingDocumentAuditing(RetailscmUserContext userContext,String accountingDocumentAuditingId, int accountingDocumentAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentAuditing loadAccountingDocumentAuditing(RetailscmUserContext userContext, String accountingDocumentAuditingId, String [] tokensExpr) throws Exception;
	public AccountingDocumentAuditing internalSaveAccountingDocumentAuditing(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing) throws Exception;
	public AccountingDocumentAuditing internalSaveAccountingDocumentAuditing(RetailscmUserContext userContext, AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String accountingDocumentAuditingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentAuditing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingDocumentManager getAccountingDocumentManager(RetailscmUserContext userContext, String accountingDocumentAuditingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String postingId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocumentAuditing addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId, String creationId, String confirmationId, String postingId , String [] tokensExpr)  throws Exception;
	public  AccountingDocumentAuditing removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentAuditing updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentAuditingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


