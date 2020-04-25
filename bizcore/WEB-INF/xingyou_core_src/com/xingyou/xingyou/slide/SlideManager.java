
package com.xingyou.xingyou.slide;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface SlideManager extends BaseManager{

		

	public Slide createSlide(XingyouUserContext userContext, int displayOrder,String name,String imageUrl,String videoUrl,String linkToUrl,String pageId) throws Exception;
	public Slide updateSlide(XingyouUserContext userContext,String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Slide loadSlide(XingyouUserContext userContext, String slideId, String [] tokensExpr) throws Exception;
	public Slide internalSaveSlide(XingyouUserContext userContext, Slide slide) throws Exception;
	public Slide internalSaveSlide(XingyouUserContext userContext, Slide slide,Map<String,Object>option) throws Exception;

	public Slide transferToAnotherPage(XingyouUserContext userContext, String slideId, String anotherPageId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String slideId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, Slide newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(XingyouUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(XingyouUserContext userContext,String pageId, int start, int count) throws Exception;
  

}


