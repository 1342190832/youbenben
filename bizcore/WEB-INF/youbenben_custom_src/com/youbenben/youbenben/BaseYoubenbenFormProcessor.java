package com.youbenben.youbenben;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.terapico.caf.form.ImageInfo;
import com.terapico.utils.DebugUtil;

public class BaseYoubenbenFormProcessor extends BaseFormProcessor{
	protected YoubenbenUserContext userContext;
	
	public YoubenbenUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(YoubenbenUserContext userContext) {
		this.userContext = userContext;
	}
	protected void addMessageToException(YoubenbenException e, String msg) {
		Message message = new Message();
		message.setBody(msg);
		e.addErrorMessage(message);
	}
	public Map<String, Object> mapToUiForm(YoubenbenUserContext userContext) {
		return null; 
	}
}









































