
package com.xingyou.xingyou.franchisedoutletprovincecenter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.xingyou.xingyou.BaseRowMapper;

public class FranchisedOutletProvinceCenterMapper extends BaseRowMapper<FranchisedOutletProvinceCenter>{
	
	protected FranchisedOutletProvinceCenter internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = getFranchisedOutletProvinceCenter();		
		 		
 		setId(franchisedOutletProvinceCenter, rs, rowNumber); 		
 		setName(franchisedOutletProvinceCenter, rs, rowNumber); 		
 		setServiceNumber(franchisedOutletProvinceCenter, rs, rowNumber); 		
 		setFounded(franchisedOutletProvinceCenter, rs, rowNumber); 		
 		setWebSite(franchisedOutletProvinceCenter, rs, rowNumber); 		
 		setAddress(franchisedOutletProvinceCenter, rs, rowNumber); 		
 		setOperatedBy(franchisedOutletProvinceCenter, rs, rowNumber); 		
 		setLegalRepresentative(franchisedOutletProvinceCenter, rs, rowNumber); 		
 		setDescription(franchisedOutletProvinceCenter, rs, rowNumber); 		
 		setVersion(franchisedOutletProvinceCenter, rs, rowNumber);

		return franchisedOutletProvinceCenter;
	}
	
	protected FranchisedOutletProvinceCenter getFranchisedOutletProvinceCenter(){
		return new FranchisedOutletProvinceCenter();
	}		
		
	protected void setId(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(FranchisedOutletProvinceCenterTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletProvinceCenter.setId(id);
	}
		
	protected void setName(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(FranchisedOutletProvinceCenterTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletProvinceCenter.setName(name);
	}
		
	protected void setServiceNumber(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String serviceNumber = rs.getString(FranchisedOutletProvinceCenterTable.COLUMN_SERVICE_NUMBER);
		
		if(serviceNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletProvinceCenter.setServiceNumber(serviceNumber);
	}
		
	protected void setFounded(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date founded = rs.getDate(FranchisedOutletProvinceCenterTable.COLUMN_FOUNDED);
		
		if(founded == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletProvinceCenter.setFounded(founded);
	}
		
	protected void setWebSite(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String webSite = rs.getString(FranchisedOutletProvinceCenterTable.COLUMN_WEB_SITE);
		
		if(webSite == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletProvinceCenter.setWebSite(webSite);
	}
		
	protected void setAddress(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String address = rs.getString(FranchisedOutletProvinceCenterTable.COLUMN_ADDRESS);
		
		if(address == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletProvinceCenter.setAddress(address);
	}
		
	protected void setOperatedBy(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String operatedBy = rs.getString(FranchisedOutletProvinceCenterTable.COLUMN_OPERATED_BY);
		
		if(operatedBy == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletProvinceCenter.setOperatedBy(operatedBy);
	}
		
	protected void setLegalRepresentative(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String legalRepresentative = rs.getString(FranchisedOutletProvinceCenterTable.COLUMN_LEGAL_REPRESENTATIVE);
		
		if(legalRepresentative == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletProvinceCenter.setLegalRepresentative(legalRepresentative);
	}
		
	protected void setDescription(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(FranchisedOutletProvinceCenterTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletProvinceCenter.setDescription(description);
	}
		
	protected void setVersion(FranchisedOutletProvinceCenter franchisedOutletProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(FranchisedOutletProvinceCenterTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		franchisedOutletProvinceCenter.setVersion(version);
	}
		
		

}


