
package com.xingyou.xingyou.potentialcustomercontactperson;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.xingyou.xingyou.BaseDAO;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.SmartList;
import com.xingyou.xingyou.MultipleAccessKey;
import com.xingyou.xingyou.XingyouUserContext;

import com.xingyou.xingyou.potentialcustomer.PotentialCustomer;
import com.xingyou.xingyou.potentialcustomercontact.PotentialCustomerContact;

import com.xingyou.xingyou.potentialcustomer.PotentialCustomerDAO;
import com.xingyou.xingyou.potentialcustomercontact.PotentialCustomerContactDAO;


public interface PotentialCustomerContactPersonDAO extends BaseDAO{

	public SmartList<PotentialCustomerContactPerson> loadAll();
	public PotentialCustomerContactPerson load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public PotentialCustomerContactPerson present(PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String,Object> options) throws Exception;
	public PotentialCustomerContactPerson clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PotentialCustomerContactPerson save(PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String,Object> options);
	public SmartList<PotentialCustomerContactPerson> savePotentialCustomerContactPersonList(SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList,Map<String,Object> options);
	public SmartList<PotentialCustomerContactPerson> removePotentialCustomerContactPersonList(SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList,Map<String,Object> options);
	public SmartList<PotentialCustomerContactPerson> findPotentialCustomerContactPersonWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPotentialCustomerContactPersonWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPotentialCustomerContactPersonWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String potentialCustomerContactPersonId, int version) throws Exception;
	public PotentialCustomerContactPerson disconnectFromAll(String potentialCustomerContactPersonId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public PotentialCustomerContactDAO getPotentialCustomerContactDAO();
		
	
 	public SmartList<PotentialCustomerContactPerson> requestCandidatePotentialCustomerContactPersonForPotentialCustomerContact(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public PotentialCustomerContactPerson planToRemovePotentialCustomerContactList(PotentialCustomerContactPerson potentialCustomerContactPerson, String potentialCustomerContactIds[], Map<String,Object> options)throws Exception;


	//disconnect PotentialCustomerContactPerson with potential_customer in PotentialCustomerContact
	public PotentialCustomerContactPerson planToRemovePotentialCustomerContactListWithPotentialCustomer(PotentialCustomerContactPerson potentialCustomerContactPerson, String potentialCustomerId, Map<String,Object> options)throws Exception;
	public int countPotentialCustomerContactListWithPotentialCustomer(String potentialCustomerContactPersonId, String potentialCustomerId, Map<String,Object> options)throws Exception;
	
	//disconnect PotentialCustomerContactPerson with city_partner in PotentialCustomerContact
	public PotentialCustomerContactPerson planToRemovePotentialCustomerContactListWithCityPartner(PotentialCustomerContactPerson potentialCustomerContactPerson, String cityPartnerId, Map<String,Object> options)throws Exception;
	public int countPotentialCustomerContactListWithCityPartner(String potentialCustomerContactPersonId, String cityPartnerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<PotentialCustomerContactPerson> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidatePotentialCustomerContactPerson executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<PotentialCustomerContactPerson> findPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public int countPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public Map<String, Integer> countPotentialCustomerContactPersonByPotentialCustomerIds(String[] ids, Map<String,Object> options);
 	public SmartList<PotentialCustomerContactPerson> findPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId, int start, int count, Map<String,Object> options);
 	public void analyzePotentialCustomerContactPersonByPotentialCustomer(SmartList<PotentialCustomerContactPerson> resultList, String potentialCustomerId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomerContact的contactTo的PotentialCustomerContactList
	public SmartList<PotentialCustomerContact> loadOurPotentialCustomerContactList(XingyouUserContext userContext, List<PotentialCustomerContactPerson> us, Map<String,Object> options) throws Exception;
	
}


