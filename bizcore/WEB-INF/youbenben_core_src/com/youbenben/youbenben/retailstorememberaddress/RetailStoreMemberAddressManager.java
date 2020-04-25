
package com.youbenben.youbenben.retailstorememberaddress;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreMemberAddressManager extends BaseManager{

		

	public RetailStoreMemberAddress createRetailStoreMemberAddress(YoubenbenUserContext userContext, String name,String ownerId,String mobilePhone,String address) throws Exception;
	public RetailStoreMemberAddress updateRetailStoreMemberAddress(YoubenbenUserContext userContext,String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreMemberAddress loadRetailStoreMemberAddress(YoubenbenUserContext userContext, String retailStoreMemberAddressId, String [] tokensExpr) throws Exception;
	public RetailStoreMemberAddress internalSaveRetailStoreMemberAddress(YoubenbenUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress) throws Exception;
	public RetailStoreMemberAddress internalSaveRetailStoreMemberAddress(YoubenbenUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress,Map<String,Object>option) throws Exception;

	public RetailStoreMemberAddress transferToAnotherOwner(YoubenbenUserContext userContext, String retailStoreMemberAddressId, String anotherOwnerId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreMemberAddressId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreMemberAddress newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByOwner(YoubenbenUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(YoubenbenUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


