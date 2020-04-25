
package com.xingyou.xingyou.franchisedoutletcitycenter;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class FranchisedOutletCityCenterManagerException extends XingyouException {
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


