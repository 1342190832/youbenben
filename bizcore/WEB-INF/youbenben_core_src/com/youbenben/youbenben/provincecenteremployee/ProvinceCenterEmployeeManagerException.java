
package com.youbenben.youbenben.provincecenteremployee;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ProvinceCenterEmployeeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ProvinceCenterEmployeeManagerException(String string) {
		super(string);
	}
	public ProvinceCenterEmployeeManagerException(Message message) {
		super(message);
	}
	public ProvinceCenterEmployeeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


