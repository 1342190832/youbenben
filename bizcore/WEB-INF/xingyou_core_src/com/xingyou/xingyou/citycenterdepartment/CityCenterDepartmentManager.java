
package com.xingyou.xingyou.citycenterdepartment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface CityCenterDepartmentManager extends BaseManager{

		

	public CityCenterDepartment createCityCenterDepartment(XingyouUserContext userContext, String name,Date founded,String cityCenterId,String manager) throws Exception;
	public CityCenterDepartment updateCityCenterDepartment(XingyouUserContext userContext,String cityCenterDepartmentId, int cityCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CityCenterDepartment loadCityCenterDepartment(XingyouUserContext userContext, String cityCenterDepartmentId, String [] tokensExpr) throws Exception;
	public CityCenterDepartment internalSaveCityCenterDepartment(XingyouUserContext userContext, CityCenterDepartment cityCenterDepartment) throws Exception;
	public CityCenterDepartment internalSaveCityCenterDepartment(XingyouUserContext userContext, CityCenterDepartment cityCenterDepartment,Map<String,Object>option) throws Exception;

	public CityCenterDepartment transferToAnotherCityCenter(XingyouUserContext userContext, String cityCenterDepartmentId, String anotherCityCenterId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String cityCenterDepartmentId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, CityCenterDepartment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CityCenterEmployeeManager getCityCenterEmployeeManager(XingyouUserContext userContext, String cityCenterDepartmentId, String name, String mobile, String email, Date founded, String cityCenterId ,String [] tokensExpr)  throws Exception;

	public  CityCenterDepartment addCityCenterEmployee(XingyouUserContext userContext, String cityCenterDepartmentId, String name, String mobile, String email, Date founded, String cityCenterId , String [] tokensExpr)  throws Exception;
	public  CityCenterDepartment removeCityCenterEmployee(XingyouUserContext userContext, String cityCenterDepartmentId, String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr)  throws Exception;
	public  CityCenterDepartment updateCityCenterEmployee(XingyouUserContext userContext, String cityCenterDepartmentId, String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCityCenter(XingyouUserContext userContext,String cityCenterId) throws Exception;
	public Object listPageByCityCenter(XingyouUserContext userContext,String cityCenterId, int start, int count) throws Exception;
  

}


