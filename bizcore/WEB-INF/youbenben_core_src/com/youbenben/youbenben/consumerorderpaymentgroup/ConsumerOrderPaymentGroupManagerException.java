
package com.youbenben.youbenben.consumerorderpaymentgroup;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ConsumerOrderPaymentGroupManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderPaymentGroupManagerException(String string) {
		super(string);
	}
	public ConsumerOrderPaymentGroupManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderPaymentGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}


