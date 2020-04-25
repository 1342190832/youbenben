
package com.youbenben.youbenben.memberwishlistproduct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.memberwishlist.MemberWishlist;

import com.youbenben.youbenben.memberwishlist.MemberWishlistDAO;


public interface MemberWishlistProductDAO extends BaseDAO{

	public SmartList<MemberWishlistProduct> loadAll();
	public MemberWishlistProduct load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<MemberWishlistProduct> memberWishlistProductList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public MemberWishlistProduct present(MemberWishlistProduct memberWishlistProduct,Map<String,Object> options) throws Exception;
	public MemberWishlistProduct clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MemberWishlistProduct save(MemberWishlistProduct memberWishlistProduct,Map<String,Object> options);
	public SmartList<MemberWishlistProduct> saveMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList,Map<String,Object> options);
	public SmartList<MemberWishlistProduct> removeMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList,Map<String,Object> options);
	public SmartList<MemberWishlistProduct> findMemberWishlistProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countMemberWishlistProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countMemberWishlistProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String memberWishlistProductId, int version) throws Exception;
	public MemberWishlistProduct disconnectFromAll(String memberWishlistProductId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<MemberWishlistProduct> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateMemberWishlistProduct executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<MemberWishlistProduct> findMemberWishlistProductByOwner(String memberWishlistId, Map<String,Object> options);
 	public int countMemberWishlistProductByOwner(String memberWishlistId, Map<String,Object> options);
 	public Map<String, Integer> countMemberWishlistProductByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<MemberWishlistProduct> findMemberWishlistProductByOwner(String memberWishlistId, int start, int count, Map<String,Object> options);
 	public void analyzeMemberWishlistProductByOwner(SmartList<MemberWishlistProduct> resultList, String memberWishlistId, Map<String,Object> options);

 
 
}


