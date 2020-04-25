
package com.youbenben.youbenben.transporttask;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface TransportTaskManager extends BaseManager{

		

	public TransportTask createTransportTask(YoubenbenUserContext userContext, String name,String start,Date beginTime,String endId,String driverId,String truckId,String belongsToId,BigDecimal latitude,BigDecimal longitude) throws Exception;
	public TransportTask updateTransportTask(YoubenbenUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportTask loadTransportTask(YoubenbenUserContext userContext, String transportTaskId, String [] tokensExpr) throws Exception;
	public TransportTask internalSaveTransportTask(YoubenbenUserContext userContext, TransportTask transportTask) throws Exception;
	public TransportTask internalSaveTransportTask(YoubenbenUserContext userContext, TransportTask transportTask,Map<String,Object>option) throws Exception;

	public TransportTask transferToAnotherEnd(YoubenbenUserContext userContext, String transportTaskId, String anotherEndId)  throws Exception;
 	public TransportTask transferToAnotherDriver(YoubenbenUserContext userContext, String transportTaskId, String anotherDriverId)  throws Exception;
 	public TransportTask transferToAnotherTruck(YoubenbenUserContext userContext, String transportTaskId, String anotherTruckId)  throws Exception;
 	public TransportTask transferToAnotherBelongsTo(YoubenbenUserContext userContext, String transportTaskId, String anotherBelongsToId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String transportTaskId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, TransportTask newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsManager getGoodsManager(YoubenbenUserContext userContext, String transportTaskId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String packagingId ,String [] tokensExpr)  throws Exception;

	public  TransportTask addGoods(YoubenbenUserContext userContext, String transportTaskId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String packagingId , String [] tokensExpr)  throws Exception;
	public  TransportTask removeGoods(YoubenbenUserContext userContext, String transportTaskId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  TransportTask updateGoods(YoubenbenUserContext userContext, String transportTaskId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportTaskTrackManager getTransportTaskTrackManager(YoubenbenUserContext userContext, String transportTaskId, Date trackTime, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  TransportTask addTransportTaskTrack(YoubenbenUserContext userContext, String transportTaskId, Date trackTime, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  TransportTask removeTransportTaskTrack(YoubenbenUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr)  throws Exception;
	public  TransportTask updateTransportTaskTrack(YoubenbenUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByEnd(YoubenbenUserContext userContext,String endId) throws Exception;
	public Object listPageByEnd(YoubenbenUserContext userContext,String endId, int start, int count) throws Exception;
  
	public Object listByDriver(YoubenbenUserContext userContext,String driverId) throws Exception;
	public Object listPageByDriver(YoubenbenUserContext userContext,String driverId, int start, int count) throws Exception;
  
	public Object listByTruck(YoubenbenUserContext userContext,String truckId) throws Exception;
	public Object listPageByTruck(YoubenbenUserContext userContext,String truckId, int start, int count) throws Exception;
  
	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


