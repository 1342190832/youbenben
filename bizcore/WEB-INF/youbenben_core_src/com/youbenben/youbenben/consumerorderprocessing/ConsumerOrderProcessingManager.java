
package com.youbenben.youbenben.consumerorderprocessing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ConsumerOrderProcessingManager extends BaseManager{

		

	public ConsumerOrderProcessing createConsumerOrderProcessing(YoubenbenUserContext userContext, String who,Date processTime) throws Exception;
	public ConsumerOrderProcessing updateConsumerOrderProcessing(YoubenbenUserContext userContext,String consumerOrderProcessingId, int consumerOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderProcessing loadConsumerOrderProcessing(YoubenbenUserContext userContext, String consumerOrderProcessingId, String [] tokensExpr) throws Exception;
	public ConsumerOrderProcessing internalSaveConsumerOrderProcessing(YoubenbenUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing) throws Exception;
	public ConsumerOrderProcessing internalSaveConsumerOrderProcessing(YoubenbenUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String consumerOrderProcessingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderProcessing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}


