
package com.youbenben.youbenben.retailstoreprovincecenter;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreProvinceCenterManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreProvinceCenterManagerException(String string) {
		super(string);
	}
	public RetailStoreProvinceCenterManagerException(Message message) {
		super(message);
	}
	public RetailStoreProvinceCenterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


