
package com.youbenben.youbenben.levelthreecategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface LevelThreeCategoryManager extends BaseManager{

		

	public LevelThreeCategory createLevelThreeCategory(YoubenbenUserContext userContext, String parentCategoryId,String name) throws Exception;
	public LevelThreeCategory updateLevelThreeCategory(YoubenbenUserContext userContext,String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelThreeCategory loadLevelThreeCategory(YoubenbenUserContext userContext, String levelThreeCategoryId, String [] tokensExpr) throws Exception;
	public LevelThreeCategory internalSaveLevelThreeCategory(YoubenbenUserContext userContext, LevelThreeCategory levelThreeCategory) throws Exception;
	public LevelThreeCategory internalSaveLevelThreeCategory(YoubenbenUserContext userContext, LevelThreeCategory levelThreeCategory,Map<String,Object>option) throws Exception;

	public LevelThreeCategory transferToAnotherParentCategory(YoubenbenUserContext userContext, String levelThreeCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String levelThreeCategoryId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, LevelThreeCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ProductManager getProductManager(YoubenbenUserContext userContext, String levelThreeCategoryId, String name, String origin, String remark, String brand, String picture ,String [] tokensExpr)  throws Exception;

	public  LevelThreeCategory addProduct(YoubenbenUserContext userContext, String levelThreeCategoryId, String name, String origin, String remark, String brand, String picture , String [] tokensExpr)  throws Exception;
	public  LevelThreeCategory removeProduct(YoubenbenUserContext userContext, String levelThreeCategoryId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  LevelThreeCategory updateProduct(YoubenbenUserContext userContext, String levelThreeCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByParentCategory(YoubenbenUserContext userContext,String parentCategoryId) throws Exception;
	public Object listPageByParentCategory(YoubenbenUserContext userContext,String parentCategoryId, int start, int count) throws Exception;
  

}


