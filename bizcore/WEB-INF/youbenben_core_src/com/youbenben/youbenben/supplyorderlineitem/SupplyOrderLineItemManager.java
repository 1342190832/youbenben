
package com.youbenben.youbenben.supplyorderlineitem;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplyOrderLineItemManager extends BaseManager{

		

	public SupplyOrderLineItem createSupplyOrderLineItem(YoubenbenUserContext userContext, String bizOrderId,String skuId,String skuName,BigDecimal amount,int quantity,String unitOfMeasurement) throws Exception;
	public SupplyOrderLineItem updateSupplyOrderLineItem(YoubenbenUserContext userContext,String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderLineItem loadSupplyOrderLineItem(YoubenbenUserContext userContext, String supplyOrderLineItemId, String [] tokensExpr) throws Exception;
	public SupplyOrderLineItem internalSaveSupplyOrderLineItem(YoubenbenUserContext userContext, SupplyOrderLineItem supplyOrderLineItem) throws Exception;
	public SupplyOrderLineItem internalSaveSupplyOrderLineItem(YoubenbenUserContext userContext, SupplyOrderLineItem supplyOrderLineItem,Map<String,Object>option) throws Exception;

	public SupplyOrderLineItem transferToAnotherBizOrder(YoubenbenUserContext userContext, String supplyOrderLineItemId, String anotherBizOrderId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String supplyOrderLineItemId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderLineItem newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


