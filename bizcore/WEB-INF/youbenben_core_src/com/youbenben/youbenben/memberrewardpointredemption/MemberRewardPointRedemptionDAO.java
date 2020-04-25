
package com.youbenben.youbenben.memberrewardpointredemption;
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


public interface MemberRewardPointRedemptionDAO extends BaseDAO{

	public SmartList<MemberRewardPointRedemption> loadAll();
	public MemberRewardPointRedemption load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<MemberRewardPointRedemption> memberRewardPointRedemptionList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public MemberRewardPointRedemption present(MemberRewardPointRedemption memberRewardPointRedemption,Map<String,Object> options) throws Exception;
	public MemberRewardPointRedemption clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MemberRewardPointRedemption save(MemberRewardPointRedemption memberRewardPointRedemption,Map<String,Object> options);
	public SmartList<MemberRewardPointRedemption> saveMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList,Map<String,Object> options);
	public SmartList<MemberRewardPointRedemption> removeMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList,Map<String,Object> options);
	public SmartList<MemberRewardPointRedemption> findMemberRewardPointRedemptionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countMemberRewardPointRedemptionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countMemberRewardPointRedemptionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String memberRewardPointRedemptionId, int version) throws Exception;
	public MemberRewardPointRedemption disconnectFromAll(String memberRewardPointRedemptionId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<MemberRewardPointRedemption> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateMemberRewardPointRedemption executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<MemberRewardPointRedemption> findMemberRewardPointRedemptionByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countMemberRewardPointRedemptionByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public Map<String, Integer> countMemberRewardPointRedemptionByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<MemberRewardPointRedemption> findMemberRewardPointRedemptionByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 	public void analyzeMemberRewardPointRedemptionByOwner(SmartList<MemberRewardPointRedemption> resultList, String retailStoreMemberId, Map<String,Object> options);

 
 
}


