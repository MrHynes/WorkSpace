package spring.aop;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建spring的ioc容器
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans-aop.xml");
		//从IoC容器中获取bean实例
		Calculate calculate=(Calculate)context.getBean(Calculate.class);
		//使用bean
		int resule=calculate.add(2, 3);
		System.out.println("result:"+resule);
		resule=calculate.sub(4,5);
		System.out.println("result:"+resule);
	}

}
