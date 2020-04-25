
package com.xingyou.xingyou.citycenteremployee;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class CityCenterEmployeeManagerException extends XingyouException {
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


