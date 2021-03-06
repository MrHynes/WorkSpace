package com.ch07.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMySQL {
	private String driver;
	private String url;
	private String username;
	private String password;

	public DBMySQL() {
		this.driver = "org.gjt.mm.mysql.Driver";
		this.url = "jdbc:mysql://localhost:3306/xe";
		this.username = "root";
		this.password = "chengqi";
	}

	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}

	public void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(ResultSet rs, Statement stmt){
		close(rs, stmt, null);
	}
	public void close(ResultSet rs, Connection conn){
		close(rs,null, conn);
	}
	public void close(Statement stmt, Connection conn){
		close(null, stmt, conn);
	}
	public void close(ResultSet rs){
		close(rs, null, null);
	}
	public void close(Statement stmt){
		close(null, stmt, null);
	}
	public void close(Connection conn){
		close(null, null, conn);
	}

	public User login(String name,String password){
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		User user=null;
		String sql="select * from usertbl where name=? and password=?";
		try {
			conn=getConnection();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, password);
			rs=pstm.executeQuery();
			if(rs.next()){
				user=new User();
				user.setUserName(rs.getString(1));
				user.setUserPassword(rs.getString(2));
				user.setuserSex(rs.getString(3));
				user.setUserProvince(rs.getString(4));
				user.setUserIntroduce(rs.getString(5));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs, pstm, conn);
		}
		return user;
	}
	
}
