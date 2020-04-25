
package com.youbenben.youbenben.retailstorecityservicecenter;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreCityServiceCenterManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreCityServiceCenterManagerException(String string) {
		super(string);
	}
	public RetailStoreCityServiceCenterManagerException(Message message) {
		super(message);
	}
	public RetailStoreCityServiceCenterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


