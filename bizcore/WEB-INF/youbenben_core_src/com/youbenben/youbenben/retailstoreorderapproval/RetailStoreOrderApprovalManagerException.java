
package com.youbenben.youbenben.retailstoreorderapproval;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreOrderApprovalManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderApprovalManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderApprovalManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderApprovalManagerException(List<Message> messageList) {
		super(messageList);
	}

}


