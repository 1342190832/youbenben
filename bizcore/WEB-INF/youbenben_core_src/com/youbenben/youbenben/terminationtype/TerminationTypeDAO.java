
package com.youbenben.youbenben.terminationtype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.termination.Termination;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.termination.TerminationDAO;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface TerminationTypeDAO extends BaseDAO{

	public SmartList<TerminationType> loadAll();
	public TerminationType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TerminationType> terminationTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TerminationType present(TerminationType terminationType,Map<String,Object> options) throws Exception;
	public TerminationType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TerminationType save(TerminationType terminationType,Map<String,Object> options);
	public SmartList<TerminationType> saveTerminationTypeList(SmartList<TerminationType> terminationTypeList,Map<String,Object> options);
	public SmartList<TerminationType> removeTerminationTypeList(SmartList<TerminationType> terminationTypeList,Map<String,Object> options);
	public SmartList<TerminationType> findTerminationTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTerminationTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTerminationTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String terminationTypeId, int version) throws Exception;
	public TerminationType disconnectFromAll(String terminationTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TerminationDAO getTerminationDAO();
		
	
 	public SmartList<TerminationType> requestCandidateTerminationTypeForTermination(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TerminationType planToRemoveTerminationList(TerminationType terminationType, String terminationIds[], Map<String,Object> options)throws Exception;


	//disconnect TerminationType with reason in Termination
	public TerminationType planToRemoveTerminationListWithReason(TerminationType terminationType, String reasonId, Map<String,Object> options)throws Exception;
	public int countTerminationListWithReason(String terminationTypeId, String reasonId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<TerminationType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateTerminationType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<TerminationType> findTerminationTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countTerminationTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countTerminationTypeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<TerminationType> findTerminationTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeTerminationTypeByCompany(SmartList<TerminationType> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Termination的type的TerminationList
	public SmartList<Termination> loadOurTerminationList(YoubenbenUserContext userContext, List<TerminationType> us, Map<String,Object> options) throws Exception;
	
}


