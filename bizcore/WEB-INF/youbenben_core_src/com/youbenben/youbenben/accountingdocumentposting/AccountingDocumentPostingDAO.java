
package com.youbenben.youbenben.accountingdocumentposting;
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


public interface AccountingDocumentPostingDAO extends BaseDAO{

	public SmartList<AccountingDocumentPosting> loadAll();
	public AccountingDocumentPosting load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingDocumentPosting> accountingDocumentPostingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountingDocumentPosting present(AccountingDocumentPosting accountingDocumentPosting,Map<String,Object> options) throws Exception;
	public AccountingDocumentPosting clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentPosting save(AccountingDocumentPosting accountingDocumentPosting,Map<String,Object> options);
	public SmartList<AccountingDocumentPosting> saveAccountingDocumentPostingList(SmartList<AccountingDocumentPosting> accountingDocumentPostingList,Map<String,Object> options);
	public SmartList<AccountingDocumentPosting> removeAccountingDocumentPostingList(SmartList<AccountingDocumentPosting> accountingDocumentPostingList,Map<String,Object> options);
	public SmartList<AccountingDocumentPosting> findAccountingDocumentPostingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingDocumentPostingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingDocumentPostingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingDocumentPostingId, int version) throws Exception;
	public AccountingDocumentPosting disconnectFromAll(String accountingDocumentPostingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingDocumentDAO getAccountingDocumentDAO();
		
	
 	public SmartList<AccountingDocumentPosting> requestCandidateAccountingDocumentPostingForAccountingDocument(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingDocumentPosting planToRemoveAccountingDocumentList(AccountingDocumentPosting accountingDocumentPosting, String accountingDocumentIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingDocumentPosting with accounting_period in AccountingDocument
	public AccountingDocumentPosting planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentPosting accountingDocumentPosting, String accountingPeriodId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentPostingId, String accountingPeriodId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentPosting with document_type in AccountingDocument
	public AccountingDocumentPosting planToRemoveAccountingDocumentListWithDocumentType(AccountingDocumentPosting accountingDocumentPosting, String documentTypeId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithDocumentType(String accountingDocumentPostingId, String documentTypeId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentPosting with creation in AccountingDocument
	public AccountingDocumentPosting planToRemoveAccountingDocumentListWithCreation(AccountingDocumentPosting accountingDocumentPosting, String creationId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithCreation(String accountingDocumentPostingId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentPosting with confirmation in AccountingDocument
	public AccountingDocumentPosting planToRemoveAccountingDocumentListWithConfirmation(AccountingDocumentPosting accountingDocumentPosting, String confirmationId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithConfirmation(String accountingDocumentPostingId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentPosting with auditing in AccountingDocument
	public AccountingDocumentPosting planToRemoveAccountingDocumentListWithAuditing(AccountingDocumentPosting accountingDocumentPosting, String auditingId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAuditing(String accountingDocumentPostingId, String auditingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<AccountingDocumentPosting> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateAccountingDocumentPosting executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:AccountingDocument的posting的AccountingDocumentList
	public SmartList<AccountingDocument> loadOurAccountingDocumentList(YoubenbenUserContext userContext, List<AccountingDocumentPosting> us, Map<String,Object> options) throws Exception;
	
}


