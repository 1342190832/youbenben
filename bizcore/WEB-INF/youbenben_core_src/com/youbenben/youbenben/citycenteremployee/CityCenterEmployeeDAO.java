
package com.youbenben.youbenben.citycenteremployee;
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
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;

import com.youbenben.youbenben.citycenterdepartment.CityCenterDepartmentDAO;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO;


public interface CityCenterEmployeeDAO extends BaseDAO{

	public SmartList<CityCenterEmployee> loadAll();
	public CityCenterEmployee load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<CityCenterEmployee> cityCenterEmployeeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public CityCenterEmployee present(CityCenterEmployee cityCenterEmployee,Map<String,Object> options) throws Exception;
	public CityCenterEmployee clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CityCenterEmployee save(CityCenterEmployee cityCenterEmployee,Map<String,Object> options);
	public SmartList<CityCenterEmployee> saveCityCenterEmployeeList(SmartList<CityCenterEmployee> cityCenterEmployeeList,Map<String,Object> options);
	public SmartList<CityCenterEmployee> removeCityCenterEmployeeList(SmartList<CityCenterEmployee> cityCenterEmployeeList,Map<String,Object> options);
	public SmartList<CityCenterEmployee> findCityCenterEmployeeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCityCenterEmployeeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCityCenterEmployeeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String cityCenterEmployeeId, int version) throws Exception;
	public CityCenterEmployee disconnectFromAll(String cityCenterEmployeeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<CityCenterEmployee> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateCityCenterEmployee executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<CityCenterEmployee> findCityCenterEmployeeByDepartment(String cityCenterDepartmentId, Map<String,Object> options);
 	public int countCityCenterEmployeeByDepartment(String cityCenterDepartmentId, Map<String,Object> options);
 	public Map<String, Integer> countCityCenterEmployeeByDepartmentIds(String[] ids, Map<String,Object> options);
 	public SmartList<CityCenterEmployee> findCityCenterEmployeeByDepartment(String cityCenterDepartmentId, int start, int count, Map<String,Object> options);
 	public void analyzeCityCenterEmployeeByDepartment(SmartList<CityCenterEmployee> resultList, String cityCenterDepartmentId, Map<String,Object> options);

 
  
 	public SmartList<CityCenterEmployee> findCityCenterEmployeeByCityCenter(String franchisedOutletCityCenterId, Map<String,Object> options);
 	public int countCityCenterEmployeeByCityCenter(String franchisedOutletCityCenterId, Map<String,Object> options);
 	public Map<String, Integer> countCityCenterEmployeeByCityCenterIds(String[] ids, Map<String,Object> options);
 	public SmartList<CityCenterEmployee> findCityCenterEmployeeByCityCenter(String franchisedOutletCityCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeCityCenterEmployeeByCityCenter(SmartList<CityCenterEmployee> resultList, String franchisedOutletCityCenterId, Map<String,Object> options);

 
 
}


