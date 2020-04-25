
package com.doublechaintech.retailscm.supplyorderpicking;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderPickingManager extends BaseManager{

		

	public SupplyOrderPicking createSupplyOrderPicking(RetailscmUserContext userContext, String who,Date processTime) throws Exception;
	public SupplyOrderPicking updateSupplyOrderPicking(RetailscmUserContext userContext,String supplyOrderPickingId, int supplyOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderPicking loadSupplyOrderPicking(RetailscmUserContext userContext, String supplyOrderPickingId, String [] tokensExpr) throws Exception;
	public SupplyOrderPicking internalSaveSupplyOrderPicking(RetailscmUserContext userContext, SupplyOrderPicking supplyOrderPicking) throws Exception;
	public SupplyOrderPicking internalSaveSupplyOrderPicking(RetailscmUserContext userContext, SupplyOrderPicking supplyOrderPicking,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String supplyOrderPickingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderPicking newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrderPicking addSupplyOrder(RetailscmUserContext userContext, String supplyOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String processingId, String shipmentId, String deliveryId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderPicking removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderPickingId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderPicking updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderPickingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


