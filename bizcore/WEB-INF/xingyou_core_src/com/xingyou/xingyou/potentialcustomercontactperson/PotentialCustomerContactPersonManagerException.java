
package com.xingyou.xingyou.potentialcustomercontactperson;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class PotentialCustomerContactPersonManagerException extends XingyouException {
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


