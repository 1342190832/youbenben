
package com.xingyou.xingyou.levelthreecategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface LevelThreeCategoryManager extends BaseManager{

		

	public LevelThreeCategory createLevelThreeCategory(XingyouUserContext userContext, String parentCategoryId,String name) throws Exception;
	public LevelThreeCategory updateLevelThreeCategory(XingyouUserContext userContext,String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelThreeCategory loadLevelThreeCategory(XingyouUserContext userContext, String levelThreeCategoryId, String [] tokensExpr) throws Exception;
	public LevelThreeCategory internalSaveLevelThreeCategory(XingyouUserContext userContext, LevelThreeCategory levelThreeCategory) throws Exception;
	public LevelThreeCategory internalSaveLevelThreeCategory(XingyouUserContext userContext, LevelThreeCategory levelThreeCategory,Map<String,Object>option) throws Exception;

	public LevelThreeCategory transferToAnotherParentCategory(XingyouUserContext userContext, String levelThreeCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String levelThreeCategoryId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, LevelThreeCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ProductManager getProductManager(XingyouUserContext userContext, String levelThreeCategoryId, String name, String origin, String remark, String brand, String picture ,String [] tokensExpr)  throws Exception;

	public  LevelThreeCategory addProduct(XingyouUserContext userContext, String levelThreeCategoryId, String name, String origin, String remark, String brand, String picture , String [] tokensExpr)  throws Exception;
	public  LevelThreeCategory removeProduct(XingyouUserContext userContext, String levelThreeCategoryId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  LevelThreeCategory updateProduct(XingyouUserContext userContext, String levelThreeCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByParentCategory(XingyouUserContext userContext,String parentCategoryId) throws Exception;
	public Object listPageByParentCategory(XingyouUserContext userContext,String parentCategoryId, int start, int count) throws Exception;
  

}


