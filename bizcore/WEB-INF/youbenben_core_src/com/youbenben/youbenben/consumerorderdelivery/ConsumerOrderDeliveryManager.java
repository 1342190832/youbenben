
package com.youbenben.youbenben.consumerorderdelivery;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ConsumerOrderDeliveryManager extends BaseManager{

		

	public ConsumerOrderDelivery createConsumerOrderDelivery(YoubenbenUserContext userContext, String who,Date deliveryTime) throws Exception;
	public ConsumerOrderDelivery updateConsumerOrderDelivery(YoubenbenUserContext userContext,String consumerOrderDeliveryId, int consumerOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderDelivery loadConsumerOrderDelivery(YoubenbenUserContext userContext, String consumerOrderDeliveryId, String [] tokensExpr) throws Exception;
	public ConsumerOrderDelivery internalSaveConsumerOrderDelivery(YoubenbenUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery) throws Exception;
	public ConsumerOrderDelivery internalSaveConsumerOrderDelivery(YoubenbenUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String consumerOrderDeliveryId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderDelivery newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}


