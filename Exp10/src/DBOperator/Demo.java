package DBOperator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo {
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBUSER="root";
	public static final String DBPASSWORD="chengqi";
	public static final String DBURL="jdbc:mysql://localhost:3306/test";
	public static void main(String[] args) throws Exception {
		String sql="select * from userinfo where age=?";
		Class.forName(DBDRIVER);
		Connection conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, 19);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			String id=rs.getString(1);
			String name=rs.getString(2);
			int age=rs.getInt(3);
			System.out.println("id:"+id+" name:"+name+" age:"+age);
		}
		rs.close();
		pst.close();
		conn.close();
	}
}
