package com.qqcheng8;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws SQLException{
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans_for_cheng8.xml");
		DataSource dataSource=(DataSource)context.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}

}
