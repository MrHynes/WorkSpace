package pers.qiqcheng.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pers.qiqcheng.bookstore.dao.IBookDao;
/**
 * 数据库操作实现类
 * @author Buer
 *
 */
public class BookDaoImp implements IBookDao {

	private Connection conn = null;
	private PreparedStatement pstm = null;

	public BookDaoImp(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 查询数据
	 * 
	 * @param 模糊查询参数
	 * @return 查询的结果
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
	 * 更新数据库 (non-Javadoc)
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
	 * 插入数据
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
	 * 删除数据
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
