
package com.youbenben.youbenben.originalvoucherauditing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface OriginalVoucherAuditingManager extends BaseManager{

		

	public OriginalVoucherAuditing createOriginalVoucherAuditing(YoubenbenUserContext userContext, String who,String comments,Date makeDate) throws Exception;
	public OriginalVoucherAuditing updateOriginalVoucherAuditing(YoubenbenUserContext userContext,String originalVoucherAuditingId, int originalVoucherAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OriginalVoucherAuditing loadOriginalVoucherAuditing(YoubenbenUserContext userContext, String originalVoucherAuditingId, String [] tokensExpr) throws Exception;
	public OriginalVoucherAuditing internalSaveOriginalVoucherAuditing(YoubenbenUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing) throws Exception;
	public OriginalVoucherAuditing internalSaveOriginalVoucherAuditing(YoubenbenUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String originalVoucherAuditingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, OriginalVoucherAuditing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  OriginalVoucherManager getOriginalVoucherManager(YoubenbenUserContext userContext, String originalVoucherAuditingId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String confirmationId ,String [] tokensExpr)  throws Exception;

	public  OriginalVoucherAuditing addOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherAuditingId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String creationId, String confirmationId , String [] tokensExpr)  throws Exception;
	public  OriginalVoucherAuditing removeOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherAuditing updateOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


