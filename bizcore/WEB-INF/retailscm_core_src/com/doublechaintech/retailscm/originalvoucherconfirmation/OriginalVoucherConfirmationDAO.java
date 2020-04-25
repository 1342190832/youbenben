
package com.doublechaintech.retailscm.originalvoucherconfirmation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;

import com.doublechaintech.retailscm.originalvoucher.OriginalVoucherDAO;


public interface OriginalVoucherConfirmationDAO extends BaseDAO{

	public SmartList<OriginalVoucherConfirmation> loadAll();
	public OriginalVoucherConfirmation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<OriginalVoucherConfirmation> originalVoucherConfirmationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public OriginalVoucherConfirmation present(OriginalVoucherConfirmation originalVoucherConfirmation,Map<String,Object> options) throws Exception;
	public OriginalVoucherConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OriginalVoucherConfirmation save(OriginalVoucherConfirmation originalVoucherConfirmation,Map<String,Object> options);
	public SmartList<OriginalVoucherConfirmation> saveOriginalVoucherConfirmationList(SmartList<OriginalVoucherConfirmation> originalVoucherConfirmationList,Map<String,Object> options);
	public SmartList<OriginalVoucherConfirmation> removeOriginalVoucherConfirmationList(SmartList<OriginalVoucherConfirmation> originalVoucherConfirmationList,Map<String,Object> options);
	public SmartList<OriginalVoucherConfirmation> findOriginalVoucherConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countOriginalVoucherConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countOriginalVoucherConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String originalVoucherConfirmationId, int version) throws Exception;
	public OriginalVoucherConfirmation disconnectFromAll(String originalVoucherConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public OriginalVoucherDAO getOriginalVoucherDAO();
		
	
 	public SmartList<OriginalVoucherConfirmation> requestCandidateOriginalVoucherConfirmationForOriginalVoucher(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public OriginalVoucherConfirmation planToRemoveOriginalVoucherList(OriginalVoucherConfirmation originalVoucherConfirmation, String originalVoucherIds[], Map<String,Object> options)throws Exception;


	//disconnect OriginalVoucherConfirmation with belongs_to in OriginalVoucher
	public OriginalVoucherConfirmation planToRemoveOriginalVoucherListWithBelongsTo(OriginalVoucherConfirmation originalVoucherConfirmation, String belongsToId, Map<String,Object> options)throws Exception;
	public int countOriginalVoucherListWithBelongsTo(String originalVoucherConfirmationId, String belongsToId, Map<String,Object> options)throws Exception;
	
	//disconnect OriginalVoucherConfirmation with creation in OriginalVoucher
	public OriginalVoucherConfirmation planToRemoveOriginalVoucherListWithCreation(OriginalVoucherConfirmation originalVoucherConfirmation, String creationId, Map<String,Object> options)throws Exception;
	public int countOriginalVoucherListWithCreation(String originalVoucherConfirmationId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect OriginalVoucherConfirmation with auditing in OriginalVoucher
	public OriginalVoucherConfirmation planToRemoveOriginalVoucherListWithAuditing(OriginalVoucherConfirmation originalVoucherConfirmation, String auditingId, Map<String,Object> options)throws Exception;
	public int countOriginalVoucherListWithAuditing(String originalVoucherConfirmationId, String auditingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<OriginalVoucherConfirmation> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateOriginalVoucherConfirmation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:OriginalVoucher的confirmation的OriginalVoucherList
	public SmartList<OriginalVoucher> loadOurOriginalVoucherList(RetailscmUserContext userContext, List<OriginalVoucherConfirmation> us, Map<String,Object> options) throws Exception;
	
}


