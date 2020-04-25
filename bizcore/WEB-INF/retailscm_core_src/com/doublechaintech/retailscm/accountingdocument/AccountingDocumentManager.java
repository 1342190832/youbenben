
package com.doublechaintech.retailscm.accountingdocument;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface AccountingDocumentManager extends BaseManager{

		

	public AccountingDocument createAccountingDocument(RetailscmUserContext userContext, String name,Date accountingDocumentDate,String accountingPeriodId,String documentTypeId,String creationId,String confirmationId,String auditingId,String postingId) throws Exception;
	public AccountingDocument updateAccountingDocument(RetailscmUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocument loadAccountingDocument(RetailscmUserContext userContext, String accountingDocumentId, String [] tokensExpr) throws Exception;
	public AccountingDocument internalSaveAccountingDocument(RetailscmUserContext userContext, AccountingDocument accountingDocument) throws Exception;
	public AccountingDocument internalSaveAccountingDocument(RetailscmUserContext userContext, AccountingDocument accountingDocument,Map<String,Object>option) throws Exception;

	public AccountingDocument transferToAnotherAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentId, String anotherAccountingPeriodId)  throws Exception;
 	public AccountingDocument transferToAnotherDocumentType(RetailscmUserContext userContext, String accountingDocumentId, String anotherDocumentTypeId)  throws Exception;
 	public AccountingDocument transferToAnotherCreation(RetailscmUserContext userContext, String accountingDocumentId, String anotherCreationId)  throws Exception;
 	public AccountingDocument transferToAnotherConfirmation(RetailscmUserContext userContext, String accountingDocumentId, String anotherConfirmationId)  throws Exception;
 	public AccountingDocument transferToAnotherAuditing(RetailscmUserContext userContext, String accountingDocumentId, String anotherAuditingId)  throws Exception;
 	public AccountingDocument transferToAnotherPosting(RetailscmUserContext userContext, String accountingDocumentId, String anotherPostingId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String accountingDocumentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocument newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  OriginalVoucherManager getOriginalVoucherManager(RetailscmUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String creationId, String confirmationId, String auditingId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocument addOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String creationId, String confirmationId, String auditingId , String [] tokensExpr)  throws Exception;
	public  AccountingDocument removeOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocument updateOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountingDocumentLineManager getAccountingDocumentLineManager(RetailscmUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocument addAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId , String [] tokensExpr)  throws Exception;
	public  AccountingDocument removeAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocument updateAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByAccountingPeriod(RetailscmUserContext userContext,String accountingPeriodId) throws Exception;
	public Object listPageByAccountingPeriod(RetailscmUserContext userContext,String accountingPeriodId, int start, int count) throws Exception;
  
	public Object listByDocumentType(RetailscmUserContext userContext,String documentTypeId) throws Exception;
	public Object listPageByDocumentType(RetailscmUserContext userContext,String documentTypeId, int start, int count) throws Exception;
  
	public Object listByCreation(RetailscmUserContext userContext,String creationId) throws Exception;
	public Object listPageByCreation(RetailscmUserContext userContext,String creationId, int start, int count) throws Exception;
  
	public Object listByConfirmation(RetailscmUserContext userContext,String confirmationId) throws Exception;
	public Object listPageByConfirmation(RetailscmUserContext userContext,String confirmationId, int start, int count) throws Exception;
  
	public Object listByAuditing(RetailscmUserContext userContext,String auditingId) throws Exception;
	public Object listPageByAuditing(RetailscmUserContext userContext,String auditingId, int start, int count) throws Exception;
  
	public Object listByPosting(RetailscmUserContext userContext,String postingId) throws Exception;
	public Object listPageByPosting(RetailscmUserContext userContext,String postingId, int start, int count) throws Exception;
  

}


