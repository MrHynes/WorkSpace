package DBOper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBResultSet {
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/test";
	public static final String DBUSER="root";
	public static final String DBPASS="chengqi";
	public static void main(String[] args) throws Exception {
		Class.forName(DBDRIVER);
		Connection connection=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		Statement statement=connection.createStatement();
		String sql="select id,name,age from userinfo";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()){
			String id=resultSet.getString("id");
			String name=resultSet.getString("name");
			int age=resultSet.getInt("age");
			System.out.println("±‡∫≈:"+id+";–’√˚:"+name+";ƒÍ¡‰:"+age);
		}
		resultSet.close();
		statement.close();
		connection.close();
	}

}
