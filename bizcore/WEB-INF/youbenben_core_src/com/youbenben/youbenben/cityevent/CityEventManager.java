
package com.youbenben.youbenben.cityevent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface CityEventManager extends BaseManager{

		

	public CityEvent createCityEvent(YoubenbenUserContext userContext, String name,String mobile,String cityServiceCenterId,String description) throws Exception;
	public CityEvent updateCityEvent(YoubenbenUserContext userContext,String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CityEvent loadCityEvent(YoubenbenUserContext userContext, String cityEventId, String [] tokensExpr) throws Exception;
	public CityEvent internalSaveCityEvent(YoubenbenUserContext userContext, CityEvent cityEvent) throws Exception;
	public CityEvent internalSaveCityEvent(YoubenbenUserContext userContext, CityEvent cityEvent,Map<String,Object>option) throws Exception;

	public CityEvent transferToAnotherCityServiceCenter(YoubenbenUserContext userContext, String cityEventId, String anotherCityServiceCenterId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String cityEventId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, CityEvent newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EventAttendanceManager getEventAttendanceManager(YoubenbenUserContext userContext, String cityEventId, String name, String potentialCustomerId, String description ,String [] tokensExpr)  throws Exception;

	public  CityEvent addEventAttendance(YoubenbenUserContext userContext, String cityEventId, String name, String potentialCustomerId, String description , String [] tokensExpr)  throws Exception;
	public  CityEvent removeEventAttendance(YoubenbenUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr)  throws Exception;
	public  CityEvent updateEventAttendance(YoubenbenUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCityServiceCenter(YoubenbenUserContext userContext,String cityServiceCenterId) throws Exception;
	public Object listPageByCityServiceCenter(YoubenbenUserContext userContext,String cityServiceCenterId, int start, int count) throws Exception;
  

}


