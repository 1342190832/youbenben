
package com.youbenben.youbenben.mobileapp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface MobileAppManager extends BaseManager{

		

	public MobileApp createMobileApp(YoubenbenUserContext userContext, String name) throws Exception;
	public MobileApp updateMobileApp(YoubenbenUserContext userContext,String mobileAppId, int mobileAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MobileApp loadMobileApp(YoubenbenUserContext userContext, String mobileAppId, String [] tokensExpr) throws Exception;
	public MobileApp internalSaveMobileApp(YoubenbenUserContext userContext, MobileApp mobileApp) throws Exception;
	public MobileApp internalSaveMobileApp(YoubenbenUserContext userContext, MobileApp mobileApp,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String mobileAppId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, MobileApp newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PageManager getPageManager(YoubenbenUserContext userContext, String mobileAppId, String pageTitle, String linkToUrl, String pageTypeId ,String [] tokensExpr)  throws Exception;

	public  MobileApp addPage(YoubenbenUserContext userContext, String mobileAppId, String pageTitle, String linkToUrl, String pageTypeId , String [] tokensExpr)  throws Exception;
	public  MobileApp removePage(YoubenbenUserContext userContext, String mobileAppId, String pageId, int pageVersion,String [] tokensExpr)  throws Exception;
	public  MobileApp updatePage(YoubenbenUserContext userContext, String mobileAppId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PageTypeManager getPageTypeManager(YoubenbenUserContext userContext, String mobileAppId, String name, String code, boolean footerTab ,String [] tokensExpr)  throws Exception;

	public  MobileApp addPageType(YoubenbenUserContext userContext, String mobileAppId, String name, String code, boolean footerTab , String [] tokensExpr)  throws Exception;
	public  MobileApp removePageType(YoubenbenUserContext userContext, String mobileAppId, String pageTypeId, int pageTypeVersion,String [] tokensExpr)  throws Exception;
	public  MobileApp updatePageType(YoubenbenUserContext userContext, String mobileAppId, String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


