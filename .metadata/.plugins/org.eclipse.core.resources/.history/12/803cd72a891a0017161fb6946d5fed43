package pers.qiqcheng.onlinechat.proxy;

import java.sql.ResultSet;
import java.util.List;

import pers.qiqcheng.onlinechat.dao.IChatDao;
import pers.qiqcheng.onlinechat.dao.impl.ChatDaoImp;
import pers.qiqcheng.onlinechat.dbc.DBConnection;

public class ChatDaoProxy implements IChatDao{
	private DBConnection conn=null;
	private IChatDao dao=null;
	public ChatDaoProxy() throws Exception {
		this.conn=new DBConnection();
		this.dao=new ChatDaoImp(this.conn.getConnection());
	}

	@Override
	public ResultSet doSelect(String sql, Object[] params) {
		ResultSet rs=null;
		rs=this.dao.doSelect(sql, params);
		return rs;
	}

	@Override
	public boolean doUpdate(String sql, Object[] params) {
		boolean flag=false;
		flag=this.dao.doUpdate(sql, params);
		//this.conn.close();
		return flag;
	}

	@Override
	public boolean doInsert(String sql, Object[] params) {
		boolean flag=false;
		flag=this.dao.doInsert(sql, params);
		this.conn.close();
		return flag;
	}


}
