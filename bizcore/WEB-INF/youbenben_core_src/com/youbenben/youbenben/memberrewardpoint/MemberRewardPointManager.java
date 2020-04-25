
package com.youbenben.youbenben.memberrewardpoint;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface MemberRewardPointManager extends BaseManager{

		

	public MemberRewardPoint createMemberRewardPoint(YoubenbenUserContext userContext, String name,int point,String ownerId) throws Exception;
	public MemberRewardPoint updateMemberRewardPoint(YoubenbenUserContext userContext,String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MemberRewardPoint loadMemberRewardPoint(YoubenbenUserContext userContext, String memberRewardPointId, String [] tokensExpr) throws Exception;
	public MemberRewardPoint internalSaveMemberRewardPoint(YoubenbenUserContext userContext, MemberRewardPoint memberRewardPoint) throws Exception;
	public MemberRewardPoint internalSaveMemberRewardPoint(YoubenbenUserContext userContext, MemberRewardPoint memberRewardPoint,Map<String,Object>option) throws Exception;

	public MemberRewardPoint transferToAnotherOwner(YoubenbenUserContext userContext, String memberRewardPointId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String memberRewardPointId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, MemberRewardPoint newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


