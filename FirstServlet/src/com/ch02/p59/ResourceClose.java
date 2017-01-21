package com.ch02.p59;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResourceClose {
	public static void close(ResultSet rs,Statement stmt,Connection conn){
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void close(ResultSet rs,Statement stmt){
		close(rs, stmt,null);
	}
	public static void close(Statement stmt,Connection conn){
		close(null, stmt,conn);
	}
	public static void close(ResultSet rs,Connection conn){
		close(rs, null,conn);
	}
	public static void close(Connection conn){
		close(null, null,conn);
	}
	public static void close(Statement stmt){
		close(null, stmt, null);
	}
	public static void close(ResultSet rs){
		close(rs, null, null);
	}
	
}
