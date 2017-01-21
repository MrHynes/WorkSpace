package spring.init_destroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans-init-destroy.xml");
		data d=(data)context.getBean("data");
		System.out.println(d);
		context.close();
	}
}
