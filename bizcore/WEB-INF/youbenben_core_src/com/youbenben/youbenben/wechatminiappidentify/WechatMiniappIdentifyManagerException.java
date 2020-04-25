
package com.youbenben.youbenben.wechatminiappidentify;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class WechatMiniappIdentifyManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public WechatMiniappIdentifyManagerException(String string) {
		super(string);
	}
	public WechatMiniappIdentifyManagerException(Message message) {
		super(message);
	}
	public WechatMiniappIdentifyManagerException(List<Message> messageList) {
		super(messageList);
	}

}


