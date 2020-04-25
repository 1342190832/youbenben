
package com.youbenben.youbenben.storagespace;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface StorageSpaceManager extends BaseManager{

		

	public StorageSpace createStorageSpace(YoubenbenUserContext userContext, String location,String contactNumber,String totalArea,String warehouseId,BigDecimal latitude,BigDecimal longitude) throws Exception;
	public StorageSpace updateStorageSpace(YoubenbenUserContext userContext,String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public StorageSpace loadStorageSpace(YoubenbenUserContext userContext, String storageSpaceId, String [] tokensExpr) throws Exception;
	public StorageSpace internalSaveStorageSpace(YoubenbenUserContext userContext, StorageSpace storageSpace) throws Exception;
	public StorageSpace internalSaveStorageSpace(YoubenbenUserContext userContext, StorageSpace storageSpace,Map<String,Object>option) throws Exception;

	public StorageSpace transferToAnotherWarehouse(YoubenbenUserContext userContext, String storageSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String storageSpaceId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, StorageSpace newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsShelfManager getGoodsShelfManager(YoubenbenUserContext userContext, String storageSpaceId, String location, String supplierSpaceId, String damageSpaceId ,String [] tokensExpr)  throws Exception;

	public  StorageSpace addGoodsShelf(YoubenbenUserContext userContext, String storageSpaceId, String location, String supplierSpaceId, String damageSpaceId , String [] tokensExpr)  throws Exception;
	public  StorageSpace removeGoodsShelf(YoubenbenUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion,String [] tokensExpr)  throws Exception;
	public  StorageSpace updateGoodsShelf(YoubenbenUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByWarehouse(YoubenbenUserContext userContext,String warehouseId) throws Exception;
	public Object listPageByWarehouse(YoubenbenUserContext userContext,String warehouseId, int start, int count) throws Exception;
  

}


