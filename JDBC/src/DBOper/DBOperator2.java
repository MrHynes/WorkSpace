package DBOper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBOperator2 {
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/test";
	public static final String DBUSER="root";
	public static final String DBPASS="chengqi";
	public static void main(String[] args) throws Exception {
		//加载驱动
		Class.forName(DBDRIVER);
		//连接数据库
		Connection connection=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		//3.
		String sql="update userinfo set id='1005' where id='1004'";
		Statement statement=connection.createStatement();
		statement.executeUpdate(sql);
		//4
		statement.close();
		connection.close();
		
	}
}
