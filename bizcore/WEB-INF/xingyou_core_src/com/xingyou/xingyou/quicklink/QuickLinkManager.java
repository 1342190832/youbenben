
package com.xingyou.xingyou.quicklink;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface QuickLinkManager extends BaseManager{

		

	public QuickLink createQuickLink(XingyouUserContext userContext, String name,String icon,String imagePath,String linkTarget,String appId) throws Exception;
	public QuickLink updateQuickLink(XingyouUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public QuickLink loadQuickLink(XingyouUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception;
	public QuickLink internalSaveQuickLink(XingyouUserContext userContext, QuickLink quickLink) throws Exception;
	public QuickLink internalSaveQuickLink(XingyouUserContext userContext, QuickLink quickLink,Map<String,Object>option) throws Exception;

	public QuickLink transferToAnotherApp(XingyouUserContext userContext, String quickLinkId, String anotherAppId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String quickLinkId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, QuickLink newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByApp(XingyouUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(XingyouUserContext userContext,String appId, int start, int count) throws Exception;
  

}


