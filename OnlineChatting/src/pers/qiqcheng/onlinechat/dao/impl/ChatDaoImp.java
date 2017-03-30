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
	 * ��ѯ���ݿ��е���Ϣ��������Ϣ������resultset������
	 * �Ա���������磺getVoters(String sql, Object[] params)
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
	 * �������ݿ�
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
			 * �ϴ�"����ͶƱϵͳ"���������У��˴���������...��ifд����while
			 * ���£����ͶƱ��ʱ��Ӧ��ͣ��������
			 * ����Ҫע��
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
	 *��������
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