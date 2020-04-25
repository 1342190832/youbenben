
package com.youbenben.youbenben.catalog;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenter;
import com.youbenben.youbenben.levelonecategory.LevelOneCategory;

import com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenterDAO;
import com.youbenben.youbenben.levelonecategory.LevelOneCategoryDAO;


public interface CatalogDAO extends BaseDAO{

	public SmartList<Catalog> loadAll();
	public Catalog load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Catalog> catalogList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Catalog present(Catalog catalog,Map<String,Object> options) throws Exception;
	public Catalog clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Catalog save(Catalog catalog,Map<String,Object> options);
	public SmartList<Catalog> saveCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options);
	public SmartList<Catalog> removeCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options);
	public SmartList<Catalog> findCatalogWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCatalogWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCatalogWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String catalogId, int version) throws Exception;
	public Catalog disconnectFromAll(String catalogId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public LevelOneCategoryDAO getLevelOneCategoryDAO();
		
	
 	public SmartList<Catalog> requestCandidateCatalogForLevelOneCategory(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Catalog planToRemoveLevelOneCategoryList(Catalog catalog, String levelOneCategoryIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Catalog> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateCatalog executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<Catalog> findCatalogByOwner(String franchisedOutletProvinceCenterId, Map<String,Object> options);
 	public int countCatalogByOwner(String franchisedOutletProvinceCenterId, Map<String,Object> options);
 	public Map<String, Integer> countCatalogByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<Catalog> findCatalogByOwner(String franchisedOutletProvinceCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeCatalogByOwner(SmartList<Catalog> resultList, String franchisedOutletProvinceCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:LevelOneCategory的catalog的LevelOneCategoryList
	public SmartList<LevelOneCategory> loadOurLevelOneCategoryList(YoubenbenUserContext userContext, List<Catalog> us, Map<String,Object> options) throws Exception;
	
}


