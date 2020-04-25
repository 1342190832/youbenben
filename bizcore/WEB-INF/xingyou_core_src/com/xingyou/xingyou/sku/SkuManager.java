
package com.xingyou.xingyou.sku;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface SkuManager extends BaseManager{

		

	public Sku createSku(XingyouUserContext userContext, String name,String size,String productId,String barcode,String packageType,String netContent,BigDecimal price,String picture) throws Exception;
	public Sku updateSku(XingyouUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Sku loadSku(XingyouUserContext userContext, String skuId, String [] tokensExpr) throws Exception;
	public Sku internalSaveSku(XingyouUserContext userContext, Sku sku) throws Exception;
	public Sku internalSaveSku(XingyouUserContext userContext, Sku sku,Map<String,Object>option) throws Exception;

	public Sku transferToAnotherProduct(XingyouUserContext userContext, String skuId, String anotherProductId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String skuId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, Sku newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByProduct(XingyouUserContext userContext,String productId) throws Exception;
	public Object listPageByProduct(XingyouUserContext userContext,String productId, int start, int count) throws Exception;
  

}


