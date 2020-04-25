package com.youbenben.youbenben;


import com.terapico.caf.viewpage.SerializeScope;

public class YoubenbenViewScope extends YoubenbenBaseViewScope{

	static {
		// 定制化本项目的序列化scope的代码放在这里
		System.out.println("**************************************************************\n定制序列化\n");
	}
	
	protected static YoubenbenViewScope instance = null;
	public static YoubenbenViewScope getInstance() {
		if (instance != null) {
			return instance;
		}
		synchronized (YoubenbenViewScope.class) {
			instance = new YoubenbenViewScope();
		}
		return instance;
	}
}

















