
package com.youbenben.youbenben.citycenterdepartment;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class CityCenterDepartmentManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public CityCenterDepartmentManagerException(String string) {
		super(string);
	}
	public CityCenterDepartmentManagerException(Message message) {
		super(message);
	}
	public CityCenterDepartmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


