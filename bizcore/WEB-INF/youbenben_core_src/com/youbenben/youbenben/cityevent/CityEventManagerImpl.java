
package com.youbenben.youbenben.cityevent;

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


import com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenter;
import com.youbenben.youbenben.eventattendance.EventAttendance;

import com.youbenben.youbenben.franchisedoutletcityservicecenter.CandidateFranchisedOutletCityServiceCenter;

import com.youbenben.youbenben.potentialcustomer.PotentialCustomer;
import com.youbenben.youbenben.cityevent.CityEvent;






public class CityEventManagerImpl extends CustomYoubenbenCheckerManager implements CityEventManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(YoubenbenUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = CityEventTokens.start().withTokenFromListName(listName).done();
		CityEvent  cityEvent = (CityEvent) this.loadCityEvent(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = cityEvent.collectRefercencesFromLists();
		cityEventDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, cityEvent, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new CityEventGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "CityEvent";
	@Override
	public CityEventDAO daoOf(YoubenbenUserContext userContext) {
		return cityEventDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws CityEventManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new CityEventManagerException(message);

	}



 	protected CityEvent saveCityEvent(YoubenbenUserContext userContext, CityEvent cityEvent, String [] tokensExpr) throws Exception{	
 		//return getCityEventDAO().save(cityEvent, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCityEvent(userContext, cityEvent, tokens);
 	}
 	
 	protected CityEvent saveCityEventDetail(YoubenbenUserContext userContext, CityEvent cityEvent) throws Exception{	

 		
 		return saveCityEvent(userContext, cityEvent, allTokens());
 	}
 	
 	public CityEvent loadCityEvent(YoubenbenUserContext userContext, String cityEventId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCityEvent(cityEventId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityEventManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CityEvent cityEvent = loadCityEvent( userContext, cityEventId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityEvent, tokens);
 	}
 	
 	
 	 public CityEvent searchCityEvent(YoubenbenUserContext userContext, String cityEventId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCityEvent(cityEventId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityEventManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CityEvent cityEvent = loadCityEvent( userContext, cityEventId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityEvent, tokens);
 	}
 	
 	

 	protected CityEvent present(YoubenbenUserContext userContext, CityEvent cityEvent, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,cityEvent,tokens);
		
		
		CityEvent  cityEventToPresent = cityEventDaoOf(userContext).present(cityEvent, tokens);
		
		List<BaseEntity> entityListToNaming = cityEventToPresent.collectRefercencesFromLists();
		cityEventDaoOf(userContext).alias(entityListToNaming);
		
		return  cityEventToPresent;
		
		
	}
 
 	
 	
 	public CityEvent loadCityEventDetail(YoubenbenUserContext userContext, String cityEventId) throws Exception{	
 		CityEvent cityEvent = loadCityEvent( userContext, cityEventId, allTokens());
 		return present(userContext,cityEvent, allTokens());
		
 	}
 	
 	public Object view(YoubenbenUserContext userContext, String cityEventId) throws Exception{	
 		CityEvent cityEvent = loadCityEvent( userContext, cityEventId, viewTokens());
 		return present(userContext,cityEvent, allTokens());
		
 	}
 	protected CityEvent saveCityEvent(YoubenbenUserContext userContext, CityEvent cityEvent, Map<String,Object>tokens) throws Exception{	
 		return cityEventDaoOf(userContext).save(cityEvent, tokens);
 	}
 	protected CityEvent loadCityEvent(YoubenbenUserContext userContext, String cityEventId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfCityEvent(cityEventId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityEventManagerException.class);

 
 		return cityEventDaoOf(userContext).load(cityEventId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, CityEvent cityEvent, Map<String, Object> tokens){
		super.addActions(userContext, cityEvent, tokens);
		
		addAction(userContext, cityEvent, tokens,"@create","createCityEvent","createCityEvent/","main","primary");
		addAction(userContext, cityEvent, tokens,"@update","updateCityEvent","updateCityEvent/"+cityEvent.getId()+"/","main","primary");
		addAction(userContext, cityEvent, tokens,"@copy","cloneCityEvent","cloneCityEvent/"+cityEvent.getId()+"/","main","primary");
		
		addAction(userContext, cityEvent, tokens,"city_event.transfer_to_city_service_center","transferToAnotherCityServiceCenter","transferToAnotherCityServiceCenter/"+cityEvent.getId()+"/","main","primary");
		addAction(userContext, cityEvent, tokens,"city_event.addEventAttendance","addEventAttendance","addEventAttendance/"+cityEvent.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, cityEvent, tokens,"city_event.removeEventAttendance","removeEventAttendance","removeEventAttendance/"+cityEvent.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, cityEvent, tokens,"city_event.updateEventAttendance","updateEventAttendance","updateEventAttendance/"+cityEvent.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, cityEvent, tokens,"city_event.copyEventAttendanceFrom","copyEventAttendanceFrom","copyEventAttendanceFrom/"+cityEvent.getId()+"/","eventAttendanceList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(YoubenbenUserContext userContext, CityEvent cityEvent, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public CityEvent createCityEvent(YoubenbenUserContext userContext, String name,String mobile,String cityServiceCenterId,String description) throws Exception
	//public CityEvent createCityEvent(YoubenbenUserContext userContext,String name, String mobile, String cityServiceCenterId, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfCityEvent(name);
		checkerOf(userContext).checkMobileOfCityEvent(mobile);
		checkerOf(userContext).checkDescriptionOfCityEvent(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityEventManagerException.class);


		CityEvent cityEvent=createNewCityEvent();	

		cityEvent.setName(name);
		cityEvent.setMobile(mobile);
			
		FranchisedOutletCityServiceCenter cityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, cityServiceCenterId,emptyOptions());
		cityEvent.setCityServiceCenter(cityServiceCenter);
		
		
		cityEvent.setDescription(description);
		cityEvent.setLastUpdateTime(userContext.now());

		cityEvent = saveCityEvent(userContext, cityEvent, emptyOptions());
		
		onNewInstanceCreated(userContext, cityEvent);
		return cityEvent;


	}
	protected CityEvent createNewCityEvent()
	{

		return new CityEvent();
	}

	protected void checkParamsForUpdatingCityEvent(YoubenbenUserContext userContext,String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfCityEvent(cityEventId);
		checkerOf(userContext).checkVersionOfCityEvent( cityEventVersion);
		

		if(CityEvent.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCityEvent(parseString(newValueExpr));
		
			
		}
		if(CityEvent.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfCityEvent(parseString(newValueExpr));
		
			
		}		

		
		if(CityEvent.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfCityEvent(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityEventManagerException.class);


	}



	public CityEvent clone(YoubenbenUserContext userContext, String fromCityEventId) throws Exception{

		return cityEventDaoOf(userContext).clone(fromCityEventId, this.allTokens());
	}

	public CityEvent internalSaveCityEvent(YoubenbenUserContext userContext, CityEvent cityEvent) throws Exception
	{
		return internalSaveCityEvent(userContext, cityEvent, allTokens());

	}
	public CityEvent internalSaveCityEvent(YoubenbenUserContext userContext, CityEvent cityEvent, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingCityEvent(userContext, cityEventId, cityEventVersion, property, newValueExpr, tokensExpr);


		synchronized(cityEvent){
			//will be good when the cityEvent loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityEvent.
			if (cityEvent.isChanged()){
			cityEvent.updateLastUpdateTime(userContext.now());
			}
			cityEvent = saveCityEvent(userContext, cityEvent, options);
			return cityEvent;

		}

	}

	public CityEvent updateCityEvent(YoubenbenUserContext userContext,String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityEvent(userContext, cityEventId, cityEventVersion, property, newValueExpr, tokensExpr);



		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		if(cityEvent.getVersion() != cityEventVersion){
			String message = "The target version("+cityEvent.getVersion()+") is not equals to version("+cityEventVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(cityEvent){
			//will be good when the cityEvent loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityEvent.
			cityEvent.updateLastUpdateTime(userContext.now());
			cityEvent.changeProperty(property, newValueExpr);
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().done());
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
			//return saveCityEvent(userContext, cityEvent, tokens().done());
		}

	}

	public CityEvent updateCityEventProperty(YoubenbenUserContext userContext,String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityEvent(userContext, cityEventId, cityEventVersion, property, newValueExpr, tokensExpr);

		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		if(cityEvent.getVersion() != cityEventVersion){
			String message = "The target version("+cityEvent.getVersion()+") is not equals to version("+cityEventVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(cityEvent){
			//will be good when the cityEvent loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityEvent.

			cityEvent.changeProperty(property, newValueExpr);
			cityEvent.updateLastUpdateTime(userContext.now());
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().done());
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
			//return saveCityEvent(userContext, cityEvent, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected CityEventTokens tokens(){
		return CityEventTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CityEventTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEventAttendanceListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CityEventTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCityServiceCenter(YoubenbenUserContext userContext, String cityEventId, String anotherCityServiceCenterId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCityEvent(cityEventId);
 		checkerOf(userContext).checkIdOfFranchisedOutletCityServiceCenter(anotherCityServiceCenterId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CityEventManagerException.class);

 	}
 	public CityEvent transferToAnotherCityServiceCenter(YoubenbenUserContext userContext, String cityEventId, String anotherCityServiceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityServiceCenter(userContext, cityEventId,anotherCityServiceCenterId);
 
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());	
		synchronized(cityEvent){
			//will be good when the cityEvent loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			FranchisedOutletCityServiceCenter cityServiceCenter = loadFranchisedOutletCityServiceCenter(userContext, anotherCityServiceCenterId, emptyOptions());		
			cityEvent.updateCityServiceCenter(cityServiceCenter);		
			cityEvent = saveCityEvent(userContext, cityEvent, emptyOptions());
			
			return present(userContext,cityEvent, allTokens());
			
		}

 	}

	


	public CandidateFranchisedOutletCityServiceCenter requestCandidateCityServiceCenter(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateFranchisedOutletCityServiceCenter result = new CandidateFranchisedOutletCityServiceCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<FranchisedOutletCityServiceCenter> candidateList = franchisedOutletCityServiceCenterDaoOf(userContext).requestCandidateFranchisedOutletCityServiceCenterForCityEvent(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected FranchisedOutletCityServiceCenter loadFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String newCityServiceCenterId, Map<String,Object> options) throws Exception
 	{

 		return franchisedOutletCityServiceCenterDaoOf(userContext).load(newCityServiceCenterId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(YoubenbenUserContext userContext, String cityEventId, int cityEventVersion) throws Exception {
		//deleteInternal(userContext, cityEventId, cityEventVersion);
	}
	protected void deleteInternal(YoubenbenUserContext userContext,
			String cityEventId, int cityEventVersion) throws Exception{

		cityEventDaoOf(userContext).delete(cityEventId, cityEventVersion);
	}

	public CityEvent forgetByAll(YoubenbenUserContext userContext, String cityEventId, int cityEventVersion) throws Exception {
		return forgetByAllInternal(userContext, cityEventId, cityEventVersion);
	}
	protected CityEvent forgetByAllInternal(YoubenbenUserContext userContext,
			String cityEventId, int cityEventVersion) throws Exception{

		return cityEventDaoOf(userContext).disconnectFromAll(cityEventId, cityEventVersion);
	}




	public int deleteAll(YoubenbenUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CityEventManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(YoubenbenUserContext userContext) throws Exception{
		return cityEventDaoOf(userContext).deleteAll();
	}


	//disconnect CityEvent with potential_customer in EventAttendance
	protected CityEvent breakWithEventAttendanceByPotentialCustomer(YoubenbenUserContext userContext, String cityEventId, String potentialCustomerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());

			synchronized(cityEvent){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				cityEventDaoOf(userContext).planToRemoveEventAttendanceListWithPotentialCustomer(cityEvent, potentialCustomerId, this.emptyOptions());

				cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
				return cityEvent;
			}
	}






	protected void checkParamsForAddingEventAttendance(YoubenbenUserContext userContext, String cityEventId, String name, String potentialCustomerId, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfCityEvent(cityEventId);

		
		checkerOf(userContext).checkNameOfEventAttendance(name);
		
		checkerOf(userContext).checkPotentialCustomerIdOfEventAttendance(potentialCustomerId);
		
		checkerOf(userContext).checkDescriptionOfEventAttendance(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityEventManagerException.class);


	}
	public  CityEvent addEventAttendance(YoubenbenUserContext userContext, String cityEventId, String name, String potentialCustomerId, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEventAttendance(userContext,cityEventId,name, potentialCustomerId, description,tokensExpr);

		EventAttendance eventAttendance = createEventAttendance(userContext,name, potentialCustomerId, description);

		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, emptyOptions());
		synchronized(cityEvent){
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityEvent.addEventAttendance( eventAttendance );
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			
			userContext.getManagerGroup().getEventAttendanceManager().onNewInstanceCreated(userContext, eventAttendance);
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEventAttendanceProperties(YoubenbenUserContext userContext, String cityEventId,String id,String name,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCityEvent(cityEventId);
		checkerOf(userContext).checkIdOfEventAttendance(id);

		checkerOf(userContext).checkNameOfEventAttendance( name);
		checkerOf(userContext).checkDescriptionOfEventAttendance( description);

		checkerOf(userContext).throwExceptionIfHasErrors(CityEventManagerException.class);

	}
	public  CityEvent updateEventAttendanceProperties(YoubenbenUserContext userContext, String cityEventId, String id,String name,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEventAttendanceProperties(userContext,cityEventId,id,name,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEventAttendanceListList()
				.searchEventAttendanceListWith(EventAttendance.ID_PROPERTY, "is", id).done();

		CityEvent cityEventToUpdate = loadCityEvent(userContext, cityEventId, options);

		if(cityEventToUpdate.getEventAttendanceList().isEmpty()){
			throw new CityEventManagerException("EventAttendance is NOT FOUND with id: '"+id+"'");
		}

		EventAttendance item = cityEventToUpdate.getEventAttendanceList().first();

		item.updateName( name );
		item.updateDescription( description );


		//checkParamsForAddingEventAttendance(userContext,cityEventId,name, code, used,tokensExpr);
		CityEvent cityEvent = saveCityEvent(userContext, cityEventToUpdate, tokens().withEventAttendanceList().done());
		synchronized(cityEvent){
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}
	}


	protected EventAttendance createEventAttendance(YoubenbenUserContext userContext, String name, String potentialCustomerId, String description) throws Exception{

		EventAttendance eventAttendance = new EventAttendance();
		
		
		eventAttendance.setName(name);		
		PotentialCustomer  potentialCustomer = new PotentialCustomer();
		potentialCustomer.setId(potentialCustomerId);		
		eventAttendance.setPotentialCustomer(potentialCustomer);		
		eventAttendance.setDescription(description);
	
		
		return eventAttendance;


	}

	protected EventAttendance createIndexedEventAttendance(String id, int version){

		EventAttendance eventAttendance = new EventAttendance();
		eventAttendance.setId(id);
		eventAttendance.setVersion(version);
		return eventAttendance;

	}

	protected void checkParamsForRemovingEventAttendanceList(YoubenbenUserContext userContext, String cityEventId,
			String eventAttendanceIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCityEvent(cityEventId);
		for(String eventAttendanceIdItem: eventAttendanceIds){
			checkerOf(userContext).checkIdOfEventAttendance(eventAttendanceIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(CityEventManagerException.class);

	}
	public  CityEvent removeEventAttendanceList(YoubenbenUserContext userContext, String cityEventId,
			String eventAttendanceIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEventAttendanceList(userContext, cityEventId,  eventAttendanceIds, tokensExpr);


			CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
			synchronized(cityEvent){
				//Will be good when the cityEvent loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				cityEventDaoOf(userContext).planToRemoveEventAttendanceList(cityEvent, eventAttendanceIds, allTokens());
				cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
				deleteRelationListInGraph(userContext, cityEvent.getEventAttendanceList());
				return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEventAttendance(YoubenbenUserContext userContext, String cityEventId,
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCityEvent( cityEventId);
		checkerOf(userContext).checkIdOfEventAttendance(eventAttendanceId);
		checkerOf(userContext).checkVersionOfEventAttendance(eventAttendanceVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CityEventManagerException.class);

	}
	public  CityEvent removeEventAttendance(YoubenbenUserContext userContext, String cityEventId,
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEventAttendance(userContext,cityEventId, eventAttendanceId, eventAttendanceVersion,tokensExpr);

		EventAttendance eventAttendance = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		synchronized(cityEvent){
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityEvent.removeEventAttendance( eventAttendance );
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			deleteRelationInGraph(userContext, eventAttendance);
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEventAttendance(YoubenbenUserContext userContext, String cityEventId,
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCityEvent( cityEventId);
		checkerOf(userContext).checkIdOfEventAttendance(eventAttendanceId);
		checkerOf(userContext).checkVersionOfEventAttendance(eventAttendanceVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CityEventManagerException.class);

	}
	public  CityEvent copyEventAttendanceFrom(YoubenbenUserContext userContext, String cityEventId,
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEventAttendance(userContext,cityEventId, eventAttendanceId, eventAttendanceVersion,tokensExpr);

		EventAttendance eventAttendance = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		synchronized(cityEvent){
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			cityEvent.copyEventAttendanceFrom( eventAttendance );
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			
			userContext.getManagerGroup().getEventAttendanceManager().onNewInstanceCreated(userContext, (EventAttendance)cityEvent.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEventAttendance(YoubenbenUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfCityEvent(cityEventId);
		checkerOf(userContext).checkIdOfEventAttendance(eventAttendanceId);
		checkerOf(userContext).checkVersionOfEventAttendance(eventAttendanceVersion);
		

		if(EventAttendance.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfEventAttendance(parseString(newValueExpr));
		
		}
		
		if(EventAttendance.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfEventAttendance(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityEventManagerException.class);

	}

	public  CityEvent updateEventAttendance(YoubenbenUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEventAttendance(userContext, cityEventId, eventAttendanceId, eventAttendanceVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEventAttendanceList().searchEventAttendanceListWith(EventAttendance.ID_PROPERTY, "eq", eventAttendanceId).done();



		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, loadTokens);

		synchronized(cityEvent){
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//cityEvent.removeEventAttendance( eventAttendance );
			//make changes to AcceleraterAccount.
			EventAttendance eventAttendanceIndex = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);

			EventAttendance eventAttendance = cityEvent.findTheEventAttendance(eventAttendanceIndex);
			if(eventAttendance == null){
				throw new CityEventManagerException(eventAttendance+" is NOT FOUND" );
			}

			eventAttendance.changeProperty(property, newValueExpr);
			
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(YoubenbenUserContext userContext, CityEvent newCreated) throws Exception{
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
		//   CityEvent newCityEvent = this.createCityEvent(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newCityEvent
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, CityEvent.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(YoubenbenUserContext userContext,SmartList<CityEvent> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<FranchisedOutletCityServiceCenter> cityServiceCenterList = YoubenbenBaseUtils.collectReferencedObjectWithType(userContext, list, FranchisedOutletCityServiceCenter.class);
		userContext.getDAOGroup().enhanceList(cityServiceCenterList, FranchisedOutletCityServiceCenter.class);


    }
	
	public Object listByCityServiceCenter(YoubenbenUserContext userContext,String cityServiceCenterId) throws Exception {
		return listPageByCityServiceCenter(userContext, cityServiceCenterId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCityServiceCenter(YoubenbenUserContext userContext,String cityServiceCenterId, int start, int count) throws Exception {
		SmartList<CityEvent> list = cityEventDaoOf(userContext).findCityEventByCityServiceCenter(cityServiceCenterId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		YoubenbenCommonListOfViewPage page = new YoubenbenCommonListOfViewPage();
		page.setClassOfList(CityEvent.class);
		page.setContainerObject(FranchisedOutletCityServiceCenter.withId(cityServiceCenterId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("城市活动列表");
		page.setRequestName("listByCityServiceCenter");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCityServiceCenter/%s/",  getBeanName(), cityServiceCenterId)));

		page.assemblerContent(userContext, "listByCityServiceCenter");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(YoubenbenUserContext userContext, String cityEventId) throws Exception{
	  SerializeScope vscope = YoubenbenViewScope.getInstance().getCityEventDetailScope().clone();
		CityEvent merchantObj = (CityEvent) this.view(userContext, cityEventId);
    String merchantObjId = cityEventId;
    String linkToUrl =	"cityEventManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "城市活动"+"详情";
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
				MapUtil.put("id", "3-mobile")
				    .put("fieldName", "mobile")
				    .put("label", "手机号码")
				    .put("type", "mobile")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("mobile", merchantObj.getMobile());

		propList.add(
				MapUtil.put("id", "4-cityServiceCenter")
				    .put("fieldName", "cityServiceCenter")
				    .put("label", "城市服务中心")
				    .put("type", "auto")
				    .put("linkToUrl", "franchisedOutletCityServiceCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("cityServiceCenter", merchantObj.getCityServiceCenter());

		propList.add(
				MapUtil.put("id", "5-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "6-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "最后更新时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：eventAttendanceListSection
		Map eventAttendanceListSection = ListofUtils.buildSection(
		    "eventAttendanceListSection",
		    "事件出席名单",
		    null,
		    "",
		    "__no_group",
		    "eventAttendanceManager/listByCityEvent/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(eventAttendanceListSection);

		result.put("eventAttendanceListSection", ListofUtils.toShortList(merchantObj.getEventAttendanceList(), "eventAttendance"));
		vscope.field("eventAttendanceListSection", YoubenbenListOfViewScope.getInstance()
					.getListOfViewScope( EventAttendance.class.getName(), null));

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


