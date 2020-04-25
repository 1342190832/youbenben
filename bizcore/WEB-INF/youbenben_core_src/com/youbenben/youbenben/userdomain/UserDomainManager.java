
package com.youbenben.youbenben.userdomain;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface UserDomainManager extends BaseManager{

		

	public UserDomain createUserDomain(YoubenbenUserContext userContext, String name) throws Exception;
	public UserDomain updateUserDomain(YoubenbenUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserDomain loadUserDomain(YoubenbenUserContext userContext, String userDomainId, String [] tokensExpr) throws Exception;
	public UserDomain internalSaveUserDomain(YoubenbenUserContext userContext, UserDomain userDomain) throws Exception;
	public UserDomain internalSaveUserDomain(YoubenbenUserContext userContext, UserDomain userDomain,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String userDomainId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, UserDomain newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  UserWhiteListManager getUserWhiteListManager(YoubenbenUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions ,String [] tokensExpr)  throws Exception;

	public  UserDomain addUserWhiteList(YoubenbenUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions , String [] tokensExpr)  throws Exception;
	public  UserDomain removeUserWhiteList(YoubenbenUserContext userContext, String userDomainId, String userWhiteListId, int userWhiteListVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateUserWhiteList(YoubenbenUserContext userContext, String userDomainId, String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SecUserManager getSecUserManager(YoubenbenUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  UserDomain addSecUser(YoubenbenUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  UserDomain removeSecUser(YoubenbenUserContext userContext, String userDomainId, String secUserId, int secUserVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateSecUser(YoubenbenUserContext userContext, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PublicKeyTypeManager getPublicKeyTypeManager(YoubenbenUserContext userContext, String userDomainId, String name, String code ,String [] tokensExpr)  throws Exception;

	public  UserDomain addPublicKeyType(YoubenbenUserContext userContext, String userDomainId, String name, String code , String [] tokensExpr)  throws Exception;
	public  UserDomain removePublicKeyType(YoubenbenUserContext userContext, String userDomainId, String publicKeyTypeId, int publicKeyTypeVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updatePublicKeyType(YoubenbenUserContext userContext, String userDomainId, String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


