
package com.youbenben.youbenben.consumerorderpaymentgroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ConsumerOrderPaymentGroupManager extends BaseManager{

		

	public ConsumerOrderPaymentGroup createConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String name,String bizOrderId,String cardNumber) throws Exception;
	public ConsumerOrderPaymentGroup updateConsumerOrderPaymentGroup(YoubenbenUserContext userContext,String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderPaymentGroup loadConsumerOrderPaymentGroup(YoubenbenUserContext userContext, String consumerOrderPaymentGroupId, String [] tokensExpr) throws Exception;
	public ConsumerOrderPaymentGroup internalSaveConsumerOrderPaymentGroup(YoubenbenUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup) throws Exception;
	public ConsumerOrderPaymentGroup internalSaveConsumerOrderPaymentGroup(YoubenbenUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup,Map<String,Object>option) throws Exception;

	public ConsumerOrderPaymentGroup transferToAnotherBizOrder(YoubenbenUserContext userContext, String consumerOrderPaymentGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String consumerOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ConsumerOrderPaymentGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


