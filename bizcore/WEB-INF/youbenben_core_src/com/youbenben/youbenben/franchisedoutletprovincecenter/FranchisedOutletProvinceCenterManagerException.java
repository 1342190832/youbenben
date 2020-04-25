
package com.youbenben.youbenben.franchisedoutletprovincecenter;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class FranchisedOutletProvinceCenterManagerException extends YoubenbenException {
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


