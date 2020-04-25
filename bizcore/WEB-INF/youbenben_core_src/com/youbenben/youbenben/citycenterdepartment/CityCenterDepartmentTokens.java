
package com.youbenben.youbenben.citycenterdepartment;
import com.youbenben.youbenben.CommonTokens;
import java.util.Map;
public class CityCenterDepartmentTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="cityCenterDepartment";
	
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
	protected CityCenterDepartmentTokens(){
		//ensure not initialized outside the class
	}
	public  static  CityCenterDepartmentTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		CityCenterDepartmentTokens tokens = new CityCenterDepartmentTokens(options);
		return tokens;
		
	}
	protected CityCenterDepartmentTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public CityCenterDepartmentTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static CityCenterDepartmentTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected CityCenterDepartmentTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static CityCenterDepartmentTokens start(){
		return new CityCenterDepartmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public CityCenterDepartmentTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static CityCenterDepartmentTokens allTokens(){
		
		return start()
			.withCityCenter()
			.withCityCenterEmployeeList();
	
	}
	public static CityCenterDepartmentTokens withoutListsTokens(){
		
		return start()
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
	
	public CityCenterDepartmentTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CITYCENTER = "cityCenter";
	public String getCityCenter(){
		return CITYCENTER;
	}
	public CityCenterDepartmentTokens withCityCenter(){		
		addSimpleOptions(CITYCENTER);
		return this;
	}
	
	
	protected static final String CITY_CENTER_EMPLOYEE_LIST = "cityCenterEmployeeList";
	public String getCityCenterEmployeeList(){
		return CITY_CENTER_EMPLOYEE_LIST;
	}
	public CityCenterDepartmentTokens withCityCenterEmployeeList(){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST);
		return this;
	}
	public CityCenterDepartmentTokens analyzeCityCenterEmployeeList(){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCityCenterEmployeeListEnabled(){		
		
		if(checkOptions(this.options(), CITY_CENTER_EMPLOYEE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public CityCenterDepartmentTokens extractMoreFromCityCenterEmployeeList(String idsSeperatedWithComma){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int cityCenterEmployeeListSortCounter = 0;
	public CityCenterDepartmentTokens sortCityCenterEmployeeListWith(String field, String descOrAsc){		
		addSortMoreOptions(CITY_CENTER_EMPLOYEE_LIST,cityCenterEmployeeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int cityCenterEmployeeListSearchCounter = 0;
	public CityCenterDepartmentTokens searchCityCenterEmployeeListWith(String field, String verb, String value){		
		
		withCityCenterEmployeeList();
		addSearchMoreOptions(CITY_CENTER_EMPLOYEE_LIST,cityCenterEmployeeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CityCenterDepartmentTokens searchAllTextOfCityCenterEmployeeList(String verb, String value){	
		String field = "id|name|mobile|email";
		addSearchMoreOptions(CITY_CENTER_EMPLOYEE_LIST,cityCenterEmployeeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CityCenterDepartmentTokens rowsPerPageOfCityCenterEmployeeList(int rowsPerPage){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CityCenterDepartmentTokens currentPageNumberOfCityCenterEmployeeList(int currentPageNumber){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CityCenterDepartmentTokens retainColumnsOfCityCenterEmployeeList(String[] columns){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST+"RetainColumns",columns);
		return this;
	}
	public CityCenterDepartmentTokens excludeColumnsOfCityCenterEmployeeList(String[] columns){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  CityCenterDepartmentTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfCityCenterEmployeeList(verb, value);	
		return this;
	}
}

