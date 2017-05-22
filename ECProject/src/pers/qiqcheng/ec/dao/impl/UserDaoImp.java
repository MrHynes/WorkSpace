package pers.qiqcheng.ec.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pers.qiqcheng.ec.dao.IUserDao;
/**
 * ���ݿ����ʵ����
 * @author Buer
 *
 */
public class UserDaoImp implements IUserDao {

	private Connection conn = null;
	private PreparedStatement pstm = null;

	public UserDaoImp(Connection conn) {
		this.conn = conn;
	}

	/**
	 * ��ѯ����
	 * 
	 * @param ģ����ѯ����
	 * @return ��ѯ�Ľ��
	 */
	@Override
	public ResultSet doSelect(String sql, Object[] params) {
		ResultSet rs = null;
		try {
			this.pstm = this.conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				this.pstm.setObject(i + 1, params[i]);
			}
			rs = this.pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/*
	 * �������ݿ� (non-Javadoc)
	 * 
	 * @see pers.qiqcheng.bookstore.dao.IBookDao#doUpdate(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public boolean doUpdate(String sql, Object[] params) {
		Boolean flag = false;
		try {
			this.pstm = this.conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				this.pstm.setObject(i + 1, params[i]);
			}
			if (this.pstm.executeUpdate() > 0) {
				flag = true;
			}
			this.pstm.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * ��������
	 */
	@Override
	public boolean doInsert(String sql, Object[] params) {
		Boolean flag = false;
		try {
			this.pstm = this.conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				this.pstm.setObject(i + 1, params[i]);
			}
			if (this.pstm.executeUpdate() > 0) {
				flag = true;
			}
			this.pstm.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * ɾ������
	 */
	@Override
	public boolean doDelete(String sql, Object[] params) {
		Boolean flag = false;
		try {
			this.pstm = this.conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				this.pstm.setObject(i + 1, params[i]);
			}
			if (this.pstm.executeUpdate() > 0) {
				flag = true;
			}
			this.pstm.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

}