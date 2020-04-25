
package com.youbenben.youbenben.smartpallet;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SmartPalletManager extends BaseManager{

		

	public SmartPallet createSmartPallet(YoubenbenUserContext userContext, String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String warehouseId) throws Exception;
	public SmartPallet updateSmartPallet(YoubenbenUserContext userContext,String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SmartPallet loadSmartPallet(YoubenbenUserContext userContext, String smartPalletId, String [] tokensExpr) throws Exception;
	public SmartPallet internalSaveSmartPallet(YoubenbenUserContext userContext, SmartPallet smartPallet) throws Exception;
	public SmartPallet internalSaveSmartPallet(YoubenbenUserContext userContext, SmartPallet smartPallet,Map<String,Object>option) throws Exception;

	public SmartPallet transferToAnotherWarehouse(YoubenbenUserContext userContext, String smartPalletId, String anotherWarehouseId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String smartPalletId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SmartPallet newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsManager getGoodsManager(YoubenbenUserContext userContext, String smartPalletId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String packagingId ,String [] tokensExpr)  throws Exception;

	public  SmartPallet addGoods(YoubenbenUserContext userContext, String smartPalletId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String packagingId , String [] tokensExpr)  throws Exception;
	public  SmartPallet removeGoods(YoubenbenUserContext userContext, String smartPalletId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  SmartPallet updateGoods(YoubenbenUserContext userContext, String smartPalletId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByWarehouse(YoubenbenUserContext userContext,String warehouseId) throws Exception;
	public Object listPageByWarehouse(YoubenbenUserContext userContext,String warehouseId, int start, int count) throws Exception;
  

}


