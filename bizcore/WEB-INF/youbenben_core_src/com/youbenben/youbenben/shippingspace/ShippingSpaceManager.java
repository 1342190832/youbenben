
package com.youbenben.youbenben.shippingspace;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ShippingSpaceManager extends BaseManager{

		

	public ShippingSpace createShippingSpace(YoubenbenUserContext userContext, String location,String contactNumber,String totalArea,String warehouseId,BigDecimal latitude,BigDecimal longitude,String description) throws Exception;
	public ShippingSpace updateShippingSpace(YoubenbenUserContext userContext,String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ShippingSpace loadShippingSpace(YoubenbenUserContext userContext, String shippingSpaceId, String [] tokensExpr) throws Exception;
	public ShippingSpace internalSaveShippingSpace(YoubenbenUserContext userContext, ShippingSpace shippingSpace) throws Exception;
	public ShippingSpace internalSaveShippingSpace(YoubenbenUserContext userContext, ShippingSpace shippingSpace,Map<String,Object>option) throws Exception;

	public ShippingSpace transferToAnotherWarehouse(YoubenbenUserContext userContext, String shippingSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String shippingSpaceId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ShippingSpace newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsManager getGoodsManager(YoubenbenUserContext userContext, String shippingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String packagingId ,String [] tokensExpr)  throws Exception;

	public  ShippingSpace addGoods(YoubenbenUserContext userContext, String shippingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String packagingId , String [] tokensExpr)  throws Exception;
	public  ShippingSpace removeGoods(YoubenbenUserContext userContext, String shippingSpaceId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  ShippingSpace updateGoods(YoubenbenUserContext userContext, String shippingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByWarehouse(YoubenbenUserContext userContext,String warehouseId) throws Exception;
	public Object listPageByWarehouse(YoubenbenUserContext userContext,String warehouseId, int start, int count) throws Exception;
  

}


