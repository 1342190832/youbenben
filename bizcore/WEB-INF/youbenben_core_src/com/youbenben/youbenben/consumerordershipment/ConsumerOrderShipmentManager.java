
package com.youbenben.youbenben.consumerordershipment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ConsumerOrderShipmentManager extends BaseManager{

		

	public ConsumerOrderShipment createConsumerOrderShipment(YoubenbenUserContext userContext, String who,Date shipTime) throws Exception;
	public ConsumerOrderShipment updateConsumerOrderShipment(YoubenbenUserContext userContext,String consumerOrderShipmentId, int consumerOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderShipment loadConsumerOrderShipment(YoubenbenUserContext userContext, String consumerOrderShipmentId, String [] tokensExpr) throws Exception;
	public ConsumerOrderShipment internalSaveConsumerOrderShipment(YoubenbenUserContext userContext, ConsumerOrderShipment consumerOrderShipment) throws Exception;
	public ConsumerOrderShipment internalSaveConsumerOrderShipment(YoubenbenUserContext userContext, ConsumerOrderShipment consumerOrderShipment,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String consumerOrderShipmentId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderShipment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}


