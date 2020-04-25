
package com.youbenben.youbenben.citycenteremployee;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface CityCenterEmployeeManager extends BaseManager{

		

	public CityCenterEmployee createCityCenterEmployee(YoubenbenUserContext userContext, String name,String mobile,String email,Date founded,String departmentId,String cityCenterId) throws Exception;
	public CityCenterEmployee updateCityCenterEmployee(YoubenbenUserContext userContext,String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CityCenterEmployee loadCityCenterEmployee(YoubenbenUserContext userContext, String cityCenterEmployeeId, String [] tokensExpr) throws Exception;
	public CityCenterEmployee internalSaveCityCenterEmployee(YoubenbenUserContext userContext, CityCenterEmployee cityCenterEmployee) throws Exception;
	public CityCenterEmployee internalSaveCityCenterEmployee(YoubenbenUserContext userContext, CityCenterEmployee cityCenterEmployee,Map<String,Object>option) throws Exception;

	public CityCenterEmployee transferToAnotherDepartment(YoubenbenUserContext userContext, String cityCenterEmployeeId, String anotherDepartmentId)  throws Exception;
 	public CityCenterEmployee transferToAnotherCityCenter(YoubenbenUserContext userContext, String cityCenterEmployeeId, String anotherCityCenterId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String cityCenterEmployeeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, CityCenterEmployee newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByDepartment(YoubenbenUserContext userContext,String departmentId) throws Exception;
	public Object listPageByDepartment(YoubenbenUserContext userContext,String departmentId, int start, int count) throws Exception;
  
	public Object listByCityCenter(YoubenbenUserContext userContext,String cityCenterId) throws Exception;
	public Object listPageByCityCenter(YoubenbenUserContext userContext,String cityCenterId, int start, int count) throws Exception;
  

}


