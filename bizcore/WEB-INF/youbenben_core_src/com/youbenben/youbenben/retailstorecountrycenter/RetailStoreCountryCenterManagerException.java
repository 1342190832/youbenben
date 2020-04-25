
package com.youbenben.youbenben.retailstorecountrycenter;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreCountryCenterManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreCountryCenterManagerException(String string) {
		super(string);
	}
	public RetailStoreCountryCenterManagerException(Message message) {
		super(message);
	}
	public RetailStoreCountryCenterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


