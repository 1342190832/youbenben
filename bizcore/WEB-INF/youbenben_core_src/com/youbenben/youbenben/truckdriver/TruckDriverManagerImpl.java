
package com.youbenben.youbenben.truckdriver;

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


import com.youbenben.youbenben.transportfleet.TransportFleet;
import com.youbenben.youbenben.transporttask.TransportTask;

import com.youbenben.youbenben.transportfleet.CandidateTransportFleet;

import com.youbenben.youbenben.transportfleet.TransportFleet;
import com.youbenben.youbenben.transporttruck.TransportTruck;
import com.youbenben.youbenben.truckdriver.TruckDriver;
import com.youbenben.youbenben.retailstore.RetailStore;






public class TruckDriverManagerImpl extends CustomYoubenbenCheckerManager implements TruckDriverManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = TruckDriverTokens.start().withTokenFromListName(listName).done();
		TruckDriver  truckDriver = (TruckDriver) this.loadTruckDriver(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = truckDriver.collectRefercencesFromLists();
		truckDriverDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, truckDriver, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new TruckDriverGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "TruckDriver";
	@Override
	public TruckDriverDAO daoOf(YoubenbenUserContext userContext) {
		return truckDriverDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws TruckDriverManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new TruckDriverManagerException(message);

	}



 	protected TruckDriver saveTruckDriver(YoubenbenUserContext userContext, TruckDriver truckDriver, String [] tokensExpr) throws Exception{	
 		//return getTruckDriverDAO().save(truckDriver, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTruckDriver(userContext, truckDriver, tokens);
 	}
 	
 	protected TruckDriver saveTruckDriverDetail(YoubenbenUserContext userContext, TruckDriver truckDriver) throws Exception{	

 		
 		return saveTruckDriver(userContext, truckDriver, allTokens());
 	}
 	
 	public TruckDriver loadTruckDriver(YoubenbenUserContext userContext, String truckDriverId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
		checkerOf(userContext).throwExceptionIfHasErrors( TruckDriverManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TruckDriver truckDriver = loadTruckDriver( userContext, truckDriverId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,truckDriver, tokens);
 	}
 	
 	
 	 public TruckDriver searchTruckDriver(YoubenbenUserContext userContext, String truckDriverId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
		checkerOf(userContext).throwExceptionIfHasErrors( TruckDriverManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TruckDriver truckDriver = loadTruckDriver( userContext, truckDriverId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,truckDriver, tokens);
 	}
 	
 	

 	protected TruckDriver present(YoubenbenUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,truckDriver,tokens);
		
		
		TruckDriver  truckDriverToPresent = truckDriverDaoOf(userContext).present(truckDriver, tokens);
		
		List<BaseEntity> entityListToNaming = truckDriverToPresent.collectRefercencesFromLists();
		truckDriverDaoOf(userContext).alias(entityListToNaming);
		
		return  truckDriverToPresent;
		
		
	}
 
 	
 	
 	public TruckDriver loadTruckDriverDetail(YoubenbenUserContext userContext, String truckDriverId) throws Exception{	
 		TruckDriver truckDriver = loadTruckDriver( userContext, truckDriverId, allTokens());
 		return present(userContext,truckDriver, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String truckDriverId) throws Exception{	
 		TruckDriver truckDriver = loadTruckDriver( userContext, truckDriverId, viewTokens());
 		return present(userContext,truckDriver, allTokens());
		
 	}
 	protected TruckDriver saveTruckDriver(YoubenbenUserContext userContext, TruckDriver truckDriver, Map<String,Object>tokens) throws Exception{	
 		return truckDriverDaoOf(userContext).save(truckDriver, tokens);
 	}
 	protected TruckDriver loadTruckDriver(YoubenbenUserContext userContext, String truckDriverId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
		checkerOf(userContext).throwExceptionIfHasErrors( TruckDriverManagerException.class);

 
 		return truckDriverDaoOf(userContext).load(truckDriverId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens){
		super.addActions(userContext, truckDriver, tokens);
		
		addAction(userContext, truckDriver, tokens,"@create","createTruckDriver","createTruckDriver/","main","primary");
		addAction(userContext, truckDriver, tokens,"@update","updateTruckDriver","updateTruckDriver/"+truckDriver.getId()+"/","main","primary");
		addAction(userContext, truckDriver, tokens,"@copy","cloneTruckDriver","cloneTruckDriver/"+truckDriver.getId()+"/","main","primary");
		
		addAction(userContext, truckDriver, tokens,"truck_driver.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+truckDriver.getId()+"/","main","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.addTransportTask","addTransportTask","addTransportTask/"+truckDriver.getId()+"/","transportTaskList","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.removeTransportTask","removeTransportTask","removeTransportTask/"+truckDriver.getId()+"/","transportTaskList","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.updateTransportTask","updateTransportTask","updateTransportTask/"+truckDriver.getId()+"/","transportTaskList","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+truckDriver.getId()+"/","transportTaskList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public TruckDriver createTruckDriver(YoubenbenUserContext userContext, String name,String driverLicenseNumber,String contactNumber,String belongsToId) throws Exception
	//public TruckDriver createTruckDriver(YoubenbenUserContext userContext,String name, String driverLicenseNumber, String contactNumber, String belongsToId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfTruckDriver(name);
		checkerOf(userContext).checkDriverLicenseNumberOfTruckDriver(driverLicenseNumber);
		checkerOf(userContext).checkContactNumberOfTruckDriver(contactNumber);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);


		TruckDriver truckDriver=createNewTruckDriver();	

		truckDriver.setName(name);
		truckDriver.setDriverLicenseNumber(driverLicenseNumber);
		truckDriver.setContactNumber(contactNumber);
			
		TransportFleet belongsTo = loadTransportFleet(userContext, belongsToId,emptyOptions());
		truckDriver.setBelongsTo(belongsTo);
		
		

		truckDriver = saveTruckDriver(userContext, truckDriver, emptyOptions());
		
		onNewInstanceCreated(userContext, truckDriver);
		return truckDriver;


	}
	protected TruckDriver createNewTruckDriver()
	{

		return new TruckDriver();
	}

	protected void checkParamsForUpdatingTruckDriver(YoubenbenUserContext userContext,String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
		checkerOf(userContext).checkVersionOfTruckDriver( truckDriverVersion);
		

		if(TruckDriver.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfTruckDriver(parseString(newValueExpr));
		
			
		}
		if(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDriverLicenseNumberOfTruckDriver(parseString(newValueExpr));
		
			
		}
		if(TruckDriver.CONTACT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContactNumberOfTruckDriver(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);


	}



	public TruckDriver clone(YoubenbenUserContext userContext, String fromTruckDriverId) throws Exception{

		return truckDriverDaoOf(userContext).clone(fromTruckDriverId, this.allTokens());
	}

	public TruckDriver internalSaveTruckDriver(YoubenbenUserContext userContext, TruckDriver truckDriver) throws Exception
	{
		return internalSaveTruckDriver(userContext, truckDriver, allTokens());

	}
	public TruckDriver internalSaveTruckDriver(YoubenbenUserContext userContext, TruckDriver truckDriver, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingTruckDriver(userContext, truckDriverId, truckDriverVersion, property, newValueExpr, tokensExpr);


		synchronized(truckDriver){
			//will be good when the truckDriver loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TruckDriver.
			if (truckDriver.isChanged()){
			
			}
			truckDriver = saveTruckDriver(userContext, truckDriver, options);
			return truckDriver;

		}

	}

	public TruckDriver updateTruckDriver(YoubenbenUserContext userContext,String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTruckDriver(userContext, truckDriverId, truckDriverVersion, property, newValueExpr, tokensExpr);



		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		if(truckDriver.getVersion() != truckDriverVersion){
			String message = "The target version("+truckDriver.getVersion()+") is not equals to version("+truckDriverVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(truckDriver){
			//will be good when the truckDriver loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TruckDriver.
			
			truckDriver.changeProperty(property, newValueExpr);
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().done());
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
			//return saveTruckDriver(userContext, truckDriver, tokens().done());
		}

	}

	public TruckDriver updateTruckDriverProperty(YoubenbenUserContext userContext,String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTruckDriver(userContext, truckDriverId, truckDriverVersion, property, newValueExpr, tokensExpr);

		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		if(truckDriver.getVersion() != truckDriverVersion){
			String message = "The target version("+truckDriver.getVersion()+") is not equals to version("+truckDriverVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(truckDriver){
			//will be good when the truckDriver loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TruckDriver.

			truckDriver.changeProperty(property, newValueExpr);
			
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().done());
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
			//return saveTruckDriver(userContext, truckDriver, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected TruckDriverTokens tokens(){
		return TruckDriverTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TruckDriverTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransportTaskListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TruckDriverTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(YoubenbenUserContext userContext, String truckDriverId, String anotherBelongsToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
 		checkerOf(userContext).checkIdOfTransportFleet(anotherBelongsToId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);

 	}
 	public TruckDriver transferToAnotherBelongsTo(YoubenbenUserContext userContext, String truckDriverId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, truckDriverId,anotherBelongsToId);
 
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());	
		synchronized(truckDriver){
			//will be good when the truckDriver loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportFleet belongsTo = loadTransportFleet(userContext, anotherBelongsToId, emptyOptions());		
			truckDriver.updateBelongsTo(belongsTo);		
			truckDriver = saveTruckDriver(userContext, truckDriver, emptyOptions());
			
			return present(userContext,truckDriver, allTokens());
			
		}

 	}

	


	public CandidateTransportFleet requestCandidateBelongsTo(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTransportFleet result = new CandidateTransportFleet();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TransportFleet> candidateList = transportFleetDaoOf(userContext).requestCandidateTransportFleetForTruckDriver(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected TransportFleet loadTransportFleet(YoubenbenUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{

 		return transportFleetDaoOf(userContext).load(newBelongsToId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String truckDriverId, int truckDriverVersion) throws Exception {
		//deleteInternal(userContext, truckDriverId, truckDriverVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String truckDriverId, int truckDriverVersion) throws Exception{

		truckDriverDaoOf(userContext).delete(truckDriverId, truckDriverVersion);
	}

	public TruckDriver forgetByAll(YoubenbenUserContext userContext, String truckDriverId, int truckDriverVersion) throws Exception {
		return forgetByAllInternal(userContext, truckDriverId, truckDriverVersion);
	}
	protected TruckDriver forgetByAllInternal(YoubenbenUserContext userContext,
			String truckDriverId, int truckDriverVersion) throws Exception{

		return truckDriverDaoOf(userContext).disconnectFromAll(truckDriverId, truckDriverVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TruckDriverManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return truckDriverDaoOf(userContext).deleteAll();
	}


	//disconnect TruckDriver with end in TransportTask
	protected TruckDriver breakWithTransportTaskByEnd(YoubenbenUserContext userContext, String truckDriverId, String endId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());

			synchronized(truckDriver){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				truckDriverDaoOf(userContext).planToRemoveTransportTaskListWithEnd(truckDriver, endId, this.emptyOptions());

				truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
				return truckDriver;
			}
	}
	//disconnect TruckDriver with truck in TransportTask
	protected TruckDriver breakWithTransportTaskByTruck(YoubenbenUserContext userContext, String truckDriverId, String truckId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());

			synchronized(truckDriver){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				truckDriverDaoOf(userContext).planToRemoveTransportTaskListWithTruck(truckDriver, truckId, this.emptyOptions());

				truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
				return truckDriver;
			}
	}
	//disconnect TruckDriver with belongs_to in TransportTask
	protected TruckDriver breakWithTransportTaskByBelongsTo(YoubenbenUserContext userContext, String truckDriverId, String belongsToId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());

			synchronized(truckDriver){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				truckDriverDaoOf(userContext).planToRemoveTransportTaskListWithBelongsTo(truckDriver, belongsToId, this.emptyOptions());

				truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
				return truckDriver;
			}
	}






	protected void checkParamsForAddingTransportTask(YoubenbenUserContext userContext, String truckDriverId, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);

		
		checkerOf(userContext).checkNameOfTransportTask(name);
		
		checkerOf(userContext).checkStartOfTransportTask(start);
		
		checkerOf(userContext).checkBeginTimeOfTransportTask(beginTime);
		
		checkerOf(userContext).checkEndIdOfTransportTask(endId);
		
		checkerOf(userContext).checkTruckIdOfTransportTask(truckId);
		
		checkerOf(userContext).checkBelongsToIdOfTransportTask(belongsToId);
		
		checkerOf(userContext).checkLatitudeOfTransportTask(latitude);
		
		checkerOf(userContext).checkLongitudeOfTransportTask(longitude);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);


	}
	public  TruckDriver addTransportTask(YoubenbenUserContext userContext, String truckDriverId, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingTransportTask(userContext,truckDriverId,name, start, beginTime, endId, truckId, belongsToId, latitude, longitude,tokensExpr);

		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, endId, truckId, belongsToId, latitude, longitude);

		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, emptyOptions());
		synchronized(truckDriver){
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			truckDriver.addTransportTask( transportTask );
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskProperties(YoubenbenUserContext userContext, String truckDriverId,String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
		checkerOf(userContext).checkIdOfTransportTask(id);

		checkerOf(userContext).checkNameOfTransportTask( name);
		checkerOf(userContext).checkStartOfTransportTask( start);
		checkerOf(userContext).checkBeginTimeOfTransportTask( beginTime);
		checkerOf(userContext).checkLatitudeOfTransportTask( latitude);
		checkerOf(userContext).checkLongitudeOfTransportTask( longitude);

		checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);

	}
	public  TruckDriver updateTransportTaskProperties(YoubenbenUserContext userContext, String truckDriverId, String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportTaskProperties(userContext,truckDriverId,id,name,start,beginTime,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListList()
				.searchTransportTaskListWith(TransportTask.ID_PROPERTY, "is", id).done();

		TruckDriver truckDriverToUpdate = loadTruckDriver(userContext, truckDriverId, options);

		if(truckDriverToUpdate.getTransportTaskList().isEmpty()){
			throw new TruckDriverManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}

		TransportTask item = truckDriverToUpdate.getTransportTaskList().first();

		item.updateName( name );
		item.updateStart( start );
		item.updateBeginTime( beginTime );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );


		//checkParamsForAddingTransportTask(userContext,truckDriverId,name, code, used,tokensExpr);
		TruckDriver truckDriver = saveTruckDriver(userContext, truckDriverToUpdate, tokens().withTransportTaskList().done());
		synchronized(truckDriver){
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}
	}


	protected TransportTask createTransportTask(YoubenbenUserContext userContext, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		transportTask.setStart(start);		
		transportTask.setBeginTime(beginTime);		
		RetailStore  end = new RetailStore();
		end.setId(endId);		
		transportTask.setEnd(end);		
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

	protected void checkParamsForRemovingTransportTaskList(YoubenbenUserContext userContext, String truckDriverId,
			String transportTaskIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
		for(String transportTaskIdItem: transportTaskIds){
			checkerOf(userContext).checkIdOfTransportTask(transportTaskIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);

	}
	public  TruckDriver removeTransportTaskList(YoubenbenUserContext userContext, String truckDriverId,
			String transportTaskIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTransportTaskList(userContext, truckDriverId,  transportTaskIds, tokensExpr);


			TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
			synchronized(truckDriver){
				//Will be good when the truckDriver loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				truckDriverDaoOf(userContext).planToRemoveTransportTaskList(truckDriver, transportTaskIds, allTokens());
				truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, truckDriver.getTransportTaskList());
				return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTransportTask(YoubenbenUserContext userContext, String truckDriverId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTruckDriver( truckDriverId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);

	}
	public  TruckDriver removeTransportTask(YoubenbenUserContext userContext, String truckDriverId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingTransportTask(userContext,truckDriverId, transportTaskId, transportTaskVersion,tokensExpr);

		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		synchronized(truckDriver){
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			truckDriver.removeTransportTask( transportTask );
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingTransportTask(YoubenbenUserContext userContext, String truckDriverId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTruckDriver( truckDriverId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);

	}
	public  TruckDriver copyTransportTaskFrom(YoubenbenUserContext userContext, String truckDriverId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingTransportTask(userContext,truckDriverId, transportTaskId, transportTaskVersion,tokensExpr);

		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		synchronized(truckDriver){
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			truckDriver.copyTransportTaskFrom( transportTask );
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)truckDriver.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTransportTask(YoubenbenUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);

	}

	public  TruckDriver updateTransportTask(YoubenbenUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTransportTask(userContext, truckDriverId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTransportTaskList().searchTransportTaskListWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();



		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, loadTokens);

		synchronized(truckDriver){
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//truckDriver.removeTransportTask( transportTask );
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);

			TransportTask transportTask = truckDriver.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new TruckDriverManagerException(transportTask+" is NOT FOUND" );
			}

			transportTask.changeProperty(property, newValueExpr);
			
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, TruckDriver newCreated) throws Exception{
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
		//   TruckDriver newTruckDriver = this.createTruckDriver(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newTruckDriver
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, TruckDriver.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<TruckDriver> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<TransportFleet> belongsToList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, TransportFleet.class);
		userContext.getDAOGroup().enhanceList(belongsToList, TransportFleet.class);


    }
	
	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception {
		return listPageByBelongsTo(userContext, belongsToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception {
		SmartList<TruckDriver> list = truckDriverDaoOf(userContext).findTruckDriverByBelongsTo(belongsToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(TruckDriver.class);
		page.setContainerObject(TransportFleet.withId(belongsToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("卡车司机列表");
		page.setRequestName("listByBelongsTo");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBelongsTo/%s/",  getBeanName(), belongsToId)));

		page.assemblerContent(userContext, "listByBelongsTo");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String truckDriverId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getTruckDriverDetailScope().clone();
		TruckDriver merchantObj = (TruckDriver) this.view(userContext, truckDriverId);
    String merchantObjId = truckDriverId;
    String linkToUrl =	"truckDriverManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "卡车司机"+"详情";
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
				MapUtil.put("id", "3-driverLicenseNumber")
				    .put("fieldName", "driverLicenseNumber")
				    .put("label", "驾驶执照号码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("driverLicenseNumber", merchantObj.getDriverLicenseNumber());

		propList.add(
				MapUtil.put("id", "4-contactNumber")
				    .put("fieldName", "contactNumber")
				    .put("label", "联系电话")
				    .put("type", "mobile")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("contactNumber", merchantObj.getContactNumber());

		propList.add(
				MapUtil.put("id", "5-belongsTo")
				    .put("fieldName", "belongsTo")
				    .put("label", "属于")
				    .put("type", "auto")
				    .put("linkToUrl", "transportFleetManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("belongsTo", merchantObj.getBelongsTo());

		//处理 sectionList

		//处理Section：transportTaskListSection
		Map transportTaskListSection = ListofUtils.buildSection(
		    "transportTaskListSection",
		    "运输任务列表",
		    null,
		    "",
		    "__no_group",
		    "transportTaskManager/listByDriver/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(transportTaskListSection);

		result.put("transportTaskListSection", ListofUtils.toShortList(merchantObj.getTransportTaskList(), "transportTask"));
		vscope.field("transportTaskListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( TransportTask.class.getName(), null));

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


