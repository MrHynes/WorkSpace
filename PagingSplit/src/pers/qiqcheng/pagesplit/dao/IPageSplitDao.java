package pers.qiqcheng.pagesplit.dao;

import java.sql.ResultSet;

public interface IPageSplitDao {
	public ResultSet getAll(String sql,Object[] param);
}