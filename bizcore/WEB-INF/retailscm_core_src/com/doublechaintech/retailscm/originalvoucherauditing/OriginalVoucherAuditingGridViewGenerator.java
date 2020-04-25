
package com.doublechaintech.retailscm.originalvoucherauditing;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class OriginalVoucherAuditingGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for OriginalVoucherAuditing", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(OriginalVoucherAuditing.ORIGINAL_VOUCHER_LIST.equals(listName)){
			return new String[]{"id","title","made_by","received_by","voucher_type","voucher_image","belongs_to","creation","confirmation","auditing","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(OriginalVoucherAuditing.ORIGINAL_VOUCHER_LIST.equals(listName)){
			return "original_voucher";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





