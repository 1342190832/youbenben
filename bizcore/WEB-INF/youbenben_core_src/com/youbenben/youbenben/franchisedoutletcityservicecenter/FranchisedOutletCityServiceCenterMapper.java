
package com.youbenben.youbenben.franchisedoutletcityservicecenter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.youbenben.youbenben.BaseRowMapper;
import com.youbenben.youbenben.franchisedoutletcitycenter.FranchisedOutletCityCenter;

public class FranchisedOutletCityServiceCenterMapper extends BaseRowMapper<FranchisedOutletCityServiceCenter>{
	
	protected FranchisedOutletCityServiceCenter internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter = getFranchisedOutletCityServiceCenter();		
		 		
 		setId(franchisedOutletCityServiceCenter, rs, rowNumber); 		
 		setName(franchisedOutletCityServiceCenter, rs, rowNumber); 		
 		setFounded(franchisedOutletCityServiceCenter, rs, rowNumber); 		
 		setBelongsTo(franchisedOutletCityServiceCenter, rs, rowNumber); 		
 		setLastUpdateTime(franchisedOutletCityServiceCenter, rs, rowNumber); 		
 		setVersion(franchisedOutletCityServiceCenter, rs, rowNumber);

		return franchisedOutletCityServiceCenter;
	}
	
	protected FranchisedOutletCityServiceCenter getFranchisedOutletCityServiceCenter(){
		return new FranchisedOutletCityServiceCenter();
	}		
		
	protected void setId(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(FranchisedOutletCityServiceCenterTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletCityServiceCenter.setId(id);
	}
		
	protected void setName(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(FranchisedOutletCityServiceCenterTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletCityServiceCenter.setName(name);
	}
		
	protected void setFounded(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date founded = rs.getDate(FranchisedOutletCityServiceCenterTable.COLUMN_FOUNDED);
		
		if(founded == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletCityServiceCenter.setFounded(founded);
	}
		 		
 	protected void setBelongsTo(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
 		String franchisedOutletCityCenterId = rs.getString(FranchisedOutletCityServiceCenterTable.COLUMN_BELONGS_TO);
 		if( franchisedOutletCityCenterId == null){
 			return;
 		}
 		if( franchisedOutletCityCenterId.isEmpty()){
 			return;
 		}
 		FranchisedOutletCityCenter franchisedOutletCityCenter = franchisedOutletCityServiceCenter.getBelongsTo();
 		if( franchisedOutletCityCenter != null ){
 			//if the root object 'franchisedOutletCityServiceCenter' already have the property, just set the id for it;
 			franchisedOutletCityCenter.setId(franchisedOutletCityCenterId);
 			
 			return;
 		}
 		franchisedOutletCityServiceCenter.setBelongsTo(createEmptyBelongsTo(franchisedOutletCityCenterId));
 	}
 	
	protected void setLastUpdateTime(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(FranchisedOutletCityServiceCenterTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletCityServiceCenter.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(FranchisedOutletCityServiceCenter franchisedOutletCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(FranchisedOutletCityServiceCenterTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletCityServiceCenter.setVersion(version);
	}
		
		

 	protected FranchisedOutletCityCenter  createEmptyBelongsTo(String franchisedOutletCityCenterId){
 		FranchisedOutletCityCenter franchisedOutletCityCenter = new FranchisedOutletCityCenter();
 		franchisedOutletCityCenter.setId(franchisedOutletCityCenterId);
 		franchisedOutletCityCenter.setVersion(Integer.MAX_VALUE);
 		return franchisedOutletCityCenter;
 	}
 	
}


