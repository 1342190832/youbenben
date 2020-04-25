
package com.youbenben.youbenben.potentialcustomercontactperson;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface PotentialCustomerContactPersonManager extends BaseManager{

		

	public PotentialCustomerContactPerson createPotentialCustomerContactPerson(YoubenbenUserContext userContext, String name,String mobile,String potentialCustomerId,String description) throws Exception;
	public PotentialCustomerContactPerson updatePotentialCustomerContactPerson(YoubenbenUserContext userContext,String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PotentialCustomerContactPerson loadPotentialCustomerContactPerson(YoubenbenUserContext userContext, String potentialCustomerContactPersonId, String [] tokensExpr) throws Exception;
	public PotentialCustomerContactPerson internalSavePotentialCustomerContactPerson(YoubenbenUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson) throws Exception;
	public PotentialCustomerContactPerson internalSavePotentialCustomerContactPerson(YoubenbenUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String,Object>option) throws Exception;

	public PotentialCustomerContactPerson transferToAnotherPotentialCustomer(YoubenbenUserContext userContext, String potentialCustomerContactPersonId, String anotherPotentialCustomerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String potentialCustomerContactPersonId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, PotentialCustomerContactPerson newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PotentialCustomerContactManager getPotentialCustomerContactManager(YoubenbenUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomerContactPerson addPotentialCustomerContact(YoubenbenUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomerContactPerson removePotentialCustomerContact(YoubenbenUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomerContactPerson updatePotentialCustomerContact(YoubenbenUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByPotentialCustomer(YoubenbenUserContext userContext,String potentialCustomerId) throws Exception;
	public Object listPageByPotentialCustomer(YoubenbenUserContext userContext,String potentialCustomerId, int start, int count) throws Exception;
  

}


