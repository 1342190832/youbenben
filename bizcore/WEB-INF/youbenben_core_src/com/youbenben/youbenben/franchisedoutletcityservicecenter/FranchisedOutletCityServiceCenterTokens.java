
package com.youbenben.youbenben.franchisedoutletcityservicecenter;
import com.youbenben.youbenben.CommonTokens;
import java.util.Map;
public class FranchisedOutletCityServiceCenterTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="franchisedOutletCityServiceCenter";
	
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
	protected FranchisedOutletCityServiceCenterTokens(){
		//ensure not initialized outside the class
	}
	public  static  FranchisedOutletCityServiceCenterTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		FranchisedOutletCityServiceCenterTokens tokens = new FranchisedOutletCityServiceCenterTokens(options);
		return tokens;
		
	}
	protected FranchisedOutletCityServiceCenterTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public FranchisedOutletCityServiceCenterTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static FranchisedOutletCityServiceCenterTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected FranchisedOutletCityServiceCenterTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static FranchisedOutletCityServiceCenterTokens start(){
		return new FranchisedOutletCityServiceCenterTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public FranchisedOutletCityServiceCenterTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static FranchisedOutletCityServiceCenterTokens allTokens(){
		
		return start()
			.withBelongsTo()
			.withCityPartnerList()
			.withPotentialCustomerList()
			.withCityEventList();
	
	}
	public static FranchisedOutletCityServiceCenterTokens withoutListsTokens(){
		
		return start()
			.withBelongsTo();
	
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
	
	public FranchisedOutletCityServiceCenterTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String BELONGSTO = "belongsTo";
	public String getBelongsTo(){
		return BELONGSTO;
	}
	public FranchisedOutletCityServiceCenterTokens withBelongsTo(){		
		addSimpleOptions(BELONGSTO);
		return this;
	}
	
	
	protected static final String CITY_PARTNER_LIST = "cityPartnerList";
	public String getCityPartnerList(){
		return CITY_PARTNER_LIST;
	}
	public FranchisedOutletCityServiceCenterTokens withCityPartnerList(){		
		addSimpleOptions(CITY_PARTNER_LIST);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens analyzeCityPartnerList(){		
		addSimpleOptions(CITY_PARTNER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCityPartnerListEnabled(){		
		
		if(checkOptions(this.options(), CITY_PARTNER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public FranchisedOutletCityServiceCenterTokens extractMoreFromCityPartnerList(String idsSeperatedWithComma){		
		addSimpleOptions(CITY_PARTNER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int cityPartnerListSortCounter = 0;
	public FranchisedOutletCityServiceCenterTokens sortCityPartnerListWith(String field, String descOrAsc){		
		addSortMoreOptions(CITY_PARTNER_LIST,cityPartnerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int cityPartnerListSearchCounter = 0;
	public FranchisedOutletCityServiceCenterTokens searchCityPartnerListWith(String field, String verb, String value){		
		
		withCityPartnerList();
		addSearchMoreOptions(CITY_PARTNER_LIST,cityPartnerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityServiceCenterTokens searchAllTextOfCityPartnerList(String verb, String value){	
		String field = "id|name|mobile|description";
		addSearchMoreOptions(CITY_PARTNER_LIST,cityPartnerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityServiceCenterTokens rowsPerPageOfCityPartnerList(int rowsPerPage){		
		addSimpleOptions(CITY_PARTNER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens currentPageNumberOfCityPartnerList(int currentPageNumber){		
		addSimpleOptions(CITY_PARTNER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens retainColumnsOfCityPartnerList(String[] columns){		
		addSimpleOptions(CITY_PARTNER_LIST+"RetainColumns",columns);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens excludeColumnsOfCityPartnerList(String[] columns){		
		addSimpleOptions(CITY_PARTNER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String POTENTIAL_CUSTOMER_LIST = "potentialCustomerList";
	public String getPotentialCustomerList(){
		return POTENTIAL_CUSTOMER_LIST;
	}
	public FranchisedOutletCityServiceCenterTokens withPotentialCustomerList(){		
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens analyzePotentialCustomerList(){		
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+".anaylze");
		return this;
	}
	public boolean analyzePotentialCustomerListEnabled(){		
		
		if(checkOptions(this.options(), POTENTIAL_CUSTOMER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public FranchisedOutletCityServiceCenterTokens extractMoreFromPotentialCustomerList(String idsSeperatedWithComma){		
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int potentialCustomerListSortCounter = 0;
	public FranchisedOutletCityServiceCenterTokens sortPotentialCustomerListWith(String field, String descOrAsc){		
		addSortMoreOptions(POTENTIAL_CUSTOMER_LIST,potentialCustomerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int potentialCustomerListSearchCounter = 0;
	public FranchisedOutletCityServiceCenterTokens searchPotentialCustomerListWith(String field, String verb, String value){		
		
		withPotentialCustomerList();
		addSearchMoreOptions(POTENTIAL_CUSTOMER_LIST,potentialCustomerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityServiceCenterTokens searchAllTextOfPotentialCustomerList(String verb, String value){	
		String field = "id|name|mobile|description";
		addSearchMoreOptions(POTENTIAL_CUSTOMER_LIST,potentialCustomerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityServiceCenterTokens rowsPerPageOfPotentialCustomerList(int rowsPerPage){		
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens currentPageNumberOfPotentialCustomerList(int currentPageNumber){		
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens retainColumnsOfPotentialCustomerList(String[] columns){		
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"RetainColumns",columns);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens excludeColumnsOfPotentialCustomerList(String[] columns){		
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CITY_EVENT_LIST = "cityEventList";
	public String getCityEventList(){
		return CITY_EVENT_LIST;
	}
	public FranchisedOutletCityServiceCenterTokens withCityEventList(){		
		addSimpleOptions(CITY_EVENT_LIST);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens analyzeCityEventList(){		
		addSimpleOptions(CITY_EVENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCityEventListEnabled(){		
		
		if(checkOptions(this.options(), CITY_EVENT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public FranchisedOutletCityServiceCenterTokens extractMoreFromCityEventList(String idsSeperatedWithComma){		
		addSimpleOptions(CITY_EVENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int cityEventListSortCounter = 0;
	public FranchisedOutletCityServiceCenterTokens sortCityEventListWith(String field, String descOrAsc){		
		addSortMoreOptions(CITY_EVENT_LIST,cityEventListSortCounter++, field, descOrAsc);
		return this;
	}
	private int cityEventListSearchCounter = 0;
	public FranchisedOutletCityServiceCenterTokens searchCityEventListWith(String field, String verb, String value){		
		
		withCityEventList();
		addSearchMoreOptions(CITY_EVENT_LIST,cityEventListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityServiceCenterTokens searchAllTextOfCityEventList(String verb, String value){	
		String field = "id|name|mobile|description";
		addSearchMoreOptions(CITY_EVENT_LIST,cityEventListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public FranchisedOutletCityServiceCenterTokens rowsPerPageOfCityEventList(int rowsPerPage){		
		addSimpleOptions(CITY_EVENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens currentPageNumberOfCityEventList(int currentPageNumber){		
		addSimpleOptions(CITY_EVENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens retainColumnsOfCityEventList(String[] columns){		
		addSimpleOptions(CITY_EVENT_LIST+"RetainColumns",columns);
		return this;
	}
	public FranchisedOutletCityServiceCenterTokens excludeColumnsOfCityEventList(String[] columns){		
		addSimpleOptions(CITY_EVENT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  FranchisedOutletCityServiceCenterTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfCityPartnerList(verb, value);	
		searchAllTextOfPotentialCustomerList(verb, value);	
		searchAllTextOfCityEventList(verb, value);	
		return this;
	}
}

