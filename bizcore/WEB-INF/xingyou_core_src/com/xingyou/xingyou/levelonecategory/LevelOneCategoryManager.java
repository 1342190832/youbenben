
package com.xingyou.xingyou.levelonecategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface LevelOneCategoryManager extends BaseManager{

		

	public LevelOneCategory createLevelOneCategory(XingyouUserContext userContext, String catalogId,String name) throws Exception;
	public LevelOneCategory updateLevelOneCategory(XingyouUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelOneCategory loadLevelOneCategory(XingyouUserContext userContext, String levelOneCategoryId, String [] tokensExpr) throws Exception;
	public LevelOneCategory internalSaveLevelOneCategory(XingyouUserContext userContext, LevelOneCategory levelOneCategory) throws Exception;
	public LevelOneCategory internalSaveLevelOneCategory(XingyouUserContext userContext, LevelOneCategory levelOneCategory,Map<String,Object>option) throws Exception;

	public LevelOneCategory transferToAnotherCatalog(XingyouUserContext userContext, String levelOneCategoryId, String anotherCatalogId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String levelOneCategoryId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, LevelOneCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelTwoCategoryManager getLevelTwoCategoryManager(XingyouUserContext userContext, String levelOneCategoryId, String name ,String [] tokensExpr)  throws Exception;

	public  LevelOneCategory addLevelTwoCategory(XingyouUserContext userContext, String levelOneCategoryId, String name , String [] tokensExpr)  throws Exception;
	public  LevelOneCategory removeLevelTwoCategory(XingyouUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelOneCategory updateLevelTwoCategory(XingyouUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCatalog(XingyouUserContext userContext,String catalogId) throws Exception;
	public Object listPageByCatalog(XingyouUserContext userContext,String catalogId, int start, int count) throws Exception;
  

}


