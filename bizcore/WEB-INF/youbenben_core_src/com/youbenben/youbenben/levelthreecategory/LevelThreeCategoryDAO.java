
package com.youbenben.youbenben.levelthreecategory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.leveltwocategory.LevelTwoCategory;
import com.youbenben.youbenben.product.Product;

import com.youbenben.youbenben.leveltwocategory.LevelTwoCategoryDAO;
import com.youbenben.youbenben.product.ProductDAO;


public interface LevelThreeCategoryDAO extends BaseDAO{

	public SmartList<LevelThreeCategory> loadAll();
	public LevelThreeCategory load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LevelThreeCategory> levelThreeCategoryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LevelThreeCategory present(LevelThreeCategory levelThreeCategory,Map<String,Object> options) throws Exception;
	public LevelThreeCategory clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelThreeCategory save(LevelThreeCategory levelThreeCategory,Map<String,Object> options);
	public SmartList<LevelThreeCategory> saveLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList,Map<String,Object> options);
	public SmartList<LevelThreeCategory> removeLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList,Map<String,Object> options);
	public SmartList<LevelThreeCategory> findLevelThreeCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLevelThreeCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLevelThreeCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String levelThreeCategoryId, int version) throws Exception;
	public LevelThreeCategory disconnectFromAll(String levelThreeCategoryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProductDAO getProductDAO();
		
	
 	public SmartList<LevelThreeCategory> requestCandidateLevelThreeCategoryForProduct(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelThreeCategory planToRemoveProductList(LevelThreeCategory levelThreeCategory, String productIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<LevelThreeCategory> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateLevelThreeCategory executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<LevelThreeCategory> findLevelThreeCategoryByParentCategory(String levelTwoCategoryId, Map<String,Object> options);
 	public int countLevelThreeCategoryByParentCategory(String levelTwoCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countLevelThreeCategoryByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelThreeCategory> findLevelThreeCategoryByParentCategory(String levelTwoCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelThreeCategoryByParentCategory(SmartList<LevelThreeCategory> resultList, String levelTwoCategoryId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Product的parentCategory的ProductList
	public SmartList<Product> loadOurProductList(YoubenbenUserContext userContext, List<LevelThreeCategory> us, Map<String,Object> options) throws Exception;
	
}


