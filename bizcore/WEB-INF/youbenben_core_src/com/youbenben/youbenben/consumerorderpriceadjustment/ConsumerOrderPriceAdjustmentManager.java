
package com.youbenben.youbenben.consumerorderpriceadjustment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ConsumerOrderPriceAdjustmentManager extends BaseManager{

		

	public ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String name,String bizOrderId,BigDecimal amount,String provider) throws Exception;
	public ConsumerOrderPriceAdjustment updateConsumerOrderPriceAdjustment(YoubenbenUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, String consumerOrderPriceAdjustmentId, String [] tokensExpr) throws Exception;
	public ConsumerOrderPriceAdjustment internalSaveConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment) throws Exception;
	public ConsumerOrderPriceAdjustment internalSaveConsumerOrderPriceAdjustment(YoubenbenUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment,Map<String,Object>option) throws Exception;

	public ConsumerOrderPriceAdjustment transferToAnotherBizOrder(YoubenbenUserContext userContext, String consumerOrderPriceAdjustmentId, String anotherBizOrderId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String consumerOrderPriceAdjustmentId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderPriceAdjustment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


