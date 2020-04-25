
package com.youbenben.youbenben.citycenterdepartment;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.youbenben.youbenben.YoubenbenBaseDAOImpl;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.AccessKey;
import com.youbenben.youbenben.DateKey;
import com.youbenben.youbenben.StatsInfo;
import com.youbenben.youbenben.StatsItem;

import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;


import com.youbenben.youbenben.citycenteremployee.CityCenterEmployee;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;

import com.youbenben.youbenben.citycenteremployee.CityCenterEmployeeDAO;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class CityCenterDepartmentJDBCTemplateDAO extends YoubenbenBaseDAOImpl implements CityCenterDepartmentDAO{

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

	
	/*
	protected CityCenterDepartment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCityCenterDepartment(accessKey, options);
	}
	*/
	
	public SmartList<CityCenterDepartment> loadAll() {
	    return this.loadAll(getCityCenterDepartmentMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public CityCenterDepartment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCityCenterDepartment(CityCenterDepartmentTable.withId(id), options);
	}
	
	
	
	public CityCenterDepartment save(CityCenterDepartment cityCenterDepartment,Map<String,Object> options){
		
		String methodName="save(CityCenterDepartment cityCenterDepartment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(cityCenterDepartment, methodName, "cityCenterDepartment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCityCenterDepartment(cityCenterDepartment,options);
	}
	public CityCenterDepartment clone(String cityCenterDepartmentId, Map<String,Object> options) throws Exception{
	
		return clone(CityCenterDepartmentTable.withId(cityCenterDepartmentId),options);
	}
	
	protected CityCenterDepartment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String cityCenterDepartmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		CityCenterDepartment newCityCenterDepartment = loadInternalCityCenterDepartment(accessKey, options);
		newCityCenterDepartment.setVersion(0);
		
		
 		
 		if(isSaveCityCenterEmployeeListEnabled(options)){
 			for(CityCenterEmployee item: newCityCenterDepartment.getCityCenterEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalCityCenterDepartment(newCityCenterDepartment,options);
		
		return newCityCenterDepartment;
	}
	
	
	
	

	protected void throwIfHasException(String cityCenterDepartmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new CityCenterDepartmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CityCenterDepartmentNotFoundException(
					"The " + this.getTableName() + "(" + cityCenterDepartmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String cityCenterDepartmentId, int version) throws Exception{
	
		String methodName="delete(String cityCenterDepartmentId, int version)";
		assertMethodArgumentNotNull(cityCenterDepartmentId, methodName, "cityCenterDepartmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{cityCenterDepartmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(cityCenterDepartmentId,version);
		}
		
	
	}
	
	
	
	
	

	public CityCenterDepartment disconnectFromAll(String cityCenterDepartmentId, int version) throws Exception{
	
		
		CityCenterDepartment cityCenterDepartment = loadInternalCityCenterDepartment(CityCenterDepartmentTable.withId(cityCenterDepartmentId), emptyOptions());
		cityCenterDepartment.clearFromAll();
		this.saveCityCenterDepartment(cityCenterDepartment);
		return cityCenterDepartment;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return CityCenterDepartmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "city_center_department";
	}
	@Override
	protected String getBeanName() {
		
		return "cityCenterDepartment";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CityCenterDepartmentTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractCityCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CityCenterDepartmentTokens.CITYCENTER);
 	}

 	protected boolean isSaveCityCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CityCenterDepartmentTokens.CITYCENTER);
 	}
 	

 	
 
		
	
	protected boolean isExtractCityCenterEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CityCenterDepartmentTokens.CITY_CENTER_EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeCityCenterEmployeeListEnabled(Map<String,Object> options){		 		
 		return CityCenterDepartmentTokens.of(options).analyzeCityCenterEmployeeListEnabled();
 	}
	
	protected boolean isSaveCityCenterEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, CityCenterDepartmentTokens.CITY_CENTER_EMPLOYEE_LIST);
		
 	}
 	
		

	

	protected CityCenterDepartmentMapper getCityCenterDepartmentMapper(){
		return new CityCenterDepartmentMapper();
	}

	
	
	protected CityCenterDepartment extractCityCenterDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			CityCenterDepartment cityCenterDepartment = loadSingleObject(accessKey, getCityCenterDepartmentMapper());
			return cityCenterDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new CityCenterDepartmentNotFoundException("CityCenterDepartment("+accessKey+") is not found!");
		}

	}

	
	

	protected CityCenterDepartment loadInternalCityCenterDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		CityCenterDepartment cityCenterDepartment = extractCityCenterDepartment(accessKey, loadOptions);
 	
 		if(isExtractCityCenterEnabled(loadOptions)){
	 		extractCityCenter(cityCenterDepartment, loadOptions);
 		}
 
		
		if(isExtractCityCenterEmployeeListEnabled(loadOptions)){
	 		extractCityCenterEmployeeList(cityCenterDepartment, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeCityCenterEmployeeListEnabled(loadOptions)){
	 		analyzeCityCenterEmployeeList(cityCenterDepartment, loadOptions);
 		}
 		
		
		return cityCenterDepartment;
		
	}

	 

 	protected CityCenterDepartment extractCityCenter(CityCenterDepartment cityCenterDepartment, Map<String,Object> options) throws Exception{

		if(cityCenterDepartment.getCityCenter() == null){
			return cityCenterDepartment;
		}
		String cityCenterId = cityCenterDepartment.getCityCenter().getId();
		if( cityCenterId == null){
			return cityCenterDepartment;
		}
		FranchisedOutletCityCenter cityCenter = getFranchisedOutletCityCenterDAO().load(cityCenterId,options);
		if(cityCenter != null){
			cityCenterDepartment.setCityCenter(cityCenter);
		}
		
 		
 		return cityCenterDepartment;
 	}
 		
 
		
	protected void enhanceCityCenterEmployeeList(SmartList<CityCenterEmployee> cityCenterEmployeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected CityCenterDepartment extractCityCenterEmployeeList(CityCenterDepartment cityCenterDepartment, Map<String,Object> options){
		
		
		if(cityCenterDepartment == null){
			return null;
		}
		if(cityCenterDepartment.getId() == null){
			return cityCenterDepartment;
		}

		
		
		SmartList<CityCenterEmployee> cityCenterEmployeeList = getCityCenterEmployeeDAO().findCityCenterEmployeeByDepartment(cityCenterDepartment.getId(),options);
		if(cityCenterEmployeeList != null){
			enhanceCityCenterEmployeeList(cityCenterEmployeeList,options);
			cityCenterDepartment.setCityCenterEmployeeList(cityCenterEmployeeList);
		}
		
		return cityCenterDepartment;
	
	}	
	
	protected CityCenterDepartment analyzeCityCenterEmployeeList(CityCenterDepartment cityCenterDepartment, Map<String,Object> options){
		
		
		if(cityCenterDepartment == null){
			return null;
		}
		if(cityCenterDepartment.getId() == null){
			return cityCenterDepartment;
		}

		
		
		SmartList<CityCenterEmployee> cityCenterEmployeeList = cityCenterDepartment.getCityCenterEmployeeList();
		if(cityCenterEmployeeList != null){
			getCityCenterEmployeeDAO().analyzeCityCenterEmployeeByDepartment(cityCenterEmployeeList, cityCenterDepartment.getId(), options);
			
		}
		
		return cityCenterDepartment;
	
	}	
	
		
		
  	
 	public SmartList<CityCenterDepartment> findCityCenterDepartmentByCityCenter(String franchisedOutletCityCenterId,Map<String,Object> options){
 	
  		SmartList<CityCenterDepartment> resultList = queryWith(CityCenterDepartmentTable.COLUMN_CITY_CENTER, franchisedOutletCityCenterId, options, getCityCenterDepartmentMapper());
		// analyzeCityCenterDepartmentByCityCenter(resultList, franchisedOutletCityCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<CityCenterDepartment> findCityCenterDepartmentByCityCenter(String franchisedOutletCityCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<CityCenterDepartment> resultList =  queryWithRange(CityCenterDepartmentTable.COLUMN_CITY_CENTER, franchisedOutletCityCenterId, options, getCityCenterDepartmentMapper(), start, count);
 		//analyzeCityCenterDepartmentByCityCenter(resultList, franchisedOutletCityCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeCityCenterDepartmentByCityCenter(SmartList<CityCenterDepartment> resultList, String franchisedOutletCityCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countCityCenterDepartmentByCityCenter(String franchisedOutletCityCenterId,Map<String,Object> options){

 		return countWith(CityCenterDepartmentTable.COLUMN_CITY_CENTER, franchisedOutletCityCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countCityCenterDepartmentByCityCenterIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CityCenterDepartmentTable.COLUMN_CITY_CENTER, ids, options);
	}
 	
 	
		
		
		

	

	protected CityCenterDepartment saveCityCenterDepartment(CityCenterDepartment  cityCenterDepartment){
		
		if(!cityCenterDepartment.isChanged()){
			return cityCenterDepartment;
		}
		
		
		String SQL=this.getSaveCityCenterDepartmentSQL(cityCenterDepartment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCityCenterDepartmentParameters(cityCenterDepartment);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		cityCenterDepartment.incVersion();
		return cityCenterDepartment;
	
	}
	public SmartList<CityCenterDepartment> saveCityCenterDepartmentList(SmartList<CityCenterDepartment> cityCenterDepartmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCityCenterDepartmentList(cityCenterDepartmentList);
		
		batchCityCenterDepartmentCreate((List<CityCenterDepartment>)lists[CREATE_LIST_INDEX]);
		
		batchCityCenterDepartmentUpdate((List<CityCenterDepartment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(CityCenterDepartment cityCenterDepartment:cityCenterDepartmentList){
			if(cityCenterDepartment.isChanged()){
				cityCenterDepartment.incVersion();
			}
			
		
		}
		
		
		return cityCenterDepartmentList;
	}

	public SmartList<CityCenterDepartment> removeCityCenterDepartmentList(SmartList<CityCenterDepartment> cityCenterDepartmentList,Map<String,Object> options){
		
		
		super.removeList(cityCenterDepartmentList, options);
		
		return cityCenterDepartmentList;
		
		
	}
	
	protected List<Object[]> prepareCityCenterDepartmentBatchCreateArgs(List<CityCenterDepartment> cityCenterDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityCenterDepartment cityCenterDepartment:cityCenterDepartmentList ){
			Object [] parameters = prepareCityCenterDepartmentCreateParameters(cityCenterDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCityCenterDepartmentBatchUpdateArgs(List<CityCenterDepartment> cityCenterDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityCenterDepartment cityCenterDepartment:cityCenterDepartmentList ){
			if(!cityCenterDepartment.isChanged()){
				continue;
			}
			Object [] parameters = prepareCityCenterDepartmentUpdateParameters(cityCenterDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCityCenterDepartmentCreate(List<CityCenterDepartment> cityCenterDepartmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCityCenterDepartmentBatchCreateArgs(cityCenterDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCityCenterDepartmentUpdate(List<CityCenterDepartment> cityCenterDepartmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCityCenterDepartmentBatchUpdateArgs(cityCenterDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCityCenterDepartmentList(List<CityCenterDepartment> cityCenterDepartmentList){
		
		List<CityCenterDepartment> cityCenterDepartmentCreateList=new ArrayList<CityCenterDepartment>();
		List<CityCenterDepartment> cityCenterDepartmentUpdateList=new ArrayList<CityCenterDepartment>();
		
		for(CityCenterDepartment cityCenterDepartment: cityCenterDepartmentList){
			if(isUpdateRequest(cityCenterDepartment)){
				cityCenterDepartmentUpdateList.add( cityCenterDepartment);
				continue;
			}
			cityCenterDepartmentCreateList.add(cityCenterDepartment);
		}
		
		return new Object[]{cityCenterDepartmentCreateList,cityCenterDepartmentUpdateList};
	}
	
	protected boolean isUpdateRequest(CityCenterDepartment cityCenterDepartment){
 		return cityCenterDepartment.getVersion() > 0;
 	}
 	protected String getSaveCityCenterDepartmentSQL(CityCenterDepartment cityCenterDepartment){
 		if(isUpdateRequest(cityCenterDepartment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCityCenterDepartmentParameters(CityCenterDepartment cityCenterDepartment){
 		if(isUpdateRequest(cityCenterDepartment) ){
 			return prepareCityCenterDepartmentUpdateParameters(cityCenterDepartment);
 		}
 		return prepareCityCenterDepartmentCreateParameters(cityCenterDepartment);
 	}
 	protected Object[] prepareCityCenterDepartmentUpdateParameters(CityCenterDepartment cityCenterDepartment){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = cityCenterDepartment.getName();
 		
 		
 		parameters[1] = cityCenterDepartment.getFounded();
 		 	
 		if(cityCenterDepartment.getCityCenter() != null){
 			parameters[2] = cityCenterDepartment.getCityCenter().getId();
 		}
 
 		
 		parameters[3] = cityCenterDepartment.getManager();
 				
 		parameters[4] = cityCenterDepartment.nextVersion();
 		parameters[5] = cityCenterDepartment.getId();
 		parameters[6] = cityCenterDepartment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCityCenterDepartmentCreateParameters(CityCenterDepartment cityCenterDepartment){
		Object[] parameters = new Object[5];
		String newCityCenterDepartmentId=getNextId();
		cityCenterDepartment.setId(newCityCenterDepartmentId);
		parameters[0] =  cityCenterDepartment.getId();
 
 		
 		parameters[1] = cityCenterDepartment.getName();
 		
 		
 		parameters[2] = cityCenterDepartment.getFounded();
 		 	
 		if(cityCenterDepartment.getCityCenter() != null){
 			parameters[3] = cityCenterDepartment.getCityCenter().getId();
 		
 		}
 		
 		
 		parameters[4] = cityCenterDepartment.getManager();
 				
 				
 		return parameters;
 	}
 	
	protected CityCenterDepartment saveInternalCityCenterDepartment(CityCenterDepartment cityCenterDepartment, Map<String,Object> options){
		
		saveCityCenterDepartment(cityCenterDepartment);
 	
 		if(isSaveCityCenterEnabled(options)){
	 		saveCityCenter(cityCenterDepartment, options);
 		}
 
		
		if(isSaveCityCenterEmployeeListEnabled(options)){
	 		saveCityCenterEmployeeList(cityCenterDepartment, options);
	 		//removeCityCenterEmployeeList(cityCenterDepartment, options);
	 		//Not delete the record
	 		
 		}		
		
		return cityCenterDepartment;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CityCenterDepartment saveCityCenter(CityCenterDepartment cityCenterDepartment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(cityCenterDepartment.getCityCenter() == null){
 			return cityCenterDepartment;//do nothing when it is null
 		}
 		
 		getFranchisedOutletCityCenterDAO().save(cityCenterDepartment.getCityCenter(),options);
 		return cityCenterDepartment;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public CityCenterDepartment planToRemoveCityCenterEmployeeList(CityCenterDepartment cityCenterDepartment, String cityCenterEmployeeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityCenterEmployee.DEPARTMENT_PROPERTY, cityCenterDepartment.getId());
		key.put(CityCenterEmployee.ID_PROPERTY, cityCenterEmployeeIds);
		
		SmartList<CityCenterEmployee> externalCityCenterEmployeeList = getCityCenterEmployeeDAO().
				findCityCenterEmployeeWithKey(key, options);
		if(externalCityCenterEmployeeList == null){
			return cityCenterDepartment;
		}
		if(externalCityCenterEmployeeList.isEmpty()){
			return cityCenterDepartment;
		}
		
		for(CityCenterEmployee cityCenterEmployeeItem: externalCityCenterEmployeeList){

			cityCenterEmployeeItem.clearFromAll();
		}
		
		
		SmartList<CityCenterEmployee> cityCenterEmployeeList = cityCenterDepartment.getCityCenterEmployeeList();		
		cityCenterEmployeeList.addAllToRemoveList(externalCityCenterEmployeeList);
		return cityCenterDepartment;	
	
	}


	//disconnect CityCenterDepartment with city_center in CityCenterEmployee
	public CityCenterDepartment planToRemoveCityCenterEmployeeListWithCityCenter(CityCenterDepartment cityCenterDepartment, String cityCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityCenterEmployee.DEPARTMENT_PROPERTY, cityCenterDepartment.getId());
		key.put(CityCenterEmployee.CITY_CENTER_PROPERTY, cityCenterId);
		
		SmartList<CityCenterEmployee> externalCityCenterEmployeeList = getCityCenterEmployeeDAO().
				findCityCenterEmployeeWithKey(key, options);
		if(externalCityCenterEmployeeList == null){
			return cityCenterDepartment;
		}
		if(externalCityCenterEmployeeList.isEmpty()){
			return cityCenterDepartment;
		}
		
		for(CityCenterEmployee cityCenterEmployeeItem: externalCityCenterEmployeeList){
			cityCenterEmployeeItem.clearCityCenter();
			cityCenterEmployeeItem.clearDepartment();
			
		}
		
		
		SmartList<CityCenterEmployee> cityCenterEmployeeList = cityCenterDepartment.getCityCenterEmployeeList();		
		cityCenterEmployeeList.addAllToRemoveList(externalCityCenterEmployeeList);
		return cityCenterDepartment;
	}
	
	public int countCityCenterEmployeeListWithCityCenter(String cityCenterDepartmentId, String cityCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityCenterEmployee.DEPARTMENT_PROPERTY, cityCenterDepartmentId);
		key.put(CityCenterEmployee.CITY_CENTER_PROPERTY, cityCenterId);
		
		int count = getCityCenterEmployeeDAO().countCityCenterEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected CityCenterDepartment saveCityCenterEmployeeList(CityCenterDepartment cityCenterDepartment, Map<String,Object> options){
		
		
		
		
		SmartList<CityCenterEmployee> cityCenterEmployeeList = cityCenterDepartment.getCityCenterEmployeeList();
		if(cityCenterEmployeeList == null){
			//null list means nothing
			return cityCenterDepartment;
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
		
		
		return cityCenterDepartment;
	
	}
	
	protected CityCenterDepartment removeCityCenterEmployeeList(CityCenterDepartment cityCenterDepartment, Map<String,Object> options){
	
	
		SmartList<CityCenterEmployee> cityCenterEmployeeList = cityCenterDepartment.getCityCenterEmployeeList();
		if(cityCenterEmployeeList == null){
			return cityCenterDepartment;
		}	
	
		SmartList<CityCenterEmployee> toRemoveCityCenterEmployeeList = cityCenterEmployeeList.getToRemoveList();
		
		if(toRemoveCityCenterEmployeeList == null){
			return cityCenterDepartment;
		}
		if(toRemoveCityCenterEmployeeList.isEmpty()){
			return cityCenterDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCityCenterEmployeeDAO().removeCityCenterEmployeeList(toRemoveCityCenterEmployeeList,options);
		
		return cityCenterDepartment;
	
	}
	
	

 	
 	
	
	
	
		

	public CityCenterDepartment present(CityCenterDepartment cityCenterDepartment,Map<String, Object> options){
	
		presentCityCenterEmployeeList(cityCenterDepartment,options);

		return cityCenterDepartment;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected CityCenterDepartment presentCityCenterEmployeeList(
			CityCenterDepartment cityCenterDepartment,
			Map<String, Object> options) {

		SmartList<CityCenterEmployee> cityCenterEmployeeList = cityCenterDepartment.getCityCenterEmployeeList();		
				SmartList<CityCenterEmployee> newList= presentSubList(cityCenterDepartment.getId(),
				cityCenterEmployeeList,
				options,
				getCityCenterEmployeeDAO()::countCityCenterEmployeeByDepartment,
				getCityCenterEmployeeDAO()::findCityCenterEmployeeByDepartment
				);

		
		cityCenterDepartment.setCityCenterEmployeeList(newList);
		

		return cityCenterDepartment;
	}			
		

	
    public SmartList<CityCenterDepartment> requestCandidateCityCenterDepartmentForCityCenterEmployee(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CityCenterDepartmentTable.COLUMN_NAME, CityCenterDepartmentTable.COLUMN_CITY_CENTER, filterKey, pageNo, pageSize, getCityCenterDepartmentMapper());
    }
		

	protected String getTableName(){
		return CityCenterDepartmentTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<CityCenterDepartment> cityCenterDepartmentList) {		
		this.enhanceListInternal(cityCenterDepartmentList, this.getCityCenterDepartmentMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:CityCenterEmployee的department的CityCenterEmployeeList
	public SmartList<CityCenterEmployee> loadOurCityCenterEmployeeList(YoubenbenUserContext userContext, List<CityCenterDepartment> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityCenterEmployee.DEPARTMENT_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<CityCenterEmployee> loadedObjs = userContext.getDAOGroup().getCityCenterEmployeeDAO().findCityCenterEmployeeWithKey(key, options);
		Map<String, List<CityCenterEmployee>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getDepartment().getId()));
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
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<CityCenterDepartment> cityCenterDepartmentList = ownerEntity.collectRefsWithType(CityCenterDepartment.INTERNAL_TYPE);
		this.enhanceList(cityCenterDepartmentList);
		
	}
	
	@Override
	public SmartList<CityCenterDepartment> findCityCenterDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getCityCenterDepartmentMapper());

	}
	@Override
	public int countCityCenterDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countCityCenterDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<CityCenterDepartment> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getCityCenterDepartmentMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateCityCenterDepartment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateCityCenterDepartment result = new CandidateCityCenterDepartment();
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


