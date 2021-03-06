package pers.qiqcheng.onlinechat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.qiqcheng.onlinechat.dao.IChatDao;
public class ChatDaoImp implements IChatDao {

	private Connection conn=null;
	private PreparedStatement pstm=null;
	public ChatDaoImp(Connection conn) {
		this.conn=conn;
	}
	/**
	 * 查询数据库中的信息，并将信息保存在resultset对象中
	 * 以便后续操作如：getVoters(String sql, Object[] params)
	 */
	@Override
	public ResultSet doSelect(String sql,Object[] params) {
		ResultSet rs=null;
		try {
			this.pstm=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pstm.setObject(i+1, params[i]);
			}
			rs=pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 更新数据库
	 */

	@Override
	public boolean doUpdate(String sql,Object[] params) {
		boolean flag=false;
		try {
			this.pstm=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pstm.setObject(i+1, params[i]);
			}
			/**
			 * 上次"在线投票系统"开发过程中，此处出过错误...把if写成了while
			 * 导致，点击投票的时候，应用停不下来。
			 * 这里要注意
			 */
			if(pstm.executeUpdate()>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	/*
	 *插入数据
	 * (non-Javadoc)
	 * @see pers.qiqcheng.onlinevote.dao.IVoteDao#doInsert(java.lang.String, java.lang.Object[])
	 */
	@Override
	public boolean doInsert(String sql, Object[] params) {
		boolean flag=false;
		try {
			this.pstm=this.conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				this.pstm.setObject(i+1, params[i]);
			}
			if(this.pstm.executeUpdate()>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
}
