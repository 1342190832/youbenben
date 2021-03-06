
package com.youbenben.youbenben.warehouseasset;
import com.youbenben.youbenben.AccessKey;


public class WarehouseAssetTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="warehouse_asset_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_POSITION = "position";
	static final String COLUMN_OWNER = "owner";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_POSITION,COLUMN_OWNER,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_POSITION,COLUMN_OWNER,COLUMN_LAST_UPDATE_TIME};
	
	
}


