package pers.qiqcheng.ec.factory;

import pers.qiqcheng.ec.dao.IUserDao;
import pers.qiqcheng.ec.proxy.UserDaoProxy;
/**
 * ����
 * @author Buer
 *
 */
public class DaoFactory {
	public static IUserDao getUserDaoInstances() throws Exception{
		return new UserDaoProxy();
	}

}