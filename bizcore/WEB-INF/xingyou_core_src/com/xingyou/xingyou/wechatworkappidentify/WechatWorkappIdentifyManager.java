
package com.xingyou.xingyou.wechatworkappidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface WechatWorkappIdentifyManager extends BaseManager{

		

	public WechatWorkappIdentify createWechatWorkappIdentify(XingyouUserContext userContext, String corpId,String userId,String secUserId,DateTime lastLoginTime) throws Exception;
	public WechatWorkappIdentify updateWechatWorkappIdentify(XingyouUserContext userContext,String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatWorkappIdentify loadWechatWorkappIdentify(XingyouUserContext userContext, String wechatWorkappIdentifyId, String [] tokensExpr) throws Exception;
	public WechatWorkappIdentify internalSaveWechatWorkappIdentify(XingyouUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify) throws Exception;
	public WechatWorkappIdentify internalSaveWechatWorkappIdentify(XingyouUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify,Map<String,Object>option) throws Exception;

	public WechatWorkappIdentify transferToAnotherSecUser(XingyouUserContext userContext, String wechatWorkappIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String wechatWorkappIdentifyId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, WechatWorkappIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(XingyouUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(XingyouUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


