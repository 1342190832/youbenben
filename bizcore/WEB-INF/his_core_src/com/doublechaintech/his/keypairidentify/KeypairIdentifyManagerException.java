
package com.doublechaintech.his.keypairidentify;
//import com.doublechaintech.his.EntityNotFoundException;
import com.doublechaintech.his.HisException;
import com.doublechaintech.his.Message;
import java.util.List;

public class KeypairIdentifyManagerException extends HisException {
	private static final long serialVersionUID = 1L;
	public KeypairIdentifyManagerException(String string) {
		super(string);
	}
	public KeypairIdentifyManagerException(Message message) {
		super(message);
	}
	public KeypairIdentifyManagerException(List<Message> messageList) {
		super(messageList);
	}

}


