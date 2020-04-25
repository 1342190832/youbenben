
package com.xingyou.xingyou.franchisedoutletprovincecenter;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class FranchisedOutletProvinceCenterManagerException extends XingyouException {
	private static final long serialVersionUID = 1L;
	public FranchisedOutletProvinceCenterManagerException(String string) {
		super(string);
	}
	public FranchisedOutletProvinceCenterManagerException(Message message) {
		super(message);
	}
	public FranchisedOutletProvinceCenterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


