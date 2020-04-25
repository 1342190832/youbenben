
package com.youbenben.youbenben.userwhitelist;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface UserWhiteListManager extends BaseManager{

		

	public UserWhiteList createUserWhiteList(YoubenbenUserContext userContext, String userIdentity,String userSpecialFunctions,String domainId) throws Exception;
	public UserWhiteList updateUserWhiteList(YoubenbenUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserWhiteList loadUserWhiteList(YoubenbenUserContext userContext, String userWhiteListId, String [] tokensExpr) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(YoubenbenUserContext userContext, UserWhiteList userWhiteList) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(YoubenbenUserContext userContext, UserWhiteList userWhiteList,Map<String,Object>option) throws Exception;

	public UserWhiteList transferToAnotherDomain(YoubenbenUserContext userContext, String userWhiteListId, String anotherDomainId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String userWhiteListId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, UserWhiteList newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByDomain(YoubenbenUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(YoubenbenUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


