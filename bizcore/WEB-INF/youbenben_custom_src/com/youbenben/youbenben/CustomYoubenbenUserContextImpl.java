package com.youbenben.youbenben;

public class CustomYoubenbenUserContextImpl extends YoubenbenBizUserContextImpl{
	protected BaseEntity currentUserInfo;

	public BaseEntity getCurrentUserInfo() {
		return currentUserInfo;
	}

	public void setCurrentUserInfo(BaseEntity currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}

}

