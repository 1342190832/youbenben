
package com.youbenben.youbenben.stockcountissuetrack;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class StockCountIssueTrackManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public StockCountIssueTrackManagerException(String string) {
		super(string);
	}
	public StockCountIssueTrackManagerException(Message message) {
		super(message);
	}
	public StockCountIssueTrackManagerException(List<Message> messageList) {
		super(messageList);
	}

}


