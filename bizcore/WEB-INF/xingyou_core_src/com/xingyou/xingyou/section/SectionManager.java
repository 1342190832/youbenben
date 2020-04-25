
package com.xingyou.xingyou.section;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface SectionManager extends BaseManager{

		

	public Section createSection(XingyouUserContext userContext, String title,String brief,String icon,String viewGroup,String linkToUrl,String pageId) throws Exception;
	public Section updateSection(XingyouUserContext userContext,String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Section loadSection(XingyouUserContext userContext, String sectionId, String [] tokensExpr) throws Exception;
	public Section internalSaveSection(XingyouUserContext userContext, Section section) throws Exception;
	public Section internalSaveSection(XingyouUserContext userContext, Section section,Map<String,Object>option) throws Exception;

	public Section transferToAnotherPage(XingyouUserContext userContext, String sectionId, String anotherPageId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String sectionId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, Section newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(XingyouUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(XingyouUserContext userContext,String pageId, int start, int count) throws Exception;
  

}


