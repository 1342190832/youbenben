
package com.youbenben.youbenben.stockcountissuetrack;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface StockCountIssueTrackManager extends BaseManager{

		

	public StockCountIssueTrack createStockCountIssueTrack(YoubenbenUserContext userContext, String title,Date countTime,String summary,String stockCountId) throws Exception;
	public StockCountIssueTrack updateStockCountIssueTrack(YoubenbenUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public StockCountIssueTrack loadStockCountIssueTrack(YoubenbenUserContext userContext, String stockCountIssueTrackId, String [] tokensExpr) throws Exception;
	public StockCountIssueTrack internalSaveStockCountIssueTrack(YoubenbenUserContext userContext, StockCountIssueTrack stockCountIssueTrack) throws Exception;
	public StockCountIssueTrack internalSaveStockCountIssueTrack(YoubenbenUserContext userContext, StockCountIssueTrack stockCountIssueTrack,Map<String,Object>option) throws Exception;

	public StockCountIssueTrack transferToAnotherStockCount(YoubenbenUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String stockCountIssueTrackId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, StockCountIssueTrack newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByStockCount(YoubenbenUserContext userContext,String stockCountId) throws Exception;
	public Object listPageByStockCount(YoubenbenUserContext userContext,String stockCountId, int start, int count) throws Exception;
  

}


