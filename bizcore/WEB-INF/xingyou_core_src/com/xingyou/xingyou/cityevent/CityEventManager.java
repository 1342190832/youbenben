
package com.xingyou.xingyou.cityevent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface CityEventManager extends BaseManager{

		

	public CityEvent createCityEvent(XingyouUserContext userContext, String name,String mobile,String cityServiceCenterId,String description) throws Exception;
	public CityEvent updateCityEvent(XingyouUserContext userContext,String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CityEvent loadCityEvent(XingyouUserContext userContext, String cityEventId, String [] tokensExpr) throws Exception;
	public CityEvent internalSaveCityEvent(XingyouUserContext userContext, CityEvent cityEvent) throws Exception;
	public CityEvent internalSaveCityEvent(XingyouUserContext userContext, CityEvent cityEvent,Map<String,Object>option) throws Exception;

	public CityEvent transferToAnotherCityServiceCenter(XingyouUserContext userContext, String cityEventId, String anotherCityServiceCenterId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String cityEventId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, CityEvent newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EventAttendanceManager getEventAttendanceManager(XingyouUserContext userContext, String cityEventId, String name, String potentialCustomerId, String description ,String [] tokensExpr)  throws Exception;

	public  CityEvent addEventAttendance(XingyouUserContext userContext, String cityEventId, String name, String potentialCustomerId, String description , String [] tokensExpr)  throws Exception;
	public  CityEvent removeEventAttendance(XingyouUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr)  throws Exception;
	public  CityEvent updateEventAttendance(XingyouUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCityServiceCenter(XingyouUserContext userContext,String cityServiceCenterId) throws Exception;
	public Object listPageByCityServiceCenter(XingyouUserContext userContext,String cityServiceCenterId, int start, int count) throws Exception;
  

}


