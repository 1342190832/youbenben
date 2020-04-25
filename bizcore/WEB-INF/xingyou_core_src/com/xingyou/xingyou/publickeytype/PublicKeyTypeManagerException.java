
package com.xingyou.xingyou.publickeytype;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class PublicKeyTypeManagerException extends XingyouException {
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


