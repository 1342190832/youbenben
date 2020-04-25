
package com.doublechaintech.retailscm.accountingdocumentauditing;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentDAO;


public interface AccountingDocumentAuditingDAO extends BaseDAO{

	public SmartList<AccountingDocumentAuditing> loadAll();
	public AccountingDocumentAuditing load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingDocumentAuditing> accountingDocumentAuditingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountingDocumentAuditing present(AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object> options) throws Exception;
	public AccountingDocumentAuditing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentAuditing save(AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object> options);
	public SmartList<AccountingDocumentAuditing> saveAccountingDocumentAuditingList(SmartList<AccountingDocumentAuditing> accountingDocumentAuditingList,Map<String,Object> options);
	public SmartList<AccountingDocumentAuditing> removeAccountingDocumentAuditingList(SmartList<AccountingDocumentAuditing> accountingDocumentAuditingList,Map<String,Object> options);
	public SmartList<AccountingDocumentAuditing> findAccountingDocumentAuditingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingDocumentAuditingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingDocumentAuditingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingDocumentAuditingId, int version) throws Exception;
	public AccountingDocumentAuditing disconnectFromAll(String accountingDocumentAuditingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingDocumentDAO getAccountingDocumentDAO();
		
	
 	public SmartList<AccountingDocumentAuditing> requestCandidateAccountingDocumentAuditingForAccountingDocument(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingDocumentAuditing planToRemoveAccountingDocumentList(AccountingDocumentAuditing accountingDocumentAuditing, String accountingDocumentIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingDocumentAuditing with accounting_period in AccountingDocument
	public AccountingDocumentAuditing planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentAuditing accountingDocumentAuditing, String accountingPeriodId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentAuditingId, String accountingPeriodId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentAuditing with document_type in AccountingDocument
	public AccountingDocumentAuditing planToRemoveAccountingDocumentListWithDocumentType(AccountingDocumentAuditing accountingDocumentAuditing, String documentTypeId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithDocumentType(String accountingDocumentAuditingId, String documentTypeId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentAuditing with creation in AccountingDocument
	public AccountingDocumentAuditing planToRemoveAccountingDocumentListWithCreation(AccountingDocumentAuditing accountingDocumentAuditing, String creationId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithCreation(String accountingDocumentAuditingId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentAuditing with confirmation in AccountingDocument
	public AccountingDocumentAuditing planToRemoveAccountingDocumentListWithConfirmation(AccountingDocumentAuditing accountingDocumentAuditing, String confirmationId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithConfirmation(String accountingDocumentAuditingId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentAuditing with posting in AccountingDocument
	public AccountingDocumentAuditing planToRemoveAccountingDocumentListWithPosting(AccountingDocumentAuditing accountingDocumentAuditing, String postingId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithPosting(String accountingDocumentAuditingId, String postingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<AccountingDocumentAuditing> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateAccountingDocumentAuditing executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:AccountingDocument的auditing的AccountingDocumentList
	public SmartList<AccountingDocument> loadOurAccountingDocumentList(RetailscmUserContext userContext, List<AccountingDocumentAuditing> us, Map<String,Object> options) throws Exception;
	
}


