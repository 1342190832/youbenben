
package com.youbenben.youbenben.supplyordershippinggroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplyOrderShippingGroupManager extends BaseManager{

		

	public SupplyOrderShippingGroup createSupplyOrderShippingGroup(YoubenbenUserContext userContext, String name,String bizOrderId,BigDecimal amount) throws Exception;
	public SupplyOrderShippingGroup updateSupplyOrderShippingGroup(YoubenbenUserContext userContext,String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderShippingGroup loadSupplyOrderShippingGroup(YoubenbenUserContext userContext, String supplyOrderShippingGroupId, String [] tokensExpr) throws Exception;
	public SupplyOrderShippingGroup internalSaveSupplyOrderShippingGroup(YoubenbenUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup) throws Exception;
	public SupplyOrderShippingGroup internalSaveSupplyOrderShippingGroup(YoubenbenUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String,Object>option) throws Exception;

	public SupplyOrderShippingGroup transferToAnotherBizOrder(YoubenbenUserContext userContext, String supplyOrderShippingGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String supplyOrderShippingGroupId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderShippingGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


