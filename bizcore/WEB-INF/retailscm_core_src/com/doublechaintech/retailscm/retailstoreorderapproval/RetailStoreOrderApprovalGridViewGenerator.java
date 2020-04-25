
package com.doublechaintech.retailscm.retailstoreorderapproval;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class RetailStoreOrderApprovalGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for RetailStoreOrderApproval", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(RetailStoreOrderApproval.RETAIL_STORE_ORDER_LIST.equals(listName)){
			return new String[]{"id","buyer","seller","title","total_amount","confirmation","approval","processing","picking","shipment","delivery","last_update_time","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(RetailStoreOrderApproval.RETAIL_STORE_ORDER_LIST.equals(listName)){
			return "retail_store_order";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





