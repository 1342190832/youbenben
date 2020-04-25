
package com.doublechaintech.retailscm.goodspackaging;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.goods.Goods;


import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodspackaging.GoodsPackaging;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;






public class GoodsPackagingManagerImpl extends CustomRetailscmCheckerManager implements GoodsPackagingManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = GoodsPackagingTokens.start().withTokenFromListName(listName).done();
		GoodsPackaging  goodsPackaging = (GoodsPackaging) this.loadGoodsPackaging(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = goodsPackaging.collectRefercencesFromLists();
		goodsPackagingDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, goodsPackaging, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new GoodsPackagingGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "GoodsPackaging";
	@Override
	public GoodsPackagingDAO daoOf(RetailscmUserContext userContext) {
		return goodsPackagingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws GoodsPackagingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new GoodsPackagingManagerException(message);

	}



 	protected GoodsPackaging saveGoodsPackaging(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, String [] tokensExpr) throws Exception{	
 		//return getGoodsPackagingDAO().save(goodsPackaging, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoodsPackaging(userContext, goodsPackaging, tokens);
 	}
 	
 	protected GoodsPackaging saveGoodsPackagingDetail(RetailscmUserContext userContext, GoodsPackaging goodsPackaging) throws Exception{	

 		
 		return saveGoodsPackaging(userContext, goodsPackaging, allTokens());
 	}
 	
 	public GoodsPackaging loadGoodsPackaging(RetailscmUserContext userContext, String goodsPackagingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfGoodsPackaging(goodsPackagingId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsPackagingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsPackaging goodsPackaging = loadGoodsPackaging( userContext, goodsPackagingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsPackaging, tokens);
 	}
 	
 	
 	 public GoodsPackaging searchGoodsPackaging(RetailscmUserContext userContext, String goodsPackagingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfGoodsPackaging(goodsPackagingId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsPackagingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		GoodsPackaging goodsPackaging = loadGoodsPackaging( userContext, goodsPackagingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsPackaging, tokens);
 	}
 	
 	

 	protected GoodsPackaging present(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsPackaging,tokens);
		
		
		GoodsPackaging  goodsPackagingToPresent = goodsPackagingDaoOf(userContext).present(goodsPackaging, tokens);
		
		List<BaseEntity> entityListToNaming = goodsPackagingToPresent.collectRefercencesFromLists();
		goodsPackagingDaoOf(userContext).alias(entityListToNaming);
		
		return  goodsPackagingToPresent;
		
		
	}
 
 	
 	
 	public GoodsPackaging loadGoodsPackagingDetail(RetailscmUserContext userContext, String goodsPackagingId) throws Exception{	
 		GoodsPackaging goodsPackaging = loadGoodsPackaging( userContext, goodsPackagingId, allTokens());
 		return present(userContext,goodsPackaging, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String goodsPackagingId) throws Exception{	
 		GoodsPackaging goodsPackaging = loadGoodsPackaging( userContext, goodsPackagingId, viewTokens());
 		return present(userContext,goodsPackaging, allTokens());
		
 	}
 	protected GoodsPackaging saveGoodsPackaging(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, Map<String,Object>tokens) throws Exception{	
 		return goodsPackagingDaoOf(userContext).save(goodsPackaging, tokens);
 	}
 	protected GoodsPackaging loadGoodsPackaging(RetailscmUserContext userContext, String goodsPackagingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfGoodsPackaging(goodsPackagingId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsPackagingManagerException.class);

 
 		return goodsPackagingDaoOf(userContext).load(goodsPackagingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, Map<String, Object> tokens){
		super.addActions(userContext, goodsPackaging, tokens);
		
		addAction(userContext, goodsPackaging, tokens,"@create","createGoodsPackaging","createGoodsPackaging/","main","primary");
		addAction(userContext, goodsPackaging, tokens,"@update","updateGoodsPackaging","updateGoodsPackaging/"+goodsPackaging.getId()+"/","main","primary");
		addAction(userContext, goodsPackaging, tokens,"@copy","cloneGoodsPackaging","cloneGoodsPackaging/"+goodsPackaging.getId()+"/","main","primary");
		
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.addGoods","addGoods","addGoods/"+goodsPackaging.getId()+"/","goodsList","primary");
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.removeGoods","removeGoods","removeGoods/"+goodsPackaging.getId()+"/","goodsList","primary");
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.updateGoods","updateGoods","updateGoods/"+goodsPackaging.getId()+"/","goodsList","primary");
		addAction(userContext, goodsPackaging, tokens,"goods_packaging.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+goodsPackaging.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public GoodsPackaging createGoodsPackaging(RetailscmUserContext userContext, String packageName,String rfid,Date packageTime,String description) throws Exception
	//public GoodsPackaging createGoodsPackaging(RetailscmUserContext userContext,String packageName, String rfid, Date packageTime, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkPackageNameOfGoodsPackaging(packageName);
		checkerOf(userContext).checkRfidOfGoodsPackaging(rfid);
		checkerOf(userContext).checkPackageTimeOfGoodsPackaging(packageTime);
		checkerOf(userContext).checkDescriptionOfGoodsPackaging(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsPackagingManagerException.class);


		GoodsPackaging goodsPackaging=createNewGoodsPackaging();	

		goodsPackaging.setPackageName(packageName);
		goodsPackaging.setRfid(rfid);
		goodsPackaging.setPackageTime(packageTime);
		goodsPackaging.setDescription(description);

		goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, emptyOptions());
		
		onNewInstanceCreated(userContext, goodsPackaging);
		return goodsPackaging;


	}
	protected GoodsPackaging createNewGoodsPackaging()
	{

		return new GoodsPackaging();
	}

	protected void checkParamsForUpdatingGoodsPackaging(RetailscmUserContext userContext,String goodsPackagingId, int goodsPackagingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfGoodsPackaging(goodsPackagingId);
		checkerOf(userContext).checkVersionOfGoodsPackaging( goodsPackagingVersion);
		

		if(GoodsPackaging.PACKAGE_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPackageNameOfGoodsPackaging(parseString(newValueExpr));
		
			
		}
		if(GoodsPackaging.RFID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRfidOfGoodsPackaging(parseString(newValueExpr));
		
			
		}
		if(GoodsPackaging.PACKAGE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPackageTimeOfGoodsPackaging(parseDate(newValueExpr));
		
			
		}
		if(GoodsPackaging.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfGoodsPackaging(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsPackagingManagerException.class);


	}



	public GoodsPackaging clone(RetailscmUserContext userContext, String fromGoodsPackagingId) throws Exception{

		return goodsPackagingDaoOf(userContext).clone(fromGoodsPackagingId, this.allTokens());
	}

	public GoodsPackaging internalSaveGoodsPackaging(RetailscmUserContext userContext, GoodsPackaging goodsPackaging) throws Exception
	{
		return internalSaveGoodsPackaging(userContext, goodsPackaging, allTokens());

	}
	public GoodsPackaging internalSaveGoodsPackaging(RetailscmUserContext userContext, GoodsPackaging goodsPackaging, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingGoodsPackaging(userContext, goodsPackagingId, goodsPackagingVersion, property, newValueExpr, tokensExpr);


		synchronized(goodsPackaging){
			//will be good when the goodsPackaging loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsPackaging.
			if (goodsPackaging.isChanged()){
			
			}
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, options);
			return goodsPackaging;

		}

	}

	public GoodsPackaging updateGoodsPackaging(RetailscmUserContext userContext,String goodsPackagingId, int goodsPackagingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsPackaging(userContext, goodsPackagingId, goodsPackagingVersion, property, newValueExpr, tokensExpr);



		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		if(goodsPackaging.getVersion() != goodsPackagingVersion){
			String message = "The target version("+goodsPackaging.getVersion()+") is not equals to version("+goodsPackagingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goodsPackaging){
			//will be good when the goodsPackaging loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsPackaging.
			
			goodsPackaging.changeProperty(property, newValueExpr);
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().done());
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
			//return saveGoodsPackaging(userContext, goodsPackaging, tokens().done());
		}

	}

	public GoodsPackaging updateGoodsPackagingProperty(RetailscmUserContext userContext,String goodsPackagingId, int goodsPackagingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsPackaging(userContext, goodsPackagingId, goodsPackagingVersion, property, newValueExpr, tokensExpr);

		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		if(goodsPackaging.getVersion() != goodsPackagingVersion){
			String message = "The target version("+goodsPackaging.getVersion()+") is not equals to version("+goodsPackagingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goodsPackaging){
			//will be good when the goodsPackaging loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsPackaging.

			goodsPackaging.changeProperty(property, newValueExpr);
			
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().done());
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
			//return saveGoodsPackaging(userContext, goodsPackaging, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected GoodsPackagingTokens tokens(){
		return GoodsPackagingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsPackagingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsPackagingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String goodsPackagingId, int goodsPackagingVersion) throws Exception {
		//deleteInternal(userContext, goodsPackagingId, goodsPackagingVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String goodsPackagingId, int goodsPackagingVersion) throws Exception{

		goodsPackagingDaoOf(userContext).delete(goodsPackagingId, goodsPackagingVersion);
	}

	public GoodsPackaging forgetByAll(RetailscmUserContext userContext, String goodsPackagingId, int goodsPackagingVersion) throws Exception {
		return forgetByAllInternal(userContext, goodsPackagingId, goodsPackagingVersion);
	}
	protected GoodsPackaging forgetByAllInternal(RetailscmUserContext userContext,
			String goodsPackagingId, int goodsPackagingVersion) throws Exception{

		return goodsPackagingDaoOf(userContext).disconnectFromAll(goodsPackagingId, goodsPackagingVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsPackagingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return goodsPackagingDaoOf(userContext).deleteAll();
	}


	//disconnect GoodsPackaging with sku in Goods
	protected GoodsPackaging breakWithGoodsBySku(RetailscmUserContext userContext, String goodsPackagingId, String skuId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsPackagingDaoOf(userContext).planToRemoveGoodsListWithSku(goodsPackaging, skuId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with receiving_space in Goods
	protected GoodsPackaging breakWithGoodsByReceivingSpace(RetailscmUserContext userContext, String goodsPackagingId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsPackagingDaoOf(userContext).planToRemoveGoodsListWithReceivingSpace(goodsPackaging, receivingSpaceId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with goods_allocation in Goods
	protected GoodsPackaging breakWithGoodsByGoodsAllocation(RetailscmUserContext userContext, String goodsPackagingId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsPackagingDaoOf(userContext).planToRemoveGoodsListWithGoodsAllocation(goodsPackaging, goodsAllocationId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with smart_pallet in Goods
	protected GoodsPackaging breakWithGoodsBySmartPallet(RetailscmUserContext userContext, String goodsPackagingId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsPackagingDaoOf(userContext).planToRemoveGoodsListWithSmartPallet(goodsPackaging, smartPalletId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with shipping_space in Goods
	protected GoodsPackaging breakWithGoodsByShippingSpace(RetailscmUserContext userContext, String goodsPackagingId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsPackagingDaoOf(userContext).planToRemoveGoodsListWithShippingSpace(goodsPackaging, shippingSpaceId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with transport_task in Goods
	protected GoodsPackaging breakWithGoodsByTransportTask(RetailscmUserContext userContext, String goodsPackagingId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsPackagingDaoOf(userContext).planToRemoveGoodsListWithTransportTask(goodsPackaging, transportTaskId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with retail_store in Goods
	protected GoodsPackaging breakWithGoodsByRetailStore(RetailscmUserContext userContext, String goodsPackagingId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsPackagingDaoOf(userContext).planToRemoveGoodsListWithRetailStore(goodsPackaging, retailStoreId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with biz_order in Goods
	protected GoodsPackaging breakWithGoodsByBizOrder(RetailscmUserContext userContext, String goodsPackagingId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsPackagingDaoOf(userContext).planToRemoveGoodsListWithBizOrder(goodsPackaging, bizOrderId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}
	//disconnect GoodsPackaging with retail_store_order in Goods
	protected GoodsPackaging breakWithGoodsByRetailStoreOrder(RetailscmUserContext userContext, String goodsPackagingId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());

			synchronized(goodsPackaging){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsPackagingDaoOf(userContext).planToRemoveGoodsListWithRetailStoreOrder(goodsPackaging, retailStoreOrderId, this.emptyOptions());

				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				return goodsPackaging;
			}
	}






	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String goodsPackagingId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfGoodsPackaging(goodsPackagingId);

		
		checkerOf(userContext).checkNameOfGoods(name);
		
		checkerOf(userContext).checkRfidOfGoods(rfid);
		
		checkerOf(userContext).checkUomOfGoods(uom);
		
		checkerOf(userContext).checkMaxPackageOfGoods(maxPackage);
		
		checkerOf(userContext).checkExpireTimeOfGoods(expireTime);
		
		checkerOf(userContext).checkSkuIdOfGoods(skuId);
		
		checkerOf(userContext).checkReceivingSpaceIdOfGoods(receivingSpaceId);
		
		checkerOf(userContext).checkGoodsAllocationIdOfGoods(goodsAllocationId);
		
		checkerOf(userContext).checkSmartPalletIdOfGoods(smartPalletId);
		
		checkerOf(userContext).checkShippingSpaceIdOfGoods(shippingSpaceId);
		
		checkerOf(userContext).checkTransportTaskIdOfGoods(transportTaskId);
		
		checkerOf(userContext).checkRetailStoreIdOfGoods(retailStoreId);
		
		checkerOf(userContext).checkBizOrderIdOfGoods(bizOrderId);
		
		checkerOf(userContext).checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsPackagingManagerException.class);


	}
	public  GoodsPackaging addGoods(RetailscmUserContext userContext, String goodsPackagingId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingGoods(userContext,goodsPackagingId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);

		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId);

		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, emptyOptions());
		synchronized(goodsPackaging){
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsPackaging.addGoods( goods );
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, goods);
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String goodsPackagingId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGoodsPackaging(goodsPackagingId);
		checkerOf(userContext).checkIdOfGoods(id);

		checkerOf(userContext).checkNameOfGoods( name);
		checkerOf(userContext).checkRfidOfGoods( rfid);
		checkerOf(userContext).checkUomOfGoods( uom);
		checkerOf(userContext).checkMaxPackageOfGoods( maxPackage);
		checkerOf(userContext).checkExpireTimeOfGoods( expireTime);

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsPackagingManagerException.class);

	}
	public  GoodsPackaging updateGoodsProperties(RetailscmUserContext userContext, String goodsPackagingId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsProperties(userContext,goodsPackagingId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, "is", id).done();

		GoodsPackaging goodsPackagingToUpdate = loadGoodsPackaging(userContext, goodsPackagingId, options);

		if(goodsPackagingToUpdate.getGoodsList().isEmpty()){
			throw new GoodsPackagingManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}

		Goods item = goodsPackagingToUpdate.getGoodsList().first();

		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );


		//checkParamsForAddingGoods(userContext,goodsPackagingId,name, code, used,tokensExpr);
		GoodsPackaging goodsPackaging = saveGoodsPackaging(userContext, goodsPackagingToUpdate, tokens().withGoodsList().done());
		synchronized(goodsPackaging){
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}
	}


	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
		Sku  sku = new Sku();
		sku.setId(skuId);		
		goods.setSku(sku);		
		ReceivingSpace  receivingSpace = new ReceivingSpace();
		receivingSpace.setId(receivingSpaceId);		
		goods.setReceivingSpace(receivingSpace);		
		GoodsAllocation  goodsAllocation = new GoodsAllocation();
		goodsAllocation.setId(goodsAllocationId);		
		goods.setGoodsAllocation(goodsAllocation);		
		SmartPallet  smartPallet = new SmartPallet();
		smartPallet.setId(smartPalletId);		
		goods.setSmartPallet(smartPallet);		
		ShippingSpace  shippingSpace = new ShippingSpace();
		shippingSpace.setId(shippingSpaceId);		
		goods.setShippingSpace(shippingSpace);		
		TransportTask  transportTask = new TransportTask();
		transportTask.setId(transportTaskId);		
		goods.setTransportTask(transportTask);		
		RetailStore  retailStore = new RetailStore();
		retailStore.setId(retailStoreId);		
		goods.setRetailStore(retailStore);		
		SupplyOrder  bizOrder = new SupplyOrder();
		bizOrder.setId(bizOrderId);		
		goods.setBizOrder(bizOrder);		
		RetailStoreOrder  retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(retailStoreOrderId);		
		goods.setRetailStoreOrder(retailStoreOrder);
	
		
		return goods;


	}

	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;

	}

	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String goodsPackagingId,
			String goodsIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGoodsPackaging(goodsPackagingId);
		for(String goodsIdItem: goodsIds){
			checkerOf(userContext).checkIdOfGoods(goodsIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsPackagingManagerException.class);

	}
	public  GoodsPackaging removeGoodsList(RetailscmUserContext userContext, String goodsPackagingId,
			String goodsIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsList(userContext, goodsPackagingId,  goodsIds, tokensExpr);


			GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
			synchronized(goodsPackaging){
				//Will be good when the goodsPackaging loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				goodsPackagingDaoOf(userContext).planToRemoveGoodsList(goodsPackaging, goodsIds, allTokens());
				goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, goodsPackaging.getGoodsList());
				return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String goodsPackagingId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoodsPackaging( goodsPackagingId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsPackagingManagerException.class);

	}
	public  GoodsPackaging removeGoods(RetailscmUserContext userContext, String goodsPackagingId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingGoods(userContext,goodsPackagingId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		synchronized(goodsPackaging){
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsPackaging.removeGoods( goods );
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String goodsPackagingId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoodsPackaging( goodsPackagingId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsPackagingManagerException.class);

	}
	public  GoodsPackaging copyGoodsFrom(RetailscmUserContext userContext, String goodsPackagingId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingGoods(userContext,goodsPackagingId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, allTokens());
		synchronized(goodsPackaging){
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			goodsPackaging.copyGoodsFrom( goods );
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, (Goods)goodsPackaging.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfGoodsPackaging(goodsPackagingId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		

		if(Goods.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfGoods(parseString(newValueExpr));
		
		}
		
		if(Goods.RFID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRfidOfGoods(parseString(newValueExpr));
		
		}
		
		if(Goods.UOM_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUomOfGoods(parseString(newValueExpr));
		
		}
		
		if(Goods.MAX_PACKAGE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMaxPackageOfGoods(parseInt(newValueExpr));
		
		}
		
		if(Goods.EXPIRE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkExpireTimeOfGoods(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsPackagingManagerException.class);

	}

	public  GoodsPackaging updateGoods(RetailscmUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoods(userContext, goodsPackagingId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, "eq", goodsId).done();



		GoodsPackaging goodsPackaging = loadGoodsPackaging(userContext, goodsPackagingId, loadTokens);

		synchronized(goodsPackaging){
			//Will be good when the goodsPackaging loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsPackaging.removeGoods( goods );
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);

			Goods goods = goodsPackaging.findTheGoods(goodsIndex);
			if(goods == null){
				throw new GoodsPackagingManagerException(goods+" is NOT FOUND" );
			}

			goods.changeProperty(property, newValueExpr);
			
			goodsPackaging = saveGoodsPackaging(userContext, goodsPackaging, tokens().withGoodsList().done());
			return present(userContext,goodsPackaging, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsPackaging newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   GoodsPackaging newGoodsPackaging = this.createGoodsPackaging(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newGoodsPackaging
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, GoodsPackaging.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<GoodsPackaging> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String goodsPackagingId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getGoodsPackagingDetailScope().clone();
		GoodsPackaging merchantObj = (GoodsPackaging) this.view(userContext, goodsPackagingId);
    String merchantObjId = goodsPackagingId;
    String linkToUrl =	"goodsPackagingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "货物包装"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-packageName")
				    .put("fieldName", "packageName")
				    .put("label", "包的名字")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("packageName", merchantObj.getPackageName());

		propList.add(
				MapUtil.put("id", "3-rfid")
				    .put("fieldName", "rfid")
				    .put("label", "RFID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("rfid", merchantObj.getRfid());

		propList.add(
				MapUtil.put("id", "4-packageTime")
				    .put("fieldName", "packageTime")
				    .put("label", "包的时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("packageTime", merchantObj.getPackageTime());

		propList.add(
				MapUtil.put("id", "5-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		//处理 sectionList

		//处理Section：goodsListSection
		Map goodsListSection = ListofUtils.buildSection(
		    "goodsListSection",
		    "商品列表",
		    null,
		    "",
		    "__no_group",
		    "goodsManager/listByPackaging/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(goodsListSection);

		result.put("goodsListSection", ListofUtils.toShortList(merchantObj.getGoodsList(), "goods"));
		vscope.field("goodsListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Goods.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


