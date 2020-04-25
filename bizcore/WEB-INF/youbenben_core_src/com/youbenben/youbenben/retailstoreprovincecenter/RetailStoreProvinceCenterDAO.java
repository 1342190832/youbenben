
package com.youbenben.youbenben.retailstoreprovincecenter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.provincecenteremployee.ProvinceCenterEmployee;
import com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.youbenben.youbenben.provincecenterdepartment.ProvinceCenterDepartment;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.youbenben.youbenben.provincecenteremployee.ProvinceCenterEmployeeDAO;
import com.youbenben.youbenben.provincecenterdepartment.ProvinceCenterDepartmentDAO;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface RetailStoreProvinceCenterDAO extends BaseDAO{

	public SmartList<RetailStoreProvinceCenter> loadAll();
	public RetailStoreProvinceCenter load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreProvinceCenter present(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object> options) throws Exception;
	public RetailStoreProvinceCenter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreProvinceCenter save(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object> options);
	public SmartList<RetailStoreProvinceCenter> saveRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList,Map<String,Object> options);
	public SmartList<RetailStoreProvinceCenter> removeRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList,Map<String,Object> options);
	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreProvinceCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreProvinceCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreProvinceCenterId, int version) throws Exception;
	public RetailStoreProvinceCenter disconnectFromAll(String retailStoreProvinceCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProvinceCenterDepartmentDAO getProvinceCenterDepartmentDAO();
		
	public ProvinceCenterEmployeeDAO getProvinceCenterEmployeeDAO();
		
	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO();
		
	
 	public SmartList<RetailStoreProvinceCenter> requestCandidateRetailStoreProvinceCenterForProvinceCenterDepartment(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreProvinceCenter> requestCandidateRetailStoreProvinceCenterForProvinceCenterEmployee(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreProvinceCenter> requestCandidateRetailStoreProvinceCenterForRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreProvinceCenter planToRemoveProvinceCenterDepartmentList(RetailStoreProvinceCenter retailStoreProvinceCenter, String provinceCenterDepartmentIds[], Map<String,Object> options)throws Exception;


	public RetailStoreProvinceCenter planToRemoveProvinceCenterEmployeeList(RetailStoreProvinceCenter retailStoreProvinceCenter, String provinceCenterEmployeeIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreProvinceCenter with department in ProvinceCenterEmployee
	public RetailStoreProvinceCenter planToRemoveProvinceCenterEmployeeListWithDepartment(RetailStoreProvinceCenter retailStoreProvinceCenter, String departmentId, Map<String,Object> options)throws Exception;
	public int countProvinceCenterEmployeeListWithDepartment(String retailStoreProvinceCenterId, String departmentId, Map<String,Object> options)throws Exception;
	
	public RetailStoreProvinceCenter planToRemoveRetailStoreCityServiceCenterList(RetailStoreProvinceCenter retailStoreProvinceCenter, String retailStoreCityServiceCenterIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<RetailStoreProvinceCenter> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreProvinceCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreProvinceCenterByCountryIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreProvinceCenterByCountry(SmartList<RetailStoreProvinceCenter> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:ProvinceCenterDepartment的provinceCenter的ProvinceCenterDepartmentList
	public SmartList<ProvinceCenterDepartment> loadOurProvinceCenterDepartmentList(YoubenbenUserContext userContext, List<RetailStoreProvinceCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ProvinceCenterEmployee的provinceCenter的ProvinceCenterEmployeeList
	public SmartList<ProvinceCenterEmployee> loadOurProvinceCenterEmployeeList(YoubenbenUserContext userContext, List<RetailStoreProvinceCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreCityServiceCenter的belongsTo的RetailStoreCityServiceCenterList
	public SmartList<RetailStoreCityServiceCenter> loadOurRetailStoreCityServiceCenterList(YoubenbenUserContext userContext, List<RetailStoreProvinceCenter> us, Map<String,Object> options) throws Exception;
	
}


