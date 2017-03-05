package com.login;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static String DBDRIVER="org.gjt.mm.mysql.Driver";
	private static String DBURL="jdbc:mysql://localhost:3306/yootk";
	private static String DBUSER="root";
	private static String DBPASSWORD="chengqi";
	public static Connection getConnection()throws Exception{
			Class.forName(DBDRIVER);
			return DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
	}
}
