package com.dao.factory;

import com.dao.dao.IEmpDao;
import com.dao.dao.proxy.EmpDAOProxy;

public class DAOFactory {
	public static IEmpDao getIEmpDAOInstance() throws Exception{
		return new EmpDAOProxy();
	}

}
