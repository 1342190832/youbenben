
package com.youbenben.youbenben.retailstoremembergiftcard;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.youbenben.youbenben.BaseDAO;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.SmartList;
import com.youbenben.youbenben.MultipleAccessKey;
import com.youbenben.youbenben.YoubenbenUserContext;

import com.youbenben.youbenben.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.youbenben.youbenben.retailstoremember.RetailStoreMember;

import com.youbenben.youbenben.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO;
import com.youbenben.youbenben.retailstoremember.RetailStoreMemberDAO;


public interface RetailStoreMemberGiftCardDAO extends BaseDAO{

	public SmartList<RetailStoreMemberGiftCard> loadAll();
	public RetailStoreMemberGiftCard load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreMemberGiftCard present(RetailStoreMemberGiftCard retailStoreMemberGiftCard,Map<String,Object> options) throws Exception;
	public RetailStoreMemberGiftCard clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreMemberGiftCard save(RetailStoreMemberGiftCard retailStoreMemberGiftCard,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCard> saveRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCard> removeRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreMemberGiftCardWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreMemberGiftCardWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreMemberGiftCardId, int version) throws Exception;
	public RetailStoreMemberGiftCard disconnectFromAll(String retailStoreMemberGiftCardId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO();
		
	
 	public SmartList<RetailStoreMemberGiftCard> requestCandidateRetailStoreMemberGiftCardForRetailStoreMemberGiftCardConsumeRecord(YoubenbenUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreMemberGiftCard planToRemoveRetailStoreMemberGiftCardConsumeRecordList(RetailStoreMemberGiftCard retailStoreMemberGiftCard, String retailStoreMemberGiftCardConsumeRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreMemberGiftCard with biz_order in RetailStoreMemberGiftCardConsumeRecord
	public RetailStoreMemberGiftCard planToRemoveRetailStoreMemberGiftCardConsumeRecordListWithBizOrder(RetailStoreMemberGiftCard retailStoreMemberGiftCard, String bizOrderId, Map<String,Object> options)throws Exception;
	public int countRetailStoreMemberGiftCardConsumeRecordListWithBizOrder(String retailStoreMemberGiftCardId, String bizOrderId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreMemberGiftCard> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreMemberGiftCard executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countRetailStoreMemberGiftCardByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreMemberGiftCardByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreMemberGiftCardByOwner(SmartList<RetailStoreMemberGiftCard> resultList, String retailStoreMemberId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:RetailStoreMemberGiftCardConsumeRecord的owner的RetailStoreMemberGiftCardConsumeRecordList
	public SmartList<RetailStoreMemberGiftCardConsumeRecord> loadOurRetailStoreMemberGiftCardConsumeRecordList(YoubenbenUserContext userContext, List<RetailStoreMemberGiftCard> us, Map<String,Object> options) throws Exception;
	
}


