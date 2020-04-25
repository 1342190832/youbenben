
package com.youbenben.youbenben.damagespace;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.warehouse.Warehouse;
import com.youbenben.youbenben.goodsshelf.GoodsShelf;

import com.youbenben.youbenben.warehouse.WarehouseDAO;
import com.youbenben.youbenben.goodsshelf.GoodsShelfDAO;


public interface DamageSpaceDAO extends BaseDAO{

	public SmartList<DamageSpace> loadAll();
	public DamageSpace load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<DamageSpace> damageSpaceList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public DamageSpace present(DamageSpace damageSpace,Map<String,Object> options) throws Exception;
	public DamageSpace clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public DamageSpace save(DamageSpace damageSpace,Map<String,Object> options);
	public SmartList<DamageSpace> saveDamageSpaceList(SmartList<DamageSpace> damageSpaceList,Map<String,Object> options);
	public SmartList<DamageSpace> removeDamageSpaceList(SmartList<DamageSpace> damageSpaceList,Map<String,Object> options);
	public SmartList<DamageSpace> findDamageSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countDamageSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countDamageSpaceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String damageSpaceId, int version) throws Exception;
	public DamageSpace disconnectFromAll(String damageSpaceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GoodsShelfDAO getGoodsShelfDAO();
		
	
 	public SmartList<DamageSpace> requestCandidateDamageSpaceForGoodsShelf(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public DamageSpace planToRemoveGoodsShelfList(DamageSpace damageSpace, String goodsShelfIds[], Map<String,Object> options)throws Exception;


	//disconnect DamageSpace with storage_space in GoodsShelf
	public DamageSpace planToRemoveGoodsShelfListWithStorageSpace(DamageSpace damageSpace, String storageSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsShelfListWithStorageSpace(String damageSpaceId, String storageSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect DamageSpace with supplier_space in GoodsShelf
	public DamageSpace planToRemoveGoodsShelfListWithSupplierSpace(DamageSpace damageSpace, String supplierSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsShelfListWithSupplierSpace(String damageSpaceId, String supplierSpaceId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<DamageSpace> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateDamageSpace executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<DamageSpace> findDamageSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countDamageSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public Map<String, Integer> countDamageSpaceByWarehouseIds(String[] ids, Map<String,Object> options);
 	public SmartList<DamageSpace> findDamageSpaceByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 	public void analyzeDamageSpaceByWarehouse(SmartList<DamageSpace> resultList, String warehouseId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:GoodsShelf的damageSpace的GoodsShelfList
	public SmartList<GoodsShelf> loadOurGoodsShelfList(YoubenbenUserContext userContext, List<DamageSpace> us, Map<String,Object> options) throws Exception;
	
}


