
package com.doublechaintech.retailscm.accountingdocumentauditing;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class AccountingDocumentAuditingGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for AccountingDocumentAuditing", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(AccountingDocumentAuditing.ACCOUNTING_DOCUMENT_LIST.equals(listName)){
			return new String[]{"id","name","accounting_document_date","accounting_period","document_type","creation","confirmation","auditing","posting","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(AccountingDocumentAuditing.ACCOUNTING_DOCUMENT_LIST.equals(listName)){
			return "accounting_document";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





