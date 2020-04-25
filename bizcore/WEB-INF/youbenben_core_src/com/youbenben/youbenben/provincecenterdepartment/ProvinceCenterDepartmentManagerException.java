
package com.youbenben.youbenben.provincecenterdepartment;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ProvinceCenterDepartmentManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ProvinceCenterDepartmentManagerException(String string) {
		super(string);
	}
	public ProvinceCenterDepartmentManagerException(Message message) {
		super(message);
	}
	public ProvinceCenterDepartmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


