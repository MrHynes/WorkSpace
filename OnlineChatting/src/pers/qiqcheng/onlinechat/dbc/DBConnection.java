package pers.qiqcheng.onlinechat.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/chat";
	public static final String DBUSER="root";
	public static final String DBPASSWORD="chengqi";
	Connection conn=null;
	public Connection getConnection() throws Exception{
		Class.forName(DBDRIVER);
		this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		return this.conn;
	}
	public void close(){
		if(this.conn!=null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
