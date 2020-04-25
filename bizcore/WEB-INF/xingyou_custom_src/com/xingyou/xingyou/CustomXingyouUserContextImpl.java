package com.xingyou.xingyou;

public class CustomXingyouUserContextImpl extends XingyouBizUserContextImpl{
	protected BaseEntity currentUserInfo;

	public BaseEntity getCurrentUserInfo() {
		return currentUserInfo;
	}

	public void setCurrentUserInfo(BaseEntity currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}

}

