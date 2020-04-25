
package com.youbenben.youbenben.franchisedoutletcitycenter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartment;
import com.youbenben.youbenben.citycenteremployee.CityCenterEmployee;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenter;

import com.youbenben.youbenben.citycenteremployee.CityCenterEmployeeDAO;
import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartmentDAO;
import com.youbenben.youbenben.franchisedoutletcityservicecenter.FranchisedOutletCityServiceCenterDAO;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO;


public interface FranchisedOutletCityCenterDAO extends BaseDAO{

	public SmartList<FranchisedOutletCityCenter> loadAll();
	public FranchisedOutletCityCenter load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<FranchisedOutletCityCenter> franchisedOutletCityCenterList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public FranchisedOutletCityCenter present(FranchisedOutletCityCenter franchisedOutletCityCenter,Map<String,Object> options) throws Exception;
	public FranchisedOutletCityCenter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public FranchisedOutletCityCenter save(FranchisedOutletCityCenter franchisedOutletCityCenter,Map<String,Object> options);
	public SmartList<FranchisedOutletCityCenter> saveFranchisedOutletCityCenterList(SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList,Map<String,Object> options);
	public SmartList<FranchisedOutletCityCenter> removeFranchisedOutletCityCenterList(SmartList<FranchisedOutletCityCenter> franchisedOutletCityCenterList,Map<String,Object> options);
	public SmartList<FranchisedOutletCityCenter> findFranchisedOutletCityCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countFranchisedOutletCityCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countFranchisedOutletCityCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String franchisedOutletCityCenterId, int version) throws Exception;
	public FranchisedOutletCityCenter disconnectFromAll(String franchisedOutletCityCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public FranchisedOutletCityCenterDAO getFranchisedOutletCityCenterDAO();
		
	public CityCenterDepartmentDAO getCityCenterDepartmentDAO();
		
	public CityCenterEmployeeDAO getCityCenterEmployeeDAO();
		
	public FranchisedOutletCityServiceCenterDAO getFranchisedOutletCityServiceCenterDAO();
		
	
 	public SmartList<FranchisedOutletCityCenter> requestCandidateFranchisedOutletCityCenterForFranchisedOutletCityCenter(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<FranchisedOutletCityCenter> requestCandidateFranchisedOutletCityCenterForCityCenterDepartment(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<FranchisedOutletCityCenter> requestCandidateFranchisedOutletCityCenterForCityCenterEmployee(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<FranchisedOutletCityCenter> requestCandidateFranchisedOutletCityCenterForFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public FranchisedOutletCityCenter planToRemoveFranchisedOutletCityCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, String franchisedOutletCityCenterIds[], Map<String,Object> options)throws Exception;


	public FranchisedOutletCityCenter planToRemoveCityCenterDepartmentList(FranchisedOutletCityCenter franchisedOutletCityCenter, String cityCenterDepartmentIds[], Map<String,Object> options)throws Exception;


	public FranchisedOutletCityCenter planToRemoveCityCenterEmployeeList(FranchisedOutletCityCenter franchisedOutletCityCenter, String cityCenterEmployeeIds[], Map<String,Object> options)throws Exception;


	//disconnect FranchisedOutletCityCenter with department in CityCenterEmployee
	public FranchisedOutletCityCenter planToRemoveCityCenterEmployeeListWithDepartment(FranchisedOutletCityCenter franchisedOutletCityCenter, String departmentId, Map<String,Object> options)throws Exception;
	public int countCityCenterEmployeeListWithDepartment(String franchisedOutletCityCenterId, String departmentId, Map<String,Object> options)throws Exception;
	
	public FranchisedOutletCityCenter planToRemoveFranchisedOutletCityServiceCenterList(FranchisedOutletCityCenter franchisedOutletCityCenter, String franchisedOutletCityServiceCenterIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<FranchisedOutletCityCenter> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateFranchisedOutletCityCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<FranchisedOutletCityCenter> findFranchisedOutletCityCenterByCity(String franchisedOutletCityCenterId, Map<String,Object> options);
 	public int countFranchisedOutletCityCenterByCity(String franchisedOutletCityCenterId, Map<String,Object> options);
 	public Map<String, Integer> countFranchisedOutletCityCenterByCityIds(String[] ids, Map<String,Object> options);
 	public SmartList<FranchisedOutletCityCenter> findFranchisedOutletCityCenterByCity(String franchisedOutletCityCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeFranchisedOutletCityCenterByCity(SmartList<FranchisedOutletCityCenter> resultList, String franchisedOutletCityCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:FranchisedOutletCityCenter的city的FranchisedOutletCityCenterList
	public SmartList<FranchisedOutletCityCenter> loadOurFranchisedOutletCityCenterList(YoubenbenUserContext userContext, List<FranchisedOutletCityCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:CityCenterDepartment的cityCenter的CityCenterDepartmentList
	public SmartList<CityCenterDepartment> loadOurCityCenterDepartmentList(YoubenbenUserContext userContext, List<FranchisedOutletCityCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:CityCenterEmployee的cityCenter的CityCenterEmployeeList
	public SmartList<CityCenterEmployee> loadOurCityCenterEmployeeList(YoubenbenUserContext userContext, List<FranchisedOutletCityCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:FranchisedOutletCityServiceCenter的belongsTo的FranchisedOutletCityServiceCenterList
	public SmartList<FranchisedOutletCityServiceCenter> loadOurFranchisedOutletCityServiceCenterList(YoubenbenUserContext userContext, List<FranchisedOutletCityCenter> us, Map<String,Object> options) throws Exception;
	
}

