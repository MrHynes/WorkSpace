package pers.qiqcheng.spring.demo03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * beanʲô���ڣ���ʼ���������ٷ���
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