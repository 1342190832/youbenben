
package com.youbenben.youbenben.productsupplyduration;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.supplierproduct.SupplierProduct;

import com.youbenben.youbenben.supplierproduct.SupplierProductDAO;


public interface ProductSupplyDurationDAO extends BaseDAO{

	public SmartList<ProductSupplyDuration> loadAll();
	public ProductSupplyDuration load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ProductSupplyDuration> productSupplyDurationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ProductSupplyDuration present(ProductSupplyDuration productSupplyDuration,Map<String,Object> options) throws Exception;
	public ProductSupplyDuration clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ProductSupplyDuration save(ProductSupplyDuration productSupplyDuration,Map<String,Object> options);
	public SmartList<ProductSupplyDuration> saveProductSupplyDurationList(SmartList<ProductSupplyDuration> productSupplyDurationList,Map<String,Object> options);
	public SmartList<ProductSupplyDuration> removeProductSupplyDurationList(SmartList<ProductSupplyDuration> productSupplyDurationList,Map<String,Object> options);
	public SmartList<ProductSupplyDuration> findProductSupplyDurationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProductSupplyDurationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProductSupplyDurationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String productSupplyDurationId, int version) throws Exception;
	public ProductSupplyDuration disconnectFromAll(String productSupplyDurationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ProductSupplyDuration> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateProductSupplyDuration executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<ProductSupplyDuration> findProductSupplyDurationByProduct(String supplierProductId, Map<String,Object> options);
 	public int countProductSupplyDurationByProduct(String supplierProductId, Map<String,Object> options);
 	public Map<String, Integer> countProductSupplyDurationByProductIds(String[] ids, Map<String,Object> options);
 	public SmartList<ProductSupplyDuration> findProductSupplyDurationByProduct(String supplierProductId, int start, int count, Map<String,Object> options);
 	public void analyzeProductSupplyDurationByProduct(SmartList<ProductSupplyDuration> resultList, String supplierProductId, Map<String,Object> options);

 
 
}


