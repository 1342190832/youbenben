
package com.youbenben.youbenben.consumerordershippinggroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ConsumerOrderShippingGroupManager extends BaseManager{

		

	public ConsumerOrderShippingGroup createConsumerOrderShippingGroup(YoubenbenUserContext userContext, String name,String bizOrderId,BigDecimal amount) throws Exception;
	public ConsumerOrderShippingGroup updateConsumerOrderShippingGroup(YoubenbenUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderShippingGroup loadConsumerOrderShippingGroup(YoubenbenUserContext userContext, String consumerOrderShippingGroupId, String [] tokensExpr) throws Exception;
	public ConsumerOrderShippingGroup internalSaveConsumerOrderShippingGroup(YoubenbenUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup) throws Exception;
	public ConsumerOrderShippingGroup internalSaveConsumerOrderShippingGroup(YoubenbenUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String,Object>option) throws Exception;

	public ConsumerOrderShippingGroup transferToAnotherBizOrder(YoubenbenUserContext userContext, String consumerOrderShippingGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String consumerOrderShippingGroupId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderShippingGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


