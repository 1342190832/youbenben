
package com.youbenben.youbenben.accountingdocumentposting;
import com.youbenben.youbenben.CommonTokens;
import java.util.Map;
public class AccountingDocumentPostingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="accountingDocumentPosting";
	
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
	protected AccountingDocumentPostingTokens(){
		//ensure not initialized outside the class
	}
	public  static  AccountingDocumentPostingTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		AccountingDocumentPostingTokens tokens = new AccountingDocumentPostingTokens(options);
		return tokens;
		
	}
	protected AccountingDocumentPostingTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public AccountingDocumentPostingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static AccountingDocumentPostingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected AccountingDocumentPostingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static AccountingDocumentPostingTokens start(){
		return new AccountingDocumentPostingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public AccountingDocumentPostingTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static AccountingDocumentPostingTokens allTokens(){
		
		return start()
			.withAccountingDocumentList();
	
	}
	public static AccountingDocumentPostingTokens withoutListsTokens(){
		
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
	
	public AccountingDocumentPostingTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";
	public String getAccountingDocumentList(){
		return ACCOUNTING_DOCUMENT_LIST;
	}
	public AccountingDocumentPostingTokens withAccountingDocumentList(){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST);
		return this;
	}
	public AccountingDocumentPostingTokens analyzeAccountingDocumentList(){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeAccountingDocumentListEnabled(){		
		
		if(checkOptions(this.options(), ACCOUNTING_DOCUMENT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public AccountingDocumentPostingTokens extractMoreFromAccountingDocumentList(String idsSeperatedWithComma){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int accountingDocumentListSortCounter = 0;
	public AccountingDocumentPostingTokens sortAccountingDocumentListWith(String field, String descOrAsc){		
		addSortMoreOptions(ACCOUNTING_DOCUMENT_LIST,accountingDocumentListSortCounter++, field, descOrAsc);
		return this;
	}
	private int accountingDocumentListSearchCounter = 0;
	public AccountingDocumentPostingTokens searchAccountingDocumentListWith(String field, String verb, String value){		
		
		withAccountingDocumentList();
		addSearchMoreOptions(ACCOUNTING_DOCUMENT_LIST,accountingDocumentListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public AccountingDocumentPostingTokens searchAllTextOfAccountingDocumentList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(ACCOUNTING_DOCUMENT_LIST,accountingDocumentListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public AccountingDocumentPostingTokens rowsPerPageOfAccountingDocumentList(int rowsPerPage){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public AccountingDocumentPostingTokens currentPageNumberOfAccountingDocumentList(int currentPageNumber){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public AccountingDocumentPostingTokens retainColumnsOfAccountingDocumentList(String[] columns){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public AccountingDocumentPostingTokens excludeColumnsOfAccountingDocumentList(String[] columns){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  AccountingDocumentPostingTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfAccountingDocumentList(verb, value);	
		return this;
	}
}

