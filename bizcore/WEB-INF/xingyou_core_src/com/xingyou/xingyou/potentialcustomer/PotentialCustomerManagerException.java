
package com.xingyou.xingyou.potentialcustomer;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class PotentialCustomerManagerException extends XingyouException {
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


