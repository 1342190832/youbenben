
package com.youbenben.youbenben.transporttasktrack;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface TransportTaskTrackManager extends BaseManager{

		

	public TransportTaskTrack createTransportTaskTrack(YoubenbenUserContext userContext, Date trackTime,BigDecimal latitude,BigDecimal longitude,String movementId) throws Exception;
	public TransportTaskTrack updateTransportTaskTrack(YoubenbenUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportTaskTrack loadTransportTaskTrack(YoubenbenUserContext userContext, String transportTaskTrackId, String [] tokensExpr) throws Exception;
	public TransportTaskTrack internalSaveTransportTaskTrack(YoubenbenUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception;
	public TransportTaskTrack internalSaveTransportTaskTrack(YoubenbenUserContext userContext, TransportTaskTrack transportTaskTrack,Map<String,Object>option) throws Exception;

	public TransportTaskTrack transferToAnotherMovement(YoubenbenUserContext userContext, String transportTaskTrackId, String anotherMovementId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String transportTaskTrackId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, TransportTaskTrack newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByMovement(YoubenbenUserContext userContext,String movementId) throws Exception;
	public Object listPageByMovement(YoubenbenUserContext userContext,String movementId, int start, int count) throws Exception;
  

}


