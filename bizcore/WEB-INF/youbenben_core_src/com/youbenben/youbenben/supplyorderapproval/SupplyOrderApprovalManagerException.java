
package com.youbenben.youbenben.supplyorderapproval;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SupplyOrderApprovalManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderApprovalManagerException(String string) {
		super(string);
	}
	public SupplyOrderApprovalManagerException(Message message) {
		super(message);
	}
	public SupplyOrderApprovalManagerException(List<Message> messageList) {
		super(messageList);
	}

}


