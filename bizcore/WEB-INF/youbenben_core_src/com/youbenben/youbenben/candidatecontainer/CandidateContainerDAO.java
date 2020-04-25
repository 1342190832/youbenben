
package com.youbenben.youbenben.candidatecontainer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.candidateelement.CandidateElement;

import com.youbenben.youbenben.candidateelement.CandidateElementDAO;


public interface CandidateContainerDAO extends BaseDAO{

	public SmartList<CandidateContainer> loadAll();
	public CandidateContainer load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<CandidateContainer> candidateContainerList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public CandidateContainer present(CandidateContainer candidateContainer,Map<String,Object> options) throws Exception;
	public CandidateContainer clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CandidateContainer save(CandidateContainer candidateContainer,Map<String,Object> options);
	public SmartList<CandidateContainer> saveCandidateContainerList(SmartList<CandidateContainer> candidateContainerList,Map<String,Object> options);
	public SmartList<CandidateContainer> removeCandidateContainerList(SmartList<CandidateContainer> candidateContainerList,Map<String,Object> options);
	public SmartList<CandidateContainer> findCandidateContainerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCandidateContainerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCandidateContainerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String candidateContainerId, int version) throws Exception;
	public CandidateContainer disconnectFromAll(String candidateContainerId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public CandidateElementDAO getCandidateElementDAO();
		
	
 	public SmartList<CandidateContainer> requestCandidateCandidateContainerForCandidateElement(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public CandidateContainer planToRemoveCandidateElementList(CandidateContainer candidateContainer, String candidateElementIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<CandidateContainer> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateCandidateContainer executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:CandidateElement的container的CandidateElementList
	public SmartList<CandidateElement> loadOurCandidateElementList(YoubenbenUserContext userContext, List<CandidateContainer> us, Map<String,Object> options) throws Exception;
	
}


