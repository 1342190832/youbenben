
package com.xingyou.xingyou.product;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface ProductManager extends BaseManager{

		

	public Product createProduct(XingyouUserContext userContext, String name,String parentCategoryId,String origin,String remark,String brand,String picture) throws Exception;
	public Product updateProduct(XingyouUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Product loadProduct(XingyouUserContext userContext, String productId, String [] tokensExpr) throws Exception;
	public Product internalSaveProduct(XingyouUserContext userContext, Product product) throws Exception;
	public Product internalSaveProduct(XingyouUserContext userContext, Product product,Map<String,Object>option) throws Exception;

	public Product transferToAnotherParentCategory(XingyouUserContext userContext, String productId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String productId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, Product newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SkuManager getSkuManager(XingyouUserContext userContext, String productId, String name, String size, String barcode, String packageType, String netContent, BigDecimal price, String picture ,String [] tokensExpr)  throws Exception;

	public  Product addSku(XingyouUserContext userContext, String productId, String name, String size, String barcode, String packageType, String netContent, BigDecimal price, String picture , String [] tokensExpr)  throws Exception;
	public  Product removeSku(XingyouUserContext userContext, String productId, String skuId, int skuVersion,String [] tokensExpr)  throws Exception;
	public  Product updateSku(XingyouUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByParentCategory(XingyouUserContext userContext,String parentCategoryId) throws Exception;
	public Object listPageByParentCategory(XingyouUserContext userContext,String parentCategoryId, int start, int count) throws Exception;
  

}


