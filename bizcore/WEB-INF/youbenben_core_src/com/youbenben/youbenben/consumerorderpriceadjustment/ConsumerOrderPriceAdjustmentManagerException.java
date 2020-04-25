
package com.youbenben.youbenben.consumerorderpriceadjustment;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ConsumerOrderPriceAdjustmentManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderPriceAdjustmentManagerException(String string) {
		super(string);
	}
	public ConsumerOrderPriceAdjustmentManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderPriceAdjustmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


