
package com.xingyou.xingyou.franchisedoutletprovincecenter;

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


import com.xingyou.xingyou.catalog.Catalog;

import com.xingyou.xingyou.catalog.CatalogDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class FranchisedOutletProvinceCenterJDBCTemplateDAO extends XingyouBaseDAOImpl implements FranchisedOutletProvinceCenterDAO{

	protected CatalogDAO catalogDAO;
	public void setCatalogDAO(CatalogDAO catalogDAO){
 	
 		if(catalogDAO == null){
 			throw new IllegalStateException("Do not try to set catalogDAO to null.");
 		}
	 	this.catalogDAO = catalogDAO;
 	}
 	public CatalogDAO getCatalogDAO(){
 		if(this.catalogDAO == null){
 			throw new IllegalStateException("The catalogDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.catalogDAO;
 	}	

	
	/*
	protected FranchisedOutletProvinceCenter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalFranchisedOutletProvinceCenter(accessKey, options);
	}
	*/
	
	public SmartList<FranchisedOutletProvinceCenter> loadAll() {
	    return this.loadAll(getFranchisedOutletProvinceCenterMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public FranchisedOutletProvinceCenter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalFranchisedOutletProvinceCenter(FranchisedOutletProvinceCenterTable.withId(id), options);
	}
	
	
	
	public FranchisedOutletProvinceCenter save(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter,Map<String,Object> options){
		
		String methodName="save(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(franchisedOutletProvinceCenter, methodName, "franchisedOutletProvinceCenter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalFranchisedOutletProvinceCenter(franchisedOutletProvinceCenter,options);
	}
	public FranchisedOutletProvinceCenter clone(String franchisedOutletProvinceCenterId, Map<String,Object> options) throws Exception{
	
		return clone(FranchisedOutletProvinceCenterTable.withId(franchisedOutletProvinceCenterId),options);
	}
	
	protected FranchisedOutletProvinceCenter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String franchisedOutletProvinceCenterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		FranchisedOutletProvinceCenter newFranchisedOutletProvinceCenter = loadInternalFranchisedOutletProvinceCenter(accessKey, options);
		newFranchisedOutletProvinceCenter.setVersion(0);
		
		
 		
 		if(isSaveCatalogListEnabled(options)){
 			for(Catalog item: newFranchisedOutletProvinceCenter.getCatalogList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalFranchisedOutletProvinceCenter(newFranchisedOutletProvinceCenter,options);
		
		return newFranchisedOutletProvinceCenter;
	}
	
	
	
	

	protected void throwIfHasException(String franchisedOutletProvinceCenterId,int version,int count) throws Exception{
		if (count == 1) {
			throw new FranchisedOutletProvinceCenterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new FranchisedOutletProvinceCenterNotFoundException(
					"The " + this.getTableName() + "(" + franchisedOutletProvinceCenterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String franchisedOutletProvinceCenterId, int version) throws Exception{
	
		String methodName="delete(String franchisedOutletProvinceCenterId, int version)";
		assertMethodArgumentNotNull(franchisedOutletProvinceCenterId, methodName, "franchisedOutletProvinceCenterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{franchisedOutletProvinceCenterId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(franchisedOutletProvinceCenterId,version);
		}
		
	
	}
	
	
	
	
	

	public FranchisedOutletProvinceCenter disconnectFromAll(String franchisedOutletProvinceCenterId, int version) throws Exception{
	
		
		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadInternalFranchisedOutletProvinceCenter(FranchisedOutletProvinceCenterTable.withId(franchisedOutletProvinceCenterId), emptyOptions());
		franchisedOutletProvinceCenter.clearFromAll();
		this.saveFranchisedOutletProvinceCenter(franchisedOutletProvinceCenter);
		return franchisedOutletProvinceCenter;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return FranchisedOutletProvinceCenterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "franchised_outlet_province_center";
	}
	@Override
	protected String getBeanName() {
		
		return "franchisedOutletProvinceCenter";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return FranchisedOutletProvinceCenterTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractCatalogListEnabled(Map<String,Object> options){		
 		return checkOptions(options,FranchisedOutletProvinceCenterTokens.CATALOG_LIST);
 	}
 	protected boolean isAnalyzeCatalogListEnabled(Map<String,Object> options){		 		
 		return FranchisedOutletProvinceCenterTokens.of(options).analyzeCatalogListEnabled();
 	}
	
	protected boolean isSaveCatalogListEnabled(Map<String,Object> options){
		return checkOptions(options, FranchisedOutletProvinceCenterTokens.CATALOG_LIST);
		
 	}
 	
		

	

	protected FranchisedOutletProvinceCenterMapper getFranchisedOutletProvinceCenterMapper(){
		return new FranchisedOutletProvinceCenterMapper();
	}

	
	
	protected FranchisedOutletProvinceCenter extractFranchisedOutletProvinceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = loadSingleObject(accessKey, getFranchisedOutletProvinceCenterMapper());
			return franchisedOutletProvinceCenter;
		}catch(EmptyResultDataAccessException e){
			throw new FranchisedOutletProvinceCenterNotFoundException("FranchisedOutletProvinceCenter("+accessKey+") is not found!");
		}

	}

	
	

	protected FranchisedOutletProvinceCenter loadInternalFranchisedOutletProvinceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = extractFranchisedOutletProvinceCenter(accessKey, loadOptions);

		
		if(isExtractCatalogListEnabled(loadOptions)){
	 		extractCatalogList(franchisedOutletProvinceCenter, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeCatalogListEnabled(loadOptions)){
	 		analyzeCatalogList(franchisedOutletProvinceCenter, loadOptions);
 		}
 		
		
		return franchisedOutletProvinceCenter;
		
	}

	
		
	protected void enhanceCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected FranchisedOutletProvinceCenter extractCatalogList(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, Map<String,Object> options){
		
		
		if(franchisedOutletProvinceCenter == null){
			return null;
		}
		if(franchisedOutletProvinceCenter.getId() == null){
			return franchisedOutletProvinceCenter;
		}

		
		
		SmartList<Catalog> catalogList = getCatalogDAO().findCatalogByOwner(franchisedOutletProvinceCenter.getId(),options);
		if(catalogList != null){
			enhanceCatalogList(catalogList,options);
			franchisedOutletProvinceCenter.setCatalogList(catalogList);
		}
		
		return franchisedOutletProvinceCenter;
	
	}	
	
	protected FranchisedOutletProvinceCenter analyzeCatalogList(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, Map<String,Object> options){
		
		
		if(franchisedOutletProvinceCenter == null){
			return null;
		}
		if(franchisedOutletProvinceCenter.getId() == null){
			return franchisedOutletProvinceCenter;
		}

		
		
		SmartList<Catalog> catalogList = franchisedOutletProvinceCenter.getCatalogList();
		if(catalogList != null){
			getCatalogDAO().analyzeCatalogByOwner(catalogList, franchisedOutletProvinceCenter.getId(), options);
			
		}
		
		return franchisedOutletProvinceCenter;
	
	}	
	
		
		
 	
		
		
		

	

	protected FranchisedOutletProvinceCenter saveFranchisedOutletProvinceCenter(FranchisedOutletProvinceCenter  franchisedOutletProvinceCenter){
		
		if(!franchisedOutletProvinceCenter.isChanged()){
			return franchisedOutletProvinceCenter;
		}
		
		
		String SQL=this.getSaveFranchisedOutletProvinceCenterSQL(franchisedOutletProvinceCenter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveFranchisedOutletProvinceCenterParameters(franchisedOutletProvinceCenter);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		franchisedOutletProvinceCenter.incVersion();
		return franchisedOutletProvinceCenter;
	
	}
	public SmartList<FranchisedOutletProvinceCenter> saveFranchisedOutletProvinceCenterList(SmartList<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitFranchisedOutletProvinceCenterList(franchisedOutletProvinceCenterList);
		
		batchFranchisedOutletProvinceCenterCreate((List<FranchisedOutletProvinceCenter>)lists[CREATE_LIST_INDEX]);
		
		batchFranchisedOutletProvinceCenterUpdate((List<FranchisedOutletProvinceCenter>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter:franchisedOutletProvinceCenterList){
			if(franchisedOutletProvinceCenter.isChanged()){
				franchisedOutletProvinceCenter.incVersion();
			}
			
		
		}
		
		
		return franchisedOutletProvinceCenterList;
	}

	public SmartList<FranchisedOutletProvinceCenter> removeFranchisedOutletProvinceCenterList(SmartList<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList,Map<String,Object> options){
		
		
		super.removeList(franchisedOutletProvinceCenterList, options);
		
		return franchisedOutletProvinceCenterList;
		
		
	}
	
	protected List<Object[]> prepareFranchisedOutletProvinceCenterBatchCreateArgs(List<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter:franchisedOutletProvinceCenterList ){
			Object [] parameters = prepareFranchisedOutletProvinceCenterCreateParameters(franchisedOutletProvinceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareFranchisedOutletProvinceCenterBatchUpdateArgs(List<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter:franchisedOutletProvinceCenterList ){
			if(!franchisedOutletProvinceCenter.isChanged()){
				continue;
			}
			Object [] parameters = prepareFranchisedOutletProvinceCenterUpdateParameters(franchisedOutletProvinceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchFranchisedOutletProvinceCenterCreate(List<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareFranchisedOutletProvinceCenterBatchCreateArgs(franchisedOutletProvinceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchFranchisedOutletProvinceCenterUpdate(List<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareFranchisedOutletProvinceCenterBatchUpdateArgs(franchisedOutletProvinceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitFranchisedOutletProvinceCenterList(List<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList){
		
		List<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterCreateList=new ArrayList<FranchisedOutletProvinceCenter>();
		List<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterUpdateList=new ArrayList<FranchisedOutletProvinceCenter>();
		
		for(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter: franchisedOutletProvinceCenterList){
			if(isUpdateRequest(franchisedOutletProvinceCenter)){
				franchisedOutletProvinceCenterUpdateList.add( franchisedOutletProvinceCenter);
				continue;
			}
			franchisedOutletProvinceCenterCreateList.add(franchisedOutletProvinceCenter);
		}
		
		return new Object[]{franchisedOutletProvinceCenterCreateList,franchisedOutletProvinceCenterUpdateList};
	}
	
	protected boolean isUpdateRequest(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter){
 		return franchisedOutletProvinceCenter.getVersion() > 0;
 	}
 	protected String getSaveFranchisedOutletProvinceCenterSQL(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter){
 		if(isUpdateRequest(franchisedOutletProvinceCenter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveFranchisedOutletProvinceCenterParameters(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter){
 		if(isUpdateRequest(franchisedOutletProvinceCenter) ){
 			return prepareFranchisedOutletProvinceCenterUpdateParameters(franchisedOutletProvinceCenter);
 		}
 		return prepareFranchisedOutletProvinceCenterCreateParameters(franchisedOutletProvinceCenter);
 	}
 	protected Object[] prepareFranchisedOutletProvinceCenterUpdateParameters(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter){
 		Object[] parameters = new Object[11];
 
 		
 		parameters[0] = franchisedOutletProvinceCenter.getName();
 		
 		
 		parameters[1] = franchisedOutletProvinceCenter.getServiceNumber();
 		
 		
 		parameters[2] = franchisedOutletProvinceCenter.getFounded();
 		
 		
 		parameters[3] = franchisedOutletProvinceCenter.getWebSite();
 		
 		
 		parameters[4] = franchisedOutletProvinceCenter.getAddress();
 		
 		
 		parameters[5] = franchisedOutletProvinceCenter.getOperatedBy();
 		
 		
 		parameters[6] = franchisedOutletProvinceCenter.getLegalRepresentative();
 		
 		
 		parameters[7] = franchisedOutletProvinceCenter.getDescription();
 				
 		parameters[8] = franchisedOutletProvinceCenter.nextVersion();
 		parameters[9] = franchisedOutletProvinceCenter.getId();
 		parameters[10] = franchisedOutletProvinceCenter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareFranchisedOutletProvinceCenterCreateParameters(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter){
		Object[] parameters = new Object[9];
		String newFranchisedOutletProvinceCenterId=getNextId();
		franchisedOutletProvinceCenter.setId(newFranchisedOutletProvinceCenterId);
		parameters[0] =  franchisedOutletProvinceCenter.getId();
 
 		
 		parameters[1] = franchisedOutletProvinceCenter.getName();
 		
 		
 		parameters[2] = franchisedOutletProvinceCenter.getServiceNumber();
 		
 		
 		parameters[3] = franchisedOutletProvinceCenter.getFounded();
 		
 		
 		parameters[4] = franchisedOutletProvinceCenter.getWebSite();
 		
 		
 		parameters[5] = franchisedOutletProvinceCenter.getAddress();
 		
 		
 		parameters[6] = franchisedOutletProvinceCenter.getOperatedBy();
 		
 		
 		parameters[7] = franchisedOutletProvinceCenter.getLegalRepresentative();
 		
 		
 		parameters[8] = franchisedOutletProvinceCenter.getDescription();
 				
 				
 		return parameters;
 	}
 	
	protected FranchisedOutletProvinceCenter saveInternalFranchisedOutletProvinceCenter(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, Map<String,Object> options){
		
		saveFranchisedOutletProvinceCenter(franchisedOutletProvinceCenter);

		
		if(isSaveCatalogListEnabled(options)){
	 		saveCatalogList(franchisedOutletProvinceCenter, options);
	 		//removeCatalogList(franchisedOutletProvinceCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		return franchisedOutletProvinceCenter;
		
	}
	
	
	
	//======================================================================================
	

	
	public FranchisedOutletProvinceCenter planToRemoveCatalogList(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, String catalogIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.OWNER_PROPERTY, franchisedOutletProvinceCenter.getId());
		key.put(Catalog.ID_PROPERTY, catalogIds);
		
		SmartList<Catalog> externalCatalogList = getCatalogDAO().
				findCatalogWithKey(key, options);
		if(externalCatalogList == null){
			return franchisedOutletProvinceCenter;
		}
		if(externalCatalogList.isEmpty()){
			return franchisedOutletProvinceCenter;
		}
		
		for(Catalog catalogItem: externalCatalogList){

			catalogItem.clearFromAll();
		}
		
		
		SmartList<Catalog> catalogList = franchisedOutletProvinceCenter.getCatalogList();		
		catalogList.addAllToRemoveList(externalCatalogList);
		return franchisedOutletProvinceCenter;	
	
	}



		
	protected FranchisedOutletProvinceCenter saveCatalogList(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, Map<String,Object> options){
		
		
		
		
		SmartList<Catalog> catalogList = franchisedOutletProvinceCenter.getCatalogList();
		if(catalogList == null){
			//null list means nothing
			return franchisedOutletProvinceCenter;
		}
		SmartList<Catalog> mergedUpdateCatalogList = new SmartList<Catalog>();
		
		
		mergedUpdateCatalogList.addAll(catalogList); 
		if(catalogList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCatalogList.addAll(catalogList.getToRemoveList());
			catalogList.removeAll(catalogList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCatalogDAO().saveCatalogList(mergedUpdateCatalogList,options);
		
		if(catalogList.getToRemoveList() != null){
			catalogList.removeAll(catalogList.getToRemoveList());
		}
		
		
		return franchisedOutletProvinceCenter;
	
	}
	
	protected FranchisedOutletProvinceCenter removeCatalogList(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, Map<String,Object> options){
	
	
		SmartList<Catalog> catalogList = franchisedOutletProvinceCenter.getCatalogList();
		if(catalogList == null){
			return franchisedOutletProvinceCenter;
		}	
	
		SmartList<Catalog> toRemoveCatalogList = catalogList.getToRemoveList();
		
		if(toRemoveCatalogList == null){
			return franchisedOutletProvinceCenter;
		}
		if(toRemoveCatalogList.isEmpty()){
			return franchisedOutletProvinceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCatalogDAO().removeCatalogList(toRemoveCatalogList,options);
		
		return franchisedOutletProvinceCenter;
	
	}
	
	

 	
 	
	
	
	
		

	public FranchisedOutletProvinceCenter present(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter,Map<String, Object> options){
	
		presentCatalogList(franchisedOutletProvinceCenter,options);

		return franchisedOutletProvinceCenter;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected FranchisedOutletProvinceCenter presentCatalogList(
			FranchisedOutletProvinceCenter franchisedOutletProvinceCenter,
			Map<String, Object> options) {

		SmartList<Catalog> catalogList = franchisedOutletProvinceCenter.getCatalogList();		
				SmartList<Catalog> newList= presentSubList(franchisedOutletProvinceCenter.getId(),
				catalogList,
				options,
				getCatalogDAO()::countCatalogByOwner,
				getCatalogDAO()::findCatalogByOwner
				);

		
		franchisedOutletProvinceCenter.setCatalogList(newList);
		

		return franchisedOutletProvinceCenter;
	}			
		

	
    public SmartList<FranchisedOutletProvinceCenter> requestCandidateFranchisedOutletProvinceCenterForCatalog(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(FranchisedOutletProvinceCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getFranchisedOutletProvinceCenterMapper());
    }
		

	protected String getTableName(){
		return FranchisedOutletProvinceCenterTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList) {		
		this.enhanceListInternal(franchisedOutletProvinceCenterList, this.getFranchisedOutletProvinceCenterMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Catalog的owner的CatalogList
	public SmartList<Catalog> loadOurCatalogList(XingyouUserContext userContext, List<FranchisedOutletProvinceCenter> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Catalog> loadedObjs = userContext.getDAOGroup().getCatalogDAO().findCatalogWithKey(key, options);
		Map<String, List<Catalog>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Catalog> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Catalog> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setCatalogList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<FranchisedOutletProvinceCenter> franchisedOutletProvinceCenterList = ownerEntity.collectRefsWithType(FranchisedOutletProvinceCenter.INTERNAL_TYPE);
		this.enhanceList(franchisedOutletProvinceCenterList);
		
	}
	
	@Override
	public SmartList<FranchisedOutletProvinceCenter> findFranchisedOutletProvinceCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getFranchisedOutletProvinceCenterMapper());

	}
	@Override
	public int countFranchisedOutletProvinceCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countFranchisedOutletProvinceCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<FranchisedOutletProvinceCenter> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getFranchisedOutletProvinceCenterMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateFranchisedOutletProvinceCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateFranchisedOutletProvinceCenter result = new CandidateFranchisedOutletProvinceCenter();
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
	
	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplateObject().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = (String) data.get("id");
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplateObject().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplateObject().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplateObject().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplateObject().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplateObject().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplateObject().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplateObject().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplateObject().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplateObject().execute(sql);
	}


}


