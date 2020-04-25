
package com.youbenben.youbenben.accountset;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface AccountSetManager extends BaseManager{

		

	public AccountSet createAccountSet(YoubenbenUserContext userContext, String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber,String countryCenterId,String retailStoreId,String goodsSupplierId) throws Exception;
	public AccountSet updateAccountSet(YoubenbenUserContext userContext,String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountSet loadAccountSet(YoubenbenUserContext userContext, String accountSetId, String [] tokensExpr) throws Exception;
	public AccountSet internalSaveAccountSet(YoubenbenUserContext userContext, AccountSet accountSet) throws Exception;
	public AccountSet internalSaveAccountSet(YoubenbenUserContext userContext, AccountSet accountSet,Map<String,Object>option) throws Exception;

	public AccountSet transferToAnotherCountryCenter(YoubenbenUserContext userContext, String accountSetId, String anotherCountryCenterId)  throws Exception;
 	public AccountSet transferToAnotherRetailStore(YoubenbenUserContext userContext, String accountSetId, String anotherRetailStoreId)  throws Exception;
 	public AccountSet transferToAnotherGoodsSupplier(YoubenbenUserContext userContext, String accountSetId, String anotherGoodsSupplierId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String accountSetId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, AccountSet newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingSubjectManager getAccountingSubjectManager(YoubenbenUserContext userContext, String accountSetId, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName ,String [] tokensExpr)  throws Exception;

	public  AccountSet addAccountingSubject(YoubenbenUserContext userContext, String accountSetId, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName , String [] tokensExpr)  throws Exception;
	public  AccountSet removeAccountingSubject(YoubenbenUserContext userContext, String accountSetId, String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr)  throws Exception;
	public  AccountSet updateAccountingSubject(YoubenbenUserContext userContext, String accountSetId, String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountingPeriodManager getAccountingPeriodManager(YoubenbenUserContext userContext, String accountSetId, String name, Date startDate, Date endDate ,String [] tokensExpr)  throws Exception;

	public  AccountSet addAccountingPeriod(YoubenbenUserContext userContext, String accountSetId, String name, Date startDate, Date endDate , String [] tokensExpr)  throws Exception;
	public  AccountSet removeAccountingPeriod(YoubenbenUserContext userContext, String accountSetId, String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr)  throws Exception;
	public  AccountSet updateAccountingPeriod(YoubenbenUserContext userContext, String accountSetId, String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountingDocumentTypeManager getAccountingDocumentTypeManager(YoubenbenUserContext userContext, String accountSetId, String name, String description ,String [] tokensExpr)  throws Exception;

	public  AccountSet addAccountingDocumentType(YoubenbenUserContext userContext, String accountSetId, String name, String description , String [] tokensExpr)  throws Exception;
	public  AccountSet removeAccountingDocumentType(YoubenbenUserContext userContext, String accountSetId, String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr)  throws Exception;
	public  AccountSet updateAccountingDocumentType(YoubenbenUserContext userContext, String accountSetId, String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCountryCenter(YoubenbenUserContext userContext,String countryCenterId) throws Exception;
	public Object listPageByCountryCenter(YoubenbenUserContext userContext,String countryCenterId, int start, int count) throws Exception;
  
	public Object listByRetailStore(YoubenbenUserContext userContext,String retailStoreId) throws Exception;
	public Object listPageByRetailStore(YoubenbenUserContext userContext,String retailStoreId, int start, int count) throws Exception;
  
	public Object listByGoodsSupplier(YoubenbenUserContext userContext,String goodsSupplierId) throws Exception;
	public Object listPageByGoodsSupplier(YoubenbenUserContext userContext,String goodsSupplierId, int start, int count) throws Exception;
  

}


