
package com.youbenben.youbenben.potentialcustomer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.youbenben.youbenben.citypartner.CityPartner;
import com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContact;
import com.youbenben.youbenben.eventattendance.EventAttendance;

import com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContactDAO;
import com.youbenben.youbenben.eventattendance.EventAttendanceDAO;
import com.youbenben.youbenben.citypartner.CityPartnerDAO;
import com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPersonDAO;


public interface PotentialCustomerDAO extends BaseDAO{

	public SmartList<PotentialCustomer> loadAll();
	public PotentialCustomer load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PotentialCustomer> potentialCustomerList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public PotentialCustomer present(PotentialCustomer potentialCustomer,Map<String,Object> options) throws Exception;
	public PotentialCustomer clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PotentialCustomer save(PotentialCustomer potentialCustomer,Map<String,Object> options);
	public SmartList<PotentialCustomer> savePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList,Map<String,Object> options);
	public SmartList<PotentialCustomer> removePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList,Map<String,Object> options);
	public SmartList<PotentialCustomer> findPotentialCustomerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPotentialCustomerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPotentialCustomerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String potentialCustomerId, int version) throws Exception;
	public PotentialCustomer disconnectFromAll(String potentialCustomerId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public PotentialCustomerContactPersonDAO getPotentialCustomerContactPersonDAO();
		
	public PotentialCustomerContactDAO getPotentialCustomerContactDAO();
		
	public EventAttendanceDAO getEventAttendanceDAO();
		
	
 	public SmartList<PotentialCustomer> requestCandidatePotentialCustomerForPotentialCustomerContactPerson(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<PotentialCustomer> requestCandidatePotentialCustomerForPotentialCustomerContact(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<PotentialCustomer> requestCandidatePotentialCustomerForEventAttendance(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public PotentialCustomer planToRemovePotentialCustomerContactPersonList(PotentialCustomer potentialCustomer, String potentialCustomerContactPersonIds[], Map<String,Object> options)throws Exception;


	public PotentialCustomer planToRemovePotentialCustomerContactList(PotentialCustomer potentialCustomer, String potentialCustomerContactIds[], Map<String,Object> options)throws Exception;


	//disconnect PotentialCustomer with city_partner in PotentialCustomerContact
	public PotentialCustomer planToRemovePotentialCustomerContactListWithCityPartner(PotentialCustomer potentialCustomer, String cityPartnerId, Map<String,Object> options)throws Exception;
	public int countPotentialCustomerContactListWithCityPartner(String potentialCustomerId, String cityPartnerId, Map<String,Object> options)throws Exception;
	
	//disconnect PotentialCustomer with contact_to in PotentialCustomerContact
	public PotentialCustomer planToRemovePotentialCustomerContactListWithContactTo(PotentialCustomer potentialCustomer, String contactToId, Map<String,Object> options)throws Exception;
	public int countPotentialCustomerContactListWithContactTo(String potentialCustomerId, String contactToId, Map<String,Object> options)throws Exception;
	
	public PotentialCustomer planToRemoveEventAttendanceList(PotentialCustomer potentialCustomer, String eventAttendanceIds[], Map<String,Object> options)throws Exception;


	//disconnect PotentialCustomer with city_event in EventAttendance
	public PotentialCustomer planToRemoveEventAttendanceListWithCityEvent(PotentialCustomer potentialCustomer, String cityEventId, Map<String,Object> options)throws Exception;
	public int countEventAttendanceListWithCityEvent(String potentialCustomerId, String cityEventId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<PotentialCustomer> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidatePotentialCustomer executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public int countPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public Map<String, Integer> countPotentialCustomerByCityServiceCenterIds(String[] ids, Map<String,Object> options);
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count, Map<String,Object> options);
 	public void analyzePotentialCustomerByCityServiceCenter(SmartList<PotentialCustomer> resultList, String retailStoreCityServiceCenterId, Map<String,Object> options);

 
  
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityPartner(String cityPartnerId, Map<String,Object> options);
 	public int countPotentialCustomerByCityPartner(String cityPartnerId, Map<String,Object> options);
 	public Map<String, Integer> countPotentialCustomerByCityPartnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityPartner(String cityPartnerId, int start, int count, Map<String,Object> options);
 	public void analyzePotentialCustomerByCityPartner(SmartList<PotentialCustomer> resultList, String cityPartnerId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomerContactPerson的potentialCustomer的PotentialCustomerContactPersonList
	public SmartList<PotentialCustomerContactPerson> loadOurPotentialCustomerContactPersonList(YoubenbenUserContext userContext, List<PotentialCustomer> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomerContact的potentialCustomer的PotentialCustomerContactList
	public SmartList<PotentialCustomerContact> loadOurPotentialCustomerContactList(YoubenbenUserContext userContext, List<PotentialCustomer> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EventAttendance的potentialCustomer的EventAttendanceList
	public SmartList<EventAttendance> loadOurEventAttendanceList(YoubenbenUserContext userContext, List<PotentialCustomer> us, Map<String,Object> options) throws Exception;
	
}


