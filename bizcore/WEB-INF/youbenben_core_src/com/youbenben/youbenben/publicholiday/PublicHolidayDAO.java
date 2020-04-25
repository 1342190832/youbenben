
package com.youbenben.youbenben.publicholiday;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface PublicHolidayDAO extends BaseDAO{

	public SmartList<PublicHoliday> loadAll();
	public PublicHoliday load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PublicHoliday> publicHolidayList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public PublicHoliday present(PublicHoliday publicHoliday,Map<String,Object> options) throws Exception;
	public PublicHoliday clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PublicHoliday save(PublicHoliday publicHoliday,Map<String,Object> options);
	public SmartList<PublicHoliday> savePublicHolidayList(SmartList<PublicHoliday> publicHolidayList,Map<String,Object> options);
	public SmartList<PublicHoliday> removePublicHolidayList(SmartList<PublicHoliday> publicHolidayList,Map<String,Object> options);
	public SmartList<PublicHoliday> findPublicHolidayWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPublicHolidayWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPublicHolidayWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String publicHolidayId, int version) throws Exception;
	public PublicHoliday disconnectFromAll(String publicHolidayId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<PublicHoliday> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidatePublicHoliday executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<PublicHoliday> findPublicHolidayByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countPublicHolidayByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countPublicHolidayByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<PublicHoliday> findPublicHolidayByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzePublicHolidayByCompany(SmartList<PublicHoliday> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
}


