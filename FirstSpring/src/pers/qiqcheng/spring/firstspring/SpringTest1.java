package pers.qiqcheng.spring.firstspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest1 {
	//��ͳ��ʽ
	public static void main(String[] args) {
//		HelloService helloService=new HelloServiceImpl();
//		helloService.sayHello();
		demo();
	}
	public static void demo(){
		//������һ��������
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloService helloService= (HelloService)applicationContext.getBean("userService");
		helloService.sayHello();
	}
}