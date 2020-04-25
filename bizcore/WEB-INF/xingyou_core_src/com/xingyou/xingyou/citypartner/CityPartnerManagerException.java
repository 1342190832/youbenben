
package com.xingyou.xingyou.citypartner;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class CityPartnerManagerException extends XingyouException {
	private static final long serialVersionUID = 1L;
	public CityPartnerManagerException(String string) {
		super(string);
	}
	public CityPartnerManagerException(Message message) {
		super(message);
	}
	public CityPartnerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


