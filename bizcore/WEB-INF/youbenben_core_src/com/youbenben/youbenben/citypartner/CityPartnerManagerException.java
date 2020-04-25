
package com.youbenben.youbenben.citypartner;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class CityPartnerManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public CityPartnerManagerException(String string) {
		super(string);
	}
	public CityPartnerManagerException(Message message) {
		super(message);
	}
	public CityPartnerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


