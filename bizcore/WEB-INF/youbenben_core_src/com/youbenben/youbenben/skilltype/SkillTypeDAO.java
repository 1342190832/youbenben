
package com.youbenben.youbenben.skilltype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.employeeskill.EmployeeSkill;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.employeeskill.EmployeeSkillDAO;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface SkillTypeDAO extends BaseDAO{

	public SmartList<SkillType> loadAll();
	public SkillType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SkillType> skillTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SkillType present(SkillType skillType,Map<String,Object> options) throws Exception;
	public SkillType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SkillType save(SkillType skillType,Map<String,Object> options);
	public SmartList<SkillType> saveSkillTypeList(SmartList<SkillType> skillTypeList,Map<String,Object> options);
	public SmartList<SkillType> removeSkillTypeList(SmartList<SkillType> skillTypeList,Map<String,Object> options);
	public SmartList<SkillType> findSkillTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSkillTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSkillTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String skillTypeId, int version) throws Exception;
	public SkillType disconnectFromAll(String skillTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeSkillDAO getEmployeeSkillDAO();
		
	
 	public SmartList<SkillType> requestCandidateSkillTypeForEmployeeSkill(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SkillType planToRemoveEmployeeSkillList(SkillType skillType, String employeeSkillIds[], Map<String,Object> options)throws Exception;


	//disconnect SkillType with employee in EmployeeSkill
	public SkillType planToRemoveEmployeeSkillListWithEmployee(SkillType skillType, String employeeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSkillListWithEmployee(String skillTypeId, String employeeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SkillType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSkillType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<SkillType> findSkillTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countSkillTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countSkillTypeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<SkillType> findSkillTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeSkillTypeByCompany(SmartList<SkillType> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:EmployeeSkill的skillType的EmployeeSkillList
	public SmartList<EmployeeSkill> loadOurEmployeeSkillList(YoubenbenUserContext userContext, List<SkillType> us, Map<String,Object> options) throws Exception;
	
}


