
package com.youbenben.youbenben.consumerorderconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ConsumerOrderConfirmationManager extends BaseManager{

		

	public ConsumerOrderConfirmation createConsumerOrderConfirmation(YoubenbenUserContext userContext, String who,Date confirmTime) throws Exception;
	public ConsumerOrderConfirmation updateConsumerOrderConfirmation(YoubenbenUserContext userContext,String consumerOrderConfirmationId, int consumerOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderConfirmation loadConsumerOrderConfirmation(YoubenbenUserContext userContext, String consumerOrderConfirmationId, String [] tokensExpr) throws Exception;
	public ConsumerOrderConfirmation internalSaveConsumerOrderConfirmation(YoubenbenUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation) throws Exception;
	public ConsumerOrderConfirmation internalSaveConsumerOrderConfirmation(YoubenbenUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String consumerOrderConfirmationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}


