
package com.youbenben.youbenben.potentialcustomer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface PotentialCustomerManager extends BaseManager{

		

	public PotentialCustomer createPotentialCustomer(YoubenbenUserContext userContext, String name,String mobile,String cityServiceCenterId,String cityPartnerId,String description) throws Exception;
	public PotentialCustomer updatePotentialCustomer(YoubenbenUserContext userContext,String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PotentialCustomer loadPotentialCustomer(YoubenbenUserContext userContext, String potentialCustomerId, String [] tokensExpr) throws Exception;
	public PotentialCustomer internalSavePotentialCustomer(YoubenbenUserContext userContext, PotentialCustomer potentialCustomer) throws Exception;
	public PotentialCustomer internalSavePotentialCustomer(YoubenbenUserContext userContext, PotentialCustomer potentialCustomer,Map<String,Object>option) throws Exception;

	public PotentialCustomer transferToAnotherCityServiceCenter(YoubenbenUserContext userContext, String potentialCustomerId, String anotherCityServiceCenterId)  throws Exception;
 	public PotentialCustomer transferToAnotherCityPartner(YoubenbenUserContext userContext, String potentialCustomerId, String anotherCityPartnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String potentialCustomerId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, PotentialCustomer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PotentialCustomerContactPersonManager getPotentialCustomerContactPersonManager(YoubenbenUserContext userContext, String potentialCustomerId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomer addPotentialCustomerContactPerson(YoubenbenUserContext userContext, String potentialCustomerId, String name, String mobile, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removePotentialCustomerContactPerson(YoubenbenUserContext userContext, String potentialCustomerId, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updatePotentialCustomerContactPerson(YoubenbenUserContext userContext, String potentialCustomerId, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PotentialCustomerContactManager getPotentialCustomerContactManager(YoubenbenUserContext userContext, String potentialCustomerId, String name, Date contactDate, String contactMethod, String cityPartnerId, String contactToId, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomer addPotentialCustomerContact(YoubenbenUserContext userContext, String potentialCustomerId, String name, Date contactDate, String contactMethod, String cityPartnerId, String contactToId, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removePotentialCustomerContact(YoubenbenUserContext userContext, String potentialCustomerId, String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updatePotentialCustomerContact(YoubenbenUserContext userContext, String potentialCustomerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EventAttendanceManager getEventAttendanceManager(YoubenbenUserContext userContext, String potentialCustomerId, String name, String cityEventId, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomer addEventAttendance(YoubenbenUserContext userContext, String potentialCustomerId, String name, String cityEventId, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removeEventAttendance(YoubenbenUserContext userContext, String potentialCustomerId, String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updateEventAttendance(YoubenbenUserContext userContext, String potentialCustomerId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCityServiceCenter(YoubenbenUserContext userContext,String cityServiceCenterId) throws Exception;
	public Object listPageByCityServiceCenter(YoubenbenUserContext userContext,String cityServiceCenterId, int start, int count) throws Exception;
  
	public Object listByCityPartner(YoubenbenUserContext userContext,String cityPartnerId) throws Exception;
	public Object listPageByCityPartner(YoubenbenUserContext userContext,String cityPartnerId, int start, int count) throws Exception;
  

}


