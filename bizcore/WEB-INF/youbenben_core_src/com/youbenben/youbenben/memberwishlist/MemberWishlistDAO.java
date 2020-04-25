
package com.youbenben.youbenben.memberwishlist;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.memberwishlistproduct.MemberWishlistProduct;
import com.youbenben.youbenben.retailstoremember.RetailStoreMember;

import com.youbenben.youbenben.retailstoremember.RetailStoreMemberDAO;
import com.youbenben.youbenben.memberwishlistproduct.MemberWishlistProductDAO;


public interface MemberWishlistDAO extends BaseDAO{

	public SmartList<MemberWishlist> loadAll();
	public MemberWishlist load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<MemberWishlist> memberWishlistList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public MemberWishlist present(MemberWishlist memberWishlist,Map<String,Object> options) throws Exception;
	public MemberWishlist clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MemberWishlist save(MemberWishlist memberWishlist,Map<String,Object> options);
	public SmartList<MemberWishlist> saveMemberWishlistList(SmartList<MemberWishlist> memberWishlistList,Map<String,Object> options);
	public SmartList<MemberWishlist> removeMemberWishlistList(SmartList<MemberWishlist> memberWishlistList,Map<String,Object> options);
	public SmartList<MemberWishlist> findMemberWishlistWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countMemberWishlistWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countMemberWishlistWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String memberWishlistId, int version) throws Exception;
	public MemberWishlist disconnectFromAll(String memberWishlistId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public MemberWishlistProductDAO getMemberWishlistProductDAO();
		
	
 	public SmartList<MemberWishlist> requestCandidateMemberWishlistForMemberWishlistProduct(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public MemberWishlist planToRemoveMemberWishlistProductList(MemberWishlist memberWishlist, String memberWishlistProductIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<MemberWishlist> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateMemberWishlist executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<MemberWishlist> findMemberWishlistByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countMemberWishlistByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public Map<String, Integer> countMemberWishlistByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<MemberWishlist> findMemberWishlistByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 	public void analyzeMemberWishlistByOwner(SmartList<MemberWishlist> resultList, String retailStoreMemberId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:MemberWishlistProduct的owner的MemberWishlistProductList
	public SmartList<MemberWishlistProduct> loadOurMemberWishlistProductList(YoubenbenUserContext userContext, List<MemberWishlist> us, Map<String,Object> options) throws Exception;
	
}


