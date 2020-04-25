
package com.xingyou.xingyou.franchisedoutletprovincecenter;
import com.xingyou.xingyou.AccessKey;

import com.xingyou.xingyou.BaseGridViewGenerator;

public class FranchisedOutletProvinceCenterGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for FranchisedOutletProvinceCenter", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(FranchisedOutletProvinceCenter.CATALOG_LIST.equals(listName)){
			return new String[]{"id","name","owner","sub_count","amount","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(FranchisedOutletProvinceCenter.CATALOG_LIST.equals(listName)){
			return "catalog";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





