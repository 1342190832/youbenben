package com.youbenben.youbenben.iamservice;

import com.youbenben.youbenben.YoubenbenUserContext;

public interface IdentificationHandler {

	/** 完成认证 */
	LoginResult authenticate(YoubenbenUserContext userContext, LoginContext loginContext);
	/** 绑定用户 */
	void bindWithSecUser(YoubenbenUserContext userContext, LoginContext loginContext) throws Exception;
}
















