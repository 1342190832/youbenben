
package com.youbenben.youbenben.accountingdocumenttype;
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


public interface AccountingDocumentTypeDAO extends BaseDAO{

	public SmartList<AccountingDocumentType> loadAll();
	public AccountingDocumentType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingDocumentType> accountingDocumentTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountingDocumentType present(AccountingDocumentType accountingDocumentType,Map<String,Object> options) throws Exception;
	public AccountingDocumentType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentType save(AccountingDocumentType accountingDocumentType,Map<String,Object> options);
	public SmartList<AccountingDocumentType> saveAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList,Map<String,Object> options);
	public SmartList<AccountingDocumentType> removeAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList,Map<String,Object> options);
	public SmartList<AccountingDocumentType> findAccountingDocumentTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingDocumentTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingDocumentTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingDocumentTypeId, int version) throws Exception;
	public AccountingDocumentType disconnectFromAll(String accountingDocumentTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingDocumentDAO getAccountingDocumentDAO();
		
	
 	public SmartList<AccountingDocumentType> requestCandidateAccountingDocumentTypeForAccountingDocument(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingDocumentType planToRemoveAccountingDocumentList(AccountingDocumentType accountingDocumentType, String accountingDocumentIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingDocumentType with accounting_period in AccountingDocument
	public AccountingDocumentType planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentType accountingDocumentType, String accountingPeriodId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentTypeId, String accountingPeriodId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentType with creation in AccountingDocument
	public AccountingDocumentType planToRemoveAccountingDocumentListWithCreation(AccountingDocumentType accountingDocumentType, String creationId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithCreation(String accountingDocumentTypeId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentType with confirmation in AccountingDocument
	public AccountingDocumentType planToRemoveAccountingDocumentListWithConfirmation(AccountingDocumentType accountingDocumentType, String confirmationId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithConfirmation(String accountingDocumentTypeId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentType with auditing in AccountingDocument
	public AccountingDocumentType planToRemoveAccountingDocumentListWithAuditing(AccountingDocumentType accountingDocumentType, String auditingId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAuditing(String accountingDocumentTypeId, String auditingId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentType with posting in AccountingDocument
	public AccountingDocumentType planToRemoveAccountingDocumentListWithPosting(AccountingDocumentType accountingDocumentType, String postingId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithPosting(String accountingDocumentTypeId, String postingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<AccountingDocumentType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateAccountingDocumentType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<AccountingDocumentType> findAccountingDocumentTypeByAccountingPeriod(String accountSetId, Map<String,Object> options);
 	public int countAccountingDocumentTypeByAccountingPeriod(String accountSetId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingDocumentTypeByAccountingPeriodIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingDocumentType> findAccountingDocumentTypeByAccountingPeriod(String accountSetId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingDocumentTypeByAccountingPeriod(SmartList<AccountingDocumentType> resultList, String accountSetId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:AccountingDocument的documentType的AccountingDocumentList
	public SmartList<AccountingDocument> loadOurAccountingDocumentList(YoubenbenUserContext userContext, List<AccountingDocumentType> us, Map<String,Object> options) throws Exception;
	
}


