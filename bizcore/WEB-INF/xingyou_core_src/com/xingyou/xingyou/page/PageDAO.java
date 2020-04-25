
package com.xingyou.xingyou.page;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.xingyou.xingyou.BaseDAO;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.SmartList;
import com.xingyou.xingyou.MultipleAccessKey;
import com.xingyou.xingyou.XingyouUserContext;

import com.xingyou.xingyou.mobileapp.MobileApp;
import com.xingyou.xingyou.uiaction.UiAction;
import com.xingyou.xingyou.pagetype.PageType;
import com.xingyou.xingyou.section.Section;
import com.xingyou.xingyou.slide.Slide;

import com.xingyou.xingyou.pagetype.PageTypeDAO;
import com.xingyou.xingyou.slide.SlideDAO;
import com.xingyou.xingyou.section.SectionDAO;
import com.xingyou.xingyou.mobileapp.MobileAppDAO;
import com.xingyou.xingyou.uiaction.UiActionDAO;


public interface PageDAO extends BaseDAO{

	public SmartList<Page> loadAll();
	public Page load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Page> pageList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Page present(Page page,Map<String,Object> options) throws Exception;
	public Page clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Page save(Page page,Map<String,Object> options);
	public SmartList<Page> savePageList(SmartList<Page> pageList,Map<String,Object> options);
	public SmartList<Page> removePageList(SmartList<Page> pageList,Map<String,Object> options);
	public SmartList<Page> findPageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPageWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String pageId, int version) throws Exception;
	public Page disconnectFromAll(String pageId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public SlideDAO getSlideDAO();
		
	public UiActionDAO getUiActionDAO();
		
	public SectionDAO getSectionDAO();
		
	
 	public SmartList<Page> requestCandidatePageForSlide(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Page> requestCandidatePageForUiAction(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Page> requestCandidatePageForSection(XingyouUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Page planToRemoveSlideList(Page page, String slideIds[], Map<String,Object> options)throws Exception;


	public Page planToRemoveUiActionList(Page page, String uiActionIds[], Map<String,Object> options)throws Exception;


	public Page planToRemoveSectionList(Page page, String sectionIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Page> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidatePage executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<Page> findPageByPageType(String pageTypeId, Map<String,Object> options);
 	public int countPageByPageType(String pageTypeId, Map<String,Object> options);
 	public Map<String, Integer> countPageByPageTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<Page> findPageByPageType(String pageTypeId, int start, int count, Map<String,Object> options);
 	public void analyzePageByPageType(SmartList<Page> resultList, String pageTypeId, Map<String,Object> options);

 
  
 	public SmartList<Page> findPageByMobileApp(String mobileAppId, Map<String,Object> options);
 	public int countPageByMobileApp(String mobileAppId, Map<String,Object> options);
 	public Map<String, Integer> countPageByMobileAppIds(String[] ids, Map<String,Object> options);
 	public SmartList<Page> findPageByMobileApp(String mobileAppId, int start, int count, Map<String,Object> options);
 	public void analyzePageByMobileApp(SmartList<Page> resultList, String mobileAppId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Slide的page的SlideList
	public SmartList<Slide> loadOurSlideList(XingyouUserContext userContext, List<Page> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:UiAction的page的UiActionList
	public SmartList<UiAction> loadOurUiActionList(XingyouUserContext userContext, List<Page> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Section的page的SectionList
	public SmartList<Section> loadOurSectionList(XingyouUserContext userContext, List<Page> us, Map<String,Object> options) throws Exception;
	
}


