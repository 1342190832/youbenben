
package com.youbenben.youbenben.memberrewardpoint;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class MemberRewardPointManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public MemberRewardPointManagerException(String string) {
		super(string);
	}
	public MemberRewardPointManagerException(Message message) {
		super(message);
	}
	public MemberRewardPointManagerException(List<Message> messageList) {
		super(messageList);
	}

}


