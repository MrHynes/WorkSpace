package DBOper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperator {
	//定义mysql的数据库驱动程序
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	//定义mysql数据库的连接地址
	public static final String DBURL="jdbc:mysql://localhost:3306/test";
	//数据库的链接名
	public static final String DBUSER="root";
	//数据库的连接密码
	public static final String DBPASS="chengqi";
	public static void main(String[] args) throws Exception {
		//加载驱动程序
		Class.forName(DBDRIVER);
		Connection conn=null;
		Statement stmt=null;
		String id="1004";
		String name="kankang";
		int age=20;
		//插入记录
		//String sql="insert into userinfo(id,name,age) values('"+id+"','"+name+"',"+age+")";
		//修改记录
		//String sql="update userinfo set id='1005',name='kk',age=19 where id='1004'";
		//删除记录
		String sql="delete from userinfo where id='1005'";
		//链接数据库
		conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}
}







