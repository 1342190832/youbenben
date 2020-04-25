
package com.youbenben.youbenben.accountingperiod;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface AccountingPeriodManager extends BaseManager{

		

	public AccountingPeriod createAccountingPeriod(YoubenbenUserContext userContext, String name,Date startDate,Date endDate,String accountSetId) throws Exception;
	public AccountingPeriod updateAccountingPeriod(YoubenbenUserContext userContext,String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingPeriod loadAccountingPeriod(YoubenbenUserContext userContext, String accountingPeriodId, String [] tokensExpr) throws Exception;
	public AccountingPeriod internalSaveAccountingPeriod(YoubenbenUserContext userContext, AccountingPeriod accountingPeriod) throws Exception;
	public AccountingPeriod internalSaveAccountingPeriod(YoubenbenUserContext userContext, AccountingPeriod accountingPeriod,Map<String,Object>option) throws Exception;

	public AccountingPeriod transferToAnotherAccountSet(YoubenbenUserContext userContext, String accountingPeriodId, String anotherAccountSetId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String accountingPeriodId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, AccountingPeriod newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingDocumentManager getAccountingDocumentManager(YoubenbenUserContext userContext, String accountingPeriodId, String name, Date accountingDocumentDate, String documentTypeId, String creationId, String confirmationId, String auditingId, String postingId ,String [] tokensExpr)  throws Exception;

	public  AccountingPeriod addAccountingDocument(YoubenbenUserContext userContext, String accountingPeriodId, String name, Date accountingDocumentDate, String documentTypeId, String creationId, String confirmationId, String auditingId, String postingId , String [] tokensExpr)  throws Exception;
	public  AccountingPeriod removeAccountingDocument(YoubenbenUserContext userContext, String accountingPeriodId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingPeriod updateAccountingDocument(YoubenbenUserContext userContext, String accountingPeriodId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByAccountSet(YoubenbenUserContext userContext,String accountSetId) throws Exception;
	public Object listPageByAccountSet(YoubenbenUserContext userContext,String accountSetId, int start, int count) throws Exception;
  

}


