
package com.youbenben.youbenben.goodspackaging;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface GoodsPackagingManager extends BaseManager{

		

	public GoodsPackaging createGoodsPackaging(YoubenbenUserContext userContext, String packageName,String rfid,Date packageTime,String description) throws Exception;
	public GoodsPackaging updateGoodsPackaging(YoubenbenUserContext userContext,String goodsPackagingId, int goodsPackagingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsPackaging loadGoodsPackaging(YoubenbenUserContext userContext, String goodsPackagingId, String [] tokensExpr) throws Exception;
	public GoodsPackaging internalSaveGoodsPackaging(YoubenbenUserContext userContext, GoodsPackaging goodsPackaging) throws Exception;
	public GoodsPackaging internalSaveGoodsPackaging(YoubenbenUserContext userContext, GoodsPackaging goodsPackaging,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String goodsPackagingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, GoodsPackaging newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsManager getGoodsManager(YoubenbenUserContext userContext, String goodsPackagingId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;

	public  GoodsPackaging addGoods(YoubenbenUserContext userContext, String goodsPackagingId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId , String [] tokensExpr)  throws Exception;
	public  GoodsPackaging removeGoods(YoubenbenUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  GoodsPackaging updateGoods(YoubenbenUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


