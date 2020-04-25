
package com.xingyou.xingyou.catalog;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.xingyou.xingyou.BaseDAO;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.SmartList;
import com.xingyou.xingyou.MultipleAccessKey;
import com.xingyou.xingyou.XingyouUserContext;

import com.xingyou.xingyou.franchisedoutletprovincecenter.FranchisedOutletProvinceCenter;
import com.xingyou.xingyou.levelonecategory.LevelOneCategory;

import com.xingyou.xingyou.levelonecategory.LevelOneCategoryDAO;
import com.xingyou.xingyou.franchisedoutletprovincecenter.FranchisedOutletProvinceCenterDAO;


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
		
	
 	public SmartList<Catalog> requestCandidateCatalogForLevelOneCategory(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
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
	public SmartList<LevelOneCategory> loadOurLevelOneCategoryList(XingyouUserContext userContext, List<Catalog> us, Map<String,Object> options) throws Exception;
	
}


