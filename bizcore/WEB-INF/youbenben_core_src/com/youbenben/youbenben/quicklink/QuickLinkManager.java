
package com.youbenben.youbenben.quicklink;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface QuickLinkManager extends BaseManager{

		

	public QuickLink createQuickLink(YoubenbenUserContext userContext, String name,String icon,String imagePath,String linkTarget,String appId) throws Exception;
	public QuickLink updateQuickLink(YoubenbenUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public QuickLink loadQuickLink(YoubenbenUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception;
	public QuickLink internalSaveQuickLink(YoubenbenUserContext userContext, QuickLink quickLink) throws Exception;
	public QuickLink internalSaveQuickLink(YoubenbenUserContext userContext, QuickLink quickLink,Map<String,Object>option) throws Exception;

	public QuickLink transferToAnotherApp(YoubenbenUserContext userContext, String quickLinkId, String anotherAppId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String quickLinkId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, QuickLink newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByApp(YoubenbenUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(YoubenbenUserContext userContext,String appId, int start, int count) throws Exception;
  

}


