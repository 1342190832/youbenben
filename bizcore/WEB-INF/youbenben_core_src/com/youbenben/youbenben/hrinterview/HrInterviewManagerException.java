
package com.youbenben.youbenben.hrinterview;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class HrInterviewManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public HrInterviewManagerException(String string) {
		super(string);
	}
	public HrInterviewManagerException(Message message) {
		super(message);
	}
	public HrInterviewManagerException(List<Message> messageList) {
		super(messageList);
	}

}


