
package com.youbenben.youbenben.franchisedoutletcitycenter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.youbenben.youbenben.BaseRowMapper;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;

public class FranchisedOutletCityCenterMapper extends BaseRowMapper<FranchisedOutletCityCenter>{
	
	protected FranchisedOutletCityCenter internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		FranchisedOutletCityCenter franchisedOutletCityCenter = getFranchisedOutletCityCenter();		
		 		
 		setId(franchisedOutletCityCenter, rs, rowNumber); 		
 		setName(franchisedOutletCityCenter, rs, rowNumber); 		
 		setFounded(franchisedOutletCityCenter, rs, rowNumber); 		
 		setCity(franchisedOutletCityCenter, rs, rowNumber); 		
 		setLastUpdateTime(franchisedOutletCityCenter, rs, rowNumber); 		
 		setVersion(franchisedOutletCityCenter, rs, rowNumber);

		return franchisedOutletCityCenter;
	}
	
	protected FranchisedOutletCityCenter getFranchisedOutletCityCenter(){
		return new FranchisedOutletCityCenter();
	}		
		
	protected void setId(FranchisedOutletCityCenter franchisedOutletCityCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(FranchisedOutletCityCenterTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletCityCenter.setId(id);
	}
		
	protected void setName(FranchisedOutletCityCenter franchisedOutletCityCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(FranchisedOutletCityCenterTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletCityCenter.setName(name);
	}
		
	protected void setFounded(FranchisedOutletCityCenter franchisedOutletCityCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date founded = rs.getDate(FranchisedOutletCityCenterTable.COLUMN_FOUNDED);
		
		if(founded == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletCityCenter.setFounded(founded);
	}
		 		
 	protected void setCity(FranchisedOutletCityCenter franchisedOutletCityCenter, ResultSet rs, int rowNumber) throws SQLException{
 		String franchisedOutletCityCenterId = rs.getString(FranchisedOutletCityCenterTable.COLUMN_CITY);
 		if( franchisedOutletCityCenterId == null){
 			return;
 		}
 		if( franchisedOutletCityCenterId.isEmpty()){
 			return;
 		}
 		FranchisedOutletCityCenter franchisedOutletCityCenter = franchisedOutletCityCenter.getCity();
 		if( franchisedOutletCityCenter != null ){
 			//if the root object 'franchisedOutletCityCenter' already have the property, just set the id for it;
 			franchisedOutletCityCenter.setId(franchisedOutletCityCenterId);
 			
 			return;
 		}
 		franchisedOutletCityCenter.setCity(createEmptyCity(franchisedOutletCityCenterId));
 	}
 	
	protected void setLastUpdateTime(FranchisedOutletCityCenter franchisedOutletCityCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(FranchisedOutletCityCenterTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletCityCenter.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(FranchisedOutletCityCenter franchisedOutletCityCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(FranchisedOutletCityCenterTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletCityCenter.setVersion(version);
	}
		
		

 	protected FranchisedOutletCityCenter  createEmptyCity(String franchisedOutletCityCenterId){
 		FranchisedOutletCityCenter franchisedOutletCityCenter = new FranchisedOutletCityCenter();
 		franchisedOutletCityCenter.setId(franchisedOutletCityCenterId);
 		franchisedOutletCityCenter.setVersion(Integer.MAX_VALUE);
 		return franchisedOutletCityCenter;
 	}
 	
}


