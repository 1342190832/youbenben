
package com.youbenben.youbenben.retailstoremember;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreMemberManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreMemberManagerException(String string) {
		super(string);
	}
	public RetailStoreMemberManagerException(Message message) {
		super(message);
	}
	public RetailStoreMemberManagerException(List<Message> messageList) {
		super(messageList);
	}

}


