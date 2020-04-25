
package com.xingyou.xingyou.citycenteremployee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.xingyou.xingyou.BaseRowMapper;
import com.xingyou.xingyou.citycenterdepartment.CityCenterDepartment;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenter;

public class CityCenterEmployeeMapper extends BaseRowMapper<CityCenterEmployee>{
	
	protected CityCenterEmployee internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		CityCenterEmployee cityCenterEmployee = getCityCenterEmployee();		
		 		
 		setId(cityCenterEmployee, rs, rowNumber); 		
 		setName(cityCenterEmployee, rs, rowNumber); 		
 		setMobile(cityCenterEmployee, rs, rowNumber); 		
 		setEmail(cityCenterEmployee, rs, rowNumber); 		
 		setFounded(cityCenterEmployee, rs, rowNumber); 		
 		setDepartment(cityCenterEmployee, rs, rowNumber); 		
 		setCityCenter(cityCenterEmployee, rs, rowNumber); 		
 		setVersion(cityCenterEmployee, rs, rowNumber);

		return cityCenterEmployee;
	}
	
	protected CityCenterEmployee getCityCenterEmployee(){
		return new CityCenterEmployee();
	}		
		
	protected void setId(CityCenterEmployee cityCenterEmployee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(CityCenterEmployeeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityCenterEmployee.setId(id);
	}
		
	protected void setName(CityCenterEmployee cityCenterEmployee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(CityCenterEmployeeTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityCenterEmployee.setName(name);
	}
		
	protected void setMobile(CityCenterEmployee cityCenterEmployee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String mobile = rs.getString(CityCenterEmployeeTable.COLUMN_MOBILE);
		
		if(mobile == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityCenterEmployee.setMobile(mobile);
	}
		
	protected void setEmail(CityCenterEmployee cityCenterEmployee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String email = rs.getString(CityCenterEmployeeTable.COLUMN_EMAIL);
		
		if(email == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityCenterEmployee.setEmail(email);
	}
		
	protected void setFounded(CityCenterEmployee cityCenterEmployee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date founded = rs.getDate(CityCenterEmployeeTable.COLUMN_FOUNDED);
		
		if(founded == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityCenterEmployee.setFounded(founded);
	}
		 		
 	protected void setDepartment(CityCenterEmployee cityCenterEmployee, ResultSet rs, int rowNumber) throws SQLException{
 		String cityCenterDepartmentId = rs.getString(CityCenterEmployeeTable.COLUMN_DEPARTMENT);
 		if( cityCenterDepartmentId == null){
 			return;
 		}
 		if( cityCenterDepartmentId.isEmpty()){
 			return;
 		}
 		CityCenterDepartment cityCenterDepartment = cityCenterEmployee.getDepartment();
 		if( cityCenterDepartment != null ){
 			//if the root object 'cityCenterEmployee' already have the property, just set the id for it;
 			cityCenterDepartment.setId(cityCenterDepartmentId);
 			
 			return;
 		}
 		cityCenterEmployee.setDepartment(createEmptyDepartment(cityCenterDepartmentId));
 	}
 	 		
 	protected void setCityCenter(CityCenterEmployee cityCenterEmployee, ResultSet rs, int rowNumber) throws SQLException{
 		String franchisedOutletCityCenterId = rs.getString(CityCenterEmployeeTable.COLUMN_CITY_CENTER);
 		if( franchisedOutletCityCenterId == null){
 			return;
 		}
 		if( franchisedOutletCityCenterId.isEmpty()){
 			return;
 		}
 		FranchisedOutletCityCenter franchisedOutletCityCenter = cityCenterEmployee.getCityCenter();
 		if( franchisedOutletCityCenter != null ){
 			//if the root object 'cityCenterEmployee' already have the property, just set the id for it;
 			franchisedOutletCityCenter.setId(franchisedOutletCityCenterId);
 			
 			return;
 		}
 		cityCenterEmployee.setCityCenter(createEmptyCityCenter(franchisedOutletCityCenterId));
 	}
 	
	protected void setVersion(CityCenterEmployee cityCenterEmployee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(CityCenterEmployeeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityCenterEmployee.setVersion(version);
	}
		
		

 	protected CityCenterDepartment  createEmptyDepartment(String cityCenterDepartmentId){
 		CityCenterDepartment cityCenterDepartment = new CityCenterDepartment();
 		cityCenterDepartment.setId(cityCenterDepartmentId);
 		cityCenterDepartment.setVersion(Integer.MAX_VALUE);
 		return cityCenterDepartment;
 	}
 	
 	protected FranchisedOutletCityCenter  createEmptyCityCenter(String franchisedOutletCityCenterId){
 		FranchisedOutletCityCenter franchisedOutletCityCenter = new FranchisedOutletCityCenter();
 		franchisedOutletCityCenter.setId(franchisedOutletCityCenterId);
 		franchisedOutletCityCenter.setVersion(Integer.MAX_VALUE);
 		return franchisedOutletCityCenter;
 	}
 	
}


