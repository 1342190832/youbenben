
package com.youbenben.youbenben.retailstoreordershipment;

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


import com.youbenben.youbenben.retailstoreorder.RetailStoreOrder;


import com.youbenben.youbenben.retailstoreorderapproval.RetailStoreOrderApproval;
import com.youbenben.youbenben.retailstoreorderpicking.RetailStoreOrderPicking;
import com.youbenben.youbenben.retailstoreordershipment.RetailStoreOrderShipment;
import com.youbenben.youbenben.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.youbenben.youbenben.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.youbenben.youbenben.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.youbenben.youbenben.retailstore.RetailStore;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;






public class RetailStoreOrderShipmentManagerImpl extends CustomYoubenbenCheckerManager implements RetailStoreOrderShipmentManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreOrderShipmentTokens.start().withTokenFromListName(listName).done();
		RetailStoreOrderShipment  retailStoreOrderShipment = (RetailStoreOrderShipment) this.loadRetailStoreOrderShipment(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreOrderShipment.collectRefercencesFromLists();
		retailStoreOrderShipmentDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreOrderShipment, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreOrderShipmentGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreOrderShipment";
	@Override
	public RetailStoreOrderShipmentDAO daoOf(YoubenbenUserContext userContext) {
		return retailStoreOrderShipmentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderShipmentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderShipmentManagerException(message);

	}



 	protected RetailStoreOrderShipment saveRetailStoreOrderShipment(YoubenbenUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderShipmentDAO().save(retailStoreOrderShipment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens);
 	}
 	
 	protected RetailStoreOrderShipment saveRetailStoreOrderShipmentDetail(YoubenbenUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment) throws Exception{	

 		
 		return saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, allTokens());
 	}
 	
 	public RetailStoreOrderShipment loadRetailStoreOrderShipment(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderShipment(retailStoreOrderShipmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderShipmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment( userContext, retailStoreOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderShipment, tokens);
 	}
 	
 	
 	 public RetailStoreOrderShipment searchRetailStoreOrderShipment(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderShipment(retailStoreOrderShipmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderShipmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment( userContext, retailStoreOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderShipment, tokens);
 	}
 	
 	

 	protected RetailStoreOrderShipment present(YoubenbenUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderShipment,tokens);
		
		
		RetailStoreOrderShipment  retailStoreOrderShipmentToPresent = retailStoreOrderShipmentDaoOf(userContext).present(retailStoreOrderShipment, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderShipmentToPresent.collectRefercencesFromLists();
		retailStoreOrderShipmentDaoOf(userContext).alias(entityListToNaming);
		
		return  retailStoreOrderShipmentToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderShipment loadRetailStoreOrderShipmentDetail(YoubenbenUserContext userContext, String retailStoreOrderShipmentId) throws Exception{	
 		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment( userContext, retailStoreOrderShipmentId, allTokens());
 		return present(userContext,retailStoreOrderShipment, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String retailStoreOrderShipmentId) throws Exception{	
 		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment( userContext, retailStoreOrderShipmentId, viewTokens());
 		return present(userContext,retailStoreOrderShipment, allTokens());
		
 	}
 	protected RetailStoreOrderShipment saveRetailStoreOrderShipment(YoubenbenUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment, Map<String,Object>tokens) throws Exception{	
 		return retailStoreOrderShipmentDaoOf(userContext).save(retailStoreOrderShipment, tokens);
 	}
 	protected RetailStoreOrderShipment loadRetailStoreOrderShipment(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreOrderShipment(retailStoreOrderShipmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderShipmentManagerException.class);

 
 		return retailStoreOrderShipmentDaoOf(userContext).load(retailStoreOrderShipmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderShipment, tokens);
		
		addAction(userContext, retailStoreOrderShipment, tokens,"@create","createRetailStoreOrderShipment","createRetailStoreOrderShipment/","main","primary");
		addAction(userContext, retailStoreOrderShipment, tokens,"@update","updateRetailStoreOrderShipment","updateRetailStoreOrderShipment/"+retailStoreOrderShipment.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderShipment, tokens,"@copy","cloneRetailStoreOrderShipment","cloneRetailStoreOrderShipment/"+retailStoreOrderShipment.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderShipment, tokens,"retail_store_order_shipment.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderShipment.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderShipment, tokens,"retail_store_order_shipment.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderShipment.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderShipment, tokens,"retail_store_order_shipment.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderShipment.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderShipment, tokens,"retail_store_order_shipment.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderShipment.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreOrderShipment createRetailStoreOrderShipment(YoubenbenUserContext userContext, String who,Date shipTime) throws Exception
	//public RetailStoreOrderShipment createRetailStoreOrderShipment(YoubenbenUserContext userContext,String who, Date shipTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfRetailStoreOrderShipment(who);
		checkerOf(userContext).checkShipTimeOfRetailStoreOrderShipment(shipTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderShipmentManagerException.class);


		RetailStoreOrderShipment retailStoreOrderShipment=createNewRetailStoreOrderShipment();	

		retailStoreOrderShipment.setWho(who);
		retailStoreOrderShipment.setShipTime(shipTime);

		retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderShipment);
		return retailStoreOrderShipment;


	}
	protected RetailStoreOrderShipment createNewRetailStoreOrderShipment()
	{

		return new RetailStoreOrderShipment();
	}

	protected void checkParamsForUpdatingRetailStoreOrderShipment(YoubenbenUserContext userContext,String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreOrderShipment(retailStoreOrderShipmentId);
		checkerOf(userContext).checkVersionOfRetailStoreOrderShipment( retailStoreOrderShipmentVersion);
		

		if(RetailStoreOrderShipment.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfRetailStoreOrderShipment(parseString(newValueExpr));
		
			
		}
		if(RetailStoreOrderShipment.SHIP_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkShipTimeOfRetailStoreOrderShipment(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderShipmentManagerException.class);


	}



	public RetailStoreOrderShipment clone(YoubenbenUserContext userContext, String fromRetailStoreOrderShipmentId) throws Exception{

		return retailStoreOrderShipmentDaoOf(userContext).clone(fromRetailStoreOrderShipmentId, this.allTokens());
	}

	public RetailStoreOrderShipment internalSaveRetailStoreOrderShipment(YoubenbenUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment) throws Exception
	{
		return internalSaveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, allTokens());

	}
	public RetailStoreOrderShipment internalSaveRetailStoreOrderShipment(YoubenbenUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, retailStoreOrderShipmentVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreOrderShipment){
			//will be good when the retailStoreOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderShipment.
			if (retailStoreOrderShipment.isChanged()){
			
			}
			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, options);
			return retailStoreOrderShipment;

		}

	}

	public RetailStoreOrderShipment updateRetailStoreOrderShipment(YoubenbenUserContext userContext,String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, retailStoreOrderShipmentVersion, property, newValueExpr, tokensExpr);



		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());
		if(retailStoreOrderShipment.getVersion() != retailStoreOrderShipmentVersion){
			String message = "The target version("+retailStoreOrderShipment.getVersion()+") is not equals to version("+retailStoreOrderShipmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderShipment){
			//will be good when the retailStoreOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderShipment.
			
			retailStoreOrderShipment.changeProperty(property, newValueExpr);
			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().done());
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().done());
		}

	}

	public RetailStoreOrderShipment updateRetailStoreOrderShipmentProperty(YoubenbenUserContext userContext,String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, retailStoreOrderShipmentVersion, property, newValueExpr, tokensExpr);

		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());
		if(retailStoreOrderShipment.getVersion() != retailStoreOrderShipmentVersion){
			String message = "The target version("+retailStoreOrderShipment.getVersion()+") is not equals to version("+retailStoreOrderShipmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderShipment){
			//will be good when the retailStoreOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderShipment.

			retailStoreOrderShipment.changeProperty(property, newValueExpr);
			
			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().done());
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreOrderShipmentTokens tokens(){
		return RetailStoreOrderShipmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderShipmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreOrderListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderShipmentTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderShipmentId, retailStoreOrderShipmentVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion) throws Exception{

		retailStoreOrderShipmentDaoOf(userContext).delete(retailStoreOrderShipmentId, retailStoreOrderShipmentVersion);
	}

	public RetailStoreOrderShipment forgetByAll(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderShipmentId, retailStoreOrderShipmentVersion);
	}
	protected RetailStoreOrderShipment forgetByAllInternal(YoubenbenUserContext userContext,
			String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion) throws Exception{

		return retailStoreOrderShipmentDaoOf(userContext).disconnectFromAll(retailStoreOrderShipmentId, retailStoreOrderShipmentVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderShipmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return retailStoreOrderShipmentDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreOrderShipment with buyer in RetailStoreOrder
	protected RetailStoreOrderShipment breakWithRetailStoreOrderByBuyer(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String buyerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());

			synchronized(retailStoreOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderShipmentDaoOf(userContext).planToRemoveRetailStoreOrderListWithBuyer(retailStoreOrderShipment, buyerId, this.emptyOptions());

				retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderShipment;
			}
	}
	//disconnect RetailStoreOrderShipment with seller in RetailStoreOrder
	protected RetailStoreOrderShipment breakWithRetailStoreOrderBySeller(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String sellerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());

			synchronized(retailStoreOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderShipmentDaoOf(userContext).planToRemoveRetailStoreOrderListWithSeller(retailStoreOrderShipment, sellerId, this.emptyOptions());

				retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderShipment;
			}
	}
	//disconnect RetailStoreOrderShipment with confirmation in RetailStoreOrder
	protected RetailStoreOrderShipment breakWithRetailStoreOrderByConfirmation(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());

			synchronized(retailStoreOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderShipmentDaoOf(userContext).planToRemoveRetailStoreOrderListWithConfirmation(retailStoreOrderShipment, confirmationId, this.emptyOptions());

				retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderShipment;
			}
	}
	//disconnect RetailStoreOrderShipment with approval in RetailStoreOrder
	protected RetailStoreOrderShipment breakWithRetailStoreOrderByApproval(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());

			synchronized(retailStoreOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderShipmentDaoOf(userContext).planToRemoveRetailStoreOrderListWithApproval(retailStoreOrderShipment, approvalId, this.emptyOptions());

				retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderShipment;
			}
	}
	//disconnect RetailStoreOrderShipment with processing in RetailStoreOrder
	protected RetailStoreOrderShipment breakWithRetailStoreOrderByProcessing(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());

			synchronized(retailStoreOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderShipmentDaoOf(userContext).planToRemoveRetailStoreOrderListWithProcessing(retailStoreOrderShipment, processingId, this.emptyOptions());

				retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderShipment;
			}
	}
	//disconnect RetailStoreOrderShipment with picking in RetailStoreOrder
	protected RetailStoreOrderShipment breakWithRetailStoreOrderByPicking(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String pickingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());

			synchronized(retailStoreOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderShipmentDaoOf(userContext).planToRemoveRetailStoreOrderListWithPicking(retailStoreOrderShipment, pickingId, this.emptyOptions());

				retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderShipment;
			}
	}
	//disconnect RetailStoreOrderShipment with delivery in RetailStoreOrder
	protected RetailStoreOrderShipment breakWithRetailStoreOrderByDelivery(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());

			synchronized(retailStoreOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderShipmentDaoOf(userContext).planToRemoveRetailStoreOrderListWithDelivery(retailStoreOrderShipment, deliveryId, this.emptyOptions());

				retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderShipment;
			}
	}






	protected void checkParamsForAddingRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreOrderShipment(retailStoreOrderShipmentId);

		
		checkerOf(userContext).checkBuyerIdOfRetailStoreOrder(buyerId);
		
		checkerOf(userContext).checkSellerIdOfRetailStoreOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfRetailStoreOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(totalAmount);
		
		checkerOf(userContext).checkConfirmationIdOfRetailStoreOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfRetailStoreOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfRetailStoreOrder(processingId);
		
		checkerOf(userContext).checkPickingIdOfRetailStoreOrder(pickingId);
		
		checkerOf(userContext).checkDeliveryIdOfRetailStoreOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderShipmentManagerException.class);


	}
	public  RetailStoreOrderShipment addRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderShipmentId,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, deliveryId,tokensExpr);

		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, deliveryId);

		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, emptyOptions());
		synchronized(retailStoreOrderShipment){
			//Will be good when the retailStoreOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderShipment.addRetailStoreOrder( retailStoreOrder );
			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(YoubenbenUserContext userContext, String retailStoreOrderShipmentId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOrderShipment(retailStoreOrderShipmentId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(id);

		checkerOf(userContext).checkTitleOfRetailStoreOrder( title);
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderShipmentManagerException.class);

	}
	public  RetailStoreOrderShipment updateRetailStoreOrderProperties(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreOrderShipmentId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "is", id).done();

		RetailStoreOrderShipment retailStoreOrderShipmentToUpdate = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, options);

		if(retailStoreOrderShipmentToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreOrderShipmentManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreOrder item = retailStoreOrderShipmentToUpdate.getRetailStoreOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderShipmentId,name, code, used,tokensExpr);
		RetailStoreOrderShipment retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipmentToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStoreOrderShipment){
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreOrder createRetailStoreOrder(YoubenbenUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId) throws Exception{

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

	protected void checkParamsForRemovingRetailStoreOrderList(YoubenbenUserContext userContext, String retailStoreOrderShipmentId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOrderShipment(retailStoreOrderShipmentId);
		for(String retailStoreOrderIdItem: retailStoreOrderIds){
			checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderShipmentManagerException.class);

	}
	public  RetailStoreOrderShipment removeRetailStoreOrderList(YoubenbenUserContext userContext, String retailStoreOrderShipmentId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreOrderShipmentId,  retailStoreOrderIds, tokensExpr);


			RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());
			synchronized(retailStoreOrderShipment){
				//Will be good when the retailStoreOrderShipment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreOrderShipmentDaoOf(userContext).planToRemoveRetailStoreOrderList(retailStoreOrderShipment, retailStoreOrderIds, allTokens());
				retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreOrderShipment.getRetailStoreOrderList());
				return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderShipmentId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOrderShipment( retailStoreOrderShipmentId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderShipmentManagerException.class);

	}
	public  RetailStoreOrderShipment removeRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderShipmentId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderShipmentId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());
		synchronized(retailStoreOrderShipment){
			//Will be good when the retailStoreOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderShipment.removeRetailStoreOrder( retailStoreOrder );
			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderShipmentId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOrderShipment( retailStoreOrderShipmentId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderShipmentManagerException.class);

	}
	public  RetailStoreOrderShipment copyRetailStoreOrderFrom(YoubenbenUserContext userContext, String retailStoreOrderShipmentId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderShipmentId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, allTokens());
		synchronized(retailStoreOrderShipment){
			//Will be good when the retailStoreOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStoreOrder.updateLastUpdateTime(userContext.now());

			retailStoreOrderShipment.copyRetailStoreOrderFrom( retailStoreOrder );
			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, (RetailStoreOrder)retailStoreOrderShipment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreOrderShipment(retailStoreOrderShipmentId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderShipmentManagerException.class);

	}

	public  RetailStoreOrderShipment updateRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderShipmentId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "eq", retailStoreOrderId).done();



		RetailStoreOrderShipment retailStoreOrderShipment = loadRetailStoreOrderShipment(userContext, retailStoreOrderShipmentId, loadTokens);

		synchronized(retailStoreOrderShipment){
			//Will be good when the retailStoreOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderShipment.removeRetailStoreOrder( retailStoreOrder );
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);

			RetailStoreOrder retailStoreOrder = retailStoreOrderShipment.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderShipmentManagerException(retailStoreOrder+" is NOT FOUND" );
			}

			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStoreOrderShipment = saveRetailStoreOrderShipment(userContext, retailStoreOrderShipment, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderShipment, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOrderShipment newCreated) throws Exception{
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
		//   RetailStoreOrderShipment newRetailStoreOrderShipment = this.createRetailStoreOrderShipment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreOrderShipment
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreOrderShipment.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<RetailStoreOrderShipment> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String retailStoreOrderShipmentId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getRetailStoreOrderShipmentDetailScope().clone();
		RetailStoreOrderShipment merchantObj = (RetailStoreOrderShipment) this.view(userContext, retailStoreOrderShipmentId);
    String merchantObjId = retailStoreOrderShipmentId;
    String linkToUrl =	"retailStoreOrderShipmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超订单出货"+"详情";
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
				MapUtil.put("id", "3-shipTime")
				    .put("fieldName", "shipTime")
				    .put("label", "船的时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("shipTime", merchantObj.getShipTime());

		//处理 sectionList

		//处理Section：retailStoreOrderListSection
		Map retailStoreOrderListSection = ListofUtils.buildSection(
		    "retailStoreOrderListSection",
		    "零售店订购单",
		    null,
		    "",
		    "__no_group",
		    "retailStoreOrderManager/listByShipment/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreOrderListSection);

		result.put("retailStoreOrderListSection", ListofUtils.toShortList(merchantObj.getRetailStoreOrderList(), "retailStoreOrder"));
		vscope.field("retailStoreOrderListSection", YoubenbenListOfViewScope.getInstance()
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


