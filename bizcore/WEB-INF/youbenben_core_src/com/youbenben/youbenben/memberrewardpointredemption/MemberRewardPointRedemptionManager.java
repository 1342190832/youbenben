
package com.youbenben.youbenben.memberrewardpointredemption;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface MemberRewardPointRedemptionManager extends BaseManager{

		

	public MemberRewardPointRedemption createMemberRewardPointRedemption(YoubenbenUserContext userContext, String name,int point,String ownerId) throws Exception;
	public MemberRewardPointRedemption updateMemberRewardPointRedemption(YoubenbenUserContext userContext,String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MemberRewardPointRedemption loadMemberRewardPointRedemption(YoubenbenUserContext userContext, String memberRewardPointRedemptionId, String [] tokensExpr) throws Exception;
	public MemberRewardPointRedemption internalSaveMemberRewardPointRedemption(YoubenbenUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption) throws Exception;
	public MemberRewardPointRedemption internalSaveMemberRewardPointRedemption(YoubenbenUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption,Map<String,Object>option) throws Exception;

	public MemberRewardPointRedemption transferToAnotherOwner(YoubenbenUserContext userContext, String memberRewardPointRedemptionId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String memberRewardPointRedemptionId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, MemberRewardPointRedemption newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


