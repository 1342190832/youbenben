
package com.youbenben.youbenben.potentialcustomer;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class PotentialCustomerManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public PotentialCustomerManagerException(String string) {
		super(string);
	}
	public PotentialCustomerManagerException(Message message) {
		super(message);
	}
	public PotentialCustomerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


