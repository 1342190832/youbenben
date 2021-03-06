
package com.youbenben.youbenben.leveltwocategory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.levelthreecategory.LevelThreeCategory;
import com.youbenben.youbenben.levelonecategory.LevelOneCategory;

import com.youbenben.youbenben.levelonecategory.LevelOneCategoryDAO;
import com.youbenben.youbenben.levelthreecategory.LevelThreeCategoryDAO;


public interface LevelTwoCategoryDAO extends BaseDAO{

	public SmartList<LevelTwoCategory> loadAll();
	public LevelTwoCategory load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LevelTwoCategory> levelTwoCategoryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LevelTwoCategory present(LevelTwoCategory levelTwoCategory,Map<String,Object> options) throws Exception;
	public LevelTwoCategory clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelTwoCategory save(LevelTwoCategory levelTwoCategory,Map<String,Object> options);
	public SmartList<LevelTwoCategory> saveLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options);
	public SmartList<LevelTwoCategory> removeLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options);
	public SmartList<LevelTwoCategory> findLevelTwoCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLevelTwoCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLevelTwoCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String levelTwoCategoryId, int version) throws Exception;
	public LevelTwoCategory disconnectFromAll(String levelTwoCategoryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public LevelThreeCategoryDAO getLevelThreeCategoryDAO();
		
	
 	public SmartList<LevelTwoCategory> requestCandidateLevelTwoCategoryForLevelThreeCategory(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelTwoCategory planToRemoveLevelThreeCategoryList(LevelTwoCategory levelTwoCategory, String levelThreeCategoryIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<LevelTwoCategory> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateLevelTwoCategory executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId, Map<String,Object> options);
 	public int countLevelTwoCategoryByParentCategory(String levelOneCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countLevelTwoCategoryByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelTwoCategoryByParentCategory(SmartList<LevelTwoCategory> resultList, String levelOneCategoryId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:LevelThreeCategory的parentCategory的LevelThreeCategoryList
	public SmartList<LevelThreeCategory> loadOurLevelThreeCategoryList(YoubenbenUserContext userContext, List<LevelTwoCategory> us, Map<String,Object> options) throws Exception;
	
}


