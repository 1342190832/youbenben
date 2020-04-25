package com.xingyou.xingyou.iamservice;

import com.xingyou.xingyou.XingyouUserContext;

public interface IdentificationHandler {

	/** 完成认证 */
	LoginResult authenticate(XingyouUserContext userContext, LoginContext loginContext);
	/** 绑定用户 */
	void bindWithSecUser(XingyouUserContext userContext, LoginContext loginContext) throws Exception;
}
















