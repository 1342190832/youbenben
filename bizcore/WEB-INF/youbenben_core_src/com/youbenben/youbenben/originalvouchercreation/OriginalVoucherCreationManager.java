
package com.youbenben.youbenben.originalvouchercreation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface OriginalVoucherCreationManager extends BaseManager{

		

	public OriginalVoucherCreation createOriginalVoucherCreation(YoubenbenUserContext userContext, String who,String comments,Date makeDate) throws Exception;
	public OriginalVoucherCreation updateOriginalVoucherCreation(YoubenbenUserContext userContext,String originalVoucherCreationId, int originalVoucherCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OriginalVoucherCreation loadOriginalVoucherCreation(YoubenbenUserContext userContext, String originalVoucherCreationId, String [] tokensExpr) throws Exception;
	public OriginalVoucherCreation internalSaveOriginalVoucherCreation(YoubenbenUserContext userContext, OriginalVoucherCreation originalVoucherCreation) throws Exception;
	public OriginalVoucherCreation internalSaveOriginalVoucherCreation(YoubenbenUserContext userContext, OriginalVoucherCreation originalVoucherCreation,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String originalVoucherCreationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, OriginalVoucherCreation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  OriginalVoucherManager getOriginalVoucherManager(YoubenbenUserContext userContext, String originalVoucherCreationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String confirmationId, String auditingId ,String [] tokensExpr)  throws Exception;

	public  OriginalVoucherCreation addOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherCreationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String confirmationId, String auditingId , String [] tokensExpr)  throws Exception;
	public  OriginalVoucherCreation removeOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherCreationId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherCreation updateOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherCreationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


