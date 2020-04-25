
package com.doublechaintech.retailscm.retailstoreorderpicking;

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






public class RetailStoreOrderPickingManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderPickingManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreOrderPickingTokens.start().withTokenFromListName(listName).done();
		RetailStoreOrderPicking  retailStoreOrderPicking = (RetailStoreOrderPicking) this.loadRetailStoreOrderPicking(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreOrderPicking.collectRefercencesFromLists();
		retailStoreOrderPickingDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreOrderPicking, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreOrderPickingGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreOrderPicking";
	@Override
	public RetailStoreOrderPickingDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreOrderPickingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderPickingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderPickingManagerException(message);

	}



 	protected RetailStoreOrderPicking saveRetailStoreOrderPicking(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderPickingDAO().save(retailStoreOrderPicking, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens);
 	}
 	
 	protected RetailStoreOrderPicking saveRetailStoreOrderPickingDetail(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking) throws Exception{	

 		
 		return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, allTokens());
 	}
 	
 	public RetailStoreOrderPicking loadRetailStoreOrderPicking(RetailscmUserContext userContext, String retailStoreOrderPickingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderPickingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking( userContext, retailStoreOrderPickingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPicking, tokens);
 	}
 	
 	
 	 public RetailStoreOrderPicking searchRetailStoreOrderPicking(RetailscmUserContext userContext, String retailStoreOrderPickingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderPickingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking( userContext, retailStoreOrderPickingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPicking, tokens);
 	}
 	
 	

 	protected RetailStoreOrderPicking present(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderPicking,tokens);
		
		
		RetailStoreOrderPicking  retailStoreOrderPickingToPresent = retailStoreOrderPickingDaoOf(userContext).present(retailStoreOrderPicking, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderPickingToPresent.collectRefercencesFromLists();
		retailStoreOrderPickingDaoOf(userContext).alias(entityListToNaming);
		
		return  retailStoreOrderPickingToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderPicking loadRetailStoreOrderPickingDetail(RetailscmUserContext userContext, String retailStoreOrderPickingId) throws Exception{	
 		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking( userContext, retailStoreOrderPickingId, allTokens());
 		return present(userContext,retailStoreOrderPicking, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderPickingId) throws Exception{	
 		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking( userContext, retailStoreOrderPickingId, viewTokens());
 		return present(userContext,retailStoreOrderPicking, allTokens());
		
 	}
 	protected RetailStoreOrderPicking saveRetailStoreOrderPicking(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object>tokens) throws Exception{	
 		return retailStoreOrderPickingDaoOf(userContext).save(retailStoreOrderPicking, tokens);
 	}
 	protected RetailStoreOrderPicking loadRetailStoreOrderPicking(RetailscmUserContext userContext, String retailStoreOrderPickingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderPickingManagerException.class);

 
 		return retailStoreOrderPickingDaoOf(userContext).load(retailStoreOrderPickingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderPicking, tokens);
		
		addAction(userContext, retailStoreOrderPicking, tokens,"@create","createRetailStoreOrderPicking","createRetailStoreOrderPicking/","main","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"@update","updateRetailStoreOrderPicking","updateRetailStoreOrderPicking/"+retailStoreOrderPicking.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"@copy","cloneRetailStoreOrderPicking","cloneRetailStoreOrderPicking/"+retailStoreOrderPicking.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreOrderPicking createRetailStoreOrderPicking(RetailscmUserContext userContext, String who,Date processTime) throws Exception
	//public RetailStoreOrderPicking createRetailStoreOrderPicking(RetailscmUserContext userContext,String who, Date processTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfRetailStoreOrderPicking(who);
		checkerOf(userContext).checkProcessTimeOfRetailStoreOrderPicking(processTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);


		RetailStoreOrderPicking retailStoreOrderPicking=createNewRetailStoreOrderPicking();	

		retailStoreOrderPicking.setWho(who);
		retailStoreOrderPicking.setProcessTime(processTime);

		retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderPicking);
		return retailStoreOrderPicking;


	}
	protected RetailStoreOrderPicking createNewRetailStoreOrderPicking()
	{

		return new RetailStoreOrderPicking();
	}

	protected void checkParamsForUpdatingRetailStoreOrderPicking(RetailscmUserContext userContext,String retailStoreOrderPickingId, int retailStoreOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		checkerOf(userContext).checkVersionOfRetailStoreOrderPicking( retailStoreOrderPickingVersion);
		

		if(RetailStoreOrderPicking.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfRetailStoreOrderPicking(parseString(newValueExpr));
		
			
		}
		if(RetailStoreOrderPicking.PROCESS_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkProcessTimeOfRetailStoreOrderPicking(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);


	}



	public RetailStoreOrderPicking clone(RetailscmUserContext userContext, String fromRetailStoreOrderPickingId) throws Exception{

		return retailStoreOrderPickingDaoOf(userContext).clone(fromRetailStoreOrderPickingId, this.allTokens());
	}

	public RetailStoreOrderPicking internalSaveRetailStoreOrderPicking(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking) throws Exception
	{
		return internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, allTokens());

	}
	public RetailStoreOrderPicking internalSaveRetailStoreOrderPicking(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreOrderPicking){
			//will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPicking.
			if (retailStoreOrderPicking.isChanged()){
			
			}
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, options);
			return retailStoreOrderPicking;

		}

	}

	public RetailStoreOrderPicking updateRetailStoreOrderPicking(RetailscmUserContext userContext,String retailStoreOrderPickingId, int retailStoreOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion, property, newValueExpr, tokensExpr);



		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		if(retailStoreOrderPicking.getVersion() != retailStoreOrderPickingVersion){
			String message = "The target version("+retailStoreOrderPicking.getVersion()+") is not equals to version("+retailStoreOrderPickingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderPicking){
			//will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPicking.
			
			retailStoreOrderPicking.changeProperty(property, newValueExpr);
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().done());
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().done());
		}

	}

	public RetailStoreOrderPicking updateRetailStoreOrderPickingProperty(RetailscmUserContext userContext,String retailStoreOrderPickingId, int retailStoreOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion, property, newValueExpr, tokensExpr);

		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		if(retailStoreOrderPicking.getVersion() != retailStoreOrderPickingVersion){
			String message = "The target version("+retailStoreOrderPicking.getVersion()+") is not equals to version("+retailStoreOrderPickingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderPicking){
			//will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPicking.

			retailStoreOrderPicking.changeProperty(property, newValueExpr);
			
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().done());
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreOrderPickingTokens tokens(){
		return RetailStoreOrderPickingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderPickingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreOrderListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderPickingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderPickingId, int retailStoreOrderPickingVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderPickingId, int retailStoreOrderPickingVersion) throws Exception{

		retailStoreOrderPickingDaoOf(userContext).delete(retailStoreOrderPickingId, retailStoreOrderPickingVersion);
	}

	public RetailStoreOrderPicking forgetByAll(RetailscmUserContext userContext, String retailStoreOrderPickingId, int retailStoreOrderPickingVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion);
	}
	protected RetailStoreOrderPicking forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderPickingId, int retailStoreOrderPickingVersion) throws Exception{

		return retailStoreOrderPickingDaoOf(userContext).disconnectFromAll(retailStoreOrderPickingId, retailStoreOrderPickingVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderPickingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreOrderPickingDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreOrderPicking with buyer in RetailStoreOrder
	protected RetailStoreOrderPicking breakWithRetailStoreOrderByBuyer(RetailscmUserContext userContext, String retailStoreOrderPickingId, String buyerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());

			synchronized(retailStoreOrderPicking){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderPickingDaoOf(userContext).planToRemoveRetailStoreOrderListWithBuyer(retailStoreOrderPicking, buyerId, this.emptyOptions());

				retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderPicking;
			}
	}
	//disconnect RetailStoreOrderPicking with seller in RetailStoreOrder
	protected RetailStoreOrderPicking breakWithRetailStoreOrderBySeller(RetailscmUserContext userContext, String retailStoreOrderPickingId, String sellerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());

			synchronized(retailStoreOrderPicking){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderPickingDaoOf(userContext).planToRemoveRetailStoreOrderListWithSeller(retailStoreOrderPicking, sellerId, this.emptyOptions());

				retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderPicking;
			}
	}
	//disconnect RetailStoreOrderPicking with confirmation in RetailStoreOrder
	protected RetailStoreOrderPicking breakWithRetailStoreOrderByConfirmation(RetailscmUserContext userContext, String retailStoreOrderPickingId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());

			synchronized(retailStoreOrderPicking){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderPickingDaoOf(userContext).planToRemoveRetailStoreOrderListWithConfirmation(retailStoreOrderPicking, confirmationId, this.emptyOptions());

				retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderPicking;
			}
	}
	//disconnect RetailStoreOrderPicking with approval in RetailStoreOrder
	protected RetailStoreOrderPicking breakWithRetailStoreOrderByApproval(RetailscmUserContext userContext, String retailStoreOrderPickingId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());

			synchronized(retailStoreOrderPicking){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderPickingDaoOf(userContext).planToRemoveRetailStoreOrderListWithApproval(retailStoreOrderPicking, approvalId, this.emptyOptions());

				retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderPicking;
			}
	}
	//disconnect RetailStoreOrderPicking with processing in RetailStoreOrder
	protected RetailStoreOrderPicking breakWithRetailStoreOrderByProcessing(RetailscmUserContext userContext, String retailStoreOrderPickingId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());

			synchronized(retailStoreOrderPicking){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderPickingDaoOf(userContext).planToRemoveRetailStoreOrderListWithProcessing(retailStoreOrderPicking, processingId, this.emptyOptions());

				retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderPicking;
			}
	}
	//disconnect RetailStoreOrderPicking with shipment in RetailStoreOrder
	protected RetailStoreOrderPicking breakWithRetailStoreOrderByShipment(RetailscmUserContext userContext, String retailStoreOrderPickingId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());

			synchronized(retailStoreOrderPicking){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderPickingDaoOf(userContext).planToRemoveRetailStoreOrderListWithShipment(retailStoreOrderPicking, shipmentId, this.emptyOptions());

				retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderPicking;
			}
	}
	//disconnect RetailStoreOrderPicking with delivery in RetailStoreOrder
	protected RetailStoreOrderPicking breakWithRetailStoreOrderByDelivery(RetailscmUserContext userContext, String retailStoreOrderPickingId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());

			synchronized(retailStoreOrderPicking){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderPickingDaoOf(userContext).planToRemoveRetailStoreOrderListWithDelivery(retailStoreOrderPicking, deliveryId, this.emptyOptions());

				retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderPicking;
			}
	}






	protected void checkParamsForAddingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);

		
		checkerOf(userContext).checkBuyerIdOfRetailStoreOrder(buyerId);
		
		checkerOf(userContext).checkSellerIdOfRetailStoreOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfRetailStoreOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(totalAmount);
		
		checkerOf(userContext).checkConfirmationIdOfRetailStoreOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfRetailStoreOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfRetailStoreOrder(processingId);
		
		checkerOf(userContext).checkShipmentIdOfRetailStoreOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfRetailStoreOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);


	}
	public  RetailStoreOrderPicking addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderPickingId,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, processingId, shipmentId, deliveryId,tokensExpr);

		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, processingId, shipmentId, deliveryId);

		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, emptyOptions());
		synchronized(retailStoreOrderPicking){
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderPicking.addRetailStoreOrder( retailStoreOrder );
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderPickingId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(id);

		checkerOf(userContext).checkTitleOfRetailStoreOrder( title);
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);

	}
	public  RetailStoreOrderPicking updateRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderPickingId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreOrderPickingId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "is", id).done();

		RetailStoreOrderPicking retailStoreOrderPickingToUpdate = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);

		if(retailStoreOrderPickingToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreOrderPickingManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreOrder item = retailStoreOrderPickingToUpdate.getRetailStoreOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderPickingId,name, code, used,tokensExpr);
		RetailStoreOrderPicking retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPickingToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStoreOrderPicking){
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreOrder createRetailStoreOrder(RetailscmUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId) throws Exception{

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
		RetailStoreOrderShipment  shipment = new RetailStoreOrderShipment();
		shipment.setId(shipmentId);		
		retailStoreOrder.setShipment(shipment);		
		RetailStoreOrderDelivery  delivery = new RetailStoreOrderDelivery();
		delivery.setId(deliveryId);		
		retailStoreOrder.setDelivery(delivery);		
		retailStoreOrder.setLastUpdateTime(userContext.now());
	
		
		return retailStoreOrder;


	}

	protected RetailStoreOrder createIndexedRetailStoreOrder(String id, int version){

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(id);
		retailStoreOrder.setVersion(version);
		return retailStoreOrder;

	}

	protected void checkParamsForRemovingRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderPickingId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		for(String retailStoreOrderIdItem: retailStoreOrderIds){
			checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);

	}
	public  RetailStoreOrderPicking removeRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderPickingId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreOrderPickingId,  retailStoreOrderIds, tokensExpr);


			RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
			synchronized(retailStoreOrderPicking){
				//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreOrderPickingDaoOf(userContext).planToRemoveRetailStoreOrderList(retailStoreOrderPicking, retailStoreOrderIds, allTokens());
				retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreOrderPicking.getRetailStoreOrderList());
				return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOrderPicking( retailStoreOrderPickingId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);

	}
	public  RetailStoreOrderPicking removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderPickingId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		synchronized(retailStoreOrderPicking){
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderPicking.removeRetailStoreOrder( retailStoreOrder );
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOrderPicking( retailStoreOrderPickingId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);

	}
	public  RetailStoreOrderPicking copyRetailStoreOrderFrom(RetailscmUserContext userContext, String retailStoreOrderPickingId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderPickingId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		synchronized(retailStoreOrderPicking){
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStoreOrder.updateLastUpdateTime(userContext.now());

			retailStoreOrderPicking.copyRetailStoreOrderFrom( retailStoreOrder );
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, (RetailStoreOrder)retailStoreOrderPicking.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);

	}

	public  RetailStoreOrderPicking updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderPickingId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "eq", retailStoreOrderId).done();



		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, loadTokens);

		synchronized(retailStoreOrderPicking){
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderPicking.removeRetailStoreOrder( retailStoreOrder );
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);

			RetailStoreOrder retailStoreOrder = retailStoreOrderPicking.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderPickingManagerException(retailStoreOrder+" is NOT FOUND" );
			}

			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderPicking newCreated) throws Exception{
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
		//   RetailStoreOrderPicking newRetailStoreOrderPicking = this.createRetailStoreOrderPicking(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreOrderPicking
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreOrderPicking.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreOrderPicking> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreOrderPickingId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreOrderPickingDetailScope().clone();
		RetailStoreOrderPicking merchantObj = (RetailStoreOrderPicking) this.view(userContext, retailStoreOrderPickingId);
    String merchantObjId = retailStoreOrderPickingId;
    String linkToUrl =	"retailStoreOrderPickingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超订单拣货"+"详情";
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
				MapUtil.put("id", "3-processTime")
				    .put("fieldName", "processTime")
				    .put("label", "过程的时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("processTime", merchantObj.getProcessTime());

		//处理 sectionList

		//处理Section：retailStoreOrderListSection
		Map retailStoreOrderListSection = ListofUtils.buildSection(
		    "retailStoreOrderListSection",
		    "零售店订购单",
		    null,
		    "",
		    "__no_group",
		    "retailStoreOrderManager/listByPicking/"+merchantObjId+"/",
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


