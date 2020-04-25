
package com.xingyou.xingyou.citypartner;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface CityPartnerManager extends BaseManager{

		

	public CityPartner createCityPartner(XingyouUserContext userContext, String name,String mobile,String townServiceCenterId,String description) throws Exception;
	public CityPartner updateCityPartner(XingyouUserContext userContext,String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CityPartner loadCityPartner(XingyouUserContext userContext, String cityPartnerId, String [] tokensExpr) throws Exception;
	public CityPartner internalSaveCityPartner(XingyouUserContext userContext, CityPartner cityPartner) throws Exception;
	public CityPartner internalSaveCityPartner(XingyouUserContext userContext, CityPartner cityPartner,Map<String,Object>option) throws Exception;

	public CityPartner transferToAnotherTownServiceCenter(XingyouUserContext userContext, String cityPartnerId, String anotherTownServiceCenterId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String cityPartnerId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, CityPartner newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PotentialCustomerManager getPotentialCustomerManager(XingyouUserContext userContext, String cityPartnerId, String name, String mobile, String cityServiceCenterId, String description ,String [] tokensExpr)  throws Exception;

	public  CityPartner addPotentialCustomer(XingyouUserContext userContext, String cityPartnerId, String name, String mobile, String cityServiceCenterId, String description , String [] tokensExpr)  throws Exception;
	public  CityPartner removePotentialCustomer(XingyouUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr)  throws Exception;
	public  CityPartner updatePotentialCustomer(XingyouUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PotentialCustomerContactManager getPotentialCustomerContactManager(XingyouUserContext userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description ,String [] tokensExpr)  throws Exception;

	public  CityPartner addPotentialCustomerContact(XingyouUserContext userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description , String [] tokensExpr)  throws Exception;
	public  CityPartner removePotentialCustomerContact(XingyouUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr)  throws Exception;
	public  CityPartner updatePotentialCustomerContact(XingyouUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByTownServiceCenter(XingyouUserContext userContext,String townServiceCenterId) throws Exception;
	public Object listPageByTownServiceCenter(XingyouUserContext userContext,String townServiceCenterId, int start, int count) throws Exception;
  

}


