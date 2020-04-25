
package com.youbenben.youbenben.supplyorderpicking;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface SupplyOrderPickingManager extends BaseManager{

		

	public SupplyOrderPicking createSupplyOrderPicking(YoubenbenUserContext userContext, String who,Date processTime) throws Exception;
	public SupplyOrderPicking updateSupplyOrderPicking(YoubenbenUserContext userContext,String supplyOrderPickingId, int supplyOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderPicking loadSupplyOrderPicking(YoubenbenUserContext userContext, String supplyOrderPickingId, String [] tokensExpr) throws Exception;
	public SupplyOrderPicking internalSaveSupplyOrderPicking(YoubenbenUserContext userContext, SupplyOrderPicking supplyOrderPicking) throws Exception;
	public SupplyOrderPicking internalSaveSupplyOrderPicking(YoubenbenUserContext userContext, SupplyOrderPicking supplyOrderPicking,Map<String,Object>option) throws Exception;



	public void delete(YoubenbenUserContext userContext, String supplyOrderPickingId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, SupplyOrderPicking newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SupplyOrderManager getSupplyOrderManager(YoubenbenUserContext userContext, String supplyOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderPicking addSupplyOrder(YoubenbenUserContext userContext, String supplyOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderPicking removeSupplyOrder(YoubenbenUserContext userContext, String supplyOrderPickingId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderPicking updateSupplyOrder(YoubenbenUserContext userContext, String supplyOrderPickingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


