
package com.youbenben.youbenben.potentialcustomercontact;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class PotentialCustomerContactManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public PotentialCustomerContactManagerException(String string) {
		super(string);
	}
	public PotentialCustomerContactManagerException(Message message) {
		super(message);
	}
	public PotentialCustomerContactManagerException(List<Message> messageList) {
		super(messageList);
	}

}


