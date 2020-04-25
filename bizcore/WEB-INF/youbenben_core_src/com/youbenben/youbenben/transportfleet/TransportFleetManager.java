
package com.youbenben.youbenben.transportfleet;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface TransportFleetManager extends BaseManager{

		

	public TransportFleet createTransportFleet(YoubenbenUserContext userContext, String name,String contactNumber,String ownerId) throws Exception;
	public TransportFleet updateTransportFleet(YoubenbenUserContext userContext,String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportFleet loadTransportFleet(YoubenbenUserContext userContext, String transportFleetId, String [] tokensExpr) throws Exception;
	public TransportFleet internalSaveTransportFleet(YoubenbenUserContext userContext, TransportFleet transportFleet) throws Exception;
	public TransportFleet internalSaveTransportFleet(YoubenbenUserContext userContext, TransportFleet transportFleet,Map<String,Object>option) throws Exception;

	public TransportFleet transferToAnotherOwner(YoubenbenUserContext userContext, String transportFleetId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String transportFleetId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, TransportFleet newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  TransportTruckManager getTransportTruckManager(YoubenbenUserContext userContext, String transportFleetId, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor ,String [] tokensExpr)  throws Exception;

	public  TransportFleet addTransportTruck(YoubenbenUserContext userContext, String transportFleetId, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor , String [] tokensExpr)  throws Exception;
	public  TransportFleet removeTransportTruck(YoubenbenUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion,String [] tokensExpr)  throws Exception;
	public  TransportFleet updateTransportTruck(YoubenbenUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TruckDriverManager getTruckDriverManager(YoubenbenUserContext userContext, String transportFleetId, String name, String driverLicenseNumber, String contactNumber ,String [] tokensExpr)  throws Exception;

	public  TransportFleet addTruckDriver(YoubenbenUserContext userContext, String transportFleetId, String name, String driverLicenseNumber, String contactNumber , String [] tokensExpr)  throws Exception;
	public  TransportFleet removeTruckDriver(YoubenbenUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion,String [] tokensExpr)  throws Exception;
	public  TransportFleet updateTruckDriver(YoubenbenUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportTaskManager getTransportTaskManager(YoubenbenUserContext userContext, String transportFleetId, String name, String start, Date beginTime, String endId, String driverId, String truckId, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  TransportFleet addTransportTask(YoubenbenUserContext userContext, String transportFleetId, String name, String start, Date beginTime, String endId, String driverId, String truckId, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  TransportFleet removeTransportTask(YoubenbenUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  TransportFleet updateTransportTask(YoubenbenUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


