
package com.youbenben.youbenben.goodsmovement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface GoodsMovementManager extends BaseManager{

		

	public GoodsMovement createGoodsMovement(YoubenbenUserContext userContext, DateTime moveTime,String facility,String facilityId,String fromIp,String userAgent,String sessionId,BigDecimal latitude,BigDecimal longitude,String goodsId) throws Exception;
	public GoodsMovement updateGoodsMovement(YoubenbenUserContext userContext,String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsMovement loadGoodsMovement(YoubenbenUserContext userContext, String goodsMovementId, String [] tokensExpr) throws Exception;
	public GoodsMovement internalSaveGoodsMovement(YoubenbenUserContext userContext, GoodsMovement goodsMovement) throws Exception;
	public GoodsMovement internalSaveGoodsMovement(YoubenbenUserContext userContext, GoodsMovement goodsMovement,Map<String,Object>option) throws Exception;

	public GoodsMovement transferToAnotherGoods(YoubenbenUserContext userContext, String goodsMovementId, String anotherGoodsId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String goodsMovementId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, GoodsMovement newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByGoods(YoubenbenUserContext userContext,String goodsId) throws Exception;
	public Object listPageByGoods(YoubenbenUserContext userContext,String goodsId, int start, int count) throws Exception;
  

}


