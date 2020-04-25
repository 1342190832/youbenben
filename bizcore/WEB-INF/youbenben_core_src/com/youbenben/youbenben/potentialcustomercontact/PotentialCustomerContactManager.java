
package com.youbenben.youbenben.potentialcustomercontact;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface PotentialCustomerContactManager extends BaseManager{

		

	public PotentialCustomerContact createPotentialCustomerContact(YoubenbenUserContext userContext, String name,Date contactDate,String contactMethod,String potentialCustomerId,String cityPartnerId,String contactToId,String description) throws Exception;
	public PotentialCustomerContact updatePotentialCustomerContact(YoubenbenUserContext userContext,String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PotentialCustomerContact loadPotentialCustomerContact(YoubenbenUserContext userContext, String potentialCustomerContactId, String [] tokensExpr) throws Exception;
	public PotentialCustomerContact internalSavePotentialCustomerContact(YoubenbenUserContext userContext, PotentialCustomerContact potentialCustomerContact) throws Exception;
	public PotentialCustomerContact internalSavePotentialCustomerContact(YoubenbenUserContext userContext, PotentialCustomerContact potentialCustomerContact,Map<String,Object>option) throws Exception;

	public PotentialCustomerContact transferToAnotherPotentialCustomer(YoubenbenUserContext userContext, String potentialCustomerContactId, String anotherPotentialCustomerId)  throws Exception;
 	public PotentialCustomerContact transferToAnotherCityPartner(YoubenbenUserContext userContext, String potentialCustomerContactId, String anotherCityPartnerId)  throws Exception;
 	public PotentialCustomerContact transferToAnotherContactTo(YoubenbenUserContext userContext, String potentialCustomerContactId, String anotherContactToId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String potentialCustomerContactId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, PotentialCustomerContact newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPotentialCustomer(YoubenbenUserContext userContext,String potentialCustomerId) throws Exception;
	public Object listPageByPotentialCustomer(YoubenbenUserContext userContext,String potentialCustomerId, int start, int count) throws Exception;
  
	public Object listByCityPartner(YoubenbenUserContext userContext,String cityPartnerId) throws Exception;
	public Object listPageByCityPartner(YoubenbenUserContext userContext,String cityPartnerId, int start, int count) throws Exception;
  
	public Object listByContactTo(YoubenbenUserContext userContext,String contactToId) throws Exception;
	public Object listPageByContactTo(YoubenbenUserContext userContext,String contactToId, int start, int count) throws Exception;
  

}


