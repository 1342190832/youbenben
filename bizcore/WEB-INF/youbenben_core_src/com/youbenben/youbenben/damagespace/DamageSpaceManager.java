
package com.youbenben.youbenben.damagespace;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface DamageSpaceManager extends BaseManager{

		

	public DamageSpace createDamageSpace(YoubenbenUserContext userContext, String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String warehouseId) throws Exception;
	public DamageSpace updateDamageSpace(YoubenbenUserContext userContext,String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public DamageSpace loadDamageSpace(YoubenbenUserContext userContext, String damageSpaceId, String [] tokensExpr) throws Exception;
	public DamageSpace internalSaveDamageSpace(YoubenbenUserContext userContext, DamageSpace damageSpace) throws Exception;
	public DamageSpace internalSaveDamageSpace(YoubenbenUserContext userContext, DamageSpace damageSpace,Map<String,Object>option) throws Exception;

	public DamageSpace transferToAnotherWarehouse(YoubenbenUserContext userContext, String damageSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String damageSpaceId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, DamageSpace newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsShelfManager getGoodsShelfManager(YoubenbenUserContext userContext, String damageSpaceId, String location, String storageSpaceId, String supplierSpaceId ,String [] tokensExpr)  throws Exception;

	public  DamageSpace addGoodsShelf(YoubenbenUserContext userContext, String damageSpaceId, String location, String storageSpaceId, String supplierSpaceId , String [] tokensExpr)  throws Exception;
	public  DamageSpace removeGoodsShelf(YoubenbenUserContext userContext, String damageSpaceId, String goodsShelfId, int goodsShelfVersion,String [] tokensExpr)  throws Exception;
	public  DamageSpace updateGoodsShelf(YoubenbenUserContext userContext, String damageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByWarehouse(YoubenbenUserContext userContext,String warehouseId) throws Exception;
	public Object listPageByWarehouse(YoubenbenUserContext userContext,String warehouseId, int start, int count) throws Exception;
  

}


