
package com.xingyou.xingyou.franchisedoutletcitycenter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.xingyou.xingyou.XingyouUserContext;
import com.xingyou.xingyou.BaseEntity;
import com.xingyou.xingyou.BaseManager;
import com.xingyou.xingyou.SmartList;

public interface FranchisedOutletCityCenterManager extends BaseManager{

		

	public FranchisedOutletCityCenter createFranchisedOutletCityCenter(XingyouUserContext userContext, String name,Date founded,String cityId) throws Exception;
	public FranchisedOutletCityCenter updateFranchisedOutletCityCenter(XingyouUserContext userContext,String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FranchisedOutletCityCenter loadFranchisedOutletCityCenter(XingyouUserContext userContext, String franchisedOutletCityCenterId, String [] tokensExpr) throws Exception;
	public FranchisedOutletCityCenter internalSaveFranchisedOutletCityCenter(XingyouUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter) throws Exception;
	public FranchisedOutletCityCenter internalSaveFranchisedOutletCityCenter(XingyouUserContext userContext, FranchisedOutletCityCenter franchisedOutletCityCenter,Map<String,Object>option) throws Exception;

	public FranchisedOutletCityCenter transferToAnotherCity(XingyouUserContext userContext, String franchisedOutletCityCenterId, String anotherCityId)  throws Exception;
 

	public void delete(XingyouUserContext userContext, String franchisedOutletCityCenterId, int version) throws Exception;
	public int deleteAll(XingyouUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(XingyouUserContext userContext, FranchisedOutletCityCenter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  FranchisedOutletCityCenterManager getFranchisedOutletCityCenterManager(XingyouUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityCenter addFranchisedOutletCityCenter(XingyouUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter removeFranchisedOutletCityCenter(XingyouUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter updateFranchisedOutletCityCenter(XingyouUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityCenterId, int franchisedOutletCityCenterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CityCenterDepartmentManager getCityCenterDepartmentManager(XingyouUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded, String manager ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityCenter addCityCenterDepartment(XingyouUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded, String manager , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter removeCityCenterDepartment(XingyouUserContext userContext, String franchisedOutletCityCenterId, String cityCenterDepartmentId, int cityCenterDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter updateCityCenterDepartment(XingyouUserContext userContext, String franchisedOutletCityCenterId, String cityCenterDepartmentId, int cityCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CityCenterEmployeeManager getCityCenterEmployeeManager(XingyouUserContext userContext, String franchisedOutletCityCenterId, String name, String mobile, String email, Date founded, String departmentId ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityCenter addCityCenterEmployee(XingyouUserContext userContext, String franchisedOutletCityCenterId, String name, String mobile, String email, Date founded, String departmentId , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter removeCityCenterEmployee(XingyouUserContext userContext, String franchisedOutletCityCenterId, String cityCenterEmployeeId, int cityCenterEmployeeVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter updateCityCenterEmployee(XingyouUserContext userContext, String franchisedOutletCityCenterId, String cityCenterEmployeeId, int cityCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FranchisedOutletCityServiceCenterManager getFranchisedOutletCityServiceCenterManager(XingyouUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded ,String [] tokensExpr)  throws Exception;

	public  FranchisedOutletCityCenter addFranchisedOutletCityServiceCenter(XingyouUserContext userContext, String franchisedOutletCityCenterId, String name, Date founded , String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter removeFranchisedOutletCityServiceCenter(XingyouUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion,String [] tokensExpr)  throws Exception;
	public  FranchisedOutletCityCenter updateFranchisedOutletCityServiceCenter(XingyouUserContext userContext, String franchisedOutletCityCenterId, String franchisedOutletCityServiceCenterId, int franchisedOutletCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCity(XingyouUserContext userContext,String cityId) throws Exception;
	public Object listPageByCity(XingyouUserContext userContext,String cityId, int start, int count) throws Exception;
  

}


