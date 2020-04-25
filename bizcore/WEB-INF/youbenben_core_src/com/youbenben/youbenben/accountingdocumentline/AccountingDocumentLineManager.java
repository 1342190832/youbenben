
package com.youbenben.youbenben.accountingdocumentline;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface AccountingDocumentLineManager extends BaseManager{

		

	public AccountingDocumentLine createAccountingDocumentLine(YoubenbenUserContext userContext, String name,String code,String direct,BigDecimal amount,String belongsToId,String accountingSubjectId) throws Exception;
	public AccountingDocumentLine updateAccountingDocumentLine(YoubenbenUserContext userContext,String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentLine loadAccountingDocumentLine(YoubenbenUserContext userContext, String accountingDocumentLineId, String [] tokensExpr) throws Exception;
	public AccountingDocumentLine internalSaveAccountingDocumentLine(YoubenbenUserContext userContext, AccountingDocumentLine accountingDocumentLine) throws Exception;
	public AccountingDocumentLine internalSaveAccountingDocumentLine(YoubenbenUserContext userContext, AccountingDocumentLine accountingDocumentLine,Map<String,Object>option) throws Exception;

	public AccountingDocumentLine transferToAnotherBelongsTo(YoubenbenUserContext userContext, String accountingDocumentLineId, String anotherBelongsToId)  throws Exception;
 	public AccountingDocumentLine transferToAnotherAccountingSubject(YoubenbenUserContext userContext, String accountingDocumentLineId, String anotherAccountingSubjectId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String accountingDocumentLineId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, AccountingDocumentLine newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception;
  
	public Object listByAccountingSubject(YoubenbenUserContext userContext,String accountingSubjectId) throws Exception;
	public Object listPageByAccountingSubject(YoubenbenUserContext userContext,String accountingSubjectId, int start, int count) throws Exception;
  

}


