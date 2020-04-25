
package com.youbenben.youbenben.accountingdocumenttype;
import com.youbenben.youbenben.AccessKey;

import com.youbenben.youbenben.BaseGridViewGenerator;

public class AccountingDocumentTypeGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for AccountingDocumentType", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(AccountingDocumentType.ACCOUNTING_DOCUMENT_LIST.equals(listName)){
			return new String[]{"id","name","accounting_document_date","accounting_period","document_type","creation","confirmation","auditing","posting","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(AccountingDocumentType.ACCOUNTING_DOCUMENT_LIST.equals(listName)){
			return "accounting_document";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





