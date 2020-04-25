
package com.youbenben.youbenben.accountingdocumentconfirmation;
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

import com.youbenben.youbenben.accountingdocument.AccountingDocumentDAO;


public interface AccountingDocumentConfirmationDAO extends BaseDAO{

	public SmartList<AccountingDocumentConfirmation> loadAll();
	public AccountingDocumentConfirmation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountingDocumentConfirmation present(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object> options) throws Exception;
	public AccountingDocumentConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentConfirmation save(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object> options);
	public SmartList<AccountingDocumentConfirmation> saveAccountingDocumentConfirmationList(SmartList<AccountingDocumentConfirmation> accountingDocumentConfirmationList,Map<String,Object> options);
	public SmartList<AccountingDocumentConfirmation> removeAccountingDocumentConfirmationList(SmartList<AccountingDocumentConfirmation> accountingDocumentConfirmationList,Map<String,Object> options);
	public SmartList<AccountingDocumentConfirmation> findAccountingDocumentConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingDocumentConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingDocumentConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingDocumentConfirmationId, int version) throws Exception;
	public AccountingDocumentConfirmation disconnectFromAll(String accountingDocumentConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingDocumentDAO getAccountingDocumentDAO();
		
	
 	public SmartList<AccountingDocumentConfirmation> requestCandidateAccountingDocumentConfirmationForAccountingDocument(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentList(AccountingDocumentConfirmation accountingDocumentConfirmation, String accountingDocumentIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingDocumentConfirmation with accounting_period in AccountingDocument
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentConfirmation accountingDocumentConfirmation, String accountingPeriodId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentConfirmationId, String accountingPeriodId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentConfirmation with document_type in AccountingDocument
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentListWithDocumentType(AccountingDocumentConfirmation accountingDocumentConfirmation, String documentTypeId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithDocumentType(String accountingDocumentConfirmationId, String documentTypeId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentConfirmation with creation in AccountingDocument
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentListWithCreation(AccountingDocumentConfirmation accountingDocumentConfirmation, String creationId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithCreation(String accountingDocumentConfirmationId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentConfirmation with auditing in AccountingDocument
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentListWithAuditing(AccountingDocumentConfirmation accountingDocumentConfirmation, String auditingId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAuditing(String accountingDocumentConfirmationId, String auditingId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentConfirmation with posting in AccountingDocument
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentListWithPosting(AccountingDocumentConfirmation accountingDocumentConfirmation, String postingId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithPosting(String accountingDocumentConfirmationId, String postingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<AccountingDocumentConfirmation> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateAccountingDocumentConfirmation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:AccountingDocument的confirmation的AccountingDocumentList
	public SmartList<AccountingDocument> loadOurAccountingDocumentList(YoubenbenUserContext userContext, List<AccountingDocumentConfirmation> us, Map<String,Object> options) throws Exception;
	
}


