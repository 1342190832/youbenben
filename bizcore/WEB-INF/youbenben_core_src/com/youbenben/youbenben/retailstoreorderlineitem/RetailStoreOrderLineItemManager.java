
package com.youbenben.youbenben.retailstoreorderlineitem;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreOrderLineItemManager extends BaseManager{

		

	public RetailStoreOrderLineItem createRetailStoreOrderLineItem(YoubenbenUserContext userContext, String bizOrderId,String skuId,String skuName,BigDecimal amount,int quantity,String unitOfMeasurement) throws Exception;
	public RetailStoreOrderLineItem updateRetailStoreOrderLineItem(YoubenbenUserContext userContext,String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderLineItem loadRetailStoreOrderLineItem(YoubenbenUserContext userContext, String retailStoreOrderLineItemId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderLineItem internalSaveRetailStoreOrderLineItem(YoubenbenUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem) throws Exception;
	public RetailStoreOrderLineItem internalSaveRetailStoreOrderLineItem(YoubenbenUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem,Map<String,Object>option) throws Exception;

	public RetailStoreOrderLineItem transferToAnotherBizOrder(YoubenbenUserContext userContext, String retailStoreOrderLineItemId, String anotherBizOrderId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreOrderLineItemId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOrderLineItem newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


