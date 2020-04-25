
package com.youbenben.youbenben.leveltwocategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface LevelTwoCategoryManager extends BaseManager{

		

	public LevelTwoCategory createLevelTwoCategory(YoubenbenUserContext userContext, String parentCategoryId,String name) throws Exception;
	public LevelTwoCategory updateLevelTwoCategory(YoubenbenUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelTwoCategory loadLevelTwoCategory(YoubenbenUserContext userContext, String levelTwoCategoryId, String [] tokensExpr) throws Exception;
	public LevelTwoCategory internalSaveLevelTwoCategory(YoubenbenUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception;
	public LevelTwoCategory internalSaveLevelTwoCategory(YoubenbenUserContext userContext, LevelTwoCategory levelTwoCategory,Map<String,Object>option) throws Exception;

	public LevelTwoCategory transferToAnotherParentCategory(YoubenbenUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String levelTwoCategoryId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, LevelTwoCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelThreeCategoryManager getLevelThreeCategoryManager(YoubenbenUserContext userContext, String levelTwoCategoryId, String name ,String [] tokensExpr)  throws Exception;

	public  LevelTwoCategory addLevelThreeCategory(YoubenbenUserContext userContext, String levelTwoCategoryId, String name , String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory removeLevelThreeCategory(YoubenbenUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory updateLevelThreeCategory(YoubenbenUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByParentCategory(YoubenbenUserContext userContext,String parentCategoryId) throws Exception;
	public Object listPageByParentCategory(YoubenbenUserContext userContext,String parentCategoryId, int start, int count) throws Exception;
  

}


