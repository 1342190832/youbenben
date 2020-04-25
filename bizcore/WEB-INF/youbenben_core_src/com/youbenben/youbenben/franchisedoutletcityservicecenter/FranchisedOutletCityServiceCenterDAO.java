
package com.youbenben.youbenben.franchisedoutletcityservicecenter;
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
import com.youbenben.youbenben.citypartner.CityPartner;
import com.youbenben.youbenben.cityevent.CityEvent;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;

import com.youbenben.youbenben.cityevent.CityEventDAO;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO;
import com.youbenben.youbenben.potentialcustomer.PotentialCustomerDAO;
import com.youbenben.youbenben.citypartner.CityPartnerDAO;


public interface FranchisedOutletCityServiceCenterDAO extends BaseDAO{

	public SmartList<FranchisedOutletCityServiceCenter> loadAll();
	public FranchisedOutletCityServiceCenter load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public FranchisedOutletCityServiceCenter present(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter,Map<String,Object> options) throws Exception;
	public FranchisedOutletCityServiceCenter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public FranchisedOutletCityServiceCenter save(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter,Map<String,Object> options);
	public SmartList<FranchisedOutletCityServiceCenter> saveFranchisedOutletCityServiceCenterList(SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList,Map<String,Object> options);
	public SmartList<FranchisedOutletCityServiceCenter> removeFranchisedOutletCityServiceCenterList(SmartList<FranchisedOutletCityServiceCenter> franchisedOutletCityServiceCenterList,Map<String,Object> options);
	public SmartList<FranchisedOutletCityServiceCenter> findFranchisedOutletCityServiceCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countFranchisedOutletCityServiceCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countFranchisedOutletCityServiceCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String franchisedOutletCityServiceCenterId, int version) throws Exception;
	public FranchisedOutletCityServiceCenter disconnectFromAll(String franchisedOutletCityServiceCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public CityPartnerDAO getCityPartnerDAO();
		
	public PotentialCustomerDAO getPotentialCustomerDAO();
		
	public CityEventDAO getCityEventDAO();
		
	
 	public SmartList<FranchisedOutletCityServiceCenter> requestCandidateFranchisedOutletCityServiceCenterForCityPartner(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<FranchisedOutletCityServiceCenter> requestCandidateFranchisedOutletCityServiceCenterForPotentialCustomer(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<FranchisedOutletCityServiceCenter> requestCandidateFranchisedOutletCityServiceCenterForCityEvent(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public FranchisedOutletCityServiceCenter planToRemoveCityPartnerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, String cityPartnerIds[], Map<String,Object> options)throws Exception;


	public FranchisedOutletCityServiceCenter planToRemovePotentialCustomerList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, String potentialCustomerIds[], Map<String,Object> options)throws Exception;


	//disconnect FranchisedOutletCityServiceCenter with city_partner in PotentialCustomer
	public FranchisedOutletCityServiceCenter planToRemovePotentialCustomerListWithCityPartner(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, String cityPartnerId, Map<String,Object> options)throws Exception;
	public int countPotentialCustomerListWithCityPartner(String franchisedOutletCityServiceCenterId, String cityPartnerId, Map<String,Object> options)throws Exception;
	
	public FranchisedOutletCityServiceCenter planToRemoveCityEventList(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, String cityEventIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<FranchisedOutletCityServiceCenter> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateFranchisedOutletCityServiceCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<FranchisedOutletCityServiceCenter> findFranchisedOutletCityServiceCenterByBelongsTo(String franchisedOutletCityCenterId, Map<String,Object> options);
 	public int countFranchisedOutletCityServiceCenterByBelongsTo(String franchisedOutletCityCenterId, Map<String,Object> options);
 	public Map<String, Integer> countFranchisedOutletCityServiceCenterByBelongsToIds(String[] ids, Map<String,Object> options);
 	public SmartList<FranchisedOutletCityServiceCenter> findFranchisedOutletCityServiceCenterByBelongsTo(String franchisedOutletCityCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeFranchisedOutletCityServiceCenterByBelongsTo(SmartList<FranchisedOutletCityServiceCenter> resultList, String franchisedOutletCityCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:CityPartner的townServiceCenter的CityPartnerList
	public SmartList<CityPartner> loadOurCityPartnerList(YoubenbenUserContext userContext, List<FranchisedOutletCityServiceCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomer的cityServiceCenter的PotentialCustomerList
	public SmartList<PotentialCustomer> loadOurPotentialCustomerList(YoubenbenUserContext userContext, List<FranchisedOutletCityServiceCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:CityEvent的cityServiceCenter的CityEventList
	public SmartList<CityEvent> loadOurCityEventList(YoubenbenUserContext userContext, List<FranchisedOutletCityServiceCenter> us, Map<String,Object> options) throws Exception;
	
}


