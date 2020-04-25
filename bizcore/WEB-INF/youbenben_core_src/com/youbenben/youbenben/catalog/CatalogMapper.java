
package com.youbenben.youbenben.catalog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.youbenben.youbenben.BaseRowMapper;
import com.youbenben.youbenben.franchisedoutletprovincecenter.FranchisedOutletProvinceCenter;

public class CatalogMapper extends BaseRowMapper<Catalog>{
	
	protected Catalog internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Catalog catalog = getCatalog();		
		 		
 		setId(catalog, rs, rowNumber); 		
 		setName(catalog, rs, rowNumber); 		
 		setOwner(catalog, rs, rowNumber); 		
 		setSubCount(catalog, rs, rowNumber); 		
 		setAmount(catalog, rs, rowNumber); 		
 		setVersion(catalog, rs, rowNumber);

		return catalog;
	}
	
	protected Catalog getCatalog(){
		return new Catalog();
	}		
		
	protected void setId(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(CatalogTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setId(id);
	}
		
	protected void setName(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(CatalogTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setName(name);
	}
		 		
 	protected void setOwner(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
 		String franchisedOutletProvinceCenterId = rs.getString(CatalogTable.COLUMN_OWNER);
 		if( franchisedOutletProvinceCenterId == null){
 			return;
 		}
 		if( franchisedOutletProvinceCenterId.isEmpty()){
 			return;
 		}
 		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = catalog.getOwner();
 		if( franchisedOutletProvinceCenter != null ){
 			//if the root object 'catalog' already have the property, just set the id for it;
 			franchisedOutletProvinceCenter.setId(franchisedOutletProvinceCenterId);
 			
 			return;
 		}
 		catalog.setOwner(createEmptyOwner(franchisedOutletProvinceCenterId));
 	}
 	
	protected void setSubCount(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer subCount = rs.getInt(CatalogTable.COLUMN_SUB_COUNT);
		
		if(subCount == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setSubCount(subCount);
	}
		
	protected void setAmount(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal amount = rs.getBigDecimal(CatalogTable.COLUMN_AMOUNT);
		
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setAmount(amount);
	}
		
	protected void setVersion(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(CatalogTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		catalog.setVersion(version);
	}
		
		

 	protected FranchisedOutletProvinceCenter  createEmptyOwner(String franchisedOutletProvinceCenterId){
 		FranchisedOutletProvinceCenter franchisedOutletProvinceCenter = new FranchisedOutletProvinceCenter();
 		franchisedOutletProvinceCenter.setId(franchisedOutletProvinceCenterId);
 		franchisedOutletProvinceCenter.setVersion(Integer.MAX_VALUE);
 		return franchisedOutletProvinceCenter;
 	}
 	
}


