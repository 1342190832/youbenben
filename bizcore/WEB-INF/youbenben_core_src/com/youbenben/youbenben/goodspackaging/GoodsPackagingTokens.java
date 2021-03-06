
package com.youbenben.youbenben.goodspackaging;
import com.youbenben.youbenben.CommonTokens;
import java.util.Map;
public class GoodsPackagingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="goodsPackaging";
	
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
	protected GoodsPackagingTokens(){
		//ensure not initialized outside the class
	}
	public  static  GoodsPackagingTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		GoodsPackagingTokens tokens = new GoodsPackagingTokens(options);
		return tokens;
		
	}
	protected GoodsPackagingTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public GoodsPackagingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GoodsPackagingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GoodsPackagingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static GoodsPackagingTokens start(){
		return new GoodsPackagingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public GoodsPackagingTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static GoodsPackagingTokens allTokens(){
		
		return start()
			.withGoodsList();
	
	}
	public static GoodsPackagingTokens withoutListsTokens(){
		
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
	
	public GoodsPackagingTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public GoodsPackagingTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}
	public GoodsPackagingTokens analyzeGoodsList(){		
		addSimpleOptions(GOODS_LIST+".anaylze");
		return this;
	}
	public boolean analyzeGoodsListEnabled(){		
		
		if(checkOptions(this.options(), GOODS_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public GoodsPackagingTokens extractMoreFromGoodsList(String idsSeperatedWithComma){		
		addSimpleOptions(GOODS_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int goodsListSortCounter = 0;
	public GoodsPackagingTokens sortGoodsListWith(String field, String descOrAsc){		
		addSortMoreOptions(GOODS_LIST,goodsListSortCounter++, field, descOrAsc);
		return this;
	}
	private int goodsListSearchCounter = 0;
	public GoodsPackagingTokens searchGoodsListWith(String field, String verb, String value){		
		
		withGoodsList();
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GoodsPackagingTokens searchAllTextOfGoodsList(String verb, String value){	
		String field = "id|name|rfid|uom";
		addSearchMoreOptions(GOODS_LIST,goodsListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GoodsPackagingTokens rowsPerPageOfGoodsList(int rowsPerPage){		
		addSimpleOptions(GOODS_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GoodsPackagingTokens currentPageNumberOfGoodsList(int currentPageNumber){		
		addSimpleOptions(GOODS_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GoodsPackagingTokens retainColumnsOfGoodsList(String[] columns){		
		addSimpleOptions(GOODS_LIST+"RetainColumns",columns);
		return this;
	}
	public GoodsPackagingTokens excludeColumnsOfGoodsList(String[] columns){		
		addSimpleOptions(GOODS_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  GoodsPackagingTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfGoodsList(verb, value);	
		return this;
	}
}

