
package com.youbenben.youbenben.goodsshelf;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface GoodsShelfManager extends BaseManager{

		

	public GoodsShelf createGoodsShelf(YoubenbenUserContext userContext, String location,String storageSpaceId,String supplierSpaceId,String damageSpaceId) throws Exception;
	public GoodsShelf updateGoodsShelf(YoubenbenUserContext userContext,String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsShelf loadGoodsShelf(YoubenbenUserContext userContext, String goodsShelfId, String [] tokensExpr) throws Exception;
	public GoodsShelf internalSaveGoodsShelf(YoubenbenUserContext userContext, GoodsShelf goodsShelf) throws Exception;
	public GoodsShelf internalSaveGoodsShelf(YoubenbenUserContext userContext, GoodsShelf goodsShelf,Map<String,Object>option) throws Exception;

	public GoodsShelf transferToAnotherStorageSpace(YoubenbenUserContext userContext, String goodsShelfId, String anotherStorageSpaceId)  throws Exception;
 	public GoodsShelf transferToAnotherSupplierSpace(YoubenbenUserContext userContext, String goodsShelfId, String anotherSupplierSpaceId)  throws Exception;
 	public GoodsShelf transferToAnotherDamageSpace(YoubenbenUserContext userContext, String goodsShelfId, String anotherDamageSpaceId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String goodsShelfId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, GoodsShelf newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsShelfStockCountManager getGoodsShelfStockCountManager(YoubenbenUserContext userContext, String goodsShelfId, String title, Date countTime, String summary ,String [] tokensExpr)  throws Exception;

	public  GoodsShelf addGoodsShelfStockCount(YoubenbenUserContext userContext, String goodsShelfId, String title, Date countTime, String summary , String [] tokensExpr)  throws Exception;
	public  GoodsShelf removeGoodsShelfStockCount(YoubenbenUserContext userContext, String goodsShelfId, String goodsShelfStockCountId, int goodsShelfStockCountVersion,String [] tokensExpr)  throws Exception;
	public  GoodsShelf updateGoodsShelfStockCount(YoubenbenUserContext userContext, String goodsShelfId, String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  GoodsAllocationManager getGoodsAllocationManager(YoubenbenUserContext userContext, String goodsShelfId, String location, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  GoodsShelf addGoodsAllocation(YoubenbenUserContext userContext, String goodsShelfId, String location, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  GoodsShelf removeGoodsAllocation(YoubenbenUserContext userContext, String goodsShelfId, String goodsAllocationId, int goodsAllocationVersion,String [] tokensExpr)  throws Exception;
	public  GoodsShelf updateGoodsAllocation(YoubenbenUserContext userContext, String goodsShelfId, String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByStorageSpace(YoubenbenUserContext userContext,String storageSpaceId) throws Exception;
	public Object listPageByStorageSpace(YoubenbenUserContext userContext,String storageSpaceId, int start, int count) throws Exception;
  
	public Object listBySupplierSpace(YoubenbenUserContext userContext,String supplierSpaceId) throws Exception;
	public Object listPageBySupplierSpace(YoubenbenUserContext userContext,String supplierSpaceId, int start, int count) throws Exception;
  
	public Object listByDamageSpace(YoubenbenUserContext userContext,String damageSpaceId) throws Exception;
	public Object listPageByDamageSpace(YoubenbenUserContext userContext,String damageSpaceId, int start, int count) throws Exception;
  

}


