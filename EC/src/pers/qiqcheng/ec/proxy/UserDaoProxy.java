package pers.qiqcheng.ec.proxy;

import java.sql.Connection;
import java.sql.ResultSet;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import pers.qiqcheng.ec.dao.IUserDao;
import pers.qiqcheng.ec.dao.impl.UserDaoImp;
import pers.qiqcheng.ec.dbc.DBConnection;

public class UserDaoProxy implements IUserDao {

	private DBConnection dbc=null;
	private IUserDao dao=null;
	public  UserDaoProxy() throws Exception {
		this.dbc=new DBConnection();
		this.dao=new UserDaoImp(this.dbc.getConnection());
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
