package pers.qiqcheng.onlinevote.proxy;

import java.sql.ResultSet;
import java.util.List;

import pers.qiqcheng.onlinevote.dao.IVoteDao;
import pers.qiqcheng.onlinevote.dao.impl.VoteDaoImp;
import pers.qiqcheng.onlinevote.dbc.DBConnection;
import pers.qiqcheng.onlinevote.vo.Votes;

public class VoteDaoProxy implements IVoteDao{
	private DBConnection conn=null;
	private IVoteDao dao=null;
	public VoteDaoProxy() throws Exception {
		this.conn=new DBConnection();
		this.dao=new VoteDaoImp(this.conn.getConnection());
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

	@Override
	public List<Votes> getVoters(String sql, Object[] params) {
		List<Votes> list=this.dao.getVoters(sql, params);
		this.conn.close();
		return list;
	}

}
