
package com.xingyou.xingyou.pagetype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface PageTypeManager extends BaseManager{

		


	public PageType loadPageTypeWithCode(XingyouUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public PageType createPageType(XingyouUserContext userContext, String name,String code,String mobileAppId,boolean footerTab) throws Exception;
	public PageType updatePageType(XingyouUserContext userContext,String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PageType loadPageType(XingyouUserContext userContext, String pageTypeId, String [] tokensExpr) throws Exception;
	public PageType internalSavePageType(XingyouUserContext userContext, PageType pageType) throws Exception;
	public PageType internalSavePageType(XingyouUserContext userContext, PageType pageType,Map<String,Object>option) throws Exception;

	public PageType transferToAnotherMobileApp(XingyouUserContext userContext, String pageTypeId, String anotherMobileAppId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String pageTypeId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, PageType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PageManager getPageManager(XingyouUserContext userContext, String pageTypeId, String pageTitle, String linkToUrl, String mobileAppId ,String [] tokensExpr)  throws Exception;

	public  PageType addPage(XingyouUserContext userContext, String pageTypeId, String pageTitle, String linkToUrl, String mobileAppId , String [] tokensExpr)  throws Exception;
	public  PageType removePage(XingyouUserContext userContext, String pageTypeId, String pageId, int pageVersion,String [] tokensExpr)  throws Exception;
	public  PageType updatePage(XingyouUserContext userContext, String pageTypeId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByMobileApp(XingyouUserContext userContext,String mobileAppId) throws Exception;
	public Object listPageByMobileApp(XingyouUserContext userContext,String mobileAppId, int start, int count) throws Exception;
  

}


