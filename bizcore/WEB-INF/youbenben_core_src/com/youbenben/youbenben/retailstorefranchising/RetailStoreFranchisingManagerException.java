
package com.youbenben.youbenben.retailstorefranchising;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreFranchisingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreFranchisingManagerException(String string) {
		super(string);
	}
	public RetailStoreFranchisingManagerException(Message message) {
		super(message);
	}
	public RetailStoreFranchisingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


