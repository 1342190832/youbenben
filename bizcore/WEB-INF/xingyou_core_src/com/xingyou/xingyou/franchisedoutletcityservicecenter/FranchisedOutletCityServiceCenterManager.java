
package com.xingyou.xingyou.franchisedoutletcityservicecenter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface FranchisedOutletCityServiceCenterManager extends BaseManager{

		

	public FranchisedOutletCityServiceCenter createFranchisedOutletCityServiceCenter(XingyouUserContext userContext, String name,Date founded,String belongsToId) throws Exception;
	public FranchisedOutletCityServiceCenter updateFranchisedOutletCityServiceCenter(XingyouUserContext userContext,String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FranchisedOutletCityServiceCenter loadFranchisedOutletCityServiceCenter(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String [] tokensExpr) throws Exception;
	public FranchisedOutletCityServiceCenter internalSaveFranchisedOutletCityServiceCenter(XingyouUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter) throws Exception;
	public FranchisedOutletCityServiceCenter internalSaveFranchisedOutletCityServiceCenter(XingyouUserContext userContext, FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter,Map<String,Object>option) throws Exception;

	public FranchisedOutletCityServiceCenter transferToAnotherBelongsTo(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String anotherBelongsToId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, FranchisedOutletCityServiceCenter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CityPartnerManager getCityPartnerManager(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityServiceCenter addCityPartner(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter removeCityPartner(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String cityPartnerId, int cityPartnerVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter updateCityPartner(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PotentialCustomerManager getPotentialCustomerManager(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String cityPartnerId, String description ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityServiceCenter addPotentialCustomer(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String cityPartnerId, String description , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter removePotentialCustomer(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter updatePotentialCustomer(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CityEventManager getCityEventManager(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityServiceCenter addCityEvent(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String name, String mobile, String description , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter removeCityEvent(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String cityEventId, int cityEventVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityServiceCenter updateCityEvent(XingyouUserContext userContext, String franchisedOutletCityServiceCenterId, String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongsTo(XingyouUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(XingyouUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


