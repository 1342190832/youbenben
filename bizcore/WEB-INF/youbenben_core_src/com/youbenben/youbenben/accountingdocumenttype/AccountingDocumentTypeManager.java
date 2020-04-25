
package com.youbenben.youbenben.accountingdocumenttype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface AccountingDocumentTypeManager extends BaseManager{

		

	public AccountingDocumentType createAccountingDocumentType(YoubenbenUserContext userContext, String name,String description,String accountingPeriodId) throws Exception;
	public AccountingDocumentType updateAccountingDocumentType(YoubenbenUserContext userContext,String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentType loadAccountingDocumentType(YoubenbenUserContext userContext, String accountingDocumentTypeId, String [] tokensExpr) throws Exception;
	public AccountingDocumentType internalSaveAccountingDocumentType(YoubenbenUserContext userContext, AccountingDocumentType accountingDocumentType) throws Exception;
	public AccountingDocumentType internalSaveAccountingDocumentType(YoubenbenUserContext userContext, AccountingDocumentType accountingDocumentType,Map<String,Object>option) throws Exception;

	public AccountingDocumentType transferToAnotherAccountingPeriod(YoubenbenUserContext userContext, String accountingDocumentTypeId, String anotherAccountingPeriodId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String accountingDocumentTypeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, AccountingDocumentType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingDocumentManager getAccountingDocumentManager(YoubenbenUserContext userContext, String accountingDocumentTypeId, String name, Date accountingDocumentDate, String accountingPeriodId, String creationId, String confirmationId, String auditingId, String postingId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocumentType addAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentTypeId, String name, Date accountingDocumentDate, String accountingPeriodId, String creationId, String confirmationId, String auditingId, String postingId , String [] tokensExpr)  throws Exception;
	public  AccountingDocumentType removeAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentTypeId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentType updateAccountingDocument(YoubenbenUserContext userContext, String accountingDocumentTypeId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByAccountingPeriod(YoubenbenUserContext userContext,String accountingPeriodId) throws Exception;
	public Object listPageByAccountingPeriod(YoubenbenUserContext userContext,String accountingPeriodId, int start, int count) throws Exception;
  

}


