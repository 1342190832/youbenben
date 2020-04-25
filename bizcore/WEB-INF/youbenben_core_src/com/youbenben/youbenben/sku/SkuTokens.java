
package com.youbenben.youbenben.sku;
import com.youbenben.youbenben.CommonTokens;
import java.util.Map;
public class SkuTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="sku";
	
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
	protected SkuTokens(){
		//ensure not initialized outside the class
	}
	public  static  SkuTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		SkuTokens tokens = new SkuTokens(options);
		return tokens;
		
	}
	protected SkuTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public SkuTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SkuTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SkuTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static SkuTokens start(){
		return new SkuTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public SkuTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static SkuTokens allTokens(){
		
		return start()
			.withProduct();
	
	}
	public static SkuTokens withoutListsTokens(){
		
		return start()
			.withProduct();
	
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
	
	public SkuTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PRODUCT = "product";
	public String getProduct(){
		return PRODUCT;
	}
	public SkuTokens withProduct(){		
		addSimpleOptions(PRODUCT);
		return this;
	}
	
	
	
	public  SkuTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

