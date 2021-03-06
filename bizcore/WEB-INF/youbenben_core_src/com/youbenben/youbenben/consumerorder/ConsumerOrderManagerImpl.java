
package com.youbenben.youbenben.consumerorder;

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


import com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDelivery;
import com.youbenben.youbenben.supplyorderapproval.SupplyOrderApproval;
import com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmation;
import com.youbenben.youbenben.consumerorderlineitem.ConsumerOrderLineItem;
import com.youbenben.youbenben.supplyordershipment.SupplyOrderShipment;
import com.youbenben.youbenben.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.youbenben.youbenben.retailstore.RetailStore;
import com.youbenben.youbenben.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.youbenben.youbenben.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.youbenben.youbenben.retailstoremember.RetailStoreMember;
import com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessing;
import com.youbenben.youbenben.consumerordershippinggroup.ConsumerOrderShippingGroup;

import com.youbenben.youbenben.supplyorderdelivery.CandidateSupplyOrderDelivery;
import com.youbenben.youbenben.supplyorderapproval.CandidateSupplyOrderApproval;
import com.youbenben.youbenben.supplyorderconfirmation.CandidateSupplyOrderConfirmation;
import com.youbenben.youbenben.supplyordershipment.CandidateSupplyOrderShipment;
import com.youbenben.youbenben.retailstore.CandidateRetailStore;
import com.youbenben.youbenben.retailstoremember.CandidateRetailStoreMember;
import com.youbenben.youbenben.supplyorderprocessing.CandidateSupplyOrderProcessing;

import com.youbenben.youbenben.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.youbenben.youbenben.consumerorder.ConsumerOrder;






