
package com.youbenben.youbenben.accountingsubject;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.accountingdocumentline.AccountingDocumentLine;
import com.youbenben.youbenben.accountset.AccountSet;

import com.youbenben.youbenben.accountset.AccountSetDAO;
import com.youbenben.youbenben.accountingdocumentline.AccountingDocumentLineDAO;


public interface AccountingSubjectDAO extends BaseDAO{

	public SmartList<AccountingSubject> loadAll();
	public AccountingSubject load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingSubject> accountingSubjectList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountingSubject present(AccountingSubject accountingSubject,Map<String,Object> options) throws Exception;
	public AccountingSubject clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingSubject save(AccountingSubject accountingSubject,Map<String,Object> options);
	public SmartList<AccountingSubject> saveAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList,Map<String,Object> options);
	public SmartList<AccountingSubject> removeAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList,Map<String,Object> options);
	public SmartList<AccountingSubject> findAccountingSubjectWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingSubjectWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingSubjectWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingSubjectId, int version) throws Exception;
	public AccountingSubject disconnectFromAll(String accountingSubjectId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingDocumentLineDAO getAccountingDocumentLineDAO();
		
	
 	public SmartList<AccountingSubject> requestCandidateAccountingSubjectForAccountingDocumentLine(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingSubject planToRemoveAccountingDocumentLineList(AccountingSubject accountingSubject, String accountingDocumentLineIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingSubject with belongs_to in AccountingDocumentLine
	public AccountingSubject planToRemoveAccountingDocumentLineListWithBelongsTo(AccountingSubject accountingSubject, String belongsToId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentLineListWithBelongsTo(String accountingSubjectId, String belongsToId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<AccountingSubject> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateAccountingSubject executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<AccountingSubject> findAccountingSubjectByAccountSet(String accountSetId, Map<String,Object> options);
 	public int countAccountingSubjectByAccountSet(String accountSetId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingSubjectByAccountSetIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingSubject> findAccountingSubjectByAccountSet(String accountSetId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingSubjectByAccountSet(SmartList<AccountingSubject> resultList, String accountSetId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:AccountingDocumentLine的accountingSubject的AccountingDocumentLineList
	public SmartList<AccountingDocumentLine> loadOurAccountingDocumentLineList(YoubenbenUserContext userContext, List<AccountingSubject> us, Map<String,Object> options) throws Exception;
	
}


