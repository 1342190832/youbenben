
package com.youbenben.youbenben.publicholiday;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class PublicHolidayManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public PublicHolidayManagerException(String string) {
		super(string);
	}
	public PublicHolidayManagerException(Message message) {
		super(message);
	}
	public PublicHolidayManagerException(List<Message> messageList) {
		super(messageList);
	}

}


