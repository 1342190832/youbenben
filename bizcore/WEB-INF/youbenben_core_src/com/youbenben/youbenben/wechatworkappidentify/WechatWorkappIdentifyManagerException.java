
package com.youbenben.youbenben.wechatworkappidentify;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class WechatWorkappIdentifyManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public WechatWorkappIdentifyManagerException(String string) {
		super(string);
	}
	public WechatWorkappIdentifyManagerException(Message message) {
		super(message);
	}
	public WechatWorkappIdentifyManagerException(List<Message> messageList) {
		super(messageList);
	}

}


