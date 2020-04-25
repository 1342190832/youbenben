
package com.youbenben.youbenben.wechatminiappidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface WechatMiniappIdentifyManager extends BaseManager{

		

	public WechatMiniappIdentify createWechatMiniappIdentify(YoubenbenUserContext userContext, String openId,String appId,String secUserId,DateTime lastLoginTime) throws Exception;
	public WechatMiniappIdentify updateWechatMiniappIdentify(YoubenbenUserContext userContext,String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatMiniappIdentify loadWechatMiniappIdentify(YoubenbenUserContext userContext, String wechatMiniappIdentifyId, String [] tokensExpr) throws Exception;
	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(YoubenbenUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify) throws Exception;
	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(YoubenbenUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify,Map<String,Object>option) throws Exception;

	public WechatMiniappIdentify transferToAnotherSecUser(YoubenbenUserContext userContext, String wechatMiniappIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String wechatMiniappIdentifyId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, WechatMiniappIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(YoubenbenUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(YoubenbenUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


