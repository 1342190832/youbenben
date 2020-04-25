
package com.youbenben.youbenben.goodssupplier;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface GoodsSupplierManager extends BaseManager{

		

	public GoodsSupplier createGoodsSupplier(YoubenbenUserContext userContext, String name,String supplyProduct,String belongToId,String contactNumber,String description) throws Exception;
	public GoodsSupplier updateGoodsSupplier(YoubenbenUserContext userContext,String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsSupplier loadGoodsSupplier(YoubenbenUserContext userContext, String goodsSupplierId, String [] tokensExpr) throws Exception;
	public GoodsSupplier internalSaveGoodsSupplier(YoubenbenUserContext userContext, GoodsSupplier goodsSupplier) throws Exception;
	public GoodsSupplier internalSaveGoodsSupplier(YoubenbenUserContext userContext, GoodsSupplier goodsSupplier,Map<String,Object>option) throws Exception;

	public GoodsSupplier transferToAnotherBelongTo(YoubenbenUserContext userContext, String goodsSupplierId, String anotherBelongToId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String goodsSupplierId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, GoodsSupplier newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SupplierProductManager getSupplierProductManager(YoubenbenUserContext userContext, String goodsSupplierId, String productName, String productDescription, String productUnit ,String [] tokensExpr)  throws Exception;

	public  GoodsSupplier addSupplierProduct(YoubenbenUserContext userContext, String goodsSupplierId, String productName, String productDescription, String productUnit , String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeSupplierProduct(YoubenbenUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateSupplierProduct(YoubenbenUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(YoubenbenUserContext userContext, String goodsSupplierId, String buyerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  GoodsSupplier addSupplyOrder(YoubenbenUserContext userContext, String goodsSupplierId, String buyerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeSupplyOrder(YoubenbenUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateSupplyOrder(YoubenbenUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountSetManager getAccountSetManager(YoubenbenUserContext userContext, String goodsSupplierId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId ,String [] tokensExpr)  throws Exception;

	public  GoodsSupplier addAccountSet(YoubenbenUserContext userContext, String goodsSupplierId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId , String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeAccountSet(YoubenbenUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateAccountSet(YoubenbenUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongTo(YoubenbenUserContext userContext,String belongToId) throws Exception;
	public Object listPageByBelongTo(YoubenbenUserContext userContext,String belongToId, int start, int count) throws Exception;
  

}


