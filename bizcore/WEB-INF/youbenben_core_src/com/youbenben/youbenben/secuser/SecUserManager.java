
package com.youbenben.youbenben.secuser;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SecUserManager extends BaseManager{

		


	public SecUser loadSecUserWithLogin(YoubenbenUserContext userContext, String login, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithEmail(YoubenbenUserContext userContext, String email, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithMobile(YoubenbenUserContext userContext, String mobile, Map<String,Object>tokens) throws Exception;

	 

	public SecUser createSecUser(YoubenbenUserContext userContext, String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String domainId) throws Exception;
	public SecUser updateSecUser(YoubenbenUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUser loadSecUser(YoubenbenUserContext userContext, String secUserId, String [] tokensExpr) throws Exception;
	public SecUser internalSaveSecUser(YoubenbenUserContext userContext, SecUser secUser) throws Exception;
	public SecUser internalSaveSecUser(YoubenbenUserContext userContext, SecUser secUser,Map<String,Object>option) throws Exception;

	public SecUser transferToAnotherDomain(YoubenbenUserContext userContext, String secUserId, String anotherDomainId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String secUserId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SecUser newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  UserAppManager getUserAppManager(YoubenbenUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location ,String [] tokensExpr)  throws Exception;

	public  SecUser addUserApp(YoubenbenUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location , String [] tokensExpr)  throws Exception;
	public  SecUser removeUserApp(YoubenbenUserContext userContext, String secUserId, String userAppId, int userAppVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateUserApp(YoubenbenUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LoginHistoryManager getLoginHistoryManager(YoubenbenUserContext userContext, String secUserId, String fromIp, String description ,String [] tokensExpr)  throws Exception;

	public  SecUser addLoginHistory(YoubenbenUserContext userContext, String secUserId, String fromIp, String description , String [] tokensExpr)  throws Exception;
	public  SecUser removeLoginHistory(YoubenbenUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateLoginHistory(YoubenbenUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatWorkappIdentifyManager getWechatWorkappIdentifyManager(YoubenbenUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatWorkappIdentify(YoubenbenUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatWorkappIdentify(YoubenbenUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatWorkappIdentify(YoubenbenUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatMiniappIdentifyManager getWechatMiniappIdentifyManager(YoubenbenUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatMiniappIdentify(YoubenbenUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatMiniappIdentify(YoubenbenUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatMiniappIdentify(YoubenbenUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  KeypairIdentifyManager getKeypairIdentifyManager(YoubenbenUserContext userContext, String secUserId, String publicKey, String keyTypeId ,String [] tokensExpr)  throws Exception;

	public  SecUser addKeypairIdentify(YoubenbenUserContext userContext, String secUserId, String publicKey, String keyTypeId , String [] tokensExpr)  throws Exception;
	public  SecUser removeKeypairIdentify(YoubenbenUserContext userContext, String secUserId, String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateKeypairIdentify(YoubenbenUserContext userContext, String secUserId, String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(YoubenbenUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(YoubenbenUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


