
package com.youbenben.youbenben.payingoff;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class PayingOffManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public PayingOffManagerException(String string) {
		super(string);
	}
	public PayingOffManagerException(Message message) {
		super(message);
	}
	public PayingOffManagerException(List<Message> messageList) {
		super(messageList);
	}

}


