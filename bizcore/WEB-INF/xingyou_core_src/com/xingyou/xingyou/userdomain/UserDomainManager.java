
package com.xingyou.xingyou.userdomain;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface UserDomainManager extends BaseManager{

		

	public UserDomain createUserDomain(XingyouUserContext userContext, String name) throws Exception;
	public UserDomain updateUserDomain(XingyouUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserDomain loadUserDomain(XingyouUserContext userContext, String userDomainId, String [] tokensExpr) throws Exception;
	public UserDomain internalSaveUserDomain(XingyouUserContext userContext, UserDomain userDomain) throws Exception;
	public UserDomain internalSaveUserDomain(XingyouUserContext userContext, UserDomain userDomain,Map<String,Object>option) throws Exception;



	public void delete(XingyouUserContext userContext, String userDomainId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, UserDomain newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  UserWhiteListManager getUserWhiteListManager(XingyouUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions ,String [] tokensExpr)  throws Exception;

	public  UserDomain addUserWhiteList(XingyouUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions , String [] tokensExpr)  throws Exception;
	public  UserDomain removeUserWhiteList(XingyouUserContext userContext, String userDomainId, String userWhiteListId, int userWhiteListVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateUserWhiteList(XingyouUserContext userContext, String userDomainId, String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SecUserManager getSecUserManager(XingyouUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  UserDomain addSecUser(XingyouUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  UserDomain removeSecUser(XingyouUserContext userContext, String userDomainId, String secUserId, int secUserVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateSecUser(XingyouUserContext userContext, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PublicKeyTypeManager getPublicKeyTypeManager(XingyouUserContext userContext, String userDomainId, String name, String code ,String [] tokensExpr)  throws Exception;

	public  UserDomain addPublicKeyType(XingyouUserContext userContext, String userDomainId, String name, String code , String [] tokensExpr)  throws Exception;
	public  UserDomain removePublicKeyType(XingyouUserContext userContext, String userDomainId, String publicKeyTypeId, int publicKeyTypeVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updatePublicKeyType(XingyouUserContext userContext, String userDomainId, String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


