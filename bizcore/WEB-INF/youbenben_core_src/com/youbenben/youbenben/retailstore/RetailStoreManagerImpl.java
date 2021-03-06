
package com.youbenben.youbenben.retailstore;

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


import com.youbenben.youbenben.retailstorefranchising.RetailStoreFranchising;
import com.youbenben.youbenben.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.youbenben.youbenben.retailstorecreation.RetailStoreCreation;
import com.youbenben.youbenben.goods.Goods;
import com.youbenben.youbenben.transporttask.TransportTask;
import com.youbenben.youbenben.consumerorder.ConsumerOrder;
import com.youbenben.youbenben.retailstoreorder.RetailStoreOrder;
import com.youbenben.youbenben.retailstoreclosing.RetailStoreClosing;
import com.youbenben.youbenben.accountset.AccountSet;
import com.youbenben.youbenben.retailstoreopening.RetailStoreOpening;
import com.youbenben.youbenben.retailstoredecoration.RetailStoreDecoration;
import com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.retailstorefranchising.CandidateRetailStoreFranchising;
import com.youbenben.youbenben.retailstoreopening.CandidateRetailStoreOpening;
import com.youbenben.youbenben.retailstoredecoration.CandidateRetailStoreDecoration;
import com.youbenben.youbenben.retailstorecityservicecenter.CandidateRetailStoreCityServiceCenter;
import com.youbenben.youbenben.retailstoreinvestmentinvitation.CandidateRetailStoreInvestmentInvitation;
import com.youbenben.youbenben.retailstorecreation.CandidateRetailStoreCreation;
import com.youbenben.youbenben.retailstoreclosing.CandidateRetailStoreClosing;
import com.youbenben.youbenben.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.youbenben.youbenben.sku.Sku;
import com.youbenben.youbenben.supplyorder.SupplyOrder;
import com.youbenben.youbenben.supplyorderapproval.SupplyOrderApproval;
import com.youbenben.youbenben.supplyorderconfirmation.SupplyOrderConfirmation;
import com.youbenben.youbenben.supplyordershipment.SupplyOrderShipment;
import com.youbenben.youbenben.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.youbenben.youbenben.retailstore.RetailStore;
import com.youbenben.youbenben.supplyorderdelivery.SupplyOrderDelivery;
import com.youbenben.youbenben.retailstoreordershipment.RetailStoreOrderShipment;
import com.youbenben.youbenben.transporttruck.TransportTruck;
import com.youbenben.youbenben.goodsallocation.GoodsAllocation;
import com.youbenben.youbenben.retailstoremember.RetailStoreMember;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;
import com.youbenben.youbenben.shippingspace.ShippingSpace;
import com.youbenben.youbenben.retailstoreorderpicking.RetailStoreOrderPicking;
import com.youbenben.youbenben.transporttask.TransportTask;
import com.youbenben.youbenben.transportfleet.TransportFleet;
import com.youbenben.youbenben.receivingspace.ReceivingSpace;
import com.youbenben.youbenben.retailstoreorder.RetailStoreOrder;
import com.youbenben.youbenben.truckdriver.TruckDriver;
import com.youbenben.youbenben.retailstoreorderapproval.RetailStoreOrderApproval;
import com.youbenben.youbenben.smartpallet.SmartPallet;
import com.youbenben.youbenben.goodssupplier.GoodsSupplier;
import com.youbenben.youbenben.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.youbenben.youbenben.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.youbenben.youbenben.goodspackaging.GoodsPackaging;
import com.youbenben.youbenben.supplyorderprocessing.SupplyOrderProcessing;






