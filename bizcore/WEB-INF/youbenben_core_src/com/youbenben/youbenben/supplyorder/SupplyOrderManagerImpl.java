
package com.youbenben.youbenben.supplyorder;

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

import com.youbenben.youbenben.*;
import com.youbenben.youbenben.tree.*;
import com.youbenben.youbenben.treenode.*;
import com.youbenben.youbenben.YoubenbenUserContextImpl;
import com.youbenben.youbenben.iamservice.*;
import com.youbenben.youbenben.services.IamService;
import com.youbenben.youbenben.secuser.SecUser;
import com.youbenben.youbenben.userapp.UserApp;
import com.youbenben.youbenben.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.youbenben.youbenben.goodssupplier.GoodsSupplier;
import com.youbenben.youbenben.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDelivery;
import com.youbenben.youbenben.supplyorderapproval.SupplyOrderApproval;
import com.youbenben.youbenben.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.youbenben.youbenben.goods.Goods;
import com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmation;
import com.youbenben.youbenben.supplyorderpicking.SupplyOrderPicking;
import com.youbenben.youbenben.supplyorderlineitem.SupplyOrderLineItem;
import com.youbenben.youbenben.supplyordershipment.SupplyOrderShipment;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;
import com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessing;

import com.youbenben.youbenben.goodssupplier.CandidateGoodsSupplier;
import com.youbenben.youbenben.supplyorderdelivery.CandidateSupplyOrderDelivery;
import com.youbenben.youbenben.supplyorderapproval.CandidateSupplyOrderApproval;
import com.youbenben.youbenben.supplyorderconfirmation.CandidateSupplyOrderConfirmation;
import com.youbenben.youbenben.supplyorderpicking.CandidateSupplyOrderPicking;
import com.youbenben.youbenben.supplyordershipment.CandidateSupplyOrderShipment;
import com.youbenben.youbenben.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.youbenben.youbenben.supplyorderprocessing.CandidateSupplyOrderProcessing;

import com.youbenben.youbenben.sku.Sku;
import com.youbenben.youbenben.smartpallet.SmartPallet;
import com.youbenben.youbenben.supplyorder.SupplyOrder;
import com.youbenben.youbenben.shippingspace.ShippingSpace;
import com.youbenben.youbenben.transporttask.TransportTask;
import com.youbenben.youbenben.receivingspace.ReceivingSpace;
import com.youbenben.youbenben.retailstoreorder.RetailStoreOrder;
import com.youbenben.youbenben.goodsallocation.GoodsAllocation;
import com.youbenben.youbenben.retailstore.RetailStore;
import com.youbenben.youbenben.goodspackaging.GoodsPackaging;






