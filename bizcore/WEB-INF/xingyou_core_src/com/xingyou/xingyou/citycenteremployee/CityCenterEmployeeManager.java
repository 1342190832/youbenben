
package com.xingyou.xingyou.citycenteremployee;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface CityCenterEmployeeManager extends BaseManager{

		

	public CityCenterEmployee createCityCenterEmployee(XingyouUserContext userContext, String name,String mobile,String email,Date founded,String departmentId,String cityCenterId) throws Exception;
	public CityCenterEmployee updateCityCenterEmployee(XingyouUserContext userContext,String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CityCenterEmployee loadCityCenterEmployee(XingyouUserContext userContext, String cityCenterEmployeeId, String [] tokensExpr) throws Exception;
	public CityCenterEmployee internalSaveCityCenterEmployee(XingyouUserContext userContext, CityCenterEmployee cityCenterEmployee) throws Exception;
	public CityCenterEmployee internalSaveCityCenterEmployee(XingyouUserContext userContext, CityCenterEmployee cityCenterEmployee,Map<String,Object>option) throws Exception;

	public CityCenterEmployee transferToAnotherDepartment(XingyouUserContext userContext, String cityCenterEmployeeId, String anotherDepartmentId)  throws Exception;
 	public CityCenterEmployee transferToAnotherCityCenter(XingyouUserContext userContext, String cityCenterEmployeeId, String anotherCityCenterId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String cityCenterEmployeeId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, CityCenterEmployee newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByDepartment(XingyouUserContext userContext,String departmentId) throws Exception;
	public Object listPageByDepartment(XingyouUserContext userContext,String departmentId, int start, int count) throws Exception;
  
	public Object listByCityCenter(XingyouUserContext userContext,String cityCenterId) throws Exception;
	public Object listPageByCityCenter(XingyouUserContext userContext,String cityCenterId, int start, int count) throws Exception;
  

}


