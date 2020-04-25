
package com.youbenben.youbenben.franchisedoutletcityservicecenter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface FranchisedOutletCityServiceCenterManager extends BaseManager{

		

	public FranchisedOutletCityServiceCenter createFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String name,Date founded,String belongsToId) throws Exception;
	public FranchisedOutletCityServiceCenter updateFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext,String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FranchisedOutletCityServiceCenter loadFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String [] tokensExpr) throws Exception;
	public FranchisedOutletCityServiceCenter internalSaveFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter) throws Exception;
	public FranchisedOutletCityServiceCenter internalSaveFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter,Map<String,Object>option) throws Exception;

	public FranchisedOutletCityServiceCenter transferToAnotherBelongsTo(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String anotherBelongsToId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, FranchisedOutletCityServiceCenter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CityPartnerManager getCityPartnerManager(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityServiceCenter addCityPartner(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter removeCityPartner(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String cityPartnerId, int cityPartnerVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter updateCityPartner(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PotentialCustomerManager getPotentialCustomerManager(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String cityPartnerId, String description ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityServiceCenter addPotentialCustomer(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String cityPartnerId, String description , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter removePotentialCustomer(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter updatePotentialCustomer(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CityEventManager getCityEventManager(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityServiceCenter addCityEvent(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter removeCityEvent(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String cityEventId, int cityEventVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter updateCityEvent(YoubenbenUserContext userContext, String franchisedOutletCityServiceCenterId, String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


