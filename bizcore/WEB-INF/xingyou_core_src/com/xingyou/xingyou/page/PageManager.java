
package com.xingyou.xingyou.page;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface PageManager extends BaseManager{

		

	public Page createPage(XingyouUserContext userContext, String pageTitle,String linkToUrl,String pageTypeId,String mobileAppId) throws Exception;
	public Page updatePage(XingyouUserContext userContext,String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Page loadPage(XingyouUserContext userContext, String pageId, String [] tokensExpr) throws Exception;
	public Page internalSavePage(XingyouUserContext userContext, Page page) throws Exception;
	public Page internalSavePage(XingyouUserContext userContext, Page page,Map<String,Object>option) throws Exception;

	public Page transferToAnotherPageType(XingyouUserContext userContext, String pageId, String anotherPageTypeId)  throws Exception;
 	public Page transferToAnotherMobileApp(XingyouUserContext userContext, String pageId, String anotherMobileAppId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String pageId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, Page newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SlideManager getSlideManager(XingyouUserContext userContext, String pageId, int displayOrder, String name, String imageUrl, String videoUrl, String linkToUrl ,String [] tokensExpr)  throws Exception;

	public  Page addSlide(XingyouUserContext userContext, String pageId, int displayOrder, String name, String imageUrl, String videoUrl, String linkToUrl , String [] tokensExpr)  throws Exception;
	public  Page removeSlide(XingyouUserContext userContext, String pageId, String slideId, int slideVersion,String [] tokensExpr)  throws Exception;
	public  Page updateSlide(XingyouUserContext userContext, String pageId, String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  UiActionManager getUiActionManager(XingyouUserContext userContext, String pageId, String code, String icon, String title, String brief, String imageUrl, String linkToUrl, String extraData ,String [] tokensExpr)  throws Exception;

	public  Page addUiAction(XingyouUserContext userContext, String pageId, String code, String icon, String title, String brief, String imageUrl, String linkToUrl, String extraData , String [] tokensExpr)  throws Exception;
	public  Page removeUiAction(XingyouUserContext userContext, String pageId, String uiActionId, int uiActionVersion,String [] tokensExpr)  throws Exception;
	public  Page updateUiAction(XingyouUserContext userContext, String pageId, String uiActionId, int uiActionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SectionManager getSectionManager(XingyouUserContext userContext, String pageId, String title, String brief, String icon, String viewGroup, String linkToUrl ,String [] tokensExpr)  throws Exception;

	public  Page addSection(XingyouUserContext userContext, String pageId, String title, String brief, String icon, String viewGroup, String linkToUrl , String [] tokensExpr)  throws Exception;
	public  Page removeSection(XingyouUserContext userContext, String pageId, String sectionId, int sectionVersion,String [] tokensExpr)  throws Exception;
	public  Page updateSection(XingyouUserContext userContext, String pageId, String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByPageType(XingyouUserContext userContext,String pageTypeId) throws Exception;
	public Object listPageByPageType(XingyouUserContext userContext,String pageTypeId, int start, int count) throws Exception;
  
	public Object listByMobileApp(XingyouUserContext userContext,String mobileAppId) throws Exception;
	public Object listPageByMobileApp(XingyouUserContext userContext,String mobileAppId, int start, int count) throws Exception;
  

}


