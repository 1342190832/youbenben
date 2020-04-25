
package com.youbenben.youbenben.warehouse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface WarehouseManager extends BaseManager{

		

	public Warehouse createWarehouse(YoubenbenUserContext userContext, String location,String contactNumber,String totalArea,String ownerId,BigDecimal latitude,BigDecimal longitude) throws Exception;
	public Warehouse updateWarehouse(YoubenbenUserContext userContext,String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Warehouse loadWarehouse(YoubenbenUserContext userContext, String warehouseId, String [] tokensExpr) throws Exception;
	public Warehouse internalSaveWarehouse(YoubenbenUserContext userContext, Warehouse warehouse) throws Exception;
	public Warehouse internalSaveWarehouse(YoubenbenUserContext userContext, Warehouse warehouse,Map<String,Object>option) throws Exception;

	public Warehouse transferToAnotherOwner(YoubenbenUserContext userContext, String warehouseId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String warehouseId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, Warehouse newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  StorageSpaceManager getStorageSpaceManager(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Warehouse addStorageSpace(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Warehouse removeStorageSpace(YoubenbenUserContext userContext, String warehouseId, String storageSpaceId, int storageSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateStorageSpace(YoubenbenUserContext userContext, String warehouseId, String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SmartPalletManager getSmartPalletManager(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Warehouse addSmartPallet(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Warehouse removeSmartPallet(YoubenbenUserContext userContext, String warehouseId, String smartPalletId, int smartPalletVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateSmartPallet(YoubenbenUserContext userContext, String warehouseId, String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplierSpaceManager getSupplierSpaceManager(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Warehouse addSupplierSpace(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Warehouse removeSupplierSpace(YoubenbenUserContext userContext, String warehouseId, String supplierSpaceId, int supplierSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateSupplierSpace(YoubenbenUserContext userContext, String warehouseId, String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ReceivingSpaceManager getReceivingSpaceManager(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String description, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Warehouse addReceivingSpace(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String description, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Warehouse removeReceivingSpace(YoubenbenUserContext userContext, String warehouseId, String receivingSpaceId, int receivingSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateReceivingSpace(YoubenbenUserContext userContext, String warehouseId, String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ShippingSpaceManager getShippingSpaceManager(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  Warehouse addShippingSpace(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  Warehouse removeShippingSpace(YoubenbenUserContext userContext, String warehouseId, String shippingSpaceId, int shippingSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateShippingSpace(YoubenbenUserContext userContext, String warehouseId, String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  DamageSpaceManager getDamageSpaceManager(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Warehouse addDamageSpace(YoubenbenUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Warehouse removeDamageSpace(YoubenbenUserContext userContext, String warehouseId, String damageSpaceId, int damageSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateDamageSpace(YoubenbenUserContext userContext, String warehouseId, String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WarehouseAssetManager getWarehouseAssetManager(YoubenbenUserContext userContext, String warehouseId, String name, String position ,String [] tokensExpr)  throws Exception;

	public  Warehouse addWarehouseAsset(YoubenbenUserContext userContext, String warehouseId, String name, String position , String [] tokensExpr)  throws Exception;
	public  Warehouse removeWarehouseAsset(YoubenbenUserContext userContext, String warehouseId, String warehouseAssetId, int warehouseAssetVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateWarehouseAsset(YoubenbenUserContext userContext, String warehouseId, String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


