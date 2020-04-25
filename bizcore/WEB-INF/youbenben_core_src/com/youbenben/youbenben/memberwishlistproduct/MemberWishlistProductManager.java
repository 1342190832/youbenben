
package com.youbenben.youbenben.memberwishlistproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface MemberWishlistProductManager extends BaseManager{

		

	public MemberWishlistProduct createMemberWishlistProduct(YoubenbenUserContext userContext, String name,String ownerId) throws Exception;
	public MemberWishlistProduct updateMemberWishlistProduct(YoubenbenUserContext userContext,String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MemberWishlistProduct loadMemberWishlistProduct(YoubenbenUserContext userContext, String memberWishlistProductId, String [] tokensExpr) throws Exception;
	public MemberWishlistProduct internalSaveMemberWishlistProduct(YoubenbenUserContext userContext, MemberWishlistProduct memberWishlistProduct) throws Exception;
	public MemberWishlistProduct internalSaveMemberWishlistProduct(YoubenbenUserContext userContext, MemberWishlistProduct memberWishlistProduct,Map<String,Object>option) throws Exception;

	public MemberWishlistProduct transferToAnotherOwner(YoubenbenUserContext userContext, String memberWishlistProductId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String memberWishlistProductId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, MemberWishlistProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


