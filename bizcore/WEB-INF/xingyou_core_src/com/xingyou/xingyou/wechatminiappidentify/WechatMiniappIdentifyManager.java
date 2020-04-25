
package com.xingyou.xingyou.wechatminiappidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface WechatMiniappIdentifyManager extends BaseManager{

		

	public WechatMiniappIdentify createWechatMiniappIdentify(XingyouUserContext userContext, String openId,String appId,String secUserId,DateTime lastLoginTime) throws Exception;
	public WechatMiniappIdentify updateWechatMiniappIdentify(XingyouUserContext userContext,String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatMiniappIdentify loadWechatMiniappIdentify(XingyouUserContext userContext, String wechatMiniappIdentifyId, String [] tokensExpr) throws Exception;
	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(XingyouUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify) throws Exception;
	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(XingyouUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify,Map<String,Object>option) throws Exception;

	public WechatMiniappIdentify transferToAnotherSecUser(XingyouUserContext userContext, String wechatMiniappIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String wechatMiniappIdentifyId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, WechatMiniappIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(XingyouUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(XingyouUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


