
package com.xingyou.xingyou.potentialcustomercontact;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface PotentialCustomerContactManager extends BaseManager{

		

	public PotentialCustomerContact createPotentialCustomerContact(XingyouUserContext userContext, String name,Date contactDate,String contactMethod,String potentialCustomerId,String cityPartnerId,String contactToId,String description) throws Exception;
	public PotentialCustomerContact updatePotentialCustomerContact(XingyouUserContext userContext,String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PotentialCustomerContact loadPotentialCustomerContact(XingyouUserContext userContext, String potentialCustomerContactId, String [] tokensExpr) throws Exception;
	public PotentialCustomerContact internalSavePotentialCustomerContact(XingyouUserContext userContext, PotentialCustomerContact potentialCustomerContact) throws Exception;
	public PotentialCustomerContact internalSavePotentialCustomerContact(XingyouUserContext userContext, PotentialCustomerContact potentialCustomerContact,Map<String,Object>option) throws Exception;

	public PotentialCustomerContact transferToAnotherPotentialCustomer(XingyouUserContext userContext, String potentialCustomerContactId, String anotherPotentialCustomerId)  throws Exception;
 	public PotentialCustomerContact transferToAnotherCityPartner(XingyouUserContext userContext, String potentialCustomerContactId, String anotherCityPartnerId)  throws Exception;
 	public PotentialCustomerContact transferToAnotherContactTo(XingyouUserContext userContext, String potentialCustomerContactId, String anotherContactToId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String potentialCustomerContactId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, PotentialCustomerContact newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPotentialCustomer(XingyouUserContext userContext,String potentialCustomerId) throws Exception;
	public Object listPageByPotentialCustomer(XingyouUserContext userContext,String potentialCustomerId, int start, int count) throws Exception;
  
	public Object listByCityPartner(XingyouUserContext userContext,String cityPartnerId) throws Exception;
	public Object listPageByCityPartner(XingyouUserContext userContext,String cityPartnerId, int start, int count) throws Exception;
  
	public Object listByContactTo(XingyouUserContext userContext,String contactToId) throws Exception;
	public Object listPageByContactTo(XingyouUserContext userContext,String contactToId, int start, int count) throws Exception;
  

}


