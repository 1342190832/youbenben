
package com.xingyou.xingyou.franchisedoutletprovincecenter;
import com.xingyou.xingyou.CommonTokens;
import java.util.Map;
public class FranchisedOutletProvinceCenterTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="franchisedOutletProvinceCenter";
	
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
	protected FranchisedOutletProvinceCenterTokens(){
		//ensure not initialized outside the class
	}
	public  static  FranchisedOutletProvinceCenterTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		FranchisedOutletProvinceCenterTokens tokens = new FranchisedOutletProvinceCenterTokens(options);
		return tokens;
		
	}
	protected FranchisedOutletProvinceCenterTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public FranchisedOutletProvinceCenterTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static FranchisedOutletProvinceCenterTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected FranchisedOutletProvinceCenterTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static FranchisedOutletProvinceCenterTokens start(){
		return new FranchisedOutletProvinceCenterTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public FranchisedOutletProvinceCenterTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static FranchisedOutletProvinceCenterTokens allTokens(){
		
		return start()
			.withCatalogList();
	
	}
	public static FranchisedOutletProvinceCenterTokens withoutListsTokens(){
		
		return start();
	
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
	
	public FranchisedOutletProvinceCenterTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CATALOG_LIST = "catalogList";
	public String getCatalogList(){
		return CATALOG_LIST;
	}
	public FranchisedOutletProvinceCenterTokens withCatalogList(){		
		addSimpleOptions(CATALOG_LIST);
		return this;
	}
	public FranchisedOutletProvinceCenterTokens analyzeCatalogList(){		
		addSimpleOptions(CATALOG_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCatalogListEnabled(){		
		
		if(checkOptions(this.options(), CATALOG_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public FranchisedOutletProvinceCenterTokens extractMoreFromCatalogList(String idsSeperatedWithComma){		
		addSimpleOptions(CATALOG_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int catalogListSortCounter = 0;
	public FranchisedOutletProvinceCenterTokens sortCatalogListWith(String field, String descOrAsc){		
		addSortMoreOptions(CATALOG_LIST,catalogListSortCounter++, field, descOrAsc);
		return this;
	}
	private int catalogListSearchCounter = 0;
	public FranchisedOutletProvinceCenterTokens searchCatalogListWith(String field, String verb, String value){		
		
		withCatalogList();
		addSearchMoreOptions(CATALOG_LIST,catalogListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletProvinceCenterTokens searchAllTextOfCatalogList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(CATALOG_LIST,catalogListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletProvinceCenterTokens rowsPerPageOfCatalogList(int rowsPerPage){		
		addSimpleOptions(CATALOG_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public FranchisedOutletProvinceCenterTokens currentPageNumberOfCatalogList(int currentPageNumber){		
		addSimpleOptions(CATALOG_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public FranchisedOutletProvinceCenterTokens retainColumnsOfCatalogList(String[] columns){		
		addSimpleOptions(CATALOG_LIST+"RetainColumns",columns);
		return this;
	}
	public FranchisedOutletProvinceCenterTokens excludeColumnsOfCatalogList(String[] columns){		
		addSimpleOptions(CATALOG_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  FranchisedOutletProvinceCenterTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfCatalogList(verb, value);	
		return this;
	}
}

