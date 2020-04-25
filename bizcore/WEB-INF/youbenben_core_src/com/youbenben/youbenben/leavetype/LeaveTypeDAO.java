
package com.youbenben.youbenben.leavetype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.employeeleave.EmployeeLeave;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.employeeleave.EmployeeLeaveDAO;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface LeaveTypeDAO extends BaseDAO{

	public SmartList<LeaveType> loadAll();
	public LeaveType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LeaveType> leaveTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LeaveType present(LeaveType leaveType,Map<String,Object> options) throws Exception;
	public LeaveType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LeaveType save(LeaveType leaveType,Map<String,Object> options);
	public SmartList<LeaveType> saveLeaveTypeList(SmartList<LeaveType> leaveTypeList,Map<String,Object> options);
	public SmartList<LeaveType> removeLeaveTypeList(SmartList<LeaveType> leaveTypeList,Map<String,Object> options);
	public SmartList<LeaveType> findLeaveTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLeaveTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLeaveTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String leaveTypeId, int version) throws Exception;
	public LeaveType disconnectFromAll(String leaveTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeLeaveDAO getEmployeeLeaveDAO();
		
	
 	public SmartList<LeaveType> requestCandidateLeaveTypeForEmployeeLeave(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LeaveType planToRemoveEmployeeLeaveList(LeaveType leaveType, String employeeLeaveIds[], Map<String,Object> options)throws Exception;


	//disconnect LeaveType with who in EmployeeLeave
	public LeaveType planToRemoveEmployeeLeaveListWithWho(LeaveType leaveType, String whoId, Map<String,Object> options)throws Exception;
	public int countEmployeeLeaveListWithWho(String leaveTypeId, String whoId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<LeaveType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateLeaveType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<LeaveType> findLeaveTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countLeaveTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countLeaveTypeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<LeaveType> findLeaveTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeLeaveTypeByCompany(SmartList<LeaveType> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:EmployeeLeave的type的EmployeeLeaveList
	public SmartList<EmployeeLeave> loadOurEmployeeLeaveList(YoubenbenUserContext userContext, List<LeaveType> us, Map<String,Object> options) throws Exception;
	
}


