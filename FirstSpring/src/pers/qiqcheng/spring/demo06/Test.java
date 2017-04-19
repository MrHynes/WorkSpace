package pers.qiqcheng.spring.demo06;


import org.springframework.context.support.ClassPathXmlApplicationContext;

//注解方式定义bean
public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext2.xml");
		HelloService helloService=(HelloService)applicationContext.getBean("helloService");
		helloService.sayHllo();
		System.out.println(helloService.toString());
		applicationContext.close();
	}

}
