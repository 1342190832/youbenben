
package com.youbenben.youbenben.offeracceptance;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class OfferAcceptanceManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public OfferAcceptanceManagerException(String string) {
		super(string);
	}
	public OfferAcceptanceManagerException(Message message) {
		super(message);
	}
	public OfferAcceptanceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


