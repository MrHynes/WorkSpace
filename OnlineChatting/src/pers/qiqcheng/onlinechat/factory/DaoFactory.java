package pers.qiqcheng.onlinechat.factory;

import pers.qiqcheng.onlinechat.dao.IChatDao;
import pers.qiqcheng.onlinechat.proxy.ChatDaoProxy;

public class DaoFactory {
	public static IChatDao getChatDaoInstance() throws Exception{
		return new ChatDaoProxy();
	}

}
