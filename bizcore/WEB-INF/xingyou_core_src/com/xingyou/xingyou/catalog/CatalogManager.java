
package com.xingyou.xingyou.catalog;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface CatalogManager extends BaseManager{

		

	public Catalog createCatalog(XingyouUserContext userContext, String name,String ownerId,int subCount,BigDecimal amount) throws Exception;
	public Catalog updateCatalog(XingyouUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Catalog loadCatalog(XingyouUserContext userContext, String catalogId, String [] tokensExpr) throws Exception;
	public Catalog internalSaveCatalog(XingyouUserContext userContext, Catalog catalog) throws Exception;
	public Catalog internalSaveCatalog(XingyouUserContext userContext, Catalog catalog,Map<String,Object>option) throws Exception;

	public Catalog transferToAnotherOwner(XingyouUserContext userContext, String catalogId, String anotherOwnerId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String catalogId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, Catalog newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelOneCategoryManager getLevelOneCategoryManager(XingyouUserContext userContext, String catalogId, String name ,String [] tokensExpr)  throws Exception;

	public  Catalog addLevelOneCategory(XingyouUserContext userContext, String catalogId, String name , String [] tokensExpr)  throws Exception;
	public  Catalog removeLevelOneCategory(XingyouUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateLevelOneCategory(XingyouUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(XingyouUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(XingyouUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


