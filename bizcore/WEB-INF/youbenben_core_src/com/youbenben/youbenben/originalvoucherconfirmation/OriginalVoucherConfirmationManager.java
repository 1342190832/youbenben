
package com.youbenben.youbenben.originalvoucherconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface OriginalVoucherConfirmationManager extends BaseManager{

		

	public OriginalVoucherConfirmation createOriginalVoucherConfirmation(YoubenbenUserContext userContext, String who,String comments,Date makeDate) throws Exception;
	public OriginalVoucherConfirmation updateOriginalVoucherConfirmation(YoubenbenUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OriginalVoucherConfirmation loadOriginalVoucherConfirmation(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String [] tokensExpr) throws Exception;
	public OriginalVoucherConfirmation internalSaveOriginalVoucherConfirmation(YoubenbenUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation) throws Exception;
	public OriginalVoucherConfirmation internalSaveOriginalVoucherConfirmation(YoubenbenUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String originalVoucherConfirmationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, OriginalVoucherConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  OriginalVoucherManager getOriginalVoucherManager(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String auditingId ,String [] tokensExpr)  throws Exception;

	public  OriginalVoucherConfirmation addOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String auditingId , String [] tokensExpr)  throws Exception;
	public  OriginalVoucherConfirmation removeOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherConfirmation updateOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


