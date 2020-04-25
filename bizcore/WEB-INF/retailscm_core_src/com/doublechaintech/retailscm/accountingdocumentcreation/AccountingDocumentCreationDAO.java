
package com.doublechaintech.retailscm.accountingdocumentcreation;
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


public interface AccountingDocumentCreationDAO extends BaseDAO{

	public SmartList<AccountingDocumentCreation> loadAll();
	public AccountingDocumentCreation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingDocumentCreation> accountingDocumentCreationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountingDocumentCreation present(AccountingDocumentCreation accountingDocumentCreation,Map<String,Object> options) throws Exception;
	public AccountingDocumentCreation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentCreation save(AccountingDocumentCreation accountingDocumentCreation,Map<String,Object> options);
	public SmartList<AccountingDocumentCreation> saveAccountingDocumentCreationList(SmartList<AccountingDocumentCreation> accountingDocumentCreationList,Map<String,Object> options);
	public SmartList<AccountingDocumentCreation> removeAccountingDocumentCreationList(SmartList<AccountingDocumentCreation> accountingDocumentCreationList,Map<String,Object> options);
	public SmartList<AccountingDocumentCreation> findAccountingDocumentCreationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingDocumentCreationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingDocumentCreationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingDocumentCreationId, int version) throws Exception;
	public AccountingDocumentCreation disconnectFromAll(String accountingDocumentCreationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingDocumentDAO getAccountingDocumentDAO();
		
	
 	public SmartList<AccountingDocumentCreation> requestCandidateAccountingDocumentCreationForAccountingDocument(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingDocumentCreation planToRemoveAccountingDocumentList(AccountingDocumentCreation accountingDocumentCreation, String accountingDocumentIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingDocumentCreation with accounting_period in AccountingDocument
	public AccountingDocumentCreation planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentCreation accountingDocumentCreation, String accountingPeriodId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentCreationId, String accountingPeriodId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentCreation with document_type in AccountingDocument
	public AccountingDocumentCreation planToRemoveAccountingDocumentListWithDocumentType(AccountingDocumentCreation accountingDocumentCreation, String documentTypeId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithDocumentType(String accountingDocumentCreationId, String documentTypeId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentCreation with confirmation in AccountingDocument
	public AccountingDocumentCreation planToRemoveAccountingDocumentListWithConfirmation(AccountingDocumentCreation accountingDocumentCreation, String confirmationId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithConfirmation(String accountingDocumentCreationId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentCreation with auditing in AccountingDocument
	public AccountingDocumentCreation planToRemoveAccountingDocumentListWithAuditing(AccountingDocumentCreation accountingDocumentCreation, String auditingId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAuditing(String accountingDocumentCreationId, String auditingId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentCreation with posting in AccountingDocument
	public AccountingDocumentCreation planToRemoveAccountingDocumentListWithPosting(AccountingDocumentCreation accountingDocumentCreation, String postingId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithPosting(String accountingDocumentCreationId, String postingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<AccountingDocumentCreation> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateAccountingDocumentCreation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:AccountingDocument的creation的AccountingDocumentList
	public SmartList<AccountingDocument> loadOurAccountingDocumentList(RetailscmUserContext userContext, List<AccountingDocumentCreation> us, Map<String,Object> options) throws Exception;
	
}


