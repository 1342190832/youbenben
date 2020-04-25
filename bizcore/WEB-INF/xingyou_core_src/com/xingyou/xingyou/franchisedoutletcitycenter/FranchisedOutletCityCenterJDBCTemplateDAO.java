
package com.xingyou.xingyou.franchisedoutletcitycenter;

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


import com.xingyou.xingyou.citycenterdepartment.CityCenterDepartment;
import com.xingyou.xingyou.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenter;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.xingyou.xingyou.citycenteremployee.CityCenterEmployee;

import com.xingyou.xingyou.citycenteremployee.CityCenterEmployeeDAO;
import com.xingyou.xingyou.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenterDAO;
import com.xingyou.xingyou.citycenterdepartment.CityCenterDepartmentDAO;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class FranchisedOutletCityCenterJDBCTemplateDAO extends XingyouBaseDAOImpl implements FranchisedOutletCityCenterDAO{

	protected CityCenterDepartmentDAO cityCenterDepartmentDAO;
	public void setCityCenterDepartmentDAO(CityCenterDepartmentDAO cityCenterDepartmentDAO){
 	
 		if(cityCenterDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set cityCenterDepartmentDAO to null.");
 		}
	 	this.cityCenterDepartmentDAO = cityCenterDepartmentDAO;
 	}
 	public CityCenterDepartmentDAO getCityCenterDepartmentDAO(){
 		if(this.cityCenterDepartmentDAO == null){
 			throw new IllegalStateException("The cityCenterDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityCenterDepartmentDAO;
 	}	

	protected CityCenterEmployeeDAO cityCenterEmployeeDAO;
	public void setCityCenterEmployeeDAO(CityCenterEmployeeDAO cityCenterEmployeeDAO){
 	
 		if(cityCenterEmployeeDAO == null){
 			throw new IllegalStateException("Do not try to set cityCenterEmployeeDAO to null.");
 		}
	 	this.cityCenterEmployeeDAO = cityCenterEmployeeDAO;
 	}
 	public CityCenterEmployeeDAO getCityCenterEmployeeDAO(){
 		if(this.cityCenterEmployeeDAO == null){
 			throw new IllegalStateException("The cityCenterEmployeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityCenterEmployeeDAO;
 	}	

	protected FranchisedOutletCityServiceCenterDAO franchisedOutletCityServiceCenterDAO;
	public void setFranchisedOutletCityServiceCenterDAO(FranchisedOutletCityServiceCenterDAO franchisedOutletCityServiceCenterDAO){
 	
 		if(franchisedOutletCityServiceCenterDAO == null){
 			throw new IllegalStateException("Do not try to set franchisedOutletCityServiceCenterDAO to null.");
 		}
	 	this.franchisedOutletCityServiceCenterDAO = franchisedOutletCityServiceCenterDAO;
 	}
 	public FranchisedOutletCityServiceCenterDAO getFranchisedOutletCityServiceCenterDAO(){
 		if(this.franchisedOutletCityServiceCenterDAO == null){
 			throw new IllegalStateException("The franchisedOutletCityServiceCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.franchisedOutletCityServiceCenterDAO;
 	}	

	
	/*
	protected FranchisedOutletCityCenter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalFranchisedOutletCityCenter(accessKey, options);
	}
	*/
	
	public SmartList<FranchisedOutletCityCenter> loadAll() {
	    return this.loadAll(getFranchisedOutletCityCenterMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public FranchisedOutletCityCenter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalFranchisedOutletCityCenter(FranchisedOutletCityCenterTable.withId(id), options);
	}
	
	
	
	public FranchisedOutletCityCenter save(FranchisedOutletCityCenter franchisedOutletCityCenter,Map<String,Object> options){
		
		String methodName="save(FranchisedOutletCityCenter franchisedOutletCityCenter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(franchisedOutletCityCenter, methodName, "franchisedOutletCityCenter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalFranchisedOutletCityCenter(franchisedOutletCityCenter,options);
	}
	public FranchisedOutletCityCenter clone(String franchisedOutletCityCenterId, Map<String,Object> options) throws Exception{
	
		return clone(FranchisedOutletCityCenterTable.withId(franchisedOutletCityCenterId),options);
	}
	
	protected FranchisedOutletCityCenter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String franchisedOutletCityCenterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		FranchisedOutletCityCenter newFranchisedOutletCityCenter = loadInternalFranchisedOutletCityCenter(accessKey, options);
		newFranchisedOutletCityCenter.setVersion(0);
		
		
 		
 		if(isSaveFranchisedOutletCityCenterListEnabled(options)){
 			for(FranchisedOutletCityCenter item: newFranchisedOutletCityCenter.getFranchisedOutletCityCenterList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCityCenterDepartmentListEnabled(options)){
 			for(CityCenterDepartment item: newFranchisedOutletCityCenter.getCityCenterDepartmentList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCityCenterEmployeeListEnabled(options)){
 			for(CityCenterEmployee item: newFranchisedOutletCityCenter.getCityCenterEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveFranchisedOutletCityServiceCenterListEnabled(options)){
 			for(FranchisedOutletCityServiceCenter item: newFranchisedOutletCityCenter.getFranchisedOutletCityServiceCenterList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalFranchisedOutletCityCenter(newFranchisedOutletCityCenter,options);
		
		return newFranchisedOutletCityCenter;
	}
	
	
	
	

	protected void throwIfHasException(String franchisedOutletCityCenterId,int version,int count) throws Exception{
		if (count == 1) {
			throw new FranchisedOutletCityCenterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new FranchisedOutletCityCenterNotFoundException(
					"The " + this.getTableName() + "(" + franchisedOutletCityCenterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String franchisedOutletCityCenterId, int version) throws Exception{
	
		String methodName="delete(String franchisedOutletCityCenterId, int version)";
		assertMethodArgumentNotNull(franchisedOutletCityCenterId, methodName, "franchisedOutletCityCenterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{franchisedOutletCityCenterId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(franchisedOutletCityCenterId,version);
		}
		
	
	}
	
	
	
	
	

	public FranchisedOutletCityCenter disconnectFromAll(String franchisedOutletCityCenterId, int version) throws Exception{
	
		
		FranchisedOutletCityCenter franchisedOutletCityCenter = loadInternalFranchisedOutletCityCenter(FranchisedOutletCityCenterTable.withId(franchisedOutletCityCenterId), emptyOptions());
		franchisedOutletCityCenter.clearFromAll();
		this.saveFranchisedOutletCityCenter(franchisedOutletCityCenter);
		return franchisedOutletCityCenter;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return FranchisedOutletCityCenterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "franchised_outlet_city_center";
	}
	@Override
	protected String getBeanName() {
		
		return "franchisedOutletCityCenter";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return FranchisedOutletCityCenterTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractCityEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, FranchisedOutletCityCenterTokens.CITY);
 	}

 	protected boolean isSaveCityEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, FranchisedOutletCityCenterTokens.CITY);
 	}
 	

 	
 
		
	
	protected boolean isExtractFranchisedOutletCityCenterListEnabled(Map<String,Object> options){		
 		return checkOptions(options,FranchisedOutletCityCenterTokens.FRANCHISED_OUTLET_CITY_CENTER_LIST);
 	}
 	protected boolean isAnalyzeFranchisedOutletCityCenterListEnabled(Map<String,Object> options){		 		
 		return FranchisedOutletCityCenterTokens.of(options).analyzeFranchisedOutletCityCenterListEnabled();
 	}
	
	protected boolean isSaveFranchisedOutletCityCenterListEnabled(Map<String,Object> options){
		return checkOptions(options, FranchisedOutletCityCenterTokens.FRANCHISED_OUTLET_CITY_CENTER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractCityCenterDepartmentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,FranchisedOutletCityCenterTokens.CITY_CENTER_DEPARTMENT_LIST);
 	}
 	protected boolean isAnalyzeCityCenterDepartmentListEnabled(Map<String,Object> options){		 		
 		return FranchisedOutletCityCenterTokens.of(options).analyzeCityCenterDepartmentListEnabled();
 	}
	
	protected boolean isSaveCityCenterDepartmentListEnabled(Map<String,Object> options){
		return checkOptions(options, FranchisedOutletCityCenterTokens.CITY_CENTER_DEPARTMENT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractCityCenterEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,FranchisedOutletCityCenterTokens.CITY_CENTER_EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeCityCenterEmployeeListEnabled(Map<String,Object> options){		 		
 		return FranchisedOutletCityCenterTokens.of(options).analyzeCityCenterEmployeeListEnabled();
 	}
	
	protected boolean isSaveCityCenterEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, FranchisedOutletCityCenterTokens.CITY_CENTER_EMPLOYEE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractFranchisedOutletCityServiceCenterListEnabled(Map<String,Object> options){		
 		return checkOptions(options,FranchisedOutletCityCenterTokens.FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST);
 	}
 	protected boolean isAnalyzeFranchisedOutletCityServiceCenterListEnabled(Map<String,Object> options){		 		
 		return FranchisedOutletCityCenterTokens.of(options).analyzeFranchisedOutletCityServiceCenterListEnabled();
 	}
	
	protected boolean isSaveFranchisedOutletCityServiceCenterListEnabled(Map<String,Object> options){
		return checkOptions(options, FranchisedOutletCityCenterTokens.FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST);
		
 	}
 	
		

	

	protected FranchisedOutletCityCenterMapper getFranchisedOutletCityCenterMapper(){
		return new FranchisedOutletCityCenterMapper();
	}

	
	
	protected FranchisedOutletCityCenter extractFranchisedOutletCityCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			FranchisedOutletCityCenter franchisedOutletCityCenter = loadSingleObject(accessKey, getFranchisedOutletCityCenterMapper());
			return franchisedOutletCityCenter;
		}catch(EmptyResultDataAccessException e){
			throw new FranchisedOutletCityCenterNotFoundException("FranchisedOutletCityCenter("+accessKey+") is not found!");
		}

	}

	
	

	protected FranchisedOutletCityCenter loadInternalFranchisedOutletCityCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		FranchisedOutletCityCenter franchisedOutletCityCenter = extractFranchisedOutletCityCenter(accessKey, loadOptions);
 	
 		if(isExtractCityEnabled(loadOptions)){
	 		extractCity(franchisedOutletCityCenter, loadOptions);
 		}
 
		
		if(isExtractFranchisedOutletCityCenterListEnabled(loadOptions)){
	 		extractFranchisedOutletCityCenterList(franchisedOutletCityCenter, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeFranchisedOutletCityCenterListEnabled(loadOptions)){
	 		analyzeFranchisedOutletCityCenterList(franchisedOutletCityCenter, loadOptions);
 		}
 		
		
		if(isExtractCityCenterDepartmentListEnabled(loadOptions)){
	 		extractCityCenterDepartmentList(franchisedOutletCityCenter, loadOptions);
 		}	
 		
 		
		
		if(isExtractCityCenterEmployeeListEnabled(loadOptions)){
	 		extractCityCenterEmployeeList(franchisedOutletCityCenter, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeCityCenterEmployeeListEnabled(loadOptions)){
	 		analyzeCityCenterEmployeeList(franchisedOutletCityCenter, loadOptions);
 		}
 		
		
		if(isExtractFranchisedOutletCityServiceCenterListEnabled(loadOptions)){
	 		extractFranchisedOutletCityServiceCenterList(franchisedOutletCityCenter, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeFranchisedOutletCityServiceCenterListEnabled(loadOptions)){
	 		analyzeFranchisedOutletCityServiceCenterList(franchisedOutletCityCenter, loadOptions);
 		}
 		
		
		return franchisedOutletCityCenter;
		
	}

	 

 	protected FranchisedOutletCityCenter extractCity(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options) throws Exception{

		if(franchisedOutletCityCenter.getCity() == null){
			return franchisedOutletCityCenter;
		}
		String cityId = franchisedOutletCityCenter.getCity().getId();
		if( cityId == null){
			return franchisedOutletCityCenter;
		}
		FranchisedOutletCityCenter city = getFranchisedOutletCityCenterDAO().load(cityId,options);
		if(city != null){
			franchisedOutletCityCenter.setCity(city);
		}
		
 		
 		return franchisedOutletCityCenter;
 	}
 		
 
		
	protected void enhanceFranchisedOutletCityCenterList(SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected FranchisedOutletCityCenter extractFranchisedOutletCityCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityCenter == null){
			return null;
		}
		if(franchisedOutletCityCenter.getId() == null){
			return franchisedOutletCityCenter;
		}

		
		
		SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList = getFranchisedOutletCityCenterDAO().findFranchisedOutletCityCenterByCity(franchisedOutletCityCenter.getId(),options);
		if(franchisedOutletCityCenterList != null){
			enhanceFranchisedOutletCityCenterList(franchisedOutletCityCenterList,options);
			franchisedOutletCityCenter.setFranchisedOutletCityCenterList(franchisedOutletCityCenterList);
		}
		
		return franchisedOutletCityCenter;
	
	}	
	
	protected FranchisedOutletCityCenter analyzeFranchisedOutletCityCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityCenter == null){
			return null;
		}
		if(franchisedOutletCityCenter.getId() == null){
			return franchisedOutletCityCenter;
		}

		
		
		SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList = franchisedOutletCityCenter.getFranchisedOutletCityCenterList();
		if(franchisedOutletCityCenterList != null){
			getFranchisedOutletCityCenterDAO().analyzeFranchisedOutletCityCenterByCity(franchisedOutletCityCenterList, franchisedOutletCityCenter.getId(), options);
			
		}
		
		return franchisedOutletCityCenter;
	
	}	
	
		
	protected void enhanceCityCenterDepartmentList(SmartList<CityCenterDepartment> cityCenterDepartmentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected FranchisedOutletCityCenter extractCityCenterDepartmentList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityCenter == null){
			return null;
		}
		if(franchisedOutletCityCenter.getId() == null){
			return franchisedOutletCityCenter;
		}

		
		
		SmartList<CityCenterDepartment> cityCenterDepartmentList = getCityCenterDepartmentDAO().findCityCenterDepartmentByCityCenter(franchisedOutletCityCenter.getId(),options);
		if(cityCenterDepartmentList != null){
			enhanceCityCenterDepartmentList(cityCenterDepartmentList,options);
			franchisedOutletCityCenter.setCityCenterDepartmentList(cityCenterDepartmentList);
		}
		
		return franchisedOutletCityCenter;
	
	}	
	
	protected FranchisedOutletCityCenter analyzeCityCenterDepartmentList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityCenter == null){
			return null;
		}
		if(franchisedOutletCityCenter.getId() == null){
			return franchisedOutletCityCenter;
		}

		
		
		SmartList<CityCenterDepartment> cityCenterDepartmentList = franchisedOutletCityCenter.getCityCenterDepartmentList();
		if(cityCenterDepartmentList != null){
			getCityCenterDepartmentDAO().analyzeCityCenterDepartmentByCityCenter(cityCenterDepartmentList, franchisedOutletCityCenter.getId(), options);
			
		}
		
		return franchisedOutletCityCenter;
	
	}	
	
		
	protected void enhanceCityCenterEmployeeList(SmartList<CityCenterEmployee> cityCenterEmployeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected FranchisedOutletCityCenter extractCityCenterEmployeeList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityCenter == null){
			return null;
		}
		if(franchisedOutletCityCenter.getId() == null){
			return franchisedOutletCityCenter;
		}

		
		
		SmartList<CityCenterEmployee> cityCenterEmployeeList = getCityCenterEmployeeDAO().findCityCenterEmployeeByCityCenter(franchisedOutletCityCenter.getId(),options);
		if(cityCenterEmployeeList != null){
			enhanceCityCenterEmployeeList(cityCenterEmployeeList,options);
			franchisedOutletCityCenter.setCityCenterEmployeeList(cityCenterEmployeeList);
		}
		
		return franchisedOutletCityCenter;
	
	}	
	
	protected FranchisedOutletCityCenter analyzeCityCenterEmployeeList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityCenter == null){
			return null;
		}
		if(franchisedOutletCityCenter.getId() == null){
			return franchisedOutletCityCenter;
		}

		
		
		SmartList<CityCenterEmployee> cityCenterEmployeeList = franchisedOutletCityCenter.getCityCenterEmployeeList();
		if(cityCenterEmployeeList != null){
			getCityCenterEmployeeDAO().analyzeCityCenterEmployeeByCityCenter(cityCenterEmployeeList, franchisedOutletCityCenter.getId(), options);
			
		}
		
		return franchisedOutletCityCenter;
	
	}	
	
		
	protected void enhanceFranchisedOutletCityServiceCenterList(SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected FranchisedOutletCityCenter extractFranchisedOutletCityServiceCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityCenter == null){
			return null;
		}
		if(franchisedOutletCityCenter.getId() == null){
			return franchisedOutletCityCenter;
		}

		
		
		SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList = getFranchisedOutletCityServiceCenterDAO().findFranchisedOutletCityServiceCenterByBelongsTo(franchisedOutletCityCenter.getId(),options);
		if(franchisedOutletCityServiceCenterList != null){
			enhanceFranchisedOutletCityServiceCenterList(franchisedOutletCityServiceCenterList,options);
			franchisedOutletCityCenter.setFranchisedOutletCityServiceCenterList(franchisedOutletCityServiceCenterList);
		}
		
		return franchisedOutletCityCenter;
	
	}	
	
	protected FranchisedOutletCityCenter analyzeFranchisedOutletCityServiceCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		if(franchisedOutletCityCenter == null){
			return null;
		}
		if(franchisedOutletCityCenter.getId() == null){
			return franchisedOutletCityCenter;
		}

		
		
		SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList = franchisedOutletCityCenter.getFranchisedOutletCityServiceCenterList();
		if(franchisedOutletCityServiceCenterList != null){
			getFranchisedOutletCityServiceCenterDAO().analyzeFranchisedOutletCityServiceCenterByBelongsTo(franchisedOutletCityServiceCenterList, franchisedOutletCityCenter.getId(), options);
			
		}
		
		return franchisedOutletCityCenter;
	
	}	
	
		
		
  	
 	public SmartList<FranchisedOutletCityCenter> findFranchisedOutletCityCenterByCity(String franchisedOutletCityCenterId,Map<String,Object> options){
 	
  		SmartList<FranchisedOutletCityCenter> resultList = queryWith(FranchisedOutletCityCenterTable.COLUMN_CITY, franchisedOutletCityCenterId, options, getFranchisedOutletCityCenterMapper());
		// analyzeFranchisedOutletCityCenterByCity(resultList, franchisedOutletCityCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<FranchisedOutletCityCenter> findFranchisedOutletCityCenterByCity(String franchisedOutletCityCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<FranchisedOutletCityCenter> resultList =  queryWithRange(FranchisedOutletCityCenterTable.COLUMN_CITY, franchisedOutletCityCenterId, options, getFranchisedOutletCityCenterMapper(), start, count);
 		//analyzeFranchisedOutletCityCenterByCity(resultList, franchisedOutletCityCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeFranchisedOutletCityCenterByCity(SmartList<FranchisedOutletCityCenter> resultList, String franchisedOutletCityCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(FranchisedOutletCityCenter.CITY_PROPERTY, franchisedOutletCityCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//FranchisedOutletCityCenter.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("城市中心专卖店");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(FranchisedOutletCityCenter.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(FranchisedOutletCityCenter.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countFranchisedOutletCityCenterByCity(String franchisedOutletCityCenterId,Map<String,Object> options){

 		return countWith(FranchisedOutletCityCenterTable.COLUMN_CITY, franchisedOutletCityCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countFranchisedOutletCityCenterByCityIds(String[] ids, Map<String, Object> options) {
		return countWithIds(FranchisedOutletCityCenterTable.COLUMN_CITY, ids, options);
	}
 	
 	
		
		
		

	

	protected FranchisedOutletCityCenter saveFranchisedOutletCityCenter(FranchisedOutletCityCenter  franchisedOutletCityCenter){
		
		if(!franchisedOutletCityCenter.isChanged()){
			return franchisedOutletCityCenter;
		}
		
		
		String SQL=this.getSaveFranchisedOutletCityCenterSQL(franchisedOutletCityCenter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveFranchisedOutletCityCenterParameters(franchisedOutletCityCenter);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		franchisedOutletCityCenter.incVersion();
		return franchisedOutletCityCenter;
	
	}
	public SmartList<FranchisedOutletCityCenter> saveFranchisedOutletCityCenterList(SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitFranchisedOutletCityCenterList(franchisedOutletCityCenterList);
		
		batchFranchisedOutletCityCenterCreate((List<FranchisedOutletCityCenter>)lists[CREATE_LIST_INDEX]);
		
		batchFranchisedOutletCityCenterUpdate((List<FranchisedOutletCityCenter>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(FranchisedOutletCityCenter franchisedOutletCityCenter:franchisedOutletCityCenterList){
			if(franchisedOutletCityCenter.isChanged()){
				franchisedOutletCityCenter.incVersion();
			}
			
		
		}
		
		
		return franchisedOutletCityCenterList;
	}

	public SmartList<FranchisedOutletCityCenter> removeFranchisedOutletCityCenterList(SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList,Map<String,Object> options){
		
		
		super.removeList(franchisedOutletCityCenterList, options);
		
		return franchisedOutletCityCenterList;
		
		
	}
	
	protected List<Object[]> prepareFranchisedOutletCityCenterBatchCreateArgs(List<FranchisedOutletCityCenter> franchisedOutletCityCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FranchisedOutletCityCenter franchisedOutletCityCenter:franchisedOutletCityCenterList ){
			Object [] parameters = prepareFranchisedOutletCityCenterCreateParameters(franchisedOutletCityCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareFranchisedOutletCityCenterBatchUpdateArgs(List<FranchisedOutletCityCenter> franchisedOutletCityCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FranchisedOutletCityCenter franchisedOutletCityCenter:franchisedOutletCityCenterList ){
			if(!franchisedOutletCityCenter.isChanged()){
				continue;
			}
			Object [] parameters = prepareFranchisedOutletCityCenterUpdateParameters(franchisedOutletCityCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchFranchisedOutletCityCenterCreate(List<FranchisedOutletCityCenter> franchisedOutletCityCenterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareFranchisedOutletCityCenterBatchCreateArgs(franchisedOutletCityCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchFranchisedOutletCityCenterUpdate(List<FranchisedOutletCityCenter> franchisedOutletCityCenterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareFranchisedOutletCityCenterBatchUpdateArgs(franchisedOutletCityCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitFranchisedOutletCityCenterList(List<FranchisedOutletCityCenter> franchisedOutletCityCenterList){
		
		List<FranchisedOutletCityCenter> franchisedOutletCityCenterCreateList=new ArrayList<FranchisedOutletCityCenter>();
		List<FranchisedOutletCityCenter> franchisedOutletCityCenterUpdateList=new ArrayList<FranchisedOutletCityCenter>();
		
		for(FranchisedOutletCityCenter franchisedOutletCityCenter: franchisedOutletCityCenterList){
			if(isUpdateRequest(franchisedOutletCityCenter)){
				franchisedOutletCityCenterUpdateList.add( franchisedOutletCityCenter);
				continue;
			}
			franchisedOutletCityCenterCreateList.add(franchisedOutletCityCenter);
		}
		
		return new Object[]{franchisedOutletCityCenterCreateList,franchisedOutletCityCenterUpdateList};
	}
	
	protected boolean isUpdateRequest(FranchisedOutletCityCenter franchisedOutletCityCenter){
 		return franchisedOutletCityCenter.getVersion() > 0;
 	}
 	protected String getSaveFranchisedOutletCityCenterSQL(FranchisedOutletCityCenter franchisedOutletCityCenter){
 		if(isUpdateRequest(franchisedOutletCityCenter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveFranchisedOutletCityCenterParameters(FranchisedOutletCityCenter franchisedOutletCityCenter){
 		if(isUpdateRequest(franchisedOutletCityCenter) ){
 			return prepareFranchisedOutletCityCenterUpdateParameters(franchisedOutletCityCenter);
 		}
 		return prepareFranchisedOutletCityCenterCreateParameters(franchisedOutletCityCenter);
 	}
 	protected Object[] prepareFranchisedOutletCityCenterUpdateParameters(FranchisedOutletCityCenter franchisedOutletCityCenter){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = franchisedOutletCityCenter.getName();
 		
 		
 		parameters[1] = franchisedOutletCityCenter.getFounded();
 		 	
 		if(franchisedOutletCityCenter.getCity() != null){
 			parameters[2] = franchisedOutletCityCenter.getCity().getId();
 		}
 
 		
 		parameters[3] = franchisedOutletCityCenter.getLastUpdateTime();
 				
 		parameters[4] = franchisedOutletCityCenter.nextVersion();
 		parameters[5] = franchisedOutletCityCenter.getId();
 		parameters[6] = franchisedOutletCityCenter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareFranchisedOutletCityCenterCreateParameters(FranchisedOutletCityCenter franchisedOutletCityCenter){
		Object[] parameters = new Object[5];
		String newFranchisedOutletCityCenterId=getNextId();
		franchisedOutletCityCenter.setId(newFranchisedOutletCityCenterId);
		parameters[0] =  franchisedOutletCityCenter.getId();
 
 		
 		parameters[1] = franchisedOutletCityCenter.getName();
 		
 		
 		parameters[2] = franchisedOutletCityCenter.getFounded();
 		 	
 		if(franchisedOutletCityCenter.getCity() != null){
 			parameters[3] = franchisedOutletCityCenter.getCity().getId();
 		
 		}
 		
 		
 		parameters[4] = franchisedOutletCityCenter.getLastUpdateTime();
 				
 				
 		return parameters;
 	}
 	
	protected FranchisedOutletCityCenter saveInternalFranchisedOutletCityCenter(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		saveFranchisedOutletCityCenter(franchisedOutletCityCenter);
 	
 		if(isSaveCityEnabled(options)){
	 		saveCity(franchisedOutletCityCenter, options);
 		}
 
		
		if(isSaveFranchisedOutletCityCenterListEnabled(options)){
	 		saveFranchisedOutletCityCenterList(franchisedOutletCityCenter, options);
	 		//removeFranchisedOutletCityCenterList(franchisedOutletCityCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveCityCenterDepartmentListEnabled(options)){
	 		saveCityCenterDepartmentList(franchisedOutletCityCenter, options);
	 		//removeCityCenterDepartmentList(franchisedOutletCityCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveCityCenterEmployeeListEnabled(options)){
	 		saveCityCenterEmployeeList(franchisedOutletCityCenter, options);
	 		//removeCityCenterEmployeeList(franchisedOutletCityCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveFranchisedOutletCityServiceCenterListEnabled(options)){
	 		saveFranchisedOutletCityServiceCenterList(franchisedOutletCityCenter, options);
	 		//removeFranchisedOutletCityServiceCenterList(franchisedOutletCityCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		return franchisedOutletCityCenter;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected FranchisedOutletCityCenter saveCity(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(franchisedOutletCityCenter.getCity() == null){
 			return franchisedOutletCityCenter;//do nothing when it is null
 		}
 		
 		getFranchisedOutletCityCenterDAO().save(franchisedOutletCityCenter.getCity(),options);
 		return franchisedOutletCityCenter;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public FranchisedOutletCityCenter planToRemoveFranchisedOutletCityCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, String franchisedOutletCityCenterIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FranchisedOutletCityCenter.CITY_PROPERTY, franchisedOutletCityCenter.getId());
		key.put(FranchisedOutletCityCenter.ID_PROPERTY, franchisedOutletCityCenterIds);
		
		SmartList<FranchisedOutletCityCenter> externalFranchisedOutletCityCenterList = getFranchisedOutletCityCenterDAO().
				findFranchisedOutletCityCenterWithKey(key, options);
		if(externalFranchisedOutletCityCenterList == null){
			return franchisedOutletCityCenter;
		}
		if(externalFranchisedOutletCityCenterList.isEmpty()){
			return franchisedOutletCityCenter;
		}
		
		for(FranchisedOutletCityCenter franchisedOutletCityCenterItem: externalFranchisedOutletCityCenterList){

			franchisedOutletCityCenterItem.clearFromAll();
		}
		
		
		SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList = franchisedOutletCityCenter.getFranchisedOutletCityCenterList();		
		franchisedOutletCityCenterList.addAllToRemoveList(externalFranchisedOutletCityCenterList);
		return franchisedOutletCityCenter;	
	
	}


	public FranchisedOutletCityCenter planToRemoveCityCenterDepartmentList(FranchisedOutletCityCenter franchisedOutletCityCenter, String cityCenterDepartmentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityCenterDepartment.CITY_CENTER_PROPERTY, franchisedOutletCityCenter.getId());
		key.put(CityCenterDepartment.ID_PROPERTY, cityCenterDepartmentIds);
		
		SmartList<CityCenterDepartment> externalCityCenterDepartmentList = getCityCenterDepartmentDAO().
				findCityCenterDepartmentWithKey(key, options);
		if(externalCityCenterDepartmentList == null){
			return franchisedOutletCityCenter;
		}
		if(externalCityCenterDepartmentList.isEmpty()){
			return franchisedOutletCityCenter;
		}
		
		for(CityCenterDepartment cityCenterDepartmentItem: externalCityCenterDepartmentList){

			cityCenterDepartmentItem.clearFromAll();
		}
		
		
		SmartList<CityCenterDepartment> cityCenterDepartmentList = franchisedOutletCityCenter.getCityCenterDepartmentList();		
		cityCenterDepartmentList.addAllToRemoveList(externalCityCenterDepartmentList);
		return franchisedOutletCityCenter;	
	
	}


	public FranchisedOutletCityCenter planToRemoveCityCenterEmployeeList(FranchisedOutletCityCenter franchisedOutletCityCenter, String cityCenterEmployeeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityCenterEmployee.CITY_CENTER_PROPERTY, franchisedOutletCityCenter.getId());
		key.put(CityCenterEmployee.ID_PROPERTY, cityCenterEmployeeIds);
		
		SmartList<CityCenterEmployee> externalCityCenterEmployeeList = getCityCenterEmployeeDAO().
				findCityCenterEmployeeWithKey(key, options);
		if(externalCityCenterEmployeeList == null){
			return franchisedOutletCityCenter;
		}
		if(externalCityCenterEmployeeList.isEmpty()){
			return franchisedOutletCityCenter;
		}
		
		for(CityCenterEmployee cityCenterEmployeeItem: externalCityCenterEmployeeList){

			cityCenterEmployeeItem.clearFromAll();
		}
		
		
		SmartList<CityCenterEmployee> cityCenterEmployeeList = franchisedOutletCityCenter.getCityCenterEmployeeList();		
		cityCenterEmployeeList.addAllToRemoveList(externalCityCenterEmployeeList);
		return franchisedOutletCityCenter;	
	
	}


	//disconnect FranchisedOutletCityCenter with department in CityCenterEmployee
	public FranchisedOutletCityCenter planToRemoveCityCenterEmployeeListWithDepartment(FranchisedOutletCityCenter franchisedOutletCityCenter, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityCenterEmployee.CITY_CENTER_PROPERTY, franchisedOutletCityCenter.getId());
		key.put(CityCenterEmployee.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<CityCenterEmployee> externalCityCenterEmployeeList = getCityCenterEmployeeDAO().
				findCityCenterEmployeeWithKey(key, options);
		if(externalCityCenterEmployeeList == null){
			return franchisedOutletCityCenter;
		}
		if(externalCityCenterEmployeeList.isEmpty()){
			return franchisedOutletCityCenter;
		}
		
		for(CityCenterEmployee cityCenterEmployeeItem: externalCityCenterEmployeeList){
			cityCenterEmployeeItem.clearDepartment();
			cityCenterEmployeeItem.clearCityCenter();
			
		}
		
		
		SmartList<CityCenterEmployee> cityCenterEmployeeList = franchisedOutletCityCenter.getCityCenterEmployeeList();		
		cityCenterEmployeeList.addAllToRemoveList(externalCityCenterEmployeeList);
		return franchisedOutletCityCenter;
	}
	
	public int countCityCenterEmployeeListWithDepartment(String franchisedOutletCityCenterId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityCenterEmployee.CITY_CENTER_PROPERTY, franchisedOutletCityCenterId);
		key.put(CityCenterEmployee.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getCityCenterEmployeeDAO().countCityCenterEmployeeWithKey(key, options);
		return count;
	}
	
	public FranchisedOutletCityCenter planToRemoveFranchisedOutletCityServiceCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, String franchisedOutletCityServiceCenterIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FranchisedOutletCityServiceCenter.BELONGS_TO_PROPERTY, franchisedOutletCityCenter.getId());
		key.put(FranchisedOutletCityServiceCenter.ID_PROPERTY, franchisedOutletCityServiceCenterIds);
		
		SmartList<FranchisedOutletCityServiceCenter> externalFranchisedOutletCityServiceCenterList = getFranchisedOutletCityServiceCenterDAO().
				findFranchisedOutletCityServiceCenterWithKey(key, options);
		if(externalFranchisedOutletCityServiceCenterList == null){
			return franchisedOutletCityCenter;
		}
		if(externalFranchisedOutletCityServiceCenterList.isEmpty()){
			return franchisedOutletCityCenter;
		}
		
		for(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenterItem: externalFranchisedOutletCityServiceCenterList){

			franchisedOutletCityServiceCenterItem.clearFromAll();
		}
		
		
		SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList = franchisedOutletCityCenter.getFranchisedOutletCityServiceCenterList();		
		franchisedOutletCityServiceCenterList.addAllToRemoveList(externalFranchisedOutletCityServiceCenterList);
		return franchisedOutletCityCenter;	
	
	}



		
	protected FranchisedOutletCityCenter saveFranchisedOutletCityCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		
		
		SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList = franchisedOutletCityCenter.getFranchisedOutletCityCenterList();
		if(franchisedOutletCityCenterList == null){
			//null list means nothing
			return franchisedOutletCityCenter;
		}
		SmartList<FranchisedOutletCityCenter> mergedUpdateFranchisedOutletCityCenterList = new SmartList<FranchisedOutletCityCenter>();
		
		
		mergedUpdateFranchisedOutletCityCenterList.addAll(franchisedOutletCityCenterList); 
		if(franchisedOutletCityCenterList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateFranchisedOutletCityCenterList.addAll(franchisedOutletCityCenterList.getToRemoveList());
			franchisedOutletCityCenterList.removeAll(franchisedOutletCityCenterList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getFranchisedOutletCityCenterDAO().saveFranchisedOutletCityCenterList(mergedUpdateFranchisedOutletCityCenterList,options);
		
		if(franchisedOutletCityCenterList.getToRemoveList() != null){
			franchisedOutletCityCenterList.removeAll(franchisedOutletCityCenterList.getToRemoveList());
		}
		
		
		return franchisedOutletCityCenter;
	
	}
	
	protected FranchisedOutletCityCenter removeFranchisedOutletCityCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
	
	
		SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList = franchisedOutletCityCenter.getFranchisedOutletCityCenterList();
		if(franchisedOutletCityCenterList == null){
			return franchisedOutletCityCenter;
		}	
	
		SmartList<FranchisedOutletCityCenter> toRemoveFranchisedOutletCityCenterList = franchisedOutletCityCenterList.getToRemoveList();
		
		if(toRemoveFranchisedOutletCityCenterList == null){
			return franchisedOutletCityCenter;
		}
		if(toRemoveFranchisedOutletCityCenterList.isEmpty()){
			return franchisedOutletCityCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getFranchisedOutletCityCenterDAO().removeFranchisedOutletCityCenterList(toRemoveFranchisedOutletCityCenterList,options);
		
		return franchisedOutletCityCenter;
	
	}
	
	

 	
 	
	
	
	
		
	protected FranchisedOutletCityCenter saveCityCenterDepartmentList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		
		
		SmartList<CityCenterDepartment> cityCenterDepartmentList = franchisedOutletCityCenter.getCityCenterDepartmentList();
		if(cityCenterDepartmentList == null){
			//null list means nothing
			return franchisedOutletCityCenter;
		}
		SmartList<CityCenterDepartment> mergedUpdateCityCenterDepartmentList = new SmartList<CityCenterDepartment>();
		
		
		mergedUpdateCityCenterDepartmentList.addAll(cityCenterDepartmentList); 
		if(cityCenterDepartmentList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCityCenterDepartmentList.addAll(cityCenterDepartmentList.getToRemoveList());
			cityCenterDepartmentList.removeAll(cityCenterDepartmentList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCityCenterDepartmentDAO().saveCityCenterDepartmentList(mergedUpdateCityCenterDepartmentList,options);
		
		if(cityCenterDepartmentList.getToRemoveList() != null){
			cityCenterDepartmentList.removeAll(cityCenterDepartmentList.getToRemoveList());
		}
		
		
		return franchisedOutletCityCenter;
	
	}
	
	protected FranchisedOutletCityCenter removeCityCenterDepartmentList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
	
	
		SmartList<CityCenterDepartment> cityCenterDepartmentList = franchisedOutletCityCenter.getCityCenterDepartmentList();
		if(cityCenterDepartmentList == null){
			return franchisedOutletCityCenter;
		}	
	
		SmartList<CityCenterDepartment> toRemoveCityCenterDepartmentList = cityCenterDepartmentList.getToRemoveList();
		
		if(toRemoveCityCenterDepartmentList == null){
			return franchisedOutletCityCenter;
		}
		if(toRemoveCityCenterDepartmentList.isEmpty()){
			return franchisedOutletCityCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCityCenterDepartmentDAO().removeCityCenterDepartmentList(toRemoveCityCenterDepartmentList,options);
		
		return franchisedOutletCityCenter;
	
	}
	
	

 	
 	
	
	
	
		
	protected FranchisedOutletCityCenter saveCityCenterEmployeeList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		
		
		SmartList<CityCenterEmployee> cityCenterEmployeeList = franchisedOutletCityCenter.getCityCenterEmployeeList();
		if(cityCenterEmployeeList == null){
			//null list means nothing
			return franchisedOutletCityCenter;
		}
		SmartList<CityCenterEmployee> mergedUpdateCityCenterEmployeeList = new SmartList<CityCenterEmployee>();
		
		
		mergedUpdateCityCenterEmployeeList.addAll(cityCenterEmployeeList); 
		if(cityCenterEmployeeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCityCenterEmployeeList.addAll(cityCenterEmployeeList.getToRemoveList());
			cityCenterEmployeeList.removeAll(cityCenterEmployeeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCityCenterEmployeeDAO().saveCityCenterEmployeeList(mergedUpdateCityCenterEmployeeList,options);
		
		if(cityCenterEmployeeList.getToRemoveList() != null){
			cityCenterEmployeeList.removeAll(cityCenterEmployeeList.getToRemoveList());
		}
		
		
		return franchisedOutletCityCenter;
	
	}
	
	protected FranchisedOutletCityCenter removeCityCenterEmployeeList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
	
	
		SmartList<CityCenterEmployee> cityCenterEmployeeList = franchisedOutletCityCenter.getCityCenterEmployeeList();
		if(cityCenterEmployeeList == null){
			return franchisedOutletCityCenter;
		}	
	
		SmartList<CityCenterEmployee> toRemoveCityCenterEmployeeList = cityCenterEmployeeList.getToRemoveList();
		
		if(toRemoveCityCenterEmployeeList == null){
			return franchisedOutletCityCenter;
		}
		if(toRemoveCityCenterEmployeeList.isEmpty()){
			return franchisedOutletCityCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCityCenterEmployeeDAO().removeCityCenterEmployeeList(toRemoveCityCenterEmployeeList,options);
		
		return franchisedOutletCityCenter;
	
	}
	
	

 	
 	
	
	
	
		
	protected FranchisedOutletCityCenter saveFranchisedOutletCityServiceCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
		
		
		
		
		SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList = franchisedOutletCityCenter.getFranchisedOutletCityServiceCenterList();
		if(franchisedOutletCityServiceCenterList == null){
			//null list means nothing
			return franchisedOutletCityCenter;
		}
		SmartList<FranchisedOutletCityServiceCenter> mergedUpdateFranchisedOutletCityServiceCenterList = new SmartList<FranchisedOutletCityServiceCenter>();
		
		
		mergedUpdateFranchisedOutletCityServiceCenterList.addAll(franchisedOutletCityServiceCenterList); 
		if(franchisedOutletCityServiceCenterList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateFranchisedOutletCityServiceCenterList.addAll(franchisedOutletCityServiceCenterList.getToRemoveList());
			franchisedOutletCityServiceCenterList.removeAll(franchisedOutletCityServiceCenterList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getFranchisedOutletCityServiceCenterDAO().saveFranchisedOutletCityServiceCenterList(mergedUpdateFranchisedOutletCityServiceCenterList,options);
		
		if(franchisedOutletCityServiceCenterList.getToRemoveList() != null){
			franchisedOutletCityServiceCenterList.removeAll(franchisedOutletCityServiceCenterList.getToRemoveList());
		}
		
		
		return franchisedOutletCityCenter;
	
	}
	
	protected FranchisedOutletCityCenter removeFranchisedOutletCityServiceCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, Map<String,Object> options){
	
	
		SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList = franchisedOutletCityCenter.getFranchisedOutletCityServiceCenterList();
		if(franchisedOutletCityServiceCenterList == null){
			return franchisedOutletCityCenter;
		}	
	
		SmartList<FranchisedOutletCityServiceCenter> toRemoveFranchisedOutletCityServiceCenterList = franchisedOutletCityServiceCenterList.getToRemoveList();
		
		if(toRemoveFranchisedOutletCityServiceCenterList == null){
			return franchisedOutletCityCenter;
		}
		if(toRemoveFranchisedOutletCityServiceCenterList.isEmpty()){
			return franchisedOutletCityCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getFranchisedOutletCityServiceCenterDAO().removeFranchisedOutletCityServiceCenterList(toRemoveFranchisedOutletCityServiceCenterList,options);
		
		return franchisedOutletCityCenter;
	
	}
	
	

 	
 	
	
	
	
		

	public FranchisedOutletCityCenter present(FranchisedOutletCityCenter franchisedOutletCityCenter,Map<String, Object> options){
	
		presentFranchisedOutletCityCenterList(franchisedOutletCityCenter,options);
		presentCityCenterDepartmentList(franchisedOutletCityCenter,options);
		presentCityCenterEmployeeList(franchisedOutletCityCenter,options);
		presentFranchisedOutletCityServiceCenterList(franchisedOutletCityCenter,options);

		return franchisedOutletCityCenter;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected FranchisedOutletCityCenter presentFranchisedOutletCityCenterList(
			FranchisedOutletCityCenter franchisedOutletCityCenter,
			Map<String, Object> options) {

		SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList = franchisedOutletCityCenter.getFranchisedOutletCityCenterList();		
				SmartList<FranchisedOutletCityCenter> newList= presentSubList(franchisedOutletCityCenter.getId(),
				franchisedOutletCityCenterList,
				options,
				getFranchisedOutletCityCenterDAO()::countFranchisedOutletCityCenterByCity,
				getFranchisedOutletCityCenterDAO()::findFranchisedOutletCityCenterByCity
				);

		
		franchisedOutletCityCenter.setFranchisedOutletCityCenterList(newList);
		

		return franchisedOutletCityCenter;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected FranchisedOutletCityCenter presentCityCenterDepartmentList(
			FranchisedOutletCityCenter franchisedOutletCityCenter,
			Map<String, Object> options) {

		SmartList<CityCenterDepartment> cityCenterDepartmentList = franchisedOutletCityCenter.getCityCenterDepartmentList();		
				SmartList<CityCenterDepartment> newList= presentSubList(franchisedOutletCityCenter.getId(),
				cityCenterDepartmentList,
				options,
				getCityCenterDepartmentDAO()::countCityCenterDepartmentByCityCenter,
				getCityCenterDepartmentDAO()::findCityCenterDepartmentByCityCenter
				);

		
		franchisedOutletCityCenter.setCityCenterDepartmentList(newList);
		

		return franchisedOutletCityCenter;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected FranchisedOutletCityCenter presentCityCenterEmployeeList(
			FranchisedOutletCityCenter franchisedOutletCityCenter,
			Map<String, Object> options) {

		SmartList<CityCenterEmployee> cityCenterEmployeeList = franchisedOutletCityCenter.getCityCenterEmployeeList();		
				SmartList<CityCenterEmployee> newList= presentSubList(franchisedOutletCityCenter.getId(),
				cityCenterEmployeeList,
				options,
				getCityCenterEmployeeDAO()::countCityCenterEmployeeByCityCenter,
				getCityCenterEmployeeDAO()::findCityCenterEmployeeByCityCenter
				);

		
		franchisedOutletCityCenter.setCityCenterEmployeeList(newList);
		

		return franchisedOutletCityCenter;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected FranchisedOutletCityCenter presentFranchisedOutletCityServiceCenterList(
			FranchisedOutletCityCenter franchisedOutletCityCenter,
			Map<String, Object> options) {

		SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList = franchisedOutletCityCenter.getFranchisedOutletCityServiceCenterList();		
				SmartList<FranchisedOutletCityServiceCenter> newList= presentSubList(franchisedOutletCityCenter.getId(),
				franchisedOutletCityServiceCenterList,
				options,
				getFranchisedOutletCityServiceCenterDAO()::countFranchisedOutletCityServiceCenterByBelongsTo,
				getFranchisedOutletCityServiceCenterDAO()::findFranchisedOutletCityServiceCenterByBelongsTo
				);

		
		franchisedOutletCityCenter.setFranchisedOutletCityServiceCenterList(newList);
		

		return franchisedOutletCityCenter;
	}			
		

	
    public SmartList<FranchisedOutletCityCenter> requestCandidateFranchisedOutletCityCenterForFranchisedOutletCityCenter(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(FranchisedOutletCityCenterTable.COLUMN_NAME, FranchisedOutletCityCenterTable.COLUMN_CITY, filterKey, pageNo, pageSize, getFranchisedOutletCityCenterMapper());
    }
		
    public SmartList<FranchisedOutletCityCenter> requestCandidateFranchisedOutletCityCenterForCityCenterDepartment(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(FranchisedOutletCityCenterTable.COLUMN_NAME, FranchisedOutletCityCenterTable.COLUMN_CITY, filterKey, pageNo, pageSize, getFranchisedOutletCityCenterMapper());
    }
		
    public SmartList<FranchisedOutletCityCenter> requestCandidateFranchisedOutletCityCenterForCityCenterEmployee(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(FranchisedOutletCityCenterTable.COLUMN_NAME, FranchisedOutletCityCenterTable.COLUMN_CITY, filterKey, pageNo, pageSize, getFranchisedOutletCityCenterMapper());
    }
		
    public SmartList<FranchisedOutletCityCenter> requestCandidateFranchisedOutletCityCenterForFranchisedOutletCityServiceCenter(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(FranchisedOutletCityCenterTable.COLUMN_NAME, FranchisedOutletCityCenterTable.COLUMN_CITY, filterKey, pageNo, pageSize, getFranchisedOutletCityCenterMapper());
    }
		

	protected String getTableName(){
		return FranchisedOutletCityCenterTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<FranchisedOutletCityCenter> franchisedOutletCityCenterList) {		
		this.enhanceListInternal(franchisedOutletCityCenterList, this.getFranchisedOutletCityCenterMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:FranchisedOutletCityCenter的city的FranchisedOutletCityCenterList
	public SmartList<FranchisedOutletCityCenter> loadOurFranchisedOutletCityCenterList(XingyouUserContext userContext, List<FranchisedOutletCityCenter> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FranchisedOutletCityCenter.CITY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<FranchisedOutletCityCenter> loadedObjs = userContext.getDAOGroup().getFranchisedOutletCityCenterDAO().findFranchisedOutletCityCenterWithKey(key, options);
		Map<String, List<FranchisedOutletCityCenter>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCity().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<FranchisedOutletCityCenter> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<FranchisedOutletCityCenter> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setFranchisedOutletCityCenterList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:CityCenterDepartment的cityCenter的CityCenterDepartmentList
	public SmartList<CityCenterDepartment> loadOurCityCenterDepartmentList(XingyouUserContext userContext, List<FranchisedOutletCityCenter> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityCenterDepartment.CITY_CENTER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<CityCenterDepartment> loadedObjs = userContext.getDAOGroup().getCityCenterDepartmentDAO().findCityCenterDepartmentWithKey(key, options);
		Map<String, List<CityCenterDepartment>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCityCenter().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<CityCenterDepartment> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<CityCenterDepartment> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setCityCenterDepartmentList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:CityCenterEmployee的cityCenter的CityCenterEmployeeList
	public SmartList<CityCenterEmployee> loadOurCityCenterEmployeeList(XingyouUserContext userContext, List<FranchisedOutletCityCenter> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityCenterEmployee.CITY_CENTER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<CityCenterEmployee> loadedObjs = userContext.getDAOGroup().getCityCenterEmployeeDAO().findCityCenterEmployeeWithKey(key, options);
		Map<String, List<CityCenterEmployee>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCityCenter().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<CityCenterEmployee> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<CityCenterEmployee> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setCityCenterEmployeeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:FranchisedOutletCityServiceCenter的belongsTo的FranchisedOutletCityServiceCenterList
	public SmartList<FranchisedOutletCityServiceCenter> loadOurFranchisedOutletCityServiceCenterList(XingyouUserContext userContext, List<FranchisedOutletCityCenter> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FranchisedOutletCityServiceCenter.BELONGS_TO_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<FranchisedOutletCityServiceCenter> loadedObjs = userContext.getDAOGroup().getFranchisedOutletCityServiceCenterDAO().findFranchisedOutletCityServiceCenterWithKey(key, options);
		Map<String, List<FranchisedOutletCityServiceCenter>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBelongsTo().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<FranchisedOutletCityServiceCenter> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<FranchisedOutletCityServiceCenter> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setFranchisedOutletCityServiceCenterList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<FranchisedOutletCityCenter> franchisedOutletCityCenterList = ownerEntity.collectRefsWithType(FranchisedOutletCityCenter.INTERNAL_TYPE);
		this.enhanceList(franchisedOutletCityCenterList);
		
	}
	
	@Override
	public SmartList<FranchisedOutletCityCenter> findFranchisedOutletCityCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getFranchisedOutletCityCenterMapper());

	}
	@Override
	public int countFranchisedOutletCityCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countFranchisedOutletCityCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<FranchisedOutletCityCenter> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getFranchisedOutletCityCenterMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateFranchisedOutletCityCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateFranchisedOutletCityCenter result = new CandidateFranchisedOutletCityCenter();
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


