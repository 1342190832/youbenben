
package com.xingyou.xingyou.citycenteremployee;
import com.xingyou.xingyou.CommonTokens;
import java.util.Map;
public class CityCenterEmployeeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="cityCenterEmployee";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected CityCenterEmployeeTokens(){
		//ensure not initialized outside the class
	}
	public  static  CityCenterEmployeeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		CityCenterEmployeeTokens tokens = new CityCenterEmployeeTokens(options);
		return tokens;
		
	}
	protected CityCenterEmployeeTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public CityCenterEmployeeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static CityCenterEmployeeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected CityCenterEmployeeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static CityCenterEmployeeTokens start(){
		return new CityCenterEmployeeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public CityCenterEmployeeTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static CityCenterEmployeeTokens allTokens(){
		
		return start()
			.withDepartment()
			.withCityCenter();
	
	}
	public static CityCenterEmployeeTokens withoutListsTokens(){
		
		return start()
			.withDepartment()
			.withCityCenter();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}
	
	public CityCenterEmployeeTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String DEPARTMENT = "department";
	public String getDepartment(){
		return DEPARTMENT;
	}
	public CityCenterEmployeeTokens withDepartment(){		
		addSimpleOptions(DEPARTMENT);
		return this;
	}
	
	
	protected static final String CITYCENTER = "cityCenter";
	public String getCityCenter(){
		return CITYCENTER;
	}
	public CityCenterEmployeeTokens withCityCenter(){		
		addSimpleOptions(CITYCENTER);
		return this;
	}
	
	
	
	public  CityCenterEmployeeTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

