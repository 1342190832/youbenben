
package com.youbenben.youbenben.provincecenterdepartment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface ProvinceCenterDepartmentManager extends BaseManager{

		

	public ProvinceCenterDepartment createProvinceCenterDepartment(YoubenbenUserContext userContext, String name,Date founded,String provinceCenterId,String manager) throws Exception;
	public ProvinceCenterDepartment updateProvinceCenterDepartment(YoubenbenUserContext userContext,String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ProvinceCenterDepartment loadProvinceCenterDepartment(YoubenbenUserContext userContext, String provinceCenterDepartmentId, String [] tokensExpr) throws Exception;
	public ProvinceCenterDepartment internalSaveProvinceCenterDepartment(YoubenbenUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment) throws Exception;
	public ProvinceCenterDepartment internalSaveProvinceCenterDepartment(YoubenbenUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment,Map<String,Object>option) throws Exception;

	public ProvinceCenterDepartment transferToAnotherProvinceCenter(YoubenbenUserContext userContext, String provinceCenterDepartmentId, String anotherProvinceCenterId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String provinceCenterDepartmentId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, ProvinceCenterDepartment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ProvinceCenterEmployeeManager getProvinceCenterEmployeeManager(YoubenbenUserContext userContext, String provinceCenterDepartmentId, String name, String mobile, String email, Date founded, String provinceCenterId ,String [] tokensExpr)  throws Exception;

	public  ProvinceCenterDepartment addProvinceCenterEmployee(YoubenbenUserContext userContext, String provinceCenterDepartmentId, String name, String mobile, String email, Date founded, String provinceCenterId , String [] tokensExpr)  throws Exception;
	public  ProvinceCenterDepartment removeProvinceCenterEmployee(YoubenbenUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr)  throws Exception;
	public  ProvinceCenterDepartment updateProvinceCenterEmployee(YoubenbenUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByProvinceCenter(YoubenbenUserContext userContext,String provinceCenterId) throws Exception;
	public Object listPageByProvinceCenter(YoubenbenUserContext userContext,String provinceCenterId, int start, int count) throws Exception;
  

}