public class RetailStoreManagerImpl extends CustomYoubenbenCheckerManager implements RetailStoreManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreTokens.start().withTokenFromListName(listName).done();
		RetailStore  retailStore = (RetailStore) this.loadRetailStore(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStore.collectRefercencesFromLists();
		retailStoreDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStore, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStore";
	@Override
	public RetailStoreDAO daoOf(YoubenbenUserContext userContext) {
		return retailStoreDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreManagerException(message);

	}



 	protected RetailStore saveRetailStore(YoubenbenUserContext userContext, RetailStore retailStore, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreDAO().save(retailStore, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStore(userContext, retailStore, tokens);
 	}
 	
 	protected RetailStore saveRetailStoreDetail(YoubenbenUserContext userContext, RetailStore retailStore) throws Exception{	

 		
 		return saveRetailStore(userContext, retailStore, allTokens());
 	}
 	
 	public RetailStore loadRetailStore(YoubenbenUserContext userContext, String retailStoreId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStore, tokens);
 	}
 	
 	
 	 public RetailStore searchRetailStore(YoubenbenUserContext userContext, String retailStoreId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStore, tokens);
 	}
 	
 	

 	protected RetailStore present(YoubenbenUserContext userContext, RetailStore retailStore, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStore,tokens);
		
		
		RetailStore  retailStoreToPresent = retailStoreDaoOf(userContext).present(retailStore, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreToPresent.collectRefercencesFromLists();
		retailStoreDaoOf(userContext).alias(entityListToNaming);
		
		return  retailStoreToPresent;
		
		
	}
 
 	
 	
 	public RetailStore loadRetailStoreDetail(YoubenbenUserContext userContext, String retailStoreId) throws Exception{	
 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, allTokens());
 		return present(userContext,retailStore, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String retailStoreId) throws Exception{	
 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, viewTokens());
 		return present(userContext,retailStore, allTokens());
		
 	}
 	protected RetailStore saveRetailStore(YoubenbenUserContext userContext, RetailStore retailStore, Map<String,Object>tokens) throws Exception{	
 		return retailStoreDaoOf(userContext).save(retailStore, tokens);
 	}
 	protected RetailStore loadRetailStore(YoubenbenUserContext userContext, String retailStoreId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreManagerException.class);

 
 		return retailStoreDaoOf(userContext).load(retailStoreId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStore retailStore, Map<String, Object> tokens){
		super.addActions(userContext, retailStore, tokens);
		
		addAction(userContext, retailStore, tokens,"@create","createRetailStore","createRetailStore/","main","primary");
		addAction(userContext, retailStore, tokens,"@update","updateRetailStore","updateRetailStore/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"@copy","cloneRetailStore","cloneRetailStore/"+retailStore.getId()+"/","main","primary");
		
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_retail_store_country_center","transferToAnotherRetailStoreCountryCenter","transferToAnotherRetailStoreCountryCenter/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_city_service_center","transferToAnotherCityServiceCenter","transferToAnotherCityServiceCenter/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_creation","transferToAnotherCreation","transferToAnotherCreation/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_investment_invitation","transferToAnotherInvestmentInvitation","transferToAnotherInvestmentInvitation/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_franchising","transferToAnotherFranchising","transferToAnotherFranchising/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_decoration","transferToAnotherDecoration","transferToAnotherDecoration/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_opening","transferToAnotherOpening","transferToAnotherOpening/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_closing","transferToAnotherClosing","transferToAnotherClosing/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addGoods","addGoods","addGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeGoods","removeGoods","removeGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateGoods","updateGoods","updateGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addTransportTask","addTransportTask","addTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeTransportTask","removeTransportTask","removeTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateTransportTask","updateTransportTask","updateTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addAccountSet","addAccountSet","addAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeAccountSet","removeAccountSet","removeAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateAccountSet","updateAccountSet","updateAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyAccountSetFrom","copyAccountSetFrom","copyAccountSetFrom/"+retailStore.getId()+"/","accountSetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, RetailStore retailStore, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStore createRetailStore(YoubenbenUserContext userContext, String name,String telephone,String owner,String retailStoreCountryCenterId,String cityServiceCenterId,String creationId,String investmentInvitationId,String franchisingId,String decorationId,String openingId,String closingId,Date founded,BigDecimal latitude,BigDecimal longitude,String description) throws Exception
	//public RetailStore createRetailStore(YoubenbenUserContext userContext,String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfRetailStore(name);
		checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
		checkerOf(userContext).checkOwnerOfRetailStore(owner);
		checkerOf(userContext).checkFoundedOfRetailStore(founded);
		checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
		checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
		checkerOf(userContext).checkDescriptionOfRetailStore(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


		RetailStore retailStore=createNewRetailStore();	

		retailStore.setName(name);
		retailStore.setTelephone(telephone);
		retailStore.setOwner(owner);
			
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId,emptyOptions());
		retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);
		
		
			
		RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(userContext, cityServiceCenterId,emptyOptions());
		retailStore.setCityServiceCenter(cityServiceCenter);
		
		
			
		RetailStoreCreation creation = loadRetailStoreCreation(userContext, creationId,emptyOptions());
		retailStore.setCreation(creation);
		
		
			
		RetailStoreInvestmentInvitation investmentInvitation = loadRetailStoreInvestmentInvitation(userContext, investmentInvitationId,emptyOptions());
		retailStore.setInvestmentInvitation(investmentInvitation);
		
		
			
		RetailStoreFranchising franchising = loadRetailStoreFranchising(userContext, franchisingId,emptyOptions());
		retailStore.setFranchising(franchising);
		
		
			
		RetailStoreDecoration decoration = loadRetailStoreDecoration(userContext, decorationId,emptyOptions());
		retailStore.setDecoration(decoration);
		
		
			
		RetailStoreOpening opening = loadRetailStoreOpening(userContext, openingId,emptyOptions());
		retailStore.setOpening(opening);
		
		
			
		RetailStoreClosing closing = loadRetailStoreClosing(userContext, closingId,emptyOptions());
		retailStore.setClosing(closing);
		
		
		retailStore.setFounded(founded);
		retailStore.setLatitude(latitude);
		retailStore.setLongitude(longitude);
		retailStore.setDescription(description);
		retailStore.setLastUpdateTime(userContext.now());

		retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStore);
		return retailStore;


	}
	protected RetailStore createNewRetailStore()
	{

		return new RetailStore();
	}

	protected void checkParamsForUpdatingRetailStore(YoubenbenUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore( retailStoreVersion);
		

		if(RetailStore.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStore(parseString(newValueExpr));
		
			
		}
		if(RetailStore.TELEPHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTelephoneOfRetailStore(parseString(newValueExpr));
		
			
		}
		if(RetailStore.OWNER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOwnerOfRetailStore(parseString(newValueExpr));
		
			
		}		

				

				

				

				

				

				

				

		
		if(RetailStore.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfRetailStore(parseDate(newValueExpr));
		
			
		}
		if(RetailStore.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfRetailStore(parseBigDecimal(newValueExpr));
		
			
		}
		if(RetailStore.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfRetailStore(parseBigDecimal(newValueExpr));
		
			
		}
		if(RetailStore.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfRetailStore(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}



	public RetailStore clone(YoubenbenUserContext userContext, String fromRetailStoreId) throws Exception{

		return retailStoreDaoOf(userContext).clone(fromRetailStoreId, this.allTokens());
	}

	public RetailStore internalSaveRetailStore(YoubenbenUserContext userContext, RetailStore retailStore) throws Exception
	{
		return internalSaveRetailStore(userContext, retailStore, allTokens());

	}
	public RetailStore internalSaveRetailStore(YoubenbenUserContext userContext, RetailStore retailStore, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStore(userContext, retailStoreId, retailStoreVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStore.
			if (retailStore.isChanged()){
			retailStore.updateLastUpdateTime(userContext.now());
			}
			retailStore = saveRetailStore(userContext, retailStore, options);
			return retailStore;

		}

	}

	public RetailStore updateRetailStore(YoubenbenUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStore(userContext, retailStoreId, retailStoreVersion, property, newValueExpr, tokensExpr);



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		if(retailStore.getVersion() != retailStoreVersion){
			String message = "The target version("+retailStore.getVersion()+") is not equals to version("+retailStoreVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStore.
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore.changeProperty(property, newValueExpr);
			retailStore = saveRetailStore(userContext, retailStore, tokens().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			//return saveRetailStore(userContext, retailStore, tokens().done());
		}

	}

	public RetailStore updateRetailStoreProperty(YoubenbenUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStore(userContext, retailStoreId, retailStoreVersion, property, newValueExpr, tokensExpr);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		if(retailStore.getVersion() != retailStoreVersion){
			String message = "The target version("+retailStore.getVersion()+") is not equals to version("+retailStoreVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStore.

			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			//return saveRetailStore(userContext, retailStore, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreTokens tokens(){
		return RetailStoreTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortRetailStoreOrderListWith("id","desc")
		.sortGoodsListWith("id","desc")
		.sortTransportTaskListWith("id","desc")
		.sortAccountSetListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherRetailStoreCountryCenter(YoubenbenUserContext userContext, String retailStoreId, String anotherRetailStoreCountryCenterId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherRetailStoreCountryCenterId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherRetailStoreCountryCenter(YoubenbenUserContext userContext, String retailStoreId, String anotherRetailStoreCountryCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherRetailStoreCountryCenter(userContext, retailStoreId,anotherRetailStoreCountryCenterId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, anotherRetailStoreCountryCenterId, emptyOptions());		
			retailStore.updateRetailStoreCountryCenter(retailStoreCountryCenter);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreCountryCenter requestCandidateRetailStoreCountryCenter(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherCityServiceCenter(YoubenbenUserContext userContext, String retailStoreId, String anotherCityServiceCenterId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(anotherCityServiceCenterId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherCityServiceCenter(YoubenbenUserContext userContext, String retailStoreId, String anotherCityServiceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityServiceCenter(userContext, retailStoreId,anotherCityServiceCenterId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(userContext, anotherCityServiceCenterId, emptyOptions());		
			retailStore.updateCityServiceCenter(cityServiceCenter);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreCityServiceCenter requestCandidateCityServiceCenter(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCityServiceCenter result = new CandidateRetailStoreCityServiceCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCityServiceCenter> candidateList = retailStoreCityServiceCenterDaoOf(userContext).requestCandidateRetailStoreCityServiceCenterForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherCreation(YoubenbenUserContext userContext, String retailStoreId, String anotherCreationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreCreation(anotherCreationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherCreation(YoubenbenUserContext userContext, String retailStoreId, String anotherCreationId) throws Exception
 	{
 		checkParamsForTransferingAnotherCreation(userContext, retailStoreId,anotherCreationId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCreation creation = loadRetailStoreCreation(userContext, anotherCreationId, emptyOptions());		
			retailStore.updateCreation(creation);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreCreation requestCandidateCreation(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCreation result = new CandidateRetailStoreCreation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCreation> candidateList = retailStoreCreationDaoOf(userContext).requestCandidateRetailStoreCreationForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherInvestmentInvitation(YoubenbenUserContext userContext, String retailStoreId, String anotherInvestmentInvitationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation(anotherInvestmentInvitationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherInvestmentInvitation(YoubenbenUserContext userContext, String retailStoreId, String anotherInvestmentInvitationId) throws Exception
 	{
 		checkParamsForTransferingAnotherInvestmentInvitation(userContext, retailStoreId,anotherInvestmentInvitationId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreInvestmentInvitation investmentInvitation = loadRetailStoreInvestmentInvitation(userContext, anotherInvestmentInvitationId, emptyOptions());		
			retailStore.updateInvestmentInvitation(investmentInvitation);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreInvestmentInvitation requestCandidateInvestmentInvitation(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreInvestmentInvitation result = new CandidateRetailStoreInvestmentInvitation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreInvestmentInvitation> candidateList = retailStoreInvestmentInvitationDaoOf(userContext).requestCandidateRetailStoreInvestmentInvitationForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherFranchising(YoubenbenUserContext userContext, String retailStoreId, String anotherFranchisingId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreFranchising(anotherFranchisingId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherFranchising(YoubenbenUserContext userContext, String retailStoreId, String anotherFranchisingId) throws Exception
 	{
 		checkParamsForTransferingAnotherFranchising(userContext, retailStoreId,anotherFranchisingId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreFranchising franchising = loadRetailStoreFranchising(userContext, anotherFranchisingId, emptyOptions());		
			retailStore.updateFranchising(franchising);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreFranchising requestCandidateFranchising(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreFranchising result = new CandidateRetailStoreFranchising();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreFranchising> candidateList = retailStoreFranchisingDaoOf(userContext).requestCandidateRetailStoreFranchisingForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherDecoration(YoubenbenUserContext userContext, String retailStoreId, String anotherDecorationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreDecoration(anotherDecorationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherDecoration(YoubenbenUserContext userContext, String retailStoreId, String anotherDecorationId) throws Exception
 	{
 		checkParamsForTransferingAnotherDecoration(userContext, retailStoreId,anotherDecorationId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreDecoration decoration = loadRetailStoreDecoration(userContext, anotherDecorationId, emptyOptions());		
			retailStore.updateDecoration(decoration);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreDecoration requestCandidateDecoration(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreDecoration result = new CandidateRetailStoreDecoration();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreDecoration> candidateList = retailStoreDecorationDaoOf(userContext).requestCandidateRetailStoreDecorationForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherOpening(YoubenbenUserContext userContext, String retailStoreId, String anotherOpeningId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreOpening(anotherOpeningId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherOpening(YoubenbenUserContext userContext, String retailStoreId, String anotherOpeningId) throws Exception
 	{
 		checkParamsForTransferingAnotherOpening(userContext, retailStoreId,anotherOpeningId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOpening opening = loadRetailStoreOpening(userContext, anotherOpeningId, emptyOptions());		
			retailStore.updateOpening(opening);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreOpening requestCandidateOpening(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOpening result = new CandidateRetailStoreOpening();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOpening> candidateList = retailStoreOpeningDaoOf(userContext).requestCandidateRetailStoreOpeningForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherClosing(YoubenbenUserContext userContext, String retailStoreId, String anotherClosingId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreClosing(anotherClosingId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherClosing(YoubenbenUserContext userContext, String retailStoreId, String anotherClosingId) throws Exception
 	{
 		checkParamsForTransferingAnotherClosing(userContext, retailStoreId,anotherClosingId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreClosing closing = loadRetailStoreClosing(userContext, anotherClosingId, emptyOptions());		
			retailStore.updateClosing(closing);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreClosing requestCandidateClosing(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreClosing result = new CandidateRetailStoreClosing();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreClosing> candidateList = retailStoreClosingDaoOf(userContext).requestCandidateRetailStoreClosingForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreOpening loadRetailStoreOpening(YoubenbenUserContext userContext, String newOpeningId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreOpeningDaoOf(userContext).load(newOpeningId, options);
 	}
 	


	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(YoubenbenUserContext userContext, String newRetailStoreCountryCenterId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newRetailStoreCountryCenterId, options);
 	}
 	


	

 	protected RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String newCityServiceCenterId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCityServiceCenterDaoOf(userContext).load(newCityServiceCenterId, options);
 	}
 	


	

 	protected RetailStoreClosing loadRetailStoreClosing(YoubenbenUserContext userContext, String newClosingId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreClosingDaoOf(userContext).load(newClosingId, options);
 	}
 	


	

 	protected RetailStoreCreation loadRetailStoreCreation(YoubenbenUserContext userContext, String newCreationId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCreationDaoOf(userContext).load(newCreationId, options);
 	}
 	


	

 	protected RetailStoreFranchising loadRetailStoreFranchising(YoubenbenUserContext userContext, String newFranchisingId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreFranchisingDaoOf(userContext).load(newFranchisingId, options);
 	}
 	


	

 	protected RetailStoreDecoration loadRetailStoreDecoration(YoubenbenUserContext userContext, String newDecorationId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreDecorationDaoOf(userContext).load(newDecorationId, options);
 	}
 	


	

 	protected RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(YoubenbenUserContext userContext, String newInvestmentInvitationId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreInvestmentInvitationDaoOf(userContext).load(newInvestmentInvitationId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String retailStoreId, int retailStoreVersion) throws Exception {
		//deleteInternal(userContext, retailStoreId, retailStoreVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String retailStoreId, int retailStoreVersion) throws Exception{

		retailStoreDaoOf(userContext).delete(retailStoreId, retailStoreVersion);
	}

	public RetailStore forgetByAll(YoubenbenUserContext userContext, String retailStoreId, int retailStoreVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreId, retailStoreVersion);
	}
	protected RetailStore forgetByAllInternal(YoubenbenUserContext userContext,
			String retailStoreId, int retailStoreVersion) throws Exception{

		return retailStoreDaoOf(userContext).disconnectFromAll(retailStoreId, retailStoreVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return retailStoreDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStore with consumer in ConsumerOrder
	protected RetailStore breakWithConsumerOrderByConsumer(YoubenbenUserContext userContext, String retailStoreId, String consumerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveConsumerOrderListWithConsumer(retailStore, consumerId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with confirmation in ConsumerOrder
	protected RetailStore breakWithConsumerOrderByConfirmation(YoubenbenUserContext userContext, String retailStoreId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveConsumerOrderListWithConfirmation(retailStore, confirmationId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with approval in ConsumerOrder
	protected RetailStore breakWithConsumerOrderByApproval(YoubenbenUserContext userContext, String retailStoreId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveConsumerOrderListWithApproval(retailStore, approvalId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with processing in ConsumerOrder
	protected RetailStore breakWithConsumerOrderByProcessing(YoubenbenUserContext userContext, String retailStoreId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveConsumerOrderListWithProcessing(retailStore, processingId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with shipment in ConsumerOrder
	protected RetailStore breakWithConsumerOrderByShipment(YoubenbenUserContext userContext, String retailStoreId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveConsumerOrderListWithShipment(retailStore, shipmentId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with delivery in ConsumerOrder
	protected RetailStore breakWithConsumerOrderByDelivery(YoubenbenUserContext userContext, String retailStoreId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveConsumerOrderListWithDelivery(retailStore, deliveryId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with seller in RetailStoreOrder
	protected RetailStore breakWithRetailStoreOrderBySeller(YoubenbenUserContext userContext, String retailStoreId, String sellerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveRetailStoreOrderListWithSeller(retailStore, sellerId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with confirmation in RetailStoreOrder
	protected RetailStore breakWithRetailStoreOrderByConfirmation(YoubenbenUserContext userContext, String retailStoreId, String confirmationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveRetailStoreOrderListWithConfirmation(retailStore, confirmationId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with approval in RetailStoreOrder
	protected RetailStore breakWithRetailStoreOrderByApproval(YoubenbenUserContext userContext, String retailStoreId, String approvalId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveRetailStoreOrderListWithApproval(retailStore, approvalId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with processing in RetailStoreOrder
	protected RetailStore breakWithRetailStoreOrderByProcessing(YoubenbenUserContext userContext, String retailStoreId, String processingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveRetailStoreOrderListWithProcessing(retailStore, processingId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with picking in RetailStoreOrder
	protected RetailStore breakWithRetailStoreOrderByPicking(YoubenbenUserContext userContext, String retailStoreId, String pickingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveRetailStoreOrderListWithPicking(retailStore, pickingId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with shipment in RetailStoreOrder
	protected RetailStore breakWithRetailStoreOrderByShipment(YoubenbenUserContext userContext, String retailStoreId, String shipmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveRetailStoreOrderListWithShipment(retailStore, shipmentId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with delivery in RetailStoreOrder
	protected RetailStore breakWithRetailStoreOrderByDelivery(YoubenbenUserContext userContext, String retailStoreId, String deliveryId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveRetailStoreOrderListWithDelivery(retailStore, deliveryId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with sku in Goods
	protected RetailStore breakWithGoodsBySku(YoubenbenUserContext userContext, String retailStoreId, String skuId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveGoodsListWithSku(retailStore, skuId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with receiving_space in Goods
	protected RetailStore breakWithGoodsByReceivingSpace(YoubenbenUserContext userContext, String retailStoreId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveGoodsListWithReceivingSpace(retailStore, receivingSpaceId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with goods_allocation in Goods
	protected RetailStore breakWithGoodsByGoodsAllocation(YoubenbenUserContext userContext, String retailStoreId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveGoodsListWithGoodsAllocation(retailStore, goodsAllocationId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with smart_pallet in Goods
	protected RetailStore breakWithGoodsBySmartPallet(YoubenbenUserContext userContext, String retailStoreId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveGoodsListWithSmartPallet(retailStore, smartPalletId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with shipping_space in Goods
	protected RetailStore breakWithGoodsByShippingSpace(YoubenbenUserContext userContext, String retailStoreId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveGoodsListWithShippingSpace(retailStore, shippingSpaceId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with transport_task in Goods
	protected RetailStore breakWithGoodsByTransportTask(YoubenbenUserContext userContext, String retailStoreId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveGoodsListWithTransportTask(retailStore, transportTaskId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with biz_order in Goods
	protected RetailStore breakWithGoodsByBizOrder(YoubenbenUserContext userContext, String retailStoreId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveGoodsListWithBizOrder(retailStore, bizOrderId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with retail_store_order in Goods
	protected RetailStore breakWithGoodsByRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveGoodsListWithRetailStoreOrder(retailStore, retailStoreOrderId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with packaging in Goods
	protected RetailStore breakWithGoodsByPackaging(YoubenbenUserContext userContext, String retailStoreId, String packagingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveGoodsListWithPackaging(retailStore, packagingId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with driver in TransportTask
	protected RetailStore breakWithTransportTaskByDriver(YoubenbenUserContext userContext, String retailStoreId, String driverId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveTransportTaskListWithDriver(retailStore, driverId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with truck in TransportTask
	protected RetailStore breakWithTransportTaskByTruck(YoubenbenUserContext userContext, String retailStoreId, String truckId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveTransportTaskListWithTruck(retailStore, truckId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with belongs_to in TransportTask
	protected RetailStore breakWithTransportTaskByBelongsTo(YoubenbenUserContext userContext, String retailStoreId, String belongsToId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveTransportTaskListWithBelongsTo(retailStore, belongsToId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with country_center in AccountSet
	protected RetailStore breakWithAccountSetByCountryCenter(YoubenbenUserContext userContext, String retailStoreId, String countryCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveAccountSetListWithCountryCenter(retailStore, countryCenterId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with goods_supplier in AccountSet
	protected RetailStore breakWithAccountSetByGoodsSupplier(YoubenbenUserContext userContext, String retailStoreId, String goodsSupplierId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDaoOf(userContext).planToRemoveAccountSetListWithGoodsSupplier(retailStore, goodsSupplierId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
				return retailStore;
			}
	}






	protected void checkParamsForAddingConsumerOrder(YoubenbenUserContext userContext, String retailStoreId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStore(retailStoreId);

		
		checkerOf(userContext).checkTitleOfConsumerOrder(title);
		
		checkerOf(userContext).checkConsumerIdOfConsumerOrder(consumerId);
		
		checkerOf(userContext).checkConfirmationIdOfConsumerOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfConsumerOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfConsumerOrder(processingId);
		
		checkerOf(userContext).checkShipmentIdOfConsumerOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfConsumerOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore addConsumerOrder(YoubenbenUserContext userContext, String retailStoreId, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingConsumerOrder(userContext,retailStoreId,title, consumerId, confirmationId, approvalId, processingId, shipmentId, deliveryId,tokensExpr);

		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, confirmationId, approvalId, processingId, shipmentId, deliveryId);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, emptyOptions());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addConsumerOrder( consumerOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(YoubenbenUserContext userContext, String retailStoreId,String id,String title,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfConsumerOrder(id);

		checkerOf(userContext).checkTitleOfConsumerOrder( title);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore updateConsumerOrderProperties(YoubenbenUserContext userContext, String retailStoreId, String id,String title, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderProperties(userContext,retailStoreId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();

		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);

		if(retailStoreToUpdate.getConsumerOrderList().isEmpty()){
			throw new RetailStoreManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrder item = retailStoreToUpdate.getConsumerOrderList().first();

		item.updateTitle( title );


		//checkParamsForAddingConsumerOrder(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withConsumerOrderList().done());
		synchronized(retailStore){
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}


	protected ConsumerOrder createConsumerOrder(YoubenbenUserContext userContext, String title, String consumerId, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId) throws Exception{

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
		SupplyOrderDelivery  delivery = new SupplyOrderDelivery();
		delivery.setId(deliveryId);		
		consumerOrder.setDelivery(delivery);		
		consumerOrder.setLastUpdateTime(userContext.now());
	
		
		return consumerOrder;


	}

	protected ConsumerOrder createIndexedConsumerOrder(String id, int version){

		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(version);
		return consumerOrder;

	}

	protected void checkParamsForRemovingConsumerOrderList(YoubenbenUserContext userContext, String retailStoreId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		for(String consumerOrderIdItem: consumerOrderIds){
			checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeConsumerOrderList(YoubenbenUserContext userContext, String retailStoreId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderList(userContext, retailStoreId,  consumerOrderIds, tokensExpr);


			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreDaoOf(userContext).planToRemoveConsumerOrderList(retailStore, consumerOrderIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, retailStore.getConsumerOrderList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrder(YoubenbenUserContext userContext, String retailStoreId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeConsumerOrder(YoubenbenUserContext userContext, String retailStoreId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrder(userContext,retailStoreId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeConsumerOrder( consumerOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrder(YoubenbenUserContext userContext, String retailStoreId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore copyConsumerOrderFrom(YoubenbenUserContext userContext, String retailStoreId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrder(userContext,retailStoreId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			consumerOrder.updateLastUpdateTime(userContext.now());

			retailStore.copyConsumerOrderFrom( consumerOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrder(YoubenbenUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}

	public  RetailStore updateConsumerOrder(YoubenbenUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrder(userContext, retailStoreId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);

		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeConsumerOrder( consumerOrder );
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);

			ConsumerOrder consumerOrder = retailStore.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new RetailStoreManagerException(consumerOrder+" is NOT FOUND" );
			}

			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStore(retailStoreId);

		
		checkerOf(userContext).checkSellerIdOfRetailStoreOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfRetailStoreOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(totalAmount);
		
		checkerOf(userContext).checkConfirmationIdOfRetailStoreOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfRetailStoreOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfRetailStoreOrder(processingId);
		
		checkerOf(userContext).checkPickingIdOfRetailStoreOrder(pickingId);
		
		checkerOf(userContext).checkShipmentIdOfRetailStoreOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfRetailStoreOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore addRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreOrder(userContext,retailStoreId,sellerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, shipmentId, deliveryId,tokensExpr);

		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,sellerId, title, totalAmount, confirmationId, approvalId, processingId, pickingId, shipmentId, deliveryId);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, emptyOptions());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addRetailStoreOrder( retailStoreOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(YoubenbenUserContext userContext, String retailStoreId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(id);

		checkerOf(userContext).checkTitleOfRetailStoreOrder( title);
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore updateRetailStoreOrderProperties(YoubenbenUserContext userContext, String retailStoreId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "is", id).done();

		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);

		if(retailStoreToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreOrder item = retailStoreToUpdate.getRetailStoreOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStore){
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreOrder createRetailStoreOrder(YoubenbenUserContext userContext, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId) throws Exception{

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		
		
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

	protected void checkParamsForRemovingRetailStoreOrderList(YoubenbenUserContext userContext, String retailStoreId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		for(String retailStoreOrderIdItem: retailStoreOrderIds){
			checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeRetailStoreOrderList(YoubenbenUserContext userContext, String retailStoreId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreId,  retailStoreOrderIds, tokensExpr);


			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreDaoOf(userContext).planToRemoveRetailStoreOrderList(retailStore, retailStoreOrderIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStore.getRetailStoreOrderList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeRetailStoreOrder( retailStoreOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore copyRetailStoreOrderFrom(YoubenbenUserContext userContext, String retailStoreId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStoreOrder.updateLastUpdateTime(userContext.now());

			retailStore.copyRetailStoreOrderFrom( retailStoreOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, (RetailStoreOrder)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}

	public  RetailStore updateRetailStoreOrder(YoubenbenUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "eq", retailStoreOrderId).done();



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);

		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeRetailStoreOrder( retailStoreOrder );
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);

			RetailStoreOrder retailStoreOrder = retailStore.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreManagerException(retailStoreOrder+" is NOT FOUND" );
			}

			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingGoods(YoubenbenUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId, String packagingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStore(retailStoreId);

		
		checkerOf(userContext).checkNameOfGoods(name);
		
		checkerOf(userContext).checkRfidOfGoods(rfid);
		
		checkerOf(userContext).checkUomOfGoods(uom);
		
		checkerOf(userContext).checkMaxPackageOfGoods(maxPackage);
		
		checkerOf(userContext).checkExpireTimeOfGoods(expireTime);
		
		checkerOf(userContext).checkSkuIdOfGoods(skuId);
		
		checkerOf(userContext).checkReceivingSpaceIdOfGoods(receivingSpaceId);
		
		checkerOf(userContext).checkGoodsAllocationIdOfGoods(goodsAllocationId);
		
		checkerOf(userContext).checkSmartPalletIdOfGoods(smartPalletId);
		
		checkerOf(userContext).checkShippingSpaceIdOfGoods(shippingSpaceId);
		
		checkerOf(userContext).checkTransportTaskIdOfGoods(transportTaskId);
		
		checkerOf(userContext).checkBizOrderIdOfGoods(bizOrderId);
		
		checkerOf(userContext).checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
		
		checkerOf(userContext).checkPackagingIdOfGoods(packagingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore addGoods(YoubenbenUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId, String packagingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingGoods(userContext,retailStoreId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, bizOrderId, retailStoreOrderId, packagingId,tokensExpr);

		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, bizOrderId, retailStoreOrderId, packagingId);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, emptyOptions());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addGoods( goods );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, goods);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(YoubenbenUserContext userContext, String retailStoreId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfGoods(id);

		checkerOf(userContext).checkNameOfGoods( name);
		checkerOf(userContext).checkRfidOfGoods( rfid);
		checkerOf(userContext).checkUomOfGoods( uom);
		checkerOf(userContext).checkMaxPackageOfGoods( maxPackage);
		checkerOf(userContext).checkExpireTimeOfGoods( expireTime);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore updateGoodsProperties(YoubenbenUserContext userContext, String retailStoreId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsProperties(userContext,retailStoreId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, "is", id).done();

		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);

		if(retailStoreToUpdate.getGoodsList().isEmpty()){
			throw new RetailStoreManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}

		Goods item = retailStoreToUpdate.getGoodsList().first();

		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );


		//checkParamsForAddingGoods(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withGoodsList().done());
		synchronized(retailStore){
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}


	protected Goods createGoods(YoubenbenUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId, String packagingId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
		Sku  sku = new Sku();
		sku.setId(skuId);		
		goods.setSku(sku);		
		ReceivingSpace  receivingSpace = new ReceivingSpace();
		receivingSpace.setId(receivingSpaceId);		
		goods.setReceivingSpace(receivingSpace);		
		GoodsAllocation  goodsAllocation = new GoodsAllocation();
		goodsAllocation.setId(goodsAllocationId);		
		goods.setGoodsAllocation(goodsAllocation);		
		SmartPallet  smartPallet = new SmartPallet();
		smartPallet.setId(smartPalletId);		
		goods.setSmartPallet(smartPallet);		
		ShippingSpace  shippingSpace = new ShippingSpace();
		shippingSpace.setId(shippingSpaceId);		
		goods.setShippingSpace(shippingSpace);		
		TransportTask  transportTask = new TransportTask();
		transportTask.setId(transportTaskId);		
		goods.setTransportTask(transportTask);		
		SupplyOrder  bizOrder = new SupplyOrder();
		bizOrder.setId(bizOrderId);		
		goods.setBizOrder(bizOrder);		
		RetailStoreOrder  retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(retailStoreOrderId);		
		goods.setRetailStoreOrder(retailStoreOrder);		
		GoodsPackaging  packaging = new GoodsPackaging();
		packaging.setId(packagingId);		
		goods.setPackaging(packaging);
	
		
		return goods;


	}

	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;

	}

	protected void checkParamsForRemovingGoodsList(YoubenbenUserContext userContext, String retailStoreId,
			String goodsIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		for(String goodsIdItem: goodsIds){
			checkerOf(userContext).checkIdOfGoods(goodsIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeGoodsList(YoubenbenUserContext userContext, String retailStoreId,
			String goodsIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsList(userContext, retailStoreId,  goodsIds, tokensExpr);


			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreDaoOf(userContext).planToRemoveGoodsList(retailStore, goodsIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, retailStore.getGoodsList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoods(YoubenbenUserContext userContext, String retailStoreId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeGoods(YoubenbenUserContext userContext, String retailStoreId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingGoods(userContext,retailStoreId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeGoods( goods );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingGoods(YoubenbenUserContext userContext, String retailStoreId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore copyGoodsFrom(YoubenbenUserContext userContext, String retailStoreId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingGoods(userContext,retailStoreId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStore.copyGoodsFrom( goods );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, (Goods)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoods(YoubenbenUserContext userContext, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		

		if(Goods.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfGoods(parseString(newValueExpr));
		
		}
		
		if(Goods.RFID_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRfidOfGoods(parseString(newValueExpr));
		
		}
		
		if(Goods.UOM_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUomOfGoods(parseString(newValueExpr));
		
		}
		
		if(Goods.MAX_PACKAGE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMaxPackageOfGoods(parseInt(newValueExpr));
		
		}
		
		if(Goods.EXPIRE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkExpireTimeOfGoods(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}

	public  RetailStore updateGoods(YoubenbenUserContext userContext, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoods(userContext, retailStoreId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, "eq", goodsId).done();



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);

		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeGoods( goods );
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);

			Goods goods = retailStore.findTheGoods(goodsIndex);
			if(goods == null){
				throw new RetailStoreManagerException(goods+" is NOT FOUND" );
			}

			goods.changeProperty(property, newValueExpr);
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingTransportTask(YoubenbenUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStore(retailStoreId);

		
		checkerOf(userContext).checkNameOfTransportTask(name);
		
		checkerOf(userContext).checkStartOfTransportTask(start);
		
		checkerOf(userContext).checkBeginTimeOfTransportTask(beginTime);
		
		checkerOf(userContext).checkDriverIdOfTransportTask(driverId);
		
		checkerOf(userContext).checkTruckIdOfTransportTask(truckId);
		
		checkerOf(userContext).checkBelongsToIdOfTransportTask(belongsToId);
		
		checkerOf(userContext).checkLatitudeOfTransportTask(latitude);
		
		checkerOf(userContext).checkLongitudeOfTransportTask(longitude);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore addTransportTask(YoubenbenUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingTransportTask(userContext,retailStoreId,name, start, beginTime, driverId, truckId, belongsToId, latitude, longitude,tokensExpr);

		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, driverId, truckId, belongsToId, latitude, longitude);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, emptyOptions());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addTransportTask( transportTask );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskProperties(YoubenbenUserContext userContext, String retailStoreId,String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfTransportTask(id);

		checkerOf(userContext).checkNameOfTransportTask( name);
		checkerOf(userContext).checkStartOfTransportTask( start);
		checkerOf(userContext).checkBeginTimeOfTransportTask( beginTime);
		checkerOf(userContext).checkLatitudeOfTransportTask( latitude);
		checkerOf(userContext).checkLongitudeOfTransportTask( longitude);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore updateTransportTaskProperties(YoubenbenUserContext userContext, String retailStoreId, String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportTaskProperties(userContext,retailStoreId,id,name,start,beginTime,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListList()
				.searchTransportTaskListWith(TransportTask.ID_PROPERTY, "is", id).done();

		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);

		if(retailStoreToUpdate.getTransportTaskList().isEmpty()){
			throw new RetailStoreManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}

		TransportTask item = retailStoreToUpdate.getTransportTaskList().first();

		item.updateName( name );
		item.updateStart( start );
		item.updateBeginTime( beginTime );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );


		//checkParamsForAddingTransportTask(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withTransportTaskList().done());
		synchronized(retailStore){
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}


	protected TransportTask createTransportTask(YoubenbenUserContext userContext, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		transportTask.setStart(start);		
		transportTask.setBeginTime(beginTime);		
		TruckDriver  driver = new TruckDriver();
		driver.setId(driverId);		
		transportTask.setDriver(driver);		
		TransportTruck  truck = new TransportTruck();
		truck.setId(truckId);		
		transportTask.setTruck(truck);		
		TransportFleet  belongsTo = new TransportFleet();
		belongsTo.setId(belongsToId);		
		transportTask.setBelongsTo(belongsTo);		
		transportTask.setLatitude(latitude);		
		transportTask.setLongitude(longitude);
	
		
		return transportTask;


	}

	protected TransportTask createIndexedTransportTask(String id, int version){

		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(version);
		return transportTask;

	}

	protected void checkParamsForRemovingTransportTaskList(YoubenbenUserContext userContext, String retailStoreId,
			String transportTaskIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		for(String transportTaskIdItem: transportTaskIds){
			checkerOf(userContext).checkIdOfTransportTask(transportTaskIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeTransportTaskList(YoubenbenUserContext userContext, String retailStoreId,
			String transportTaskIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTransportTaskList(userContext, retailStoreId,  transportTaskIds, tokensExpr);


			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreDaoOf(userContext).planToRemoveTransportTaskList(retailStore, transportTaskIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, retailStore.getTransportTaskList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTransportTask(YoubenbenUserContext userContext, String retailStoreId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeTransportTask(YoubenbenUserContext userContext, String retailStoreId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingTransportTask(userContext,retailStoreId, transportTaskId, transportTaskVersion,tokensExpr);

		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeTransportTask( transportTask );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingTransportTask(YoubenbenUserContext userContext, String retailStoreId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore copyTransportTaskFrom(YoubenbenUserContext userContext, String retailStoreId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingTransportTask(userContext,retailStoreId, transportTaskId, transportTaskVersion,tokensExpr);

		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStore.copyTransportTaskFrom( transportTask );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTransportTask(YoubenbenUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfTransportTask(parseString(newValueExpr));
		
		}
		
		if(TransportTask.START_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkStartOfTransportTask(parseString(newValueExpr));
		
		}
		
		if(TransportTask.BEGIN_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBeginTimeOfTransportTask(parseDate(newValueExpr));
		
		}
		
		if(TransportTask.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfTransportTask(parseBigDecimal(newValueExpr));
		
		}
		
		if(TransportTask.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfTransportTask(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}

	public  RetailStore updateTransportTask(YoubenbenUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTransportTask(userContext, retailStoreId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTransportTaskList().searchTransportTaskListWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);

		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeTransportTask( transportTask );
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);

			TransportTask transportTask = retailStore.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new RetailStoreManagerException(transportTask+" is NOT FOUND" );
			}

			transportTask.changeProperty(property, newValueExpr);
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingAccountSet(YoubenbenUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStore(retailStoreId);

		
		checkerOf(userContext).checkNameOfAccountSet(name);
		
		checkerOf(userContext).checkYearSetOfAccountSet(yearSet);
		
		checkerOf(userContext).checkEffectiveDateOfAccountSet(effectiveDate);
		
		checkerOf(userContext).checkAccountingSystemOfAccountSet(accountingSystem);
		
		checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet(domesticCurrencyCode);
		
		checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet(domesticCurrencyName);
		
		checkerOf(userContext).checkOpeningBankOfAccountSet(openingBank);
		
		checkerOf(userContext).checkAccountNumberOfAccountSet(accountNumber);
		
		checkerOf(userContext).checkCountryCenterIdOfAccountSet(countryCenterId);
		
		checkerOf(userContext).checkGoodsSupplierIdOfAccountSet(goodsSupplierId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore addAccountSet(YoubenbenUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountSet(userContext,retailStoreId,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, goodsSupplierId,tokensExpr);

		AccountSet accountSet = createAccountSet(userContext,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, goodsSupplierId);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, emptyOptions());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addAccountSet( accountSet );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			
			userContext.getManagerGroup().getAccountSetManager().onNewInstanceCreated(userContext, accountSet);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountSetProperties(YoubenbenUserContext userContext, String retailStoreId,String id,String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfAccountSet(id);

		checkerOf(userContext).checkNameOfAccountSet( name);
		checkerOf(userContext).checkYearSetOfAccountSet( yearSet);
		checkerOf(userContext).checkEffectiveDateOfAccountSet( effectiveDate);
		checkerOf(userContext).checkAccountingSystemOfAccountSet( accountingSystem);
		checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet( domesticCurrencyCode);
		checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet( domesticCurrencyName);
		checkerOf(userContext).checkOpeningBankOfAccountSet( openingBank);
		checkerOf(userContext).checkAccountNumberOfAccountSet( accountNumber);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore updateAccountSetProperties(YoubenbenUserContext userContext, String retailStoreId, String id,String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountSetProperties(userContext,retailStoreId,id,name,yearSet,effectiveDate,accountingSystem,domesticCurrencyCode,domesticCurrencyName,openingBank,accountNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountSetListList()
				.searchAccountSetListWith(AccountSet.ID_PROPERTY, "is", id).done();

		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);

		if(retailStoreToUpdate.getAccountSetList().isEmpty()){
			throw new RetailStoreManagerException("AccountSet is NOT FOUND with id: '"+id+"'");
		}

		AccountSet item = retailStoreToUpdate.getAccountSetList().first();

		item.updateName( name );
		item.updateYearSet( yearSet );
		item.updateEffectiveDate( effectiveDate );
		item.updateAccountingSystem( accountingSystem );
		item.updateDomesticCurrencyCode( domesticCurrencyCode );
		item.updateDomesticCurrencyName( domesticCurrencyName );
		item.updateOpeningBank( openingBank );
		item.updateAccountNumber( accountNumber );


		//checkParamsForAddingAccountSet(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withAccountSetList().done());
		synchronized(retailStore){
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountSet createAccountSet(YoubenbenUserContext userContext, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId) throws Exception{

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
		GoodsSupplier  goodsSupplier = new GoodsSupplier();
		goodsSupplier.setId(goodsSupplierId);		
		accountSet.setGoodsSupplier(goodsSupplier);		
		accountSet.setLastUpdateTime(userContext.now());
	
		
		return accountSet;


	}

	protected AccountSet createIndexedAccountSet(String id, int version){

		AccountSet accountSet = new AccountSet();
		accountSet.setId(id);
		accountSet.setVersion(version);
		return accountSet;

	}

	protected void checkParamsForRemovingAccountSetList(YoubenbenUserContext userContext, String retailStoreId,
			String accountSetIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		for(String accountSetIdItem: accountSetIds){
			checkerOf(userContext).checkIdOfAccountSet(accountSetIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeAccountSetList(YoubenbenUserContext userContext, String retailStoreId,
			String accountSetIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountSetList(userContext, retailStoreId,  accountSetIds, tokensExpr);


			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreDaoOf(userContext).planToRemoveAccountSetList(retailStore, accountSetIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
				deleteRelationListInGraph(userContext, retailStore.getAccountSetList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountSet(YoubenbenUserContext userContext, String retailStoreId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkVersionOfAccountSet(accountSetVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeAccountSet(YoubenbenUserContext userContext, String retailStoreId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountSet(userContext,retailStoreId, accountSetId, accountSetVersion,tokensExpr);

		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeAccountSet( accountSet );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			deleteRelationInGraph(userContext, accountSet);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountSet(YoubenbenUserContext userContext, String retailStoreId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkVersionOfAccountSet(accountSetVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore copyAccountSetFrom(YoubenbenUserContext userContext, String retailStoreId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountSet(userContext,retailStoreId, accountSetId, accountSetVersion,tokensExpr);

		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			accountSet.updateLastUpdateTime(userContext.now());

			retailStore.copyAccountSetFrom( accountSet );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			
			userContext.getManagerGroup().getAccountSetManager().onNewInstanceCreated(userContext, (AccountSet)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountSet(YoubenbenUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}

	public  RetailStore updateAccountSet(YoubenbenUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountSet(userContext, retailStoreId, accountSetId, accountSetVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountSetList().searchAccountSetListWith(AccountSet.ID_PROPERTY, "eq", accountSetId).done();



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);

		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeAccountSet( accountSet );
			//make changes to AcceleraterAccount.
			AccountSet accountSetIndex = createIndexedAccountSet(accountSetId, accountSetVersion);

			AccountSet accountSet = retailStore.findTheAccountSet(accountSetIndex);
			if(accountSet == null){
				throw new RetailStoreManagerException(accountSet+" is NOT FOUND" );
			}

			accountSet.changeProperty(property, newValueExpr);
			accountSet.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStore newCreated) throws Exception{
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
		//   RetailStore newRetailStore = this.createRetailStore(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStore
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStore.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<RetailStore> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> retailStoreCountryCenterList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(retailStoreCountryCenterList, RetailStoreCountryCenter.class);
		List<RetailStoreCityServiceCenter> cityServiceCenterList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCityServiceCenter.class);
		userContext.getDAOGroup().enhanceList(cityServiceCenterList, RetailStoreCityServiceCenter.class);
		List<RetailStoreCreation> creationList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCreation.class);
		userContext.getDAOGroup().enhanceList(creationList, RetailStoreCreation.class);
		List<RetailStoreInvestmentInvitation> investmentInvitationList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreInvestmentInvitation.class);
		userContext.getDAOGroup().enhanceList(investmentInvitationList, RetailStoreInvestmentInvitation.class);
		List<RetailStoreFranchising> franchisingList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreFranchising.class);
		userContext.getDAOGroup().enhanceList(franchisingList, RetailStoreFranchising.class);
		List<RetailStoreDecoration> decorationList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreDecoration.class);
		userContext.getDAOGroup().enhanceList(decorationList, RetailStoreDecoration.class);
		List<RetailStoreOpening> openingList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreOpening.class);
		userContext.getDAOGroup().enhanceList(openingList, RetailStoreOpening.class);
		List<RetailStoreClosing> closingList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreClosing.class);
		userContext.getDAOGroup().enhanceList(closingList, RetailStoreClosing.class);


    }
	
	public Object listByRetailStoreCountryCenter(YoubenbenUserContext userContext,String retailStoreCountryCenterId) throws Exception {
		return listPageByRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByRetailStoreCountryCenter(YoubenbenUserContext userContext,String retailStoreCountryCenterId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByRetailStoreCountryCenter(retailStoreCountryCenterId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(retailStoreCountryCenterId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByRetailStoreCountryCenter");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByRetailStoreCountryCenter/%s/",  getBeanName(), retailStoreCountryCenterId)));

		page.assemblerContent(userContext, "listByRetailStoreCountryCenter");
		return page.doRender(userContext);
	}
  
	public Object listByCityServiceCenter(YoubenbenUserContext userContext,String cityServiceCenterId) throws Exception {
		return listPageByCityServiceCenter(userContext, cityServiceCenterId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCityServiceCenter(YoubenbenUserContext userContext,String cityServiceCenterId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByCityServiceCenter(cityServiceCenterId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreCityServiceCenter.withId(cityServiceCenterId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByCityServiceCenter");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCityServiceCenter/%s/",  getBeanName(), cityServiceCenterId)));

		page.assemblerContent(userContext, "listByCityServiceCenter");
		return page.doRender(userContext);
	}
  
	public Object listByCreation(YoubenbenUserContext userContext,String creationId) throws Exception {
		return listPageByCreation(userContext, creationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCreation(YoubenbenUserContext userContext,String creationId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByCreation(creationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreCreation.withId(creationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByCreation");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCreation/%s/",  getBeanName(), creationId)));

		page.assemblerContent(userContext, "listByCreation");
		return page.doRender(userContext);
	}
  
	public Object listByInvestmentInvitation(YoubenbenUserContext userContext,String investmentInvitationId) throws Exception {
		return listPageByInvestmentInvitation(userContext, investmentInvitationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByInvestmentInvitation(YoubenbenUserContext userContext,String investmentInvitationId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByInvestmentInvitation(investmentInvitationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreInvestmentInvitation.withId(investmentInvitationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByInvestmentInvitation");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByInvestmentInvitation/%s/",  getBeanName(), investmentInvitationId)));

		page.assemblerContent(userContext, "listByInvestmentInvitation");
		return page.doRender(userContext);
	}
  
	public Object listByFranchising(YoubenbenUserContext userContext,String franchisingId) throws Exception {
		return listPageByFranchising(userContext, franchisingId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByFranchising(YoubenbenUserContext userContext,String franchisingId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByFranchising(franchisingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreFranchising.withId(franchisingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByFranchising");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByFranchising/%s/",  getBeanName(), franchisingId)));

		page.assemblerContent(userContext, "listByFranchising");
		return page.doRender(userContext);
	}
  
	public Object listByDecoration(YoubenbenUserContext userContext,String decorationId) throws Exception {
		return listPageByDecoration(userContext, decorationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDecoration(YoubenbenUserContext userContext,String decorationId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByDecoration(decorationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreDecoration.withId(decorationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByDecoration");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDecoration/%s/",  getBeanName(), decorationId)));

		page.assemblerContent(userContext, "listByDecoration");
		return page.doRender(userContext);
	}
  
	public Object listByOpening(YoubenbenUserContext userContext,String openingId) throws Exception {
		return listPageByOpening(userContext, openingId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOpening(YoubenbenUserContext userContext,String openingId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByOpening(openingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreOpening.withId(openingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByOpening");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByOpening/%s/",  getBeanName(), openingId)));

		page.assemblerContent(userContext, "listByOpening");
		return page.doRender(userContext);
	}
  
	public Object listByClosing(YoubenbenUserContext userContext,String closingId) throws Exception {
		return listPageByClosing(userContext, closingId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByClosing(YoubenbenUserContext userContext,String closingId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByClosing(closingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreClosing.withId(closingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByClosing");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByClosing/%s/",  getBeanName(), closingId)));

		page.assemblerContent(userContext, "listByClosing");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String retailStoreId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getRetailStoreDetailScope().clone();
		RetailStore merchantObj = (RetailStore) this.view(userContext, retailStoreId);
    String merchantObjId = retailStoreId;
    String linkToUrl =	"retailStoreManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "双链小超"+"详情";
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
				MapUtil.put("id", "3-telephone")
				    .put("fieldName", "telephone")
				    .put("label", "电话")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("telephone", merchantObj.getTelephone());

		propList.add(
				MapUtil.put("id", "4-owner")
				    .put("fieldName", "owner")
				    .put("label", "所有人")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("owner", merchantObj.getOwner());

		propList.add(
				MapUtil.put("id", "5-retailStoreCountryCenter")
				    .put("fieldName", "retailStoreCountryCenter")
				    .put("label", "双链小超全国运营中心")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("retailStoreCountryCenter", merchantObj.getRetailStoreCountryCenter());

		propList.add(
				MapUtil.put("id", "6-cityServiceCenter")
				    .put("fieldName", "cityServiceCenter")
				    .put("label", "城市服务中心")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCityServiceCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("cityServiceCenter", merchantObj.getCityServiceCenter());

		propList.add(
				MapUtil.put("id", "7-creation")
				    .put("fieldName", "creation")
				    .put("label", "创建")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCreationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("creation", merchantObj.getCreation());

		propList.add(
				MapUtil.put("id", "8-investmentInvitation")
				    .put("fieldName", "investmentInvitation")
				    .put("label", "招商")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreInvestmentInvitationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("investmentInvitation", merchantObj.getInvestmentInvitation());

		propList.add(
				MapUtil.put("id", "9-franchising")
				    .put("fieldName", "franchising")
				    .put("label", "加盟")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreFranchisingManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("franchising", merchantObj.getFranchising());

		propList.add(
				MapUtil.put("id", "10-decoration")
				    .put("fieldName", "decoration")
				    .put("label", "装修")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreDecorationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("decoration", merchantObj.getDecoration());

		propList.add(
				MapUtil.put("id", "11-opening")
				    .put("fieldName", "opening")
				    .put("label", "开业")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreOpeningManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("opening", merchantObj.getOpening());

		propList.add(
				MapUtil.put("id", "12-closing")
				    .put("fieldName", "closing")
				    .put("label", "关闭")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreClosingManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("closing", merchantObj.getClosing());

		propList.add(
				MapUtil.put("id", "13-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		propList.add(
				MapUtil.put("id", "14-latitude")
				    .put("fieldName", "latitude")
				    .put("label", "纬度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("latitude", merchantObj.getLatitude());

		propList.add(
				MapUtil.put("id", "15-longitude")
				    .put("fieldName", "longitude")
				    .put("label", "经度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("longitude", merchantObj.getLongitude());

		propList.add(
				MapUtil.put("id", "16-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "17-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "最后更新时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：consumerOrderListSection
		Map consumerOrderListSection = ListofUtils.buildSection(
		    "consumerOrderListSection",
		    "消费者的订单列表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderManager/listByStore/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(consumerOrderListSection);

		result.put("consumerOrderListSection", ListofUtils.toShortList(merchantObj.getConsumerOrderList(), "consumerOrder"));
		vscope.field("consumerOrderListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( ConsumerOrder.class.getName(), null));

		//处理Section：retailStoreOrderListSection
		Map retailStoreOrderListSection = ListofUtils.buildSection(
		    "retailStoreOrderListSection",
		    "零售店订购单",
		    null,
		    "",
		    "__no_group",
		    "retailStoreOrderManager/listByBuyer/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreOrderListSection);

		result.put("retailStoreOrderListSection", ListofUtils.toShortList(merchantObj.getRetailStoreOrderList(), "retailStoreOrder"));
		vscope.field("retailStoreOrderListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( RetailStoreOrder.class.getName(), null));

		//处理Section：goodsListSection
		Map goodsListSection = ListofUtils.buildSection(
		    "goodsListSection",
		    "商品列表",
		    null,
		    "",
		    "__no_group",
		    "goodsManager/listByRetailStore/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(goodsListSection);

		result.put("goodsListSection", ListofUtils.toShortList(merchantObj.getGoodsList(), "goods"));
		vscope.field("goodsListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( Goods.class.getName(), null));

		//处理Section：transportTaskListSection
		Map transportTaskListSection = ListofUtils.buildSection(
		    "transportTaskListSection",
		    "运输任务列表",
		    null,
		    "",
		    "__no_group",
		    "transportTaskManager/listByEnd/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(transportTaskListSection);

		result.put("transportTaskListSection", ListofUtils.toShortList(merchantObj.getTransportTaskList(), "transportTask"));
		vscope.field("transportTaskListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( TransportTask.class.getName(), null));

		//处理Section：accountSetListSection
		Map accountSetListSection = ListofUtils.buildSection(
		    "accountSetListSection",
		    "帐户设置列表",
		    null,
		    "",
		    "__no_group",
		    "accountSetManager/listByRetailStore/"+merchantObjId+"/",
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


