
package com.youbenben.youbenben.memberwishlistproduct;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class MemberWishlistProductManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public MemberWishlistProductManagerException(String string) {
		super(string);
	}
	public MemberWishlistProductManagerException(Message message) {
		super(message);
	}
	public MemberWishlistProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


