
package com.youbenben.youbenben.retailstorecityservicecenter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreCityServiceCenterManager extends BaseManager{

		

	public RetailStoreCityServiceCenter createRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String name,Date founded,String belongsToId) throws Exception;
	public RetailStoreCityServiceCenter updateRetailStoreCityServiceCenter(YoubenbenUserContext userContext,String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String [] tokensExpr) throws Exception;
	public RetailStoreCityServiceCenter internalSaveRetailStoreCityServiceCenter(YoubenbenUserContext userContext, RetailStoreCityServiceCenter retailStoreCityServiceCenter) throws Exception;
	public RetailStoreCityServiceCenter internalSaveRetailStoreCityServiceCenter(YoubenbenUserContext userContext, RetailStoreCityServiceCenter retailStoreCityServiceCenter,Map<String,Object>option) throws Exception;

	public RetailStoreCityServiceCenter transferToAnotherBelongsTo(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String anotherBelongsToId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreCityServiceCenter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CityPartnerManager getCityPartnerManager(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCityServiceCenter addCityPartner(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter removeCityPartner(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String cityPartnerId, int cityPartnerVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter updateCityPartner(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PotentialCustomerManager getPotentialCustomerManager(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String cityPartnerId, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCityServiceCenter addPotentialCustomer(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String cityPartnerId, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter removePotentialCustomer(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter updatePotentialCustomer(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CityEventManager getCityEventManager(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCityServiceCenter addCityEvent(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter removeCityEvent(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String cityEventId, int cityEventVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter updateCityEvent(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreManager getRetailStoreManager(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String name, String telephone, String owner, String retailStoreCountryCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCityServiceCenter addRetailStore(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String name, String telephone, String owner, String retailStoreCountryCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter removeRetailStore(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter updateRetailStore(YoubenbenUserContext userContext, String retailStoreCityServiceCenterId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


