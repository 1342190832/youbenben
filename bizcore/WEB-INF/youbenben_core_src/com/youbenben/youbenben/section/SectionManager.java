
package com.youbenben.youbenben.section;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SectionManager extends BaseManager{

		

	public Section createSection(YoubenbenUserContext userContext, String title,String brief,String icon,String viewGroup,String linkToUrl,String pageId) throws Exception;
	public Section updateSection(YoubenbenUserContext userContext,String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Section loadSection(YoubenbenUserContext userContext, String sectionId, String [] tokensExpr) throws Exception;
	public Section internalSaveSection(YoubenbenUserContext userContext, Section section) throws Exception;
	public Section internalSaveSection(YoubenbenUserContext userContext, Section section,Map<String,Object>option) throws Exception;

	public Section transferToAnotherPage(YoubenbenUserContext userContext, String sectionId, String anotherPageId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String sectionId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, Section newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(YoubenbenUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(YoubenbenUserContext userContext,String pageId, int start, int count) throws Exception;
  

}


