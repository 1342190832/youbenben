
package com.youbenben.youbenben.franchisedoutletprovincecenter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.catalog.Catalog;

import com.youbenben.youbenben.catalog.CatalogDAO;


public interface FranchisedOutletProvinceCenterDAO extends BaseDAO{

	public SmartList<FranchisedOutletProvinceCenter> loadAll();
	public FranchisedOutletProvinceCenter load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public FranchisedOutletProvinceCenter present(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter,Map<String,Object> options) throws Exception;
	public FranchisedOutletProvinceCenter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public FranchisedOutletProvinceCenter save(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter,Map<String,Object> options);
	public SmartList<FranchisedOutletProvinceCenter> saveFranchisedOutletProvinceCenterList(SmartList<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList,Map<String,Object> options);
	public SmartList<FranchisedOutletProvinceCenter> removeFranchisedOutletProvinceCenterList(SmartList<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList,Map<String,Object> options);
	public SmartList<FranchisedOutletProvinceCenter> findFranchisedOutletProvinceCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countFranchisedOutletProvinceCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countFranchisedOutletProvinceCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String franchisedOutletProvinceCenterId, int version) throws Exception;
	public FranchisedOutletProvinceCenter disconnectFromAll(String franchisedOutletProvinceCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public CatalogDAO getCatalogDAO();
		
	
 	public SmartList<FranchisedOutletProvinceCenter> requestCandidateFranchisedOutletProvinceCenterForCatalog(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public FranchisedOutletProvinceCenter planToRemoveCatalogList(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, String catalogIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<FranchisedOutletProvinceCenter> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateFranchisedOutletProvinceCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:Catalog的owner的CatalogList
	public SmartList<Catalog> loadOurCatalogList(YoubenbenUserContext userContext, List<FranchisedOutletProvinceCenter> us, Map<String,Object> options) throws Exception;
	
}


