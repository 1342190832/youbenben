
package com.xingyou.xingyou.keypairidentify;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class KeypairIdentifyManagerException extends XingyouException {
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


