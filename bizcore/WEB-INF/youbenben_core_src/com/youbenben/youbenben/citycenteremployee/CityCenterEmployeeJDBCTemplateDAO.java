
package com.youbenben.youbenben.citycenteremployee;

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


import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartment;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;

import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartmentDAO;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class CityCenterEmployeeJDBCTemplateDAO extends YoubenbenBaseDAOImpl implements CityCenterEmployeeDAO{

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

	
	/*
	protected CityCenterEmployee load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCityCenterEmployee(accessKey, options);
	}
	*/
	
	public SmartList<CityCenterEmployee> loadAll() {
	    return this.loadAll(getCityCenterEmployeeMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public CityCenterEmployee load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCityCenterEmployee(CityCenterEmployeeTable.withId(id), options);
	}
	
	
	
	public CityCenterEmployee save(CityCenterEmployee cityCenterEmployee,Map<String,Object> options){
		
		String methodName="save(CityCenterEmployee cityCenterEmployee,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(cityCenterEmployee, methodName, "cityCenterEmployee");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCityCenterEmployee(cityCenterEmployee,options);
	}
	public CityCenterEmployee clone(String cityCenterEmployeeId, Map<String,Object> options) throws Exception{
	
		return clone(CityCenterEmployeeTable.withId(cityCenterEmployeeId),options);
	}
	
	protected CityCenterEmployee clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String cityCenterEmployeeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		CityCenterEmployee newCityCenterEmployee = loadInternalCityCenterEmployee(accessKey, options);
		newCityCenterEmployee.setVersion(0);
		
		

		
		saveInternalCityCenterEmployee(newCityCenterEmployee,options);
		
		return newCityCenterEmployee;
	}
	
	
	
	

	protected void throwIfHasException(String cityCenterEmployeeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new CityCenterEmployeeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CityCenterEmployeeNotFoundException(
					"The " + this.getTableName() + "(" + cityCenterEmployeeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String cityCenterEmployeeId, int version) throws Exception{
	
		String methodName="delete(String cityCenterEmployeeId, int version)";
		assertMethodArgumentNotNull(cityCenterEmployeeId, methodName, "cityCenterEmployeeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{cityCenterEmployeeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(cityCenterEmployeeId,version);
		}
		
	
	}
	
	
	
	
	

	public CityCenterEmployee disconnectFromAll(String cityCenterEmployeeId, int version) throws Exception{
	
		
		CityCenterEmployee cityCenterEmployee = loadInternalCityCenterEmployee(CityCenterEmployeeTable.withId(cityCenterEmployeeId), emptyOptions());
		cityCenterEmployee.clearFromAll();
		this.saveCityCenterEmployee(cityCenterEmployee);
		return cityCenterEmployee;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return CityCenterEmployeeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "city_center_employee";
	}
	@Override
	protected String getBeanName() {
		
		return "cityCenterEmployee";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CityCenterEmployeeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractDepartmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CityCenterEmployeeTokens.DEPARTMENT);
 	}

 	protected boolean isSaveDepartmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CityCenterEmployeeTokens.DEPARTMENT);
 	}
 	

 	
  

 	protected boolean isExtractCityCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CityCenterEmployeeTokens.CITYCENTER);
 	}

 	protected boolean isSaveCityCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CityCenterEmployeeTokens.CITYCENTER);
 	}
 	

 	
 
		

	

	protected CityCenterEmployeeMapper getCityCenterEmployeeMapper(){
		return new CityCenterEmployeeMapper();
	}

	
	
	protected CityCenterEmployee extractCityCenterEmployee(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			CityCenterEmployee cityCenterEmployee = loadSingleObject(accessKey, getCityCenterEmployeeMapper());
			return cityCenterEmployee;
		}catch(EmptyResultDataAccessException e){
			throw new CityCenterEmployeeNotFoundException("CityCenterEmployee("+accessKey+") is not found!");
		}

	}

	
	

	protected CityCenterEmployee loadInternalCityCenterEmployee(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		CityCenterEmployee cityCenterEmployee = extractCityCenterEmployee(accessKey, loadOptions);
 	
 		if(isExtractDepartmentEnabled(loadOptions)){
	 		extractDepartment(cityCenterEmployee, loadOptions);
 		}
  	
 		if(isExtractCityCenterEnabled(loadOptions)){
	 		extractCityCenter(cityCenterEmployee, loadOptions);
 		}
 
		
		return cityCenterEmployee;
		
	}

	 

 	protected CityCenterEmployee extractDepartment(CityCenterEmployee cityCenterEmployee, Map<String,Object> options) throws Exception{

		if(cityCenterEmployee.getDepartment() == null){
			return cityCenterEmployee;
		}
		String departmentId = cityCenterEmployee.getDepartment().getId();
		if( departmentId == null){
			return cityCenterEmployee;
		}
		CityCenterDepartment department = getCityCenterDepartmentDAO().load(departmentId,options);
		if(department != null){
			cityCenterEmployee.setDepartment(department);
		}
		
 		
 		return cityCenterEmployee;
 	}
 		
  

 	protected CityCenterEmployee extractCityCenter(CityCenterEmployee cityCenterEmployee, Map<String,Object> options) throws Exception{

		if(cityCenterEmployee.getCityCenter() == null){
			return cityCenterEmployee;
		}
		String cityCenterId = cityCenterEmployee.getCityCenter().getId();
		if( cityCenterId == null){
			return cityCenterEmployee;
		}
		FranchisedOutletCityCenter cityCenter = getFranchisedOutletCityCenterDAO().load(cityCenterId,options);
		if(cityCenter != null){
			cityCenterEmployee.setCityCenter(cityCenter);
		}
		
 		
 		return cityCenterEmployee;
 	}
 		
 
		
		
  	
 	public SmartList<CityCenterEmployee> findCityCenterEmployeeByDepartment(String cityCenterDepartmentId,Map<String,Object> options){
 	
  		SmartList<CityCenterEmployee> resultList = queryWith(CityCenterEmployeeTable.COLUMN_DEPARTMENT, cityCenterDepartmentId, options, getCityCenterEmployeeMapper());
		// analyzeCityCenterEmployeeByDepartment(resultList, cityCenterDepartmentId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<CityCenterEmployee> findCityCenterEmployeeByDepartment(String cityCenterDepartmentId, int start, int count,Map<String,Object> options){
 		
 		SmartList<CityCenterEmployee> resultList =  queryWithRange(CityCenterEmployeeTable.COLUMN_DEPARTMENT, cityCenterDepartmentId, options, getCityCenterEmployeeMapper(), start, count);
 		//analyzeCityCenterEmployeeByDepartment(resultList, cityCenterDepartmentId, options);
 		return resultList;
 		
 	}
 	public void analyzeCityCenterEmployeeByDepartment(SmartList<CityCenterEmployee> resultList, String cityCenterDepartmentId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(CityCenterEmployee.DEPARTMENT_PROPERTY, cityCenterDepartmentId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countCityCenterEmployeeByDepartment(String cityCenterDepartmentId,Map<String,Object> options){

 		return countWith(CityCenterEmployeeTable.COLUMN_DEPARTMENT, cityCenterDepartmentId, options);
 	}
 	@Override
	public Map<String, Integer> countCityCenterEmployeeByDepartmentIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CityCenterEmployeeTable.COLUMN_DEPARTMENT, ids, options);
	}
 	
  	
 	public SmartList<CityCenterEmployee> findCityCenterEmployeeByCityCenter(String franchisedOutletCityCenterId,Map<String,Object> options){
 	
  		SmartList<CityCenterEmployee> resultList = queryWith(CityCenterEmployeeTable.COLUMN_CITY_CENTER, franchisedOutletCityCenterId, options, getCityCenterEmployeeMapper());
		// analyzeCityCenterEmployeeByCityCenter(resultList, franchisedOutletCityCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<CityCenterEmployee> findCityCenterEmployeeByCityCenter(String franchisedOutletCityCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<CityCenterEmployee> resultList =  queryWithRange(CityCenterEmployeeTable.COLUMN_CITY_CENTER, franchisedOutletCityCenterId, options, getCityCenterEmployeeMapper(), start, count);
 		//analyzeCityCenterEmployeeByCityCenter(resultList, franchisedOutletCityCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeCityCenterEmployeeByCityCenter(SmartList<CityCenterEmployee> resultList, String franchisedOutletCityCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(CityCenterEmployee.CITY_CENTER_PROPERTY, franchisedOutletCityCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countCityCenterEmployeeByCityCenter(String franchisedOutletCityCenterId,Map<String,Object> options){

 		return countWith(CityCenterEmployeeTable.COLUMN_CITY_CENTER, franchisedOutletCityCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countCityCenterEmployeeByCityCenterIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CityCenterEmployeeTable.COLUMN_CITY_CENTER, ids, options);
	}
 	
 	
		
		
		

	

	protected CityCenterEmployee saveCityCenterEmployee(CityCenterEmployee  cityCenterEmployee){
		
		if(!cityCenterEmployee.isChanged()){
			return cityCenterEmployee;
		}
		
		
		String SQL=this.getSaveCityCenterEmployeeSQL(cityCenterEmployee);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCityCenterEmployeeParameters(cityCenterEmployee);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		cityCenterEmployee.incVersion();
		return cityCenterEmployee;
	
	}
	public SmartList<CityCenterEmployee> saveCityCenterEmployeeList(SmartList<CityCenterEmployee> cityCenterEmployeeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCityCenterEmployeeList(cityCenterEmployeeList);
		
		batchCityCenterEmployeeCreate((List<CityCenterEmployee>)lists[CREATE_LIST_INDEX]);
		
		batchCityCenterEmployeeUpdate((List<CityCenterEmployee>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(CityCenterEmployee cityCenterEmployee:cityCenterEmployeeList){
			if(cityCenterEmployee.isChanged()){
				cityCenterEmployee.incVersion();
			}
			
		
		}
		
		
		return cityCenterEmployeeList;
	}

	public SmartList<CityCenterEmployee> removeCityCenterEmployeeList(SmartList<CityCenterEmployee> cityCenterEmployeeList,Map<String,Object> options){
		
		
		super.removeList(cityCenterEmployeeList, options);
		
		return cityCenterEmployeeList;
		
		
	}
	
	protected List<Object[]> prepareCityCenterEmployeeBatchCreateArgs(List<CityCenterEmployee> cityCenterEmployeeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityCenterEmployee cityCenterEmployee:cityCenterEmployeeList ){
			Object [] parameters = prepareCityCenterEmployeeCreateParameters(cityCenterEmployee);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCityCenterEmployeeBatchUpdateArgs(List<CityCenterEmployee> cityCenterEmployeeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityCenterEmployee cityCenterEmployee:cityCenterEmployeeList ){
			if(!cityCenterEmployee.isChanged()){
				continue;
			}
			Object [] parameters = prepareCityCenterEmployeeUpdateParameters(cityCenterEmployee);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCityCenterEmployeeCreate(List<CityCenterEmployee> cityCenterEmployeeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCityCenterEmployeeBatchCreateArgs(cityCenterEmployeeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCityCenterEmployeeUpdate(List<CityCenterEmployee> cityCenterEmployeeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCityCenterEmployeeBatchUpdateArgs(cityCenterEmployeeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCityCenterEmployeeList(List<CityCenterEmployee> cityCenterEmployeeList){
		
		List<CityCenterEmployee> cityCenterEmployeeCreateList=new ArrayList<CityCenterEmployee>();
		List<CityCenterEmployee> cityCenterEmployeeUpdateList=new ArrayList<CityCenterEmployee>();
		
		for(CityCenterEmployee cityCenterEmployee: cityCenterEmployeeList){
			if(isUpdateRequest(cityCenterEmployee)){
				cityCenterEmployeeUpdateList.add( cityCenterEmployee);
				continue;
			}
			cityCenterEmployeeCreateList.add(cityCenterEmployee);
		}
		
		return new Object[]{cityCenterEmployeeCreateList,cityCenterEmployeeUpdateList};
	}
	
	protected boolean isUpdateRequest(CityCenterEmployee cityCenterEmployee){
 		return cityCenterEmployee.getVersion() > 0;
 	}
 	protected String getSaveCityCenterEmployeeSQL(CityCenterEmployee cityCenterEmployee){
 		if(isUpdateRequest(cityCenterEmployee)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCityCenterEmployeeParameters(CityCenterEmployee cityCenterEmployee){
 		if(isUpdateRequest(cityCenterEmployee) ){
 			return prepareCityCenterEmployeeUpdateParameters(cityCenterEmployee);
 		}
 		return prepareCityCenterEmployeeCreateParameters(cityCenterEmployee);
 	}
 	protected Object[] prepareCityCenterEmployeeUpdateParameters(CityCenterEmployee cityCenterEmployee){
 		Object[] parameters = new Object[9];
 
 		
 		parameters[0] = cityCenterEmployee.getName();
 		
 		
 		parameters[1] = cityCenterEmployee.getMobile();
 		
 		
 		parameters[2] = cityCenterEmployee.getEmail();
 		
 		
 		parameters[3] = cityCenterEmployee.getFounded();
 		 	
 		if(cityCenterEmployee.getDepartment() != null){
 			parameters[4] = cityCenterEmployee.getDepartment().getId();
 		}
  	
 		if(cityCenterEmployee.getCityCenter() != null){
 			parameters[5] = cityCenterEmployee.getCityCenter().getId();
 		}
 		
 		parameters[6] = cityCenterEmployee.nextVersion();
 		parameters[7] = cityCenterEmployee.getId();
 		parameters[8] = cityCenterEmployee.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCityCenterEmployeeCreateParameters(CityCenterEmployee cityCenterEmployee){
		Object[] parameters = new Object[7];
		String newCityCenterEmployeeId=getNextId();
		cityCenterEmployee.setId(newCityCenterEmployeeId);
		parameters[0] =  cityCenterEmployee.getId();
 
 		
 		parameters[1] = cityCenterEmployee.getName();
 		
 		
 		parameters[2] = cityCenterEmployee.getMobile();
 		
 		
 		parameters[3] = cityCenterEmployee.getEmail();
 		
 		
 		parameters[4] = cityCenterEmployee.getFounded();
 		 	
 		if(cityCenterEmployee.getDepartment() != null){
 			parameters[5] = cityCenterEmployee.getDepartment().getId();
 		
 		}
 		 	
 		if(cityCenterEmployee.getCityCenter() != null){
 			parameters[6] = cityCenterEmployee.getCityCenter().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected CityCenterEmployee saveInternalCityCenterEmployee(CityCenterEmployee cityCenterEmployee, Map<String,Object> options){
		
		saveCityCenterEmployee(cityCenterEmployee);
 	
 		if(isSaveDepartmentEnabled(options)){
	 		saveDepartment(cityCenterEmployee, options);
 		}
  	
 		if(isSaveCityCenterEnabled(options)){
	 		saveCityCenter(cityCenterEmployee, options);
 		}
 
		
		return cityCenterEmployee;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CityCenterEmployee saveDepartment(CityCenterEmployee cityCenterEmployee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(cityCenterEmployee.getDepartment() == null){
 			return cityCenterEmployee;//do nothing when it is null
 		}
 		
 		getCityCenterDepartmentDAO().save(cityCenterEmployee.getDepartment(),options);
 		return cityCenterEmployee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected CityCenterEmployee saveCityCenter(CityCenterEmployee cityCenterEmployee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(cityCenterEmployee.getCityCenter() == null){
 			return cityCenterEmployee;//do nothing when it is null
 		}
 		
 		getFranchisedOutletCityCenterDAO().save(cityCenterEmployee.getCityCenter(),options);
 		return cityCenterEmployee;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public CityCenterEmployee present(CityCenterEmployee cityCenterEmployee,Map<String, Object> options){
	

		return cityCenterEmployee;
	
	}
		

	

	protected String getTableName(){
		return CityCenterEmployeeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<CityCenterEmployee> cityCenterEmployeeList) {		
		this.enhanceListInternal(cityCenterEmployeeList, this.getCityCenterEmployeeMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<CityCenterEmployee> cityCenterEmployeeList = ownerEntity.collectRefsWithType(CityCenterEmployee.INTERNAL_TYPE);
		this.enhanceList(cityCenterEmployeeList);
		
	}
	
	@Override
	public SmartList<CityCenterEmployee> findCityCenterEmployeeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getCityCenterEmployeeMapper());

	}
	@Override
	public int countCityCenterEmployeeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countCityCenterEmployeeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<CityCenterEmployee> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getCityCenterEmployeeMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateCityCenterEmployee executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateCityCenterEmployee result = new CandidateCityCenterEmployee();
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


