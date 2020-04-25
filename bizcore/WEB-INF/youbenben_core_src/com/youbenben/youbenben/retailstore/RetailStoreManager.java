
package com.youbenben.youbenben.retailstore;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreManager extends BaseManager{

		

	public RetailStore createRetailStore(YoubenbenUserContext userContext, String name,String telephone,String owner,String retailStoreCountryCenterId,String cityServiceCenterId,String creationId,String investmentInvitationId,String franchisingId,String decorationId,String openingId,String closingId,Date founded,BigDecimal latitude,BigDecimal longitude,String description) throws Exception;
	public RetailStore updateRetailStore(YoubenbenUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStore loadRetailStore(YoubenbenUserContext userContext, String retailStoreId, String [] tokensExpr) throws Exception;
	public RetailStore internalSaveRetailStore(YoubenbenUserContext userContext, RetailStore retailStore) throws Exception;
	public RetailStore internalSaveRetailStore(YoubenbenUserContext userContext, RetailStore retailStore,Map<String,Object>option) throws Exception;

	public RetailStore transferToAnotherRetailStoreCountryCenter(YoubenbenUserContext userContext, String retailStoreId, String anotherRetailStoreCountryCenterId)  throws Exception;
 	public RetailStore transferToAnotherCityServiceCenter(YoubenbenUserContext userContext, String retailStoreId, String anotherCityServiceCenterId)  throws Exception;
 	public RetailStore transferToAnotherCreation(YoubenbenUserContext userContext, String retailStoreId, String anotherCreationId)  throws Exception;
 	public RetailStore transferToAnotherInvestmentInvitation(YoubenbenUserContext userContext, String retailStoreId, String anotherInvestmentInvitationId)  throws Exception;
 	public RetailStore transferToAnotherFranchising(YoubenbenUserContext userContext, String retailStoreId, String anotherFranchisingId)  throws Exception;
 	public RetailStore transferToAnotherDecoration(YoubenbenUserContext userContext, String retailStoreId, String anotherDecorationId)  throws Exception;
 	public RetailStore transferToAnotherOpening(YoubenbenUserContext userContext, String retailStoreId, String anotherOpeningId)  throws Exception;
 	public RetailStore transferToAnotherClosing(YoubenbenUserContext userContext, String retailStoreId, String anotherClosingId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStore newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(YoubenbenUserContext userContext, String retailStoreId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStore addConsumerOrder(YoubenbenUserContext userContext, String retailStoreId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStore removeConsumerOrder(YoubenbenUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateConsumerOrder(YoubenbenUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreOrderManager getRetailStoreOrderManager(YoubenbenUserContext userContext, String retailStoreId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  RetailStore addRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  RetailStore removeRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  GoodsManager getGoodsManager(YoubenbenUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId, String packagingId ,String [] tokensExpr)  throws Exception;

	public  RetailStore addGoods(YoubenbenUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId, String packagingId , String [] tokensExpr)  throws Exception;
	public  RetailStore removeGoods(YoubenbenUserContext userContext, String retailStoreId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateGoods(YoubenbenUserContext userContext, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportTaskManager getTransportTaskManager(YoubenbenUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  RetailStore addTransportTask(YoubenbenUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  RetailStore removeTransportTask(YoubenbenUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateTransportTask(YoubenbenUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountSetManager getAccountSetManager(YoubenbenUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId ,String [] tokensExpr)  throws Exception;

	public  RetailStore addAccountSet(YoubenbenUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId , String [] tokensExpr)  throws Exception;
	public  RetailStore removeAccountSet(YoubenbenUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateAccountSet(YoubenbenUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByRetailStoreCountryCenter(YoubenbenUserContext userContext,String retailStoreCountryCenterId) throws Exception;
	public Object listPageByRetailStoreCountryCenter(YoubenbenUserContext userContext,String retailStoreCountryCenterId, int start, int count) throws Exception;
  
	public Object listByCityServiceCenter(YoubenbenUserContext userContext,String cityServiceCenterId) throws Exception;
	public Object listPageByCityServiceCenter(YoubenbenUserContext userContext,String cityServiceCenterId, int start, int count) throws Exception;
  
	public Object listByCreation(YoubenbenUserContext userContext,String creationId) throws Exception;
	public Object listPageByCreation(YoubenbenUserContext userContext,String creationId, int start, int count) throws Exception;
  
	public Object listByInvestmentInvitation(YoubenbenUserContext userContext,String investmentInvitationId) throws Exception;
	public Object listPageByInvestmentInvitation(YoubenbenUserContext userContext,String investmentInvitationId, int start, int count) throws Exception;
  
	public Object listByFranchising(YoubenbenUserContext userContext,String franchisingId) throws Exception;
	public Object listPageByFranchising(YoubenbenUserContext userContext,String franchisingId, int start, int count) throws Exception;
  
	public Object listByDecoration(YoubenbenUserContext userContext,String decorationId) throws Exception;
	public Object listPageByDecoration(YoubenbenUserContext userContext,String decorationId, int start, int count) throws Exception;
  
	public Object listByOpening(YoubenbenUserContext userContext,String openingId) throws Exception;
	public Object listPageByOpening(YoubenbenUserContext userContext,String openingId, int start, int count) throws Exception;
  
	public Object listByClosing(YoubenbenUserContext userContext,String closingId) throws Exception;
	public Object listPageByClosing(YoubenbenUserContext userContext,String closingId, int start, int count) throws Exception;
  

}


