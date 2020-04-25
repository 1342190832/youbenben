
package com.xingyou.xingyou.eventattendance;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface EventAttendanceManager extends BaseManager{

		

	public EventAttendance createEventAttendance(XingyouUserContext userContext, String name,String potentialCustomerId,String cityEventId,String description) throws Exception;
	public EventAttendance updateEventAttendance(XingyouUserContext userContext,String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EventAttendance loadEventAttendance(XingyouUserContext userContext, String eventAttendanceId, String [] tokensExpr) throws Exception;
	public EventAttendance internalSaveEventAttendance(XingyouUserContext userContext, EventAttendance eventAttendance) throws Exception;
	public EventAttendance internalSaveEventAttendance(XingyouUserContext userContext, EventAttendance eventAttendance,Map<String,Object>option) throws Exception;

	public EventAttendance transferToAnotherPotentialCustomer(XingyouUserContext userContext, String eventAttendanceId, String anotherPotentialCustomerId)  throws Exception;
 	public EventAttendance transferToAnotherCityEvent(XingyouUserContext userContext, String eventAttendanceId, String anotherCityEventId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String eventAttendanceId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, EventAttendance newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPotentialCustomer(XingyouUserContext userContext,String potentialCustomerId) throws Exception;
	public Object listPageByPotentialCustomer(XingyouUserContext userContext,String potentialCustomerId, int start, int count) throws Exception;
  
	public Object listByCityEvent(XingyouUserContext userContext,String cityEventId) throws Exception;
	public Object listPageByCityEvent(XingyouUserContext userContext,String cityEventId, int start, int count) throws Exception;
  

}


