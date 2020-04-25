
package com.youbenben.youbenben.eventattendance;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface EventAttendanceManager extends BaseManager{

		

	public EventAttendance createEventAttendance(YoubenbenUserContext userContext, String name,String potentialCustomerId,String cityEventId,String description) throws Exception;
	public EventAttendance updateEventAttendance(YoubenbenUserContext userContext,String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EventAttendance loadEventAttendance(YoubenbenUserContext userContext, String eventAttendanceId, String [] tokensExpr) throws Exception;
	public EventAttendance internalSaveEventAttendance(YoubenbenUserContext userContext, EventAttendance eventAttendance) throws Exception;
	public EventAttendance internalSaveEventAttendance(YoubenbenUserContext userContext, EventAttendance eventAttendance,Map<String,Object>option) throws Exception;

	public EventAttendance transferToAnotherPotentialCustomer(YoubenbenUserContext userContext, String eventAttendanceId, String anotherPotentialCustomerId)  throws Exception;
 	public EventAttendance transferToAnotherCityEvent(YoubenbenUserContext userContext, String eventAttendanceId, String anotherCityEventId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String eventAttendanceId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, EventAttendance newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPotentialCustomer(YoubenbenUserContext userContext,String potentialCustomerId) throws Exception;
	public Object listPageByPotentialCustomer(YoubenbenUserContext userContext,String potentialCustomerId, int start, int count) throws Exception;
  
	public Object listByCityEvent(YoubenbenUserContext userContext,String cityEventId) throws Exception;
	public Object listPageByCityEvent(YoubenbenUserContext userContext,String cityEventId, int start, int count) throws Exception;
  

}


