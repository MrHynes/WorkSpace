package pers.qiqcheng.bookstore.factory;

import pers.qiqcheng.bookstore.dao.IBookDao;
import pers.qiqcheng.bookstore.proxy.BookDaoProxy;
/**
 * ¹¤³§
 * @author Buer
 *
 */
public class DaoFactory {
	public static IBookDao getBookDaoInstances() throws Exception{
		return new BookDaoProxy();
	}

}
