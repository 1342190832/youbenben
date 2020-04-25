
package com.youbenben.youbenben.publickeytype;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class PublicKeyTypeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public PublicKeyTypeManagerException(String string) {
		super(string);
	}
	public PublicKeyTypeManagerException(Message message) {
		super(message);
	}
	public PublicKeyTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


