package com.dbop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbop.dao.IDbopDao;
import com.dbop.dbc.DBConnection;
import com.dbop.vo.Info;

public class DbopDaoImp implements IDbopDao{
	private Connection conn=null;
	public DbopDaoImp(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doInsert(Info info) throws Exception {
		boolean flag=false;
		String sql="insert into info(id,name,age,score)values(?,?,?,?)";
		PreparedStatement pstm=this.conn.prepareStatement(sql);
		pstm.setString(1, info.getId());
		pstm.setString(2, info.getName());
		pstm.setInt(3, info.getAge());
		pstm.setFloat(4, info.getScore());
		if(pstm.executeUpdate()>0){
			flag=true;
		}
		pstm.close();
		return flag;
	}
	@Override
	public List<Info> doSelect() throws Exception {
		Info info=null;
		List<Info> list=new ArrayList<Info>();
		String sql="select * from info order by id";
		PreparedStatement pstm=this.conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			info=new Info();
			info.setId(rs.getString(1));
			info.setName(rs.getString(2));
			info.setAge(rs.getInt(3));
			info.setScore(rs.getFloat(4));
			list.add(info);
		}
		pstm.close();
		return list;
	}
	@Override
	public Info doSelectByKey(String key) throws Exception {
		Info info=null;
		String sql="select * from info where id=?";
		PreparedStatement pstm=this.conn.prepareStatement(sql);
		pstm.setString(1, key);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			info=new Info();
			info.setId(rs.getString(1));
			info.setName(rs.getString(2));
			info.setAge(rs.getInt(3));
			info.setScore(rs.getFloat(4));
		}
		pstm.close();
		return info;
	}
	@Override
	public boolean doDelete(String key) throws Exception {
		boolean flag=false;
		String sql="delete from info where id=?";
		PreparedStatement pstm=this.conn.prepareStatement(sql);
		pstm.setString(1, key);
		if(pstm.executeUpdate()>0){
			flag=true;
		}
		pstm.close();
		return flag;
	}
	@Override
	public boolean doUpdate(Info info) throws Exception {
		boolean flag=false;
		String sql="update info set name=?,age=?,score=? where id=?";
		PreparedStatement pstm=this.conn.prepareStatement(sql);
		pstm.setString(1, info.getName());
		pstm.setInt(2, info.getAge());
		pstm.setFloat(3, info.getScore());
		pstm.setString(4, info.getId());
		if(pstm.executeUpdate()>0){
			flag=true;
		}
		pstm.close();
		return flag;
	}


}
