
package com.youbenben.youbenben.accountingsubject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface AccountingSubjectManager extends BaseManager{

		

	public AccountingSubject createAccountingSubject(YoubenbenUserContext userContext, String accountingSubjectCode,String accountingSubjectName,int accountingSubjectClassCode,String accountingSubjectClassName,String accountSetId) throws Exception;
	public AccountingSubject updateAccountingSubject(YoubenbenUserContext userContext,String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingSubject loadAccountingSubject(YoubenbenUserContext userContext, String accountingSubjectId, String [] tokensExpr) throws Exception;
	public AccountingSubject internalSaveAccountingSubject(YoubenbenUserContext userContext, AccountingSubject accountingSubject) throws Exception;
	public AccountingSubject internalSaveAccountingSubject(YoubenbenUserContext userContext, AccountingSubject accountingSubject,Map<String,Object>option) throws Exception;

	public AccountingSubject transferToAnotherAccountSet(YoubenbenUserContext userContext, String accountingSubjectId, String anotherAccountSetId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String accountingSubjectId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, AccountingSubject newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingDocumentLineManager getAccountingDocumentLineManager(YoubenbenUserContext userContext, String accountingSubjectId, String name, String code, String direct, BigDecimal amount, String belongsToId ,String [] tokensExpr)  throws Exception;

	public  AccountingSubject addAccountingDocumentLine(YoubenbenUserContext userContext, String accountingSubjectId, String name, String code, String direct, BigDecimal amount, String belongsToId , String [] tokensExpr)  throws Exception;
	public  AccountingSubject removeAccountingDocumentLine(YoubenbenUserContext userContext, String accountingSubjectId, String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr)  throws Exception;
	public  AccountingSubject updateAccountingDocumentLine(YoubenbenUserContext userContext, String accountingSubjectId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByAccountSet(YoubenbenUserContext userContext,String accountSetId) throws Exception;
	public Object listPageByAccountSet(YoubenbenUserContext userContext,String accountSetId, int start, int count) throws Exception;
  

}


