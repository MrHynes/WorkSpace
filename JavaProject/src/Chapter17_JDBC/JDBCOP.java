package Chapter17_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBCOP {
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/test";
	public static final String DBUSER="root";
	public static final String DBPASS="chengqi";
	public static void main(String[] args) throws Exception {
		String sql=" select id,name,age from userinfo where age=?";
		String sql2="insert into userinfo(id,name,age) values(?,?,?)";
		//加载驱动
		Class.forName(DBDRIVER);
		//连接数据库
		Connection con=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		//操作数据库
		PreparedStatement pst=null;
		pst=con.prepareStatement(sql);
		pst.setInt(1, 22);
		ResultSet rst=pst.executeQuery();
		while(rst.next()){
			int id=rst.getInt(1);
			String name=rst.getString(2);
			int age=rst.getInt(3);
			System.out.println("id="+id+",name="+name+",age="+age);
		}
		
		pst=con.prepareStatement(sql2);
		pst.setInt(1, 1007);
		pst.setString(2,"chengqq");
		pst.setInt(3, 22);
		pst.executeUpdate();
		
		//关闭数据库
		pst.close();
		con.close();
	}
	
}
