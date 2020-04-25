
package com.xingyou.xingyou.citycenterdepartment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.xingyou.xingyou.BaseDAO;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.SmartList;
import com.xingyou.xingyou.MultipleAccessKey;
import com.xingyou.xingyou.XingyouUserContext;

import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenter;
import com.xingyou.xingyou.citycenteremployee.CityCenterEmployee;

import com.xingyou.xingyou.citycenteremployee.CityCenterEmployeeDAO;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenterDAO;


public interface CityCenterDepartmentDAO extends BaseDAO{

	public SmartList<CityCenterDepartment> loadAll();
	public CityCenterDepartment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<CityCenterDepartment> cityCenterDepartmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public CityCenterDepartment present(CityCenterDepartment cityCenterDepartment,Map<String,Object> options) throws Exception;
	public CityCenterDepartment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CityCenterDepartment save(CityCenterDepartment cityCenterDepartment,Map<String,Object> options);
	public SmartList<CityCenterDepartment> saveCityCenterDepartmentList(SmartList<CityCenterDepartment> cityCenterDepartmentList,Map<String,Object> options);
	public SmartList<CityCenterDepartment> removeCityCenterDepartmentList(SmartList<CityCenterDepartment> cityCenterDepartmentList,Map<String,Object> options);
	public SmartList<CityCenterDepartment> findCityCenterDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCityCenterDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCityCenterDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String cityCenterDepartmentId, int version) throws Exception;
	public CityCenterDepartment disconnectFromAll(String cityCenterDepartmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public CityCenterEmployeeDAO getCityCenterEmployeeDAO();
		
	
 	public SmartList<CityCenterDepartment> requestCandidateCityCenterDepartmentForCityCenterEmployee(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public CityCenterDepartment planToRemoveCityCenterEmployeeList(CityCenterDepartment cityCenterDepartment, String cityCenterEmployeeIds[], Map<String,Object> options)throws Exception;


	//disconnect CityCenterDepartment with city_center in CityCenterEmployee
	public CityCenterDepartment planToRemoveCityCenterEmployeeListWithCityCenter(CityCenterDepartment cityCenterDepartment, String cityCenterId, Map<String,Object> options)throws Exception;
	public int countCityCenterEmployeeListWithCityCenter(String cityCenterDepartmentId, String cityCenterId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<CityCenterDepartment> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateCityCenterDepartment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<CityCenterDepartment> findCityCenterDepartmentByCityCenter(String franchisedOutletCityCenterId, Map<String,Object> options);
 	public int countCityCenterDepartmentByCityCenter(String franchisedOutletCityCenterId, Map<String,Object> options);
 	public Map<String, Integer> countCityCenterDepartmentByCityCenterIds(String[] ids, Map<String,Object> options);
 	public SmartList<CityCenterDepartment> findCityCenterDepartmentByCityCenter(String franchisedOutletCityCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeCityCenterDepartmentByCityCenter(SmartList<CityCenterDepartment> resultList, String franchisedOutletCityCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:CityCenterEmployee的department的CityCenterEmployeeList
	public SmartList<CityCenterEmployee> loadOurCityCenterEmployeeList(XingyouUserContext userContext, List<CityCenterDepartment> us, Map<String,Object> options) throws Exception;
	
}


