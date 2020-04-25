
package com.youbenben.youbenben.originalvouchercreation;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class OriginalVoucherCreationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public OriginalVoucherCreationManagerException(String string) {
		super(string);
	}
	public OriginalVoucherCreationManagerException(Message message) {
		super(message);
	}
	public OriginalVoucherCreationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


