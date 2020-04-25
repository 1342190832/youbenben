
package com.youbenben.youbenben.originalvouchercreation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.originalvoucher.OriginalVoucher;

import com.youbenben.youbenben.originalvoucher.OriginalVoucherDAO;


public interface OriginalVoucherCreationDAO extends BaseDAO{

	public SmartList<OriginalVoucherCreation> loadAll();
	public OriginalVoucherCreation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<OriginalVoucherCreation> originalVoucherCreationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public OriginalVoucherCreation present(OriginalVoucherCreation originalVoucherCreation,Map<String,Object> options) throws Exception;
	public OriginalVoucherCreation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OriginalVoucherCreation save(OriginalVoucherCreation originalVoucherCreation,Map<String,Object> options);
	public SmartList<OriginalVoucherCreation> saveOriginalVoucherCreationList(SmartList<OriginalVoucherCreation> originalVoucherCreationList,Map<String,Object> options);
	public SmartList<OriginalVoucherCreation> removeOriginalVoucherCreationList(SmartList<OriginalVoucherCreation> originalVoucherCreationList,Map<String,Object> options);
	public SmartList<OriginalVoucherCreation> findOriginalVoucherCreationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countOriginalVoucherCreationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countOriginalVoucherCreationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String originalVoucherCreationId, int version) throws Exception;
	public OriginalVoucherCreation disconnectFromAll(String originalVoucherCreationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public OriginalVoucherDAO getOriginalVoucherDAO();
		
	
 	public SmartList<OriginalVoucherCreation> requestCandidateOriginalVoucherCreationForOriginalVoucher(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public OriginalVoucherCreation planToRemoveOriginalVoucherList(OriginalVoucherCreation originalVoucherCreation, String originalVoucherIds[], Map<String,Object> options)throws Exception;


	//disconnect OriginalVoucherCreation with belongs_to in OriginalVoucher
	public OriginalVoucherCreation planToRemoveOriginalVoucherListWithBelongsTo(OriginalVoucherCreation originalVoucherCreation, String belongsToId, Map<String,Object> options)throws Exception;
	public int countOriginalVoucherListWithBelongsTo(String originalVoucherCreationId, String belongsToId, Map<String,Object> options)throws Exception;
	
	//disconnect OriginalVoucherCreation with confirmation in OriginalVoucher
	public OriginalVoucherCreation planToRemoveOriginalVoucherListWithConfirmation(OriginalVoucherCreation originalVoucherCreation, String confirmationId, Map<String,Object> options)throws Exception;
	public int countOriginalVoucherListWithConfirmation(String originalVoucherCreationId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect OriginalVoucherCreation with auditing in OriginalVoucher
	public OriginalVoucherCreation planToRemoveOriginalVoucherListWithAuditing(OriginalVoucherCreation originalVoucherCreation, String auditingId, Map<String,Object> options)throws Exception;
	public int countOriginalVoucherListWithAuditing(String originalVoucherCreationId, String auditingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<OriginalVoucherCreation> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateOriginalVoucherCreation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:OriginalVoucher的creation的OriginalVoucherList
	public SmartList<OriginalVoucher> loadOurOriginalVoucherList(YoubenbenUserContext userContext, List<OriginalVoucherCreation> us, Map<String,Object> options) throws Exception;
	
}


