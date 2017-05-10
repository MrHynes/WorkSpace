package pers.qiqcheng.ec.dao;

import java.sql.ResultSet;

/**
 * ���ݿ�����ӿ�
 * @author Buer
 *
 */
public interface IUserDao {
	public ResultSet doSelect(String sql,Object []params);
	public boolean doUpdate(String sql,Object []params);
	public boolean doInsert(String sql,Object [] params);
	public boolean doDelete(String sql,Object [] params);
}