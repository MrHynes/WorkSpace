package pers.qiqcheng.pagesplit.factory;

import pers.qiqcheng.pagesplit.dao.IPageSplitDao;
import pers.qiqcheng.pagesplit.proxy.PageSplitDaoProxy;

public class DaoFactory {
	public static IPageSplitDao getPageSplitDaoInstance() throws Exception{
		return new PageSplitDaoProxy();
	}

}
