
package com.youbenben.youbenben.memberrewardpoint;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.retailstoremember.RetailStoreMember;

import com.youbenben.youbenben.retailstoremember.RetailStoreMemberDAO;


public interface MemberRewardPointDAO extends BaseDAO{

	public SmartList<MemberRewardPoint> loadAll();
	public MemberRewardPoint load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<MemberRewardPoint> memberRewardPointList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public MemberRewardPoint present(MemberRewardPoint memberRewardPoint,Map<String,Object> options) throws Exception;
	public MemberRewardPoint clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MemberRewardPoint save(MemberRewardPoint memberRewardPoint,Map<String,Object> options);
	public SmartList<MemberRewardPoint> saveMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList,Map<String,Object> options);
	public SmartList<MemberRewardPoint> removeMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList,Map<String,Object> options);
	public SmartList<MemberRewardPoint> findMemberRewardPointWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countMemberRewardPointWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countMemberRewardPointWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String memberRewardPointId, int version) throws Exception;
	public MemberRewardPoint disconnectFromAll(String memberRewardPointId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<MemberRewardPoint> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateMemberRewardPoint executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<MemberRewardPoint> findMemberRewardPointByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countMemberRewardPointByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public Map<String, Integer> countMemberRewardPointByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<MemberRewardPoint> findMemberRewardPointByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 	public void analyzeMemberRewardPointByOwner(SmartList<MemberRewardPoint> resultList, String retailStoreMemberId, Map<String,Object> options);

 
 
}


