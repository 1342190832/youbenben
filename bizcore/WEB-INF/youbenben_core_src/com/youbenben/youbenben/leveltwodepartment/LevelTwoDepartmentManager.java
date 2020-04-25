
package com.youbenben.youbenben.leveltwodepartment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface LevelTwoDepartmentManager extends BaseManager{

		

	public LevelTwoDepartment createLevelTwoDepartment(YoubenbenUserContext userContext, String belongsToId,String name,String description,Date founded) throws Exception;
	public LevelTwoDepartment updateLevelTwoDepartment(YoubenbenUserContext userContext,String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelTwoDepartment loadLevelTwoDepartment(YoubenbenUserContext userContext, String levelTwoDepartmentId, String [] tokensExpr) throws Exception;
	public LevelTwoDepartment internalSaveLevelTwoDepartment(YoubenbenUserContext userContext, LevelTwoDepartment levelTwoDepartment) throws Exception;
	public LevelTwoDepartment internalSaveLevelTwoDepartment(YoubenbenUserContext userContext, LevelTwoDepartment levelTwoDepartment,Map<String,Object>option) throws Exception;

	public LevelTwoDepartment transferToAnotherBelongsTo(YoubenbenUserContext userContext, String levelTwoDepartmentId, String anotherBelongsToId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String levelTwoDepartmentId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, LevelTwoDepartment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelThreeDepartmentManager getLevelThreeDepartmentManager(YoubenbenUserContext userContext, String levelTwoDepartmentId, String name, String description, Date founded ,String [] tokensExpr)  throws Exception;

	public  LevelTwoDepartment addLevelThreeDepartment(YoubenbenUserContext userContext, String levelTwoDepartmentId, String name, String description, Date founded , String [] tokensExpr)  throws Exception;
	public  LevelTwoDepartment removeLevelThreeDepartment(YoubenbenUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  LevelTwoDepartment updateLevelThreeDepartment(YoubenbenUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


