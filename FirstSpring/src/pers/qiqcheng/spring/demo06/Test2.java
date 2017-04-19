package pers.qiqcheng.spring.demo06;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext2.xml");
		UserService userService=(UserService)applicationContext.getBean("userService");
		System.out.println(userService.toString());
	}

}
