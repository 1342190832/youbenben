
package com.youbenben.youbenben.scoring;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.employeecompanytraining.EmployeeCompanyTraining;

import com.youbenben.youbenben.employeecompanytraining.EmployeeCompanyTrainingDAO;


public interface ScoringDAO extends BaseDAO{

	public SmartList<Scoring> loadAll();
	public Scoring load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Scoring> scoringList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Scoring present(Scoring scoring,Map<String,Object> options) throws Exception;
	public Scoring clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Scoring save(Scoring scoring,Map<String,Object> options);
	public SmartList<Scoring> saveScoringList(SmartList<Scoring> scoringList,Map<String,Object> options);
	public SmartList<Scoring> removeScoringList(SmartList<Scoring> scoringList,Map<String,Object> options);
	public SmartList<Scoring> findScoringWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countScoringWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countScoringWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String scoringId, int version) throws Exception;
	public Scoring disconnectFromAll(String scoringId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO();
		
	
 	public SmartList<Scoring> requestCandidateScoringForEmployeeCompanyTraining(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Scoring planToRemoveEmployeeCompanyTrainingList(Scoring scoring, String employeeCompanyTrainingIds[], Map<String,Object> options)throws Exception;


	//disconnect Scoring with employee in EmployeeCompanyTraining
	public Scoring planToRemoveEmployeeCompanyTrainingListWithEmployee(Scoring scoring, String employeeId, Map<String,Object> options)throws Exception;
	public int countEmployeeCompanyTrainingListWithEmployee(String scoringId, String employeeId, Map<String,Object> options)throws Exception;
	
	//disconnect Scoring with training in EmployeeCompanyTraining
	public Scoring planToRemoveEmployeeCompanyTrainingListWithTraining(Scoring scoring, String trainingId, Map<String,Object> options)throws Exception;
	public int countEmployeeCompanyTrainingListWithTraining(String scoringId, String trainingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Scoring> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateScoring executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:EmployeeCompanyTraining的scoring的EmployeeCompanyTrainingList
	public SmartList<EmployeeCompanyTraining> loadOurEmployeeCompanyTrainingList(YoubenbenUserContext userContext, List<Scoring> us, Map<String,Object> options) throws Exception;
	
}


