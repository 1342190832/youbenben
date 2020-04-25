
package com.youbenben.youbenben.consumerorderapproval;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ConsumerOrderApprovalManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderApprovalManagerException(String string) {
		super(string);
	}
	public ConsumerOrderApprovalManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderApprovalManagerException(List<Message> messageList) {
		super(messageList);
	}

}


