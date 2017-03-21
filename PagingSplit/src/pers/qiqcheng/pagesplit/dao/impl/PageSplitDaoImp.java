package pers.qiqcheng.pagesplit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pers.qiqcheng.pagesplit.dao.IPageSplitDao;
import pers.qiqcheng.pagesplit.dbc.DBConnection;

public class PageSplitDaoImp implements IPageSplitDao {

	private Connection conn=null;
	private PreparedStatement pstm=null;
	public PageSplitDaoImp(Connection conn) {
		this.conn=conn;
	}
	@Override
	public ResultSet getAll(String sql, Object[] param) {
		ResultSet rs=null;
		try {
			this.pstm=this.conn.prepareStatement(sql);
			for(int i=0;i<param.length;i++){
				this.pstm.setObject(i+1, param[i]);
			}
			rs=pstm.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
