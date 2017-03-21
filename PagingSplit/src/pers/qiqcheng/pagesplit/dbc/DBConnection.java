package pers.qiqcheng.pagesplit.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public final String DBURL="jdbc:mysql://localhost:3306/student";
	public final String USER="root";
	public final String PASSWORD="chengqi";
	private Connection conn=null;
	public Connection getConnection() throws Exception{
			Class.forName(DBDRIVER);
			this.conn=DriverManager.getConnection(DBURL,USER,PASSWORD);
			return conn;
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
