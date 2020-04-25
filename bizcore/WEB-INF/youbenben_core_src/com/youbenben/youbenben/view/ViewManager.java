
package com.youbenben.youbenben.view;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ViewManager extends BaseManager{

		

	public View createView(YoubenbenUserContext userContext, String who,String assessment,Date interviewTime) throws Exception;
	public View updateView(YoubenbenUserContext userContext,String viewId, int viewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public View loadView(YoubenbenUserContext userContext, String viewId, String [] tokensExpr) throws Exception;
	public View internalSaveView(YoubenbenUserContext userContext, View view) throws Exception;
	public View internalSaveView(YoubenbenUserContext userContext, View view,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String viewId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, View newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}


