package pers.qiqcheng.onlinechat.dao;

import java.sql.ResultSet;
import java.util.List;

public interface IChatDao {
	public ResultSet doSelect(String sql,Object[] params);
	public boolean doUpdate(String sql,Object[] params);
	public boolean doInsert(String sql,Object[] params);
}
