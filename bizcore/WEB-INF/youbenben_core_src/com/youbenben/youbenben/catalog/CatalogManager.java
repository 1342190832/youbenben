
package com.youbenben.youbenben.catalog;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface CatalogManager extends BaseManager{

		

	public Catalog createCatalog(YoubenbenUserContext userContext, String name,String ownerId,int subCount,BigDecimal amount) throws Exception;
	public Catalog updateCatalog(YoubenbenUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Catalog loadCatalog(YoubenbenUserContext userContext, String catalogId, String [] tokensExpr) throws Exception;
	public Catalog internalSaveCatalog(YoubenbenUserContext userContext, Catalog catalog) throws Exception;
	public Catalog internalSaveCatalog(YoubenbenUserContext userContext, Catalog catalog,Map<String,Object>option) throws Exception;

	public Catalog transferToAnotherOwner(YoubenbenUserContext userContext, String catalogId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String catalogId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, Catalog newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelOneCategoryManager getLevelOneCategoryManager(YoubenbenUserContext userContext, String catalogId, String name ,String [] tokensExpr)  throws Exception;

	public  Catalog addLevelOneCategory(YoubenbenUserContext userContext, String catalogId, String name , String [] tokensExpr)  throws Exception;
	public  Catalog removeLevelOneCategory(YoubenbenUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateLevelOneCategory(YoubenbenUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


