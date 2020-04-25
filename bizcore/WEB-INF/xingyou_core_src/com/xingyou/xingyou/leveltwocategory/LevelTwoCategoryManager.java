
package com.xingyou.xingyou.leveltwocategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface LevelTwoCategoryManager extends BaseManager{

		

	public LevelTwoCategory createLevelTwoCategory(XingyouUserContext userContext, String parentCategoryId,String name) throws Exception;
	public LevelTwoCategory updateLevelTwoCategory(XingyouUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelTwoCategory loadLevelTwoCategory(XingyouUserContext userContext, String levelTwoCategoryId, String [] tokensExpr) throws Exception;
	public LevelTwoCategory internalSaveLevelTwoCategory(XingyouUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception;
	public LevelTwoCategory internalSaveLevelTwoCategory(XingyouUserContext userContext, LevelTwoCategory levelTwoCategory,Map<String,Object>option) throws Exception;

	public LevelTwoCategory transferToAnotherParentCategory(XingyouUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String levelTwoCategoryId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, LevelTwoCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelThreeCategoryManager getLevelThreeCategoryManager(XingyouUserContext userContext, String levelTwoCategoryId, String name ,String [] tokensExpr)  throws Exception;

	public  LevelTwoCategory addLevelThreeCategory(XingyouUserContext userContext, String levelTwoCategoryId, String name , String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory removeLevelThreeCategory(XingyouUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory updateLevelThreeCategory(XingyouUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByParentCategory(XingyouUserContext userContext,String parentCategoryId) throws Exception;
	public Object listPageByParentCategory(XingyouUserContext userContext,String parentCategoryId, int start, int count) throws Exception;
  

}


