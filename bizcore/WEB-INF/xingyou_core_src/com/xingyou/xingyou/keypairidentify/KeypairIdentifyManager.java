
package com.xingyou.xingyou.keypairidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface KeypairIdentifyManager extends BaseManager{

		

	public KeypairIdentify createKeypairIdentify(XingyouUserContext userContext, String publicKey,String keyTypeId,String secUserId) throws Exception;
	public KeypairIdentify updateKeypairIdentify(XingyouUserContext userContext,String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public KeypairIdentify loadKeypairIdentify(XingyouUserContext userContext, String keypairIdentifyId, String [] tokensExpr) throws Exception;
	public KeypairIdentify internalSaveKeypairIdentify(XingyouUserContext userContext, KeypairIdentify keypairIdentify) throws Exception;
	public KeypairIdentify internalSaveKeypairIdentify(XingyouUserContext userContext, KeypairIdentify keypairIdentify,Map<String,Object>option) throws Exception;

	public KeypairIdentify transferToAnotherKeyType(XingyouUserContext userContext, String keypairIdentifyId, String anotherKeyTypeId)  throws Exception;
 	public KeypairIdentify transferToAnotherSecUser(XingyouUserContext userContext, String keypairIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String keypairIdentifyId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, KeypairIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByKeyType(XingyouUserContext userContext,String keyTypeId) throws Exception;
	public Object listPageByKeyType(XingyouUserContext userContext,String keyTypeId, int start, int count) throws Exception;
  
	public Object listBySecUser(XingyouUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(XingyouUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


