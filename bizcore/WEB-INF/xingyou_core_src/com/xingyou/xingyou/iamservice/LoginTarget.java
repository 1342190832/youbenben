package com.xingyou.xingyou.iamservice;

import com.xingyou.xingyou.secuser.SecUser;
import com.xingyou.xingyou.userapp.UserApp;

public class LoginTarget {
	protected SecUser secUser;
	protected UserApp userApp;
	protected Object additionalInfo;
	public SecUser getSecUser() {
		return secUser;
	}
	public void setSecUser(SecUser secUser) {
		this.secUser = secUser;
	}
	public UserApp getUserApp() {
		return userApp;
	}
	public void setUserApp(UserApp userApp) {
		this.userApp = userApp;
	}
	public Object getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(Object additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	
}
















