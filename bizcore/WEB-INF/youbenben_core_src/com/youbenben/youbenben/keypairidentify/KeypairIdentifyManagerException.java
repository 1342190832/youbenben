
package com.youbenben.youbenben.keypairidentify;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class KeypairIdentifyManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public KeypairIdentifyManagerException(String string) {
		super(string);
	}
	public KeypairIdentifyManagerException(Message message) {
		super(message);
	}
	public KeypairIdentifyManagerException(List<Message> messageList) {
		super(messageList);
	}

}


