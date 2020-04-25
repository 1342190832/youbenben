
package com.youbenben.youbenben.consumerorderlineitem;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ConsumerOrderLineItemManager extends BaseManager{

		

	public ConsumerOrderLineItem createConsumerOrderLineItem(YoubenbenUserContext userContext, String bizOrderId,String skuId,String skuName,BigDecimal price,BigDecimal quantity,BigDecimal amount) throws Exception;
	public ConsumerOrderLineItem updateConsumerOrderLineItem(YoubenbenUserContext userContext,String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderLineItem loadConsumerOrderLineItem(YoubenbenUserContext userContext, String consumerOrderLineItemId, String [] tokensExpr) throws Exception;
	public ConsumerOrderLineItem internalSaveConsumerOrderLineItem(YoubenbenUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem) throws Exception;
	public ConsumerOrderLineItem internalSaveConsumerOrderLineItem(YoubenbenUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem,Map<String,Object>option) throws Exception;

	public ConsumerOrderLineItem transferToAnotherBizOrder(YoubenbenUserContext userContext, String consumerOrderLineItemId, String anotherBizOrderId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String consumerOrderLineItemId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderLineItem newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


