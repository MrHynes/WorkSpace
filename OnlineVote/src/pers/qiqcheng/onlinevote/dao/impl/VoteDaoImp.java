package pers.qiqcheng.onlinevote.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.qiqcheng.onlinevote.dao.IVoteDao;
import pers.qiqcheng.onlinevote.vo.Votes;

public class VoteDaoImp implements IVoteDao {

	private Connection conn=null;
	private PreparedStatement pstm=null;
	public VoteDaoImp(Connection conn) {
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
			 * ���������У��˴���������...��ifд����while
			 * ���£����ͶƱ��ʱ��Ӧ��ͣ��������
			 */
			if(pstm.executeUpdate()>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	/**
	 * ����Ϣ���浽list����
	 */
	@Override
	public List<Votes> getVoters(String sql, Object[] params) {
		List <Votes> list=new ArrayList<Votes>();
		Votes votes=null;
		ResultSet rs=this.doSelect(sql, params);
		try {
			while(rs.next()){
				votes=new Votes(rs.getString(1), rs.getString(2), rs.getInt(3));
				list.add(votes);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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