
package com.youbenben.youbenben.originalvoucherauditing;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class OriginalVoucherAuditingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public OriginalVoucherAuditingManagerException(String string) {
		super(string);
	}
	public OriginalVoucherAuditingManagerException(Message message) {
		super(message);
	}
	public OriginalVoucherAuditingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


