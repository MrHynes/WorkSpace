package pers.qiqcheng.spring.demo05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test{
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		//setter方式注入属性
		User user=(User)applicationContext.getBean("user");
		System.out.println(user.toString());
		//构造器注入属性
		User user2=(User)applicationContext.getBean("user2");
		System.out.println(user2.toString());
		//p名称空间注入属性
		User user3=(User)applicationContext.getBean("user3");
		System.out.println(user3.toString());
	}
}
