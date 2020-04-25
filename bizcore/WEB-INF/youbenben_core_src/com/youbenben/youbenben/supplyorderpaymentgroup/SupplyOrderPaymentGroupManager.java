
package com.youbenben.youbenben.supplyorderpaymentgroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplyOrderPaymentGroupManager extends BaseManager{

		

	public SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String name,String bizOrderId,String cardNumber) throws Exception;
	public SupplyOrderPaymentGroup updateSupplyOrderPaymentGroup(YoubenbenUserContext userContext,String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderPaymentGroup loadSupplyOrderPaymentGroup(YoubenbenUserContext userContext, String supplyOrderPaymentGroupId, String [] tokensExpr) throws Exception;
	public SupplyOrderPaymentGroup internalSaveSupplyOrderPaymentGroup(YoubenbenUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup) throws Exception;
	public SupplyOrderPaymentGroup internalSaveSupplyOrderPaymentGroup(YoubenbenUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup,Map<String,Object>option) throws Exception;

	public SupplyOrderPaymentGroup transferToAnotherBizOrder(YoubenbenUserContext userContext, String supplyOrderPaymentGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String supplyOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderPaymentGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


