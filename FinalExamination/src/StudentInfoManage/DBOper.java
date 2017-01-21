package StudentInfoManage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOper {
	//定义mysql的数据库驱动程序
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	//定义mysql数据库的连接地址
	public static final String DBURL="jdbc:mysql://localhost:3306/stuinfo";
	//数据库的链接名
	public static final String DBUSER="root";
	//数据库的连接密码
	public static final String DBPASS="chengqi";
	public Connection getConnection() throws Exception{	
			Class.forName(DBDRIVER);
			Connection connection=DriverManager.getConnection(DBURL,DBUSER,DBPASS);//连接数据库
			return connection;
	}
}
