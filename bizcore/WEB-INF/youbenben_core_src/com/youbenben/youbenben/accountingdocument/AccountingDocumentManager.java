
package com.youbenben.youbenben.accountingdocument;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface AccountingDocumentManager extends BaseManager{

		

	public AccountingDocument createAccountingDocument(YoubenbenUserContext userContext, String name,Date accountingDocumentDate,String accountingPeriodId,String documentTypeId,String creationId,String confirmationId,String auditingId,String postingId) throws Exception;
	public AccountingDocument updateAccountingDocument(YoubenbenUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocument loadAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentId, String [] tokensExpr) throws Exception;
	public AccountingDocument internalSaveAccountingDocument(YoubenbenUserContext userContext, AccountingDocument accountingDocument) throws Exception;
	public AccountingDocument internalSaveAccountingDocument(YoubenbenUserContext userContext, AccountingDocument accountingDocument,Map<String,Object>option) throws Exception;

	public AccountingDocument transferToAnotherAccountingPeriod(YoubenbenUserContext userContext, String accountingDocumentId, String anotherAccountingPeriodId)  throws Exception;
 	public AccountingDocument transferToAnotherDocumentType(YoubenbenUserContext userContext, String accountingDocumentId, String anotherDocumentTypeId)  throws Exception;
 	public AccountingDocument transferToAnotherCreation(YoubenbenUserContext userContext, String accountingDocumentId, String anotherCreationId)  throws Exception;
 	public AccountingDocument transferToAnotherConfirmation(YoubenbenUserContext userContext, String accountingDocumentId, String anotherConfirmationId)  throws Exception;
 	public AccountingDocument transferToAnotherAuditing(YoubenbenUserContext userContext, String accountingDocumentId, String anotherAuditingId)  throws Exception;
 	public AccountingDocument transferToAnotherPosting(YoubenbenUserContext userContext, String accountingDocumentId, String anotherPostingId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String accountingDocumentId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, AccountingDocument newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  OriginalVoucherManager getOriginalVoucherManager(YoubenbenUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String creationId, String confirmationId, String auditingId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocument addOriginalVoucher(YoubenbenUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String creationId, String confirmationId, String auditingId , String [] tokensExpr)  throws Exception;
	public  AccountingDocument removeOriginalVoucher(YoubenbenUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocument updateOriginalVoucher(YoubenbenUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountingDocumentLineManager getAccountingDocumentLineManager(YoubenbenUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocument addAccountingDocumentLine(YoubenbenUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId , String [] tokensExpr)  throws Exception;
	public  AccountingDocument removeAccountingDocumentLine(YoubenbenUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocument updateAccountingDocumentLine(YoubenbenUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByAccountingPeriod(YoubenbenUserContext userContext,String accountingPeriodId) throws Exception;
	public Object listPageByAccountingPeriod(YoubenbenUserContext userContext,String accountingPeriodId, int start, int count) throws Exception;
  
	public Object listByDocumentType(YoubenbenUserContext userContext,String documentTypeId) throws Exception;
	public Object listPageByDocumentType(YoubenbenUserContext userContext,String documentTypeId, int start, int count) throws Exception;
  
	public Object listByCreation(YoubenbenUserContext userContext,String creationId) throws Exception;
	public Object listPageByCreation(YoubenbenUserContext userContext,String creationId, int start, int count) throws Exception;
  
	public Object listByConfirmation(YoubenbenUserContext userContext,String confirmationId) throws Exception;
	public Object listPageByConfirmation(YoubenbenUserContext userContext,String confirmationId, int start, int count) throws Exception;
  
	public Object listByAuditing(YoubenbenUserContext userContext,String auditingId) throws Exception;
	public Object listPageByAuditing(YoubenbenUserContext userContext,String auditingId, int start, int count) throws Exception;
  
	public Object listByPosting(YoubenbenUserContext userContext,String postingId) throws Exception;
	public Object listPageByPosting(YoubenbenUserContext userContext,String postingId, int start, int count) throws Exception;
  

}


