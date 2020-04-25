
package com.youbenben.youbenben.retailstoreorderpaymentgroup;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreOrderPaymentGroupManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderPaymentGroupManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderPaymentGroupManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderPaymentGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}


