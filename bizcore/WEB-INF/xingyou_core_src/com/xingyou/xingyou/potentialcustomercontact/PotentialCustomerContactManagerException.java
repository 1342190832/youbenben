
package com.xingyou.xingyou.potentialcustomercontact;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class PotentialCustomerContactManagerException extends XingyouException {
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


