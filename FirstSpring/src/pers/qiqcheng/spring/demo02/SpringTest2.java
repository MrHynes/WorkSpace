package pers.qiqcheng.spring.demo02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {
	
	public static void main(String[] args) {
		demo01();
	}
	//通过无参构造方法实例化bena
	public static void demo01(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean01 bean=(Bean01)applicationContext.getBean("bean01");
		System.out.println(bean.toString());
	}
	//通过静态工厂实例化bean
//	public static void demo02(){
//		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//		Bean02 bean2=(Bean02)applicationContext.getBean("bean02");
//		//System.out.println(bean.toString());
//	}
}