public class SupplyOrderManagerImpl extends CustomYoubenbenCheckerManager implements SupplyOrderManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = SupplyOrderTokens.start().withTokenFromListName(listName).done();
		SupplyOrder  supplyOrder = (SupplyOrder) this.loadSupplyOrder(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = supplyOrder.collectRefercencesFromLists();
		supplyOrderDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, supplyOrder, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new SupplyOrderGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "SupplyOrder";
	@Override
	public SupplyOrderDAO daoOf(YoubenbenUserContext userContext) {
		return supplyOrderDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws SupplyOrderManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderManagerException(message);

	}



 	protected SupplyOrder saveSupplyOrder(YoubenbenUserContext userContext, SupplyOrder supplyOrder, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderDAO().save(supplyOrder, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrder(userContext, supplyOrder, tokens);
 	}
 	
 	protected SupplyOrder saveSupplyOrderDetail(YoubenbenUserContext userContext, SupplyOrder supplyOrder) throws Exception{	

 		
 		return saveSupplyOrder(userContext, supplyOrder, allTokens());
 	}
 	
 	public SupplyOrder loadSupplyOrder(YoubenbenUserContext userContext, String supplyOrderId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrder supplyOrder = loadSupplyOrder( userContext, supplyOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrder, tokens);
 	}
 	
 	
 	 public SupplyOrder searchSupplyOrder(YoubenbenUserContext userContext, String supplyOrderId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrder supplyOrder = loadSupplyOrder( userContext, supplyOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrder, tokens);
 	}
 	
 	

 	protected SupplyOrder present(YoubenbenUserContext userContext, SupplyOrder supplyOrder, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrder,tokens);
		
		
		SupplyOrder  supplyOrderToPresent = supplyOrderDaoOf(userContext).present(supplyOrder, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderToPresent.collectRefercencesFromLists();
		supplyOrderDaoOf(userContext).alias(entityListToNaming);
		
		return  supplyOrderToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrder loadSupplyOrderDetail(YoubenbenUserContext userContext, String supplyOrderId) throws Exception{	
 		SupplyOrder supplyOrder = loadSupplyOrder( userContext, supplyOrderId, allTokens());
 		return present(userContext,supplyOrder, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String supplyOrderId) throws Exception{	
 		SupplyOrder supplyOrder = loadSupplyOrder( userContext, supplyOrderId, viewTokens());
 		return present(userContext,supplyOrder, allTokens());
		
 	}
 	protected SupplyOrder saveSupplyOrder(YoubenbenUserContext userContext, SupplyOrder supplyOrder, Map<String,Object>tokens) throws Exception{	
 		return supplyOrderDaoOf(userContext).save(supplyOrder, tokens);
 	}
 	protected SupplyOrder loadSupplyOrder(YoubenbenUserContext userContext, String supplyOrderId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderManagerException.class);

 
 		return supplyOrderDaoOf(userContext).load(supplyOrderId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrder supplyOrder, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrder, tokens);
		
		addAction(userContext, supplyOrder, tokens,"@create","createSupplyOrder","createSupplyOrder/","main","primary");
		addAction(userContext, supplyOrder, tokens,"@update","updateSupplyOrder","updateSupplyOrder/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"@copy","cloneSupplyOrder","cloneSupplyOrder/"+supplyOrder.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_buyer","transferToAnotherBuyer","transferToAnotherBuyer/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_seller","transferToAnotherSeller","transferToAnotherSeller/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_confirmation","transferToAnotherConfirmation","transferToAnotherConfirmation/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_approval","transferToAnotherApproval","transferToAnotherApproval/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_processing","transferToAnotherProcessing","transferToAnotherProcessing/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_picking","transferToAnotherPicking","transferToAnotherPicking/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_shipment","transferToAnotherShipment","transferToAnotherShipment/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_delivery","transferToAnotherDelivery","transferToAnotherDelivery/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.addSupplyOrderLineItem","addSupplyOrderLineItem","addSupplyOrderLineItem/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeSupplyOrderLineItem","removeSupplyOrderLineItem","removeSupplyOrderLineItem/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateSupplyOrderLineItem","updateSupplyOrderLineItem","updateSupplyOrderLineItem/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copySupplyOrderLineItemFrom","copySupplyOrderLineItemFrom","copySupplyOrderLineItemFrom/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.addSupplyOrderShippingGroup","addSupplyOrderShippingGroup","addSupplyOrderShippingGroup/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeSupplyOrderShippingGroup","removeSupplyOrderShippingGroup","removeSupplyOrderShippingGroup/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateSupplyOrderShippingGroup","updateSupplyOrderShippingGroup","updateSupplyOrderShippingGroup/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copySupplyOrderShippingGroupFrom","copySupplyOrderShippingGroupFrom","copySupplyOrderShippingGroupFrom/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.addSupplyOrderPaymentGroup","addSupplyOrderPaymentGroup","addSupplyOrderPaymentGroup/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeSupplyOrderPaymentGroup","removeSupplyOrderPaymentGroup","removeSupplyOrderPaymentGroup/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateSupplyOrderPaymentGroup","updateSupplyOrderPaymentGroup","updateSupplyOrderPaymentGroup/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copySupplyOrderPaymentGroupFrom","copySupplyOrderPaymentGroupFrom","copySupplyOrderPaymentGroupFrom/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.addGoods","addGoods","addGoods/"+supplyOrder.getId()+"/","goodsList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeGoods","removeGoods","removeGoods/"+supplyOrder.getId()+"/","goodsList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateGoods","updateGoods","updateGoods/"+supplyOrder.getId()+"/","goodsList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+supplyOrder.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrder supplyOrder, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SupplyOrder createSupplyOrder(YoubenbenUserContext userContext, String buyerId,String sellerId,String title,BigDecimal totalAmount,String confirmationId,String approvalId,String processingId,String pickingId,String shipmentId,String deliveryId) throws Exception
	//public SupplyOrder createSupplyOrder(YoubenbenUserContext userContext,String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfSupplyOrder(title);
		checkerOf(userContext).checkTotalAmountOfSupplyOrder(totalAmount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);


		SupplyOrder supplyOrder=createNewSupplyOrder();	

			
		RetailStoreCountryCenter buyer = loadRetailStoreCountryCenter(userContext, buyerId,emptyOptions());
		supplyOrder.setBuyer(buyer);
		
		
			
		GoodsSupplier seller = loadGoodsSupplier(userContext, sellerId,emptyOptions());
		supplyOrder.setSeller(seller);
		
		
		supplyOrder.setTitle(title);
		supplyOrder.setTotalAmount(totalAmount);
			
		SupplyOrderConfirmation confirmation = loadSupplyOrderConfirmation(userContext, confirmationId,emptyOptions());
		supplyOrder.setConfirmation(confirmation);
		
		
			
		SupplyOrderApproval approval = loadSupplyOrderApproval(userContext, approvalId,emptyOptions());
		supplyOrder.setApproval(approval);
		
		
			
		SupplyOrderProcessing processing = loadSupplyOrderProcessing(userContext, processingId,emptyOptions());
		supplyOrder.setProcessing(processing);
		
		
			
		SupplyOrderPicking picking = loadSupplyOrderPicking(userContext, pickingId,emptyOptions());
		supplyOrder.setPicking(picking);
		
		
			
		SupplyOrderShipment shipment = loadSupplyOrderShipment(userContext, shipmentId,emptyOptions());
		supplyOrder.setShipment(shipment);
		
		
			
		SupplyOrderDelivery delivery = loadSupplyOrderDelivery(userContext, deliveryId,emptyOptions());
		supplyOrder.setDelivery(delivery);
		
		
		supplyOrder.setLastUpdateTime(userContext.now());

		supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrder);
		return supplyOrder;


	}
	protected SupplyOrder createNewSupplyOrder()
	{

		return new SupplyOrder();
	}

	protected void checkParamsForUpdatingSupplyOrder(YoubenbenUserContext userContext,String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder( supplyOrderVersion);
		
		

				

		
		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfSupplyOrder(parseString(newValueExpr));
		
			
		}
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		
			
		}		

				

				

				

				

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);


	}



	public SupplyOrder clone(YoubenbenUserContext userContext, String fromSupplyOrderId) throws Exception{

		return supplyOrderDaoOf(userContext).clone(fromSupplyOrderId, this.allTokens());
	}

	public SupplyOrder internalSaveSupplyOrder(YoubenbenUserContext userContext, SupplyOrder supplyOrder) throws Exception
	{
		return internalSaveSupplyOrder(userContext, supplyOrder, allTokens());

	}
	public SupplyOrder internalSaveSupplyOrder(YoubenbenUserContext userContext, SupplyOrder supplyOrder, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSupplyOrder(userContext, supplyOrderId, supplyOrderVersion, property, newValueExpr, tokensExpr);


		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrder.
			if (supplyOrder.isChanged()){
			supplyOrder.updateLastUpdateTime(userContext.now());
			}
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, options);
			return supplyOrder;

		}

	}

	public SupplyOrder updateSupplyOrder(YoubenbenUserContext userContext,String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderId, supplyOrderVersion, property, newValueExpr, tokensExpr);



		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		if(supplyOrder.getVersion() != supplyOrderVersion){
			String message = "The target version("+supplyOrder.getVersion()+") is not equals to version("+supplyOrderVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrder.
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			//return saveSupplyOrder(userContext, supplyOrder, tokens().done());
		}

	}

	public SupplyOrder updateSupplyOrderProperty(YoubenbenUserContext userContext,String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderId, supplyOrderVersion, property, newValueExpr, tokensExpr);

		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		if(supplyOrder.getVersion() != supplyOrderVersion){
			String message = "The target version("+supplyOrder.getVersion()+") is not equals to version("+supplyOrderVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrder.

			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			//return saveSupplyOrder(userContext, supplyOrder, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SupplyOrderTokens tokens(){
		return SupplyOrderTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortSupplyOrderLineItemListWith("id","desc")
		.sortSupplyOrderShippingGroupListWith("id","desc")
		.sortSupplyOrderPaymentGroupListWith("id","desc")
		.sortGoodsListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBuyer(YoubenbenUserContext userContext, String supplyOrderId, String anotherBuyerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherBuyerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder transferToAnotherBuyer(YoubenbenUserContext userContext, String supplyOrderId, String anotherBuyerId) throws Exception
 	{
 		checkParamsForTransferingAnotherBuyer(userContext, supplyOrderId,anotherBuyerId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter buyer = loadRetailStoreCountryCenter(userContext, anotherBuyerId, emptyOptions());		
			supplyOrder.updateBuyer(buyer);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreCountryCenter requestCandidateBuyer(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherSeller(YoubenbenUserContext userContext, String supplyOrderId, String anotherSellerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
 		checkerOf(userContext).checkIdOfGoodsSupplier(anotherSellerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder transferToAnotherSeller(YoubenbenUserContext userContext, String supplyOrderId, String anotherSellerId) throws Exception
 	{
 		checkParamsForTransferingAnotherSeller(userContext, supplyOrderId,anotherSellerId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsSupplier seller = loadGoodsSupplier(userContext, anotherSellerId, emptyOptions());		
			supplyOrder.updateSeller(seller);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}

	


	public CandidateGoodsSupplier requestCandidateSeller(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGoodsSupplier result = new CandidateGoodsSupplier();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GoodsSupplier> candidateList = goodsSupplierDaoOf(userContext).requestCandidateGoodsSupplierForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherConfirmation(YoubenbenUserContext userContext, String supplyOrderId, String anotherConfirmationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
 		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(anotherConfirmationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder transferToAnotherConfirmation(YoubenbenUserContext userContext, String supplyOrderId, String anotherConfirmationId) throws Exception
 	{
 		checkParamsForTransferingAnotherConfirmation(userContext, supplyOrderId,anotherConfirmationId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderConfirmation confirmation = loadSupplyOrderConfirmation(userContext, anotherConfirmationId, emptyOptions());		
			supplyOrder.updateConfirmation(confirmation);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}

	


	public CandidateSupplyOrderConfirmation requestCandidateConfirmation(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderConfirmation result = new CandidateSupplyOrderConfirmation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderConfirmation> candidateList = supplyOrderConfirmationDaoOf(userContext).requestCandidateSupplyOrderConfirmationForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherApproval(YoubenbenUserContext userContext, String supplyOrderId, String anotherApprovalId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
 		checkerOf(userContext).checkIdOfSupplyOrderApproval(anotherApprovalId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder transferToAnotherApproval(YoubenbenUserContext userContext, String supplyOrderId, String anotherApprovalId) throws Exception
 	{
 		checkParamsForTransferingAnotherApproval(userContext, supplyOrderId,anotherApprovalId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderApproval approval = loadSupplyOrderApproval(userContext, anotherApprovalId, emptyOptions());		
			supplyOrder.updateApproval(approval);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}

	


	public CandidateSupplyOrderApproval requestCandidateApproval(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderApproval result = new CandidateSupplyOrderApproval();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderApproval> candidateList = supplyOrderApprovalDaoOf(userContext).requestCandidateSupplyOrderApprovalForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherProcessing(YoubenbenUserContext userContext, String supplyOrderId, String anotherProcessingId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
 		checkerOf(userContext).checkIdOfSupplyOrderProcessing(anotherProcessingId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder transferToAnotherProcessing(YoubenbenUserContext userContext, String supplyOrderId, String anotherProcessingId) throws Exception
 	{
 		checkParamsForTransferingAnotherProcessing(userContext, supplyOrderId,anotherProcessingId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderProcessing processing = loadSupplyOrderProcessing(userContext, anotherProcessingId, emptyOptions());		
			supplyOrder.updateProcessing(processing);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}

	


	public CandidateSupplyOrderProcessing requestCandidateProcessing(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderProcessing result = new CandidateSupplyOrderProcessing();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderProcessing> candidateList = supplyOrderProcessingDaoOf(userContext).requestCandidateSupplyOrderProcessingForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherPicking(YoubenbenUserContext userContext, String supplyOrderId, String anotherPickingId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
 		checkerOf(userContext).checkIdOfSupplyOrderPicking(anotherPickingId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder transferToAnotherPicking(YoubenbenUserContext userContext, String supplyOrderId, String anotherPickingId) throws Exception
 	{
 		checkParamsForTransferingAnotherPicking(userContext, supplyOrderId,anotherPickingId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderPicking picking = loadSupplyOrderPicking(userContext, anotherPickingId, emptyOptions());		
			supplyOrder.updatePicking(picking);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}

	


	public CandidateSupplyOrderPicking requestCandidatePicking(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderPicking result = new CandidateSupplyOrderPicking();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderPicking> candidateList = supplyOrderPickingDaoOf(userContext).requestCandidateSupplyOrderPickingForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherShipment(YoubenbenUserContext userContext, String supplyOrderId, String anotherShipmentId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
 		checkerOf(userContext).checkIdOfSupplyOrderShipment(anotherShipmentId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder transferToAnotherShipment(YoubenbenUserContext userContext, String supplyOrderId, String anotherShipmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherShipment(userContext, supplyOrderId,anotherShipmentId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderShipment shipment = loadSupplyOrderShipment(userContext, anotherShipmentId, emptyOptions());		
			supplyOrder.updateShipment(shipment);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}

	


	public CandidateSupplyOrderShipment requestCandidateShipment(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderShipment result = new CandidateSupplyOrderShipment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderShipment> candidateList = supplyOrderShipmentDaoOf(userContext).requestCandidateSupplyOrderShipmentForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherDelivery(YoubenbenUserContext userContext, String supplyOrderId, String anotherDeliveryId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
 		checkerOf(userContext).checkIdOfSupplyOrderDelivery(anotherDeliveryId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder transferToAnotherDelivery(YoubenbenUserContext userContext, String supplyOrderId, String anotherDeliveryId) throws Exception
 	{
 		checkParamsForTransferingAnotherDelivery(userContext, supplyOrderId,anotherDeliveryId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderDelivery delivery = loadSupplyOrderDelivery(userContext, anotherDeliveryId, emptyOptions());		
			supplyOrder.updateDelivery(delivery);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}

	


	public CandidateSupplyOrderDelivery requestCandidateDelivery(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderDelivery result = new CandidateSupplyOrderDelivery();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderDelivery> candidateList = supplyOrderDeliveryDaoOf(userContext).requestCandidateSupplyOrderDeliveryForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected SupplyOrderProcessing loadSupplyOrderProcessing(YoubenbenUserContext userContext, String newProcessingId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderProcessingDaoOf(userContext).load(newProcessingId, options);
 	}
 	


	

 	protected SupplyOrderApproval loadSupplyOrderApproval(YoubenbenUserContext userContext, String newApprovalId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderApprovalDaoOf(userContext).load(newApprovalId, options);
 	}
 	


	

 	protected SupplyOrderDelivery loadSupplyOrderDelivery(YoubenbenUserContext userContext, String newDeliveryId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderDeliveryDaoOf(userContext).load(newDeliveryId, options);
 	}
 	


	

 	protected SupplyOrderConfirmation loadSupplyOrderConfirmation(YoubenbenUserContext userContext, String newConfirmationId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderConfirmationDaoOf(userContext).load(newConfirmationId, options);
 	}
 	


	

 	protected SupplyOrderPicking loadSupplyOrderPicking(YoubenbenUserContext userContext, String newPickingId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderPickingDaoOf(userContext).load(newPickingId, options);
 	}
 	


	

 	protected GoodsSupplier loadGoodsSupplier(YoubenbenUserContext userContext, String newSellerId, Map<String,Object> options) throws Exception
 	{

 		return goodsSupplierDaoOf(userContext).load(newSellerId, options);
 	}
 	


	

 	protected SupplyOrderShipment loadSupplyOrderShipment(YoubenbenUserContext userContext, String newShipmentId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderShipmentDaoOf(userContext).load(newShipmentId, options);
 	}
 	


	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(YoubenbenUserContext userContext, String newBuyerId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newBuyerId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String supplyOrderId, int supplyOrderVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderId, supplyOrderVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String supplyOrderId, int supplyOrderVersion) throws Exception{

		supplyOrderDaoOf(userContext).delete(supplyOrderId, supplyOrderVersion);
	}

	public SupplyOrder forgetByAll(YoubenbenUserContext userContext, String supplyOrderId, int supplyOrderVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderId, supplyOrderVersion);
	}
	protected SupplyOrder forgetByAllInternal(YoubenbenUserContext userContext,
			String supplyOrderId, int supplyOrderVersion) throws Exception{

		return supplyOrderDaoOf(userContext).disconnectFromAll(supplyOrderId, supplyOrderVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return supplyOrderDaoOf(userContext).deleteAll();
	}


	//disconnect SupplyOrder with sku_id in SupplyOrderLineItem
	protected SupplyOrder breakWithSupplyOrderLineItemBySkuId(YoubenbenUserContext userContext, String supplyOrderId, String skuIdId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDaoOf(userContext).planToRemoveSupplyOrderLineItemListWithSkuId(supplyOrder, skuIdId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with sku in Goods
	protected SupplyOrder breakWithGoodsBySku(YoubenbenUserContext userContext, String supplyOrderId, String skuId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDaoOf(userContext).planToRemoveGoodsListWithSku(supplyOrder, skuId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with receiving_space in Goods
	protected SupplyOrder breakWithGoodsByReceivingSpace(YoubenbenUserContext userContext, String supplyOrderId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDaoOf(userContext).planToRemoveGoodsListWithReceivingSpace(supplyOrder, receivingSpaceId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with goods_allocation in Goods
	protected SupplyOrder breakWithGoodsByGoodsAllocation(YoubenbenUserContext userContext, String supplyOrderId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDaoOf(userContext).planToRemoveGoodsListWithGoodsAllocation(supplyOrder, goodsAllocationId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with smart_pallet in Goods
	protected SupplyOrder breakWithGoodsBySmartPallet(YoubenbenUserContext userContext, String supplyOrderId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDaoOf(userContext).planToRemoveGoodsListWithSmartPallet(supplyOrder, smartPalletId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with shipping_space in Goods
	protected SupplyOrder breakWithGoodsByShippingSpace(YoubenbenUserContext userContext, String supplyOrderId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDaoOf(userContext).planToRemoveGoodsListWithShippingSpace(supplyOrder, shippingSpaceId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with transport_task in Goods
	protected SupplyOrder breakWithGoodsByTransportTask(YoubenbenUserContext userContext, String supplyOrderId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDaoOf(userContext).planToRemoveGoodsListWithTransportTask(supplyOrder, transportTaskId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with retail_store in Goods
	protected SupplyOrder breakWithGoodsByRetailStore(YoubenbenUserContext userContext, String supplyOrderId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDaoOf(userContext).planToRemoveGoodsListWithRetailStore(supplyOrder, retailStoreId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with retail_store_order in Goods
	protected SupplyOrder breakWithGoodsByRetailStoreOrder(YoubenbenUserContext userContext, String supplyOrderId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDaoOf(userContext).planToRemoveGoodsListWithRetailStoreOrder(supplyOrder, retailStoreOrderId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with packaging in Goods
	protected SupplyOrder breakWithGoodsByPackaging(YoubenbenUserContext userContext, String supplyOrderId, String packagingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDaoOf(userContext).planToRemoveGoodsListWithPackaging(supplyOrder, packagingId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}






	protected void checkParamsForAddingSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);

		
		checkerOf(userContext).checkSkuIdOfSupplyOrderLineItem(skuId);
		
		checkerOf(userContext).checkSkuNameOfSupplyOrderLineItem(skuName);
		
		checkerOf(userContext).checkAmountOfSupplyOrderLineItem(amount);
		
		checkerOf(userContext).checkQuantityOfSupplyOrderLineItem(quantity);
		
		checkerOf(userContext).checkUnitOfMeasurementOfSupplyOrderLineItem(unitOfMeasurement);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);


	}
	public  SupplyOrder addSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSupplyOrderLineItem(userContext,supplyOrderId,skuId, skuName, amount, quantity, unitOfMeasurement,tokensExpr);

		SupplyOrderLineItem supplyOrderLineItem = createSupplyOrderLineItem(userContext,skuId, skuName, amount, quantity, unitOfMeasurement);

		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, emptyOptions());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addSupplyOrderLineItem( supplyOrderLineItem );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			
			userContext.getManagerGroup().getSupplyOrderLineItemManager().onNewInstanceCreated(userContext, supplyOrderLineItem);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderLineItemProperties(YoubenbenUserContext userContext, String supplyOrderId,String id,String skuId,String skuName,BigDecimal amount,int quantity,String unitOfMeasurement,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderLineItem(id);

		checkerOf(userContext).checkSkuIdOfSupplyOrderLineItem( skuId);
		checkerOf(userContext).checkSkuNameOfSupplyOrderLineItem( skuName);
		checkerOf(userContext).checkAmountOfSupplyOrderLineItem( amount);
		checkerOf(userContext).checkQuantityOfSupplyOrderLineItem( quantity);
		checkerOf(userContext).checkUnitOfMeasurementOfSupplyOrderLineItem( unitOfMeasurement);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder updateSupplyOrderLineItemProperties(YoubenbenUserContext userContext, String supplyOrderId, String id,String skuId,String skuName,BigDecimal amount,int quantity,String unitOfMeasurement, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderLineItemProperties(userContext,supplyOrderId,id,skuId,skuName,amount,quantity,unitOfMeasurement,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderLineItemListList()
				.searchSupplyOrderLineItemListWith(SupplyOrderLineItem.ID_PROPERTY, "is", id).done();

		SupplyOrder supplyOrderToUpdate = loadSupplyOrder(userContext, supplyOrderId, options);

		if(supplyOrderToUpdate.getSupplyOrderLineItemList().isEmpty()){
			throw new SupplyOrderManagerException("SupplyOrderLineItem is NOT FOUND with id: '"+id+"'");
		}

		SupplyOrderLineItem item = supplyOrderToUpdate.getSupplyOrderLineItemList().first();

		item.updateSkuId( skuId );
		item.updateSkuName( skuName );
		item.updateAmount( amount );
		item.updateQuantity( quantity );
		item.updateUnitOfMeasurement( unitOfMeasurement );


		//checkParamsForAddingSupplyOrderLineItem(userContext,supplyOrderId,name, code, used,tokensExpr);
		SupplyOrder supplyOrder = saveSupplyOrder(userContext, supplyOrderToUpdate, tokens().withSupplyOrderLineItemList().done());
		synchronized(supplyOrder){
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}


	protected SupplyOrderLineItem createSupplyOrderLineItem(YoubenbenUserContext userContext, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement) throws Exception{

		SupplyOrderLineItem supplyOrderLineItem = new SupplyOrderLineItem();
		
		
		supplyOrderLineItem.setSkuId(skuId);		
		supplyOrderLineItem.setSkuName(skuName);		
		supplyOrderLineItem.setAmount(amount);		
		supplyOrderLineItem.setQuantity(quantity);		
		supplyOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);
	
		
		return supplyOrderLineItem;


	}

	protected SupplyOrderLineItem createIndexedSupplyOrderLineItem(String id, int version){

		SupplyOrderLineItem supplyOrderLineItem = new SupplyOrderLineItem();
		supplyOrderLineItem.setId(id);
		supplyOrderLineItem.setVersion(version);
		return supplyOrderLineItem;

	}

	protected void checkParamsForRemovingSupplyOrderLineItemList(YoubenbenUserContext userContext, String supplyOrderId,
			String supplyOrderLineItemIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		for(String supplyOrderLineItemIdItem: supplyOrderLineItemIds){
			checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder removeSupplyOrderLineItemList(YoubenbenUserContext userContext, String supplyOrderId,
			String supplyOrderLineItemIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSupplyOrderLineItemList(userContext, supplyOrderId,  supplyOrderLineItemIds, tokensExpr);


			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
			synchronized(supplyOrder){
				//Will be good when the supplyOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderDaoOf(userContext).planToRemoveSupplyOrderLineItemList(supplyOrder, supplyOrderLineItemIds, allTokens());
				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
				deleteRelationListInGraph(userContext, supplyOrder.getSupplyOrderLineItemList());
				return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrder( supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		checkerOf(userContext).checkVersionOfSupplyOrderLineItem(supplyOrderLineItemVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder removeSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSupplyOrderLineItem(userContext,supplyOrderId, supplyOrderLineItemId, supplyOrderLineItemVersion,tokensExpr);

		SupplyOrderLineItem supplyOrderLineItem = createIndexedSupplyOrderLineItem(supplyOrderLineItemId, supplyOrderLineItemVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeSupplyOrderLineItem( supplyOrderLineItem );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			deleteRelationInGraph(userContext, supplyOrderLineItem);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrder( supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		checkerOf(userContext).checkVersionOfSupplyOrderLineItem(supplyOrderLineItemVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder copySupplyOrderLineItemFrom(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSupplyOrderLineItem(userContext,supplyOrderId, supplyOrderLineItemId, supplyOrderLineItemVersion,tokensExpr);

		SupplyOrderLineItem supplyOrderLineItem = createIndexedSupplyOrderLineItem(supplyOrderLineItemId, supplyOrderLineItemVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			supplyOrder.copySupplyOrderLineItemFrom( supplyOrderLineItem );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			
			userContext.getManagerGroup().getSupplyOrderLineItemManager().onNewInstanceCreated(userContext, (SupplyOrderLineItem)supplyOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		checkerOf(userContext).checkVersionOfSupplyOrderLineItem(supplyOrderLineItemVersion);
		

		if(SupplyOrderLineItem.SKU_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSkuIdOfSupplyOrderLineItem(parseString(newValueExpr));
		
		}
		
		if(SupplyOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSkuNameOfSupplyOrderLineItem(parseString(newValueExpr));
		
		}
		
		if(SupplyOrderLineItem.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfSupplyOrderLineItem(parseBigDecimal(newValueExpr));
		
		}
		
		if(SupplyOrderLineItem.QUANTITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkQuantityOfSupplyOrderLineItem(parseInt(newValueExpr));
		
		}
		
		if(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUnitOfMeasurementOfSupplyOrderLineItem(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}

	public  SupplyOrder updateSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSupplyOrderLineItem(userContext, supplyOrderId, supplyOrderLineItemId, supplyOrderLineItemVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSupplyOrderLineItemList().searchSupplyOrderLineItemListWith(SupplyOrderLineItem.ID_PROPERTY, "eq", supplyOrderLineItemId).done();



		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, loadTokens);

		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeSupplyOrderLineItem( supplyOrderLineItem );
			//make changes to AcceleraterAccount.
			SupplyOrderLineItem supplyOrderLineItemIndex = createIndexedSupplyOrderLineItem(supplyOrderLineItemId, supplyOrderLineItemVersion);

			SupplyOrderLineItem supplyOrderLineItem = supplyOrder.findTheSupplyOrderLineItem(supplyOrderLineItemIndex);
			if(supplyOrderLineItem == null){
				throw new SupplyOrderManagerException(supplyOrderLineItem+" is NOT FOUND" );
			}

			supplyOrderLineItem.changeProperty(property, newValueExpr);
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingSupplyOrderShippingGroup(YoubenbenUserContext userContext, String supplyOrderId, String name, BigDecimal amount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);

		
		checkerOf(userContext).checkNameOfSupplyOrderShippingGroup(name);
		
		checkerOf(userContext).checkAmountOfSupplyOrderShippingGroup(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);


	}
	public  SupplyOrder addSupplyOrderShippingGroup(YoubenbenUserContext userContext, String supplyOrderId, String name, BigDecimal amount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSupplyOrderShippingGroup(userContext,supplyOrderId,name, amount,tokensExpr);

		SupplyOrderShippingGroup supplyOrderShippingGroup = createSupplyOrderShippingGroup(userContext,name, amount);

		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, emptyOptions());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addSupplyOrderShippingGroup( supplyOrderShippingGroup );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			
			userContext.getManagerGroup().getSupplyOrderShippingGroupManager().onNewInstanceCreated(userContext, supplyOrderShippingGroup);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderShippingGroupProperties(YoubenbenUserContext userContext, String supplyOrderId,String id,String name,BigDecimal amount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderShippingGroup(id);

		checkerOf(userContext).checkNameOfSupplyOrderShippingGroup( name);
		checkerOf(userContext).checkAmountOfSupplyOrderShippingGroup( amount);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder updateSupplyOrderShippingGroupProperties(YoubenbenUserContext userContext, String supplyOrderId, String id,String name,BigDecimal amount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderShippingGroupProperties(userContext,supplyOrderId,id,name,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderShippingGroupListList()
				.searchSupplyOrderShippingGroupListWith(SupplyOrderShippingGroup.ID_PROPERTY, "is", id).done();

		SupplyOrder supplyOrderToUpdate = loadSupplyOrder(userContext, supplyOrderId, options);

		if(supplyOrderToUpdate.getSupplyOrderShippingGroupList().isEmpty()){
			throw new SupplyOrderManagerException("SupplyOrderShippingGroup is NOT FOUND with id: '"+id+"'");
		}

		SupplyOrderShippingGroup item = supplyOrderToUpdate.getSupplyOrderShippingGroupList().first();

		item.updateName( name );
		item.updateAmount( amount );


		//checkParamsForAddingSupplyOrderShippingGroup(userContext,supplyOrderId,name, code, used,tokensExpr);
		SupplyOrder supplyOrder = saveSupplyOrder(userContext, supplyOrderToUpdate, tokens().withSupplyOrderShippingGroupList().done());
		synchronized(supplyOrder){
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}


	protected SupplyOrderShippingGroup createSupplyOrderShippingGroup(YoubenbenUserContext userContext, String name, BigDecimal amount) throws Exception{

		SupplyOrderShippingGroup supplyOrderShippingGroup = new SupplyOrderShippingGroup();
		
		
		supplyOrderShippingGroup.setName(name);		
		supplyOrderShippingGroup.setAmount(amount);
	
		
		return supplyOrderShippingGroup;


	}

	protected SupplyOrderShippingGroup createIndexedSupplyOrderShippingGroup(String id, int version){

		SupplyOrderShippingGroup supplyOrderShippingGroup = new SupplyOrderShippingGroup();
		supplyOrderShippingGroup.setId(id);
		supplyOrderShippingGroup.setVersion(version);
		return supplyOrderShippingGroup;

	}

	protected void checkParamsForRemovingSupplyOrderShippingGroupList(YoubenbenUserContext userContext, String supplyOrderId,
			String supplyOrderShippingGroupIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		for(String supplyOrderShippingGroupIdItem: supplyOrderShippingGroupIds){
			checkerOf(userContext).checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder removeSupplyOrderShippingGroupList(YoubenbenUserContext userContext, String supplyOrderId,
			String supplyOrderShippingGroupIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSupplyOrderShippingGroupList(userContext, supplyOrderId,  supplyOrderShippingGroupIds, tokensExpr);


			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
			synchronized(supplyOrder){
				//Will be good when the supplyOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderDaoOf(userContext).planToRemoveSupplyOrderShippingGroupList(supplyOrder, supplyOrderShippingGroupIds, allTokens());
				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
				deleteRelationListInGraph(userContext, supplyOrder.getSupplyOrderShippingGroupList());
				return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSupplyOrderShippingGroup(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrder( supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
		checkerOf(userContext).checkVersionOfSupplyOrderShippingGroup(supplyOrderShippingGroupVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder removeSupplyOrderShippingGroup(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSupplyOrderShippingGroup(userContext,supplyOrderId, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion,tokensExpr);

		SupplyOrderShippingGroup supplyOrderShippingGroup = createIndexedSupplyOrderShippingGroup(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeSupplyOrderShippingGroup( supplyOrderShippingGroup );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			deleteRelationInGraph(userContext, supplyOrderShippingGroup);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSupplyOrderShippingGroup(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrder( supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
		checkerOf(userContext).checkVersionOfSupplyOrderShippingGroup(supplyOrderShippingGroupVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder copySupplyOrderShippingGroupFrom(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSupplyOrderShippingGroup(userContext,supplyOrderId, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion,tokensExpr);

		SupplyOrderShippingGroup supplyOrderShippingGroup = createIndexedSupplyOrderShippingGroup(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			supplyOrder.copySupplyOrderShippingGroupFrom( supplyOrderShippingGroup );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			
			userContext.getManagerGroup().getSupplyOrderShippingGroupManager().onNewInstanceCreated(userContext, (SupplyOrderShippingGroup)supplyOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSupplyOrderShippingGroup(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
		checkerOf(userContext).checkVersionOfSupplyOrderShippingGroup(supplyOrderShippingGroupVersion);
		

		if(SupplyOrderShippingGroup.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfSupplyOrderShippingGroup(parseString(newValueExpr));
		
		}
		
		if(SupplyOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfSupplyOrderShippingGroup(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}

	public  SupplyOrder updateSupplyOrderShippingGroup(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSupplyOrderShippingGroup(userContext, supplyOrderId, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSupplyOrderShippingGroupList().searchSupplyOrderShippingGroupListWith(SupplyOrderShippingGroup.ID_PROPERTY, "eq", supplyOrderShippingGroupId).done();



		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, loadTokens);

		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeSupplyOrderShippingGroup( supplyOrderShippingGroup );
			//make changes to AcceleraterAccount.
			SupplyOrderShippingGroup supplyOrderShippingGroupIndex = createIndexedSupplyOrderShippingGroup(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);

			SupplyOrderShippingGroup supplyOrderShippingGroup = supplyOrder.findTheSupplyOrderShippingGroup(supplyOrderShippingGroupIndex);
			if(supplyOrderShippingGroup == null){
				throw new SupplyOrderManagerException(supplyOrderShippingGroup+" is NOT FOUND" );
			}

			supplyOrderShippingGroup.changeProperty(property, newValueExpr);
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String supplyOrderId, String name, String cardNumber,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);

		
		checkerOf(userContext).checkNameOfSupplyOrderPaymentGroup(name);
		
		checkerOf(userContext).checkCardNumberOfSupplyOrderPaymentGroup(cardNumber);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);


	}
	public  SupplyOrder addSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String supplyOrderId, String name, String cardNumber, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSupplyOrderPaymentGroup(userContext,supplyOrderId,name, cardNumber,tokensExpr);

		SupplyOrderPaymentGroup supplyOrderPaymentGroup = createSupplyOrderPaymentGroup(userContext,name, cardNumber);

		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, emptyOptions());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addSupplyOrderPaymentGroup( supplyOrderPaymentGroup );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			
			userContext.getManagerGroup().getSupplyOrderPaymentGroupManager().onNewInstanceCreated(userContext, supplyOrderPaymentGroup);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderPaymentGroupProperties(YoubenbenUserContext userContext, String supplyOrderId,String id,String name,String cardNumber,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderPaymentGroup(id);

		checkerOf(userContext).checkNameOfSupplyOrderPaymentGroup( name);
		checkerOf(userContext).checkCardNumberOfSupplyOrderPaymentGroup( cardNumber);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder updateSupplyOrderPaymentGroupProperties(YoubenbenUserContext userContext, String supplyOrderId, String id,String name,String cardNumber, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderPaymentGroupProperties(userContext,supplyOrderId,id,name,cardNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderPaymentGroupListList()
				.searchSupplyOrderPaymentGroupListWith(SupplyOrderPaymentGroup.ID_PROPERTY, "is", id).done();

		SupplyOrder supplyOrderToUpdate = loadSupplyOrder(userContext, supplyOrderId, options);

		if(supplyOrderToUpdate.getSupplyOrderPaymentGroupList().isEmpty()){
			throw new SupplyOrderManagerException("SupplyOrderPaymentGroup is NOT FOUND with id: '"+id+"'");
		}

		SupplyOrderPaymentGroup item = supplyOrderToUpdate.getSupplyOrderPaymentGroupList().first();

		item.updateName( name );
		item.updateCardNumber( cardNumber );


		//checkParamsForAddingSupplyOrderPaymentGroup(userContext,supplyOrderId,name, code, used,tokensExpr);
		SupplyOrder supplyOrder = saveSupplyOrder(userContext, supplyOrderToUpdate, tokens().withSupplyOrderPaymentGroupList().done());
		synchronized(supplyOrder){
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}


	protected SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String name, String cardNumber) throws Exception{

		SupplyOrderPaymentGroup supplyOrderPaymentGroup = new SupplyOrderPaymentGroup();
		
		
		supplyOrderPaymentGroup.setName(name);		
		supplyOrderPaymentGroup.setCardNumber(cardNumber);
	
		
		return supplyOrderPaymentGroup;


	}

	protected SupplyOrderPaymentGroup createIndexedSupplyOrderPaymentGroup(String id, int version){

		SupplyOrderPaymentGroup supplyOrderPaymentGroup = new SupplyOrderPaymentGroup();
		supplyOrderPaymentGroup.setId(id);
		supplyOrderPaymentGroup.setVersion(version);
		return supplyOrderPaymentGroup;

	}

	protected void checkParamsForRemovingSupplyOrderPaymentGroupList(YoubenbenUserContext userContext, String supplyOrderId,
			String supplyOrderPaymentGroupIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		for(String supplyOrderPaymentGroupIdItem: supplyOrderPaymentGroupIds){
			checkerOf(userContext).checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder removeSupplyOrderPaymentGroupList(YoubenbenUserContext userContext, String supplyOrderId,
			String supplyOrderPaymentGroupIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSupplyOrderPaymentGroupList(userContext, supplyOrderId,  supplyOrderPaymentGroupIds, tokensExpr);


			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
			synchronized(supplyOrder){
				//Will be good when the supplyOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderDaoOf(userContext).planToRemoveSupplyOrderPaymentGroupList(supplyOrder, supplyOrderPaymentGroupIds, allTokens());
				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
				deleteRelationListInGraph(userContext, supplyOrder.getSupplyOrderPaymentGroupList());
				return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrder( supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		checkerOf(userContext).checkVersionOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder removeSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSupplyOrderPaymentGroup(userContext,supplyOrderId, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion,tokensExpr);

		SupplyOrderPaymentGroup supplyOrderPaymentGroup = createIndexedSupplyOrderPaymentGroup(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeSupplyOrderPaymentGroup( supplyOrderPaymentGroup );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			deleteRelationInGraph(userContext, supplyOrderPaymentGroup);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrder( supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		checkerOf(userContext).checkVersionOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder copySupplyOrderPaymentGroupFrom(YoubenbenUserContext userContext, String supplyOrderId,
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSupplyOrderPaymentGroup(userContext,supplyOrderId, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion,tokensExpr);

		SupplyOrderPaymentGroup supplyOrderPaymentGroup = createIndexedSupplyOrderPaymentGroup(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			supplyOrder.copySupplyOrderPaymentGroupFrom( supplyOrderPaymentGroup );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			
			userContext.getManagerGroup().getSupplyOrderPaymentGroupManager().onNewInstanceCreated(userContext, (SupplyOrderPaymentGroup)supplyOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		checkerOf(userContext).checkVersionOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupVersion);
		

		if(SupplyOrderPaymentGroup.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfSupplyOrderPaymentGroup(parseString(newValueExpr));
		
		}
		
		if(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCardNumberOfSupplyOrderPaymentGroup(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}

	public  SupplyOrder updateSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSupplyOrderPaymentGroup(userContext, supplyOrderId, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSupplyOrderPaymentGroupList().searchSupplyOrderPaymentGroupListWith(SupplyOrderPaymentGroup.ID_PROPERTY, "eq", supplyOrderPaymentGroupId).done();



		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, loadTokens);

		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeSupplyOrderPaymentGroup( supplyOrderPaymentGroup );
			//make changes to AcceleraterAccount.
			SupplyOrderPaymentGroup supplyOrderPaymentGroupIndex = createIndexedSupplyOrderPaymentGroup(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);

			SupplyOrderPaymentGroup supplyOrderPaymentGroup = supplyOrder.findTheSupplyOrderPaymentGroup(supplyOrderPaymentGroupIndex);
			if(supplyOrderPaymentGroup == null){
				throw new SupplyOrderManagerException(supplyOrderPaymentGroup+" is NOT FOUND" );
			}

			supplyOrderPaymentGroup.changeProperty(property, newValueExpr);
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingGoods(YoubenbenUserContext userContext, String supplyOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId, String packagingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);

		
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
		
		checkerOf(userContext).checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
		
		checkerOf(userContext).checkPackagingIdOfGoods(packagingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);


	}
	public  SupplyOrder addGoods(YoubenbenUserContext userContext, String supplyOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId, String packagingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingGoods(userContext,supplyOrderId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, retailStoreOrderId, packagingId,tokensExpr);

		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, retailStoreOrderId, packagingId);

		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, emptyOptions());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addGoods( goods );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, goods);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(YoubenbenUserContext userContext, String supplyOrderId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkIdOfGoods(id);

		checkerOf(userContext).checkNameOfGoods( name);
		checkerOf(userContext).checkRfidOfGoods( rfid);
		checkerOf(userContext).checkUomOfGoods( uom);
		checkerOf(userContext).checkMaxPackageOfGoods( maxPackage);
		checkerOf(userContext).checkExpireTimeOfGoods( expireTime);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder updateGoodsProperties(YoubenbenUserContext userContext, String supplyOrderId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsProperties(userContext,supplyOrderId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, "is", id).done();

		SupplyOrder supplyOrderToUpdate = loadSupplyOrder(userContext, supplyOrderId, options);

		if(supplyOrderToUpdate.getGoodsList().isEmpty()){
			throw new SupplyOrderManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}

		Goods item = supplyOrderToUpdate.getGoodsList().first();

		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );


		//checkParamsForAddingGoods(userContext,supplyOrderId,name, code, used,tokensExpr);
		SupplyOrder supplyOrder = saveSupplyOrder(userContext, supplyOrderToUpdate, tokens().withGoodsList().done());
		synchronized(supplyOrder){
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}


	protected Goods createGoods(YoubenbenUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId, String packagingId) throws Exception{

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
		RetailStoreOrder  retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(retailStoreOrderId);		
		goods.setRetailStoreOrder(retailStoreOrder);		
		GoodsPackaging  packaging = new GoodsPackaging();
		packaging.setId(packagingId);		
		goods.setPackaging(packaging);
	
		
		return goods;


	}

	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;

	}

	protected void checkParamsForRemovingGoodsList(YoubenbenUserContext userContext, String supplyOrderId,
			String goodsIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		for(String goodsIdItem: goodsIds){
			checkerOf(userContext).checkIdOfGoods(goodsIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder removeGoodsList(YoubenbenUserContext userContext, String supplyOrderId,
			String goodsIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsList(userContext, supplyOrderId,  goodsIds, tokensExpr);


			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
			synchronized(supplyOrder){
				//Will be good when the supplyOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderDaoOf(userContext).planToRemoveGoodsList(supplyOrder, goodsIds, allTokens());
				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, supplyOrder.getGoodsList());
				return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoods(YoubenbenUserContext userContext, String supplyOrderId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrder( supplyOrderId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder removeGoods(YoubenbenUserContext userContext, String supplyOrderId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingGoods(userContext,supplyOrderId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeGoods( goods );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingGoods(YoubenbenUserContext userContext, String supplyOrderId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrder( supplyOrderId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}
	public  SupplyOrder copyGoodsFrom(YoubenbenUserContext userContext, String supplyOrderId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingGoods(userContext,supplyOrderId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			supplyOrder.copyGoodsFrom( goods );
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, (Goods)supplyOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoods(YoubenbenUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	}

	public  SupplyOrder updateGoods(YoubenbenUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoods(userContext, supplyOrderId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, "eq", goodsId).done();



		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, loadTokens);

		synchronized(supplyOrder){
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeGoods( goods );
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);

			Goods goods = supplyOrder.findTheGoods(goodsIndex);
			if(goods == null){
				throw new SupplyOrderManagerException(goods+" is NOT FOUND" );
			}

			goods.changeProperty(property, newValueExpr);
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrder newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(YoubenbenUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(YoubenbenUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(YoubenbenUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(YoubenbenUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(YoubenbenBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(YoubenbenUserContextImpl userContext, LoginContext loginContext) throws Exception {
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
		YoubenbenUserContextImpl userContext = (YoubenbenUserContextImpl)baseUserContext;
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
	protected boolean isMethodNeedLogin(YoubenbenUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(YoubenbenUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(YoubenbenUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   SupplyOrder newSupplyOrder = this.createSupplyOrder(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSupplyOrder
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(YoubenbenUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, SupplyOrder.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((YoubenbenBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<SupplyOrder> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> buyerList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(buyerList, RetailStoreCountryCenter.class);
		List<GoodsSupplier> sellerList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, GoodsSupplier.class);
		userContext.getDAOGroup().enhanceList(sellerList, GoodsSupplier.class);
		List<SupplyOrderConfirmation> confirmationList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrderConfirmation.class);
		userContext.getDAOGroup().enhanceList(confirmationList, SupplyOrderConfirmation.class);
		List<SupplyOrderApproval> approvalList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrderApproval.class);
		userContext.getDAOGroup().enhanceList(approvalList, SupplyOrderApproval.class);
		List<SupplyOrderProcessing> processingList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrderProcessing.class);
		userContext.getDAOGroup().enhanceList(processingList, SupplyOrderProcessing.class);
		List<SupplyOrderPicking> pickingList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrderPicking.class);
		userContext.getDAOGroup().enhanceList(pickingList, SupplyOrderPicking.class);
		List<SupplyOrderShipment> shipmentList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrderShipment.class);
		userContext.getDAOGroup().enhanceList(shipmentList, SupplyOrderShipment.class);
		List<SupplyOrderDelivery> deliveryList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrderDelivery.class);
		userContext.getDAOGroup().enhanceList(deliveryList, SupplyOrderDelivery.class);


    }
	
	public Object listByBuyer(YoubenbenUserContext userContext,String buyerId) throws Exception {
		return listPageByBuyer(userContext, buyerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBuyer(YoubenbenUserContext userContext,String buyerId, int start, int count) throws Exception {
		SmartList<SupplyOrder> list = supplyOrderDaoOf(userContext).findSupplyOrderByBuyer(buyerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(SupplyOrder.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(buyerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应订单列表");
		page.setRequestName("listByBuyer");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBuyer/%s/",  getBeanName(), buyerId)));

		page.assemblerContent(userContext, "listByBuyer");
		return page.doRender(userContext);
	}
  
	public Object listBySeller(YoubenbenUserContext userContext,String sellerId) throws Exception {
		return listPageBySeller(userContext, sellerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySeller(YoubenbenUserContext userContext,String sellerId, int start, int count) throws Exception {
		SmartList<SupplyOrder> list = supplyOrderDaoOf(userContext).findSupplyOrderBySeller(sellerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(SupplyOrder.class);
		page.setContainerObject(GoodsSupplier.withId(sellerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应订单列表");
		page.setRequestName("listBySeller");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listBySeller/%s/",  getBeanName(), sellerId)));

		page.assemblerContent(userContext, "listBySeller");
		return page.doRender(userContext);
	}
  
	public Object listByConfirmation(YoubenbenUserContext userContext,String confirmationId) throws Exception {
		return listPageByConfirmation(userContext, confirmationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByConfirmation(YoubenbenUserContext userContext,String confirmationId, int start, int count) throws Exception {
		SmartList<SupplyOrder> list = supplyOrderDaoOf(userContext).findSupplyOrderByConfirmation(confirmationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(SupplyOrder.class);
		page.setContainerObject(SupplyOrderConfirmation.withId(confirmationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应订单列表");
		page.setRequestName("listByConfirmation");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByConfirmation/%s/",  getBeanName(), confirmationId)));

		page.assemblerContent(userContext, "listByConfirmation");
		return page.doRender(userContext);
	}
  
	public Object listByApproval(YoubenbenUserContext userContext,String approvalId) throws Exception {
		return listPageByApproval(userContext, approvalId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByApproval(YoubenbenUserContext userContext,String approvalId, int start, int count) throws Exception {
		SmartList<SupplyOrder> list = supplyOrderDaoOf(userContext).findSupplyOrderByApproval(approvalId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(SupplyOrder.class);
		page.setContainerObject(SupplyOrderApproval.withId(approvalId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应订单列表");
		page.setRequestName("listByApproval");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByApproval/%s/",  getBeanName(), approvalId)));

		page.assemblerContent(userContext, "listByApproval");
		return page.doRender(userContext);
	}
  
	public Object listByProcessing(YoubenbenUserContext userContext,String processingId) throws Exception {
		return listPageByProcessing(userContext, processingId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByProcessing(YoubenbenUserContext userContext,String processingId, int start, int count) throws Exception {
		SmartList<SupplyOrder> list = supplyOrderDaoOf(userContext).findSupplyOrderByProcessing(processingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(SupplyOrder.class);
		page.setContainerObject(SupplyOrderProcessing.withId(processingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应订单列表");
		page.setRequestName("listByProcessing");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByProcessing/%s/",  getBeanName(), processingId)));

		page.assemblerContent(userContext, "listByProcessing");
		return page.doRender(userContext);
	}
  
	public Object listByPicking(YoubenbenUserContext userContext,String pickingId) throws Exception {
		return listPageByPicking(userContext, pickingId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPicking(YoubenbenUserContext userContext,String pickingId, int start, int count) throws Exception {
		SmartList<SupplyOrder> list = supplyOrderDaoOf(userContext).findSupplyOrderByPicking(pickingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(SupplyOrder.class);
		page.setContainerObject(SupplyOrderPicking.withId(pickingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应订单列表");
		page.setRequestName("listByPicking");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByPicking/%s/",  getBeanName(), pickingId)));

		page.assemblerContent(userContext, "listByPicking");
		return page.doRender(userContext);
	}
  
	public Object listByShipment(YoubenbenUserContext userContext,String shipmentId) throws Exception {
		return listPageByShipment(userContext, shipmentId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByShipment(YoubenbenUserContext userContext,String shipmentId, int start, int count) throws Exception {
		SmartList<SupplyOrder> list = supplyOrderDaoOf(userContext).findSupplyOrderByShipment(shipmentId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(SupplyOrder.class);
		page.setContainerObject(SupplyOrderShipment.withId(shipmentId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应订单列表");
		page.setRequestName("listByShipment");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByShipment/%s/",  getBeanName(), shipmentId)));

		page.assemblerContent(userContext, "listByShipment");
		return page.doRender(userContext);
	}
  
	public Object listByDelivery(YoubenbenUserContext userContext,String deliveryId) throws Exception {
		return listPageByDelivery(userContext, deliveryId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDelivery(YoubenbenUserContext userContext,String deliveryId, int start, int count) throws Exception {
		SmartList<SupplyOrder> list = supplyOrderDaoOf(userContext).findSupplyOrderByDelivery(deliveryId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(SupplyOrder.class);
		page.setContainerObject(SupplyOrderDelivery.withId(deliveryId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应订单列表");
		page.setRequestName("listByDelivery");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDelivery/%s/",  getBeanName(), deliveryId)));

		page.assemblerContent(userContext, "listByDelivery");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String supplyOrderId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getSupplyOrderDetailScope().clone();
		SupplyOrder merchantObj = (SupplyOrder) this.view(userContext, supplyOrderId);
    String merchantObjId = supplyOrderId;
    String linkToUrl =	"supplyOrderManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "供应订单"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-buyer")
				    .put("fieldName", "buyer")
				    .put("label", "打包站商家")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("buyer", merchantObj.getBuyer());

		propList.add(
				MapUtil.put("id", "3-seller")
				    .put("fieldName", "seller")
				    .put("label", "卖方")
				    .put("type", "auto")
				    .put("linkToUrl", "goodsSupplierManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("seller", merchantObj.getSeller());

		propList.add(
				MapUtil.put("id", "4-title")
				    .put("fieldName", "title")
				    .put("label", "标题")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("title", merchantObj.getTitle());

		propList.add(
				MapUtil.put("id", "5-totalAmount")
				    .put("fieldName", "totalAmount")
				    .put("label", "总金额")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("totalAmount", merchantObj.getTotalAmount());

		propList.add(
				MapUtil.put("id", "6-confirmation")
				    .put("fieldName", "confirmation")
				    .put("label", "确认")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderConfirmationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"confirm_time\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("confirmation", merchantObj.getConfirmation());

		propList.add(
				MapUtil.put("id", "7-approval")
				    .put("fieldName", "approval")
				    .put("label", "审批公证员")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderApprovalManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"approve_time\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("approval", merchantObj.getApproval());

		propList.add(
				MapUtil.put("id", "8-processing")
				    .put("fieldName", "processing")
				    .put("label", "处理")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderProcessingManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"process_time\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("processing", merchantObj.getProcessing());

		propList.add(
				MapUtil.put("id", "9-picking")
				    .put("fieldName", "picking")
				    .put("label", "捡货")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderPickingManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"process_time\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("picking", merchantObj.getPicking());

		propList.add(
				MapUtil.put("id", "10-shipment")
				    .put("fieldName", "shipment")
				    .put("label", "装运")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderShipmentManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"ship_time\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("shipment", merchantObj.getShipment());

		propList.add(
				MapUtil.put("id", "11-delivery")
				    .put("fieldName", "delivery")
				    .put("label", "送货")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderDeliveryManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"delivery_time\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("delivery", merchantObj.getDelivery());

		propList.add(
				MapUtil.put("id", "12-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "最后更新时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：supplyOrderLineItemListSection
		Map supplyOrderLineItemListSection = ListofUtils.buildSection(
		    "supplyOrderLineItemListSection",
		    "供应订单行项目列表",
		    null,
		    "",
		    "__no_group",
		    "supplyOrderLineItemManager/listByBizOrder/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(supplyOrderLineItemListSection);

		result.put("supplyOrderLineItemListSection", ListofUtils.toShortList(merchantObj.getSupplyOrderLineItemList(), "supplyOrderLineItem"));
		vscope.field("supplyOrderLineItemListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( SupplyOrderLineItem.class.getName(), null));

		//处理Section：supplyOrderShippingGroupListSection
		Map supplyOrderShippingGroupListSection = ListofUtils.buildSection(
		    "supplyOrderShippingGroupListSection",
		    "供货订单发货组列表",
		    null,
		    "",
		    "__no_group",
		    "supplyOrderShippingGroupManager/listByBizOrder/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(supplyOrderShippingGroupListSection);

		result.put("supplyOrderShippingGroupListSection", ListofUtils.toShortList(merchantObj.getSupplyOrderShippingGroupList(), "supplyOrderShippingGroup"));
		vscope.field("supplyOrderShippingGroupListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( SupplyOrderShippingGroup.class.getName(), null));

		//处理Section：supplyOrderPaymentGroupListSection
		Map supplyOrderPaymentGroupListSection = ListofUtils.buildSection(
		    "supplyOrderPaymentGroupListSection",
		    "供货订单付款组列表",
		    null,
		    "",
		    "__no_group",
		    "supplyOrderPaymentGroupManager/listByBizOrder/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(supplyOrderPaymentGroupListSection);

		result.put("supplyOrderPaymentGroupListSection", ListofUtils.toShortList(merchantObj.getSupplyOrderPaymentGroupList(), "supplyOrderPaymentGroup"));
		vscope.field("supplyOrderPaymentGroupListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( SupplyOrderPaymentGroup.class.getName(), null));

		//处理Section：goodsListSection
		Map goodsListSection = ListofUtils.buildSection(
		    "goodsListSection",
		    "商品列表",
		    null,
		    "",
		    "__no_group",
		    "goodsManager/listByBizOrder/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(goodsListSection);

		result.put("goodsListSection", ListofUtils.toShortList(merchantObj.getGoodsList(), "goods"));
		vscope.field("goodsListSection", YoubenbenListOfViewScope.getInstance()
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


