
package com.youbenben.youbenben.stockcountissuetrack;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.goodsshelfstockcount.GoodsShelfStockCount;

import com.youbenben.youbenben.goodsshelfstockcount.GoodsShelfStockCountDAO;


public interface StockCountIssueTrackDAO extends BaseDAO{

	public SmartList<StockCountIssueTrack> loadAll();
	public StockCountIssueTrack load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<StockCountIssueTrack> stockCountIssueTrackList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public StockCountIssueTrack present(StockCountIssueTrack stockCountIssueTrack,Map<String,Object> options) throws Exception;
	public StockCountIssueTrack clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public StockCountIssueTrack save(StockCountIssueTrack stockCountIssueTrack,Map<String,Object> options);
	public SmartList<StockCountIssueTrack> saveStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList,Map<String,Object> options);
	public SmartList<StockCountIssueTrack> removeStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList,Map<String,Object> options);
	public SmartList<StockCountIssueTrack> findStockCountIssueTrackWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countStockCountIssueTrackWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countStockCountIssueTrackWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String stockCountIssueTrackId, int version) throws Exception;
	public StockCountIssueTrack disconnectFromAll(String stockCountIssueTrackId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<StockCountIssueTrack> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateStockCountIssueTrack executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<StockCountIssueTrack> findStockCountIssueTrackByStockCount(String goodsShelfStockCountId, Map<String,Object> options);
 	public int countStockCountIssueTrackByStockCount(String goodsShelfStockCountId, Map<String,Object> options);
 	public Map<String, Integer> countStockCountIssueTrackByStockCountIds(String[] ids, Map<String,Object> options);
 	public SmartList<StockCountIssueTrack> findStockCountIssueTrackByStockCount(String goodsShelfStockCountId, int start, int count, Map<String,Object> options);
 	public void analyzeStockCountIssueTrackByStockCount(SmartList<StockCountIssueTrack> resultList, String goodsShelfStockCountId, Map<String,Object> options);

 
 
}


