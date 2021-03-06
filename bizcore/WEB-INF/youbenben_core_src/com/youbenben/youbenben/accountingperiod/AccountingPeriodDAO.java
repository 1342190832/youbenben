
package com.youbenben.youbenben.accountingperiod;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.accountingdocument.AccountingDocument;
import com.youbenben.youbenben.accountset.AccountSet;

import com.youbenben.youbenben.accountset.AccountSetDAO;
import com.youbenben.youbenben.accountingdocument.AccountingDocumentDAO;


public interface AccountingPeriodDAO extends BaseDAO{

	public SmartList<AccountingPeriod> loadAll();
	public AccountingPeriod load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingPeriod> accountingPeriodList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountingPeriod present(AccountingPeriod accountingPeriod,Map<String,Object> options) throws Exception;
	public AccountingPeriod clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingPeriod save(AccountingPeriod accountingPeriod,Map<String,Object> options);
	public SmartList<AccountingPeriod> saveAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList,Map<String,Object> options);
	public SmartList<AccountingPeriod> removeAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList,Map<String,Object> options);
	public SmartList<AccountingPeriod> findAccountingPeriodWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingPeriodWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingPeriodWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingPeriodId, int version) throws Exception;
	public AccountingPeriod disconnectFromAll(String accountingPeriodId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingDocumentDAO getAccountingDocumentDAO();
		
	
 	public SmartList<AccountingPeriod> requestCandidateAccountingPeriodForAccountingDocument(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingPeriod planToRemoveAccountingDocumentList(AccountingPeriod accountingPeriod, String accountingDocumentIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingPeriod with document_type in AccountingDocument
	public AccountingPeriod planToRemoveAccountingDocumentListWithDocumentType(AccountingPeriod accountingPeriod, String documentTypeId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithDocumentType(String accountingPeriodId, String documentTypeId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingPeriod with creation in AccountingDocument
	public AccountingPeriod planToRemoveAccountingDocumentListWithCreation(AccountingPeriod accountingPeriod, String creationId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithCreation(String accountingPeriodId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingPeriod with confirmation in AccountingDocument
	public AccountingPeriod planToRemoveAccountingDocumentListWithConfirmation(AccountingPeriod accountingPeriod, String confirmationId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithConfirmation(String accountingPeriodId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingPeriod with auditing in AccountingDocument
	public AccountingPeriod planToRemoveAccountingDocumentListWithAuditing(AccountingPeriod accountingPeriod, String auditingId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAuditing(String accountingPeriodId, String auditingId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingPeriod with posting in AccountingDocument
	public AccountingPeriod planToRemoveAccountingDocumentListWithPosting(AccountingPeriod accountingPeriod, String postingId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithPosting(String accountingPeriodId, String postingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<AccountingPeriod> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateAccountingPeriod executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<AccountingPeriod> findAccountingPeriodByAccountSet(String accountSetId, Map<String,Object> options);
 	public int countAccountingPeriodByAccountSet(String accountSetId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingPeriodByAccountSetIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingPeriod> findAccountingPeriodByAccountSet(String accountSetId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingPeriodByAccountSet(SmartList<AccountingPeriod> resultList, String accountSetId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:AccountingDocument的accountingPeriod的AccountingDocumentList
	public SmartList<AccountingDocument> loadOurAccountingDocumentList(YoubenbenUserContext userContext, List<AccountingPeriod> us, Map<String,Object> options) throws Exception;
	
}


