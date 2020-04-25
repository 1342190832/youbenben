
package com.youbenben.youbenben.retailstoremembergiftcard;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreMemberGiftCardManager extends BaseManager{

		

	public RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String name,String ownerId,String number,BigDecimal remain) throws Exception;
	public RetailStoreMemberGiftCard updateRetailStoreMemberGiftCard(YoubenbenUserContext userContext,String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(YoubenbenUserContext userContext, String retailStoreMemberGiftCardId, String [] tokensExpr) throws Exception;
	public RetailStoreMemberGiftCard internalSaveRetailStoreMemberGiftCard(YoubenbenUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard) throws Exception;
	public RetailStoreMemberGiftCard internalSaveRetailStoreMemberGiftCard(YoubenbenUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard,Map<String,Object>option) throws Exception;

	public RetailStoreMemberGiftCard transferToAnotherOwner(YoubenbenUserContext userContext, String retailStoreMemberGiftCardId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreMemberGiftCardId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreMemberGiftCard newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreMemberGiftCardConsumeRecordManager getRetailStoreMemberGiftCardConsumeRecordManager(YoubenbenUserContext userContext, String retailStoreMemberGiftCardId, Date occureTime, String bizOrderId, String number, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  RetailStoreMemberGiftCard addRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String retailStoreMemberGiftCardId, Date occureTime, String bizOrderId, String number, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  RetailStoreMemberGiftCard removeRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String retailStoreMemberGiftCardId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMemberGiftCard updateRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String retailStoreMemberGiftCardId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


