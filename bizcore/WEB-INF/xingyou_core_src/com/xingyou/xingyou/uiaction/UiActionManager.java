
package com.xingyou.xingyou.uiaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface UiActionManager extends BaseManager{

		

	public UiAction createUiAction(XingyouUserContext userContext, String code,String icon,String title,String brief,String imageUrl,String linkToUrl,String extraData,String pageId) throws Exception;
	public UiAction updateUiAction(XingyouUserContext userContext,String uiActionId, int uiActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UiAction loadUiAction(XingyouUserContext userContext, String uiActionId, String [] tokensExpr) throws Exception;
	public UiAction internalSaveUiAction(XingyouUserContext userContext, UiAction uiAction) throws Exception;
	public UiAction internalSaveUiAction(XingyouUserContext userContext, UiAction uiAction,Map<String,Object>option) throws Exception;

	public UiAction transferToAnotherPage(XingyouUserContext userContext, String uiActionId, String anotherPageId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String uiActionId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, UiAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(XingyouUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(XingyouUserContext userContext,String pageId, int start, int count) throws Exception;
  

}


