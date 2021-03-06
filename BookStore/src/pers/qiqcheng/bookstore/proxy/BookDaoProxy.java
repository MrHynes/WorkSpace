package pers.qiqcheng.bookstore.proxy;

import java.sql.Connection;
import java.sql.ResultSet;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import pers.qiqcheng.bookstore.dao.IBookDao;
import pers.qiqcheng.bookstore.dao.impl.BookDaoImp;
import pers.qiqcheng.bookstore.dbc.DBConnection;

public class BookDaoProxy implements IBookDao {

	private DBConnection dbc=null;
	private IBookDao dao=null;
	public  BookDaoProxy() throws Exception {
		this.dbc=new DBConnection();
		this.dao=new BookDaoImp(this.dbc.getConnection());
	}
	@Override
	public ResultSet doSelect(String sql, Object[] params) {
		return this.dao.doSelect(sql, params);
	}

	@Override
	public boolean doUpdate(String sql, Object[] params) {
		return this.dao.doUpdate(sql, params);
	}

	@Override
	public boolean doInsert(String sql, Object[] params) {
		return this.dao.doInsert(sql, params);
	}

	@Override
	public boolean doDelete(String sql, Object[] params) {
		return this.dao.doDelete(sql, params);
	}

}
