package DBOperator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBSelectRecord1 {
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBUSER="root";
	public static final String DBPASSWORD="chengqi";
	public static final String DBURL="jdbc:mysql://localhost:3306/test";
	public static void main(String[] args) throws Exception {
		String sql="select * from userinfo where age=?";
		Class.forName(DBDRIVER);
		Connection conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		PreparedStatement pst=conn.prepareStatement(sql);
		int age=19;
		pst.setInt(1, age);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			System.out.println("id:"+rs.getString(1)+" name:"+rs.getString(2)+" age:"+rs.getInt(3));
		}
		pst.close();
		conn.close();
	}
}
