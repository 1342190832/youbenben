
package com.youbenben.youbenben.memberrewardpointredemption;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class MemberRewardPointRedemptionManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public MemberRewardPointRedemptionManagerException(String string) {
		super(string);
	}
	public MemberRewardPointRedemptionManagerException(Message message) {
		super(message);
	}
	public MemberRewardPointRedemptionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


