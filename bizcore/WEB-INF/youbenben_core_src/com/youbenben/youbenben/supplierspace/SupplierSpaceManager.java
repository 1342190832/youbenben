
package com.youbenben.youbenben.supplierspace;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplierSpaceManager extends BaseManager{

		

	public SupplierSpace createSupplierSpace(YoubenbenUserContext userContext, String location,String contactNumber,String totalArea,String warehouseId,BigDecimal latitude,BigDecimal longitude) throws Exception;
	public SupplierSpace updateSupplierSpace(YoubenbenUserContext userContext,String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplierSpace loadSupplierSpace(YoubenbenUserContext userContext, String supplierSpaceId, String [] tokensExpr) throws Exception;
	public SupplierSpace internalSaveSupplierSpace(YoubenbenUserContext userContext, SupplierSpace supplierSpace) throws Exception;
	public SupplierSpace internalSaveSupplierSpace(YoubenbenUserContext userContext, SupplierSpace supplierSpace,Map<String,Object>option) throws Exception;

	public SupplierSpace transferToAnotherWarehouse(YoubenbenUserContext userContext, String supplierSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String supplierSpaceId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplierSpace newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsShelfManager getGoodsShelfManager(YoubenbenUserContext userContext, String supplierSpaceId, String location, String storageSpaceId, String damageSpaceId ,String [] tokensExpr)  throws Exception;

	public  SupplierSpace addGoodsShelf(YoubenbenUserContext userContext, String supplierSpaceId, String location, String storageSpaceId, String damageSpaceId , String [] tokensExpr)  throws Exception;
	public  SupplierSpace removeGoodsShelf(YoubenbenUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion,String [] tokensExpr)  throws Exception;
	public  SupplierSpace updateGoodsShelf(YoubenbenUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByWarehouse(YoubenbenUserContext userContext,String warehouseId) throws Exception;
	public Object listPageByWarehouse(YoubenbenUserContext userContext,String warehouseId, int start, int count) throws Exception;
  

}


