
package com.youbenben.youbenben.retailstoremembergiftcardconsumerecord;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreMemberGiftCardConsumeRecordManager extends BaseManager{

		

	public RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, Date occureTime,String ownerId,String bizOrderId,String number,BigDecimal amount) throws Exception;
	public RetailStoreMemberGiftCardConsumeRecord updateRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext,String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String [] tokensExpr) throws Exception;
	public RetailStoreMemberGiftCardConsumeRecord internalSaveRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) throws Exception;
	public RetailStoreMemberGiftCardConsumeRecord internalSaveRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,Map<String,Object>option) throws Exception;

	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherOwner(YoubenbenUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherOwnerId)  throws Exception;
 	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherBizOrder(YoubenbenUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherBizOrderId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreMemberGiftCardConsumeRecord newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  
	public Object listByBizOrder(YoubenbenUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(YoubenbenUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


