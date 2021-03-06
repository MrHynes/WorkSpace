package pers.qiqcheng.spring.demo03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean的作用范围
 * 
 * @author Buer
 *
 */
public class SpringTest3 {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer customer1 = (Customer) applicationContext.getBean("customer");
		System.out.println(customer1);
		Customer customer2 = (Customer) applicationContext.getBean("customer");
		System.out.println(customer2);
		// 可以发现customer1和customer2的地址是一样的，说明他们是同一个对象，只被实例化一次，因为<bean>标签的scope属性默认值为singleton
		//若scpoe属性改为prototype
		//运行程序，发现实例化两次，创建了两个不同的对象
	}
}
