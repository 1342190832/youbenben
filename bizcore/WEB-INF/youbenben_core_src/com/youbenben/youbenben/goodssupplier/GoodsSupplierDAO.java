
package com.youbenben.youbenben.goodssupplier;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.supplierproduct.SupplierProduct;
import com.youbenben.youbenben.supplyorder.SupplyOrder;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;
import com.youbenben.youbenben.accountset.AccountSet;

import com.youbenben.youbenben.accountset.AccountSetDAO;
import com.youbenben.youbenben.supplierproduct.SupplierProductDAO;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.youbenben.youbenben.supplyorder.SupplyOrderDAO;


public interface GoodsSupplierDAO extends BaseDAO{

	public SmartList<GoodsSupplier> loadAll();
	public GoodsSupplier load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<GoodsSupplier> goodsSupplierList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public GoodsSupplier present(GoodsSupplier goodsSupplier,Map<String,Object> options) throws Exception;
	public GoodsSupplier clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GoodsSupplier save(GoodsSupplier goodsSupplier,Map<String,Object> options);
	public SmartList<GoodsSupplier> saveGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList,Map<String,Object> options);
	public SmartList<GoodsSupplier> removeGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList,Map<String,Object> options);
	public SmartList<GoodsSupplier> findGoodsSupplierWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countGoodsSupplierWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countGoodsSupplierWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String goodsSupplierId, int version) throws Exception;
	public GoodsSupplier disconnectFromAll(String goodsSupplierId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public SupplierProductDAO getSupplierProductDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	public AccountSetDAO getAccountSetDAO();
		
	
 	public SmartList<GoodsSupplier> requestCandidateGoodsSupplierForSupplierProduct(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<GoodsSupplier> requestCandidateGoodsSupplierForSupplyOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<GoodsSupplier> requestCandidateGoodsSupplierForAccountSet(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public GoodsSupplier planToRemoveSupplierProductList(GoodsSupplier goodsSupplier, String supplierProductIds[], Map<String,Object> options)throws Exception;


	public GoodsSupplier planToRemoveSupplyOrderList(GoodsSupplier goodsSupplier, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect GoodsSupplier with buyer in SupplyOrder
	public GoodsSupplier planToRemoveSupplyOrderListWithBuyer(GoodsSupplier goodsSupplier, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String goodsSupplierId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsSupplier with confirmation in SupplyOrder
	public GoodsSupplier planToRemoveSupplyOrderListWithConfirmation(GoodsSupplier goodsSupplier, String confirmationId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithConfirmation(String goodsSupplierId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsSupplier with approval in SupplyOrder
	public GoodsSupplier planToRemoveSupplyOrderListWithApproval(GoodsSupplier goodsSupplier, String approvalId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithApproval(String goodsSupplierId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsSupplier with processing in SupplyOrder
	public GoodsSupplier planToRemoveSupplyOrderListWithProcessing(GoodsSupplier goodsSupplier, String processingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithProcessing(String goodsSupplierId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsSupplier with picking in SupplyOrder
	public GoodsSupplier planToRemoveSupplyOrderListWithPicking(GoodsSupplier goodsSupplier, String pickingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithPicking(String goodsSupplierId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsSupplier with shipment in SupplyOrder
	public GoodsSupplier planToRemoveSupplyOrderListWithShipment(GoodsSupplier goodsSupplier, String shipmentId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithShipment(String goodsSupplierId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsSupplier with delivery in SupplyOrder
	public GoodsSupplier planToRemoveSupplyOrderListWithDelivery(GoodsSupplier goodsSupplier, String deliveryId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithDelivery(String goodsSupplierId, String deliveryId, Map<String,Object> options)throws Exception;
	
	public GoodsSupplier planToRemoveAccountSetList(GoodsSupplier goodsSupplier, String accountSetIds[], Map<String,Object> options)throws Exception;


	//disconnect GoodsSupplier with country_center in AccountSet
	public GoodsSupplier planToRemoveAccountSetListWithCountryCenter(GoodsSupplier goodsSupplier, String countryCenterId, Map<String,Object> options)throws Exception;
	public int countAccountSetListWithCountryCenter(String goodsSupplierId, String countryCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsSupplier with retail_store in AccountSet
	public GoodsSupplier planToRemoveAccountSetListWithRetailStore(GoodsSupplier goodsSupplier, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countAccountSetListWithRetailStore(String goodsSupplierId, String retailStoreId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<GoodsSupplier> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateGoodsSupplier executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<GoodsSupplier> findGoodsSupplierByBelongTo(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countGoodsSupplierByBelongTo(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsSupplierByBelongToIds(String[] ids, Map<String,Object> options);
 	public SmartList<GoodsSupplier> findGoodsSupplierByBelongTo(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsSupplierByBelongTo(SmartList<GoodsSupplier> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:SupplierProduct的supplier的SupplierProductList
	public SmartList<SupplierProduct> loadOurSupplierProductList(YoubenbenUserContext userContext, List<GoodsSupplier> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrder的seller的SupplyOrderList
	public SmartList<SupplyOrder> loadOurSupplyOrderList(YoubenbenUserContext userContext, List<GoodsSupplier> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:AccountSet的goodsSupplier的AccountSetList
	public SmartList<AccountSet> loadOurAccountSetList(YoubenbenUserContext userContext, List<GoodsSupplier> us, Map<String,Object> options) throws Exception;
	
}


