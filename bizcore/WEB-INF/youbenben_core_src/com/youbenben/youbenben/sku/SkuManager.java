
package com.youbenben.youbenben.sku;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SkuManager extends BaseManager{

		

	public Sku createSku(YoubenbenUserContext userContext, String name,String size,String productId,String barcode,String packageType,String netContent,BigDecimal price,String picture) throws Exception;
	public Sku updateSku(YoubenbenUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Sku loadSku(YoubenbenUserContext userContext, String skuId, String [] tokensExpr) throws Exception;
	public Sku internalSaveSku(YoubenbenUserContext userContext, Sku sku) throws Exception;
	public Sku internalSaveSku(YoubenbenUserContext userContext, Sku sku,Map<String,Object>option) throws Exception;

	public Sku transferToAnotherProduct(YoubenbenUserContext userContext, String skuId, String anotherProductId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String skuId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, Sku newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByProduct(YoubenbenUserContext userContext,String productId) throws Exception;
	public Object listPageByProduct(YoubenbenUserContext userContext,String productId, int start, int count) throws Exception;
  

}


