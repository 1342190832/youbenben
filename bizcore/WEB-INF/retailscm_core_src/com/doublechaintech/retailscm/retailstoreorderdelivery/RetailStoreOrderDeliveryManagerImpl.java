
package com.doublechaintech.retailscm.retailstoreorderdelivery;

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


import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.doublechaintech.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.doublechaintech.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.doublechaintech.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.doublechaintech.retailscm.retailstoreordershipment.RetailStoreOrderShipment;






public class RetailStoreOrderDeliveryManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderDeliveryManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreOrderDeliveryTokens.start().withTokenFromListName(listName).done();
		RetailStoreOrderDelivery  retailStoreOrderDelivery = (RetailStoreOrderDelivery) this.loadRetailStoreOrderDelivery(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreOrderDelivery.collectRefercencesFromLists();
		retailStoreOrderDeliveryDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreOrderDelivery, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreOrderDeliveryGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreOrderDelivery";
	@Override
	public RetailStoreOrderDeliveryDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreOrderDeliveryDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderDeliveryManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderDeliveryManagerException(message);

	}



 	protected RetailStoreOrderDelivery saveRetailStoreOrderDelivery(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderDeliveryDAO().save(retailStoreOrderDelivery, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens);
 	}
 	
 	protected RetailStoreOrderDelivery saveRetailStoreOrderDeliveryDetail(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery) throws Exception{	

 		
 		return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, allTokens());
 	}
 	
 	public RetailStoreOrderDelivery loadRetailStoreOrderDelivery(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderDeliveryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery( userContext, retailStoreOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderDelivery, tokens);
 	}
 	
 	
 	 public RetailStoreOrderDelivery searchRetailStoreOrderDelivery(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderDeliveryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery( userContext, retailStoreOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderDelivery, tokens);
 	}
 	
 	

 	protected RetailStoreOrderDelivery present(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderDelivery,tokens);
		
		
		RetailStoreOrderDelivery  retailStoreOrderDeliveryToPresent = retailStoreOrderDeliveryDaoOf(userContext).present(retailStoreOrderDelivery, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderDeliveryToPresent.collectRefercencesFromLists();
		retailStoreOrderDeliveryDaoOf(userContext).alias(entityListToNaming);
		
		return  retailStoreOrderDeliveryToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderDelivery loadRetailStoreOrderDeliveryDetail(RetailscmUserContext userContext, String retailStoreOrderDeliveryId) throws Exception{	
 		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery( userContext, retailStoreOrderDeliveryId, allTokens());
 		return present(userContext,retailStoreOrderDelivery, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderDeliveryId) throws Exception{	
 		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery( userContext, retailStoreOrderDeliveryId, viewTokens());
 		return present(userContext,retailStoreOrderDelivery, allTokens());
		
 	}
 	protected RetailStoreOrderDelivery saveRetailStoreOrderDelivery(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object>tokens) throws Exception{	
 		return retailStoreOrderDeliveryDaoOf(userContext).save(retailStoreOrderDelivery, tokens);
 	}
 	protected RetailStoreOrderDelivery loadRetailStoreOrderDelivery(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderDeliveryManagerException.class);

 
 		return retailStoreOrderDeliveryDaoOf(userContext).load(retailStoreOrderDeliveryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderDelivery, tokens);
		
		addAction(userContext, retailStoreOrderDelivery, tokens,"@create","createRetailStoreOrderDelivery","createRetailStoreOrderDelivery/","main","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"@update","updateRetailStoreOrderDelivery","updateRetailStoreOrderDelivery/"+retailStoreOrderDelivery.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"@copy","cloneRetailStoreOrderDelivery","cloneRetailStoreOrderDelivery/"+retailStoreOrderDelivery.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreOrderDelivery createRetailStoreOrderDelivery(RetailscmUserContext userContext, String who,Date deliveryTime) throws Exception
	//public RetailStoreOrderDelivery createRetailStoreOrderDelivery(RetailscmUserContext userContext,String who, Date deliveryTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfRetailStoreOrderDelivery(who);
		checkerOf(userContext).checkDeliveryTimeOfRetailStoreOrderDelivery(deliveryTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);


		RetailStoreOrderDelivery retailStoreOrderDelivery=createNewRetailStoreOrderDelivery();	

		retailStoreOrderDelivery.setWho(who);
		retailStoreOrderDelivery.setDeliveryTime(deliveryTime);

		retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderDelivery);
		return retailStoreOrderDelivery;


	}
	protected RetailStoreOrderDelivery createNewRetailStoreOrderDelivery()
	{

		return new RetailStoreOrderDelivery();
	}

	protected void checkParamsForUpdatingRetailStoreOrderDelivery(RetailscmUserContext userContext,String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		checkerOf(userContext).checkVersionOfRetailStoreOrderDelivery( retailStoreOrderDeliveryVersion);
		

		if(RetailStoreOrderDelivery.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfRetailStoreOrderDelivery(parseString(newValueExpr));
		
			
		}
		if(RetailStoreOrderDelivery.DELIVERY_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDeliveryTimeOfRetailStoreOrderDelivery(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);


	}



	public RetailStoreOrderDelivery clone(RetailscmUserContext userContext, String fromRetailStoreOrderDeliveryId) throws Exception{

		return retailStoreOrderDeliveryDaoOf(userContext).clone(fromRetailStoreOrderDeliveryId, this.allTokens());
	}

	public RetailStoreOrderDelivery internalSaveRetailStoreOrderDelivery(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery) throws Exception
	{
		return internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, allTokens());

	}
	public RetailStoreOrderDelivery internalSaveRetailStoreOrderDelivery(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreOrderDelivery){
			//will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderDelivery.
			if (retailStoreOrderDelivery.isChanged()){
			
			}
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, options);
			return retailStoreOrderDelivery;

		}

	}

	public RetailStoreOrderDelivery updateRetailStoreOrderDelivery(RetailscmUserContext userContext,String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion, property, newValueExpr, tokensExpr);



		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		if(retailStoreOrderDelivery.getVersion() != retailStoreOrderDeliveryVersion){
			String message = "The target version("+retailStoreOrderDelivery.getVersion()+") is not equals to version("+retailStoreOrderDeliveryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderDelivery){
			//will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderDelivery.
			
			retailStoreOrderDelivery.changeProperty(property, newValueExpr);
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().done());
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().done());
		}

	}

	public RetailStoreOrderDelivery updateRetailStoreOrderDeliveryProperty(RetailscmUserContext userContext,String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion, property, newValueExpr, tokensExpr);

		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		if(retailStoreOrderDelivery.getVersion() != retailStoreOrderDeliveryVersion){
			String message = "The target version("+retailStoreOrderDelivery.getVersion()+") is not equals to version("+retailStoreOrderDeliveryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderDelivery){
			//will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderDelivery.

			retailStoreOrderDelivery.changeProperty(property, newValueExpr);
			
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().done());
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreOrderDeliveryTokens tokens(){
		return RetailStoreOrderDeliveryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderDeliveryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreOrderListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderDeliveryTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion) throws Exception{

		retailStoreOrderDeliveryDaoOf(userContext).delete(retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion);
	}

	public RetailStoreOrderDelivery forgetByAll(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion);
	}
	protected RetailStoreOrderDelivery forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion) throws Exception{

		return retailStoreOrderDeliveryDaoOf(userContext).disconnectFromAll(retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderDeliveryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreOrderDeliveryDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreOrderDelivery with buyer in RetailStoreOrder
	protected RetailStoreOrderDelivery breakWithRetailStoreOrderByBuyer(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String buyerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());

			synchronized(retailStoreOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderDeliveryDaoOf(userContext).planToRemoveRetailStoreOrderListWithBuyer(retailStoreOrderDelivery, buyerId, this.emptyOptions());

				retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderDelivery;
			}
	}
	//disconnect RetailStoreOrderDelivery with seller in RetailStoreOrder
	protected RetailStoreOrderDelivery breakWithRetailStoreOrderBySeller(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String sellerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());

			synchronized(retailStoreOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderDeliveryDaoOf(userContext).planToRemoveRetailStoreOrderListWithSeller(retailStoreOrderDelivery, sellerId, this.emptyOptions());

				retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderDelivery;
			}
	}
	//disconnect RetailStoreOrderDelivery with confirmation in RetailStoreOrder
	protected RetailStoreOrderDelivery breakWithRetailStoreOrderByConfirmation(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());

			synchronized(retailStoreOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderDeliveryDaoOf(userContext).planToRemoveRetailStoreOrderListWithConfirmation(retailStoreOrderDelivery, confirmationId, this.emptyOptions());

				retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderDelivery;
			}
	}
	//disconnect RetailStoreOrderDelivery with approval in RetailStoreOrder
	protected RetailStoreOrderDelivery breakWithRetailStoreOrderByApproval(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());

			synchronized(retailStoreOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderDeliveryDaoOf(userContext).planToRemoveRetailStoreOrderListWithApproval(retailStoreOrderDelivery, approvalId, this.emptyOptions());

				retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderDelivery;
			}
	}
	//disconnect RetailStoreOrderDelivery with processing in RetailStoreOrder
	protected RetailStoreOrderDelivery breakWithRetailStoreOrderByProcessing(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());

			synchronized(retailStoreOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderDeliveryDaoOf(userContext).planToRemoveRetailStoreOrderListWithProcessing(retailStoreOrderDelivery, processingId, this.emptyOptions());

				retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderDelivery;
			}
	}
	//disconnect RetailStoreOrderDelivery with picking in RetailStoreOrder
	protected RetailStoreOrderDelivery breakWithRetailStoreOrderByPicking(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String pickingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());

			synchronized(retailStoreOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderDeliveryDaoOf(userContext).planToRemoveRetailStoreOrderListWithPicking(retailStoreOrderDelivery, pickingId, this.emptyOptions());

				retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderDelivery;
			}
	}
	//disconnect RetailStoreOrderDelivery with shipment in RetailStoreOrder
	protected RetailStoreOrderDelivery breakWithRetailStoreOrderByShipment(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());

			synchronized(retailStoreOrderDelivery){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderDeliveryDaoOf(userContext).planToRemoveRetailStoreOrderListWithShipment(retailStoreOrderDelivery, shipmentId, this.emptyOptions());

				retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderDelivery;
			}
	}






	protected void checkParamsForAddingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);

		
		checkerOf(userContext).checkBuyerIdOfRetailStoreOrder(buyerId);
		
		checkerOf(userContext).checkSellerIdOfRetailStoreOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfRetailStoreOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(totalAmount);
		
		checkerOf(userContext).checkConfirmationIdOfRetailStoreOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfRetailStoreOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfRetailStoreOrder(processingId);
		
		checkerOf(userContext).checkPickingIdOfRetailStoreOrder(pickingId);
		
		checkerOf(userContext).checkShipmentIdOfRetailStoreOrder(shipmentId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);


	}
	public  RetailStoreOrderDelivery addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderDeliveryId,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, shipmentId,tokensExpr);

		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, shipmentId);

		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, emptyOptions());
		synchronized(retailStoreOrderDelivery){
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderDelivery.addRetailStoreOrder( retailStoreOrder );
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderDeliveryId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(id);

		checkerOf(userContext).checkTitleOfRetailStoreOrder( title);
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);

	}
	public  RetailStoreOrderDelivery updateRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreOrderDeliveryId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "is", id).done();

		RetailStoreOrderDelivery retailStoreOrderDeliveryToUpdate = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);

		if(retailStoreOrderDeliveryToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreOrderDeliveryManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreOrder item = retailStoreOrderDeliveryToUpdate.getRetailStoreOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderDeliveryId,name, code, used,tokensExpr);
		RetailStoreOrderDelivery retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStoreOrderDelivery){
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreOrder createRetailStoreOrder(RetailscmUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId) throws Exception{

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		
		
		RetailStore  buyer = new RetailStore();
		buyer.setId(buyerId);		
		retailStoreOrder.setBuyer(buyer);		
		RetailStoreCountryCenter  seller = new RetailStoreCountryCenter();
		seller.setId(sellerId);		
		retailStoreOrder.setSeller(seller);		
		retailStoreOrder.setTitle(title);		
		retailStoreOrder.setTotalAmount(totalAmount);		
		RetailStoreOrderConfirmation  confirmation = new RetailStoreOrderConfirmation();
		confirmation.setId(confirmationId);		
		retailStoreOrder.setConfirmation(confirmation);		
		RetailStoreOrderApproval  approval = new RetailStoreOrderApproval();
		approval.setId(approvalId);		
		retailStoreOrder.setApproval(approval);		
		RetailStoreOrderProcessing  processing = new RetailStoreOrderProcessing();
		processing.setId(processingId);		
		retailStoreOrder.setProcessing(processing);		
		RetailStoreOrderPicking  picking = new RetailStoreOrderPicking();
		picking.setId(pickingId);		
		retailStoreOrder.setPicking(picking);		
		RetailStoreOrderShipment  shipment = new RetailStoreOrderShipment();
		shipment.setId(shipmentId);		
		retailStoreOrder.setShipment(shipment);		
		retailStoreOrder.setLastUpdateTime(userContext.now());
	
		
		return retailStoreOrder;


	}

	protected RetailStoreOrder createIndexedRetailStoreOrder(String id, int version){

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(id);
		retailStoreOrder.setVersion(version);
		return retailStoreOrder;

	}

	protected void checkParamsForRemovingRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderDeliveryId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		for(String retailStoreOrderIdItem: retailStoreOrderIds){
			checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);

	}
	public  RetailStoreOrderDelivery removeRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderDeliveryId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreOrderDeliveryId,  retailStoreOrderIds, tokensExpr);


			RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
			synchronized(retailStoreOrderDelivery){
				//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreOrderDeliveryDaoOf(userContext).planToRemoveRetailStoreOrderList(retailStoreOrderDelivery, retailStoreOrderIds, allTokens());
				retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreOrderDelivery.getRetailStoreOrderList());
				return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOrderDelivery( retailStoreOrderDeliveryId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);

	}
	public  RetailStoreOrderDelivery removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderDeliveryId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		synchronized(retailStoreOrderDelivery){
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderDelivery.removeRetailStoreOrder( retailStoreOrder );
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOrderDelivery( retailStoreOrderDeliveryId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);

	}
	public  RetailStoreOrderDelivery copyRetailStoreOrderFrom(RetailscmUserContext userContext, String retailStoreOrderDeliveryId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderDeliveryId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		synchronized(retailStoreOrderDelivery){
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStoreOrder.updateLastUpdateTime(userContext.now());

			retailStoreOrderDelivery.copyRetailStoreOrderFrom( retailStoreOrder );
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, (RetailStoreOrder)retailStoreOrderDelivery.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);

	}

	public  RetailStoreOrderDelivery updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderDeliveryId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "eq", retailStoreOrderId).done();



		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, loadTokens);

		synchronized(retailStoreOrderDelivery){
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderDelivery.removeRetailStoreOrder( retailStoreOrder );
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);

			RetailStoreOrder retailStoreOrder = retailStoreOrderDelivery.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderDeliveryManagerException(retailStoreOrder+" is NOT FOUND" );
			}

			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderDelivery newCreated) throws Exception{
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
		//   RetailStoreOrderDelivery newRetailStoreOrderDelivery = this.createRetailStoreOrderDelivery(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreOrderDelivery
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreOrderDelivery.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreOrderDelivery> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreOrderDeliveryId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreOrderDeliveryDetailScope().clone();
		RetailStoreOrderDelivery merchantObj = (RetailStoreOrderDelivery) this.view(userContext, retailStoreOrderDeliveryId);
    String merchantObjId = retailStoreOrderDeliveryId;
    String linkToUrl =	"retailStoreOrderDeliveryManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超订单交付"+"详情";
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

		//处理Section：retailStoreOrderListSection
		Map retailStoreOrderListSection = ListofUtils.buildSection(
		    "retailStoreOrderListSection",
		    "零售店订购单",
		    null,
		    "",
		    "__no_group",
		    "retailStoreOrderManager/listByDelivery/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreOrderListSection);

		result.put("retailStoreOrderListSection", ListofUtils.toShortList(merchantObj.getRetailStoreOrderList(), "retailStoreOrder"));
		vscope.field("retailStoreOrderListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( RetailStoreOrder.class.getName(), null));

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


