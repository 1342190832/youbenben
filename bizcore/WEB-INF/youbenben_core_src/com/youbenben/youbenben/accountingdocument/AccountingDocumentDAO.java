
package com.youbenben.youbenben.accountingdocument;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.accountingdocumentposting.AccountingDocumentPosting;
import com.youbenben.youbenben.accountingdocumenttype.AccountingDocumentType;
import com.youbenben.youbenben.originalvoucher.OriginalVoucher;
import com.youbenben.youbenben.accountingdocumentauditing.AccountingDocumentAuditing;
import com.youbenben.youbenben.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.youbenben.youbenben.accountingdocumentcreation.AccountingDocumentCreation;
import com.youbenben.youbenben.accountingperiod.AccountingPeriod;
import com.youbenben.youbenben.accountingdocumentline.AccountingDocumentLine;

import com.youbenben.youbenben.accountingdocumentauditing.AccountingDocumentAuditingDAO;
import com.youbenben.youbenben.accountingdocumentposting.AccountingDocumentPostingDAO;
import com.youbenben.youbenben.accountingdocumenttype.AccountingDocumentTypeDAO;
import com.youbenben.youbenben.accountingdocumentconfirmation.AccountingDocumentConfirmationDAO;
import com.youbenben.youbenben.accountingperiod.AccountingPeriodDAO;
import com.youbenben.youbenben.originalvoucher.OriginalVoucherDAO;
import com.youbenben.youbenben.accountingdocumentline.AccountingDocumentLineDAO;
import com.youbenben.youbenben.accountingdocumentcreation.AccountingDocumentCreationDAO;


public interface AccountingDocumentDAO extends BaseDAO{

	public SmartList<AccountingDocument> loadAll();
	public AccountingDocument load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingDocument> accountingDocumentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountingDocument present(AccountingDocument accountingDocument,Map<String,Object> options) throws Exception;
	public AccountingDocument clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocument save(AccountingDocument accountingDocument,Map<String,Object> options);
	public SmartList<AccountingDocument> saveAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options);
	public SmartList<AccountingDocument> removeAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options);
	public SmartList<AccountingDocument> findAccountingDocumentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingDocumentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingDocumentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingDocumentId, int version) throws Exception;
	public AccountingDocument disconnectFromAll(String accountingDocumentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public OriginalVoucherDAO getOriginalVoucherDAO();
		
	public AccountingDocumentLineDAO getAccountingDocumentLineDAO();
		
	
 	public SmartList<AccountingDocument> requestCandidateAccountingDocumentForOriginalVoucher(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<AccountingDocument> requestCandidateAccountingDocumentForAccountingDocumentLine(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingDocument planToRemoveOriginalVoucherList(AccountingDocument accountingDocument, String originalVoucherIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingDocument with creation in OriginalVoucher
	public AccountingDocument planToRemoveOriginalVoucherListWithCreation(AccountingDocument accountingDocument, String creationId, Map<String,Object> options)throws Exception;
	public int countOriginalVoucherListWithCreation(String accountingDocumentId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocument with confirmation in OriginalVoucher
	public AccountingDocument planToRemoveOriginalVoucherListWithConfirmation(AccountingDocument accountingDocument, String confirmationId, Map<String,Object> options)throws Exception;
	public int countOriginalVoucherListWithConfirmation(String accountingDocumentId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocument with auditing in OriginalVoucher
	public AccountingDocument planToRemoveOriginalVoucherListWithAuditing(AccountingDocument accountingDocument, String auditingId, Map<String,Object> options)throws Exception;
	public int countOriginalVoucherListWithAuditing(String accountingDocumentId, String auditingId, Map<String,Object> options)throws Exception;
	
	public AccountingDocument planToRemoveAccountingDocumentLineList(AccountingDocument accountingDocument, String accountingDocumentLineIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingDocument with accounting_subject in AccountingDocumentLine
	public AccountingDocument planToRemoveAccountingDocumentLineListWithAccountingSubject(AccountingDocument accountingDocument, String accountingSubjectId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentLineListWithAccountingSubject(String accountingDocumentId, String accountingSubjectId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<AccountingDocument> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateAccountingDocument executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<AccountingDocument> findAccountingDocumentByAccountingPeriod(String accountingPeriodId, Map<String,Object> options);
 	public int countAccountingDocumentByAccountingPeriod(String accountingPeriodId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingDocumentByAccountingPeriodIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByAccountingPeriod(String accountingPeriodId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingDocumentByAccountingPeriod(SmartList<AccountingDocument> resultList, String accountingPeriodId, Map<String,Object> options);

 
  
 	public SmartList<AccountingDocument> findAccountingDocumentByDocumentType(String accountingDocumentTypeId, Map<String,Object> options);
 	public int countAccountingDocumentByDocumentType(String accountingDocumentTypeId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingDocumentByDocumentTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByDocumentType(String accountingDocumentTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingDocumentByDocumentType(SmartList<AccountingDocument> resultList, String accountingDocumentTypeId, Map<String,Object> options);

 
  
 	public SmartList<AccountingDocument> findAccountingDocumentByCreation(String accountingDocumentCreationId, Map<String,Object> options);
 	public int countAccountingDocumentByCreation(String accountingDocumentCreationId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingDocumentByCreationIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByCreation(String accountingDocumentCreationId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingDocumentByCreation(SmartList<AccountingDocument> resultList, String accountingDocumentCreationId, Map<String,Object> options);

 
  
 	public SmartList<AccountingDocument> findAccountingDocumentByConfirmation(String accountingDocumentConfirmationId, Map<String,Object> options);
 	public int countAccountingDocumentByConfirmation(String accountingDocumentConfirmationId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingDocumentByConfirmationIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByConfirmation(String accountingDocumentConfirmationId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingDocumentByConfirmation(SmartList<AccountingDocument> resultList, String accountingDocumentConfirmationId, Map<String,Object> options);

 
  
 	public SmartList<AccountingDocument> findAccountingDocumentByAuditing(String accountingDocumentAuditingId, Map<String,Object> options);
 	public int countAccountingDocumentByAuditing(String accountingDocumentAuditingId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingDocumentByAuditingIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByAuditing(String accountingDocumentAuditingId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingDocumentByAuditing(SmartList<AccountingDocument> resultList, String accountingDocumentAuditingId, Map<String,Object> options);

 
  
 	public SmartList<AccountingDocument> findAccountingDocumentByPosting(String accountingDocumentPostingId, Map<String,Object> options);
 	public int countAccountingDocumentByPosting(String accountingDocumentPostingId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingDocumentByPostingIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByPosting(String accountingDocumentPostingId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingDocumentByPosting(SmartList<AccountingDocument> resultList, String accountingDocumentPostingId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:OriginalVoucher的belongsTo的OriginalVoucherList
	public SmartList<OriginalVoucher> loadOurOriginalVoucherList(YoubenbenUserContext userContext, List<AccountingDocument> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:AccountingDocumentLine的belongsTo的AccountingDocumentLineList
	public SmartList<AccountingDocumentLine> loadOurAccountingDocumentLineList(YoubenbenUserContext userContext, List<AccountingDocument> us, Map<String,Object> options) throws Exception;
	
}


