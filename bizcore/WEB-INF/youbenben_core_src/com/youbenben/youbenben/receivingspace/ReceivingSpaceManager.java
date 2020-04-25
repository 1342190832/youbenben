
package com.youbenben.youbenben.receivingspace;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ReceivingSpaceManager extends BaseManager{

		

	public ReceivingSpace createReceivingSpace(YoubenbenUserContext userContext, String location,String contactNumber,String description,String totalArea,String warehouseId,BigDecimal latitude,BigDecimal longitude) throws Exception;
	public ReceivingSpace updateReceivingSpace(YoubenbenUserContext userContext,String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ReceivingSpace loadReceivingSpace(YoubenbenUserContext userContext, String receivingSpaceId, String [] tokensExpr) throws Exception;
	public ReceivingSpace internalSaveReceivingSpace(YoubenbenUserContext userContext, ReceivingSpace receivingSpace) throws Exception;
	public ReceivingSpace internalSaveReceivingSpace(YoubenbenUserContext userContext, ReceivingSpace receivingSpace,Map<String,Object>option) throws Exception;

	public ReceivingSpace transferToAnotherWarehouse(YoubenbenUserContext userContext, String receivingSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String receivingSpaceId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ReceivingSpace newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsManager getGoodsManager(YoubenbenUserContext userContext, String receivingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String packagingId ,String [] tokensExpr)  throws Exception;

	public  ReceivingSpace addGoods(YoubenbenUserContext userContext, String receivingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String packagingId , String [] tokensExpr)  throws Exception;
	public  ReceivingSpace removeGoods(YoubenbenUserContext userContext, String receivingSpaceId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  ReceivingSpace updateGoods(YoubenbenUserContext userContext, String receivingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByWarehouse(YoubenbenUserContext userContext,String warehouseId) throws Exception;
	public Object listPageByWarehouse(YoubenbenUserContext userContext,String warehouseId, int start, int count) throws Exception;
  

}


