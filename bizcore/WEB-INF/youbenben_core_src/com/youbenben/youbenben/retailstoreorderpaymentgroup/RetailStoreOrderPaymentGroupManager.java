
package com.youbenben.youbenben.retailstoreorderpaymentgroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreOrderPaymentGroupManager extends BaseManager{

		

	public RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(YoubenbenUserContext userContext, String name,String bizOrderId,String cardNumber) throws Exception;
	public RetailStoreOrderPaymentGroup updateRetailStoreOrderPaymentGroup(YoubenbenUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroup(YoubenbenUserContext userContext, String retailStoreOrderPaymentGroupId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderPaymentGroup internalSaveRetailStoreOrderPaymentGroup(YoubenbenUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup) throws Exception;
	public RetailStoreOrderPaymentGroup internalSaveRetailStoreOrderPaymentGroup(YoubenbenUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String,Object>option) throws Exception;

	public RetailStoreOrderPaymentGroup transferToAnotherBizOrder(YoubenbenUserContext userContext, String retailStoreOrderPaymentGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreOrderPaymentGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


