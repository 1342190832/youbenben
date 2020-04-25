
package com.youbenben.youbenben.franchisedoutletcitycenter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface FranchisedOutletCityCenterManager extends BaseManager{

		

	public FranchisedOutletCityCenter createFranchisedOutletCityCenter(YoubenbenUserContext userContext, String name,Date founded,String cityId) throws Exception;
	public FranchisedOutletCityCenter updateFranchisedOutletCityCenter(YoubenbenUserContext userContext,String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FranchisedOutletCityCenter loadFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String [] tokensExpr) throws Exception;
	public FranchisedOutletCityCenter internalSaveFranchisedOutletCityCenter(YoubenbenUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter) throws Exception;
	public FranchisedOutletCityCenter internalSaveFranchisedOutletCityCenter(YoubenbenUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter,Map<String,Object>option) throws Exception;

	public FranchisedOutletCityCenter transferToAnotherCity(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String anotherCityId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, FranchisedOutletCityCenter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  FranchisedOutletCityCenterManager getFranchisedOutletCityCenterManager(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityCenter addFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter removeFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter updateFranchisedOutletCityCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CityCenterDepartmentManager getCityCenterDepartmentManager(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded, String manager ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityCenter addCityCenterDepartment(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded, String manager , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter removeCityCenterDepartment(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String cityCenterDepartmentId, int cityCenterDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter updateCityCenterDepartment(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String cityCenterDepartmentId, int cityCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CityCenterEmployeeManager getCityCenterEmployeeManager(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, String mobile, String email, Date founded, String departmentId ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityCenter addCityCenterEmployee(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, String mobile, String email, Date founded, String departmentId , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter removeCityCenterEmployee(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter updateCityCenterEmployee(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FranchisedOutletCityServiceCenterManager getFranchisedOutletCityServiceCenterManager(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityCenter addFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter removeFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter updateFranchisedOutletCityServiceCenter(YoubenbenUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCity(YoubenbenUserContext userContext,String cityId) throws Exception;
	public Object listPageByCity(YoubenbenUserContext userContext,String cityId, int start, int count) throws Exception;
  

}


