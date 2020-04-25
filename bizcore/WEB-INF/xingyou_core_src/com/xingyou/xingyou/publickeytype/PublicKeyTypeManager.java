
package com.xingyou.xingyou.publickeytype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface PublicKeyTypeManager extends BaseManager{

		

	public PublicKeyType createPublicKeyType(XingyouUserContext userContext, String name,String code,String domainId) throws Exception;
	public PublicKeyType updatePublicKeyType(XingyouUserContext userContext,String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PublicKeyType loadPublicKeyType(XingyouUserContext userContext, String publicKeyTypeId, String [] tokensExpr) throws Exception;
	public PublicKeyType internalSavePublicKeyType(XingyouUserContext userContext, PublicKeyType publicKeyType) throws Exception;
	public PublicKeyType internalSavePublicKeyType(XingyouUserContext userContext, PublicKeyType publicKeyType,Map<String,Object>option) throws Exception;

	public PublicKeyType transferToAnotherDomain(XingyouUserContext userContext, String publicKeyTypeId, String anotherDomainId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String publicKeyTypeId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, PublicKeyType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  KeypairIdentifyManager getKeypairIdentifyManager(XingyouUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId ,String [] tokensExpr)  throws Exception;

	public  PublicKeyType addKeypairIdentify(XingyouUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId , String [] tokensExpr)  throws Exception;
	public  PublicKeyType removeKeypairIdentify(XingyouUserContext userContext, String publicKeyTypeId, String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  PublicKeyType updateKeypairIdentify(XingyouUserContext userContext, String publicKeyTypeId, String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(XingyouUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(XingyouUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


