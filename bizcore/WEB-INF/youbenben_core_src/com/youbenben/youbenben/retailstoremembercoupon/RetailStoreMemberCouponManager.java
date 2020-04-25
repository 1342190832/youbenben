
package com.youbenben.youbenben.retailstoremembercoupon;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreMemberCouponManager extends BaseManager{

		

	public RetailStoreMemberCoupon createRetailStoreMemberCoupon(YoubenbenUserContext userContext, String name,String ownerId,String number) throws Exception;
	public RetailStoreMemberCoupon updateRetailStoreMemberCoupon(YoubenbenUserContext userContext,String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreMemberCoupon loadRetailStoreMemberCoupon(YoubenbenUserContext userContext, String retailStoreMemberCouponId, String [] tokensExpr) throws Exception;
	public RetailStoreMemberCoupon internalSaveRetailStoreMemberCoupon(YoubenbenUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon) throws Exception;
	public RetailStoreMemberCoupon internalSaveRetailStoreMemberCoupon(YoubenbenUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String,Object>option) throws Exception;

	public RetailStoreMemberCoupon transferToAnotherOwner(YoubenbenUserContext userContext, String retailStoreMemberCouponId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreMemberCouponId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreMemberCoupon newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


