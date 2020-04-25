
package com.xingyou.xingyou.secuser;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface SecUserManager extends BaseManager{

		


	public SecUser loadSecUserWithLogin(XingyouUserContext userContext, String login, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithEmail(XingyouUserContext userContext, String email, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithMobile(XingyouUserContext userContext, String mobile, Map<String,Object>tokens) throws Exception;

	 

	public SecUser createSecUser(XingyouUserContext userContext, String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String domainId) throws Exception;
	public SecUser updateSecUser(XingyouUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUser loadSecUser(XingyouUserContext userContext, String secUserId, String [] tokensExpr) throws Exception;
	public SecUser internalSaveSecUser(XingyouUserContext userContext, SecUser secUser) throws Exception;
	public SecUser internalSaveSecUser(XingyouUserContext userContext, SecUser secUser,Map<String,Object>option) throws Exception;

	public SecUser transferToAnotherDomain(XingyouUserContext userContext, String secUserId, String anotherDomainId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String secUserId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, SecUser newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  UserAppManager getUserAppManager(XingyouUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location ,String [] tokensExpr)  throws Exception;

	public  SecUser addUserApp(XingyouUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location , String [] tokensExpr)  throws Exception;
	public  SecUser removeUserApp(XingyouUserContext userContext, String secUserId, String userAppId, int userAppVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateUserApp(XingyouUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LoginHistoryManager getLoginHistoryManager(XingyouUserContext userContext, String secUserId, String fromIp, String description ,String [] tokensExpr)  throws Exception;

	public  SecUser addLoginHistory(XingyouUserContext userContext, String secUserId, String fromIp, String description , String [] tokensExpr)  throws Exception;
	public  SecUser removeLoginHistory(XingyouUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateLoginHistory(XingyouUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatWorkappIdentifyManager getWechatWorkappIdentifyManager(XingyouUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatWorkappIdentify(XingyouUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatWorkappIdentify(XingyouUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatWorkappIdentify(XingyouUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatMiniappIdentifyManager getWechatMiniappIdentifyManager(XingyouUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatMiniappIdentify(XingyouUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatMiniappIdentify(XingyouUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatMiniappIdentify(XingyouUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  KeypairIdentifyManager getKeypairIdentifyManager(XingyouUserContext userContext, String secUserId, String publicKey, String keyTypeId ,String [] tokensExpr)  throws Exception;

	public  SecUser addKeypairIdentify(XingyouUserContext userContext, String secUserId, String publicKey, String keyTypeId , String [] tokensExpr)  throws Exception;
	public  SecUser removeKeypairIdentify(XingyouUserContext userContext, String secUserId, String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateKeypairIdentify(XingyouUserContext userContext, String secUserId, String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(XingyouUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(XingyouUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


