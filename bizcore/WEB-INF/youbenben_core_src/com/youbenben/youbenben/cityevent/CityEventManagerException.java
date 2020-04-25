
package com.youbenben.youbenben.cityevent;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class CityEventManagerException extends YoubenbenException {
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


