
package com.youbenben.youbenben.supplyorderapproval;

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






public class SupplyOrderApprovalManagerImpl extends CustomYoubenbenCheckerManager implements SupplyOrderApprovalManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = SupplyOrderApprovalTokens.start().withTokenFromListName(listName).done();
		SupplyOrderApproval  supplyOrderApproval = (SupplyOrderApproval) this.loadSupplyOrderApproval(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = supplyOrderApproval.collectRefercencesFromLists();
		supplyOrderApprovalDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, supplyOrderApproval, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new SupplyOrderApprovalGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "SupplyOrderApproval";
	@Override
	public SupplyOrderApprovalDAO daoOf(YoubenbenUserContext userContext) {
		return supplyOrderApprovalDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws SupplyOrderApprovalManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderApprovalManagerException(message);

	}



 	protected SupplyOrderApproval saveSupplyOrderApproval(YoubenbenUserContext userContext, SupplyOrderApproval supplyOrderApproval, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderApprovalDAO().save(supplyOrderApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens);
 	}
 	
 	protected SupplyOrderApproval saveSupplyOrderApprovalDetail(YoubenbenUserContext userContext, SupplyOrderApproval supplyOrderApproval) throws Exception{	

 		
 		return saveSupplyOrderApproval(userContext, supplyOrderApproval, allTokens());
 	}
 	
 	public SupplyOrderApproval loadSupplyOrderApproval(YoubenbenUserContext userContext, String supplyOrderApprovalId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderApprovalManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderApproval, tokens);
 	}
 	
 	
 	 public SupplyOrderApproval searchSupplyOrderApproval(YoubenbenUserContext userContext, String supplyOrderApprovalId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderApprovalManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderApproval, tokens);
 	}
 	
 	

 	protected SupplyOrderApproval present(YoubenbenUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderApproval,tokens);
		
		
		SupplyOrderApproval  supplyOrderApprovalToPresent = supplyOrderApprovalDaoOf(userContext).present(supplyOrderApproval, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderApprovalToPresent.collectRefercencesFromLists();
		supplyOrderApprovalDaoOf(userContext).alias(entityListToNaming);
		
		return  supplyOrderApprovalToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderApproval loadSupplyOrderApprovalDetail(YoubenbenUserContext userContext, String supplyOrderApprovalId) throws Exception{	
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, allTokens());
 		return present(userContext,supplyOrderApproval, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String supplyOrderApprovalId) throws Exception{	
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, viewTokens());
 		return present(userContext,supplyOrderApproval, allTokens());
		
 	}
 	protected SupplyOrderApproval saveSupplyOrderApproval(YoubenbenUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String,Object>tokens) throws Exception{	
 		return supplyOrderApprovalDaoOf(userContext).save(supplyOrderApproval, tokens);
 	}
 	protected SupplyOrderApproval loadSupplyOrderApproval(YoubenbenUserContext userContext, String supplyOrderApprovalId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderApprovalManagerException.class);

 
 		return supplyOrderApprovalDaoOf(userContext).load(supplyOrderApprovalId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderApproval, tokens);
		
		addAction(userContext, supplyOrderApproval, tokens,"@create","createSupplyOrderApproval","createSupplyOrderApproval/","main","primary");
		addAction(userContext, supplyOrderApproval, tokens,"@update","updateSupplyOrderApproval","updateSupplyOrderApproval/"+supplyOrderApproval.getId()+"/","main","primary");
		addAction(userContext, supplyOrderApproval, tokens,"@copy","cloneSupplyOrderApproval","cloneSupplyOrderApproval/"+supplyOrderApproval.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SupplyOrderApproval createSupplyOrderApproval(YoubenbenUserContext userContext, String who,Date approveTime) throws Exception
	//public SupplyOrderApproval createSupplyOrderApproval(YoubenbenUserContext userContext,String who, Date approveTime) throws Exception
	{

		

		

		checkerOf(userContext).checkWhoOfSupplyOrderApproval(who);
		checkerOf(userContext).checkApproveTimeOfSupplyOrderApproval(approveTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);


		SupplyOrderApproval supplyOrderApproval=createNewSupplyOrderApproval();	

		supplyOrderApproval.setWho(who);
		supplyOrderApproval.setApproveTime(approveTime);

		supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderApproval);
		return supplyOrderApproval;


	}
	protected SupplyOrderApproval createNewSupplyOrderApproval()
	{

		return new SupplyOrderApproval();
	}

	protected void checkParamsForUpdatingSupplyOrderApproval(YoubenbenUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).checkVersionOfSupplyOrderApproval( supplyOrderApprovalVersion);
		

		if(SupplyOrderApproval.WHO_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWhoOfSupplyOrderApproval(parseString(newValueExpr));
		
			
		}
		if(SupplyOrderApproval.APPROVE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkApproveTimeOfSupplyOrderApproval(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);


	}



	public SupplyOrderApproval clone(YoubenbenUserContext userContext, String fromSupplyOrderApprovalId) throws Exception{

		return supplyOrderApprovalDaoOf(userContext).clone(fromSupplyOrderApprovalId, this.allTokens());
	}

	public SupplyOrderApproval internalSaveSupplyOrderApproval(YoubenbenUserContext userContext, SupplyOrderApproval supplyOrderApproval) throws Exception
	{
		return internalSaveSupplyOrderApproval(userContext, supplyOrderApproval, allTokens());

	}
	public SupplyOrderApproval internalSaveSupplyOrderApproval(YoubenbenUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSupplyOrderApproval(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion, property, newValueExpr, tokensExpr);


		synchronized(supplyOrderApproval){
			//will be good when the supplyOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderApproval.
			if (supplyOrderApproval.isChanged()){
			
			}
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, options);
			return supplyOrderApproval;

		}

	}

	public SupplyOrderApproval updateSupplyOrderApproval(YoubenbenUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderApproval(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion, property, newValueExpr, tokensExpr);



		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		if(supplyOrderApproval.getVersion() != supplyOrderApprovalVersion){
			String message = "The target version("+supplyOrderApproval.getVersion()+") is not equals to version("+supplyOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderApproval){
			//will be good when the supplyOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderApproval.
			
			supplyOrderApproval.changeProperty(property, newValueExpr);
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
		}

	}

	public SupplyOrderApproval updateSupplyOrderApprovalProperty(YoubenbenUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderApproval(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion, property, newValueExpr, tokensExpr);

		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		if(supplyOrderApproval.getVersion() != supplyOrderApprovalVersion){
			String message = "The target version("+supplyOrderApproval.getVersion()+") is not equals to version("+supplyOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderApproval){
			//will be good when the supplyOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderApproval.

			supplyOrderApproval.changeProperty(property, newValueExpr);
			
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SupplyOrderApprovalTokens tokens(){
		return SupplyOrderApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderApprovalTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderApprovalTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception{

		supplyOrderApprovalDaoOf(userContext).delete(supplyOrderApprovalId, supplyOrderApprovalVersion);
	}

	public SupplyOrderApproval forgetByAll(YoubenbenUserContext userContext, String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion);
	}
	protected SupplyOrderApproval forgetByAllInternal(YoubenbenUserContext userContext,
			String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception{

		return supplyOrderApprovalDaoOf(userContext).disconnectFromAll(supplyOrderApprovalId, supplyOrderApprovalVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return supplyOrderApprovalDaoOf(userContext).deleteAll();
	}


	//disconnect SupplyOrderApproval with consumer in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByConsumer(YoubenbenUserContext userContext, String supplyOrderApprovalId, String consumerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithConsumer(supplyOrderApproval, consumerId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with confirmation in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByConfirmation(YoubenbenUserContext userContext, String supplyOrderApprovalId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithConfirmation(supplyOrderApproval, confirmationId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with processing in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByProcessing(YoubenbenUserContext userContext, String supplyOrderApprovalId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithProcessing(supplyOrderApproval, processingId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with shipment in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByShipment(YoubenbenUserContext userContext, String supplyOrderApprovalId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithShipment(supplyOrderApproval, shipmentId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with delivery in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByDelivery(YoubenbenUserContext userContext, String supplyOrderApprovalId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithDelivery(supplyOrderApproval, deliveryId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with store in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByStore(YoubenbenUserContext userContext, String supplyOrderApprovalId, String storeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithStore(supplyOrderApproval, storeId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with buyer in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByBuyer(YoubenbenUserContext userContext, String supplyOrderApprovalId, String buyerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithBuyer(supplyOrderApproval, buyerId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with seller in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderBySeller(YoubenbenUserContext userContext, String supplyOrderApprovalId, String sellerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithSeller(supplyOrderApproval, sellerId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with confirmation in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByConfirmation(YoubenbenUserContext userContext, String supplyOrderApprovalId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithConfirmation(supplyOrderApproval, confirmationId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with processing in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByProcessing(YoubenbenUserContext userContext, String supplyOrderApprovalId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithProcessing(supplyOrderApproval, processingId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with picking in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByPicking(YoubenbenUserContext userContext, String supplyOrderApprovalId, String pickingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithPicking(supplyOrderApproval, pickingId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with shipment in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByShipment(YoubenbenUserContext userContext, String supplyOrderApprovalId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithShipment(supplyOrderApproval, shipmentId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with delivery in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByDelivery(YoubenbenUserContext userContext, String supplyOrderApprovalId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithDelivery(supplyOrderApproval, deliveryId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}






	protected void checkParamsForAddingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String confirmationId, String processingId, String shipmentId, String deliveryId, String storeId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);

		
		checkerOf(userContext).checkTitleOfConsumerOrder(title);
		
		checkerOf(userContext).checkConsumerIdOfConsumerOrder(consumerId);
		
		checkerOf(userContext).checkConfirmationIdOfConsumerOrder(confirmationId);
		
		checkerOf(userContext).checkProcessingIdOfConsumerOrder(processingId);
		
		checkerOf(userContext).checkShipmentIdOfConsumerOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfConsumerOrder(deliveryId);
		
		checkerOf(userContext).checkStoreIdOfConsumerOrder(storeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);


	}
	public  SupplyOrderApproval addConsumerOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String confirmationId, String processingId, String shipmentId, String deliveryId, String storeId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingConsumerOrder(userContext,supplyOrderApprovalId,title, consumerId, confirmationId, processingId, shipmentId, deliveryId, storeId,tokensExpr);

		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, confirmationId, processingId, shipmentId, deliveryId, storeId);

		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, emptyOptions());
		synchronized(supplyOrderApproval){
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.addConsumerOrder( consumerOrder );
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(YoubenbenUserContext userContext, String supplyOrderApprovalId,String id,String title,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfConsumerOrder(id);

		checkerOf(userContext).checkTitleOfConsumerOrder( title);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	}
	public  SupplyOrderApproval updateConsumerOrderProperties(YoubenbenUserContext userContext, String supplyOrderApprovalId, String id,String title, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderApprovalId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();

		SupplyOrderApproval supplyOrderApprovalToUpdate = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);

		if(supplyOrderApprovalToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderApprovalManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrder item = supplyOrderApprovalToUpdate.getConsumerOrderList().first();

		item.updateTitle( title );


		//checkParamsForAddingConsumerOrder(userContext,supplyOrderApprovalId,name, code, used,tokensExpr);
		SupplyOrderApproval supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApprovalToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderApproval){
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}


	protected ConsumerOrder createConsumerOrder(YoubenbenUserContext userContext, String title, String consumerId, String confirmationId, String processingId, String shipmentId, String deliveryId, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStoreMember  consumer = new RetailStoreMember();
		consumer.setId(consumerId);		
		consumerOrder.setConsumer(consumer);		
		SupplyOrderConfirmation  confirmation = new SupplyOrderConfirmation();
		confirmation.setId(confirmationId);		
		consumerOrder.setConfirmation(confirmation);		
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

	protected void checkParamsForRemovingConsumerOrderList(YoubenbenUserContext userContext, String supplyOrderApprovalId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		for(String consumerOrderIdItem: consumerOrderIds){
			checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	}
	public  SupplyOrderApproval removeConsumerOrderList(YoubenbenUserContext userContext, String supplyOrderApprovalId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderApprovalId,  consumerOrderIds, tokensExpr);


			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
			synchronized(supplyOrderApproval){
				//Will be good when the supplyOrderApproval loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderList(supplyOrderApproval, consumerOrderIds, allTokens());
				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderApproval.getConsumerOrderList());
				return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	}
	public  SupplyOrderApproval removeConsumerOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrder(userContext,supplyOrderApprovalId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.removeConsumerOrder( consumerOrder );
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	}
	public  SupplyOrderApproval copyConsumerOrderFrom(YoubenbenUserContext userContext, String supplyOrderApprovalId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrder(userContext,supplyOrderApprovalId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			consumerOrder.updateLastUpdateTime(userContext.now());

			supplyOrderApproval.copyConsumerOrderFrom( consumerOrder );
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderApproval.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	}

	public  SupplyOrderApproval updateConsumerOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderApprovalId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();



		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, loadTokens);

		synchronized(supplyOrderApproval){
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderApproval.removeConsumerOrder( consumerOrder );
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);

			ConsumerOrder consumerOrder = supplyOrderApproval.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderApprovalManagerException(consumerOrder+" is NOT FOUND" );
			}

			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);

		
		checkerOf(userContext).checkBuyerIdOfSupplyOrder(buyerId);
		
		checkerOf(userContext).checkSellerIdOfSupplyOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfSupplyOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfSupplyOrder(totalAmount);
		
		checkerOf(userContext).checkConfirmationIdOfSupplyOrder(confirmationId);
		
		checkerOf(userContext).checkProcessingIdOfSupplyOrder(processingId);
		
		checkerOf(userContext).checkPickingIdOfSupplyOrder(pickingId);
		
		checkerOf(userContext).checkShipmentIdOfSupplyOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfSupplyOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);


	}
	public  SupplyOrderApproval addSupplyOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSupplyOrder(userContext,supplyOrderApprovalId,buyerId, sellerId, title, totalAmount, confirmationId, processingId, pickingId, shipmentId, deliveryId,tokensExpr);

		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount, confirmationId, processingId, pickingId, shipmentId, deliveryId);

		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, emptyOptions());
		synchronized(supplyOrderApproval){
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.addSupplyOrder( supplyOrder );
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(YoubenbenUserContext userContext, String supplyOrderApprovalId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfSupplyOrder(id);

		checkerOf(userContext).checkTitleOfSupplyOrder( title);
		checkerOf(userContext).checkTotalAmountOfSupplyOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	}
	public  SupplyOrderApproval updateSupplyOrderProperties(YoubenbenUserContext userContext, String supplyOrderApprovalId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderApprovalId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();

		SupplyOrderApproval supplyOrderApprovalToUpdate = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);

		if(supplyOrderApprovalToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderApprovalManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}

		SupplyOrder item = supplyOrderApprovalToUpdate.getSupplyOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingSupplyOrder(userContext,supplyOrderApprovalId,name, code, used,tokensExpr);
		SupplyOrderApproval supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApprovalToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderApproval){
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}


	protected SupplyOrder createSupplyOrder(YoubenbenUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId) throws Exception{

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

	protected void checkParamsForRemovingSupplyOrderList(YoubenbenUserContext userContext, String supplyOrderApprovalId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		for(String supplyOrderIdItem: supplyOrderIds){
			checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	}
	public  SupplyOrderApproval removeSupplyOrderList(YoubenbenUserContext userContext, String supplyOrderApprovalId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderApprovalId,  supplyOrderIds, tokensExpr);


			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
			synchronized(supplyOrderApproval){
				//Will be good when the supplyOrderApproval loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderList(supplyOrderApproval, supplyOrderIds, allTokens());
				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderApproval.getSupplyOrderList());
				return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	}
	public  SupplyOrderApproval removeSupplyOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSupplyOrder(userContext,supplyOrderApprovalId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.removeSupplyOrder( supplyOrder );
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	}
	public  SupplyOrderApproval copySupplyOrderFrom(YoubenbenUserContext userContext, String supplyOrderApprovalId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSupplyOrder(userContext,supplyOrderApprovalId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			supplyOrder.updateLastUpdateTime(userContext.now());

			supplyOrderApproval.copySupplyOrderFrom( supplyOrder );
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderApproval.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSupplyOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfSupplyOrder(parseString(newValueExpr));
		
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	}

	public  SupplyOrderApproval updateSupplyOrder(YoubenbenUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderApprovalId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();



		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, loadTokens);

		synchronized(supplyOrderApproval){
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderApproval.removeSupplyOrder( supplyOrder );
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);

			SupplyOrder supplyOrder = supplyOrderApproval.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderApprovalManagerException(supplyOrder+" is NOT FOUND" );
			}

			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderApproval newCreated) throws Exception{
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
		//   SupplyOrderApproval newSupplyOrderApproval = this.createSupplyOrderApproval(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSupplyOrderApproval
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, SupplyOrderApproval.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<SupplyOrderApproval> list) throws Exception {
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
 	public Object wxappview(YoubenbenUserContext userContext, String supplyOrderApprovalId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getSupplyOrderApprovalDetailScope().clone();
		SupplyOrderApproval merchantObj = (SupplyOrderApproval) this.view(userContext, supplyOrderApprovalId);
    String merchantObjId = supplyOrderApprovalId;
    String linkToUrl =	"supplyOrderApprovalManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "供应订单审批"+"详情";
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

		//处理Section：consumerOrderListSection
		Map consumerOrderListSection = ListofUtils.buildSection(
		    "consumerOrderListSection",
		    "消费者的订单列表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderManager/listByApproval/"+merchantObjId+"/",
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
		    "supplyOrderManager/listByApproval/"+merchantObjId+"/",
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


