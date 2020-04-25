
package com.xingyou.xingyou.loginhistory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface LoginHistoryManager extends BaseManager{

		

	public LoginHistory createLoginHistory(XingyouUserContext userContext, String fromIp,String description,String secUserId) throws Exception;
	public LoginHistory updateLoginHistory(XingyouUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LoginHistory loadLoginHistory(XingyouUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception;
	public LoginHistory internalSaveLoginHistory(XingyouUserContext userContext, LoginHistory loginHistory) throws Exception;
	public LoginHistory internalSaveLoginHistory(XingyouUserContext userContext, LoginHistory loginHistory,Map<String,Object>option) throws Exception;

	public LoginHistory transferToAnotherSecUser(XingyouUserContext userContext, String loginHistoryId, String anotherSecUserId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String loginHistoryId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, LoginHistory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(XingyouUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(XingyouUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


