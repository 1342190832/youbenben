
package com.youbenben.youbenben.goodssupplier;

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


import com.youbenben.youbenben.supplierproduct.SupplierProduct;
import com.youbenben.youbenben.supplyorder.SupplyOrder;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;
import com.youbenben.youbenben.accountset.AccountSet;

import com.youbenben.youbenben.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.youbenben.youbenben.goodssupplier.GoodsSupplier;
import com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDelivery;
import com.youbenben.youbenben.supplyorderapproval.SupplyOrderApproval;
import com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmation;
import com.youbenben.youbenben.supplyorderpicking.SupplyOrderPicking;
import com.youbenben.youbenben.supplyordershipment.SupplyOrderShipment;
import com.youbenben.youbenben.retailstore.RetailStore;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;
import com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessing;






public class GoodsSupplierManagerImpl extends CustomYoubenbenCheckerManager implements GoodsSupplierManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = GoodsSupplierTokens.start().withTokenFromListName(listName).done();
		GoodsSupplier  goodsSupplier = (GoodsSupplier) this.loadGoodsSupplier(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = goodsSupplier.collectRefercencesFromLists();
		goodsSupplierDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, goodsSupplier, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new GoodsSupplierGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "GoodsSupplier";
	@Override
	public GoodsSupplierDAO daoOf(YoubenbenUserContext userContext) {
		return goodsSupplierDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws GoodsSupplierManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new GoodsSupplierManagerException(message);

	}



 	protected GoodsSupplier saveGoodsSupplier(YoubenbenUserContext userContext, GoodsSupplier goodsSupplier, String [] tokensExpr) throws Exception{	
 		//return getGoodsSupplierDAO().save(goodsSupplier, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoodsSupplier(userContext, goodsSupplier, tokens);
 	}
 	
 	protected GoodsSupplier saveGoodsSupplierDetail(YoubenbenUserContext userContext, GoodsSupplier goodsSupplier) throws Exception{	

 		
 		return saveGoodsSupplier(userContext, goodsSupplier, allTokens());
 	}
 	
 	public GoodsSupplier loadGoodsSupplier(YoubenbenUserContext userContext, String goodsSupplierId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsSupplierManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsSupplier goodsSupplier = loadGoodsSupplier( userContext, goodsSupplierId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsSupplier, tokens);
 	}
 	
 	
 	 public GoodsSupplier searchGoodsSupplier(YoubenbenUserContext userContext, String goodsSupplierId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsSupplierManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		GoodsSupplier goodsSupplier = loadGoodsSupplier( userContext, goodsSupplierId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsSupplier, tokens);
 	}
 	
 	

 	protected GoodsSupplier present(YoubenbenUserContext userContext, GoodsSupplier goodsSupplier, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsSupplier,tokens);
		
		
		GoodsSupplier  goodsSupplierToPresent = goodsSupplierDaoOf(userContext).present(goodsSupplier, tokens);
		
		List<BaseEntity> entityListToNaming = goodsSupplierToPresent.collectRefercencesFromLists();
		goodsSupplierDaoOf(userContext).alias(entityListToNaming);
		
		return  goodsSupplierToPresent;
		
		
	}
 
 	
 	
 	public GoodsSupplier loadGoodsSupplierDetail(YoubenbenUserContext userContext, String goodsSupplierId) throws Exception{	
 		GoodsSupplier goodsSupplier = loadGoodsSupplier( userContext, goodsSupplierId, allTokens());
 		return present(userContext,goodsSupplier, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String goodsSupplierId) throws Exception{	
 		GoodsSupplier goodsSupplier = loadGoodsSupplier( userContext, goodsSupplierId, viewTokens());
 		return present(userContext,goodsSupplier, allTokens());
		
 	}
 	protected GoodsSupplier saveGoodsSupplier(YoubenbenUserContext userContext, GoodsSupplier goodsSupplier, Map<String,Object>tokens) throws Exception{	
 		return goodsSupplierDaoOf(userContext).save(goodsSupplier, tokens);
 	}
 	protected GoodsSupplier loadGoodsSupplier(YoubenbenUserContext userContext, String goodsSupplierId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsSupplierManagerException.class);

 
 		return goodsSupplierDaoOf(userContext).load(goodsSupplierId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, GoodsSupplier goodsSupplier, Map<String, Object> tokens){
		super.addActions(userContext, goodsSupplier, tokens);
		
		addAction(userContext, goodsSupplier, tokens,"@create","createGoodsSupplier","createGoodsSupplier/","main","primary");
		addAction(userContext, goodsSupplier, tokens,"@update","updateGoodsSupplier","updateGoodsSupplier/"+goodsSupplier.getId()+"/","main","primary");
		addAction(userContext, goodsSupplier, tokens,"@copy","cloneGoodsSupplier","cloneGoodsSupplier/"+goodsSupplier.getId()+"/","main","primary");
		
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.transfer_to_belong_to","transferToAnotherBelongTo","transferToAnotherBelongTo/"+goodsSupplier.getId()+"/","main","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.addSupplierProduct","addSupplierProduct","addSupplierProduct/"+goodsSupplier.getId()+"/","supplierProductList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.removeSupplierProduct","removeSupplierProduct","removeSupplierProduct/"+goodsSupplier.getId()+"/","supplierProductList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.updateSupplierProduct","updateSupplierProduct","updateSupplierProduct/"+goodsSupplier.getId()+"/","supplierProductList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.copySupplierProductFrom","copySupplierProductFrom","copySupplierProductFrom/"+goodsSupplier.getId()+"/","supplierProductList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+goodsSupplier.getId()+"/","supplyOrderList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+goodsSupplier.getId()+"/","supplyOrderList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+goodsSupplier.getId()+"/","supplyOrderList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+goodsSupplier.getId()+"/","supplyOrderList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.addAccountSet","addAccountSet","addAccountSet/"+goodsSupplier.getId()+"/","accountSetList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.removeAccountSet","removeAccountSet","removeAccountSet/"+goodsSupplier.getId()+"/","accountSetList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.updateAccountSet","updateAccountSet","updateAccountSet/"+goodsSupplier.getId()+"/","accountSetList","primary");
		addAction(userContext, goodsSupplier, tokens,"goods_supplier.copyAccountSetFrom","copyAccountSetFrom","copyAccountSetFrom/"+goodsSupplier.getId()+"/","accountSetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, GoodsSupplier goodsSupplier, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public GoodsSupplier createGoodsSupplier(YoubenbenUserContext userContext, String name,String supplyProduct,String belongToId,String contactNumber,String description) throws Exception
	//public GoodsSupplier createGoodsSupplier(YoubenbenUserContext userContext,String name, String supplyProduct, String belongToId, String contactNumber, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfGoodsSupplier(name);
		checkerOf(userContext).checkSupplyProductOfGoodsSupplier(supplyProduct);
		checkerOf(userContext).checkContactNumberOfGoodsSupplier(contactNumber);
		checkerOf(userContext).checkDescriptionOfGoodsSupplier(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);


		GoodsSupplier goodsSupplier=createNewGoodsSupplier();	

		goodsSupplier.setName(name);
		goodsSupplier.setSupplyProduct(supplyProduct);
			
		RetailStoreCountryCenter belongTo = loadRetailStoreCountryCenter(userContext, belongToId,emptyOptions());
		goodsSupplier.setBelongTo(belongTo);
		
		
		goodsSupplier.setContactNumber(contactNumber);
		goodsSupplier.setDescription(description);
		goodsSupplier.setLastUpdateTime(userContext.now());

		goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, emptyOptions());
		
		onNewInstanceCreated(userContext, goodsSupplier);
		return goodsSupplier;


	}
	protected GoodsSupplier createNewGoodsSupplier()
	{

		return new GoodsSupplier();
	}

	protected void checkParamsForUpdatingGoodsSupplier(YoubenbenUserContext userContext,String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).checkVersionOfGoodsSupplier( goodsSupplierVersion);
		

		if(GoodsSupplier.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfGoodsSupplier(parseString(newValueExpr));
		
			
		}
		if(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSupplyProductOfGoodsSupplier(parseString(newValueExpr));
		
			
		}		

		
		if(GoodsSupplier.CONTACT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContactNumberOfGoodsSupplier(parseString(newValueExpr));
		
			
		}
		if(GoodsSupplier.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfGoodsSupplier(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);


	}



	public GoodsSupplier clone(YoubenbenUserContext userContext, String fromGoodsSupplierId) throws Exception{

		return goodsSupplierDaoOf(userContext).clone(fromGoodsSupplierId, this.allTokens());
	}

	public GoodsSupplier internalSaveGoodsSupplier(YoubenbenUserContext userContext, GoodsSupplier goodsSupplier) throws Exception
	{
		return internalSaveGoodsSupplier(userContext, goodsSupplier, allTokens());

	}
	public GoodsSupplier internalSaveGoodsSupplier(YoubenbenUserContext userContext, GoodsSupplier goodsSupplier, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingGoodsSupplier(userContext, goodsSupplierId, goodsSupplierVersion, property, newValueExpr, tokensExpr);


		synchronized(goodsSupplier){
			//will be good when the goodsSupplier loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsSupplier.
			if (goodsSupplier.isChanged()){
			goodsSupplier.updateLastUpdateTime(userContext.now());
			}
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, options);
			return goodsSupplier;

		}

	}

	public GoodsSupplier updateGoodsSupplier(YoubenbenUserContext userContext,String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsSupplier(userContext, goodsSupplierId, goodsSupplierVersion, property, newValueExpr, tokensExpr);



		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		if(goodsSupplier.getVersion() != goodsSupplierVersion){
			String message = "The target version("+goodsSupplier.getVersion()+") is not equals to version("+goodsSupplierVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goodsSupplier){
			//will be good when the goodsSupplier loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsSupplier.
			goodsSupplier.updateLastUpdateTime(userContext.now());
			goodsSupplier.changeProperty(property, newValueExpr);
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
			//return saveGoodsSupplier(userContext, goodsSupplier, tokens().done());
		}

	}

	public GoodsSupplier updateGoodsSupplierProperty(YoubenbenUserContext userContext,String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsSupplier(userContext, goodsSupplierId, goodsSupplierVersion, property, newValueExpr, tokensExpr);

		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		if(goodsSupplier.getVersion() != goodsSupplierVersion){
			String message = "The target version("+goodsSupplier.getVersion()+") is not equals to version("+goodsSupplierVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goodsSupplier){
			//will be good when the goodsSupplier loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsSupplier.

			goodsSupplier.changeProperty(property, newValueExpr);
			goodsSupplier.updateLastUpdateTime(userContext.now());
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
			//return saveGoodsSupplier(userContext, goodsSupplier, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected GoodsSupplierTokens tokens(){
		return GoodsSupplierTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsSupplierTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortSupplierProductListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.sortAccountSetListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsSupplierTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongTo(YoubenbenUserContext userContext, String goodsSupplierId, String anotherBelongToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherBelongToId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

 	}
 	public GoodsSupplier transferToAnotherBelongTo(YoubenbenUserContext userContext, String goodsSupplierId, String anotherBelongToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongTo(userContext, goodsSupplierId,anotherBelongToId);
 
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());	
		synchronized(goodsSupplier){
			//will be good when the goodsSupplier loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter belongTo = loadRetailStoreCountryCenter(userContext, anotherBelongToId, emptyOptions());		
			goodsSupplier.updateBelongTo(belongTo);		
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, emptyOptions());
			
			return present(userContext,goodsSupplier, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreCountryCenter requestCandidateBelongTo(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForGoodsSupplier(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(YoubenbenUserContext userContext, String newBelongToId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newBelongToId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String goodsSupplierId, int goodsSupplierVersion) throws Exception {
		//deleteInternal(userContext, goodsSupplierId, goodsSupplierVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String goodsSupplierId, int goodsSupplierVersion) throws Exception{

		goodsSupplierDaoOf(userContext).delete(goodsSupplierId, goodsSupplierVersion);
	}

	public GoodsSupplier forgetByAll(YoubenbenUserContext userContext, String goodsSupplierId, int goodsSupplierVersion) throws Exception {
		return forgetByAllInternal(userContext, goodsSupplierId, goodsSupplierVersion);
	}
	protected GoodsSupplier forgetByAllInternal(YoubenbenUserContext userContext,
			String goodsSupplierId, int goodsSupplierVersion) throws Exception{

		return goodsSupplierDaoOf(userContext).disconnectFromAll(goodsSupplierId, goodsSupplierVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsSupplierManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return goodsSupplierDaoOf(userContext).deleteAll();
	}


	//disconnect GoodsSupplier with buyer in SupplyOrder
	protected GoodsSupplier breakWithSupplyOrderByBuyer(YoubenbenUserContext userContext, String goodsSupplierId, String buyerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());

			synchronized(goodsSupplier){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsSupplierDaoOf(userContext).planToRemoveSupplyOrderListWithBuyer(goodsSupplier, buyerId, this.emptyOptions());

				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
				return goodsSupplier;
			}
	}
	//disconnect GoodsSupplier with confirmation in SupplyOrder
	protected GoodsSupplier breakWithSupplyOrderByConfirmation(YoubenbenUserContext userContext, String goodsSupplierId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());

			synchronized(goodsSupplier){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsSupplierDaoOf(userContext).planToRemoveSupplyOrderListWithConfirmation(goodsSupplier, confirmationId, this.emptyOptions());

				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
				return goodsSupplier;
			}
	}
	//disconnect GoodsSupplier with approval in SupplyOrder
	protected GoodsSupplier breakWithSupplyOrderByApproval(YoubenbenUserContext userContext, String goodsSupplierId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());

			synchronized(goodsSupplier){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsSupplierDaoOf(userContext).planToRemoveSupplyOrderListWithApproval(goodsSupplier, approvalId, this.emptyOptions());

				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
				return goodsSupplier;
			}
	}
	//disconnect GoodsSupplier with processing in SupplyOrder
	protected GoodsSupplier breakWithSupplyOrderByProcessing(YoubenbenUserContext userContext, String goodsSupplierId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());

			synchronized(goodsSupplier){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsSupplierDaoOf(userContext).planToRemoveSupplyOrderListWithProcessing(goodsSupplier, processingId, this.emptyOptions());

				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
				return goodsSupplier;
			}
	}
	//disconnect GoodsSupplier with picking in SupplyOrder
	protected GoodsSupplier breakWithSupplyOrderByPicking(YoubenbenUserContext userContext, String goodsSupplierId, String pickingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());

			synchronized(goodsSupplier){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsSupplierDaoOf(userContext).planToRemoveSupplyOrderListWithPicking(goodsSupplier, pickingId, this.emptyOptions());

				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
				return goodsSupplier;
			}
	}
	//disconnect GoodsSupplier with shipment in SupplyOrder
	protected GoodsSupplier breakWithSupplyOrderByShipment(YoubenbenUserContext userContext, String goodsSupplierId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());

			synchronized(goodsSupplier){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsSupplierDaoOf(userContext).planToRemoveSupplyOrderListWithShipment(goodsSupplier, shipmentId, this.emptyOptions());

				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
				return goodsSupplier;
			}
	}
	//disconnect GoodsSupplier with delivery in SupplyOrder
	protected GoodsSupplier breakWithSupplyOrderByDelivery(YoubenbenUserContext userContext, String goodsSupplierId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());

			synchronized(goodsSupplier){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsSupplierDaoOf(userContext).planToRemoveSupplyOrderListWithDelivery(goodsSupplier, deliveryId, this.emptyOptions());

				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
				return goodsSupplier;
			}
	}
	//disconnect GoodsSupplier with country_center in AccountSet
	protected GoodsSupplier breakWithAccountSetByCountryCenter(YoubenbenUserContext userContext, String goodsSupplierId, String countryCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());

			synchronized(goodsSupplier){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsSupplierDaoOf(userContext).planToRemoveAccountSetListWithCountryCenter(goodsSupplier, countryCenterId, this.emptyOptions());

				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withAccountSetList().done());
				return goodsSupplier;
			}
	}
	//disconnect GoodsSupplier with retail_store in AccountSet
	protected GoodsSupplier breakWithAccountSetByRetailStore(YoubenbenUserContext userContext, String goodsSupplierId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());

			synchronized(goodsSupplier){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				goodsSupplierDaoOf(userContext).planToRemoveAccountSetListWithRetailStore(goodsSupplier, retailStoreId, this.emptyOptions());

				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withAccountSetList().done());
				return goodsSupplier;
			}
	}






	protected void checkParamsForAddingSupplierProduct(YoubenbenUserContext userContext, String goodsSupplierId, String productName, String productDescription, String productUnit,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);

		
		checkerOf(userContext).checkProductNameOfSupplierProduct(productName);
		
		checkerOf(userContext).checkProductDescriptionOfSupplierProduct(productDescription);
		
		checkerOf(userContext).checkProductUnitOfSupplierProduct(productUnit);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);


	}
	public  GoodsSupplier addSupplierProduct(YoubenbenUserContext userContext, String goodsSupplierId, String productName, String productDescription, String productUnit, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSupplierProduct(userContext,goodsSupplierId,productName, productDescription, productUnit,tokensExpr);

		SupplierProduct supplierProduct = createSupplierProduct(userContext,productName, productDescription, productUnit);

		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, emptyOptions());
		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.addSupplierProduct( supplierProduct );
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplierProductList().done());
			
			userContext.getManagerGroup().getSupplierProductManager().onNewInstanceCreated(userContext, supplierProduct);
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplierProductProperties(YoubenbenUserContext userContext, String goodsSupplierId,String id,String productName,String productDescription,String productUnit,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).checkIdOfSupplierProduct(id);

		checkerOf(userContext).checkProductNameOfSupplierProduct( productName);
		checkerOf(userContext).checkProductDescriptionOfSupplierProduct( productDescription);
		checkerOf(userContext).checkProductUnitOfSupplierProduct( productUnit);

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier updateSupplierProductProperties(YoubenbenUserContext userContext, String goodsSupplierId, String id,String productName,String productDescription,String productUnit, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplierProductProperties(userContext,goodsSupplierId,id,productName,productDescription,productUnit,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplierProductListList()
				.searchSupplierProductListWith(SupplierProduct.ID_PROPERTY, "is", id).done();

		GoodsSupplier goodsSupplierToUpdate = loadGoodsSupplier(userContext, goodsSupplierId, options);

		if(goodsSupplierToUpdate.getSupplierProductList().isEmpty()){
			throw new GoodsSupplierManagerException("SupplierProduct is NOT FOUND with id: '"+id+"'");
		}

		SupplierProduct item = goodsSupplierToUpdate.getSupplierProductList().first();

		item.updateProductName( productName );
		item.updateProductDescription( productDescription );
		item.updateProductUnit( productUnit );


		//checkParamsForAddingSupplierProduct(userContext,goodsSupplierId,name, code, used,tokensExpr);
		GoodsSupplier goodsSupplier = saveGoodsSupplier(userContext, goodsSupplierToUpdate, tokens().withSupplierProductList().done());
		synchronized(goodsSupplier){
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
	}


	protected SupplierProduct createSupplierProduct(YoubenbenUserContext userContext, String productName, String productDescription, String productUnit) throws Exception{

		SupplierProduct supplierProduct = new SupplierProduct();
		
		
		supplierProduct.setProductName(productName);		
		supplierProduct.setProductDescription(productDescription);		
		supplierProduct.setProductUnit(productUnit);
	
		
		return supplierProduct;


	}

	protected SupplierProduct createIndexedSupplierProduct(String id, int version){

		SupplierProduct supplierProduct = new SupplierProduct();
		supplierProduct.setId(id);
		supplierProduct.setVersion(version);
		return supplierProduct;

	}

	protected void checkParamsForRemovingSupplierProductList(YoubenbenUserContext userContext, String goodsSupplierId,
			String supplierProductIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		for(String supplierProductIdItem: supplierProductIds){
			checkerOf(userContext).checkIdOfSupplierProduct(supplierProductIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier removeSupplierProductList(YoubenbenUserContext userContext, String goodsSupplierId,
			String supplierProductIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSupplierProductList(userContext, goodsSupplierId,  supplierProductIds, tokensExpr);


			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
			synchronized(goodsSupplier){
				//Will be good when the goodsSupplier loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				goodsSupplierDaoOf(userContext).planToRemoveSupplierProductList(goodsSupplier, supplierProductIds, allTokens());
				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplierProductList().done());
				deleteRelationListInGraph(userContext, goodsSupplier.getSupplierProductList());
				return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSupplierProduct(YoubenbenUserContext userContext, String goodsSupplierId,
		String supplierProductId, int supplierProductVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoodsSupplier( goodsSupplierId);
		checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
		checkerOf(userContext).checkVersionOfSupplierProduct(supplierProductVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier removeSupplierProduct(YoubenbenUserContext userContext, String goodsSupplierId,
		String supplierProductId, int supplierProductVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSupplierProduct(userContext,goodsSupplierId, supplierProductId, supplierProductVersion,tokensExpr);

		SupplierProduct supplierProduct = createIndexedSupplierProduct(supplierProductId, supplierProductVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.removeSupplierProduct( supplierProduct );
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplierProductList().done());
			deleteRelationInGraph(userContext, supplierProduct);
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSupplierProduct(YoubenbenUserContext userContext, String goodsSupplierId,
		String supplierProductId, int supplierProductVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoodsSupplier( goodsSupplierId);
		checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
		checkerOf(userContext).checkVersionOfSupplierProduct(supplierProductVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier copySupplierProductFrom(YoubenbenUserContext userContext, String goodsSupplierId,
		String supplierProductId, int supplierProductVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSupplierProduct(userContext,goodsSupplierId, supplierProductId, supplierProductVersion,tokensExpr);

		SupplierProduct supplierProduct = createIndexedSupplierProduct(supplierProductId, supplierProductVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			goodsSupplier.copySupplierProductFrom( supplierProduct );
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplierProductList().done());
			
			userContext.getManagerGroup().getSupplierProductManager().onNewInstanceCreated(userContext, (SupplierProduct)goodsSupplier.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSupplierProduct(YoubenbenUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
		checkerOf(userContext).checkVersionOfSupplierProduct(supplierProductVersion);
		

		if(SupplierProduct.PRODUCT_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkProductNameOfSupplierProduct(parseString(newValueExpr));
		
		}
		
		if(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkProductDescriptionOfSupplierProduct(parseString(newValueExpr));
		
		}
		
		if(SupplierProduct.PRODUCT_UNIT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkProductUnitOfSupplierProduct(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}

	public  GoodsSupplier updateSupplierProduct(YoubenbenUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSupplierProduct(userContext, goodsSupplierId, supplierProductId, supplierProductVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSupplierProductList().searchSupplierProductListWith(SupplierProduct.ID_PROPERTY, "eq", supplierProductId).done();



		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, loadTokens);

		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsSupplier.removeSupplierProduct( supplierProduct );
			//make changes to AcceleraterAccount.
			SupplierProduct supplierProductIndex = createIndexedSupplierProduct(supplierProductId, supplierProductVersion);

			SupplierProduct supplierProduct = goodsSupplier.findTheSupplierProduct(supplierProductIndex);
			if(supplierProduct == null){
				throw new GoodsSupplierManagerException(supplierProduct+" is NOT FOUND" );
			}

			supplierProduct.changeProperty(property, newValueExpr);
			
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplierProductList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingSupplyOrder(YoubenbenUserContext userContext, String goodsSupplierId, String buyerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);

		
		checkerOf(userContext).checkBuyerIdOfSupplyOrder(buyerId);
		
		checkerOf(userContext).checkTitleOfSupplyOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfSupplyOrder(totalAmount);
		
		checkerOf(userContext).checkConfirmationIdOfSupplyOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfSupplyOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfSupplyOrder(processingId);
		
		checkerOf(userContext).checkPickingIdOfSupplyOrder(pickingId);
		
		checkerOf(userContext).checkShipmentIdOfSupplyOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfSupplyOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);


	}
	public  GoodsSupplier addSupplyOrder(YoubenbenUserContext userContext, String goodsSupplierId, String buyerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSupplyOrder(userContext,goodsSupplierId,buyerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, shipmentId, deliveryId,tokensExpr);

		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, shipmentId, deliveryId);

		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, emptyOptions());
		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.addSupplyOrder( supplyOrder );
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(YoubenbenUserContext userContext, String goodsSupplierId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).checkIdOfSupplyOrder(id);

		checkerOf(userContext).checkTitleOfSupplyOrder( title);
		checkerOf(userContext).checkTotalAmountOfSupplyOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier updateSupplyOrderProperties(YoubenbenUserContext userContext, String goodsSupplierId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderProperties(userContext,goodsSupplierId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();

		GoodsSupplier goodsSupplierToUpdate = loadGoodsSupplier(userContext, goodsSupplierId, options);

		if(goodsSupplierToUpdate.getSupplyOrderList().isEmpty()){
			throw new GoodsSupplierManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}

		SupplyOrder item = goodsSupplierToUpdate.getSupplyOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingSupplyOrder(userContext,goodsSupplierId,name, code, used,tokensExpr);
		GoodsSupplier goodsSupplier = saveGoodsSupplier(userContext, goodsSupplierToUpdate, tokens().withSupplyOrderList().done());
		synchronized(goodsSupplier){
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
	}


	protected SupplyOrder createSupplyOrder(YoubenbenUserContext userContext, String buyerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId) throws Exception{

		SupplyOrder supplyOrder = new SupplyOrder();
		
		
		RetailStoreCountryCenter  buyer = new RetailStoreCountryCenter();
		buyer.setId(buyerId);		
		supplyOrder.setBuyer(buyer);		
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

	protected void checkParamsForRemovingSupplyOrderList(YoubenbenUserContext userContext, String goodsSupplierId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		for(String supplyOrderIdItem: supplyOrderIds){
			checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier removeSupplyOrderList(YoubenbenUserContext userContext, String goodsSupplierId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSupplyOrderList(userContext, goodsSupplierId,  supplyOrderIds, tokensExpr);


			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
			synchronized(goodsSupplier){
				//Will be good when the goodsSupplier loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				goodsSupplierDaoOf(userContext).planToRemoveSupplyOrderList(goodsSupplier, supplyOrderIds, allTokens());
				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, goodsSupplier.getSupplyOrderList());
				return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSupplyOrder(YoubenbenUserContext userContext, String goodsSupplierId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoodsSupplier( goodsSupplierId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier removeSupplyOrder(YoubenbenUserContext userContext, String goodsSupplierId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSupplyOrder(userContext,goodsSupplierId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.removeSupplyOrder( supplyOrder );
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSupplyOrder(YoubenbenUserContext userContext, String goodsSupplierId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoodsSupplier( goodsSupplierId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier copySupplyOrderFrom(YoubenbenUserContext userContext, String goodsSupplierId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSupplyOrder(userContext,goodsSupplierId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			supplyOrder.updateLastUpdateTime(userContext.now());

			goodsSupplier.copySupplyOrderFrom( supplyOrder );
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)goodsSupplier.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSupplyOrder(YoubenbenUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfSupplyOrder(parseString(newValueExpr));
		
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}

	public  GoodsSupplier updateSupplyOrder(YoubenbenUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSupplyOrder(userContext, goodsSupplierId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();



		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, loadTokens);

		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsSupplier.removeSupplyOrder( supplyOrder );
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);

			SupplyOrder supplyOrder = goodsSupplier.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new GoodsSupplierManagerException(supplyOrder+" is NOT FOUND" );
			}

			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withSupplyOrderList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingAccountSet(YoubenbenUserContext userContext, String goodsSupplierId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);

		
		checkerOf(userContext).checkNameOfAccountSet(name);
		
		checkerOf(userContext).checkYearSetOfAccountSet(yearSet);
		
		checkerOf(userContext).checkEffectiveDateOfAccountSet(effectiveDate);
		
		checkerOf(userContext).checkAccountingSystemOfAccountSet(accountingSystem);
		
		checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet(domesticCurrencyCode);
		
		checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet(domesticCurrencyName);
		
		checkerOf(userContext).checkOpeningBankOfAccountSet(openingBank);
		
		checkerOf(userContext).checkAccountNumberOfAccountSet(accountNumber);
		
		checkerOf(userContext).checkCountryCenterIdOfAccountSet(countryCenterId);
		
		checkerOf(userContext).checkRetailStoreIdOfAccountSet(retailStoreId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);


	}
	public  GoodsSupplier addAccountSet(YoubenbenUserContext userContext, String goodsSupplierId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountSet(userContext,goodsSupplierId,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, retailStoreId,tokensExpr);

		AccountSet accountSet = createAccountSet(userContext,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, retailStoreId);

		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, emptyOptions());
		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.addAccountSet( accountSet );
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withAccountSetList().done());
			
			userContext.getManagerGroup().getAccountSetManager().onNewInstanceCreated(userContext, accountSet);
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountSetProperties(YoubenbenUserContext userContext, String goodsSupplierId,String id,String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).checkIdOfAccountSet(id);

		checkerOf(userContext).checkNameOfAccountSet( name);
		checkerOf(userContext).checkYearSetOfAccountSet( yearSet);
		checkerOf(userContext).checkEffectiveDateOfAccountSet( effectiveDate);
		checkerOf(userContext).checkAccountingSystemOfAccountSet( accountingSystem);
		checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet( domesticCurrencyCode);
		checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet( domesticCurrencyName);
		checkerOf(userContext).checkOpeningBankOfAccountSet( openingBank);
		checkerOf(userContext).checkAccountNumberOfAccountSet( accountNumber);

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier updateAccountSetProperties(YoubenbenUserContext userContext, String goodsSupplierId, String id,String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountSetProperties(userContext,goodsSupplierId,id,name,yearSet,effectiveDate,accountingSystem,domesticCurrencyCode,domesticCurrencyName,openingBank,accountNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountSetListList()
				.searchAccountSetListWith(AccountSet.ID_PROPERTY, "is", id).done();

		GoodsSupplier goodsSupplierToUpdate = loadGoodsSupplier(userContext, goodsSupplierId, options);

		if(goodsSupplierToUpdate.getAccountSetList().isEmpty()){
			throw new GoodsSupplierManagerException("AccountSet is NOT FOUND with id: '"+id+"'");
		}

		AccountSet item = goodsSupplierToUpdate.getAccountSetList().first();

		item.updateName( name );
		item.updateYearSet( yearSet );
		item.updateEffectiveDate( effectiveDate );
		item.updateAccountingSystem( accountingSystem );
		item.updateDomesticCurrencyCode( domesticCurrencyCode );
		item.updateDomesticCurrencyName( domesticCurrencyName );
		item.updateOpeningBank( openingBank );
		item.updateAccountNumber( accountNumber );


		//checkParamsForAddingAccountSet(userContext,goodsSupplierId,name, code, used,tokensExpr);
		GoodsSupplier goodsSupplier = saveGoodsSupplier(userContext, goodsSupplierToUpdate, tokens().withAccountSetList().done());
		synchronized(goodsSupplier){
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountSet createAccountSet(YoubenbenUserContext userContext, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId) throws Exception{

		AccountSet accountSet = new AccountSet();
		
		
		accountSet.setName(name);		
		accountSet.setYearSet(yearSet);		
		accountSet.setEffectiveDate(effectiveDate);		
		accountSet.setAccountingSystem(accountingSystem);		
		accountSet.setDomesticCurrencyCode(domesticCurrencyCode);		
		accountSet.setDomesticCurrencyName(domesticCurrencyName);		
		accountSet.setOpeningBank(openingBank);		
		accountSet.setAccountNumber(accountNumber);		
		RetailStoreCountryCenter  countryCenter = new RetailStoreCountryCenter();
		countryCenter.setId(countryCenterId);		
		accountSet.setCountryCenter(countryCenter);		
		RetailStore  retailStore = new RetailStore();
		retailStore.setId(retailStoreId);		
		accountSet.setRetailStore(retailStore);		
		accountSet.setLastUpdateTime(userContext.now());
	
		
		return accountSet;


	}

	protected AccountSet createIndexedAccountSet(String id, int version){

		AccountSet accountSet = new AccountSet();
		accountSet.setId(id);
		accountSet.setVersion(version);
		return accountSet;

	}

	protected void checkParamsForRemovingAccountSetList(YoubenbenUserContext userContext, String goodsSupplierId,
			String accountSetIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		for(String accountSetIdItem: accountSetIds){
			checkerOf(userContext).checkIdOfAccountSet(accountSetIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier removeAccountSetList(YoubenbenUserContext userContext, String goodsSupplierId,
			String accountSetIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountSetList(userContext, goodsSupplierId,  accountSetIds, tokensExpr);


			GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
			synchronized(goodsSupplier){
				//Will be good when the goodsSupplier loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				goodsSupplierDaoOf(userContext).planToRemoveAccountSetList(goodsSupplier, accountSetIds, allTokens());
				goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withAccountSetList().done());
				deleteRelationListInGraph(userContext, goodsSupplier.getAccountSetList());
				return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountSet(YoubenbenUserContext userContext, String goodsSupplierId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoodsSupplier( goodsSupplierId);
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkVersionOfAccountSet(accountSetVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier removeAccountSet(YoubenbenUserContext userContext, String goodsSupplierId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountSet(userContext,goodsSupplierId, accountSetId, accountSetVersion,tokensExpr);

		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsSupplier.removeAccountSet( accountSet );
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withAccountSetList().done());
			deleteRelationInGraph(userContext, accountSet);
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountSet(YoubenbenUserContext userContext, String goodsSupplierId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoodsSupplier( goodsSupplierId);
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkVersionOfAccountSet(accountSetVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}
	public  GoodsSupplier copyAccountSetFrom(YoubenbenUserContext userContext, String goodsSupplierId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountSet(userContext,goodsSupplierId, accountSetId, accountSetVersion,tokensExpr);

		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, allTokens());
		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			accountSet.updateLastUpdateTime(userContext.now());

			goodsSupplier.copyAccountSetFrom( accountSet );
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withAccountSetList().done());
			
			userContext.getManagerGroup().getAccountSetManager().onNewInstanceCreated(userContext, (AccountSet)goodsSupplier.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountSet(YoubenbenUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkVersionOfAccountSet(accountSetVersion);
		

		if(AccountSet.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountSet(parseString(newValueExpr));
		
		}
		
		if(AccountSet.YEAR_SET_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkYearSetOfAccountSet(parseString(newValueExpr));
		
		}
		
		if(AccountSet.EFFECTIVE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEffectiveDateOfAccountSet(parseDate(newValueExpr));
		
		}
		
		if(AccountSet.ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountingSystemOfAccountSet(parseString(newValueExpr));
		
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet(parseString(newValueExpr));
		
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet(parseString(newValueExpr));
		
		}
		
		if(AccountSet.OPENING_BANK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOpeningBankOfAccountSet(parseString(newValueExpr));
		
		}
		
		if(AccountSet.ACCOUNT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAccountNumberOfAccountSet(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsSupplierManagerException.class);

	}

	public  GoodsSupplier updateAccountSet(YoubenbenUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountSet(userContext, goodsSupplierId, accountSetId, accountSetVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountSetList().searchAccountSetListWith(AccountSet.ID_PROPERTY, "eq", accountSetId).done();



		GoodsSupplier goodsSupplier = loadGoodsSupplier(userContext, goodsSupplierId, loadTokens);

		synchronized(goodsSupplier){
			//Will be good when the goodsSupplier loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsSupplier.removeAccountSet( accountSet );
			//make changes to AcceleraterAccount.
			AccountSet accountSetIndex = createIndexedAccountSet(accountSetId, accountSetVersion);

			AccountSet accountSet = goodsSupplier.findTheAccountSet(accountSetIndex);
			if(accountSet == null){
				throw new GoodsSupplierManagerException(accountSet+" is NOT FOUND" );
			}

			accountSet.changeProperty(property, newValueExpr);
			accountSet.updateLastUpdateTime(userContext.now());
			goodsSupplier = saveGoodsSupplier(userContext, goodsSupplier, tokens().withAccountSetList().done());
			return present(userContext,goodsSupplier, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, GoodsSupplier newCreated) throws Exception{
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
		//   GoodsSupplier newGoodsSupplier = this.createGoodsSupplier(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newGoodsSupplier
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, GoodsSupplier.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<GoodsSupplier> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> belongToList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(belongToList, RetailStoreCountryCenter.class);


    }
	
	public Object listByBelongTo(YoubenbenUserContext userContext,String belongToId) throws Exception {
		return listPageByBelongTo(userContext, belongToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBelongTo(YoubenbenUserContext userContext,String belongToId, int start, int count) throws Exception {
		SmartList<GoodsSupplier> list = goodsSupplierDaoOf(userContext).findGoodsSupplierByBelongTo(belongToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(GoodsSupplier.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(belongToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("产品供应商列表");
		page.setRequestName("listByBelongTo");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBelongTo/%s/",  getBeanName(), belongToId)));

		page.assemblerContent(userContext, "listByBelongTo");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String goodsSupplierId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getGoodsSupplierDetailScope().clone();
		GoodsSupplier merchantObj = (GoodsSupplier) this.view(userContext, goodsSupplierId);
    String merchantObjId = goodsSupplierId;
    String linkToUrl =	"goodsSupplierManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "产品供应商"+"详情";
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
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-supplyProduct")
				    .put("fieldName", "supplyProduct")
				    .put("label", "供应产品")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("supplyProduct", merchantObj.getSupplyProduct());

		propList.add(
				MapUtil.put("id", "4-belongTo")
				    .put("fieldName", "belongTo")
				    .put("label", "属于")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("belongTo", merchantObj.getBelongTo());

		propList.add(
				MapUtil.put("id", "5-contactNumber")
				    .put("fieldName", "contactNumber")
				    .put("label", "联系电话")
				    .put("type", "mobile")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("contactNumber", merchantObj.getContactNumber());

		propList.add(
				MapUtil.put("id", "6-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "7-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "最后更新时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：supplierProductListSection
		Map supplierProductListSection = ListofUtils.buildSection(
		    "supplierProductListSection",
		    "供应商产品列表",
		    null,
		    "",
		    "__no_group",
		    "supplierProductManager/listBySupplier/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(supplierProductListSection);

		result.put("supplierProductListSection", ListofUtils.toShortList(merchantObj.getSupplierProductList(), "supplierProduct"));
		vscope.field("supplierProductListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( SupplierProduct.class.getName(), null));

		//处理Section：supplyOrderListSection
		Map supplyOrderListSection = ListofUtils.buildSection(
		    "supplyOrderListSection",
		    "供应订单列表",
		    null,
		    "",
		    "__no_group",
		    "supplyOrderManager/listBySeller/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(supplyOrderListSection);

		result.put("supplyOrderListSection", ListofUtils.toShortList(merchantObj.getSupplyOrderList(), "supplyOrder"));
		vscope.field("supplyOrderListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( SupplyOrder.class.getName(), null));

		//处理Section：accountSetListSection
		Map accountSetListSection = ListofUtils.buildSection(
		    "accountSetListSection",
		    "帐户设置列表",
		    null,
		    "",
		    "__no_group",
		    "accountSetManager/listByGoodsSupplier/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(accountSetListSection);

		result.put("accountSetListSection", ListofUtils.toShortList(merchantObj.getAccountSetList(), "accountSet"));
		vscope.field("accountSetListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( AccountSet.class.getName(), null));

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


