package pers.qiqcheng.pagesplit.proxy;

import java.sql.Connection;
import java.sql.ResultSet;

import org.apache.taglibs.standard.lang.jstl.test.PageContextImpl;

import pers.qiqcheng.pagesplit.dao.IPageSplitDao;
import pers.qiqcheng.pagesplit.dao.impl.PageSplitDaoImp;
import pers.qiqcheng.pagesplit.dbc.DBConnection;

public class PageSplitDaoProxy implements IPageSplitDao{
	private DBConnection conn=null;
	private IPageSplitDao dao=null;
	public  PageSplitDaoProxy() throws Exception {
		this.conn=new DBConnection();
		this.dao=new PageSplitDaoImp(this.conn.getConnection());
	}

	@Override
	public ResultSet getAll(String sql, Object[] param) {
		ResultSet rs=this.dao.getAll(sql, param);	
		return rs;
	}
	

}
