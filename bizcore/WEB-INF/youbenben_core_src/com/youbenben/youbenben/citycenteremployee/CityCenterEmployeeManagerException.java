
package com.youbenben.youbenben.citycenteremployee;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class CityCenterEmployeeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public CityCenterEmployeeManagerException(String string) {
		super(string);
	}
	public CityCenterEmployeeManagerException(Message message) {
		super(message);
	}
	public CityCenterEmployeeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