public class ConsumerOrderManagerImpl extends CustomYoubenbenCheckerManager implements ConsumerOrderManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = ConsumerOrderTokens.start().withTokenFromListName(listName).done();
		ConsumerOrder  consumerOrder = (ConsumerOrder) this.loadConsumerOrder(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = consumerOrder.collectRefercencesFromLists();
		consumerOrderDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, consumerOrder, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new ConsumerOrderGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "ConsumerOrder";
	@Override
	public ConsumerOrderDAO daoOf(YoubenbenUserContext userContext) {
		return consumerOrderDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ConsumerOrderManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderManagerException(message);

	}



 	protected ConsumerOrder saveConsumerOrder(YoubenbenUserContext userContext, ConsumerOrder consumerOrder, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderDAO().save(consumerOrder, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrder(userContext, consumerOrder, tokens);
 	}
 	
 	protected ConsumerOrder saveConsumerOrderDetail(YoubenbenUserContext userContext, ConsumerOrder consumerOrder) throws Exception{	

 		
 		return saveConsumerOrder(userContext, consumerOrder, allTokens());
 	}
 	
 	public ConsumerOrder loadConsumerOrder(YoubenbenUserContext userContext, String consumerOrderId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrder consumerOrder = loadConsumerOrder( userContext, consumerOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrder, tokens);
 	}
 	
 	
 	 public ConsumerOrder searchConsumerOrder(YoubenbenUserContext userContext, String consumerOrderId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrder consumerOrder = loadConsumerOrder( userContext, consumerOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrder, tokens);
 	}
 	
 	

 	protected ConsumerOrder present(YoubenbenUserContext userContext, ConsumerOrder consumerOrder, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrder,tokens);
		
		
		ConsumerOrder  consumerOrderToPresent = consumerOrderDaoOf(userContext).present(consumerOrder, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderToPresent.collectRefercencesFromLists();
		consumerOrderDaoOf(userContext).alias(entityListToNaming);
		
		return  consumerOrderToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrder loadConsumerOrderDetail(YoubenbenUserContext userContext, String consumerOrderId) throws Exception{	
 		ConsumerOrder consumerOrder = loadConsumerOrder( userContext, consumerOrderId, allTokens());
 		return present(userContext,consumerOrder, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String consumerOrderId) throws Exception{	
 		ConsumerOrder consumerOrder = loadConsumerOrder( userContext, consumerOrderId, viewTokens());
 		return present(userContext,consumerOrder, allTokens());
		
 	}
 	protected ConsumerOrder saveConsumerOrder(YoubenbenUserContext userContext, ConsumerOrder consumerOrder, Map<String,Object>tokens) throws Exception{	
 		return consumerOrderDaoOf(userContext).save(consumerOrder, tokens);
 	}
 	protected ConsumerOrder loadConsumerOrder(YoubenbenUserContext userContext, String consumerOrderId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderManagerException.class);

 
 		return consumerOrderDaoOf(userContext).load(consumerOrderId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, ConsumerOrder consumerOrder, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrder, tokens);
		
		addAction(userContext, consumerOrder, tokens,"@create","createConsumerOrder","createConsumerOrder/","main","primary");
		addAction(userContext, consumerOrder, tokens,"@update","updateConsumerOrder","updateConsumerOrder/"+consumerOrder.getId()+"/","main","primary");
		addAction(userContext, consumerOrder, tokens,"@copy","cloneConsumerOrder","cloneConsumerOrder/"+consumerOrder.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrder, tokens,"consumer_order.transfer_to_consumer","transferToAnotherConsumer","transferToAnotherConsumer/"+consumerOrder.getId()+"/","main","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.transfer_to_confirmation","transferToAnotherConfirmation","transferToAnotherConfirmation/"+consumerOrder.getId()+"/","main","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.transfer_to_approval","transferToAnotherApproval","transferToAnotherApproval/"+consumerOrder.getId()+"/","main","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.transfer_to_processing","transferToAnotherProcessing","transferToAnotherProcessing/"+consumerOrder.getId()+"/","main","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.transfer_to_shipment","transferToAnotherShipment","transferToAnotherShipment/"+consumerOrder.getId()+"/","main","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.transfer_to_delivery","transferToAnotherDelivery","transferToAnotherDelivery/"+consumerOrder.getId()+"/","main","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.transfer_to_store","transferToAnotherStore","transferToAnotherStore/"+consumerOrder.getId()+"/","main","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.addConsumerOrderLineItem","addConsumerOrderLineItem","addConsumerOrderLineItem/"+consumerOrder.getId()+"/","consumerOrderLineItemList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.removeConsumerOrderLineItem","removeConsumerOrderLineItem","removeConsumerOrderLineItem/"+consumerOrder.getId()+"/","consumerOrderLineItemList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.updateConsumerOrderLineItem","updateConsumerOrderLineItem","updateConsumerOrderLineItem/"+consumerOrder.getId()+"/","consumerOrderLineItemList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.copyConsumerOrderLineItemFrom","copyConsumerOrderLineItemFrom","copyConsumerOrderLineItemFrom/"+consumerOrder.getId()+"/","consumerOrderLineItemList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.addConsumerOrderShippingGroup","addConsumerOrderShippingGroup","addConsumerOrderShippingGroup/"+consumerOrder.getId()+"/","consumerOrderShippingGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.removeConsumerOrderShippingGroup","removeConsumerOrderShippingGroup","removeConsumerOrderShippingGroup/"+consumerOrder.getId()+"/","consumerOrderShippingGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.updateConsumerOrderShippingGroup","updateConsumerOrderShippingGroup","updateConsumerOrderShippingGroup/"+consumerOrder.getId()+"/","consumerOrderShippingGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.copyConsumerOrderShippingGroupFrom","copyConsumerOrderShippingGroupFrom","copyConsumerOrderShippingGroupFrom/"+consumerOrder.getId()+"/","consumerOrderShippingGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.addConsumerOrderPaymentGroup","addConsumerOrderPaymentGroup","addConsumerOrderPaymentGroup/"+consumerOrder.getId()+"/","consumerOrderPaymentGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.removeConsumerOrderPaymentGroup","removeConsumerOrderPaymentGroup","removeConsumerOrderPaymentGroup/"+consumerOrder.getId()+"/","consumerOrderPaymentGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.updateConsumerOrderPaymentGroup","updateConsumerOrderPaymentGroup","updateConsumerOrderPaymentGroup/"+consumerOrder.getId()+"/","consumerOrderPaymentGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.copyConsumerOrderPaymentGroupFrom","copyConsumerOrderPaymentGroupFrom","copyConsumerOrderPaymentGroupFrom/"+consumerOrder.getId()+"/","consumerOrderPaymentGroupList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.addConsumerOrderPriceAdjustment","addConsumerOrderPriceAdjustment","addConsumerOrderPriceAdjustment/"+consumerOrder.getId()+"/","consumerOrderPriceAdjustmentList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.removeConsumerOrderPriceAdjustment","removeConsumerOrderPriceAdjustment","removeConsumerOrderPriceAdjustment/"+consumerOrder.getId()+"/","consumerOrderPriceAdjustmentList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.updateConsumerOrderPriceAdjustment","updateConsumerOrderPriceAdjustment","updateConsumerOrderPriceAdjustment/"+consumerOrder.getId()+"/","consumerOrderPriceAdjustmentList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.copyConsumerOrderPriceAdjustmentFrom","copyConsumerOrderPriceAdjustmentFrom","copyConsumerOrderPriceAdjustmentFrom/"+consumerOrder.getId()+"/","consumerOrderPriceAdjustmentList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.addRetailStoreMemberGiftCardConsumeRecord","addRetailStoreMemberGiftCardConsumeRecord","addRetailStoreMemberGiftCardConsumeRecord/"+consumerOrder.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.removeRetailStoreMemberGiftCardConsumeRecord","removeRetailStoreMemberGiftCardConsumeRecord","removeRetailStoreMemberGiftCardConsumeRecord/"+consumerOrder.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.updateRetailStoreMemberGiftCardConsumeRecord","updateRetailStoreMemberGiftCardConsumeRecord","updateRetailStoreMemberGiftCardConsumeRecord/"+consumerOrder.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, consumerOrder, tokens,"consumer_order.copyRetailStoreMemberGiftCardConsumeRecordFrom","copyRetailStoreMemberGiftCardConsumeRecordFrom","copyRetailStoreMemberGiftCardConsumeRecordFrom/"+consumerOrder.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, ConsumerOrder consumerOrder, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ConsumerOrder createConsumerOrder(YoubenbenUserContext userContext, String title,String consumerId,String confirmationId,String approvalId,String processingId,String shipmentId,String deliveryId,String storeId) throws Exception
	//public ConsumerOrder createConsumerOrder(YoubenbenUserContext userContext,String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfConsumerOrder(title);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);


		ConsumerOrder consumerOrder=createNewConsumerOrder();	

		consumerOrder.setTitle(title);
			
		RetailStoreMember consumer = loadRetailStoreMember(userContext, consumerId,emptyOptions());
		consumerOrder.setConsumer(consumer);
		
		
			
		SupplyOrderConfirmation confirmation = loadSupplyOrderConfirmation(userContext, confirmationId,emptyOptions());
		consumerOrder.setConfirmation(confirmation);
		
		
			
		SupplyOrderApproval approval = loadSupplyOrderApproval(userContext, approvalId,emptyOptions());
		consumerOrder.setApproval(approval);
		
		
			
		SupplyOrderProcessing processing = loadSupplyOrderProcessing(userContext, processingId,emptyOptions());
		consumerOrder.setProcessing(processing);
		
		
			
		SupplyOrderShipment shipment = loadSupplyOrderShipment(userContext, shipmentId,emptyOptions());
		consumerOrder.setShipment(shipment);
		
		
			
		SupplyOrderDelivery delivery = loadSupplyOrderDelivery(userContext, deliveryId,emptyOptions());
		consumerOrder.setDelivery(delivery);
		
		
			
		RetailStore store = loadRetailStore(userContext, storeId,emptyOptions());
		consumerOrder.setStore(store);
		
		
		consumerOrder.setLastUpdateTime(userContext.now());

		consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrder);
		return consumerOrder;


	}
	protected ConsumerOrder createNewConsumerOrder()
	{

		return new ConsumerOrder();
	}

	protected void checkParamsForUpdatingConsumerOrder(YoubenbenUserContext userContext,String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder( consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		
			
		}		

				

				

				

				

				

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);


	}



	public ConsumerOrder clone(YoubenbenUserContext userContext, String fromConsumerOrderId) throws Exception{

		return consumerOrderDaoOf(userContext).clone(fromConsumerOrderId, this.allTokens());
	}

	public ConsumerOrder internalSaveConsumerOrder(YoubenbenUserContext userContext, ConsumerOrder consumerOrder) throws Exception
	{
		return internalSaveConsumerOrder(userContext, consumerOrder, allTokens());

	}
	public ConsumerOrder internalSaveConsumerOrder(YoubenbenUserContext userContext, ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingConsumerOrder(userContext, consumerOrderId, consumerOrderVersion, property, newValueExpr, tokensExpr);


		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrder.
			if (consumerOrder.isChanged()){
			consumerOrder.updateLastUpdateTime(userContext.now());
			}
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, options);
			return consumerOrder;

		}

	}

	public ConsumerOrder updateConsumerOrder(YoubenbenUserContext userContext,String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrder(userContext, consumerOrderId, consumerOrderVersion, property, newValueExpr, tokensExpr);



		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		if(consumerOrder.getVersion() != consumerOrderVersion){
			String message = "The target version("+consumerOrder.getVersion()+") is not equals to version("+consumerOrderVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrder.
			consumerOrder.updateLastUpdateTime(userContext.now());
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
			//return saveConsumerOrder(userContext, consumerOrder, tokens().done());
		}

	}

	public ConsumerOrder updateConsumerOrderProperty(YoubenbenUserContext userContext,String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrder(userContext, consumerOrderId, consumerOrderVersion, property, newValueExpr, tokensExpr);

		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		if(consumerOrder.getVersion() != consumerOrderVersion){
			String message = "The target version("+consumerOrder.getVersion()+") is not equals to version("+consumerOrderVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrder.

			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
			//return saveConsumerOrder(userContext, consumerOrder, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ConsumerOrderTokens tokens(){
		return ConsumerOrderTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderLineItemListWith("id","desc")
		.sortConsumerOrderShippingGroupListWith("id","desc")
		.sortConsumerOrderPaymentGroupListWith("id","desc")
		.sortConsumerOrderPriceAdjustmentListWith("id","desc")
		.sortRetailStoreMemberGiftCardConsumeRecordListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherConsumer(YoubenbenUserContext userContext, String consumerOrderId, String anotherConsumerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
 		checkerOf(userContext).checkIdOfRetailStoreMember(anotherConsumerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

 	}
 	public ConsumerOrder transferToAnotherConsumer(YoubenbenUserContext userContext, String consumerOrderId, String anotherConsumerId) throws Exception
 	{
 		checkParamsForTransferingAnotherConsumer(userContext, consumerOrderId,anotherConsumerId);
 
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember consumer = loadRetailStoreMember(userContext, anotherConsumerId, emptyOptions());		
			consumerOrder.updateConsumer(consumer);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());
			
			return present(userContext,consumerOrder, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreMember requestCandidateConsumer(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreMember result = new CandidateRetailStoreMember();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreMember> candidateList = retailStoreMemberDaoOf(userContext).requestCandidateRetailStoreMemberForConsumerOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherConfirmation(YoubenbenUserContext userContext, String consumerOrderId, String anotherConfirmationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
 		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(anotherConfirmationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

 	}
 	public ConsumerOrder transferToAnotherConfirmation(YoubenbenUserContext userContext, String consumerOrderId, String anotherConfirmationId) throws Exception
 	{
 		checkParamsForTransferingAnotherConfirmation(userContext, consumerOrderId,anotherConfirmationId);
 
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderConfirmation confirmation = loadSupplyOrderConfirmation(userContext, anotherConfirmationId, emptyOptions());		
			consumerOrder.updateConfirmation(confirmation);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());
			
			return present(userContext,consumerOrder, allTokens());
			
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
		SmartList<SupplyOrderConfirmation> candidateList = supplyOrderConfirmationDaoOf(userContext).requestCandidateSupplyOrderConfirmationForConsumerOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherApproval(YoubenbenUserContext userContext, String consumerOrderId, String anotherApprovalId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
 		checkerOf(userContext).checkIdOfSupplyOrderApproval(anotherApprovalId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

 	}
 	public ConsumerOrder transferToAnotherApproval(YoubenbenUserContext userContext, String consumerOrderId, String anotherApprovalId) throws Exception
 	{
 		checkParamsForTransferingAnotherApproval(userContext, consumerOrderId,anotherApprovalId);
 
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderApproval approval = loadSupplyOrderApproval(userContext, anotherApprovalId, emptyOptions());		
			consumerOrder.updateApproval(approval);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());
			
			return present(userContext,consumerOrder, allTokens());
			
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
		SmartList<SupplyOrderApproval> candidateList = supplyOrderApprovalDaoOf(userContext).requestCandidateSupplyOrderApprovalForConsumerOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherProcessing(YoubenbenUserContext userContext, String consumerOrderId, String anotherProcessingId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
 		checkerOf(userContext).checkIdOfSupplyOrderProcessing(anotherProcessingId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

 	}
 	public ConsumerOrder transferToAnotherProcessing(YoubenbenUserContext userContext, String consumerOrderId, String anotherProcessingId) throws Exception
 	{
 		checkParamsForTransferingAnotherProcessing(userContext, consumerOrderId,anotherProcessingId);
 
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderProcessing processing = loadSupplyOrderProcessing(userContext, anotherProcessingId, emptyOptions());		
			consumerOrder.updateProcessing(processing);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());
			
			return present(userContext,consumerOrder, allTokens());
			
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
		SmartList<SupplyOrderProcessing> candidateList = supplyOrderProcessingDaoOf(userContext).requestCandidateSupplyOrderProcessingForConsumerOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherShipment(YoubenbenUserContext userContext, String consumerOrderId, String anotherShipmentId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
 		checkerOf(userContext).checkIdOfSupplyOrderShipment(anotherShipmentId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

 	}
 	public ConsumerOrder transferToAnotherShipment(YoubenbenUserContext userContext, String consumerOrderId, String anotherShipmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherShipment(userContext, consumerOrderId,anotherShipmentId);
 
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderShipment shipment = loadSupplyOrderShipment(userContext, anotherShipmentId, emptyOptions());		
			consumerOrder.updateShipment(shipment);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());
			
			return present(userContext,consumerOrder, allTokens());
			
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
		SmartList<SupplyOrderShipment> candidateList = supplyOrderShipmentDaoOf(userContext).requestCandidateSupplyOrderShipmentForConsumerOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherDelivery(YoubenbenUserContext userContext, String consumerOrderId, String anotherDeliveryId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
 		checkerOf(userContext).checkIdOfSupplyOrderDelivery(anotherDeliveryId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

 	}
 	public ConsumerOrder transferToAnotherDelivery(YoubenbenUserContext userContext, String consumerOrderId, String anotherDeliveryId) throws Exception
 	{
 		checkParamsForTransferingAnotherDelivery(userContext, consumerOrderId,anotherDeliveryId);
 
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderDelivery delivery = loadSupplyOrderDelivery(userContext, anotherDeliveryId, emptyOptions());		
			consumerOrder.updateDelivery(delivery);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());
			
			return present(userContext,consumerOrder, allTokens());
			
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
		SmartList<SupplyOrderDelivery> candidateList = supplyOrderDeliveryDaoOf(userContext).requestCandidateSupplyOrderDeliveryForConsumerOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherStore(YoubenbenUserContext userContext, String consumerOrderId, String anotherStoreId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
 		checkerOf(userContext).checkIdOfRetailStore(anotherStoreId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

 	}
 	public ConsumerOrder transferToAnotherStore(YoubenbenUserContext userContext, String consumerOrderId, String anotherStoreId) throws Exception
 	{
 		checkParamsForTransferingAnotherStore(userContext, consumerOrderId,anotherStoreId);
 
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());	
		synchronized(consumerOrder){
			//will be good when the consumerOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStore store = loadRetailStore(userContext, anotherStoreId, emptyOptions());		
			consumerOrder.updateStore(store);		
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());
			
			return present(userContext,consumerOrder, allTokens());
			
		}

 	}

	


	public CandidateRetailStore requestCandidateStore(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStore result = new CandidateRetailStore();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStore> candidateList = retailStoreDaoOf(userContext).requestCandidateRetailStoreForConsumerOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreMember loadRetailStoreMember(YoubenbenUserContext userContext, String newConsumerId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreMemberDaoOf(userContext).load(newConsumerId, options);
 	}
 	


	

 	protected SupplyOrderProcessing loadSupplyOrderProcessing(YoubenbenUserContext userContext, String newProcessingId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderProcessingDaoOf(userContext).load(newProcessingId, options);
 	}
 	


	

 	protected SupplyOrderApproval loadSupplyOrderApproval(YoubenbenUserContext userContext, String newApprovalId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderApprovalDaoOf(userContext).load(newApprovalId, options);
 	}
 	


	

 	protected RetailStore loadRetailStore(YoubenbenUserContext userContext, String newStoreId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreDaoOf(userContext).load(newStoreId, options);
 	}
 	


	

 	protected SupplyOrderDelivery loadSupplyOrderDelivery(YoubenbenUserContext userContext, String newDeliveryId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderDeliveryDaoOf(userContext).load(newDeliveryId, options);
 	}
 	


	

 	protected SupplyOrderConfirmation loadSupplyOrderConfirmation(YoubenbenUserContext userContext, String newConfirmationId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderConfirmationDaoOf(userContext).load(newConfirmationId, options);
 	}
 	


	

 	protected SupplyOrderShipment loadSupplyOrderShipment(YoubenbenUserContext userContext, String newShipmentId, Map<String,Object> options) throws Exception
 	{

 		return supplyOrderShipmentDaoOf(userContext).load(newShipmentId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String consumerOrderId, int consumerOrderVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderId, consumerOrderVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String consumerOrderId, int consumerOrderVersion) throws Exception{

		consumerOrderDaoOf(userContext).delete(consumerOrderId, consumerOrderVersion);
	}

	public ConsumerOrder forgetByAll(YoubenbenUserContext userContext, String consumerOrderId, int consumerOrderVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderId, consumerOrderVersion);
	}
	protected ConsumerOrder forgetByAllInternal(YoubenbenUserContext userContext,
			String consumerOrderId, int consumerOrderVersion) throws Exception{

		return consumerOrderDaoOf(userContext).disconnectFromAll(consumerOrderId, consumerOrderVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return consumerOrderDaoOf(userContext).deleteAll();
	}


	//disconnect ConsumerOrder with sku_id in ConsumerOrderLineItem
	protected ConsumerOrder breakWithConsumerOrderLineItemBySkuId(YoubenbenUserContext userContext, String consumerOrderId, String skuIdId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());

			synchronized(consumerOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				consumerOrderDaoOf(userContext).planToRemoveConsumerOrderLineItemListWithSkuId(consumerOrder, skuIdId, this.emptyOptions());

				consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
				return consumerOrder;
			}
	}
	//disconnect ConsumerOrder with owner in RetailStoreMemberGiftCardConsumeRecord
	protected ConsumerOrder breakWithRetailStoreMemberGiftCardConsumeRecordByOwner(YoubenbenUserContext userContext, String consumerOrderId, String ownerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());

			synchronized(consumerOrder){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				consumerOrderDaoOf(userContext).planToRemoveRetailStoreMemberGiftCardConsumeRecordListWithOwner(consumerOrder, ownerId, this.emptyOptions());

				consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
				return consumerOrder;
			}
	}






	protected void checkParamsForAddingConsumerOrderLineItem(YoubenbenUserContext userContext, String consumerOrderId, String skuId, String skuName, BigDecimal price, BigDecimal quantity, BigDecimal amount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

		
		checkerOf(userContext).checkSkuIdOfConsumerOrderLineItem(skuId);
		
		checkerOf(userContext).checkSkuNameOfConsumerOrderLineItem(skuName);
		
		checkerOf(userContext).checkPriceOfConsumerOrderLineItem(price);
		
		checkerOf(userContext).checkQuantityOfConsumerOrderLineItem(quantity);
		
		checkerOf(userContext).checkAmountOfConsumerOrderLineItem(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);


	}
	public  ConsumerOrder addConsumerOrderLineItem(YoubenbenUserContext userContext, String consumerOrderId, String skuId, String skuName, BigDecimal price, BigDecimal quantity, BigDecimal amount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingConsumerOrderLineItem(userContext,consumerOrderId,skuId, skuName, price, quantity, amount,tokensExpr);

		ConsumerOrderLineItem consumerOrderLineItem = createConsumerOrderLineItem(userContext,skuId, skuName, price, quantity, amount);

		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, emptyOptions());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.addConsumerOrderLineItem( consumerOrderLineItem );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
			
			userContext.getManagerGroup().getConsumerOrderLineItemManager().onNewInstanceCreated(userContext, consumerOrderLineItem);
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderLineItemProperties(YoubenbenUserContext userContext, String consumerOrderId,String id,String skuId,String skuName,BigDecimal price,BigDecimal quantity,BigDecimal amount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderLineItem(id);

		checkerOf(userContext).checkSkuIdOfConsumerOrderLineItem( skuId);
		checkerOf(userContext).checkSkuNameOfConsumerOrderLineItem( skuName);
		checkerOf(userContext).checkPriceOfConsumerOrderLineItem( price);
		checkerOf(userContext).checkQuantityOfConsumerOrderLineItem( quantity);
		checkerOf(userContext).checkAmountOfConsumerOrderLineItem( amount);

		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder updateConsumerOrderLineItemProperties(YoubenbenUserContext userContext, String consumerOrderId, String id,String skuId,String skuName,BigDecimal price,BigDecimal quantity,BigDecimal amount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderLineItemProperties(userContext,consumerOrderId,id,skuId,skuName,price,quantity,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderLineItemListList()
				.searchConsumerOrderLineItemListWith(ConsumerOrderLineItem.ID_PROPERTY, "is", id).done();

		ConsumerOrder consumerOrderToUpdate = loadConsumerOrder(userContext, consumerOrderId, options);

		if(consumerOrderToUpdate.getConsumerOrderLineItemList().isEmpty()){
			throw new ConsumerOrderManagerException("ConsumerOrderLineItem is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrderLineItem item = consumerOrderToUpdate.getConsumerOrderLineItemList().first();

		item.updateSkuId( skuId );
		item.updateSkuName( skuName );
		item.updatePrice( price );
		item.updateQuantity( quantity );
		item.updateAmount( amount );


		//checkParamsForAddingConsumerOrderLineItem(userContext,consumerOrderId,name, code, used,tokensExpr);
		ConsumerOrder consumerOrder = saveConsumerOrder(userContext, consumerOrderToUpdate, tokens().withConsumerOrderLineItemList().done());
		synchronized(consumerOrder){
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}


	protected ConsumerOrderLineItem createConsumerOrderLineItem(YoubenbenUserContext userContext, String skuId, String skuName, BigDecimal price, BigDecimal quantity, BigDecimal amount) throws Exception{

		ConsumerOrderLineItem consumerOrderLineItem = new ConsumerOrderLineItem();
		
		
		consumerOrderLineItem.setSkuId(skuId);		
		consumerOrderLineItem.setSkuName(skuName);		
		consumerOrderLineItem.setPrice(price);		
		consumerOrderLineItem.setQuantity(quantity);		
		consumerOrderLineItem.setAmount(amount);		
		consumerOrderLineItem.setLastUpdateTime(userContext.now());
	
		
		return consumerOrderLineItem;


	}

	protected ConsumerOrderLineItem createIndexedConsumerOrderLineItem(String id, int version){

		ConsumerOrderLineItem consumerOrderLineItem = new ConsumerOrderLineItem();
		consumerOrderLineItem.setId(id);
		consumerOrderLineItem.setVersion(version);
		return consumerOrderLineItem;

	}

	protected void checkParamsForRemovingConsumerOrderLineItemList(YoubenbenUserContext userContext, String consumerOrderId,
			String consumerOrderLineItemIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		for(String consumerOrderLineItemIdItem: consumerOrderLineItemIds){
			checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder removeConsumerOrderLineItemList(YoubenbenUserContext userContext, String consumerOrderId,
			String consumerOrderLineItemIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderLineItemList(userContext, consumerOrderId,  consumerOrderLineItemIds, tokensExpr);


			ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
			synchronized(consumerOrder){
				//Will be good when the consumerOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				consumerOrderDaoOf(userContext).planToRemoveConsumerOrderLineItemList(consumerOrder, consumerOrderLineItemIds, allTokens());
				consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
				deleteRelationListInGraph(userContext, consumerOrder.getConsumerOrderLineItemList());
				return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrderLineItem(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderLineItemId, int consumerOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfConsumerOrder( consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
		checkerOf(userContext).checkVersionOfConsumerOrderLineItem(consumerOrderLineItemVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder removeConsumerOrderLineItem(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderLineItemId, int consumerOrderLineItemVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrderLineItem(userContext,consumerOrderId, consumerOrderLineItemId, consumerOrderLineItemVersion,tokensExpr);

		ConsumerOrderLineItem consumerOrderLineItem = createIndexedConsumerOrderLineItem(consumerOrderLineItemId, consumerOrderLineItemVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.removeConsumerOrderLineItem( consumerOrderLineItem );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
			deleteRelationInGraph(userContext, consumerOrderLineItem);
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrderLineItem(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderLineItemId, int consumerOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfConsumerOrder( consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
		checkerOf(userContext).checkVersionOfConsumerOrderLineItem(consumerOrderLineItemVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder copyConsumerOrderLineItemFrom(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderLineItemId, int consumerOrderLineItemVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrderLineItem(userContext,consumerOrderId, consumerOrderLineItemId, consumerOrderLineItemVersion,tokensExpr);

		ConsumerOrderLineItem consumerOrderLineItem = createIndexedConsumerOrderLineItem(consumerOrderLineItemId, consumerOrderLineItemVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			consumerOrderLineItem.updateLastUpdateTime(userContext.now());

			consumerOrder.copyConsumerOrderLineItemFrom( consumerOrderLineItem );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
			
			userContext.getManagerGroup().getConsumerOrderLineItemManager().onNewInstanceCreated(userContext, (ConsumerOrderLineItem)consumerOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrderLineItem(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
		checkerOf(userContext).checkVersionOfConsumerOrderLineItem(consumerOrderLineItemVersion);
		

		if(ConsumerOrderLineItem.SKU_ID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSkuIdOfConsumerOrderLineItem(parseString(newValueExpr));
		
		}
		
		if(ConsumerOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSkuNameOfConsumerOrderLineItem(parseString(newValueExpr));
		
		}
		
		if(ConsumerOrderLineItem.PRICE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPriceOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
		
		}
		
		if(ConsumerOrderLineItem.QUANTITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkQuantityOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
		
		}
		
		if(ConsumerOrderLineItem.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}

	public  ConsumerOrder updateConsumerOrderLineItem(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrderLineItem(userContext, consumerOrderId, consumerOrderLineItemId, consumerOrderLineItemVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderLineItemList().searchConsumerOrderLineItemListWith(ConsumerOrderLineItem.ID_PROPERTY, "eq", consumerOrderLineItemId).done();



		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, loadTokens);

		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//consumerOrder.removeConsumerOrderLineItem( consumerOrderLineItem );
			//make changes to AcceleraterAccount.
			ConsumerOrderLineItem consumerOrderLineItemIndex = createIndexedConsumerOrderLineItem(consumerOrderLineItemId, consumerOrderLineItemVersion);

			ConsumerOrderLineItem consumerOrderLineItem = consumerOrder.findTheConsumerOrderLineItem(consumerOrderLineItemIndex);
			if(consumerOrderLineItem == null){
				throw new ConsumerOrderManagerException(consumerOrderLineItem+" is NOT FOUND" );
			}

			consumerOrderLineItem.changeProperty(property, newValueExpr);
			consumerOrderLineItem.updateLastUpdateTime(userContext.now());
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingConsumerOrderShippingGroup(YoubenbenUserContext userContext, String consumerOrderId, String name, BigDecimal amount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

		
		checkerOf(userContext).checkNameOfConsumerOrderShippingGroup(name);
		
		checkerOf(userContext).checkAmountOfConsumerOrderShippingGroup(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);


	}
	public  ConsumerOrder addConsumerOrderShippingGroup(YoubenbenUserContext userContext, String consumerOrderId, String name, BigDecimal amount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingConsumerOrderShippingGroup(userContext,consumerOrderId,name, amount,tokensExpr);

		ConsumerOrderShippingGroup consumerOrderShippingGroup = createConsumerOrderShippingGroup(userContext,name, amount);

		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, emptyOptions());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.addConsumerOrderShippingGroup( consumerOrderShippingGroup );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
			
			userContext.getManagerGroup().getConsumerOrderShippingGroupManager().onNewInstanceCreated(userContext, consumerOrderShippingGroup);
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderShippingGroupProperties(YoubenbenUserContext userContext, String consumerOrderId,String id,String name,BigDecimal amount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(id);

		checkerOf(userContext).checkNameOfConsumerOrderShippingGroup( name);
		checkerOf(userContext).checkAmountOfConsumerOrderShippingGroup( amount);

		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder updateConsumerOrderShippingGroupProperties(YoubenbenUserContext userContext, String consumerOrderId, String id,String name,BigDecimal amount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderShippingGroupProperties(userContext,consumerOrderId,id,name,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderShippingGroupListList()
				.searchConsumerOrderShippingGroupListWith(ConsumerOrderShippingGroup.ID_PROPERTY, "is", id).done();

		ConsumerOrder consumerOrderToUpdate = loadConsumerOrder(userContext, consumerOrderId, options);

		if(consumerOrderToUpdate.getConsumerOrderShippingGroupList().isEmpty()){
			throw new ConsumerOrderManagerException("ConsumerOrderShippingGroup is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrderShippingGroup item = consumerOrderToUpdate.getConsumerOrderShippingGroupList().first();

		item.updateName( name );
		item.updateAmount( amount );


		//checkParamsForAddingConsumerOrderShippingGroup(userContext,consumerOrderId,name, code, used,tokensExpr);
		ConsumerOrder consumerOrder = saveConsumerOrder(userContext, consumerOrderToUpdate, tokens().withConsumerOrderShippingGroupList().done());
		synchronized(consumerOrder){
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}


	protected ConsumerOrderShippingGroup createConsumerOrderShippingGroup(YoubenbenUserContext userContext, String name, BigDecimal amount) throws Exception{

		ConsumerOrderShippingGroup consumerOrderShippingGroup = new ConsumerOrderShippingGroup();
		
		
		consumerOrderShippingGroup.setName(name);		
		consumerOrderShippingGroup.setAmount(amount);
	
		
		return consumerOrderShippingGroup;


	}

	protected ConsumerOrderShippingGroup createIndexedConsumerOrderShippingGroup(String id, int version){

		ConsumerOrderShippingGroup consumerOrderShippingGroup = new ConsumerOrderShippingGroup();
		consumerOrderShippingGroup.setId(id);
		consumerOrderShippingGroup.setVersion(version);
		return consumerOrderShippingGroup;

	}

	protected void checkParamsForRemovingConsumerOrderShippingGroupList(YoubenbenUserContext userContext, String consumerOrderId,
			String consumerOrderShippingGroupIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		for(String consumerOrderShippingGroupIdItem: consumerOrderShippingGroupIds){
			checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder removeConsumerOrderShippingGroupList(YoubenbenUserContext userContext, String consumerOrderId,
			String consumerOrderShippingGroupIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderShippingGroupList(userContext, consumerOrderId,  consumerOrderShippingGroupIds, tokensExpr);


			ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
			synchronized(consumerOrder){
				//Will be good when the consumerOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				consumerOrderDaoOf(userContext).planToRemoveConsumerOrderShippingGroupList(consumerOrder, consumerOrderShippingGroupIds, allTokens());
				consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
				deleteRelationListInGraph(userContext, consumerOrder.getConsumerOrderShippingGroupList());
				return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrderShippingGroup(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfConsumerOrder( consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		checkerOf(userContext).checkVersionOfConsumerOrderShippingGroup(consumerOrderShippingGroupVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder removeConsumerOrderShippingGroup(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrderShippingGroup(userContext,consumerOrderId, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion,tokensExpr);

		ConsumerOrderShippingGroup consumerOrderShippingGroup = createIndexedConsumerOrderShippingGroup(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.removeConsumerOrderShippingGroup( consumerOrderShippingGroup );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
			deleteRelationInGraph(userContext, consumerOrderShippingGroup);
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrderShippingGroup(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfConsumerOrder( consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		checkerOf(userContext).checkVersionOfConsumerOrderShippingGroup(consumerOrderShippingGroupVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder copyConsumerOrderShippingGroupFrom(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrderShippingGroup(userContext,consumerOrderId, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion,tokensExpr);

		ConsumerOrderShippingGroup consumerOrderShippingGroup = createIndexedConsumerOrderShippingGroup(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			consumerOrder.copyConsumerOrderShippingGroupFrom( consumerOrderShippingGroup );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
			
			userContext.getManagerGroup().getConsumerOrderShippingGroupManager().onNewInstanceCreated(userContext, (ConsumerOrderShippingGroup)consumerOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrderShippingGroup(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		checkerOf(userContext).checkVersionOfConsumerOrderShippingGroup(consumerOrderShippingGroupVersion);
		

		if(ConsumerOrderShippingGroup.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfConsumerOrderShippingGroup(parseString(newValueExpr));
		
		}
		
		if(ConsumerOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfConsumerOrderShippingGroup(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}

	public  ConsumerOrder updateConsumerOrderShippingGroup(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderId, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderShippingGroupList().searchConsumerOrderShippingGroupListWith(ConsumerOrderShippingGroup.ID_PROPERTY, "eq", consumerOrderShippingGroupId).done();



		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, loadTokens);

		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//consumerOrder.removeConsumerOrderShippingGroup( consumerOrderShippingGroup );
			//make changes to AcceleraterAccount.
			ConsumerOrderShippingGroup consumerOrderShippingGroupIndex = createIndexedConsumerOrderShippingGroup(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);

			ConsumerOrderShippingGroup consumerOrderShippingGroup = consumerOrder.findTheConsumerOrderShippingGroup(consumerOrderShippingGroupIndex);
			if(consumerOrderShippingGroup == null){
				throw new ConsumerOrderManagerException(consumerOrderShippingGroup+" is NOT FOUND" );
			}

			consumerOrderShippingGroup.changeProperty(property, newValueExpr);
			
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String consumerOrderId, String name, String cardNumber,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

		
		checkerOf(userContext).checkNameOfConsumerOrderPaymentGroup(name);
		
		checkerOf(userContext).checkCardNumberOfConsumerOrderPaymentGroup(cardNumber);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);


	}
	public  ConsumerOrder addConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String consumerOrderId, String name, String cardNumber, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingConsumerOrderPaymentGroup(userContext,consumerOrderId,name, cardNumber,tokensExpr);

		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = createConsumerOrderPaymentGroup(userContext,name, cardNumber);

		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, emptyOptions());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.addConsumerOrderPaymentGroup( consumerOrderPaymentGroup );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
			
			userContext.getManagerGroup().getConsumerOrderPaymentGroupManager().onNewInstanceCreated(userContext, consumerOrderPaymentGroup);
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderPaymentGroupProperties(YoubenbenUserContext userContext, String consumerOrderId,String id,String name,String cardNumber,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderPaymentGroup(id);

		checkerOf(userContext).checkNameOfConsumerOrderPaymentGroup( name);
		checkerOf(userContext).checkCardNumberOfConsumerOrderPaymentGroup( cardNumber);

		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder updateConsumerOrderPaymentGroupProperties(YoubenbenUserContext userContext, String consumerOrderId, String id,String name,String cardNumber, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderPaymentGroupProperties(userContext,consumerOrderId,id,name,cardNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderPaymentGroupListList()
				.searchConsumerOrderPaymentGroupListWith(ConsumerOrderPaymentGroup.ID_PROPERTY, "is", id).done();

		ConsumerOrder consumerOrderToUpdate = loadConsumerOrder(userContext, consumerOrderId, options);

		if(consumerOrderToUpdate.getConsumerOrderPaymentGroupList().isEmpty()){
			throw new ConsumerOrderManagerException("ConsumerOrderPaymentGroup is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrderPaymentGroup item = consumerOrderToUpdate.getConsumerOrderPaymentGroupList().first();

		item.updateName( name );
		item.updateCardNumber( cardNumber );


		//checkParamsForAddingConsumerOrderPaymentGroup(userContext,consumerOrderId,name, code, used,tokensExpr);
		ConsumerOrder consumerOrder = saveConsumerOrder(userContext, consumerOrderToUpdate, tokens().withConsumerOrderPaymentGroupList().done());
		synchronized(consumerOrder){
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}


	protected ConsumerOrderPaymentGroup createConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String name, String cardNumber) throws Exception{

		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = new ConsumerOrderPaymentGroup();
		
		
		consumerOrderPaymentGroup.setName(name);		
		consumerOrderPaymentGroup.setCardNumber(cardNumber);
	
		
		return consumerOrderPaymentGroup;


	}

	protected ConsumerOrderPaymentGroup createIndexedConsumerOrderPaymentGroup(String id, int version){

		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = new ConsumerOrderPaymentGroup();
		consumerOrderPaymentGroup.setId(id);
		consumerOrderPaymentGroup.setVersion(version);
		return consumerOrderPaymentGroup;

	}

	protected void checkParamsForRemovingConsumerOrderPaymentGroupList(YoubenbenUserContext userContext, String consumerOrderId,
			String consumerOrderPaymentGroupIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		for(String consumerOrderPaymentGroupIdItem: consumerOrderPaymentGroupIds){
			checkerOf(userContext).checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder removeConsumerOrderPaymentGroupList(YoubenbenUserContext userContext, String consumerOrderId,
			String consumerOrderPaymentGroupIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderPaymentGroupList(userContext, consumerOrderId,  consumerOrderPaymentGroupIds, tokensExpr);


			ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
			synchronized(consumerOrder){
				//Will be good when the consumerOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				consumerOrderDaoOf(userContext).planToRemoveConsumerOrderPaymentGroupList(consumerOrder, consumerOrderPaymentGroupIds, allTokens());
				consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
				deleteRelationListInGraph(userContext, consumerOrder.getConsumerOrderPaymentGroupList());
				return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfConsumerOrder( consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupId);
		checkerOf(userContext).checkVersionOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder removeConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrderPaymentGroup(userContext,consumerOrderId, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion,tokensExpr);

		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = createIndexedConsumerOrderPaymentGroup(consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.removeConsumerOrderPaymentGroup( consumerOrderPaymentGroup );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
			deleteRelationInGraph(userContext, consumerOrderPaymentGroup);
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfConsumerOrder( consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupId);
		checkerOf(userContext).checkVersionOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder copyConsumerOrderPaymentGroupFrom(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrderPaymentGroup(userContext,consumerOrderId, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion,tokensExpr);

		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = createIndexedConsumerOrderPaymentGroup(consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			consumerOrder.copyConsumerOrderPaymentGroupFrom( consumerOrderPaymentGroup );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
			
			userContext.getManagerGroup().getConsumerOrderPaymentGroupManager().onNewInstanceCreated(userContext, (ConsumerOrderPaymentGroup)consumerOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupId);
		checkerOf(userContext).checkVersionOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupVersion);
		

		if(ConsumerOrderPaymentGroup.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfConsumerOrderPaymentGroup(parseString(newValueExpr));
		
		}
		
		if(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCardNumberOfConsumerOrderPaymentGroup(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}

	public  ConsumerOrder updateConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrderPaymentGroup(userContext, consumerOrderId, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderPaymentGroupList().searchConsumerOrderPaymentGroupListWith(ConsumerOrderPaymentGroup.ID_PROPERTY, "eq", consumerOrderPaymentGroupId).done();



		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, loadTokens);

		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//consumerOrder.removeConsumerOrderPaymentGroup( consumerOrderPaymentGroup );
			//make changes to AcceleraterAccount.
			ConsumerOrderPaymentGroup consumerOrderPaymentGroupIndex = createIndexedConsumerOrderPaymentGroup(consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);

			ConsumerOrderPaymentGroup consumerOrderPaymentGroup = consumerOrder.findTheConsumerOrderPaymentGroup(consumerOrderPaymentGroupIndex);
			if(consumerOrderPaymentGroup == null){
				throw new ConsumerOrderManagerException(consumerOrderPaymentGroup+" is NOT FOUND" );
			}

			consumerOrderPaymentGroup.changeProperty(property, newValueExpr);
			
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String consumerOrderId, String name, BigDecimal amount, String provider,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

		
		checkerOf(userContext).checkNameOfConsumerOrderPriceAdjustment(name);
		
		checkerOf(userContext).checkAmountOfConsumerOrderPriceAdjustment(amount);
		
		checkerOf(userContext).checkProviderOfConsumerOrderPriceAdjustment(provider);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);


	}
	public  ConsumerOrder addConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String consumerOrderId, String name, BigDecimal amount, String provider, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingConsumerOrderPriceAdjustment(userContext,consumerOrderId,name, amount, provider,tokensExpr);

		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = createConsumerOrderPriceAdjustment(userContext,name, amount, provider);

		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, emptyOptions());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.addConsumerOrderPriceAdjustment( consumerOrderPriceAdjustment );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
			
			userContext.getManagerGroup().getConsumerOrderPriceAdjustmentManager().onNewInstanceCreated(userContext, consumerOrderPriceAdjustment);
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderPriceAdjustmentProperties(YoubenbenUserContext userContext, String consumerOrderId,String id,String name,BigDecimal amount,String provider,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(id);

		checkerOf(userContext).checkNameOfConsumerOrderPriceAdjustment( name);
		checkerOf(userContext).checkAmountOfConsumerOrderPriceAdjustment( amount);
		checkerOf(userContext).checkProviderOfConsumerOrderPriceAdjustment( provider);

		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder updateConsumerOrderPriceAdjustmentProperties(YoubenbenUserContext userContext, String consumerOrderId, String id,String name,BigDecimal amount,String provider, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderPriceAdjustmentProperties(userContext,consumerOrderId,id,name,amount,provider,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderPriceAdjustmentListList()
				.searchConsumerOrderPriceAdjustmentListWith(ConsumerOrderPriceAdjustment.ID_PROPERTY, "is", id).done();

		ConsumerOrder consumerOrderToUpdate = loadConsumerOrder(userContext, consumerOrderId, options);

		if(consumerOrderToUpdate.getConsumerOrderPriceAdjustmentList().isEmpty()){
			throw new ConsumerOrderManagerException("ConsumerOrderPriceAdjustment is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrderPriceAdjustment item = consumerOrderToUpdate.getConsumerOrderPriceAdjustmentList().first();

		item.updateName( name );
		item.updateAmount( amount );
		item.updateProvider( provider );


		//checkParamsForAddingConsumerOrderPriceAdjustment(userContext,consumerOrderId,name, code, used,tokensExpr);
		ConsumerOrder consumerOrder = saveConsumerOrder(userContext, consumerOrderToUpdate, tokens().withConsumerOrderPriceAdjustmentList().done());
		synchronized(consumerOrder){
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}


	protected ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String name, BigDecimal amount, String provider) throws Exception{

		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = new ConsumerOrderPriceAdjustment();
		
		
		consumerOrderPriceAdjustment.setName(name);		
		consumerOrderPriceAdjustment.setAmount(amount);		
		consumerOrderPriceAdjustment.setProvider(provider);
	
		
		return consumerOrderPriceAdjustment;


	}

	protected ConsumerOrderPriceAdjustment createIndexedConsumerOrderPriceAdjustment(String id, int version){

		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = new ConsumerOrderPriceAdjustment();
		consumerOrderPriceAdjustment.setId(id);
		consumerOrderPriceAdjustment.setVersion(version);
		return consumerOrderPriceAdjustment;

	}

	protected void checkParamsForRemovingConsumerOrderPriceAdjustmentList(YoubenbenUserContext userContext, String consumerOrderId,
			String consumerOrderPriceAdjustmentIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		for(String consumerOrderPriceAdjustmentIdItem: consumerOrderPriceAdjustmentIds){
			checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder removeConsumerOrderPriceAdjustmentList(YoubenbenUserContext userContext, String consumerOrderId,
			String consumerOrderPriceAdjustmentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderPriceAdjustmentList(userContext, consumerOrderId,  consumerOrderPriceAdjustmentIds, tokensExpr);


			ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
			synchronized(consumerOrder){
				//Will be good when the consumerOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				consumerOrderDaoOf(userContext).planToRemoveConsumerOrderPriceAdjustmentList(consumerOrder, consumerOrderPriceAdjustmentIds, allTokens());
				consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
				deleteRelationListInGraph(userContext, consumerOrder.getConsumerOrderPriceAdjustmentList());
				return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfConsumerOrder( consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		checkerOf(userContext).checkVersionOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder removeConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrderPriceAdjustment(userContext,consumerOrderId, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion,tokensExpr);

		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = createIndexedConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.removeConsumerOrderPriceAdjustment( consumerOrderPriceAdjustment );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
			deleteRelationInGraph(userContext, consumerOrderPriceAdjustment);
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfConsumerOrder( consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		checkerOf(userContext).checkVersionOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder copyConsumerOrderPriceAdjustmentFrom(YoubenbenUserContext userContext, String consumerOrderId,
		String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrderPriceAdjustment(userContext,consumerOrderId, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion,tokensExpr);

		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = createIndexedConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			consumerOrder.copyConsumerOrderPriceAdjustmentFrom( consumerOrderPriceAdjustment );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
			
			userContext.getManagerGroup().getConsumerOrderPriceAdjustmentManager().onNewInstanceCreated(userContext, (ConsumerOrderPriceAdjustment)consumerOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		checkerOf(userContext).checkVersionOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentVersion);
		

		if(ConsumerOrderPriceAdjustment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfConsumerOrderPriceAdjustment(parseString(newValueExpr));
		
		}
		
		if(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfConsumerOrderPriceAdjustment(parseBigDecimal(newValueExpr));
		
		}
		
		if(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkProviderOfConsumerOrderPriceAdjustment(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}

	public  ConsumerOrder updateConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String consumerOrderId, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderId, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderPriceAdjustmentList().searchConsumerOrderPriceAdjustmentListWith(ConsumerOrderPriceAdjustment.ID_PROPERTY, "eq", consumerOrderPriceAdjustmentId).done();



		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, loadTokens);

		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//consumerOrder.removeConsumerOrderPriceAdjustment( consumerOrderPriceAdjustment );
			//make changes to AcceleraterAccount.
			ConsumerOrderPriceAdjustment consumerOrderPriceAdjustmentIndex = createIndexedConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);

			ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = consumerOrder.findTheConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentIndex);
			if(consumerOrderPriceAdjustment == null){
				throw new ConsumerOrderManagerException(consumerOrderPriceAdjustment+" is NOT FOUND" );
			}

			consumerOrderPriceAdjustment.changeProperty(property, newValueExpr);
			
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String consumerOrderId, Date occureTime, String ownerId, String number, BigDecimal amount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

		
		checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(occureTime);
		
		checkerOf(userContext).checkOwnerIdOfRetailStoreMemberGiftCardConsumeRecord(ownerId);
		
		checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord(number);
		
		checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);


	}
	public  ConsumerOrder addRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String consumerOrderId, Date occureTime, String ownerId, String number, BigDecimal amount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(userContext,consumerOrderId,occureTime, ownerId, number, amount,tokensExpr);

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createRetailStoreMemberGiftCardConsumeRecord(userContext,occureTime, ownerId, number, amount);

		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, emptyOptions());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.addRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberGiftCardConsumeRecordManager().onNewInstanceCreated(userContext, retailStoreMemberGiftCardConsumeRecord);
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecordProperties(YoubenbenUserContext userContext, String consumerOrderId,String id,Date occureTime,String number,BigDecimal amount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(id);

		checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord( occureTime);
		checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord( number);
		checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord( amount);

		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder updateRetailStoreMemberGiftCardConsumeRecordProperties(YoubenbenUserContext userContext, String consumerOrderId, String id,Date occureTime,String number,BigDecimal amount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecordProperties(userContext,consumerOrderId,id,occureTime,number,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberGiftCardConsumeRecordListList()
				.searchRetailStoreMemberGiftCardConsumeRecordListWith(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY, "is", id).done();

		ConsumerOrder consumerOrderToUpdate = loadConsumerOrder(userContext, consumerOrderId, options);

		if(consumerOrderToUpdate.getRetailStoreMemberGiftCardConsumeRecordList().isEmpty()){
			throw new ConsumerOrderManagerException("RetailStoreMemberGiftCardConsumeRecord is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreMemberGiftCardConsumeRecord item = consumerOrderToUpdate.getRetailStoreMemberGiftCardConsumeRecordList().first();

		item.updateOccureTime( occureTime );
		item.updateNumber( number );
		item.updateAmount( amount );


		//checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(userContext,consumerOrderId,name, code, used,tokensExpr);
		ConsumerOrder consumerOrder = saveConsumerOrder(userContext, consumerOrderToUpdate, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
		synchronized(consumerOrder){
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, Date occureTime, String ownerId, String number, BigDecimal amount) throws Exception{

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		
		
		retailStoreMemberGiftCardConsumeRecord.setOccureTime(occureTime);		
		RetailStoreMemberGiftCard  owner = new RetailStoreMemberGiftCard();
		owner.setId(ownerId);		
		retailStoreMemberGiftCardConsumeRecord.setOwner(owner);		
		retailStoreMemberGiftCardConsumeRecord.setNumber(number);		
		retailStoreMemberGiftCardConsumeRecord.setAmount(amount);
	
		
		return retailStoreMemberGiftCardConsumeRecord;


	}

	protected RetailStoreMemberGiftCardConsumeRecord createIndexedRetailStoreMemberGiftCardConsumeRecord(String id, int version){

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		retailStoreMemberGiftCardConsumeRecord.setId(id);
		retailStoreMemberGiftCardConsumeRecord.setVersion(version);
		return retailStoreMemberGiftCardConsumeRecord;

	}

	protected void checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecordList(YoubenbenUserContext userContext, String consumerOrderId,
			String retailStoreMemberGiftCardConsumeRecordIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		for(String retailStoreMemberGiftCardConsumeRecordIdItem: retailStoreMemberGiftCardConsumeRecordIds){
			checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder removeRetailStoreMemberGiftCardConsumeRecordList(YoubenbenUserContext userContext, String consumerOrderId,
			String retailStoreMemberGiftCardConsumeRecordIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecordList(userContext, consumerOrderId,  retailStoreMemberGiftCardConsumeRecordIds, tokensExpr);


			ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
			synchronized(consumerOrder){
				//Will be good when the consumerOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				consumerOrderDaoOf(userContext).planToRemoveRetailStoreMemberGiftCardConsumeRecordList(consumerOrder, retailStoreMemberGiftCardConsumeRecordIds, allTokens());
				consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
				deleteRelationListInGraph(userContext, consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList());
				return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String consumerOrderId,
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfConsumerOrder( consumerOrderId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder removeRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String consumerOrderId,
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(userContext,consumerOrderId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion,tokensExpr);

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			consumerOrder.removeRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			deleteRelationInGraph(userContext, retailStoreMemberGiftCardConsumeRecord);
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String consumerOrderId,
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfConsumerOrder( consumerOrderId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}
	public  ConsumerOrder copyRetailStoreMemberGiftCardConsumeRecordFrom(YoubenbenUserContext userContext, String consumerOrderId,
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(userContext,consumerOrderId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion,tokensExpr);

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			consumerOrder.copyRetailStoreMemberGiftCardConsumeRecordFrom( retailStoreMemberGiftCardConsumeRecord );
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberGiftCardConsumeRecordManager().onNewInstanceCreated(userContext, (RetailStoreMemberGiftCardConsumeRecord)consumerOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String consumerOrderId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordVersion);
		

		if(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(parseDate(newValueExpr));
		
		}
		
		if(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord(parseString(newValueExpr));
		
		}
		
		if(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

	}

	public  ConsumerOrder updateRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String consumerOrderId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(userContext, consumerOrderId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberGiftCardConsumeRecordList().searchRetailStoreMemberGiftCardConsumeRecordListWith(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY, "eq", retailStoreMemberGiftCardConsumeRecordId).done();



		ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, loadTokens);

		synchronized(consumerOrder){
			//Will be good when the consumerOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//consumerOrder.removeRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );
			//make changes to AcceleraterAccount.
			RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordIndex = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);

			RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = consumerOrder.findTheRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordIndex);
			if(retailStoreMemberGiftCardConsumeRecord == null){
				throw new ConsumerOrderManagerException(retailStoreMemberGiftCardConsumeRecord+" is NOT FOUND" );
			}

			retailStoreMemberGiftCardConsumeRecord.changeProperty(property, newValueExpr);
			
			consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			return present(userContext,consumerOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrder newCreated) throws Exception{
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
		//   ConsumerOrder newConsumerOrder = this.createConsumerOrder(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newConsumerOrder
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ConsumerOrder.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<ConsumerOrder> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreMember> consumerList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreMember.class);
		userContext.getDAOGroup().enhanceList(consumerList, RetailStoreMember.class);
		List<SupplyOrderConfirmation> confirmationList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrderConfirmation.class);
		userContext.getDAOGroup().enhanceList(confirmationList, SupplyOrderConfirmation.class);
		List<SupplyOrderApproval> approvalList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrderApproval.class);
		userContext.getDAOGroup().enhanceList(approvalList, SupplyOrderApproval.class);
		List<SupplyOrderProcessing> processingList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrderProcessing.class);
		userContext.getDAOGroup().enhanceList(processingList, SupplyOrderProcessing.class);
		List<SupplyOrderShipment> shipmentList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrderShipment.class);
		userContext.getDAOGroup().enhanceList(shipmentList, SupplyOrderShipment.class);
		List<SupplyOrderDelivery> deliveryList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrderDelivery.class);
		userContext.getDAOGroup().enhanceList(deliveryList, SupplyOrderDelivery.class);
		List<RetailStore> storeList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStore.class);
		userContext.getDAOGroup().enhanceList(storeList, RetailStore.class);


    }
	
	public Object listByConsumer(YoubenbenUserContext userContext,String consumerId) throws Exception {
		return listPageByConsumer(userContext, consumerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByConsumer(YoubenbenUserContext userContext,String consumerId, int start, int count) throws Exception {
		SmartList<ConsumerOrder> list = consumerOrderDaoOf(userContext).findConsumerOrderByConsumer(consumerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(ConsumerOrder.class);
		page.setContainerObject(RetailStoreMember.withId(consumerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费者订单列表");
		page.setRequestName("listByConsumer");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByConsumer/%s/",  getBeanName(), consumerId)));

		page.assemblerContent(userContext, "listByConsumer");
		return page.doRender(userContext);
	}
  
	public Object listByConfirmation(YoubenbenUserContext userContext,String confirmationId) throws Exception {
		return listPageByConfirmation(userContext, confirmationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByConfirmation(YoubenbenUserContext userContext,String confirmationId, int start, int count) throws Exception {
		SmartList<ConsumerOrder> list = consumerOrderDaoOf(userContext).findConsumerOrderByConfirmation(confirmationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(ConsumerOrder.class);
		page.setContainerObject(SupplyOrderConfirmation.withId(confirmationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费者订单列表");
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
		SmartList<ConsumerOrder> list = consumerOrderDaoOf(userContext).findConsumerOrderByApproval(approvalId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(ConsumerOrder.class);
		page.setContainerObject(SupplyOrderApproval.withId(approvalId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费者订单列表");
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
		SmartList<ConsumerOrder> list = consumerOrderDaoOf(userContext).findConsumerOrderByProcessing(processingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(ConsumerOrder.class);
		page.setContainerObject(SupplyOrderProcessing.withId(processingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费者订单列表");
		page.setRequestName("listByProcessing");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByProcessing/%s/",  getBeanName(), processingId)));

		page.assemblerContent(userContext, "listByProcessing");
		return page.doRender(userContext);
	}
  
	public Object listByShipment(YoubenbenUserContext userContext,String shipmentId) throws Exception {
		return listPageByShipment(userContext, shipmentId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByShipment(YoubenbenUserContext userContext,String shipmentId, int start, int count) throws Exception {
		SmartList<ConsumerOrder> list = consumerOrderDaoOf(userContext).findConsumerOrderByShipment(shipmentId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(ConsumerOrder.class);
		page.setContainerObject(SupplyOrderShipment.withId(shipmentId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费者订单列表");
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
		SmartList<ConsumerOrder> list = consumerOrderDaoOf(userContext).findConsumerOrderByDelivery(deliveryId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(ConsumerOrder.class);
		page.setContainerObject(SupplyOrderDelivery.withId(deliveryId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费者订单列表");
		page.setRequestName("listByDelivery");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDelivery/%s/",  getBeanName(), deliveryId)));

		page.assemblerContent(userContext, "listByDelivery");
		return page.doRender(userContext);
	}
  
	public Object listByStore(YoubenbenUserContext userContext,String storeId) throws Exception {
		return listPageByStore(userContext, storeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByStore(YoubenbenUserContext userContext,String storeId, int start, int count) throws Exception {
		SmartList<ConsumerOrder> list = consumerOrderDaoOf(userContext).findConsumerOrderByStore(storeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(ConsumerOrder.class);
		page.setContainerObject(RetailStore.withId(storeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费者订单列表");
		page.setRequestName("listByStore");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByStore/%s/",  getBeanName(), storeId)));

		page.assemblerContent(userContext, "listByStore");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String consumerOrderId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getConsumerOrderDetailScope().clone();
		ConsumerOrder merchantObj = (ConsumerOrder) this.view(userContext, consumerOrderId);
    String merchantObjId = consumerOrderId;
    String linkToUrl =	"consumerOrderManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "消费者订单"+"详情";
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
				MapUtil.put("id", "2-title")
				    .put("fieldName", "title")
				    .put("label", "标题")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("title", merchantObj.getTitle());

		propList.add(
				MapUtil.put("id", "3-consumer")
				    .put("fieldName", "consumer")
				    .put("label", "消费者")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreMemberManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"mobile_phone\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("consumer", merchantObj.getConsumer());

		propList.add(
				MapUtil.put("id", "4-confirmation")
				    .put("fieldName", "confirmation")
				    .put("label", "确认")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderConfirmationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"confirm_time\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("confirmation", merchantObj.getConfirmation());

		propList.add(
				MapUtil.put("id", "5-approval")
				    .put("fieldName", "approval")
				    .put("label", "审批公证员")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderApprovalManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"approve_time\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("approval", merchantObj.getApproval());

		propList.add(
				MapUtil.put("id", "6-processing")
				    .put("fieldName", "processing")
				    .put("label", "处理")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderProcessingManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"process_time\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("processing", merchantObj.getProcessing());

		propList.add(
				MapUtil.put("id", "7-shipment")
				    .put("fieldName", "shipment")
				    .put("label", "装运")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderShipmentManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"ship_time\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("shipment", merchantObj.getShipment());

		propList.add(
				MapUtil.put("id", "8-delivery")
				    .put("fieldName", "delivery")
				    .put("label", "送货")
				    .put("type", "auto")
				    .put("linkToUrl", "supplyOrderDeliveryManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"delivery_time\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"who\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("delivery", merchantObj.getDelivery());

		propList.add(
				MapUtil.put("id", "9-store")
				    .put("fieldName", "store")
				    .put("label", "门店")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("store", merchantObj.getStore());

		propList.add(
				MapUtil.put("id", "10-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "最后更新时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：consumerOrderLineItemListSection
		Map consumerOrderLineItemListSection = ListofUtils.buildSection(
		    "consumerOrderLineItemListSection",
		    "消费者订单行项目列表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderLineItemManager/listByBizOrder/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(consumerOrderLineItemListSection);

		result.put("consumerOrderLineItemListSection", ListofUtils.toShortList(merchantObj.getConsumerOrderLineItemList(), "consumerOrderLineItem"));
		vscope.field("consumerOrderLineItemListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( ConsumerOrderLineItem.class.getName(), null));

		//处理Section：consumerOrderShippingGroupListSection
		Map consumerOrderShippingGroupListSection = ListofUtils.buildSection(
		    "consumerOrderShippingGroupListSection",
		    "消费者订单发货组列表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderShippingGroupManager/listByBizOrder/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(consumerOrderShippingGroupListSection);

		result.put("consumerOrderShippingGroupListSection", ListofUtils.toShortList(merchantObj.getConsumerOrderShippingGroupList(), "consumerOrderShippingGroup"));
		vscope.field("consumerOrderShippingGroupListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( ConsumerOrderShippingGroup.class.getName(), null));

		//处理Section：consumerOrderPaymentGroupListSection
		Map consumerOrderPaymentGroupListSection = ListofUtils.buildSection(
		    "consumerOrderPaymentGroupListSection",
		    "消费者订单支付组列表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderPaymentGroupManager/listByBizOrder/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(consumerOrderPaymentGroupListSection);

		result.put("consumerOrderPaymentGroupListSection", ListofUtils.toShortList(merchantObj.getConsumerOrderPaymentGroupList(), "consumerOrderPaymentGroup"));
		vscope.field("consumerOrderPaymentGroupListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( ConsumerOrderPaymentGroup.class.getName(), null));

		//处理Section：consumerOrderPriceAdjustmentListSection
		Map consumerOrderPriceAdjustmentListSection = ListofUtils.buildSection(
		    "consumerOrderPriceAdjustmentListSection",
		    "消费者订单价格调整表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderPriceAdjustmentManager/listByBizOrder/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(consumerOrderPriceAdjustmentListSection);

		result.put("consumerOrderPriceAdjustmentListSection", ListofUtils.toShortList(merchantObj.getConsumerOrderPriceAdjustmentList(), "consumerOrderPriceAdjustment"));
		vscope.field("consumerOrderPriceAdjustmentListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( ConsumerOrderPriceAdjustment.class.getName(), null));

		//处理Section：retailStoreMemberGiftCardConsumeRecordListSection
		Map retailStoreMemberGiftCardConsumeRecordListSection = ListofUtils.buildSection(
		    "retailStoreMemberGiftCardConsumeRecordListSection",
		    "零售会员礼品卡消费记录列表",
		    null,
		    "",
		    "__no_group",
		    "retailStoreMemberGiftCardConsumeRecordManager/listByBizOrder/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreMemberGiftCardConsumeRecordListSection);

		result.put("retailStoreMemberGiftCardConsumeRecordListSection", ListofUtils.toShortList(merchantObj.getRetailStoreMemberGiftCardConsumeRecordList(), "retailStoreMemberGiftCardConsumeRecord"));
		vscope.field("retailStoreMemberGiftCardConsumeRecordListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( RetailStoreMemberGiftCardConsumeRecord.class.getName(), null));

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


