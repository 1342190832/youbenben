
package com.youbenben.youbenben.goods;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface GoodsManager extends BaseManager{

		

	public Goods createGoods(YoubenbenUserContext userContext, String name,String rfid,String uom,int maxPackage,Date expireTime,String skuId,String receivingSpaceId,String goodsAllocationId,String smartPalletId,String shippingSpaceId,String transportTaskId,String retailStoreId,String bizOrderId,String retailStoreOrderId,String packagingId) throws Exception;
	public Goods updateGoods(YoubenbenUserContext userContext,String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Goods loadGoods(YoubenbenUserContext userContext, String goodsId, String [] tokensExpr) throws Exception;
	public Goods internalSaveGoods(YoubenbenUserContext userContext, Goods goods) throws Exception;
	public Goods internalSaveGoods(YoubenbenUserContext userContext, Goods goods,Map<String,Object>option) throws Exception;

	public Goods transferToAnotherSku(YoubenbenUserContext userContext, String goodsId, String anotherSkuId)  throws Exception;
 	public Goods transferToAnotherReceivingSpace(YoubenbenUserContext userContext, String goodsId, String anotherReceivingSpaceId)  throws Exception;
 	public Goods transferToAnotherGoodsAllocation(YoubenbenUserContext userContext, String goodsId, String anotherGoodsAllocationId)  throws Exception;
 	public Goods transferToAnotherSmartPallet(YoubenbenUserContext userContext, String goodsId, String anotherSmartPalletId)  throws Exception;
 	public Goods transferToAnotherShippingSpace(YoubenbenUserContext userContext, String goodsId, String anotherShippingSpaceId)  throws Exception;
 	public Goods transferToAnotherTransportTask(YoubenbenUserContext userContext, String goodsId, String anotherTransportTaskId)  throws Exception;
 	public Goods transferToAnotherRetailStore(YoubenbenUserContext userContext, String goodsId, String anotherRetailStoreId)  throws Exception;
 	public Goods transferToAnotherBizOrder(YoubenbenUserContext userContext, String goodsId, String anotherBizOrderId)  throws Exception;
 	public Goods transferToAnotherRetailStoreOrder(YoubenbenUserContext userContext, String goodsId, String anotherRetailStoreOrderId)  throws Exception;
 	public Goods transferToAnotherPackaging(YoubenbenUserContext userContext, String goodsId, String anotherPackagingId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String goodsId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, Goods newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsMovementManager getGoodsMovementManager(YoubenbenUserContext userContext, String goodsId, DateTime moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Goods addGoodsMovement(YoubenbenUserContext userContext, String goodsId, DateTime moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Goods removeGoodsMovement(YoubenbenUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion,String [] tokensExpr)  throws Exception;
	public  Goods updateGoodsMovement(YoubenbenUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listBySku(YoubenbenUserContext userContext,String skuId) throws Exception;
	public Object listPageBySku(YoubenbenUserContext userContext,String skuId, int start, int count) throws Exception;
  
	public Object listByReceivingSpace(YoubenbenUserContext userContext,String receivingSpaceId) throws Exception;
	public Object listPageByReceivingSpace(YoubenbenUserContext userContext,String receivingSpaceId, int start, int count) throws Exception;
  
	public Object listByGoodsAllocation(YoubenbenUserContext userContext,String goodsAllocationId) throws Exception;
	public Object listPageByGoodsAllocation(YoubenbenUserContext userContext,String goodsAllocationId, int start, int count) throws Exception;
  
	public Object listBySmartPallet(YoubenbenUserContext userContext,String smartPalletId) throws Exception;
	public Object listPageBySmartPallet(YoubenbenUserContext userContext,String smartPalletId, int start, int count) throws Exception;
  
	public Object listByShippingSpace(YoubenbenUserContext userContext,String shippingSpaceId) throws Exception;
	public Object listPageByShippingSpace(YoubenbenUserContext userContext,String shippingSpaceId, int start, int count) throws Exception;
  
	public Object listByTransportTask(YoubenbenUserContext userContext,String transportTaskId) throws Exception;
	public Object listPageByTransportTask(YoubenbenUserContext userContext,String transportTaskId, int start, int count) throws Exception;
  
	public Object listByRetailStore(YoubenbenUserContext userContext,String retailStoreId) throws Exception;
	public Object listPageByRetailStore(YoubenbenUserContext userContext,String retailStoreId, int start, int count) throws Exception;
  
	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  
	public Object listByRetailStoreOrder(YoubenbenUserContext userContext,String retailStoreOrderId) throws Exception;
	public Object listPageByRetailStoreOrder(YoubenbenUserContext userContext,String retailStoreOrderId, int start, int count) throws Exception;
  
	public Object listByPackaging(YoubenbenUserContext userContext,String packagingId) throws Exception;
	public Object listPageByPackaging(YoubenbenUserContext userContext,String packagingId, int start, int count) throws Exception;
  

}


