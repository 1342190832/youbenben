
package com.youbenben.youbenben.originalvoucher;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.originalvouchercreation.OriginalVoucherCreation;
import com.youbenben.youbenben.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.youbenben.youbenben.originalvoucherauditing.OriginalVoucherAuditing;
import com.youbenben.youbenben.accountingdocument.AccountingDocument;

import com.youbenben.youbenben.originalvouchercreation.OriginalVoucherCreationDAO;
import com.youbenben.youbenben.originalvoucherconfirmation.OriginalVoucherConfirmationDAO;
import com.youbenben.youbenben.originalvoucherauditing.OriginalVoucherAuditingDAO;
import com.youbenben.youbenben.accountingdocument.AccountingDocumentDAO;


public interface OriginalVoucherDAO extends BaseDAO{

	public SmartList<OriginalVoucher> loadAll();
	public OriginalVoucher load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<OriginalVoucher> originalVoucherList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public OriginalVoucher present(OriginalVoucher originalVoucher,Map<String,Object> options) throws Exception;
	public OriginalVoucher clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OriginalVoucher save(OriginalVoucher originalVoucher,Map<String,Object> options);
	public SmartList<OriginalVoucher> saveOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options);
	public SmartList<OriginalVoucher> removeOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options);
	public SmartList<OriginalVoucher> findOriginalVoucherWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countOriginalVoucherWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countOriginalVoucherWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String originalVoucherId, int version) throws Exception;
	public OriginalVoucher disconnectFromAll(String originalVoucherId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<OriginalVoucher> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateOriginalVoucher executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<OriginalVoucher> findOriginalVoucherByBelongsTo(String accountingDocumentId, Map<String,Object> options);
 	public int countOriginalVoucherByBelongsTo(String accountingDocumentId, Map<String,Object> options);
 	public Map<String, Integer> countOriginalVoucherByBelongsToIds(String[] ids, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByBelongsTo(String accountingDocumentId, int start, int count, Map<String,Object> options);
 	public void analyzeOriginalVoucherByBelongsTo(SmartList<OriginalVoucher> resultList, String accountingDocumentId, Map<String,Object> options);

 
  
 	public SmartList<OriginalVoucher> findOriginalVoucherByCreation(String originalVoucherCreationId, Map<String,Object> options);
 	public int countOriginalVoucherByCreation(String originalVoucherCreationId, Map<String,Object> options);
 	public Map<String, Integer> countOriginalVoucherByCreationIds(String[] ids, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByCreation(String originalVoucherCreationId, int start, int count, Map<String,Object> options);
 	public void analyzeOriginalVoucherByCreation(SmartList<OriginalVoucher> resultList, String originalVoucherCreationId, Map<String,Object> options);

 
  
 	public SmartList<OriginalVoucher> findOriginalVoucherByConfirmation(String originalVoucherConfirmationId, Map<String,Object> options);
 	public int countOriginalVoucherByConfirmation(String originalVoucherConfirmationId, Map<String,Object> options);
 	public Map<String, Integer> countOriginalVoucherByConfirmationIds(String[] ids, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByConfirmation(String originalVoucherConfirmationId, int start, int count, Map<String,Object> options);
 	public void analyzeOriginalVoucherByConfirmation(SmartList<OriginalVoucher> resultList, String originalVoucherConfirmationId, Map<String,Object> options);

 
  
 	public SmartList<OriginalVoucher> findOriginalVoucherByAuditing(String originalVoucherAuditingId, Map<String,Object> options);
 	public int countOriginalVoucherByAuditing(String originalVoucherAuditingId, Map<String,Object> options);
 	public Map<String, Integer> countOriginalVoucherByAuditingIds(String[] ids, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByAuditing(String originalVoucherAuditingId, int start, int count, Map<String,Object> options);
 	public void analyzeOriginalVoucherByAuditing(SmartList<OriginalVoucher> resultList, String originalVoucherAuditingId, Map<String,Object> options);

 
 
}


