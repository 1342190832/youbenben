
package com.youbenben.youbenben.productsupplyduration;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ProductSupplyDurationManager extends BaseManager{

		

	public ProductSupplyDuration createProductSupplyDuration(YoubenbenUserContext userContext, int quantity,String duration,BigDecimal price,String productId) throws Exception;
	public ProductSupplyDuration updateProductSupplyDuration(YoubenbenUserContext userContext,String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ProductSupplyDuration loadProductSupplyDuration(YoubenbenUserContext userContext, String productSupplyDurationId, String [] tokensExpr) throws Exception;
	public ProductSupplyDuration internalSaveProductSupplyDuration(YoubenbenUserContext userContext, ProductSupplyDuration productSupplyDuration) throws Exception;
	public ProductSupplyDuration internalSaveProductSupplyDuration(YoubenbenUserContext userContext, ProductSupplyDuration productSupplyDuration,Map<String,Object>option) throws Exception;

	public ProductSupplyDuration transferToAnotherProduct(YoubenbenUserContext userContext, String productSupplyDurationId, String anotherProductId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String productSupplyDurationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ProductSupplyDuration newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByProduct(YoubenbenUserContext userContext,String productId) throws Exception;
	public Object listPageByProduct(YoubenbenUserContext userContext,String productId, int start, int count) throws Exception;
  

}


