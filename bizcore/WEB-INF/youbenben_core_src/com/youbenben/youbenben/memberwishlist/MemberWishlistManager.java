
package com.youbenben.youbenben.memberwishlist;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface MemberWishlistManager extends BaseManager{

		

	public MemberWishlist createMemberWishlist(YoubenbenUserContext userContext, String name,String ownerId) throws Exception;
	public MemberWishlist updateMemberWishlist(YoubenbenUserContext userContext,String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MemberWishlist loadMemberWishlist(YoubenbenUserContext userContext, String memberWishlistId, String [] tokensExpr) throws Exception;
	public MemberWishlist internalSaveMemberWishlist(YoubenbenUserContext userContext, MemberWishlist memberWishlist) throws Exception;
	public MemberWishlist internalSaveMemberWishlist(YoubenbenUserContext userContext, MemberWishlist memberWishlist,Map<String,Object>option) throws Exception;

	public MemberWishlist transferToAnotherOwner(YoubenbenUserContext userContext, String memberWishlistId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String memberWishlistId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, MemberWishlist newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  MemberWishlistProductManager getMemberWishlistProductManager(YoubenbenUserContext userContext, String memberWishlistId, String name ,String [] tokensExpr)  throws Exception;

	public  MemberWishlist addMemberWishlistProduct(YoubenbenUserContext userContext, String memberWishlistId, String name , String [] tokensExpr)  throws Exception;
	public  MemberWishlist removeMemberWishlistProduct(YoubenbenUserContext userContext, String memberWishlistId, String memberWishlistProductId, int memberWishlistProductVersion,String [] tokensExpr)  throws Exception;
	public  MemberWishlist updateMemberWishlistProduct(YoubenbenUserContext userContext, String memberWishlistId, String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


