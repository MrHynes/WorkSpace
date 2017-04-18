package pers.qiqcheng.spring.demo04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService=(CustomerService)applicationContext.getBean("customerService");
		customerService.sayHello();
		applicationContext.close();
	}
}
