
package com.xingyou.xingyou.franchisedoutletcityservicecenter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.xingyou.xingyou.BaseDAO;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.SmartList;
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
		
	
 	public SmartList<FranchisedOutletCityServiceCenter> requestCandidateFranchisedOutletCityServiceCenterForCityPartner(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<FranchisedOutletCityServiceCenter> requestCandidateFranchisedOutletCityServiceCenterForPotentialCustomer(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<FranchisedOutletCityServiceCenter> requestCandidateFranchisedOutletCityServiceCenterForCityEvent(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
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
	public SmartList<CityPartner> loadOurCityPartnerList(XingyouUserContext userContext, List<FranchisedOutletCityServiceCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomer的cityServiceCenter的PotentialCustomerList
	public SmartList<PotentialCustomer> loadOurPotentialCustomerList(XingyouUserContext userContext, List<FranchisedOutletCityServiceCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:CityEvent的cityServiceCenter的CityEventList
	public SmartList<CityEvent> loadOurCityEventList(XingyouUserContext userContext, List<FranchisedOutletCityServiceCenter> us, Map<String,Object> options) throws Exception;
	
}


