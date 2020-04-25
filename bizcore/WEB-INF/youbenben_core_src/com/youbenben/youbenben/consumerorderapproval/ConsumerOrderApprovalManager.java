
package com.youbenben.youbenben.consumerorderapproval;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ConsumerOrderApprovalManager extends BaseManager{

		

	public ConsumerOrderApproval createConsumerOrderApproval(YoubenbenUserContext userContext, String who,Date approveTime) throws Exception;
	public ConsumerOrderApproval updateConsumerOrderApproval(YoubenbenUserContext userContext,String consumerOrderApprovalId, int consumerOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderApproval loadConsumerOrderApproval(YoubenbenUserContext userContext, String consumerOrderApprovalId, String [] tokensExpr) throws Exception;
	public ConsumerOrderApproval internalSaveConsumerOrderApproval(YoubenbenUserContext userContext, ConsumerOrderApproval consumerOrderApproval) throws Exception;
	public ConsumerOrderApproval internalSaveConsumerOrderApproval(YoubenbenUserContext userContext, ConsumerOrderApproval consumerOrderApproval,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String consumerOrderApprovalId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderApproval newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}


