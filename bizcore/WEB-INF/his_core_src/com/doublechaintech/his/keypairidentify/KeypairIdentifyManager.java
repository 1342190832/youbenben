
package com.doublechaintech.his.keypairidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.his.HisUserContext;
import com.doublechaintech.his.BaseEntity;
import com.doublechaintech.his.BaseManager;
import com.doublechaintech.his.SmartList;

public interface KeypairIdentifyManager extends BaseManager{

		

	public KeypairIdentify createKeypairIdentify(HisUserContext userContext, String publicKey,String keyTypeId,String secUserId) throws Exception;
	public KeypairIdentify updateKeypairIdentify(HisUserContext userContext,String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public KeypairIdentify loadKeypairIdentify(HisUserContext userContext, String keypairIdentifyId, String [] tokensExpr) throws Exception;
	public KeypairIdentify internalSaveKeypairIdentify(HisUserContext userContext, KeypairIdentify keypairIdentify) throws Exception;
	public KeypairIdentify internalSaveKeypairIdentify(HisUserContext userContext, KeypairIdentify keypairIdentify,Map<String,Object>option) throws Exception;

	public KeypairIdentify transferToAnotherKeyType(HisUserContext userContext, String keypairIdentifyId, String anotherKeyTypeId)  throws Exception;
 	public KeypairIdentify transferToAnotherSecUser(HisUserContext userContext, String keypairIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(HisUserContext userContext, String keypairIdentifyId, int version) throws Exception;
	public int deleteAll(HisUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HisUserContext userContext, KeypairIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByKeyType(HisUserContext userContext,String keyTypeId) throws Exception;
	public Object listPageByKeyType(HisUserContext userContext,String keyTypeId, int start, int count) throws Exception;
  
	public Object listBySecUser(HisUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(HisUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


