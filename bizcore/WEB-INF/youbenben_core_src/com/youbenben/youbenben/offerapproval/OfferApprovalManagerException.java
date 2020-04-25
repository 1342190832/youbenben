
package com.youbenben.youbenben.offerapproval;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class OfferApprovalManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public OfferApprovalManagerException(String string) {
		super(string);
	}
	public OfferApprovalManagerException(Message message) {
		super(message);
	}
	public OfferApprovalManagerException(List<Message> messageList) {
		super(messageList);
	}

}


