package pers.qiqcheng.spring.demo03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean什么周期，初始化，和销毁方法
 * @author Buer
 *
 */
public class SpringTest4 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext cpxac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Producter producter=(Producter)cpxac.getBean("producter");
		producter.sayHello();
		System.out.println(producter.toString());
		cpxac.close();
	}

}
