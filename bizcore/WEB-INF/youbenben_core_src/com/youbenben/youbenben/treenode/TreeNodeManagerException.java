
package com.youbenben.youbenben.treenode;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class TreeNodeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public TreeNodeManagerException(String string) {
		super(string);
	}
	public TreeNodeManagerException(Message message) {
		super(message);
	}
	public TreeNodeManagerException(List<Message> messageList) {
		super(messageList);
	}

}



















