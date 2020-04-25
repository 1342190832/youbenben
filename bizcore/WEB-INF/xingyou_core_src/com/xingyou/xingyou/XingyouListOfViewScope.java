package com.xingyou.xingyou;

public class XingyouListOfViewScope extends BaseXingyouListOfViewScope {

	protected static XingyouListOfViewScope instance = new XingyouListOfViewScope();
	static {
		instance.initAllViewScope();
	}
	public static XingyouListOfViewScope getInstance() {
		return instance;
	}
}















