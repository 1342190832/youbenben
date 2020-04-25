package com.xingyou.xingyou;


import com.terapico.caf.viewpage.SerializeScope;

public class XingyouViewScope extends XingyouBaseViewScope{

	static {
		// 定制化本项目的序列化scope的代码放在这里
		System.out.println("**************************************************************\n定制序列化\n");
	}
	
	protected static XingyouViewScope instance = null;
	public static XingyouViewScope getInstance() {
		if (instance != null) {
			return instance;
		}
		synchronized (XingyouViewScope.class) {
			instance = new XingyouViewScope();
		}
		return instance;
	}
}

















