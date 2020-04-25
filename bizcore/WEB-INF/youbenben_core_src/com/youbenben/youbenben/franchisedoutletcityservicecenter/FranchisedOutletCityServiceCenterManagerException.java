
package com.youbenben.youbenben.franchisedoutletcityservicecenter;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class FranchisedOutletCityServiceCenterManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public FranchisedOutletCityServiceCenterManagerException(String string) {
		super(string);
	}
	public FranchisedOutletCityServiceCenterManagerException(Message message) {
		super(message);
	}
	public FranchisedOutletCityServiceCenterManagerException(List<Message> messageList) {
		super(messageList);
	}

}


