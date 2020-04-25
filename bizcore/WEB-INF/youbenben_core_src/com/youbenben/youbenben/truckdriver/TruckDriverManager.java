
package com.youbenben.youbenben.truckdriver;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface TruckDriverManager extends BaseManager{

		

	public TruckDriver createTruckDriver(YoubenbenUserContext userContext, String name,String driverLicenseNumber,String contactNumber,String belongsToId) throws Exception;
	public TruckDriver updateTruckDriver(YoubenbenUserContext userContext,String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TruckDriver loadTruckDriver(YoubenbenUserContext userContext, String truckDriverId, String [] tokensExpr) throws Exception;
	public TruckDriver internalSaveTruckDriver(YoubenbenUserContext userContext, TruckDriver truckDriver) throws Exception;
	public TruckDriver internalSaveTruckDriver(YoubenbenUserContext userContext, TruckDriver truckDriver,Map<String,Object>option) throws Exception;

	public TruckDriver transferToAnotherBelongsTo(YoubenbenUserContext userContext, String truckDriverId, String anotherBelongsToId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String truckDriverId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, TruckDriver newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  TransportTaskManager getTransportTaskManager(YoubenbenUserContext userContext, String truckDriverId, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  TruckDriver addTransportTask(YoubenbenUserContext userContext, String truckDriverId, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  TruckDriver removeTransportTask(YoubenbenUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  TruckDriver updateTransportTask(YoubenbenUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


