
package com.youbenben.youbenben.trainingcoursetype;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class TrainingCourseTypeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public TrainingCourseTypeManagerException(String string) {
		super(string);
	}
	public TrainingCourseTypeManagerException(Message message) {
		super(message);
	}
	public TrainingCourseTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


