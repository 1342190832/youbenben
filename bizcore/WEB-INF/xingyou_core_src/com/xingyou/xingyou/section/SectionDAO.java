
package com.xingyou.xingyou.section;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.xingyou.xingyou.BaseDAO;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.SmartList;
import com.xingyou.xingyou.MultipleAccessKey;
import com.xingyou.xingyou.XingyouUserContext;

import com.xingyou.xingyou.page.Page;

import com.xingyou.xingyou.page.PageDAO;


public interface SectionDAO extends BaseDAO{

	public SmartList<Section> loadAll();
	public Section load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Section> sectionList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Section present(Section section,Map<String,Object> options) throws Exception;
	public Section clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Section save(Section section,Map<String,Object> options);
	public SmartList<Section> saveSectionList(SmartList<Section> sectionList,Map<String,Object> options);
	public SmartList<Section> removeSectionList(SmartList<Section> sectionList,Map<String,Object> options);
	public SmartList<Section> findSectionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSectionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSectionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String sectionId, int version) throws Exception;
	public Section disconnectFromAll(String sectionId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Section> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSection executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<Section> findSectionByPage(String pageId, Map<String,Object> options);
 	public int countSectionByPage(String pageId, Map<String,Object> options);
 	public Map<String, Integer> countSectionByPageIds(String[] ids, Map<String,Object> options);
 	public SmartList<Section> findSectionByPage(String pageId, int start, int count, Map<String,Object> options);
 	public void analyzeSectionByPage(SmartList<Section> resultList, String pageId, Map<String,Object> options);

 
 
}


