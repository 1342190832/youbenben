
package com.xingyou.xingyou.potentialcustomercontactperson;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface PotentialCustomerContactPersonManager extends BaseManager{

		

	public PotentialCustomerContactPerson createPotentialCustomerContactPerson(XingyouUserContext userContext, String name,String mobile,String potentialCustomerId,String description) throws Exception;
	public PotentialCustomerContactPerson updatePotentialCustomerContactPerson(XingyouUserContext userContext,String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PotentialCustomerContactPerson loadPotentialCustomerContactPerson(XingyouUserContext userContext, String potentialCustomerContactPersonId, String [] tokensExpr) throws Exception;
	public PotentialCustomerContactPerson internalSavePotentialCustomerContactPerson(XingyouUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson) throws Exception;
	public PotentialCustomerContactPerson internalSavePotentialCustomerContactPerson(XingyouUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String,Object>option) throws Exception;

	public PotentialCustomerContactPerson transferToAnotherPotentialCustomer(XingyouUserContext userContext, String potentialCustomerContactPersonId, String anotherPotentialCustomerId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String potentialCustomerContactPersonId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, PotentialCustomerContactPerson newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PotentialCustomerContactManager getPotentialCustomerContactManager(XingyouUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomerContactPerson addPotentialCustomerContact(XingyouUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomerContactPerson removePotentialCustomerContact(XingyouUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomerContactPerson updatePotentialCustomerContact(XingyouUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByPotentialCustomer(XingyouUserContext userContext,String potentialCustomerId) throws Exception;
	public Object listPageByPotentialCustomer(XingyouUserContext userContext,String potentialCustomerId, int start, int count) throws Exception;
  

}


