
package com.youbenben.youbenben.keypairidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface KeypairIdentifyManager extends BaseManager{

		

	public KeypairIdentify createKeypairIdentify(YoubenbenUserContext userContext, String publicKey,String keyTypeId,String secUserId) throws Exception;
	public KeypairIdentify updateKeypairIdentify(YoubenbenUserContext userContext,String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public KeypairIdentify loadKeypairIdentify(YoubenbenUserContext userContext, String keypairIdentifyId, String [] tokensExpr) throws Exception;
	public KeypairIdentify internalSaveKeypairIdentify(YoubenbenUserContext userContext, KeypairIdentify keypairIdentify) throws Exception;
	public KeypairIdentify internalSaveKeypairIdentify(YoubenbenUserContext userContext, KeypairIdentify keypairIdentify,Map<String,Object>option) throws Exception;

	public KeypairIdentify transferToAnotherKeyType(YoubenbenUserContext userContext, String keypairIdentifyId, String anotherKeyTypeId)  throws Exception;
 	public KeypairIdentify transferToAnotherSecUser(YoubenbenUserContext userContext, String keypairIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String keypairIdentifyId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, KeypairIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByKeyType(YoubenbenUserContext userContext,String keyTypeId) throws Exception;
	public Object listPageByKeyType(YoubenbenUserContext userContext,String keyTypeId, int start, int count) throws Exception;
  
	public Object listBySecUser(YoubenbenUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(YoubenbenUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


