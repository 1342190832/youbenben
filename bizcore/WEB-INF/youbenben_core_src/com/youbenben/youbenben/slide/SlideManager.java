
package com.youbenben.youbenben.slide;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SlideManager extends BaseManager{

		

	public Slide createSlide(YoubenbenUserContext userContext, int displayOrder,String name,String imageUrl,String videoUrl,String linkToUrl,String pageId) throws Exception;
	public Slide updateSlide(YoubenbenUserContext userContext,String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Slide loadSlide(YoubenbenUserContext userContext, String slideId, String [] tokensExpr) throws Exception;
	public Slide internalSaveSlide(YoubenbenUserContext userContext, Slide slide) throws Exception;
	public Slide internalSaveSlide(YoubenbenUserContext userContext, Slide slide,Map<String,Object>option) throws Exception;

	public Slide transferToAnotherPage(YoubenbenUserContext userContext, String slideId, String anotherPageId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String slideId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, Slide newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(YoubenbenUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(YoubenbenUserContext userContext,String pageId, int start, int count) throws Exception;
  

}


