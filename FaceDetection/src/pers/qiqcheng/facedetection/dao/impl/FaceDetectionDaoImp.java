package pers.qiqcheng.facedetection.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.qiqcheng.facedetection.dao.IFaceDetectionDao;
public class FaceDetectionDaoImp implements IFaceDetectionDao {

	private Connection conn=null;
	private PreparedStatement pstm=null;
	public FaceDetectionDaoImp(Connection conn) {
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
	@Override
	/**
	 * 插入数据
	 */
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
