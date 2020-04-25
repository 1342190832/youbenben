
package com.youbenben.youbenben.citycenterdepartment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface CityCenterDepartmentManager extends BaseManager{

		

	public CityCenterDepartment createCityCenterDepartment(YoubenbenUserContext userContext, String name,Date founded,String cityCenterId,String manager) throws Exception;
	public CityCenterDepartment updateCityCenterDepartment(YoubenbenUserContext userContext,String cityCenterDepartmentId, int cityCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CityCenterDepartment loadCityCenterDepartment(YoubenbenUserContext userContext, String cityCenterDepartmentId, String [] tokensExpr) throws Exception;
	public CityCenterDepartment internalSaveCityCenterDepartment(YoubenbenUserContext userContext, CityCenterDepartment cityCenterDepartment) throws Exception;
	public CityCenterDepartment internalSaveCityCenterDepartment(YoubenbenUserContext userContext, CityCenterDepartment cityCenterDepartment,Map<String,Object>option) throws Exception;

	public CityCenterDepartment transferToAnotherCityCenter(YoubenbenUserContext userContext, String cityCenterDepartmentId, String anotherCityCenterId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String cityCenterDepartmentId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, CityCenterDepartment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CityCenterEmployeeManager getCityCenterEmployeeManager(YoubenbenUserContext userContext, String cityCenterDepartmentId, String name, String mobile, String email, Date founded, String cityCenterId ,String [] tokensExpr)  throws Exception;

	public  CityCenterDepartment addCityCenterEmployee(YoubenbenUserContext userContext, String cityCenterDepartmentId, String name, String mobile, String email, Date founded, String cityCenterId , String [] tokensExpr)  throws Exception;
	public  CityCenterDepartment removeCityCenterEmployee(YoubenbenUserContext userContext, String cityCenterDepartmentId, String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr)  throws Exception;
	public  CityCenterDepartment updateCityCenterEmployee(YoubenbenUserContext userContext, String cityCenterDepartmentId, String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCityCenter(YoubenbenUserContext userContext,String cityCenterId) throws Exception;
	public Object listPageByCityCenter(YoubenbenUserContext userContext,String cityCenterId, int start, int count) throws Exception;
  

}


