package pers.qiqcheng.onlinevote.dao;

import java.sql.ResultSet;
import java.util.List;

import pers.qiqcheng.onlinevote.vo.Votes;

public interface IVoteDao {
	public ResultSet doSelect(String sql,Object[] params);
	public boolean doUpdate(String sql,Object[] params);
	public boolean doInsert(String sql,Object[] params);
	public List<Votes> getVoters(String sql,Object[] params);
}
