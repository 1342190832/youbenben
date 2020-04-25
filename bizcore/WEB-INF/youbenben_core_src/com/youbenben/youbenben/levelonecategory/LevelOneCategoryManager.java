
package com.youbenben.youbenben.levelonecategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface LevelOneCategoryManager extends BaseManager{

		

	public LevelOneCategory createLevelOneCategory(YoubenbenUserContext userContext, String catalogId,String name) throws Exception;
	public LevelOneCategory updateLevelOneCategory(YoubenbenUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelOneCategory loadLevelOneCategory(YoubenbenUserContext userContext, String levelOneCategoryId, String [] tokensExpr) throws Exception;
	public LevelOneCategory internalSaveLevelOneCategory(YoubenbenUserContext userContext, LevelOneCategory levelOneCategory) throws Exception;
	public LevelOneCategory internalSaveLevelOneCategory(YoubenbenUserContext userContext, LevelOneCategory levelOneCategory,Map<String,Object>option) throws Exception;

	public LevelOneCategory transferToAnotherCatalog(YoubenbenUserContext userContext, String levelOneCategoryId, String anotherCatalogId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String levelOneCategoryId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, LevelOneCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelTwoCategoryManager getLevelTwoCategoryManager(YoubenbenUserContext userContext, String levelOneCategoryId, String name ,String [] tokensExpr)  throws Exception;

	public  LevelOneCategory addLevelTwoCategory(YoubenbenUserContext userContext, String levelOneCategoryId, String name , String [] tokensExpr)  throws Exception;
	public  LevelOneCategory removeLevelTwoCategory(YoubenbenUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelOneCategory updateLevelTwoCategory(YoubenbenUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCatalog(YoubenbenUserContext userContext,String catalogId) throws Exception;
	public Object listPageByCatalog(YoubenbenUserContext userContext,String catalogId, int start, int count) throws Exception;
  

}


