
package com.youbenben.youbenben.originalvoucher;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface OriginalVoucherManager extends BaseManager{

		

	public OriginalVoucher createOriginalVoucher(YoubenbenUserContext userContext, String title,String madeBy,String receivedBy,String voucherType,String voucherImage,String belongsToId,String creationId,String confirmationId,String auditingId) throws Exception;
	public OriginalVoucher updateOriginalVoucher(YoubenbenUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OriginalVoucher loadOriginalVoucher(YoubenbenUserContext userContext, String originalVoucherId, String [] tokensExpr) throws Exception;
	public OriginalVoucher internalSaveOriginalVoucher(YoubenbenUserContext userContext, OriginalVoucher originalVoucher) throws Exception;
	public OriginalVoucher internalSaveOriginalVoucher(YoubenbenUserContext userContext, OriginalVoucher originalVoucher,Map<String,Object>option) throws Exception;

	public OriginalVoucher transferToAnotherBelongsTo(YoubenbenUserContext userContext, String originalVoucherId, String anotherBelongsToId)  throws Exception;
 	public OriginalVoucher transferToAnotherCreation(YoubenbenUserContext userContext, String originalVoucherId, String anotherCreationId)  throws Exception;
 	public OriginalVoucher transferToAnotherConfirmation(YoubenbenUserContext userContext, String originalVoucherId, String anotherConfirmationId)  throws Exception;
 	public OriginalVoucher transferToAnotherAuditing(YoubenbenUserContext userContext, String originalVoucherId, String anotherAuditingId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String originalVoucherId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, OriginalVoucher newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception;
  
	public Object listByCreation(YoubenbenUserContext userContext,String creationId) throws Exception;
	public Object listPageByCreation(YoubenbenUserContext userContext,String creationId, int start, int count) throws Exception;
  
	public Object listByConfirmation(YoubenbenUserContext userContext,String confirmationId) throws Exception;
	public Object listPageByConfirmation(YoubenbenUserContext userContext,String confirmationId, int start, int count) throws Exception;
  
	public Object listByAuditing(YoubenbenUserContext userContext,String auditingId) throws Exception;
	public Object listPageByAuditing(YoubenbenUserContext userContext,String auditingId, int start, int count) throws Exception;
  

}


