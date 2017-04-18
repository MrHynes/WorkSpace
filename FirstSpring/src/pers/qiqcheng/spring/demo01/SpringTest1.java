package pers.qiqcheng.spring.demo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest1 {
	//传统方式
	public static void main(String[] args) {
//		HelloService helloService=new HelloServiceImpl();
//		helloService.sayHello();
		demo();
	}
	public static void demo(){
		//创建了一个工厂类
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloService helloService= (HelloService)applicationContext.getBean("userService");
		helloService.sayHello();
	}
}
