package com.dbop.dao.factory;

import com.dbop.dao.IDbopDao;
import com.dbop.dao.proxy.DbopDaoProxy;

public class DaoFactory {
	public static IDbopDao getIDbopDaoInstance() throws Exception{
		return new DbopDaoProxy();
	}

}
