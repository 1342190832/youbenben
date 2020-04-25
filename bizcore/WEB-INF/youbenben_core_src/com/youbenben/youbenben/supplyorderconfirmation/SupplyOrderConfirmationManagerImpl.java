
package com.youbenben.youbenben.supplyorderconfirmation;

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






public class SupplyOrderConfirmationManagerImpl extends CustomYoubenbenCheckerManager implements SupplyOrderConfirmationManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = SupplyOrderConfirmationTokens.start().withTokenFromListName(listName).done();
		SupplyOrderConfirmation  supplyOrderConfirmation = (SupplyOrderConfirmation) this.loadSupplyOrderConfirmation(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = supplyOrderConfirmation.collectRefercencesFromLists();
		supplyOrderConfirmationDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, supplyOrderConfirmation, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new SupplyOrderConfirmationGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "SupplyOrderConfirmation";
	@Override
	public SupplyOrderConfirmationDAO daoOf(YoubenbenUserContext userContext) {
		return supplyOrderConfirmationDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws SupplyOrderConfirmationManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderConfirmationManagerException(message);

	}



 	protected SupplyOrderConfirmation saveSupplyOrderConfirmation(YoubenbenUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderConfirmationDAO().save(supplyOrderConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens);
 	}
 	
 	protected SupplyOrderConfirmation saveSupplyOrderConfirmationDetail(YoubenbenUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation) throws Exception{	

 		
 		return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, allTokens());
 	}
 	
 	public SupplyOrderConfirmation loadSupplyOrderConfirmation(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderConfirmationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderConfirmation, tokens);
 	}
 	
 	
 	 public SupplyOrderConfirmation searchSupplyOrderConfirmation(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderConfirmationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderConfirmation, tokens);
 	}
 	
 	

 	protected SupplyOrderConfirmation present(YoubenbenUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderConfirmation,tokens);
		
		
		SupplyOrderConfirmation  supplyOrderConfirmationToPresent = supplyOrderConfirmationDaoOf(userContext).present(supplyOrderConfirmation, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderConfirmationToPresent.collectRefercencesFromLists();
		supplyOrderConfirmationDaoOf(userContext).alias(entityListToNaming);
		
		return  supplyOrderConfirmationToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderConfirmation loadSupplyOrderConfirmationDetail(YoubenbenUserContext userContext, String supplyOrderConfirmationId) throws Exception{	
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, allTokens());
 		return present(userContext,supplyOrderConfirmation, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String supplyOrderConfirmationId) throws Exception{	
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, viewTokens());
 		return present(userContext,supplyOrderConfirmation, allTokens());
		
 	}
 	protected SupplyOrderConfirmation saveSupplyOrderConfirmation(YoubenbenUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object>tokens) throws Exception{	
 		return supplyOrderConfirmationDaoOf(userContext).save(supplyOrderConfirmation, tokens);
 	}
 	protected SupplyOrderConfirmation loadSupplyOrderConfirmation(YoubenbenUserContext userContext, String supplyOrderConfirmationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderConfirmationManagerException.class);

 
 		return supplyOrderConfirmationDaoOf(userContext).load(supplyOrderConfirmationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderConfirmation, tokens);
		
		addAction(userContext, supplyOrderConfirmation, tokens,"@create","createSupplyOrderConfirmation","createSupplyOrderConfirmation/","main","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"@update","updateSupplyOrderConfirmation","updateSupplyOrderConfirmation/"+supplyOrderConfirmation.getId()+"/","main","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"@copy","cloneSupplyOrderConfirmation","cloneSupplyOrderConfirmation/"+supplyOrderConfirmation.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SupplyOrderConfirmation createSupplyOrderConfirmation(YoubenbenUserContext userContext, String who,Date confirmTime) throws Exception
	//public SupplyOrderConfirmation createSupplyOrderConfirmation(YoubenbenUserContext userContext,String who, Date confirmTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfSupplyOrderConfirmation(who);
		checkerOf(userContext).checkConfirmTimeOfSupplyOrderConfirmation(confirmTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);


		SupplyOrderConfirmation supplyOrderConfirmation=createNewSupplyOrderConfirmation();	

		supplyOrderConfirmation.setWho(who);
		supplyOrderConfirmation.setConfirmTime(confirmTime);

		supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderConfirmation);
		return supplyOrderConfirmation;


	}
	protected SupplyOrderConfirmation createNewSupplyOrderConfirmation()
	{

		return new SupplyOrderConfirmation();
	}

	protected void checkParamsForUpdatingSupplyOrderConfirmation(YoubenbenUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).checkVersionOfSupplyOrderConfirmation( supplyOrderConfirmationVersion);
		

		if(SupplyOrderConfirmation.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfSupplyOrderConfirmation(parseString(newValueExpr));
		
			
		}
		if(SupplyOrderConfirmation.CONFIRM_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkConfirmTimeOfSupplyOrderConfirmation(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);


	}



	public SupplyOrderConfirmation clone(YoubenbenUserContext userContext, String fromSupplyOrderConfirmationId) throws Exception{

		return supplyOrderConfirmationDaoOf(userContext).clone(fromSupplyOrderConfirmationId, this.allTokens());
	}

	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(YoubenbenUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation) throws Exception
	{
		return internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, allTokens());

	}
	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(YoubenbenUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion, property, newValueExpr, tokensExpr);


		synchronized(supplyOrderConfirmation){
			//will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderConfirmation.
			if (supplyOrderConfirmation.isChanged()){
			
			}
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, options);
			return supplyOrderConfirmation;

		}

	}

	public SupplyOrderConfirmation updateSupplyOrderConfirmation(YoubenbenUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion, property, newValueExpr, tokensExpr);



		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		if(supplyOrderConfirmation.getVersion() != supplyOrderConfirmationVersion){
			String message = "The target version("+supplyOrderConfirmation.getVersion()+") is not equals to version("+supplyOrderConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderConfirmation){
			//will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderConfirmation.
			
			supplyOrderConfirmation.changeProperty(property, newValueExpr);
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
		}

	}

	public SupplyOrderConfirmation updateSupplyOrderConfirmationProperty(YoubenbenUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion, property, newValueExpr, tokensExpr);

		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		if(supplyOrderConfirmation.getVersion() != supplyOrderConfirmationVersion){
			String message = "The target version("+supplyOrderConfirmation.getVersion()+") is not equals to version("+supplyOrderConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderConfirmation){
			//will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderConfirmation.

			supplyOrderConfirmation.changeProperty(property, newValueExpr);
			
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SupplyOrderConfirmationTokens tokens(){
		return SupplyOrderConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderConfirmationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderConfirmationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception{

		supplyOrderConfirmationDaoOf(userContext).delete(supplyOrderConfirmationId, supplyOrderConfirmationVersion);
	}

	public SupplyOrderConfirmation forgetByAll(YoubenbenUserContext userContext, String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion);
	}
	protected SupplyOrderConfirmation forgetByAllInternal(YoubenbenUserContext userContext,
			String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception{

		return supplyOrderConfirmationDaoOf(userContext).disconnectFromAll(supplyOrderConfirmationId, supplyOrderConfirmationVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return supplyOrderConfirmationDaoOf(userContext).deleteAll();
	}


	//disconnect SupplyOrderConfirmation with consumer in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByConsumer(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String consumerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithConsumer(supplyOrderConfirmation, consumerId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with approval in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByApproval(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithApproval(supplyOrderConfirmation, approvalId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with processing in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByProcessing(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithProcessing(supplyOrderConfirmation, processingId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with shipment in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByShipment(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithShipment(supplyOrderConfirmation, shipmentId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with delivery in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByDelivery(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithDelivery(supplyOrderConfirmation, deliveryId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with store in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByStore(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String storeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithStore(supplyOrderConfirmation, storeId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with buyer in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByBuyer(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String buyerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithBuyer(supplyOrderConfirmation, buyerId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with seller in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderBySeller(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String sellerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithSeller(supplyOrderConfirmation, sellerId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with approval in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByApproval(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithApproval(supplyOrderConfirmation, approvalId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with processing in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByProcessing(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithProcessing(supplyOrderConfirmation, processingId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with picking in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByPicking(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String pickingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithPicking(supplyOrderConfirmation, pickingId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with shipment in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByShipment(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithShipment(supplyOrderConfirmation, shipmentId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with delivery in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByDelivery(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithDelivery(supplyOrderConfirmation, deliveryId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}






	protected void checkParamsForAddingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);

		
		checkerOf(userContext).checkTitleOfConsumerOrder(title);
		
		checkerOf(userContext).checkConsumerIdOfConsumerOrder(consumerId);
		
		checkerOf(userContext).checkApprovalIdOfConsumerOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfConsumerOrder(processingId);
		
		checkerOf(userContext).checkShipmentIdOfConsumerOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfConsumerOrder(deliveryId);
		
		checkerOf(userContext).checkStoreIdOfConsumerOrder(storeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);


	}
	public  SupplyOrderConfirmation addConsumerOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingConsumerOrder(userContext,supplyOrderConfirmationId,title, consumerId, approvalId, processingId, shipmentId, deliveryId, storeId,tokensExpr);

		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, approvalId, processingId, shipmentId, deliveryId, storeId);

		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, emptyOptions());
		synchronized(supplyOrderConfirmation){
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.addConsumerOrder( consumerOrder );
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(YoubenbenUserContext userContext, String supplyOrderConfirmationId,String id,String title,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfConsumerOrder(id);

		checkerOf(userContext).checkTitleOfConsumerOrder( title);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	}
	public  SupplyOrderConfirmation updateConsumerOrderProperties(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String id,String title, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderConfirmationId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();

		SupplyOrderConfirmation supplyOrderConfirmationToUpdate = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);

		if(supplyOrderConfirmationToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderConfirmationManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrder item = supplyOrderConfirmationToUpdate.getConsumerOrderList().first();

		item.updateTitle( title );


		//checkParamsForAddingConsumerOrder(userContext,supplyOrderConfirmationId,name, code, used,tokensExpr);
		SupplyOrderConfirmation supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmationToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderConfirmation){
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
	}


	protected ConsumerOrder createConsumerOrder(YoubenbenUserContext userContext, String title, String consumerId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStoreMember  consumer = new RetailStoreMember();
		consumer.setId(consumerId);		
		consumerOrder.setConsumer(consumer);		
		SupplyOrderApproval  approval = new SupplyOrderApproval();
		approval.setId(approvalId);		
		consumerOrder.setApproval(approval);		
		SupplyOrderProcessing  processing = new SupplyOrderProcessing();
		processing.setId(processingId);		
		consumerOrder.setProcessing(processing);		
		SupplyOrderShipment  shipment = new SupplyOrderShipment();
		shipment.setId(shipmentId);		
		consumerOrder.setShipment(shipment);		
		SupplyOrderDelivery  delivery = new SupplyOrderDelivery();
		delivery.setId(deliveryId);		
		consumerOrder.setDelivery(delivery);		
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

	protected void checkParamsForRemovingConsumerOrderList(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		for(String consumerOrderIdItem: consumerOrderIds){
			checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	}
	public  SupplyOrderConfirmation removeConsumerOrderList(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderConfirmationId,  consumerOrderIds, tokensExpr);


			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
			synchronized(supplyOrderConfirmation){
				//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderList(supplyOrderConfirmation, consumerOrderIds, allTokens());
				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderConfirmation.getConsumerOrderList());
				return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	}
	public  SupplyOrderConfirmation removeConsumerOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrder(userContext,supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.removeConsumerOrder( consumerOrder );
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	}
	public  SupplyOrderConfirmation copyConsumerOrderFrom(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrder(userContext,supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			consumerOrder.updateLastUpdateTime(userContext.now());

			supplyOrderConfirmation.copyConsumerOrderFrom( consumerOrder );
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderConfirmation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	}

	public  SupplyOrderConfirmation updateConsumerOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();



		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, loadTokens);

		synchronized(supplyOrderConfirmation){
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderConfirmation.removeConsumerOrder( consumerOrder );
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);

			ConsumerOrder consumerOrder = supplyOrderConfirmation.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderConfirmationManagerException(consumerOrder+" is NOT FOUND" );
			}

			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);

		
		checkerOf(userContext).checkBuyerIdOfSupplyOrder(buyerId);
		
		checkerOf(userContext).checkSellerIdOfSupplyOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfSupplyOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfSupplyOrder(totalAmount);
		
		checkerOf(userContext).checkApprovalIdOfSupplyOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfSupplyOrder(processingId);
		
		checkerOf(userContext).checkPickingIdOfSupplyOrder(pickingId);
		
		checkerOf(userContext).checkShipmentIdOfSupplyOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfSupplyOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);


	}
	public  SupplyOrderConfirmation addSupplyOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSupplyOrder(userContext,supplyOrderConfirmationId,buyerId, sellerId, title, totalAmount, approvalId, processingId, pickingId, shipmentId, deliveryId,tokensExpr);

		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount, approvalId, processingId, pickingId, shipmentId, deliveryId);

		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, emptyOptions());
		synchronized(supplyOrderConfirmation){
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.addSupplyOrder( supplyOrder );
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(YoubenbenUserContext userContext, String supplyOrderConfirmationId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfSupplyOrder(id);

		checkerOf(userContext).checkTitleOfSupplyOrder( title);
		checkerOf(userContext).checkTotalAmountOfSupplyOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	}
	public  SupplyOrderConfirmation updateSupplyOrderProperties(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderConfirmationId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();

		SupplyOrderConfirmation supplyOrderConfirmationToUpdate = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);

		if(supplyOrderConfirmationToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderConfirmationManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}

		SupplyOrder item = supplyOrderConfirmationToUpdate.getSupplyOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingSupplyOrder(userContext,supplyOrderConfirmationId,name, code, used,tokensExpr);
		SupplyOrderConfirmation supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmationToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderConfirmation){
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
	}


	protected SupplyOrder createSupplyOrder(YoubenbenUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId) throws Exception{

		SupplyOrder supplyOrder = new SupplyOrder();
		
		
		RetailStoreCountryCenter  buyer = new RetailStoreCountryCenter();
		buyer.setId(buyerId);		
		supplyOrder.setBuyer(buyer);		
		GoodsSupplier  seller = new GoodsSupplier();
		seller.setId(sellerId);		
		supplyOrder.setSeller(seller);		
		supplyOrder.setTitle(title);		
		supplyOrder.setTotalAmount(totalAmount);		
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
		SupplyOrderDelivery  delivery = new SupplyOrderDelivery();
		delivery.setId(deliveryId);		
		supplyOrder.setDelivery(delivery);		
		supplyOrder.setLastUpdateTime(userContext.now());
	
		
		return supplyOrder;


	}

	protected SupplyOrder createIndexedSupplyOrder(String id, int version){

		SupplyOrder supplyOrder = new SupplyOrder();
		supplyOrder.setId(id);
		supplyOrder.setVersion(version);
		return supplyOrder;

	}

	protected void checkParamsForRemovingSupplyOrderList(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		for(String supplyOrderIdItem: supplyOrderIds){
			checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	}
	public  SupplyOrderConfirmation removeSupplyOrderList(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderConfirmationId,  supplyOrderIds, tokensExpr);


			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
			synchronized(supplyOrderConfirmation){
				//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderList(supplyOrderConfirmation, supplyOrderIds, allTokens());
				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderConfirmation.getSupplyOrderList());
				return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	}
	public  SupplyOrderConfirmation removeSupplyOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSupplyOrder(userContext,supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.removeSupplyOrder( supplyOrder );
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	}
	public  SupplyOrderConfirmation copySupplyOrderFrom(YoubenbenUserContext userContext, String supplyOrderConfirmationId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSupplyOrder(userContext,supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			supplyOrder.updateLastUpdateTime(userContext.now());

			supplyOrderConfirmation.copySupplyOrderFrom( supplyOrder );
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderConfirmation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfSupplyOrder(parseString(newValueExpr));
		
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	}

	public  SupplyOrderConfirmation updateSupplyOrder(YoubenbenUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();



		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, loadTokens);

		synchronized(supplyOrderConfirmation){
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderConfirmation.removeSupplyOrder( supplyOrder );
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);

			SupplyOrder supplyOrder = supplyOrderConfirmation.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderConfirmationManagerException(supplyOrder+" is NOT FOUND" );
			}

			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderConfirmation newCreated) throws Exception{
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
		//   SupplyOrderConfirmation newSupplyOrderConfirmation = this.createSupplyOrderConfirmation(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSupplyOrderConfirmation
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, SupplyOrderConfirmation.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<SupplyOrderConfirmation> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String supplyOrderConfirmationId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getSupplyOrderConfirmationDetailScope().clone();
		SupplyOrderConfirmation merchantObj = (SupplyOrderConfirmation) this.view(userContext, supplyOrderConfirmationId);
    String merchantObjId = supplyOrderConfirmationId;
    String linkToUrl =	"supplyOrderConfirmationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "供应订单确认"+"详情";
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
				MapUtil.put("id", "3-confirmTime")
				    .put("fieldName", "confirmTime")
				    .put("label", "确认时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("confirmTime", merchantObj.getConfirmTime());

		//处理 sectionList

		//处理Section：consumerOrderListSection
		Map consumerOrderListSection = ListofUtils.buildSection(
		    "consumerOrderListSection",
		    "消费者的订单列表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderManager/listByConfirmation/"+merchantObjId+"/",
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
		    "supplyOrderManager/listByConfirmation/"+merchantObjId+"/",
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


