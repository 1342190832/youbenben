
package com.youbenben.youbenben.originalvoucherconfirmation;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class OriginalVoucherConfirmationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public OriginalVoucherConfirmationManagerException(String string) {
		super(string);
	}
	public OriginalVoucherConfirmationManagerException(Message message) {
		super(message);
	}
	public OriginalVoucherConfirmationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


