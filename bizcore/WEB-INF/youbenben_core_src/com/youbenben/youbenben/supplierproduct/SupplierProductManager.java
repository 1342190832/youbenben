
package com.youbenben.youbenben.supplierproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplierProductManager extends BaseManager{

		

	public SupplierProduct createSupplierProduct(YoubenbenUserContext userContext, String productName,String productDescription,String productUnit,String supplierId) throws Exception;
	public SupplierProduct updateSupplierProduct(YoubenbenUserContext userContext,String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplierProduct loadSupplierProduct(YoubenbenUserContext userContext, String supplierProductId, String [] tokensExpr) throws Exception;
	public SupplierProduct internalSaveSupplierProduct(YoubenbenUserContext userContext, SupplierProduct supplierProduct) throws Exception;
	public SupplierProduct internalSaveSupplierProduct(YoubenbenUserContext userContext, SupplierProduct supplierProduct,Map<String,Object>option) throws Exception;

	public SupplierProduct transferToAnotherSupplier(YoubenbenUserContext userContext, String supplierProductId, String anotherSupplierId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String supplierProductId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplierProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ProductSupplyDurationManager getProductSupplyDurationManager(YoubenbenUserContext userContext, String supplierProductId, int quantity, String duration, BigDecimal price ,String [] tokensExpr)  throws Exception;

	public  SupplierProduct addProductSupplyDuration(YoubenbenUserContext userContext, String supplierProductId, int quantity, String duration, BigDecimal price , String [] tokensExpr)  throws Exception;
	public  SupplierProduct removeProductSupplyDuration(YoubenbenUserContext userContext, String supplierProductId, String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr)  throws Exception;
	public  SupplierProduct updateProductSupplyDuration(YoubenbenUserContext userContext, String supplierProductId, String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listBySupplier(YoubenbenUserContext userContext,String supplierId) throws Exception;
	public Object listPageBySupplier(YoubenbenUserContext userContext,String supplierId, int start, int count) throws Exception;
  

}


