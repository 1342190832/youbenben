
package com.youbenben.youbenben.supplyorderpaymentgroup;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SupplyOrderPaymentGroupManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderPaymentGroupManagerException(String string) {
		super(string);
	}
	public SupplyOrderPaymentGroupManagerException(Message message) {
		super(message);
	}
	public SupplyOrderPaymentGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}


