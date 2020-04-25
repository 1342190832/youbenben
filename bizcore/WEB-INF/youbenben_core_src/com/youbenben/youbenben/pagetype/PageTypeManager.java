
package com.youbenben.youbenben.pagetype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface PageTypeManager extends BaseManager{

		


	public PageType loadPageTypeWithCode(YoubenbenUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public PageType createPageType(YoubenbenUserContext userContext, String name,String code,String mobileAppId,boolean footerTab) throws Exception;
	public PageType updatePageType(YoubenbenUserContext userContext,String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PageType loadPageType(YoubenbenUserContext userContext, String pageTypeId, String [] tokensExpr) throws Exception;
	public PageType internalSavePageType(YoubenbenUserContext userContext, PageType pageType) throws Exception;
	public PageType internalSavePageType(YoubenbenUserContext userContext, PageType pageType,Map<String,Object>option) throws Exception;

	public PageType transferToAnotherMobileApp(YoubenbenUserContext userContext, String pageTypeId, String anotherMobileAppId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String pageTypeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, PageType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PageManager getPageManager(YoubenbenUserContext userContext, String pageTypeId, String pageTitle, String linkToUrl, String mobileAppId ,String [] tokensExpr)  throws Exception;

	public  PageType addPage(YoubenbenUserContext userContext, String pageTypeId, String pageTitle, String linkToUrl, String mobileAppId , String [] tokensExpr)  throws Exception;
	public  PageType removePage(YoubenbenUserContext userContext, String pageTypeId, String pageId, int pageVersion,String [] tokensExpr)  throws Exception;
	public  PageType updatePage(YoubenbenUserContext userContext, String pageTypeId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByMobileApp(YoubenbenUserContext userContext,String mobileAppId) throws Exception;
	public Object listPageByMobileApp(YoubenbenUserContext userContext,String mobileAppId, int start, int count) throws Exception;
  

}


