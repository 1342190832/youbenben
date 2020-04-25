
package com.youbenben.youbenben.potentialcustomercontact;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.potentialcustomer.PotentialCustomer;
import com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.youbenben.youbenben.citypartner.CityPartner;

import com.youbenben.youbenben.potentialcustomer.PotentialCustomerDAO;
import com.youbenben.youbenben.citypartner.CityPartnerDAO;
import com.youbenben.youbenben.potentialcustomercontactperson.PotentialCustomerContactPersonDAO;


public interface PotentialCustomerContactDAO extends BaseDAO{

	public SmartList<PotentialCustomerContact> loadAll();
	public PotentialCustomerContact load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PotentialCustomerContact> potentialCustomerContactList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public PotentialCustomerContact present(PotentialCustomerContact potentialCustomerContact,Map<String,Object> options) throws Exception;
	public PotentialCustomerContact clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PotentialCustomerContact save(PotentialCustomerContact potentialCustomerContact,Map<String,Object> options);
	public SmartList<PotentialCustomerContact> savePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList,Map<String,Object> options);
	public SmartList<PotentialCustomerContact> removePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList,Map<String,Object> options);
	public SmartList<PotentialCustomerContact> findPotentialCustomerContactWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPotentialCustomerContactWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPotentialCustomerContactWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String potentialCustomerContactId, int version) throws Exception;
	public PotentialCustomerContact disconnectFromAll(String potentialCustomerContactId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<PotentialCustomerContact> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidatePotentialCustomerContact executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public int countPotentialCustomerContactByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public Map<String, Integer> countPotentialCustomerContactByPotentialCustomerIds(String[] ids, Map<String,Object> options);
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByPotentialCustomer(String potentialCustomerId, int start, int count, Map<String,Object> options);
 	public void analyzePotentialCustomerContactByPotentialCustomer(SmartList<PotentialCustomerContact> resultList, String potentialCustomerId, Map<String,Object> options);

 
  
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByCityPartner(String cityPartnerId, Map<String,Object> options);
 	public int countPotentialCustomerContactByCityPartner(String cityPartnerId, Map<String,Object> options);
 	public Map<String, Integer> countPotentialCustomerContactByCityPartnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByCityPartner(String cityPartnerId, int start, int count, Map<String,Object> options);
 	public void analyzePotentialCustomerContactByCityPartner(SmartList<PotentialCustomerContact> resultList, String cityPartnerId, Map<String,Object> options);

 
  
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId, Map<String,Object> options);
 	public int countPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId, Map<String,Object> options);
 	public Map<String, Integer> countPotentialCustomerContactByContactToIds(String[] ids, Map<String,Object> options);
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId, int start, int count, Map<String,Object> options);
 	public void analyzePotentialCustomerContactByContactTo(SmartList<PotentialCustomerContact> resultList, String potentialCustomerContactPersonId, Map<String,Object> options);

 
 
}


