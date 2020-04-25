
package com.youbenben.youbenben.retailstoremembergiftcardconsumerecord;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreMemberGiftCardConsumeRecordManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreMemberGiftCardConsumeRecordManagerException(String string) {
		super(string);
	}
	public RetailStoreMemberGiftCardConsumeRecordManagerException(Message message) {
		super(message);
	}
	public RetailStoreMemberGiftCardConsumeRecordManagerException(List<Message> messageList) {
		super(messageList);
	}

}


