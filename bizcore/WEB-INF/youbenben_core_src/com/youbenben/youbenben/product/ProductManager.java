
package com.youbenben.youbenben.product;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ProductManager extends BaseManager{

		

	public Product createProduct(YoubenbenUserContext userContext, String name,String parentCategoryId,String origin,String remark,String brand,String picture) throws Exception;
	public Product updateProduct(YoubenbenUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Product loadProduct(YoubenbenUserContext userContext, String productId, String [] tokensExpr) throws Exception;
	public Product internalSaveProduct(YoubenbenUserContext userContext, Product product) throws Exception;
	public Product internalSaveProduct(YoubenbenUserContext userContext, Product product,Map<String,Object>option) throws Exception;

	public Product transferToAnotherParentCategory(YoubenbenUserContext userContext, String productId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String productId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, Product newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SkuManager getSkuManager(YoubenbenUserContext userContext, String productId, String name, String size, String barcode, String packageType, String netContent, BigDecimal price, String picture ,String [] tokensExpr)  throws Exception;

	public  Product addSku(YoubenbenUserContext userContext, String productId, String name, String size, String barcode, String packageType, String netContent, BigDecimal price, String picture , String [] tokensExpr)  throws Exception;
	public  Product removeSku(YoubenbenUserContext userContext, String productId, String skuId, int skuVersion,String [] tokensExpr)  throws Exception;
	public  Product updateSku(YoubenbenUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByParentCategory(YoubenbenUserContext userContext,String parentCategoryId) throws Exception;
	public Object listPageByParentCategory(YoubenbenUserContext userContext,String parentCategoryId, int start, int count) throws Exception;
  

}


