package pers.qiqcheng.bookstore.dao;

import java.sql.ResultSet;

/**
 * 数据库操作接口
 * @author Buer
 *
 */
public interface IBookDao {
	public ResultSet doSelect(String sql,Object []params);
	public boolean doUpdate(String sql,Object []params);
	public boolean doInsert(String sql,Object [] params);
	public boolean doDelete(String sql,Object [] params);
}
