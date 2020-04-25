
package com.youbenben.youbenben.publickeytype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface PublicKeyTypeManager extends BaseManager{

		

	public PublicKeyType createPublicKeyType(YoubenbenUserContext userContext, String name,String code,String domainId) throws Exception;
	public PublicKeyType updatePublicKeyType(YoubenbenUserContext userContext,String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PublicKeyType loadPublicKeyType(YoubenbenUserContext userContext, String publicKeyTypeId, String [] tokensExpr) throws Exception;
	public PublicKeyType internalSavePublicKeyType(YoubenbenUserContext userContext, PublicKeyType publicKeyType) throws Exception;
	public PublicKeyType internalSavePublicKeyType(YoubenbenUserContext userContext, PublicKeyType publicKeyType,Map<String,Object>option) throws Exception;

	public PublicKeyType transferToAnotherDomain(YoubenbenUserContext userContext, String publicKeyTypeId, String anotherDomainId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String publicKeyTypeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, PublicKeyType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  KeypairIdentifyManager getKeypairIdentifyManager(YoubenbenUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId ,String [] tokensExpr)  throws Exception;

	public  PublicKeyType addKeypairIdentify(YoubenbenUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId , String [] tokensExpr)  throws Exception;
	public  PublicKeyType removeKeypairIdentify(YoubenbenUserContext userContext, String publicKeyTypeId, String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  PublicKeyType updateKeypairIdentify(YoubenbenUserContext userContext, String publicKeyTypeId, String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(YoubenbenUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(YoubenbenUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


