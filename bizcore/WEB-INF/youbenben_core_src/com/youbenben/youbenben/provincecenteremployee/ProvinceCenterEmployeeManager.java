
package com.youbenben.youbenben.provincecenteremployee;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ProvinceCenterEmployeeManager extends BaseManager{

		

	public ProvinceCenterEmployee createProvinceCenterEmployee(YoubenbenUserContext userContext, String name,String mobile,String email,Date founded,String departmentId,String provinceCenterId) throws Exception;
	public ProvinceCenterEmployee updateProvinceCenterEmployee(YoubenbenUserContext userContext,String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ProvinceCenterEmployee loadProvinceCenterEmployee(YoubenbenUserContext userContext, String provinceCenterEmployeeId, String [] tokensExpr) throws Exception;
	public ProvinceCenterEmployee internalSaveProvinceCenterEmployee(YoubenbenUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee) throws Exception;
	public ProvinceCenterEmployee internalSaveProvinceCenterEmployee(YoubenbenUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee,Map<String,Object>option) throws Exception;

	public ProvinceCenterEmployee transferToAnotherDepartment(YoubenbenUserContext userContext, String provinceCenterEmployeeId, String anotherDepartmentId)  throws Exception;
 	public ProvinceCenterEmployee transferToAnotherProvinceCenter(YoubenbenUserContext userContext, String provinceCenterEmployeeId, String anotherProvinceCenterId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String provinceCenterEmployeeId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ProvinceCenterEmployee newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByDepartment(YoubenbenUserContext userContext,String departmentId) throws Exception;
	public Object listPageByDepartment(YoubenbenUserContext userContext,String departmentId, int start, int count) throws Exception;
  
	public Object listByProvinceCenter(YoubenbenUserContext userContext,String provinceCenterId) throws Exception;
	public Object listPageByProvinceCenter(YoubenbenUserContext userContext,String provinceCenterId, int start, int count) throws Exception;
  

}


