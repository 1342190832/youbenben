
package com.xingyou.xingyou.franchisedoutletcitycenter;
import com.xingyou.xingyou.CommonTokens;
import java.util.Map;
public class FranchisedOutletCityCenterTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="franchisedOutletCityCenter";
	
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
	protected FranchisedOutletCityCenterTokens(){
		//ensure not initialized outside the class
	}
	public  static  FranchisedOutletCityCenterTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		FranchisedOutletCityCenterTokens tokens = new FranchisedOutletCityCenterTokens(options);
		return tokens;
		
	}
	protected FranchisedOutletCityCenterTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public FranchisedOutletCityCenterTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static FranchisedOutletCityCenterTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected FranchisedOutletCityCenterTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static FranchisedOutletCityCenterTokens start(){
		return new FranchisedOutletCityCenterTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public FranchisedOutletCityCenterTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static FranchisedOutletCityCenterTokens allTokens(){
		
		return start()
			.withCity()
			.withFranchisedOutletCityCenterList()
			.withCityCenterDepartmentList()
			.withCityCenterEmployeeList()
			.withFranchisedOutletCityServiceCenterList();
	
	}
	public static FranchisedOutletCityCenterTokens withoutListsTokens(){
		
		return start()
			.withCity();
	
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
	
	public FranchisedOutletCityCenterTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CITY = "city";
	public String getCity(){
		return CITY;
	}
	public FranchisedOutletCityCenterTokens withCity(){		
		addSimpleOptions(CITY);
		return this;
	}
	
	
	protected static final String FRANCHISED_OUTLET_CITY_CENTER_LIST = "franchisedOutletCityCenterList";
	public String getFranchisedOutletCityCenterList(){
		return FRANCHISED_OUTLET_CITY_CENTER_LIST;
	}
	public FranchisedOutletCityCenterTokens withFranchisedOutletCityCenterList(){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_CENTER_LIST);
		return this;
	}
	public FranchisedOutletCityCenterTokens analyzeFranchisedOutletCityCenterList(){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_CENTER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeFranchisedOutletCityCenterListEnabled(){		
		
		if(checkOptions(this.options(), FRANCHISED_OUTLET_CITY_CENTER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public FranchisedOutletCityCenterTokens extractMoreFromFranchisedOutletCityCenterList(String idsSeperatedWithComma){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_CENTER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int franchisedOutletCityCenterListSortCounter = 0;
	public FranchisedOutletCityCenterTokens sortFranchisedOutletCityCenterListWith(String field, String descOrAsc){		
		addSortMoreOptions(FRANCHISED_OUTLET_CITY_CENTER_LIST,franchisedOutletCityCenterListSortCounter++, field, descOrAsc);
		return this;
	}
	private int franchisedOutletCityCenterListSearchCounter = 0;
	public FranchisedOutletCityCenterTokens searchFranchisedOutletCityCenterListWith(String field, String verb, String value){		
		
		withFranchisedOutletCityCenterList();
		addSearchMoreOptions(FRANCHISED_OUTLET_CITY_CENTER_LIST,franchisedOutletCityCenterListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityCenterTokens searchAllTextOfFranchisedOutletCityCenterList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(FRANCHISED_OUTLET_CITY_CENTER_LIST,franchisedOutletCityCenterListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityCenterTokens rowsPerPageOfFranchisedOutletCityCenterList(int rowsPerPage){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_CENTER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public FranchisedOutletCityCenterTokens currentPageNumberOfFranchisedOutletCityCenterList(int currentPageNumber){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_CENTER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public FranchisedOutletCityCenterTokens retainColumnsOfFranchisedOutletCityCenterList(String[] columns){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_CENTER_LIST+"RetainColumns",columns);
		return this;
	}
	public FranchisedOutletCityCenterTokens excludeColumnsOfFranchisedOutletCityCenterList(String[] columns){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_CENTER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CITY_CENTER_DEPARTMENT_LIST = "cityCenterDepartmentList";
	public String getCityCenterDepartmentList(){
		return CITY_CENTER_DEPARTMENT_LIST;
	}
	public FranchisedOutletCityCenterTokens withCityCenterDepartmentList(){		
		addSimpleOptions(CITY_CENTER_DEPARTMENT_LIST);
		return this;
	}
	public FranchisedOutletCityCenterTokens analyzeCityCenterDepartmentList(){		
		addSimpleOptions(CITY_CENTER_DEPARTMENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCityCenterDepartmentListEnabled(){		
		
		if(checkOptions(this.options(), CITY_CENTER_DEPARTMENT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public FranchisedOutletCityCenterTokens extractMoreFromCityCenterDepartmentList(String idsSeperatedWithComma){		
		addSimpleOptions(CITY_CENTER_DEPARTMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int cityCenterDepartmentListSortCounter = 0;
	public FranchisedOutletCityCenterTokens sortCityCenterDepartmentListWith(String field, String descOrAsc){		
		addSortMoreOptions(CITY_CENTER_DEPARTMENT_LIST,cityCenterDepartmentListSortCounter++, field, descOrAsc);
		return this;
	}
	private int cityCenterDepartmentListSearchCounter = 0;
	public FranchisedOutletCityCenterTokens searchCityCenterDepartmentListWith(String field, String verb, String value){		
		
		withCityCenterDepartmentList();
		addSearchMoreOptions(CITY_CENTER_DEPARTMENT_LIST,cityCenterDepartmentListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityCenterTokens searchAllTextOfCityCenterDepartmentList(String verb, String value){	
		String field = "id|name|manager";
		addSearchMoreOptions(CITY_CENTER_DEPARTMENT_LIST,cityCenterDepartmentListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityCenterTokens rowsPerPageOfCityCenterDepartmentList(int rowsPerPage){		
		addSimpleOptions(CITY_CENTER_DEPARTMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public FranchisedOutletCityCenterTokens currentPageNumberOfCityCenterDepartmentList(int currentPageNumber){		
		addSimpleOptions(CITY_CENTER_DEPARTMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public FranchisedOutletCityCenterTokens retainColumnsOfCityCenterDepartmentList(String[] columns){		
		addSimpleOptions(CITY_CENTER_DEPARTMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public FranchisedOutletCityCenterTokens excludeColumnsOfCityCenterDepartmentList(String[] columns){		
		addSimpleOptions(CITY_CENTER_DEPARTMENT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CITY_CENTER_EMPLOYEE_LIST = "cityCenterEmployeeList";
	public String getCityCenterEmployeeList(){
		return CITY_CENTER_EMPLOYEE_LIST;
	}
	public FranchisedOutletCityCenterTokens withCityCenterEmployeeList(){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST);
		return this;
	}
	public FranchisedOutletCityCenterTokens analyzeCityCenterEmployeeList(){		
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
	public FranchisedOutletCityCenterTokens extractMoreFromCityCenterEmployeeList(String idsSeperatedWithComma){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int cityCenterEmployeeListSortCounter = 0;
	public FranchisedOutletCityCenterTokens sortCityCenterEmployeeListWith(String field, String descOrAsc){		
		addSortMoreOptions(CITY_CENTER_EMPLOYEE_LIST,cityCenterEmployeeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int cityCenterEmployeeListSearchCounter = 0;
	public FranchisedOutletCityCenterTokens searchCityCenterEmployeeListWith(String field, String verb, String value){		
		
		withCityCenterEmployeeList();
		addSearchMoreOptions(CITY_CENTER_EMPLOYEE_LIST,cityCenterEmployeeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityCenterTokens searchAllTextOfCityCenterEmployeeList(String verb, String value){	
		String field = "id|name|mobile|email";
		addSearchMoreOptions(CITY_CENTER_EMPLOYEE_LIST,cityCenterEmployeeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityCenterTokens rowsPerPageOfCityCenterEmployeeList(int rowsPerPage){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public FranchisedOutletCityCenterTokens currentPageNumberOfCityCenterEmployeeList(int currentPageNumber){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public FranchisedOutletCityCenterTokens retainColumnsOfCityCenterEmployeeList(String[] columns){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST+"RetainColumns",columns);
		return this;
	}
	public FranchisedOutletCityCenterTokens excludeColumnsOfCityCenterEmployeeList(String[] columns){		
		addSimpleOptions(CITY_CENTER_EMPLOYEE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST = "franchisedOutletCityServiceCenterList";
	public String getFranchisedOutletCityServiceCenterList(){
		return FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST;
	}
	public FranchisedOutletCityCenterTokens withFranchisedOutletCityServiceCenterList(){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST);
		return this;
	}
	public FranchisedOutletCityCenterTokens analyzeFranchisedOutletCityServiceCenterList(){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeFranchisedOutletCityServiceCenterListEnabled(){		
		
		if(checkOptions(this.options(), FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public FranchisedOutletCityCenterTokens extractMoreFromFranchisedOutletCityServiceCenterList(String idsSeperatedWithComma){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int franchisedOutletCityServiceCenterListSortCounter = 0;
	public FranchisedOutletCityCenterTokens sortFranchisedOutletCityServiceCenterListWith(String field, String descOrAsc){		
		addSortMoreOptions(FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST,franchisedOutletCityServiceCenterListSortCounter++, field, descOrAsc);
		return this;
	}
	private int franchisedOutletCityServiceCenterListSearchCounter = 0;
	public FranchisedOutletCityCenterTokens searchFranchisedOutletCityServiceCenterListWith(String field, String verb, String value){		
		
		withFranchisedOutletCityServiceCenterList();
		addSearchMoreOptions(FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST,franchisedOutletCityServiceCenterListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityCenterTokens searchAllTextOfFranchisedOutletCityServiceCenterList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST,franchisedOutletCityServiceCenterListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityCenterTokens rowsPerPageOfFranchisedOutletCityServiceCenterList(int rowsPerPage){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public FranchisedOutletCityCenterTokens currentPageNumberOfFranchisedOutletCityServiceCenterList(int currentPageNumber){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public FranchisedOutletCityCenterTokens retainColumnsOfFranchisedOutletCityServiceCenterList(String[] columns){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST+"RetainColumns",columns);
		return this;
	}
	public FranchisedOutletCityCenterTokens excludeColumnsOfFranchisedOutletCityServiceCenterList(String[] columns){		
		addSimpleOptions(FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  FranchisedOutletCityCenterTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfFranchisedOutletCityCenterList(verb, value);	
		searchAllTextOfCityCenterDepartmentList(verb, value);	
		searchAllTextOfCityCenterEmployeeList(verb, value);	
		searchAllTextOfFranchisedOutletCityServiceCenterList(verb, value);	
		return this;
	}
}

