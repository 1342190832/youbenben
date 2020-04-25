
package com.youbenben.youbenben.warehouseasset;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface WarehouseAssetManager extends BaseManager{

		

	public WarehouseAsset createWarehouseAsset(YoubenbenUserContext userContext, String name,String position,String ownerId) throws Exception;
	public WarehouseAsset updateWarehouseAsset(YoubenbenUserContext userContext,String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WarehouseAsset loadWarehouseAsset(YoubenbenUserContext userContext, String warehouseAssetId, String [] tokensExpr) throws Exception;
	public WarehouseAsset internalSaveWarehouseAsset(YoubenbenUserContext userContext, WarehouseAsset warehouseAsset) throws Exception;
	public WarehouseAsset internalSaveWarehouseAsset(YoubenbenUserContext userContext, WarehouseAsset warehouseAsset,Map<String,Object>option) throws Exception;

	public WarehouseAsset transferToAnotherOwner(YoubenbenUserContext userContext, String warehouseAssetId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String warehouseAssetId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, WarehouseAsset newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


