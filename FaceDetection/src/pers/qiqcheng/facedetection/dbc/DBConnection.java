package pers.qiqcheng.facedetection.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/user";
	public static final String DBUSER="root";
	public static final String DBPASSWORD="chengqi";
	Connection conn=null;
	/**
	 * �������ݿ�
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection(){
		//�������ݿ���������
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������ݿ�
		try {
			this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.conn;
	}
	/**
	 * �ر����ݿ�
	 */
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