
package com.youbenben.youbenben.sku;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.product.Product;

import com.youbenben.youbenben.product.ProductDAO;


public interface SkuDAO extends BaseDAO{

	public SmartList<Sku> loadAll();
	public Sku load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Sku> skuList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Sku present(Sku sku,Map<String,Object> options) throws Exception;
	public Sku clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Sku save(Sku sku,Map<String,Object> options);
	public SmartList<Sku> saveSkuList(SmartList<Sku> skuList,Map<String,Object> options);
	public SmartList<Sku> removeSkuList(SmartList<Sku> skuList,Map<String,Object> options);
	public SmartList<Sku> findSkuWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSkuWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSkuWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String skuId, int version) throws Exception;
	public Sku disconnectFromAll(String skuId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Sku> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSku executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<Sku> findSkuByProduct(String productId, Map<String,Object> options);
 	public int countSkuByProduct(String productId, Map<String,Object> options);
 	public Map<String, Integer> countSkuByProductIds(String[] ids, Map<String,Object> options);
 	public SmartList<Sku> findSkuByProduct(String productId, int start, int count, Map<String,Object> options);
 	public void analyzeSkuByProduct(SmartList<Sku> resultList, String productId, Map<String,Object> options);

 
 
}


