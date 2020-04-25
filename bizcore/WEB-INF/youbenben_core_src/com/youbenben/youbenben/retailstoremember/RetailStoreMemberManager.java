
package com.youbenben.youbenben.retailstoremember;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreMemberManager extends BaseManager{

		

	public RetailStoreMember createRetailStoreMember(YoubenbenUserContext userContext, String name,String mobilePhone,String ownerId) throws Exception;
	public RetailStoreMember updateRetailStoreMember(YoubenbenUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreMember loadRetailStoreMember(YoubenbenUserContext userContext, String retailStoreMemberId, String [] tokensExpr) throws Exception;
	public RetailStoreMember internalSaveRetailStoreMember(YoubenbenUserContext userContext, RetailStoreMember retailStoreMember) throws Exception;
	public RetailStoreMember internalSaveRetailStoreMember(YoubenbenUserContext userContext, RetailStoreMember retailStoreMember,Map<String,Object>option) throws Exception;

	public RetailStoreMember transferToAnotherOwner(YoubenbenUserContext userContext, String retailStoreMemberId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreMemberId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreMember newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ConsumerOrderManager getConsumerOrderManager(YoubenbenUserContext userContext, String retailStoreMemberId, String title, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addConsumerOrder(YoubenbenUserContext userContext, String retailStoreMemberId, String title, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeConsumerOrder(YoubenbenUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateConsumerOrder(YoubenbenUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreMemberCouponManager getRetailStoreMemberCouponManager(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String number ,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addRetailStoreMemberCoupon(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String number , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeRetailStoreMemberCoupon(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateRetailStoreMemberCoupon(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  MemberWishlistManager getMemberWishlistManager(YoubenbenUserContext userContext, String retailStoreMemberId, String name ,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addMemberWishlist(YoubenbenUserContext userContext, String retailStoreMemberId, String name , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeMemberWishlist(YoubenbenUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateMemberWishlist(YoubenbenUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  MemberRewardPointManager getMemberRewardPointManager(YoubenbenUserContext userContext, String retailStoreMemberId, String name, int point ,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addMemberRewardPoint(YoubenbenUserContext userContext, String retailStoreMemberId, String name, int point , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeMemberRewardPoint(YoubenbenUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateMemberRewardPoint(YoubenbenUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  MemberRewardPointRedemptionManager getMemberRewardPointRedemptionManager(YoubenbenUserContext userContext, String retailStoreMemberId, String name, int point ,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addMemberRewardPointRedemption(YoubenbenUserContext userContext, String retailStoreMemberId, String name, int point , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeMemberRewardPointRedemption(YoubenbenUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateMemberRewardPointRedemption(YoubenbenUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreMemberAddressManager getRetailStoreMemberAddressManager(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address ,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addRetailStoreMemberAddress(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeRetailStoreMemberAddress(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateRetailStoreMemberAddress(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreMemberGiftCardManager getRetailStoreMemberGiftCardManager(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String number, BigDecimal remain ,String [] tokensExpr)  throws Exception;

	public  RetailStoreMember addRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String retailStoreMemberId, String name, String number, BigDecimal remain , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


