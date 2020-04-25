
package com.xingyou.xingyou.citycenterdepartment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.xingyou.xingyou.BaseRowMapper;
import com.xingyou.xingyou.franchisedoutletcitycenter.FranchisedOutletCityCenter;

public class CityCenterDepartmentMapper extends BaseRowMapper<CityCenterDepartment>{
	
	protected CityCenterDepartment internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		CityCenterDepartment cityCenterDepartment = getCityCenterDepartment();		
		 		
 		setId(cityCenterDepartment, rs, rowNumber); 		
 		setName(cityCenterDepartment, rs, rowNumber); 		
 		setFounded(cityCenterDepartment, rs, rowNumber); 		
 		setCityCenter(cityCenterDepartment, rs, rowNumber); 		
 		setManager(cityCenterDepartment, rs, rowNumber); 		
 		setVersion(cityCenterDepartment, rs, rowNumber);

		return cityCenterDepartment;
	}
	
	protected CityCenterDepartment getCityCenterDepartment(){
		return new CityCenterDepartment();
	}		
		
	protected void setId(CityCenterDepartment cityCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(CityCenterDepartmentTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityCenterDepartment.setId(id);
	}
		
	protected void setName(CityCenterDepartment cityCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(CityCenterDepartmentTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityCenterDepartment.setName(name);
	}
		
	protected void setFounded(CityCenterDepartment cityCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date founded = rs.getDate(CityCenterDepartmentTable.COLUMN_FOUNDED);
		
		if(founded == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityCenterDepartment.setFounded(founded);
	}
		 		
 	protected void setCityCenter(CityCenterDepartment cityCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
 		String franchisedOutletCityCenterId = rs.getString(CityCenterDepartmentTable.COLUMN_CITY_CENTER);
 		if( franchisedOutletCityCenterId == null){
 			return;
 		}
 		if( franchisedOutletCityCenterId.isEmpty()){
 			return;
 		}
 		FranchisedOutletCityCenter franchisedOutletCityCenter = cityCenterDepartment.getCityCenter();
 		if( franchisedOutletCityCenter != null ){
 			//if the root object 'cityCenterDepartment' already have the property, just set the id for it;
 			franchisedOutletCityCenter.setId(franchisedOutletCityCenterId);
 			
 			return;
 		}
 		cityCenterDepartment.setCityCenter(createEmptyCityCenter(franchisedOutletCityCenterId));
 	}
 	
	protected void setManager(CityCenterDepartment cityCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String manager = rs.getString(CityCenterDepartmentTable.COLUMN_MANAGER);
		
		if(manager == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityCenterDepartment.setManager(manager);
	}
		
	protected void setVersion(CityCenterDepartment cityCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(CityCenterDepartmentTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityCenterDepartment.setVersion(version);
	}
		
		

 	protected FranchisedOutletCityCenter  createEmptyCityCenter(String franchisedOutletCityCenterId){
 		FranchisedOutletCityCenter franchisedOutletCityCenter = new FranchisedOutletCityCenter();
 		franchisedOutletCityCenter.setId(franchisedOutletCityCenterId);
 		franchisedOutletCityCenter.setVersion(Integer.MAX_VALUE);
 		return franchisedOutletCityCenter;
 	}
 	
}


