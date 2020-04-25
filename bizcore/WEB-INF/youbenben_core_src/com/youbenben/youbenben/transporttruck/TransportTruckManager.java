
package com.youbenben.youbenben.transporttruck;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface TransportTruckManager extends BaseManager{

		

	public TransportTruck createTransportTruck(YoubenbenUserContext userContext, String name,String plateNumber,String contactNumber,String vehicleLicenseNumber,String engineNumber,Date makeDate,String mileage,String bodyColor,String ownerId) throws Exception;
	public TransportTruck updateTransportTruck(YoubenbenUserContext userContext,String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportTruck loadTransportTruck(YoubenbenUserContext userContext, String transportTruckId, String [] tokensExpr) throws Exception;
	public TransportTruck internalSaveTransportTruck(YoubenbenUserContext userContext, TransportTruck transportTruck) throws Exception;
	public TransportTruck internalSaveTransportTruck(YoubenbenUserContext userContext, TransportTruck transportTruck,Map<String,Object>option) throws Exception;

	public TransportTruck transferToAnotherOwner(YoubenbenUserContext userContext, String transportTruckId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String transportTruckId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, TransportTruck newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  TransportTaskManager getTransportTaskManager(YoubenbenUserContext userContext, String transportTruckId, String name, String start, Date beginTime, String endId, String driverId, String belongsToId, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  TransportTruck addTransportTask(YoubenbenUserContext userContext, String transportTruckId, String name, String start, Date beginTime, String endId, String driverId, String belongsToId, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  TransportTruck removeTransportTask(YoubenbenUserContext userContext, String transportTruckId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  TransportTruck updateTransportTask(YoubenbenUserContext userContext, String transportTruckId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


