
package com.youbenben.youbenben.memberwishlist;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class MemberWishlistManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public MemberWishlistManagerException(String string) {
		super(string);
	}
	public MemberWishlistManagerException(Message message) {
		super(message);
	}
	public MemberWishlistManagerException(List<Message> messageList) {
		super(messageList);
	}

}


