
package com.youbenben.youbenben.uiaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface UiActionManager extends BaseManager{

		

	public UiAction createUiAction(YoubenbenUserContext userContext, String code,String icon,String title,String brief,String imageUrl,String linkToUrl,String extraData,String pageId) throws Exception;
	public UiAction updateUiAction(YoubenbenUserContext userContext,String uiActionId, int uiActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UiAction loadUiAction(YoubenbenUserContext userContext, String uiActionId, String [] tokensExpr) throws Exception;
	public UiAction internalSaveUiAction(YoubenbenUserContext userContext, UiAction uiAction) throws Exception;
	public UiAction internalSaveUiAction(YoubenbenUserContext userContext, UiAction uiAction,Map<String,Object>option) throws Exception;

	public UiAction transferToAnotherPage(YoubenbenUserContext userContext, String uiActionId, String anotherPageId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String uiActionId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, UiAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(YoubenbenUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(YoubenbenUserContext userContext,String pageId, int start, int count) throws Exception;
  

}


