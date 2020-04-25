
package com.xingyou.xingyou.franchisedoutletcityservicecenter;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.xingyou.xingyou.XingyouBaseDAOImpl;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.SmartList;
import com.xingyou.xingyou.AccessKey;
import com.xingyou.xingyou.DateKey;
import com.xingyou.xingyou.StatsInfo;
import com.xingyou.xingyou.StatsItem;

import com.xingyou.xingyou.MultipleAccessKey;
import com.xingyou.xingyou.XingyouUserContext;


import com.xingyou.xingyou.cityevent.CityEvent;
import com.xingyou.xingyou.citypartner.CityPartner;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.xingyou.xingyou.potentialcustomer.PotentialCustomer;

import com.xingyou.xingyou.potentialcustomer.PotentialCustomerDAO;
import com.xingyou.xingyou.citypartner.CityPartnerDAO;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO;
import com.xingyou.xingyou.cityevent.CityEventDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class FranchisedOutletCityServiceCenterJDBCTemplateDAO extends XingyouBaseDAOImpl implements FranchisedOutletCityServiceCenterDAO{

	protected FranchisedOutletCityCenterDAO franchisedOutletCityCenterDAO;
	public void setFranchisedOutletCityCenterDAO(FranchisedOutletCityCenterDAO franchisedOutletCityCenterDAO){
 	
 		if(franchisedOutletCityCenterDAO == null){
 			throw new IllegalStateException("Do not try to set franchisedOutletCityCenterDAO to null.");
 		}
	 	this.franchisedOutletCityCenterDAO = franchisedOutletCityCenterDAO;
 	}
 	public FranchisedOutletCityCenterDAO getFranchisedOutletCityCenterDAO(){
 		if(this.franchisedOutletCityCenterDAO == null){
 			throw new IllegalStateException("The franchisedOutletCityCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.franchisedOutletCityCenterDAO;
 	}	

	protected CityPartnerDAO cityPartnerDAO;
	public void setCityPartnerDAO(CityPartnerDAO cityPartnerDAO){
 	
 		if(cityPartnerDAO == null){
 			throw new IllegalStateException("Do not try to set cityPartnerDAO to null.");
 		}
	 	this.cityPartnerDAO = cityPartnerDAO;
 	}
 	public CityPartnerDAO getCityPartnerDAO(){
 		if(this.cityPartnerDAO == null){
 			throw new IllegalStateException("The cityPartnerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityPartnerDAO;
 	}	

	protected PotentialCustomerDAO potentialCustomerDAO;
	public void setPotentialCustomerDAO(PotentialCustomerDAO potentialCustomerDAO){
 	
 		if(potentialCustomerDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerDAO to null.");
 		}
	 	this.potentialCustomerDAO = potentialCustomerDAO;
 	}
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
 		if(this.potentialCustomerDAO == null){
 			throw new IllegalStateException("The potentialCustomerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerDAO;
 	}	

	protected CityEventDAO cityEventDAO;
	public void setCityEventDAO(CityEventDAO cityEventDAO){
 	
 		if(cityEventDAO == null){
 			throw new IllegalStateException("Do not try to set cityEventDAO to null.");
 		}
	 	this.cityEventDAO = cityEventDAO;
 	}
 	public CityEventDAO getCityEventDAO(){
 		if(this.cityEventDAO == null){
 			throw new IllegalStateException("The cityEventDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityEventDAO;
 	}	

	
	/*
	protected FranchisedOutletCityServiceCenter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalFranchisedOutletCityServiceCenter(accessKey, options);
	}
	*/
	
	public SmartList<FranchisedOutletCityServiceCenter> loadAll() {
	    return this.loadAll(getFranchisedOutletCityServiceCenterMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public FranchisedOutletCityServiceCenter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalFranchisedOutletCityServiceCenter(FranchisedOutletCityServiceCenterTable.withId(id), options);
	}
	
	
	
	public FranchisedOutletCityServiceCenter save(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter,Map<String,Object> options){
		
		String methodName="save(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(franchisedOutletCityServiceCenter, methodName, "franchisedOutletCityServiceCenter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenter,options);
	}
	public FranchisedOutletCityServiceCenter clone(String franchisedOutletCityServiceCenterId, Map<String,Object> options) throws Exception{
	
		return clone(FranchisedOutletCityServiceCenterTable.withId(franchisedOutletCityServiceCenterId),options);
	}
	
	protected FranchisedOutletCityServiceCenter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String franchisedOutletCityServiceCenterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		FranchisedOutletCityServiceCenter newFranchisedOutletCityServiceCenter = loadInternalFranchisedOutletCityServiceCenter(accessKey, options);
		newFranchisedOutletCityServiceCenter.setVersion(0);
		
		
 		
 		if(isSaveCityPartnerListEnabled(options)){
 			for(CityPartner item: newFranchisedOutletCityServiceCenter.getCityPartnerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePotentialCustomerListEnabled(options)){
 			for(PotentialCustomer item: newFranchisedOutletCityServiceCenter.getPotentialCustomerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCityEventListEnabled(options)){
 			for(CityEvent item: newFranchisedOutletCityServiceCenter.getCityEventList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalFranchisedOutletCityServiceCenter(newFranchisedOutletCityServiceCenter,options);
		
		return newFranchisedOutletCityServiceCenter;
	}
	
	
	
	

	protected void throwIfHasException(String franchisedOutletCityServiceCenterId,int version,int count) throws Exception{
		if (count == 1) {
			throw new FranchisedOutletCityServiceCenterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new FranchisedOutletCityServiceCenterNotFoundException(
					"The " + this.getTableName() + "(" + franchisedOutletCityServiceCenterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String franchisedOutletCityServiceCenterId, int version) throws Exception{
	
		String methodName="delete(String franchisedOutletCityServiceCenterId, int version)";
		assertMethodArgumentNotNull(franchisedOutletCityServiceCenterId, methodName, "franchisedOutletCityServiceCenterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{franchisedOutletCityServiceCenterId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(franchisedOutletCityServiceCenterId,version);
		}
		
	
	}
	
	
	
	
	

	public FranchisedOutletCityServiceCenter disconnectFromAll(String franchisedOutletCityServiceCenterId, int version) throws Exception{
	
		
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadInternalFranchisedOutletCityServiceCenter(FranchisedOutletCityServiceCenterTable.withId(franchisedOutletCityServiceCenterId), emptyOptions());
		franchisedOutletCityServiceCenter.clearFromAll();
		this.saveFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenter);
		return franchisedOutletCityServiceCenter;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return FranchisedOutletCityServiceCenterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "franchised_outlet_city_service_center";
	}
	@Override
	protected String getBeanName() {
		
		return "franchisedOutletCityServiceCenter";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return FranchisedOutletCityServiceCenterTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, FranchisedOutletCityServiceCenterTokens.BELONGSTO);
 	}

 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, FranchisedOutletCityServiceCenterTokens.BELONGSTO);
 	}
 	

 	
 
		
	
	protected boolean isExtractCityPartnerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,FranchisedOutletCityServiceCenterTokens.CITY_PARTNER_LIST);
 	}
 	protected boolean isAnalyzeCityPartnerListEnabled(Map<String,Object> options){		 		
 		return FranchisedOutletCityServiceCenterTokens.of(options).analyzeCityPartnerListEnabled();
 	}
	
	protected boolean isSaveCityPartnerListEnabled(Map<String,Object> options){
		return checkOptions(options, FranchisedOutletCityServiceCenterTokens.CITY_PARTNER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractPotentialCustomerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,FranchisedOutletCityServiceCenterTokens.POTENTIAL_CUSTOMER_LIST);
 	}
 	protected boolean isAnalyzePotentialCustomerListEnabled(Map<String,Object> options){		 		
 		return FranchisedOutletCityServiceCenterTokens.of(options).analyzePotentialCustomerListEnabled();
 	}
	
	protected boolean isSavePotentialCustomerListEnabled(Map<String,Object> options){
		return checkOptions(options, FranchisedOutletCityServiceCenterTokens.POTENTIAL_CUSTOMER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractCityEventListEnabled(Map<String,Object> options){		
 		return checkOptions(options,FranchisedOutletCityServiceCenterTokens.CITY_EVENT_LIST);
 	}
 	protected boolean isAnalyzeCityEventListEnabled(Map<String,Object> options){		 		
 		return FranchisedOutletCityServiceCenterTokens.of(options).analyzeCityEventListEnabled();
 	}
	
	protected boolean isSaveCityEventListEnabled(Map<String,Object> options){
		return checkOptions(options, FranchisedOutletCityServiceCenterTokens.CITY_EVENT_LIST);
		
 	}
 	
		

	

	protected FranchisedOutletCityServiceCenterMapper getFranchisedOutletCityServiceCenterMapper(){
		return new FranchisedOutletCityServiceCenterMapper();
	}

	
	
	protected FranchisedOutletCityServiceCenter extractFranchisedOutletCityServiceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = loadSingleObject(accessKey, getFranchisedOutletCityServiceCenterMapper());
			return franchisedOutletCityServiceCenter;
		}catch(EmptyResultDataAccessException e){
			throw new FranchisedOutletCityServiceCenterNotFoundException("FranchisedOutletCityServiceCenter("+accessKey+") is not found!");
		}

	}

	
	

	protected FranchisedOutletCityServiceCenter loadInternalFranchisedOutletCityServiceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = extractFranchisedOutletCityServiceCenter(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(franchisedOutletCityServiceCenter, loadOptions);
 		}
 
		
		if(isExtractCityPartnerListEnabled(loadOptions)){
	 		extractCityPartnerList(franchisedOutletCityServiceCenter, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeCityPartnerListEnabled(loadOptions)){
	 		analyzeCityPartnerList(franchisedOutletCityServiceCenter, loadOptions);
 		}
 		
		
		if(isExtractPotentialCustomerListEnabled(loadOptions)){
	 		extractPotentialCustomerList(franchisedOutletCityServiceCenter, loadOptions);
 		}	
 		
 		
 		if(isAnalyzePotentialCustomerListEnabled(loadOptions)){
	 		analyzePotentialCustomerList(franchisedOutletCityServiceCenter, loadOptions);
 		}
 		
		
		if(isExtractCityEventListEnabled(loadOptions)){
	 		extractCityEventList(franchisedOutletCityServiceCenter, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeCityEventListEnabled(loadOptions)){
	 		analyzeCityEventList(franchisedOutletCityServiceCenter, loadOptions);
 		}
 		
		
		return franchisedOutletCityServiceCenter;
		
	}

	 

 	protected FranchisedOutletCityServiceCenter extractBelongsTo(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options) throws Exception{

		if(franchisedOutletCityServiceCenter.getBelongsTo() == null){
			return franchisedOutletCityServiceCenter;
		}
		String belongsToId = franchisedOutletCityServiceCenter.getBelongsTo().getId();
		if( belongsToId == null){
			return franchisedOutletCityServiceCenter;
		}
		FranchisedOutletCityCenter belongsTo = getFranchisedOutletCityCenterDAO().load(belongsToId,options);
		if(belongsTo != null){
			franchisedOutletCityServiceCenter.setBelongsTo(belongsTo);
		}
		
 		
 		return franchisedOutletCityServiceCenter;
 	}
 		
 
		
	protected void enhanceCityPartnerList(SmartList<CityPartner> cityPartnerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected FranchisedOutletCityServiceCenter extractCityPartnerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityServiceCenter == null){
			return null;
		}
		if(franchisedOutletCityServiceCenter.getId() == null){
			return franchisedOutletCityServiceCenter;
		}

		
		
		SmartList<CityPartner> cityPartnerList = getCityPartnerDAO().findCityPartnerByTownServiceCenter(franchisedOutletCityServiceCenter.getId(),options);
		if(cityPartnerList != null){
			enhanceCityPartnerList(cityPartnerList,options);
			franchisedOutletCityServiceCenter.setCityPartnerList(cityPartnerList);
		}
		
		return franchisedOutletCityServiceCenter;
	
	}	
	
	protected FranchisedOutletCityServiceCenter analyzeCityPartnerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityServiceCenter == null){
			return null;
		}
		if(franchisedOutletCityServiceCenter.getId() == null){
			return franchisedOutletCityServiceCenter;
		}

		
		
		SmartList<CityPartner> cityPartnerList = franchisedOutletCityServiceCenter.getCityPartnerList();
		if(cityPartnerList != null){
			getCityPartnerDAO().analyzeCityPartnerByTownServiceCenter(cityPartnerList, franchisedOutletCityServiceCenter.getId(), options);
			
		}
		
		return franchisedOutletCityServiceCenter;
	
	}	
	
		
	protected void enhancePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected FranchisedOutletCityServiceCenter extractPotentialCustomerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityServiceCenter == null){
			return null;
		}
		if(franchisedOutletCityServiceCenter.getId() == null){
			return franchisedOutletCityServiceCenter;
		}

		
		
		SmartList<PotentialCustomer> potentialCustomerList = getPotentialCustomerDAO().findPotentialCustomerByCityServiceCenter(franchisedOutletCityServiceCenter.getId(),options);
		if(potentialCustomerList != null){
			enhancePotentialCustomerList(potentialCustomerList,options);
			franchisedOutletCityServiceCenter.setPotentialCustomerList(potentialCustomerList);
		}
		
		return franchisedOutletCityServiceCenter;
	
	}	
	
	protected FranchisedOutletCityServiceCenter analyzePotentialCustomerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityServiceCenter == null){
			return null;
		}
		if(franchisedOutletCityServiceCenter.getId() == null){
			return franchisedOutletCityServiceCenter;
		}

		
		
		SmartList<PotentialCustomer> potentialCustomerList = franchisedOutletCityServiceCenter.getPotentialCustomerList();
		if(potentialCustomerList != null){
			getPotentialCustomerDAO().analyzePotentialCustomerByCityServiceCenter(potentialCustomerList, franchisedOutletCityServiceCenter.getId(), options);
			
		}
		
		return franchisedOutletCityServiceCenter;
	
	}	
	
		
	protected void enhanceCityEventList(SmartList<CityEvent> cityEventList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected FranchisedOutletCityServiceCenter extractCityEventList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityServiceCenter == null){
			return null;
		}
		if(franchisedOutletCityServiceCenter.getId() == null){
			return franchisedOutletCityServiceCenter;
		}

		
		
		SmartList<CityEvent> cityEventList = getCityEventDAO().findCityEventByCityServiceCenter(franchisedOutletCityServiceCenter.getId(),options);
		if(cityEventList != null){
			enhanceCityEventList(cityEventList,options);
			franchisedOutletCityServiceCenter.setCityEventList(cityEventList);
		}
		
		return franchisedOutletCityServiceCenter;
	
	}	
	
	protected FranchisedOutletCityServiceCenter analyzeCityEventList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityServiceCenter == null){
			return null;
		}
		if(franchisedOutletCityServiceCenter.getId() == null){
			return franchisedOutletCityServiceCenter;
		}

		
		
		SmartList<CityEvent> cityEventList = franchisedOutletCityServiceCenter.getCityEventList();
		if(cityEventList != null){
			getCityEventDAO().analyzeCityEventByCityServiceCenter(cityEventList, franchisedOutletCityServiceCenter.getId(), options);
			
		}
		
		return franchisedOutletCityServiceCenter;
	
	}	
	
		
		
  	
 	public SmartList<FranchisedOutletCityServiceCenter> findFranchisedOutletCityServiceCenterByBelongsTo(String franchisedOutletCityCenterId,Map<String,Object> options){
 	
  		SmartList<FranchisedOutletCityServiceCenter> resultList = queryWith(FranchisedOutletCityServiceCenterTable.COLUMN_BELONGS_TO, franchisedOutletCityCenterId, options, getFranchisedOutletCityServiceCenterMapper());
		// analyzeFranchisedOutletCityServiceCenterByBelongsTo(resultList, franchisedOutletCityCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<FranchisedOutletCityServiceCenter> findFranchisedOutletCityServiceCenterByBelongsTo(String franchisedOutletCityCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<FranchisedOutletCityServiceCenter> resultList =  queryWithRange(FranchisedOutletCityServiceCenterTable.COLUMN_BELONGS_TO, franchisedOutletCityCenterId, options, getFranchisedOutletCityServiceCenterMapper(), start, count);
 		//analyzeFranchisedOutletCityServiceCenterByBelongsTo(resultList, franchisedOutletCityCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeFranchisedOutletCityServiceCenterByBelongsTo(SmartList<FranchisedOutletCityServiceCenter> resultList, String franchisedOutletCityCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(FranchisedOutletCityServiceCenter.BELONGS_TO_PROPERTY, franchisedOutletCityCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//FranchisedOutletCityServiceCenter.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("特许经销城市服务中心");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(FranchisedOutletCityServiceCenter.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(FranchisedOutletCityServiceCenter.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countFranchisedOutletCityServiceCenterByBelongsTo(String franchisedOutletCityCenterId,Map<String,Object> options){

 		return countWith(FranchisedOutletCityServiceCenterTable.COLUMN_BELONGS_TO, franchisedOutletCityCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countFranchisedOutletCityServiceCenterByBelongsToIds(String[] ids, Map<String, Object> options) {
		return countWithIds(FranchisedOutletCityServiceCenterTable.COLUMN_BELONGS_TO, ids, options);
	}
 	
 	
		
		
		

	

	protected FranchisedOutletCityServiceCenter saveFranchisedOutletCityServiceCenter(FranchisedOutletCityServiceCenter  franchisedOutletCityServiceCenter){
		
		if(!franchisedOutletCityServiceCenter.isChanged()){
			return franchisedOutletCityServiceCenter;
		}
		
		
		String SQL=this.getSaveFranchisedOutletCityServiceCenterSQL(franchisedOutletCityServiceCenter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveFranchisedOutletCityServiceCenterParameters(franchisedOutletCityServiceCenter);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		franchisedOutletCityServiceCenter.incVersion();
		return franchisedOutletCityServiceCenter;
	
	}
	public SmartList<FranchisedOutletCityServiceCenter> saveFranchisedOutletCityServiceCenterList(SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitFranchisedOutletCityServiceCenterList(franchisedOutletCityServiceCenterList);
		
		batchFranchisedOutletCityServiceCenterCreate((List<FranchisedOutletCityServiceCenter>)lists[CREATE_LIST_INDEX]);
		
		batchFranchisedOutletCityServiceCenterUpdate((List<FranchisedOutletCityServiceCenter>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter:franchisedOutletCityServiceCenterList){
			if(franchisedOutletCityServiceCenter.isChanged()){
				franchisedOutletCityServiceCenter.incVersion();
			}
			
		
		}
		
		
		return franchisedOutletCityServiceCenterList;
	}

	public SmartList<FranchisedOutletCityServiceCenter> removeFranchisedOutletCityServiceCenterList(SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList,Map<String,Object> options){
		
		
		super.removeList(franchisedOutletCityServiceCenterList, options);
		
		return franchisedOutletCityServiceCenterList;
		
		
	}
	
	protected List<Object[]> prepareFranchisedOutletCityServiceCenterBatchCreateArgs(List<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter:franchisedOutletCityServiceCenterList ){
			Object [] parameters = prepareFranchisedOutletCityServiceCenterCreateParameters(franchisedOutletCityServiceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareFranchisedOutletCityServiceCenterBatchUpdateArgs(List<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter:franchisedOutletCityServiceCenterList ){
			if(!franchisedOutletCityServiceCenter.isChanged()){
				continue;
			}
			Object [] parameters = prepareFranchisedOutletCityServiceCenterUpdateParameters(franchisedOutletCityServiceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchFranchisedOutletCityServiceCenterCreate(List<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareFranchisedOutletCityServiceCenterBatchCreateArgs(franchisedOutletCityServiceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchFranchisedOutletCityServiceCenterUpdate(List<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareFranchisedOutletCityServiceCenterBatchUpdateArgs(franchisedOutletCityServiceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitFranchisedOutletCityServiceCenterList(List<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList){
		
		List<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterCreateList=new ArrayList<FranchisedOutletCityServiceCenter>();
		List<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterUpdateList=new ArrayList<FranchisedOutletCityServiceCenter>();
		
		for(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter: franchisedOutletCityServiceCenterList){
			if(isUpdateRequest(franchisedOutletCityServiceCenter)){
				franchisedOutletCityServiceCenterUpdateList.add( franchisedOutletCityServiceCenter);
				continue;
			}
			franchisedOutletCityServiceCenterCreateList.add(franchisedOutletCityServiceCenter);
		}
		
		return new Object[]{franchisedOutletCityServiceCenterCreateList,franchisedOutletCityServiceCenterUpdateList};
	}
	
	protected boolean isUpdateRequest(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter){
 		return franchisedOutletCityServiceCenter.getVersion() > 0;
 	}
 	protected String getSaveFranchisedOutletCityServiceCenterSQL(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter){
 		if(isUpdateRequest(franchisedOutletCityServiceCenter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveFranchisedOutletCityServiceCenterParameters(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter){
 		if(isUpdateRequest(franchisedOutletCityServiceCenter) ){
 			return prepareFranchisedOutletCityServiceCenterUpdateParameters(franchisedOutletCityServiceCenter);
 		}
 		return prepareFranchisedOutletCityServiceCenterCreateParameters(franchisedOutletCityServiceCenter);
 	}
 	protected Object[] prepareFranchisedOutletCityServiceCenterUpdateParameters(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = franchisedOutletCityServiceCenter.getName();
 		
 		
 		parameters[1] = franchisedOutletCityServiceCenter.getFounded();
 		 	
 		if(franchisedOutletCityServiceCenter.getBelongsTo() != null){
 			parameters[2] = franchisedOutletCityServiceCenter.getBelongsTo().getId();
 		}
 
 		
 		parameters[3] = franchisedOutletCityServiceCenter.getLastUpdateTime();
 				
 		parameters[4] = franchisedOutletCityServiceCenter.nextVersion();
 		parameters[5] = franchisedOutletCityServiceCenter.getId();
 		parameters[6] = franchisedOutletCityServiceCenter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareFranchisedOutletCityServiceCenterCreateParameters(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter){
		Object[] parameters = new Object[5];
		String newFranchisedOutletCityServiceCenterId=getNextId();
		franchisedOutletCityServiceCenter.setId(newFranchisedOutletCityServiceCenterId);
		parameters[0] =  franchisedOutletCityServiceCenter.getId();
 
 		
 		parameters[1] = franchisedOutletCityServiceCenter.getName();
 		
 		
 		parameters[2] = franchisedOutletCityServiceCenter.getFounded();
 		 	
 		if(franchisedOutletCityServiceCenter.getBelongsTo() != null){
 			parameters[3] = franchisedOutletCityServiceCenter.getBelongsTo().getId();
 		
 		}
 		
 		
 		parameters[4] = franchisedOutletCityServiceCenter.getLastUpdateTime();
 				
 				
 		return parameters;
 	}
 	
	protected FranchisedOutletCityServiceCenter saveInternalFranchisedOutletCityServiceCenter(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
		
		saveFranchisedOutletCityServiceCenter(franchisedOutletCityServiceCenter);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(franchisedOutletCityServiceCenter, options);
 		}
 
		
		if(isSaveCityPartnerListEnabled(options)){
	 		saveCityPartnerList(franchisedOutletCityServiceCenter, options);
	 		//removeCityPartnerList(franchisedOutletCityServiceCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSavePotentialCustomerListEnabled(options)){
	 		savePotentialCustomerList(franchisedOutletCityServiceCenter, options);
	 		//removePotentialCustomerList(franchisedOutletCityServiceCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveCityEventListEnabled(options)){
	 		saveCityEventList(franchisedOutletCityServiceCenter, options);
	 		//removeCityEventList(franchisedOutletCityServiceCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		return franchisedOutletCityServiceCenter;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected FranchisedOutletCityServiceCenter saveBelongsTo(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(franchisedOutletCityServiceCenter.getBelongsTo() == null){
 			return franchisedOutletCityServiceCenter;//do nothing when it is null
 		}
 		
 		getFranchisedOutletCityCenterDAO().save(franchisedOutletCityServiceCenter.getBelongsTo(),options);
 		return franchisedOutletCityServiceCenter;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public FranchisedOutletCityServiceCenter planToRemoveCityPartnerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, String cityPartnerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityPartner.TOWN_SERVICE_CENTER_PROPERTY, franchisedOutletCityServiceCenter.getId());
		key.put(CityPartner.ID_PROPERTY, cityPartnerIds);
		
		SmartList<CityPartner> externalCityPartnerList = getCityPartnerDAO().
				findCityPartnerWithKey(key, options);
		if(externalCityPartnerList == null){
			return franchisedOutletCityServiceCenter;
		}
		if(externalCityPartnerList.isEmpty()){
			return franchisedOutletCityServiceCenter;
		}
		
		for(CityPartner cityPartnerItem: externalCityPartnerList){

			cityPartnerItem.clearFromAll();
		}
		
		
		SmartList<CityPartner> cityPartnerList = franchisedOutletCityServiceCenter.getCityPartnerList();		
		cityPartnerList.addAllToRemoveList(externalCityPartnerList);
		return franchisedOutletCityServiceCenter;	
	
	}


	public FranchisedOutletCityServiceCenter planToRemovePotentialCustomerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, String potentialCustomerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, franchisedOutletCityServiceCenter.getId());
		key.put(PotentialCustomer.ID_PROPERTY, potentialCustomerIds);
		
		SmartList<PotentialCustomer> externalPotentialCustomerList = getPotentialCustomerDAO().
				findPotentialCustomerWithKey(key, options);
		if(externalPotentialCustomerList == null){
			return franchisedOutletCityServiceCenter;
		}
		if(externalPotentialCustomerList.isEmpty()){
			return franchisedOutletCityServiceCenter;
		}
		
		for(PotentialCustomer potentialCustomerItem: externalPotentialCustomerList){

			potentialCustomerItem.clearFromAll();
		}
		
		
		SmartList<PotentialCustomer> potentialCustomerList = franchisedOutletCityServiceCenter.getPotentialCustomerList();		
		potentialCustomerList.addAllToRemoveList(externalPotentialCustomerList);
		return franchisedOutletCityServiceCenter;	
	
	}


	//disconnect FranchisedOutletCityServiceCenter with city_partner in PotentialCustomer
	public FranchisedOutletCityServiceCenter planToRemovePotentialCustomerListWithCityPartner(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, String cityPartnerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, franchisedOutletCityServiceCenter.getId());
		key.put(PotentialCustomer.CITY_PARTNER_PROPERTY, cityPartnerId);
		
		SmartList<PotentialCustomer> externalPotentialCustomerList = getPotentialCustomerDAO().
				findPotentialCustomerWithKey(key, options);
		if(externalPotentialCustomerList == null){
			return franchisedOutletCityServiceCenter;
		}
		if(externalPotentialCustomerList.isEmpty()){
			return franchisedOutletCityServiceCenter;
		}
		
		for(PotentialCustomer potentialCustomerItem: externalPotentialCustomerList){
			potentialCustomerItem.clearCityPartner();
			potentialCustomerItem.clearCityServiceCenter();
			
		}
		
		
		SmartList<PotentialCustomer> potentialCustomerList = franchisedOutletCityServiceCenter.getPotentialCustomerList();		
		potentialCustomerList.addAllToRemoveList(externalPotentialCustomerList);
		return franchisedOutletCityServiceCenter;
	}
	
	public int countPotentialCustomerListWithCityPartner(String franchisedOutletCityServiceCenterId, String cityPartnerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, franchisedOutletCityServiceCenterId);
		key.put(PotentialCustomer.CITY_PARTNER_PROPERTY, cityPartnerId);
		
		int count = getPotentialCustomerDAO().countPotentialCustomerWithKey(key, options);
		return count;
	}
	
	public FranchisedOutletCityServiceCenter planToRemoveCityEventList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, String cityEventIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityEvent.CITY_SERVICE_CENTER_PROPERTY, franchisedOutletCityServiceCenter.getId());
		key.put(CityEvent.ID_PROPERTY, cityEventIds);
		
		SmartList<CityEvent> externalCityEventList = getCityEventDAO().
				findCityEventWithKey(key, options);
		if(externalCityEventList == null){
			return franchisedOutletCityServiceCenter;
		}
		if(externalCityEventList.isEmpty()){
			return franchisedOutletCityServiceCenter;
		}
		
		for(CityEvent cityEventItem: externalCityEventList){

			cityEventItem.clearFromAll();
		}
		
		
		SmartList<CityEvent> cityEventList = franchisedOutletCityServiceCenter.getCityEventList();		
		cityEventList.addAllToRemoveList(externalCityEventList);
		return franchisedOutletCityServiceCenter;	
	
	}



		
	protected FranchisedOutletCityServiceCenter saveCityPartnerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
		
		
		
		
		SmartList<CityPartner> cityPartnerList = franchisedOutletCityServiceCenter.getCityPartnerList();
		if(cityPartnerList == null){
			//null list means nothing
			return franchisedOutletCityServiceCenter;
		}
		SmartList<CityPartner> mergedUpdateCityPartnerList = new SmartList<CityPartner>();
		
		
		mergedUpdateCityPartnerList.addAll(cityPartnerList); 
		if(cityPartnerList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCityPartnerList.addAll(cityPartnerList.getToRemoveList());
			cityPartnerList.removeAll(cityPartnerList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCityPartnerDAO().saveCityPartnerList(mergedUpdateCityPartnerList,options);
		
		if(cityPartnerList.getToRemoveList() != null){
			cityPartnerList.removeAll(cityPartnerList.getToRemoveList());
		}
		
		
		return franchisedOutletCityServiceCenter;
	
	}
	
	protected FranchisedOutletCityServiceCenter removeCityPartnerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
	
	
		SmartList<CityPartner> cityPartnerList = franchisedOutletCityServiceCenter.getCityPartnerList();
		if(cityPartnerList == null){
			return franchisedOutletCityServiceCenter;
		}	
	
		SmartList<CityPartner> toRemoveCityPartnerList = cityPartnerList.getToRemoveList();
		
		if(toRemoveCityPartnerList == null){
			return franchisedOutletCityServiceCenter;
		}
		if(toRemoveCityPartnerList.isEmpty()){
			return franchisedOutletCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCityPartnerDAO().removeCityPartnerList(toRemoveCityPartnerList,options);
		
		return franchisedOutletCityServiceCenter;
	
	}
	
	

 	
 	
	
	
	
		
	protected FranchisedOutletCityServiceCenter savePotentialCustomerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
		
		
		
		
		SmartList<PotentialCustomer> potentialCustomerList = franchisedOutletCityServiceCenter.getPotentialCustomerList();
		if(potentialCustomerList == null){
			//null list means nothing
			return franchisedOutletCityServiceCenter;
		}
		SmartList<PotentialCustomer> mergedUpdatePotentialCustomerList = new SmartList<PotentialCustomer>();
		
		
		mergedUpdatePotentialCustomerList.addAll(potentialCustomerList); 
		if(potentialCustomerList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdatePotentialCustomerList.addAll(potentialCustomerList.getToRemoveList());
			potentialCustomerList.removeAll(potentialCustomerList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getPotentialCustomerDAO().savePotentialCustomerList(mergedUpdatePotentialCustomerList,options);
		
		if(potentialCustomerList.getToRemoveList() != null){
			potentialCustomerList.removeAll(potentialCustomerList.getToRemoveList());
		}
		
		
		return franchisedOutletCityServiceCenter;
	
	}
	
	protected FranchisedOutletCityServiceCenter removePotentialCustomerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
	
	
		SmartList<PotentialCustomer> potentialCustomerList = franchisedOutletCityServiceCenter.getPotentialCustomerList();
		if(potentialCustomerList == null){
			return franchisedOutletCityServiceCenter;
		}	
	
		SmartList<PotentialCustomer> toRemovePotentialCustomerList = potentialCustomerList.getToRemoveList();
		
		if(toRemovePotentialCustomerList == null){
			return franchisedOutletCityServiceCenter;
		}
		if(toRemovePotentialCustomerList.isEmpty()){
			return franchisedOutletCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPotentialCustomerDAO().removePotentialCustomerList(toRemovePotentialCustomerList,options);
		
		return franchisedOutletCityServiceCenter;
	
	}
	
	

 	
 	
	
	
	
		
	protected FranchisedOutletCityServiceCenter saveCityEventList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
		
		
		
		
		SmartList<CityEvent> cityEventList = franchisedOutletCityServiceCenter.getCityEventList();
		if(cityEventList == null){
			//null list means nothing
			return franchisedOutletCityServiceCenter;
		}
		SmartList<CityEvent> mergedUpdateCityEventList = new SmartList<CityEvent>();
		
		
		mergedUpdateCityEventList.addAll(cityEventList); 
		if(cityEventList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCityEventList.addAll(cityEventList.getToRemoveList());
			cityEventList.removeAll(cityEventList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCityEventDAO().saveCityEventList(mergedUpdateCityEventList,options);
		
		if(cityEventList.getToRemoveList() != null){
			cityEventList.removeAll(cityEventList.getToRemoveList());
		}
		
		
		return franchisedOutletCityServiceCenter;
	
	}
	
	protected FranchisedOutletCityServiceCenter removeCityEventList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, Map<String,Object> options){
	
	
		SmartList<CityEvent> cityEventList = franchisedOutletCityServiceCenter.getCityEventList();
		if(cityEventList == null){
			return franchisedOutletCityServiceCenter;
		}	
	
		SmartList<CityEvent> toRemoveCityEventList = cityEventList.getToRemoveList();
		
		if(toRemoveCityEventList == null){
			return franchisedOutletCityServiceCenter;
		}
		if(toRemoveCityEventList.isEmpty()){
			return franchisedOutletCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCityEventDAO().removeCityEventList(toRemoveCityEventList,options);
		
		return franchisedOutletCityServiceCenter;
	
	}
	
	

 	
 	
	
	
	
		

	public FranchisedOutletCityServiceCenter present(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter,Map<String, Object> options){
	
		presentCityPartnerList(franchisedOutletCityServiceCenter,options);
		presentPotentialCustomerList(franchisedOutletCityServiceCenter,options);
		presentCityEventList(franchisedOutletCityServiceCenter,options);

		return franchisedOutletCityServiceCenter;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected FranchisedOutletCityServiceCenter presentCityPartnerList(
			FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter,
			Map<String, Object> options) {

		SmartList<CityPartner> cityPartnerList = franchisedOutletCityServiceCenter.getCityPartnerList();		
				SmartList<CityPartner> newList= presentSubList(franchisedOutletCityServiceCenter.getId(),
				cityPartnerList,
				options,
				getCityPartnerDAO()::countCityPartnerByTownServiceCenter,
				getCityPartnerDAO()::findCityPartnerByTownServiceCenter
				);

		
		franchisedOutletCityServiceCenter.setCityPartnerList(newList);
		

		return franchisedOutletCityServiceCenter;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected FranchisedOutletCityServiceCenter presentPotentialCustomerList(
			FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter,
			Map<String, Object> options) {

		SmartList<PotentialCustomer> potentialCustomerList = franchisedOutletCityServiceCenter.getPotentialCustomerList();		
				SmartList<PotentialCustomer> newList= presentSubList(franchisedOutletCityServiceCenter.getId(),
				potentialCustomerList,
				options,
				getPotentialCustomerDAO()::countPotentialCustomerByCityServiceCenter,
				getPotentialCustomerDAO()::findPotentialCustomerByCityServiceCenter
				);

		
		franchisedOutletCityServiceCenter.setPotentialCustomerList(newList);
		

		return franchisedOutletCityServiceCenter;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected FranchisedOutletCityServiceCenter presentCityEventList(
			FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter,
			Map<String, Object> options) {

		SmartList<CityEvent> cityEventList = franchisedOutletCityServiceCenter.getCityEventList();		
				SmartList<CityEvent> newList= presentSubList(franchisedOutletCityServiceCenter.getId(),
				cityEventList,
				options,
				getCityEventDAO()::countCityEventByCityServiceCenter,
				getCityEventDAO()::findCityEventByCityServiceCenter
				);

		
		franchisedOutletCityServiceCenter.setCityEventList(newList);
		

		return franchisedOutletCityServiceCenter;
	}			
		

	
    public SmartList<FranchisedOutletCityServiceCenter> requestCandidateFranchisedOutletCityServiceCenterForCityPartner(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(FranchisedOutletCityServiceCenterTable.COLUMN_NAME, FranchisedOutletCityServiceCenterTable.COLUMN_BELONGS_TO, filterKey, pageNo, pageSize, getFranchisedOutletCityServiceCenterMapper());
    }
		
    public SmartList<FranchisedOutletCityServiceCenter> requestCandidateFranchisedOutletCityServiceCenterForPotentialCustomer(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(FranchisedOutletCityServiceCenterTable.COLUMN_NAME, FranchisedOutletCityServiceCenterTable.COLUMN_BELONGS_TO, filterKey, pageNo, pageSize, getFranchisedOutletCityServiceCenterMapper());
    }
		
    public SmartList<FranchisedOutletCityServiceCenter> requestCandidateFranchisedOutletCityServiceCenterForCityEvent(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(FranchisedOutletCityServiceCenterTable.COLUMN_NAME, FranchisedOutletCityServiceCenterTable.COLUMN_BELONGS_TO, filterKey, pageNo, pageSize, getFranchisedOutletCityServiceCenterMapper());
    }
		

	protected String getTableName(){
		return FranchisedOutletCityServiceCenterTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList) {		
		this.enhanceListInternal(franchisedOutletCityServiceCenterList, this.getFranchisedOutletCityServiceCenterMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:CityPartner的townServiceCenter的CityPartnerList
	public SmartList<CityPartner> loadOurCityPartnerList(XingyouUserContext userContext, List<FranchisedOutletCityServiceCenter> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityPartner.TOWN_SERVICE_CENTER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<CityPartner> loadedObjs = userContext.getDAOGroup().getCityPartnerDAO().findCityPartnerWithKey(key, options);
		Map<String, List<CityPartner>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getTownServiceCenter().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<CityPartner> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<CityPartner> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setCityPartnerList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomer的cityServiceCenter的PotentialCustomerList
	public SmartList<PotentialCustomer> loadOurPotentialCustomerList(XingyouUserContext userContext, List<FranchisedOutletCityServiceCenter> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<PotentialCustomer> loadedObjs = userContext.getDAOGroup().getPotentialCustomerDAO().findPotentialCustomerWithKey(key, options);
		Map<String, List<PotentialCustomer>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCityServiceCenter().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<PotentialCustomer> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<PotentialCustomer> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setPotentialCustomerList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:CityEvent的cityServiceCenter的CityEventList
	public SmartList<CityEvent> loadOurCityEventList(XingyouUserContext userContext, List<FranchisedOutletCityServiceCenter> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityEvent.CITY_SERVICE_CENTER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<CityEvent> loadedObjs = userContext.getDAOGroup().getCityEventDAO().findCityEventWithKey(key, options);
		Map<String, List<CityEvent>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCityServiceCenter().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<CityEvent> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<CityEvent> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setCityEventList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList = ownerEntity.collectRefsWithType(FranchisedOutletCityServiceCenter.INTERNAL_TYPE);
		this.enhanceList(franchisedOutletCityServiceCenterList);
		
	}
	
	@Override
	public SmartList<FranchisedOutletCityServiceCenter> findFranchisedOutletCityServiceCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getFranchisedOutletCityServiceCenterMapper());

	}
	@Override
	public int countFranchisedOutletCityServiceCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countFranchisedOutletCityServiceCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<FranchisedOutletCityServiceCenter> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getFranchisedOutletCityServiceCenterMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateFranchisedOutletCityServiceCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateFranchisedOutletCityServiceCenter result = new CandidateFranchisedOutletCityServiceCenter();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}
	
	

}


