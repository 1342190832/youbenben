
package com.doublechaintech.his.publickeytype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface PublicKeyTypeManager extends BaseManager{

		

	public PublicKeyType createPublicKeyType(HisUserContext userContext, String name,String code,String domainId) throws Exception;
	public PublicKeyType updatePublicKeyType(HisUserContext userContext,String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PublicKeyType loadPublicKeyType(HisUserContext userContext, String publicKeyTypeId, String [] tokensExpr) throws Exception;
	public PublicKeyType internalSavePublicKeyType(HisUserContext userContext, PublicKeyType publicKeyType) throws Exception;
	public PublicKeyType internalSavePublicKeyType(HisUserContext userContext, PublicKeyType publicKeyType,Map<String,Object>option) throws Exception;

	public PublicKeyType transferToAnotherDomain(HisUserContext userContext, String publicKeyTypeId, String anotherDomainId)  throws Exception;
 

	public void delete(HisUserContext userContext, String publicKeyTypeId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, PublicKeyType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  KeypairIdentifyManager getKeypairIdentifyManager(HisUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId ,String [] tokensExpr)  throws Exception;

	public  PublicKeyType addKeypairIdentify(HisUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId , String [] tokensExpr)  throws Exception;
	public  PublicKeyType removeKeypairIdentify(HisUserContext userContext, String publicKeyTypeId, String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  PublicKeyType updateKeypairIdentify(HisUserContext userContext, String publicKeyTypeId, String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(HisUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(HisUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


