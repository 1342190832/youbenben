
package com.youbenben.youbenben.goods;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.sku.Sku;
import com.youbenben.youbenben.smartpallet.SmartPallet;
import com.youbenben.youbenben.shippingspace.ShippingSpace;
import com.youbenben.youbenben.supplyorder.SupplyOrder;
import com.youbenben.youbenben.transporttask.TransportTask;
import com.youbenben.youbenben.receivingspace.ReceivingSpace;
import com.youbenben.youbenben.retailstoreorder.RetailStoreOrder;
import com.youbenben.youbenben.goodsallocation.GoodsAllocation;
import com.youbenben.youbenben.retailstore.RetailStore;
import com.youbenben.youbenben.goodspackaging.GoodsPackaging;
import com.youbenben.youbenben.goodsmovement.GoodsMovement;

import com.youbenben.youbenben.transporttask.TransportTaskDAO;
import com.youbenben.youbenben.goodsallocation.GoodsAllocationDAO;
import com.youbenben.youbenben.shippingspace.ShippingSpaceDAO;
import com.youbenben.youbenben.retailstore.RetailStoreDAO;
import com.youbenben.youbenben.sku.SkuDAO;
import com.youbenben.youbenben.goodspackaging.GoodsPackagingDAO;
import com.youbenben.youbenben.goodsmovement.GoodsMovementDAO;
import com.youbenben.youbenben.retailstoreorder.RetailStoreOrderDAO;
import com.youbenben.youbenben.receivingspace.ReceivingSpaceDAO;
import com.youbenben.youbenben.smartpallet.SmartPalletDAO;
import com.youbenben.youbenben.supplyorder.SupplyOrderDAO;


public interface GoodsDAO extends BaseDAO{

	public SmartList<Goods> loadAll();
	public Goods load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Goods> goodsList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Goods present(Goods goods,Map<String,Object> options) throws Exception;
	public Goods clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Goods save(Goods goods,Map<String,Object> options);
	public SmartList<Goods> saveGoodsList(SmartList<Goods> goodsList,Map<String,Object> options);
	public SmartList<Goods> removeGoodsList(SmartList<Goods> goodsList,Map<String,Object> options);
	public SmartList<Goods> findGoodsWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countGoodsWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countGoodsWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String goodsId, int version) throws Exception;
	public Goods disconnectFromAll(String goodsId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GoodsMovementDAO getGoodsMovementDAO();
		
	
 	public SmartList<Goods> requestCandidateGoodsForGoodsMovement(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Goods planToRemoveGoodsMovementList(Goods goods, String goodsMovementIds[], Map<String,Object> options)throws Exception;


	//disconnect Goods with facility_id in GoodsMovement
	public Goods planToRemoveGoodsMovementListWithFacilityId(Goods goods, String facilityIdId, Map<String,Object> options)throws Exception;
	public int countGoodsMovementListWithFacilityId(String goodsId, String facilityIdId, Map<String,Object> options)throws Exception;
	
	//disconnect Goods with session_id in GoodsMovement
	public Goods planToRemoveGoodsMovementListWithSessionId(Goods goods, String sessionIdId, Map<String,Object> options)throws Exception;
	public int countGoodsMovementListWithSessionId(String goodsId, String sessionIdId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Goods> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateGoods executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<Goods> findGoodsBySku(String skuId, Map<String,Object> options);
 	public int countGoodsBySku(String skuId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsBySkuIds(String[] ids, Map<String,Object> options);
 	public SmartList<Goods> findGoodsBySku(String skuId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsBySku(SmartList<Goods> resultList, String skuId, Map<String,Object> options);

 
  
 	public SmartList<Goods> findGoodsByReceivingSpace(String receivingSpaceId, Map<String,Object> options);
 	public int countGoodsByReceivingSpace(String receivingSpaceId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsByReceivingSpaceIds(String[] ids, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByReceivingSpace(String receivingSpaceId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsByReceivingSpace(SmartList<Goods> resultList, String receivingSpaceId, Map<String,Object> options);

 
  
 	public SmartList<Goods> findGoodsByGoodsAllocation(String goodsAllocationId, Map<String,Object> options);
 	public int countGoodsByGoodsAllocation(String goodsAllocationId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsByGoodsAllocationIds(String[] ids, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByGoodsAllocation(String goodsAllocationId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsByGoodsAllocation(SmartList<Goods> resultList, String goodsAllocationId, Map<String,Object> options);

 
  
 	public SmartList<Goods> findGoodsBySmartPallet(String smartPalletId, Map<String,Object> options);
 	public int countGoodsBySmartPallet(String smartPalletId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsBySmartPalletIds(String[] ids, Map<String,Object> options);
 	public SmartList<Goods> findGoodsBySmartPallet(String smartPalletId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsBySmartPallet(SmartList<Goods> resultList, String smartPalletId, Map<String,Object> options);

 
  
 	public SmartList<Goods> findGoodsByShippingSpace(String shippingSpaceId, Map<String,Object> options);
 	public int countGoodsByShippingSpace(String shippingSpaceId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsByShippingSpaceIds(String[] ids, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByShippingSpace(String shippingSpaceId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsByShippingSpace(SmartList<Goods> resultList, String shippingSpaceId, Map<String,Object> options);

 
  
 	public SmartList<Goods> findGoodsByTransportTask(String transportTaskId, Map<String,Object> options);
 	public int countGoodsByTransportTask(String transportTaskId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsByTransportTaskIds(String[] ids, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByTransportTask(String transportTaskId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsByTransportTask(SmartList<Goods> resultList, String transportTaskId, Map<String,Object> options);

 
  
 	public SmartList<Goods> findGoodsByRetailStore(String retailStoreId, Map<String,Object> options);
 	public int countGoodsByRetailStore(String retailStoreId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsByRetailStoreIds(String[] ids, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByRetailStore(String retailStoreId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsByRetailStore(SmartList<Goods> resultList, String retailStoreId, Map<String,Object> options);

 
  
 	public SmartList<Goods> findGoodsByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public int countGoodsByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByBizOrder(String supplyOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsByBizOrder(SmartList<Goods> resultList, String supplyOrderId, Map<String,Object> options);

 
  
 	public SmartList<Goods> findGoodsByRetailStoreOrder(String retailStoreOrderId, Map<String,Object> options);
 	public int countGoodsByRetailStoreOrder(String retailStoreOrderId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsByRetailStoreOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByRetailStoreOrder(String retailStoreOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsByRetailStoreOrder(SmartList<Goods> resultList, String retailStoreOrderId, Map<String,Object> options);

 
  
 	public SmartList<Goods> findGoodsByPackaging(String goodsPackagingId, Map<String,Object> options);
 	public int countGoodsByPackaging(String goodsPackagingId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsByPackagingIds(String[] ids, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByPackaging(String goodsPackagingId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsByPackaging(SmartList<Goods> resultList, String goodsPackagingId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:GoodsMovement的goods的GoodsMovementList
	public SmartList<GoodsMovement> loadOurGoodsMovementList(YoubenbenUserContext userContext, List<Goods> us, Map<String,Object> options) throws Exception;
	
}


