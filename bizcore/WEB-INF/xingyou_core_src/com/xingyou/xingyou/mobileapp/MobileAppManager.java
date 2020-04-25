
package com.xingyou.xingyou.mobileapp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface MobileAppManager extends BaseManager{

		

	public MobileApp createMobileApp(XingyouUserContext userContext, String name) throws Exception;
	public MobileApp updateMobileApp(XingyouUserContext userContext,String mobileAppId, int mobileAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MobileApp loadMobileApp(XingyouUserContext userContext, String mobileAppId, String [] tokensExpr) throws Exception;
	public MobileApp internalSaveMobileApp(XingyouUserContext userContext, MobileApp mobileApp) throws Exception;
	public MobileApp internalSaveMobileApp(XingyouUserContext userContext, MobileApp mobileApp,Map<String,Object>option) throws Exception;



	public void delete(XingyouUserContext userContext, String mobileAppId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, MobileApp newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PageManager getPageManager(XingyouUserContext userContext, String mobileAppId, String pageTitle, String linkToUrl, String pageTypeId ,String [] tokensExpr)  throws Exception;

	public  MobileApp addPage(XingyouUserContext userContext, String mobileAppId, String pageTitle, String linkToUrl, String pageTypeId , String [] tokensExpr)  throws Exception;
	public  MobileApp removePage(XingyouUserContext userContext, String mobileAppId, String pageId, int pageVersion,String [] tokensExpr)  throws Exception;
	public  MobileApp updatePage(XingyouUserContext userContext, String mobileAppId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PageTypeManager getPageTypeManager(XingyouUserContext userContext, String mobileAppId, String name, String code, boolean footerTab ,String [] tokensExpr)  throws Exception;

	public  MobileApp addPageType(XingyouUserContext userContext, String mobileAppId, String name, String code, boolean footerTab , String [] tokensExpr)  throws Exception;
	public  MobileApp removePageType(XingyouUserContext userContext, String mobileAppId, String pageTypeId, int pageTypeVersion,String [] tokensExpr)  throws Exception;
	public  MobileApp updatePageType(XingyouUserContext userContext, String mobileAppId, String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


