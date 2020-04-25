package com.xingyou.xingyou;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.terapico.caf.form.ImageInfo;
import com.terapico.utils.DebugUtil;

public class BaseXingyouFormProcessor extends BaseFormProcessor{
	protected XingyouUserContext userContext;
	
	public XingyouUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(XingyouUserContext userContext) {
		this.userContext = userContext;
	}
	protected void addMessageToException(XingyouException e, String msg) {
		Message message = new Message();
		message.setBody(msg);
		e.addErrorMessage(message);
	}
	public Map<String, Object> mapToUiForm(XingyouUserContext userContext) {
		return null; 
	}
}









































