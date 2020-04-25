
package com.youbenben.youbenben.damagespace;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class DamageSpaceManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public DamageSpaceManagerException(String string) {
		super(string);
	}
	public DamageSpaceManagerException(Message message) {
		super(message);
	}
	public DamageSpaceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


