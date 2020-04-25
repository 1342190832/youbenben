
package com.youbenben.youbenben.storagespace;

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


import com.youbenben.youbenben.warehouse.Warehouse;
import com.youbenben.youbenben.goodsshelf.GoodsShelf;

import com.youbenben.youbenben.warehouse.CandidateWarehouse;

import com.youbenben.youbenben.supplierspace.SupplierSpace;
import com.youbenben.youbenben.damagespace.DamageSpace;
import com.youbenben.youbenben.storagespace.StorageSpace;






public class StorageSpaceManagerImpl extends CustomYoubenbenCheckerManager implements StorageSpaceManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = StorageSpaceTokens.start().withTokenFromListName(listName).done();
		StorageSpace  storageSpace = (StorageSpace) this.loadStorageSpace(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = storageSpace.collectRefercencesFromLists();
		storageSpaceDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, storageSpace, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new StorageSpaceGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "StorageSpace";
	@Override
	public StorageSpaceDAO daoOf(YoubenbenUserContext userContext) {
		return storageSpaceDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws StorageSpaceManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new StorageSpaceManagerException(message);

	}



 	protected StorageSpace saveStorageSpace(YoubenbenUserContext userContext, StorageSpace storageSpace, String [] tokensExpr) throws Exception{	
 		//return getStorageSpaceDAO().save(storageSpace, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveStorageSpace(userContext, storageSpace, tokens);
 	}
 	
 	protected StorageSpace saveStorageSpaceDetail(YoubenbenUserContext userContext, StorageSpace storageSpace) throws Exception{	

 		
 		return saveStorageSpace(userContext, storageSpace, allTokens());
 	}
 	
 	public StorageSpace loadStorageSpace(YoubenbenUserContext userContext, String storageSpaceId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
		checkerOf(userContext).throwExceptionIfHasErrors( StorageSpaceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		StorageSpace storageSpace = loadStorageSpace( userContext, storageSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,storageSpace, tokens);
 	}
 	
 	
 	 public StorageSpace searchStorageSpace(YoubenbenUserContext userContext, String storageSpaceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
		checkerOf(userContext).throwExceptionIfHasErrors( StorageSpaceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		StorageSpace storageSpace = loadStorageSpace( userContext, storageSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,storageSpace, tokens);
 	}
 	
 	

 	protected StorageSpace present(YoubenbenUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,storageSpace,tokens);
		
		
		StorageSpace  storageSpaceToPresent = storageSpaceDaoOf(userContext).present(storageSpace, tokens);
		
		List<BaseEntity> entityListToNaming = storageSpaceToPresent.collectRefercencesFromLists();
		storageSpaceDaoOf(userContext).alias(entityListToNaming);
		
		return  storageSpaceToPresent;
		
		
	}
 
 	
 	
 	public StorageSpace loadStorageSpaceDetail(YoubenbenUserContext userContext, String storageSpaceId) throws Exception{	
 		StorageSpace storageSpace = loadStorageSpace( userContext, storageSpaceId, allTokens());
 		return present(userContext,storageSpace, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String storageSpaceId) throws Exception{	
 		StorageSpace storageSpace = loadStorageSpace( userContext, storageSpaceId, viewTokens());
 		return present(userContext,storageSpace, allTokens());
		
 	}
 	protected StorageSpace saveStorageSpace(YoubenbenUserContext userContext, StorageSpace storageSpace, Map<String,Object>tokens) throws Exception{	
 		return storageSpaceDaoOf(userContext).save(storageSpace, tokens);
 	}
 	protected StorageSpace loadStorageSpace(YoubenbenUserContext userContext, String storageSpaceId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
		checkerOf(userContext).throwExceptionIfHasErrors( StorageSpaceManagerException.class);

 
 		return storageSpaceDaoOf(userContext).load(storageSpaceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens){
		super.addActions(userContext, storageSpace, tokens);
		
		addAction(userContext, storageSpace, tokens,"@create","createStorageSpace","createStorageSpace/","main","primary");
		addAction(userContext, storageSpace, tokens,"@update","updateStorageSpace","updateStorageSpace/"+storageSpace.getId()+"/","main","primary");
		addAction(userContext, storageSpace, tokens,"@copy","cloneStorageSpace","cloneStorageSpace/"+storageSpace.getId()+"/","main","primary");
		
		addAction(userContext, storageSpace, tokens,"storage_space.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+storageSpace.getId()+"/","main","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.addGoodsShelf","addGoodsShelf","addGoodsShelf/"+storageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.removeGoodsShelf","removeGoodsShelf","removeGoodsShelf/"+storageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.updateGoodsShelf","updateGoodsShelf","updateGoodsShelf/"+storageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.copyGoodsShelfFrom","copyGoodsShelfFrom","copyGoodsShelfFrom/"+storageSpace.getId()+"/","goodsShelfList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public StorageSpace createStorageSpace(YoubenbenUserContext userContext, String location,String contactNumber,String totalArea,String warehouseId,BigDecimal latitude,BigDecimal longitude) throws Exception
	//public StorageSpace createStorageSpace(YoubenbenUserContext userContext,String location, String contactNumber, String totalArea, String warehouseId, BigDecimal latitude, BigDecimal longitude) throws Exception
	{

		

		

		checkerOf(userContext).checkLocationOfStorageSpace(location);
		checkerOf(userContext).checkContactNumberOfStorageSpace(contactNumber);
		checkerOf(userContext).checkTotalAreaOfStorageSpace(totalArea);
		checkerOf(userContext).checkLatitudeOfStorageSpace(latitude);
		checkerOf(userContext).checkLongitudeOfStorageSpace(longitude);
	
		checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);


		StorageSpace storageSpace=createNewStorageSpace();	

		storageSpace.setLocation(location);
		storageSpace.setContactNumber(contactNumber);
		storageSpace.setTotalArea(totalArea);
			
		Warehouse warehouse = loadWarehouse(userContext, warehouseId,emptyOptions());
		storageSpace.setWarehouse(warehouse);
		
		
		storageSpace.setLatitude(latitude);
		storageSpace.setLongitude(longitude);
		storageSpace.setLastUpdateTime(userContext.now());

		storageSpace = saveStorageSpace(userContext, storageSpace, emptyOptions());
		
		onNewInstanceCreated(userContext, storageSpace);
		return storageSpace;


	}
	protected StorageSpace createNewStorageSpace()
	{

		return new StorageSpace();
	}

	protected void checkParamsForUpdatingStorageSpace(YoubenbenUserContext userContext,String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
		checkerOf(userContext).checkVersionOfStorageSpace( storageSpaceVersion);
		

		if(StorageSpace.LOCATION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocationOfStorageSpace(parseString(newValueExpr));
		
			
		}
		if(StorageSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContactNumberOfStorageSpace(parseString(newValueExpr));
		
			
		}
		if(StorageSpace.TOTAL_AREA_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAreaOfStorageSpace(parseString(newValueExpr));
		
			
		}		

		
		if(StorageSpace.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfStorageSpace(parseBigDecimal(newValueExpr));
		
			
		}
		if(StorageSpace.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfStorageSpace(parseBigDecimal(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);


	}



	public StorageSpace clone(YoubenbenUserContext userContext, String fromStorageSpaceId) throws Exception{

		return storageSpaceDaoOf(userContext).clone(fromStorageSpaceId, this.allTokens());
	}

	public StorageSpace internalSaveStorageSpace(YoubenbenUserContext userContext, StorageSpace storageSpace) throws Exception
	{
		return internalSaveStorageSpace(userContext, storageSpace, allTokens());

	}
	public StorageSpace internalSaveStorageSpace(YoubenbenUserContext userContext, StorageSpace storageSpace, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingStorageSpace(userContext, storageSpaceId, storageSpaceVersion, property, newValueExpr, tokensExpr);


		synchronized(storageSpace){
			//will be good when the storageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StorageSpace.
			if (storageSpace.isChanged()){
			storageSpace.updateLastUpdateTime(userContext.now());
			}
			storageSpace = saveStorageSpace(userContext, storageSpace, options);
			return storageSpace;

		}

	}

	public StorageSpace updateStorageSpace(YoubenbenUserContext userContext,String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingStorageSpace(userContext, storageSpaceId, storageSpaceVersion, property, newValueExpr, tokensExpr);



		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		if(storageSpace.getVersion() != storageSpaceVersion){
			String message = "The target version("+storageSpace.getVersion()+") is not equals to version("+storageSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(storageSpace){
			//will be good when the storageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StorageSpace.
			storageSpace.updateLastUpdateTime(userContext.now());
			storageSpace.changeProperty(property, newValueExpr);
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().done());
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
			//return saveStorageSpace(userContext, storageSpace, tokens().done());
		}

	}

	public StorageSpace updateStorageSpaceProperty(YoubenbenUserContext userContext,String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingStorageSpace(userContext, storageSpaceId, storageSpaceVersion, property, newValueExpr, tokensExpr);

		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		if(storageSpace.getVersion() != storageSpaceVersion){
			String message = "The target version("+storageSpace.getVersion()+") is not equals to version("+storageSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(storageSpace){
			//will be good when the storageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StorageSpace.

			storageSpace.changeProperty(property, newValueExpr);
			storageSpace.updateLastUpdateTime(userContext.now());
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().done());
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
			//return saveStorageSpace(userContext, storageSpace, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected StorageSpaceTokens tokens(){
		return StorageSpaceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return StorageSpaceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsShelfListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return StorageSpaceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWarehouse(YoubenbenUserContext userContext, String storageSpaceId, String anotherWarehouseId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
 		checkerOf(userContext).checkIdOfWarehouse(anotherWarehouseId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);

 	}
 	public StorageSpace transferToAnotherWarehouse(YoubenbenUserContext userContext, String storageSpaceId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, storageSpaceId,anotherWarehouseId);
 
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());	
		synchronized(storageSpace){
			//will be good when the storageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(userContext, anotherWarehouseId, emptyOptions());		
			storageSpace.updateWarehouse(warehouse);		
			storageSpace = saveStorageSpace(userContext, storageSpace, emptyOptions());
			
			return present(userContext,storageSpace, allTokens());
			
		}

 	}

	


	public CandidateWarehouse requestCandidateWarehouse(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateWarehouse result = new CandidateWarehouse();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("location");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Warehouse> candidateList = warehouseDaoOf(userContext).requestCandidateWarehouseForStorageSpace(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Warehouse loadWarehouse(YoubenbenUserContext userContext, String newWarehouseId, Map<String,Object> options) throws Exception
 	{

 		return warehouseDaoOf(userContext).load(newWarehouseId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String storageSpaceId, int storageSpaceVersion) throws Exception {
		//deleteInternal(userContext, storageSpaceId, storageSpaceVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String storageSpaceId, int storageSpaceVersion) throws Exception{

		storageSpaceDaoOf(userContext).delete(storageSpaceId, storageSpaceVersion);
	}

	public StorageSpace forgetByAll(YoubenbenUserContext userContext, String storageSpaceId, int storageSpaceVersion) throws Exception {
		return forgetByAllInternal(userContext, storageSpaceId, storageSpaceVersion);
	}
	protected StorageSpace forgetByAllInternal(YoubenbenUserContext userContext,
			String storageSpaceId, int storageSpaceVersion) throws Exception{

		return storageSpaceDaoOf(userContext).disconnectFromAll(storageSpaceId, storageSpaceVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new StorageSpaceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return storageSpaceDaoOf(userContext).deleteAll();
	}


	//disconnect StorageSpace with supplier_space in GoodsShelf
	protected StorageSpace breakWithGoodsShelfBySupplierSpace(YoubenbenUserContext userContext, String storageSpaceId, String supplierSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());

			synchronized(storageSpace){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				storageSpaceDaoOf(userContext).planToRemoveGoodsShelfListWithSupplierSpace(storageSpace, supplierSpaceId, this.emptyOptions());

				storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
				return storageSpace;
			}
	}
	//disconnect StorageSpace with damage_space in GoodsShelf
	protected StorageSpace breakWithGoodsShelfByDamageSpace(YoubenbenUserContext userContext, String storageSpaceId, String damageSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());

			synchronized(storageSpace){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				storageSpaceDaoOf(userContext).planToRemoveGoodsShelfListWithDamageSpace(storageSpace, damageSpaceId, this.emptyOptions());

				storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
				return storageSpace;
			}
	}






	protected void checkParamsForAddingGoodsShelf(YoubenbenUserContext userContext, String storageSpaceId, String location, String supplierSpaceId, String damageSpaceId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);

		
		checkerOf(userContext).checkLocationOfGoodsShelf(location);
		
		checkerOf(userContext).checkSupplierSpaceIdOfGoodsShelf(supplierSpaceId);
		
		checkerOf(userContext).checkDamageSpaceIdOfGoodsShelf(damageSpaceId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);


	}
	public  StorageSpace addGoodsShelf(YoubenbenUserContext userContext, String storageSpaceId, String location, String supplierSpaceId, String damageSpaceId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingGoodsShelf(userContext,storageSpaceId,location, supplierSpaceId, damageSpaceId,tokensExpr);

		GoodsShelf goodsShelf = createGoodsShelf(userContext,location, supplierSpaceId, damageSpaceId);

		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, emptyOptions());
		synchronized(storageSpace){
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			storageSpace.addGoodsShelf( goodsShelf );
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			
			userContext.getManagerGroup().getGoodsShelfManager().onNewInstanceCreated(userContext, goodsShelf);
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsShelfProperties(YoubenbenUserContext userContext, String storageSpaceId,String id,String location,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
		checkerOf(userContext).checkIdOfGoodsShelf(id);

		checkerOf(userContext).checkLocationOfGoodsShelf( location);

		checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);

	}
	public  StorageSpace updateGoodsShelfProperties(YoubenbenUserContext userContext, String storageSpaceId, String id,String location, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsShelfProperties(userContext,storageSpaceId,id,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsShelfListList()
				.searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, "is", id).done();

		StorageSpace storageSpaceToUpdate = loadStorageSpace(userContext, storageSpaceId, options);

		if(storageSpaceToUpdate.getGoodsShelfList().isEmpty()){
			throw new StorageSpaceManagerException("GoodsShelf is NOT FOUND with id: '"+id+"'");
		}

		GoodsShelf item = storageSpaceToUpdate.getGoodsShelfList().first();

		item.updateLocation( location );


		//checkParamsForAddingGoodsShelf(userContext,storageSpaceId,name, code, used,tokensExpr);
		StorageSpace storageSpace = saveStorageSpace(userContext, storageSpaceToUpdate, tokens().withGoodsShelfList().done());
		synchronized(storageSpace){
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}
	}


	protected GoodsShelf createGoodsShelf(YoubenbenUserContext userContext, String location, String supplierSpaceId, String damageSpaceId) throws Exception{

		GoodsShelf goodsShelf = new GoodsShelf();
		
		
		goodsShelf.setLocation(location);		
		SupplierSpace  supplierSpace = new SupplierSpace();
		supplierSpace.setId(supplierSpaceId);		
		goodsShelf.setSupplierSpace(supplierSpace);		
		DamageSpace  damageSpace = new DamageSpace();
		damageSpace.setId(damageSpaceId);		
		goodsShelf.setDamageSpace(damageSpace);		
		goodsShelf.setLastUpdateTime(userContext.now());
	
		
		return goodsShelf;


	}

	protected GoodsShelf createIndexedGoodsShelf(String id, int version){

		GoodsShelf goodsShelf = new GoodsShelf();
		goodsShelf.setId(id);
		goodsShelf.setVersion(version);
		return goodsShelf;

	}

	protected void checkParamsForRemovingGoodsShelfList(YoubenbenUserContext userContext, String storageSpaceId,
			String goodsShelfIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
		for(String goodsShelfIdItem: goodsShelfIds){
			checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);

	}
	public  StorageSpace removeGoodsShelfList(YoubenbenUserContext userContext, String storageSpaceId,
			String goodsShelfIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsShelfList(userContext, storageSpaceId,  goodsShelfIds, tokensExpr);


			StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
			synchronized(storageSpace){
				//Will be good when the storageSpace loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				storageSpaceDaoOf(userContext).planToRemoveGoodsShelfList(storageSpace, goodsShelfIds, allTokens());
				storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
				deleteRelationListInGraph(userContext, storageSpace.getGoodsShelfList());
				return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoodsShelf(YoubenbenUserContext userContext, String storageSpaceId,
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfStorageSpace( storageSpaceId);
		checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
		checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);

	}
	public  StorageSpace removeGoodsShelf(YoubenbenUserContext userContext, String storageSpaceId,
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingGoodsShelf(userContext,storageSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);

		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		synchronized(storageSpace){
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			storageSpace.removeGoodsShelf( goodsShelf );
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			deleteRelationInGraph(userContext, goodsShelf);
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingGoodsShelf(YoubenbenUserContext userContext, String storageSpaceId,
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfStorageSpace( storageSpaceId);
		checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
		checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);

	}
	public  StorageSpace copyGoodsShelfFrom(YoubenbenUserContext userContext, String storageSpaceId,
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingGoodsShelf(userContext,storageSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);

		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		synchronized(storageSpace){
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			goodsShelf.updateLastUpdateTime(userContext.now());

			storageSpace.copyGoodsShelfFrom( goodsShelf );
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			
			userContext.getManagerGroup().getGoodsShelfManager().onNewInstanceCreated(userContext, (GoodsShelf)storageSpace.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoodsShelf(YoubenbenUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
		checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
		checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);
		

		if(GoodsShelf.LOCATION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocationOfGoodsShelf(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);

	}

	public  StorageSpace updateGoodsShelf(YoubenbenUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoodsShelf(userContext, storageSpaceId, goodsShelfId, goodsShelfVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsShelfList().searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, "eq", goodsShelfId).done();



		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, loadTokens);

		synchronized(storageSpace){
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//storageSpace.removeGoodsShelf( goodsShelf );
			//make changes to AcceleraterAccount.
			GoodsShelf goodsShelfIndex = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);

			GoodsShelf goodsShelf = storageSpace.findTheGoodsShelf(goodsShelfIndex);
			if(goodsShelf == null){
				throw new StorageSpaceManagerException(goodsShelf+" is NOT FOUND" );
			}

			goodsShelf.changeProperty(property, newValueExpr);
			goodsShelf.updateLastUpdateTime(userContext.now());
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, StorageSpace newCreated) throws Exception{
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
		//   StorageSpace newStorageSpace = this.createStorageSpace(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newStorageSpace
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, StorageSpace.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<StorageSpace> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Warehouse> warehouseList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, Warehouse.class);
		userContext.getDAOGroup().enhanceList(warehouseList, Warehouse.class);


    }
	
	public Object listByWarehouse(YoubenbenUserContext userContext,String warehouseId) throws Exception {
		return listPageByWarehouse(userContext, warehouseId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByWarehouse(YoubenbenUserContext userContext,String warehouseId, int start, int count) throws Exception {
		SmartList<StorageSpace> list = storageSpaceDaoOf(userContext).findStorageSpaceByWarehouse(warehouseId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(StorageSpace.class);
		page.setContainerObject(Warehouse.withId(warehouseId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("存货区列表");
		page.setRequestName("listByWarehouse");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByWarehouse/%s/",  getBeanName(), warehouseId)));

		page.assemblerContent(userContext, "listByWarehouse");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String storageSpaceId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getStorageSpaceDetailScope().clone();
		StorageSpace merchantObj = (StorageSpace) this.view(userContext, storageSpaceId);
    String merchantObjId = storageSpaceId;
    String linkToUrl =	"storageSpaceManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "存货区"+"详情";
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
				MapUtil.put("id", "2-location")
				    .put("fieldName", "location")
				    .put("label", "位置")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("location", merchantObj.getLocation());

		propList.add(
				MapUtil.put("id", "3-contactNumber")
				    .put("fieldName", "contactNumber")
				    .put("label", "联系电话")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("contactNumber", merchantObj.getContactNumber());

		propList.add(
				MapUtil.put("id", "4-totalArea")
				    .put("fieldName", "totalArea")
				    .put("label", "区域总面积")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("totalArea", merchantObj.getTotalArea());

		propList.add(
				MapUtil.put("id", "5-warehouse")
				    .put("fieldName", "warehouse")
				    .put("label", "仓库")
				    .put("type", "auto")
				    .put("linkToUrl", "warehouseManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("warehouse", merchantObj.getWarehouse());

		propList.add(
				MapUtil.put("id", "6-latitude")
				    .put("fieldName", "latitude")
				    .put("label", "纬度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("latitude", merchantObj.getLatitude());

		propList.add(
				MapUtil.put("id", "7-longitude")
				    .put("fieldName", "longitude")
				    .put("label", "经度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("longitude", merchantObj.getLongitude());

		propList.add(
				MapUtil.put("id", "8-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "最后更新时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：goodsShelfListSection
		Map goodsShelfListSection = ListofUtils.buildSection(
		    "goodsShelfListSection",
		    "货架列表",
		    null,
		    "",
		    "__no_group",
		    "goodsShelfManager/listByStorageSpace/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(goodsShelfListSection);

		result.put("goodsShelfListSection", ListofUtils.toShortList(merchantObj.getGoodsShelfList(), "goodsShelf"));
		vscope.field("goodsShelfListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( GoodsShelf.class.getName(), null));

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


