
package com.youbenben.youbenben.warehouse;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.smartpallet.SmartPallet;
import com.youbenben.youbenben.shippingspace.ShippingSpace;
import com.youbenben.youbenben.warehouseasset.WarehouseAsset;
import com.youbenben.youbenben.supplierspace.SupplierSpace;
import com.youbenben.youbenben.receivingspace.ReceivingSpace;
import com.youbenben.youbenben.damagespace.DamageSpace;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;
import com.youbenben.youbenben.storagespace.StorageSpace;

import com.youbenben.youbenben.storagespace.StorageSpaceDAO;
import com.youbenben.youbenben.shippingspace.ShippingSpaceDAO;
import com.youbenben.youbenben.warehouseasset.WarehouseAssetDAO;
import com.youbenben.youbenben.damagespace.DamageSpaceDAO;
import com.youbenben.youbenben.receivingspace.ReceivingSpaceDAO;
import com.youbenben.youbenben.supplierspace.SupplierSpaceDAO;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.youbenben.youbenben.smartpallet.SmartPalletDAO;


public interface WarehouseDAO extends BaseDAO{

	public SmartList<Warehouse> loadAll();
	public Warehouse load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Warehouse> warehouseList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Warehouse present(Warehouse warehouse,Map<String,Object> options) throws Exception;
	public Warehouse clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Warehouse save(Warehouse warehouse,Map<String,Object> options);
	public SmartList<Warehouse> saveWarehouseList(SmartList<Warehouse> warehouseList,Map<String,Object> options);
	public SmartList<Warehouse> removeWarehouseList(SmartList<Warehouse> warehouseList,Map<String,Object> options);
	public SmartList<Warehouse> findWarehouseWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countWarehouseWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countWarehouseWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String warehouseId, int version) throws Exception;
	public Warehouse disconnectFromAll(String warehouseId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public StorageSpaceDAO getStorageSpaceDAO();
		
	public SmartPalletDAO getSmartPalletDAO();
		
	public SupplierSpaceDAO getSupplierSpaceDAO();
		
	public ReceivingSpaceDAO getReceivingSpaceDAO();
		
	public ShippingSpaceDAO getShippingSpaceDAO();
		
	public DamageSpaceDAO getDamageSpaceDAO();
		
	public WarehouseAssetDAO getWarehouseAssetDAO();
		
	
 	public SmartList<Warehouse> requestCandidateWarehouseForStorageSpace(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForSmartPallet(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForSupplierSpace(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForReceivingSpace(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForShippingSpace(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForDamageSpace(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForWarehouseAsset(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Warehouse planToRemoveStorageSpaceList(Warehouse warehouse, String storageSpaceIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveSmartPalletList(Warehouse warehouse, String smartPalletIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveSupplierSpaceList(Warehouse warehouse, String supplierSpaceIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveReceivingSpaceList(Warehouse warehouse, String receivingSpaceIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveShippingSpaceList(Warehouse warehouse, String shippingSpaceIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveDamageSpaceList(Warehouse warehouse, String damageSpaceIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveWarehouseAssetList(Warehouse warehouse, String warehouseAssetIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Warehouse> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateWarehouse executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<Warehouse> findWarehouseByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countWarehouseByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countWarehouseByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<Warehouse> findWarehouseByOwner(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeWarehouseByOwner(SmartList<Warehouse> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:StorageSpace的warehouse的StorageSpaceList
	public SmartList<StorageSpace> loadOurStorageSpaceList(YoubenbenUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SmartPallet的warehouse的SmartPalletList
	public SmartList<SmartPallet> loadOurSmartPalletList(YoubenbenUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplierSpace的warehouse的SupplierSpaceList
	public SmartList<SupplierSpace> loadOurSupplierSpaceList(YoubenbenUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ReceivingSpace的warehouse的ReceivingSpaceList
	public SmartList<ReceivingSpace> loadOurReceivingSpaceList(YoubenbenUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ShippingSpace的warehouse的ShippingSpaceList
	public SmartList<ShippingSpace> loadOurShippingSpaceList(YoubenbenUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:DamageSpace的warehouse的DamageSpaceList
	public SmartList<DamageSpace> loadOurDamageSpaceList(YoubenbenUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:WarehouseAsset的owner的WarehouseAssetList
	public SmartList<WarehouseAsset> loadOurWarehouseAssetList(YoubenbenUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
}


