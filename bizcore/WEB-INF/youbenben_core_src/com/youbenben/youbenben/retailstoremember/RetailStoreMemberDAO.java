
package com.youbenben.youbenben.retailstoremember;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.memberrewardpointredemption.MemberRewardPointRedemption;
import com.youbenben.youbenben.memberwishlist.MemberWishlist;
import com.youbenben.youbenben.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.youbenben.youbenben.memberrewardpoint.MemberRewardPoint;
import com.youbenben.youbenben.retailstorememberaddress.RetailStoreMemberAddress;
import com.youbenben.youbenben.consumerorder.ConsumerOrder;
import com.youbenben.youbenben.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenter;

import com.youbenben.youbenben.retailstoremembercoupon.RetailStoreMemberCouponDAO;
import com.youbenben.youbenben.memberrewardpoint.MemberRewardPointDAO;
import com.youbenben.youbenben.memberrewardpointredemption.MemberRewardPointRedemptionDAO;
import com.youbenben.youbenben.retailstorememberaddress.RetailStoreMemberAddressDAO;
import com.youbenben.youbenben.memberwishlist.MemberWishlistDAO;
import com.youbenben.youbenben.consumerorder.ConsumerOrderDAO;
import com.youbenben.youbenben.retailstoremembergiftcard.RetailStoreMemberGiftCardDAO;
import com.youbenben.youbenben.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface RetailStoreMemberDAO extends BaseDAO{

	public SmartList<RetailStoreMember> loadAll();
	public RetailStoreMember load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreMember> retailStoreMemberList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreMember present(RetailStoreMember retailStoreMember,Map<String,Object> options) throws Exception;
	public RetailStoreMember clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreMember save(RetailStoreMember retailStoreMember,Map<String,Object> options);
	public SmartList<RetailStoreMember> saveRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList,Map<String,Object> options);
	public SmartList<RetailStoreMember> removeRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList,Map<String,Object> options);
	public SmartList<RetailStoreMember> findRetailStoreMemberWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreMemberWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreMemberWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreMemberId, int version) throws Exception;
	public RetailStoreMember disconnectFromAll(String retailStoreMemberId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderDAO getConsumerOrderDAO();
		
	public RetailStoreMemberCouponDAO getRetailStoreMemberCouponDAO();
		
	public MemberWishlistDAO getMemberWishlistDAO();
		
	public MemberRewardPointDAO getMemberRewardPointDAO();
		
	public MemberRewardPointRedemptionDAO getMemberRewardPointRedemptionDAO();
		
	public RetailStoreMemberAddressDAO getRetailStoreMemberAddressDAO();
		
	public RetailStoreMemberGiftCardDAO getRetailStoreMemberGiftCardDAO();
		
	
 	public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForConsumerOrder(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForRetailStoreMemberCoupon(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForMemberWishlist(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForMemberRewardPoint(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForMemberRewardPointRedemption(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForRetailStoreMemberAddress(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreMember planToRemoveConsumerOrderList(RetailStoreMember retailStoreMember, String consumerOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreMember with confirmation in ConsumerOrder
	public RetailStoreMember planToRemoveConsumerOrderListWithConfirmation(RetailStoreMember retailStoreMember, String confirmationId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConfirmation(String retailStoreMemberId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreMember with approval in ConsumerOrder
	public RetailStoreMember planToRemoveConsumerOrderListWithApproval(RetailStoreMember retailStoreMember, String approvalId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithApproval(String retailStoreMemberId, String approvalId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreMember with processing in ConsumerOrder
	public RetailStoreMember planToRemoveConsumerOrderListWithProcessing(RetailStoreMember retailStoreMember, String processingId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithProcessing(String retailStoreMemberId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreMember with shipment in ConsumerOrder
	public RetailStoreMember planToRemoveConsumerOrderListWithShipment(RetailStoreMember retailStoreMember, String shipmentId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithShipment(String retailStoreMemberId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreMember with delivery in ConsumerOrder
	public RetailStoreMember planToRemoveConsumerOrderListWithDelivery(RetailStoreMember retailStoreMember, String deliveryId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithDelivery(String retailStoreMemberId, String deliveryId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreMember with store in ConsumerOrder
	public RetailStoreMember planToRemoveConsumerOrderListWithStore(RetailStoreMember retailStoreMember, String storeId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithStore(String retailStoreMemberId, String storeId, Map<String,Object> options)throws Exception;
	
	public RetailStoreMember planToRemoveRetailStoreMemberCouponList(RetailStoreMember retailStoreMember, String retailStoreMemberCouponIds[], Map<String,Object> options)throws Exception;


	public RetailStoreMember planToRemoveMemberWishlistList(RetailStoreMember retailStoreMember, String memberWishlistIds[], Map<String,Object> options)throws Exception;


	public RetailStoreMember planToRemoveMemberRewardPointList(RetailStoreMember retailStoreMember, String memberRewardPointIds[], Map<String,Object> options)throws Exception;


	public RetailStoreMember planToRemoveMemberRewardPointRedemptionList(RetailStoreMember retailStoreMember, String memberRewardPointRedemptionIds[], Map<String,Object> options)throws Exception;


	public RetailStoreMember planToRemoveRetailStoreMemberAddressList(RetailStoreMember retailStoreMember, String retailStoreMemberAddressIds[], Map<String,Object> options)throws Exception;


	public RetailStoreMember planToRemoveRetailStoreMemberGiftCardList(RetailStoreMember retailStoreMember, String retailStoreMemberGiftCardIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<RetailStoreMember> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreMember executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<RetailStoreMember> findRetailStoreMemberByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countRetailStoreMemberByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreMemberByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreMember> findRetailStoreMemberByOwner(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreMemberByOwner(SmartList<RetailStoreMember> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:ConsumerOrder的consumer的ConsumerOrderList
	public SmartList<ConsumerOrder> loadOurConsumerOrderList(YoubenbenUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreMemberCoupon的owner的RetailStoreMemberCouponList
	public SmartList<RetailStoreMemberCoupon> loadOurRetailStoreMemberCouponList(YoubenbenUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:MemberWishlist的owner的MemberWishlistList
	public SmartList<MemberWishlist> loadOurMemberWishlistList(YoubenbenUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:MemberRewardPoint的owner的MemberRewardPointList
	public SmartList<MemberRewardPoint> loadOurMemberRewardPointList(YoubenbenUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:MemberRewardPointRedemption的owner的MemberRewardPointRedemptionList
	public SmartList<MemberRewardPointRedemption> loadOurMemberRewardPointRedemptionList(YoubenbenUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreMemberAddress的owner的RetailStoreMemberAddressList
	public SmartList<RetailStoreMemberAddress> loadOurRetailStoreMemberAddressList(YoubenbenUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreMemberGiftCard的owner的RetailStoreMemberGiftCardList
	public SmartList<RetailStoreMemberGiftCard> loadOurRetailStoreMemberGiftCardList(YoubenbenUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception;
	
}


