
package com.youbenben.youbenben.publicholiday;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface PublicHolidayManager extends BaseManager{

		

	public PublicHoliday createPublicHoliday(YoubenbenUserContext userContext, String code,String companyId,String name,String description) throws Exception;
	public PublicHoliday updatePublicHoliday(YoubenbenUserContext userContext,String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PublicHoliday loadPublicHoliday(YoubenbenUserContext userContext, String publicHolidayId, String [] tokensExpr) throws Exception;
	public PublicHoliday internalSavePublicHoliday(YoubenbenUserContext userContext, PublicHoliday publicHoliday) throws Exception;
	public PublicHoliday internalSavePublicHoliday(YoubenbenUserContext userContext, PublicHoliday publicHoliday,Map<String,Object>option) throws Exception;

	public PublicHoliday transferToAnotherCompany(YoubenbenUserContext userContext, String publicHolidayId, String anotherCompanyId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String publicHolidayId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, PublicHoliday newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByCompany(YoubenbenUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(YoubenbenUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


