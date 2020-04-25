
package com.xingyou.xingyou.cityevent;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class CityEventManagerException extends XingyouException {
	private static final long serialVersionUID = 1L;
	public CityEventManagerException(String string) {
		super(string);
	}
	public CityEventManagerException(Message message) {
		super(message);
	}
	public CityEventManagerException(List<Message> messageList) {
		super(messageList);
	}

}


