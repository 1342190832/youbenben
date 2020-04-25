
package com.youbenben.youbenben.goodsshelfstockcount;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface GoodsShelfStockCountManager extends BaseManager{

		

	public GoodsShelfStockCount createGoodsShelfStockCount(YoubenbenUserContext userContext, String title,Date countTime,String summary,String shelfId) throws Exception;
	public GoodsShelfStockCount updateGoodsShelfStockCount(YoubenbenUserContext userContext,String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsShelfStockCount loadGoodsShelfStockCount(YoubenbenUserContext userContext, String goodsShelfStockCountId, String [] tokensExpr) throws Exception;
	public GoodsShelfStockCount internalSaveGoodsShelfStockCount(YoubenbenUserContext userContext, GoodsShelfStockCount goodsShelfStockCount) throws Exception;
	public GoodsShelfStockCount internalSaveGoodsShelfStockCount(YoubenbenUserContext userContext, GoodsShelfStockCount goodsShelfStockCount,Map<String,Object>option) throws Exception;

	public GoodsShelfStockCount transferToAnotherShelf(YoubenbenUserContext userContext, String goodsShelfStockCountId, String anotherShelfId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String goodsShelfStockCountId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, GoodsShelfStockCount newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  StockCountIssueTrackManager getStockCountIssueTrackManager(YoubenbenUserContext userContext, String goodsShelfStockCountId, String title, Date countTime, String summary ,String [] tokensExpr)  throws Exception;

	public  GoodsShelfStockCount addStockCountIssueTrack(YoubenbenUserContext userContext, String goodsShelfStockCountId, String title, Date countTime, String summary , String [] tokensExpr)  throws Exception;
	public  GoodsShelfStockCount removeStockCountIssueTrack(YoubenbenUserContext userContext, String goodsShelfStockCountId, String stockCountIssueTrackId, int stockCountIssueTrackVersion,String [] tokensExpr)  throws Exception;
	public  GoodsShelfStockCount updateStockCountIssueTrack(YoubenbenUserContext userContext, String goodsShelfStockCountId, String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByShelf(YoubenbenUserContext userContext,String shelfId) throws Exception;
	public Object listPageByShelf(YoubenbenUserContext userContext,String shelfId, int start, int count) throws Exception;
  

}


