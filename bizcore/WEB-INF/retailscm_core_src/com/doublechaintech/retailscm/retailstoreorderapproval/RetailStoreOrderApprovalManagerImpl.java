
package com.doublechaintech.retailscm.retailstoreorderapproval;

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






public class RetailStoreOrderApprovalManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderApprovalManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreOrderApprovalTokens.start().withTokenFromListName(listName).done();
		RetailStoreOrderApproval  retailStoreOrderApproval = (RetailStoreOrderApproval) this.loadRetailStoreOrderApproval(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreOrderApproval.collectRefercencesFromLists();
		retailStoreOrderApprovalDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreOrderApproval, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreOrderApprovalGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreOrderApproval";
	@Override
	public RetailStoreOrderApprovalDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreOrderApprovalDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderApprovalManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderApprovalManagerException(message);

	}



 	protected RetailStoreOrderApproval saveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderApprovalDAO().save(retailStoreOrderApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens);
 	}
 	
 	protected RetailStoreOrderApproval saveRetailStoreOrderApprovalDetail(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval) throws Exception{	

 		
 		return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, allTokens());
 	}
 	
 	public RetailStoreOrderApproval loadRetailStoreOrderApproval(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderApprovalManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval( userContext, retailStoreOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderApproval, tokens);
 	}
 	
 	
 	 public RetailStoreOrderApproval searchRetailStoreOrderApproval(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderApprovalManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval( userContext, retailStoreOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderApproval, tokens);
 	}
 	
 	

 	protected RetailStoreOrderApproval present(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderApproval,tokens);
		
		
		RetailStoreOrderApproval  retailStoreOrderApprovalToPresent = retailStoreOrderApprovalDaoOf(userContext).present(retailStoreOrderApproval, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderApprovalToPresent.collectRefercencesFromLists();
		retailStoreOrderApprovalDaoOf(userContext).alias(entityListToNaming);
		
		return  retailStoreOrderApprovalToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderApproval loadRetailStoreOrderApprovalDetail(RetailscmUserContext userContext, String retailStoreOrderApprovalId) throws Exception{	
 		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval( userContext, retailStoreOrderApprovalId, allTokens());
 		return present(userContext,retailStoreOrderApproval, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderApprovalId) throws Exception{	
 		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval( userContext, retailStoreOrderApprovalId, viewTokens());
 		return present(userContext,retailStoreOrderApproval, allTokens());
		
 	}
 	protected RetailStoreOrderApproval saveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object>tokens) throws Exception{	
 		return retailStoreOrderApprovalDaoOf(userContext).save(retailStoreOrderApproval, tokens);
 	}
 	protected RetailStoreOrderApproval loadRetailStoreOrderApproval(RetailscmUserContext userContext, String retailStoreOrderApprovalId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderApprovalManagerException.class);

 
 		return retailStoreOrderApprovalDaoOf(userContext).load(retailStoreOrderApprovalId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderApproval, tokens);
		
		addAction(userContext, retailStoreOrderApproval, tokens,"@create","createRetailStoreOrderApproval","createRetailStoreOrderApproval/","main","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"@update","updateRetailStoreOrderApproval","updateRetailStoreOrderApproval/"+retailStoreOrderApproval.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"@copy","cloneRetailStoreOrderApproval","cloneRetailStoreOrderApproval/"+retailStoreOrderApproval.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreOrderApproval createRetailStoreOrderApproval(RetailscmUserContext userContext, String who,Date approveTime) throws Exception
	//public RetailStoreOrderApproval createRetailStoreOrderApproval(RetailscmUserContext userContext,String who, Date approveTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfRetailStoreOrderApproval(who);
		checkerOf(userContext).checkApproveTimeOfRetailStoreOrderApproval(approveTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);


		RetailStoreOrderApproval retailStoreOrderApproval=createNewRetailStoreOrderApproval();	

		retailStoreOrderApproval.setWho(who);
		retailStoreOrderApproval.setApproveTime(approveTime);

		retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderApproval);
		return retailStoreOrderApproval;


	}
	protected RetailStoreOrderApproval createNewRetailStoreOrderApproval()
	{

		return new RetailStoreOrderApproval();
	}

	protected void checkParamsForUpdatingRetailStoreOrderApproval(RetailscmUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		checkerOf(userContext).checkVersionOfRetailStoreOrderApproval( retailStoreOrderApprovalVersion);
		

		if(RetailStoreOrderApproval.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfRetailStoreOrderApproval(parseString(newValueExpr));
		
			
		}
		if(RetailStoreOrderApproval.APPROVE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkApproveTimeOfRetailStoreOrderApproval(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);


	}



	public RetailStoreOrderApproval clone(RetailscmUserContext userContext, String fromRetailStoreOrderApprovalId) throws Exception{

		return retailStoreOrderApprovalDaoOf(userContext).clone(fromRetailStoreOrderApprovalId, this.allTokens());
	}

	public RetailStoreOrderApproval internalSaveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval) throws Exception
	{
		return internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, allTokens());

	}
	public RetailStoreOrderApproval internalSaveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreOrderApproval){
			//will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderApproval.
			if (retailStoreOrderApproval.isChanged()){
			
			}
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, options);
			return retailStoreOrderApproval;

		}

	}

	public RetailStoreOrderApproval updateRetailStoreOrderApproval(RetailscmUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion, property, newValueExpr, tokensExpr);



		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		if(retailStoreOrderApproval.getVersion() != retailStoreOrderApprovalVersion){
			String message = "The target version("+retailStoreOrderApproval.getVersion()+") is not equals to version("+retailStoreOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderApproval){
			//will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderApproval.
			
			retailStoreOrderApproval.changeProperty(property, newValueExpr);
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().done());
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().done());
		}

	}

	public RetailStoreOrderApproval updateRetailStoreOrderApprovalProperty(RetailscmUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion, property, newValueExpr, tokensExpr);

		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		if(retailStoreOrderApproval.getVersion() != retailStoreOrderApprovalVersion){
			String message = "The target version("+retailStoreOrderApproval.getVersion()+") is not equals to version("+retailStoreOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderApproval){
			//will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderApproval.

			retailStoreOrderApproval.changeProperty(property, newValueExpr);
			
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().done());
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreOrderApprovalTokens tokens(){
		return RetailStoreOrderApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderApprovalTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreOrderListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderApprovalTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion) throws Exception{

		retailStoreOrderApprovalDaoOf(userContext).delete(retailStoreOrderApprovalId, retailStoreOrderApprovalVersion);
	}

	public RetailStoreOrderApproval forgetByAll(RetailscmUserContext userContext, String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion);
	}
	protected RetailStoreOrderApproval forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion) throws Exception{

		return retailStoreOrderApprovalDaoOf(userContext).disconnectFromAll(retailStoreOrderApprovalId, retailStoreOrderApprovalVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreOrderApprovalDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreOrderApproval with buyer in RetailStoreOrder
	protected RetailStoreOrderApproval breakWithRetailStoreOrderByBuyer(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String buyerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());

			synchronized(retailStoreOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderApprovalDaoOf(userContext).planToRemoveRetailStoreOrderListWithBuyer(retailStoreOrderApproval, buyerId, this.emptyOptions());

				retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderApproval;
			}
	}
	//disconnect RetailStoreOrderApproval with seller in RetailStoreOrder
	protected RetailStoreOrderApproval breakWithRetailStoreOrderBySeller(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String sellerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());

			synchronized(retailStoreOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderApprovalDaoOf(userContext).planToRemoveRetailStoreOrderListWithSeller(retailStoreOrderApproval, sellerId, this.emptyOptions());

				retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderApproval;
			}
	}
	//disconnect RetailStoreOrderApproval with confirmation in RetailStoreOrder
	protected RetailStoreOrderApproval breakWithRetailStoreOrderByConfirmation(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());

			synchronized(retailStoreOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderApprovalDaoOf(userContext).planToRemoveRetailStoreOrderListWithConfirmation(retailStoreOrderApproval, confirmationId, this.emptyOptions());

				retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderApproval;
			}
	}
	//disconnect RetailStoreOrderApproval with processing in RetailStoreOrder
	protected RetailStoreOrderApproval breakWithRetailStoreOrderByProcessing(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());

			synchronized(retailStoreOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderApprovalDaoOf(userContext).planToRemoveRetailStoreOrderListWithProcessing(retailStoreOrderApproval, processingId, this.emptyOptions());

				retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderApproval;
			}
	}
	//disconnect RetailStoreOrderApproval with picking in RetailStoreOrder
	protected RetailStoreOrderApproval breakWithRetailStoreOrderByPicking(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String pickingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());

			synchronized(retailStoreOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderApprovalDaoOf(userContext).planToRemoveRetailStoreOrderListWithPicking(retailStoreOrderApproval, pickingId, this.emptyOptions());

				retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderApproval;
			}
	}
	//disconnect RetailStoreOrderApproval with shipment in RetailStoreOrder
	protected RetailStoreOrderApproval breakWithRetailStoreOrderByShipment(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());

			synchronized(retailStoreOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderApprovalDaoOf(userContext).planToRemoveRetailStoreOrderListWithShipment(retailStoreOrderApproval, shipmentId, this.emptyOptions());

				retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderApproval;
			}
	}
	//disconnect RetailStoreOrderApproval with delivery in RetailStoreOrder
	protected RetailStoreOrderApproval breakWithRetailStoreOrderByDelivery(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());

			synchronized(retailStoreOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreOrderApprovalDaoOf(userContext).planToRemoveRetailStoreOrderListWithDelivery(retailStoreOrderApproval, deliveryId, this.emptyOptions());

				retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderApproval;
			}
	}






	protected void checkParamsForAddingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);

		
		checkerOf(userContext).checkBuyerIdOfRetailStoreOrder(buyerId);
		
		checkerOf(userContext).checkSellerIdOfRetailStoreOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfRetailStoreOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(totalAmount);
		
		checkerOf(userContext).checkConfirmationIdOfRetailStoreOrder(confirmationId);
		
		checkerOf(userContext).checkProcessingIdOfRetailStoreOrder(processingId);
		
		checkerOf(userContext).checkPickingIdOfRetailStoreOrder(pickingId);
		
		checkerOf(userContext).checkShipmentIdOfRetailStoreOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfRetailStoreOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);


	}
	public  RetailStoreOrderApproval addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderApprovalId,buyerId, sellerId, title, totalAmount, confirmationId, processingId, pickingId, shipmentId, deliveryId,tokensExpr);

		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount, confirmationId, processingId, pickingId, shipmentId, deliveryId);

		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, emptyOptions());
		synchronized(retailStoreOrderApproval){
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderApproval.addRetailStoreOrder( retailStoreOrder );
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderApprovalId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(id);

		checkerOf(userContext).checkTitleOfRetailStoreOrder( title);
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);

	}
	public  RetailStoreOrderApproval updateRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreOrderApprovalId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "is", id).done();

		RetailStoreOrderApproval retailStoreOrderApprovalToUpdate = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);

		if(retailStoreOrderApprovalToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreOrderApprovalManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreOrder item = retailStoreOrderApprovalToUpdate.getRetailStoreOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderApprovalId,name, code, used,tokensExpr);
		RetailStoreOrderApproval retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApprovalToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStoreOrderApproval){
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreOrder createRetailStoreOrder(RetailscmUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId) throws Exception{

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
		RetailStoreOrderProcessing  processing = new RetailStoreOrderProcessing();
		processing.setId(processingId);		
		retailStoreOrder.setProcessing(processing);		
		RetailStoreOrderPicking  picking = new RetailStoreOrderPicking();
		picking.setId(pickingId);		
		retailStoreOrder.setPicking(picking);		
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

	protected void checkParamsForRemovingRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderApprovalId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		for(String retailStoreOrderIdItem: retailStoreOrderIds){
			checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);

	}
	public  RetailStoreOrderApproval removeRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderApprovalId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreOrderApprovalId,  retailStoreOrderIds, tokensExpr);


			RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
			synchronized(retailStoreOrderApproval){
				//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreOrderApprovalDaoOf(userContext).planToRemoveRetailStoreOrderList(retailStoreOrderApproval, retailStoreOrderIds, allTokens());
				retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreOrderApproval.getRetailStoreOrderList());
				return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOrderApproval( retailStoreOrderApprovalId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);

	}
	public  RetailStoreOrderApproval removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderApprovalId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		synchronized(retailStoreOrderApproval){
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderApproval.removeRetailStoreOrder( retailStoreOrder );
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOrderApproval( retailStoreOrderApprovalId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);

	}
	public  RetailStoreOrderApproval copyRetailStoreOrderFrom(RetailscmUserContext userContext, String retailStoreOrderApprovalId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderApprovalId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		synchronized(retailStoreOrderApproval){
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStoreOrder.updateLastUpdateTime(userContext.now());

			retailStoreOrderApproval.copyRetailStoreOrderFrom( retailStoreOrder );
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, (RetailStoreOrder)retailStoreOrderApproval.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);

	}

	public  RetailStoreOrderApproval updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderApprovalId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "eq", retailStoreOrderId).done();



		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, loadTokens);

		synchronized(retailStoreOrderApproval){
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderApproval.removeRetailStoreOrder( retailStoreOrder );
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);

			RetailStoreOrder retailStoreOrder = retailStoreOrderApproval.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderApprovalManagerException(retailStoreOrder+" is NOT FOUND" );
			}

			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderApproval newCreated) throws Exception{
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
		//   RetailStoreOrderApproval newRetailStoreOrderApproval = this.createRetailStoreOrderApproval(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreOrderApproval
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreOrderApproval.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreOrderApproval> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreOrderApprovalId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreOrderApprovalDetailScope().clone();
		RetailStoreOrderApproval merchantObj = (RetailStoreOrderApproval) this.view(userContext, retailStoreOrderApprovalId);
    String merchantObjId = retailStoreOrderApprovalId;
    String linkToUrl =	"retailStoreOrderApprovalManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超订单批准"+"详情";
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
				MapUtil.put("id", "3-approveTime")
				    .put("fieldName", "approveTime")
				    .put("label", "批准时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("approveTime", merchantObj.getApproveTime());

		//处理 sectionList

		//处理Section：retailStoreOrderListSection
		Map retailStoreOrderListSection = ListofUtils.buildSection(
		    "retailStoreOrderListSection",
		    "零售店订购单",
		    null,
		    "",
		    "__no_group",
		    "retailStoreOrderManager/listByApproval/"+merchantObjId+"/",
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


