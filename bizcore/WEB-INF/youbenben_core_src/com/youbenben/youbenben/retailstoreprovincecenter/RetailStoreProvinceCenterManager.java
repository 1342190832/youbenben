
package com.youbenben.youbenben.retailstoreprovincecenter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface RetailStoreProvinceCenterManager extends BaseManager{

		

	public RetailStoreProvinceCenter createRetailStoreProvinceCenter(YoubenbenUserContext userContext, String name,Date founded,String countryId) throws Exception;
	public RetailStoreProvinceCenter updateRetailStoreProvinceCenter(YoubenbenUserContext userContext,String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreProvinceCenter loadRetailStoreProvinceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String [] tokensExpr) throws Exception;
	public RetailStoreProvinceCenter internalSaveRetailStoreProvinceCenter(YoubenbenUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter) throws Exception;
	public RetailStoreProvinceCenter internalSaveRetailStoreProvinceCenter(YoubenbenUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object>option) throws Exception;

	public RetailStoreProvinceCenter transferToAnotherCountry(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String anotherCountryId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, RetailStoreProvinceCenter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ProvinceCenterDepartmentManager getProvinceCenterDepartmentManager(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String manager ,String [] tokensExpr)  throws Exception;

	public  RetailStoreProvinceCenter addProvinceCenterDepartment(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String manager , String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter removeProvinceCenterDepartment(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter updateProvinceCenterDepartment(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProvinceCenterEmployeeManager getProvinceCenterEmployeeManager(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, String mobile, String email, Date founded, String departmentId ,String [] tokensExpr)  throws Exception;

	public  RetailStoreProvinceCenter addProvinceCenterEmployee(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, String mobile, String email, Date founded, String departmentId , String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter removeProvinceCenterEmployee(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter updateProvinceCenterEmployee(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreCityServiceCenterManager getRetailStoreCityServiceCenterManager(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded ,String [] tokensExpr)  throws Exception;

	public  RetailStoreProvinceCenter addRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded , String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter removeRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter updateRetailStoreCityServiceCenter(YoubenbenUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCountry(YoubenbenUserContext userContext,String countryId) throws Exception;
	public Object listPageByCountry(YoubenbenUserContext userContext,String countryId, int start, int count) throws Exception;
  

}


