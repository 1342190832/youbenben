
package com.xingyou.xingyou.listaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface ListAccessManager extends BaseManager{

		

	public ListAccess createListAccess(XingyouUserContext userContext, String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission,String appId) throws Exception;
	public ListAccess updateListAccess(XingyouUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ListAccess loadListAccess(XingyouUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception;
	public ListAccess internalSaveListAccess(XingyouUserContext userContext, ListAccess listAccess) throws Exception;
	public ListAccess internalSaveListAccess(XingyouUserContext userContext, ListAccess listAccess,Map<String,Object>option) throws Exception;

	public ListAccess transferToAnotherApp(XingyouUserContext userContext, String listAccessId, String anotherAppId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String listAccessId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, ListAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByApp(XingyouUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(XingyouUserContext userContext,String appId, int start, int count) throws Exception;
  

}


