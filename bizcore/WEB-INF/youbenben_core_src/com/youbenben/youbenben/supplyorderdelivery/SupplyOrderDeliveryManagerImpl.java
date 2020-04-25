
package com.youbenben.youbenben.supplyorderdelivery;

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


import com.youbenben.youbenben.supplyorder.SupplyOrder;
import com.youbenben.youbenben.consumerorder.ConsumerOrder;


import com.youbenben.youbenben.goodssupplier.GoodsSupplier;
import com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDelivery;
import com.youbenben.youbenben.supplyorderapproval.SupplyOrderApproval;
import com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmation;
import com.youbenben.youbenben.supplyorderpicking.SupplyOrderPicking;
import com.youbenben.youbenben.supplyordershipment.SupplyOrderShipment;
import com.youbenben.youbenben.retailstore.RetailStore;
import com.youbenben.youbenben.retailstoremember.RetailStoreMember;
import com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessing;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;






public class SupplyOrderDeliveryManagerImpl extends CustomYoubenbenCheckerManager implements SupplyOrderDeliveryManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = SupplyOrderDeliveryTokens.start().withTokenFromListName(listName).done();
		SupplyOrderDelivery  supplyOrderDelivery = (SupplyOrderDelivery) this.loadSupplyOrderDelivery(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = supplyOrderDelivery.collectRefercencesFromLists();
		supplyOrderDeliveryDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, supplyOrderDelivery, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new SupplyOrderDeliveryGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "SupplyOrderDelivery";
	@Override
	public SupplyOrderDeliveryDAO daoOf(YoubenbenUserContext userContext) {
		return supplyOrderDeliveryDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws SupplyOrderDeliveryManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderDeliveryManagerException(message);

	}



 	protected SupplyOrderDelivery saveSupplyOrderDelivery(YoubenbenUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderDeliveryDAO().save(supplyOrderDelivery, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens);
 	}
 	
 	protected SupplyOrderDelivery saveSupplyOrderDeliveryDetail(YoubenbenUserContext userContext, SupplyOrderDelivery supplyOrderDelivery) throws Exception{	

 		
 		return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, allTokens());
 	}
 	
 	public SupplyOrderDelivery loadSupplyOrderDelivery(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderDeliveryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery( userContext, supplyOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderDelivery, tokens);
 	}
 	
 	
 	 public SupplyOrderDelivery searchSupplyOrderDelivery(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderDeliveryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery( userContext, supplyOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderDelivery, tokens);
 	}
 	
 	

 	protected SupplyOrderDelivery present(YoubenbenUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderDelivery,tokens);
		
		
		SupplyOrderDelivery  supplyOrderDeliveryToPresent = supplyOrderDeliveryDaoOf(userContext).present(supplyOrderDelivery, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderDeliveryToPresent.collectRefercencesFromLists();
		supplyOrderDeliveryDaoOf(userContext).alias(entityListToNaming);
		
		return  supplyOrderDeliveryToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderDelivery loadSupplyOrderDeliveryDetail(YoubenbenUserContext userContext, String supplyOrderDeliveryId) throws Exception{	
 		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery( userContext, supplyOrderDeliveryId, allTokens());
 		return present(userContext,supplyOrderDelivery, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String supplyOrderDeliveryId) throws Exception{	
 		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery( userContext, supplyOrderDeliveryId, viewTokens());
 		return present(userContext,supplyOrderDelivery, allTokens());
		
 	}
 	protected SupplyOrderDelivery saveSupplyOrderDelivery(YoubenbenUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String,Object>tokens) throws Exception{	
 		return supplyOrderDeliveryDaoOf(userContext).save(supplyOrderDelivery, tokens);
 	}
 	protected SupplyOrderDelivery loadSupplyOrderDelivery(YoubenbenUserContext userContext, String supplyOrderDeliveryId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderDeliveryManagerException.class);

 
 		return supplyOrderDeliveryDaoOf(userContext).load(supplyOrderDeliveryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderDelivery, tokens);
		
		addAction(userContext, supplyOrderDelivery, tokens,"@create","createSupplyOrderDelivery","createSupplyOrderDelivery/","main","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"@update","updateSupplyOrderDelivery","updateSupplyOrderDelivery/"+supplyOrderDelivery.getId()+"/","main","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"@copy","cloneSupplyOrderDelivery","cloneSupplyOrderDelivery/"+supplyOrderDelivery.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SupplyOrderDelivery createSupplyOrderDelivery(YoubenbenUserContext userContext, String who,Date deliveryTime) throws Exception
	//public SupplyOrderDelivery createSupplyOrderDelivery(YoubenbenUserContext userContext,String who, Date deliveryTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfSupplyOrderDelivery(who);
		checkerOf(userContext).checkDeliveryTimeOfSupplyOrderDelivery(deliveryTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);


		SupplyOrderDelivery supplyOrderDelivery=createNewSupplyOrderDelivery();	

		supplyOrderDelivery.setWho(who);
		supplyOrderDelivery.setDeliveryTime(deliveryTime);

		supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderDelivery);
		return supplyOrderDelivery;


	}
	protected SupplyOrderDelivery createNewSupplyOrderDelivery()
	{

		return new SupplyOrderDelivery();
	}

	protected void checkParamsForUpdatingSupplyOrderDelivery(YoubenbenUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		checkerOf(userContext).checkVersionOfSupplyOrderDelivery( supplyOrderDeliveryVersion);
		

		if(SupplyOrderDelivery.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfSupplyOrderDelivery(parseString(newValueExpr));
		
			
		}
		if(SupplyOrderDelivery.DELIVERY_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDeliveryTimeOfSupplyOrderDelivery(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);


	}



	public SupplyOrderDelivery clone(YoubenbenUserContext userContext, String fromSupplyOrderDeliveryId) throws Exception{

		return supplyOrderDeliveryDaoOf(userContext).clone(fromSupplyOrderDeliveryId, this.allTokens());
	}

	public SupplyOrderDelivery internalSaveSupplyOrderDelivery(YoubenbenUserContext userContext, SupplyOrderDelivery supplyOrderDelivery) throws Exception
	{
		return internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery, allTokens());

	}
	public SupplyOrderDelivery internalSaveSupplyOrderDelivery(YoubenbenUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSupplyOrderDelivery(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion, property, newValueExpr, tokensExpr);


		synchronized(supplyOrderDelivery){
			//will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderDelivery.
			if (supplyOrderDelivery.isChanged()){
			
			}
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, options);
			return supplyOrderDelivery;

		}

	}

	public SupplyOrderDelivery updateSupplyOrderDelivery(YoubenbenUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderDelivery(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion, property, newValueExpr, tokensExpr);



		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		if(supplyOrderDelivery.getVersion() != supplyOrderDeliveryVersion){
			String message = "The target version("+supplyOrderDelivery.getVersion()+") is not equals to version("+supplyOrderDeliveryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderDelivery){
			//will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderDelivery.
			
			supplyOrderDelivery.changeProperty(property, newValueExpr);
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().done());
		}

	}

	public SupplyOrderDelivery updateSupplyOrderDeliveryProperty(YoubenbenUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderDelivery(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion, property, newValueExpr, tokensExpr);

		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		if(supplyOrderDelivery.getVersion() != supplyOrderDeliveryVersion){
			String message = "The target version("+supplyOrderDelivery.getVersion()+") is not equals to version("+supplyOrderDeliveryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderDelivery){
			//will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderDelivery.

			supplyOrderDelivery.changeProperty(property, newValueExpr);
			
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SupplyOrderDeliveryTokens tokens(){
		return SupplyOrderDeliveryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderDeliveryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderDeliveryTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String supplyOrderDeliveryId, int supplyOrderDeliveryVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String supplyOrderDeliveryId, int supplyOrderDeliveryVersion) throws Exception{

		supplyOrderDeliveryDaoOf(userContext).delete(supplyOrderDeliveryId, supplyOrderDeliveryVersion);
	}

	public SupplyOrderDelivery forgetByAll(YoubenbenUserContext userContext, String supplyOrderDeliveryId, int supplyOrderDeliveryVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion);
	}
	protected SupplyOrderDelivery forgetByAllInternal(YoubenbenUserContext userContext,
			String supplyOrderDeliveryId, int supplyOrderDeliveryVersion) throws Exception{

		return supplyOrderDeliveryDaoOf(userContext).disconnectFromAll(supplyOrderDeliveryId, supplyOrderDeliveryVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderDeliveryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return supplyOrderDeliveryDaoOf(userContext).deleteAll();
	}


	//disconnect SupplyOrderDelivery with consumer in ConsumerOrder
	protected SupplyOrderDelivery breakWithConsumerOrderByConsumer(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String consumerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveConsumerOrderListWithConsumer(supplyOrderDelivery, consumerId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with confirmation in ConsumerOrder
	protected SupplyOrderDelivery breakWithConsumerOrderByConfirmation(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveConsumerOrderListWithConfirmation(supplyOrderDelivery, confirmationId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with approval in ConsumerOrder
	protected SupplyOrderDelivery breakWithConsumerOrderByApproval(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveConsumerOrderListWithApproval(supplyOrderDelivery, approvalId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with processing in ConsumerOrder
	protected SupplyOrderDelivery breakWithConsumerOrderByProcessing(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveConsumerOrderListWithProcessing(supplyOrderDelivery, processingId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with shipment in ConsumerOrder
	protected SupplyOrderDelivery breakWithConsumerOrderByShipment(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveConsumerOrderListWithShipment(supplyOrderDelivery, shipmentId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with store in ConsumerOrder
	protected SupplyOrderDelivery breakWithConsumerOrderByStore(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String storeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveConsumerOrderListWithStore(supplyOrderDelivery, storeId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with buyer in SupplyOrder
	protected SupplyOrderDelivery breakWithSupplyOrderByBuyer(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String buyerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveSupplyOrderListWithBuyer(supplyOrderDelivery, buyerId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with seller in SupplyOrder
	protected SupplyOrderDelivery breakWithSupplyOrderBySeller(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String sellerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveSupplyOrderListWithSeller(supplyOrderDelivery, sellerId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with confirmation in SupplyOrder
	protected SupplyOrderDelivery breakWithSupplyOrderByConfirmation(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveSupplyOrderListWithConfirmation(supplyOrderDelivery, confirmationId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with approval in SupplyOrder
	protected SupplyOrderDelivery breakWithSupplyOrderByApproval(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveSupplyOrderListWithApproval(supplyOrderDelivery, approvalId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with processing in SupplyOrder
	protected SupplyOrderDelivery breakWithSupplyOrderByProcessing(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveSupplyOrderListWithProcessing(supplyOrderDelivery, processingId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with picking in SupplyOrder
	protected SupplyOrderDelivery breakWithSupplyOrderByPicking(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String pickingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveSupplyOrderListWithPicking(supplyOrderDelivery, pickingId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with shipment in SupplyOrder
	protected SupplyOrderDelivery breakWithSupplyOrderByShipment(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderDeliveryDaoOf(userContext).planToRemoveSupplyOrderListWithShipment(supplyOrderDelivery, shipmentId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
				return supplyOrderDelivery;
			}
	}






	protected void checkParamsForAddingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String storeId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);

		
		checkerOf(userContext).checkTitleOfConsumerOrder(title);
		
		checkerOf(userContext).checkConsumerIdOfConsumerOrder(consumerId);
		
		checkerOf(userContext).checkConfirmationIdOfConsumerOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfConsumerOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfConsumerOrder(processingId);
		
		checkerOf(userContext).checkShipmentIdOfConsumerOrder(shipmentId);
		
		checkerOf(userContext).checkStoreIdOfConsumerOrder(storeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);


	}
	public  SupplyOrderDelivery addConsumerOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String storeId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingConsumerOrder(userContext,supplyOrderDeliveryId,title, consumerId, confirmationId, approvalId, processingId, shipmentId, storeId,tokensExpr);

		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, confirmationId, approvalId, processingId, shipmentId, storeId);

		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, emptyOptions());
		synchronized(supplyOrderDelivery){
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.addConsumerOrder( consumerOrder );
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(YoubenbenUserContext userContext, String supplyOrderDeliveryId,String id,String title,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		checkerOf(userContext).checkIdOfConsumerOrder(id);

		checkerOf(userContext).checkTitleOfConsumerOrder( title);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	}
	public  SupplyOrderDelivery updateConsumerOrderProperties(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String id,String title, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderDeliveryId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();

		SupplyOrderDelivery supplyOrderDeliveryToUpdate = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);

		if(supplyOrderDeliveryToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderDeliveryManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrder item = supplyOrderDeliveryToUpdate.getConsumerOrderList().first();

		item.updateTitle( title );


		//checkParamsForAddingConsumerOrder(userContext,supplyOrderDeliveryId,name, code, used,tokensExpr);
		SupplyOrderDelivery supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDeliveryToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderDelivery){
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
	}


	protected ConsumerOrder createConsumerOrder(YoubenbenUserContext userContext, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStoreMember  consumer = new RetailStoreMember();
		consumer.setId(consumerId);		
		consumerOrder.setConsumer(consumer);		
		SupplyOrderConfirmation  confirmation = new SupplyOrderConfirmation();
		confirmation.setId(confirmationId);		
		consumerOrder.setConfirmation(confirmation);		
		SupplyOrderApproval  approval = new SupplyOrderApproval();
		approval.setId(approvalId);		
		consumerOrder.setApproval(approval);		
		SupplyOrderProcessing  processing = new SupplyOrderProcessing();
		processing.setId(processingId);		
		consumerOrder.setProcessing(processing);		
		SupplyOrderShipment  shipment = new SupplyOrderShipment();
		shipment.setId(shipmentId);		
		consumerOrder.setShipment(shipment);		
		RetailStore  store = new RetailStore();
		store.setId(storeId);		
		consumerOrder.setStore(store);		
		consumerOrder.setLastUpdateTime(userContext.now());
	
		
		return consumerOrder;


	}

	protected ConsumerOrder createIndexedConsumerOrder(String id, int version){

		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(version);
		return consumerOrder;

	}

	protected void checkParamsForRemovingConsumerOrderList(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		for(String consumerOrderIdItem: consumerOrderIds){
			checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	}
	public  SupplyOrderDelivery removeConsumerOrderList(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderDeliveryId,  consumerOrderIds, tokensExpr);


			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
			synchronized(supplyOrderDelivery){
				//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderDeliveryDaoOf(userContext).planToRemoveConsumerOrderList(supplyOrderDelivery, consumerOrderIds, allTokens());
				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderDelivery.getConsumerOrderList());
				return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderDelivery( supplyOrderDeliveryId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	}
	public  SupplyOrderDelivery removeConsumerOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrder(userContext,supplyOrderDeliveryId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.removeConsumerOrder( consumerOrder );
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderDelivery( supplyOrderDeliveryId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	}
	public  SupplyOrderDelivery copyConsumerOrderFrom(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrder(userContext,supplyOrderDeliveryId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			consumerOrder.updateLastUpdateTime(userContext.now());

			supplyOrderDelivery.copyConsumerOrderFrom( consumerOrder );
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderDelivery.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	}

	public  SupplyOrderDelivery updateConsumerOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderDeliveryId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();



		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, loadTokens);

		synchronized(supplyOrderDelivery){
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderDelivery.removeConsumerOrder( consumerOrder );
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);

			ConsumerOrder consumerOrder = supplyOrderDelivery.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderDeliveryManagerException(consumerOrder+" is NOT FOUND" );
			}

			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);

		
		checkerOf(userContext).checkBuyerIdOfSupplyOrder(buyerId);
		
		checkerOf(userContext).checkSellerIdOfSupplyOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfSupplyOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfSupplyOrder(totalAmount);
		
		checkerOf(userContext).checkConfirmationIdOfSupplyOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfSupplyOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfSupplyOrder(processingId);
		
		checkerOf(userContext).checkPickingIdOfSupplyOrder(pickingId);
		
		checkerOf(userContext).checkShipmentIdOfSupplyOrder(shipmentId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);


	}
	public  SupplyOrderDelivery addSupplyOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSupplyOrder(userContext,supplyOrderDeliveryId,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, shipmentId,tokensExpr);

		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, shipmentId);

		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, emptyOptions());
		synchronized(supplyOrderDelivery){
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.addSupplyOrder( supplyOrder );
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(YoubenbenUserContext userContext, String supplyOrderDeliveryId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		checkerOf(userContext).checkIdOfSupplyOrder(id);

		checkerOf(userContext).checkTitleOfSupplyOrder( title);
		checkerOf(userContext).checkTotalAmountOfSupplyOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	}
	public  SupplyOrderDelivery updateSupplyOrderProperties(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderDeliveryId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();

		SupplyOrderDelivery supplyOrderDeliveryToUpdate = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);

		if(supplyOrderDeliveryToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderDeliveryManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}

		SupplyOrder item = supplyOrderDeliveryToUpdate.getSupplyOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingSupplyOrder(userContext,supplyOrderDeliveryId,name, code, used,tokensExpr);
		SupplyOrderDelivery supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDeliveryToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderDelivery){
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
	}


	protected SupplyOrder createSupplyOrder(YoubenbenUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId) throws Exception{

		SupplyOrder supplyOrder = new SupplyOrder();
		
		
		RetailStoreCountryCenter  buyer = new RetailStoreCountryCenter();
		buyer.setId(buyerId);		
		supplyOrder.setBuyer(buyer);		
		GoodsSupplier  seller = new GoodsSupplier();
		seller.setId(sellerId);		
		supplyOrder.setSeller(seller);		
		supplyOrder.setTitle(title);		
		supplyOrder.setTotalAmount(totalAmount);		
		SupplyOrderConfirmation  confirmation = new SupplyOrderConfirmation();
		confirmation.setId(confirmationId);		
		supplyOrder.setConfirmation(confirmation);		
		SupplyOrderApproval  approval = new SupplyOrderApproval();
		approval.setId(approvalId);		
		supplyOrder.setApproval(approval);		
		SupplyOrderProcessing  processing = new SupplyOrderProcessing();
		processing.setId(processingId);		
		supplyOrder.setProcessing(processing);		
		SupplyOrderPicking  picking = new SupplyOrderPicking();
		picking.setId(pickingId);		
		supplyOrder.setPicking(picking);		
		SupplyOrderShipment  shipment = new SupplyOrderShipment();
		shipment.setId(shipmentId);		
		supplyOrder.setShipment(shipment);		
		supplyOrder.setLastUpdateTime(userContext.now());
	
		
		return supplyOrder;


	}

	protected SupplyOrder createIndexedSupplyOrder(String id, int version){

		SupplyOrder supplyOrder = new SupplyOrder();
		supplyOrder.setId(id);
		supplyOrder.setVersion(version);
		return supplyOrder;

	}

	protected void checkParamsForRemovingSupplyOrderList(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		for(String supplyOrderIdItem: supplyOrderIds){
			checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	}
	public  SupplyOrderDelivery removeSupplyOrderList(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderDeliveryId,  supplyOrderIds, tokensExpr);


			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
			synchronized(supplyOrderDelivery){
				//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderDeliveryDaoOf(userContext).planToRemoveSupplyOrderList(supplyOrderDelivery, supplyOrderIds, allTokens());
				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderDelivery.getSupplyOrderList());
				return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderDelivery( supplyOrderDeliveryId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	}
	public  SupplyOrderDelivery removeSupplyOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSupplyOrder(userContext,supplyOrderDeliveryId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.removeSupplyOrder( supplyOrder );
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderDelivery( supplyOrderDeliveryId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	}
	public  SupplyOrderDelivery copySupplyOrderFrom(YoubenbenUserContext userContext, String supplyOrderDeliveryId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSupplyOrder(userContext,supplyOrderDeliveryId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			supplyOrder.updateLastUpdateTime(userContext.now());

			supplyOrderDelivery.copySupplyOrderFrom( supplyOrder );
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderDelivery.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfSupplyOrder(parseString(newValueExpr));
		
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	}

	public  SupplyOrderDelivery updateSupplyOrder(YoubenbenUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderDeliveryId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();



		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, loadTokens);

		synchronized(supplyOrderDelivery){
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderDelivery.removeSupplyOrder( supplyOrder );
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);

			SupplyOrder supplyOrder = supplyOrderDelivery.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderDeliveryManagerException(supplyOrder+" is NOT FOUND" );
			}

			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderDelivery newCreated) throws Exception{
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
		//   SupplyOrderDelivery newSupplyOrderDelivery = this.createSupplyOrderDelivery(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSupplyOrderDelivery
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, SupplyOrderDelivery.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<SupplyOrderDelivery> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String supplyOrderDeliveryId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getSupplyOrderDeliveryDetailScope().clone();
		SupplyOrderDelivery merchantObj = (SupplyOrderDelivery) this.view(userContext, supplyOrderDeliveryId);
    String merchantObjId = supplyOrderDeliveryId;
    String linkToUrl =	"supplyOrderDeliveryManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "供应订单交货"+"详情";
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
				MapUtil.put("id", "2-who")
				    .put("fieldName", "who")
				    .put("label", "谁")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("who", merchantObj.getWho());

		propList.add(
				MapUtil.put("id", "3-deliveryTime")
				    .put("fieldName", "deliveryTime")
				    .put("label", "交货时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("deliveryTime", merchantObj.getDeliveryTime());

		//处理 sectionList

		//处理Section：consumerOrderListSection
		Map consumerOrderListSection = ListofUtils.buildSection(
		    "consumerOrderListSection",
		    "消费者的订单列表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderManager/listByDelivery/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(consumerOrderListSection);

		result.put("consumerOrderListSection", ListofUtils.toShortList(merchantObj.getConsumerOrderList(), "consumerOrder"));
		vscope.field("consumerOrderListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( ConsumerOrder.class.getName(), null));

		//处理Section：supplyOrderListSection
		Map supplyOrderListSection = ListofUtils.buildSection(
		    "supplyOrderListSection",
		    "供应订单列表",
		    null,
		    "",
		    "__no_group",
		    "supplyOrderManager/listByDelivery/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(supplyOrderListSection);

		result.put("supplyOrderListSection", ListofUtils.toShortList(merchantObj.getSupplyOrderList(), "supplyOrder"));
		vscope.field("supplyOrderListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( SupplyOrder.class.getName(), null));

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


