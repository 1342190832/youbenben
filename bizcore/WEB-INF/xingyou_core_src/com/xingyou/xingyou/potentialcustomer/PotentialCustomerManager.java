
package com.xingyou.xingyou.potentialcustomer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface PotentialCustomerManager extends BaseManager{

		

	public PotentialCustomer createPotentialCustomer(XingyouUserContext userContext, String name,String mobile,String cityServiceCenterId,String cityPartnerId,String description) throws Exception;
	public PotentialCustomer updatePotentialCustomer(XingyouUserContext userContext,String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PotentialCustomer loadPotentialCustomer(XingyouUserContext userContext, String potentialCustomerId, String [] tokensExpr) throws Exception;
	public PotentialCustomer internalSavePotentialCustomer(XingyouUserContext userContext, PotentialCustomer potentialCustomer) throws Exception;
	public PotentialCustomer internalSavePotentialCustomer(XingyouUserContext userContext, PotentialCustomer potentialCustomer,Map<String,Object>option) throws Exception;

	public PotentialCustomer transferToAnotherCityServiceCenter(XingyouUserContext userContext, String potentialCustomerId, String anotherCityServiceCenterId)  throws Exception;
 	public PotentialCustomer transferToAnotherCityPartner(XingyouUserContext userContext, String potentialCustomerId, String anotherCityPartnerId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String potentialCustomerId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, PotentialCustomer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PotentialCustomerContactPersonManager getPotentialCustomerContactPersonManager(XingyouUserContext userContext, String potentialCustomerId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomer addPotentialCustomerContactPerson(XingyouUserContext userContext, String potentialCustomerId, String name, String mobile, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removePotentialCustomerContactPerson(XingyouUserContext userContext, String potentialCustomerId, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updatePotentialCustomerContactPerson(XingyouUserContext userContext, String potentialCustomerId, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PotentialCustomerContactManager getPotentialCustomerContactManager(XingyouUserContext userContext, String potentialCustomerId, String name, Date contactDate, String contactMethod, String cityPartnerId, String contactToId, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomer addPotentialCustomerContact(XingyouUserContext userContext, String potentialCustomerId, String name, Date contactDate, String contactMethod, String cityPartnerId, String contactToId, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removePotentialCustomerContact(XingyouUserContext userContext, String potentialCustomerId, String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updatePotentialCustomerContact(XingyouUserContext userContext, String potentialCustomerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EventAttendanceManager getEventAttendanceManager(XingyouUserContext userContext, String potentialCustomerId, String name, String cityEventId, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomer addEventAttendance(XingyouUserContext userContext, String potentialCustomerId, String name, String cityEventId, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removeEventAttendance(XingyouUserContext userContext, String potentialCustomerId, String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updateEventAttendance(XingyouUserContext userContext, String potentialCustomerId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCityServiceCenter(XingyouUserContext userContext,String cityServiceCenterId) throws Exception;
	public Object listPageByCityServiceCenter(XingyouUserContext userContext,String cityServiceCenterId, int start, int count) throws Exception;
  
	public Object listByCityPartner(XingyouUserContext userContext,String cityPartnerId) throws Exception;
	public Object listPageByCityPartner(XingyouUserContext userContext,String cityPartnerId, int start, int count) throws Exception;
  

}


