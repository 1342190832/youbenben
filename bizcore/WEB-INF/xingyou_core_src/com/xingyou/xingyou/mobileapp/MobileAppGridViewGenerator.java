
package com.xingyou.xingyou.mobileapp;
import com.xingyou.xingyou.AccessKey;

import com.xingyou.xingyou.BaseGridViewGenerator;

public class MobileAppGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for MobileApp", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(MobileApp.PAGE_LIST.equals(listName)){
			return new String[]{"id","page_title","link_to_url","page_type","mobile_app","version"};
		}
		if(MobileApp.PAGE_TYPE_LIST.equals(listName)){
			return new String[]{"id","name","code","mobile_app","footer_tab","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(MobileApp.PAGE_LIST.equals(listName)){
			return "page";
		}
		if(MobileApp.PAGE_TYPE_LIST.equals(listName)){
			return "page_type";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





