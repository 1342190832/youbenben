package com.youbenben.youbenben;

public class YoubenbenListOfViewScope extends BaseYoubenbenListOfViewScope {

	protected static YoubenbenListOfViewScope instance = new YoubenbenListOfViewScope();
	static {
		instance.initAllViewScope();
	}
	public static YoubenbenListOfViewScope getInstance() {
		return instance;
	}
}















