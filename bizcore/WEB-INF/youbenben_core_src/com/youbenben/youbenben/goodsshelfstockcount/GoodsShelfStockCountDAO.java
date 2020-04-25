
package com.youbenben.youbenben.goodsshelfstockcount;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.goodsshelf.GoodsShelf;
import com.youbenben.youbenben.stockcountissuetrack.StockCountIssueTrack;

import com.youbenben.youbenben.goodsshelf.GoodsShelfDAO;
import com.youbenben.youbenben.stockcountissuetrack.StockCountIssueTrackDAO;


public interface GoodsShelfStockCountDAO extends BaseDAO{

	public SmartList<GoodsShelfStockCount> loadAll();
	public GoodsShelfStockCount load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<GoodsShelfStockCount> goodsShelfStockCountList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public GoodsShelfStockCount present(GoodsShelfStockCount goodsShelfStockCount,Map<String,Object> options) throws Exception;
	public GoodsShelfStockCount clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GoodsShelfStockCount save(GoodsShelfStockCount goodsShelfStockCount,Map<String,Object> options);
	public SmartList<GoodsShelfStockCount> saveGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList,Map<String,Object> options);
	public SmartList<GoodsShelfStockCount> removeGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList,Map<String,Object> options);
	public SmartList<GoodsShelfStockCount> findGoodsShelfStockCountWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countGoodsShelfStockCountWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countGoodsShelfStockCountWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String goodsShelfStockCountId, int version) throws Exception;
	public GoodsShelfStockCount disconnectFromAll(String goodsShelfStockCountId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public StockCountIssueTrackDAO getStockCountIssueTrackDAO();
		
	
 	public SmartList<GoodsShelfStockCount> requestCandidateGoodsShelfStockCountForStockCountIssueTrack(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public GoodsShelfStockCount planToRemoveStockCountIssueTrackList(GoodsShelfStockCount goodsShelfStockCount, String stockCountIssueTrackIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<GoodsShelfStockCount> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateGoodsShelfStockCount executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<GoodsShelfStockCount> findGoodsShelfStockCountByShelf(String goodsShelfId, Map<String,Object> options);
 	public int countGoodsShelfStockCountByShelf(String goodsShelfId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsShelfStockCountByShelfIds(String[] ids, Map<String,Object> options);
 	public SmartList<GoodsShelfStockCount> findGoodsShelfStockCountByShelf(String goodsShelfId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsShelfStockCountByShelf(SmartList<GoodsShelfStockCount> resultList, String goodsShelfId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:StockCountIssueTrack的stockCount的StockCountIssueTrackList
	public SmartList<StockCountIssueTrack> loadOurStockCountIssueTrackList(YoubenbenUserContext userContext, List<GoodsShelfStockCount> us, Map<String,Object> options) throws Exception;
	
}


