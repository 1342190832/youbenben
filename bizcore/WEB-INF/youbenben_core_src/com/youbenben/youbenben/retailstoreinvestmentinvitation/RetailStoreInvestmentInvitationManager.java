
package com.youbenben.youbenben.retailstoreinvestmentinvitation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreInvestmentInvitationManager extends BaseManager{

		

	public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(YoubenbenUserContext userContext, String comment) throws Exception;
	public RetailStoreInvestmentInvitation updateRetailStoreInvestmentInvitation(YoubenbenUserContext userContext,String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(YoubenbenUserContext userContext, String retailStoreInvestmentInvitationId, String [] tokensExpr) throws Exception;
	public RetailStoreInvestmentInvitation internalSaveRetailStoreInvestmentInvitation(YoubenbenUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation) throws Exception;
	public RetailStoreInvestmentInvitation internalSaveRetailStoreInvestmentInvitation(YoubenbenUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String retailStoreInvestmentInvitationId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreInvestmentInvitation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreManager getRetailStoreManager(YoubenbenUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreInvestmentInvitation addRetailStore(YoubenbenUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreInvestmentInvitation removeRetailStore(YoubenbenUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreInvestmentInvitation updateRetailStore(YoubenbenUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


