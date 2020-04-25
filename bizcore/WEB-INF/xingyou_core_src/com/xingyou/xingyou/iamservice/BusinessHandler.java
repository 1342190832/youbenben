package com.xingyou.xingyou.iamservice;

import com.xingyou.xingyou.XingyouUserContext;

public interface BusinessHandler {

	void onAuthenticationFailed(XingyouUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

	void onAuthenticateNewUserLogged(XingyouUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

	void onAuthenticateUserLogged(XingyouUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

}
















