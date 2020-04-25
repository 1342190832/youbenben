
package com.xingyou.xingyou.pagetype;
import com.xingyou.xingyou.AccessKey;

import com.xingyou.xingyou.BaseGridViewGenerator;

public class PageTypeGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for PageType", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(PageType.PAGE_LIST.equals(listName)){
			return new String[]{"id","page_title","link_to_url","page_type","mobile_app","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(PageType.PAGE_LIST.equals(listName)){
			return "page";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





