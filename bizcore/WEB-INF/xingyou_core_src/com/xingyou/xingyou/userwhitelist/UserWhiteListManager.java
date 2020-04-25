
package com.xingyou.xingyou.userwhitelist;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface UserWhiteListManager extends BaseManager{

		

	public UserWhiteList createUserWhiteList(XingyouUserContext userContext, String userIdentity,String userSpecialFunctions,String domainId) throws Exception;
	public UserWhiteList updateUserWhiteList(XingyouUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserWhiteList loadUserWhiteList(XingyouUserContext userContext, String userWhiteListId, String [] tokensExpr) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(XingyouUserContext userContext, UserWhiteList userWhiteList) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(XingyouUserContext userContext, UserWhiteList userWhiteList,Map<String,Object>option) throws Exception;

	public UserWhiteList transferToAnotherDomain(XingyouUserContext userContext, String userWhiteListId, String anotherDomainId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String userWhiteListId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, UserWhiteList newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByDomain(XingyouUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(XingyouUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


