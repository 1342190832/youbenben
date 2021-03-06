
package com.youbenben.youbenben.publickeytype;
import com.youbenben.youbenben.AccessKey;

import com.youbenben.youbenben.BaseGridViewGenerator;

public class PublicKeyTypeGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for PublicKeyType", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(PublicKeyType.KEYPAIR_IDENTIFY_LIST.equals(listName)){
			return new String[]{"id","public_key","key_type","sec_user","create_time","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(PublicKeyType.KEYPAIR_IDENTIFY_LIST.equals(listName)){
			return "keypair_identify";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}












