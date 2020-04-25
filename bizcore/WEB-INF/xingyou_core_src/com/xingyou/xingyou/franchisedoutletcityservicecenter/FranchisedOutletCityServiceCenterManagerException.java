
package com.xingyou.xingyou.franchisedoutletcityservicecenter;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class FranchisedOutletCityServiceCenterManagerException extends XingyouException {
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


