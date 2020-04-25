
package com.youbenben.youbenben.smartpallet;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SmartPalletManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SmartPalletManagerException(String string) {
		super(string);
	}
	public SmartPalletManagerException(Message message) {
		super(message);
	}
	public SmartPalletManagerException(List<Message> messageList) {
		super(messageList);
	}

}


