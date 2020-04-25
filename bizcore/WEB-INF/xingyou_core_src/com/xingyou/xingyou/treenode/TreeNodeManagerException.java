
package com.xingyou.xingyou.treenode;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class TreeNodeManagerException extends XingyouException {
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



















