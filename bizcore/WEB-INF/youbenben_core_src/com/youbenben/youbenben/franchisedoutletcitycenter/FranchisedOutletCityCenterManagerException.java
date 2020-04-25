
package com.youbenben.youbenben.franchisedoutletcitycenter;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class FranchisedOutletCityCenterManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public FranchisedOutletCityCenterManagerException(String string) {
		super(string);
	}
	public FranchisedOutletCityCenterManagerException(Message message) {
		super(message);
	}
	public FranchisedOutletCityCenterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


