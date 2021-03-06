
package com.youbenben.youbenben.interviewtype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.employeeinterview.EmployeeInterview;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.employeeinterview.EmployeeInterviewDAO;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface InterviewTypeDAO extends BaseDAO{

	public SmartList<InterviewType> loadAll();
	public InterviewType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<InterviewType> interviewTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public InterviewType present(InterviewType interviewType,Map<String,Object> options) throws Exception;
	public InterviewType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public InterviewType save(InterviewType interviewType,Map<String,Object> options);
	public SmartList<InterviewType> saveInterviewTypeList(SmartList<InterviewType> interviewTypeList,Map<String,Object> options);
	public SmartList<InterviewType> removeInterviewTypeList(SmartList<InterviewType> interviewTypeList,Map<String,Object> options);
	public SmartList<InterviewType> findInterviewTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countInterviewTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countInterviewTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String interviewTypeId, int version) throws Exception;
	public InterviewType disconnectFromAll(String interviewTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeInterviewDAO getEmployeeInterviewDAO();
		
	
 	public SmartList<InterviewType> requestCandidateInterviewTypeForEmployeeInterview(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public InterviewType planToRemoveEmployeeInterviewList(InterviewType interviewType, String employeeInterviewIds[], Map<String,Object> options)throws Exception;


	//disconnect InterviewType with employee in EmployeeInterview
	public InterviewType planToRemoveEmployeeInterviewListWithEmployee(InterviewType interviewType, String employeeId, Map<String,Object> options)throws Exception;
	public int countEmployeeInterviewListWithEmployee(String interviewTypeId, String employeeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<InterviewType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateInterviewType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<InterviewType> findInterviewTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countInterviewTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countInterviewTypeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<InterviewType> findInterviewTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeInterviewTypeByCompany(SmartList<InterviewType> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:EmployeeInterview的interviewType的EmployeeInterviewList
	public SmartList<EmployeeInterview> loadOurEmployeeInterviewList(YoubenbenUserContext userContext, List<InterviewType> us, Map<String,Object> options) throws Exception;
	
}


