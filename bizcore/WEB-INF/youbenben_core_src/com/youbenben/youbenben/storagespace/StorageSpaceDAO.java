
package com.youbenben.youbenben.storagespace;
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


public interface StorageSpaceDAO extends BaseDAO{

	public SmartList<StorageSpace> loadAll();
	public StorageSpace load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<StorageSpace> storageSpaceList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public StorageSpace present(StorageSpace storageSpace,Map<String,Object> options) throws Exception;
	public StorageSpace clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public StorageSpace save(StorageSpace storageSpace,Map<String,Object> options);
	public SmartList<StorageSpace> saveStorageSpaceList(SmartList<StorageSpace> storageSpaceList,Map<String,Object> options);
	public SmartList<StorageSpace> removeStorageSpaceList(SmartList<StorageSpace> storageSpaceList,Map<String,Object> options);
	public SmartList<StorageSpace> findStorageSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countStorageSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countStorageSpaceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String storageSpaceId, int version) throws Exception;
	public StorageSpace disconnectFromAll(String storageSpaceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GoodsShelfDAO getGoodsShelfDAO();
		
	
 	public SmartList<StorageSpace> requestCandidateStorageSpaceForGoodsShelf(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public StorageSpace planToRemoveGoodsShelfList(StorageSpace storageSpace, String goodsShelfIds[], Map<String,Object> options)throws Exception;


	//disconnect StorageSpace with supplier_space in GoodsShelf
	public StorageSpace planToRemoveGoodsShelfListWithSupplierSpace(StorageSpace storageSpace, String supplierSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsShelfListWithSupplierSpace(String storageSpaceId, String supplierSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect StorageSpace with damage_space in GoodsShelf
	public StorageSpace planToRemoveGoodsShelfListWithDamageSpace(StorageSpace storageSpace, String damageSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsShelfListWithDamageSpace(String storageSpaceId, String damageSpaceId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<StorageSpace> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateStorageSpace executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<StorageSpace> findStorageSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countStorageSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public Map<String, Integer> countStorageSpaceByWarehouseIds(String[] ids, Map<String,Object> options);
 	public SmartList<StorageSpace> findStorageSpaceByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 	public void analyzeStorageSpaceByWarehouse(SmartList<StorageSpace> resultList, String warehouseId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:GoodsShelf的storageSpace的GoodsShelfList
	public SmartList<GoodsShelf> loadOurGoodsShelfList(YoubenbenUserContext userContext, List<StorageSpace> us, Map<String,Object> options) throws Exception;
	
}


