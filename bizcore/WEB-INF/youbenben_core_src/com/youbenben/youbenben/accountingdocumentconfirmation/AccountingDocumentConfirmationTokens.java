
package com.youbenben.youbenben.accountingdocumentconfirmation;
import com.youbenben.youbenben.CommonTokens;
import java.util.Map;
public class AccountingDocumentConfirmationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="accountingDocumentConfirmation";
	
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
	protected AccountingDocumentConfirmationTokens(){
		//ensure not initialized outside the class
	}
	public  static  AccountingDocumentConfirmationTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		AccountingDocumentConfirmationTokens tokens = new AccountingDocumentConfirmationTokens(options);
		return tokens;
		
	}
	protected AccountingDocumentConfirmationTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public AccountingDocumentConfirmationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static AccountingDocumentConfirmationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected AccountingDocumentConfirmationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static AccountingDocumentConfirmationTokens start(){
		return new AccountingDocumentConfirmationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public AccountingDocumentConfirmationTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static AccountingDocumentConfirmationTokens allTokens(){
		
		return start()
			.withAccountingDocumentList();
	
	}
	public static AccountingDocumentConfirmationTokens withoutListsTokens(){
		
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
	
	public AccountingDocumentConfirmationTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";
	public String getAccountingDocumentList(){
		return ACCOUNTING_DOCUMENT_LIST;
	}
	public AccountingDocumentConfirmationTokens withAccountingDocumentList(){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST);
		return this;
	}
	public AccountingDocumentConfirmationTokens analyzeAccountingDocumentList(){		
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
	public AccountingDocumentConfirmationTokens extractMoreFromAccountingDocumentList(String idsSeperatedWithComma){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int accountingDocumentListSortCounter = 0;
	public AccountingDocumentConfirmationTokens sortAccountingDocumentListWith(String field, String descOrAsc){		
		addSortMoreOptions(ACCOUNTING_DOCUMENT_LIST,accountingDocumentListSortCounter++, field, descOrAsc);
		return this;
	}
	private int accountingDocumentListSearchCounter = 0;
	public AccountingDocumentConfirmationTokens searchAccountingDocumentListWith(String field, String verb, String value){		
		
		withAccountingDocumentList();
		addSearchMoreOptions(ACCOUNTING_DOCUMENT_LIST,accountingDocumentListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public AccountingDocumentConfirmationTokens searchAllTextOfAccountingDocumentList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(ACCOUNTING_DOCUMENT_LIST,accountingDocumentListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public AccountingDocumentConfirmationTokens rowsPerPageOfAccountingDocumentList(int rowsPerPage){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public AccountingDocumentConfirmationTokens currentPageNumberOfAccountingDocumentList(int currentPageNumber){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public AccountingDocumentConfirmationTokens retainColumnsOfAccountingDocumentList(String[] columns){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public AccountingDocumentConfirmationTokens excludeColumnsOfAccountingDocumentList(String[] columns){		
		addSimpleOptions(ACCOUNTING_DOCUMENT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  AccountingDocumentConfirmationTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfAccountingDocumentList(verb, value);	
		return this;
	}
}

