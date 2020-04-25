
package com.youbenben.youbenben.originalvoucher;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class OriginalVoucherManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public OriginalVoucherManagerException(String string) {
		super(string);
	}
	public OriginalVoucherManagerException(Message message) {
		super(message);
	}
	public OriginalVoucherManagerException(List<Message> messageList) {
		super(messageList);
	}

}


