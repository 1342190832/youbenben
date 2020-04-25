
package com.youbenben.youbenben.goodsallocation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface GoodsAllocationManager extends BaseManager{

		

	public GoodsAllocation createGoodsAllocation(YoubenbenUserContext userContext, String location,BigDecimal latitude,BigDecimal longitude,String goodsShelfId) throws Exception;
	public GoodsAllocation updateGoodsAllocation(YoubenbenUserContext userContext,String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsAllocation loadGoodsAllocation(YoubenbenUserContext userContext, String goodsAllocationId, String [] tokensExpr) throws Exception;
	public GoodsAllocation internalSaveGoodsAllocation(YoubenbenUserContext userContext, GoodsAllocation goodsAllocation) throws Exception;
	public GoodsAllocation internalSaveGoodsAllocation(YoubenbenUserContext userContext, GoodsAllocation goodsAllocation,Map<String,Object>option) throws Exception;

	public GoodsAllocation transferToAnotherGoodsShelf(YoubenbenUserContext userContext, String goodsAllocationId, String anotherGoodsShelfId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String goodsAllocationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, GoodsAllocation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsManager getGoodsManager(YoubenbenUserContext userContext, String goodsAllocationId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String packagingId ,String [] tokensExpr)  throws Exception;

	public  GoodsAllocation addGoods(YoubenbenUserContext userContext, String goodsAllocationId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String packagingId , String [] tokensExpr)  throws Exception;
	public  GoodsAllocation removeGoods(YoubenbenUserContext userContext, String goodsAllocationId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  GoodsAllocation updateGoods(YoubenbenUserContext userContext, String goodsAllocationId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByGoodsShelf(YoubenbenUserContext userContext,String goodsShelfId) throws Exception;
	public Object listPageByGoodsShelf(YoubenbenUserContext userContext,String goodsShelfId, int start, int count) throws Exception;
  

}


