
package com.youbenben.youbenben.retailstoremembergiftcard;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreMemberGiftCardManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreMemberGiftCardManagerException(String string) {
		super(string);
	}
	public RetailStoreMemberGiftCardManagerException(Message message) {
		super(message);
	}
	public RetailStoreMemberGiftCardManagerException(List<Message> messageList) {
		super(messageList);
	}

}


