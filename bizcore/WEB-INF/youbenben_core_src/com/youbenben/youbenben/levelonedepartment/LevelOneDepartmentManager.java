
package com.youbenben.youbenben.levelonedepartment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.youbenben.youbenben.YoubenbenUserContext;
import com.youbenben.youbenben.BaseEntity;
import com.youbenben.youbenben.BaseManager;
import com.youbenben.youbenben.SmartList;

public interface LevelOneDepartmentManager extends BaseManager{

		

	public LevelOneDepartment createLevelOneDepartment(YoubenbenUserContext userContext, String belongsToId,String name,String description,String manager,Date founded) throws Exception;
	public LevelOneDepartment updateLevelOneDepartment(YoubenbenUserContext userContext,String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelOneDepartment loadLevelOneDepartment(YoubenbenUserContext userContext, String levelOneDepartmentId, String [] tokensExpr) throws Exception;
	public LevelOneDepartment internalSaveLevelOneDepartment(YoubenbenUserContext userContext, LevelOneDepartment levelOneDepartment) throws Exception;
	public LevelOneDepartment internalSaveLevelOneDepartment(YoubenbenUserContext userContext, LevelOneDepartment levelOneDepartment,Map<String,Object>option) throws Exception;

	public LevelOneDepartment transferToAnotherBelongsTo(YoubenbenUserContext userContext, String levelOneDepartmentId, String anotherBelongsToId)  throws Exception;
 

	public void delete(YoubenbenUserContext userContext, String levelOneDepartmentId, int version) throws Exception;
	public int deleteAll(YoubenbenUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(YoubenbenUserContext userContext, LevelOneDepartment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelTwoDepartmentManager getLevelTwoDepartmentManager(YoubenbenUserContext userContext, String levelOneDepartmentId, String name, String description, Date founded ,String [] tokensExpr)  throws Exception;

	public  LevelOneDepartment addLevelTwoDepartment(YoubenbenUserContext userContext, String levelOneDepartmentId, String name, String description, Date founded , String [] tokensExpr)  throws Exception;
	public  LevelOneDepartment removeLevelTwoDepartment(YoubenbenUserContext userContext, String levelOneDepartmentId, String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  LevelOneDepartment updateLevelTwoDepartment(YoubenbenUserContext userContext, String levelOneDepartmentId, String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongsTo(YoubenbenUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(YoubenbenUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


