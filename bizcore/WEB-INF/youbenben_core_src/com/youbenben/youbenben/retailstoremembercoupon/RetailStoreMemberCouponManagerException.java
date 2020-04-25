
package com.youbenben.youbenben.retailstoremembercoupon;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreMemberCouponManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreMemberCouponManagerException(String string) {
		super(string);
	}
	public RetailStoreMemberCouponManagerException(Message message) {
		super(message);
	}
	public RetailStoreMemberCouponManagerException(List<Message> messageList) {
		super(messageList);
	}

}


