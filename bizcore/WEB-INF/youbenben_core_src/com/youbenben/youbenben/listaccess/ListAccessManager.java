
package com.youbenben.youbenben.listaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ListAccessManager extends BaseManager{

		

	public ListAccess createListAccess(YoubenbenUserContext userContext, String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission,String appId) throws Exception;
	public ListAccess updateListAccess(YoubenbenUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ListAccess loadListAccess(YoubenbenUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception;
	public ListAccess internalSaveListAccess(YoubenbenUserContext userContext, ListAccess listAccess) throws Exception;
	public ListAccess internalSaveListAccess(YoubenbenUserContext userContext, ListAccess listAccess,Map<String,Object>option) throws Exception;

	public ListAccess transferToAnotherApp(YoubenbenUserContext userContext, String listAccessId, String anotherAppId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String listAccessId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ListAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByApp(YoubenbenUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(YoubenbenUserContext userContext,String appId, int start, int count) throws Exception;
  

}


