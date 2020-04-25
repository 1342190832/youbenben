
package com.youbenben.youbenben.supplyordershipment;

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






public class SupplyOrderShipmentManagerImpl extends CustomYoubenbenCheckerManager implements SupplyOrderShipmentManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = SupplyOrderShipmentTokens.start().withTokenFromListName(listName).done();
		SupplyOrderShipment  supplyOrderShipment = (SupplyOrderShipment) this.loadSupplyOrderShipment(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = supplyOrderShipment.collectRefercencesFromLists();
		supplyOrderShipmentDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, supplyOrderShipment, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new SupplyOrderShipmentGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "SupplyOrderShipment";
	@Override
	public SupplyOrderShipmentDAO daoOf(YoubenbenUserContext userContext) {
		return supplyOrderShipmentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws SupplyOrderShipmentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderShipmentManagerException(message);

	}



 	protected SupplyOrderShipment saveSupplyOrderShipment(YoubenbenUserContext userContext, SupplyOrderShipment supplyOrderShipment, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderShipmentDAO().save(supplyOrderShipment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens);
 	}
 	
 	protected SupplyOrderShipment saveSupplyOrderShipmentDetail(YoubenbenUserContext userContext, SupplyOrderShipment supplyOrderShipment) throws Exception{	

 		
 		return saveSupplyOrderShipment(userContext, supplyOrderShipment, allTokens());
 	}
 	
 	public SupplyOrderShipment loadSupplyOrderShipment(YoubenbenUserContext userContext, String supplyOrderShipmentId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderShipmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment( userContext, supplyOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderShipment, tokens);
 	}
 	
 	
 	 public SupplyOrderShipment searchSupplyOrderShipment(YoubenbenUserContext userContext, String supplyOrderShipmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderShipmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment( userContext, supplyOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderShipment, tokens);
 	}
 	
 	

 	protected SupplyOrderShipment present(YoubenbenUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderShipment,tokens);
		
		
		SupplyOrderShipment  supplyOrderShipmentToPresent = supplyOrderShipmentDaoOf(userContext).present(supplyOrderShipment, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderShipmentToPresent.collectRefercencesFromLists();
		supplyOrderShipmentDaoOf(userContext).alias(entityListToNaming);
		
		return  supplyOrderShipmentToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderShipment loadSupplyOrderShipmentDetail(YoubenbenUserContext userContext, String supplyOrderShipmentId) throws Exception{	
 		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment( userContext, supplyOrderShipmentId, allTokens());
 		return present(userContext,supplyOrderShipment, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String supplyOrderShipmentId) throws Exception{	
 		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment( userContext, supplyOrderShipmentId, viewTokens());
 		return present(userContext,supplyOrderShipment, allTokens());
		
 	}
 	protected SupplyOrderShipment saveSupplyOrderShipment(YoubenbenUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String,Object>tokens) throws Exception{	
 		return supplyOrderShipmentDaoOf(userContext).save(supplyOrderShipment, tokens);
 	}
 	protected SupplyOrderShipment loadSupplyOrderShipment(YoubenbenUserContext userContext, String supplyOrderShipmentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderShipmentManagerException.class);

 
 		return supplyOrderShipmentDaoOf(userContext).load(supplyOrderShipmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderShipment, tokens);
		
		addAction(userContext, supplyOrderShipment, tokens,"@create","createSupplyOrderShipment","createSupplyOrderShipment/","main","primary");
		addAction(userContext, supplyOrderShipment, tokens,"@update","updateSupplyOrderShipment","updateSupplyOrderShipment/"+supplyOrderShipment.getId()+"/","main","primary");
		addAction(userContext, supplyOrderShipment, tokens,"@copy","cloneSupplyOrderShipment","cloneSupplyOrderShipment/"+supplyOrderShipment.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SupplyOrderShipment createSupplyOrderShipment(YoubenbenUserContext userContext, String who,Date shipTime) throws Exception
	//public SupplyOrderShipment createSupplyOrderShipment(YoubenbenUserContext userContext,String who, Date shipTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfSupplyOrderShipment(who);
		checkerOf(userContext).checkShipTimeOfSupplyOrderShipment(shipTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);


		SupplyOrderShipment supplyOrderShipment=createNewSupplyOrderShipment();	

		supplyOrderShipment.setWho(who);
		supplyOrderShipment.setShipTime(shipTime);

		supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderShipment);
		return supplyOrderShipment;


	}
	protected SupplyOrderShipment createNewSupplyOrderShipment()
	{

		return new SupplyOrderShipment();
	}

	protected void checkParamsForUpdatingSupplyOrderShipment(YoubenbenUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		checkerOf(userContext).checkVersionOfSupplyOrderShipment( supplyOrderShipmentVersion);
		

		if(SupplyOrderShipment.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfSupplyOrderShipment(parseString(newValueExpr));
		
			
		}
		if(SupplyOrderShipment.SHIP_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkShipTimeOfSupplyOrderShipment(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);


	}



	public SupplyOrderShipment clone(YoubenbenUserContext userContext, String fromSupplyOrderShipmentId) throws Exception{

		return supplyOrderShipmentDaoOf(userContext).clone(fromSupplyOrderShipmentId, this.allTokens());
	}

	public SupplyOrderShipment internalSaveSupplyOrderShipment(YoubenbenUserContext userContext, SupplyOrderShipment supplyOrderShipment) throws Exception
	{
		return internalSaveSupplyOrderShipment(userContext, supplyOrderShipment, allTokens());

	}
	public SupplyOrderShipment internalSaveSupplyOrderShipment(YoubenbenUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSupplyOrderShipment(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion, property, newValueExpr, tokensExpr);


		synchronized(supplyOrderShipment){
			//will be good when the supplyOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderShipment.
			if (supplyOrderShipment.isChanged()){
			
			}
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, options);
			return supplyOrderShipment;

		}

	}

	public SupplyOrderShipment updateSupplyOrderShipment(YoubenbenUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderShipment(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion, property, newValueExpr, tokensExpr);



		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		if(supplyOrderShipment.getVersion() != supplyOrderShipmentVersion){
			String message = "The target version("+supplyOrderShipment.getVersion()+") is not equals to version("+supplyOrderShipmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderShipment){
			//will be good when the supplyOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderShipment.
			
			supplyOrderShipment.changeProperty(property, newValueExpr);
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().done());
		}

	}

	public SupplyOrderShipment updateSupplyOrderShipmentProperty(YoubenbenUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderShipment(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion, property, newValueExpr, tokensExpr);

		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		if(supplyOrderShipment.getVersion() != supplyOrderShipmentVersion){
			String message = "The target version("+supplyOrderShipment.getVersion()+") is not equals to version("+supplyOrderShipmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderShipment){
			//will be good when the supplyOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderShipment.

			supplyOrderShipment.changeProperty(property, newValueExpr);
			
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SupplyOrderShipmentTokens tokens(){
		return SupplyOrderShipmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderShipmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderShipmentTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String supplyOrderShipmentId, int supplyOrderShipmentVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String supplyOrderShipmentId, int supplyOrderShipmentVersion) throws Exception{

		supplyOrderShipmentDaoOf(userContext).delete(supplyOrderShipmentId, supplyOrderShipmentVersion);
	}

	public SupplyOrderShipment forgetByAll(YoubenbenUserContext userContext, String supplyOrderShipmentId, int supplyOrderShipmentVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion);
	}
	protected SupplyOrderShipment forgetByAllInternal(YoubenbenUserContext userContext,
			String supplyOrderShipmentId, int supplyOrderShipmentVersion) throws Exception{

		return supplyOrderShipmentDaoOf(userContext).disconnectFromAll(supplyOrderShipmentId, supplyOrderShipmentVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderShipmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return supplyOrderShipmentDaoOf(userContext).deleteAll();
	}


	//disconnect SupplyOrderShipment with consumer in ConsumerOrder
	protected SupplyOrderShipment breakWithConsumerOrderByConsumer(YoubenbenUserContext userContext, String supplyOrderShipmentId, String consumerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveConsumerOrderListWithConsumer(supplyOrderShipment, consumerId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with confirmation in ConsumerOrder
	protected SupplyOrderShipment breakWithConsumerOrderByConfirmation(YoubenbenUserContext userContext, String supplyOrderShipmentId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveConsumerOrderListWithConfirmation(supplyOrderShipment, confirmationId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with approval in ConsumerOrder
	protected SupplyOrderShipment breakWithConsumerOrderByApproval(YoubenbenUserContext userContext, String supplyOrderShipmentId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveConsumerOrderListWithApproval(supplyOrderShipment, approvalId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with processing in ConsumerOrder
	protected SupplyOrderShipment breakWithConsumerOrderByProcessing(YoubenbenUserContext userContext, String supplyOrderShipmentId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveConsumerOrderListWithProcessing(supplyOrderShipment, processingId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with delivery in ConsumerOrder
	protected SupplyOrderShipment breakWithConsumerOrderByDelivery(YoubenbenUserContext userContext, String supplyOrderShipmentId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveConsumerOrderListWithDelivery(supplyOrderShipment, deliveryId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with store in ConsumerOrder
	protected SupplyOrderShipment breakWithConsumerOrderByStore(YoubenbenUserContext userContext, String supplyOrderShipmentId, String storeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveConsumerOrderListWithStore(supplyOrderShipment, storeId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with buyer in SupplyOrder
	protected SupplyOrderShipment breakWithSupplyOrderByBuyer(YoubenbenUserContext userContext, String supplyOrderShipmentId, String buyerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveSupplyOrderListWithBuyer(supplyOrderShipment, buyerId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with seller in SupplyOrder
	protected SupplyOrderShipment breakWithSupplyOrderBySeller(YoubenbenUserContext userContext, String supplyOrderShipmentId, String sellerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveSupplyOrderListWithSeller(supplyOrderShipment, sellerId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with confirmation in SupplyOrder
	protected SupplyOrderShipment breakWithSupplyOrderByConfirmation(YoubenbenUserContext userContext, String supplyOrderShipmentId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveSupplyOrderListWithConfirmation(supplyOrderShipment, confirmationId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with approval in SupplyOrder
	protected SupplyOrderShipment breakWithSupplyOrderByApproval(YoubenbenUserContext userContext, String supplyOrderShipmentId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveSupplyOrderListWithApproval(supplyOrderShipment, approvalId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with processing in SupplyOrder
	protected SupplyOrderShipment breakWithSupplyOrderByProcessing(YoubenbenUserContext userContext, String supplyOrderShipmentId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveSupplyOrderListWithProcessing(supplyOrderShipment, processingId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with picking in SupplyOrder
	protected SupplyOrderShipment breakWithSupplyOrderByPicking(YoubenbenUserContext userContext, String supplyOrderShipmentId, String pickingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveSupplyOrderListWithPicking(supplyOrderShipment, pickingId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with delivery in SupplyOrder
	protected SupplyOrderShipment breakWithSupplyOrderByDelivery(YoubenbenUserContext userContext, String supplyOrderShipmentId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderShipmentDaoOf(userContext).planToRemoveSupplyOrderListWithDelivery(supplyOrderShipment, deliveryId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
				return supplyOrderShipment;
			}
	}






	protected void checkParamsForAddingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String deliveryId, String storeId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);

		
		checkerOf(userContext).checkTitleOfConsumerOrder(title);
		
		checkerOf(userContext).checkConsumerIdOfConsumerOrder(consumerId);
		
		checkerOf(userContext).checkConfirmationIdOfConsumerOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfConsumerOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfConsumerOrder(processingId);
		
		checkerOf(userContext).checkDeliveryIdOfConsumerOrder(deliveryId);
		
		checkerOf(userContext).checkStoreIdOfConsumerOrder(storeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);


	}
	public  SupplyOrderShipment addConsumerOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String deliveryId, String storeId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingConsumerOrder(userContext,supplyOrderShipmentId,title, consumerId, confirmationId, approvalId, processingId, deliveryId, storeId,tokensExpr);

		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, confirmationId, approvalId, processingId, deliveryId, storeId);

		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, emptyOptions());
		synchronized(supplyOrderShipment){
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.addConsumerOrder( consumerOrder );
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(YoubenbenUserContext userContext, String supplyOrderShipmentId,String id,String title,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		checkerOf(userContext).checkIdOfConsumerOrder(id);

		checkerOf(userContext).checkTitleOfConsumerOrder( title);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	}
	public  SupplyOrderShipment updateConsumerOrderProperties(YoubenbenUserContext userContext, String supplyOrderShipmentId, String id,String title, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderShipmentId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();

		SupplyOrderShipment supplyOrderShipmentToUpdate = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);

		if(supplyOrderShipmentToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderShipmentManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrder item = supplyOrderShipmentToUpdate.getConsumerOrderList().first();

		item.updateTitle( title );


		//checkParamsForAddingConsumerOrder(userContext,supplyOrderShipmentId,name, code, used,tokensExpr);
		SupplyOrderShipment supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipmentToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderShipment){
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
	}


	protected ConsumerOrder createConsumerOrder(YoubenbenUserContext userContext, String title, String consumerId, String confirmationId, String approvalId, String processingId, String deliveryId, String storeId) throws Exception{

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

	protected void checkParamsForRemovingConsumerOrderList(YoubenbenUserContext userContext, String supplyOrderShipmentId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		for(String consumerOrderIdItem: consumerOrderIds){
			checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	}
	public  SupplyOrderShipment removeConsumerOrderList(YoubenbenUserContext userContext, String supplyOrderShipmentId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderShipmentId,  consumerOrderIds, tokensExpr);


			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
			synchronized(supplyOrderShipment){
				//Will be good when the supplyOrderShipment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderShipmentDaoOf(userContext).planToRemoveConsumerOrderList(supplyOrderShipment, consumerOrderIds, allTokens());
				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderShipment.getConsumerOrderList());
				return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderShipment( supplyOrderShipmentId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	}
	public  SupplyOrderShipment removeConsumerOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrder(userContext,supplyOrderShipmentId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.removeConsumerOrder( consumerOrder );
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderShipment( supplyOrderShipmentId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	}
	public  SupplyOrderShipment copyConsumerOrderFrom(YoubenbenUserContext userContext, String supplyOrderShipmentId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrder(userContext,supplyOrderShipmentId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			consumerOrder.updateLastUpdateTime(userContext.now());

			supplyOrderShipment.copyConsumerOrderFrom( consumerOrder );
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderShipment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	}

	public  SupplyOrderShipment updateConsumerOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderShipmentId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();



		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, loadTokens);

		synchronized(supplyOrderShipment){
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderShipment.removeConsumerOrder( consumerOrder );
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);

			ConsumerOrder consumerOrder = supplyOrderShipment.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderShipmentManagerException(consumerOrder+" is NOT FOUND" );
			}

			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);

		
		checkerOf(userContext).checkBuyerIdOfSupplyOrder(buyerId);
		
		checkerOf(userContext).checkSellerIdOfSupplyOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfSupplyOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfSupplyOrder(totalAmount);
		
		checkerOf(userContext).checkConfirmationIdOfSupplyOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfSupplyOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfSupplyOrder(processingId);
		
		checkerOf(userContext).checkPickingIdOfSupplyOrder(pickingId);
		
		checkerOf(userContext).checkDeliveryIdOfSupplyOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);


	}
	public  SupplyOrderShipment addSupplyOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSupplyOrder(userContext,supplyOrderShipmentId,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, deliveryId,tokensExpr);

		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, deliveryId);

		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, emptyOptions());
		synchronized(supplyOrderShipment){
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.addSupplyOrder( supplyOrder );
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(YoubenbenUserContext userContext, String supplyOrderShipmentId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		checkerOf(userContext).checkIdOfSupplyOrder(id);

		checkerOf(userContext).checkTitleOfSupplyOrder( title);
		checkerOf(userContext).checkTotalAmountOfSupplyOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	}
	public  SupplyOrderShipment updateSupplyOrderProperties(YoubenbenUserContext userContext, String supplyOrderShipmentId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderShipmentId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();

		SupplyOrderShipment supplyOrderShipmentToUpdate = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);

		if(supplyOrderShipmentToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderShipmentManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}

		SupplyOrder item = supplyOrderShipmentToUpdate.getSupplyOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingSupplyOrder(userContext,supplyOrderShipmentId,name, code, used,tokensExpr);
		SupplyOrderShipment supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipmentToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderShipment){
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
	}


	protected SupplyOrder createSupplyOrder(YoubenbenUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String deliveryId) throws Exception{

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

	protected void checkParamsForRemovingSupplyOrderList(YoubenbenUserContext userContext, String supplyOrderShipmentId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		for(String supplyOrderIdItem: supplyOrderIds){
			checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	}
	public  SupplyOrderShipment removeSupplyOrderList(YoubenbenUserContext userContext, String supplyOrderShipmentId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderShipmentId,  supplyOrderIds, tokensExpr);


			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
			synchronized(supplyOrderShipment){
				//Will be good when the supplyOrderShipment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderShipmentDaoOf(userContext).planToRemoveSupplyOrderList(supplyOrderShipment, supplyOrderIds, allTokens());
				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderShipment.getSupplyOrderList());
				return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderShipment( supplyOrderShipmentId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	}
	public  SupplyOrderShipment removeSupplyOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSupplyOrder(userContext,supplyOrderShipmentId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.removeSupplyOrder( supplyOrder );
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderShipment( supplyOrderShipmentId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	}
	public  SupplyOrderShipment copySupplyOrderFrom(YoubenbenUserContext userContext, String supplyOrderShipmentId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSupplyOrder(userContext,supplyOrderShipmentId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			supplyOrder.updateLastUpdateTime(userContext.now());

			supplyOrderShipment.copySupplyOrderFrom( supplyOrder );
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderShipment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfSupplyOrder(parseString(newValueExpr));
		
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	}

	public  SupplyOrderShipment updateSupplyOrder(YoubenbenUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderShipmentId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();



		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, loadTokens);

		synchronized(supplyOrderShipment){
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderShipment.removeSupplyOrder( supplyOrder );
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);

			SupplyOrder supplyOrder = supplyOrderShipment.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderShipmentManagerException(supplyOrder+" is NOT FOUND" );
			}

			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderShipment newCreated) throws Exception{
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
		//   SupplyOrderShipment newSupplyOrderShipment = this.createSupplyOrderShipment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSupplyOrderShipment
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, SupplyOrderShipment.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<SupplyOrderShipment> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String supplyOrderShipmentId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getSupplyOrderShipmentDetailScope().clone();
		SupplyOrderShipment merchantObj = (SupplyOrderShipment) this.view(userContext, supplyOrderShipmentId);
    String merchantObjId = supplyOrderShipmentId;
    String linkToUrl =	"supplyOrderShipmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "供应货"+"详情";
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

		//处理Section：consumerOrderListSection
		Map consumerOrderListSection = ListofUtils.buildSection(
		    "consumerOrderListSection",
		    "消费者的订单列表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderManager/listByShipment/"+merchantObjId+"/",
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
		    "supplyOrderManager/listByShipment/"+merchantObjId+"/",
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


