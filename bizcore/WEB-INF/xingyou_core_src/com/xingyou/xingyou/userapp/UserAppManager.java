
package com.xingyou.xingyou.userapp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface UserAppManager extends BaseManager{

		

	public UserApp createUserApp(XingyouUserContext userContext, String title,String secUserId,String appIcon,boolean fullAccess,String permission,String objectType,String objectId,String location) throws Exception;
	public UserApp updateUserApp(XingyouUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserApp loadUserApp(XingyouUserContext userContext, String userAppId, String [] tokensExpr) throws Exception;
	public UserApp internalSaveUserApp(XingyouUserContext userContext, UserApp userApp) throws Exception;
	public UserApp internalSaveUserApp(XingyouUserContext userContext, UserApp userApp,Map<String,Object>option) throws Exception;

	public UserApp transferToAnotherSecUser(XingyouUserContext userContext, String userAppId, String anotherSecUserId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String userAppId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, UserApp newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  QuickLinkManager getQuickLinkManager(XingyouUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget ,String [] tokensExpr)  throws Exception;

	public  UserApp addQuickLink(XingyouUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget , String [] tokensExpr)  throws Exception;
	public  UserApp removeQuickLink(XingyouUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateQuickLink(XingyouUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ListAccessManager getListAccessManager(XingyouUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission ,String [] tokensExpr)  throws Exception;

	public  UserApp addListAccess(XingyouUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission , String [] tokensExpr)  throws Exception;
	public  UserApp removeListAccess(XingyouUserContext userContext, String userAppId, String listAccessId, int listAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateListAccess(XingyouUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listBySecUser(XingyouUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(XingyouUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


