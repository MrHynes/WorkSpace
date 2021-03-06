package com.dbop.dao.proxy;

import java.util.List;

import com.dbop.dao.IDbopDao;
import com.dbop.dao.impl.DbopDaoImp;
import com.dbop.dbc.DBConnection;
import com.dbop.vo.Info;

public class DbopDaoProxy implements IDbopDao {

	private DBConnection conn=null;
	private IDbopDao dao=null;
	public DbopDaoProxy() throws Exception {
		this.conn=new DBConnection();
		this.dao=new DbopDaoImp(this.conn.getConnection());
	}
	@Override
	public boolean doInsert(Info info) throws Exception {
		boolean flag=false;
		if(this.dao.doSelectByKey(info.getId())==null){
			flag=this.dao.doInsert(info);
		}
		this.conn.close();
		return flag;
	}

	@Override
	public List<Info> doSelect() throws Exception {
		List<Info> list=null;
		list=this.dao.doSelect();
		this.conn.close();
		return list;
	}
	@Override
	public Info doSelectByKey(String key) throws Exception {
		Info info=this.dao.doSelectByKey(key);
		this.conn.close();
		return info;
	}
	@Override
	public boolean doDelete(String key) throws Exception {
		boolean flag=false;
		flag=this.dao.doDelete(key);
		return flag;
	}
	@Override
	public boolean doUpdate(Info info) throws Exception {
		boolean flag=false;
		flag=this.dao.doUpdate(info);
		return flag;
	}

}
