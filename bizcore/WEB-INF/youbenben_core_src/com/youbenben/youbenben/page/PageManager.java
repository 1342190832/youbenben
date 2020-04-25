
package com.youbenben.youbenben.page;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface PageManager extends BaseManager{

		

	public Page createPage(YoubenbenUserContext userContext, String pageTitle,String linkToUrl,String pageTypeId,String mobileAppId) throws Exception;
	public Page updatePage(YoubenbenUserContext userContext,String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Page loadPage(YoubenbenUserContext userContext, String pageId, String [] tokensExpr) throws Exception;
	public Page internalSavePage(YoubenbenUserContext userContext, Page page) throws Exception;
	public Page internalSavePage(YoubenbenUserContext userContext, Page page,Map<String,Object>option) throws Exception;

	public Page transferToAnotherPageType(YoubenbenUserContext userContext, String pageId, String anotherPageTypeId)  throws Exception;
 	public Page transferToAnotherMobileApp(YoubenbenUserContext userContext, String pageId, String anotherMobileAppId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String pageId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, Page newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SlideManager getSlideManager(YoubenbenUserContext userContext, String pageId, int displayOrder, String name, String imageUrl, String videoUrl, String linkToUrl ,String [] tokensExpr)  throws Exception;

	public  Page addSlide(YoubenbenUserContext userContext, String pageId, int displayOrder, String name, String imageUrl, String videoUrl, String linkToUrl , String [] tokensExpr)  throws Exception;
	public  Page removeSlide(YoubenbenUserContext userContext, String pageId, String slideId, int slideVersion,String [] tokensExpr)  throws Exception;
	public  Page updateSlide(YoubenbenUserContext userContext, String pageId, String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  UiActionManager getUiActionManager(YoubenbenUserContext userContext, String pageId, String code, String icon, String title, String brief, String imageUrl, String linkToUrl, String extraData ,String [] tokensExpr)  throws Exception;

	public  Page addUiAction(YoubenbenUserContext userContext, String pageId, String code, String icon, String title, String brief, String imageUrl, String linkToUrl, String extraData , String [] tokensExpr)  throws Exception;
	public  Page removeUiAction(YoubenbenUserContext userContext, String pageId, String uiActionId, int uiActionVersion,String [] tokensExpr)  throws Exception;
	public  Page updateUiAction(YoubenbenUserContext userContext, String pageId, String uiActionId, int uiActionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SectionManager getSectionManager(YoubenbenUserContext userContext, String pageId, String title, String brief, String icon, String viewGroup, String linkToUrl ,String [] tokensExpr)  throws Exception;

	public  Page addSection(YoubenbenUserContext userContext, String pageId, String title, String brief, String icon, String viewGroup, String linkToUrl , String [] tokensExpr)  throws Exception;
	public  Page removeSection(YoubenbenUserContext userContext, String pageId, String sectionId, int sectionVersion,String [] tokensExpr)  throws Exception;
	public  Page updateSection(YoubenbenUserContext userContext, String pageId, String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByPageType(YoubenbenUserContext userContext,String pageTypeId) throws Exception;
	public Object listPageByPageType(YoubenbenUserContext userContext,String pageTypeId, int start, int count) throws Exception;
  
	public Object listByMobileApp(YoubenbenUserContext userContext,String mobileAppId) throws Exception;
	public Object listPageByMobileApp(YoubenbenUserContext userContext,String mobileAppId, int start, int count) throws Exception;
  

}


