
package com.xingyou.xingyou.secuser;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class SecUserManagerException extends XingyouException {
	private static final long serialVersionUID = 1L;
	public SecUserManagerException(String string) {
		super(string);
	}
	public SecUserManagerException(Message message) {
		super(message);
	}
	public SecUserManagerException(List<Message> messageList) {
		super(messageList);
	}

}


