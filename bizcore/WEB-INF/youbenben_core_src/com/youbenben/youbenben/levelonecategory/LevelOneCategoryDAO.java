
package com.youbenben.youbenben.levelonecategory;
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
import com.youbenben.youbenben.leveltwocategory.LevelTwoCategory;

import com.youbenben.youbenben.catalog.CatalogDAO;
import com.youbenben.youbenben.leveltwocategory.LevelTwoCategoryDAO;


public interface LevelOneCategoryDAO extends BaseDAO{

	public SmartList<LevelOneCategory> loadAll();
	public LevelOneCategory load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LevelOneCategory> levelOneCategoryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LevelOneCategory present(LevelOneCategory levelOneCategory,Map<String,Object> options) throws Exception;
	public LevelOneCategory clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelOneCategory save(LevelOneCategory levelOneCategory,Map<String,Object> options);
	public SmartList<LevelOneCategory> saveLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options);
	public SmartList<LevelOneCategory> removeLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options);
	public SmartList<LevelOneCategory> findLevelOneCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLevelOneCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLevelOneCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String levelOneCategoryId, int version) throws Exception;
	public LevelOneCategory disconnectFromAll(String levelOneCategoryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public LevelTwoCategoryDAO getLevelTwoCategoryDAO();
		
	
 	public SmartList<LevelOneCategory> requestCandidateLevelOneCategoryForLevelTwoCategory(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelOneCategory planToRemoveLevelTwoCategoryList(LevelOneCategory levelOneCategory, String levelTwoCategoryIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<LevelOneCategory> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateLevelOneCategory executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<LevelOneCategory> findLevelOneCategoryByCatalog(String catalogId, Map<String,Object> options);
 	public int countLevelOneCategoryByCatalog(String catalogId, Map<String,Object> options);
 	public Map<String, Integer> countLevelOneCategoryByCatalogIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelOneCategory> findLevelOneCategoryByCatalog(String catalogId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelOneCategoryByCatalog(SmartList<LevelOneCategory> resultList, String catalogId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:LevelTwoCategory的parentCategory的LevelTwoCategoryList
	public SmartList<LevelTwoCategory> loadOurLevelTwoCategoryList(YoubenbenUserContext userContext, List<LevelOneCategory> us, Map<String,Object> options) throws Exception;
	
}


