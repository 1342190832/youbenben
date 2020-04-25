
package com.youbenben.youbenben.potentialcustomercontactperson;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class PotentialCustomerContactPersonManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public PotentialCustomerContactPersonManagerException(String string) {
		super(string);
	}
	public PotentialCustomerContactPersonManagerException(Message message) {
		super(message);
	}
	public PotentialCustomerContactPersonManagerException(List<Message> messageList) {
		super(messageList);
	}

}


