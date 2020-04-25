
package com.xingyou.xingyou.mobileapp;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class MobileAppManagerException extends XingyouException {
	private static final long serialVersionUID = 1L;
	public MobileAppManagerException(String string) {
		super(string);
	}
	public MobileAppManagerException(Message message) {
		super(message);
	}
	public MobileAppManagerException(List<Message> messageList) {
		super(messageList);
	}

}


