
package com.youbenben.youbenben.retailstoreordershippinggroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreOrderShippingGroupManager extends BaseManager{

		

	public RetailStoreOrderShippingGroup createRetailStoreOrderShippingGroup(YoubenbenUserContext userContext, String name,String bizOrderId,BigDecimal amount) throws Exception;
	public RetailStoreOrderShippingGroup updateRetailStoreOrderShippingGroup(YoubenbenUserContext userContext,String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderShippingGroup loadRetailStoreOrderShippingGroup(YoubenbenUserContext userContext, String retailStoreOrderShippingGroupId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderShippingGroup internalSaveRetailStoreOrderShippingGroup(YoubenbenUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) throws Exception;
	public RetailStoreOrderShippingGroup internalSaveRetailStoreOrderShippingGroup(YoubenbenUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String,Object>option) throws Exception;

	public RetailStoreOrderShippingGroup transferToAnotherBizOrder(YoubenbenUserContext userContext, String retailStoreOrderShippingGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreOrderShippingGroupId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOrderShippingGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


