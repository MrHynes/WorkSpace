package DBOperator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBInsertRecord {
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBUSER="root";
	public static final String DBPASSWORD="chengqi";
	public static final String DBURL="jdbc:mysql://localhost:3306/test";
	public static void main(String[] args) throws Exception {
		String sql="insert into userinfo values(?,?,?)";
		Class.forName(DBDRIVER);
		Connection conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		PreparedStatement pst=conn.prepareStatement(sql);
		String id="1008";
		String name="java";
		int age=24;
		pst.setString(1, id);
		pst.setString(2, name);
		pst.setInt(3, age);
		pst.executeUpdate();
		pst.close();
		conn.close();
	}
}
