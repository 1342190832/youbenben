
package com.youbenben.youbenben.supplyorderdelivery;

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


import com.youbenben.youbenben.supplyorder.SupplyOrder;
import com.youbenben.youbenben.consumerorder.ConsumerOrder;

import com.youbenben.youbenben.consumerorder.ConsumerOrderDAO;
import com.youbenben.youbenben.supplyorder.SupplyOrderDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class SupplyOrderDeliveryJDBCTemplateDAO extends YoubenbenBaseDAOImpl implements SupplyOrderDeliveryDAO{

	protected ConsumerOrderDAO consumerOrderDAO;
	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){
 	
 		if(consumerOrderDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderDAO to null.");
 		}
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
 		if(this.consumerOrderDAO == null){
 			throw new IllegalStateException("The consumerOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderDAO;
 	}	

	protected SupplyOrderDAO supplyOrderDAO;
	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){
 	
 		if(supplyOrderDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderDAO to null.");
 		}
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
 		if(this.supplyOrderDAO == null){
 			throw new IllegalStateException("The supplyOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderDAO;
 	}	

	
	/*
	protected SupplyOrderDelivery load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderDelivery(accessKey, options);
	}
	*/
	
	public SmartList<SupplyOrderDelivery> loadAll() {
	    return this.loadAll(getSupplyOrderDeliveryMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SupplyOrderDelivery load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderDelivery(SupplyOrderDeliveryTable.withId(id), options);
	}
	
	
	
	public SupplyOrderDelivery save(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options){
		
		String methodName="save(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderDelivery, methodName, "supplyOrderDelivery");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderDelivery(supplyOrderDelivery,options);
	}
	public SupplyOrderDelivery clone(String supplyOrderDeliveryId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderDeliveryTable.withId(supplyOrderDeliveryId),options);
	}
	
	protected SupplyOrderDelivery clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderDeliveryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderDelivery newSupplyOrderDelivery = loadInternalSupplyOrderDelivery(accessKey, options);
		newSupplyOrderDelivery.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newSupplyOrderDelivery.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderDelivery.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderDelivery(newSupplyOrderDelivery,options);
		
		return newSupplyOrderDelivery;
	}
	
	
	
	

	protected void throwIfHasException(String supplyOrderDeliveryId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplyOrderDeliveryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderDeliveryNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderDeliveryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String supplyOrderDeliveryId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderDeliveryId, int version)";
		assertMethodArgumentNotNull(supplyOrderDeliveryId, methodName, "supplyOrderDeliveryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderDeliveryId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderDeliveryId,version);
		}
		
	
	}
	
	
	
	
	

	public SupplyOrderDelivery disconnectFromAll(String supplyOrderDeliveryId, int version) throws Exception{
	
		
		SupplyOrderDelivery supplyOrderDelivery = loadInternalSupplyOrderDelivery(SupplyOrderDeliveryTable.withId(supplyOrderDeliveryId), emptyOptions());
		supplyOrderDelivery.clearFromAll();
		this.saveSupplyOrderDelivery(supplyOrderDelivery);
		return supplyOrderDelivery;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SupplyOrderDeliveryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_delivery";
	}
	@Override
	protected String getBeanName() {
		
		return "supplyOrderDelivery";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderDeliveryTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SupplyOrderDeliveryTokens.CONSUMER_ORDER_LIST);
 	}
 	protected boolean isAnalyzeConsumerOrderListEnabled(Map<String,Object> options){		 		
 		return SupplyOrderDeliveryTokens.of(options).analyzeConsumerOrderListEnabled();
 	}
	
	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderDeliveryTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SupplyOrderDeliveryTokens.SUPPLY_ORDER_LIST);
 	}
 	protected boolean isAnalyzeSupplyOrderListEnabled(Map<String,Object> options){		 		
 		return SupplyOrderDeliveryTokens.of(options).analyzeSupplyOrderListEnabled();
 	}
	
	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderDeliveryTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
		

	

	protected SupplyOrderDeliveryMapper getSupplyOrderDeliveryMapper(){
		return new SupplyOrderDeliveryMapper();
	}

	
	
	protected SupplyOrderDelivery extractSupplyOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplyOrderDelivery supplyOrderDelivery = loadSingleObject(accessKey, getSupplyOrderDeliveryMapper());
			return supplyOrderDelivery;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderDeliveryNotFoundException("SupplyOrderDelivery("+accessKey+") is not found!");
		}

	}

	
	

	protected SupplyOrderDelivery loadInternalSupplyOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderDelivery supplyOrderDelivery = extractSupplyOrderDelivery(accessKey, loadOptions);

		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(supplyOrderDelivery, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeConsumerOrderListEnabled(loadOptions)){
	 		analyzeConsumerOrderList(supplyOrderDelivery, loadOptions);
 		}
 		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderDelivery, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeSupplyOrderListEnabled(loadOptions)){
	 		analyzeSupplyOrderList(supplyOrderDelivery, loadOptions);
 		}
 		
		
		return supplyOrderDelivery;
		
	}

	
		
	protected void enhanceConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SupplyOrderDelivery extractConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		if(supplyOrderDelivery == null){
			return null;
		}
		if(supplyOrderDelivery.getId() == null){
			return supplyOrderDelivery;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByDelivery(supplyOrderDelivery.getId(),options);
		if(consumerOrderList != null){
			enhanceConsumerOrderList(consumerOrderList,options);
			supplyOrderDelivery.setConsumerOrderList(consumerOrderList);
		}
		
		return supplyOrderDelivery;
	
	}	
	
	protected SupplyOrderDelivery analyzeConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		if(supplyOrderDelivery == null){
			return null;
		}
		if(supplyOrderDelivery.getId() == null){
			return supplyOrderDelivery;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();
		if(consumerOrderList != null){
			getConsumerOrderDAO().analyzeConsumerOrderByDelivery(consumerOrderList, supplyOrderDelivery.getId(), options);
			
		}
		
		return supplyOrderDelivery;
	
	}	
	
		
	protected void enhanceSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SupplyOrderDelivery extractSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		if(supplyOrderDelivery == null){
			return null;
		}
		if(supplyOrderDelivery.getId() == null){
			return supplyOrderDelivery;
		}

		
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByDelivery(supplyOrderDelivery.getId(),options);
		if(supplyOrderList != null){
			enhanceSupplyOrderList(supplyOrderList,options);
			supplyOrderDelivery.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderDelivery;
	
	}	
	
	protected SupplyOrderDelivery analyzeSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		if(supplyOrderDelivery == null){
			return null;
		}
		if(supplyOrderDelivery.getId() == null){
			return supplyOrderDelivery;
		}

		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();
		if(supplyOrderList != null){
			getSupplyOrderDAO().analyzeSupplyOrderByDelivery(supplyOrderList, supplyOrderDelivery.getId(), options);
			
		}
		
		return supplyOrderDelivery;
	
	}	
	
		
		
 	
		
		
		

	

	protected SupplyOrderDelivery saveSupplyOrderDelivery(SupplyOrderDelivery  supplyOrderDelivery){
		
		if(!supplyOrderDelivery.isChanged()){
			return supplyOrderDelivery;
		}
		
		
		String SQL=this.getSaveSupplyOrderDeliverySQL(supplyOrderDelivery);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderDeliveryParameters(supplyOrderDelivery);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderDelivery.incVersion();
		return supplyOrderDelivery;
	
	}
	public SmartList<SupplyOrderDelivery> saveSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderDeliveryList(supplyOrderDeliveryList);
		
		batchSupplyOrderDeliveryCreate((List<SupplyOrderDelivery>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderDeliveryUpdate((List<SupplyOrderDelivery>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderDelivery supplyOrderDelivery:supplyOrderDeliveryList){
			if(supplyOrderDelivery.isChanged()){
				supplyOrderDelivery.incVersion();
			}
			
		
		}
		
		
		return supplyOrderDeliveryList;
	}

	public SmartList<SupplyOrderDelivery> removeSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderDeliveryList, options);
		
		return supplyOrderDeliveryList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderDeliveryBatchCreateArgs(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderDelivery supplyOrderDelivery:supplyOrderDeliveryList ){
			Object [] parameters = prepareSupplyOrderDeliveryCreateParameters(supplyOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderDeliveryBatchUpdateArgs(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderDelivery supplyOrderDelivery:supplyOrderDeliveryList ){
			if(!supplyOrderDelivery.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderDeliveryUpdateParameters(supplyOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderDeliveryCreate(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderDeliveryBatchCreateArgs(supplyOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderDeliveryUpdate(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderDeliveryBatchUpdateArgs(supplyOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderDeliveryList(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		
		List<SupplyOrderDelivery> supplyOrderDeliveryCreateList=new ArrayList<SupplyOrderDelivery>();
		List<SupplyOrderDelivery> supplyOrderDeliveryUpdateList=new ArrayList<SupplyOrderDelivery>();
		
		for(SupplyOrderDelivery supplyOrderDelivery: supplyOrderDeliveryList){
			if(isUpdateRequest(supplyOrderDelivery)){
				supplyOrderDeliveryUpdateList.add( supplyOrderDelivery);
				continue;
			}
			supplyOrderDeliveryCreateList.add(supplyOrderDelivery);
		}
		
		return new Object[]{supplyOrderDeliveryCreateList,supplyOrderDeliveryUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderDelivery supplyOrderDelivery){
 		return supplyOrderDelivery.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderDeliverySQL(SupplyOrderDelivery supplyOrderDelivery){
 		if(isUpdateRequest(supplyOrderDelivery)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderDeliveryParameters(SupplyOrderDelivery supplyOrderDelivery){
 		if(isUpdateRequest(supplyOrderDelivery) ){
 			return prepareSupplyOrderDeliveryUpdateParameters(supplyOrderDelivery);
 		}
 		return prepareSupplyOrderDeliveryCreateParameters(supplyOrderDelivery);
 	}
 	protected Object[] prepareSupplyOrderDeliveryUpdateParameters(SupplyOrderDelivery supplyOrderDelivery){
 		Object[] parameters = new Object[5];
 
 		
 		parameters[0] = supplyOrderDelivery.getWho();
 		
 		
 		parameters[1] = supplyOrderDelivery.getDeliveryTime();
 				
 		parameters[2] = supplyOrderDelivery.nextVersion();
 		parameters[3] = supplyOrderDelivery.getId();
 		parameters[4] = supplyOrderDelivery.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderDeliveryCreateParameters(SupplyOrderDelivery supplyOrderDelivery){
		Object[] parameters = new Object[3];
		String newSupplyOrderDeliveryId=getNextId();
		supplyOrderDelivery.setId(newSupplyOrderDeliveryId);
		parameters[0] =  supplyOrderDelivery.getId();
 
 		
 		parameters[1] = supplyOrderDelivery.getWho();
 		
 		
 		parameters[2] = supplyOrderDelivery.getDeliveryTime();
 				
 				
 		return parameters;
 	}
 	
	protected SupplyOrderDelivery saveInternalSupplyOrderDelivery(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		saveSupplyOrderDelivery(supplyOrderDelivery);

		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(supplyOrderDelivery, options);
	 		//removeConsumerOrderList(supplyOrderDelivery, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderDelivery, options);
	 		//removeSupplyOrderList(supplyOrderDelivery, options);
	 		//Not delete the record
	 		
 		}		
		
		return supplyOrderDelivery;
		
	}
	
	
	
	//======================================================================================
	

	
	public SupplyOrderDelivery planToRemoveConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, String consumerOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(ConsumerOrder.ID_PROPERTY, consumerOrderIds);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(ConsumerOrder consumerOrderItem: externalConsumerOrderList){

			consumerOrderItem.clearFromAll();
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderDelivery;	
	
	}


	//disconnect SupplyOrderDelivery with consumer in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithConsumer(SupplyOrderDelivery supplyOrderDelivery, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(ConsumerOrder consumerOrderItem: externalConsumerOrderList){
			consumerOrderItem.clearConsumer();
			consumerOrderItem.clearDelivery();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderDelivery;
	}
	
	public int countConsumerOrderListWithConsumer(String supplyOrderDeliveryId, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with confirmation in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithConfirmation(SupplyOrderDelivery supplyOrderDelivery, String confirmationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(ConsumerOrder.CONFIRMATION_PROPERTY, confirmationId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(ConsumerOrder consumerOrderItem: externalConsumerOrderList){
			consumerOrderItem.clearConfirmation();
			consumerOrderItem.clearDelivery();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderDelivery;
	}
	
	public int countConsumerOrderListWithConfirmation(String supplyOrderDeliveryId, String confirmationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(ConsumerOrder.CONFIRMATION_PROPERTY, confirmationId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with approval in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithApproval(SupplyOrderDelivery supplyOrderDelivery, String approvalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(ConsumerOrder.APPROVAL_PROPERTY, approvalId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(ConsumerOrder consumerOrderItem: externalConsumerOrderList){
			consumerOrderItem.clearApproval();
			consumerOrderItem.clearDelivery();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderDelivery;
	}
	
	public int countConsumerOrderListWithApproval(String supplyOrderDeliveryId, String approvalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(ConsumerOrder.APPROVAL_PROPERTY, approvalId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with processing in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithProcessing(SupplyOrderDelivery supplyOrderDelivery, String processingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(ConsumerOrder.PROCESSING_PROPERTY, processingId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(ConsumerOrder consumerOrderItem: externalConsumerOrderList){
			consumerOrderItem.clearProcessing();
			consumerOrderItem.clearDelivery();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderDelivery;
	}
	
	public int countConsumerOrderListWithProcessing(String supplyOrderDeliveryId, String processingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(ConsumerOrder.PROCESSING_PROPERTY, processingId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with shipment in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithShipment(SupplyOrderDelivery supplyOrderDelivery, String shipmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(ConsumerOrder.SHIPMENT_PROPERTY, shipmentId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(ConsumerOrder consumerOrderItem: externalConsumerOrderList){
			consumerOrderItem.clearShipment();
			consumerOrderItem.clearDelivery();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderDelivery;
	}
	
	public int countConsumerOrderListWithShipment(String supplyOrderDeliveryId, String shipmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(ConsumerOrder.SHIPMENT_PROPERTY, shipmentId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with store in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithStore(SupplyOrderDelivery supplyOrderDelivery, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(ConsumerOrder consumerOrderItem: externalConsumerOrderList){
			consumerOrderItem.clearStore();
			consumerOrderItem.clearDelivery();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderDelivery;
	}
	
	public int countConsumerOrderListWithStore(String supplyOrderDeliveryId, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	public SupplyOrderDelivery planToRemoveSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, String supplyOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(SupplyOrder.ID_PROPERTY, supplyOrderIds);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(SupplyOrder supplyOrderItem: externalSupplyOrderList){

			supplyOrderItem.clearFromAll();
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderDelivery;	
	
	}


	//disconnect SupplyOrderDelivery with buyer in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithBuyer(SupplyOrderDelivery supplyOrderDelivery, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(SupplyOrder supplyOrderItem: externalSupplyOrderList){
			supplyOrderItem.clearBuyer();
			supplyOrderItem.clearDelivery();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderDelivery;
	}
	
	public int countSupplyOrderListWithBuyer(String supplyOrderDeliveryId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with seller in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithSeller(SupplyOrderDelivery supplyOrderDelivery, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(SupplyOrder supplyOrderItem: externalSupplyOrderList){
			supplyOrderItem.clearSeller();
			supplyOrderItem.clearDelivery();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderDelivery;
	}
	
	public int countSupplyOrderListWithSeller(String supplyOrderDeliveryId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with confirmation in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithConfirmation(SupplyOrderDelivery supplyOrderDelivery, String confirmationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(SupplyOrder.CONFIRMATION_PROPERTY, confirmationId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(SupplyOrder supplyOrderItem: externalSupplyOrderList){
			supplyOrderItem.clearConfirmation();
			supplyOrderItem.clearDelivery();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderDelivery;
	}
	
	public int countSupplyOrderListWithConfirmation(String supplyOrderDeliveryId, String confirmationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(SupplyOrder.CONFIRMATION_PROPERTY, confirmationId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with approval in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithApproval(SupplyOrderDelivery supplyOrderDelivery, String approvalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(SupplyOrder.APPROVAL_PROPERTY, approvalId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(SupplyOrder supplyOrderItem: externalSupplyOrderList){
			supplyOrderItem.clearApproval();
			supplyOrderItem.clearDelivery();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderDelivery;
	}
	
	public int countSupplyOrderListWithApproval(String supplyOrderDeliveryId, String approvalId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(SupplyOrder.APPROVAL_PROPERTY, approvalId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with processing in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithProcessing(SupplyOrderDelivery supplyOrderDelivery, String processingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(SupplyOrder.PROCESSING_PROPERTY, processingId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(SupplyOrder supplyOrderItem: externalSupplyOrderList){
			supplyOrderItem.clearProcessing();
			supplyOrderItem.clearDelivery();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderDelivery;
	}
	
	public int countSupplyOrderListWithProcessing(String supplyOrderDeliveryId, String processingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(SupplyOrder.PROCESSING_PROPERTY, processingId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with picking in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithPicking(SupplyOrderDelivery supplyOrderDelivery, String pickingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(SupplyOrder.PICKING_PROPERTY, pickingId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(SupplyOrder supplyOrderItem: externalSupplyOrderList){
			supplyOrderItem.clearPicking();
			supplyOrderItem.clearDelivery();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderDelivery;
	}
	
	public int countSupplyOrderListWithPicking(String supplyOrderDeliveryId, String pickingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(SupplyOrder.PICKING_PROPERTY, pickingId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with shipment in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithShipment(SupplyOrderDelivery supplyOrderDelivery, String shipmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(SupplyOrder.SHIPMENT_PROPERTY, shipmentId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(SupplyOrder supplyOrderItem: externalSupplyOrderList){
			supplyOrderItem.clearShipment();
			supplyOrderItem.clearDelivery();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderDelivery;
	}
	
	public int countSupplyOrderListWithShipment(String supplyOrderDeliveryId, String shipmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(SupplyOrder.SHIPMENT_PROPERTY, shipmentId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	

		
	protected SupplyOrderDelivery saveConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();
		if(consumerOrderList == null){
			//null list means nothing
			return supplyOrderDelivery;
		}
		SmartList<ConsumerOrder> mergedUpdateConsumerOrderList = new SmartList<ConsumerOrder>();
		
		
		mergedUpdateConsumerOrderList.addAll(consumerOrderList); 
		if(consumerOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateConsumerOrderList.addAll(consumerOrderList.getToRemoveList());
			consumerOrderList.removeAll(consumerOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getConsumerOrderDAO().saveConsumerOrderList(mergedUpdateConsumerOrderList,options);
		
		if(consumerOrderList.getToRemoveList() != null){
			consumerOrderList.removeAll(consumerOrderList.getToRemoveList());
		}
		
		
		return supplyOrderDelivery;
	
	}
	
	protected SupplyOrderDelivery removeConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderDelivery;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return supplyOrderDelivery;
	
	}
	
	

 	
 	
	
	
	
		
	protected SupplyOrderDelivery saveSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();
		if(supplyOrderList == null){
			//null list means nothing
			return supplyOrderDelivery;
		}
		SmartList<SupplyOrder> mergedUpdateSupplyOrderList = new SmartList<SupplyOrder>();
		
		
		mergedUpdateSupplyOrderList.addAll(supplyOrderList); 
		if(supplyOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSupplyOrderList.addAll(supplyOrderList.getToRemoveList());
			supplyOrderList.removeAll(supplyOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getSupplyOrderDAO().saveSupplyOrderList(mergedUpdateSupplyOrderList,options);
		
		if(supplyOrderList.getToRemoveList() != null){
			supplyOrderList.removeAll(supplyOrderList.getToRemoveList());
		}
		
		
		return supplyOrderDelivery;
	
	}
	
	protected SupplyOrderDelivery removeSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderDelivery;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderDelivery;
	
	}
	
	

 	
 	
	
	
	
		

	public SupplyOrderDelivery present(SupplyOrderDelivery supplyOrderDelivery,Map<String, Object> options){
	
		presentConsumerOrderList(supplyOrderDelivery,options);
		presentSupplyOrderList(supplyOrderDelivery,options);

		return supplyOrderDelivery;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderDelivery presentConsumerOrderList(
			SupplyOrderDelivery supplyOrderDelivery,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
				SmartList<ConsumerOrder> newList= presentSubList(supplyOrderDelivery.getId(),
				consumerOrderList,
				options,
				getConsumerOrderDAO()::countConsumerOrderByDelivery,
				getConsumerOrderDAO()::findConsumerOrderByDelivery
				);

		
		supplyOrderDelivery.setConsumerOrderList(newList);
		

		return supplyOrderDelivery;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderDelivery presentSupplyOrderList(
			SupplyOrderDelivery supplyOrderDelivery,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
				SmartList<SupplyOrder> newList= presentSubList(supplyOrderDelivery.getId(),
				supplyOrderList,
				options,
				getSupplyOrderDAO()::countSupplyOrderByDelivery,
				getSupplyOrderDAO()::findSupplyOrderByDelivery
				);

		
		supplyOrderDelivery.setSupplyOrderList(newList);
		

		return supplyOrderDelivery;
	}			
		

	
    public SmartList<SupplyOrderDelivery> requestCandidateSupplyOrderDeliveryForConsumerOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderDeliveryTable.COLUMN_WHO, null, filterKey, pageNo, pageSize, getSupplyOrderDeliveryMapper());
    }
		
    public SmartList<SupplyOrderDelivery> requestCandidateSupplyOrderDeliveryForSupplyOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderDeliveryTable.COLUMN_WHO, null, filterKey, pageNo, pageSize, getSupplyOrderDeliveryMapper());
    }
		

	protected String getTableName(){
		return SupplyOrderDeliveryTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SupplyOrderDelivery> supplyOrderDeliveryList) {		
		this.enhanceListInternal(supplyOrderDeliveryList, this.getSupplyOrderDeliveryMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ConsumerOrder的delivery的ConsumerOrderList
	public SmartList<ConsumerOrder> loadOurConsumerOrderList(YoubenbenUserContext userContext, List<SupplyOrderDelivery> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ConsumerOrder> loadedObjs = userContext.getDAOGroup().getConsumerOrderDAO().findConsumerOrderWithKey(key, options);
		Map<String, List<ConsumerOrder>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getDelivery().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ConsumerOrder> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ConsumerOrder> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setConsumerOrderList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrder的delivery的SupplyOrderList
	public SmartList<SupplyOrder> loadOurSupplyOrderList(YoubenbenUserContext userContext, List<SupplyOrderDelivery> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<SupplyOrder> loadedObjs = userContext.getDAOGroup().getSupplyOrderDAO().findSupplyOrderWithKey(key, options);
		Map<String, List<SupplyOrder>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getDelivery().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<SupplyOrder> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<SupplyOrder> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setSupplyOrderList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplyOrderDelivery> supplyOrderDeliveryList = ownerEntity.collectRefsWithType(SupplyOrderDelivery.INTERNAL_TYPE);
		this.enhanceList(supplyOrderDeliveryList);
		
	}
	
	@Override
	public SmartList<SupplyOrderDelivery> findSupplyOrderDeliveryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSupplyOrderDeliveryMapper());

	}
	@Override
	public int countSupplyOrderDeliveryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplyOrderDeliveryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SupplyOrderDelivery> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplyOrderDeliveryMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateSupplyOrderDelivery executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateSupplyOrderDelivery result = new CandidateSupplyOrderDelivery();
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


