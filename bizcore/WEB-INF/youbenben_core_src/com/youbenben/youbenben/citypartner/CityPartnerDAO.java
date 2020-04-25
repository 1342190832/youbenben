
package com.youbenben.youbenben.citypartner;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.potentialcustomer.PotentialCustomer;
import com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContact;

import com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.youbenben.youbenben.potentialcustomercontact.PotentialCustomerContactDAO;
import com.youbenben.youbenben.potentialcustomer.PotentialCustomerDAO;


public interface CityPartnerDAO extends BaseDAO{

	public SmartList<CityPartner> loadAll();
	public CityPartner load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<CityPartner> cityPartnerList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public CityPartner present(CityPartner cityPartner,Map<String,Object> options) throws Exception;
	public CityPartner clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CityPartner save(CityPartner cityPartner,Map<String,Object> options);
	public SmartList<CityPartner> saveCityPartnerList(SmartList<CityPartner> cityPartnerList,Map<String,Object> options);
	public SmartList<CityPartner> removeCityPartnerList(SmartList<CityPartner> cityPartnerList,Map<String,Object> options);
	public SmartList<CityPartner> findCityPartnerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCityPartnerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCityPartnerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String cityPartnerId, int version) throws Exception;
	public CityPartner disconnectFromAll(String cityPartnerId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public PotentialCustomerDAO getPotentialCustomerDAO();
		
	public PotentialCustomerContactDAO getPotentialCustomerContactDAO();
		
	
 	public SmartList<CityPartner> requestCandidateCityPartnerForPotentialCustomer(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<CityPartner> requestCandidateCityPartnerForPotentialCustomerContact(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public CityPartner planToRemovePotentialCustomerList(CityPartner cityPartner, String potentialCustomerIds[], Map<String,Object> options)throws Exception;


	//disconnect CityPartner with city_service_center in PotentialCustomer
	public CityPartner planToRemovePotentialCustomerListWithCityServiceCenter(CityPartner cityPartner, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	public int countPotentialCustomerListWithCityServiceCenter(String cityPartnerId, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	
	public CityPartner planToRemovePotentialCustomerContactList(CityPartner cityPartner, String potentialCustomerContactIds[], Map<String,Object> options)throws Exception;


	//disconnect CityPartner with potential_customer in PotentialCustomerContact
	public CityPartner planToRemovePotentialCustomerContactListWithPotentialCustomer(CityPartner cityPartner, String potentialCustomerId, Map<String,Object> options)throws Exception;
	public int countPotentialCustomerContactListWithPotentialCustomer(String cityPartnerId, String potentialCustomerId, Map<String,Object> options)throws Exception;
	
	//disconnect CityPartner with contact_to in PotentialCustomerContact
	public CityPartner planToRemovePotentialCustomerContactListWithContactTo(CityPartner cityPartner, String contactToId, Map<String,Object> options)throws Exception;
	public int countPotentialCustomerContactListWithContactTo(String cityPartnerId, String contactToId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<CityPartner> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateCityPartner executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<CityPartner> findCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public int countCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public Map<String, Integer> countCityPartnerByCityServiceCenterIds(String[] ids, Map<String,Object> options);
 	public SmartList<CityPartner> findCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeCityPartnerByCityServiceCenter(SmartList<CityPartner> resultList, String retailStoreCityServiceCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomer的cityPartner的PotentialCustomerList
	public SmartList<PotentialCustomer> loadOurPotentialCustomerList(YoubenbenUserContext userContext, List<CityPartner> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomerContact的cityPartner的PotentialCustomerContactList
	public SmartList<PotentialCustomerContact> loadOurPotentialCustomerContactList(YoubenbenUserContext userContext, List<CityPartner> us, Map<String,Object> options) throws Exception;
	
}


