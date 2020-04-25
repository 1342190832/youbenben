
package com.doublechaintech.retailscm.originalvoucherconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface OriginalVoucherConfirmationManager extends BaseManager{

		

	public OriginalVoucherConfirmation createOriginalVoucherConfirmation(RetailscmUserContext userContext, String who,String comments,Date makeDate) throws Exception;
	public OriginalVoucherConfirmation updateOriginalVoucherConfirmation(RetailscmUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OriginalVoucherConfirmation loadOriginalVoucherConfirmation(RetailscmUserContext userContext, String originalVoucherConfirmationId, String [] tokensExpr) throws Exception;
	public OriginalVoucherConfirmation internalSaveOriginalVoucherConfirmation(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation) throws Exception;
	public OriginalVoucherConfirmation internalSaveOriginalVoucherConfirmation(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String originalVoucherConfirmationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, OriginalVoucherConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  OriginalVoucherManager getOriginalVoucherManager(RetailscmUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String auditingId ,String [] tokensExpr)  throws Exception;

	public  OriginalVoucherConfirmation addOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String auditingId , String [] tokensExpr)  throws Exception;
	public  OriginalVoucherConfirmation removeOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherConfirmation updateOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


