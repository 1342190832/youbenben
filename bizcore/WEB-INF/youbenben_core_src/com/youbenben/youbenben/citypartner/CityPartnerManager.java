
package com.youbenben.youbenben.citypartner;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface CityPartnerManager extends BaseManager{

		

	public CityPartner createCityPartner(YoubenbenUserContext userContext, String name,String mobile,String townServiceCenterId,String description) throws Exception;
	public CityPartner updateCityPartner(YoubenbenUserContext userContext,String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CityPartner loadCityPartner(YoubenbenUserContext userContext, String cityPartnerId, String [] tokensExpr) throws Exception;
	public CityPartner internalSaveCityPartner(YoubenbenUserContext userContext, CityPartner cityPartner) throws Exception;
	public CityPartner internalSaveCityPartner(YoubenbenUserContext userContext, CityPartner cityPartner,Map<String,Object>option) throws Exception;

	public CityPartner transferToAnotherTownServiceCenter(YoubenbenUserContext userContext, String cityPartnerId, String anotherTownServiceCenterId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String cityPartnerId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, CityPartner newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PotentialCustomerManager getPotentialCustomerManager(YoubenbenUserContext userContext, String cityPartnerId, String name, String mobile, String cityServiceCenterId, String description ,String [] tokensExpr)  throws Exception;

	public  CityPartner addPotentialCustomer(YoubenbenUserContext userContext, String cityPartnerId, String name, String mobile, String cityServiceCenterId, String description , String [] tokensExpr)  throws Exception;
	public  CityPartner removePotentialCustomer(YoubenbenUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr)  throws Exception;
	public  CityPartner updatePotentialCustomer(YoubenbenUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PotentialCustomerContactManager getPotentialCustomerContactManager(YoubenbenUserContext userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description ,String [] tokensExpr)  throws Exception;

	public  CityPartner addPotentialCustomerContact(YoubenbenUserContext userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description , String [] tokensExpr)  throws Exception;
	public  CityPartner removePotentialCustomerContact(YoubenbenUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr)  throws Exception;
	public  CityPartner updatePotentialCustomerContact(YoubenbenUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByTownServiceCenter(YoubenbenUserContext userContext,String townServiceCenterId) throws Exception;
	public Object listPageByTownServiceCenter(YoubenbenUserContext userContext,String townServiceCenterId, int start, int count) throws Exception;
  

}


