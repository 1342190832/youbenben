
package com.xingyou.xingyou.citycenterdepartment;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class CityCenterDepartmentManagerException extends XingyouException {
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


